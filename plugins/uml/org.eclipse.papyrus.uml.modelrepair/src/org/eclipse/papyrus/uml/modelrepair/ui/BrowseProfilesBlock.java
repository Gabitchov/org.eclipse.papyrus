/*
 * Copyright (c) 2014 CEA and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA - Initial API and implementation
 *   Christian W. Damus (CEA) - bug 431953 (extracted from SwitchProfileDialog)
 *
 */
package org.eclipse.papyrus.uml.modelrepair.ui;

import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.infra.widgets.editors.TreeSelectorDialog;
import org.eclipse.papyrus.infra.widgets.providers.EncapsulatedContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.StaticContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.WorkspaceContentProvider;
import org.eclipse.papyrus.uml.extensionpoints.profile.RegisteredProfile;
import org.eclipse.papyrus.uml.modelrepair.Activator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import com.google.common.eventbus.EventBus;


/**
 * This is the BrowseProfilesBlock type. Enjoy.
 */
public class BrowseProfilesBlock {

	/** Block style for icon browse buttons. */
	public static final int ICON = 0x00;

	/** Block style for text browser buttons. */
	public static final int TEXT = 0x01;

	private final EventBus bus;

	private final LabelProviderService labelProviderService;

	private Composite control;

	private Button browseWorkspace;

	private Button browseRegistered;

	private boolean enabled = true;

	public BrowseProfilesBlock(EventBus bus, LabelProviderService labelProviderService) {
		super();

		this.bus = bus;
		this.labelProviderService = labelProviderService;
	}

	public Control createControl(Composite parent, int style) {
		control = new Composite(parent, SWT.NONE);

		GridLayout buttonsLayout = new GridLayout(2, false);
		buttonsLayout.marginWidth = 0;

		control.setLayout(buttonsLayout);

		final boolean useText = (style & TEXT) == TEXT;

		browseWorkspace = new Button(control, SWT.PUSH);
		if(useText) {
			browseWorkspace.setText("Workspace...");
		} else {
			browseWorkspace.setImage(org.eclipse.papyrus.infra.widgets.Activator.getDefault().getImage("icons/Add_12x12.gif"));
		}

		browseRegistered = new Button(control, SWT.PUSH);
		if(useText) {
			browseRegistered.setText("Registered...");
		} else {
			browseRegistered.setImage(org.eclipse.papyrus.infra.widgets.Activator.getDefault().getImage(Activator.PLUGIN_ID, "icons/AddReg.gif"));
		}

		SelectionListener buttonListener = new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if(e.widget == browseWorkspace) {
					browseWorkspaceProfiles();
				} else {
					browseRegisteredProfiles();
				}
			}
		};
		browseWorkspace.addSelectionListener(buttonListener);
		browseRegistered.addSelectionListener(buttonListener);

		updateEnablement();

		return control;
	}

	public void setEnabled(boolean enabled) {
		if(enabled != this.enabled) {
			this.enabled = enabled;
			updateEnablement();
		}
	}

	public boolean isEnabled() {
		return enabled;
	}

	protected Shell getShell() {
		return (control == null) ? null : control.getShell();
	}

	protected void updateEnablement() {
		if((browseWorkspace != null) && !browseWorkspace.isDisposed()) {
			browseWorkspace.setEnabled(enabled);
			browseRegistered.setEnabled(enabled);
		}
	}

	protected void browseWorkspaceProfiles() {
		Map<String, String> extensionFilters = new LinkedHashMap<String, String>();
		extensionFilters.put("*.profile.uml", "UML Profiles (*.profile.uml)");
		extensionFilters.put("*.uml", "UML (*.uml)");
		extensionFilters.put("*", "All (*)");

		TreeSelectorDialog dialog = new TreeSelectorDialog(getShell());
		dialog.setTitle("Browse Workspace");
		dialog.setDescription("Select a profile in the workspace.");
		WorkspaceContentProvider workspaceContentProvider = new WorkspaceContentProvider();
		workspaceContentProvider.setExtensionFilters(extensionFilters);
		dialog.setContentProvider(workspaceContentProvider);

		dialog.setLabelProvider(labelProviderService.getLabelProvider());


		if(dialog.open() == Window.OK) {
			Object[] result = dialog.getResult();
			if(result == null || result.length == 0) {
				return;
			}

			Object selectedFile = result[0];

			if(selectedFile instanceof IFile) {
				bus.post((IFile)selectedFile);
			}
		}
	}

	protected void browseRegisteredProfiles() {
		TreeSelectorDialog dialog = new TreeSelectorDialog(getShell());
		dialog.setTitle("Browse Registered Profiles");
		dialog.setDescription("Select one of the registered profiles below.");
		dialog.setContentProvider(new EncapsulatedContentProvider(new StaticContentProvider(RegisteredProfile.getRegisteredProfiles())));
		dialog.setLabelProvider(new LabelProvider() {

			@Override
			public Image getImage(Object element) {
				if(element instanceof RegisteredProfile) {
					RegisteredProfile profile = (RegisteredProfile)element;
					return profile.getImage();
				}
				return super.getImage(element);
			}

			@Override
			public String getText(Object element) {
				if(element instanceof RegisteredProfile) {
					RegisteredProfile profile = (RegisteredProfile)element;
					return profile.name;
				}

				return super.getText(element);
			}
		});

		if(dialog.open() == Window.OK) {
			Object[] result = dialog.getResult();
			if(result == null || result.length == 0) {
				return;
			}

			Object selectedElement = result[0];
			if(selectedElement instanceof RegisteredProfile) {
				bus.post((RegisteredProfile)selectedElement);
			}
		}
	}
}
