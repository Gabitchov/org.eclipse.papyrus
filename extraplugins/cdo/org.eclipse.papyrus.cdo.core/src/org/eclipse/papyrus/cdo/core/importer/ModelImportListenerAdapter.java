/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.cdo.core.importer;

import org.eclipse.emf.common.util.Diagnostic;

/**
 * This is the ModelImportListenerAdapter type. Enjoy.
 */
public class ModelImportListenerAdapter
		implements IModelImportListener {

	public ModelImportListenerAdapter() {
		super();
	}

	public void modelsToImportChanged(IModelImportConfiguration configuration) {
		// pass
	}

	public void modelDependentsChanged(IModelImportNode node) {
		// pass
	}

	public void modelImportProblemsOccurred(Diagnostic problems) {
		// pass
	}

}
