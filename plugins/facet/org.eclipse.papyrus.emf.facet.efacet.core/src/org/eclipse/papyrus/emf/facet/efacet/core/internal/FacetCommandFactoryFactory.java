/**
 * Copyright (c) 2012 Mia-Software.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  	Grégoire Dupé (Mia-Software) - Bug 387470 - [EFacet][Custom] Editors
 */
package org.eclipse.papyrus.emf.facet.efacet.core.internal;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.emf.facet.efacet.core.IFacetCommandFactoryFactory;
import org.eclipse.papyrus.emf.facet.efacet.core.IFacetCommandFactory;

public class FacetCommandFactoryFactory implements IFacetCommandFactoryFactory {

	public IFacetCommandFactory createCommandFactory(
			final EditingDomain editingDomain) {
		return new FacetCommandFactoryImpl(editingDomain);
	}

}
