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

import java.util.Collections;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.eresource.CDOResourceFolder;
import org.eclipse.emf.cdo.eresource.CDOResourceNode;
import org.eclipse.emf.cdo.eresource.EresourceFactory;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.cdo.internal.core.IInternalPapyrusRepository;
import org.eclipse.papyrus.cdo.internal.ui.Activator;
import org.eclipse.papyrus.cdo.internal.ui.l10n.Messages;
import org.eclipse.ui.IWorkbenchPart;

import com.google.common.collect.Iterables;

/**
 * This is the CreateFolderAction type. Enjoy.
 */
public class CreateFolderAction
		extends AsyncTransactionAction<CDOResourceNode> {

	private final IWorkbenchPart part;

	private String folderName;

	public CreateFolderAction(IWorkbenchPart part) {
		super(CDOResourceNode.class, Messages.CreateFolderAction_0,
			Activator.ICON_CREATE_FOLDER);

		this.part = part;
	}

	@Override
	protected CDOResourceNode coerce(Object selection) {
		CDOResourceNode result = super.coerce(selection);

		if ((result == null)
			&& (selection instanceof IInternalPapyrusRepository)) {

			IInternalPapyrusRepository repository = (IInternalPapyrusRepository) selection;

			if (repository.isConnected()) {
				CDOView view = repository.getMasterView();
				if (view != null) {
					result = view.getRootResource();
				}
			}
		}

		return result;
	}

	@Override
	protected boolean gatherInput(CDOResourceNode selection) {
		boolean result = false;

		InputDialog dialog = new InputDialog(part.getSite().getShell(),
			Messages.CreateFolderAction_1, Messages.CreateFolderAction_2,
			getDefaultFolderName(selection), createInputValidator(selection));

		if (dialog.open() == Window.OK) {
			folderName = dialog.getValue().trim();
			result = true;
		}

		return result;
	}

	private Iterable<CDOResourceNode> getChildren(CDOResourceNode node) {
		Iterable<CDOResourceNode> result;

		if (node instanceof CDOResourceFolder) {
			result = ((CDOResourceFolder) node).getNodes();
		} else if ((node instanceof CDOResource)
			&& ((CDOResource) node).isRoot()) {
			result = Iterables.filter(((CDOResource) node).getContents(),
				CDOResourceNode.class);
		} else {
			result = Collections.emptyList();
		}

		return result;
	}

	boolean nameExists(Iterable<CDOResourceNode> existingNodes, String name) {
		boolean result = false;

		for (CDOResourceNode next : existingNodes) {
			if (name.equals(next.getName())) {
				result = true;
				break;
			}
		}

		return result;
	}

	private String getDefaultFolderName(CDOResourceNode parent) {
		Iterable<CDOResourceNode> existing = getChildren(parent);
		String result = null;

		for (int i = 1; result == null; i++) {
			result = "folder" + i; //$NON-NLS-1$

			if (nameExists(existing, result)) {
				result = null;
			}
		}

		return result;
	}

	private IInputValidator createInputValidator(CDOResourceNode parent) {
		final Iterable<CDOResourceNode> existing = getChildren(parent);

		return new IInputValidator() {

			public String isValid(String newText) {
				String result;
				String name = (newText == null)
					? "" //$NON-NLS-1$
					: newText.trim();

				if (name.length() == 0) {
					result = Messages.CreateFolderAction_5;
				} else if (nameExists(existing, name)) {
					result = Messages.CreateFolderAction_6;
				} else {
					result = null;
				}

				return result;
			}
		};
	}

	@Override
	protected void doRun(CDOResourceNode selection, CDOTransaction transaction,
			IProgressMonitor monitor) {

		CDOResourceFolder folder = EresourceFactory.eINSTANCE
			.createCDOResourceFolder();
		folder.setName(folderName);

		if (selection instanceof CDOResourceFolder) {
			((CDOResourceFolder) selection).getNodes().add(folder);
		} else if (selection instanceof CDOResource) {
			((CDOResource) selection).getContents().add(folder);
		}
	}

}
