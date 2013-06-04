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
package org.eclipse.papyrus.infra.core.sasheditor.internal;

import org.eclipse.papyrus.infra.core.sasheditor.editor.IPage;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Widget;

/**
 * This class represent a leaf part that is a part containing an editor or a component.
 * 
 * @author dumoulin
 */
public abstract class PagePart extends AbstractPart implements IPage {

	/** Raw model associated to this part. We store it because the PartModel do not provide it */
	protected Object rawModel;

	/** Parent part of this Part */
	protected TabFolderPart parent;


	/**
	 * Constructor.
	 * 
	 * @param sashWindowsContainer
	 */
	public PagePart(TabFolderPart parent, Object rawModel) {
		super(parent.getSashWindowContainer());
		this.parent = parent;
		this.rawModel = rawModel;
	}


	/**
	 * @return the parent
	 */
	protected TabFolderPart getParent() {
		return parent;
	}

	
	/**
	 * Get the {@link TabItemPart} that is associated to this Page.
	 * <br>
	 * The {@link TabItemPart} represents the tab in the folder.
	 * @return
	 */
	protected TabItemPart getAssociatedTabItemPart() {
		
		// TabItemPart is not directly accessible. We should ask it to 
		// the parent.
		return getParent().lookupAssociatedTabItemPart(this);
	}
	
	/**
	 * Orphan this node. The parent is set to null, but control is left unchanged.
	 * The node can be reattached with reparent(). Change garbage state to {@link GarbageState.ORPHANED}.
	 * This method as no effect if the Page has already been reparented.
	 * 
	 * @see
	 * @return the parent
	 */
	public void orphan() {
		// orphan only if we are in COLLECTED state
		if(garbageState == GarbageState.UNVISITED) {
			garbageState = GarbageState.ORPHANED;
			parent = null;
		}
	}

	/**
	 * Mark this Page as UNCHANGED.
	 * The PAge should be in the COLLECTED state.
	 * 
	 * @see
	 * @return the parent
	 */
	public void unchanged() {
		// orphan only if we are in COLLECTED state
		if(garbageState == GarbageState.UNVISITED || garbageState == GarbageState.ORPHANED) {
			garbageState = GarbageState.UNCHANGED;
		} else {
			// Bad state, this is an internal error
			// TODO : log a warning ?
			throw new IllegalStateException("Try to change state from " + garbageState.toString() + " to UNCHANGED. This is forbidden.");
		}
	}

	/**
	 * Visit this part.
	 * 
	 * @param visitor
	 * @return true if the visit should continue, false otherwise.
	 */
	abstract boolean visit(IPartVisitor visitor);

	/**
	 * Locates the part that intersects the given point and that have the expected type.
	 * For a leaf, return the leaf if it is of the expected type.
	 * 
	 * @param position
	 * @param expectedTileType
	 * @return
	 */
	public AbstractPart findPartAt(Point position, Class<?> expectedTileType) {

		if(expectedTileType == this.getClass())
			return this;

		return null;
	}

	/**
	 * Create the control of this Part, and children's controls.
	 * 
	 * @param parent
	 */
	abstract public void createPartControl(Composite parent);

	/**
	 * Get the control associated to this Part.
	 * 
	 * @return
	 */
	abstract public Control getControl();

	/**
	 * reparent this Part with the specified new parent.
	 * The part is marked as reparented.
	 * 
	 * @param parent
	 */
	abstract public void reparent(TabFolderPart parent);

	/**
	 * Return the {@link Widget} of the tab associated to this page.
	 * @return The {@link Widget} of the tab.
	 */
	public Widget getTabWidget() {
		return getAssociatedTabItemPart().control;
	}
	
	/**
	 * Add the tree of parts starting from this part.
	 * As we are a leaf, add itself only.
	 * 
	 * @param partMap
	 */
	public void fillPartMap(PartLists partMap) {
		partMap.addLeaf(this);
		garbageState = GarbageState.UNVISITED;
	}

	/**
	 * Get the raw model associated to this Part.
	 * 
	 * @return
	 */
	public Object getRawModel() {
		return rawModel;
	}

	/**
	 * Return a title for this part. This title can be used by parent to be shown
	 * in tabs ...
	 * To be implemented by subclasses.
	 * 
	 * @return The title or null.
	 */
	public String getPageTitle() {
		return null;
	}

	/**
	 * Return a icon for this part. This title can be used by parent to be shown
	 * in tabs ...
	 * To be implemented by subclasses.
	 * 
	 * @return The icon or null.
	 */
	public Image getPageIcon() {
		return null;
	}

	/**
	 * Refresh the tab of this page (I.e the name and icon in the tab).
	 */
	public void refreshTab() {
		getParent().refreshPageTab(this);
	}
	/**
	 * Set focus on the SWT control associated to this PagePart.
	 * Used by the ActivePageTracker.
	 */
	abstract public void setFocus();

	/**
	 * Dispose the part.
	 * <br/>
	 * The part and its associated resource are disposed.
	 * 
	 */
	abstract public void dispose();

	/**
	 * Dispose this part and all its children.
	 * The method is called recursively on children of the part.
	 */
	abstract public void disposeThisAndChildren();

	/**
	 * Garbage the part.
	 * <br/>
	 * This method is called by the sashwindows garbage mechanism. It means that the part has been marked as "garbage" or 
	 * is now unreachable. It is no longer used by the {@link SashWindowsContainer}, and it should be garbage.
	 * <br/>
	 * All resources used by this node should be reclaimed, but not its subnodes.
	 * 
	 */
	abstract public void garbage();

	/**
	 * Return true if the part is associated to the specified rawModel.
	 * Return false otherwise.
	 * 
	 * @param realModel
	 * @return
	 */
	public boolean isPartFor(Object realModel) {
		return this.rawModel == realModel;
	}



}
