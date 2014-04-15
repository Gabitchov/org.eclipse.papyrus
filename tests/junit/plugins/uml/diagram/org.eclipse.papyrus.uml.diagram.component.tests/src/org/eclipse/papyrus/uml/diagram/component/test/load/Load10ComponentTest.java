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
package org.eclipse.papyrus.uml.diagram.component.test.load;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.component.test.IComponentDiagramTestsConstants;
import org.eclipse.papyrus.uml.diagram.component.test.canonical.AbstractPapyrusTestCase;
import org.junit.Test;

/**
 * The Class Load10ComponentTest.
 */
public class Load10ComponentTest extends AbstractPapyrusTestCase {

	@Override
	protected String getProjectName() {
		return IComponentDiagramTestsConstants.PROJECT_NAME;
	}

	@Override
	protected String getFileName() {
		return IComponentDiagramTestsConstants.FILE_NAME;
	}

	/**
	 * Test to create a Component.
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
	 * Test load10 Component.
	 */
	@Test
	public void testLoad10Component() {
		for(int i = 0; i < 10; i++) {
			testToCreateANode(UMLElementTypes.Component_2002);
		}
	}
}
