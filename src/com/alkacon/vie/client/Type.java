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

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * A value type.<p>
 */
public final class Type extends JavaScriptObject implements I_Type {

    /**
     * Hiding constructor.<p>
     */
    private Type() {

        // nothing to do
    }

    /**
     * @see com.alkacon.vie.client.I_Type#getAttributeMaxOccurrence(java.lang.String)
     */
    public native int getAttributeMaxOccurrence(String attributeName) /*-{

        // TODO: Auto-generated method stub
        return 1;
    }-*/;

    /**
     * @see com.alkacon.vie.client.I_Type#getAttributeMinOccurrence(java.lang.String)
     */
    public native int getAttributeMinOccurrence(String attributeName) /*-{

        // TODO: Auto-generated method stub
        return 1;
    }-*/;

    /**
     * @see com.alkacon.vie.client.I_Type#getAttributeNames()
     */
    public List<String> getAttributeNames() {

        List<String> attributes = new ArrayList<String>();
        prepareAttributeNames(attributes);
        return attributes;
    }

    /**
     * Prepares the list of attribute names.<p>
     * 
     * @param attributes the list to fill with attribute names
     */
    private native void prepareAttributeNames(List<String> attributes) /*-{
        for ( var attr in this.attributes.list()) {
            attributes.@java.util.List::add(Ljava/lang/String;)(attr.id);
        }
    }-*/;

    /**
     * @see com.alkacon.vie.client.I_Type#getAttributeType(java.lang.String)
     */
    public native I_Type getAttributeType(String attributeName) /*-{
        var attr = this.attributes.get(attributeName);
        return (attr === undefined) ? null : this.vie.types.get(attr.range[0]);
    }-*/;

    /**
     * @see com.alkacon.vie.client.I_Type#getAttributeTypeName(java.lang.String)
     */
    public native String getAttributeTypeName(String attributeName) /*-{

        var attr = this.attributes.get(attributeName);
        return (attr === undefined) ? null : attr.id;
    }-*/;

    /**
     * @see com.alkacon.vie.client.I_Type#getId()
     */
    public native String getId() /*-{

        return this.id;
    }-*/;

    /**
     * @see com.alkacon.vie.client.I_Type#isSimpleType()
     */
    public native boolean isSimpleType() /*-{

        return this.attributes == null || this.attributes.list().length == 0;
    }-*/;

}
