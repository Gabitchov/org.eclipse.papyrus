/*****************************************************************************
 * Copyright (c) 2009 CEA LIST & LIFL 
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
package org.eclipse.papyrus.sasheditor.internal;

/**
 * Visitor used to visit the hierarchy of Parts.
 * 
 * @author dumoulin
 * 
 */
public interface IPartVisitor {

	/**
	 * Accept the node of specified type.
	 * 
	 * @param folder
	 */

	public void accept(RootPart tile);

	/**
	 * Accept the node of specified type.
	 * 
	 * @param folder
	 */
	public void accept(SashPanelPart tile);

	/**
	 * Accept the node of specified type.
	 * 
	 * @param folder
	 */
	public void accept(TabFolderPart folder);

	/**
	 * Accept the node of specified type.
	 * 
	 * @param folder
	 */
	public void accept(TabItemPart tile);

	/**
	 * Accept the node of specified type.
	 * 
	 * @param folder
	 */
	public void accept(EditorPart tile);

	/**
	 * Accept the node of specified type.
	 * 
	 * @param componentPart
	 */
	public void accept(ComponentPart componentPart);

}
