/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.dnd.preferences;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.papyrus.infra.gmfdiag.dnd.Activator;
import org.eclipse.papyrus.infra.gmfdiag.dnd.policy.DropStrategyManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;


public class DNDPreferencesPage extends PreferencePage implements IWorkbenchPreferencePage {

	private DropStrategyEditor editor;

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public DNDPreferencesPage() {
		super("Drag and Drop", org.eclipse.papyrus.infra.widgets.Activator.getDefault().getImageDescriptor("/icons/papyrus.png"));
	}

	public void init(IWorkbench workbench) {
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription("Papyrus drag and drop configuration.\nSelect the drop strategies you wish to activate.");
	}

	@Override
	protected Control createContents(Composite parent) {
		Composite self = new Composite(parent, SWT.NONE);
		self.setLayout(new GridLayout(1, true));

		editor = new DropStrategyEditor(self, SWT.NONE);
		editor.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		return self;
	}

	@Override
	protected void performDefaults() {
		if(editor != null && !editor.isDisposed()) {
			DropStrategyManager.instance.restoreDefaults();
			editor.refresh();
		}
		super.performDefaults();
	}

}
