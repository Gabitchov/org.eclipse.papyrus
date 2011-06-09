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

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.internal.dnd.IDropTarget;


/**
 * Common ancestor of Panel Parts.
 * Panels are sashes and folders.
 * 
 * @author cedric dumoulin
 */
public abstract class AbstractPanelPart extends AbstractPart {

	/**
	 * Parent of this part.
	 */
	protected IPanelParent parent;

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *        Parent of the Pane.
	 */
	public AbstractPanelPart(IPanelParent parent) {
		super(parent.getSashWindowContainer());
	}

	/**
	 * Create the SWT controls.
	 * This method is called by the SWT parent.
	 * 
	 * @param container
	 */
	abstract public void createPartControl(Composite container);

	/**
	 * Dispose all nested SWT controls.
	 */
	abstract public void dispose();

	/**
	 * Visit the part.
	 * 
	 * @param visitor
	 */
	abstract public boolean visit(IPartVisitor visitor);

	/**
	 * Synchronize the part and its children with the models in contentProvider.
	 * 
	 * @param existingParts
	 *        List of already existing part before the synchronization.
	 */
	abstract public void synchronize2(PartLists existingParts);

	/**
	 * Return true is the part is for the specified raw model.
	 * Return false otherwise.
	 * 
	 * @param rawModel
	 * @return
	 */
	abstract public boolean isPartFor(Object rawModel);

	/**
	 * Orphan this node. The parent is set to null, but control is left unchanged.
	 * The node can be reattached with reparent(). Change garbage state to {@link GarbageState.ORPHANED}.
	 * This method as no effect if the Tile has already been reparented.
	 */
	public void orphan() {
		// orphan only if we are in UNCHANGED state
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
	 * Change the parent of the Part. The parent is changed, and the control is
	 * attached to the parent control. Change garbage state to {@link GarbageState.REPARENTED}.
	 * 
	 * @param newParent
	 *        The new parent to which the part should be attached.
	 */
	abstract public void reparent(IPanelParent newParent, Composite swtParent);

	/**
	 * Collect all the parts. The method is called recursively in the tree of parts.
	 * 
	 * @param parts
	 *        The list into which parts are added.
	 */
	abstract public void fillPartMap(PartLists parts);

	/**
	 * Traverses the tree to find the part that intersects the given point
	 * 
	 * @param toFind
	 *        Point in display coordinate
	 * @return the part that intersects the given point
	 * @throws NotFoundException
	 */
	abstract public AbstractPart findPart(Point toFind) throws NotFoundException;

	/**
	 * Find the part associated to the provided control.
	 * 
	 * @param control
	 * @return
	 */
	abstract public AbstractPart findPart(Object control);

	/**
	 * Locates the part that intersects the given point and that have the expected type
	 * 
	 * @param toFind
	 *        Position in Display coordinate.
	 * @return
	 */
	abstract public AbstractPart findPartAt(Point toFind, Class<?> expectedTileType);

	/* ***************************************************** */
	/* Drag and Drop methods */
	/* ***************************************************** */

	/**
	 * Return the swt Control associated to this part.
	 */
	abstract public Composite getControl();

	/**
	 * Get the drop target.
	 * Used by the drag tab mechanism.
	 */
	abstract public IDropTarget getDropTarget(Object draggedObject, TabFolderPart sourcePart, Point position);


}
