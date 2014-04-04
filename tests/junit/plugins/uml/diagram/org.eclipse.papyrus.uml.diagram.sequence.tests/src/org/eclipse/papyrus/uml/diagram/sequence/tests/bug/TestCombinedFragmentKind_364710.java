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

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragmentCombinedFragmentCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CustomConsiderIgnoreFragmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.tests.ISequenceDiagramTestsConstants;
import org.eclipse.papyrus.uml.diagram.sequence.tests.canonical.CreateSequenceDiagramCommand;
import org.eclipse.papyrus.uml.diagram.sequence.tests.canonical.TestTopNode;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.InteractionOperatorKind;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.Test;

/**
 * Currently, combined fragment kind can be changed only if the combined fragment
 * has a unique operand. Kind modification should be allowed in the case of a
 * combined fragment owing more than one operand when the modification is
 * compatible with the number of operands. For instance, the change of seq kind to
 * alt kind should be allowed.
 *
 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=364710
 *
 */
public class TestCombinedFragmentKind_364710 extends TestTopNode {

	private static final String CHANGE_OPERATOR_KIND = "Change Operator Kind: ";

	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		return new CreateSequenceDiagramCommand();
	}

	@Override
	protected String getProjectName() {
		return ISequenceDiagramTestsConstants.PROJECT_NAME;
	}

	@Override
	protected String getFileName() {
		return ISequenceDiagramTestsConstants.FILE_NAME;
	}

	@Test
	public void testConsiderIgnoreFragment() {
		createNode(UMLElementTypes.ConsiderIgnoreFragment_3007, getRootEditPart(), new Point(10, 80), new Dimension(100, 100));
		CustomConsiderIgnoreFragmentEditPart cep = (CustomConsiderIgnoreFragmentEditPart)getRootEditPart().getChildren().get(0);
		final CombinedFragmentCombinedFragmentCompartmentEditPart cfp = (CombinedFragmentCombinedFragmentCompartmentEditPart)cep.getChildren().get(0);

		// add operand
		createNode(UMLElementTypes.InteractionOperand_3005, cfp, new Point(30, 100), new Dimension(100, 100));
		assertTrue(CREATION + TEST_THE_EXECUTION, cfp.getChildren().size() == 2);

		CombinedFragment cf = (CombinedFragment)cep.resolveSemanticElement();
		InteractionOperatorKind[] list = { InteractionOperatorKind.IGNORE_LITERAL, InteractionOperatorKind.CONSIDER_LITERAL };
		for(int i = 0; i < list.length; i++) {
			changeOperatorKind(cep, cf, list[i]);
			assertTrue(CHANGE_OPERATOR_KIND + TEST_THE_EXECUTION, cf.getInteractionOperator() == list[i]);
		}
	}

	@Test
	public void testCombinedFragment() {
		createNode(UMLElementTypes.CombinedFragment_3004, getRootEditPart(), new Point(10, 80), new Dimension(100, 100));
		CombinedFragmentEditPart cep = (CombinedFragmentEditPart)getRootEditPart().getChildren().get(0);
		final CombinedFragmentCombinedFragmentCompartmentEditPart cfp = (CombinedFragmentCombinedFragmentCompartmentEditPart)cep.getChildren().get(0);

		// add operand
		createNode(UMLElementTypes.InteractionOperand_3005, cfp, new Point(30, 100), new Dimension(100, 100));
		assertTrue(CREATION + TEST_THE_EXECUTION, cfp.getChildren().size() == 2);

		CombinedFragment cf = (CombinedFragment)cep.resolveSemanticElement();
		InteractionOperatorKind[] list = { InteractionOperatorKind.ALT_LITERAL, InteractionOperatorKind.PAR_LITERAL, InteractionOperatorKind.STRICT_LITERAL, InteractionOperatorKind.CRITICAL_LITERAL, InteractionOperatorKind.ASSERT_LITERAL, InteractionOperatorKind.SEQ_LITERAL };
		for(int i = 0; i < list.length; i++) {
			changeOperatorKind(cep, cf, list[i]);
		}
	}

	protected void changeOperatorKind(CombinedFragmentEditPart p, CombinedFragment cf, InteractionOperatorKind kind) {
		EAttribute feature = UMLPackage.eINSTANCE.getCombinedFragment_InteractionOperator();
		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(cf);
		SetRequest request = new SetRequest(p.getEditingDomain(), cf, feature, kind);
		ICommand createGMFCommand = provider.getEditCommand(request);
		org.eclipse.emf.common.command.AbstractCommand emfCommand = new GMFtoEMFCommandWrapper(createGMFCommand);
		assertTrue(CHANGE_OPERATOR_KIND + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, emfCommand.canExecute() == true);
		getEMFCommandStack().execute(emfCommand);
		waitForComplete();
		assertTrue(CHANGE_OPERATOR_KIND + TEST_THE_EXECUTION, cf.getInteractionOperator() == kind);
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
