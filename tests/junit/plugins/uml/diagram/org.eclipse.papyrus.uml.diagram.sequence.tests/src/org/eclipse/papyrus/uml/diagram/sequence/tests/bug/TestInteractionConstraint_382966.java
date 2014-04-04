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

import java.util.Collections;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.impl.InternalTransactionalEditingDomain;
import org.eclipse.emf.transaction.impl.TransactionalCommandStackImpl;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragmentCombinedFragmentCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CustomInteractionOperandEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionOperandEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.tests.ISequenceDiagramTestsConstants;
import org.eclipse.papyrus.uml.diagram.sequence.tests.canonical.CreateSequenceDiagramCommand;
import org.eclipse.papyrus.uml.diagram.sequence.tests.canonical.TestTopNode;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.InteractionConstraint;
import org.eclipse.uml2.uml.InteractionOperatorKind;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.Test;


/**
 * Minint and Maxint values are allways visible on the diagram, even when the guard of a loop combined fragment is deleted and also when these values
 * are not defined. This interval shall not appear on the diagram when it is not defined in the model.
 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=382966
 *
 */
public class TestInteractionConstraint_382966 extends TestTopNode {

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
	public void testEditMaxint() {
		InteractionOperandEditPart op = setupOperand();
		CombinedFragmentEditPart cep = (CombinedFragmentEditPart)getRootEditPart().getChildren().get(0);
		changeOperatorKind(cep, (CombinedFragment)cep.resolveSemanticElement(), InteractionOperatorKind.LOOP_LITERAL);

		CombinedFragment cf = (CombinedFragment)((CombinedFragmentEditPart)getRootEditPart().getChildren().get(0)).resolveSemanticElement();
		final InteractionConstraint guard = cf.getOperands().get(0).getGuard();

		executeCommandWithoutHistory(getRootEditPart().getEditingDomain(), new DummyCommand() {

			@Override
			public void execute() {
				guard.setMaxint(null); // unset maxint
				guard.setSpecification(null);
			}
		}, true);
		waitForComplete();

		//introduced a guard edit part for displaying operand label.
		WrappingLabel label = op instanceof CustomInteractionOperandEditPart ? ((CustomInteractionOperandEditPart)op).getInteractionConstraintLabel() : op.getPrimaryShape().getInteractionConstraintLabel();
		assertTrue(TEST_THE_EXECUTION, label.getText().equals(""));
	}

	@Test
	public void testEditMinint() {
		InteractionOperandEditPart op = setupOperand();
		CombinedFragmentEditPart cep = (CombinedFragmentEditPart)getRootEditPart().getChildren().get(0);
		changeOperatorKind(cep, (CombinedFragment)cep.resolveSemanticElement(), InteractionOperatorKind.LOOP_LITERAL);

		CombinedFragment cf = (CombinedFragment)((CombinedFragmentEditPart)getRootEditPart().getChildren().get(0)).resolveSemanticElement();
		final InteractionConstraint guard = cf.getOperands().get(0).getGuard();

		executeCommandWithoutHistory(getRootEditPart().getEditingDomain(), new DummyCommand() {

			@Override
			public void execute() {
				guard.setMinint(null); // unset maxint
				guard.setSpecification(null);
			}
		}, true);
		waitForComplete();

		WrappingLabel label = op instanceof CustomInteractionOperandEditPart ? ((CustomInteractionOperandEditPart)op).getInteractionConstraintLabel() : op.getPrimaryShape().getInteractionConstraintLabel();
		assertTrue(TEST_THE_EXECUTION, label.getText().equals(""));
	}


	/**
	 * Execute a EMF command without history
	 *
	 * @param editingDomain
	 *        The editing domain
	 * @param command
	 *        The command
	 * @param flag
	 */
	public static void executeCommandWithoutHistory(EditingDomain editingDomain, org.eclipse.emf.common.command.Command command, boolean flag) {
		TransactionalCommandStackImpl stack = new TransactionalCommandStackImpl();
		stack.setEditingDomain((InternalTransactionalEditingDomain)editingDomain);
		try {
			stack.execute(command, Collections.singletonMap(Transaction.OPTION_UNPROTECTED, Boolean.TRUE));
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (RollbackException e) {
			e.printStackTrace();
		}
	}

	static class DummyCommand extends org.eclipse.emf.common.command.AbstractCommand {

		public void execute() {
		}

		public void redo() {
		}

		@Override
		public void undo() {
		}

		@Override
		protected boolean prepare() {
			return true;
		}
	};

	protected InteractionOperandEditPart setupOperand() {
		createNode(UMLElementTypes.CombinedFragment_3004, getRootEditPart(), new Point(10, 80), new Dimension(100, 100));
		CombinedFragmentEditPart cep = (CombinedFragmentEditPart)getRootEditPart().getChildren().get(0);
		final CombinedFragmentCombinedFragmentCompartmentEditPart cfp = (CombinedFragmentCombinedFragmentCompartmentEditPart)cep.getChildren().get(0);
		InteractionOperandEditPart op = (InteractionOperandEditPart)cfp.getChildren().get(0);
		waitForComplete();
		return op;
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
