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

    /**
     * Constructor, for internal use only.<p>
     */
    protected EntityAttribute() {

        // noop
    }

    /**
     * Initialization.<p>
     * 
     * @return the type
     */
    public static final native TYPE getType() /*-{

		var type = "UNDIFINED";
		if (this.isCollection) {
			// value is a VIE.Collection
			type = "COLLECTION";
		} else if ($wnd.jQuery.isArray(this)) {
			// values of an array could be JavaScript Literals or VIE.Type
			//  array can also contain different types
			type = "ARRAY";
		} else if (this instanceof $wnd.VIE.Type) {
			// type
			type = "TYPE";
		} else {
			// Literal
			type = "LITERAL";
		}
		return @com.alkacon.vie.client.EntityAttribute::getTypeFromString(Ljava/lang/String;)(type);
    }-*/;

    /**
     * Sets the type for the entity value.<p>
     * 
     * @param type the type to set as String
     * 
     * @return the enum type for the given String
     */
    private static final TYPE getTypeFromString(String type) {

        return TYPE.valueOf(type.toUpperCase());
    }
}
