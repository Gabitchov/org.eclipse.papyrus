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
package org.eclipse.papyrus.uml.diagram.pkg.tests.canonical;

import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.uml.diagram.pkg.PackageDiagramCreateCommand;
import org.eclipse.papyrus.uml.diagram.pkg.provider.ElementTypes;
import org.junit.Test;

public class TestPackageDiagramCommentLink extends TestCommentLink {

	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		return new PackageDiagramCreateCommand();
	}

	/**
	 * Test to manage Comment
	 */
	@Test
	public void testToManageComment() {
		testToManageLink(ElementTypes.COMMENT, ElementTypes.PACKAGE, ElementTypes.COMMENT_ANNOTATED_ELEMENT, ElementTypes.PACKAGE, true);
	}
}
