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
package org.eclipse.papyrus.cdo.internal.core;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.cdo.session.CDOSession;
import org.eclipse.emf.cdo.util.CDOURIUtil;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;
import org.eclipse.equinox.security.storage.SecurePreferencesFactory;
import org.eclipse.net4j.util.container.Container;
import org.eclipse.net4j.util.container.ContainerUtil;
import org.eclipse.net4j.util.container.IManagedContainer;
import org.eclipse.net4j.util.io.IOUtil;
import org.eclipse.papyrus.cdo.core.IPapyrusRepository;
import org.eclipse.papyrus.cdo.internal.core.repositories.RepositoriesFactory;
import org.eclipse.papyrus.cdo.internal.core.repositories.RepositoriesPackage;
import org.eclipse.papyrus.cdo.internal.core.repositories.Repository;
import org.eclipse.papyrus.cdo.internal.core.repositories.RepositoryRegistry;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;

/**
 * This is the PapyrusRepositoryManager type. Enjoy.
 */
public class PapyrusRepositoryManager extends Container<IPapyrusRepository> implements IInternalPapyrusRepositoryManager {

	public static final PapyrusRepositoryManager INSTANCE = new PapyrusRepositoryManager();

	private final IRepositoryModelStorage storage;

	private final IManagedContainer container;

	private final RepositoryRegistry repositoryRegistry;

	private final Map<String, IInternalPapyrusRepository> repositories;

	private ICredentialsProviderFactory credentialsProviderFactory;

	public PapyrusRepositoryManager() {
		this(null);
	}

	public PapyrusRepositoryManager(IRepositoryModelStorage storage) {
		this.storage = storage;
		this.container = createContainer();
		this.repositoryRegistry = loadRepositories();
		this.repositories = initializeRepositories();

		activate();

		container.putElement(PRODUCT_GROUP, MANAGER_FACTORY, null, this);
	}

	public void dispose() {
		deactivate();
	}

	private static IManagedContainer createContainer() {
		IManagedContainer result = ContainerUtil.createPluginContainer();

		result.activate();

		return result;
	}

	@Override
	public IManagedContainer getSessionsContainer() {
		return container;
	}

	@Override
	public Collection<? extends IInternalPapyrusRepository> getRepositories() {
		return Collections.unmodifiableCollection(repositories.values());
	}

	@Override
	public IInternalPapyrusRepository createRepository(String url) {
		if(getRepository(url) != null) {
			throw new IllegalArgumentException("repository already exists"); //$NON-NLS-1$
		}

		Repository repository = RepositoriesFactory.eINSTANCE.createRepository();
		repository.setURL(url);
		repositoryRegistry.getRepositories().add(repository);

		PapyrusRepository result = new PapyrusRepository(container, repository);
		repositories.put(url, result);

		fireElementAddedEvent(result);

		return result;
	}

	@Override
	public void setURL(IPapyrusRepository repository, String url) {
		if(!Objects.equal(repository.getURL(), url)) {
			if(getRepository(url) != null) {
				throw new IllegalArgumentException("repository already exists"); //$NON-NLS-1$
			}

			if(repository.isConnected()) {
				throw new IllegalStateException("repository is connected"); //$NON-NLS-1$
			}

			PapyrusRepository internalRepository = (PapyrusRepository)repository;
			repositories.remove(internalRepository.getURL());
			internalRepository.getModel().setURL(url);
			repositories.put(url, internalRepository);
		}
	}

	@Override
	public void removeRepository(IPapyrusRepository repository) {
		if(repository.isConnected()) {
			throw new IllegalArgumentException("repository is still connected"); //$NON-NLS-1$
		}

		repositories.remove(repository.getURL());
		EcoreUtil.delete(((PapyrusRepository)repository).getModel());

		fireElementRemovedEvent(repository);
	}

	@Override
	public IInternalPapyrusRepository getRepository(String url) {
		return repositories.get(url);
	}

	@Override
	public IInternalPapyrusRepository getRepositoryForURI(URI uri) {
		return getRepositoryForURI(uri, true);
	}

	@Override
	public IInternalPapyrusRepository getRepositoryForURI(URI uri, boolean connectedOnly) {
		IInternalPapyrusRepository result = null;

		if(CDOUtils.isCDOURI(uri)) {
			String uuid = CDOURIUtil.extractRepositoryUUID(uri);

			for(IInternalPapyrusRepository next : repositories.values()) {
				CDOSession session = next.getCDOSession();
				if((session != null) && Objects.equal(uuid, session.getRepositoryInfo().getUUID())) {
					result = next;
					break;
				}
			}

			if((result == null) && !connectedOnly) {
				// guess based on the last known UUIDs
				for(IInternalPapyrusRepository next : repositories.values()) {
					PapyrusRepository repo = CDOUtils.tryCast(next, PapyrusRepository.class);
					if((repo != null) && Objects.equal(uuid, repo.getModel().getUUID())) {
						result = next;
						break;
					}
				}
			}
		}

		return result;
	}

	@Override
	public void saveRepositories() {
		if(storage != null) {
			try {
				OutputStream output = storage.createOutputStream();
				try {
					repositoryRegistry.eResource().save(output, null);
				} finally {
					if(output != null) {
						IOUtil.closeSilent(output);
					}
				}
			} catch (IOException e) {
				Activator.log.error("Failed to save model repositories to custom storage.", e); //$NON-NLS-1$
			}
		} else {
			try {
				repositoryRegistry.eResource().save(null);
			} catch (IOException e) {
				Activator.log.error("Failed to save model repositories.", e); //$NON-NLS-1$
			}
		}

		// save passwords, if any
		try {
			SecurePreferencesFactory.getDefault().flush();
		} catch (IOException e) {
			Activator.log.error("Failed to save repository passwords to secure storage.", e); //$NON-NLS-1$
		}
	}

	private RepositoryRegistry loadRepositories() {
		ResourceSet rset = new ResourceSetImpl();
		rset.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xml", new XMLResourceFactoryImpl()); //$NON-NLS-1$

		File repositoriesFile = new File(Activator.getDefault().getStateLocation().toFile(), "repositories.xml"); //$NON-NLS-1$
		URI uri = URI.createFileURI(repositoriesFile.getAbsolutePath());
		Resource resource = rset.createResource(uri);

		if(storage != null) {
			try {
				InputStream input = storage.createInputStream();
				if(input != null) {
					try {
						resource.load(input, null);
					} finally {
						IOUtil.closeSilent(input);
					}
				}
			} catch (Exception e) {
				Activator.log.error("Failed to load repository registry from custom storage.", //$NON-NLS-1$
					e);
			}
		} else {
			if(repositoriesFile.exists()) {
				try {
					resource.load(null);
				} catch (Exception e) {
					Activator.log.error("Failed to load repository registry.", //$NON-NLS-1$
						e);
					// if there's any junk, clear it out
					resource.getContents().clear();
				}
			} else {
				resource = rset.createResource(uri);
			}
		}

		RepositoryRegistry result = (RepositoryRegistry)EcoreUtil.getObjectByType(resource.getContents(), RepositoriesPackage.Literals.REPOSITORY_REGISTRY);

		if(result == null) {
			result = RepositoriesFactory.eINSTANCE.createRepositoryRegistry();
			resource.getContents().add(result);
		}

		return result;
	}

	private Map<String, IInternalPapyrusRepository> initializeRepositories() {
		Map<String, IInternalPapyrusRepository> result = Maps.newHashMap();

		for(Repository next : repositoryRegistry.getRepositories()) {
			result.put(next.getURL(), new PapyrusRepository(container, next));
		}

		return result;
	}

	@Override
	public ICredentialsProviderFactory getCredentialsProviderFactory() {
		return credentialsProviderFactory;
	}

	@Override
	public void setCredentialsProviderFactory(ICredentialsProviderFactory credentialsProviderFactory) {

		this.credentialsProviderFactory = credentialsProviderFactory;
	}

	@Override
	public IInternalPapyrusRepository getRepository(CDOView view) {
		IInternalPapyrusRepository result = null;

		int sessionID = view.getSessionID();

		for(IInternalPapyrusRepository next : repositories.values()) {
			// if it's not connected, it can't be responsible for this view
			if(next.isConnected()) {
				if(next.getCDOSession().getSessionID() == sessionID) {
					result = next;
					break;
				}
			}
		}

		return result;
	}

	//
	// IContainer protocol
	//

	@Override
	public boolean isEmpty() {
		return !isActive() || repositories.isEmpty();
	}

	@Override
	public IPapyrusRepository[] getElements() {
		return Iterables.toArray(repositories.values(), IPapyrusRepository.class);
	}
}
