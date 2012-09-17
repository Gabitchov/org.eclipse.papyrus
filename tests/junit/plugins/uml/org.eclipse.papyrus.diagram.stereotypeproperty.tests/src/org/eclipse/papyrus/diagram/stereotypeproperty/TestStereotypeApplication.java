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

import java.util.ArrayList;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.core.utils.EditorUtils;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ClassEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.common.editparts.AppliedStereotypeConpartmentEditPart;
import org.eclipse.papyrus.uml.extensionpoints.profile.RegisteredProfile;
import org.eclipse.papyrus.uml.extensionpoints.utils.Util;
import org.eclipse.papyrus.uml.tools.commands.ApplyStereotypeCommand;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;
import org.junit.Test;


public class TestStereotypeApplication extends AbstractPapyrusTestCase {


	private static final String TEST_PROFILE_STEREOTYPE1 = "testProfile::Stereotype1";

	@Test
	public void testToManageModel() {
		testToCreateANode(UMLElementTypes.Class_2008);

	}

	/**
	 * Test to create a node.
	 * 
	 * @param type
	 *        the type
	 */
	public void testToCreateANode(IElementType type) {

		//CREATION
		assertTrue(CREATION + INITIALIZATION_TEST, getDiagramEditPart().getChildren().size() == 0);

		assertTrue(CREATION + INITIALIZATION_TEST, getRootSemanticModel().getOwnedElements().size() == 1);
		//1 element element due to the reference to the profile
		EList<Profile> list = ((Model)getRootSemanticModel()).getAllAppliedProfiles();
		assertTrue(CREATION + INITIALIZATION_TEST, ((Model)getRootSemanticModel()).getAllAppliedProfiles().size() == 1);

		CreateViewRequest requestcreation = CreateViewRequestFactory.getCreateShapeRequest(type, getDiagramEditPart().getDiagramPreferencesHint());
		Command command = getDiagramEditPart().getCommand(requestcreation);
		assertNotNull(CREATION + COMMAND_NULL, command);
		assertTrue(CREATION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue("CREATION: " + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(command);
		assertTrue(CREATION + TEST_THE_EXECUTION, getRootView().getChildren().size() == 1);
		Element element = getRootSemanticModel().getOwnedElements().get(1);
		GraphicalEditPart classEditPart = (ClassEditPart)getDiagramEditPart().getChildren().get(0);
		assertTrue(CREATION + TEST_THE_EXECUTION, element.getApplicableStereotype(TEST_PROFILE_STEREOTYPE1) != null);
		ArrayList<Stereotype> stereotypeslist = new ArrayList<Stereotype>();
		stereotypeslist.add(element.getApplicableStereotype(TEST_PROFILE_STEREOTYPE1));



		ApplyStereotypeCommand applyStereotypeCommand = new ApplyStereotypeCommand(((Element)classEditPart.resolveSemanticElement()), stereotypeslist);
		diagramEditor.getEditingDomain().getCommandStack().execute(applyStereotypeCommand);
		//diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(new ICommandProxy(new EMFtoGMFCommandWrapper(applyStereotypeCommand)));
		Element semanticElement = (Element)classEditPart.resolveSemanticElement();
		assertTrue(CREATION + TEST_THE_EXECUTION + "No applied stereotype found on the element ", semanticElement.getAppliedStereotypes().size() != 0);

		View appliedStereotypeMultilinePropertyView = null;
		for(int i = 0; i < classEditPart.getNotationView().getChildren().size(); i++) {
			View view = ((View)classEditPart.getNotationView().getChildren().get(i));
			if(view.getType().equals(AppliedStereotypeConpartmentEditPart.ID)) {
				appliedStereotypeMultilinePropertyView = view;

			}
		}
		//the thread is asynchronous
		assertTrue(CREATION + TEST_THE_EXECUTION + "No stereotype Compartment found in the notation", appliedStereotypeMultilinePropertyView == null);

		//		AppliedStereotypeMultilinePropertyEditPart appliedStereotypeMultilinePropertyEditPart=null;
		//		for(int i=0; i<classEditPart.getChildren().size();i++){
		//			GraphicalEditPart editPart= ((GraphicalEditPart)classEditPart.getChildren().get(i));
		//			if (editPart.getNotationView().getType().equals(AppliedStereotypeMultilinePropertyEditPart.ID)){
		//				appliedStereotypeMultilinePropertyEditPart=(AppliedStereotypeMultilinePropertyEditPart)editPart;
		//				
		//			}
		//		}
		//		assertTrue(CREATION+TEST_THE_EXECUTION,appliedStereotypeMultilinePropertyEditPart!=null);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		RegisteredProfile registeredProfile = RegisteredProfile.getRegisteredProfile("TestProfile");
		final Model root = ((Model)getDiagramEditPart().resolveSemanticElement());
		URI modelUri = registeredProfile.uri;
		final Resource modelResource = Util.getResourceSet(root).getResource(modelUri, true);
		final Profile profile = (Profile)modelResource.getContents().get(0);
		//	PackageUtil.applyProfile(root,profile, false);
		final TransactionalEditingDomain domain = EditorUtils.getTransactionalEditingDomain();
		AppliedProfileCommand appliedProfileCommand = new AppliedProfileCommand(domain, root, profile);
		domain.getCommandStack().execute(new GMFtoEMFCommandWrapper(appliedProfileCommand));


	}
}
