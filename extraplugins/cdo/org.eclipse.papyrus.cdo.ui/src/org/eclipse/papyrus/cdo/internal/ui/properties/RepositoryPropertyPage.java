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
package org.eclipse.papyrus.cdo.internal.ui.properties;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.papyrus.cdo.core.CommitException;
import org.eclipse.papyrus.cdo.core.IPapyrusRepository;
import org.eclipse.papyrus.cdo.internal.core.IInternalPapyrusRepositoryManager;
import org.eclipse.papyrus.cdo.internal.core.PapyrusRepositoryManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.dialogs.PropertyPage;
import org.eclipse.ui.statushandlers.IStatusAdapterConstants;
import org.eclipse.ui.statushandlers.StatusAdapter;
import org.eclipse.ui.statushandlers.StatusManager;

import com.google.common.base.Objects;

/**
 * This is the RepositoryPropertyPage type. Enjoy.
 */
public class RepositoryPropertyPage
		extends PropertyPage {

	private static final String MESSAGE = "Edit the repository name and location.";

	private RepositoryPropertiesBlock block;
	
	private Button forgetCredsButton;

	@Override
	protected Control createContents(Composite parent) {
		setMessage(MESSAGE);

		Composite result = new Composite(parent, SWT.NONE);
		result.setLayout(new GridLayout(1, false));
		
		block = new RepositoryPropertiesBlock(getRepository());
		block.createControl(result);
		block
			.addListener(new RepositoryPropertiesBlock.StatusChangedMessageProviderAdapter() {

				@Override
				protected void handleMessageChange(String message,
						int messageSeverity) {

					setValid(messageSeverity < IMessageProvider.ERROR);

					if (message == null) {
						setMessage(MESSAGE);
					} else {
						setMessage(message, messageSeverity);
					}
				}
			});
		
		forgetCredsButton = new Button(result, SWT.PUSH);
		forgetCredsButton.setText("Clear stored password");
		forgetCredsButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getRepository().clearCredentials();
			}
		});

		return result;
	}

	protected IPapyrusRepository getRepository() {
		IAdaptable element = getElement();
		IPapyrusRepository result = (element instanceof IPapyrusRepository)
			? (IPapyrusRepository) element
			: (IPapyrusRepository) element.getAdapter(IPapyrusRepository.class);

		return result;
	}

	@Override
	public boolean performOk() {
		boolean result = false;

		block.finish();

		if (block.getStatus().isOK()) {
			IPapyrusRepository repository = getRepository();

			if (!repository.isConnected()
				|| Objects.equal(repository.getURL(), block.getURL())
				|| MessageDialog
					.openQuestion(
						getShell(),
						"Repository Connected",
						"The repository will have to be disconnected in order to apply these changes.  Proceed?")) {

				updateRepository(repository);

				result = super.performOk();
			}
		}

		return result;
	}

	@Override
	protected void performDefaults() {
		block.reset();
	}

	private void updateRepository(IPapyrusRepository repository) {
		boolean reconnect = repository.isConnected()
			&& !Objects.equal(repository.getURL(), block.getURL());

		IInternalPapyrusRepositoryManager mgr = PapyrusRepositoryManager.INSTANCE;
		String url = block.getURL();

		try {
			if (reconnect) {
				repository.disconnect();
			}

			repository.setName(block.getName());
			mgr.setURL(repository, url);

			mgr.saveRepositories();

			if (reconnect) {
				// if it was connected, re-connect
				repository.connect();
			}
		} catch (CommitException e) {
			StatusAdapter adapter = new StatusAdapter(e.getStatus());
			adapter.setProperty(IStatusAdapterConstants.TITLE_PROPERTY,
				"Disconnect failed");
			StatusManager.getManager().handle(adapter, StatusManager.SHOW);
		}
	}
}
