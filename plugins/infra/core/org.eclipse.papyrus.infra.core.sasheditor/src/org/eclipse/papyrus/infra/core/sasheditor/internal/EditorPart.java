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

import java.io.PrintWriter;
import java.io.StringWriter;

import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.infra.core.sasheditor.Activator;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IEditorModel;
import org.eclipse.papyrus.infra.core.sasheditor.editor.IEditorPage;
import org.eclipse.papyrus.infra.core.sasheditor.internal.eclipsecopy.IMultiPageEditorSite;
import org.eclipse.papyrus.infra.core.sasheditor.internal.eclipsecopy.MultiPageEditorSite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.internal.ErrorEditorPart;
import org.eclipse.ui.internal.dnd.IDropTarget;
import org.eclipse.ui.internal.misc.StatusUtil;
import org.eclipse.ui.part.EditorActionBarContributor;
import org.eclipse.ui.part.IWorkbenchPartOrientation;


/**
 * This is a controler/part for an Editor. It is associated to a {@link IEditorModel}.
 * This Part encapsulate an Eclipse Editor implementing {@link IEditorPart}.
 * 
 * @author dumoulin
 * @author <a href="mailto:thomas.szadel@atosorigin.com">Thomas SZADEL</a> Improve the error text (avoid NPE)
 */
@SuppressWarnings("restriction")
public class EditorPart extends PagePart implements IEditorPage {

	/**
	 * The model representing the editor.
	 */
	private IEditorModel editorModel;

	/**
	 * The created Eclipse editor.
	 */
	private IEditorPart editorPart;

	/**
	 * The SWT Control containning the editor's controls.
	 */
	private Composite editorControl;

	/**
	 * The MultiPageContainer system. This is the manager of all tiles.
	 */
	//	private SashWindowsContainer tilesContainer;

	/**
	 * The manager used to access main editor properties like site, actionbars, ...
	 */
	private IMultiEditorManager multiEditorManager;

	/**
	 * Parent owning this PagePart.
	 * Can be null if the Part is orphaned. Even if it is orphaned, the Item still set.
	 */
	//	protected TabFolderPart parent;

	/**
	 * Listen on mouse enter event.
	 * Try to get an event indicating that the mouse enter over the editor.
	 * This can be used to switch the active editor.
	 * TODO This doesn't work yet.
	 */
	private Listener mouseEnterListener = new Listener() {

		/**
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.Event)
		 */
		public void handleEvent(Event event) {
			//			Point globalPos = new Point(event.x, event.y);
			//			System.out.println(this.getClass().getSimpleName() + ".handleEvent(" + eventName(event.type) + ", " + globalPos + ")");
		}
	};

	/**
	 * Listener on widget disposed event. When the widget is disposed, the associated IEditor dispose()
	 * method is called.
	 * 
	 */
	private DisposeListener widgetDisposedListener = new DisposeListener() {

		/**
		 * @see org.eclipse.swt.events.DisposeListener#widgetDisposed(org.eclipse.swt.events.DisposeEvent)
		 * @see SashWindowsContainer#dispose()
		 * @param e
		 */
		public void widgetDisposed(DisposeEvent e) {
			// We dispose the associated editor.
			disposeEditorPart();
		}
	};

	// To be removed
	//	private String eventName(int eventType) {
	//		switch(eventType) {
	//		case SWT.MouseEnter:
	//			return "MouseEnter";
	//		case SWT.MouseDown:
	//			return "MouseDown";
	//		case SWT.MouseExit:
	//			return "MouseExit";
	//		case SWT.MouseHover:
	//			return "MouseHover";
	//		case SWT.FocusIn:
	//			return "FocusIn";
	//		case SWT.FocusOut:
	//			return "FocusOut";
	//		case SWT.MouseMove:
	//			return "MouseMove";
	//		case SWT.MouseUp:
	//			return "MouseUp";
	//		case SWT.Activate:
	//			return "Activate";
	//		default:
	//			return Integer.toString(eventType);
	//		}
	//	}

	/**
	 * Constructor.
	 * 
	 * @param editorModel
	 *        The model of the editor.
	 */
	public EditorPart(TabFolderPart parent, IEditorModel editorModel, Object rawModel, IMultiEditorManager multiEditorManager) {
		super(parent, rawModel);
		this.editorModel = editorModel;
		this.multiEditorManager = multiEditorManager;
	}


	/**
	 * Create the control of this part.
	 * For a this implementations, also create the children's controls.
	 * This method forward to {@link createPartControl(Composite)}.
	 * 
	 * @param parent
	 *        TODO remove ?
	 */
	//	public void createControl(Composite parent) {
	//		createPartControl(parent);
	//	}


	/**
	 * Create the control of this Part, and children's controls.
	 * 
	 * @param parent
	 *        The SWT parent of this EditorPart. This is usually the {@link TabFolderPart}'s control.
	 */
	@Override
	public void createPartControl(Composite parent) {

		try {
			// Create the editor.
			editorPart = createIEditorPart();
			// Initialize it and create its controls.
			editorControl = createEditorPartControl(parent, editorPart);
			attachListeners(editorControl, true);
		} catch (PartInitException e) {
			Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getLocalizedMessage(), e));
			// TODO Create a fake Error Page and initialize this part with.
			//			editorPart = new ErrorEditorPart();
			//			editorControl = createEditorPartControl(parent, editorPart);
			//			editorControl = createErrorPartControl(parent, e);
			createErrorEditorPart(parent, e);
		} catch (Exception e) {
			Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getLocalizedMessage(), e));
			// TODO Create a fake Error Page and initialize this part with.
			//			editorControl = createErrorPartControl(parent, e);
			createErrorEditorPart(parent, e);
		}
	}

	/**
	 * Create a Control showing the error.
	 * 
	 * @param parent
	 *        Parent Control to which the Created Control should be attached
	 * @param e
	 *        Exception containing the error.
	 */
	private Composite createErrorPartControl(Composite parent, Exception e) {

		Composite comp = new Composite(parent, SWT.NONE);
		comp.setLayout(new FillLayout());
		// Show the stack trace
		StringWriter strOut = new StringWriter();
		PrintWriter out = new PrintWriter(strOut);
		e.printStackTrace(out);
		out.flush();
		out.close();

		Text diag = new Text(comp, SWT.MULTI);
		diag.setSize(64, 32);

		diag.setText(strOut.toString());
		return comp;
	}

	/**
	 * Create an EditorPart showing the Exception.
	 * This is used when the creation of the regular IEditorPart failed.
	 * 
	 * @param e
	 */
	private void createErrorEditorPart(Composite parent, Exception e) {

		try {
			PartInitException partInitException = new PartInitException(StatusUtil.getLocalizedMessage(e), StatusUtil.getCause(e));
			editorPart = new ErrorEditorPart(partInitException.getStatus());
			// Initialize it and create its controls.
			editorControl = createEditorPartControl(parent, editorPart);

		} catch (Exception ex) {
			// Even the ErrorEditorPart creation fail.
			// Use a more simple renderer.
			Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getLocalizedMessage(), e));
			// TODO Create a fake Error Page and initialize this part with.
			editorControl = createErrorPartControl(parent, e);
		}

	}

	/**
	 * Create the editor associated to this TabPart.
	 * 
	 * @return
	 * @throws PartInitException
	 */
	private IEditorPart createIEditorPart() throws PartInitException {

		return editorModel.createIEditorPart();
	}

	/**
	 * Create the controls required by the editor.
	 * Init the editor.
	 * 
	 * @param viewer
	 * @param editorInput
	 * @param model
	 * @return
	 * @throws PartInitException
	 */
	private Composite createEditorPartControl(Composite parentControl, IEditorPart editor) throws PartInitException {
		IEditorSite site = createSite(editor);
		// call init first so that if an exception is thrown, we have created no
		// new widgets
		editor.init(site, getIMultiEditorManager().getEditorInput());
		Composite editorParent = new Composite(parentControl, getOrientation(editor));
		editorParent.setLayout(new FillLayout());
		// Listen to dispose event
		editorParent.addDisposeListener(widgetDisposedListener);
		// Create editor controls
		editor.createPartControl(editorParent);
		editor.addPropertyListener(new IPropertyListener() {

			public void propertyChanged(Object source, int propertyId) {
				EditorPart.this.handlePropertyChange(propertyId);
			}
		});

		// TODO test to be removed
		//				attachListeners(editorParent, false);
		return editorParent;
	}

	/**
	 * Attach SWT listeners.
	 */
	private void attachListeners(Control theControl, boolean recursive) {

		// All following methods listen to the same event. 
		// So use only one of them
		//		theControl.addListener(SWT.MouseEnter, mouseEnterListener);
		//		
		//		theControl.addListener(SWT.FocusIn, mouseEnterListener);
		//		theControl.addListener(SWT.MouseMove, mouseEnterListener);
		//		theControl.addListener(SWT.MouseHover, mouseEnterListener);
		//		theControl.addListener(SWT.MouseUp, mouseEnterListener);
		//		theControl.addListener(SWT.MouseDown, mouseEnterListener);
		theControl.addListener(SWT.Activate, mouseEnterListener);

		//		if (recursive && theControl instanceof Composite) {
		//			Composite composite = (Composite) theControl;
		//			Control[] children = composite.getChildren();
		//
		//			for (int i = 0; i < children.length; i++) {
		//				Control control = children[i];
		//
		//				attachListeners(control, true);
		//			}
		//		}
	}

	/**
	 * Detach SWT listeners
	 */
	private void detachListeners(Control theControl, boolean recursive) {
		//		theControl.removeListener(SWT.MouseEnter, mouseEnterListener);
		//		theControl.removeListener(SWT.FocusIn, mouseEnterListener);
		//		theControl.removeListener(SWT.MouseMove, mouseEnterListener);
		//		theControl.removeListener(SWT.MouseHover, mouseEnterListener);
		//		theControl.removeListener(SWT.MouseUp, mouseEnterListener);
		//		theControl.removeListener(SWT.MouseDown, mouseEnterListener);
		theControl.removeListener(SWT.Activate, mouseEnterListener);

		//		if (recursive && theControl instanceof Composite) {
		//			Composite composite = (Composite) theControl;
		//			Control[] children = composite.getChildren();
		//
		//			for (int i = 0; i < children.length; i++) {
		//				Control control = children[i];
		//
		//				detachListeners(control, false);
		//			}
		//		}
	}


	/**
	 * Handles a property change notification from a nested editor. The default implementation simply forwards
	 * the change to listeners on this multi-page editor by calling <code>firePropertyChange</code> with the same property id. For example, if the
	 * dirty state of a nested
	 * editor changes (property id <code>IEditorPart.PROP_DIRTY</code>), this method handles it
	 * by firing a property change event for <code>IEditorPart.PROP_DIRTY</code> to property listeners on this
	 * multi-page editor.
	 * <p>
	 * Subclasses may extend or reimplement this method.
	 * </p>
	 * 
	 * @param propertyId
	 *        the id of the property that changed
	 */
	private void handlePropertyChange(int propertyId) {
		getSashWindowContainer().firePropertyChange(propertyId);
	}

	/**
	 * Creates the site for the given nested editor. The <code>MultiPageEditorPart</code> implementation
	 * of this method creates an instance of <code>MultiPageEditorSite</code>. Subclasses may
	 * reimplement to create more specialized sites.
	 * 
	 * @param editor
	 *        the nested editor
	 * @return the editor site
	 */
	protected IEditorSite createSite(IEditorPart editor) {
		EditorActionBarContributor contributor = createEditorActionBarContributor();

		return new MultiPageEditorSite(multiEditorManager.getEditorSite(), editor, contributor);
	}

	/**
	 * Create the EditorActionBarContributor requested by the editor.
	 * Creation is done by delegating to the IMultiEditorNestedPartManager.
	 * 
	 * @return
	 */
	private EditorActionBarContributor createEditorActionBarContributor() {
		EditorActionBarContributor contributor = editorModel.getActionBarContributor();
		return contributor;
	}

	/**
	 * Get the orientation of the editor.
	 * 
	 * @param editor
	 * @return int the orientation flag
	 * @see SWT#RIGHT_TO_LEFT
	 * @see SWT#LEFT_TO_RIGHT
	 * @see SWT#NONE
	 */
	private int getOrientation(IEditorPart editor) {
		if(editor instanceof IWorkbenchPartOrientation) {
			return ((IWorkbenchPartOrientation)editor).getOrientation();
		}
		return Window.getDefaultOrientation();
	}

	/**
	 * Get the nested part manager.
	 * 
	 * @return
	 */
	private IMultiEditorManager getIMultiEditorManager() {
		return multiEditorManager;
	}


	/**
	 * /**
	 * Dispose all resources used by this part. <br/>
	 * The Part should not be used after it has been disposed.
	 */
	@Override
	public void dispose() {

		detachListeners(editorControl, true);
		// dispose the SWT root control
		// This should also trigger the disposal of associated editor.
		editorControl.dispose();
		// Dispose the editor.
		//		disposeEditorPart();

		// clean up properties to help GC
		editorModel = null;
		//		editorPart = null;
		rawModel = null;
	}

	/**
	 * Dispose this part and all its children.
	 * The method is called recursively on children of the part. <br/>
	 * SWT resources have already been disposed. We don't need to dispose them again.
	 * 
	 */
	@Override
	public void disposeThisAndChildren() {

		// Dispose the editor (normally this should be already done).
		disposeEditorPart();

		// clean up properties to help GC
		editorModel = null;
		//		editorPart = null;
		rawModel = null;
	}


	/**
	 * Disposes the associated editor and its site.
	 * Do not dispose it twice.
	 * 
	 * @param part
	 *        The part to dispose; must not be <code>null</code>.
	 * @copy copied from org.eclipse.ui.part.MultiPageEditorPart.disposePart(IWorkbenchPart) v3.8
	 */
	private void disposeEditorPart() {

		// Is the editor already disposed ?
		if(editorPart == null) {
			return;
		}

		final IWorkbenchPart part = editorPart;
		editorPart = null;

		SafeRunner.run(new ISafeRunnable() {

			public void run() {
				IWorkbenchPartSite partSite = part.getSite();
				part.dispose();
				if(partSite instanceof IMultiPageEditorSite) {
					((IMultiPageEditorSite)partSite).dispose();
				}
			}

			public void handleException(Throwable e) {
				// Exception has already being logged by Core. Do nothing.
			}
		});
	}


	/**
	 * As we are a final Tile, we should be the requested part.
	 * Return this TilePart.
	 * 
	 * @param toFind
	 * @return
	 */
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

		if(expectedTileType == this.getClass()) {
			return this;
		}

		// Not found !!
		// The tile contains the position, but the type is not found.
		throw new UnsupportedOperationException("Tile match the expected position '" + toFind + "' but there is no Tile of requested type '" + expectedTileType.getClass().getName() + "'");
	}

	/**
	 * @param control
	 * @return
	 */
	public PagePart findPart(Object control) {
		if(getControl() == control) {
			return this;
		}

		// Not found
		return null;
	}

	/**
	 * Returns the active nested editor if there is one.
	 * <p>
	 * Subclasses should not override this method
	 * </p>
	 * 
	 * @return the active nested editor, or <code>null</code> if none
	 */
	public IEditorPart getIEditorPart() {
		return editorPart;
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
	 * This is a container method. Not necessary in Leaf Tile.
	 * TODO: change the interface.
	 * 
	 * @param draggedObject
	 * @param sourcePart
	 * @param position
	 * @return
	 */
	public IDropTarget getDropTarget(Object draggedObject, TabFolderPart sourcePart, Point position) {
		return null;
	}


	/**
	 * @return
	 */
	@Override
	public GarbageState getGarbageState() {
		return garbageState;
	}


	/**
	 * Is the associated editor dirty ?
	 * Delegate to {@link IEditorPart.isDirty()}
	 * 
	 * @return true if the associated editor is dirty.
	 * 
	 * @unused
	 */
	public boolean isDirty() {
		return editorPart.isDirty();
	}



	/**
	 * Change the parent of the Tile. The parent is changed, and the control is
	 * attached to the parent control. Change garbage state to {@link GarbageState.REPARENTED}.
	 * Do not detach the Tile from its old parent.
	 * 
	 * @param newParent
	 *        The tilePart that should be used as part parent.
	 * @param compositeParent
	 *        The composite that should be used as parent.
	 */
	@Override
	public void reparent(TabFolderPart newParent) {

		// Change the tile parent
		this.parent = newParent;
		// Change the SWT parent.
		editorControl.setParent(newParent.getControl());

		// Change state
		if(garbageState == GarbageState.UNVISITED || garbageState == GarbageState.ORPHANED || garbageState == GarbageState.CREATED) {
			garbageState = GarbageState.REPARENTED;
		} else {
			// Bad state, this is an internal error
			// TODO : log a warning ?
			throw new IllegalStateException("Try to change state from " + garbageState.toString() + " to REPARENTED. This is forbidden.");
		}

	}


	/**
	 * Asks this part to take focus within the workbench.
	 * Set the focus on the active nested part if the part is a container.
	 */
	@Override
	public void setFocus() {
		if(editorPart != null) {
			editorPart.setFocus();
		}
	}


	/**
	 * Synchronize the Part, and its children. PartMap contains a snapshot of the available part before
	 * the synchronization. After synchronization, unreachable parts should be marked "orphaned" (= no
	 * parent).
	 * Do nothing in this implementation, as we are a final leaf, and there is nothing to synchronize
	 * with the underlying model.
	 * 
	 * @param partMap
	 */
	public void synchronize2(PartLists partMap) {

	}


	/**
	 * Garbage this part.
	 * This part will be not used anymore.
	 * The part is already marked as ORPHANED. It is not used anymore. It is already detached
	 * from its parent. <br>
	 * This method is called by the sashwindows garbage mechanism after the Part has been marked as ORPHANED.
	 * All resources associated to this part can be disposed.
	 * 
	 */
	@Override
	public void garbage() {
		dispose();
		// fire appropriate life cycle event
		getSashWindowContainer().getLifeCycleEventProvider().firePageClosedEvent(this);
	}


	/**
	 * Accept the provided visitor.
	 * Call the corresponding accept method in the visitor.
	 * 
	 * @param visitor
	 * @return
	 */
	@Override
	public boolean visit(IPartVisitor visitor) {
		return visitor.accept(this);
	}

	/**
	 * Visit the children of this Tile.
	 * There is no child, so do nothing.
	 * 
	 * @param visitor
	 */
	public boolean visitChildren(IPartVisitor visitor) {
		return true;
	}


	/**
	 * Show item status.
	 */
	protected void showStatus() {
		//		System.out.println( "EditorTile: " 
		//				+ " disposed=" + editorControl.isDisposed()
		//				+ ", visible=" + editorControl.isVisible()
		//				+ ", garbState=" + garbageState
		//				+ ", '" + editorPart.getTitle()
		//				+ "', " + this);
		String title = (editorPart != null ? editorPart.getTitle() : "no editorPart");
		System.out.printf("EditorTile: disposed=%-5b, visible=%-5b, garbState=%-10s, %s, %s\n", editorControl.isDisposed(), (editorControl.isDisposed() ? false : editorControl.isVisible()), garbageState, title, this);

	}

	/**
	 * Get the title for this part. {@inheritDoc}
	 */
	@Override
	public String getPageTitle() {
		return editorModel.getTabTitle();
	}

	/**
	 * Return an icon for this part. {@inheritDoc}
	 */
	@Override
	public Image getPageIcon() {
		return editorModel.getTabIcon();
	}
}
