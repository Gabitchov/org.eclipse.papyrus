/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.menu.actions.handlers;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.draw2d.Animation;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramCommandStack;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.diagram.menu.actions.ArrangeAction;
import org.eclipse.ui.IWorkbenchPart;

/**
 * Handler for the Arrange Action
 * 
 * 
 * 
 */
public class ArrangeHandler extends AbstractGraphicalCommandHandler {

	/** id of the parameter for the ZOrderAction */
	public static final String parameterID = "arrange_parameter"; //$NON-NLS-1$

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parameter
	 *        parameter for the arrange action
	 */
	public ArrangeHandler(String parameter) {
		super(parameterID, parameter);
	}

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public ArrangeHandler() {
		super(parameterID);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.diagram.common.handlers.GraphicalCommandHandler#getCommand()
	 * 
	 * @return
	 * @throws ExecutionException
	 */
	@Override
	protected Command getCommand() throws ExecutionException {
		ArrangeAction action = new ArrangeAction(this.parameter, getSelectedElements());
		Command cmd = action.getCommand();
		return (cmd == null) ? UnexecutableCommand.INSTANCE : cmd;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.diagram.menu.actions.handlers.AbstractGraphicalCommandHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 * 
	 * @param event
	 * @return
	 * @throws ExecutionException
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		doRun(new NullProgressMonitor());
		return null;
	}

	/**
	 * Execute the action with an animation
	 * 
	 * @param progressMonitor
	 *        the progress monitor
	 */
	protected void doRun(IProgressMonitor progressMonitor) {
		IPreferenceStore preferenceStore = (IPreferenceStore)getDiagramEditPart().getDiagramPreferencesHint().getPreferenceStore();
		boolean animatedLayout = preferenceStore.getBoolean(IPreferenceConstants.PREF_ENABLE_ANIMATED_LAYOUT);

		if(animatedLayout)
			Animation.markBegin();

		DiagramCommandStack stack = getDiagramCommandStack();
		if(stack != null) {
			try {
				(stack).execute(getCommand(), progressMonitor);
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			return;
		}

		if(animatedLayout) {
			int durationInc = 800;
			int factor = 10;
			int size = 0;

			List operationSet = getSelectedElements();
			if(ArrangeAction.ARRANGE_ALL.equals(parameter)) {
				for(Iterator iter = operationSet.iterator(); iter.hasNext();) {
					IGraphicalEditPart element = (IGraphicalEditPart)iter.next();
					size += element.getFigure().getChildren().size();
				}
			} else if(operationSet != null && !operationSet.isEmpty()) {
				IGraphicalEditPart container = (IGraphicalEditPart)getSelectionParent(operationSet);
				size += container.getFigure().getChildren().size();
			}

			int totalDuration = Math.min(durationInc * factor / 2, Math.max(durationInc, (size / factor) * durationInc));

			Animation.run(totalDuration);
		}
	}

	/**
	 * getSelectionParent Utility to return the logical parent of the selection
	 * list
	 * 
	 * @param editparts
	 *        List to parse for a common parent.
	 * @return EditPart that is the parent or null if a common parent doesn't
	 *         exist.
	 */
	private EditPart getSelectionParent(List editparts) {
		ListIterator li = editparts.listIterator();
		while(li.hasNext()) {
			Object obj = li.next();
			if(!(obj instanceof ConnectionEditPart) && obj instanceof EditPart) {
				return ((EditPart)obj).getParent();
			}
		}

		return null;
	}

	/**
	 * A utility method to return the active <code>DiagramEditPart</code> if
	 * the current part implements <code>IDiagramWorkbenchPart</code>
	 * 
	 * @return The current diagram if the parts implements <code>IDiagramWorkbenchPart</code>; <code>null</code> otherwise
	 */
	@Override
	protected IDiagramGraphicalViewer getDiagramGraphicalViewer() {
		IDiagramWorkbenchPart part = getDiagramWorkbenchPart();
		return part != null ? part.getDiagramGraphicalViewer() : null;
	}

	/**
	 * A utility method to return the active part if it implements
	 * or adapts to the <code>IDiagramWorkbenchPart</code> interface
	 * 
	 * @return The current part if it implements or adapts to <code>IDiagramWorkbenchPart</code>; <code>null</code> otherwise
	 */
	@Override
	protected IDiagramWorkbenchPart getDiagramWorkbenchPart() {
		IDiagramWorkbenchPart diagramPart = null;
		IWorkbenchPart part = getWorkbenchPart();

		if(part instanceof IDiagramWorkbenchPart) {
			diagramPart = (IDiagramWorkbenchPart)part;

		} else if(part != null) {
			diagramPart = (IDiagramWorkbenchPart)part.getAdapter(IDiagramWorkbenchPart.class);
		}

		return diagramPart;
	}

}
