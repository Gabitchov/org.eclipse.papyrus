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
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.operation.IRunnableContext;
import org.eclipse.papyrus.cdo.core.IPapyrusRepository;
import org.eclipse.papyrus.cdo.core.IPapyrusRepositoryManager;
import org.eclipse.papyrus.cdo.internal.ui.l10n.Messages;
import org.eclipse.papyrus.cdo.internal.ui.wizards.RepositorySelectionBlock;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import com.google.common.base.Supplier;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

/**
 * This is the RepositorySelectionDialog type. Enjoy.
 */
public class RepositorySelectionDialog extends TitleAreaDialog {

	private static final String TITLE = Messages.RepositorySelectionDialog_0;

	private final IPapyrusRepositoryManager repoMan;

	private final Supplier<? extends IRunnableContext> runnableContext;

	private final EventBus bus;

	private final IPapyrusRepository initialSelection;

	private IPapyrusRepository selectedRepository;

	private RepositorySelectionBlock repoSelectionBlock;

	public RepositorySelectionDialog(Shell parentShell, IPapyrusRepositoryManager repoMan, //
		IPapyrusRepository initialSelection, Supplier<? extends IRunnableContext> runnableContext) {

		super(parentShell);

		this.repoMan = repoMan;
		this.runnableContext = runnableContext;
		this.bus = new EventBus("repositorySelectionDialog"); //$NON-NLS-1$
		this.initialSelection = initialSelection;

		setShellStyle(getShellStyle() | SWT.APPLICATION_MODAL | SWT.TITLE);
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText(TITLE);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		setTitle(TITLE);
		setMessage(Messages.RepositorySelectionDialog_1);
		Composite result = (Composite)super.createDialogArea(parent);

		Composite main = new Composite(result, SWT.NONE);
		main.setLayout(new GridLayout());
		GridDataFactory.fillDefaults().grab(true, true).applyTo(main);


		repoSelectionBlock = new RepositorySelectionBlock(repoMan, bus, runnableContext);
		repoSelectionBlock.createControl(main);

		bus.register(this);
		repoSelectionBlock.setSelectedRepository(initialSelection);

		return result;
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		super.createButtonsForButtonBar(parent);

		setSelectedRepository(initialSelection);
	}

	public IPapyrusRepository getSelectedRepository() {
		return selectedRepository;
	}

	@Subscribe
	public void setSelectedRepository(IPapyrusRepository repository) {
		Button ok = getButton(IDialogConstants.OK_ID);

		if(ok != null) {
			ok.setEnabled(repository != null);
		}
	}

	@Override
	protected void okPressed() {
		selectedRepository = repoSelectionBlock.getSelectedRepository();

		super.okPressed();
	}
}
