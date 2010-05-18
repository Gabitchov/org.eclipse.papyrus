/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.tabbed.customization.dialog;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.w3c.dom.Document;


/**
 * Wizard page where user can customize the content of the property view
 */
public class CustomizeContentWizardPage extends WizardPage {

	/** initial content */
	protected Document document;

	/**
	 * Creates a new CustomizeContentWizardPage.
	 */
	public CustomizeContentWizardPage() {
		super("Customize Property View", "Customize property view Wizard", null);
	}

	/**
	 * {@inheritDoc}
	 */
	public void createControl(Composite parent) {
		Label label = new Label(parent, SWT.NONE);
		label.setText("hello");
		setControl(label);
	}

	/**
	 * Sets the initial content for this page
	 * 
	 * @param initialContent
	 *        the initial content for this page, i.e. the document
	 */
	public void setInitialContent(Document document) {
		this.document = document;
	}

	/**
	 * Returns the final content for this page
	 * 
	 * @return the final content for this page
	 */
	public Document getFinalContent() {
		return this.document;
	}



}
