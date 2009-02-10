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
 * 
 * @author dumoulin
 * 
 */
public interface ITilePart {

	/**
	 * Enumeration used when the parts are synchronized.
	 */
	public enum GarbageState {
		UNCHANGED, ORPHANED, REPARENTED
	}

	/**
	 * Base interface for the TilePart model
	 */
	public interface ITilePartNodeModel {

		/**
		 * Get the underlying object associated to this model.
		 */
		public Object getNodeModel();

		/**
		 * Add a listener on change in the model.
		 * 
		 * @NOTE Here we use Observer to be independant from EMF. If such dependency is introduce in the plugin, we can use Adapter.
		 * @param listener
		 *            The listener that will be notified of the change
		 */
		public void addChangeListener(IListener listener);

		/**
		 * Remove a listener on change in the model.
		 * 
		 * @param listener
		 *            The listener to remove
		 */
		public void removeChangeListener(IListener listener);

		/**
		 * Activate listening on underlying model.
		 */
		public void activate();

		/**
		 * Deactivate listening on underlying model.
		 */
		public void deactivate();

	}

	/**
	 * Interface implemented by observer listening to node changes.
	 * 
	 * @NOTE We use this interface in order to be NOT dependant on EMF. If the plugin become dependant on EMF, this interface can be replaced by Adapter.
	 */
	public interface IListener {

		/**
		 * Notify the listener that the specified node has changed.
		 */
		public void notifyChanged(ITilePartNodeModel node);
	}

	/**
	 * Create corresponding control.
	 * 
	 * @param parent
	 * @return Control
	 */
	public void createPartControl(Composite parent);

	/**
	 * Get associated SWT Control.
	 */
	public Composite getControl();

	/**
	 * Orphan this node. The parent is set to null, but control is left unchanged. The node can be reattached with reparent(). Change garbage state
	 * 
	 * @see
	 * @return the parent
	 */
	public void orphan();

	/**
	 * Change the parent of this method. The parent is changed, and the control is attached to the parent control. Change garbage state
	 * 
	 * @param newParent
	 *            The tilePart that should be used as part parent.
	 * @param compositeParent
	 *            The composite that should be used as parent.
	 */
	public void reparent(ITilePart newParent, Composite compositeParent);

	/**
	 * Get the garbage state of this part.
	 * 
	 * @return
	 */
	public GarbageState getGarbageState();

	/**
	 * Refresh the TilePart. This method synchronize this TilePart with its underlying model.
	 */
	public void refreshTabs();

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
	 * 
	 * @return the active nested editor, or <code>null</code> if none
	 */
	public IEditorPart getActiveEditor();

	/**
	 * Asks this part to take focus within the workbench.
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
	 */
	public void setFocus();

	/**
	 * The <code>MultiPageEditorPart</code> implementation of this <code>IEditorPart</code> method returns whether the contents of any of this multi-page editor's nested editors have changed since the
	 * last save. Pages created with <code>addPage(Control)</code> are ignored.
	 * <p>
	 * Subclasses may extend or reimplement this method.
	 * </p>
	 * 
	 * @return <code>true</code> if any of the nested editors are dirty; <code>false</code> otherwise.
	 */
	public boolean isDirty();

	/**
	 * Locates the part that intersects the given point
	 * 
	 * @param toFind
	 * @return
	 */
	public ITilePart findPart(Point toFind);

	/**
	 * Locates the part associated to the specified Control
	 * 
	 */
	public ITilePart findPart(Object control);

	/**
	 * Ask the target if it can handle the drop event. The object is considered as the target.
	 * 
	 * @param sourcePart
	 * @return an IDropTarget instance if it can handle the drop, or null if it can't handle the drop.
	 */
	public IDropTarget getDropTarget(Object draggedObject, TabFolderPart sourcePart, Point position);

	/**
	 * Set the container holding all the TilePart. Not intended to be used outside of this package. Called immediately after the TilePart creation, and before call to createPartControl.
	 */
	public void setParentPartContainer(TilePartContainer rootContainer);

	/**
	 * Synchronize the Part, and its children. PartMap contains a snapshot of the available part before the synchronization. After synchronization, unreachable parts should be marked "orphaned" (= no
	 * parent).
	 * 
	 * This is for internal use.
	 * 
	 * @param partMap
	 */
	public void synchronize2(PartMap partMap);

	/**
	 * Return true if the TilePart is for the specified real model. Return false otherwise.
	 * 
	 * @param model
	 * @return
	 */
	public boolean isTilePartFor(Object realModel);

	/**
	 * Fill the provided part map with this parts and recursively call children to fillin. All Garbage state are reset to UNCHANGED
	 * 
	 * @param partMap
	 */
	public void fillPartMap(PartMap partMap);

	/**
	 * Return true if this node is orphaned (parent is null)
	 * 
	 * @return
	 */
	public boolean isOrphaned();

	/**
	 * Create the control of the part, with the provided parent.
	 * 
	 * @param parent
	 */
	public void createControl(Composite parent);
}