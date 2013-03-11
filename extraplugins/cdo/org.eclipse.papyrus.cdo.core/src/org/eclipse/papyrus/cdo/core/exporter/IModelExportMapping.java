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
package org.eclipse.papyrus.cdo.core.exporter;

import org.eclipse.papyrus.cdo.core.importer.IModelTransferConfiguration;
import org.eclipse.papyrus.cdo.core.importer.IModelTransferMapping;
import org.eclipse.papyrus.cdo.internal.core.exporter.DefaultModelExportMappingFactory;

/**
 * This is the IModelExportMapping type. Enjoy.
 */
public interface IModelExportMapping extends IModelTransferMapping {

	interface Factory {

		Factory DEFAULT = new DefaultModelExportMappingFactory();

		IModelExportMapping create(IModelTransferConfiguration configuration);
	}
}
