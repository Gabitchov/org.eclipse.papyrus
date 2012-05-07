/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.compare.ui.content.transactional.viewer;


import java.util.List;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.ui.actions.RedoActionWrapper;
import org.eclipse.emf.workspace.ui.actions.UndoActionWrapper;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.emf.compare.ui.Activator;
import org.eclipse.papyrus.infra.emf.compare.ui.content.viewer.PapyrusCustomizableModelContentMergeViewer;
import org.eclipse.papyrus.infra.emf.compare.ui.messages.Messages;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.builders.NotificationBuilder;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

/**
 * 
 * This viewer adds the Undo/Redo after a merge action
 * 
 * 
 */
public class PapyrusTransactionalModelContentMergeViewer extends PapyrusCustomizableModelContentMergeViewer {

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parent
	 * @param config
	 */
	public PapyrusTransactionalModelContentMergeViewer(final Composite parent, final CompareConfiguration config, final IEditorPart editor) {
		super(parent, config, editor);
	}

	/**
	 * Undoes the changes implied by the currently selected {@link DiffElement diff}.
	 */
	@Override
	protected void copyDiffLeftToRight() {
		if(this.currentSelection != null) {
			doCopy(this.currentSelection, true);
		}
		this.currentSelection.clear();
		switchCopyState(false);
	}

	/**
	 * Applies the changes implied by the currently selected {@link DiffElement diff}.
	 */
	@Override
	protected void copyDiffRightToLeft() {
		if(this.currentSelection != null) {
			doCopy(this.currentSelection, false);
		}
		this.currentSelection.clear();
		switchCopyState(false);
	}


	protected void doCopy(final List<DiffElement> diffs, final boolean leftToRight) {
		//TODO : use the service registery when it is possible
		TransactionalEditingDomain domain = null;
		IEditorPart editorPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		ServicesRegistry servicesRegistry = (ServicesRegistry)editorPart.getAdapter(ServicesRegistry.class);
		if(servicesRegistry != null) {
			try {
				domain = servicesRegistry.getService(TransactionalEditingDomain.class);
			} catch (ServiceException e) {
				Activator.log.error(e);
			}
		} else if(editorPart instanceof IEditingDomainProvider) {
			domain = (TransactionalEditingDomain)((IEditingDomainProvider)editorPart).getEditingDomain();
		}
		if(domain != null) {
			Command command = new GMFtoEMFCommandWrapper(new AbstractTransactionalCommand(domain, Messages.PapyrusTransactionalModelContentMergeViewer_MergeCommandLabel, null) {

				@Override
				protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
					PapyrusTransactionalModelContentMergeViewer.this.copy(diffs, leftToRight);
					return null;
				}
			});
			domain.getCommandStack().execute(command);
		} else {
			NotificationBuilder.createAsyncPopup(Messages.PapyrusTransactionalModelContentMergeViewer_TheCurrentEditorDontAllowToUseUndoRedo).run();
			PapyrusTransactionalModelContentMergeViewer.this.copy(diffs, leftToRight);
		}
	}

	/**
	 * 
	 * {@inheritDoc} Add a toogle button to the toolbar to do the synchronization with the diagram
	 * 
	 * @param tbm
	 *        the toolbar manager
	 */
	@Override
	protected void createToolItems(final ToolBarManager tbm) {
		super.createToolItems(tbm);
		final UndoActionWrapper undoAction = new UndoActionWrapper();
		final RedoActionWrapper redoAction = new RedoActionWrapper();

		//we need that the editor will be created to get it and initialize the actions
		Display.getCurrent().asyncExec(new Runnable() {

			public void run() {
				IEditorPart editorPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
				undoAction.setActiveWorkbenchPart(editorPart);
				redoAction.setActiveWorkbenchPart(editorPart);
			}
		});

		ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();
		undoAction.setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_UNDO));
		redoAction.setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_REDO));

		tbm.insert(0, new ActionContributionItem(undoAction));
		tbm.insert(1, new ActionContributionItem(redoAction));

		tbm.insert(2, new Separator("undo_redo_group")); //$NON-NLS-1$

	}
}
