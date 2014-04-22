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
import org.eclipse.papyrus.diagram.tests.canonical.TestChildNode;
import org.eclipse.papyrus.uml.diagram.profile.CreateProfileDiagramCommand;
import org.eclipse.papyrus.uml.diagram.profile.providers.UMLElementTypes;
import org.eclipse.uml2.uml.UMLPackage;
/**
 * @author Thibault
 *
 */
import org.junit.Test;

public class TestProfileDiagramChildNode extends TestChildNode {

	protected CreateViewRequest createViewRequestShapeContainer() {
		return CreateViewRequestFactory.getCreateShapeRequest(UMLElementTypes.Package_2007, getDiagramEditPart().getDiagramPreferencesHint());
	}

	protected ICreationCommand getDiagramCommandCreation() {
		return new CreateProfileDiagramCommand();
	}

	protected String getProjectName() {
		return "ProfileDiagramTestProject";
	}

	protected String getFileName() {
		return "ProfileDiagramTest.profile.di";
	}

	@Test
	public void testToManageClassInPackage() {
		testToManageNode(UMLElementTypes.Class_3010, UMLPackage.eINSTANCE.getClass_(), UMLElementTypes.Package_2007, false);
	}

	@Test
	public void testToManageDatatypeInPackage() {
		testToManageNode(UMLElementTypes.DataType_3027, UMLPackage.eINSTANCE.getDataType(), UMLElementTypes.Package_2007, false);
	}

	@Test
	public void testToManagePackageInPackage() {
		testToManageNode(UMLElementTypes.Package_1012, UMLPackage.eINSTANCE.getPackage(), UMLElementTypes.Package_2007, false);
	}

	@Test
	public void testToManageStereoTypeInPackage() {
		testToManageNode(UMLElementTypes.Stereotype_1023, UMLPackage.eINSTANCE.getStereotype(), UMLElementTypes.Package_2007, false);
	}

	@Test
	public void testToManageProfileInPackage() {
		testToManageNode(UMLElementTypes.Profile_1024, UMLPackage.eINSTANCE.getProfile(), UMLElementTypes.Package_2007, false);
	}

	@Test
	public void testToManageClassInProfile() {
		testToManageNode(UMLElementTypes.Class_3010, UMLPackage.eINSTANCE.getClass_(), UMLElementTypes.Profile_1030, false);
	}

	@Test
	public void testToManageDatatypeInProfile() {
		testToManageNode(UMLElementTypes.DataType_3027, UMLPackage.eINSTANCE.getDataType(), UMLElementTypes.Profile_1030, false);
	}

	@Test
	public void testToManagePackageInProfile() {
		testToManageNode(UMLElementTypes.Package_1012, UMLPackage.eINSTANCE.getPackage(), UMLElementTypes.Profile_1030, false);
	}

	@Test
	public void testToManageStereoTypeInProfile() {
		testToManageNode(UMLElementTypes.Stereotype_1023, UMLPackage.eINSTANCE.getStereotype(), UMLElementTypes.Profile_1030, false);
	}

	@Test
	public void testToManageProfileInProfile() {
		testToManageNode(UMLElementTypes.Profile_1024, UMLPackage.eINSTANCE.getProfile(), UMLElementTypes.Profile_1030, false);
	}
}
