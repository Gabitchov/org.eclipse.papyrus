/*****************************************************************************
 * Copyright (c) 2011 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mathieu Velten (Atos Origin) mathieu.velten@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.readonly;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.impl.TransactionalEditingDomainImpl;
import org.eclipse.emf.workspace.IResourceUndoContextPolicy;
import org.eclipse.emf.workspace.WorkspaceEditingDomainFactory;
import org.eclipse.papyrus.commands.CheckedOperationHistory;
import org.eclipse.papyrus.commands.NotifyingWorkspaceCommandStack;
import org.eclipse.papyrus.infra.core.resource.ITransactionalEditingDomainProvider;

public class ReadOnlyTransactionalEditingDomainProvider implements ITransactionalEditingDomainProvider {

	public TransactionalEditingDomain createTransactionalEditingDomain(ResourceSet resourceSet) {
		NotifyingWorkspaceCommandStack stack = new NotifyingWorkspaceCommandStack(CheckedOperationHistory.getInstance());
		stack.setResourceUndoContextPolicy(IResourceUndoContextPolicy.DEFAULT);

		TransactionalEditingDomain result = new TransactionalEditingDomainImpl(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE), stack, resourceSet) {

			@Override
			public boolean isReadOnly(Resource resource) {
				return ReadOnlyManager.isReadOnly(resource);
			}
		};

		WorkspaceEditingDomainFactory.INSTANCE.mapResourceSet(result);

		return result;
	}

}
