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
package org.eclipse.papyrus.infra.xtext.widgets.creation;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.infra.xtext.widgets.adapter.IXtextAdapter;
import org.eclipse.papyrus.infra.xtext.widgets.embedded.EmbeddedXtextEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.SelectionDialog;


public class XtextEditorDialog extends SelectionDialog {

	protected IXtextAdapter adapter;

	protected EObject currentValue;

	protected EmbeddedXtextEditor editor;

	public XtextEditorDialog(Shell shell, IXtextAdapter adapter, EObject currentValue) {
		super(shell);
		this.adapter = adapter;
		this.currentValue = currentValue;
	}

	@Override
	public void create() {
		super.create();
		editor = new EmbeddedXtextEditor(getDialogArea(), adapter.getInjector(), SWT.NONE);
		editor.update(adapter.getText(currentValue));
		getShell().pack();
	}

	@Override
	protected void okPressed() {
		Resource resource = editor.getResource();
		if(resource != null) {
			List<EObject> contents = resource.getContents();
			if(!contents.isEmpty()) {
				currentValue = adapter.reconcile(currentValue, contents.get(0));
				setResult(contents);
			}
		}
		super.okPressed();
	}

	public EObject getValue() {
		return currentValue;
	}

	@Override
	protected Composite getDialogArea() {
		return (Composite)super.getDialogArea();
	}

}
