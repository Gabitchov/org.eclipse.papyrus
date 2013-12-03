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
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.eresource.CDOResourceNode;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.cdo.internal.ui.l10n.Messages;
import org.eclipse.papyrus.cdo.internal.ui.views.DIModel;
import org.eclipse.papyrus.infra.core.resource.sasheditor.DiModel;
import org.eclipse.ui.IWorkbenchCommandConstants;
import org.eclipse.ui.IWorkbenchPart;

import com.google.common.base.Strings;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * This is the RenameModelAction type. Enjoy.
 */
public class RenameModelAction extends AsyncEditAction<DIModel> {

	private final IWorkbenchPart part;

	private String newName;

	public RenameModelAction(IWorkbenchPart part) {
		super(DIModel.class, Messages.RenameModelAction_0, (ImageDescriptor)null);

		this.part = part;

		setActionDefinitionId(IWorkbenchCommandConstants.FILE_RENAME);
	}

	@Override
	protected CDOView getView(DIModel selection) {
		return selection.getResource().cdoView();
	}

	@Override
	protected boolean gatherInput(DIModel selection) {
		boolean result = false;

		InputDialog dialog = new InputDialog(part.getSite().getShell(), Messages.RenameModelAction_1, Messages.RenameModelAction_2, getModelName(selection.getName()), createInputValidator(selection));
		if(dialog.open() == Dialog.OK) {
			newName = getModelName(dialog.getValue().trim());

			result = true;
		}

		return result;
	}

	static String getModelName(String filename) {
		String suffix = "." + DiModel.DI_FILE_EXTENSION.toLowerCase(); //$NON-NLS-1$
		String result = filename;

		if(filename.toLowerCase().endsWith(suffix)) {
			result = filename.substring(0, filename.length() - suffix.length());
		}

		return result;
	}

	static String getBaseName(String filename) {
		return new Path(filename).removeFileExtension().toString();
	}

	String getNewName(String filename) {
		IPath path = new Path(filename);

		IPath result = new Path(newName);
		if(path.getFileExtension() != null) {
			result = result.addFileExtension(path.getFileExtension());
		}

		return result.toString();
	}

	@Override
	protected void doRun(DIModel selection, CDOTransaction transaction, IProgressMonitor monitor) throws CoreException {
		List<IStatus> failures = Lists.newArrayListWithExpectedSize(1);
		for(Object next : selection.getChildren()) {
			if(next instanceof CDOResource) {
				// get the resource local to this transaction

				CDOID oid = ((CDOResource)next).cdoID();
				CDOResource toRename = (CDOResource)transaction.getObject(oid);
				if(toRename != null) {
					try {
						toRename.setName(getNewName(toRename.getName()));
					} catch (Exception e) {
						failures.add(error("Failed to rename resource " + toRename.getPath(), e)); //$NON-NLS-1$
					}
				}
			}
		}

		if(!failures.isEmpty()) {
			throw new CoreException(wrap(failures, "Errors occurred in renaming model.")); //$NON-NLS-1$
		}
	}

	private IInputValidator createInputValidator(DIModel model) {
		final CDOResource primaryResource = model.getResource();

		CDOResourceNode parent = primaryResource.getFolder();
		if(parent == null) {
			parent = (CDOResourceNode)primaryResource.eResource();
		}
		final CDOResourceNode container = parent;

		return new IInputValidator() {

			@Override
			public String isValid(String newText) {
				String result = null;
				newText = Strings.nullToEmpty(newText).trim();

				if(newText.equals("")) { //$NON-NLS-1$
					result = Messages.RenameModelAction_7;
				} else if((newText.indexOf('/') >= 0) || (newText.indexOf('\\') >= 0)) {
					result = Messages.RenameModelAction_8;
				} else if(getModelName(newText).equals(getModelName(primaryResource.getName()))) {
					// user didn't change the name
					result = ""; //$NON-NLS-1$
				} else {
					String base = getBaseName(newText);
					for(CDOResourceNode next : Iterables.filter(container.eContents(), CDOResourceNode.class)) {
						if(base.equals(getBaseName(next.getName()))) {
							result = NLS.bind(Messages.RenameModelAction_10, next.getName());
						}
					}
				}

				return result;
			}
		};
	}
}
