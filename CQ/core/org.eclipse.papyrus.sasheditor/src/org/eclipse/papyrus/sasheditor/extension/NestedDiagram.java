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

/**
 * Provide getter/setter for shared object. Editors whishing to have the shared object by this method should implement this interface
 * 
 * TODO Remove this interface as there is other ways to do that ?
 * 
 * @author dumoulin
 * 
 */
public interface NestedDiagram {

	/**
	 * Set the MultiDiagramSharedObjects property.
	 * 
	 * @param sharedObjects
	 *            shared objects among several diagrams
	 */
	public void setSharedObjects(MultiDiagramSharedObjects sharedObjects);

	/**
	 * Get the MultiDiagramSharedObjects property.
	 * 
	 * @return the shared objects among several diagrams
	 */
	public MultiDiagramSharedObjects getSharedObjects();

	/**
	 * Set the root of the editor. This method is intended to initialize the editor. It should be called immediately after the editor creation. The editor is not intended to allow further calls.
	 * 
	 * @param root
	 *            object edited by the editor
	 */
	public void setRoot(Object root);

}
