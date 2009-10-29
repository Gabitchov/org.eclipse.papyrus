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

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.internal.dnd.IDropTarget;

/**
 * Part used as root. This is the one with no parent and no model. This class is intended for local
 * use only.
 * 
 * @author dumoulin
 * 
 * @param T
 *            Common ancestor for the model provided for the sash windows by the application. This
 *            is the type used externally by the application. Sash implementation don't use this
 *            type, it just carry it to ask for the appropriate wrapper. Concrete implementation can
 *            specify a type.
 */
@SuppressWarnings("restriction")
public class RootPart<T> implements ITilePart<T> {

	/** The SWT container used as parent of all */
	protected Composite rootContainer;

	/** The model used by this node */
	protected ISashWindowsModelManager<T> model;

	/** Factory used to create Part */
	protected ITilePartFactory<T> tilePartfactory;

	/**
	 * The first SWT controled part;
	 */
	protected ITilePart<T> child;

	/**
	 * Constructor.
	 */
	public RootPart(ITilePartFactory<T> tilePartfactory, ISashWindowsModelManager<T> model) {
		this.model = model;
		this.tilePartfactory = tilePartfactory;
	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.sash.ITilePart#createPartControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createPartControl(Composite parent) {
		this.rootContainer = parent;
		T realModel = model.getSashWindowsModelRoot();
		child = getTilePartFactory().createTilePart(this, realModel);
		child.createPartControl(rootContainer);
	}

	/**
	 * Do nothing, as there is no control associated to this part.
	 * 
	 * @see org.eclipse.papyrus.sasheditor.sash.ITilePart#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		// Do nothing, as there is no control associated to this part.

	}

	/**
	 * Return true if the TilePart is for the specified real model. Return false otherwise.
	 * 
	 * @param realModel
	 * @return
	 */
	public boolean isTilePartFor(T realModel) {
		return model.getSashWindowsModelRoot() == realModel;
	}

	/**
	 * Synchronize the
	 * 
	 * @see org.eclipse.papyrus.sasheditor.sash.ITilePart#synchronize2(org.eclipse.papyrus.sasheditor.sash.PartMap)
	 */
	public void synchronize2(GarbageMaps<T> partMap) {

		// Synchronize locally the child
		synchronizeChild(partMap);
		// Synchronize recursively subchilds.
		child.synchronize2(partMap);

	}

	/**
	 * Synchronize locally the child
	 * 
	 * @param partMap
	 */
	private void synchronizeChild(GarbageMaps<T> partMap) {
		T newModel = model.getSashWindowsModelRoot();

		// Check if old child exist
		// If exist, check if the current part is associated to the checked
		// model
		// 
		if (child != null) {
			// If the tile is already for the model, there is nothing to do.
			if (child.isTilePartFor(newModel)) {
				return;
			}
			// The current tile is not for the model: mark it as orphan
			child.orphan();
		}

		// The child tile need to be updated. Do it.
		// First check if already exist in the map
		ITilePart<T> newTile = partMap.getContainerPartMap().findTilePart(newModel);
		if (newTile != null) {
			// Reparent the tile
			newTile.reparent(this, getChildParent());
		} else {
			// create the tile and its control
			newTile = getTilePartFactory().createTilePart(this, newModel);
			newTile.createControl(getChildParent());
		}

		// Now, put the tile on the right side
		setChild(newTile);
	}

	/**
	 * Set the child. If a child already exist at the specified index, it is lost.
	 * 
	 * @param newTile
	 */
	private void setChild(ITilePart<T> newTile) {
		child = newTile;
	}

	/**
	 * Get the Composite used as parent for childs.
	 * 
	 * @return
	 */
	private Composite getChildParent() {
		// This is the rootContainer
		return rootContainer;
	}

	/**
	 * Get the factory used to create part from an object model.
	 * 
	 * @return
	 */
	private ITilePartFactory<T> getTilePartFactory() {
		return tilePartfactory;
	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.sash.ITilePart#dispose()
	 */
	public void dispose(boolean isRecursive) {

		if (isRecursive) {
			child.dispose(true);
		}
	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.sash.ITilePart#fillPartMap(org.eclipse.papyrus.sasheditor.sash.PartMap)
	 */
	public void fillPartMap(GarbageMaps<T> partMap) {
		child.fillPartMap(partMap);

	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.sash.ITilePart#findPart(org.eclipse.swt.graphics.Point)
	 */
	public ITilePart<T> findPart(Point toFind) {
		return child.findPart(toFind);
	}

	/**
	 * Locates the part that intersects the given point and that have the expected type
	 * 
	 * @param toFind
	 * @return
	 */
	public <U extends ITilePart<T>> U findPartAt(Point toFind, Class<U> tileType) {
		return child.findPartAt(toFind, tileType);
	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.sash.ITilePart#findPart(java.lang.Object)
	 */
	public ITilePart<T> findPart(Object control) {
		return child.findPart(control);
	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.sash.ITilePart#getActiveEditor()
	 */
	public IEditorPart getActiveEditor() {
		return child.getActiveEditor();
	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.sash.ITilePart#getControl()
	 */
	public Composite getControl() {
		return rootContainer;
	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.sash.ITilePart#getDropTarget(java.lang.Object,
	 *      org.eclipse.papyrus.sasheditor.sash.TabFolderPart, org.eclipse.swt.graphics.Point)
	 */
	public IDropTarget getDropTarget(Object draggedObject, TabFolderPart<T> sourcePart, Point position) {
		return child.getDropTarget(draggedObject, sourcePart, position);
	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.sash.ITilePart#isDirty()
	 */
	public boolean isDirty() {
		return child.isDirty();
	}

	/**
	 * Do nothing. This node can't be orphaned
	 * 
	 * @see org.eclipse.papyrus.sasheditor.sash.ITilePart#orphan()
	 */
	public void orphan() {
		// Do nothing. This node can't be orphaned
	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.sash.ITilePart#isOrphaned()
	 */
	public boolean isOrphaned() {
		return false;
	}

	/**
	 * Do nothing. This node can't be reparented
	 * 
	 * @see org.eclipse.papyrus.sasheditor.sash.ITilePart#reparent(org.eclipse.papyrus.sasheditor.sash.ITilePart)
	 */
	public void reparent(ITilePart<T> newParent, Composite compositeParent) {
	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.sash.ITilePart#setFocus()
	 */
	public void setFocus() {
		child.setFocus();
	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.sash.ITilePart#setParentPartContainer(org.eclipse.papyrus.sasheditor.sash.TilePartContainer)
	 */
	// @unused
	public void setParentPartContainer(TilePartContainer<T> rootContainer) {

	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.sash.ITilePart#getGarbageState()
	 */
	public GarbageState getGarbageState() {
		return GarbageState.UNCHANGED;
	}

	/**
	 * Accept the provided visitor. Call the corresponding accept method in the visitor.
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
		child.visit(visitor);
	}

	/**
	 * Show tile status.
	 */
	protected void showStatus() {
		System.out.println("rootPart (1)" + ", disposed=" + rootContainer.isDisposed() + ", visible="
				+ rootContainer.isVisible() + ", " + this);
	}

}
