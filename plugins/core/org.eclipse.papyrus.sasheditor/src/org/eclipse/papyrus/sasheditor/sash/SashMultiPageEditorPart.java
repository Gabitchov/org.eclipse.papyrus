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

import org.eclipse.papyrus.sasheditor.eclipsecopy.MultiPageEditorPart;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPart;

/**
 * Base class for multipage editors with sash windows. sash - fenetre a guillotine pane - carreaux
 * 
 * This class should be subclassed, and method {@link createTilePartContainerModel()} must be
 * implemented. This method should return a {@link ISashWindowsModelManager} instance. This instance
 * will be used to interact with the model representing sashes, and to create editors when
 * requested.
 */
public abstract class SashMultiPageEditorPart<T> extends MultiPageEditorPart implements IMultiEditorNestedPartManager {

	// Cedric : Tempory code! to test
	// @unused
	public TilePartContainer<T> getRootContainer() {
		return rootContainer;
	}

	/** State of the editor */
	private boolean isActive;

	/**
	 * Root container for sash windows.
	 */
	protected TilePartContainer<T> rootContainer;

	/**
	 * Control associated to this Part.
	 */
	protected Composite container;

	/**
	 * This listens for when the outline becomes active <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * TODO Remove.This is for debug purpose.
	 */
	protected IPartListener partListener = new IPartListener() {

		public void partActivated(IWorkbenchPart p) {
			System.out.println("partActivated(" + p + ")");
		}

		public void partBroughtToTop(IWorkbenchPart p) {
			// Ignore.
		}

		public void partClosed(IWorkbenchPart p) {
			// Ignore.
		}

		public void partDeactivated(IWorkbenchPart p) {
			System.out.println("partDeactivated(" + p + ")");
		}

		public void partOpened(IWorkbenchPart p) {
			// Ignore.
		}
	};

	/**
	 * Constructor.
	 */
	// @unused
	public SashMultiPageEditorPart() {
	}

	/**
	 * Override to weak the access.
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#firePropertyChange(int)
	 */
	@Override
	public void firePropertyChange(int propertyId) {
		super.firePropertyChange(propertyId);
	}

	/**
	 * The <code>MultiPageEditor</code> implementation of this <code>IWorkbenchPart</code> method
	 * creates the control for the multi-page editor by calling <code>createContainer</code>, then
	 * <code>createPages</code>. Subclasses should implement <code>createPages</code> rather than
	 * overriding this method.
	 * 
	 * @param parent
	 *            The parent in which the editor should be created; must not be <code>null</code>.
	 */
	@Override
	public void createPartControl(Composite parent) {
		this.container = createContainer(parent);

		// Create the tree of tile part.
		ISashWindowsModelManager<T> rootModel = createTilePartContainerModel();
		rootContainer = new TilePartContainer<T>(this, rootModel);
		rootContainer.createPartControl(container);
		// postCreatePartControl();
		activate();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.sasheditor.eclipsecopy.MultiPageEditorPart#getAdapter(java.lang.Class)
	 */
	@Override
	@SuppressWarnings(value = "unchecked")
	public Object getAdapter(Class adapter) {

		if (DeveloperDebug.class.isAssignableFrom(adapter)) {
			return getDeveloperDebug();
		}

		return super.getAdapter(adapter);
	}

	/**
	 * Refresh the windows. This method synchronize the windows with the underlying model.
	 */
	// @unused
	public void refreshTabs() {
		rootContainer.refreshTabs();
	}

	/* *************************************************** */
	/* To be moved in subclass */
	/* *************************************************** */

	/**
	 * Create the model wrapper used by the TilePartContainer.
	 */
	abstract protected ISashWindowsModelManager<T> createTilePartContainerModel();

	/**
	 * Called when the editor should be activated. Subclass should implements this method to
	 * register listeners to the model.
	 * 
	 */
	protected void activate() {
		isActive = true;
		getSite().getPage().addPartListener(partListener);
	}

	/**
	 * Called when the editor is deactivated.
	 */
	// @unused
	protected void deactivate() {
		isActive = false;
	}

	/**
	 * Returns the state of this editor.
	 * 
	 * @return <code>true</code> if the editor is active.
	 */
	// @unused
	protected boolean isActive() {
		return isActive;
	}

	/**
	 * Asks this part to take focus within the workbench.
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
	 */
	@Override
	public void setFocus() {
		rootContainer.setFocus();

	}

	/**
	 * Get the currently active editor Part
	 */
	@Override
	public IEditorPart getActiveEditor() {
		return rootContainer.getActiveEditor();
	}

	/**
	 * Returns the composite control containing this multi-page editor's pages. This should be used
	 * as the parent when creating controls for the individual pages. That is, when calling
	 * <code>addPage(Control)</code>, the passed control should be a child of this container.
	 * <p>
	 * Warning: Clients should not assume that the container is any particular subclass of
	 * Composite. The actual class used may change in order to improve the look and feel of
	 * multi-page editors. Any code making assumptions on the particular subclass would thus be
	 * broken.
	 * </p>
	 * <p>
	 * Subclasses should not override this method
	 * </p>
	 * 
	 * @return the composite, or <code>null</code> if <code>createPartControl</code> has not been
	 *         called yet
	 */
	protected Composite getContainer() {
		return container;
	}

	/**
	 * Creates the parent control for the container returned by {@link #getContainer() }.
	 * 
	 * <p>
	 * Subclasses may extend and must call super implementation first.
	 * </p>
	 * 
	 * @param parent
	 *            the parent for all of the editors contents.
	 * @return the parent for this editor's container. Must not be <code>null</code>.
	 * 
	 * @since 3.2
	 */
	protected Composite createContainer(Composite parent) {
		return parent;
	}

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
	@Override
	public boolean isDirty() {
		return rootContainer.isDirty();
	}

	private DeveloperDebug developerDebug;

	/**
	 * Get the developerDebug object.
	 * 
	 * @return
	 */
	private DeveloperDebug getDeveloperDebug() {
		if (developerDebug == null) {
			developerDebug = new DeveloperDebug();
		}
		return developerDebug;
	}

	/**
	 * Class that can be returned with getAdapter. It provides methods useful for debug. Such
	 * methods allows to see the internal state of the sash system. This class is not intended to be
	 * used in normal stuff. This class may be not maintained in the future.
	 * 
	 * @author dumoulin
	 * 
	 */
	public class DeveloperDebug {

		// @unused
		public void showSashWindowInfo() {
			rootContainer.showTilesStatus();
		}
	}
}
