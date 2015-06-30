package de.agilecoders.wicket.extensions.markup.html.bootstrap.behavior;

import java.util.HashMap;
import java.util.Map;

import org.apache.wicket.Component;
import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.OnDomReadyHeaderItem;
import org.apache.wicket.util.io.IOUtils;
import org.apache.wicket.util.template.PackageTextTemplate;

import de.agilecoders.wicket.core.markup.html.bootstrap.behavior.BootstrapBaseBehavior;
import de.agilecoders.wicket.extensions.markup.html.bootstrap.references.InteractJsResourceReference;

/**
 * Provides the draggable functionality based on interact js, so that it also
 * works on mobilde devices
 * 
 * @author Tobias Soloschenko
 *
 */
public class InteractJsDraggable extends BootstrapBaseBehavior {

    private static final long serialVersionUID = 1L;

    private final InteractJsDraggableConfig config;

    public InteractJsDraggable() {
	this(new InteractJsDraggableConfig());
    }

    /**
     * Construct.
     *
     * @param config
     *            The configuration
     */
    public InteractJsDraggable(final InteractJsDraggableConfig config) {
	this.config = config;
    }

    @Override
    public void renderHead(Component component, IHeaderResponse headerResponse) {
	super.renderHead(component, headerResponse);
	headerResponse.render(newInteractJsDraggableHeaderItem());
	
        PackageTextTemplate dropZoneTemplate = null;
        try {
            dropZoneTemplate = new PackageTextTemplate(InteractJsResourceReference.class, "js/interact-init.js");
            String jsonConfig = config.toJsonString();
            Map<String, Object> variables = new HashMap<String, Object>();
            variables.put("config", jsonConfig);
            String js = dropZoneTemplate.asString(variables);
            headerResponse.render(OnDomReadyHeaderItem.forScript(js));
        } finally {
            IOUtils.closeQuietly(dropZoneTemplate);
        }
    }

    /**
     * @return new interactjs draggable js header item
     */
    protected HeaderItem newInteractJsDraggableHeaderItem() {
	return InteractJsResourceReference.asHeaderItem();
    }

    /**
     * Override bind so that the output markup id is always set to "true"
     */
    @Override
    public void bind(Component component) {
	super.bind(component);
	component.setOutputMarkupId(true);
    }
}
