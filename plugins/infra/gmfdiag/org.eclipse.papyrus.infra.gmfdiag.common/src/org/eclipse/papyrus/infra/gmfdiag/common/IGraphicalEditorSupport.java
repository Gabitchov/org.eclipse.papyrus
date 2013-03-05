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


/**
 * An interface for helper objects that support the functioning of GMF {@link GraphicalEditor}s
 */
public interface IGraphicalEditorSupport {
	void initialize(GraphicalEditor editor);
}
