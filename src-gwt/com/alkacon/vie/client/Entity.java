/*
 * This library is part of OpenCms -
 * the Open Source Content Management System
 *
 * Copyright (c) Alkacon Software GmbH (http://www.alkacon.com)
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * For further information about Alkacon Software, please see the
 * company website: http://www.alkacon.com
 *
 * For further information about OpenCms, please see the
 * project website: http://www.opencms.org
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

package com.alkacon.vie.client;

import com.alkacon.vie.shared.I_Entity;
import com.alkacon.vie.shared.I_EntityAttribute;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.event.logical.shared.HasValueChangeHandlers;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;

/**
 * The entity wrapper.<p>
 */
public final class Entity extends JavaScriptObject implements HasValueChangeHandlers<I_Entity>, I_Entity {

    /** Flag indicating that id's should always be wrapped in '<>' brackets. */
    private static boolean USE_BRACKET_WRAPPED_IDS;

    /**
     * Constructor, for internal use only.<p>
     */
    protected Entity() {

    }

    /**
     * Sets the use bracket wrapped id's flag.<p>
     * 
     * @param useBrackets <code>true</code> to use bracket wrapped id's
     */
    public static void setUseBracketWrappetIds(boolean useBrackets) {

        USE_BRACKET_WRAPPED_IDS = useBrackets;
    }

    /**
     * Helper method for firing a 'value changed' event.<p>
     *
     * @param entity the entity that changed
     */
    private static void fireValueChangedEvent(Entity entity) {

        ValueChangeEvent.fire(entity, entity);
    }

    /**
     * @see com.alkacon.vie.shared.I_Entity#addAttributeValue(java.lang.String, com.alkacon.vie.shared.I_Entity)
     */
    public native void addAttributeValue(String attributeName, I_Entity value) /*-{
        this.setOrAdd(attributeName, value);
    }-*/;

    /**
     * @see com.alkacon.vie.shared.I_Entity#addAttributeValue(java.lang.String, java.lang.String)
     */
    public native void addAttributeValue(String attributeName, String value) /*-{
        this.setOrAdd(attributeName, value);
    }-*/;

    /**
     * Adds this handler to the widget.
     *
     * @param <H> the type of handler to add
     * @param type the event type
     * @param handler the handler
     * 
     * @return {@link HandlerRegistration} used to remove the handler
     */
    public <H extends EventHandler> HandlerRegistration addHandler(final H handler, GwtEvent.Type<H> type) {

        return ensureHandlers().addHandler(type, handler);
    }

    /**
     * @see com.google.gwt.event.logical.shared.HasValueChangeHandlers#addValueChangeHandler(com.google.gwt.event.logical.shared.ValueChangeHandler)
     */
    public HandlerRegistration addValueChangeHandler(ValueChangeHandler<I_Entity> handler) {

        return addHandler(handler, ValueChangeEvent.getType());
    }

    /**
     * @see com.google.gwt.event.shared.HasHandlers#fireEvent(com.google.gwt.event.shared.GwtEvent)
     */
    public void fireEvent(GwtEvent<?> event) {

        if (getHandlerManager() != null) {
            getHandlerManager().fireEvent(event);
        }

    }

    /**
     * @see com.alkacon.vie.shared.I_Entity#getAttribute(java.lang.String)
     */
    public I_EntityAttribute getAttribute(String attributeName) {

        if (!hasAttribute(attributeName)) {
            return null;
        }
        if (isSimpleAttribute(attributeName)) {
            return new EntityAttribute(attributeName, getSimpleValues(attributeName));
        }
        return new EntityAttribute(attributeName, getComplexValues(attributeName));
    }

    /**
     * @see com.alkacon.vie.shared.I_Entity#getAttributes()
     */
    public List<I_EntityAttribute> getAttributes() {

        List<I_EntityAttribute> result = new ArrayList<I_EntityAttribute>();
        JsArrayString attributeNames = getAttributeNames();
        for (int i = 0; i < attributeNames.length(); i++) {
            result.add(getAttribute(attributeNames.get(i)));
        }
        return result;
    }

    /**
     * @see com.alkacon.vie.shared.I_Entity#getId()
     */
    public native String getId() /*-{
        var subject = this.getSubject();
        if (!@com.alkacon.vie.client.Entity::USE_BRACKET_WRAPPED_IDS) {
            subject = @com.alkacon.vie.client.Vie::removePointyBrackets(Ljava/lang/String;)(subject);
        }
        return subject;
    }-*/;

    /**
     * @see com.alkacon.vie.shared.I_Entity#getTypeName()
     */
    public native String getTypeName() /*-{

        var type = this.get('@type');
        return (typeof type === 'string') ? type : type.id;
    }-*/;

    /**
     * @see com.alkacon.vie.shared.I_Entity#hasAttribute(java.lang.String)
     */
    public native boolean hasAttribute(String attributeName) /*-{

        return this.has(attributeName);
    }-*/;

    /**
     * Returns if the entity has the given type.<p>
     *
     * @param type the type
     *
     * @return <code>true</code> if the entity has the given type
     */
    public native boolean hasType(String type) /*-{

        return this.hasType(type);
    }-*/;

    /**
     * Removes the given attribute.<p>
     *
     * @param attributeName the attribute name
     */
    public native void removeAttribute(String attributeName) /*-{

        this.unset(attributeName);
    }-*/;

    /**
     * @see com.alkacon.vie.shared.I_Entity#removeAttributeSilent(java.lang.String)
     */
    public native void removeAttributeSilent(String attributeName) /*-{

        this.unset(attributeName, {
            silent : true
        });
    }-*/;

    /**
     * @see com.alkacon.vie.shared.I_Entity#setAttributeValue(java.lang.String, com.alkacon.vie.shared.I_Entity)
     */
    public native void setAttributeValue(String attributeName, I_Entity value) /*-{
        this.unset(attributeName, {
            silent : true
        });
        this.set(attributeName, value);
    }-*/;

    /**
     * @see com.alkacon.vie.shared.I_Entity#setAttributeValue(java.lang.String, com.alkacon.vie.shared.I_Entity, int)
     */
    public void setAttributeValue(String attributeName, I_Entity value, int index) {

        if ((index == 0) && !hasAttribute(attributeName)) {
            setAttributeValue(attributeName, value);
        }
        I_EntityAttribute attribute = getAttribute(attributeName);
        if ((index == 0) && attribute.isSingleValue()) {
            setAttributeValue(attributeName, value);
        } else {
            List<I_Entity> values = attribute.getComplexValues();
            if (index >= values.size()) {
                throw new IndexOutOfBoundsException("Index of " + index + " to big.");
            }
            removeAttributeSilent(attributeName);
            for (int i = 0; i < values.size(); i++) {
                if (i == index) {
                    addAttributeValue(attributeName, value);
                } else {
                    addAttributeValue(attributeName, values.get(i));
                }
            }
        }
    }

    /**
     * @see com.alkacon.vie.shared.I_Entity#setAttributeValue(java.lang.String, java.lang.String)
     */
    public native void setAttributeValue(String attributeName, String value) /*-{
        this.unset(attributeName, {
            silent : true
        });
        this.setOrAdd(attributeName, value);
    }-*/;

    /**
     * @see com.alkacon.vie.shared.I_Entity#setAttributeValue(java.lang.String, java.lang.String, int)
     */
    public void setAttributeValue(String attributeName, String value, int index) {

        if ((index == 0) && !hasAttribute(attributeName)) {
            setAttributeValue(attributeName, value);
        }
        I_EntityAttribute attribute = getAttribute(attributeName);
        if ((index == 0) && attribute.isSingleValue()) {
            setAttributeValue(attributeName, value);
        } else {
            List<String> values = attribute.getSimpleValues();
            if (index >= values.size()) {
                throw new IndexOutOfBoundsException("Index of " + index + " to big.");
            }
            removeAttributeSilent(attributeName);
            for (int i = 0; i < values.size(); i++) {
                if (i == index) {
                    addAttributeValue(attributeName, value);
                } else {
                    addAttributeValue(attributeName, values.get(i));
                }
            }
        }
    }

    /**
     * @see com.alkacon.vie.shared.I_Entity#toJSON()
     */
    public native String toJSON() /*-{

        return JSON.stringify(this);
    }-*/;

    /**
     * Binds the {@link #com.alkacon.vie.client.Entity.fireValueChangedEvent(Entity)} method 
     * to the native change function and sets the handler manager for this instance.<p>
     *
     * @param handlerManager the handler manager to use
     */
    private native void bindChange(HandlerManager handlerManager)/*-{

        this.handlerManager = handlerManager;
        var self = this;
        this
                .bind(
                        "change",
                        function() {
                            @com.alkacon.vie.client.Entity::fireValueChangedEvent(Lcom/alkacon/vie/client/Entity;)(self);
                        });
    }-*/;

    /**
     * Ensures the existence of the handler manager.
     *
     * @return the handler manager
     * */
    private HandlerManager ensureHandlers() {

        if (getHandlerManager() == null) {
            bindChange(new HandlerManager(this));
        }
        return getHandlerManager();
    }

    /**
     * Returns the names of the available attributes.<p>
     * 
     * @return the attribute names
     */
    private native JsArrayString getAttributeNames() /*-{
        var names = new Array();
        var attributes = this.attrs;
        for ( var key in attributes) {
            names.push(key);
        }
        return names;
    }-*/;

    /**
     * Returns the values of the given attribute as an array of entities.<p>
     * Check if the given attribute is of complex type first!!<p>
     * 
     * @param attributeName the name of the attribute 
     * 
     * @return the attribute values
     */
    private native I_EntityCollection getComplexValues(String attributeName) /*-{

        var attr = this.get(attributeName);
        //        if (attr.isEntity) {
        //            return [ attr ];
        //        }
        return attr;
    }-*/;

    /**
     * Returns the handler manager.<p>
     *
     * @return the handler manager
     */
    private native HandlerManager getHandlerManager()/*-{

        return this.handlerManager;
    }-*/;

    /**
     * Returns the values of the given attribute as an array of entities.<p>
     * Check if the given attribute is of complex type first!!<p>
     * 
     * @param attributeName the name of the attribute 
     * 
     * @return the attribute values
     */
    private native JsArrayString getSimpleValues(String attributeName) /*-{

        var attr = this.get(attributeName);
        if (typeof attr === 'string') {
            return [ attr ];
        }
        return attr;
    }-*/;

    /**
     * Returns if the given attribute is of the simple type.<p>
     * 
     * @param attributeName the name of the attribute
     * 
     * @return <code>true</code> is this is a simple type attribute
     */
    private native boolean isSimpleAttribute(String attributeName) /*-{

        var attr = this.get(attributeName);
        if (typeof attr === 'string') {
            return true;
        }
        if (attr.isEntity) {
            return false;
        }
        if (Object.prototype.toString.call(attr) === '[object Array]') {
            if (typeof attr[0] === 'string') {
                return true;
            }
        }
        return false;
    }-*/;
}
