/**
 * Copyright (c) 2011 Mia-Software.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	Nicolas Guyomar (Mia-Software) - Bug 349546 - EMF Facet facetSet editor
 */
package org.eclipse.emf.facet.efacet.ui.internal.wizards.pages;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.facet.efacet.ui.internal.Messages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

/**
 * Wizard page to enter a NsURI, a prefix and an extended EPackage to a facetSet
 */
public class FacetSetPropertyWizardPage extends SelectEPackageWizardPage {

	private Text nsUriTextField;
	private Text prefixTextField;

	public FacetSetPropertyWizardPage(final EditingDomain editingDomain) {
		super(editingDomain);
	}

	@Override
	public void createControl(final Composite parent) {

		// Extends the SelectEPackageWizardPage to add a NsURI and a Prefix textField
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new GridLayout(1, false));
		container.setLayoutData(new GridData(GridData.FILL_HORIZONTAL, GridData.FILL_VERTICAL, true, true));

		Composite nsURiContainer = new Composite(container, SWT.NONE);
		nsURiContainer.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		nsURiContainer.setLayout(new GridLayout(2, false));

		// NsURI
		Label nsUriLabel = new Label(nsURiContainer, SWT.NONE);
		nsUriLabel.setText(Messages.Enter_a_nsUri);
		this.nsUriTextField = new Text(nsURiContainer, SWT.BORDER | SWT.SINGLE);
		this.nsUriTextField.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		this.nsUriTextField.addListener(SWT.Modify, new Listener() {
			public void handleEvent(final Event event) {
				updateButtons();
			}
		});

		// PREFIX
		Label prefixLabel = new Label(nsURiContainer, SWT.NONE);
		prefixLabel.setText(Messages.Enter_a_prefix);
		this.prefixTextField = new Text(nsURiContainer, SWT.BORDER | SWT.SINGLE);
		this.prefixTextField.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		this.prefixTextField.addListener(SWT.Modify, new Listener() {
			public void handleEvent(final Event event) {
				updateButtons();
			}
		});

		super.createControl(container);
	}

	@Override
	public boolean isPageComplete() {
		if (this.nsUriTextField.getText().length() == 0) {
			setErrorMessage(Messages.Please_enter_nsUri);
			return false;
		}

		if (this.prefixTextField.getText().length() == 0) {
			setErrorMessage(Messages.Please_enter_prefix);
			return false;
		}
		if (super.isPageComplete()) {
			setErrorMessage(null);
			return true;
		}
		setErrorMessage(Messages.Please_select_EPackage);

		return false;
	}

	public String getNsUri() {
		return this.nsUriTextField.getText();
	}

	public String getPrefix() {
		return this.prefixTextField.getText();
	}

	protected void updateButtons() {
		getContainer().updateButtons();
	}

}
