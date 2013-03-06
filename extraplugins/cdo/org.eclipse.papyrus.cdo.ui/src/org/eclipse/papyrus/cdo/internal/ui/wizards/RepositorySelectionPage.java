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
package org.eclipse.papyrus.cdo.internal.ui.wizards;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.papyrus.cdo.core.IPapyrusRepository;
import org.eclipse.papyrus.cdo.internal.core.PapyrusRepositoryManager;
import org.eclipse.papyrus.cdo.internal.ui.properties.RepositoryPropertiesBlock;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;

import com.google.common.base.Suppliers;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

/**
 * This is the RepositorySelectionPage type. Enjoy.
 */
public class RepositorySelectionPage
		extends ModelImportWizardPage {

	private static final String MESSAGE = "Select a repository to import the models into.";

	private RepositorySelectionBlock repoSelectionBlock;

	private RepositoryPropertiesBlock repoBlock;

	public RepositorySelectionPage(EventBus bus) {
		super("repository", "Model Repository", null, bus, MESSAGE);
	}

	public void createControl(Composite parent) {
		initializeDialogUnits(parent);

		Composite result = new Composite(parent, SWT.NONE);
		result.setLayout(new GridLayout(1, false));

		new Label(result, SWT.NONE).setText("Repositories:");

		repoSelectionBlock = new RepositorySelectionBlock(
			PapyrusRepositoryManager.INSTANCE, getEventBus(),
			Suppliers.ofInstance(getContainer()));
		repoSelectionBlock.createControl(result);

		Group group = new Group(result, SWT.BORDER);
		group.setText("Repository details:");
		group.setLayoutData(GridDataFactory.fillDefaults().grab(true, false)
			.create());
		group.setLayout(new GridLayout(1, false));
		repoBlock = new RepositoryPropertiesBlock(getSelectedRepository());
		repoBlock.createControl(group);
		repoBlock.setEditable(false);

		setControl(result);

		validatePage();
	}

	@Override
	public void dispose() {
		repoSelectionBlock.dispose();
		repoBlock.dispose();

		super.dispose();
	}

	@Subscribe
	public void selected(final IPapyrusRepository repository) {
		repoBlock.setRepository(repository);
		validatePage();
	}

	@Override
	protected Diagnostic doValidatePage() {
		Diagnostic result = Diagnostic.CANCEL_INSTANCE;

		if (getSelectedRepository() != null) {
			result = Diagnostic.OK_INSTANCE;
		}

		return result;
	}

	public IPapyrusRepository getSelectedRepository() {
		return (repoSelectionBlock == null)
			? null
			: repoSelectionBlock.getSelectedRepository();
	}
}
