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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.resource.ResourceSet;


/**
 * Protocol for a CDO repository in the Papyrus system.
 */
public interface IPapyrusRepository {

	String getName();

	void setName(String name);

	String getURL();

	String getUsername();

	void setUsername(String username);

	String getPassword();

	void setPassword(String password);

	void clearCredentials();

	boolean isConnected();

	IStatus connect();

	void disconnect() throws CommitException;

	Collection<ResourceSet> getTransactions();

	Collection<ResourceSet> getReadOnlyViews();

	ResourceSet createReadOnlyView(ResourceSet resourceSet);

	ResourceSet createTransaction(ResourceSet resourceSet);

	void commit(ResourceSet transaction) throws CommitException;

	void rollback(ResourceSet transaction);

	void close(ResourceSet view);

	void addResourceSetDisposalApprover(IResourceSetDisposalApprover approver);

	void removeResourceSetDisposalApprover(IResourceSetDisposalApprover approver);

	void addPapyrusRepositoryListener(IPapyrusRepositoryListener listener);

	void removePapyrusRepositoryListener(IPapyrusRepositoryListener listener);
}
