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

import java.util.List;

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.commands.wrappers.GEFtoEMFCommandWrapper;
import org.eclipse.papyrus.uml.diagram.sequence.tests.canonical.CreateSequenceDiagramCommand;
import org.eclipse.papyrus.uml.diagram.sequence.tests.canonical.TestTopNode;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.intro.IIntroManager;
import org.eclipse.ui.intro.IIntroPart;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public abstract class AbstractNodeTest extends TestTopNode {

	private static final String RESIZE = "Resize: ";

	/**
	 * @see org.eclipse.papyrus.diagram.tests.canonical.AbstractPapyrusTestCase#getDiagramCommandCreation()
	 * 
	 * @return
	 */
	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		return new CreateSequenceDiagramCommand();
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.sequence.tests.canonical.TestTopNode#setUp()
	 * 
	 * @throws Exception
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		Runnable runnable = new Runnable() {

			public void run() {
				try {
					//Max shell
					IWorkbench workbench = PlatformUI.getWorkbench();
					workbench.getActiveWorkbenchWindow().getShell().setMaximized(true);
					//close intro
					IIntroManager introManager = workbench.getIntroManager();
					IIntroPart intro = introManager.getIntro();
					if(intro != null) {
						introManager.closeIntro(intro);
					}
				} catch (Exception ex) {
					ex.printStackTrace(System.out);
				}
			}
		};
		Display.getDefault().syncExec(runnable);
	}

	protected EditPart createNode(IElementType type, EditPart parentPart, Point location, Dimension size) {
		//CREATION
		CreateViewRequest createReq = CreateViewRequestFactory.getCreateShapeRequest(type, getRootEditPart().getDiagramPreferencesHint());
		createReq.setLocation(location);
		createReq.setSize(size);
		Command command = parentPart.getCommand(createReq);
		assertNotNull(CREATION + COMMAND_NULL, command);
		assertTrue(CREATION + TEST_IF_THE_COMMAND_IS_CREATED, command != UnexecutableCommand.INSTANCE);
		assertTrue(CREATION + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, command.canExecute() == true);
		getDiagramCommandStack().execute(command);
		waitForComplete();
		//return the created EditPart.
		List<? extends ViewDescriptor> viewDescriptors = createReq.getViewDescriptors();
		for(ViewDescriptor viewDescriptor : viewDescriptors) {
			String semanticHint = viewDescriptor.getSemanticHint();
			if(type instanceof IHintedType) {
				if(!semanticHint.equals(((IHintedType)type).getSemanticHint())) {
					continue;
				}
			}
			Object adapter = viewDescriptor.getAdapter(View.class);
			Object object = parentPart.getViewer().getEditPartRegistry().get(adapter);
			if(object instanceof EditPart) {
				return (EditPart)object;
			}
		}
		return null;
	}

	protected void resize(IGraphicalEditPart editPart, Point location, int resizeDirection, Dimension sizeDelta) {
		ChangeBoundsRequest req = new ChangeBoundsRequest(RequestConstants.REQ_RESIZE);
		req.setLocation(location);
		req.setEditParts(editPart);
		req.setResizeDirection(resizeDirection);
		req.setSizeDelta(sizeDelta);
		if(resizeDirection == PositionConstants.NORTH || resizeDirection == PositionConstants.WEST) {
			req.setMoveDelta(new Point(-sizeDelta.width(), -sizeDelta.height()));
		}
		Command c = editPart.getCommand(req);
		manageResizeCommnad(editPart, sizeDelta, c);
	}

	private void manageResizeCommnad(IGraphicalEditPart op, Dimension deltaSize, Command c) {
		assertNotNull(RESIZE + COMMAND_NULL, c);
		assertTrue(RESIZE + TEST_IF_THE_COMMAND_CAN_BE_EXECUTED, c.canExecute() == true);
		Rectangle before = getAbsoluteBounds(op);
		getEMFCommandStack().execute(new GEFtoEMFCommandWrapper(c));
		waitForComplete();
		Rectangle after = getAbsoluteBounds(op);
		assertTrue(RESIZE + TEST_THE_EXECUTION, after.width() - before.width() == deltaSize.width());
		assertTrue(RESIZE + TEST_THE_EXECUTION, after.height() - before.height() == deltaSize.height());
		getEMFCommandStack().undo();
		waitForComplete();
		assertTrue(RESIZE + TEST_THE_UNDO, before.equals(getAbsoluteBounds(op)));
		getEMFCommandStack().redo();
		waitForComplete();
		assertTrue(RESIZE + TEST_THE_REDO, after.equals(getAbsoluteBounds(op)));
	}
}
