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

package eu.iksproject.vie.wrapper.client;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * The entity wrapper.<p>
 */
public class Entity extends JavaScriptObject {

    /**
     * Constructor, for internal use only.<p>
     */
    protected Entity() {

    }

    /**
     * Returns an entity attribute.<p>
     * 
     * @param attributeName the attribute name
     * 
     * @return the attribute value
     */
    public native JavaScriptObject getAttribute(String attributeName) /*-{

        return this.get(attributeName);
    }-*/;

    /**
     * Returns the entity id/URI.<p>
     * 
     * @return the id/URI
     */
    public native String getUri() /*-{
        this.getSubjectUri();
    }-*/;

    /**
     * Returns if the entity has the given attribute.<p>
     * 
     * @param attributeName the attribute name
     * 
     * @return <code>true</code> if the entity has the given attribute
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
     * Removes the given attribute
     * 
     * @param attributeName the attribute name
     */
    public native void removeAttribute(String attributeName) /*-{
        this.unset(attributeName);
    }-*/;

    /**
     * Removes the attribute without triggering any change events.<p>
     * 
     * @param attributeName the attribute name
     */
    public native void removeAttributeSilent(String attributeName) /*-{
        this.unset(attributeName, {
            silent : true
        });
    }-*/;

    /**
     * Sets the given attribute.<p>
     * 
     * @param attributeName the attribute name
     * @param value the attribute value
     */
    public native void setAttribute(String attributeName, JavaScriptObject value) /*-{
        this.set(attributeName, value);
    }-*/;
}
