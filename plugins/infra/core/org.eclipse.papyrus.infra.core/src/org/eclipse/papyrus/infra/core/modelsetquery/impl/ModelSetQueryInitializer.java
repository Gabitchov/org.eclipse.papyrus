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
package org.eclipse.papyrus.infra.core.modelsetquery.impl;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.infra.core.modelsetquery.IModelSetQueryAdapter;
import org.eclipse.papyrus.infra.core.resource.IModelSetSnippet;
import org.eclipse.papyrus.infra.core.resource.ModelSet;

/**
 * This snippet take in charge the initialization of the TypeCache. The snippet
 * is attached to the {@link ModelSet} (in the extensions), and called right
 * after ModelsManager is initialized.
 * 
 * @author cedric dumoulin
 * 
 */
public class ModelSetQueryInitializer implements IModelSetSnippet {

	/**
	 * The type cache adapter used to reference elements from a type
	 */
	private IModelSetQueryAdapter modelQueryAdapter;

	/**
	 * @see org.eclipse.papyrus.resource.IModelSetSnippet#start(org.eclipse.papyrus.infra.core.resource.ModelSet)
	 * 
	 * @param modelsManager
	 */
	public void start(ModelSet modelsManager) {
		EList<Adapter> eAdapters = modelsManager.eAdapters();
		boolean found = false;
		for(Adapter adapter : eAdapters) {
			if(adapter instanceof IModelSetQueryAdapter) {
				found = true;
				modelQueryAdapter = (IModelSetQueryAdapter)adapter;
			}
		}
		if(!found) {
			modelQueryAdapter = createDefaultIModelSetQueryAdapter();
			if(modelQueryAdapter instanceof Adapter) {
				eAdapters.add((Adapter)modelQueryAdapter);
			}
		}

	}

	public static IModelSetQueryAdapter createDefaultIModelSetQueryAdapter() {
		// for big models size matters TODO change the implementation to provide options
		return new ModelSetQueryAdapterSizeMatters();
	}

	/**
	 * @see org.eclipse.papyrus.resource.IModelSetSnippet#dispose(org.eclipse.papyrus.infra.core.resource.ModelSet)
	 * 
	 * @param modelsManager
	 */
	public void dispose(ModelSet modelsManager) {
		if(modelQueryAdapter instanceof Adapter) {
			modelsManager.eAdapters().remove(modelQueryAdapter);
		}

	}

}
