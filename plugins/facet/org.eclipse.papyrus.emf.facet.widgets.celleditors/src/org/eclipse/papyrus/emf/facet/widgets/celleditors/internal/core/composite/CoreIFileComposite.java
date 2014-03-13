/*******************************************************************************
 * Copyright (c) 2011 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Nicolas Bros (Mia-Software) - initial API and implementation
 *    Nicolas Guyomar (Mia-Software) - Bug 334546 - [celleditors] no border on Text field
 *    Nicolas Bros (Mia-Software) - Bug 338437 - compositeEditors extension point cannot be used to register user types
 *    Nicolas Bros (Mia-Software) - Bug 339664 - org.eclipse.papyrus.emf.facet.widgets.celleditors API cleaning
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.widgets.celleditors.internal.core.composite;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.papyrus.emf.facet.widgets.celleditors.internal.Activator;
import org.eclipse.papyrus.emf.facet.widgets.celleditors.internal.Messages;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;

public class CoreIFileComposite extends AbstractIResourceComposite<IFile> {

	public CoreIFileComposite(final Composite parent) {
		super(parent);
	}

	public CoreIFileComposite(final Composite parent, final int style) {
		super(parent, style);
	}

	@Override
	public IFile getValue() {
		IResource member = ResourcesPlugin.getWorkspace().getRoot().findMember(getText().getText());
		if (member instanceof IFile) {
			IFile file = (IFile) member;
			return file;
		}
		return null;
	}

	@Override
	protected final void browseResource() {
		ElementTreeSelectionDialog elementTreeSelectionDialog = new ElementTreeSelectionDialog(
				getShell(), new WorkbenchLabelProvider(), new WorkbenchContentProvider());
		elementTreeSelectionDialog.setInput(ResourcesPlugin.getWorkspace().getRoot());
		elementTreeSelectionDialog.setMessage(Messages.CoreIFileComposite_selectFile);
		elementTreeSelectionDialog.setAllowMultiple(false);
		elementTreeSelectionDialog.setDoubleClickSelects(true);
		elementTreeSelectionDialog.setValidator(new ISelectionStatusValidator() {
			public IStatus validate(final Object[] selection) {
				if (selection.length != 1 || !(selection[0] instanceof IFile)) {
					return new Status(IStatus.ERROR, Activator.PLUGIN_ID, Messages.CoreIFileComposite_mustSelectFile);
				}
				return Status.OK_STATUS;
			}
		});
		elementTreeSelectionDialog.open();
		Object result = elementTreeSelectionDialog.getFirstResult();

		if (result != null && result instanceof IFile) {
			IFile selectedFile = (IFile) result;
			setValue(selectedFile);
			fireCommit();
		}
	}

}
