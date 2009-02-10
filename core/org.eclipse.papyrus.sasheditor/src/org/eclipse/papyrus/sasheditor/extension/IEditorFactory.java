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
package org.eclipse.papyrus.sasheditor.extension;

import org.eclipse.ui.IEditorPart;

/**
 * Editor factory. A factory is responsible to create an editor for the specified root object.
 */
public interface IEditorFactory {

	/**
	 * Returns <code>true</code> if the editor is able to edit the root object.
	 * 
	 * @param root
	 *            the root object to be edited
	 * @return <code>true</code> if the editor can edit the root object.
	 */
	public boolean isEditorFor(Object root);

	/**
	 * Creates an editor for the specified root object.
	 * 
	 * @param sharedObjects
	 *            shared objects among several editors
	 * @param root
	 *            the root opbject to be edited, for example, a diagram
	 * @return the created editor
	 */
	public IEditorPart createEditorFor(MultiDiagramSharedObjects sharedObjects, Object root);
}
