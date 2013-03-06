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
package org.eclipse.papyrus.cdo.internal.core.importer;

import org.eclipse.core.runtime.IPath;
import org.eclipse.papyrus.cdo.core.importer.IModelImportConfiguration;
import org.eclipse.papyrus.cdo.core.importer.IModelImportNode;

import com.google.common.base.Objects;

/**
 * This is the ManyToOneModelImportMapping type. Enjoy.
 */
public class ManyToOneModelImportMapping
		extends AbstractModelImportMapping {

	private IPath mapping;

	public ManyToOneModelImportMapping(IModelImportConfiguration config) {
		super(config);
		
		computeDefaultMappings(config);
	}

	public void mapTo(IModelImportNode source, IPath path) {
		if (!Objects.equal(this.mapping, path)) {
			this.mapping = path;

			for (IModelImportNode next : getConfiguration().getModelsToImport()) {
				fireMappingChanged(next);
			}
		}
	}

	public IPath getMapping(IModelImportNode node) {
		return mapping;
	}

}
