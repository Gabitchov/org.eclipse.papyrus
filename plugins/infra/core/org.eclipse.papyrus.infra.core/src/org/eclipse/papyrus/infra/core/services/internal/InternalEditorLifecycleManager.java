/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.core.services.internal;

import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.services.IService;


public interface InternalEditorLifecycleManager extends IService {

	/**
	 * Sends the postInit notification for this editor
	 * 
	 * @param editor
	 */
	void firePostInit(IMultiDiagramEditor editor);

	/**
	 * Sends the postDisplay notification for this editor
	 * 
	 * @param editor
	 */
	void firePostDisplay(IMultiDiagramEditor editor);

	/**
	 * Sends the beforeClose notification for this Editor
	 * 
	 * @param editor
	 */
	void fireBeforeClose(IMultiDiagramEditor editor);
}
