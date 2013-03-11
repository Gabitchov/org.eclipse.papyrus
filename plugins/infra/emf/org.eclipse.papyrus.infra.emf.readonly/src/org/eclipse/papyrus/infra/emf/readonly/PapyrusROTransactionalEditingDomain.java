/*****************************************************************************
 * Copyright (c) 2011, 2013 Atos Origin, CEA, and others.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mathieu Velten (Atos Origin) mathieu.velten@atosorigin.com - Initial API and implementation
 *  Christian W. Damus (CEA) - Support object-level read/write controls (CDO)
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.readonly;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalCommandStack;
import org.eclipse.emf.transaction.impl.TransactionalEditingDomainImpl;
import org.eclipse.papyrus.infra.core.resource.IReadOnlyProvider;


public class PapyrusROTransactionalEditingDomain
		extends TransactionalEditingDomainImpl
		implements IReadOnlyProvider {

	public PapyrusROTransactionalEditingDomain(AdapterFactory adapterFactory, TransactionalCommandStack stack, ResourceSet resourceSet) {
		super(adapterFactory, stack, resourceSet);
	}

	@Override
	public boolean isReadOnly(Resource resource) {
		return ReadOnlyManager.isReadOnly(resource, this);
	}
	
	public boolean isReadOnly(EObject eObject) {
		return ReadOnlyManager.isReadOnly(eObject, this);
	}
	
	@Override
	public void dispose(){
		super.dispose();
		resourceSet = null;
		adapterFactory = null;
	}
}
