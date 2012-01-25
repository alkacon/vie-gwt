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

import java.util.List;

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

        Entity.setUseBracketWrappetIds(true);
        String entityId = "<myEntityId>";
        String entityType = "<cms:myType>";
        I_Vie vie = getVieInstance();
        vie.createType(entityType);
        I_Entity entity = vie.createEntity(entityId, entityType);
        assertNotNull("The newly created entity should not be null", entity);
        assertEquals("The entity id should match the initial id", entityId, entity.getId());
        assertEquals("The type name should match the initial type name", entityType, entity.getTypeName());
    }

    /**
     * Tests the type creation.<p>
     */
    public void testCreateType() {

        String typeId = "<cms:mySimpleType>";
        I_Type type = getVieInstance().createType(typeId);
        assertNotNull("The newly created type should not be null", type);
        assertEquals("The type id should match the initial id", typeId, type.getId());
        assertTrue("This should be a simple type, as it has no attributes.", type.isSimpleType());
    }

    /**
     * Tests the creation of new type attributes.<p>
     */
    public void testTypeAttribute() {

        String simpleTypeId = "<cms:simple>";
        String complexTypeId = "<cms:complex>";
        String attributeName = "<http:opencms/simpleAttribute>";
        I_Vie vie = getVieInstance();

        I_Type simple = vie.createType(simpleTypeId);
        I_Type complex = vie.createType(complexTypeId);
        complex.addAttribute(attributeName, simpleTypeId, 1, 1);
        assertNotNull("The newly created type should not be null", simple);
        assertNotNull("The newly created type should not be null", complex);
        assertEquals("The type id should match the initial id", simpleTypeId, simple.getId());
        assertEquals("The type id should match the initial id", complexTypeId, complex.getId());
        assertTrue("This should be a simple type, as it has no attributes.", simple.isSimpleType());
        assertFalse("This should be no simple type, as it has attributes.", complex.isSimpleType());
        assertNotNull("The attribute list should not be null.", complex.getAttributeNames());
        assertEquals("The attribute names list should have a length of 1.", 1, complex.getAttributeNames().size());
        String attributeType = complex.getAttributeTypeName(attributeName);
        assertEquals("The attribute should be of the type: " + simpleTypeId, simpleTypeId, attributeType);
        List<String> attributes = complex.getAttributeNames();
        assertEquals("The attribute name should be as given above.", attributeName, attributes.get(0));
    }

    /**
     * Returns the {@link Vie} instance.<p>
     * 
     * @return the {@link Vie} instance
     */
    private I_Vie getVieInstance() {

        return Vie.getInstance();
    }

}
