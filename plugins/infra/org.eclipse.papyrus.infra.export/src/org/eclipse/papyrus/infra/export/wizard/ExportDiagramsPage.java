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

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.papyrus.infra.export.actions.ExportComposite;

/**
 * wizard page to export all diagram from a Papyrus model
 */
public class ExportDiagramsPage extends WizardPage {

	private ExportComposite export;

	public ExportComposite getExport() {
		return export;
	}

	private final IFile file;

	/**
	 * Create the wizard.
	 */
	public ExportDiagramsPage(IFile file) {
		super(Messages.ExportDiagramsPage_0);
		this.file = file;
		setTitle(Messages.ExportDiagramsPage_0);
		setDescription(Messages.ExportDiagramsPage_2);
	}

	/**
	 * Create contents of the wizard.
	 * 
	 * @param parent
	 */
	public void createControl(Composite parent) {
		export = new ExportComposite(parent, SWT.NONE);
		export.setSelectedDiagramFile(file);
		setControl(export);
	}

}
