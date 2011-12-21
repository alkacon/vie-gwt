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
 * The entity collection.<p>
 */
public final class EntityCollection extends JavaScriptObject {

    /**
     * Constructor, for internal use only.<p>
     */
    protected EntityCollection() {

    }

    /**
     * Creates a new entity collection.<p>
     * 
     * @param vieInstance the vie instance
     * 
     * @return the new entity collection
     */
    public static native EntityCollection createCollection(JavaScriptObject vieInstance) /*-{
		return new vieInstance.Collection();
    }-*/;

    /**
     * Adds a new entity to the collection or updates the entity with the same URI.<p>
     * 
     * @param entity the entity to add
     */
    public native void addOrUpdate(Entity entity) /*-{
		this.addOrUpdate(entity);
    }-*/;

    /**
     * Returns the entity with the given id/URI.<p>
     * 
     * @param uri the entity id/URI
     * 
     * @return the entity
     */
    public native Entity getEntityByUri(String uri) /*-{
		return this.getByCid(uri);
    }-*/;

    public native Entity getEntity(int index) /*-{

		return this.at(index);
    }-*/;

    /**
     * Returns the size of the collection.<p>
     * 
     * @return the size
     */
    public native int size() /*-{
		return this.length;
    }-*/;
}
