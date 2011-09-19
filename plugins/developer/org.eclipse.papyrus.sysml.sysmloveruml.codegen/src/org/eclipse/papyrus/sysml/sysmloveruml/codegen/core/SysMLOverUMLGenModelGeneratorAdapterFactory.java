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
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.sysmloveruml.codegen.core;

import org.eclipse.emf.codegen.ecore.genmodel.generator.GenModelGeneratorAdapterFactory;
import org.eclipse.emf.common.notify.Adapter;

/**
 * @author "Arthur Daussy <a href="mailto:arthur.daussy@atos.net
 *         ">arthur.daussy@atos.net</a>"
 * 
 */
public class SysMLOverUMLGenModelGeneratorAdapterFactory extends GenModelGeneratorAdapterFactory {

	@Override
	public Adapter createGenPackageAdapter() {
		return null;
	}

	@Override
	public Adapter createGenEnumAdapter() {
		return null;
	}

	@Override
	public Adapter createGenModelAdapter() {
		if(genPackageGeneratorAdapter == null) {
			genPackageGeneratorAdapter = new SysMLOverUmlGenModelGenerator(this);
		}
		return genPackageGeneratorAdapter;
	}

	/**
	 * Define the new GenClassFatoryGeneratorAdaptor.
	 * 
	 * @see org.eclipse.emf.codegen.ecore.genmodel.generator.GenModelGeneratorAdapterFactory#createGenClassAdapter()
	 * @return {@link Adapter}
	 */
	@Override
	public Adapter createGenClassAdapter() {
		return null;
	}
}
