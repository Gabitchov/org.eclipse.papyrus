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
package org.eclipse.emf.facet.custom.sdk.core.internal;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.facet.custom.sdk.core.ICustomizationCommandFactory;
import org.eclipse.emf.facet.custom.sdk.core.ICustomizationCommandFactoryFactory;

public class CustomizationCommandFactoryFactory implements
		ICustomizationCommandFactoryFactory {

	public ICustomizationCommandFactory createICustomizationCommandFactory(
			final EditingDomain editingDomain) {
		return new CustomizationCommandFactory(editingDomain);
	}

}
