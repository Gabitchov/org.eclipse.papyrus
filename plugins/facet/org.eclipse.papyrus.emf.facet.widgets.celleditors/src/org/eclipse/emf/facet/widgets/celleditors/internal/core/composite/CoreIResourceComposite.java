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
 *    Nicolas Bros (Mia-Software) - Bug 339664 - org.eclipse.emf.facet.widgets.celleditors API cleaning
 *******************************************************************************/
package org.eclipse.emf.facet.widgets.celleditors.internal.core.composite;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;

public class CoreIResourceComposite extends AbstractIResourceComposite<IResource> {

	public CoreIResourceComposite(final Composite parent) {
		super(parent);
	}

	public CoreIResourceComposite(final Composite parent, final int style) {
		super(parent, style);
	}

	@Override
	public IResource getValue() {
		return ResourcesPlugin.getWorkspace().getRoot().findMember(getText().getText());
	}

	@Override
	protected final void browseResource() {
		ElementTreeSelectionDialog elementTreeSelectionDialog = new ElementTreeSelectionDialog(
				getShell(), new WorkbenchLabelProvider(), new WorkbenchContentProvider());
		elementTreeSelectionDialog.setInput(ResourcesPlugin.getWorkspace().getRoot());
		elementTreeSelectionDialog.setMessage("Select a resource"); //$NON-NLS-1$
		elementTreeSelectionDialog.setAllowMultiple(false);
		elementTreeSelectionDialog.setDoubleClickSelects(true);
		elementTreeSelectionDialog.open();
		Object result = elementTreeSelectionDialog.getFirstResult();

		if (result != null && result instanceof IResource) {
			IResource selectedResource = (IResource) result;
			setValue(selectedResource);
			fireCommit();
		}
	}

}
