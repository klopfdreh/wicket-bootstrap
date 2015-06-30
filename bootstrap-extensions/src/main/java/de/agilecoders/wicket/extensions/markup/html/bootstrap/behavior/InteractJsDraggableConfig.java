package de.agilecoders.wicket.extensions.markup.html.bootstrap.behavior;

import de.agilecoders.wicket.jquery.AbstractConfig;
import de.agilecoders.wicket.jquery.IKey;

/**
 * {@link de.agilecoders.wicket.extensions.markup.html.bootstrap.behavior.InteractJsDraggable} configuration
 *
 * @author miha
 */
public class InteractJsDraggableConfig extends AbstractConfig {

    private static final long serialVersionUID = 1L;
    
    /**
     * If specified, restricts dragging from starting unless the mousedown occurs on
     * the specified element(s).
     */
    private static final IKey<String> Handle = newKey("handle", "");
    
    /**
     * If specified, restricts dragging from starting unless the mousedown occurs on
     * the specified element(s).
     *
     * @param value mandatory parameter
     * @return this instance for chaining
     */
    public InteractJsDraggableConfig withHandle(final String value) {
        put(Handle, value);
        return this;
    }

}
