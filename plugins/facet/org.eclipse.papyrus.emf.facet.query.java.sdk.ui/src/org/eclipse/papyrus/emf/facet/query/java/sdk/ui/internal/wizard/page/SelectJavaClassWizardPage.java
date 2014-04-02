/**
 * Copyright (c) 2011 Mia-Software.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *		Nicolas Guyomar (Mia-Software) - Bug 349556 - EMF Facet Java Query wizard
 *		Alban Ménager (Soft-Maint) - Bug 387470 - [EFacet][Custom] Editors
 *		Grégoire Dupé (Mia-Software) - Bug 387470 - [EFacet][Custom] Editors
 */
package org.eclipse.papyrus.emf.facet.query.java.sdk.ui.internal.wizard.page;

import org.eclipse.papyrus.emf.facet.query.java.sdk.ui.internal.Activator;
import org.eclipse.papyrus.emf.facet.query.java.sdk.ui.internal.Messages;
import org.eclipse.papyrus.emf.facet.util.core.Logger;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jdt.ui.IJavaElementSearchConstants;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.SelectionDialog;

// Copied from org.eclipse.papyrus.emf.facet.query.java.ui.internal.wizard.page.SelectOrCreateJavaClassWizardPage
public class SelectJavaClassWizardPage extends WizardPage {

	private String result;
	private Text text;

	public SelectJavaClassWizardPage() {
		super("SelectJavaClass"); //$NON-NLS-1$
		setTitle(Messages.SelectJavaClassWizardPage_SelectAJavaClass);
		setDescription(Messages.SelectJavaClassWizardPage_SeclectAJavaClassLongDescription);
	}

	public void createControl(final Composite parent) {
		final Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout());
		final Button dialogBtn = new Button(composite, SWT.PUSH);
		dialogBtn.setText("Open the class selection wizard..."); //$NON-NLS-1$
		final SelectionListener listener = new SelectionListener() {
			public void widgetSelected(final SelectionEvent event) {
				SelectJavaClassWizardPage.this.openSelectionDialog();
			}

			public void widgetDefaultSelected(final SelectionEvent event) {
				// Noting to do
			}
		};
		dialogBtn.addSelectionListener(listener);
		this.text = new Text(composite, SWT.BORDER);
		setControl(composite);
		setPageComplete(false);
	}

	protected void openSelectionDialog() {
		final Display display = Display.getDefault();
		display.asyncExec(new Runnable() {
			public void run() {
				final Shell shell = new Shell(display);
				SelectionDialog dialog;
				try {
					dialog = JavaUI.createTypeDialog(shell,
							new ProgressMonitorDialog(shell),
							SearchEngine.createWorkspaceScope(),
							IJavaElementSearchConstants.CONSIDER_CLASSES, false);
					dialog.open();
					final boolean cancelled = (dialog.getReturnCode() == Window.CANCEL);
					Object dilaogResult = null;
					if (!cancelled && dialog.getResult()[0] instanceof IType) {
						final IType type = (IType) dialog.getResult()[0];
						dilaogResult = type.getFullyQualifiedName();
					}
					SelectJavaClassWizardPage.this.dialogClosed(dilaogResult,
							cancelled);
				} catch (JavaModelException e) {
					Logger.logError(e, Activator.getDefault());
					SelectJavaClassWizardPage.this.dialogClosed(null, true);
				}
			}
		});
	}

	protected void dialogClosed(final Object dialogResult, final boolean cancelled) {
		if (cancelled) {
			this.getPreviousPage();
		} else {
			if (dialogResult != null && dialogResult.toString().length() > 0) {
				this.result = dialogResult.toString();
				this.text.setText(dialogResult.toString());
				setPageComplete(true);
			} else {
				setPageComplete(false);
			}
		}
	}

	public String getResult() {
		return this.result;
	}

}
