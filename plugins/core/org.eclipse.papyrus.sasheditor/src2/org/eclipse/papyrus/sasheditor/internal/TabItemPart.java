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

import org.eclipse.papyrus.sasheditor.contentprovider.IPageModel;
import org.eclipse.papyrus.sasheditor.internal.AbstractPart.GarbageState;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IEditorPart;

/**
 * A controller associated to a tabitem in a tabfolder. This controller contains a reference to
 * a PagePart.
 * This class is used exclusively by the TabFolderPart. It should be not used from elsewhere.
 * 
 * @author dumoulin
 * 
 */
public class TabItemPart {

	/**
	 * The associated model TODO : change the type
	 */
//	protected Object model;

	/**
	 * The child associated to this tabitem. The child is rendered by the tabitem.
	 */
	protected PagePart childPart;

	/**
	 * Parent owning this TabItem. Can be null if the Part is orphaned. Even if
	 * it is orphaned, the SWT Item still set.
	 */
	protected TabFolderPart parent;

	/**
	 * The SWT item associated to this part. This item contains the control of the
	 * associated editor.
	 */
	protected CTabItem control;

	/** Garbage state used during refresh */
	protected GarbageState garbageState;

	/**
	 * Constructor. 
	 * Create a TabItem for the provided modelPart.
	 * @param tabFolderPart
	 * @param modelPart
	 * @param index
	 */
	public TabItemPart(TabFolderPart parent, PagePart modelPart, int index) {
		this.parent = parent;
		this.childPart = modelPart;
		
		createItemControl(index);
	}

	/**
	 * Create the part control and the control of the child.
	 * 
	 * @param tabFolder
	 * @param index
	 */
	public void createItemControl( int index) {
		// Create the item
		CTabItem item = new CTabItem(getTabFolder(), SWT.NONE, index);
		control = item;
		if(childPart!=null)
		{
			item.setControl(childPart.getControl());
		    refreshTabDecorations();
		}
	}

	/**
	 * Set the tab decorations: label, icon.
	 */
	private void refreshTabDecorations() {
		setTabText(childPart.getPageTitle());
		setTabImage(childPart.getPageIcon());
	}

	/**
	 * Reset this TabItem to use the new part. Reparent the new part and orphan the old part.
	 * 
	 * @param modelPart
	 */
	protected void resetChild(PagePart newChild) {
		childPart.orphan();
		newChild.reparent(parent);
		childPart = newChild;
		setItemControl(childPart.getControl() );
		
		refreshTabDecorations();
	}

	/**
	 * Get the container of the Parent. This container is used as root of the
	 * Controls associated to this editor.
	 * 
	 * @return
	 */
	private CTabFolder getTabFolder() {
		return (CTabFolder) parent.getControl();
	}

	/**
	 * Fill the provided part map with the child's parts.
	 * 
	 * @param partMap
	 */
	public void fillPartMap(PartLists partMap) {

		childPart.fillPartMap(partMap);
		garbageState = GarbageState.UNVISITED;
	}

	/**
	 * Remove the TabPart. 
	 * Dispose the associated SWT CTabItem.
	 * (TODO Remove from the parent list.)
	 * Orphan the associated ITilePart
	 * 
	 * @see
	 * @return the parent
	 */
	protected void remove() {

		// setControl() change the visibility of the underlying SWT control
		// (here the editor).
		// This should not happen if the editor is already attached to another
		// folder.
		// check this case and remember the flag to put it back if needed
		setItemControl(null);
		parent = null;
		control.dispose();
		// Orphan associates Tiles
		childPart.orphan();
	}

	/**
	 * Set the item control. Setting the item control with the
	 * control.setControl() method has a side effect: the previous control is
	 * modified with previousControl.setVisible(false). This is annoying when
	 * the previous control has already been attached to another parent. This
	 * method take care to not change the visibility of the previous control if
	 * it is detached from the item's parent.
	 * 
	 * @param newControl
	 */
	private void setItemControl(Control newControl) {
		// setControl() change the visibility of the underlying SWT control
		// (here the editor).
		// This should not happen if the editor is already attached to another
		// folder.
		// check this case and remember the flag to put it back if needed
		boolean editorIsVisible = false;
		// Get previously attached editor's control
		Control editorControl = control.getControl();
		if (editorControl != null && editorControl.getParent() != control.getParent()) {
			// Editor has already been reattached
			// Remember its visible flag
			editorIsVisible = editorControl.getVisible();
			// Detach the item's control
			control.setControl(newControl);
			if (editorIsVisible)
				editorControl.setVisible(editorIsVisible);
		} else {
			// Not reattached, do nothing else
			control.setControl(newControl);
		}
	}

	/**
	 * Dispose the associated control.
	 * Only dispose this tabitem, not the childpart.
	 */
	public void dispose() {
		Control itemControl = control.getControl();
		control.dispose();

		// Dispose the inner control if any.
		if (!itemControl.isDisposed())
			itemControl.dispose();

		//
		parent = null;
	}

	/**
	 * Set the image of the associated tab.
	 * 
	 * @param titleImage
	 */
	private void setTabImage(Image titleImage) {
		control.setImage(titleImage);
	}

	/**
	 * Set the text of the associated tab.
	 * 
	 * @param title
	 */
	private void setTabText(String title) {
		if(title == null)
			title = "";
		control.setText(title);
		control.setToolTipText(title);
	}

	/**
	 * Return the associated EditorTile.
	 * @return
	 */
	public PagePart getChildPart()
	{
		return childPart;
	}
	
	/**
	 * Locates the part that intersects the given point and that have the expected type
	 * 
	 * @param position
	 * @return
	 */
	public AbstractPart findPartAt(Point position, Class<?> expectedTileType) {
		
//		if(expectedTileType == this.getClass())
//			return this;
		
		return childPart.findPartAt(position, expectedTileType);	
	}


	/**
	 * Accept the provided visitor.
	 * Call the corresponding accept method in the visitor.
	 * @param visitor
	 * @return
	 */
	public void visit(IPartVisitor visitor) {
		visitor.accept(this);
	}
	
	/**
	 * Visit the children of this Tile.
	 * @param visitor
	 */
	public void visitChildren(IPartVisitor visitor) {
		childPart.visit(visitor);
	}

	/**
	 * Return true if this TabItem is for the specified rawModel.
	 * @param curModel
	 * @return
	 */
	public boolean isTabItemFor(Object rawModel) {
		return rawModel.equals( getChildPart().getRawModel());
	}


}
