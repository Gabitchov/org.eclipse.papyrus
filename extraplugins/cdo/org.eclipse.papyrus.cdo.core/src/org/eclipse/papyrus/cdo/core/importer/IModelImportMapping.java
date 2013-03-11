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

import org.eclipse.papyrus.cdo.internal.core.importer.ManyToOneModelImportMappingFactory;
import org.eclipse.papyrus.cdo.internal.core.importer.OneToOneModelImportMappingFactory;

/**
 * This is the IModelImportMapping type. Enjoy.
 */
public interface IModelImportMapping extends IModelTransferMapping {

	interface Factory {

		Factory ONE_TO_ONE = new OneToOneModelImportMappingFactory();

		Factory MANY_TO_ONE = new ManyToOneModelImportMappingFactory();

		IModelImportMapping create(IModelTransferConfiguration configuration);
	}
}
