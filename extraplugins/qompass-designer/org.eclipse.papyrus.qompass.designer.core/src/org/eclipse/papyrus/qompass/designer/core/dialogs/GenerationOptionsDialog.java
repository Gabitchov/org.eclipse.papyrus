/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Ansgar Radermacher  ansgar.radermacher@cea.fr  
 *
 *****************************************************************************/

package org.eclipse.papyrus.qompass.designer.core.dialogs;

import java.util.Arrays;

import org.eclipse.papyrus.qompass.designer.core.generate.GenerationOptions;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.SelectionStatusDialog;

/**
 * Select options for code generation.
 * 
 * @author ansgar
 */
public class GenerationOptionsDialog extends SelectionStatusDialog implements GenerationOptions {

	protected Button fButtonModelOnly;

	protected Button fButtonRewriteSettings;

	protected Button fButtonOnlyChanged;

	protected Button fButtonCACOnly;

	public static int oldResultInt = 0;

	public GenerationOptionsDialog(Shell parent) {
		super(parent);
	}

	/**
	 * @see SelectionStatusDialog#computeResult()
	 */
	protected void computeResult() {
		int resultInt = (isRewriteSettings() ? REWRITE_SETTINGS : 0) +
			(isOnlyChanged() ? ONLY_CHANGED : 0) +
			(isModelOnly() ? MODEL_ONLY : 0) +
			(isCACOnly() ? CAC_ONLY : 0);
		oldResultInt = resultInt;
		Object[] result = new Object[]{
			resultInt
		};
		setResult(Arrays.asList(result));
	}

	public Control createDialogArea(Composite parent) {
		Composite contents = (Composite)super.createDialogArea(parent);
		// (parent, "Container rules", "Avail. extensions/interceptors");

		fButtonCACOnly = new Button(contents, SWT.CHECK);
		fButtonCACOnly.setText("Only perform container and connector expansion (intermediate model without code generation)");
		fButtonCACOnly.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				updateButtonEnableStatus();
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
		fButtonCACOnly.setSelection((oldResultInt & CAC_ONLY) != 0);

		fButtonModelOnly = new Button(contents, SWT.CHECK);
		fButtonModelOnly.setText("Only generate model (not code)");
		fButtonModelOnly.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				// only write types that have changed does not make sense, if the whole directory is cleaned
				boolean modelOnly = fButtonModelOnly.getSelection();
				fButtonOnlyChanged.setEnabled(!modelOnly);
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
		fButtonModelOnly.setSelection((oldResultInt & MODEL_ONLY) != 0);

		fButtonRewriteSettings = new Button(contents, SWT.CHECK);
		fButtonRewriteSettings.setText("Rewrite project settings, if project exists already (may overwrite user settings)");
		fButtonRewriteSettings.setSelection((oldResultInt & REWRITE_SETTINGS) != 0);

		fButtonOnlyChanged = new Button(contents, SWT.CHECK);
		fButtonOnlyChanged.setText("Experimental: only write types that have changed (based on a difference model via EMF compare)");
		fButtonOnlyChanged.setSelection((oldResultInt & ONLY_CHANGED) != 0);

		updateButtonEnableStatus();
		return contents;
	}

	protected void updateButtonEnableStatus() {
		boolean onlyCAC = fButtonCACOnly.getSelection();
		boolean modelOnly = fButtonModelOnly.getSelection();
		fButtonModelOnly.setEnabled(!onlyCAC);
		fButtonOnlyChanged.setEnabled(!modelOnly && !onlyCAC);
		fButtonRewriteSettings.setEnabled(!onlyCAC);
	}

	public boolean isRewriteSettings() {
		return fButtonRewriteSettings.getSelection();
	}

	public boolean isOnlyChanged() {
		return fButtonOnlyChanged.getSelection();
	}

	public boolean isModelOnly() {
		return fButtonModelOnly.getSelection();
	}

	public boolean isCACOnly() {
		return fButtonCACOnly.getSelection();
	}
}
