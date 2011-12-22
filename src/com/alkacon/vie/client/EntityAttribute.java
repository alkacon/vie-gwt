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

import com.google.gwt.core.client.JavaScriptObject;

/**
 * The attribute implementation for an entity.<p>
 * 
 * An entity has several attributes that are from different types. <code>EntityAttribute</code>
 * makes it able to access this "type unsafe" JavaScriptObjects in an easy way.<p> 
 * 
 * A value of an entity attribute can be one of the following types:<p>
 * 
 * <ul>
 * <li>VIE.Collection
 * <li>VIE.Type
 * <li>Literal [string, number (double, int),  date]
 * <li>Array   [contains Literals or VIE.Type, Arrays can also contain different types at the same time]
 * </ul>
 */
public final class EntityAttribute extends JavaScriptObject {

    /**
     * VIE.type representation.<p>
     */
    public class AttributeType extends JavaScriptObject {

        // TODO: IMPLEMENT
    }

    /** A enum for the possible attribute types. */
    public static enum TYPE {

        /** Attribute type. */
        ARRAY,

        /** Attribute type. */
        COLLECTION,

        /** Attribute type. */
        LITERAL,

        /** Attribute type. */
        TYPE,

        /** Attribute type. */
        UNDIFINED
    }

    /** The type. */
    private TYPE m_type;

    /**
     * Constructor, for internal use only.<p>
     */
    protected EntityAttribute() {

        init();
    }

    /**
     * Returns the type of this attribute.<p>
     * 
     * @return the type
     */
    public TYPE getType() {

        return m_type;
    }

    /**
     * Returns the value as entity.<p>
     * 
     * @return the value as entity
     */
    protected final Entity getAsEntity() {

        return null;
    }

    /**
     * Returns the value as String.<p>
     * 
     * @return the value as String
     */
    protected final String getAsString() {

        return null;
    }

    /**
     * Returns the value as Array.<p>
     * 
     * @return the value as Array
     */
    protected final String[] getAsStringArray() {

        return null;
    }

    /**
     * Returns the value as entity.<p>
     * 
     * @return the value as entity
     */
    protected final AttributeType getAsType() {

        return null;
    }

    /**
     * Initialization.<p>
     */
    private native void init() /*-{

		// Literal (string, number (double, int),  date)

		var type = "UNDIFINED";
		if (this.isCollection) {
			// value is a VIE.Collection
			type = "COLLECTION";
		} else if ($wnd.jQuery.isArray(this)) {
			// values of an array could be JavaScript Literals or VIE.Type
			// this array can also contain different types
			type = "ARRAY";
		} else if (this instanceof $wnd.VIE.Type) {
			// type
			type = "TYPE";
		} else {
			// Literal
			type = "LITERAL";
		}
		this.@com.alkacon.vie.client.EntityAttribute::setTypeAsString(Ljava/lang/String;)(type);
    }-*/;

    /**
     * Sets the type for the entity value.<p>
     * 
     * @param type the type to set as String
     */
    private void setTypeAsString(String type) {

        m_type = TYPE.valueOf(type.toUpperCase());
    }
}
