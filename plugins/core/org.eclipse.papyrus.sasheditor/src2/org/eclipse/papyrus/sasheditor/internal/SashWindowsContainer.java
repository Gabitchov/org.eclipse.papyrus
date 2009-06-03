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

import org.eclipse.jface.util.Geometry;
import org.eclipse.papyrus.sasheditor.contentprovider.IComponentModel;
import org.eclipse.papyrus.sasheditor.contentprovider.IEditorModel;
import org.eclipse.papyrus.sasheditor.contentprovider.IPageModel;
import org.eclipse.papyrus.sasheditor.contentprovider.ISashWindowsContentProvider;
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
 * Main entry class of the SashWindows system.
 * This class allows to have a multitab window with sashes.
 * The class require a ContentProvider describing the content to be shown.
 * @author dumoulin
 */
public class SashWindowsContainer {

	/**
	 * The content provider describing the sashes, folders and tabs.
	 */
	private ISashWindowsContentProvider contentProvider;
	
	/**
	 * The manager used to get Main editor properties like Site, ActionBars, ...
	 */
	private IMultiEditorManager multiEditorManager;
	
	/**
	 * Tracker tracking the current active page. The tracker also disconnect last active page and connect 
	 * the new one.
	 */
	private ActivePageTracker activePageTracker;
	/**
	 * The part used as root. We use an extra class as root in order to separate the code dedicated to 
	 * ITilePart.
	 */
	private RootPart rootPart;

	/**
	 * The SWT container associated to this part. This is generally the container of the 
	 * parent.
	 */
	private Composite container;
	
	/**
	 * The drop target.
	 */
	protected DropTarget dropTarget;

	/**
	 * Constructor.
	 * Build a Container without IEditor management. Trying to add a EditorPart will result in an Exception.
	 * The ContentProvider should not contain IEditorModel.
	 */
	public SashWindowsContainer() {
		this.multiEditorManager = null;
		activePageTracker = new ActivePageTracker();
	}
	
	/**
	 * Constructor.
	 * Build a container with EditorPart management. The container will allow to add EditorPart 
	 * (and thus IEditorModel to the ContentProvider).
	 */
	public SashWindowsContainer(IMultiEditorManager multiEditorManager) {
		this.multiEditorManager = multiEditorManager;
		activePageTracker = new ActiveEditorAndPageTracker(multiEditorManager);
	}
	
	/**
	 * @return the contentProvider
	 */
	protected ISashWindowsContentProvider getContentProvider() {
		// Content provider should have been set.
		assert(contentProvider != null);
		// Double check for developement
		if(contentProvider == null)
			throw new IllegalStateException("ContentProvider should be set before calling any method requiring it.");
		
		return contentProvider;
	}

	/**
	 * Set the content provider describing the sashes, folders and tabs.
	 * @param contentProvider the contentProvider to set
	 */
	public void setContentProvider(ISashWindowsContentProvider contentProvider) {
		this.contentProvider = contentProvider;
	}

	/**
	 * Creates control associated to this Container.
	 * This method should be called when the parent is build.
	 * 
	 * @param parent
	 *            The parent in which the editor should be created; must not be <code>null</code>.
	 */
	public void createPartControl(Composite parent) {
		this.container = parent;

		rootPart = createRootPart();
		// Create the tree of tile part.
		rootPart.createPartControl(container);
		// Create children
		refreshTabs();
		// postCreatePartControl();
		// TODO reactivate next
		initDrag(container);
//		activate();
	}

	/**
	 * Create the root part for the model.
	 */
	private RootPart createRootPart() {
		RootPart part = new RootPart(this);
		return part;
	}

	/**
	 * Notifies this page container that the specified page has been activated. This method 
	 * is called when the user selects a different tab.
	 * 
	 * This method is called by inner parts whenever the active page part changes (when user selects a different tab).
	 * Propagate the event to activePageTracker.
	 * 
	 * @param childPart
	 */
	protected void activePageChange(PagePart childPart) {
		System.out.println("activePageChange("+childPart+")");
		activePageTracker.setActiveEditor(childPart);
	}

	/**
	 * A change has happen in one of the inner parts. Relay the event.
	 * This method is called by inner parts whenever the event happen in one of the part.
	 * 
	 * @param propertyId
	 */
	protected void firePropertyChange(int propertyId) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Create the part for the specified newModel.
	 * @param parent The parent of the created part.
	 * @param partModel The model for which a part should be created.
	 * @return
	 */
	protected PagePart createPagePart(TabFolderPart parent, IPageModel partModel, Object rawModel) {
		
		
		if( partModel instanceof IEditorModel)
		{
			// Check if we can use IEditorModel
			if(multiEditorManager == null)
				throw new IllegalArgumentException("Container can't accept IEditorModel as no IMultiEditorManager is set. Please set a IMultiEditorManager.");

			return new EditorPart(parent, (IEditorModel)partModel, rawModel, multiEditorManager);
		}
		else if( partModel instanceof IComponentModel)
		{
			return new ComponentPart(parent, (IComponentModel)partModel, rawModel);
		}
		else
		{
			// Return a default part
		}
		
		// TODO return a default part showing an error instead.
		throw new IllegalArgumentException("No Part found for the model '" + rawModel + "'");
	}

	/**
	 * Get the active page.
	 * @return
	 */
	private PagePart getActivePage() {
		return activePageTracker.getActiveEditor();
	}

	/**
	 * Get the currently active editor, or null if none is active.
	 * @return
	 */
	public IEditorPart getActiveEditor() {
		PagePart pagePart = getActivePage();
		if(pagePart instanceof EditorPart)
			return ((EditorPart)pagePart).getIEditorPart();
		else
		  return null;
	}

	/**
	 * The <code>AbstractMultiPageSashEditor</code> implementation of this
	 * <code>IWorkbenchPart</code> method sets focus on the active nested
	 * editor, if there is one.
	 * <p>
	 * Subclasses may extend or reimplement.
	 * </p>
	 */
	public void setFocus() {
		setFocus(getActivePage());
	}

	/**
	 * Sets focus to the control for the given page. If the page has an editor,
	 * this calls its <code>setFocus()</code> method. Otherwise, this calls
	 * <code>setFocus</code> on the control for the page.
	 * 
	 * @param pageIndex
	 *            the index of the page
	 */
	private void setFocus(PagePart part) {
		if(part!=null)
		  part.setFocus();
	}

	/**
	 * Refresh the SashWindows. 
	 * Synchronize the internal structure with the {@link ISashWindowsContentProvider}.
	 */
	public void refreshTabs() {
		System.out.println("start synchronize2() ------------------------");
		showTilesStatus();

		container.setRedraw(false);
		// Create map of parts
//		PartMap<T> partMap = new PartMap<T>();
		PartLists garbageMaps = new PartLists();
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
	}

	/**
	 * Show the status of the different Tiles composing the sash system.
	 * Used for debug purpose.
	 */
	protected void showTilesStatus()
	{
		ShowPartStatusVisitor visitor = new ShowPartStatusVisitor();
		rootPart.visit(visitor);
	}
	
	/* ***************************************************** */
	/*    Drag and Drop methods                              */
	/* ***************************************************** */
	
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
			System.out.println(SashWindowsContainer.this.getClass().getSimpleName() + ".drag(position=" + position + ", rectangle=" + dragRectangle + ")");
			// if (!(draggedObject instanceof ITilePart)) {
			// System.out.println("drag object is of bad type (" +draggedObject + "!=ITilePart)");
			// return null;
			// }

			// @TODO remove the cast by changing the method. Only folder can be source and target
			final TabFolderPart sourcePart = (TabFolderPart) rootPart.findPart(draggedObject); // (ITilePart) draggedObject;
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
			AbstractPanelPart targetPart = null;
			// ILayoutContainer sourceContainer = isStackType(sourcePart) ? (ILayoutContainer) sourcePart
			// : sourcePart.getContainer();

			// Check if the cursor is inside the container
			if (containerDisplayBounds.contains(position)) {

				System.out.println("Inside container bounds");
				if (rootPart != null) {
					targetPart = (AbstractPanelPart)rootPart.findPart(position);
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
						IDropTarget target = targetPart.getDropTarget(draggedObject, (TabFolderPart) sourcePart, position);
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
				System.out.println("Outside container bounds");
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
	private DropTarget createDropTarget(final TabFolderPart sourcePart, int srcTabIndex, int side, int cursor, AbstractPart targetPart) {
		if (dropTarget == null) {
			dropTarget = new DropTarget(sourcePart, srcTabIndex, side, cursor, targetPart);
		} else {
			dropTarget.setTarget(sourcePart, srcTabIndex, side, cursor, targetPart);
		}
		return dropTarget;
	}

	/**
	 * Class implementing methods required by drop targets.
	 */
	protected class DropTarget implements IDropTarget {

		int count = 0;

		int cursor = SWT.TOP;

		private int side;

		private AbstractPanelPart targetPart;

		private int srcTabIndex;

		private TabFolderPart sourcePart;

		/**
		 * Constructor.
		 */
		public DropTarget(TabFolderPart sourcePart, int srcTabIndex, int cursor, int side, AbstractPart targetPart) {
			this.cursor = cursor;
			this.side = side;
			this.sourcePart = sourcePart;
			this.srcTabIndex = srcTabIndex;
			this.targetPart = (AbstractPanelPart)targetPart;
		}

		public void setTarget(TabFolderPart sourcePart, int srcTabIndex, int cursor, int side, AbstractPart targetPart) {
			this.cursor = cursor;
			this.side = side;
			this.sourcePart = sourcePart;
			this.srcTabIndex = srcTabIndex;
			this.targetPart = (AbstractPanelPart)targetPart;
		}

		/**
		 * A folder is dropped.
		 * 
		 * @see org.eclipse.ui.internal.dnd.IDropTarget#drop()
		 */
		public void drop() {
			System.out.println(SashWindowsContainer.this.getClass().getSimpleName() + ".drop(source=" + sourcePart + ", target=" + targetPart + "side=" + side);

			// @TODO remove next cast
			if (side == SWT.CENTER) { // Add to target folder
				contentProvider.movePage(sourcePart.getPartModel(), srcTabIndex, ((TabFolderPart) targetPart).getPartModel(), -1);
			} else { // Create a new folder
				contentProvider.createFolder(sourcePart.getPartModel(), srcTabIndex, ((TabFolderPart) targetPart).getPartModel(), side);
			}
		}

		/**
		 * Return the cursor used during drag.
		 * 
		 * @see org.eclipse.ui.internal.dnd.IDropTarget#getCursor()
		 */
		public Cursor getCursor() {
			System.out.println(SashWindowsContainer.this.getClass().getSimpleName() + ".getCursor()-" + count++);
			return DragCursors.getCursor(DragCursors.positionToDragCursor(cursor));

		}

		public Rectangle getSnapRectangle() {
			System.out.println(SashWindowsContainer.this.getClass().getSimpleName() + ".getSnapRectangle(" + "sourcePart=" + sourcePart + ", targetPart=" + targetPart + ", side=" + side);
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

		protected float getDockingRatio(AbstractPart dragged, AbstractPart target) {
			return 0.5f;
		}

	}




}
