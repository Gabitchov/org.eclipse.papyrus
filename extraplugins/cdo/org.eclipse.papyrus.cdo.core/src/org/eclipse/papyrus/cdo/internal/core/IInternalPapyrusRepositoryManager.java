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

import java.util.Collection;

import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.common.util.URI;
import org.eclipse.net4j.util.container.IManagedContainer;
import org.eclipse.papyrus.cdo.core.IPapyrusRepository;
import org.eclipse.papyrus.cdo.core.IPapyrusRepositoryManager;

/**
 * This is the IInternalPapyrusRepositoryManager type. Enjoy.
 */
public interface IInternalPapyrusRepositoryManager extends IPapyrusRepositoryManager {

	/** Managed container product group key for model repository-related elements. */
	String PRODUCT_GROUP = Activator.PLUGIN_ID + ".repositories"; //$NON-NLS-1$

	/** Managed container product factory key for the repository manager. */
	String MANAGER_FACTORY = "manager"; //$NON-NLS-1$

	IManagedContainer getSessionsContainer();

	void setURL(IPapyrusRepository repository, String url);

	ICredentialsProviderFactory getCredentialsProviderFactory();

	void setCredentialsProviderFactory(ICredentialsProviderFactory credentialsProviderFactory);

	IInternalPapyrusRepository getRepository(CDOView view);

	//
	// Specializations of inherited API
	//

	@Override
	Collection<? extends IInternalPapyrusRepository> getRepositories();

	@Override
	IInternalPapyrusRepository createRepository(String url);

	@Override
	IInternalPapyrusRepository getRepository(String url);

	@Override
	IInternalPapyrusRepository getRepositoryForURI(URI uri);

	IInternalPapyrusRepository getRepositoryForURI(URI uri, boolean connectedOnly);

}
