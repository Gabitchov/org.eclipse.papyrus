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

import java.io.PrintWriter;
import java.io.StringWriter;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.sasheditor.Activator;
import org.eclipse.papyrus.sasheditor.contentprovider.IEditorModel;
import org.eclipse.papyrus.sasheditor.internal.eclipsecopy.MultiPageEditorSite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorActionBarContributor;
import org.eclipse.ui.part.IWorkbenchPartOrientation;

/**
 * This is a controler/part for an Editor. It is associated to a {@link IEditorModel}. This Part
 * encapsulate an Eclipse Editor implementing {@link IEditorPart}.
 * 
 * @author dumoulin
 * 
 */
@SuppressWarnings("restriction")
public class EditorPart extends PagePart {

	/**
	 * The model representing the editor.
	 */
	private final IEditorModel editorModel;

	/**
	 * The created Eclipse editor.
	 */
	private IEditorPart editorPart;

	/**
	 * The SWT Control containning the editor's controls.
	 */
	private Composite editorControl;

	/**
	 * The manager used to access main editor properties like site, actionbars, ...
	 */
	private final IMultiEditorManager multiEditorManager;

	/**
	 * Constructor.
	 * 
	 * @param editorModel
	 *            The model of the editor.
	 */
	public EditorPart(TabFolderPart parent, IEditorModel editorModel, Object rawModel,
			IMultiEditorManager multiEditorManager) {
		super(parent, rawModel);
		this.editorModel = editorModel;
		this.multiEditorManager = multiEditorManager;
	}

	/**
	 * Create the control of this Part, and children's controls.
	 * 
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {

		try {
			// Create the editor.
			editorPart = createIEditorPart();
			// Initialize it and create its controls.
			editorControl = createEditorPartControl(parent, editorPart);

		} catch (Exception e) {
			Activator.getDefault().getLog().log(
					new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getLocalizedMessage(), e));
			// TODO Create a fake Error Page and initialize this part with.
			editorControl = createErrorPartControl(parent, e);
		}
	}

	/**
	 * Create a Control showing the error.
	 * 
	 * @param parent
	 *            Parent Control to which the Created Control should be attached
	 * @param e
	 *            Exception containing the error.
	 */
	private Composite createErrorPartControl(Composite parent, Exception e) {
		Composite comp = new Composite(parent, SWT.NONE);
		comp.setLayout(new FillLayout());
		Text diag = new Text(comp, SWT.MULTI);
		diag.setSize(64, 32);

		StringWriter strOut = new StringWriter();
		PrintWriter out = new PrintWriter(strOut);
		e.printStackTrace(out);
		out.close();
		diag.setText(strOut.toString());

		return comp;
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
	 * Create the controls required by the editor. Init the editor.
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
		editor.init(site, multiEditorManager.getEditorInput());
		Composite editorParent = new Composite(parentControl, getOrientation(editor));
		editorParent.setLayout(new FillLayout());
		editor.createPartControl(editorParent);
		editor.addPropertyListener(new IPropertyListener() {

			public void propertyChanged(Object source, int propertyId) {
				EditorPart.this.handlePropertyChange(propertyId);
			}
		});

		return editorParent;
	}

	/**
	 * Handles a property change notification from a nested editor. The default implementation
	 * simply forwards the change to listeners on this multi-page editor by calling
	 * <code>firePropertyChange</code> with the same property id. For example, if the dirty state of
	 * a nested editor changes (property id <code>IEditorPart.PROP_DIRTY</code>), this method
	 * handles it by firing a property change event for <code>IEditorPart.PROP_DIRTY</code> to
	 * property listeners on this multi-page editor.
	 * <p>
	 * Subclasses may extend or reimplement this method.
	 * </p>
	 * 
	 * @param propertyId
	 *            the id of the property that changed
	 */
	private void handlePropertyChange(int propertyId) {
		getSashWindowContainer().firePropertyChange(propertyId);
	}

	/**
	 * Creates the site for the given nested editor. The <code>MultiPageEditorPart</code>
	 * implementation of this method creates an instance of <code>MultiPageEditorSite</code>.
	 * Subclasses may reimplement to create more specialized sites.
	 * 
	 * @param editor
	 *            the nested editor
	 * @return the editor site
	 */
	protected IEditorSite createSite(IEditorPart editor) {
		EditorActionBarContributor contributor = createEditorActionBarContributor();
		return new MultiPageEditorSite(multiEditorManager.getEditorSite(), editor, contributor);
	}

	/**
	 * Create the EditorActionBarContributor requested by the editor. Creation is done by delegating
	 * to the IMultiEditorNestedPartManager.
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
		if (editor instanceof IWorkbenchPartOrientation) {
			return ((IWorkbenchPartOrientation) editor).getOrientation();
		}
		return Window.getDefaultOrientation();
	}

	/**
	 * @param isRecursive
	 */
	public void dispose() {
		editorControl.dispose();
		editorPart.dispose();
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
	 * @return
	 */
	@Override
	public GarbageState getGarbageState() {
		return garbageState;
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
		if (editorPart != null) {
			editorPart.setFocus();
		}
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
