/*******************************************************************************
 * Copyright (c) 2007 Anyware Technologies. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Jacques Lescot (Anyware Technologies) - initial API and
 * implementation
 * Anass Radouani (AtoS) - use of ExporterManager removed
 ******************************************************************************/
package org.eclipse.papyrus.infra.export.actions;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

/**
 * 
 * Creation 24 sept. 07
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class ExportAllDiagramsDialog extends Dialog {

	private ExportComposite dialogComposite;

	private IFile selectedDiagramFile;


	/**
	 * @param parentShell
	 * @param selectedFile
	 */
	public ExportAllDiagramsDialog(Shell parentShell, IFile selectedFile) {
		super(parentShell);
		selectedDiagramFile = selectedFile;
		setBlockOnOpen(true);
		setShellStyle(getShellStyle() | SWT.RESIZE);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite)super.createDialogArea(parent);
		dialogComposite = new ExportComposite(composite, SWT.NONE);
		dialogComposite.setSelectedDiagramFile(selectedDiagramFile);
		return composite;
	}

	public IResource getOutputDirectory() {
		return dialogComposite.getOutputDirectory();
	}

	public String getExporter() {
		return dialogComposite.getExporter();
	}

	public boolean getQualifiedName() {
		return dialogComposite.getQualifiedName();
	}




}
