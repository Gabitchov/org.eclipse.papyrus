/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
  *****************************************************************************/
package org.eclipse.papyrus.navigator.factory;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.action.CopyAction;
import org.eclipse.emf.edit.ui.action.CutAction;
import org.eclipse.emf.edit.ui.action.DeleteAction;
import org.eclipse.emf.edit.ui.action.LoadResourceAction;
import org.eclipse.emf.edit.ui.action.PasteAction;
import org.eclipse.emf.edit.ui.action.RedoAction;
import org.eclipse.emf.edit.ui.action.UndoAction;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.navigator.CommonNavigator;


/**
 * The Class DefaultEMFActionsFactory for creating a default action from EMF. 
 * Undefined actions are not still in use or might be overridden
 * 
 * @author Emilien Perico
 */
public class DefaultEMFActionsFactory implements IActionHandlerFactory {
	
	protected List<Action> actions = new LinkedList<Action>();

	protected DeleteAction deleteAction;

	protected CutAction cutAction;

	protected CopyAction copyAction;

	protected PasteAction pasteAction;

	protected UndoAction undoAction;

	protected RedoAction redoAction;
	
	protected LoadResourceAction loadResourceAction;
	
	//protected ValidateAction validateAction;
	
	/**
	 * {@inheritDoc}
	 */
	public List<Action> createActions(EditingDomain editingDomain) {
		ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();
		
		// Create Cut action
		this.cutAction = new CutAction(editingDomain);
		this.cutAction.setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_CUT));
		actions.add(cutAction);
		
		// Create Copy action
		this.copyAction = new CopyAction(editingDomain);
		this.copyAction.setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_COPY));
		actions.add(copyAction);
		
		// Create Paste action
		this.pasteAction = new PasteAction(editingDomain);
		this.pasteAction.setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_PASTE));
		actions.add(pasteAction);

		// Create Delete action
		this.deleteAction = new DeleteAction(editingDomain, true);
		this.deleteAction.setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE));
		this.deleteAction.setDisabledImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE_DISABLED));
		actions.add(deleteAction);

		// Undo action
		this.undoAction = new UndoAction();
		this.undoAction.setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_UNDO));
		actions.add(undoAction);

		// Redo action
		this.redoAction = new RedoAction();
		this.redoAction.setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_REDO));
		actions.add(redoAction);
		
		// Load Resource action
		this.loadResourceAction = new LoadResourceAction(editingDomain);
		actions.add(loadResourceAction);
		
		return actions;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void activate(CommonNavigator activeViewPart) {		
		deleteAction.setActiveWorkbenchPart(activeViewPart);
		cutAction.setActiveWorkbenchPart(activeViewPart);
		copyAction.setActiveWorkbenchPart(activeViewPart);
		pasteAction.setActiveWorkbenchPart(activeViewPart);
		undoAction.setActiveWorkbenchPart(activeViewPart);
		redoAction.setActiveWorkbenchPart(activeViewPart);
		loadResourceAction.setActiveWorkbenchPart(activeViewPart);
		
		ISelectionProvider selectionProvider = null;
		if (activeViewPart.getCommonViewer() instanceof ISelectionProvider) {
			selectionProvider = activeViewPart.getCommonViewer();
			selectionProvider.addSelectionChangedListener(deleteAction);
			selectionProvider.addSelectionChangedListener(cutAction);
			selectionProvider.addSelectionChangedListener(copyAction);
			selectionProvider.addSelectionChangedListener(pasteAction);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void deactivate(CommonNavigator activeViewPart) {
		deleteAction.setActiveWorkbenchPart(null);
		cutAction.setActiveWorkbenchPart(null);
		copyAction.setActiveWorkbenchPart(null);
		pasteAction.setActiveWorkbenchPart(null);
		undoAction.setActiveWorkbenchPart(null);
		redoAction.setActiveWorkbenchPart(null);
		loadResourceAction.setActiveWorkbenchPart(null);
		
		ISelectionProvider selectionProvider = null;
		if (activeViewPart.getCommonViewer() instanceof ISelectionProvider) {
			selectionProvider = activeViewPart.getCommonViewer();
			selectionProvider.removeSelectionChangedListener(deleteAction);
			selectionProvider.removeSelectionChangedListener(cutAction);
			selectionProvider.removeSelectionChangedListener(copyAction);
			selectionProvider.removeSelectionChangedListener(pasteAction);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void fillActionBars(IActionBars actionBars) {
		actionBars.setGlobalActionHandler(ActionFactory.DELETE.getId(),	deleteAction);
		actionBars.setGlobalActionHandler(ActionFactory.CUT.getId(), cutAction);
		actionBars.setGlobalActionHandler(ActionFactory.COPY.getId(), copyAction);
		actionBars.setGlobalActionHandler(ActionFactory.PASTE.getId(), pasteAction);
		actionBars.setGlobalActionHandler(ActionFactory.UNDO.getId(), undoAction);
		actionBars.setGlobalActionHandler(ActionFactory.REDO.getId(), redoAction);
	}

	/**
	 * {@inheritDoc}
	 */
	public void update(IStructuredSelection structuredSelection) {
		deleteAction.updateSelection(structuredSelection);
		cutAction.updateSelection(structuredSelection);
		copyAction.updateSelection(structuredSelection);
		pasteAction.updateSelection(structuredSelection);
		loadResourceAction.update();
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Action> getActions() {
		return actions;
	}

}
