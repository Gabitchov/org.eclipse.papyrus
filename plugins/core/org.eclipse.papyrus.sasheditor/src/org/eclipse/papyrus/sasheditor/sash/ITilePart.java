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
 * Base interface for controllers associated to sash model
 * 
 * @param T
 *            Common ancestor for the model provided to the sash windows by the application. This is
 *            the type used externally by the application. Sash implementation don't use this type,
 *            it just carry it to ask for the appropriate wrapper. Concrete implementation can
 *            specify a type.
 * 
 * @author dumoulin
 */
@SuppressWarnings("restriction")
public interface ITilePart<T> {

	/**
	 * Enumeration used when the parts are synchronized.
	 */
	public enum GarbageState {
		UNCHANGED, ORPHANED, REPARENTED, CREATED
	}

	/**
	 * Base interface for the TilePart model
	 * 
	 * @param T
	 *            Common ancestor for the model provided for the sash windows by the application.
	 *            This is the type used externally by the application. Sash implementation don't use
	 *            this type, it just carry it to ask for the appropriate wrapper. Concrete
	 *            implementation can specify a type.
	 */
	public interface ITilePartNodeModel<T> {

		/**
		 * Get the underlying object associated to this model.
		 */
		public T getNodeModel();

		/**
		 * Add a listener on change in the model.
		 * 
		 * @NOTE Here we use Observer to be independant from EMF. If such dependency is introduce in
		 *       the plugin, we can use Adapter.
		 * @param listener
		 *            The listener that will be notified of the change
		 */
		// @unused
		public void addChangeListener(IListener<T> listener);

		/**
		 * Remove a listener on change in the model.
		 * 
		 * @param listener
		 *            The listener to remove
		 */
		// @unused
		public void removeChangeListener(IListener<T> listener);

		/**
		 * Activate listening on underlying model.
		 */
		// @unused
		public void activate();

		/**
		 * Deactivate listening on underlying model.
		 */
		public void deactivate();

	}

	/**
	 * Interface implemented by observer listening to node changes.
	 * 
	 * @NOTE We use this interface in order to be NOT dependant on EMF. If the plugin become
	 *       dependant on EMF, this interface can be replaced by Adapter.
	 */
	public interface IListener<T> {

		/**
		 * Notify the listener that the specified node has changed.
		 */
		// @unused
		public void notifyChanged(ITilePartNodeModel<T> node);
	}

	/**
	 * Create corresponding control. Create controls of the part, and also ask children to create
	 * their controls.
	 * 
	 * @param parent
	 * @return Control
	 */
	public void createPartControl(Composite parent);

	/**
	 * Create the control of the part, with the provided parent. Do not create control for children.
	 * 
	 * @param parent
	 */
	public void createControl(Composite parent);

	/**
	 * Get associated SWT Control.
	 */
	public Composite getControl();

	/**
	 * Orphan this node. The parent is set to null, but control is left unchanged. The node can be
	 * reattached with reparent(). Change garbage state to {@link GarbageState.ORPHANED}. This
	 * method as no effect if the Tile has already been reparented.
	 * 
	 * @see
	 * @return the parent
	 */
	public void orphan();

	/**
	 * Return true if this node is orphaned (parent is null).
	 * 
	 * @return
	 */
	public boolean isOrphaned();

	/**
	 * Change the parent of the Tile. The parent is changed, and the control is attached to the
	 * parent control. Change garbage state to {@link GarbageState.REPARENTED}. Do not detach the
	 * Tile from its old parent.
	 * 
	 * @param newParent
	 *            The tilePart that should be used as part parent.
	 * @param compositeParent
	 *            The composite that should be used as parent.
	 */
	public void reparent(ITilePart<T> newParent, Composite compositeParent);

	/**
	 * Get the garbage state of this part.
	 * 
	 * @return
	 */
	public GarbageState getGarbageState();

	/**
	 * This method disposes all nested editors.
	 * 
	 * @param isRecursive
	 *            If true, also dispose children.
	 */
	public void dispose(boolean isRecursive);

	/**
	 * Returns the active nested editor if there is one.
	 * <p>
	 * Subclasses should not override this method
	 * </p>
	 * TODO : put this method as a ITileContainer method
	 * 
	 * @return the active nested editor, or <code>null</code> if none
	 */
	public IEditorPart getActiveEditor();

	/**
	 * Asks this part to take focus within the workbench. Set the focus on the active nested part if
	 * the part is a container.
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
	 */
	public void setFocus();

	/**
	 * The <code>MultiPageEditorPart</code> implementation of this <code>IEditorPart</code> method
	 * returns whether the contents of any of this multi-page editor's nested editors have changed
	 * since the last save. Pages created with <code>addPage(Control)</code> are ignored.
	 * <p>
	 * Subclasses may extend or reimplement this method.
	 * </p>
	 * 
	 * @return <code>true</code> if any of the nested editors are dirty; <code>false</code>
	 *         otherwise.
	 */
	public boolean isDirty();

	/**
	 * Locates the part that intersects the given point
	 * 
	 * @param toFind
	 * @return
	 */
	public ITilePart<T> findPart(Point toFind);

	/**
	 * Locates the part that intersects the given point and that have the expected type
	 * 
	 * @param toFind
	 * @return
	 */
	public <U extends ITilePart<T>> U findPartAt(Point toFind, Class<U> tileType);

	/**
	 * Locates the part associated to the specified Control
	 * 
	 */
	public ITilePart<T> findPart(Object control);

	/**
	 * Ask the target if it can handle the drop event. The object is considered as the target.
	 * 
	 * @param sourcePart
	 * @return an IDropTarget instance if it can handle the drop, or null if it can't handle the
	 *         drop.
	 * 
	 *         TODO : put this method as a ITileContainer method
	 */
	public IDropTarget getDropTarget(Object draggedObject, TabFolderPart<T> sourcePart, Point position);

	/**
	 * Set the container holding all the TilePart. Not intended to be used outside of this package.
	 * Called immediately after the TilePart creation, and before call to createPartControl.
	 */
	// public void setParentPartContainer(TilePartContainer<T> rootContainer);

	/**
	 * Synchronize the Part, and its children. PartMap contains a snapshot of the available part
	 * before the synchronization. After synchronization, unreachable parts should be marked
	 * "orphaned" (= no parent).
	 * 
	 * This is for internal use.
	 * 
	 * @param partMap
	 */
	public void synchronize2(GarbageMaps<T> partMap);

	/**
	 * Fill the provided part map with this parts and recursively call children to fillin. All
	 * Garbage state are reset to UNCHANGED
	 * 
	 * @param garbageMaps
	 *            The maps to fill.
	 */
	public void fillPartMap(GarbageMaps<T> garbageMaps);

	/**
	 * Return true if the TilePart is for the specified real model. Return false otherwise.
	 * 
	 * @param model
	 * @return true if the Part is associated with the realModel.
	 */
	public boolean isTilePartFor(T realModel);

	/**
	 * Method used to visit the hierarchy of Tiles.
	 * 
	 * @param visitor
	 * @return
	 */
	public void visit(ITileVisitor visitor);

	/**
	 * Method used to visit the children of the specified Tile.
	 * 
	 * @param visitor
	 * @return
	 */
	public void visitChildren(ITileVisitor visitor);

}