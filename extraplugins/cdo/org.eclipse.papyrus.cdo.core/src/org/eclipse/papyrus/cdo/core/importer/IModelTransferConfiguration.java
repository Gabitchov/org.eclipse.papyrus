/*****************************************************************************
 * Copyright (c) 2013, 2014 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   Christian W. Damus (CEA) - bug 429242
 *   
 *****************************************************************************/
package org.eclipse.papyrus.cdo.core.importer;

import java.util.Collection;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.cdo.internal.core.exporter.DefaultModelExportConfigurationFactory;
import org.eclipse.papyrus.cdo.internal.core.importer.DefaultModelImportConfigurationFactory;

/**
 * This is the IModelTransferConfiguration type. Enjoy.
 */
public interface IModelTransferConfiguration {

	Collection<IModelTransferNode> getModelsToTransfer();

	IModelTransferNode addModelToTransfer(URI resourceURI);

	void removeModelToTransfer(IModelTransferNode node);

	ResourceSet getResourceSet();

	void addModelDependentsProvider(IModelDependentsProvider provider);

	IModelTransferOperation.Context getOperationContext();

	boolean hasSashModelContent();

	boolean isStripSashModelContent();

	void setStripSashModelContent(boolean stripSashModelContent);

	Diagnostic validate();

	void dispose();

	void addModelTransferListener(IModelTransferListener listener);

	void removeModelTransferListener(IModelTransferListener listener);

	interface Factory {

		Factory IMPORT = new DefaultModelImportConfigurationFactory();

		Factory EXPORT = new DefaultModelExportConfigurationFactory();

		/**
		 * Creates a new model transfer configuration. If a {@code ResourceSet} is provided,
		 * then the configuration will use it to load resources for dependency analysis. It will
		 * then be the caller's responsibility to clean up that resource set, if necessary,
		 * after completion of the transfer process.
		 * 
		 * @param operationContext
		 *        a context in which to run model transfer operations
		 * @param resourceSet
		 *        an optional resource set for the configuration to use for dependency analysis; may be {@code null}
		 * 
		 * @return the model transfer configuration
		 */
		IModelTransferConfiguration create(IModelTransferOperation.Context operationContext, ResourceSet resourceSet);
	}
}
