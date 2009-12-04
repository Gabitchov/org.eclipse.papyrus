/*******************************************************************************
 * Copyright (c) 2006 CEA List.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA List - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.extensionpoints.editors.ui;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.papyrus.extensionpoints.editors.configuration.IDirectEditorConfiguration;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.VerifyKeyListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;

/**
 * Dialog used in for direct edition, when an extension is provided
 */
public class ExtendedDirectEditionDialog extends LabelEditorDialog {

	/** Title of the Dialog */
	final private static String TITLE = "Edit Label";

	/** Edited object */
	protected Object editedObject;

	/** Document used by the dialog */
	protected Document document;

	/** initial text value */
	protected String value;

	/** extension configuration */
	protected IDirectEditorConfiguration configuration;

	/**
	 * Creates a new ExtendedDirectEditionDialog
	 * 
	 * @param parentShell
	 *        the parent shell
	 * @param parameter
	 *        the editedObject
	 * @param initialValue
	 *        the initial text value
	 */
	public ExtendedDirectEditionDialog(Shell parentShell, Object object, String initialValue,
			IDirectEditorConfiguration configuration) {
		super(parentShell, TITLE, initialValue, configuration.getInputValidator());
		this.editedObject = object;
		this.value = initialValue;
		this.configuration = configuration;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Group composite = new Group(parent, SWT.RESIZE);
		composite.setText("Specification");
		GridLayout layout = new GridLayout();
		layout.marginHeight = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_MARGIN);
		layout.marginWidth = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_MARGIN);
		layout.verticalSpacing = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_SPACING);
		layout.horizontalSpacing = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_SPACING);
		composite.setLayout(layout);
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));

		Composite viewerGroup = new Composite(composite, SWT.RESIZE);
		FillLayout viewerLayout = new FillLayout();
		viewerGroup.setLayout(viewerLayout);
		GridData data = new GridData(GridData.GRAB_HORIZONTAL | GridData.GRAB_VERTICAL | GridData.HORIZONTAL_ALIGN_FILL
				| GridData.VERTICAL_ALIGN_CENTER);
		data.widthHint = convertHorizontalDLUsToPixels(IDialogConstants.MINIMUM_MESSAGE_AREA_WIDTH);
		viewerGroup.setLayoutData(data);
		viewer = new SourceViewer(viewerGroup, null, SWT.BORDER | SWT.FILL_EVEN_ODD);

		// configure source viewer
		document = new Document();
		document.set(value);

		// add completion processor key listener (ctrl+space keys)
		viewer.appendVerifyKeyListener(new LabelKeyListener(viewer));

		document.addDocumentListener(new DocumentListener());
		viewer.configure(configuration.getSourceViewerConfiguration());
		viewer.setDocument(document);

		viewer.setSelectedRange(0, value.length());

		Composite extendedArea = configuration.createExtendedDialogArea(viewerGroup);
		if(extendedArea != null) {
			extendedArea.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL));
		}

		errorMessageText = new CLabel(composite, SWT.READ_ONLY | SWT.SHADOW_NONE);
		errorMessageText.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL));
		errorMessageText.setBackground(errorMessageText.getDisplay().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
		// Set the error message text
		// See https://bugs.eclipse.org/bugs/show_bug.cgi?id=66292
		setErrorMessage(errorMessage);

		applyDialogFont(composite);
		return composite;
	}

	/**
	 * 
	 */
	private class LabelKeyListener implements VerifyKeyListener {

		/**
		 * 
		 */
		SourceViewer viewer;

		/**
		 * Default constructor.
		 * 
		 * @param viewer
		 */
		public LabelKeyListener(SourceViewer viewer) {
			this.viewer = viewer;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.swt.custom.VerifyKeyListener#verifyKey(org.eclipse.swt.events.VerifyEvent)
		 */
		/**
		 * 
		 * 
		 * @param event
		 */
		public void verifyKey(VerifyEvent event) {
			if((event.stateMask == SWT.CTRL) && (event.character == ' ')) {
				if(viewer.canDoOperation(ISourceViewer.CONTENTASSIST_PROPOSALS)) {
					viewer.doOperation(ISourceViewer.CONTENTASSIST_PROPOSALS);
				}
				event.doit = false;
			} else if(event.character == SWT.CR) {
				event.doit = false;
			}
		}
	}

	/**
	 * 
	 */
	private class DocumentListener implements IDocumentListener {

		/**
		 * 
		 * 
		 * @param event
		 */
		public void documentAboutToBeChanged(DocumentEvent event) {
		}

		/**
		 * 
		 * 
		 * @param event
		 */
		public void documentChanged(DocumentEvent event) {
			validateInput();
		}

	}

}
