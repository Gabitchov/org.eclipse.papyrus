/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.cdo.internal.ui.dialogs;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.papyrus.cdo.internal.ui.l10n.Messages;
import org.eclipse.papyrus.cdo.internal.ui.properties.RepositoryPropertiesBlock;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

/**
 * This is the AddRepositoryDialog type. Enjoy.
 */
public class AddRepositoryDialog
		extends TitleAreaDialog {

	private static final String TITLE = Messages.AddRepositoryDialog_0;
	
	private static final String MESSAGE = Messages.AddRepositoryDialog_1;

	private RepositoryPropertiesBlock block;

	public AddRepositoryDialog(Shell parentShell) {
		super(parentShell);
		setShellStyle(getShellStyle() | SWT.APPLICATION_MODAL | SWT.TITLE
			| SWT.RESIZE);
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText(TITLE);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		setTitle(TITLE);
		setMessage(MESSAGE);

		Composite result = (Composite) super.createDialogArea(parent);
		
		block = new RepositoryPropertiesBlock();
		block.createControl(result);

		block
			.addListener(new RepositoryPropertiesBlock.StatusChangedMessageProviderAdapter() {

				@Override
				protected void handleMessageChange(String message,
						int messageSeverity) {

					Button okButton = getButton(IDialogConstants.OK_ID);
					okButton
						.setEnabled(messageSeverity == IMessageProvider.NONE);

					if (message == null) {
						setMessage(MESSAGE);
					} else {
						setMessage(message, messageSeverity);
					}
				}
			});

		return result;
	}

	@Override
	protected Control createContents(Composite parent) {
		Control result = super.createContents(parent);

		block.update();

		return result;
	}

	@Override
	protected void okPressed() {
		block.finish();

		super.okPressed();
	}

	public String getName() {
		return block.getName();
	}

	public String getURL() {
		return block.getURL();
	}
}
