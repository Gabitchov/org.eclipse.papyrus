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

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.diagram.clazz.test.IClassDiagramTestsConstants;
import org.eclipse.papyrus.diagram.clazz.test.canonical.AbstractPapyrusTestCase;
import org.eclipse.papyrus.uml.diagram.clazz.providers.UMLElementTypes;
import org.junit.Ignore;
import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class Load500ClassTest.
 */
public class Load500ClassTest extends AbstractPapyrusTestCase {

	@Override
	protected String getProjectName() {
		return IClassDiagramTestsConstants.PROJECT_NAME;
	}

	@Override
	protected String getFileName() {
		return IClassDiagramTestsConstants.FILE_NAME;
	}

	/**
	 * Test to create a node.
	 *
	 * @param type
	 *        the type
	 */
	public void testToCreateANode(IElementType type) {
		CreateViewRequest requestcreation = CreateViewRequestFactory.getCreateShapeRequest(type, getDiagramEditPart().getDiagramPreferencesHint());
		Command command = getDiagramEditPart().getCommand(requestcreation);
		assertNotNull("CREATION: creation command null", command);
		assertTrue("CREATION: test if the command is created", command != UnexecutableCommand.INSTANCE);
		assertTrue("CREATION: test if the command can be executed", command.canExecute() == true);
		diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(command);
	}

	/**
	 * Test load500 class.
	 */
	@Ignore
	@Test
	public void testLoad500Class() {
		for(int i = 0; i < 500; i++) {
			testToCreateANode(UMLElementTypes.Class_2008);
		}
	}
}
