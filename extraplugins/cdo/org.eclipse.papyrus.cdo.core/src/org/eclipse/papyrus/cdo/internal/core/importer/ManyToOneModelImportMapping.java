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
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.papyrus.cdo.core.importer.IModelTransferConfiguration;
import org.eclipse.papyrus.cdo.core.importer.IModelTransferNode;

import com.google.common.base.Objects;

/**
 * This is the ManyToOneModelImportMapping type. Enjoy.
 */
public class ManyToOneModelImportMapping extends AbstractModelImportMapping {

	private IPath mapping;

	public ManyToOneModelImportMapping(IModelTransferConfiguration config) {
		super(config);

		computeDefaultMappings(config);
	}

	@Override
	public void mapTo(IModelTransferNode source, IPath path) {
		if(!Objects.equal(this.mapping, path)) {
			this.mapping = path;

			for(IModelTransferNode next : getConfiguration().getModelsToTransfer()) {
				fireMappingChanged(next);
			}
		}
	}

	@Override
	public IPath getMapping(IModelTransferNode node) {
		return mapping;
	}

	@Override
	protected void validateUniqueMappings(DiagnosticChain diagnostics) {
		// pass.  The whole point of this mapping is that all inputs map to one output
	}

}
