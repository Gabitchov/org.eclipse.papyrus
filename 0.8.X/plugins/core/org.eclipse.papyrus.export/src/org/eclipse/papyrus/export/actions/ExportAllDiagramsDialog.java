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
package org.eclipse.papyrus.export.actions;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.gmf.runtime.diagram.ui.image.ImageFileFormat;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.export.internal.Activator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ContainerSelectionDialog;

/**
 * 
 * Creation 24 sept. 07
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class ExportAllDiagramsDialog extends Dialog {

	private IFile selectedDiagramFile;

	// SWT Objects
	private Composite dialogComposite;

	private Text outputPathTxt;

	private Button outputDirectoryBtn;

	private Combo outputFormatCb;

	// Configured items
	protected IResource outputDirectory;

	protected String exporter;

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

		dialogComposite = (Composite)super.createDialogArea(parent);
		createDialogComposite();
		createDialogContents(dialogComposite);
		hookListeners();
		loadData();


		return dialogComposite;
	}

	/**
	 * Create the view of the list of interaction operators
	 * 
	 * @param parent
	 *        the parent composite to contain this group
	 */
	protected void createDialogContents(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		composite.setLayout(layout);
		composite.setFont(parent.getFont());
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));

		Label editorConfLbl = new Label(composite, SWT.NONE);
		editorConfLbl.setText(Messages.ExportAllDiagramsDialog_0);
		outputPathTxt = new Text(composite, SWT.BORDER);
		outputPathTxt.setEnabled(false);
		outputPathTxt.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		outputDirectoryBtn = new Button(composite, SWT.NONE);
		outputDirectoryBtn.setText(Messages.ExportAllDiagramsDialog_1);

		Label outputFormatLbl = new Label(composite, SWT.NONE);
		outputFormatLbl.setText(Messages.ExportAllDiagramsDialog_2);

		outputFormatCb = new Combo(composite, SWT.NONE);
		GridData gridData2 = new GridData(GridData.FILL_HORIZONTAL);
		gridData2.horizontalSpan = 2;
		outputFormatCb.setLayoutData(gridData2);

	}

	/**
	 * Create the Dialog Contents
	 */
	private void createDialogComposite() {
		GridLayout dialogLayout = new GridLayout();
		GridData dialogLayoutData = new GridData(GridData.FILL_BOTH);
		dialogComposite.setLayout(dialogLayout);
		dialogComposite.setLayoutData(dialogLayoutData);
	}


	private void hookListeners() {
		outputDirectoryBtn.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				ContainerSelectionDialog csDialog = new ContainerSelectionDialog(Activator.getActiveWorkbenchShell(), ResourcesPlugin.getWorkspace().getRoot(), true, Messages.ExportAllDiagramsDialog_3);


				if(csDialog.open() == Window.OK) {
					Object[] results = csDialog.getResult();
					if(results.length == 1 && results[0] instanceof IPath) {
						URI uri = URI.createPlatformResourceURI(((IPath)results[0]).toString(), true);
						outputDirectory = ResourcesPlugin.getWorkspace().getRoot().findMember(new Path(uri.toPlatformString(true)));
						outputPathTxt.setText(outputDirectory.getLocation().toString());
					}
				}
			}
		});

		outputFormatCb.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				exporter = outputFormatCb.getText();
			}
		});
	}

	private void loadData() {
		outputDirectory = selectedDiagramFile.getParent();
		outputPathTxt.setText(outputDirectory.getLocation().toString());
		for(ImageFileFormat imageFileFormat : ImageFileFormat.VALUES) {
			outputFormatCb.add(imageFileFormat.toString());
		}

		outputFormatCb.setText(ImageFileFormat.getDefaultImageFormat().toString());

		exporter = outputFormatCb.getText();
	}

	/**
	 * Return the selected output IResource
	 * 
	 * @return IResource
	 */
	public IResource getOutputDirectory() {
		return outputDirectory;
	}

}
