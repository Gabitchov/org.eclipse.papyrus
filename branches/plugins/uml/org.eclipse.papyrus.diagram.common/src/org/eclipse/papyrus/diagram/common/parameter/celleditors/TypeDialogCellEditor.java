/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Tatiana Fesenko (Borland) - initial API and implementation
 */
package org.eclipse.papyrus.diagram.common.parameter.celleditors;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.DialogCellEditor;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.diagram.common.part.UMLElementChooserDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.uml2.uml.Type;

public class TypeDialogCellEditor extends DialogCellEditor {

	private final TransactionalEditingDomain myEditingDomain;

	private final AdapterFactory myAdapterFactory;

	public TypeDialogCellEditor(Table table, TransactionalEditingDomain editingDomain, AdapterFactory af) {
		super(table, SWT.SINGLE);
		myEditingDomain = editingDomain;
		myAdapterFactory = af;
	}

	@Override
	protected Object openDialogBox(Control cellEditorWindow) {
		UMLElementChooserDialog dialog = new TypeChooserDialog(cellEditorWindow.getShell(), myAdapterFactory);
		if (Window.OK == dialog.open()) {
			URI uri = dialog.getSelectedModelElementURI();
			try {
				return myEditingDomain.getResourceSet().getEObject(uri, true);
			} catch (WrappedException e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}

	private static class TypeChooserDialog extends UMLElementChooserDialog {

		public TypeChooserDialog(Shell parentShell, AdapterFactory af) {
			super(parentShell, af);
		}

		@Override
		protected boolean isValid(EObject selectedElement) {
			return selectedElement instanceof Type;
		}

		@Override
		protected void setInput(TreeViewer treeViewer) {
			treeViewer.setInput(ResourcesPlugin.getWorkspace().getRoot());
		}
	}

}
