package org.eclipse.papyrus.readonly;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalCommandStack;
import org.eclipse.emf.transaction.impl.TransactionalEditingDomainImpl;


public class PapyrusROTransactionalEditingDomain extends TransactionalEditingDomainImpl {
	public PapyrusROTransactionalEditingDomain(AdapterFactory adapterFactory, TransactionalCommandStack stack, ResourceSet resourceSet) {
		super(adapterFactory, stack, resourceSet);
	}

	@Override
	public boolean isReadOnly(Resource resource) {
		return ReadOnlyManager.isReadOnly(resource, this);
	}
}
