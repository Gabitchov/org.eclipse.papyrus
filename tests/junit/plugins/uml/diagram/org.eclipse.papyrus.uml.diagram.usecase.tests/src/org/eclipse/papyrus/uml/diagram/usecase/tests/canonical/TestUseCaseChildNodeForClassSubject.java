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
package org.eclipse.papyrus.uml.diagram.usecase.tests.canonical;

import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest.ViewAndElementDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.diagram.tests.canonical.TestChildNode;
import org.eclipse.papyrus.uml.diagram.usecase.CreateUseCaseDiagramCommand;
import org.eclipse.papyrus.uml.diagram.usecase.providers.UMLElementTypes;
import org.junit.Test;


/**
 * The Class TestUseCaseChildNodeForPackage.
 */
public class TestUseCaseChildNodeForClassSubject extends TestChildNode {

	
	@Override
	protected CreateViewRequest createViewRequestShapeContainer() {
		CreateElementRequest semanticRequest=new CreateElementRequest(UMLElementTypes.Classifier_2015);
		semanticRequest.setParameter("Subject_SemanticHint", org.eclipse.papyrus.uml.service.types.element.UMLElementTypes.CLASS);
		
		ViewAndElementDescriptor viewDescriptor = new ViewAndElementDescriptor(
			new CreateElementRequestAdapter(semanticRequest),
			Node.class, ((IHintedType) UMLElementTypes.Classifier_2015).getSemanticHint(), getDiagramEditPart().getDiagramPreferencesHint());
		CreateViewRequest requestcreation= new CreateViewAndElementRequest(viewDescriptor);
		return requestcreation;
	}
	
	
	@Test
	public void testToManageUseCaseForClassSubject() {
		testToManageChildNode(UMLElementTypes.UseCase_3009, UMLElementTypes.Classifier_2015, false);
	}
	
	@Test
	public void testToManageUseCaseForComponentSubject() {
		testToManageChildNode(UMLElementTypes.UseCase_3009, UMLElementTypes.Classifier_2015, false);
	}
	@Test
	public void testToManageUseCaseForInterfaceSubject() {
		testToManageChildNode(UMLElementTypes.UseCase_3009, UMLElementTypes.Classifier_2015, false);
	}
	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		return  new CreateUseCaseDiagramCommand();
	}
	
}
