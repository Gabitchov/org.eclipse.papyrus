/*******************************************************************************
 * Copyright (c) 2010 Atos Origin.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Atos Origin - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.providers;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.uml2.uml.edit.providers.UMLItemProviderAdapterFactory;
import org.eclipse.uml2.uml.edit.providers.UMLResourceItemProviderAdapterFactory;

public class UMLComposedAdapterFactory extends ComposedAdapterFactory {

	private static final AdapterFactory[] factories = { new UMLResourceItemProviderAdapterFactory(), new UMLItemProviderAdapterFactory() };

	public UMLComposedAdapterFactory() {
		super(factories);
	}
}
