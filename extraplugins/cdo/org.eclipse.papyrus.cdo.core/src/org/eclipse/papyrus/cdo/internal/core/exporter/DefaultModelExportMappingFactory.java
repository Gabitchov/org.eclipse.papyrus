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

import org.eclipse.papyrus.cdo.core.exporter.IModelExportMapping;
import org.eclipse.papyrus.cdo.core.importer.IModelTransferConfiguration;

/**
 * This is the DefaultModelExportMappingFactory type. Enjoy.
 */
public class DefaultModelExportMappingFactory implements IModelExportMapping.Factory {

	public DefaultModelExportMappingFactory() {
		super();
	}

	public IModelExportMapping create(IModelTransferConfiguration configuration) {
		return new ModelExportMapping(configuration);
	}

}
