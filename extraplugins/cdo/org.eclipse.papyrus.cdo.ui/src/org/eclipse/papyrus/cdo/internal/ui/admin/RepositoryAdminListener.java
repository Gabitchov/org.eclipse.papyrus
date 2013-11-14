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
package org.eclipse.papyrus.cdo.internal.ui.admin;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.net4j.util.ui.UIUtil;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.cdo.core.IPapyrusRepository;
import org.eclipse.papyrus.cdo.core.IPapyrusRepositoryManager;
import org.eclipse.papyrus.cdo.core.admin.IPapyrusRepositoryAdminListener;
import org.eclipse.papyrus.cdo.core.admin.PapyrusRepositoryAdminEvent;
import org.eclipse.papyrus.cdo.internal.ui.l10n.Messages;


/**
 * This is the RepositoryAdminListener type. Enjoy.
 */
public class RepositoryAdminListener implements IPapyrusRepositoryAdminListener {

	private final IPapyrusRepositoryManager repositoryManager;

	public RepositoryAdminListener(IPapyrusRepositoryManager repositoryManager) {
		super();

		this.repositoryManager = repositoryManager;
	}

	@Override
	public void repositoryAdded(PapyrusRepositoryAdminEvent event) {
		final String url = event.getRepositoryURL();

		IPapyrusRepository existing = repositoryManager.getRepository(url);
		if(existing == null) {
			final String name = event.getRepositoryName();
			UIUtil.getDisplay().asyncExec(new Runnable() {

				@Override
				public void run() {
					if(MessageDialog.openQuestion(UIUtil.getActiveWorkbenchWindow().getShell(), Messages.RepositoryAdminListener_0, NLS.bind(Messages.RepositoryAdminListener_1, name))) {
						repositoryManager.createRepository(url).setName(uniqueName(name));
						repositoryManager.saveRepositories();
					}
				}
			});
		}
	}

	@Override
	public void repositoryRemoved(PapyrusRepositoryAdminEvent event) {
		final IPapyrusRepository existing = repositoryManager.getRepository(event.getRepositoryURL());
		if(existing != null) {
			final String name = existing.getName();
			UIUtil.getDisplay().asyncExec(new Runnable() {

				@Override
				public void run() {
					if(MessageDialog.openQuestion(UIUtil.getActiveWorkbenchWindow().getShell(), Messages.RepositoryAdminListener_2, NLS.bind(Messages.RepositoryAdminListener_3, name))) {
						repositoryManager.removeRepository(existing);
						repositoryManager.saveRepositories();
					}
				}
			});
		}
	}

	protected String uniqueName(String preferredName) {
		String result = preferredName;
		int counter = 1;
		boolean again;

		do {
			again = false;
			for(IPapyrusRepository next : repositoryManager.getRepositories()) {
				if(result.equals(next.getName())) {
					result = NLS.bind(Messages.RepositoryAdminListener_4, preferredName, counter++);
					again = true;
					break;
				}
			}
		} while(again);

		return result;
	}
}
