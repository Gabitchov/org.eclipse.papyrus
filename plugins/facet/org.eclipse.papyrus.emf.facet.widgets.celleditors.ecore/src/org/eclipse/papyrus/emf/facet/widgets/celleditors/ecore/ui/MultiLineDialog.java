/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Nicolas Guyomar (Mia-Software) - initial API and implementation
 *****************************************************************************/
package org.eclipse.emf.facet.widgets.celleditors.ecore.ui;

import org.eclipse.emf.facet.widgets.celleditors.ecore.Activator;
import org.eclipse.emf.facet.widgets.celleditors.ecore.Messages;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class MultiLineDialog extends Dialog {

	private static final int DIALOG_WIDTH = 300;
	private static final int DIALOG_HEIGHT = 200;
	private String originalValue;
	private Text textArea;

	public MultiLineDialog(final Shell parent, final Object originalValue) {
		super(parent);
		if (originalValue instanceof String) {
			this.originalValue = (String) originalValue;
		}

	}

	@Override
	protected Control createDialogArea(final Composite parent) {
		// create a composite with standard margins and spacing
		Composite composite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.marginHeight = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_MARGIN);
		layout.marginWidth = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_MARGIN);
		layout.verticalSpacing = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_SPACING);
		layout.horizontalSpacing = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_SPACING);
		composite.setLayout(layout);
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));

		this.textArea = new Text(composite, SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL | SWT.BORDER);
		if (this.originalValue != null) {
			this.textArea.setText(this.originalValue);
		}
		this.textArea.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		this.textArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(final KeyEvent e) {
				if (e.keyCode == SWT.CR && e.stateMask == SWT.CTRL) {
					okPressed();
				}
				super.keyPressed(e);
			}
		});

		applyDialogFont(composite);
		return composite;
	}

	@Override
	protected void okPressed() {
		super.okPressed();
	}

	@Override
	protected boolean isResizable() {
		return true;
	}

	@Override
	protected void configureShell(final Shell newShell) {
		super.configureShell(newShell);
		newShell.setText(Messages.MultiLineDialog_enterAValue);
	}

	protected Text getTextArea() {
		return this.textArea;
	}

	@Override
	protected IDialogSettings getDialogBoundsSettings() {
		final String sectionName = this.getClass().getName() + ".settings"; //$NON-NLS-1$
		IDialogSettings settings = Activator.getDefault().getDialogSettings();
		IDialogSettings section = settings.getSection(sectionName);
		if (section == null) {
			section = settings.addNewSection(sectionName);
			// cf Dialog#DIALOG_WIDTH
			section.put("DIALOG_WIDTH", MultiLineDialog.DIALOG_WIDTH); //$NON-NLS-1$
			section.put("DIALOG_HEIGHT", MultiLineDialog.DIALOG_HEIGHT); //$NON-NLS-1$
		}
		return section;
	}
}
