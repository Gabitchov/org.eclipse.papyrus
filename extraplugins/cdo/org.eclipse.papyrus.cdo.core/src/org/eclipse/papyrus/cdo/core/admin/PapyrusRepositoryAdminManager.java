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
package org.eclipse.papyrus.cdo.core.admin;

import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import org.eclipse.emf.cdo.admin.CDOAdminClient;
import org.eclipse.emf.cdo.common.admin.CDOAdminRepository;
import org.eclipse.net4j.util.container.ContainerEventAdapter;
import org.eclipse.net4j.util.container.IContainer;
import org.eclipse.papyrus.cdo.internal.core.Activator;

import com.google.common.collect.Maps;


/**
 * This is the PapyrusRepositoryAdminManager type. Enjoy.
 */
public class PapyrusRepositoryAdminManager extends ContainerEventAdapter<CDOAdminClient> {

	private final RepositoryListener repositoryListener = new RepositoryListener();

	private final CopyOnWriteArrayList<IPapyrusRepositoryAdminListener> listeners = new CopyOnWriteArrayList<IPapyrusRepositoryAdminListener>();

	private final Map<CDOAdminRepository, String> repositories = Maps.newConcurrentMap();

	public PapyrusRepositoryAdminManager() {
		super(true);
	}

	public void install(IContainer<? extends CDOAdminClient> container) {
		container.addListener(this);

		for(CDOAdminClient next : container.getElements()) {
			next.addListener(repositoryListener);
		}
	}

	@Override
	protected void onAdded(IContainer<CDOAdminClient> container, CDOAdminClient element) {
		element.addListener(repositoryListener);
	}

	@Override
	protected void onRemoved(IContainer<CDOAdminClient> container, CDOAdminClient element) {
		element.removeListener(repositoryListener);
	}

	public void addRepositoryAdminListener(IPapyrusRepositoryAdminListener listener) {
		listeners.addIfAbsent(listener);
	}

	public void removeRepositoryAdminListener(IPapyrusRepositoryAdminListener listener) {
		listeners.remove(listener);
	}

	protected void fireRepositoryAdminEvent(int eventType, String url, String name) {
		if(!listeners.isEmpty()) {
			PapyrusRepositoryAdminEvent event = new PapyrusRepositoryAdminEvent(this, eventType, url, name);
			for(IPapyrusRepositoryAdminListener next : listeners) {
				try {
					switch(eventType) {
					case PapyrusRepositoryAdminEvent.REPOSITORY_ADDED:
						next.repositoryAdded(event);
						break;
					case PapyrusRepositoryAdminEvent.REPOSITORY_REMOVED:
						next.repositoryRemoved(event);
						break;
					}
				} catch (Exception e) {
					Activator.log.error("Uncaught exception in repository admin listener.", e); //$NON-NLS-1$
				}
			}
		}
	}

	//
	// Nested types
	//

	private class RepositoryListener extends ContainerEventAdapter<CDOAdminRepository> {

		@Override
		protected void onAdded(IContainer<CDOAdminRepository> container, CDOAdminRepository element) {
			if(container instanceof CDOAdminClient) {
				CDOAdminClient client = (CDOAdminClient)container;
				String url = String.format("%s?repositoryName=%s", client.getURL(), element.getName()); //$NON-NLS-1$
				repositories.put(element, url);

				if(client.isConnected()) {
					// Only notify for repositories added while connected, which ensures that we don't
					// get a cascade of events on initial connection and discovery of existing repositories
					fireRepositoryAdminEvent(PapyrusRepositoryAdminEvent.REPOSITORY_ADDED, url, element.getName());
				}
			}
		}

		@Override
		protected void onRemoved(IContainer<CDOAdminRepository> container, CDOAdminRepository element) {
			if(container instanceof CDOAdminClient) {
				CDOAdminClient client = (CDOAdminClient)container;
				String url = repositories.remove(element);

				if((url != null) && client.isConnected()) {
					// Only notify for repositories removed while connected, which ensures that we don't
					// get a cascade of events on disconnection from the server
					fireRepositoryAdminEvent(PapyrusRepositoryAdminEvent.REPOSITORY_REMOVED, url, element.getName());
				}
			}
		}
	}
}
