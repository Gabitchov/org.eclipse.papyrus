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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.diagram.ui.actions.internal.SelectAllAction;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GroupEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IPrimaryEditPart;
import org.eclipse.gmf.runtime.diagram.ui.internal.editparts.ISurfaceEditPart;
import org.eclipse.jface.viewers.StructuredSelection;

/**
 * Adapted from {@link SelectAllAction}
 * 
 * 
 * 
 */
public class SelectAction extends AbstractParametricAction {

	/** parameters for the action */
	public static final String SELECT_ALL = "selectAll"; //$NON-NLS-1$

	public static final String SELECT_ALL_SHAPES = "selectAllShapes"; //$NON-NLS-1$

	public static final String SELECT_ALL_CONNECTORS = "selectAllConnectors"; //$NON-NLS-1$

	/**
	 * this value indicates if we select the shapes or not
	 */
	protected boolean selectShapes = false;

	/**
	 * this value indicates if we select the connections or not
	 */
	protected boolean selectConnections = false;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parameter
	 */
	public SelectAction(String parameter, List<IGraphicalEditPart> selectedElements) {
		super(parameter, selectedElements);
		initAction();
	}

	protected void initAction() {
		if(SELECT_ALL.equals(getParameter())) {
			this.selectShapes = true;
			this.selectConnections = true;
		} else if(SELECT_ALL_SHAPES.equals(getParameter())) {
			this.selectShapes = true;
		} else if(SELECT_ALL_CONNECTORS.equals(getParameter())) {
			this.selectConnections = true;
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
		return !getSelection().isEmpty();
	}

	@Override
	public void doRun(IProgressMonitor progressMonitor) {
		getDiagramGraphicalViewer().setSelection(new StructuredSelection(createOperationSet()));
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.diagram.menu.actions.AbstractParametricAction#getSelection()
	 * 
	 * @return
	 */
	@Override
	protected List<IGraphicalEditPart> getSelection() {
		// TODO Auto-generated method stub
		return super.getSelection();
	}

	/**
	 * The operation set is the shapes, connections or both on the diagram edit part
	 */
	protected List createOperationSet() {
		List selection = getSelection();
		if(selection.isEmpty() || !(selection.get(0) instanceof IGraphicalEditPart))
			return Collections.EMPTY_LIST;

		List selectables = new ArrayList();

		EditPart primaryEP = (EditPart)selection.get(selection.size() - 1);
		List nodeEditParts = new ArrayList();
		nodeEditParts.addAll(getSelectableNodes(primaryEP));

		if(selectShapes)
			selectables.addAll(nodeEditParts);
		if(selectConnections)
			selectables.addAll(addSelectableConnections(nodeEditParts));
		return filterEditPartsMatching(selectables, getSelectionConditional());
	}

	/**
	 * Determines the candidate list of node editparts for selection
	 * 
	 * @param editpart
	 * @return
	 */
	protected List getSelectableNodes(EditPart editpart) {
		if(editpart == null) {
			return Collections.EMPTY_LIST;
		}

		List retval = new ArrayList();
		getSelectableNodesInside(editpart, true, retval);
		return retval;
	}

	/**
	 * Determines the candidate list of node editparts for selection
	 * 
	 * @param editpart
	 * @param topLevel
	 *        <code>boolean</code> is this the initial entry point into the recursive method.
	 * @param retval
	 *        <code>List</code> to modify
	 */
	private void getSelectableNodesInside(EditPart editpart, boolean topLevel, List retval) {

		if(editpart instanceof ISurfaceEditPart) {
			getSelectableChildrenNodes(editpart, retval);
		} else if(editpart instanceof IPrimaryEditPart) {
			if(topLevel) {
				if(editpart instanceof ConnectionEditPart) {
					ConnectionEditPart connection = (ConnectionEditPart)editpart;
					EditPart source = connection.getSource();
					EditPart target = connection.getTarget();
					if(source != null && target != null) {
						getSelectableNodesInside(source, true, retval);
						if(target.getParent() != source.getParent())
							getSelectableNodesInside(target, true, retval);
					}
				} else
					getSelectableNodesInside(editpart.getParent(), true, retval);
			} else {
				if(editpart.isSelectable())
					retval.add(editpart);

				// Do not dig into groups -- just select the group, but not the
				// shapes inside.
				if(!(editpart instanceof GroupEditPart)) {
					getSelectableChildrenNodes(editpart, retval);
				}
			}
		}
	}

	/**
	 * 
	 * @param editpart
	 *        an editpart
	 * @param retval
	 *        the selectable node inside this editpart
	 */
	private void getSelectableChildrenNodes(EditPart editpart, List retval) {
		Iterator iter = editpart.getChildren().iterator();
		while(iter.hasNext()) {
			EditPart child = (EditPart)iter.next();
			getSelectableNodesInside(child, false, retval);
		}
	}

	/**
	 * This method searches an edit part for a child that is a border item edit part
	 * 
	 * @param parent
	 *        part needed to search
	 * @param set
	 *        to be modified of border item edit parts that are direct children of the parent
	 */
	private void getBorderItemEditParts(EditPart parent, Set retval) {

		Iterator iter = parent.getChildren().iterator();
		while(iter.hasNext()) {
			EditPart child = (EditPart)iter.next();
			if(child instanceof IBorderItemEditPart) {
				retval.add(child);
				retval.addAll(child.getChildren());
			}
			getBorderItemEditParts(child, retval);
		}
	}

	/**
	 * Determines the candidate list of connection edit for selection
	 * A connection is included if atleast the source or the target is
	 * included in the given list
	 * 
	 * @param editparts
	 */
	protected List addSelectableConnections(List editparts) {
		List selectableConnections = new ArrayList();

		DiagramEditPart diagramEditPart = getDiagramEditPart();
		Set connnectableEditParts = new HashSet(editparts);
		ListIterator li = editparts.listIterator();
		while(li.hasNext()) {
			EditPart ep = (EditPart)li.next();
			getBorderItemEditParts(ep, connnectableEditParts);
			if(ep instanceof GroupEditPart) {
				connnectableEditParts.addAll(((GroupEditPart)ep).getShapeChildren());
			}
		}

		if(diagramEditPart != null) {
			Iterator connections = diagramEditPart.getConnections().iterator();
			while(connections.hasNext()) {
				ConnectionEditPart connection = (ConnectionEditPart)connections.next();
				if(canSelectConnection(connection, connnectableEditParts))
					selectableConnections.add(connection);
			}
		}
		return selectableConnections;
	}

	/**
	 * Determines whether the given connection can be selected. First checks
	 * whether the source or target of the connection is in the given
	 * connetableEditPart list. If it isn't it checks recursively whether the source
	 * or target of the connection is another connection and if that connection's
	 * source or target is in the given connectableEditPart list. This is in
	 * response to Bugzilla #162083.
	 * 
	 * @param connection
	 *        connection to check
	 * @param connectableEditParts
	 */
	private boolean canSelectConnection(ConnectionEditPart connection, Set connectableEditParts) {
		EditPart connectionSource = connection.getSource();
		EditPart connectionTarget = connection.getTarget();
		boolean sourceHasSelectable = false;
		boolean targetHasSelectable = false;

		if(connectableEditParts.contains(connectionSource) || connectableEditParts.contains(connectionTarget))
			return true;

		if(connectionSource instanceof ConnectionEditPart)
			sourceHasSelectable = canSelectConnection((ConnectionEditPart)connectionSource, connectableEditParts);

		if(!sourceHasSelectable && connectionTarget instanceof ConnectionEditPart)
			targetHasSelectable = canSelectConnection((ConnectionEditPart)connectionTarget, connectableEditParts);

		return sourceHasSelectable || targetHasSelectable;
	}

	/**
	 * @return The Selection Conditional which tests if the editpart is selectable
	 */
	protected EditPartViewer.Conditional getSelectionConditional() {
		return new EditPartViewer.Conditional() {

			public boolean evaluate(EditPart editpart) {
				return editpart.isSelectable();
			}
		};
	}

	/**
	 * Filters the given list of EditParts so that the list only contains the
	 * EditParts that matches the given condition.
	 * 
	 * @param list
	 *        the list of edit parts to filter
	 * @param condition
	 *        the condition
	 * @return a modified list containing those editparts that matched the
	 *         condition
	 */
	protected List filterEditPartsMatching(List list, EditPartViewer.Conditional condition) {
		List matchList = new ArrayList();
		Iterator iter = list.iterator();
		while(iter.hasNext()) {
			EditPart ep = (EditPart)iter.next();
			if(condition.evaluate(ep))
				matchList.add(ep);
		}
		return matchList;
	}

}
