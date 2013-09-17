/*******************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cedric Dumoulin Cedric.dumoulin@lifl.fr
 ******************************************************************************/
package org.eclipse.papyrus.layers.stackmodel.layers.provider.custom;

import java.util.Collection;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStackApplication;


/**
 * @author cedric dumoulin
 *
 */
public class LayersStackApplicationItemProvider extends org.eclipse.papyrus.layers.stackmodel.layers.provider.LayersStackApplicationItemProvider {

	/**
	 * Constructor.
	 *
	 * @param adapterFactory
	 */
	public LayersStackApplicationItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * Only return the owned stacks
	 * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#getChildren(java.lang.Object)
	 *
	 * @param object
	 * @return
	 */
	@Override
	public Collection<?> getChildren(Object object) {
		
		return ((LayersStackApplication)object).getLayersStacks();
	}
}
