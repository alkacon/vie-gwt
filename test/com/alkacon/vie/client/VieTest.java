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

import com.google.gwt.junit.client.GWTTestCase;

/**
 * Tests for {@link Vie}.<p>
 */
public class VieTest extends GWTTestCase {

    /**
     * @see com.google.gwt.junit.client.GWTTestCase#getModuleName()
     */
    @Override
    public String getModuleName() {

        return "com.alkacon.vie.VieGwt";
    }

    /**
     * Tests if a new entity can be created within VIE.<p>
     */
    public void testCreateEntity() {

        String entityId = "myEntityId";
        String entityType = "myEntityType";
        I_Vie vie = getVieInstance();
        I_Entity entity = vie.createEntity(entityId, entityType);
        assertNotNull("The newly created entity should not be null", entity);
        assertEquals(entityId, entity.getId());

    }

    /**
     * Returns a new {@link Vie} instance.<p>
     * 
     * @return the {@link Vie} instance
     */
    private I_Vie getVieInstance() {

        return Vie.getInstance();
    }

}
