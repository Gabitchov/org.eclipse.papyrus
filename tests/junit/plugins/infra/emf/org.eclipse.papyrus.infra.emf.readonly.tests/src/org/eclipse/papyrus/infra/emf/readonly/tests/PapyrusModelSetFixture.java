/*
 * Copyright (c) 2014 CEA and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus (CEA) - Initial API and implementation
 *
 */
package org.eclipse.papyrus.infra.emf.readonly.tests;

import static org.junit.Assert.fail;

import java.util.Collections;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.resource.EditingDomainServiceFactory;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.ServiceDescriptor;
import org.eclipse.papyrus.infra.core.services.ServiceDescriptor.ServiceTypeKind;
import org.eclipse.papyrus.infra.core.services.ServiceStartKind;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.emf.readonly.PapyrusROTransactionalEditingDomain;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForResourceInitializerService;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForResourceSet;
import org.eclipse.papyrus.junit.utils.rules.AbstractModelFixture;
import org.junit.runner.Description;


/**
 * This is the PapyrusModelSetFixture type. Enjoy.
 */
public class PapyrusModelSetFixture extends AbstractModelFixture<PapyrusROTransactionalEditingDomain> {

	public PapyrusModelSetFixture() {
		super();
	}

	protected PapyrusROTransactionalEditingDomain createEditingDomain() {
		try {
			ServicesRegistry services = createServiceRegistry();
			return (PapyrusROTransactionalEditingDomain)services.getService(ModelSet.class).getTransactionalEditingDomain();
		} catch (Exception e) {
			e.printStackTrace();
			fail("Failed to initialize service registry and/or editing domain: " + e.getLocalizedMessage());
			return null; // unreachable
		}
	}

	@Override
	protected void finished(Description description) {
		ResourceSet rset = getEditingDomain().getResourceSet();

		try {
			ServicesRegistry services = ServiceUtilsForResourceSet.getInstance().getServiceRegistry(rset);
			services.disposeRegistry();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			super.finished(description);
		}
	}

	protected ServicesRegistry createServiceRegistry() throws Exception {
		ServicesRegistry result = new ServicesRegistry();
		result.add(ModelSet.class, 10, new ModelSet());
		result.add(ServiceUtilsForResourceInitializerService.class, 10, new ServiceUtilsForResourceInitializerService());

		ServiceDescriptor desc = new ServiceDescriptor(TransactionalEditingDomain.class, EditingDomainServiceFactory.class.getName(), ServiceStartKind.STARTUP, 10, Collections.singletonList(ModelSet.class.getName()));
		desc.setServiceTypeKind(ServiceTypeKind.serviceFactory);
		desc.setClassBundleID(org.eclipse.papyrus.infra.core.Activator.PLUGIN_ID);
		result.add(desc);

		result.startRegistry();

		return result;
	}
}
