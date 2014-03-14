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

import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.papyrus.infra.emf.readonly.PapyrusROTransactionalEditingDomain;
import org.eclipse.papyrus.infra.emf.readonly.PapyrusROTransactionalEditingDomainProvider;
import org.eclipse.papyrus.junit.utils.rules.AbstractModelFixture;


/**
 * This is the PapyrusROEditingDomainFixture type. Enjoy.
 */
public class PapyrusROEditingDomainFixture extends AbstractModelFixture<PapyrusROTransactionalEditingDomain> {

	public PapyrusROEditingDomainFixture() {
		super();
	}

	protected PapyrusROTransactionalEditingDomain createEditingDomain() {
		return (PapyrusROTransactionalEditingDomain)new PapyrusROTransactionalEditingDomainProvider().createTransactionalEditingDomain(new ResourceSetImpl());
	}
}
