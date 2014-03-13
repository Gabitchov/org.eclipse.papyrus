/*******************************************************************************
 * Copyright (c) 2011 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Nicolas Bros (Mia-Software) - Bug 342548 - [Java Discovery] Illegal parameter initializer for ELEMENTS_TO_ANALYZE
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.widgets.celleditors.internal.core.composite;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.ListDialog;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;

public class CoreIProjectComposite extends AbstractIResourceComposite<IProject> {

	public CoreIProjectComposite(final Composite parent) {
		super(parent);
	}

	public CoreIProjectComposite(final Composite parent, final int style) {
		super(parent, style);
	}

	@Override
	public IProject getValue() {
		IResource member = ResourcesPlugin.getWorkspace().getRoot().findMember(getText().getText());
		if (member instanceof IProject) {
			return (IProject) member;
		}
		return null;
	}

	@Override
	protected final void browseResource() {

		WorkbenchContentProvider projectsContentProvider = new WorkbenchContentProvider() {
			@Override
			public Object[] getChildren(final Object element) {
				if (!(element instanceof IWorkspace)) {
					return new Object[0];
				}
				IProject[] projects = ((IWorkspace) element).getRoot().getProjects();
				if (projects == null) {
					return new Object[0];
				}
				return projects;
			}
		};

		ListDialog dialog = new ListDialog(getShell());
		dialog.setContentProvider(projectsContentProvider);
		dialog.setLabelProvider(new WorkbenchLabelProvider());
		dialog.setInput(ResourcesPlugin.getWorkspace());
		// TODO: externalize string
		dialog.setMessage("Please select a project"); //$NON-NLS-1$
		// TODO: externalize string
		dialog.setTitle("Select Project"); //$NON-NLS-1$
		int code = dialog.open();
		if (code == Window.OK) {
			Object[] result = dialog.getResult();
			if (result.length == 1) {
				IProject selectedProject = (IProject) result[0];
				setValue(selectedProject);
				fireCommit();
			}
		}
	}
}
