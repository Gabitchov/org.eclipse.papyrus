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
package org.eclipse.emf.facet.efacet.core;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.facet.efacet.core.internal.FacetCommandFactoryFactory;

/**
 * @since 0.3
 */
public interface IFacetCommandFactoryFactory {
	
	IFacetCommandFactoryFactory DEFAULT = new FacetCommandFactoryFactory();
	
	IFacetCommandFactory createCommandFactory(EditingDomain editingDomain);
}
