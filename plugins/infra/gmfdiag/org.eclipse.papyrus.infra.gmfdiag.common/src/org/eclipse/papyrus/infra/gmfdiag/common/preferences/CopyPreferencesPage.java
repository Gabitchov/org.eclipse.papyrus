/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Benoit Maggi (CEA LIST) benoit.maggi@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.preferences;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.papyrus.infra.gmfdiag.common.Activator;
import org.eclipse.papyrus.infra.gmfdiag.common.strategy.StrategyEditor;
import org.eclipse.papyrus.infra.gmfdiag.common.strategy.copy.CopyStrategyManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * Allow to select strategies for Papyrus copy
 */
public class CopyPreferencesPage extends PreferencePage implements IWorkbenchPreferencePage {

	private StrategyEditor editor;

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public CopyPreferencesPage() {
		super("Copy preferences", org.eclipse.papyrus.infra.widgets.Activator.getDefault().getImageDescriptor("/icons/papyrus.png"));
	}

	public void init(IWorkbench workbench) {
		setPreferenceStore(Activator.getInstance().getPreferenceStore());
		setDescription("Papyrus copy configuration.\nSelect the copy strategies you wish to activate.");
	}

	@Override
	protected Control createContents(Composite parent) {
		Composite self = new Composite(parent, SWT.NONE);
		self.setLayout(new GridLayout(1, true));
		editor = new StrategyEditor(self, SWT.NONE, CopyStrategyManager.getInstance());
		editor.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		return self;
	}

	@Override
	protected void performDefaults() {
		if(editor != null && !editor.isDisposed()) {
			CopyStrategyManager.getInstance().restoreDefaults();
			editor.refresh();
		}
		super.performDefaults();
	}

}
