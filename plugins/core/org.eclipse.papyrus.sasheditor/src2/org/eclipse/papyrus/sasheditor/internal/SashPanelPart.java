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
package org.eclipse.papyrus.sasheditor.internal;

import java.util.logging.Logger;

import org.eclipse.papyrus.sasheditor.contentprovider.IAbstractPanelModel;
import org.eclipse.papyrus.sasheditor.contentprovider.ISashPanelModel;
import org.eclipse.papyrus.sasheditor.contentprovider.ITabFolderModel;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.internal.dnd.DragUtil;
import org.eclipse.ui.internal.dnd.IDropTarget;

/**
 * Controller for a sash panel.
 * A sash panel contain 2 children. It shows them in two windows separated by a sash.
 * Implementation use one model, a {@link ISashPanelModel}. This model encapsulate the real model which
 * is of an unknown type. 
 * 
 * 
 * @author dumoulin
 *
 * @param T Type of the external model representing the sash.
 */
@SuppressWarnings({ "restriction" })
public class SashPanelPart extends AbstractPanelPart implements IPanelParent {

	/** Log object */
	Logger log = Logger.getLogger(getClass().getName());

	/** Interface to the model */
	protected ISashPanelModel model;

	/** Raw model associated to this part. We store it because the PartModel do not provide it */
	private Object rawModel;

	/** Ordered set of currently shown diagrams (a left and right child, or upper and lower) TODO rename as children */
	protected AbstractPanelPart[] currentChildParts = new AbstractPanelPart[2];

	/**
	 * The container widget.
	 */
	private ReplaceableSashForm container;

	/**
	 * Direction of the sash: SWT.HORIZONTAL or SWT.VERTICAL. Default = SWT.HORIZONTAL
	 */
	private int sashDirection = SWT.HORIZONTAL;

	/**
	 * Constructor.
	 */
	public SashPanelPart(IPanelParent parent, ISashPanelModel model, Object rawModel) {
		super(parent);
		this.model = model;
		this.rawModel = rawModel;
		this.sashDirection = model.getSashDirection();
	}

	/**
	 * Get the associated model.
	 */
	public ISashPanelModel getPartModel() {
		return model;
	}

	/**
	 * Fill the provided part map with this parts and recursively call children to fillin.
	 * 
	 * @param partMap
	 */
	public void fillPartMap(PartLists partMap) {
		partMap.addPart(this);
		for (AbstractPanelPart child : currentChildParts) {
			child.fillPartMap(partMap);
		}
		garbageState = GarbageState.UNVISITED;
	}

	/**
	 * Create local control, and the tree of children (TileParts AND controls). Create this TilePart control, and then Tile childs of this TilePart.
	 * 
	 * @param parent
	 * @return Control
	 */
	public void createPartControl(Composite parent) {

		createControl(parent);
//		activate();
//		createChildrenControl();
	}

	/**
	 * Create local control. Does not create children.
	 * 
	 * @see org.eclipse.papyrus.sasheditor.sash.ITilePart#createControl(org.eclipse.swt.widgets.Composite)
	 */
	protected void createControl(Composite parent) {
		// container = new SashForm(parent, sashDirection);
		container = new ReplaceableSashForm(parent, sashDirection);
	}

	/**
	 * Create the part for the specified child model.
	 * The controls are NOT build.
	 * 
	 * TODO: delegate to sashContainer, remove duplication from here and RootPart.
	 * @param rootPart
	 * @param partModel
	 * @return
	 */
	private AbstractPanelPart createChildPart(Object rawModel) {
		
		// Create the child PartModel. Delegate creation to this part PartModel.
		IAbstractPanelModel model = getPartModel().createChildSashModel(rawModel);

		AbstractPanelPart createdPart;
		if(model instanceof ITabFolderModel)
		{
			createdPart =  new TabFolderPart(this, (ITabFolderModel)model, rawModel);
		}
		else if(model instanceof ISashPanelModel)
		{
			createdPart = new SashPanelPart(this, (ISashPanelModel)model, rawModel);
		}
		else
		{
			// error
			throw new IllegalArgumentException("Can't create child part for model of type '" 
					+ model.getClass().getName() 
					+ "'");
			// TODO: Return an error Part showing the exception instead of throwing it ?
		}
		
		return createdPart;
	}
		
	/**
	 * Create the part for the specified child model.
	 * The controls are build.
	 * 
	 * TODO: delegate to sashContainer, remove duplication from here and RootPart.
	 * @param rootPart
	 * @param partModel
	 * @return
	 */
	private AbstractPanelPart createChildPart(Object rawModel, int childIndex) {
		// Create parts
		AbstractPanelPart createdPart = createChildPart(rawModel);
		// Create controls
		createdPart.createPartControl(getChildParent(childIndex));
		return createdPart;
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
	@Override
	public void reparent(IPanelParent newParent, Composite swtParent) {
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
		getControl().setParent(swtParent);
		garbageState = GarbageState.REPARENTED;
	}

	/**
	 * Orphan this node, and children. The parent is set to null, but control is left unchanged. The node can be reattached with reparent().
	 * 
	 * @see
	 * @return the parent
	 */
	public void orphan() {

		// orphan only if we are in UNCHANGED state
		if (garbageState == GarbageState.UNVISITED) {
			garbageState = GarbageState.ORPHANED;
			parent = null;
		}
	}

	/**
	 * Dispose the TilePart and its controls.
	 * 
	 * @param isRecursive
	 *            If true, also dispose children.
	 * @see org.eclipse.papyrus.sasheditor.sash.ITilePart#dispose()
	 */
	public void dispose(boolean isRecursive) {

		// Dispose children if requested
		if (isRecursive) {
			for (AbstractPanelPart childModel : currentChildParts) {
				if (childModel != null)
					childModel.dispose();
			}
		}

		// dispose local resources
		if (container != null && !container.isDisposed()) {
			container.dispose();
		}
		container = null;
	}

	/**
	 * Dispose the TilePart and its controls.
	 */
	public void dispose() {
		dispose(false);
	}

	/**
	 * Traverses the tree to find the part that intersects the given point
	 * 
	 * @param toFind
	 *            Point in display coordinate
	 * @return the part that intersects the given point
	 * @throws NotFoundException 
	 */
	public AbstractPart findPart(Point toFind) throws NotFoundException {

		Rectangle bounds = DragUtil.getDisplayBounds(container); // container.getBounds();

		// Try the left/up pane
		bounds = DragUtil.getDisplayBounds(container.getLeftParent());
		if (bounds.contains(toFind)) {
			return currentChildParts[0].findPart(toFind);
		}
		bounds = DragUtil.getDisplayBounds(container.getRightParent());
		if(bounds.contains(toFind)) 
		{
			// Return right part
			return currentChildParts[1].findPart(toFind);
		}
		
		throw new NotFoundException("Can't find a part at '" + toFind + "'");
		
	
	}

	/**
	 * Locates the part that intersects the given point and that have the expected type
	 * 
	 * @param toFind Position in Display coordinate.
	 * @return
	 */
	public AbstractPart findPartAt(Point toFind, Class<?> expectedTileType) {
		
		if(expectedTileType == this.getClass())
			return this;
		
		Rectangle bounds = DragUtil.getDisplayBounds(container); // container.getBounds();

		if (isVertical()) {
			if (toFind.y < bounds.y + (bounds.height / 2)) {
				return currentChildParts[0].findPartAt(toFind, expectedTileType);
			}
			return currentChildParts[1].findPartAt(toFind, expectedTileType);
		} else {
			if (toFind.x < bounds.x + (bounds.width / 2)) {
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
	public AbstractPart findPart(Object control) {
		if (this.getControl() == control) {
			return this;
		}

		AbstractPart node = currentChildParts[0].findPart(control);
		if (node != null) {
			return node;
		}
		node = currentChildParts[1].findPart(control);
		if (node != null) {
			return node;
		}
		return null;

	}

	/**
	 * SashPanelPart can't be a DropTarget. Do nothing.
	 * @see org.eclipse.papyrus.sasheditor.sash.ITilePart#getDropTarget(java.lang.Object, org.eclipse.swt.graphics.Point)
	 */
	public IDropTarget getDropTarget(Object draggedObject, TabFolderPart sourcePart, Point position) {
		return null;
	}

	/**
	 * Return true if the Part is for the specified real model. Return false otherwise.
	 * 
	 * @param realModel The raw model to check
	 * @return
	 */
	public boolean isPartFor(Object realModel) {
		return getRawModel() == realModel;
	}

	/**
	 * Get the raw model associated to this part.
	 * @return
	 */
	protected Object getRawModel() {
		return rawModel;
	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.sash.ITilePart#synchronize2(org.eclipse.papyrus.sasheditor.sash.PartMap)
	 */
	public void synchronize2(PartLists partMap) {

		// Compare currentChildParts and node model
		assert (model.getChildren().size() == 2);

		// Synchronize each child
		for (int i = 0; i < 2 /*model.getChildModels().size()*/; i++) {
			synchronizeChild(i, partMap);
		}

		// Now recursively call synchronize on childs.
		for (int i = 0; i < currentChildParts.length; i++) {
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
	 *            index of the child to be synchronized
	 * @param existingParts
	 */
	private void synchronizeChild(int childIndex, PartLists existingParts) {

		Object newModel = model.getChildren().get(childIndex);

		// Check if old child exist
		// If exist, check if the current part is associated to the checked model
		// 
		AbstractPanelPart currentChildPart = currentChildParts[childIndex];
		if (currentChildPart != null) {
			// If the tile is already for the model, there is nothing to do.
			if (currentChildPart.isPartFor(newModel))
			{
				currentChildPart.unchanged();
				return;
			}
			// The current tile is not for the model: mark it as orphan
			currentChildPart.orphan();
		}

		// The child part need to be updated. Do it.
		// First check if already exist in the map
		AbstractPanelPart newTile = existingParts.findPartFor(newModel);
		if (newTile != null) {
			// Reparent the tile
			newTile.reparent(this, getChildParent(childIndex));
		} else {
			// create the tile and its control
			newTile = createChildPart(newModel, childIndex);
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
		if (childIndex == 0)
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
	private void setChildToSide(AbstractPanelPart newTile, int childIndex) {
		currentChildParts[childIndex] = newTile;

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
		for( AbstractPanelPart child : currentChildParts)
		{
			child.visit(visitor);
		}	
	}

	/**
	 * Show tile status.
	 * Used for debug purpose
	 */
	protected void showStatus()
	{
		System.out.println( "sash[" + currentChildParts.length + "]:"
				+ ", disposed=" + container.isDisposed()
				+ ", visible=" + container.isVisible()
				+ ", garbState=" + garbageState
				+ ", " + this);
	}

}
