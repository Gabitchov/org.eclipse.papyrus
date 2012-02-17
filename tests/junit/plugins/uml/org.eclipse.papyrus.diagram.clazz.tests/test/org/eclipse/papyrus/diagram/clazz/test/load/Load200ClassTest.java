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
package org.eclipse.papyrus.diagram.clazz.test.load;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.diagram.clazz.test.canonical.AbstractPapyrusTestCase;
import org.eclipse.papyrus.uml.diagram.clazz.providers.UMLElementTypes;
import org.junit.Test;



// TODO: Auto-generated Javadoc
/**
 * The Class Load200ClassTest.
 */
public class Load200ClassTest extends AbstractPapyrusTestCase {
	
	/**
	 * Test to create a node.
	 * 
	 * @param type the type
	 */
	public void testToCreateANode(IElementType type) {
		CreateViewRequest requestcreation=CreateViewRequestFactory.getCreateShapeRequest(type, getDiagramEditPart().getDiagramPreferencesHint());
		Command command=getDiagramEditPart().getCommand(requestcreation);
		assertNotNull("CREATION: creation command null",command);
		assertTrue("CREATION: test if the command is created",command!=UnexecutableCommand.INSTANCE);
		assertTrue("CREATION: test if the command can be executed",command.canExecute()==true);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(command);
			
	}
	
	/**
	 * Test load200 class.
	 */
	@Test
	public void testLoad200Class() {
		for( int i=0; i<200;i++){
		testToCreateANode(UMLElementTypes.Class_2008);
		}
	}
	
}