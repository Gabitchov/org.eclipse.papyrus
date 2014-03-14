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

import org.eclipse.papyrus.emf.facet.query.java.sdk.ui.internal.Messages;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

// Copied from org.eclipse.papyrus.emf.facet.query.java.ui.internal.wizard.page.SelectOrCreateJavaClassWizardPage
public class SelectOrCreateJavaClassWizardPage extends WizardPage {

	private Button selectButton;

	private final SelectionListener selectionListener = new SelectionListener() {
		public void widgetSelected(final SelectionEvent event) {
			onSelection();
		}

		public void widgetDefaultSelected(final SelectionEvent event) {
			// Nothing
		}
	};

	public SelectOrCreateJavaClassWizardPage() {
		super("Whatever"); //$NON-NLS-1$		
		setTitle(Messages.Choose_an_operation);
		setDescription(Messages.Choose_an_operation_desc);
	}

	public void createControl(final Composite parent) {
		final Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new GridLayout(1, false));
		// Create the creation radio button
		final Button createButton = new Button(container, SWT.RADIO);
		createButton.setText(Messages.Create_new_java_class);
		createButton.addSelectionListener(this.selectionListener);
		// Create the creation radio button
		this.selectButton = new Button(container, SWT.RADIO);
		this.selectButton.setText(Messages.Select_existing_java_class);
		this.selectButton.addSelectionListener(this.selectionListener);
		setControl(container);
	}

	public boolean canFinish() {
		return this.selectButton.getSelection();
	}


	protected void onSelection() {
		getContainer().updateButtons();
	}

	public boolean isSelect() {
		return this.selectButton.getSelection();
	}
}
