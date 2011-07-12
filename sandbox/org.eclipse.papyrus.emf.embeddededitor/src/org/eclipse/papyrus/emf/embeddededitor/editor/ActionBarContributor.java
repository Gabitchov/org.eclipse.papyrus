/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.emf.embeddededitor.editor;

import org.eclipse.emf.ecore.presentation.EcoreActionBarContributor;
import org.eclipse.emf.ecore.presentation.EcoreEditorPlugin;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.action.CopyAction;
import org.eclipse.emf.edit.ui.action.CutAction;
import org.eclipse.emf.edit.ui.action.DeleteAction;
import org.eclipse.emf.edit.ui.action.PasteAction;
import org.eclipse.emf.edit.ui.action.RedoAction;
import org.eclipse.emf.edit.ui.action.UndoAction;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.papyrus.emf.embeddededitor.editor.actions.MoDiscoCopyAction;
import org.eclipse.papyrus.emf.embeddededitor.editor.actions.MoDiscoCutAction;
import org.eclipse.papyrus.emf.embeddededitor.editor.actions.MoDiscoDeleteAction;
import org.eclipse.papyrus.emf.embeddededitor.editor.actions.MoDiscoPasteAction;
import org.eclipse.papyrus.emf.embeddededitor.editor.actions.ValidationAction;
import org.eclipse.papyrus.newchild.runtime.NewchildManager;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

/**
 * The Action bar contributor for the Context Editor
 * Mainly serves as an Adapter for the Ecore actions, as the Ecore actions are
 * not natively compatible with the EMF Facet tree objects
 * 
 * @author Camille Letavernier
 */

//TODO : Remove the EcoreActionBarContributor extension
public class ActionBarContributor extends EcoreActionBarContributor {

	protected IStructuredSelection lastSelection;

	protected EditingDomain domain;

	public void init(EditingDomain domain, final TreeViewer viewer) {
		ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();

		deleteAction = createDeleteAction(domain);
		deleteAction.setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE));

		cutAction = createCutAction(domain);
		cutAction.setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_CUT));

		copyAction = createCopyAction(domain);
		copyAction.setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_COPY));

		pasteAction = createPasteAction(domain);
		pasteAction.setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_PASTE));

		undoAction = createUndoAction(domain);
		undoAction.setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_UNDO));

		redoAction = createRedoAction(domain);
		redoAction.setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_REDO));

		validateAction = new ValidationAction(domain);

		refreshViewerAction = new Action(EcoreEditorPlugin.INSTANCE.getString("_UI_RefreshViewer_menu_item")) {

			@Override
			public void run() {
				viewer.refresh();
			}
		};

		this.domain = domain;

		viewer.addSelectionChangedListener(this);
	}

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public ActionBarContributor() {
		super();
	}

	@Override
	public void menuAboutToShow(IMenuManager menuManager) {
		update();
		super.menuAboutToShow(menuManager);
		menuManager.insertBefore("edit", new Separator(NewchildManager.TOP)); //$NON-NLS-1$
		NewchildManager.instance.fillMenu(menuManager, lastSelection);
	}

	@Override
	public void update() {
		undoAction.update();
		redoAction.update();
		deleteAction.setEnabled(deleteAction.updateSelection(lastSelection));
		cutAction.setEnabled(cutAction.updateSelection(lastSelection));
		copyAction.setEnabled(copyAction.updateSelection(lastSelection));
		pasteAction.setEnabled(pasteAction.updateSelection(lastSelection));
		validateAction.setEnabled(validateAction.updateSelection(lastSelection));
	}

	protected DeleteAction createDeleteAction(EditingDomain domain) {
		return new MoDiscoDeleteAction(domain, removeAllReferencesOnDelete());
	}

	@Override
	protected boolean removeAllReferencesOnDelete() {
		return true;
	}

	protected CutAction createCutAction(EditingDomain domain) {
		return new MoDiscoCutAction(domain);
	}

	protected CopyAction createCopyAction(EditingDomain domain) {
		return new MoDiscoCopyAction(domain);
	}

	protected PasteAction createPasteAction(EditingDomain domain) {
		return new MoDiscoPasteAction(domain);
	}

	protected UndoAction createUndoAction(EditingDomain domain) {
		return new UndoAction(domain);
	}

	protected RedoAction createRedoAction(EditingDomain domain) {
		return new RedoAction(domain);
	}

	@Override
	public void selectionChanged(SelectionChangedEvent event) {
		if(event.getSelection() instanceof IStructuredSelection) {
			lastSelection = (IStructuredSelection)event.getSelection();
		}
	}

	@Override
	protected void addGlobalActions(IMenuManager menuManager) {
		menuManager.insertAfter("additions-end", new Separator("ui-actions"));
		refreshViewerAction.setEnabled(refreshViewerAction.isEnabled());
		menuManager.insertAfter("ui-actions", refreshViewerAction);

		String key = (style & ADDITIONS_LAST_STYLE) == 0 ? "additions-end" : "additions";
		if(validateAction != null) {
			menuManager.insertBefore(key, new ActionContributionItem(validateAction));
		}
	}

}
