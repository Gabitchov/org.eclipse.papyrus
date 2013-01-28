package org.eclipse.papyrus.qompass.designer.cpp;

import org.eclipse.cdt.ui.wizards.CDTMainWizardPage;

/**
 * Variant of the CDTMainWizardPage that skips the first validation. This
 * is required in the context of setting an initial project name, since the
 * update of the project name will trigger a validation which stops with an
 * exception, since some elements (notable tree) are not yet initialized.
 * 
 * Verify if future versions of CDT still require this "hack" {@link CDTMainWizardPage}
 * 
 * @author ansgar
 * 
 */
public class CDTMainWizardPageV extends CDTMainWizardPage {

	public CDTMainWizardPageV(String pageName) {
		super(pageName);
		firstValidate = true;
	}

	@Override
	protected boolean validatePage() {
		if(firstValidate) {
			return true;
		} else {
			return super.validatePage();
		}
	}

	private boolean firstValidate;
}
