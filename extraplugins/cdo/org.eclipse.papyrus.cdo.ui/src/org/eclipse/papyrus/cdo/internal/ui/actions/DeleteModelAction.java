/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.cdo.internal.ui.actions;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.cdo.internal.core.CDOUtils;
import org.eclipse.papyrus.cdo.internal.ui.editors.PapyrusCDOEditorInput;
import org.eclipse.papyrus.cdo.internal.ui.l10n.Messages;
import org.eclipse.papyrus.cdo.internal.ui.views.DIModel;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchCommandConstants;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;

import com.google.common.collect.Lists;

/**
 * This is the DeleteModelAction type. Enjoy.
 */
public class DeleteModelAction extends AsyncEditAction<DIModel> {

	private final IWorkbenchPart part;

	public DeleteModelAction(IWorkbenchPart part) {
		super(DIModel.class, Messages.DeleteModelAction_0, ImageDescriptor.createFromImage(part.getSite().getWorkbenchWindow().getWorkbench().getSharedImages().getImage(ISharedImages.IMG_TOOL_DELETE)));

		this.part = part;

		setActionDefinitionId(IWorkbenchCommandConstants.EDIT_DELETE);
	}

	@Override
	protected CDOView getView(DIModel selection) {
		return selection.getResource().cdoView();
	}

	@Override
	protected boolean gatherInput(DIModel selection) {
		boolean result = false;

		if(MessageDialog.openQuestion(part.getSite().getShell(), Messages.DeleteModelAction_1, NLS.bind(Messages.DeleteModelAction_2, selection.getName()))) {

			IWorkbenchPage page = part.getSite().getPage();
			URI uri = selection.getResource().getURI();
			PapyrusCDOEditorInput input = new PapyrusCDOEditorInput(uri);
			IEditorPart openEditor = page.findEditor(input);
			if(openEditor != null) {
				page.closeEditor(openEditor, false);
			}

			result = true;
		}

		return result;
	}

	@Override
	protected void doRun(DIModel selection, CDOTransaction transaction, IProgressMonitor monitor) throws CoreException {

		List<IStatus> failures = Lists.newArrayListWithExpectedSize(1);
		for(Object next : selection.getChildren()) {
			if(next instanceof CDOResource) {
				// get the resource local to this transaction

				CDOID oid = ((CDOResource)next).cdoID();
				CDOResource toDelete = (CDOResource)transaction.getObject(oid);
				if(toDelete != null) {
					try {
						toDelete.delete(null);
					} catch (Exception e) {
						failures.add(error("Failed to delete resource " + toDelete.getPath(), e)); //$NON-NLS-1$
					}
				}
			}
		}

		if(!failures.isEmpty()) {
			throw new CoreException(wrap(failures, "Errors occurred in deleting model.")); //$NON-NLS-1$
		}
	}

	@Override
	protected boolean updateSelection(IStructuredSelection selection) {
		boolean result = super.updateSelection(selection);

		if(result) {
			// must also be able to modify the containing folder/resource
			CDOObject toDelete = getSelectedCDOObject();
			EObject container = toDelete.eContainer();
			if(container != null) {
				CDOObject cdoContainer = CDOUtils.getCDOObject(container);
				result = (cdoContainer == null) || cdoContainer.cdoPermission().isWritable();
			}
		}

		return result;
	}
}
