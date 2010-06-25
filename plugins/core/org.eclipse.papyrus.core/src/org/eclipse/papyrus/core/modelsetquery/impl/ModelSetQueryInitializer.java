/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.core.modelsetquery.impl;

import org.eclipse.papyrus.resource.IModelSetSnippet;
import org.eclipse.papyrus.resource.ModelSet;


/**
 * This snippet take in charge the initialization of the TypeCache.
 * The snippet is attached to the {@link ModelSet} (in the extensions), and called 
 * right after ModelsManager is initialized.
 * 
 * @author cedric dumoulin
 *
 */
public class ModelSetQueryInitializer implements IModelSetSnippet {

	/**
	 * The type cache adapter used to reference elements from a type
	 */
	private ModelSetQueryAdapter typeCacheAdapter = new ModelSetQueryAdapter();

	/**
	 * @see org.eclipse.papyrus.resource.IModelSetSnippet#start(org.eclipse.papyrus.resource.ModelSet)
	 *
	 * @param modelsManager
	 */
	public void start(ModelSet modelsManager) {
		modelsManager.eAdapters().add(typeCacheAdapter);

	}

	/**
	 * @see org.eclipse.papyrus.resource.IModelSetSnippet#dispose(org.eclipse.papyrus.resource.ModelSet)
	 *
	 * @param modelsManager
	 */
	public void dispose(ModelSet modelsManager) {
		modelsManager.eAdapters().remove(typeCacheAdapter);

	}

}
