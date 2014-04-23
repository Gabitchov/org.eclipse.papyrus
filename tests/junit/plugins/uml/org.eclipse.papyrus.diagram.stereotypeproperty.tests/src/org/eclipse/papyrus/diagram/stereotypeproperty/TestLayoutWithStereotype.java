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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderedNodeFigure;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.draw2d.ui.text.TextFlowEx;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.IShapeCompartmentEditPart;
import org.eclipse.papyrus.junit.utils.classification.InvalidTest;
import org.eclipse.papyrus.uml.appearance.helper.AppliedStereotypeHelper;
import org.eclipse.papyrus.uml.appearance.helper.UMLVisualInformationPapyrusConstant;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ClassEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.PackageEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.common.figure.node.AutomaticCompartmentLayoutManager;
import org.eclipse.papyrus.uml.diagram.common.figure.node.ClassifierFigure;
import org.eclipse.papyrus.uml.diagram.common.figure.node.EditingFlowPage;
import org.eclipse.papyrus.uml.diagram.common.figure.node.PackageFigure;
import org.eclipse.papyrus.uml.diagram.common.figure.node.StereotypePropertiesCompartment;
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

/**
 * the purpose of this class is to test the layout
 *
 */
public class TestLayoutWithStereotype extends AbstractPapyrusTestCase {

	protected static final String ST_LEFT = String.valueOf("\u00AB");

	protected static final String ST_RIGHT = String.valueOf("\u00BB");

	private static final String TEST_PROFILE_STEREOTYPE1 = "testProfile::Stereotype1";

	@InvalidTest("Works on Windows, Fails on Linux. To be investigated further")
	@Test
	public void testLayoutStereotypeApplicationOnClass() {
		testToCreateANode(UMLElementTypes.Class_2008);
	}

	@Test
	public void testLayoutStereotypeApplicationOnPackage() {
		//testToCreateAPackage(UMLElementTypes.Package_2007);

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
		ClassifierFigure class1figure = null;
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


		//look for the applied stereotype compartment
		NotationClass1 = classEditPart.getNotationView();
		{//execution of the command
			SetBoundsCommand resizeCommand = new SetBoundsCommand(diagramEditor.getEditingDomain(), "resize", new EObjectAdapter(NotationClass1), new Rectangle(0, 0, 200, 200));

			assertTrue("CREATION: " + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, resizeCommand.canExecute() == true);
			diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(new ICommandProxy(resizeCommand));
		}
		{//test about the layout
			org.eclipse.papyrus.infra.gmfdiag.common.figure.node.SVGNodePlateFigure nodePlate = (org.eclipse.papyrus.infra.gmfdiag.common.figure.node.SVGNodePlateFigure)((BorderedNodeFigure)classEditPart.getFigure()).getChildren().get(0);
			// now verify position of each subfigure
			class1figure = ((ClassifierFigure)nodePlate.getChildren().get(0));
			class1figure.setBounds(new Rectangle(0, 0, 200, 200));
			assertTrue("The figure of class1 is not an automaticCompartmentLayoutManager", class1figure.getLayoutManager() instanceof AutomaticCompartmentLayoutManager);
			class1figure.getLayoutManager().layout(class1figure);
			assertEquals("The figure of the Class has not the good X coordinate", class1figure.getBounds().x, 0);
			assertEquals("The figure of the Class has not the good Y coordinate", class1figure.getBounds().y, 0);
			assertEquals("The figure of the Class has not the good width coordinate", class1figure.getBounds().width, 200);
			assertEquals("The figure of the Class has not the good height coordinate", class1figure.getBounds().height, 200);

			// At this moment the class figure must contain 4 sub-figures 1label+ 3compartments
			assertEquals("The number of figure children must be equal to 4", class1figure.getChildren().size(), 4);

			//wrappinglabel for name
			assertTrue("The sub figure [0] is not a wrapping label", class1figure.getChildren().get(0) instanceof WrappingLabel);
			WrappingLabel labelClass = (WrappingLabel)class1figure.getChildren().get(0);

			assertEquals("The label of the Class has not the good X coordinate", labelClass.getBounds().x, 1);
			assertEquals("The label of the Class has not the good Y coordinate", labelClass.getBounds().y, 3);
			assertEquals("The label of the Class has not the good width coordinate", labelClass.getBounds().width, 200);
			assertEquals("The label of the Class has not the good heightcoordinate", labelClass.getBounds().height, 16);
			assertEquals("The label of the Class does not display Class1", labelClass.getText(), "Class1");

			assertTrue("The sub figure [0] is not a compartment", class1figure.getChildren().get(1) instanceof RectangleFigure);
			RectangleFigure propertiesClass = (RectangleFigure)class1figure.getChildren().get(1);
			assertTrue("The sub figure [0] is not the attribute compartment is not a ResizableCompartmentFigure", propertiesClass.getChildren().get(0) instanceof ResizableCompartmentFigure);

			// compartment for attribute
			assertEquals("The compartment attribute of the Class has not the good X coordinate", propertiesClass.getBounds().x, 1);
			assertEquals("The compartment attribute of the Class has not the good Y coordinate", propertiesClass.getBounds().y, 20);
			assertEquals("The compartment attribute of the Class has not the good width coordinate", propertiesClass.getBounds().width, 200);
			assertEquals("The compartment attribute of the Class has not the good height coordinate", propertiesClass.getBounds().height, 59);


			//compartment for operation
			assertTrue("The figure of class1 is not an automaticCompartmentLayoutManager", class1figure.getChildren().get(2) instanceof RectangleFigure);
			RectangleFigure operationsClass = (RectangleFigure)class1figure.getChildren().get(2);
			assertTrue("The sub figure [0] is not the operation compartment is not a ResizableCompartmentFigure", operationsClass.getChildren().get(0) instanceof ResizableCompartmentFigure);
			assertEquals("The compartment operation of the Class has not the good X coordinate", operationsClass.getBounds().x, 1);
			assertEquals("The compartment operation of the Class has not the good y coordinate", operationsClass.getBounds().y, 80);
			assertEquals("The compartment operation of the Class has not the good width coordinate", operationsClass.getBounds().width, 200);
			assertEquals("The compartment operation of the Class has not the good height coordinate", operationsClass.getBounds().height, 59);


			// compartment for nested classifier
			assertTrue("The figure of class1 is not an automaticCompartmentLayoutManager", class1figure.getChildren().get(3) instanceof RectangleFigure);
			RectangleFigure innerclassifiersClass = (RectangleFigure)class1figure.getChildren().get(3);
			assertTrue("The sub figure [0] is not the nested Classifier compartment is not a ResizableCompartmentFigure", innerclassifiersClass.getChildren().get(0) instanceof ResizableCompartmentFigure);
			assertEquals("The compartment nested classifier of the Class has not the good X coordinate", innerclassifiersClass.getBounds().x, 1);
			assertEquals("The compartment nested classifier of the Class has not the good Y coordinate", innerclassifiersClass.getBounds().y, 140);
			assertEquals("The compartment nested classifier of the Class has not the good width coordinate", innerclassifiersClass.getBounds().width, 200);
			assertEquals("The compartment nested classifier of the Class has not the good Height coordinate", innerclassifiersClass.getBounds().height, 59);

		}

		{// execution of the application of the stereotype
			ArrayList<Stereotype> stereotypeslist = new ArrayList<Stereotype>();
			stereotypeslist.add(class1.getApplicableStereotype(TEST_PROFILE_STEREOTYPE1));
			ApplyStereotypeCommand applyStereotypeCommand = new ApplyStereotypeCommand(((Element)classEditPart.resolveSemanticElement()), stereotypeslist, diagramEditor.getEditingDomain());
			diagramEditor.getEditingDomain().getCommandStack().execute(applyStereotypeCommand);
			assertTrue("No applied stereotype found on the element ", class1.getAppliedStereotypes().size() != 0);
		}



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
			assertEquals("text of stereotype label be equals to " + ST_LEFT + "stereotype1" + ST_RIGHT, stereotypeLabel.getText(), ST_LEFT + "stereotype1" + ST_RIGHT);
		}

		{//test about the layout
			org.eclipse.papyrus.infra.gmfdiag.common.figure.node.SVGNodePlateFigure nodePlate = (org.eclipse.papyrus.infra.gmfdiag.common.figure.node.SVGNodePlateFigure)((BorderedNodeFigure)classEditPart.getFigure()).getChildren().get(0);
			// now verify position of each subfigure
			class1figure = ((ClassifierFigure)nodePlate.getChildren().get(0));
			class1figure.setBounds(new Rectangle(0, 0, 200, 200));
			assertTrue("The figure of «stereotype1»Class1 is not an automaticCompartmentLayoutManager", class1figure.getLayoutManager() instanceof AutomaticCompartmentLayoutManager);
			class1figure.getLayoutManager().layout(class1figure);
			assertEquals("The figure of the  «stereotype1»Class1 has not the good X coordinate", class1figure.getBounds().x, 0);
			assertEquals("The figure of the  «stereotype1»Class1 has not the good Y coordinate", class1figure.getBounds().y, 0);
			assertEquals("The figure of the  «stereotype1»Class1 has not the good width coordinate", class1figure.getBounds().width, 200);
			assertEquals("The figure of the  «stereotype1»Class1 has not the good height coordinate", class1figure.getBounds().height, 200);

			// At this moment the class figure must contain 5 sub-figures 1 label for stereotype+ 1label for name+ 3compartments
			assertEquals("The number of children «stereotype1»Class1 is not equals to 5", class1figure.getChildren().size(), 5);


			//wrappingLabel for stereotype
			assertTrue("The sub figure [0] of «stereotype1»Class1 is not a label", class1figure.getChildren().get(0) instanceof Label);
			Label stereotypelabelClass = (Label)class1figure.getChildren().get(0);

			assertEquals("The label of the Class has not the good X coordinate", stereotypelabelClass.getBounds().x, 1);
			assertEquals("The label of the Class has not the good Y coordinate", stereotypelabelClass.getBounds().y, 3);
			assertEquals("The label of the Class has not the good width coordinate", stereotypelabelClass.getBounds().width, 200);
			assertEquals("The label of the Class has not the good heightcoordinate", stereotypelabelClass.getBounds().height, 15);
			assertEquals("The label of the Class does not display " + ST_LEFT + "stereotype1" + ST_RIGHT, stereotypelabelClass.getText(), ST_LEFT + "stereotype1" + ST_RIGHT);


			//wrappingLabel for name
			assertTrue("The sub figure [1] of «stereotype1»Class1 is not a wrapping label", class1figure.getChildren().get(1) instanceof WrappingLabel);
			WrappingLabel labelClass = (WrappingLabel)class1figure.getChildren().get(1);

			assertEquals("The label of the Class has not the good X coordinate", labelClass.getBounds().x, 1);
			assertEquals("The label of the Class has not the good Y coordinate", labelClass.getBounds().y, 19);
			assertEquals("The label of the Class has not the good width coordinate", labelClass.getBounds().width, 200);
			assertEquals("The label of the Class has not the good heightcoordinate", labelClass.getBounds().height, 16);
			assertEquals("The label of the Class does not display Class1", labelClass.getText(), "Class1");

			// compartment for property of stereotype
			assertTrue("The sub figure [0] of «stereotype1»Class1 is not a compartment", class1figure.getChildren().get(2) instanceof RectangleFigure);
			RectangleFigure stereotypePropertiesClass = (RectangleFigure)class1figure.getChildren().get(2);
			assertTrue("The sub figure [0] is not the attribute compartment is not a ResizableCompartmentFigure", stereotypePropertiesClass.getChildren().get(0) instanceof ResizableCompartmentFigure);


			assertEquals("The compartment attribute of the Class has not the good X coordinate", stereotypePropertiesClass.getBounds().x, 1);
			assertEquals("The compartment attribute of the Class has not the good Y coordinate", stereotypePropertiesClass.getBounds().y, 36);
			assertEquals("The compartment attribute of the Class has not the good width coordinate", stereotypePropertiesClass.getBounds().width, 200);
			assertEquals("The compartment attribute of the Class has not the good height coordinate", stereotypePropertiesClass.getBounds().height, 54);


			// compartment attribute
			assertTrue("The sub figure [0] of «stereotype1»Class1 is not a compartment", class1figure.getChildren().get(2) instanceof RectangleFigure);
			RectangleFigure propertiesClass = (RectangleFigure)class1figure.getChildren().get(2);
			assertTrue("The sub figure [0] is not the attribute compartment is not a ResizableCompartmentFigure", propertiesClass.getChildren().get(0) instanceof ResizableCompartmentFigure);


			assertEquals("The compartment attribute of the Class has not the good X coordinate", propertiesClass.getBounds().x, 1);
			assertEquals("The compartment attribute of the Class has not the good Y coordinate", propertiesClass.getBounds().y, 36);
			assertEquals("The compartment attribute of the Class has not the good width coordinate", propertiesClass.getBounds().width, 200);
			assertEquals("The compartment attribute of the Class has not the good height coordinate", propertiesClass.getBounds().height, 54);


			//compartment for operation
			assertTrue("The sub figure [2] of «stereotype1»Class1 is not a compartment", class1figure.getChildren().get(3) instanceof RectangleFigure);
			RectangleFigure operationsClass = (RectangleFigure)class1figure.getChildren().get(3);
			assertTrue("The sub figure [2] is not the operation compartment is not a ResizableCompartmentFigure", operationsClass.getChildren().get(0) instanceof ResizableCompartmentFigure);
			assertEquals("The compartment operation of the Class has not the good X coordinate", operationsClass.getBounds().x, 1);
			assertEquals("The compartment operation of the Class has not the good y coordinate", operationsClass.getBounds().y, 91);
			assertEquals("The compartment operation of the Class has not the good width coordinate", operationsClass.getBounds().width, 200);
			assertEquals("The compartment operation of the Class has not the good height coordinate", operationsClass.getBounds().height, 54);

			//compartment for nested classifier
			assertTrue("The figure of class1 is not an automaticCompartmentLayoutManager", class1figure.getChildren().get(4) instanceof RectangleFigure);
			RectangleFigure innerclassifiersClass = (RectangleFigure)class1figure.getChildren().get(4);
			assertTrue("The sub figure [0] is not the nested Classifier compartment is not a ResizableCompartmentFigure", innerclassifiersClass.getChildren().get(0) instanceof ResizableCompartmentFigure);
			assertEquals("The compartment nested classifier of the Class has not the good X coordinate", innerclassifiersClass.getBounds().x, 1);
			assertEquals("The compartment nested classifier of the Class has not the good Y coordinate", innerclassifiersClass.getBounds().y, 146);
			assertEquals("The compartment nested classifier of the Class has not the good width coordinate", innerclassifiersClass.getBounds().width, 200);
			assertEquals("The compartment nested classifier of the Class has not the good Height coordinate", innerclassifiersClass.getBounds().height, 54);

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
			assertEquals("text of stereotype label be equals to «stereotype1» ", ((TextFlowEx)textarea.getChildren().get(0)).getText(), "testInt=0");
		}

		{//test about the layout
			org.eclipse.papyrus.infra.gmfdiag.common.figure.node.SVGNodePlateFigure nodePlate = (org.eclipse.papyrus.infra.gmfdiag.common.figure.node.SVGNodePlateFigure)((BorderedNodeFigure)classEditPart.getFigure()).getChildren().get(0);
			// now verify position of each subfigure
			class1figure = ((ClassifierFigure)nodePlate.getChildren().get(0));
			class1figure.setBounds(new Rectangle(0, 0, 200, 200));
			assertTrue("The figure of «stereotype1»Class1 is not an automaticCompartmentLayoutManager", class1figure.getLayoutManager() instanceof AutomaticCompartmentLayoutManager);
			class1figure.getLayoutManager().layout(class1figure);
			assertEquals("The figure of the  «stereotype1»Class1 has not the good X coordinate", class1figure.getBounds().x, 0);
			assertEquals("The figure of the  «stereotype1»Class1 has not the good Y coordinate", class1figure.getBounds().y, 0);
			assertEquals("The figure of the  «stereotype1»Class1 has not the good width coordinate", class1figure.getBounds().width, 200);
			assertEquals("The figure of the  «stereotype1»Class1 has not the good height coordinate", class1figure.getBounds().height, 200);

			// At this moment the class figure must contain 5 sub-figures 1 label for stereotype+ 1label for name+ compartment of stereotypes+ 3compartments
			assertEquals("The number of children «stereotype1»Class1 is not equals to 6", class1figure.getChildren().size(), 6);


			//label for stereotype
			assertTrue("The sub figure [0] of «stereotype1»Class1 is not a label", class1figure.getChildren().get(0) instanceof Label);
			Label stereotypelabelClass = (Label)class1figure.getChildren().get(0);

			assertEquals("The label of the Class has not the good X coordinate", stereotypelabelClass.getBounds().x, 1);
			assertEquals("The label of the Class has not the good Y coordinate", stereotypelabelClass.getBounds().y, 3);
			assertEquals("The label of the Class has not the good width coordinate", stereotypelabelClass.getBounds().width, 200);
			assertEquals("The label of the Class has not the good heightcoordinate", stereotypelabelClass.getBounds().height, 15);
			assertEquals("The label of the Class does not display " + ST_LEFT + "stereotype1" + ST_RIGHT, stereotypelabelClass.getText(), ST_LEFT + "stereotype1" + ST_RIGHT);


			//wrappingLabel for name
			assertTrue("The sub figure [1] of «stereotype1»Class1 is not a wrapping label", class1figure.getChildren().get(1) instanceof WrappingLabel);
			WrappingLabel labelClass = (WrappingLabel)class1figure.getChildren().get(1);

			assertEquals("The label of the Class has not the good X coordinate", labelClass.getBounds().x, 1);
			assertEquals("The label of the Class has not the good Y coordinate", labelClass.getBounds().y, 19);
			assertEquals("The label of the Class has not the good width coordinate", labelClass.getBounds().width, 200);
			assertEquals("The label of the Class has not the good heightcoordinate", labelClass.getBounds().height, 16);
			assertEquals("The label of the Class does not display Class1", labelClass.getText(), "Class1");


			// compartment for property of stereotypes
			assertTrue("The sub figure [2] of «stereotype1»Class1 is not a compartment", class1figure.getChildren().get(2) instanceof StereotypePropertiesCompartment);
			StereotypePropertiesCompartment sterotypesPropertiesClass = (StereotypePropertiesCompartment)class1figure.getChildren().get(2);

			assertTrue("the stereotype properties compartment does not conent the compartment for a stereotype", sterotypesPropertiesClass.getChildren().get(0) instanceof ResizableCompartmentFigure);
			ResizableCompartmentFigure compartmentFigure = (ResizableCompartmentFigure)sterotypesPropertiesClass.getChildren().get(0);
			assertTrue("The content of the sterotype properties compartment is not an EditingFlowPage", compartmentFigure.getContentPane().getChildren().get(0) instanceof EditingFlowPage);
			EditingFlowPage stereotypeProperty = (EditingFlowPage)compartmentFigure.getContentPane().getChildren().get(0);
			assertTrue("text of stereotype label be equals to «stereotype1» ", ((TextFlowEx)stereotypeProperty.getChildren().get(0)).getText().equals("testInt=0"));

			assertEquals("The compartment property of stereotypes of the Class has not the good X coordinate", sterotypesPropertiesClass.getBounds().x, 1);
			assertEquals("The compartment property of stereotypes of the Class has not the good Y coordinate", sterotypesPropertiesClass.getBounds().y, 36);
			assertEquals("The compartment property of stereotypes of the Class has not the good width coordinate", sterotypesPropertiesClass.getBounds().width, 200);
			assertEquals("The compartment property of stereotypes of the Class has not the good height coordinate", sterotypesPropertiesClass.getBounds().height, 51);

			//compartment for attribute
			assertTrue("The sub figure [2] of «stereotype1»Class1 is not a compartment", class1figure.getChildren().get(3) instanceof RectangleFigure);
			RectangleFigure propertiesClass = (RectangleFigure)class1figure.getChildren().get(3);
			assertTrue("The sub figure [2] is not the attribute compartment is not a ResizableCompartmentFigure", propertiesClass.getChildren().get(0) instanceof ResizableCompartmentFigure);

			assertEquals("The compartment attribute of the Class has not the good X coordinate", propertiesClass.getBounds().x, 1);
			assertEquals("The compartment attribute of the Class has not the good Y coordinate", propertiesClass.getBounds().y, 88);
			assertEquals("The compartment attribute of the Class has not the good width coordinate", propertiesClass.getBounds().width, 200);
			assertEquals("The compartment attribute of the Class has not the good height coordinate", propertiesClass.getBounds().height, 37);


			//compartment for operation
			assertTrue("The sub figure [2] of «stereotype1»Class1 is not a compartment", class1figure.getChildren().get(4) instanceof RectangleFigure);
			RectangleFigure operationsClass = (RectangleFigure)class1figure.getChildren().get(4);
			assertTrue("The sub figure [2] is not the operation compartment is not a ResizableCompartmentFigure", operationsClass.getChildren().get(0) instanceof ResizableCompartmentFigure);
			assertEquals("The compartment operation of the Class has not the good X coordinate", operationsClass.getBounds().x, 1);
			assertEquals("The compartment operation of the Class has not the good y coordinate", operationsClass.getBounds().y, 126);
			assertEquals("The compartment operation of the Class has not the good width coordinate", operationsClass.getBounds().width, 200);
			assertEquals("The compartment operation of the Class has not the good height coordinate", operationsClass.getBounds().height, 37);

			//compartment for nested classifier
			assertTrue("The figure of class1 is not an automaticCompartmentLayoutManager", class1figure.getChildren().get(5) instanceof RectangleFigure);
			RectangleFigure innerclassifiersClass = (RectangleFigure)class1figure.getChildren().get(5);
			assertTrue("The sub figure [0] is not the nested Classifier compartment is not a ResizableCompartmentFigure", innerclassifiersClass.getChildren().get(0) instanceof ResizableCompartmentFigure);
			assertEquals("The compartment nested classifier of the Class has not the good X coordinate", innerclassifiersClass.getBounds().x, 1);
			assertEquals("The compartment nested classifier of the Class has not the good Y coordinate", innerclassifiersClass.getBounds().y, 164);
			assertEquals("The compartment nested classifier of the Class has not the good width coordinate", innerclassifiersClass.getBounds().width, 200);
			assertEquals("The compartment nested classifier of the Class has not the good Height coordinate", innerclassifiersClass.getBounds().height, 37);

		}
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
		View NotationPackage1 = null;
		PackageFigure package1figure = null;
		//editpart of class1
		GraphicalEditPart packageEditPart = null;
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
		packageEditPart = (PackageEditPart)getDiagramEditPart().getChildren().get(0);
		//test if stereotype can be applied
		assertTrue("stereotype1 must be applicable on class1", package1.getApplicableStereotype(TEST_PROFILE_STEREOTYPE1) != null);


		//look for the applied stereotype compartment
		NotationPackage1 = packageEditPart.getNotationView();
		{//execution of the command
			SetBoundsCommand resizeCommand = new SetBoundsCommand(diagramEditor.getEditingDomain(), "resize", new EObjectAdapter(NotationPackage1), new Rectangle(0, 0, 200, 200));

			assertTrue("CREATION: " + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, resizeCommand.canExecute() == true);
			diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(new ICommandProxy(resizeCommand));
		}
		{//test about the layout
			org.eclipse.papyrus.infra.gmfdiag.common.figure.node.SVGNodePlateFigure nodePlate = (org.eclipse.papyrus.infra.gmfdiag.common.figure.node.SVGNodePlateFigure)((BorderedNodeFigure)packageEditPart.getFigure()).getChildren().get(0);
			// now verify position of each subfigure
			package1figure = ((PackageFigure)nodePlate.getChildren().get(0));
			package1figure.setBounds(new Rectangle(0, 0, 200, 200));
			assertTrue("The figure of package1 is not an automaticCompartmentLayoutManager", package1figure.getLayoutManager() instanceof Package);
			package1figure.getLayoutManager().layout(package1figure);
			assertTrue("The figure of the Class has not the good X coordinate", package1figure.getBounds().x == 0);
			assertTrue("The figure of the Class has not the good Y coordinate", package1figure.getBounds().y == 0);
			assertTrue("The figure of the Class has not the good width coordinate", package1figure.getBounds().width == 200);
			assertTrue("The figure of the Class has not the good height coordinate", package1figure.getBounds().height == 200);

			// At this moment the class figure must contain 4 sub-figures 1label+ 3compartments
			assertTrue("The number of figure children must be equal to 4", package1figure.getChildren().size() == 4);

			//wrappinglabel for name
			assertTrue("The sub figure [0] is not a wrapping label", package1figure.getChildren().get(0) instanceof WrappingLabel);
			WrappingLabel labelClass = (WrappingLabel)package1figure.getChildren().get(0);

			assertTrue("The label of the Class has not the good X coordinate", labelClass.getBounds().x == 1);
			assertTrue("The label of the Class has not the good Y coordinate", labelClass.getBounds().y == 3);
			assertTrue("The label of the Class has not the good width coordinate", labelClass.getBounds().width == 200);
			assertTrue("The label of the Class has not the good heightcoordinate", labelClass.getBounds().height == 16);
			assertEquals("The label of the Class does not display Class1", labelClass.getText(), "Class1");

			assertTrue("The sub figure [0] is not a compartment", package1figure.getChildren().get(1) instanceof RectangleFigure);
			RectangleFigure propertiesClass = (RectangleFigure)package1figure.getChildren().get(1);
			assertTrue("The sub figure [0] is not the attribute compartment is not a ResizableCompartmentFigure", propertiesClass.getChildren().get(0) instanceof ResizableCompartmentFigure);

			// compartment for attribute
			assertTrue("The compartment attribute of the Class has not the good X coordinate", propertiesClass.getBounds().x == 1);
			assertTrue("The compartment attribute of the Class has not the good Y coordinate", propertiesClass.getBounds().y == 20);
			assertTrue("The compartment attribute of the Class has not the good width coordinate", propertiesClass.getBounds().width == 200);
			assertTrue("The compartment attribute of the Class has not the good height coordinate", propertiesClass.getBounds().height == 59);


			//compartment for operation
			assertTrue("The figure of class1 is not an automaticCompartmentLayoutManager", package1figure.getChildren().get(2) instanceof RectangleFigure);
			RectangleFigure operationsClass = (RectangleFigure)package1figure.getChildren().get(2);
			assertTrue("The sub figure [0] is not the operation compartment is not a ResizableCompartmentFigure", operationsClass.getChildren().get(0) instanceof ResizableCompartmentFigure);
			assertTrue("The compartment operation of the Class has not the good X coordinate", operationsClass.getBounds().x == 1);
			assertTrue("The compartment operation of the Class has not the good y coordinate", operationsClass.getBounds().y == 80);
			assertTrue("The compartment operation of the Class has not the good width coordinate", operationsClass.getBounds().width == 200);
			assertTrue("The compartment operation of the Class has not the good height coordinate", operationsClass.getBounds().height == 59);


			// compartment for nested classifier
			assertTrue("The figure of class1 is not an automaticCompartmentLayoutManager", package1figure.getChildren().get(3) instanceof RectangleFigure);
			RectangleFigure innerclassifiersClass = (RectangleFigure)package1figure.getChildren().get(3);
			assertTrue("The sub figure [0] is not the nested Classifier compartment is not a ResizableCompartmentFigure", innerclassifiersClass.getChildren().get(0) instanceof ResizableCompartmentFigure);
			assertTrue("The compartment nested classifier of the Class has not the good X coordinate", innerclassifiersClass.getBounds().x == 1);
			assertTrue("The compartment nested classifier of the Class has not the good Y coordinate", innerclassifiersClass.getBounds().y == 140);
			assertTrue("The compartment nested classifier of the Class has not the good width coordinate", innerclassifiersClass.getBounds().width == 200);
			assertTrue("The compartment nested classifier of the Class has not the good Height coordinate", innerclassifiersClass.getBounds().height == 59);

		}

		{// execution of the application of the stereotype
			ArrayList<Stereotype> stereotypeslist = new ArrayList<Stereotype>();
			stereotypeslist.add(package1.getApplicableStereotype(TEST_PROFILE_STEREOTYPE1));
			ApplyStereotypeCommand applyStereotypeCommand = new ApplyStereotypeCommand(((Element)packageEditPart.resolveSemanticElement()), stereotypeslist, diagramEditor.getEditingDomain());
			diagramEditor.getEditingDomain().getCommandStack().execute(applyStereotypeCommand);
			assertTrue("No applied stereotype found on the element ", package1.getAppliedStereotypes().size() != 0);
		}



		for(int i = 0; i < NotationPackage1.getTransientChildren().size(); i++) {
			View view = (View)NotationPackage1.getTransientChildren().get(i);
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
			RecordingCommand displayStereotypeCommand = AppliedStereotypeHelper.getAppliedStereotypeToDisplayCommand(diagramEditor.getEditingDomain(), NotationPackage1, stereotypeTest.getQualifiedName(), UMLVisualInformationPapyrusConstant.STEREOTYPE_COMPARTMENT_LOCATION);

			diagramEditor.getEditingDomain().getCommandStack().execute(displayStereotypeCommand);
			org.eclipse.papyrus.infra.gmfdiag.common.figure.node.SVGNodePlateFigure nodePlate = (org.eclipse.papyrus.infra.gmfdiag.common.figure.node.SVGNodePlateFigure)((BorderedNodeFigure)packageEditPart.getFigure()).getChildren().get(0);

			//get the label
			org.eclipse.draw2d.Label stereotypeLabel = ((ClassifierFigure)nodePlate.getChildren().get(0)).getStereotypesLabel();
			assertTrue("stereotype label must be not null", stereotypeLabel != null);
			assertTrue("text of stereotype label be equals to " + ST_LEFT + "stereotype1" + ST_RIGHT, stereotypeLabel.getText().equals(ST_LEFT + "stereotype1" + ST_RIGHT));
		}

		{//test about the layout
			org.eclipse.papyrus.infra.gmfdiag.common.figure.node.SVGNodePlateFigure nodePlate = (org.eclipse.papyrus.infra.gmfdiag.common.figure.node.SVGNodePlateFigure)((BorderedNodeFigure)packageEditPart.getFigure()).getChildren().get(0);
			// now verify position of each subfigure
			package1figure = ((PackageFigure)nodePlate.getChildren().get(0));
			package1figure.setBounds(new Rectangle(0, 0, 200, 200));
			assertTrue("The figure of «stereotype1»Class1 is not an automaticCompartmentLayoutManager", package1figure.getLayoutManager() instanceof AutomaticCompartmentLayoutManager);
			package1figure.getLayoutManager().layout(package1figure);
			assertTrue("The figure of the  «stereotype1»Class1 has not the good X coordinate", package1figure.getBounds().x == 0);
			assertTrue("The figure of the  «stereotype1»Class1 has not the good Y coordinate", package1figure.getBounds().y == 0);
			assertTrue("The figure of the  «stereotype1»Class1 has not the good width coordinate", package1figure.getBounds().width == 200);
			assertTrue("The figure of the  «stereotype1»Class1 has not the good height coordinate", package1figure.getBounds().height == 200);

			// At this moment the class figure must contain 5 sub-figures 1 label for stereotype+ 1label for name+ 3compartments
			assertTrue("The number of children «stereotype1»Class1 is not equals to 6", package1figure.getChildren().size() == 5);


			//wrappingLabel for stereotype
			assertTrue("The sub figure [0] of «stereotype1»Class1 is not a label", package1figure.getChildren().get(0) instanceof Label);
			Label stereotypelabelClass = (Label)package1figure.getChildren().get(0);

			assertTrue("The label of the Class has not the good X coordinate", stereotypelabelClass.getBounds().x == 1);
			assertTrue("The label of the Class has not the good Y coordinate", stereotypelabelClass.getBounds().y == 3);
			assertTrue("The label of the Class has not the good width coordinate", stereotypelabelClass.getBounds().width == 200);
			assertTrue("The label of the Class has not the good heightcoordinate", stereotypelabelClass.getBounds().height == 15);
			assertEquals("The label of the Class does not display " + ST_LEFT + "stereotype1" + ST_RIGHT, stereotypelabelClass.getText(), ST_LEFT + "stereotype1" + ST_RIGHT);


			//wrappingLabel for name
			assertTrue("The sub figure [1] of «stereotype1»Class1 is not a wrapping label", package1figure.getChildren().get(1) instanceof WrappingLabel);
			WrappingLabel labelClass = (WrappingLabel)package1figure.getChildren().get(1);

			assertTrue("The label of the Class has not the good X coordinate", labelClass.getBounds().x == 1);
			assertTrue("The label of the Class has not the good Y coordinate", labelClass.getBounds().y == 19);
			assertTrue("The label of the Class has not the good width coordinate", labelClass.getBounds().width == 200);
			assertTrue("The label of the Class has not the good heightcoordinate", labelClass.getBounds().height == 16);
			assertEquals("The label of the Class does not display Class1", labelClass.getText(), "Class1");

			// compartment for property of stereotype
			assertTrue("The sub figure [0] of «stereotype1»Class1 is not a compartment", package1figure.getChildren().get(2) instanceof RectangleFigure);
			RectangleFigure stereotypePropertiesClass = (RectangleFigure)package1figure.getChildren().get(2);
			assertTrue("The sub figure [0] is not the attribute compartment is not a ResizableCompartmentFigure", stereotypePropertiesClass.getChildren().get(0) instanceof ResizableCompartmentFigure);


			assertTrue("The compartment attribute of the Class has not the good X coordinate", stereotypePropertiesClass.getBounds().x == 1);
			assertTrue("The compartment attribute of the Class has not the good Y coordinate", stereotypePropertiesClass.getBounds().y == 36);
			assertTrue("The compartment attribute of the Class has not the good width coordinate", stereotypePropertiesClass.getBounds().width == 200);
			assertTrue("The compartment attribute of the Class has not the good height coordinate", stereotypePropertiesClass.getBounds().height == 54);


			// compartment attribute
			assertTrue("The sub figure [0] of «stereotype1»Class1 is not a compartment", package1figure.getChildren().get(2) instanceof RectangleFigure);
			RectangleFigure propertiesClass = (RectangleFigure)package1figure.getChildren().get(2);
			assertTrue("The sub figure [0] is not the attribute compartment is not a ResizableCompartmentFigure", propertiesClass.getChildren().get(0) instanceof ResizableCompartmentFigure);


			assertTrue("The compartment attribute of the Class has not the good X coordinate", propertiesClass.getBounds().x == 1);
			assertTrue("The compartment attribute of the Class has not the good Y coordinate", propertiesClass.getBounds().y == 36);
			assertTrue("The compartment attribute of the Class has not the good width coordinate", propertiesClass.getBounds().width == 200);
			assertTrue("The compartment attribute of the Class has not the good height coordinate", propertiesClass.getBounds().height == 54);


			//compartment for operation
			assertTrue("The sub figure [2] of «stereotype1»Class1 is not a compartment", package1figure.getChildren().get(3) instanceof RectangleFigure);
			RectangleFigure operationsClass = (RectangleFigure)package1figure.getChildren().get(3);
			assertTrue("The sub figure [2] is not the operation compartment is not a ResizableCompartmentFigure", operationsClass.getChildren().get(0) instanceof ResizableCompartmentFigure);
			assertTrue("The compartment operation of the Class has not the good X coordinate", operationsClass.getBounds().x == 1);
			assertTrue("The compartment operation of the Class has not the good y coordinate", operationsClass.getBounds().y == 91);
			assertTrue("The compartment operation of the Class has not the good width coordinate", operationsClass.getBounds().width == 200);
			assertTrue("The compartment operation of the Class has not the good height coordinate", operationsClass.getBounds().height == 54);

			//compartment for nested classifier
			assertTrue("The figure of class1 is not an automaticCompartmentLayoutManager", package1figure.getChildren().get(4) instanceof RectangleFigure);
			RectangleFigure innerclassifiersClass = (RectangleFigure)package1figure.getChildren().get(4);
			assertTrue("The sub figure [0] is not the nested Classifier compartment is not a ResizableCompartmentFigure", innerclassifiersClass.getChildren().get(0) instanceof ResizableCompartmentFigure);
			assertTrue("The compartment nested classifier of the Class has not the good X coordinate", innerclassifiersClass.getBounds().x == 1);
			assertTrue("The compartment nested classifier of the Class has not the good Y coordinate", innerclassifiersClass.getBounds().y == 146);
			assertTrue("The compartment nested classifier of the Class has not the good width coordinate", innerclassifiersClass.getBounds().width == 200);
			assertTrue("The compartment nested classifier of the Class has not the good Height coordinate", innerclassifiersClass.getBounds().height == 54);

		}





		{//test display of property of stereotype in compartment
			RecordingCommand displayPropertyStereotypeCommand = AppliedStereotypeHelper.getAddAppliedStereotypePropertiesCommand(diagramEditor.getEditingDomain(), NotationPackage1, stereotypeTest.getQualifiedName() + ".testInt");
			diagramEditor.getEditingDomain().getCommandStack().execute(displayPropertyStereotypeCommand);

			//the compartment must be visible
			assertTrue("the compartment must be visible", appliedStereotypeCompartmentNotation.isVisible() == true);
			//look for view that represents the property of the applied stereotype
			stereotypePropertyView = (View)appliedStereotypeCompartmentNotation.getChildren().get(0);
			assertNotNull("the view of the applied stereotype property must be created", stereotypePropertyView);
			//look for the editpart that represents the property of applied stereotype
			stereotypeCompartmentEdipart = (GraphicalEditPart)packageEditPart.getChildBySemanticHint(AppliedStereotypeCompartmentEditPart.ID);
			stereotypePropertyEdipart = (GraphicalEditPart)stereotypeCompartmentEdipart.getChildBySemanticHint(AppliedStereotypeMultilinePropertyEditPart.ID);
			assertNotNull("the editpart of the applied stereotype compartment must be created", stereotypeCompartmentEdipart);
			assertNotNull("the editpart of the applied stereotype property must be created", stereotypePropertyEdipart);
			EditingFlowPage textarea = (EditingFlowPage)stereotypePropertyEdipart.getFigure();
			assertTrue("text of stereotype label be equals to «stereotype1» ", ((TextFlowEx)textarea.getChildren().get(0)).getText().equals("testInt=0"));
		}

		{//test about the layout
			org.eclipse.papyrus.infra.gmfdiag.common.figure.node.SVGNodePlateFigure nodePlate = (org.eclipse.papyrus.infra.gmfdiag.common.figure.node.SVGNodePlateFigure)((BorderedNodeFigure)packageEditPart.getFigure()).getChildren().get(0);
			// now verify position of each subfigure
			package1figure = ((PackageFigure)nodePlate.getChildren().get(0));
			package1figure.setBounds(new Rectangle(0, 0, 200, 200));
			assertTrue("The figure of «stereotype1»Class1 is not an automaticCompartmentLayoutManager", package1figure.getLayoutManager() instanceof AutomaticCompartmentLayoutManager);
			package1figure.getLayoutManager().layout(package1figure);
			assertTrue("The figure of the  «stereotype1»Class1 has not the good X coordinate", package1figure.getBounds().x == 0);
			assertTrue("The figure of the  «stereotype1»Class1 has not the good Y coordinate", package1figure.getBounds().y == 0);
			assertTrue("The figure of the  «stereotype1»Class1 has not the good width coordinate", package1figure.getBounds().width == 200);
			assertTrue("The figure of the  «stereotype1»Class1 has not the good height coordinate", package1figure.getBounds().height == 200);

			// At this moment the class figure must contain 5 sub-figures 1 label for stereotype+ 1label for name+ compartment of stereotypes+ 3compartments
			assertTrue("The number of children «stereotype1»Class1 is not equals to 6", package1figure.getChildren().size() == 6);


			//label for stereotype
			assertTrue("The sub figure [0] of «stereotype1»Class1 is not a label", package1figure.getChildren().get(0) instanceof Label);
			Label stereotypelabelClass = (Label)package1figure.getChildren().get(0);

			assertTrue("The label of the Class has not the good X coordinate", stereotypelabelClass.getBounds().x == 1);
			assertTrue("The label of the Class has not the good Y coordinate", stereotypelabelClass.getBounds().y == 3);
			assertTrue("The label of the Class has not the good width coordinate", stereotypelabelClass.getBounds().width == 200);
			assertTrue("The label of the Class has not the good heightcoordinate", stereotypelabelClass.getBounds().height == 15);
			assertEquals("The label of the Class does not display " + ST_LEFT + "stereotype1" + ST_RIGHT, stereotypelabelClass.getText(), ST_LEFT + "stereotype1" + ST_RIGHT);


			//wrappingLabel for name
			assertTrue("The sub figure [1] of «stereotype1»Class1 is not a wrapping label", package1figure.getChildren().get(1) instanceof WrappingLabel);
			WrappingLabel labelClass = (WrappingLabel)package1figure.getChildren().get(1);

			assertTrue("The label of the Class has not the good X coordinate", labelClass.getBounds().x == 1);
			assertTrue("The label of the Class has not the good Y coordinate", labelClass.getBounds().y == 19);
			assertTrue("The label of the Class has not the good width coordinate", labelClass.getBounds().width == 200);
			assertTrue("The label of the Class has not the good heightcoordinate", labelClass.getBounds().height == 16);
			assertEquals("The label of the Class does not display Class1", labelClass.getText(), "Class1");


			// compartment for property of stereotypes
			assertTrue("The sub figure [2] of «stereotype1»Class1 is not a compartment", package1figure.getChildren().get(2) instanceof StereotypePropertiesCompartment);
			StereotypePropertiesCompartment sterotypesPropertiesClass = (StereotypePropertiesCompartment)package1figure.getChildren().get(2);

			assertTrue("the stereotype properties compartment does not conent the compartment for a stereotype", sterotypesPropertiesClass.getChildren().get(0) instanceof ResizableCompartmentFigure);
			ResizableCompartmentFigure compartmentFigure = (ResizableCompartmentFigure)sterotypesPropertiesClass.getChildren().get(0);
			assertTrue("The content of the sterotype properties compartment is not an EditingFlowPage", compartmentFigure.getContentPane().getChildren().get(0) instanceof EditingFlowPage);
			EditingFlowPage stereotypeProperty = (EditingFlowPage)compartmentFigure.getContentPane().getChildren().get(0);
			assertTrue("text of stereotype label be equals to «stereotype1» ", ((TextFlowEx)stereotypeProperty.getChildren().get(0)).getText().equals("testInt=0"));

			assertTrue("The compartment property of stereotypes of the Class has not the good X coordinate", sterotypesPropertiesClass.getBounds().x == 1);
			assertTrue("The compartment property of stereotypes of the Class has not the good Y coordinate", sterotypesPropertiesClass.getBounds().y == 36);
			assertTrue("The compartment property of stereotypes of the Class has not the good width coordinate", sterotypesPropertiesClass.getBounds().width == 200);
			assertTrue("The compartment property of stereotypes of the Class has not the good height coordinate", sterotypesPropertiesClass.getBounds().height == 51);

			//compartment for attribute
			assertTrue("The sub figure [2] of «stereotype1»Class1 is not a compartment", package1figure.getChildren().get(3) instanceof RectangleFigure);
			RectangleFigure propertiesClass = (RectangleFigure)package1figure.getChildren().get(3);
			assertTrue("The sub figure [2] is not the attribute compartment is not a ResizableCompartmentFigure", propertiesClass.getChildren().get(0) instanceof ResizableCompartmentFigure);

			assertTrue("The compartment attribute of the Class has not the good X coordinate", propertiesClass.getBounds().x == 1);
			assertTrue("The compartment attribute of the Class has not the good Y coordinate", propertiesClass.getBounds().y == 88);
			assertTrue("The compartment attribute of the Class has not the good width coordinate", propertiesClass.getBounds().width == 200);
			assertTrue("The compartment attribute of the Class has not the good height coordinate", propertiesClass.getBounds().height == 37);


			//compartment for operation
			assertTrue("The sub figure [2] of «stereotype1»Class1 is not a compartment", package1figure.getChildren().get(4) instanceof RectangleFigure);
			RectangleFigure operationsClass = (RectangleFigure)package1figure.getChildren().get(4);
			assertTrue("The sub figure [2] is not the operation compartment is not a ResizableCompartmentFigure", operationsClass.getChildren().get(0) instanceof ResizableCompartmentFigure);
			assertTrue("The compartment operation of the Class has not the good X coordinate", operationsClass.getBounds().x == 1);
			assertTrue("The compartment operation of the Class has not the good y coordinate", operationsClass.getBounds().y == 126);
			assertTrue("The compartment operation of the Class has not the good width coordinate", operationsClass.getBounds().width == 200);
			assertTrue("The compartment operation of the Class has not the good height coordinate", operationsClass.getBounds().height == 37);

			//compartment for nested classifier
			assertTrue("The figure of class1 is not an automaticCompartmentLayoutManager", package1figure.getChildren().get(5) instanceof RectangleFigure);
			RectangleFigure innerclassifiersClass = (RectangleFigure)package1figure.getChildren().get(5);
			assertTrue("The sub figure [0] is not the nested Classifier compartment is not a ResizableCompartmentFigure", innerclassifiersClass.getChildren().get(0) instanceof ResizableCompartmentFigure);
			assertTrue("The compartment nested classifier of the Class has not the good X coordinate", innerclassifiersClass.getBounds().x == 1);
			assertTrue("The compartment nested classifier of the Class has not the good Y coordinate", innerclassifiersClass.getBounds().y == 164);
			assertTrue("The compartment nested classifier of the Class has not the good width coordinate", innerclassifiersClass.getBounds().width == 200);
			assertTrue("The compartment nested classifier of the Class has not the good Height coordinate", innerclassifiersClass.getBounds().height == 37);

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
}
