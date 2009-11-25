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
 * Action used to create a Diagram. This kind of action is used by the multiEditor to create a new diagram. The diagram creation indirectly involves
 * an editor creation.
 * 
 * @author dumoulin
 * 
 */
public interface ICreateDiagramAction {

	/**
	 * Runs the action performing the diagram creation.
	 * 
	 * @param sharedObjects
	 *        the shared objects among several diagrams
	 */
	public void run(MultiDiagramSharedObjects sharedObjects);
}
