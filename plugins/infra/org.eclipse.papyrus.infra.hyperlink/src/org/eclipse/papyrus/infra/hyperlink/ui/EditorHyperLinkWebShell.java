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
import org.eclipse.papyrus.infra.hyperlink.object.HyperLinkWeb;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.widgets.Display;

/**
 * The Class HyperlinkWebEditor is used to add or modify an hyperlink web entry.
 * you can use the default button for the tooltip.
 */
public class EditorHyperLinkWebShell extends AbstractEditHyperlinkShell {

	/** The Constant HYPERLINKS_LABEL. */
	protected static final String HYPERLINKS_LABEL = Messages.EditorHyperLinkWebShell_Hyperlinks;

	/** The Constant HTTP. */
	protected static final String HTTP = "http://"; //$NON-NLS-1$

	/** The hyper link web. */
	private HyperLinkWeb hyperLinkWeb = null;

	/** The usedefault tooltip. */
	private boolean usedefaultTooltip = true;

	/**
	 * Open.
	 */
	public void open() {
		Display display = Display.getCurrent();

		// code use to wait for an action from the user
		getEditHyperlinkShell().pack();
		//		getEditHyperlinkShell().setBounds(500, 500, 600, 120);
		getEditHyperlinkShell().open();
		while(!getEditHyperlinkShell().isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Instantiates a new hyperlink web editor.
	 */
	public EditorHyperLinkWebShell() {
		super();
		createEditHyperlinkShell();

		this.getObjectcLabel().setText(HYPERLINKS_LABEL);
		// fill information
		if(hyperLinkWeb != null) {
			this.getObjectLabeltext().setText(hyperLinkWeb.getHyperLinkWeb());
			this.getTooltipInputText().setText(hyperLinkWeb.getTooltipText());
		} else {
			this.getObjectLabeltext().setText(HTTP);
			this.getObjectLabeltext().setSelection(HTTP.length());
		}
		// listener to cancel
		this.getCancelButton().addMouseListener(new MouseListener() {

			public void mouseUp(MouseEvent e) {
			}

			public void mouseDown(MouseEvent e) {
				hyperLinkWeb = null;
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
				if(hyperLinkWeb == null) {
					hyperLinkWeb = new HyperLinkWeb();
				}
				hyperLinkWeb.setHyperLinkWeb(getObjectLabeltext().getText().trim());
				hyperLinkWeb.setTooltipText(getTooltipInputText().getText().trim());

				getEditHyperlinkShell().close();
			}

			public void mouseDoubleClick(MouseEvent e) {
			}
		});
		// intialize "use default" check box
		getUseDefaultCheckBox().setSelection(usedefaultTooltip);
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

		// add a key listener on inputText to synchronize with the tooltip in
		// the case of use
		// default
		getObjectLabeltext().addKeyListener(new KeyListener() {

			public void keyReleased(KeyEvent e) {
				if(usedefaultTooltip) {
					getTooltipInputText().setText(getObjectLabeltext().getText());
				}
			}

			public void keyPressed(KeyEvent e) {
			}
		});
	}

	/**
	 * Gets the hyper link web.
	 * 
	 * @return the hyperLinkWeb
	 */
	public HyperLinkWeb getHyperLinkWeb() {
		return hyperLinkWeb;
	}

	/**
	 * Sets the hyper link web.
	 * 
	 * @param hyperLinkWeb
	 *        the hyperLinkWeb to set
	 */
	public void setHyperLinkWeb(HyperLinkWeb hyperLinkWeb) {
		this.hyperLinkWeb = hyperLinkWeb;
		this.getObjectLabeltext().setText(hyperLinkWeb.getHyperLinkWeb());
		this.getTooltipInputText().setText(hyperLinkWeb.getTooltipText());
	}

}
