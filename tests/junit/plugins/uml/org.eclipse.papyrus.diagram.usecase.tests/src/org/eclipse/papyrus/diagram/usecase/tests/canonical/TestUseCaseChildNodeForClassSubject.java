/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.usecase.tests.canonical;

import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.papyrus.diagram.tests.canonical.TestChildNode;
import org.eclipse.papyrus.infra.core.extension.commands.ICreationCommand;
import org.eclipse.papyrus.uml.diagram.usecase.CreateUseCaseDiagramCommand;
import org.eclipse.papyrus.uml.diagram.usecase.providers.UMLElementTypes;
import org.junit.Test;


// TODO: Auto-generated Javadoc
/**
 * The Class TestUseCaseChildNodeForPackage.
 */
public class TestUseCaseChildNodeForClassSubject extends TestChildNode {

	
	@Override
	protected CreateViewRequest createViewRequestShapeContainer() {
		return CreateViewRequestFactory.getCreateShapeRequest(UMLElementTypes.Class_2020, getDiagramEditPart().getDiagramPreferencesHint());
	}
	
	
	@Test
	public void testToManageUseCaseForClassSubject() {
		testToManageChildNode(UMLElementTypes.UseCase_3009, UMLElementTypes.Class_2020, false);
	}
	
	@Test
	public void testToManageUseCaseForComponentSubject() {
		testToManageChildNode(UMLElementTypes.UseCase_3009, UMLElementTypes.Component_2015, false);
	}
	@Test
	public void testToManageUseCaseForInterfaceSubject() {
		testToManageChildNode(UMLElementTypes.UseCase_3009, UMLElementTypes.Interface_2021, false);
	}
	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		return  new CreateUseCaseDiagramCommand();
	}
	
}
