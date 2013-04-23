/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.hyperlink.ui;

import org.eclipse.papyrus.infra.hyperlink.messages.Messages;
import org.eclipse.papyrus.infra.hyperlink.object.HyperLinkDocument;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;

/**
 * The Class EditorHyperlinkDocumentShell.
 */
public class EditorHyperlinkDocumentShell extends AbstractEditHyperlinkDocumentShell {

	/** The usedefault tooltip. */
	protected boolean usedefaultTooltip = true;

	/** The hyperlink document. */
	protected HyperLinkDocument hyperlinkDocument;

	/**
	 * Gets the hyperlink document.
	 * 
	 * @return the hyperlinkDocument
	 */
	public HyperLinkDocument getHyperlinkDocument() {
		return hyperlinkDocument;
	}

	/**
	 * Sets the hyperlink document.
	 * 
	 * @param hyperlinkDocument
	 *        the hyperlinkDocument to set
	 */
	public void setHyperlinkDocument(HyperLinkDocument hyperlinkDocument) {
		this.hyperlinkDocument = hyperlinkDocument;
		getObjectLabeltext().setText(getHyperlinkDocument().getHyperlinkDocument());
		getTooltipInputText().setText(getHyperlinkDocument().getTooltipText());
	}

	/**
	 * Open.
	 */
	public void open() {
		Display display = Display.getCurrent();

		// code use to wait for an action from the user
		//		getEditHyperlinkShell().setBounds(500, 500, 600, 120);
		getEditHyperlinkShell().pack();
		getEditHyperlinkShell().open();
		while(!getEditHyperlinkShell().isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Instantiates a new editor hyperlink document shell.
	 */
	public EditorHyperlinkDocumentShell() {
		super();
		createEditHyperlinkShell();

		// intialize "use default" check box
		getUseDefaultCheckBox().setSelection(usedefaultTooltip);
		getObjectLabeltext().setEditable(false);
		if(usedefaultTooltip) {
			getTooltipInputText().setEditable(false);
			getTooltipInputText().setText(getObjectLabeltext().getText());
		}
		// add listener "use default button"
		getUseDefaultCheckBox().addMouseListener(new MouseListener() {

			public void mouseUp(MouseEvent e) {
				usedefaultTooltip = getUseDefaultCheckBox().getSelection();
				if(usedefaultTooltip) {
					getTooltipInputText().setEditable(false);
					getTooltipInputText().setText(getObjectLabeltext().getText());
				} else {
					getTooltipInputText().setEditable(true);
				}
			}

			public void mouseDown(MouseEvent e) {
			}

			public void mouseDoubleClick(MouseEvent e) {
			}
		});

		getChooseDiagramButton().addMouseListener(new MouseListener() {

			public void mouseUp(MouseEvent e) {
			}

			public void mouseDown(MouseEvent e) {
				FileDialog fd = new FileDialog(getEditHyperlinkShell(), SWT.OPEN);
				fd.setText(Messages.EditorHyperlinkDocumentShell_Open);
				String[] filterExt = { "*.pdf", "*.doc", "*.txt", "*" }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
				fd.setFilterExtensions(filterExt);
				String selected = fd.open();
				if(selected != null) {
					getObjectLabeltext().setText(selected);
					if(usedefaultTooltip) {
						getTooltipInputText().setText(selected);
					}
				}
			}

			public void mouseDoubleClick(MouseEvent e) {
			}
		});

		// listener to cancel
		this.getCancelButton().addMouseListener(new MouseListener() {

			public void mouseUp(MouseEvent e) {
			}

			public void mouseDown(MouseEvent e) {
				hyperlinkDocument = null;
				getEditHyperlinkShell().close();
			}

			public void mouseDoubleClick(MouseEvent e) {
			}
		});
		// listener to click on OK
		this.getOkButton().addMouseListener(new MouseListener() {

			public void mouseUp(MouseEvent e) {
			}

			public void mouseDown(MouseEvent e) {
				if(hyperlinkDocument == null) {
					hyperlinkDocument = new HyperLinkDocument();
				}
				hyperlinkDocument.setHyperlinkDocument(getObjectLabeltext().getText().trim());
				hyperlinkDocument.setTooltipText(getTooltipInputText().getText().trim());

				getEditHyperlinkShell().close();
			}

			public void mouseDoubleClick(MouseEvent e) {
			}
		});
	}
}
