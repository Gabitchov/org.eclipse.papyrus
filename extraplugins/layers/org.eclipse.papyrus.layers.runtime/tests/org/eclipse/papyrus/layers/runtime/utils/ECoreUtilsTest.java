/*******************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cedric Dumoulin Cedric.dumoulin@lifl.fr
 ******************************************************************************/
package org.eclipse.papyrus.layers.runtime.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.eclipse.papyrus.layers.stackmodel.LayersException;
import org.eclipse.papyrus.layers.stackmodel.layers.Layer;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersFactory;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage;
import org.eclipse.papyrus.layers.stackmodel.layers.TopLayerOperator;
import org.eclipse.papyrus.layers.stackmodel.layers.TypeInstance;
import org.eclipse.papyrus.layers.stackmodel.layers.util.ECoreUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * @author dumoulin
 *
 */
public class ECoreUtilsTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.util.ECoreUtils#isAncestorInstanceOf(org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EClass)}.
	 */
	@Test
	public void testIsAncestorInstanceOf() {
		// Create a tree of EObject
		TopLayerOperator layerOperator = LayersFactory.eINSTANCE.createTopLayerOperator();
		Layer layer = LayersFactory.eINSTANCE.createLayer();
		layerOperator.getLayers().add(layer);

		TypeInstance instance2 = LayersFactory.eINSTANCE.createBooleanInstance();
		layer.getPropertyValueMap().put("prop1", instance2);
		
		// Check ancestor
		assertTrue("ancestor found", ECoreUtils.isAncestorInstanceOf(instance2, LayersPackage.eINSTANCE.getTypeInstance()));
		assertTrue("ancestor found", ECoreUtils.isAncestorInstanceOf(instance2, LayersPackage.eINSTANCE.getLayer()));
		assertTrue("ancestor found", ECoreUtils.isAncestorInstanceOf(instance2, LayersPackage.eINSTANCE.getTopLayerOperator()));
		assertTrue("ancestor found", ECoreUtils.isAncestorInstanceOf(instance2, LayersPackage.eINSTANCE.getLayerOperator()));

		assertFalse("no ancestor found", ECoreUtils.isAncestorInstanceOf(instance2, LayersPackage.eINSTANCE.getLayersStack()));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.util.ECoreUtils#lookupAncestorOfType(org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EClass)}.
	 * @throws LayersException 
	 */
	@Test
	public void testLookupAncestorOfType() throws LayersException {
		// Create a tree of EObject
		TopLayerOperator layerOperator = LayersFactory.eINSTANCE.createTopLayerOperator();
		Layer layer = LayersFactory.eINSTANCE.createLayer();
		layerOperator.getLayers().add(layer);

		TypeInstance instance2 = LayersFactory.eINSTANCE.createBooleanInstance();
		layer.getPropertyValueMap().put("prop1", instance2);
		
		// Check ancestor
		assertEquals("ancestor found", instance2, ECoreUtils.lookupAncestorOfType(instance2, LayersPackage.eINSTANCE.getTypeInstance()));
		assertEquals("ancestor found", layer, ECoreUtils.lookupAncestorOfType(instance2, LayersPackage.eINSTANCE.getLayer()));
		assertEquals("ancestor found", layerOperator, ECoreUtils.lookupAncestorOfType(instance2, LayersPackage.eINSTANCE.getTopLayerOperator()));
		assertEquals("ancestor found", layerOperator, ECoreUtils.lookupAncestorOfType(instance2, LayersPackage.eINSTANCE.getLayerOperator()));

		 try {
			ECoreUtils.lookupAncestorOfType(instance2, LayersPackage.eINSTANCE.getLayersStack());
			fail("Exception is thrown");
		} catch (LayersException e) {
			// Ok, we expect an exception
		}
	}

}
