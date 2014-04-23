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
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.stereotypeproperty;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderedNodeFigure;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.draw2d.ui.text.TextFlowEx;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.IShapeCompartmentEditPart;
import org.eclipse.papyrus.uml.appearance.helper.AppliedStereotypeHelper;
import org.eclipse.papyrus.uml.appearance.helper.UMLVisualInformationPapyrusConstant;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ClassEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.PackageEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.common.figure.node.ClassifierFigure;
import org.eclipse.papyrus.uml.diagram.common.figure.node.EditingFlowPage;
import org.eclipse.papyrus.uml.diagram.common.figure.node.PackageFigure;
import org.eclipse.papyrus.uml.diagram.stereotype.edition.editpart.AppliedStereotypeCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.stereotype.edition.editpart.AppliedStereotypeMultilinePropertyEditPart;
import org.eclipse.papyrus.uml.extensionpoints.profile.RegisteredProfile;
import org.eclipse.papyrus.uml.extensionpoints.utils.Util;
import org.eclipse.papyrus.uml.tools.commands.ApplyStereotypeCommand;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;
import org.junit.Before;
import org.junit.Test;


public class TestStereotypeApplication extends AbstractPapyrusTestCase {


	protected static final String ST_LEFT = String.valueOf("\u00AB");

	protected static final String ST_RIGHT = String.valueOf("\u00BB");

	private static final String TEST_PROFILE_STEREOTYPE1 = "testProfile::Stereotype1";

	@Test
	public void testStereotypeApplicationOnClass() {
		testToCreateANode(UMLElementTypes.Class_2008);

	}

	@Test
	public void testStereotypeApplicationOnPackage() {
		testToCreateAPackage(UMLElementTypes.Package_2007);

	}

	/**
	 * Test to create a node.
	 *
	 * @param type
	 *        the type
	 */
	public void testToCreateANode(IElementType type) {

		//VARIABLES
		org.eclipse.uml2.uml.Class class1 = null;
		//stereotype that is applied on class1
		Stereotype stereotypeTest = null;
		//view of the class
		View NotationClass1 = null;
		//editpart of class1
		GraphicalEditPart classEditPart = null;
		//compartment of stereotype
		View appliedStereotypeCompartmentNotation = null;
		//compartment Shape
		View shapeCompartmentView = null;
		//the view of the applied stereotype property
		View stereotypePropertyView = null;
		GraphicalEditPart stereotypeCompartmentEdipart = null;
		GraphicalEditPart stereotypePropertyEdipart = null;

		//CREATION
		assertTrue(CREATION + INITIALIZATION_TEST, getDiagramEditPart().getChildren().size() == 0);

		assertTrue(CREATION + INITIALIZATION_TEST, getRootSemanticModel().getOwnedElements().size() == 1);
		//1 element element due to the reference to the profile
		assertTrue(CREATION + INITIALIZATION_TEST, ((Model)getRootSemanticModel()).getAllAppliedProfiles().size() == 1);


		{//execution of the command
			CreateViewRequest requestcreation = CreateViewRequestFactory.getCreateShapeRequest(type, getDiagramEditPart().getDiagramPreferencesHint());
			Command command = getDiagramEditPart().getCommand(requestcreation);
			assertNotNull(CREATION + COMMAND_NULL, command);
			assertTrue(CREATION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
			assertTrue("CREATION: " + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
			diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(command);
			assertTrue(CREATION + TEST_THE_EXECUTION, getRootView().getChildren().size() == 1);
		}

		//get the created Class
		class1 = (org.eclipse.uml2.uml.Class)((org.eclipse.uml2.uml.Package)getRootSemanticModel()).getPackagedElement("Class1");
		assertNotNull("created class must be not null", class1);
		//look for the editpart that the class
		classEditPart = (ClassEditPart)getDiagramEditPart().getChildren().get(0);
		//test if stereotype can be applied
		assertTrue("stereotype1 must be applicable on class1", class1.getApplicableStereotype(TEST_PROFILE_STEREOTYPE1) != null);

		{// execution of the application of the stereotype
			ArrayList<Stereotype> stereotypeslist = new ArrayList<Stereotype>();
			stereotypeslist.add(class1.getApplicableStereotype(TEST_PROFILE_STEREOTYPE1));
			ApplyStereotypeCommand applyStereotypeCommand = new ApplyStereotypeCommand(((Element)classEditPart.resolveSemanticElement()), stereotypeslist, diagramEditor.getEditingDomain());
			diagramEditor.getEditingDomain().getCommandStack().execute(applyStereotypeCommand);
			assertTrue("No applied stereotype found on the element ", class1.getAppliedStereotypes().size() != 0);
		}

		//look for the applied stereotype compartment
		NotationClass1 = classEditPart.getNotationView();

		for(int i = 0; i < NotationClass1.getTransientChildren().size(); i++) {
			View view = (View)NotationClass1.getTransientChildren().get(i);
			if(view.getType().equals(AppliedStereotypeCompartmentEditPart.ID)) {
				appliedStereotypeCompartmentNotation = view;
			}
			if(view.getType().equals(IShapeCompartmentEditPart.VIEW_TYPE)) {
				shapeCompartmentView = view;
			}
		}
		// the mechanism of stereotype display is running.
		//the thread is synchronous
		assertTrue("No stereotype Compartment found in the notation", appliedStereotypeCompartmentNotation != null);
		assertTrue("No stereotype  shape Compartment found in the notation", shapeCompartmentView != null);

		//now display stereotypes
		stereotypeTest = class1.getAppliedStereotypes().get(0);

		{//display stereotype1
			RecordingCommand displayStereotypeCommand = AppliedStereotypeHelper.getAppliedStereotypeToDisplayCommand(diagramEditor.getEditingDomain(), NotationClass1, stereotypeTest.getQualifiedName(), UMLVisualInformationPapyrusConstant.STEREOTYPE_COMPARTMENT_LOCATION);

			diagramEditor.getEditingDomain().getCommandStack().execute(displayStereotypeCommand);
			org.eclipse.papyrus.infra.gmfdiag.common.figure.node.SVGNodePlateFigure nodePlate = (org.eclipse.papyrus.infra.gmfdiag.common.figure.node.SVGNodePlateFigure)((BorderedNodeFigure)classEditPart.getFigure()).getChildren().get(0);

			//get the label
			org.eclipse.draw2d.Label stereotypeLabel = ((ClassifierFigure)nodePlate.getChildren().get(0)).getStereotypesLabel();
			assertTrue("stereotype label must be not null", stereotypeLabel != null);
			assertTrue("text of stereotype label be equals to" + ST_LEFT + "stereotype1" + ST_RIGHT, stereotypeLabel.getText().equals(ST_LEFT + "stereotype1" + ST_RIGHT));
		}

		{//test display of property of stereotype in compartment
			RecordingCommand displayPropertyStereotypeCommand = AppliedStereotypeHelper.getAddAppliedStereotypePropertiesCommand(diagramEditor.getEditingDomain(), NotationClass1, stereotypeTest.getQualifiedName() + ".testInt");
			diagramEditor.getEditingDomain().getCommandStack().execute(displayPropertyStereotypeCommand);

			//the compartment must be visible
			assertTrue("the compartment must be visible", appliedStereotypeCompartmentNotation.isVisible() == true);
			//look for view that represents the property of the applied stereotype
			stereotypePropertyView = (View)appliedStereotypeCompartmentNotation.getChildren().get(0);
			assertNotNull("the view of the applied stereotype property must be created", stereotypePropertyView);
			//look for the editpart that represents the property of applied stereotype
			stereotypeCompartmentEdipart = (GraphicalEditPart)classEditPart.getChildBySemanticHint(AppliedStereotypeCompartmentEditPart.ID);
			stereotypePropertyEdipart = (GraphicalEditPart)stereotypeCompartmentEdipart.getChildBySemanticHint(AppliedStereotypeMultilinePropertyEditPart.ID);
			assertNotNull("the editpart of the applied stereotype compartment must be created", stereotypeCompartmentEdipart);
			assertNotNull("the editpart of the applied stereotype property must be created", stereotypePropertyEdipart);
			EditingFlowPage textarea = (EditingFlowPage)stereotypePropertyEdipart.getFigure();
			assertTrue("text of stereotype label be equals to «stereotype1» ", ((TextFlowEx)textarea.getChildren().get(0)).getText().equals("testInt=0"));
		}
	}

	@Before
	@Override
	public void setUp() throws Exception {
		super.setUp();
		RegisteredProfile registeredProfile = RegisteredProfile.getRegisteredProfile("TestProfile");
		final Model root = ((Model)getDiagramEditPart().resolveSemanticElement());
		URI modelUri = registeredProfile.uri;
		@SuppressWarnings("deprecation")
		final Resource modelResource = Util.getResourceSet(root).getResource(modelUri, true);
		final Profile profile = (Profile)modelResource.getContents().get(0);
		//	PackageUtil.applyProfile(root,profile, false);
		final TransactionalEditingDomain domain = ServiceUtils.getInstance().getTransactionalEditingDomain(papyrusEditor.getServicesRegistry());
		AppliedProfileCommand appliedProfileCommand = new AppliedProfileCommand(domain, root, profile);
		domain.getCommandStack().execute(new GMFtoEMFCommandWrapper(appliedProfileCommand));


	}

	/**
	 * Test to create a node.
	 *
	 * @param type
	 *        the type
	 */
	public void testToCreateAPackage(IElementType type) {

		//VARIABLES
		org.eclipse.uml2.uml.Package package1 = null;
		//stereotype that is applied on class1
		Stereotype stereotypeTest = null;
		//view of the class
		View Notationpackage1 = null;
		//editpart of class1
		GraphicalEditPart package1EditPart = null;
		//compartment of stereotype
		View appliedStereotypeCompartmentNotation = null;
		//compartment Shape
		View shapeCompartmentView = null;
		//the view of the applied stereotype property
		View stereotypePropertyView = null;
		GraphicalEditPart stereotypeCompartmentEdipart = null;
		GraphicalEditPart stereotypePropertyEdipart = null;

		//CREATION
		assertTrue(CREATION + INITIALIZATION_TEST, getDiagramEditPart().getChildren().size() == 0);

		assertTrue(CREATION + INITIALIZATION_TEST, getRootSemanticModel().getOwnedElements().size() == 1);
		//1 element element due to the reference to the profile
		assertTrue(CREATION + INITIALIZATION_TEST, ((Model)getRootSemanticModel()).getAllAppliedProfiles().size() == 1);


		{//execution of the command
			CreateViewRequest requestcreation = CreateViewRequestFactory.getCreateShapeRequest(type, getDiagramEditPart().getDiagramPreferencesHint());
			Command command = getDiagramEditPart().getCommand(requestcreation);
			assertNotNull(CREATION + COMMAND_NULL, command);
			assertTrue(CREATION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
			assertTrue("CREATION: " + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
			diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(command);
			assertTrue(CREATION + TEST_THE_EXECUTION, getRootView().getChildren().size() == 1);
		}

		//get the created Class
		package1 = (org.eclipse.uml2.uml.Package)((org.eclipse.uml2.uml.Package)getRootSemanticModel()).getPackagedElement("Package1");
		assertNotNull("created class must be not null", package1);
		//look for the editpart that the class
		package1EditPart = (PackageEditPart)getDiagramEditPart().getChildren().get(0);
		//test if stereotype can be applied
		assertTrue("stereotype1 must be applicable on class1", package1.getApplicableStereotype(TEST_PROFILE_STEREOTYPE1) != null);

		{// execution of the application of the stereotype
			ArrayList<Stereotype> stereotypeslist = new ArrayList<Stereotype>();
			stereotypeslist.add(package1.getApplicableStereotype(TEST_PROFILE_STEREOTYPE1));
			ApplyStereotypeCommand applyStereotypeCommand = new ApplyStereotypeCommand(((Element)package1EditPart.resolveSemanticElement()), stereotypeslist, diagramEditor.getEditingDomain());
			diagramEditor.getEditingDomain().getCommandStack().execute(applyStereotypeCommand);
			assertTrue("No applied stereotype found on the element ", package1.getAppliedStereotypes().size() != 0);
		}

		//look for the applied stereotype compartment
		Notationpackage1 = package1EditPart.getNotationView();

		for(int i = 0; i < Notationpackage1.getTransientChildren().size(); i++) {
			View view = (View)Notationpackage1.getTransientChildren().get(i);
			if(view.getType().equals(AppliedStereotypeCompartmentEditPart.ID)) {
				appliedStereotypeCompartmentNotation = view;
			}
			if(view.getType().equals(IShapeCompartmentEditPart.VIEW_TYPE)) {
				shapeCompartmentView = view;
			}
		}
		// the mechanism of stereotype display is running.
		//the thread is synchronous
		assertTrue("No stereotype Compartment found in the notation", appliedStereotypeCompartmentNotation != null);
		assertTrue("No stereotype  shape Compartment found in the notation", shapeCompartmentView != null);

		//now display stereotypes
		stereotypeTest = package1.getAppliedStereotypes().get(0);

		{//display stereotype1
			RecordingCommand displayStereotypeCommand = AppliedStereotypeHelper.getAppliedStereotypeToDisplayCommand(diagramEditor.getEditingDomain(), Notationpackage1, stereotypeTest.getQualifiedName(), UMLVisualInformationPapyrusConstant.STEREOTYPE_COMPARTMENT_LOCATION);

			diagramEditor.getEditingDomain().getCommandStack().execute(displayStereotypeCommand);
			org.eclipse.papyrus.infra.gmfdiag.common.figure.node.SVGNodePlateFigure nodePlate = (org.eclipse.papyrus.infra.gmfdiag.common.figure.node.SVGNodePlateFigure)((BorderedNodeFigure)package1EditPart.getFigure()).getChildren().get(0);

			//get the label
			org.eclipse.draw2d.Label stereotypeLabel = ((PackageFigure)nodePlate.getChildren().get(0)).getStereotypesLabel();
			assertTrue("stereotype label must be not null", stereotypeLabel != null);
			assertTrue("text of stereotype label be equals to " + ST_LEFT + "stereotype1" + ST_RIGHT, stereotypeLabel.getText().equals(ST_LEFT + "stereotype1" + ST_RIGHT));
		}

		{//test display of property of stereotype in compartment
			RecordingCommand displayPropertyStereotypeCommand = AppliedStereotypeHelper.getAddAppliedStereotypePropertiesCommand(diagramEditor.getEditingDomain(), Notationpackage1, stereotypeTest.getQualifiedName() + ".testInt");
			diagramEditor.getEditingDomain().getCommandStack().execute(displayPropertyStereotypeCommand);

			//the compartment must be visible
			assertTrue("the compartment must be visible", appliedStereotypeCompartmentNotation.isVisible() == true);
			//look for view that represents the property of the applied stereotype
			stereotypePropertyView = (View)appliedStereotypeCompartmentNotation.getChildren().get(0);
			assertNotNull("the view of the applied stereotype property must be created", stereotypePropertyView);
			//look for the editpart that represents the property of applied stereotype
			stereotypeCompartmentEdipart = (GraphicalEditPart)package1EditPart.getChildBySemanticHint(AppliedStereotypeCompartmentEditPart.ID);
			stereotypePropertyEdipart = (GraphicalEditPart)stereotypeCompartmentEdipart.getChildBySemanticHint(AppliedStereotypeMultilinePropertyEditPart.ID);
			assertNotNull("the editpart of the applied stereotype compartment must be created", stereotypeCompartmentEdipart);
			assertNotNull("the editpart of the applied stereotype property must be created", stereotypePropertyEdipart);
			EditingFlowPage textarea = (EditingFlowPage)stereotypePropertyEdipart.getFigure();
			assertTrue("text of stereotype label be equals to " + ST_LEFT + "stereotype1" + ST_RIGHT, ((TextFlowEx)textarea.getChildren().get(0)).getText().equals("testInt=0"));
		}
	}

}
