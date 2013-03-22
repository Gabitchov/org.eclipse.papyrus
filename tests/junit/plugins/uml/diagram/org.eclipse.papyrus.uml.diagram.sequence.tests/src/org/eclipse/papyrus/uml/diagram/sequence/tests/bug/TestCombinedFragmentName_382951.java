/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.tests.bug;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ConsiderIgnoreFragmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.tests.canonical.CreateSequenceDiagramCommand;
import org.eclipse.papyrus.uml.diagram.sequence.tests.canonical.TestTopNode;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.ConsiderIgnoreFragment;
import org.junit.Test;

/**
 * Combined fragment name shall be displayed at the right upper corner of the fragment.
 * 
 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=382951
 * 
 */
public class TestCombinedFragmentName_382951 extends TestTopNode {

	private static final String PREF_STORE = "org.eclipse.papyrus.infra.gmfdiag.preferences";

	private static final String COMBINED_FRAGMENT_KEY = "ELEMENT_PapyrusUMLSequenceDiagram_CombinedFragment_CombinedFragmentCompartment.compartment_name.visibility";

	private static final String CONSIDER_FRAGMENT_KEY = "ELEMENT_PapyrusUMLSequenceDiagram_ConsiderIgnoreFragment_CombinedFragmentCompartment.compartment_name.visibility";


	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		return new CreateSequenceDiagramCommand();
	}

	@Test
	public void testCombinedFragment() {
		IEclipsePreferences store = InstanceScope.INSTANCE.getNode(PREF_STORE);
		store.putBoolean(COMBINED_FRAGMENT_KEY, true);

		createNode(UMLElementTypes.CombinedFragment_3004, getRootEditPart(), new Point(10, 80), new Dimension(100, 100));
		CombinedFragmentEditPart cep = (CombinedFragmentEditPart)getRootEditPart().getChildren().get(0);
		CombinedFragment cf = (CombinedFragment)cep.resolveSemanticElement();
		WrappingLabel label = cep.getTitleLabel();
		assertTrue(TEST_THE_EXECUTION, label.isVisible());
		assertTrue(TEST_THE_EXECUTION, label.getText().equals(cf.getName()));

		store.putBoolean(COMBINED_FRAGMENT_KEY, false);
		assertFalse(TEST_THE_EXECUTION, label.isVisible());
	}

	@Test
	public void testConsiderIgnoreFragment() {
		IEclipsePreferences store = InstanceScope.INSTANCE.getNode(PREF_STORE);
		store.putBoolean(CONSIDER_FRAGMENT_KEY, false);

		createNode(UMLElementTypes.ConsiderIgnoreFragment_3007, getRootEditPart(), new Point(10, 80), new Dimension(100, 100));
		ConsiderIgnoreFragmentEditPart cep = (ConsiderIgnoreFragmentEditPart)getRootEditPart().getChildren().get(0);
		ConsiderIgnoreFragment cf = (ConsiderIgnoreFragment)cep.resolveSemanticElement();
		WrappingLabel label = cep.getTitleLabel();
		assertFalse(TEST_THE_EXECUTION, label.isVisible());

		store.putBoolean(CONSIDER_FRAGMENT_KEY, true);
		assertTrue(TEST_THE_EXECUTION, label.isVisible());
		assertTrue(TEST_THE_EXECUTION, label.getText().equals(cf.getName()));
	}

	public void createNode(IElementType type, EditPart parentPart, Point location, Dimension size) {
		//CREATION
		CreateViewRequest requestcreation = CreateViewRequestFactory.getCreateShapeRequest(type, getRootEditPart().getDiagramPreferencesHint());
		requestcreation.setLocation(location);
		requestcreation.setSize(size);
		Command command = parentPart.getCommand(requestcreation);
		assertNotNull(CREATION + COMMAND_NULL, command);
		assertTrue(CREATION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue(CREATION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);

		getDiagramCommandStack().execute(command);
	}
}
