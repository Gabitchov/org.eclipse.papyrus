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
package org.eclipse.papyrus.infra.core.services;

import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;

/**
 * Listens to the Lifecycle of an {@link IMultiDiagramEditor}
 * 
 * @author Camille Letavernier
 * 
 */
public interface EditorLifecycleEventListener {

	/**
	 * The ServicesRegistry is successfully started
	 * 
	 * @param editor
	 */
	public void postInit(IMultiDiagramEditor editor);

	/**
	 * All the editors are displayed
	 * 
	 * @param editor
	 */
	public void postDisplay(IMultiDiagramEditor editor);

	/**
	 * The editor is about to be closed
	 * 
	 * @param editor
	 */
	public void beforeClose(IMultiDiagramEditor editor);

}
