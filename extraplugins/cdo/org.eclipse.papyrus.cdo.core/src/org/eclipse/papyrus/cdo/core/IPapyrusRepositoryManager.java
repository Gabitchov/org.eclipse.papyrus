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
package org.eclipse.papyrus.cdo.core;

import java.util.Collection;

import org.eclipse.emf.common.util.URI;

/**
 * This is the IPapyrusRepositoryManager type. Enjoy.
 */
public interface IPapyrusRepositoryManager {

	Collection<? extends IPapyrusRepository> getRepositories();

	IPapyrusRepository createRepository(String url);

	void removeRepository(IPapyrusRepository repository);

	IPapyrusRepository getRepository(String url);

	IPapyrusRepository getRepositoryForURI(URI uri);
	
	void saveRepositories();
}
