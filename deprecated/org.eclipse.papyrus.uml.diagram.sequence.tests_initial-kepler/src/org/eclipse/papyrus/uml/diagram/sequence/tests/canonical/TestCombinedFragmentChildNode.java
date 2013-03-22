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
package org.eclipse.papyrus.uml.diagram.sequence.tests.canonical;

import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragmentCombinedFragmentCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InteractionOperand;
import org.eclipse.uml2.uml.InteractionOperatorKind;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.Test;


public class TestCombinedFragmentChildNode extends TestChildNode {

	private static final String CHANGE_OPERATOR_KIND = "Change Operator Kind: ";

	@Test
	public void testToManageOperand() {
		testToManageChildNode(UMLElementTypes.InteractionOperand_3005, combinedFragmentProvider);
	}

	@Test
	public void testToManageContinuation() {
		testToManageChildNode(UMLElementTypes.Continuation_3016, operandProvider);
	}

	@Override
	protected CreateViewRequest createViewRequestShapeContainer() {
		return CreateViewRequestFactory.getCreateShapeRequest(UMLElementTypes.CombinedFragment_3004, getDiagramEditPart().getDiagramPreferencesHint());
	}

	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		return new CreateSequenceDiagramCommand();
	}

	@Override
	protected void createTopNode() {
		super.createTopNode();
		CombinedFragmentEditPart cep = (CombinedFragmentEditPart)getRootEditPart().getChildren().get(0);
		CombinedFragment cf = (CombinedFragment)cep.resolveSemanticElement();
		changeOperatorKind(cep, cf, InteractionOperatorKind.ALT_LITERAL);
		waitForComplete();
	}

	protected void changeOperatorKind(CombinedFragmentEditPart p, CombinedFragment cf, InteractionOperatorKind kind) {
		EAttribute feature = UMLPackage.eINSTANCE.getCombinedFragment_InteractionOperator();
		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(cf);
		SetRequest request = new SetRequest(p.getEditingDomain(), cf, feature, kind);
		ICommand createGMFCommand = provider.getEditCommand(request);
		org.eclipse.emf.common.command.AbstractCommand emfCommand = new GMFtoEMFCommandWrapper(createGMFCommand);
		assertTrue(CHANGE_OPERATOR_KIND + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, emfCommand.canExecute() == true);
		getEMFCommandStack().execute(emfCommand);
	}

	private GraphicalEditPart containerEditPart;

	IChildTestProvider operandProvider = new IChildTestProvider() {

		public int getEditPartChildrenSize() {
			return getParentEditPart().getChildren().size();
		}

		public int getSemanticChildrenSize() {
			InteractionOperand operand = ((InteractionOperand)getParentEditPart().getNotationView().getElement());
			return operand.getFragments().size();
		}

		public int getViewChildrenSize() {
			return getParentEditPart().getNotationView().getChildren().size();
		}

		public Element getDropElement() {
			return null;
		}

		public GraphicalEditPart getParentEditPart() {
			if(containerEditPart == null) {
				CombinedFragmentEditPart cep = (CombinedFragmentEditPart)getRootEditPart().getChildren().get(0);
				CombinedFragmentCombinedFragmentCompartmentEditPart cfp = (CombinedFragmentCombinedFragmentCompartmentEditPart)cep.getChildren().get(0);
				containerEditPart = (GraphicalEditPart)cfp.getChildren().get(0); // operand
			}
			return containerEditPart;
		}

		public GraphicalEditPart getDestroyEditPart() {
			List children = getParentEditPart().getChildren();
			return (GraphicalEditPart)children.get(children.size() - 1);
		}

		public boolean hasSemanticChild() {
			return true;
		}

		public Point getChildLocation(GraphicalEditPart parentEditPart) {
			IFigure f = parentEditPart.getFigure();
			Rectangle b = f.getBounds().getCopy();
			f.translateToAbsolute(b);
			return b.getCenter().getCopy();
		}
	};

	IChildTestProvider combinedFragmentProvider = new IChildTestProvider() {

		public int getEditPartChildrenSize() {
			return getParentEditPart().getChildren().size() - 1;
		}

		public int getSemanticChildrenSize() {
			CombinedFragment cf = ((CombinedFragment)getParentEditPart().getNotationView().getElement());
			return cf.getOperands().size() - 1;
		}

		public int getViewChildrenSize() {
			return getParentEditPart().getNotationView().getChildren().size() - 1;
		}

		public Element getDropElement() {
			return null;
		}

		public GraphicalEditPart getParentEditPart() {
			if(containerEditPart == null) {
				CombinedFragmentEditPart cep = (CombinedFragmentEditPart)getRootEditPart().getChildren().get(0);
				CombinedFragmentCombinedFragmentCompartmentEditPart cfp = (CombinedFragmentCombinedFragmentCompartmentEditPart)cep.getChildren().get(0);
				containerEditPart = cfp;
			}
			return containerEditPart;
		}

		public GraphicalEditPart getDestroyEditPart() {
			List children = getParentEditPart().getChildren();
			return (GraphicalEditPart)children.get(children.size() - 1);
		}

		public boolean hasSemanticChild() {
			return true;
		}

		public Point getChildLocation(GraphicalEditPart parentEditPart) {
			IFigure f = parentEditPart.getFigure();
			Rectangle b = f.getBounds().getCopy();
			f.translateToAbsolute(b);
			return b.getCenter().getCopy();
		}
	};

}
