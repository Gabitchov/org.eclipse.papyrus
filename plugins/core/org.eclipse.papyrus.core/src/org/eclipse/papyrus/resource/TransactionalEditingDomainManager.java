package org.eclipse.papyrus.resource;

import java.util.Collections;
import java.util.LinkedList;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.impl.TransactionalEditingDomainImpl;
import org.eclipse.emf.workspace.IResourceUndoContextPolicy;
import org.eclipse.emf.workspace.WorkspaceEditingDomainFactory;
import org.eclipse.papyrus.commands.CheckedOperationHistory;
import org.eclipse.papyrus.commands.NotifyingWorkspaceCommandStack;

public class TransactionalEditingDomainManager {

	protected static final ITransactionalEditingDomainProvider[] orderedProvidersArray;

	protected static class ProviderPriorityPair implements Comparable<ProviderPriorityPair> {

		public ITransactionalEditingDomainProvider provider;
		public int priority;

		public int compareTo(ProviderPriorityPair o) {
			if (o.priority > priority) {
				return 1;
			} else if (o.priority < priority) {
				return -1;
			} else {
				return 0;
			}
		}
	}

	static {
		IConfigurationElement[] configElements = Platform.getExtensionRegistry().getConfigurationElementsFor("org.eclipse.papyrus.core", "transactionalEditingDomainProvider");

		LinkedList<ProviderPriorityPair> providerPriorityPairs = new LinkedList<ProviderPriorityPair>();

		for(IConfigurationElement elem : configElements) {
			if ("transactionalEditingDomainProvider".equals(elem.getName())) {
				try {
					ProviderPriorityPair providerPriorityPair = new ProviderPriorityPair();
					providerPriorityPair.provider = (ITransactionalEditingDomainProvider) elem.createExecutableExtension("class");
					providerPriorityPair.priority = Integer.parseInt(elem.getAttribute("priority"));

					providerPriorityPairs.add(providerPriorityPair);
				} catch (Exception e) {
				}
			}
		}

		Collections.sort(providerPriorityPairs);

		orderedProvidersArray = new ITransactionalEditingDomainProvider[providerPriorityPairs.size()];

		for (int i = 0; i < orderedProvidersArray.length; i++) {
			orderedProvidersArray[i] = providerPriorityPairs.get(i).provider;
		}
	}

	public static TransactionalEditingDomain createTransactionalEditingDomain(ResourceSet resourceSet) {
		for (ITransactionalEditingDomainProvider provider : orderedProvidersArray) {
			TransactionalEditingDomain ed = provider.createTransactionalEditingDomain(resourceSet);
			if (ed != null) {
				return ed;
			}
		}
		return createDefaultTransactionalEditingDomain(resourceSet);
	}

	public static TransactionalEditingDomain createDefaultTransactionalEditingDomain(ResourceSet resourceSet) {
		NotifyingWorkspaceCommandStack stack = new NotifyingWorkspaceCommandStack(CheckedOperationHistory.getInstance());
		stack.setResourceUndoContextPolicy(IResourceUndoContextPolicy.DEFAULT);

		TransactionalEditingDomain result = new TransactionalEditingDomainImpl(
				new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE), stack,	resourceSet);

		WorkspaceEditingDomainFactory.INSTANCE.mapResourceSet(result);

		return result;
	}
}
