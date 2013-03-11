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
package org.eclipse.papyrus.cdo.internal.core.exporter;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.cdo.core.importer.IModelTransferConfiguration;
import org.eclipse.papyrus.cdo.core.importer.IModelTransferConfiguration.Factory;
import org.eclipse.papyrus.cdo.core.importer.IModelTransferOperation;
import org.eclipse.papyrus.cdo.internal.core.importer.ModelTransferConfiguration;
import org.eclipse.papyrus.cdo.internal.core.importer.ModelTransferConfiguration.Direction;

/**
 * This is the DefaultModelExportConfigurationFactory type. Enjoy.
 */
public class DefaultModelExportConfigurationFactory implements Factory {

	public DefaultModelExportConfigurationFactory() {
		super();
	}

	public IModelTransferConfiguration create(IModelTransferOperation.Context operationContext, ResourceSet resourceSet) {
		ModelTransferConfiguration result = new ModelTransferConfiguration(operationContext, resourceSet, Direction.EXPORT);

		result.addModelDependentsProvider(new CDODIDependentsProvider());

		return result;
	}

}
