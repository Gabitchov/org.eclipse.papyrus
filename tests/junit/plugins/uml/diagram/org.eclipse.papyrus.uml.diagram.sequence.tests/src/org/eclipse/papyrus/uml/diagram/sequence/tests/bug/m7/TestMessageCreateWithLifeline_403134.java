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

import java.util.Collections;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message4EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.junit.Test;

/**
 * Create a lifeline if the target of Create message is not selected.
 * 
 * @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=403134
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class TestMessageCreateWithLifeline_403134 extends AbstractNodeTest {

	@Test
	public void test() {
		LifelineEditPart lifeline = (LifelineEditPart)createNode(UMLElementTypes.Lifeline_3001, getRootEditPart(), new Point(100, 100), null);
		assertNotNull(lifeline);
		Point fromLocation = getAbsoluteBounds(lifeline).getCenter();
		//start connection
		EditPart sourceEditPart = null;
		EditPart targetEditPart = null;
		CreateConnectionViewRequest request = CreateViewRequestFactory.getCreateConnectionRequest(UMLElementTypes.Message_4006, ((IGraphicalEditPart)getDiagramEditPart()).getDiagramPreferencesHint());
		assertNotNull(request);
		request.setLocation(fromLocation);
		request.setType(RequestConstants.REQ_CONNECTION_START);
		sourceEditPart = lifeline.getViewer().findObjectAtExcluding(fromLocation, Collections.emptySet(), getTargetingConditional(request));
		assertNotNull(sourceEditPart);
		request.setSourceEditPart(sourceEditPart);
		request.setTargetEditPart(sourceEditPart);
		Command command = sourceEditPart.getCommand(request);
		assertNotNull(COMMAND_NULL, command);
		//connect...
		Point toLocation = fromLocation.getTranslated(100, 0);
		request.setLocation(toLocation);
		request.setType(RequestConstants.REQ_CONNECTION_END);
		targetEditPart = sourceEditPart.getViewer().findObjectAtExcluding(toLocation, Collections.emptySet(), getTargetingConditional(request));
		assertNotNull(targetEditPart);
		request.setTargetEditPart(targetEditPart);
		command = targetEditPart.getCommand(request);
		assertNotNull(COMMAND_NULL, command);
		assertTrue(command.canExecute());
		getDiagramCommandStack().execute(command);
		waitForComplete();
		//check result
		View view = (View)request.getConnectionViewDescriptor().getAdapter(View.class);
		assertNotNull("view not found", view);
		EditPart editPart = (EditPart)lifeline.getViewer().getEditPartRegistry().get(view);
		assertNotNull("editpart not found", editPart);
		assertTrue("not a messageCreate editpart", editPart instanceof Message4EditPart);
		EditPart target = ((Message4EditPart)editPart).getTarget();
		assertTrue("the target is not a lifeline", target instanceof LifelineEditPart);
	}

	protected EditPartViewer.Conditional getTargetingConditional(final Request req) {
		return new EditPartViewer.Conditional() {

			public boolean evaluate(EditPart editpart) {
				return editpart.getTargetEditPart(req) != null;
			}
		};
	}
}
