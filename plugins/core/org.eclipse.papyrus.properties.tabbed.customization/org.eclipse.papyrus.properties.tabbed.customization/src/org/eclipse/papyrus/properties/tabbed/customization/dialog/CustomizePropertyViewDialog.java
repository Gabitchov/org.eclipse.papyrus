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

import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.papyrus.properties.tabbed.customization.Messages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;


/**
 * Dialog that allows customization of the property views for Papyrus
 */
public class CustomizePropertyViewDialog extends TrayDialog {

	/**
	 * Creates a new CustomizePropertyViewDialog.
	 * 
	 * @param shell
	 *        the shell that displays the dialog
	 */
	public CustomizePropertyViewDialog(Shell shell) {
		super(shell);
		setShellStyle(getShellStyle() | SWT.SHELL_TRIM);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite)super.createDialogArea(parent);

		SashForm sashForm = new SashForm(composite, SWT.HORIZONTAL);
		sashForm.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		createContentExplorer(sashForm);
		createConfigurationArea(sashForm);

		sashForm.setWeights(new int[]{ 30, 70 });

		return composite;
	}

	/**
	 * Creates the configuration area, where the configuration for one model element is displayed.
	 * This is the part on the right.
	 * 
	 * @param composite
	 *        the parent composite for the controls created in this area
	 */
	protected void createConfigurationArea(Composite composite) {
		SashForm configurationAreaSashForm = new SashForm(composite, SWT.VERTICAL);
		configurationAreaSashForm.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		createConfigurationEditor(configurationAreaSashForm);
		createPreviewArea(configurationAreaSashForm);

		configurationAreaSashForm.setWeights(new int[]{ 50, 50 });

	}

	/**
	 * Creates the configuration editor, where the configuration for one model element can be edited
	 * 
	 * @param composite
	 *        the parent composite for the controls created in this area
	 */
	protected void createConfigurationEditor(Composite composite) {
		Composite configurationAreaComposite = new Composite(composite, SWT.NONE);
		configurationAreaComposite.setLayout(new GridLayout(1, false));

		// title of this area
		Label titleLabel = new Label(configurationAreaComposite, SWT.NONE);
		titleLabel.setText("Configuration:");

		// content tree and viewer on this tree
		Tree configurationTree = new Tree(configurationAreaComposite, SWT.BORDER);
		configurationTree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		TreeViewer contentViewer = new TreeViewer(configurationTree);
	}

	/**
	 * Creates the area where the preview of the property view is displayed.
	 * This is the part in the lower right.
	 * 
	 * @param composite
	 *        the parent composite for the controls created in this area
	 */
	protected void createPreviewArea(Composite composite) {
		Composite previewAreaComposite = new Composite(composite, SWT.NONE);
		previewAreaComposite.setLayout(new GridLayout(1, false));

		// title of this area
		Label titleLabel = new Label(previewAreaComposite, SWT.NONE);
		titleLabel.setText("Preview:");

		// content tree and viewer on this tree
		Tree previewTree = new Tree(previewAreaComposite, SWT.BORDER);
		previewTree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		TreeViewer contentViewer = new TreeViewer(previewTree);
	}

	/**
	 * Creates the area where the metamodel elements, the available views and controllers are displayed.
	 * This is the part on the upper left.
	 * 
	 * @param composite
	 *        the parent composite for the controls created in this area
	 */
	protected void createContentExplorer(Composite composite) {
		Composite mainContentAreaComposite = new Composite(composite, SWT.NONE);
		mainContentAreaComposite.setLayout(new GridLayout(1, false));

		// title of this area
		Label contentLabel = new Label(mainContentAreaComposite, SWT.NONE);
		contentLabel.setText("Content:");

		// content tree and viewer on this tree
		Tree contentTree = new Tree(mainContentAreaComposite, SWT.BORDER);
		contentTree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		TreeViewer contentViewer = new TreeViewer(contentTree);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setSize(640, 480);
		newShell.setText(Messages.CustomizePropertyViewDialog_DialogTitle);
	}

}
