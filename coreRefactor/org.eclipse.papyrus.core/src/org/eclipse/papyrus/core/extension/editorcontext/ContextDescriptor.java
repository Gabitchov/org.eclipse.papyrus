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
package org.eclipse.papyrus.core.extension.editorcontext;

import org.eclipse.papyrus.core.editor.BackboneException;
import org.eclipse.papyrus.core.editor.IMultiDiagramEditor;

/**
 * Context Descriptor used to init an editor
 * 
 * @author Cedric Dumoulin
 * @author Patrick Tessier
 * 
 */
public class ContextDescriptor {

	protected Class<? extends IEditorContext> contextClass;

	protected String contextId;

	/**
	 * Instance is created when requested.
	 */
	protected IEditorContext instance = null;

	/**
	 * constructor.
	 * 
	 * @return the context descriptor
	 * @throws BackboneException
	 */
	protected IEditorContext getContext(IMultiDiagramEditor multiEditor) throws BackboneException {
		if (instance == null)
			instance = createContext(multiEditor);

		return instance;
	}

	private IEditorContext createContext(IMultiDiagramEditor multiEditor) throws BackboneException {
		try {
			IEditorContext context = contextClass.newInstance();
			context.init(multiEditor);
			return context;

		} catch (SecurityException e) {
			// Lets propagate. This is an implementation problem that should be solved by programmer.
			throw new RuntimeException(e);
		} catch (InstantiationException e) {
			// Lets propagate. This is an implementation problem that should be solved by programmer.
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			// Lets propagate. This is an implementation problem that should be solved by programmer.
			throw new RuntimeException(e);
		}
	}

} // end class