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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.papyrus.sasheditor.Activator;
import org.eclipse.papyrus.sasheditor.contentprovider.IComponentModel;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.internal.dnd.IDropTarget;

/**
 * This is a controler/part for an SWT Control. It is associated to a {@link IComponentModel}. This
 * Part encapsulate a SWT Control.
 * 
 * @author dumoulin
 * 
 */
@SuppressWarnings("restriction")
public class ComponentPart extends PagePart {

	/**
	 * The model representing the control.
	 */
	private final IComponentModel partModel;

	/**
	 * The SWT Control.
	 */
	private Composite editorControl;

	/**
	 * Parent owning this PagePart. Can be null if the Part is orphaned. Even if it is orphaned, the
	 * Item still set.
	 */
	// protected TabFolderPart parent;

	/**
	 * Listen on mouse enter event. Try to get an event indicating that the mouse enter over the
	 * editor. This can be used to switch the active editor. TODO This doesn't work yet.
	 */
	private final Listener mouseEnterListener = new Listener() {

		/**
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.Event)
		 */
		public void handleEvent(Event event) {
			Point globalPos = new Point(event.x, event.y);
			System.out.println("EditorTile.mouseEnterListener(" + eventName(event.type) + ", " + globalPos + ")");
		}
	};

	private String eventName(int eventType) {
		switch (eventType) {
		case SWT.MouseEnter:
			return "MouseEnter";
		case SWT.MouseDown:
			return "MouseDown";
		case SWT.MouseExit:
			return "MouseExit";
		case SWT.MouseHover:
			return "MouseHover";
		case SWT.FocusIn:
			return "FocusIn";
		case SWT.FocusOut:
			return "FocusOut";
		case SWT.MouseMove:
			return "MouseMove";
		case SWT.MouseUp:
			return "MouseUp";
		default:
			return Integer.toString(eventType);
		}
	}

	/**
	 * Constructor.
	 * 
	 * @param partModel
	 *            The model of the editor.
	 */
	public ComponentPart(TabFolderPart parent, IComponentModel partModel, Object rawModel) {
		super(parent, rawModel);
		this.partModel = partModel;
	}

	/**
	 * Create the control of this Part, and children's controls.
	 * 
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {

		try {
			// Initialize it and create its controls.
			editorControl = createEditorPartControl(parent);
			// attachListeners(editorControl, true);

		} catch (PartInitException e) {
			Activator.getDefault().getLog()
					.log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getLocalizedMessage()));
		}
	}

	/**
	 * Create the controls required by the editor. Init the editor.
	 * 
	 * @param viewer
	 * @param editorInput
	 * @param model
	 * @return
	 * @throws PartInitException
	 */
	private Composite createEditorPartControl(Composite parentControl) throws PartInitException {
		Composite editorParent = new Composite(parentControl, SWT.NONE);
		editorParent.setLayout(new FillLayout());
		partModel.createPartControl(editorParent);

		return editorParent;
	}

	/**
	 * Attach SWT listeners.
	 */
	private void attachListeners(Control theControl, boolean recursive) {

		// Both following methods listen to the same event.
		// So use only one of them
		theControl.addListener(SWT.MouseEnter, mouseEnterListener);

		theControl.addListener(SWT.FocusIn, mouseEnterListener);
		theControl.addListener(SWT.MouseMove, mouseEnterListener);
		theControl.addListener(SWT.MouseHover, mouseEnterListener);
		theControl.addListener(SWT.MouseUp, mouseEnterListener);
		theControl.addListener(SWT.MouseDown, mouseEnterListener);

		if (recursive && theControl instanceof Composite) {
			Composite composite = (Composite) theControl;
			Control[] children = composite.getChildren();

			for (Control control : children) {
				attachListeners(control, true);
			}
		}
	}

	/**
	 * Detach SWT listeners
	 */
	private void detachListeners(Control theControl, boolean recursive) {
		theControl.removeListener(SWT.MouseEnter, mouseEnterListener);
		theControl.removeListener(SWT.FocusIn, mouseEnterListener);

		if (recursive && theControl instanceof Composite) {
			Composite composite = (Composite) theControl;
			Control[] children = composite.getChildren();

			for (Control control : children) {
				detachListeners(control, false);
			}
		}
	}

	/**
	 * @param isRecursive
	 */
	public void dispose() {

		// detachListeners(editorControl, true);
		// dispose the SWT root control
		editorControl.dispose();
	}

	/**
	 * As we are a final Tile, we should be the requested part. Return this TilePart.
	 * 
	 * @param toFind
	 * @return
	 */
	// @unused
	public PagePart findPart(Point toFind) {
		return this;
	}

	/**
	 * Locates the part that intersects the given point and that have the expected type
	 * 
	 * @param toFind
	 * @return
	 */
	@Override
	public PagePart findPartAt(Point toFind, Class<?> expectedTileType) {

		if (expectedTileType == this.getClass()) {
			return this;
		}

		// Not found !!
		// The tile contains the position, but the type is not found.
		throw new UnsupportedOperationException("Tile match the expected position '" + toFind
				+ "' but there is no Tile of requested type '" + expectedTileType.getClass().getName() + "'");
	}

	/**
	 * @param control
	 * @return
	 */
	// @unused
	public PagePart findPart(Object control) {
		if (getControl() == control) {
			return this;
		}

		// Not found
		return null;
	}

	/**
	 * Get associated SWT Control.
	 * 
	 * @return
	 */
	@Override
	public Composite getControl() {
		return editorControl;
	}

	/**
	 * This is a container method. Not necessary in Leaf Tile. TODO: change the interface.
	 * 
	 * @param draggedObject
	 * @param sourcePart
	 * @param position
	 * @return
	 */
	// @unused
	public IDropTarget getDropTarget(Object draggedObject, TabFolderPart sourcePart, Point position) {
		return null;
	}

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
	@Override
	public void reparent(TabFolderPart newParent) {

		// Change the tile parent
		this.parent = newParent;
		// Change the SWT parent.
		editorControl.setParent(newParent.getControl());

		// Change state
		if (garbageState == GarbageState.UNVISITED || garbageState == GarbageState.ORPHANED) {
			garbageState = GarbageState.REPARENTED;
		} else {
			// Bad state, this is an internal error
			// TODO : log a warning ?
			throw new IllegalStateException("Try to change state from " + garbageState.toString()
					+ " to REPARENTED. This is forbidden.");
		}
	}

	/**
	 * Asks this part to take focus within the workbench. Set the focus on the active nested part if
	 * the part is a container.
	 */
	@Override
	public void setFocus() {
		editorControl.setFocus();
	}

	/**
	 * Synchronize the Part, and its children. PartMap contains a snapshot of the available part
	 * before the synchronization. After synchronization, unreachable parts should be marked
	 * "orphaned" (= no parent). Do nothing in this implementation, as we are a final leaf, and
	 * there is nothing to synchronize with the underlying model.
	 * 
	 * @param partMap
	 */
	// @unused
	public void synchronize2(PartLists partMap) {

	}

	/**
	 * Garbage this part. The part is already marked as ORPHANED. It is not used anymore. It is
	 * already detached from its parent.
	 * 
	 */
	@Override
	public void garbage() {
		dispose();
	}

	/**
	 * Accept the provided visitor. Call the corresponding accept method in the visitor.
	 * 
	 * @param visitor
	 * @return
	 */
	@Override
	public void visit(IPartVisitor visitor) {
		visitor.accept(this);
	}

	/**
	 * Visit the children of this Tile. There is no child, so do nothing.
	 * 
	 * @param visitor
	 */
	public void visitChildren(IPartVisitor visitor) {
	}

	/**
	 * Show item status.
	 */
	protected void showStatus() {
		// System.out.println( "EditorTile: "
		// + " disposed=" + editorControl.isDisposed()
		// + ", visible=" + editorControl.isVisible()
		// + ", garbState=" + garbageState
		// + ", '" + editorPart.getTitle()
		// + "', " + this);

		System.out.printf("ComponentPart: disposed=%-5b, visible=%-5b, garbState=%-10s, %s, %s\n", editorControl
				.isDisposed(), (editorControl.isDisposed() ? false : editorControl.isVisible()), garbageState,
				getPageTitle(), this);

	}

	/**
	 * Get the title for this part. {@inheritDoc}
	 */
	@Override
	public String getPageTitle() {
		return partModel.getTabTitle();
	}

	/**
	 * Return an icon for this part. {@inheritDoc}
	 */
	@Override
	public Image getPageIcon() {
		return partModel.getTabIcon();
	}
}
