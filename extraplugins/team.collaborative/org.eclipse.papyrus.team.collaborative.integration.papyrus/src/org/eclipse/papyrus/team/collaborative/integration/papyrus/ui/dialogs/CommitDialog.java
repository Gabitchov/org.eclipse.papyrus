/*******************************************************************************
 * Copyright (c) 2013 Atos
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Arthur Daussy - initial implementation
 *******************************************************************************/
package org.eclipse.papyrus.team.collaborative.integration.papyrus.ui.dialogs;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;


/**
 * Dialog used to gather inforamtion before commit
 */
public class CommitDialog extends PreviewDialog {

	/** The toolkit. */
	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());

	/** The message value text. */
	private Text messageValueText;

	/**
	 * Instantiates a new commit dialog.
	 * 
	 * @param parentShell
	 *        the parent shell
	 * @param labelProvider
	 *        the label provider
	 * @param title
	 *        the title
	 * @param message
	 *        the message
	 */
	public CommitDialog(Shell parentShell, ILabelProvider labelProvider, String title, String message) {
		super(parentShell, labelProvider, title, message);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.team.collaborative.integration.papyrus.ui.dialogs.PreviewDialog#createDialogArea(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Control result = super.createDialogArea(parent);
		commitComposite((Composite)result, SWT.BORDER);
		return result;

	}

	/** The message. */
	protected String message = "";

	/** The keep lock. */
	protected boolean keepLock = false;

	/**
	 * Commit composite.
	 * 
	 * @param parent
	 *        the parent
	 * @param style
	 *        the style
	 * @return the composite
	 */
	public Composite commitComposite(Composite parent, int style) {
		Composite commitComposite = new Composite(parent, style);
		commitComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		toolkit.adapt(commitComposite);
		toolkit.paintBordersFor(commitComposite);
		commitComposite.setLayout(new GridLayout(1, false));

		Label lblMessage = new Label(commitComposite, SWT.NONE);
		toolkit.adapt(lblMessage, true, true);
		lblMessage.setText("Message:");

		messageValueText = new Text(commitComposite, SWT.BORDER);
		messageValueText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		messageValueText.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				message = messageValueText.getMessage();

			}
		});
		toolkit.adapt(messageValueText, true, true);

		Composite composite = new Composite(commitComposite, SWT.NONE);
		toolkit.adapt(composite);
		toolkit.paintBordersFor(composite);
		composite.setLayout(new GridLayout(1, false));
		return commitComposite;
	}


	/**
	 * Gets the commit message.
	 * 
	 * @return the commit message
	 */
	public String getCommitMessage() {
		return message;
	}


	/**
	 * Checks if is keep lock.
	 * 
	 * @return true, if is keep lock
	 */
	public boolean isKeepLock() {
		return keepLock;
	}



}
