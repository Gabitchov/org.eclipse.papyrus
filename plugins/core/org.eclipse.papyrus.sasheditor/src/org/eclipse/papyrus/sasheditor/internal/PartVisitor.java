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
	 * Visit the specified type, and then visit the children ...
	 * 
	 * @param folder
	 */
	public boolean accept(TabFolderPart part) {


		if(acceptTabFolderPart(part)) {
			// Visit the children
			return part.visitChildren(this);
		}

		// stop visiting
		return false;
	}

	/**
	 * Visit the specified type, and then visit the childs..
	 * 
	 * @param folder
	 */
	public boolean accept(RootPart part) {

		if(acceptRootPart(part)) {
			// Visit the children
			return part.visitChildren(this);
		}
		// stop visiting
		return false;
	}

	/**
	 * Visit the specified type, and then visit the children..
	 * 
	 * @param folder
	 */
	public boolean accept(SashPanelPart part) {
		if(acceptSashPanelPart(part)) {
			// Visit the children
			return part.visitChildren(this);
		}
		// stop visiting
		return false;
	}

	/**
	 * Visit the specified type, and then visit the children..
	 * 
	 * @param folder
	 */
	public boolean accept(TabItemPart part) {
		if(acceptTabItemPart(part)) {
			// Visit the children
			return part.visitChildren(this);
		}
		// stop visiting
		return false;
	}

	/**
	 * Visit the specified type, and then visit the children..
	 * 
	 * @param part
	 */
	public boolean accept(EditorPart part) {
		if(acceptEditorTile(part)) {
			// Visit the children
			return part.visitChildren(this);
		}
		// stop visiting
		return false;
	}

	/**
	 * Visit the specified type, and then visit the children ..
	 * 
	 * @param part
	 */
	public boolean accept(ComponentPart part) {
		if(acceptEditorTile(part)) {
			// Visit the children
			return part.visitChildren(this);
		}
		// stop visiting
		return false;
	}


	// ----------------------------------------------

	/**
	 * Visit the specified type.
	 * 
	 * @param part
	 */
	protected boolean acceptRootPart(RootPart part) {
		return true;
	}

	/**
	 * Visit the specified type.
	 * 
	 * @param part
	 */
	protected boolean acceptSashPanelPart(SashPanelPart part) {
		return true;
	}

	/**
	 * Visit the specified type.
	 * 
	 * @param part
	 */
	protected boolean acceptTabFolderPart(TabFolderPart part) {
		return true;
	}

	/**
	 * Visit the specified type.
	 * 
	 * @param part
	 */
	protected boolean acceptTabItemPart(TabItemPart part) {
		return true;
	}

	/**
	 * Visit the specified type.
	 * 
	 * @param part
	 */
	protected boolean acceptEditorTile(EditorPart part) {
		return true;
	}

	/**
	 * Visit the specified type.
	 * 
	 * @param part
	 */
	protected boolean acceptEditorTile(ComponentPart part) {
		return true;
	}


}
