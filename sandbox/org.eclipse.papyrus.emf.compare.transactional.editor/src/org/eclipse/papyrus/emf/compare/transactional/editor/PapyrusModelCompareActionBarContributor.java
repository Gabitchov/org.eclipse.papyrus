/**
 * <copyright>
 * 
 * Copyright (c) 2008-2010 See4sys and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *     See4sys - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.papyrus.emf.compare.transactional.editor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.commands.operations.IOperationHistoryListener;
import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.commands.operations.OperationHistoryEvent;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.ui.action.EditingDomainActionBarContributor;
import org.eclipse.emf.edit.ui.action.RedoAction;
import org.eclipse.emf.edit.ui.action.UndoAction;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.IWorkspaceCommandStack;
import org.eclipse.emf.workspace.ResourceUndoContext;
import org.eclipse.emf.workspace.ui.actions.RedoActionWrapper;
import org.eclipse.emf.workspace.ui.actions.UndoActionWrapper;
import org.eclipse.papyrus.emf.compare.transactional.editor.sphinx.WorkspaceEditingDomainUtil;
import org.eclipse.sphinx.emf.compare.ui.editor.ModelCompareEditor;
import org.eclipse.sphinx.emf.workspace.domain.WorkspaceEditingDomainManager;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorActionBarContributor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;

/**
 * An implementation of {@linkplain IEditorActionBarContributor action bar contributor} that is dedicated to
 * {@linkplain ModelCompareEditor model compare editor}s.
 * <p>
 * Brings support for undo/redo actions.
 */
public class PapyrusModelCompareActionBarContributor extends EditingDomainActionBarContributor {

	/**
	 * The {@linkplain IOperationHistoryListener operation history listener} responsible for setting editing domain on
	 * <em>undo</em>/<em>redo</em> actions as soon as an operation (on the command stack of that precise editing domain)
	 * has been finished.
	 */
	protected IOperationHistoryListener historyListener;

	/**
	 * Default constructor that creates a new instance of this contributor.
	 */
	public PapyrusModelCompareActionBarContributor() {
		super(ADDITIONS_LAST_STYLE);
	}

	/**
	 * Creates the {@linkplain IOperationHistoryListener operation history listener} that is responsible for setting
	 * editing domain on <em>undo</em>/<em>redo</em> actions as soon as an operation (on the command stack of that
	 * precise editing domain) has been finished.
	 * 
	 * @return The {@linkplain IOperationHistoryListener operation history listener} to add on the concerned editing
	 *         domain's command stack.
	 */
	protected IOperationHistoryListener createOperationHistoryListener() {
		return new IOperationHistoryListener() {
			public void historyNotification(OperationHistoryEvent event) {
				if (event.getEventType() == OperationHistoryEvent.DONE || event.getEventType() == OperationHistoryEvent.UNDONE
						|| event.getEventType() == OperationHistoryEvent.REDONE) {
					IUndoContext[] contexts = event.getOperation().getContexts();
					for (IUndoContext context : contexts) {
						if (PapyrusCompareEditor.ID.equals(context.getLabel())) {
							Set<Resource> affectedResources = ResourceUndoContext.getAffectedResources(event.getOperation());
							TransactionalEditingDomain editingDomain = null;
							for (Resource resource : affectedResources) {
								TransactionalEditingDomain domain = WorkspaceEditingDomainUtil.getEditingDomain(resource);
								if (editingDomain != null && editingDomain != domain) {
									//
									// !! Important Note !!
									// For the moment, the case where two elements from different editing domain are
									// compared is not really supported because we do not know very well the expected
									// behavior of such a kind of comparison.
									//
									UnsupportedOperationException ex = new UnsupportedOperationException("Several editing domains"); //$NON-NLS-1$
									//PlatformLogUtil.logAsWarning(Activator.getPlugin(), ex);
									Activator.log.error(ex);
									editingDomain = null;
									break;
								} else {
									editingDomain = domain;
								}
							}
							if (editingDomain != null) {
								// Set editing domain on Undo/Redo actions
								if (undoAction != null) {
									undoAction.setEditingDomain(editingDomain);
								}
								if (redoAction != null) {
									redoAction.setEditingDomain(editingDomain);
								}
							}
							break;
						}
					}
				}
			}
		};
	}

	@Override
	public void init(IActionBars actionBars) {
		super.init(actionBars);

		historyListener = createOperationHistoryListener();

		ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();

		// Override the superclass implementation of these actions
		undoAction = createUndoAction();
		undoAction.setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_UNDO));
		actionBars.setGlobalActionHandler(ActionFactory.UNDO.getId(), undoAction);

		redoAction = createRedoAction();
		redoAction.setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_REDO));
		actionBars.setGlobalActionHandler(ActionFactory.REDO.getId(), redoAction);
	}

	/**
	 * Returns the {@linkplain RedoAction} this action bar contributor must provide. Default implementation creates a
	 * new instance of {@linkplain RedoActionWrapper}; clients may override this method in order to create another kind
	 * of action instead.
	 * 
	 * @return The {@linkplain RedoAction} this action bar contributor must provide.
	 */
	// FIXME Uncomment @Override once we don't need to support Eclipse 3.5 any longer
	// @Override
	protected RedoAction createRedoAction() {
		return new RedoActionWrapper();
	}

	/**
	 * Returns the {@linkplain UndoAction} this action bar contributor must provide. Default implementation creates a
	 * new instance of {@linkplain UndoActionWrapper}; clients may override this method in order to create another kind
	 * of action instead.
	 * 
	 * @return The {@linkplain UndoAction} this action bar contributor must provide.
	 */
	// FIXME Uncomment @Override once we don't need to support Eclipse 3.5 any longer
	// @Override
	protected UndoAction createUndoAction() {
		return new UndoActionWrapper();
	}

	@Override
	public void setActiveEditor(IEditorPart part) {
		if (part != activeEditor) {
			if (activeEditor != null) {
				deactivate();
			}
			if (part instanceof PapyrusCompareEditor) {
				activeEditor = part;
				activate();
			}
		}
	}

	@Override
	public void dispose() {
		super.dispose();

		if (historyListener != null) {
			List<TransactionalEditingDomain> editingDomains = WorkspaceEditingDomainManager.INSTANCE.getEditingDomainMapping().getEditingDomains();
			for (TransactionalEditingDomain editingDomain : editingDomains) {
				((IWorkspaceCommandStack) editingDomain.getCommandStack()).getOperationHistory().removeOperationHistoryListener(historyListener);
			}
		}
		historyListener = null;
	}

	@Override
	public void deactivate() {
		activeEditor.removePropertyListener(this);

		undoAction.setActiveWorkbenchPart(null);
		redoAction.setActiveWorkbenchPart(null);
	}

	/**
	 * @return The {@linkplain TransactionalEditingDomain editing domain}s of the objects being compared (retrieves them
	 *         directly from {@linkplain ModelCompareEditor}).
	 */
	protected Set<TransactionalEditingDomain> getEditingDomainsFromCompareEditor() {
		Set<TransactionalEditingDomain> editingDomains = new HashSet<TransactionalEditingDomain>();
		for (TransactionalEditingDomain editingDomain : ((PapyrusCompareEditor) activeEditor).getEditingDomains()) {
			if (editingDomain != null) {
				editingDomains.add(editingDomain);
			}
		}
		return editingDomains;
	}

	@Override
	public void activate() {
		if (historyListener != null) {
			for (TransactionalEditingDomain editingDomain : getEditingDomainsFromCompareEditor()) {
				((IWorkspaceCommandStack) editingDomain.getCommandStack()).getOperationHistory().addOperationHistoryListener(historyListener);
			}
		}

		activeEditor.addPropertyListener(this);

		undoAction.setActiveWorkbenchPart(activeEditor);
		redoAction.setActiveWorkbenchPart(activeEditor);

		update();
	}

	@Override
	public void update() {
		undoAction.update();
		redoAction.update();
	}
}
