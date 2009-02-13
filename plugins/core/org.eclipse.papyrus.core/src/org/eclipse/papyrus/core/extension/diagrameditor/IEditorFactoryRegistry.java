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
package org.eclipse.papyrus.core.extension.diagrameditor;

import org.eclipse.papyrus.core.extension.editorcontext.IEditorContextRegistry;
import org.eclipse.papyrus.sasheditor.gef.EditorNotFoundException;
import org.eclipse.papyrus.sasheditor.gef.MultiDiagramException;
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
	 * @param contextFactoryRegistry*
	 * @param model
	 * @throws EditorNotFoundException
	 *             No editor handling the model can be found.
	 */
	public IEditorPart createEditorFor(IEditorContextRegistry contextFactoryRegistry, Object model) throws MultiDiagramException;

	/**
	 * Get the editor descriptor for the specified model.
	 * 
	 * @throws EditorNotFoundException
	 *             No editor handling the model can be found.
	 */
	public IEditorDescriptor getEditorDescriptorFor(Object model) throws MultiDiagramException;

}