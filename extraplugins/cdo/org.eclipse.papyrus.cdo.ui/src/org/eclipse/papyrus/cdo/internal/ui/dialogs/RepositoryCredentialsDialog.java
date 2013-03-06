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

import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.net4j.util.security.IPasswordCredentials;
import org.eclipse.net4j.util.security.PasswordCredentials;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.cdo.core.IPapyrusRepository;
import org.eclipse.papyrus.cdo.internal.core.PapyrusRepositoryManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * This is the AddRepositoryDialog type. Enjoy.
 */
public class RepositoryCredentialsDialog
		extends TitleAreaDialog {

	private static final String TITLE = "Repository Login";

	private static final String MESSAGE = "Enter your credentials for the repository \"{0}\".";

	private final IPapyrusRepository repository;

	private final String message;

	private Text usernameText;

	private Text passwordText;

	private Button rememberCheckbox;

	private IPasswordCredentials credentials;

	public RepositoryCredentialsDialog(Shell parentShell,
			IPapyrusRepository repository) {
		super(parentShell);
		setShellStyle(getShellStyle() | SWT.APPLICATION_MODAL | SWT.TITLE);

		this.repository = repository;
		message = NLS.bind(MESSAGE, repository.getName());
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText(TITLE);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		setTitle(TITLE);
		setMessage(message);

		Composite result = (Composite) super.createDialogArea(parent);

		Composite main = new Composite(result, SWT.NONE);
		main.setLayout(new GridLayout(2, false));
		GridDataFactory.fillDefaults().grab(true, true).applyTo(main);

		new Label(main, SWT.NONE).setText("User name:");
		usernameText = new Text(main, SWT.BORDER);
		GridDataFactory.fillDefaults().applyTo(usernameText);

		new Label(main, SWT.NONE).setText("Password:");
		passwordText = new Text(main, SWT.BORDER | SWT.PASSWORD);
		GridDataFactory.fillDefaults().applyTo(passwordText);

		rememberCheckbox = new Button(main, SWT.CHECK);
		rememberCheckbox.setText("Remember login for this repository");
		GridDataFactory.fillDefaults().span(2, 1).applyTo(rememberCheckbox);

		if (repository.getUsername() != null) {
			usernameText.setText(repository.getUsername());
		}

		if (repository.getPassword() != null) {
			passwordText.setText(repository.getPassword());
		}

		return result;
	}

	@Override
	protected Control createContents(Composite parent) {
		Control result = super.createContents(parent);

		// the shell is bigger than it needs to be, by default (in English)
		getShell().pack();

		return result;
	}

	@Override
	protected void okPressed() {
		String username = usernameText.getText().trim();
		String password = passwordText.getText().trim();
		credentials = new PasswordCredentials(username, password.toCharArray());

		if (rememberCheckbox.getSelection()) {
			repository.setUsername(username);
			repository.setPassword(password);
			PapyrusRepositoryManager.INSTANCE.saveRepositories();
		}

		super.okPressed();
	}

	public IPasswordCredentials getCredentials() {
		return credentials;
	}
}
