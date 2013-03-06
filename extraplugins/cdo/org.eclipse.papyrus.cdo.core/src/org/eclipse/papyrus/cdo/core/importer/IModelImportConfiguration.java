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

import java.util.Collection;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.cdo.internal.core.importer.DefaultModelImportConfigurationFactory;

/**
 * This is the IModelImportConfiguration type. Enjoy.
 */
public interface IModelImportConfiguration {

	Collection<IModelImportNode> getModelsToImport();

	IModelImportNode addModelToImport(URI resourceURI);

	void removeModelToImport(IModelImportNode node);

	ResourceSet getResourceSet();
	
	void addModelDependentsProvider(IModelDependentsProvider provider);

	IModelImportOperation.Context getOperationContext();
	
	Diagnostic validate();

	void dispose();

	void addModelImportListener(IModelImportListener listener);

	void removeModelImportListener(IModelImportListener listener);

	interface Factory {

		Factory DEFAULT = new DefaultModelImportConfigurationFactory();

		IModelImportConfiguration create(
				IModelImportOperation.Context operationContext);
	}
}
