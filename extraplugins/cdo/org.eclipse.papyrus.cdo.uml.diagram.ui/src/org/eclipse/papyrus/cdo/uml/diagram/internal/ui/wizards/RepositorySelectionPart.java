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
package org.eclipse.papyrus.cdo.uml.diagram.internal.ui.wizards;

import org.eclipse.jface.operation.IRunnableContext;
import org.eclipse.papyrus.cdo.core.IPapyrusRepository;
import org.eclipse.papyrus.cdo.core.IPapyrusRepositoryManager;
import org.eclipse.papyrus.cdo.internal.ui.wizards.RepositorySelectionBlock;
import org.eclipse.papyrus.uml.diagram.wizards.AbstractSelectStorageProviderPart;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import com.google.common.base.Supplier;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

/**
 * This is the RepositorySelectionPart type. Enjoy.
 */
public class RepositorySelectionPart
		extends AbstractSelectStorageProviderPart {

	private final IPapyrusRepositoryManager repoMan;

	private final Supplier<? extends IRunnableContext> runnableContext;

	private final EventBus bus;

	private RepositorySelectionBlock repoSelectionBlock;

	public RepositorySelectionPart(IPapyrusRepositoryManager repoMan,
			EventBus bus, Supplier<? extends IRunnableContext> runnableContext) {

		super();

		this.repoMan = repoMan;
		this.runnableContext = runnableContext;
		this.bus = bus;
	}

	public Control createControl(Composite parent) {
		bus.register(this);

		repoSelectionBlock = new RepositorySelectionBlock(repoMan, bus,
			runnableContext);

		return repoSelectionBlock.createControl(parent);
	}

	@Override
	protected void enableControls(boolean enabled) {
		repoSelectionBlock.setEnabled(enabled);
	}

	public IPapyrusRepository getSelectedRepository() {
		return (repoSelectionBlock == null)
			? null
			: repoSelectionBlock.getSelectedRepository();
	}

	@Subscribe
	public void setSelectedRepository(IPapyrusRepository repository) {
		firePartCompleteChanged();
	}

	public boolean isPartComplete() {
		return (getSelectedRepository() != null)
			&& getSelectedRepository().isConnected();
	}

}
