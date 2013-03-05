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
package org.eclipse.papyrus.infra.gmfdiag.common;

import org.eclipse.gef.ui.parts.GraphicalEditor;
import org.eclipse.papyrus.infra.core.services.IService;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;

/**
 * This is the DefaultGraphicalEditorSupport type. Enjoy.
 */
public class DefaultGraphicalEditorSupport implements IGraphicalEditorSupport, IService {

	public DefaultGraphicalEditorSupport() {
		super();
	}

	public void initialize(GraphicalEditor editor) {
		// pass
	}

	public void init(ServicesRegistry servicesRegistry) {
		// pass
	}

	public void startService() {
		// pass
	}

	public void disposeService() {
		// pass
	}

}
