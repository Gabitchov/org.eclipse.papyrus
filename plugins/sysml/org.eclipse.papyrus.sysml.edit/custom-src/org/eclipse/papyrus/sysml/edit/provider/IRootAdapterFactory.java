/*****************************************************************************
 * Copyright (c) 2011 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.sysml.edit.provider;

/**
 * Interfaces which has to be implemented by Root AdapterFactory
 */
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;

public interface IRootAdapterFactory {

	/**
	 * Give back the itemProvider which correspond to the given EClass In this
	 * prog : used to get back the UML ItemProvider of the EClass
	 * 
	 * @param eClass
	 * @return
	 */
	public ItemProviderAdapter getItemProvider(EClass eClass);
}
