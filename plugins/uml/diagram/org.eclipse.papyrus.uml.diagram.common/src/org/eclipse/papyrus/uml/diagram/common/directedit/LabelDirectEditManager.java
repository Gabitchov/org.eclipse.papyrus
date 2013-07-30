/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
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
package org.eclipse.papyrus.uml.diagram.common.directedit;

import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.part.CellEditorActionHandler;

/**
 * DirectEdit manager for label managed by a LabelControlerManager. It is
 * intended to be used in conjunction with LabelDirectEditPolicy and
 * LabelControler.
 */
public class LabelDirectEditManager extends DirectEditManager {

	/**
	 * 
	 */
	protected IActionBars actionBars;

	/**
	 * 
	 */
	protected CellEditorActionHandler actionHandler;

	/**
	 * 
	 */
	protected IAction copy, cut, paste, undo, redo, find, selectAll, delete;

	/**
	 * The label to be edited.
	 */
	protected ILabelControler labelCtrl;

	/**
	 * Constructor.
	 * 
	 * @param locator
	 * @param labelCtrl
	 *        The label to edit
	 * @param source
	 *        The EditPart owning the label.
	 */
	public LabelDirectEditManager(GraphicalEditPart source, CellEditorLocator locator, ILabelControler labelCtrl) {
		super(source, null, locator);
		this.labelCtrl = labelCtrl;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.tools.DirectEditManager#bringDown()
	 */
	/**
	 * 
	 */
	@Override
	protected void bringDown() {
		if(actionHandler != null) {
			actionHandler.dispose();
			actionHandler = null;
		}
		if(actionBars != null) {
			restoreSavedActions(actionBars);
			actionBars.updateActionBars();
			actionBars = null;
		}
		super.bringDown();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.gef.tools.DirectEditManager#createCellEditorOn(org.eclipse
	 * .swt.widgets.Composite)
	 */
	/**
	 * 
	 * 
	 * @param composite
	 * 
	 * @return
	 */
	@Override
	protected CellEditor createCellEditorOn(Composite composite) {
		return new TextCellEditor(composite, SWT.CENTER);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.tools.DirectEditManager#createDirectEditRequest()
	 */
	/**
	 * 
	 * 
	 * @return
	 */
	@Override
	protected DirectEditRequest createDirectEditRequest() {
		DirectEditRequest req = new DirectEditRequest();
		req.setCellEditor(getCellEditor());
		// Register the concerned label in the request.
		req.setDirectEditFeature(labelCtrl);
		return req;
	}

	/**
	 * Init the cell editor with the current value of the edited label.
	 */
	@Override
	protected void initCellEditor() {

		// set initial value for the cell editor
		getCellEditor().setValue(labelCtrl.getPropertyAccessor().getValue());
		getCellEditor().getControl().setFont(labelCtrl.getLabel().getFont());

		// Hook the cell editor's copy/paste actions to the actionBars so that
		// they can
		// be invoked via keyboard shortcuts.
		actionBars = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor().getEditorSite().getActionBars();
		saveCurrentActions(actionBars);
		actionHandler = new CellEditorActionHandler(actionBars);
		actionHandler.addCellEditor(getCellEditor());
		actionBars.updateActionBars();
	}

	/**
	 * 
	 * 
	 * @param actionBars
	 */
	private void restoreSavedActions(IActionBars actionBars) {
		actionBars.setGlobalActionHandler(ActionFactory.COPY.getId(), copy);
		actionBars.setGlobalActionHandler(ActionFactory.PASTE.getId(), paste);
		actionBars.setGlobalActionHandler(ActionFactory.DELETE.getId(), delete);
		actionBars.setGlobalActionHandler(ActionFactory.SELECT_ALL.getId(), selectAll);
		actionBars.setGlobalActionHandler(ActionFactory.CUT.getId(), cut);
		actionBars.setGlobalActionHandler(ActionFactory.FIND.getId(), find);
		actionBars.setGlobalActionHandler(ActionFactory.UNDO.getId(), undo);
		actionBars.setGlobalActionHandler(ActionFactory.REDO.getId(), redo);
	}

	/**
	 * 
	 * 
	 * @param actionBars
	 */
	private void saveCurrentActions(IActionBars actionBars) {
		copy = actionBars.getGlobalActionHandler(ActionFactory.COPY.getId());
		paste = actionBars.getGlobalActionHandler(ActionFactory.PASTE.getId());
		delete = actionBars.getGlobalActionHandler(ActionFactory.DELETE.getId());
		selectAll = actionBars.getGlobalActionHandler(ActionFactory.SELECT_ALL.getId());
		cut = actionBars.getGlobalActionHandler(ActionFactory.CUT.getId());
		find = actionBars.getGlobalActionHandler(ActionFactory.FIND.getId());
		undo = actionBars.getGlobalActionHandler(ActionFactory.UNDO.getId());
		redo = actionBars.getGlobalActionHandler(ActionFactory.REDO.getId());
	}

}
