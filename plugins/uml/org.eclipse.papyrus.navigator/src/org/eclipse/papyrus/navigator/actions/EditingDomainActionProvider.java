/*******************************************************************************
 * Copyright (c) 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.navigator.actions;

import org.eclipse.emf.edit.ui.action.CopyAction;
import org.eclipse.emf.edit.ui.action.CutAction;
import org.eclipse.emf.edit.ui.action.DeleteAction;
import org.eclipse.emf.edit.ui.action.LoadResourceAction;
import org.eclipse.emf.edit.ui.action.PasteAction;
import org.eclipse.emf.edit.ui.action.RedoAction;
import org.eclipse.emf.edit.ui.action.UndoAction;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.navigator.internal.utils.NavigatorUtils;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.navigator.CommonNavigator;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;

/**
 * Provider used to create actions applicable on semantic elements
 * 
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class EditingDomainActionProvider extends AbstractSubmenuActionProvider {

	protected DeleteAction deleteAction;

	protected CutAction cutAction;

	protected CopyAction copyAction;

	protected PasteAction pasteAction;

	protected UndoAction undoAction;

	protected RedoAction redoAction;

	protected LoadResourceAction loadResourceAction;

	// protected ControlAction controlAction;

	// protected ValidateAction validateAction;

	CommonNavigator activeViewPart;

	@Override
	public void init(ICommonActionExtensionSite site) {
		super.init(site);
		this.activeViewPart = getCommonNavigator();

		ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();
		TransactionalEditingDomain editingDomain = NavigatorUtils.getTransactionalEditingDomain();

		// Create Delete action
		this.deleteAction = new DeleteAction(editingDomain, true);
		this.deleteAction.setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE));
		this.deleteAction.setDisabledImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE_DISABLED));

		// Create Copy action
		this.copyAction = new CopyAction(editingDomain);
		this.copyAction.setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_COPY));

		// Create Cut action
		this.cutAction = new CutAction(editingDomain);
		this.cutAction.setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_CUT));

		// Create Paste action
		this.pasteAction = new PasteAction(editingDomain);
		this.pasteAction.setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_PASTE));

		// Undo action
		this.undoAction = new UndoAction();
		this.undoAction.setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_UNDO));

		// Redo action
		this.redoAction = new RedoAction();
		this.redoAction.setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_REDO));

		// Load Resource action
		this.loadResourceAction = new LoadResourceAction(editingDomain);
	}

	@Override
	public void fillActionBars(IActionBars actionBars) {
		super.fillActionBars(actionBars);
		actionBars.setGlobalActionHandler(ActionFactory.DELETE.getId(), deleteAction);
		actionBars.setGlobalActionHandler(ActionFactory.CUT.getId(), cutAction);
		actionBars.setGlobalActionHandler(ActionFactory.COPY.getId(), copyAction);
		actionBars.setGlobalActionHandler(ActionFactory.PASTE.getId(), pasteAction);
		actionBars.setGlobalActionHandler(ActionFactory.UNDO.getId(), undoAction);
		actionBars.setGlobalActionHandler(ActionFactory.REDO.getId(), redoAction);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void fillContextMenu(IMenuManager menu) {
		update();
		// Add the edit menu actions.
		menu.add(new Separator());
		menu.add(new ActionContributionItem(cutAction));
		menu.add(new ActionContributionItem(copyAction));
		menu.add(new ActionContributionItem(pasteAction));;
		menu.add(new ActionContributionItem(deleteAction));
		menu.add(new Separator());
		menu.add(new ActionContributionItem(undoAction));
		menu.add(new ActionContributionItem(redoAction));
		menu.add(new Separator());
		menu.add(new ActionContributionItem(loadResourceAction));
		menu.add(new Separator());
		// Activate
		activate();
	}

	public void update() {
		ISelection selection = getCommonNavigator().getCommonViewer().getSelection();
		IStructuredSelection structuredSelection = selection instanceof IStructuredSelection ? (IStructuredSelection) selection : StructuredSelection.EMPTY;

		deleteAction.updateSelection(structuredSelection);
		cutAction.updateSelection(structuredSelection);
		copyAction.updateSelection(structuredSelection);
		pasteAction.updateSelection(structuredSelection);
		// validateAction.updateSelection(structuredSelection);
		// controlAction.updateSelection(structuredSelection);
		TransactionalEditingDomain domain = NavigatorUtils.getTransactionalEditingDomain();
		loadResourceAction.setEditingDomain(domain);
		loadResourceAction.update();
	}

	public void activate() {
		deleteAction.setActiveWorkbenchPart(activeViewPart);
		cutAction.setActiveWorkbenchPart(activeViewPart);
		copyAction.setActiveWorkbenchPart(activeViewPart);
		pasteAction.setActiveWorkbenchPart(activeViewPart);
		undoAction.setActiveWorkbenchPart(activeViewPart);
		redoAction.setActiveWorkbenchPart(activeViewPart);
		loadResourceAction.setActiveWorkbenchPart(activeViewPart);
		// controlAction.setActiveWorkbenchPart(activeViewPart);
		// validateAction.setActiveWorkbenchPart(activeViewPart);

		ISelectionProvider selectionProvider = activeViewPart.getCommonViewer() instanceof ISelectionProvider ? (ISelectionProvider) activeViewPart.getCommonViewer() : null;

		if (selectionProvider != null) {
			selectionProvider.addSelectionChangedListener(deleteAction);
			selectionProvider.addSelectionChangedListener(cutAction);
			selectionProvider.addSelectionChangedListener(copyAction);
			selectionProvider.addSelectionChangedListener(pasteAction);
			// selectionProvider.addSelectionChangedListener(validateAction);
			// selectionProvider.addSelectionChangedListener(controlAction);
		}
		update();
	}

	/**
	 * Deactivate.
	 */
	public void deactivate() {
		deleteAction.setActiveWorkbenchPart(null);
		cutAction.setActiveWorkbenchPart(null);
		copyAction.setActiveWorkbenchPart(null);
		pasteAction.setActiveWorkbenchPart(null);
		undoAction.setActiveWorkbenchPart(null);
		redoAction.setActiveWorkbenchPart(null);
		loadResourceAction.setActiveWorkbenchPart(null);
		// controlAction.setActiveWorkbenchPart(null);
		// validateAction.setActiveWorkbenchPart(null);

		ISelectionProvider selectionProvider = activeViewPart.getCommonViewer() instanceof ISelectionProvider ? (ISelectionProvider) activeViewPart.getCommonViewer() : null;

		if (selectionProvider != null) {
			selectionProvider.removeSelectionChangedListener(deleteAction);
			selectionProvider.removeSelectionChangedListener(cutAction);
			selectionProvider.removeSelectionChangedListener(copyAction);
			selectionProvider.removeSelectionChangedListener(pasteAction);
			// selectionProvider.removeSelectionChangedListener(validateAction);
			// selectionProvider.removeSelectionChangedListener(controlAction);
		}
	}

	/**
	 * @see org.eclipse.ui.actions.ActionGroup#updateActionBars()
	 */
	@Override
	public void updateActionBars() {
		super.updateActionBars();
		activate();
		update();
	}

}
