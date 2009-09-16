/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
  *****************************************************************************/
package org.eclipse.papyrus.sasheditor.gef;

import org.eclipse.papyrus.sasheditor.extension.MultiDiagramSharedObjects;
import org.eclipse.ui.IEditorPart;

/**
 * Registry used to create a new nested editor for a specified model.
 * 
 * @author dumoulin TODO move this to extension.
 */
public interface IEditorFactoryRegistry {

	/**
	 * Create a new editor for the specified diagram root.
	 * 
	 * @throws EditorNotFoundException
	 *             No editor handling the model can be found.
	 */
	public IEditorPart createEditorFor(MultiDiagramSharedObjects sharedObjects, Object model) throws EditorNotFoundException;

}