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
package org.eclipse.papyrus.layers.runtime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.layers.stackmodel.notifier.DiagramViewEventNotifier;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


/**
 * @author dumoulin
 *
 */
public class DiagramViewEventNotifierTest {

	/**
	 * URI used to store the created model.
	 */
	protected static final String PROJECT_MODEL_URI = "org.eclipse.papyrus.infra.core/tmp/model1.di";

	/**
	 * ModelSet created for each test
	 */
	protected ModelSet modelSet;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
//		// Create ModelSet and Model
//		ModelSet mngr = new ModelSet();
//		// LayersModel
//		LayersModel layersModel = new LayersModel();
//		mngr.registerModel(layersModel);
//		// Notation model
//		NotationModel notationModel = new NotationModel();
//		mngr.registerModel(notationModel);
//		// Do create resources
//		URI uri = URI.createPlatformResourceURI(PROJECT_MODEL_URI, true);
//		mngr.createModels(uri);
//		
//		modelSet = mngr;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
//		modelSet.unload();
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.notifier.DiagramViewEventNotifier#DiagramViewEventNotifier(org.eclipse.gmf.runtime.notation.Diagram)}.
	 */
	@Test
	public void testDiagramViewEventNotifier() {
		Diagram diagram = NotationFactory.eINSTANCE.createDiagram();
		
		DiagramViewEventNotifier notifier = new DiagramViewEventNotifier(diagram);
		assertNotNull("notifier created", notifier);

		// dispose
		notifier.dispose();
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.notifier.DiagramViewEventNotifier#dispose()}.
	 */
	@Test
	public void testDispose() {
		Diagram diagram = NotationFactory.eINSTANCE.createDiagram();
		
		DiagramViewEventNotifier notifier = new DiagramViewEventNotifier(diagram);
		assertNotNull("notifier created", notifier);

		// dispose
		assertFalse("notifier is disposed", notifier.isDisposed());
		notifier.dispose();
		assertTrue("notifier is disposed", notifier.isDisposed());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.notifier.DiagramViewEventNotifier#addEventListener(org.eclipse.papyrus.layers.runtime.IDiagramViewEventListener)}.
	 */
	@Test
	@Ignore
	public void testAddEventListener() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.notifier.DiagramViewEventNotifier#removeEventListener(org.eclipse.papyrus.layers.runtime.IDiagramViewEventListener)}.
	 */
	@Test
	@Ignore
	public void testRemoveEventListener() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.notifier.DiagramViewEventNotifier#fireDiagramViewAddedEvent(org.eclipse.emf.common.notify.Notification)}.
	 */
	@Test
	public void testFireDiagramViewAddedEvent() {
		Diagram diagram = NotationFactory.eINSTANCE.createDiagram();
		
		DiagramViewEventNotifier notifier = new DiagramViewEventNotifier(diagram);
		
		TraceDiagramViewEventListener listener = new TraceDiagramViewEventListener();
		notifier.addEventListener(listener);
		
		// Add view
		Node node1 = diagram.createChild( NotationPackage.eINSTANCE.getShape() );
		
		// Check for event
		assertEquals("event found", "diagramViewAdded", listener.traces.get(0).name);
		
		// Check inner creation
		listener.traces.clear();
		node1.createChild( NotationPackage.eINSTANCE.getShape() );
		assertEquals("event found", "diagramViewAdded", listener.traces.get(0).name);

		
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.notifier.DiagramViewEventNotifier#fireDiagramViewRemovedEvent(org.eclipse.emf.common.notify.Notification)}.
	 */
	@Test
	public void testFireDiagramViewRemovedEvent() {
		Diagram diagram = NotationFactory.eINSTANCE.createDiagram();
		
		DiagramViewEventNotifier notifier = new DiagramViewEventNotifier(diagram);
		
		TraceDiagramViewEventListener listener = new TraceDiagramViewEventListener();
		notifier.addEventListener(listener);
		
		// Add view
		Node node1 = diagram.createChild( NotationPackage.eINSTANCE.getShape() );
		
		// Check inner creation
		listener.traces.clear();
		node1.createChild( NotationPackage.eINSTANCE.getShape() );

		// Check if the node is a children of the diagram
		assertTrue("event found", diagram.getChildren().contains(node1));

		// Check remove
		listener.traces.clear();
		diagram.removeChild(node1);
		assertFalse("event found", diagram.getChildren().contains(node1));
		
		assertTrue("event found", listener.traces.contains("diagramViewRemoved"));
//		assertEquals("event found", "diagramViewRemoved", listener.traces.get(0).name);
	}

}
