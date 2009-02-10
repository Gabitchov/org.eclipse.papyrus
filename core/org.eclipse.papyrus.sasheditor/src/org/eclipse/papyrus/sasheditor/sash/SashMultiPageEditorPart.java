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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.papyrus.sasheditor.eclipsecopy.MultiPageEditorPart;
import org.eclipse.papyrus.sasheditor.eclipsecopy.MultiPageSelectionProvider;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.internal.dnd.DragUtil;
import org.eclipse.ui.internal.dnd.IDragOverListener;
import org.eclipse.ui.internal.dnd.IDropTarget;
import org.eclipse.ui.internal.services.INestable;
import org.eclipse.ui.services.IServiceLocator;

/**
 * Base class for multipage editors with sash windows. sash - fenetre a guillotine pane - carreaux
 * 
 */
public abstract class SashMultiPageEditorPart extends MultiPageEditorPart implements IMultiEditorNestedPartManager {

	/** State of the editor */
	private boolean isActive;

	/**
	 * Root container for sash windows.
	 */
	protected TilePartContainer rootContainer;

	/**
	 * Control associated to this Part.
	 */
	protected Composite container;

	/**
	 * Constructor.
	 */
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
	 * The <code>MultiPageEditor</code> implementation of this <code>IWorkbenchPart</code> method creates the control for the multi-page editor by calling <code>createContainer</code>, then
	 * <code>createPages</code>. Subclasses should implement <code>createPages</code> rather than overriding this method.
	 * 
	 * @param parent
	 *            The parent in which the editor should be created; must not be <code>null</code>.
	 */
	public void createPartControl(Composite parent) {
		this.container = createContainer(parent);

		// Create the tree of tile part.
		ISashWindowsModelManager rootModel = createTilePartContainerModel();
		rootContainer = new TilePartContainer(this, rootModel);
		rootContainer.createPartControl(container);
		// postCreatePartControl();
		activate();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.sasheditor.eclipsecopy.MultiPageEditorPart#getAdapter(java.lang.Class)
	 */
	@Override
	public Object getAdapter(Class adapter) {
		return super.getAdapter(adapter);
	}

	/**
	 * Refresh the windows. This method synchronize the windows with the underlying model.
	 */
	public void refreshTabs() {
		rootContainer.refreshTabs();
	}

	/* *************************************************** */
	/* To be moved in subclass */
	/* *************************************************** */

	/**
	 * Create the model wrapper used by the TilePartContainer.
	 */
	abstract protected ISashWindowsModelManager createTilePartContainerModel();

	/**
	 * Called when the editor should be activated. Subclass should implements this method to register listeners to the model.
	 * 
	 */
	protected void activate() {
		isActive = true;
	}

	/**
	 * Called when the editor is deactivated.
	 */
	protected void deactivate() {
		isActive = false;
	}

	/**
	 * Returns the state of this editor.
	 * 
	 * @return <code>true</code> if the editor is active.
	 */
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

	@Override
	protected IEditorPart getActiveEditor() {
		return rootContainer.getActiveEditor();
	}

	/**
	 * Returns the composite control containing this multi-page editor's pages. This should be used as the parent when creating controls for the individual pages. That is, when calling
	 * <code>addPage(Control)</code>, the passed control should be a child of this container.
	 * <p>
	 * Warning: Clients should not assume that the container is any particular subclass of Composite. The actual class used may change in order to improve the look and feel of multi-page editors. Any
	 * code making assumptions on the particular subclass would thus be broken.
	 * </p>
	 * <p>
	 * Subclasses should not override this method
	 * </p>
	 * 
	 * @return the composite, or <code>null</code> if <code>createPartControl</code> has not been called yet
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
	 * The <code>MultiPageEditorPart</code> implementation of this <code>IEditorPart</code> method returns whether the contents of any of this multi-page editor's nested editors have changed since the
	 * last save. Pages created with <code>addPage(Control)</code> are ignored.
	 * <p>
	 * Subclasses may extend or reimplement this method.
	 * </p>
	 * 
	 * @return <code>true</code> if any of the nested editors are dirty; <code>false</code> otherwise.
	 */
	public boolean isDirty() {
		return rootContainer.isDirty();
	}

}
