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
package org.eclipse.papyrus.cdo.core.resource;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.IResourceUndoContextPolicy;
import org.eclipse.emf.workspace.WorkspaceEditingDomainFactory;
import org.eclipse.papyrus.commands.CheckedOperationHistory;
import org.eclipse.papyrus.commands.NotifyingWorkspaceCommandStack;
import org.eclipse.papyrus.infra.emf.readonly.PapyrusROTransactionalEditingDomainProvider;

/**
 * This is the CDOAwareTransactionalEditingDomainProvider type. Enjoy.
 */
public class CDOAwareTransactionalEditingDomainProvider
		extends PapyrusROTransactionalEditingDomainProvider {

	public CDOAwareTransactionalEditingDomainProvider() {
		super();
	}

	@Override
	public TransactionalEditingDomain createTransactionalEditingDomain(
			ResourceSet resourceSet) {

		NotifyingWorkspaceCommandStack stack = new NotifyingWorkspaceCommandStack(
			CheckedOperationHistory.getInstance());
		stack.setResourceUndoContextPolicy(IResourceUndoContextPolicy.DEFAULT);

		TransactionalEditingDomain result = new CDOAwareTransactionalEditingDomain(
			new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE), stack,
			resourceSet);

		WorkspaceEditingDomainFactory.INSTANCE.mapResourceSet(result);

		return result;
	}
}
