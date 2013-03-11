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

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.papyrus.cdo.core.IPapyrusRepository;

/**
 * This is the IModelTransferMapping type. Enjoy.
 */
public interface IModelTransferMapping {

	IModelTransferConfiguration getConfiguration();

	void mapTo(IModelTransferNode source, IPath path);

	IPath getMapping(IModelTransferNode node);

	IPapyrusRepository getRepository();

	void setRepository(IPapyrusRepository repository);

	Diagnostic validate();

	void addModelTransferMappingListener(IModelTransferMappingListener listener);

	void removeModelTransferMappingListener(IModelTransferMappingListener listener);
}
