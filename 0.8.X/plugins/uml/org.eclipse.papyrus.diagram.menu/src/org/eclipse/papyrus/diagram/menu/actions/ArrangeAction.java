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
package org.eclipse.papyrus.diagram.menu.actions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.tools.ToolUtilities;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.ArrangeRequest;

/**
 * This action is used to arrange editparts on the diagram
 * Copied from {@link ArrangeAction}
 * 
 * 
 */
public class ArrangeAction extends AbstractGraphicalParametricAction {

	/** possible parameters for this action */
	public static final String ARRANGE_ALL = "arrangeAll"; //$NON-NLS-1$

	public static final String ARRANGE_SELECTION = "arrangeSelection"; //$NON-NLS-1$

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parameter
	 */
	public ArrangeAction(String parameter, List<IGraphicalEditPart> selection) {
		super(parameter, selection);
	}


	/**
	 * 
	 * @see org.eclipse.papyrus.diagram.menu.actions.AbstractParametricAction#getBuildedCommand()
	 * 
	 * @return
	 */
	@Override
	protected Command getBuildedCommand() {
		CompoundCommand command = new CompoundCommand("Arrange Command"); //$NON-NLS-1$

		if(getParameter().equals(ARRANGE_ALL)) {
			ArrangeRequest request = new ArrangeRequest("arrangeAllAction"); //$NON-NLS-1$
			request.setPartsToArrange(createOperationSetForArrangeAll(getSelection()));

			for(Iterator<IGraphicalEditPart> iter = getSelection().iterator(); iter.hasNext();) {
				EditPart element = iter.next();
				Command cmd = element.getCommand(request);
				if(cmd != null && cmd.canExecute())
					command.add(cmd);
			}
		} else if(getParameter().equals(ARRANGE_SELECTION)) {
			ArrangeRequest request = new ArrangeRequest("arrangeSelectionAction"); //$NON-NLS-1$
			request.setPartsToArrange(getSelection());

			EditPart commonAncestor = getTargetEditPartForArrangeSelection(getSelection(), request);
			if(commonAncestor != null) {
				Command cmd = commonAncestor.getCommand(request);
				if(cmd != null)
					command.add(cmd);
			}
		}

		return command.isEmpty() ? null : command;
	}

	/**
	 * 
	 * Copied from {@link org.eclipse.gmf.runtime.diagram.ui.actions.internal.ArrangeAction}
	 * 
	 * @param editparts
	 *        the list of the selected editparts
	 * @param request
	 *        the request to arrange the edit part
	 * @return
	 *         the EditPart, which can arrange the selection
	 */
	@SuppressWarnings("restriction")
	private EditPart getTargetEditPartForArrangeSelection(List<?> editparts, Request request) {

		if(editparts.size() == 1) {

			// If there is only one editpart selected, then the Arrange
			// Selected request gets sent to this editpart's target editpart to
			// allow clients to do as they wish.
			return ((EditPart)editparts.get(0)).getTargetEditPart(request);

		} else {

			// If there is more than one editpart selected, then the Arrange
			// Selected request gets sent to the common parent.
			EditPart parentEP = getSelectionParent(editparts);
			if(parentEP == null)
				return null;

			for(int i = 1; i < editparts.size(); i++) {
				EditPart part = (EditPart)editparts.get(i);
				if(part instanceof ConnectionEditPart) {
					continue;
				}
				// if there is no common parent, then Arrange Selected isn't
				// supported.
				if(part.getParent() != parentEP)
					return null;
			}
			return parentEP;
		}
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.diagram.menu.actions.AbstractParametricAction#isEnabled()
	 * 
	 * @return
	 */
	@Override
	public boolean isEnabled() {
		//we don't need selection to do arrange all
		if(getParameter().equals(ARRANGE_ALL)) {
			return true;
		}
		return super.isEnabled();
	}


	/**
	 * 
	 * Copied from {@link ArrangeAction} getSelectionParent Utility to return the logical parent of the selection
	 * list
	 * 
	 * @param editparts
	 *        List to parse for a common parent.
	 * @return EditPart that is the parent or null if a common parent doesn't
	 *         exist.
	 */
	protected EditPart getSelectionParent(List<?> editparts) {
		ListIterator<?> li = editparts.listIterator();
		while(li.hasNext()) {
			Object obj = li.next();
			if(!(obj instanceof ConnectionEditPart) && obj instanceof EditPart) {
				return ((EditPart)obj).getParent();
			}
		}

		return null;
	}

	/**
	 * @param selection
	 * @return the selection for the arrange all command
	 */
	@SuppressWarnings("unchecked")
	protected List<IGraphicalEditPart> createOperationSetForArrangeAll(List<IGraphicalEditPart> selection) {
		Set<IGraphicalEditPart> parentsSet = new HashSet<IGraphicalEditPart>();
		for(Iterator<IGraphicalEditPart> iter = selection.iterator(); iter.hasNext();) {
			Object element = iter.next();
			if(element instanceof ShapeCompartmentEditPart || element instanceof DiagramEditPart) {
				parentsSet.add((IGraphicalEditPart)element);
			} else if(element instanceof EditPart) {
				EditPart gEditPart = (EditPart)element;
				EditPart parentEditPart = gEditPart.getParent();
				if(parentEditPart instanceof ShapeCompartmentEditPart || parentEditPart instanceof DiagramEditPart) {
					if(!parentsSet.contains(parentEditPart))
						parentsSet.add((IGraphicalEditPart)parentEditPart);
				}
			}
		}
		if(parentsSet.isEmpty()) {
			return Collections.EMPTY_LIST;
		}
		List<IGraphicalEditPart> elements = new ArrayList<IGraphicalEditPart>();
		elements.addAll(parentsSet);
		return elements;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.diagram.menu.actions.AbstractParametricAction#getSelection()
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected List<IGraphicalEditPart> getSelection() {
		List<IGraphicalEditPart> selection = super.getSelection();

		if(ArrangeAction.ARRANGE_ALL.equals(getParameter())) {

			if(!selection.isEmpty()) {
				return createOperationSetForArrangeAll(selection);
			}
			if(getDiagramEditPart() != null) {
				return getDiagramEditPart().getChildren();
			}
			return Collections.EMPTY_LIST;

		} else {

			// this is the case of Arrange Selection
			if(selection.isEmpty() || !(selection.get(0) instanceof IGraphicalEditPart))
				return Collections.EMPTY_LIST;

			selection = ToolUtilities.getSelectionWithoutDependants(selection);
			return selection;
		}
	}
}
