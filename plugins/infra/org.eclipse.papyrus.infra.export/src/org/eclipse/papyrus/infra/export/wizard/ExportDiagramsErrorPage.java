/*******************************************************************************
 * Copyright (c) 2011 AtoS
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Anass RADOUANI (AtoS)
 *******************************************************************************/

package org.eclipse.papyrus.infra.export.wizard;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

/**
 * error wizard page shown when the selected file is incorrect
 */
public class ExportDiagramsErrorPage extends WizardPage {

	/**
	 * Create the wizard.
	 */
	public ExportDiagramsErrorPage() {
		super(Messages.ExportDiagramsErrorPage_0);
		setTitle(Messages.ExportDiagramsErrorPage_0);
		setDescription(Messages.ExportDiagramsErrorPage_2);
	}

	/**
	 * Create contents of the wizard.
	 * 
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Label label = new Label(parent, SWT.NONE);
		label.setText(Messages.ExportDiagramsErrorPage_3);
		setControl(label);
	}

}
