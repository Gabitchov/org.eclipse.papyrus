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
public class PapyrusRepositoryManager
		extends Container<IPapyrusRepository>
		implements IInternalPapyrusRepositoryManager {

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
	}

	public void dispose() {
		deactivate();
	}

	private static IManagedContainer createContainer() {
		IManagedContainer result = ContainerUtil.createPluginContainer();

		result.activate();

		return result;
	}

	public IManagedContainer getSessionsContainer() {
		return container;
	}

	public Collection<? extends IPapyrusRepository> getRepositories() {
		return Collections.unmodifiableCollection(repositories.values());
	}

	public IPapyrusRepository createRepository(String url) {
		if (getRepository(url) != null) {
			throw new IllegalArgumentException("repository already exists");
		}

		Repository repository = RepositoriesFactory.eINSTANCE
			.createRepository();
		repository.setURL(url);
		repositoryRegistry.getRepositories().add(repository);

		PapyrusRepository result = new PapyrusRepository(container, repository);
		repositories.put(url, result);

		fireElementAddedEvent(result);

		return result;
	}

	public void setURL(IPapyrusRepository repository, String url) {
		if (!Objects.equal(repository.getURL(), url)) {
			if (getRepository(url) != null) {
				throw new IllegalArgumentException("repository already exists");
			}

			if (repository.isConnected()) {
				throw new IllegalStateException("repository is connected");
			}

			PapyrusRepository internalRepository = (PapyrusRepository) repository;
			repositories.remove(internalRepository.getURL());
			internalRepository.getModel().setURL(url);
			repositories.put(url, internalRepository);
		}
	}

	public void removeRepository(IPapyrusRepository repository) {
		if (repository.isConnected()) {
			throw new IllegalArgumentException("repository is still connected");
		}

		repositories.remove(repository.getURL());
		EcoreUtil.delete(((PapyrusRepository) repository).getModel());

		fireElementRemovedEvent(repository);
	}

	public IPapyrusRepository getRepository(String url) {
		return repositories.get(url);
	}

	public IPapyrusRepository getRepositoryForURI(URI uri) {
		IPapyrusRepository result = null;

		if (CDOUtils.isCDOURI(uri)) {
			String uuid = CDOURIUtil.extractRepositoryUUID(uri);
	
			for (IInternalPapyrusRepository next : repositories.values()) {
				CDOSession session = next.getCDOSession();
				if ((session != null)
					&& Objects.equal(uuid, session.getRepositoryInfo().getUUID())) {
	
					result = next;
					break;
				}
			}
		}
		
		return result;
	}

	public void saveRepositories() {
		if (storage != null) {
			try {
				OutputStream output = storage.createOutputStream();
				try {
					repositoryRegistry.eResource().save(output, null);
				} finally {
					if (output != null) {
						IOUtil.closeSilent(output);
					}
				}
			} catch (IOException e) {
				Activator.log.error(
					"Failed to save model repositories to custom storage.", e);
			}
		} else {
			try {
				repositoryRegistry.eResource().save(null);
			} catch (IOException e) {
				Activator.log.error("Failed to save model repositories.", e);
			}
		}

		// save passwords, if any
		try {
			SecurePreferencesFactory.getDefault().flush();
		} catch (IOException e) {
			Activator.log.error(
				"Failed to save repository passwords to secure storage.", e);
		}
	}

	private RepositoryRegistry loadRepositories() {
		ResourceSet rset = new ResourceSetImpl();
		rset.getResourceFactoryRegistry().getExtensionToFactoryMap()
			.put("xml", new XMLResourceFactoryImpl());

		File repositoriesFile = new File(Activator.getDefault()
			.getStateLocation().toFile(), "repositories.xml");
		URI uri = URI.createFileURI(repositoriesFile.getAbsolutePath());
		Resource resource = rset.createResource(uri);

		if (storage != null) {
			try {
				InputStream input = storage.createInputStream();
				if (input != null) {
					try {
						resource.load(input, null);
					} finally {
						IOUtil.closeSilent(input);
					}
				}
			} catch (Exception e) {
				Activator.log.error(
					"Failed to load repository registry from custom storage.",
					e);
			}
		} else {
			if (repositoriesFile.exists()) {
				try {
					resource.load(null);
				} catch (Exception e) {
					Activator.log.error("Failed to load repository registry.",
						e);
					// if there's any junk, clear it out
					resource.getContents().clear();
				}
			} else {
				resource = rset.createResource(uri);
			}
		}

		RepositoryRegistry result = (RepositoryRegistry) EcoreUtil
			.getObjectByType(resource.getContents(),
				RepositoriesPackage.Literals.REPOSITORY_REGISTRY);

		if (result == null) {
			result = RepositoriesFactory.eINSTANCE.createRepositoryRegistry();
			resource.getContents().add(result);
		}

		return result;
	}

	private Map<String, IInternalPapyrusRepository> initializeRepositories() {
		Map<String, IInternalPapyrusRepository> result = Maps.newHashMap();

		for (Repository next : repositoryRegistry.getRepositories()) {
			result.put(next.getURL(), new PapyrusRepository(container, next));
		}

		return result;
	}

	public ICredentialsProviderFactory getCredentialsProviderFactory() {
		return credentialsProviderFactory;
	}

	public void setCredentialsProviderFactory(
			ICredentialsProviderFactory credentialsProviderFactory) {

		this.credentialsProviderFactory = credentialsProviderFactory;
	}

	//
	// IContainer protocol
	//

	public boolean isEmpty() {
		return !isActive() || repositories.isEmpty();
	}

	public IPapyrusRepository[] getElements() {
		return Iterables.toArray(repositories.values(),
			IPapyrusRepository.class);
	}
}
