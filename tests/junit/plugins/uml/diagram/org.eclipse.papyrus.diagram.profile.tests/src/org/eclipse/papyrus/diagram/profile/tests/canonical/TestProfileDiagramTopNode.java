/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Thibault Le Ouay (Sherpa Engineering) t.leouay@sherpa-eng.com  - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.diagram.profile.tests.canonical;


import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.diagram.tests.canonical.TestTopNode;
import org.eclipse.papyrus.uml.diagram.profile.CreateProfileDiagramCommand;
import org.eclipse.papyrus.uml.diagram.profile.providers.UMLElementTypes;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.Test;


public class TestProfileDiagramTopNode extends TestTopNode {

	@Override
	protected CreateViewRequest createViewRequestShapeContainer() {
		return CreateViewRequestFactory.getCreateShapeRequest(UMLElementTypes.Package_2007, getDiagramEditPart().getDiagramPreferencesHint());
	}

	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		return (ICreationCommand)new CreateProfileDiagramCommand();
	}

	@Override
	protected String getProjectName() {
		return "ProfileDiagramTestProject";
	}

	@Override
	protected String getFileName() {
		return "ProfileDiagramTest.profile.di";
	}

	@Test
	public void testToManageClass() {
		testToManageNode(UMLElementTypes.Class_2008, UMLPackage.eINSTANCE.getClass_(), UMLElementTypes.Package_2007, false);
	}

	@Test
	public void testToManagePackage() {
		testToManageNode(UMLElementTypes.Package_2007, UMLPackage.eINSTANCE.getPackage(), UMLElementTypes.Package_2007, false);
	}

	@Test
	public void testToManageDataType() {
		testToManageNode(UMLElementTypes.DataType_2010, UMLPackage.eINSTANCE.getPackage(), UMLElementTypes.Package_2007, false);
	}

	@Test
	public void testToManageStereoType() {
		testToManageNode(UMLElementTypes.Stereotype_1026, UMLPackage.eINSTANCE.getStereotype(), UMLElementTypes.Package_2007, false);
	}

	@Test
	public void testToManageProfile() {
		testToManageNode(UMLElementTypes.Profile_1030, UMLPackage.eINSTANCE.getProfile(), UMLElementTypes.Package_2007, false);
	}
}
