/**
 * Copyright (c) 2012 Mia-Software.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  	Alban Ménager (Soft-Maint) - Bug 387470 - [EFacet][Custom] Editors
 */
package org.eclipse.papyrus.emf.facet.custom.sdk.ui.internal.util.wizard.page;

import org.eclipse.papyrus.emf.facet.custom.sdk.ui.internal.Messages;
import org.eclipse.papyrus.emf.facet.custom.sdk.ui.internal.wizard.page.ICustomizationPropertyWizardPage;
import org.eclipse.jface.wizard.WizardPage;
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
public class CustomPropertyWizardPage extends WizardPage implements
		ICustomizationPropertyWizardPage {

	private Text nsUriTextField;
	private Text prefixTextField;

	/**
	 * @param pageName
	 */
	public CustomPropertyWizardPage(final String pageName) {
		super(pageName);

		setTitle(Messages.CreateCustomizationWizardImpl_customization_properties);
	}

	public void createControl(final Composite parent) {
		final Composite nsURiContainer = new Composite(parent, SWT.NONE);
		nsURiContainer.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		nsURiContainer.setLayout(new GridLayout(2, false));
		// NsURI
		final Label nsUriLabel = new Label(nsURiContainer, SWT.NONE);
		nsUriLabel.setText(Messages.Enter_a_nsUri);
		this.nsUriTextField = new Text(nsURiContainer, SWT.BORDER | SWT.SINGLE);
		this.nsUriTextField.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		this.nsUriTextField.addListener(SWT.Modify, new Listener() {
			public void handleEvent(final Event event) {
				updateButtons();
			}
		});
		// PREFIX
		final Label prefixLabel = new Label(nsURiContainer, SWT.NONE);
		prefixLabel.setText(Messages.Enter_a_prefix);
		this.prefixTextField = new Text(nsURiContainer, SWT.BORDER | SWT.SINGLE);
		this.prefixTextField.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		this.prefixTextField.addListener(SWT.Modify, new Listener() {
			public void handleEvent(final Event event) {
				updateButtons();
			}
		});
		setControl(nsURiContainer);
	}

	@Override
	public boolean isPageComplete() {
		boolean result = false;
		if (this.nsUriTextField.getText().length() == 0) {
			setErrorMessage(Messages.Please_enter_nsUri);
		}
		if (this.prefixTextField.getText().length() == 0) {
			setErrorMessage(Messages.Please_enter_prefix);
		}
		if (super.isPageComplete()) {
			setErrorMessage(null);
			result = true;
		} else {
			setErrorMessage(Messages.Please_select_EPackage);
		}
		return result;
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

	public void setNsUri(final String nsUri) {
		this.nsUriTextField.setText(nsUri);
	}

	public void setPrefix(final String prefix) {
		this.prefixTextField.setText(prefix);
	}

	public void setIsPageComplete(final boolean complete) {
		this.setPageComplete(complete);
	}
}
