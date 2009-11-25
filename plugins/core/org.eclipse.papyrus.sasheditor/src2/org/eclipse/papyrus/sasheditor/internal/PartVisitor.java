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
 * Visitor implementation allowing to visit the hierarchy of Parts.
 * 
 * @author dumoulin
 * 
 */
public class PartVisitor implements IPartVisitor {

	/**
	 * Visit the specified type, and then visit the childs..
	 * 
	 * @param folder
	 */
	public void accept(TabFolderPart part) {
		acceptTabFolderPart(part);
		// Visit the children
		part.visitChildren(this);
	}

	/**
	 * Visit the specified type, and then visit the childs..
	 * 
	 * @param folder
	 */
	public void accept(RootPart part) {
		acceptRootPart(part);
		// Visit the children
		part.visitChildren(this);
	}

	/**
	 * Visit the specified type, and then visit the children..
	 * 
	 * @param folder
	 */
	public void accept(SashPanelPart part) {
		acceptSashPanelPart(part);
		// Visit the children
		part.visitChildren(this);
	}

	/**
	 * Visit the specified type, and then visit the children..
	 * 
	 * @param folder
	 */
	public void accept(TabItemPart part) {
		acceptTabItemPart(part);
		// Visit the children
		part.visitChildren(this);
	}

	/**
	 * Visit the specified type, and then visit the children..
	 * 
	 * @param part
	 */
	public void accept(EditorPart part) {
		acceptEditorTile(part);
		// Visit the children
		part.visitChildren(this);
	}

	/**
	 * Visit the specified type, and then visit the children ..
	 * 
	 * @param part
	 */
	public void accept(ComponentPart part) {
		acceptEditorTile(part);
		// Visit the children
		part.visitChildren(this);
	}


	// ----------------------------------------------

	/**
	 * Visit the specified type.
	 * 
	 * @param part
	 */
	protected void acceptRootPart(RootPart part) {
	}

	/**
	 * Visit the specified type.
	 * 
	 * @param part
	 */
	protected void acceptSashPanelPart(SashPanelPart part) {
	}

	/**
	 * Visit the specified type.
	 * 
	 * @param part
	 */
	protected void acceptTabFolderPart(TabFolderPart part) {
	}

	/**
	 * Visit the specified type.
	 * 
	 * @param part
	 */
	protected void acceptTabItemPart(TabItemPart part) {
	}

	/**
	 * Visit the specified type.
	 * 
	 * @param part
	 */
	protected void acceptEditorTile(EditorPart part) {
	}

	/**
	 * Visit the specified type.
	 * 
	 * @param part
	 */
	protected void acceptEditorTile(ComponentPart part) {
	}


}
