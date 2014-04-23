/*
 * Copyright (c) 2014 CEA and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus (CEA) - Initial API and implementation
 *
 */
package org.eclipse.papyrus.uml.modelrepair.ui;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.window.IShellProvider;
import org.eclipse.jface.window.SameShellProvider;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.uml.extensionpoints.profile.RegisteredProfile;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;


/**
 * This is the BrowseProfilesDialog type. Enjoy.
 */
public class BrowseProfilesDialog extends TrayDialog {

	private final LabelProviderService labelProviderService;

	private Text profileText;

	private URI selectedProfileURI;

	public BrowseProfilesDialog(Shell shell, LabelProviderService labelProviderService) {
		this(new SameShellProvider(shell), labelProviderService);
	}

	public BrowseProfilesDialog(IShellProvider parentShell, LabelProviderService labelProviderService) {
		super(parentShell);

		this.labelProviderService = labelProviderService;
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);

		newShell.setText("Apply Profile");
		newShell.setMinimumSize(300, 150);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite contents = (Composite)super.createDialogArea(parent);

		Composite main = new Composite(contents, SWT.NONE);
		main.setLayout(new GridLayout(2, false));
		main.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		Label messageLabel = new Label(main, SWT.WRAP);
		messageLabel.setText("Select a registered or a workspace profile to apply for recovery of unrecognized stereotypes.");
		GridData span2 = new GridData(SWT.FILL, SWT.BEGINNING, true, false);
		span2.horizontalSpan = 2;
		messageLabel.setLayoutData(span2);

		EventBus bus = new EventBus("profileSelection"); //$NON-NLS-1$
		BrowseProfilesBlock block = new BrowseProfilesBlock(bus, labelProviderService);
		block.createControl(main, BrowseProfilesBlock.TEXT).setLayoutData(new GridData(SWT.END, SWT.CENTER, false, false, 2, 1));

		Label profileLabel = new Label(main, SWT.NONE);
		profileLabel.setText("Profile:");
		profileText = new Text(main, SWT.BORDER | SWT.READ_ONLY);
		profileText.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));

		bus.register(new Object() {

			@Subscribe
			public void workspaceProfileSelected(IFile file) {
				IPath filePath = file.getFullPath();
				setSelectedProfileURI(URI.createPlatformResourceURI(filePath.toPortableString(), true));

				updateProfile();
			}

			@Subscribe
			public void registeredProfileSelected(RegisteredProfile profile) {
				setSelectedProfileURI(profile.uri);
			}
		});

		return contents;
	}

	protected Control createContents(Composite parent) {
		setHelpAvailable(false);
		Control result = super.createContents(parent);
		updateProfile();
		return result;
	}

	public void setSelectedProfileURI(URI selectedProfileURI) {
		this.selectedProfileURI = selectedProfileURI;
		updateProfile();
	}

	public URI getSelectedProfileURI() {
		return selectedProfileURI;
	}

	@Override
	protected void cancelPressed() {
		selectedProfileURI = null;
		super.cancelPressed();
	}

	protected void updateProfile() {
		if((profileText != null) && !profileText.isDisposed()) {
			if(selectedProfileURI == null) {
				profileText.setText(""); //$NON-NLS-1$
			} else {
				profileText.setText(selectedProfileURI.toString());
			}

			getButton(IDialogConstants.OK_ID).setEnabled(selectedProfileURI != null);
		}
	}
}
