/*****************************************************************************
 * Copyright (c) 2012, 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - Refactoring package/profile import/apply UI for CDO
 *  
 *****************************************************************************/
package org.eclipse.papyrus.uml.importt.ui;

import java.util.Collection;

import org.eclipse.papyrus.uml.profile.ui.dialogs.PackageImportTreeSelectionDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Package;

/**
 * An import package dialog, with the option to import a copy of the selected
 * package
 * 
 * @author Camille Letavernier
 */
public class PackageImportDialog
		extends PackageImportTreeSelectionDialog {

	public PackageImportDialog(Shell parent, Package model) {
		super(parent, model);
	}

	public PackageImportDialog(Shell parent,
			Collection<? extends Package> models) {
		super(parent, models);
	}

	@Override
	public Composite createDialogArea(Composite parent) {
		Composite result = (Composite) super.createDialogArea(parent);

		Composite buttons = new Composite(result, SWT.NONE);
		buttons.setLayout(new RowLayout());

		Button importAll = new Button(buttons, SWT.PUSH);
		importAll.setText("Import All");
		importAll.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				selectAll(ImportAction.IMPORT);
			}
		});

		Button copyAll = new Button(buttons, SWT.PUSH);
		copyAll.setText("Copy All");
		copyAll.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				selectAll(ImportAction.COPY);
			}
		});

		Button deselectAll = new Button(buttons, SWT.PUSH);
		deselectAll.setText("Deselect All");
		deselectAll.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				selectAll(ImportAction.NONE);
			}
		});

		return result;
	}

	@Override
	protected boolean isResizable() {
		return true;
	}

}
