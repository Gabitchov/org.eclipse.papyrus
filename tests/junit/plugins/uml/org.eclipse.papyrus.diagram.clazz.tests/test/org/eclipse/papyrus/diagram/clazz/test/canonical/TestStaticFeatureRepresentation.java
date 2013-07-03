/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Nizar GUEDIDI (CEA LIST) - Initial API and implementation
 /*****************************************************************************/
package org.eclipse.papyrus.diagram.clazz.test.canonical;

import org.eclipse.draw2d.text.FlowPage;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ListCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.draw2d.ui.text.TextFlowEx;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.commands.wrappers.EMFtoGMFCommandWrapper;
import org.eclipse.papyrus.diagram.clazz.test.IClassDiagramTestsConstants;
import org.eclipse.papyrus.diagram.tests.canonical.TestChildLabel;
import org.eclipse.papyrus.uml.diagram.clazz.CreateClassDiagramCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ClassAttributeCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ClassOperationCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.common.editparts.UMLCompartmentEditPart;
import org.eclipse.uml2.uml.Feature;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.Test;

/**
 * this class is used to test if feature are a representation for static
 * 
 */
public class TestStaticFeatureRepresentation extends TestChildLabel {

	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		return new CreateClassDiagramCommand();
	}

	@Override
	protected String getProjectName() {
		return IClassDiagramTestsConstants.PROJECT_NAME;
	}

	@Override
	protected String getFileName() {
		return IClassDiagramTestsConstants.FILE_NAME;
	}

	@Test
	public void testStaticOperation() {
		testToCreateATopNode(UMLElementTypes.Class_2008);
		testToTestStaticoperation(UMLElementTypes.Operation_3013, ClassOperationCompartmentEditPart.VISUAL_ID);
	}

	@Test
	public void testStaticProperty() {
		testToCreateATopNode(UMLElementTypes.Class_2008);
		testToTestStaticoperation(UMLElementTypes.Property_3012, ClassAttributeCompartmentEditPart.VISUAL_ID);
	}

	protected void testToTestStaticoperation(IElementType type, int containerType) {
		ListCompartmentEditPart compartment = null;
		int index = 0;
		while(compartment == null && index < getTopEditPart().getChildren().size()) {
			if((getTopEditPart().getChildren().get(index)) instanceof ListCompartmentEditPart && (((View)((ListCompartmentEditPart)(getTopEditPart().getChildren().get(index))).getModel()).getType().equals("" + containerType))) {
				compartment = (ListCompartmentEditPart)(getTopEditPart().getChildren().get(index));
			}
			index++;
		}
		assertTrue("Container not found", compartment != null);
		//CREATION
		assertTrue(CREATION + INITIALIZATION_TEST, compartment.getChildren().size() == 0);
		assertTrue(CREATION + INITIALIZATION_TEST, getRootSemanticModel().getOwnedElements().size() == 0);
		CreateViewRequest requestcreation = CreateViewRequestFactory.getCreateShapeRequest(type, getDiagramEditPart().getDiagramPreferencesHint());
		Command command = compartment.getCommand(requestcreation);
		assertNotNull(CREATION + COMMAND_NULL, command);
		assertTrue(CREATION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue("CREATION: " + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
		//creation of label
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(command);
		assertTrue(CREATION + TEST_THE_EXECUTION, compartment.getChildren().size() == 1);
		assertTrue("ceated editpart is a feature editpart", ((compartment.getChildren().get(0)) instanceof UMLCompartmentEditPart));
		UMLCompartmentEditPart featureEditPart = (UMLCompartmentEditPart)compartment.getChildren().get(0);
		//make it static
		SetCommand setStaticOperation = new SetCommand(diagramEditor.getEditingDomain(), featureEditPart.resolveSemanticElement(), UMLPackage.eINSTANCE.getFeature_IsStatic(), true);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(new ICommandProxy(new EMFtoGMFCommandWrapper(setStaticOperation)));
		TextFlowEx label = (TextFlowEx)((FlowPage)featureEditPart.getFigure().getChildren().get(0)).getChildren().get(0);
		featureEditPart.refresh();
		//the semantic element is static
		assertTrue("the feature is static", ((Feature)featureEditPart.resolveSemanticElement()).isStatic());
		//the graphical element is underlined
		assertTrue("the figigure is drawn as static", label.isTextUnderlined());
	}
}
