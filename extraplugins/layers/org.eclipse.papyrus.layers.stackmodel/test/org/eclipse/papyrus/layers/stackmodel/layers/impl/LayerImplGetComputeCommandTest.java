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
package org.eclipse.papyrus.layers.stackmodel.layers.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import java.util.Arrays;
import java.util.List;

import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.layers.stackmodel.LayersException;
import org.eclipse.papyrus.layers.stackmodel.command.ComputePropertyValueCommand;
import org.eclipse.papyrus.layers.stackmodel.layers.Layer;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersFactory;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStackApplication;
import org.eclipse.papyrus.layers.stackmodel.layers.Property;
import org.eclipse.papyrus.layers.stackmodel.layers.PropertyRegistry;
import org.eclipse.papyrus.layers.stackmodel.layers.TypeInstance;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * Test the {@link AbstractLayer#getComputePropertyValueCommand(...)} commands
 * 
 * @author cedric dumoulin
 *
 */
public class LayerImplGetComputeCommandTest {

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
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayerImpl#LayerImpl()}.
	 */
	@Test
	public void testLayerImpl() {
		Layer layer = LayersFactory.eINSTANCE.createLayer();
		assertNotNull("object created", layer);
		
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.AbstractLayerImpl#getComputePropertyValueCommand(org.eclipse.gmf.runtime.notation.View, org.eclipse.papyrus.layers.stackmodel.layers.Property)}.
	 * @throws LayersException 
	 */
	@Test
	public void testGetComputePropertyValueCommand() throws LayersException {
		// Create objets to test
		LayerImpl layer = (LayerImpl)LayersFactory.eINSTANCE.createLayer();
		LayersStackApplication application = LayersFactory.eINSTANCE.createLayersStackApplication();
		layer.setApplication(application);
		PropertyRegistry propertyRegistry = application.getPropertyRegistry();
		
		// Fill the map with an instance for the 2 first properties
		int index = 0;
		Property property = propertyRegistry.getProperties().get(index);
		TypeInstance instance = property.createInstance();
		layer.getPropertyValueMap().put(property.getName(), instance);
		
		Property property2 = propertyRegistry.getProperties().get(++index);
		TypeInstance instance2 = property2.createInstance();
		layer.getPropertyValueMap().put(property2.getName(), instance2);
		
		Property property3 = propertyRegistry.getProperties().get(++index);
		
		// Add views
		View view1 = NotationFactory.eINSTANCE.createShape();
		layer.getViews().add(view1);
		View view2 = NotationFactory.eINSTANCE.createShape();
		
		// Check 
		ComputePropertyValueCommand cmd = layer.getComputePropertyValueCommand(view1, property);
		assertNotNull("cmd created", cmd);
		assertSame("cmd s the property instance", instance, cmd);
		
		// Check wrong view2
		ComputePropertyValueCommand cmd2 = layer.getComputePropertyValueCommand(view2, property);
		assertNull("cmd created", cmd2);
		
		// Check wrong property
		ComputePropertyValueCommand cmd3 = layer.getComputePropertyValueCommand(view2, property3);
		assertNull("cmd created", cmd3);
		
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.AbstractLayerImpl#getViewsComputePropertyValueCommand(java.util.List, org.eclipse.papyrus.layers.stackmodel.layers.Property)}.
	 * @throws LayersException 
	 */
	@Test
	public void testGetViewsComputePropertyValueCommandListOfViewProperty() throws LayersException {
		// Create objets to test
		LayerImpl layer = (LayerImpl)LayersFactory.eINSTANCE.createLayer();
		LayersStackApplication application = LayersFactory.eINSTANCE.createLayersStackApplication();
		layer.setApplication(application);
		PropertyRegistry propertyRegistry = application.getPropertyRegistry();
		
		// Fill the map with an instance for the 2 first properties
		int index = 0;
		Property property = propertyRegistry.getProperties().get(index);
		TypeInstance instance = property.createInstance();
		layer.getPropertyValueMap().put(property.getName(), instance);
		
		Property property2 = propertyRegistry.getProperties().get(++index);
		TypeInstance instance2 = property2.createInstance();
		layer.getPropertyValueMap().put(property2.getName(), instance2);
		
		Property property3 = propertyRegistry.getProperties().get(++index);
		
		// Add views
		View view1 = NotationFactory.eINSTANCE.createShape();
		layer.getViews().add(view1);
		View view2 = NotationFactory.eINSTANCE.createShape();
		View view3 = NotationFactory.eINSTANCE.createShape();
		layer.getViews().add(view3);
		
		// Check view
		List<ComputePropertyValueCommand> cmds = layer.getViewsComputePropertyValueCommand(Arrays.asList(view1, view3), property);
		assertNotNull("cmd created", cmds);
		assertSame("cmd size is equals to views size", 2, cmds.size());
		int i=0;
		assertSame("cmd is the property instance", instance, cmds.get(i++));
		assertSame("cmd is the property instance", instance, cmds.get(i++));
		
		// Check wrong view2
		List<ComputePropertyValueCommand> cmds2 = layer.getViewsComputePropertyValueCommand(Arrays.asList(view1, view2), property);
		assertNotNull("cmd created", cmds2);
		assertSame("cmd size is equals to views size", 2, cmds2.size());
		i=0;
		assertSame("cmd is the property instance", instance, cmds2.get(i++));
		assertSame("cmd is the property instance", null, cmds2.get(i++));
		
		// Check wrong view2
		List<ComputePropertyValueCommand> cmds21 = layer.getViewsComputePropertyValueCommand(Arrays.asList(view2), property);
		assertNull("cmd created", cmds21);
		
		// Check wrong property
		List<ComputePropertyValueCommand> cmds3 = layer.getViewsComputePropertyValueCommand(Arrays.asList(view1), property3);
		assertNull("cmd created", cmds3);
		
		// Check list with null
		cmds = layer.getViewsComputePropertyValueCommand(Arrays.asList(view1, null, view3), property);
		assertNotNull("cmd created", cmds);
		assertSame("cmd size is equals to views size", 3, cmds.size());
		i=0;
		assertSame("cmd is the property instance", instance, cmds.get(i++));
		assertSame("cmd is null", null, cmds.get(i++));
		assertSame("cmd is the property instance", instance, cmds.get(i++));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.AbstractLayerImpl#getPropertiesComputePropertyValueCommand(org.eclipse.gmf.runtime.notation.View, java.util.List)}.
	 * @throws LayersException 
	 */
	@Test
	public void testGetPropertiesComputePropertyValueCommandViewListOfProperty() throws LayersException {
		// Create objets to test
		LayerImpl layer = (LayerImpl)LayersFactory.eINSTANCE.createLayer();
		LayersStackApplication application = LayersFactory.eINSTANCE.createLayersStackApplication();
		layer.setApplication(application);
		PropertyRegistry propertyRegistry = application.getPropertyRegistry();
		
		// Fill the map with an instance for the 2 first properties
		int index = 0;
		Property property = propertyRegistry.getProperties().get(index);
		TypeInstance instance = property.createInstance();
		layer.getPropertyValueMap().put(property.getName(), instance);
		
		Property property2 = propertyRegistry.getProperties().get(++index);
		TypeInstance instance2 = property2.createInstance();
		layer.getPropertyValueMap().put(property2.getName(), instance2);
		
		Property property3 = propertyRegistry.getProperties().get(++index);
		
		// Add views
		View view1 = NotationFactory.eINSTANCE.createShape();
		layer.getViews().add(view1);
		View view2 = NotationFactory.eINSTANCE.createShape();
		View view3 = NotationFactory.eINSTANCE.createShape();
		layer.getViews().add(view3);
		
		// Check view
		List<ComputePropertyValueCommand> cmds = layer.getPropertiesComputePropertyValueCommand(view1, Arrays.asList(property, property2));
		assertNotNull("cmd created", cmds);
		assertSame("cmd size is equals to views size", 2, cmds.size());
		int i=0;
		assertSame("cmd is the property instance", instance, cmds.get(i++));
		assertSame("cmd is the property instance", instance2, cmds.get(i++));
		
		// Check wrong property3
		cmds = layer.getPropertiesComputePropertyValueCommand(view1, Arrays.asList(property, property3));
		assertNotNull("cmd created", cmds);
		assertSame("cmd size is equals to views size", 2, cmds.size());
		i=0;
		assertSame("cmd is the property instance", instance, cmds.get(i++));
		assertSame("cmd is the property instance", null, cmds.get(i++));
		
		// Check wrong view2
		cmds = layer.getPropertiesComputePropertyValueCommand(view1, Arrays.asList(property3));
		assertNull("cmd created", cmds);
		
		// Check wrong view
		cmds = layer.getPropertiesComputePropertyValueCommand(view2, Arrays.asList(property, property2));
		assertNull("cmd created", cmds);
		
		// Check list with null
		cmds = layer.getPropertiesComputePropertyValueCommand(view1, Arrays.asList(property, null, property2));
		assertNotNull("cmd created", cmds);
		assertSame("cmd size is equals to views size", 3, cmds.size());
		i=0;
		assertSame("cmd is the property instance", instance, cmds.get(i++));
		assertSame("cmd is null", null, cmds.get(i++));
		assertSame("cmd is the property instance", instance2, cmds.get(i++));
		
	}

}
