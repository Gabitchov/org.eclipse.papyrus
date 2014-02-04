/*****************************************************************************
 * Copyright (c) 2011, 2014 Atos, CEA, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mathieu Velten  mathieu.velten@atos.net - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 402525
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.core.resource;

import java.util.Collections;
import java.util.LinkedList;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.impl.TransactionalEditingDomainImpl;
import org.eclipse.emf.workspace.WorkspaceEditingDomainFactory;

/**
 * Manager used to read transactionalEditingDomainProvider extension point
 * and providing an helper method to create an Editing Domain.
 * 
 * @author mvelten
 * 
 */
public class TransactionalEditingDomainManager {

	protected static final ITransactionalEditingDomainProvider[] orderedProvidersArray;

	protected static class ProviderPriorityPair implements Comparable<ProviderPriorityPair> {

		public ITransactionalEditingDomainProvider provider;

		public int priority;

		public int compareTo(ProviderPriorityPair o) {
			if(o.priority > priority) {
				return 1;
			} else if(o.priority < priority) {
				return -1;
			} else {
				return 0;
			}
		}
	}

	static {
		IConfigurationElement[] configElements = Platform.getExtensionRegistry().getConfigurationElementsFor("org.eclipse.papyrus.infra.core", "transactionalEditingDomainProvider");

		LinkedList<ProviderPriorityPair> providerPriorityPairs = new LinkedList<ProviderPriorityPair>();

		for(IConfigurationElement elem : configElements) {
			if("transactionalEditingDomainProvider".equals(elem.getName())) {
				try {
					ProviderPriorityPair providerPriorityPair = new ProviderPriorityPair();
					providerPriorityPair.provider = (ITransactionalEditingDomainProvider)elem.createExecutableExtension("class");
					providerPriorityPair.priority = Integer.parseInt(elem.getAttribute("priority"));

					providerPriorityPairs.add(providerPriorityPair);
				} catch (Exception e) {
				}
			}
		}

		Collections.sort(providerPriorityPairs);

		orderedProvidersArray = new ITransactionalEditingDomainProvider[providerPriorityPairs.size()];

		for(int i = 0; i < orderedProvidersArray.length; i++) {
			orderedProvidersArray[i] = providerPriorityPairs.get(i).provider;
		}
	}

	/**
	 * Create an Editing Domain using the registered provider with the highest priority.
	 * 
	 * @param resourceSet
	 * @return
	 */
	public static TransactionalEditingDomain createTransactionalEditingDomain(ResourceSet resourceSet) {
		for(ITransactionalEditingDomainProvider provider : orderedProvidersArray) {
			TransactionalEditingDomain ed = provider.createTransactionalEditingDomain(resourceSet);
			if(ed != null) {
				return ed;
			}
		}
		return createDefaultTransactionalEditingDomain(resourceSet);
	}

	public static TransactionalEditingDomain createDefaultTransactionalEditingDomain(ResourceSet resourceSet) {
		//		NotifyingWorkspaceCommandStack stack = new NotifyingWorkspaceCommandStack(CheckedOperationHistory.getInstance());
		//		stack.setResourceUndoContextPolicy(IResourceUndoContextPolicy.DEFAULT);

		NestingTransactionalCommandStack stack = new NestingTransactionalCommandStack();
		TransactionalEditingDomain result = new TransactionalEditingDomainImpl(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE), stack, resourceSet);

		WorkspaceEditingDomainFactory.INSTANCE.mapResourceSet(result);

		return result;
	}

	public static TransactionalEditingDomain getTransactionalEditingDomain(ResourceSet resourceSet) {
		return WorkspaceEditingDomainFactory.INSTANCE.getEditingDomain(resourceSet);
	}
}
