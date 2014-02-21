/**
 *  Copyright (c) 2012 Mia-Software.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *  	Gregoire Dupe (Mia-Software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 *      Gregoire Dupe (Mia-Software) - Bug 373078 - API Cleaning
 */
package org.eclipse.papyrus.emf.facet.custom.ui.internal;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.emf.facet.custom.ui.internal.exported.ICustomizationCommandFactory;
import org.eclipse.papyrus.emf.facet.custom.ui.internal.exported.ICustomizationCommandFactoryFactory;
import org.eclipse.papyrus.emf.facet.util.emf.core.internal.exported.ICommandFactory;

public class CustomizationCommandFactoryFactory implements
		ICustomizationCommandFactoryFactory {

	public ICustomizationCommandFactory createCustomizationCommandFactory(
			final EditingDomain editingDomain,
			final ICommandFactory commandFactory) {
		return new CustomizationCommandFactory(editingDomain, commandFactory);
	}

}
