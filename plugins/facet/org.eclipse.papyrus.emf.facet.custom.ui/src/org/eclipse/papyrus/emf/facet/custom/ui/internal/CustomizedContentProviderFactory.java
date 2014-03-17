/**
 *  Copyright (c) 2011 Mia-Software.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *  	Gregoire Dupe (Mia-Software) - Bug 361794 - [Restructuring] New customization meta-model
 *      Nicolas Bros (Mia-Software) - Bug 379683 - customizable Tree content provider
 */
package org.eclipse.papyrus.emf.facet.custom.ui.internal;

import org.eclipse.papyrus.emf.facet.custom.ui.ICustomizedContentProvider;
import org.eclipse.papyrus.emf.facet.custom.ui.ICustomizedContentProviderFactory;
import org.eclipse.papyrus.emf.facet.custom.ui.ICustomizedTreeContentProvider;
import org.eclipse.papyrus.emf.facet.custom.core.ICustomizationManager;

@SuppressWarnings("deprecation")
//@SuppressWarnings("deprecation") : Bug 380229 - [deprecated] ICustomizedContentProvider
public class CustomizedContentProviderFactory implements ICustomizedContentProviderFactory {

	public ICustomizedContentProvider createCustomizedContentProvider(final ICustomizationManager customManager) {
		return new CustomizedTreeContentProvider(customManager);
	}

	public ICustomizedTreeContentProvider createCustomizedTreeContentProvider(final ICustomizationManager customManager) {
		return new CustomizedTreeContentProvider(customManager);
	}

}
