/*******************************************************************************
 * Copyright (c) 2012 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Nicolas Bros (Mia-Software) - Bug 379683 - customizable Tree content provider
 *    David Couvrand (Soft-Maint) - Bug 418418 - [Customization] Overlay icons not implemented
 *******************************************************************************/
package org.eclipse.emf.facet.custom.ui.internal;

import org.eclipse.emf.facet.custom.core.ICustomizationManager;
import org.eclipse.emf.facet.custom.ui.ICustomizedLabelProvider;
import org.eclipse.emf.facet.custom.ui.IResolvingCustomizedLabelProviderFactory;

public class ResolvingCustomizedLabelProviderFactory implements IResolvingCustomizedLabelProviderFactory {

	public ICustomizedLabelProvider createCustomizedLabelProvider(final ICustomizationManager customManager) {
		return new ResolvingCustomizedLabelProvider(
				new DecoratingCustomizedLabelProvider(
						customManager));
	}

}
