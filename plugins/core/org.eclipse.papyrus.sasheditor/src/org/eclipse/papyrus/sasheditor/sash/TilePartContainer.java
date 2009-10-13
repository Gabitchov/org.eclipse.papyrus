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

import org.eclipse.jface.util.Geometry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.internal.DragCursors;
import org.eclipse.ui.internal.dnd.DragUtil;
import org.eclipse.ui.internal.dnd.IDragOverListener;
import org.eclipse.ui.internal.dnd.IDropTarget;

/**
 * Container of TilePart, used to have SashWindow with TabFolder. This container is the root of TilePart.
 * 
 * @param T Common ancestor for the model provided to the sash windows by the application. 
 * This is the type used externally by the application. Sash implementation don't use this type,
 * it just carry it to ask for the appropriate wrapper. Concrete implementation can specify 
 * a type.
 * 
 */
@SuppressWarnings("restriction")
public class TilePartContainer <T> {

	/**
	 * Root of nested tiles. Should not be null.
	 */
	protected RootPart<T> rootPart;

	/**
	 * Control associated to this Part.
	 */
	protected Composite container;

	/**
	 * The nestedPartManager (i.e. the main editor.) Used to propagate data between editor in parts and the main editor.
	 */
	protected IMultiEditorNestedPartManager nestedPartManager;

	/**
	 * Object responsible of tracking the active editor.
	 * Nested container should inform this object of activeEditor change.
	 */
	protected ActiveEditorTracker activeEditorTracker;
	
	/**
	 * Factory use to create TilePart from an object representing the real model.
	 */
	protected ITilePartFactory<T> tilePartFactory;

	/**
	 * The manager used by the container to manage the underlying model.
	 */
	protected ISashWindowsModelManager<T> model;

	/**
	 * The drop target.
	 */
	protected DropTarget dropTarget;

	/**
	 * Listen on model changes.
	 * Listen on all events, and refresh the entire structure.
	 */
	private ISashWindowModelChangeListener modelChangeListener = new ISashWindowModelChangeListener() {

		public void notifyChanged(ChangeEvent event) {
			synchronize2();
		}

	};

	/**
	 * Constructor.
	 */
	public TilePartContainer(IMultiEditorNestedPartManager nestedPartManager, ISashWindowsModelManager<T> model) {
		this.nestedPartManager = nestedPartManager;
		this.model = model;
		this.tilePartFactory = new TilePartFactory<T>(this);
		this.activeEditorTracker = new ActiveEditorTracker(nestedPartManager);
	}

	/**
	 * @return the nestedPartManager
	 */
	protected IMultiEditorNestedPartManager getNestedPartManager() {
		return nestedPartManager;
	}

	/**
	 * @return the tilePartFactory
	 */
	protected ITilePartFactory<T> getTilePartFactory() {
		return tilePartFactory;
	}

	/**
	 * Get the associated container model. Not part of the API. Internal use.
	 * 
	 * @return the container model
	 */
	protected ISashWindowsModelManager<T> getContainerModel() {
		return model;
	}

	/**
	 * Creates control associated to this Container.
	 * 
	 * @param parent
	 *            The parent in which the editor should be created; must not be <code>null</code>.
	 */
	public void createPartControl(Composite parent) {
		this.container = createContainer(parent);

		createRootPart();
		// Create the tree of tile part.
		rootPart.createPartControl(container);
		// postCreatePartControl();
		initDrag(container);
		activate();
		
	}

	/**
	 * Activate the Container: setup listeners
	 */
	protected void activate()
	{
		activateModelChangeListener();
	}
	
	/**
	 * Deactivate the container: unregister listeners.
	 */
	protected void deactivate()
	{
		deactivateModelChangeListener();
	}
	/**
	 * Activate the model change listener.
	 */
	private void activateModelChangeListener() {
		model.addChangeListener(modelChangeListener);
	}

	/**
	 * Activate the model change listener.
	 */
	private void deactivateModelChangeListener() {
		model.removeChangeListener(modelChangeListener);
	}

	/**
	 * Create a container.
	 */
	protected Composite createContainer(Composite parent) {
		return parent;
	}

	/**
	 * 
	 */
	private void initDrag(Composite container) {
		DragUtil.addDragTarget(container, dragOverListener);

	}

	IDragOverListener dragOverListener = new IDragOverListener() {

		/**
		 * 
		 * @see org.eclipse.ui.internal.dnd.IDragOverListener#drag(org.eclipse.swt.widgets.Control, java.lang.Object, org.eclipse.swt.graphics.Point, org.eclipse.swt.graphics.Rectangle)
		 */
		public IDropTarget drag(Control currentControl, Object draggedObject, Point position, Rectangle dragRectangle) {
			System.out.println(TilePartContainer.this.getClass().getSimpleName() + ".drag(position=" + position + ", rectangle=" + dragRectangle + ")");
			// if (!(draggedObject instanceof ITilePart)) {
			// System.out.println("drag object is of bad type (" +draggedObject + "!=ITilePart)");
			// return null;
			// }

			// @TODO remove the cast by changing the method. Only folder can be source and target
			final TabFolderPart<T> sourcePart = (TabFolderPart<T>) rootPart.findPart(draggedObject); // (ITilePart) draggedObject;
			// Compute src tab index
			// @TODO move that and previous in the sender of drag event. Use a class containing both as draggedObject.
			final int srcTabIndex = PTabFolder.getDraggedObjectTabIndex(draggedObject);

			// if (!isStackType(sourcePart) && !isPaneType(sourcePart)) {
			// return null;
			// }

			// boolean differentWindows = sourcePart.getWorkbenchWindow() != getWorkbenchWindow();
			// boolean editorDropOK = ((sourcePart instanceof EditorPane) &&
			// sourcePart.getWorkbenchWindow().getWorkbench() ==
			// getWorkbenchWindow().getWorkbench());
			// if (differentWindows && !editorDropOK) {
			// return null;
			// }

			// If this container has no visible children
			// if (getVisibleChildrenCount(this) == 0) {
			// return createDropTarget(sourcePart, SWT.CENTER, SWT.CENTER, null);
			// }

			Rectangle containerDisplayBounds = DragUtil.getDisplayBounds(container);
			ITilePart<T> targetPart = null;
			// ILayoutContainer sourceContainer = isStackType(sourcePart) ? (ILayoutContainer) sourcePart
			// : sourcePart.getContainer();

			// Check if the cursor is inside the container
			if (containerDisplayBounds.contains(position)) {

				System.out.println("Inside cursor");
				if (rootPart != null) {
					targetPart = rootPart.findPart(position);
					// System.out.println("targetPart=" + targetPart
					// + ", position=" + position
					// + "container.toControl(position)=" + container.toControl(position));
				}

				if (targetPart != null) {
					final Control targetControl = targetPart.getControl();

					final Rectangle targetBounds = DragUtil.getDisplayBounds(targetControl);

					int side = Geometry.getClosestSide(targetBounds, position);
					int distance = Geometry.getDistanceFromEdge(targetBounds, position, side);
					//                    
					// // is the source coming from a standalone part
					// boolean standalone = (isStackType(sourcePart)
					// && ((PartStack) sourcePart).isStandalone())
					// || (isPaneType(sourcePart)
					// && ((PartPane) sourcePart).getStack()!=null
					// && ((PartPane) sourcePart).getStack().isStandalone());
					//                     
					// // Only allow dropping onto an existing stack from different windows
					// if (differentWindows && targetPart instanceof EditorStack) {
					// IDropTarget target = targetPart.getDropTarget(draggedObject, position);
					// return target;
					// }
					//                     
					// Reserve the 5 pixels around the edge of the part for the drop-on-edge cursor
					// Check if the target can handle the drop.
					if (distance >= 5) {
						// Otherwise, ask the part if it has any special meaning for this drop location
						// @TODO remove cast; change return type of findPart()
						IDropTarget target = targetPart.getDropTarget(draggedObject, (TabFolderPart<T>) sourcePart, position);
						if (target != null) {
							return target;
						}
					}
					//                     
					if (distance > 30) {
						// if (targetPart instanceof ILayoutContainer) {
						// ILayoutContainer targetContainer = (ILayoutContainer)targetPart;
						// if (targetContainer.allowsAdd(sourcePart)) {
						side = SWT.CENTER;
						// }
						// }
					}
					//                     
					// // If the part doesn't want to override this drop location then drop on the edge
					//                     
					// // A "pointless drop" would be one that will put the dragged object back where it started.
					// // Note that it should be perfectly valid to drag an object back to where it came from -- however,
					// // the drop should be ignored.
					//
					@SuppressWarnings("unused")
					boolean pointlessDrop = false;

					if (sourcePart == targetPart) {
						pointlessDrop = true;
					}
					//
					// if ((sourceContainer != null)
					// && (sourceContainer == targetPart)
					// && getVisibleChildrenCount(sourceContainer) <= 1) {
					// pointlessDrop = true;
					// }
					//
					// if (side == SWT.CENTER
					// && sourcePart.getContainer() == targetPart) {
					// pointlessDrop = true;
					// }
					//
					int cursor = side;
					//
					// if (pointlessDrop) {
					// side = SWT.NONE;
					// cursor = SWT.CENTER;
					// }
					//
					return createDropTarget(sourcePart, srcTabIndex, side, cursor, targetPart);
				}
			} else {
				// Cursor is outside the container
				System.out.println("Outside cursor");
				// We only allow dropping into a stack, not creating one
				// if (differentWindows)
				// return null;

				int side = Geometry.getClosestSide(containerDisplayBounds, position);

				boolean pointlessDrop = false;
				//
				// if ((isStackType(sourcePart) && sourcePart.getContainer() == this)
				// || (sourcePart.getContainer() != null
				// && isPaneType(sourcePart)
				// && getVisibleChildrenCount(sourcePart.getContainer()) <= 1)
				// && ((LayoutPart)sourcePart.getContainer()).getContainer() == this) {
				// if (root == null || getVisibleChildrenCount(this) <= 1) {
				// pointlessDrop = true;
				// }
				// }
				//
				int cursor = Geometry.getOppositeSide(side);

				if (pointlessDrop) {
					side = SWT.NONE;
				}

				return createDropTarget(sourcePart, srcTabIndex, side, cursor, null);
			}
			//
			return null;
		} // end method

	};

	/**
	 * Create the drop target
	 */
	private DropTarget createDropTarget(final TabFolderPart<T> sourcePart, int srcTabIndex, int side, int cursor, ITilePart<T> targetPart) {
		if (dropTarget == null) {
			dropTarget = new DropTarget(sourcePart, srcTabIndex, side, cursor, targetPart);
		} else {
			dropTarget.setTarget(sourcePart, srcTabIndex, side, cursor, targetPart);
		}
		return dropTarget;
	}

	/**
	 * Synchronize the TilePart with the underlying model.
	 */
	public void synchronize2() {
		System.out.println("start synchronize2() ------------------------");

		container.setRedraw(false);
		// Create map of parts
//		PartMap<T> partMap = new PartMap<T>();
		GarbageMaps<T> garbageMaps = new GarbageMaps<T>();
		rootPart.fillPartMap(garbageMaps);

		// Synchronize parts
		rootPart.synchronize2(garbageMaps);

		
		// Remove orphaned parts (no more used)
		garbageMaps.garbage();

		// Reenable SWT and force layout
		container.setRedraw(true);
		container.layout(true, true);
		System.out.println("end synchronize2() ------------------------");
		showTilesStatus();
	}; // end class

	/**
	 * 
	 * @see org.eclipse.papyrus.sasheditor.eclipsecopy.MultiPageEditorPart#dispose()
	 */
	public void dispose() {
		deactivate();
		rootPart.dispose(true);
	}

	/**
	 * Create the root part from the model.
	 */
	protected void createRootPart() {
		rootPart = new RootPart<T>(getTilePartFactory(), model);
	}

	/**
	 * Refresh the parts. This method synchronize the parts with the underlying model.
	 * TODO Remove this method ?
	 */
	public void refreshTabs() {
		synchronize2();
	}

	/**
	 * Asks this part to take focus within the workbench.
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
	 */
	public void setFocus() {
		rootPart.setFocus();

	}

	/**
	 * Get the active editor
	 * @return
	 */
	protected IEditorPart getActiveEditor() {
		if(activeEditorTracker!=null)
			return activeEditorTracker.getActiveEditor().getIEditorPart();
		
		// TODO remove next and previuos if as soon as the tracker is working.
		return rootPart.getActiveEditor();
	}

	/**
	 * Get the editor currently under the mouse.
	 * @return
	 */
	public IEditorPart getEditorUnderMouse()
	{
		return getEditorTileAt(getMousePosition()).getIEditorPart();
	}
	
	/**
	 * Get the mouse position.
	 * Can be usefull to get the editor under the mouse.
	 * @return
	 */
	private Point getMousePosition()
	{
		return container.getDisplay().getCursorLocation();
	}
	
	/**
	 * Get the editorTile containing the specified position.
	 * @param mousePos
	 * @return
	 */
	private EditorTile getEditorTileAt(Point mousePos) {
		return (EditorTile)rootPart.findPartAt(mousePos, EditorTile.class);
	}

	/**
	 * Get the active editor
	 * @return
	 */
	protected void setActiveEditorTile( EditorTile<T>  activeTile) {
		activeEditorTracker.setActiveEditor(activeTile);
	}

	/**
	 * 
	 * @return <code>true</code> if any of the nested editors are dirty; <code>false</code> otherwise.
	 */
	public boolean isDirty() {
		return rootPart.isDirty();
	}

	/**
	 * Class implementing methods required by drop targets.
	 */
	protected class DropTarget implements IDropTarget {

		int count = 0;

		int cursor = SWT.TOP;

		private int side;

		private ITilePart<T> targetPart;

		private int srcTabIndex;

		private TabFolderPart<T> sourcePart;

		/**
		 * Constructor.
		 */
		public DropTarget(TabFolderPart<T> sourcePart, int srcTabIndex, int cursor, int side, ITilePart<T> targetPart) {
			this.cursor = cursor;
			this.side = side;
			this.sourcePart = sourcePart;
			this.srcTabIndex = srcTabIndex;
			this.targetPart = targetPart;
		}

		public void setTarget(TabFolderPart<T> sourcePart, int srcTabIndex, int cursor, int side, ITilePart<T> targetPart) {
			this.cursor = cursor;
			this.side = side;
			this.sourcePart = sourcePart;
			this.srcTabIndex = srcTabIndex;
			this.targetPart = targetPart;
		}

		/**
		 * A folder is dropped.
		 * 
		 * @see org.eclipse.ui.internal.dnd.IDropTarget#drop()
		 */
		public void drop() {
			System.out.println(TilePartContainer.this.getClass().getSimpleName() + ".drop(source=" + sourcePart + ", target=" + targetPart + "side=" + side);

			// @TODO remove next cast
			if (side == SWT.CENTER) { // Add to target folder
				model.moveTab(sourcePart.getModel(), srcTabIndex, ((TabFolderPart<T>) targetPart).getModel(), -1);
			} else { // Create a new folder
				model.createFolder(sourcePart.getModel(), srcTabIndex, ((TabFolderPart<T>) targetPart).getModel(), side);
			}
		}

		/**
		 * Return the cursor used during drag.
		 * 
		 * @see org.eclipse.ui.internal.dnd.IDropTarget#getCursor()
		 */
		public Cursor getCursor() {
			System.out.println(TilePartContainer.this.getClass().getSimpleName() + ".getCursor()-" + count++);
			return DragCursors.getCursor(DragCursors.positionToDragCursor(cursor));

		}

		public Rectangle getSnapRectangle() {
			System.out.println(TilePartContainer.this.getClass().getSimpleName() + ".getSnapRectangle(" + "sourcePart=" + sourcePart + ", targetPart=" + targetPart + ", side=" + side);
			Rectangle targetDisplayBounds;

			if (targetPart != null) {
				targetDisplayBounds = DragUtil.getDisplayBounds(targetPart.getControl());
			} else {
				// targetBounds = DragUtil.getDisplayBounds(getParent());
				targetDisplayBounds = DragUtil.getDisplayBounds(container);
			}

			if (side == SWT.CENTER || side == SWT.NONE) {
				return targetDisplayBounds;
			}

			int distance = Geometry.getDimension(targetDisplayBounds, !Geometry.isHorizontal(side));

			return Geometry.getExtrudedEdge(targetDisplayBounds, (int) (distance * getDockingRatio(sourcePart, targetPart)), side);
		}

		protected float getDockingRatio(ITilePart<T> dragged, ITilePart<T> target) {
			return 0.5f;
		}

	}

	/**
	 * Show the status of the different Tiles composing the sash system.
	 * Used for debug purpose.
	 */
	protected void showTilesStatus()
	{
		ShowModelsVisitor visitor = new ShowModelsVisitor();
		rootPart.visit(visitor);
	}
	
	/**
	 * Visitor used to show the status of the different Tiles composing the sash system.
	 * @author dumoulin
	 *
	 */
	@SuppressWarnings("unchecked")
	private class ShowModelsVisitor extends TileVisitor {
		int level=1;
		
		/**
		 * @param tile
		 */
		
		@Override
		public void accept(RootPart tile) {
			indent();
			tile.showStatus();
//			System.out.println( "root:" + tile );
			level++;
			super.accept(tile);
			level--;
		}
		
		/**
		 * 
		 */
		private void indent() {
			if(level<1)
			{
				//error
				return;
			}
			
			for(int i=0; i<level-1; i++)
			{
			  System.out.print("|   ");
			}
			// last segment
			System.out.print("+ ");

		}

		/**
		 * @param tile
		 */
		@Override
		public void accept(SashPart tile) {
			indent();
			tile.showStatus();
//			System.out.println( "sash:" + tile );
			level++;
			super.accept(tile);
			level--;
		}
		
		/**
		 * @param tile
		 */
		@Override
		public void accept(TabFolderPart tile) {
			indent();
			tile.showStatus();
//			System.out.println( "folder:" + tile );
			level++;
			super.accept(tile);
			level--;
		}
		
		/**
		 * @param tile
		 */
		@Override
		public void accept(EditorTile tile) {
			indent();
			tile.showStatus();
//			System.out.println( "editor:" + tile );
			level++;
			super.accept(tile);
			level--;
		}
	}


}
