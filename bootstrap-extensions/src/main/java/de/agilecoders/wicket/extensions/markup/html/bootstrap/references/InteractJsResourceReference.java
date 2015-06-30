package de.agilecoders.wicket.extensions.markup.html.bootstrap.references;

import org.apache.wicket.Application;
import org.apache.wicket.RuntimeConfigurationType;
import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

/**
 * Provides the interact js library
 * 
 * @author Tobias Soloschenko
 *
 */
public class InteractJsResourceReference extends JavaScriptResourceReference {

    private static final long serialVersionUID = 1L;

    /**
     * Singleton instance of this reference
     */
    private static final class Holder {
	private static final InteractJsResourceReference INSTANCE = new InteractJsResourceReference();
    }

    /**
     * @return the single instance of the resource reference
     */
    public static InteractJsResourceReference instance() {
	return Holder.INSTANCE;
    }

    public InteractJsResourceReference() {
	// If deployment mode use minified version
	super(InteractJsResourceReference.class, "js/interact-1.2.4"
		+ (Application.get().getConfigurationType() == RuntimeConfigurationType.DEPLOYMENT ? ".min" : "")
		+ ".js");
    }

    /**
     * @return this resource reference singleton instance as header item
     */
    public static HeaderItem asHeaderItem() {
	return JavaScriptHeaderItem.forReference(instance());
    }

}
