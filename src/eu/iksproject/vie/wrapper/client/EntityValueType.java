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
 * The value type implementation for an entity.<p>
 * 
 */
public class EntityValueType extends JavaScriptObject {

    /** A enum for the possible types. */
    public static enum TYPE {

        /** Entity type. */
        collection,

        /** Entity type. */
        entity,

        /** String/int/double */
        literal,

        /** Entity type. */
        type
    }

    /** The reference to the according entity. */
    private JavaScriptObject m_entity;

    /** The type. */
    private TYPE m_type;

    /**
     * Public constructor.<p>
     * 
     * @param entity the entity reference
     */
    public EntityValueType(JavaScriptObject entity) {

        m_entity = entity;
        init();
    }

    /**
     * Returns the value as entity.<p>
     * 
     * @return the value as entity
     */
    Entity getAsEntity() {

        return null;
    }

    /**
     * Returns the value as String.<p>
     * 
     * @return the value as String
     */
    String getAsString() {

        return null;
    }

    /**
     * Returns the value as Array.<p>
     * 
     * @return the value as Array
     */
    String[] getAsStringArray() {

        return null;
    }

    /**
     * Returns the value as Type.<p>
     * 
     * @return the value as Type
     */
    Type getAsType() {

        return null;
    }

    /**
     * Initialization.<p>
     */
    private native void init() /*-{

		// Literal (string, number (double, int),  date)

		var value = this.@eu.iksproject.vie.wrapper.client.EntityValueType::m_entity;

		if (value.isCollection) {
			// value is a VIE.Collection
		} else if (jQuery.isArray(value)) {
			// Literal, VIE.Entity, VIE.Type
		} else if (value instanceof VIE.Type) {
			// type
		} else {
			// Literal
		}
		this.@eu.iksproject.vie.wrapper.client.EntityValueType::setType(Ljava/lang/String;)(type);
		return value;
    }-*/;

    /**
     * Sets the type for the entity value.<p>
     * 
     * @param type the type to set as String
     */
    private void setType(String type) {

        // TODO: IMPLEMENT
    }
}
