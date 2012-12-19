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
package org.eclipse.papyrus.infra.emf.readonly;

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
	
	@Override
	public void dispose(){
		super.dispose();
		resourceSet = null;
		adapterFactory = null;
	}
}
