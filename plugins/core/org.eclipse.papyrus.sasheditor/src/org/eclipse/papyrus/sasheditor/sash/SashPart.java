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
package org.eclipse.papyrus.sasheditor.sash;

import java.util.List;
import java.util.logging.Logger;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.internal.dnd.DragUtil;
import org.eclipse.ui.internal.dnd.IDropTarget;

/**
 * Controller for a sash node.
 * A sash node contain 2 children. It shows them in two windows separated by a sash.
 * Implementation use one model, a ISashModel. This model encapsulate the real model which
 * is of an unknown type. This type is provided as a generic parameter T. {@link TilePart}
 * 
 * @author dumoulin
 * 
 * @param T
 *        Type of the external model representing the sash.
 */
@SuppressWarnings({ "restriction" })
public class SashPart<T> extends TilePart<T> {

	/** Log object */
	Logger log = Logger.getLogger(getClass().getName());

	/** Interface to the model */
	protected ISashModel<T> model;

	/** Ordered set of currently shown diagrams (a left and right child, or upper and lower) TODO rename as children */
	@SuppressWarnings({ "unchecked" })
	protected ITilePart<T>[] currentChildParts = new ITilePart[2];

	/** Index of the currently active model. -1 = no active model or not yet initialized. */
	protected int activeModelIndex = -1;

	/**
	 * The container widget.
	 */
	private ReplaceableSashForm container;

	/**
	 * Direction of the sash: SWT.HORIZONTAL or SWT.VERTICAL. Default = SWT.HORIZONTAL
	 */
	private int sashDirection = SWT.HORIZONTAL;

	/**
	 * Interface used by the SashPart to access model. An implementation of this interface should be provided when the SashPart is created.
	 * 
	 * @param U
	 *        Real type encapsulated by the model. This should be the same as T.
	 */
	public interface ISashModel<U> extends ITilePart.ITilePartNodeModel<U> {

		/**
		 * Get the childs of this node. The returned objects will be provided to the child part.
		 */
		public List<U> getChildModels();

		/**
		 * Get the sash direction. Can be SWT.VERTICAL or SWT.HORIZONTAL.
		 */
		public int getSashDirection();

	}

	/**
	 * Constructor.
	 */
	public SashPart(TilePartContainer<T> tilesContainer, ITilePart<T> parent, ISashModel<T> model) {
		super(tilesContainer, parent);
		this.model = model;
		this.sashDirection = model.getSashDirection();
	}

	/**
	 * Get the associated model.
	 */
	public ISashModel<T> getModel() {
		return model;
	}

	/**
	 * Fill the provided part map with this parts and recursively call children to fillin.
	 * 
	 * @param partMap
	 */
	public void fillPartMap(GarbageMaps<T> partMap) {
		partMap.getContainerPartMap().put(model.getNodeModel(), this);
		for(ITilePart<T> child : currentChildParts) {
			child.fillPartMap(partMap);
		}
		garbageState = ITilePart.GarbageState.UNCHANGED;
	}

	/**
	 * Create local control, and the tree of children (TileParts AND controls). Create this TilePart control, and then Tile childs of this TilePart.
	 * 
	 * @param parent
	 * @return Control
	 */
	public void createPartControl(Composite parent) {

		createControl(parent);
		createChildren();
		// listen to node change
		// model.addChangeListener(modelListener);
		// model.activate();
	}

	/**
	 * Create local control. Does not create children.
	 * 
	 * @see org.eclipse.papyrus.sasheditor.sash.ITilePart#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		// container = new SashForm(parent, sashDirection);
		container = new ReplaceableSashForm(parent, sashDirection);
	}

	/**
	 * Create the tree of children (TileParts AND controls).
	 */
	private void createChildren() {

		for(int childIndex = 0; childIndex < 2; childIndex++) {
			ITilePart<T> part = getTilePartFactory().createTilePart(this, model.getChildModels().get(childIndex));
			// part.createPartControl(container);
			part.createPartControl(getChildParent(childIndex));

			currentChildParts[childIndex] = part;
		}

	}

	/**
	 * 
	 * @see org.eclipse.papyrus.sasheditor.sash.ITilePart#getControl()
	 */
	public Composite getControl() {
		return container;
	}

	/**
	 * Change the parent of this method. Reparent the Tile and the control. Normally, the control already exists.
	 * 
	 * @see org.eclipse.papyrus.sasheditor.sash.ITilePart#reparent(org.eclipse.papyrus.sasheditor.sash.ITilePart)
	 */
	public void reparent(ITilePart<T> newParent, Composite compositeParent) {
		parent = newParent;
		// Create control if needed
		// This can happen if the TilePart is just created after a refresh
		// if(getControl() == null)
		// {
		// container = createContainer(parent.getControl());
		// }
		// Reparent the control
		assert (getControl() != null);
		// getControl().setParent(newParent.getControl()) ;
		getControl().setParent(compositeParent);
		garbageState = ITilePart.GarbageState.REPARENTED;
	}

	/**
	 * Orphan this node, and children. The parent is set to null, but control is left unchanged. The node can be reattached with reparent().
	 * 
	 * @see
	 * @return the parent
	 */
	public void orphan() {

		// orphan only if we are in UNCHANGED state
		if(garbageState == ITilePart.GarbageState.UNCHANGED) {
			garbageState = ITilePart.GarbageState.ORPHANED;
			parent = null;
			orphanChildren();
		}
	}

	/**
	 * Orphan children of this node.
	 */
	private void orphanChildren() {
		for(int i = 0; i < currentChildParts.length; i++) {
			currentChildParts[i].orphan();
		}
	}

	/**
	 * Dispose the TilePart and its controls.
	 * 
	 * @param isRecursive
	 *        If true, also dispose children.
	 * @see org.eclipse.papyrus.sasheditor.sash.ITilePart#dispose()
	 */
	public void dispose(boolean isRecursive) {
		model.deactivate();

		// Dispose children if requested
		if(isRecursive) {
			for(ITilePart<T> childModel : currentChildParts) {
				if(childModel != null)
					childModel.dispose(true);
			}
		}

		// dispose local resources
		if(container != null && !container.isDisposed()) {
			container.dispose();
		}
		container = null;
	}

	/**
	 * Dispose the TilePart and its controls.
	 */
	public void dispose() {
		dispose(true);
	}

	/**
	 * Return the currently active child Tile
	 * 
	 * @return the currently active TilePart, or null if none.
	 */
	protected ITilePart<T> getActiveChild() {
		if(activeModelIndex != -1)
			return currentChildParts[activeModelIndex];

		// No active
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.sasheditor.sash.ITilePart#getActiveEditor()
	 */
	public IEditorPart getActiveEditor() {

		ITilePart<T> activePart = getActiveChild();
		if(activePart != null)
			return getActiveChild().getActiveEditor();
		// none
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.sasheditor.sash.ITilePart#setFocus()
	 */
	public void setFocus() {
		ITilePart<T> activePart = getActiveChild();
		if(activePart != null)

			getActiveChild().setFocus();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.sasheditor.sash.ITilePart#isDirty()
	 */
	public boolean isDirty() {
		if(currentChildParts[0].isDirty())
			return true;

		return currentChildParts[1].isDirty();
	}

	/**
	 * Traverses the tree to find the part that intersects the given point
	 * 
	 * @param toFind
	 *        Point in display coordinate
	 * @return the part that intersects the given point
	 */
	public ITilePart<T> findPart(Point toFind) {

		Rectangle bounds = DragUtil.getDisplayBounds(container); // container.getBounds();

		if(isVertical()) {
			if(toFind.y < bounds.y + (bounds.height / 2)) {
				return currentChildParts[0].findPart(toFind);
			}
			return currentChildParts[1].findPart(toFind);
		} else {
			if(toFind.x < bounds.x + (bounds.width / 2)) {
				return currentChildParts[0].findPart(toFind);
			}
			return currentChildParts[1].findPart(toFind);
		}
	}

	/**
	 * Locates the part that intersects the given point and that have the expected type
	 * 
	 * @param toFind
	 *        Position in Display coordinate.
	 * @return
	 */
	public <U extends ITilePart<T>> U findPartAt(Point toFind, Class<U> expectedTileType) {

		if(expectedTileType == this.getClass())
			return (U)this;

		Rectangle bounds = DragUtil.getDisplayBounds(container); // container.getBounds();

		if(isVertical()) {
			if(toFind.y < bounds.y + (bounds.height / 2)) {
				return currentChildParts[0].findPartAt(toFind, expectedTileType);
			}
			return currentChildParts[1].findPartAt(toFind, expectedTileType);
		} else {
			if(toFind.x < bounds.x + (bounds.width / 2)) {
				return currentChildParts[0].findPartAt(toFind, expectedTileType);
			}
			return currentChildParts[1].findPartAt(toFind, expectedTileType);
		}
	}


	/**
	 * Return true if this sash is vertical, false otherwise.
	 */
	private boolean isVertical() {
		return (container.getOrientation() == SWT.VERTICAL);
	}

	/**
	 * Find the part associated to the provided control.
	 * 
	 * @see org.eclipse.papyrus.sasheditor.sash.ITilePart#findPart(org.eclipse.swt.widgets.Control)
	 */
	public ITilePart<T> findPart(Object control) {
		if(this.getControl() == control) {
			return this;
		}

		ITilePart<T> node = currentChildParts[0].findPart(control);
		if(node != null) {
			return node;
		}
		node = currentChildParts[1].findPart(control);
		if(node != null) {
			return node;
		}
		return null;

	}

	/**
	 * 
	 * @see org.eclipse.papyrus.sasheditor.sash.ITilePart#getDropTarget(java.lang.Object, org.eclipse.swt.graphics.Point)
	 */
	public IDropTarget getDropTarget(Object draggedObject, TabFolderPart<T> sourcePart, Point position) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Return true if the TilePart is for the specified real model. Return false otherwise.
	 * 
	 * @param realModel
	 * @return
	 */
	public boolean isTilePartFor(T realModel) {
		return model.getNodeModel() == realModel;
	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.sash.ITilePart#synchronize2(org.eclipse.papyrus.sasheditor.sash.PartMap)
	 */
	public void synchronize2(GarbageMaps<T> partMap) {

		// Compare currentChildParts and node model
		assert (model.getChildModels().size() == 2);

		// Synchronize each child
		for(int i = 0; i < 2 /* model.getChildModels().size() */; i++) {
			synchronizeChild(i, partMap);
		}

		// Now recursively call synchronize on childs.
		for(int i = 0; i < currentChildParts.length; i++) {
			currentChildParts[i].synchronize2(partMap);
			// // Set the child controls at the right place
			// if(i==0)
			// container.moveAbove(currentChildParts[i].getControl());
			// else
			// container.moveBelow(currentChildParts[i].getControl());
			//
		}

	}

	/**
	 * Synchronize the specified child.
	 * 
	 * @param childIndex
	 *        index of the child to be synchronized
	 * @param partMap
	 */
	private void synchronizeChild(int childIndex, GarbageMaps<T> partMap) {

		T newModel = model.getChildModels().get(childIndex);

		// Check if old child exist
		// If exist, check if the current part is associated to the checked model
		// 
		ITilePart<T> currentChildPart = currentChildParts[childIndex];
		if(currentChildPart != null) {
			// If the tile is already for the model, there is nothing to do.
			if(currentChildPart.isTilePartFor(newModel))
				return;
			// The current tile is not for the model: mark it as orphan
			currentChildPart.orphan();
		}

		// The child tile need to be updated. Do it.
		// First check if already exist in the map
		ITilePart<T> newTile = partMap.getContainerPartMap().findTilePart(newModel);
		if(newTile != null) {
			// Reparent the tile
			newTile.reparent(this, getChildParent(childIndex));
		} else {
			// create the tile and its control
			newTile = getTilePartFactory().createTilePart(this, newModel);
			newTile.createControl(getChildParent(childIndex));
		}

		// Now, put the tile on the right side
		setChildToSide(newTile, childIndex);

	}

	/**
	 * Get the Composite parent that will be provided to the child.
	 * 
	 * @param childIndex
	 * @return
	 */
	private Composite getChildParent(int childIndex) {
		// return container;
		if(childIndex == 0)
			return container.getLeftParent();
		else
			return container.getRightParent();

	}

	/**
	 * Set the provided child at the specified index. If a child already exist at the specified index, it is lost. The controls are set accordingly
	 * 
	 * @param newTile
	 * @param childIndex
	 */
	private void setChildToSide(ITilePart<T> newTile, int childIndex) {
		currentChildParts[childIndex] = newTile;

	}

	/**
	 * Accept the provided visitor.
	 * Call the corresponding accept method in the visitor.
	 * 
	 * @param visitor
	 * @return
	 */
	public void visit(ITileVisitor visitor) {
		visitor.accept(this);
	}

	/**
	 * Visit the children of this Tile.
	 * 
	 * @param visitor
	 */
	public void visitChildren(ITileVisitor visitor) {
		for(ITilePart<T> child : currentChildParts) {
			child.visit(visitor);
		}
	}

	/**
	 * Show tile status.
	 */
	protected void showStatus() {
		System.out.println("sash[" + currentChildParts.length + "]:"
				+ ", disposed=" + container.isDisposed()
				+ ", visible=" + container.isVisible()
				+ ", garbState=" + garbageState
				+ ", " + this);
	}

	/**
	 * Update the children TilePart to be synchronized with the realModel. After calling this method, each children TilePart is the one for the
	 * corresponding model.realModel. Look first in the
	 * provided PartMap to find an existing TilePart for the realModel. Create it if not found. At the end of this call, childs control are not
	 * already updated.
	 * 
	 * @param partMap
	 */
	// private void updateChildren(PartMap partMap) {
	//	   
	// assert(currentChildParts.length==2);
	// List<Object> newRealModels = model.getChildModels();
	// // Compare both list
	// for(int i=0; i<currentChildParts.length; i++)
	// {
	// // Check if the current model is associated to the new realModel
	// if(! currentChildParts[i].isTilePartFor(newRealModels.get(i)))
	// {
	// // orphan actual node
	// currentChildParts[i].orphan();
	// // Synchronize
	// Object newModel = newRealModels.get(i);
	// // Look for an already existing part for this model
	// ITilePart part = partMap.get(newModel);
	// if(part != null)
	// { // Found, use it and orphan old part
	// part.reparent(this);
	// }
	// else
	// { // No part found, create a new one, replace new model
	// // orphan old part and replace with new part
	// part = getTilePartFactory().createTilePart(this, newModel);
	// }
	// // Attach new part
	// currentChildParts[i] = part;
	// } // end if
	// }
	// }
	/**
	 * Initialize the node: create the control, and attach the children. The children are only created if there are not present in the partMap.
	 * 
	 * @param partMap
	 */
	// private void initNode(PartMap partMap) {
	// // Create the sash
	// container = createContainer(getParent().getControl());
	//	   
	// // Create the childs
	// for(int i=0; i<2; i++)
	// {
	// Object childRealModel = model.getChildModels().get(i);
	// ITilePart part = partMap.findTilePart(childRealModel);
	// if(part != null)
	// {
	// part.reparent(this);
	// }
	// else
	// { // not found, create it
	// part = getTilePartFactory().createTilePart(this, childRealModel);
	// }
	//		   
	// currentChildParts[i] = part;
	// }
	//
	// }
	/**
	 * Set the specified ITilePart as the new child. Orphan the old child and replace it. Also set the child in the controls.
	 * 
	 * @param i
	 * @param part
	 */
	// private void reparentChild(int i, ITilePart part) {
	// currentChildParts[i].orphan();
	// currentChildParts[i] = part;
	// // Change the parent
	// part.reparent(this);
	// // move the control at the right place
	// // TODO Check if the following works.
	// // It can work because old control will be disposed later.
	// if(i==0)
	// container.moveAbove(part.getControl());
	// else
	// container.moveBelow(part.getControl());
	//		   
	//
	// }
}
