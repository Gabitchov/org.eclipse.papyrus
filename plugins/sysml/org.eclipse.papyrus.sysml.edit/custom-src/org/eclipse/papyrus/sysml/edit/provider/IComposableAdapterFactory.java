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
 * The purpose of this interface is to create composable adapterFactory but in a
 * way much simpler than EMF does.
 * 
 * @author "Arthur Daussy <a href="mailto:arthur.daussy@atos.net
 *         ">arthur.daussy@atos.net</a>"
 * 
 */
public interface IComposableAdapterFactory {

	/**
	 * Return the root of the adapter factory
	 * 
	 * @return {@link AdapterFactory}
	 */
	public IRootAdapterFactory getIRootAdapterFactory();

	/**
	 * Set the root AdapterFactory
	 * 
	 * @param root
	 */
	public void setRootAdapterFactory(IRootAdapterFactory root);
}
