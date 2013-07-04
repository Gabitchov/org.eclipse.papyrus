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

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.commands.wrappers.GEFtoEMFCommandWrapper;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.tests.ISequenceDiagramTestsConstants;
import org.eclipse.uml2.uml.ActionExecutionSpecification;
import org.eclipse.uml2.uml.BehaviorExecutionSpecification;
import org.eclipse.uml2.uml.DestructionOccurrenceSpecification;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.Lifeline;
import org.junit.Test;


public class TestSequenceDiagramChildNode extends TestChildNode {

	@Override
	protected CreateViewRequest createViewRequestShapeContainer() {
		return CreateViewRequestFactory.getCreateShapeRequest(UMLElementTypes.Lifeline_3001, getDiagramEditPart().getDiagramPreferencesHint());
	}

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
	public void testToManageActionExecution() {
		testToManageChildNode(UMLElementTypes.ActionExecutionSpecification_3006, lifelineProvider);
	}

	@Test
	public void testToManageBehaviorExecution() {
		testToManageChildNode(UMLElementTypes.BehaviorExecutionSpecification_3003, lifelineProvider);
	}

	@Test
	public void testToManageDestructionOccurrence() {
		testToManageChildNode(UMLElementTypes.DestructionOccurrenceSpecification_3022, lifelineProvider);
	}

	@Test
	public void testToManageCoRegion() {
		semanticChild = false;
		testToManageChildNode(UMLElementTypes.CombinedFragment_3018, lifelineProvider);
		semanticChild = true;
	}

	@Test
	public void testToManageStateInvariant() {
		semanticChild = false;
		testToManageChildNode(UMLElementTypes.StateInvariant_3017, lifelineProvider);
		semanticChild = true;
	}


	@Test
	public void testToManageTimeConstraint() {
		createChildNode(UMLElementTypes.ActionExecutionSpecification_3006, lifelineProvider);
		semanticChild = false;
		testToManageChildNode(UMLElementTypes.TimeConstraint_3019, executionProvider);
		semanticChild = true;
	}

	@Test
	public void testToManageDurationConstraint() {
		createChildNode(UMLElementTypes.ActionExecutionSpecification_3006, lifelineProvider);
		semanticChild = false;

		testToCreateChildNode(UMLElementTypes.ActionExecutionSpecification_3006, executionProvider);
		{
			//DESTROY SEMANTIC+ VIEW
			IChildTestProvider provider = executionProvider;
			assertTrue(DESTROY_DELETION + INITIALIZATION_TEST, provider.getEditPartChildrenSize() == 1);
			assertTrue(DESTROY_DELETION + INITIALIZATION_TEST, provider.getViewChildrenSize() == 1);
			assertTrue(DESTROY_DELETION + INITIALIZATION_TEST, !provider.hasSemanticChild() || provider.getSemanticChildrenSize() == 1);

			Request deleteViewRequest = new EditCommandRequestWrapper(new DestroyElementRequest(false));
			Command command = provider.getDestroyEditPart().getCommand(deleteViewRequest);
			assertNotNull(DESTROY_DELETION + COMMAND_NULL, command);
			assertTrue(DESTROY_DELETION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
			assertTrue(DESTROY_DELETION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);

			getEMFCommandStack().execute(new GEFtoEMFCommandWrapper(command));
			assertTrue(DESTROY_DELETION + TEST_THE_EXECUTION, provider.getEditPartChildrenSize() == 0);
			assertTrue(DESTROY_DELETION + TEST_THE_EXECUTION, provider.getViewChildrenSize() == 0);
			assertTrue(DESTROY_DELETION + TEST_THE_EXECUTION, provider.getSemanticChildrenSize() == 0);
		}

		// the node has been destroyed, the UML element also
		getEMFCommandStack().undo();

		// the node and the UML element are present
		testViewDeletion(UMLElementTypes.ActionExecutionSpecification_3006, executionProvider);

		semanticChild = true;
	}

	GraphicalEditPart containerEditPart;

	boolean semanticChild = true;

	IChildTestProvider executionProvider = new IChildTestProvider() {

		public int getEditPartChildrenSize() {
			return TestSequenceDiagramChildNode.this.lifelineProvider.getEditPartChildrenSize() - 1; // ignore ActionExecution
		}

		public int getSemanticChildrenSize() {
			return TestSequenceDiagramChildNode.this.lifelineProvider.getSemanticChildrenSize() - 1;
		}

		public int getViewChildrenSize() {
			return TestSequenceDiagramChildNode.this.lifelineProvider.getViewChildrenSize() - 1;
		}

		public Element getDropElement() {
			return null;
		}

		public GraphicalEditPart getParentEditPart() {
			return TestSequenceDiagramChildNode.this.lifelineProvider.getParentEditPart();
		}

		public GraphicalEditPart getDestroyEditPart() {
			return (GraphicalEditPart)getParentEditPart().getChildren().get(2);
		}

		public boolean hasSemanticChild() {
			return semanticChild;
		}

		public Point getChildLocation(GraphicalEditPart parentEditPart) {
			return TestSequenceDiagramChildNode.this.lifelineProvider.getChildLocation(parentEditPart);
		}
	};

	IChildTestProvider lifelineProvider = new IChildTestProvider() {

		public int getEditPartChildrenSize() {
			return getParentEditPart().getChildren().size() - 1; // ignore LifelineNameEditPart
		}

		public int getSemanticChildrenSize() {
			Lifeline lifeline = ((Lifeline)getParentEditPart().getNotationView().getElement());
			int count = 0;
			for(InteractionFragment f : lifeline.getCoveredBys())
				if(f instanceof DestructionOccurrenceSpecification || f instanceof ActionExecutionSpecification || f instanceof BehaviorExecutionSpecification)
					count++;

			return count;
		}

		public int getViewChildrenSize() {
			int count = 0;
			Lifeline lifeline = ((Lifeline)getParentEditPart().getNotationView().getElement());
			EList children = getParentEditPart().getNotationView().getChildren();
			for(Object object : children) {
				View view = (View)object;
				if(lifeline != ViewUtil.resolveSemanticElement(view)) {
					count++;
				}
			}
			return count;
		}

		public Element getDropElement() {
			return null;
		}

		public GraphicalEditPart getParentEditPart() {
			if(containerEditPart == null) {
				GraphicalEditPart ep = (GraphicalEditPart)getRootEditPart().getChildren().get(0);
				containerEditPart = ep;
			}
			return containerEditPart;
		}

		public GraphicalEditPart getDestroyEditPart() {
			return (GraphicalEditPart)getParentEditPart().getChildren().get(1);
		}

		public boolean hasSemanticChild() {
			return semanticChild;
		}

		public Point getChildLocation(GraphicalEditPart parentEditPart) {
			IFigure f = ((LifelineEditPart)parentEditPart).getPrimaryShape().getFigureLifelineDotLineFigure();
			Rectangle b = f.getBounds().getCopy();
			f.translateToAbsolute(b);
			return b.getCenter().getCopy().translate(0, 50);
		}
	};
}
