/*****************************************************************************
 * Copyright (c) 2010 CEA
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.tests.bug.m7;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message4EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.tests.ISequenceDiagramTestsConstants;
import org.junit.Test;

/**
 * Create a lifeline if the target of Create message is not selected.
 *
 * @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=403134
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class TestMessageCreateWithLifeline_403134 extends AbstractNodeTest {

	@Override
	protected String getProjectName() {
		return ISequenceDiagramTestsConstants.PROJECT_NAME;
	}

	@Override
	protected String getFileName() {
		return ISequenceDiagramTestsConstants.FILE_NAME;
	}

	@Test
	public void test() {
		LifelineEditPart lifeline = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(100, 100), null);
		assertNotNull(lifeline);
		Point fromLocation = getAbsoluteBounds(lifeline).getCenter();
		EditPart editPart = createLink(UMLElementTypes.Message_4006, lifeline.getViewer(), fromLocation, fromLocation.getTranslated(100, 0));
		//check result
		assertNotNull("editpart not found", editPart);
		assertTrue("not a messageCreate editpart", editPart instanceof Message4EditPart);
		EditPart target = ((Message4EditPart)editPart).getTarget();
		assertTrue("the target is not a lifeline", target instanceof LifelineEditPart);
	}
}
