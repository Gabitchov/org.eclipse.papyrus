package org.eclipse.papyrus.infra.core.resource;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

public interface ITransactionalEditingDomainProvider {
	TransactionalEditingDomain createTransactionalEditingDomain(ResourceSet resourceSet);
}
