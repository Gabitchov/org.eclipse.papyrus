/**
 * 
 */
package org.eclipse.papyrus.sasheditor.sash;

import org.eclipse.papyrus.sasheditor.sash.ITilePart.GarbageState;
import org.eclipse.papyrus.sasheditor.sash.ITilePart.ITilePartNodeModel;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IEditorPart;

/**
 * A controler associated to a part in a folder. This controller is usually
 * associated to an eclipse editor.
 * 
 * @author dumoulin
 * 
 */
public class TabPart<T> {

	/**
	 * Model used to interact with the final editor.
	 * 
	 * @author dumoulin
	 * 
	 */
	public interface ITabModel<T> extends ITilePartNodeModel<T> {

	}

	/**
	 * The associated model TODO : change the type
	 */
	protected Object model;

	/**
	 * The editor Tile associated to this Tab.
	 */
	protected EditorTile<T> editorTile;

	/**
	 * Parent owning this TabPart. Can be null if the Part is orphaned. Even if
	 * it is orphaned, the Item still set.
	 */
	protected TabFolderPart<T> parent;

	/**
	 * The item associated to this part. This item contains the control of the
	 * associated editor.
	 */
	protected CTabItem control;

	/** Garbage state used during refresh */
	protected GarbageState garbageState;

	/**
	 * Constructor. Create a new leaf editor for the provided model. Insert it
	 * at the specified position in the parent folder.
	 * 
	 * @param model
	 */
	public TabPart(TabFolderPart<T> parent, Object model) {
		this.parent = parent;
		this.model = model;
	}

	/**
	 * Create the part control and the control of the child.
	 * 
	 * @param tabFolder
	 * @param index
	 */
	public void createPartControl(CTabFolder tabFolder, int index) {
		// Create child
		ITilePart<T> child = createChildPartControl(tabFolder);
		// Create the item
		createItem(index, child.getControl());
		refreshTabDecorations();
	}

	/**
	 * Create the child and its part controls.
	 * 
	 * @param tabFolder
	 * @return
	 */
	private ITilePart<T> createChildPartControl(CTabFolder tabFolder) {
		// TODO : use the factory to create any kind of child.
		EditorTile<T> child = new EditorTile<T>(parent.parentPartContainer, parent, model);
		child.createPartControl(tabFolder);
		editorTile = child;
		return child;
	}

	/**
	 * Create the part control for the tab. Lookup in existing Tile for the
	 * child. Create one if none exist.
	 * 
	 * @param tabFolder
	 * @param index
	 */
	public void createPartControl(CTabFolder tabFolder, int index, GarbageMaps<T> partMap) {
		// Check if an editor already exist for the model.
		ITilePart<T> child = partMap.getTabPartMap().get(model);
		if(child == null) {
			// not found, create one
			createPartControl(tabFolder, index);
			return;
		}

		// An editor already exist, use it
		child.reparent(parent, tabFolder);
		editorTile = (EditorTile<T>)child;
		createItem(index, child.getControl());
		refreshTabDecorations();
	}

	/**
	 * Return true if this Tab is for the specified model.
	 * 
	 * @param curModel
	 * @return
	 */
	public boolean isTilePartFor(Object newModel) {
		return model == newModel;
	}

	/**
	 * Set the tab decorations: label, icon.
	 */
	private void refreshTabDecorations() {
		IEditorPart editorPart = getIEditorPart();
		if(editorPart == null) {
			System.err.println("Error: found null editorPart " + this.getClass().getName());
			setTabText("noname");
			setTabImage(null);
			return;
		}
		setTabText(editorPart.getTitle());
		setTabImage(editorPart.getTitleImage());
	}


	/**
	 * Creates a tab item at the given index and places the given control in the
	 * new item. The item is a CTabItem with no style bits set.
	 * 
	 * @param index
	 *        the index at which to add the control
	 * @param control
	 *        is the control to be placed in an item
	 * @return a new item
	 */
	private CTabItem createItem(int index, Control itemControl) {
		CTabItem item = new CTabItem(getTabFolder(), SWT.NONE, index);
		control = item;
		item.setControl(itemControl);
		return item;
	}

	/**
	 * Synchronize this tab with the specified model. Check if an editor exist
	 * for the model. If true, use it. If not, create it. The SWT item is
	 * unchanged.
	 * 
	 * @param newModel
	 * @param partMap
	 */
	protected void synchronizeWith(Object newModel, GarbageMaps<T> partMap) {

		// Do nothing if there is no change
		if(newModel == model)
			return;

		model = newModel;
		// Check if an editor already exist for the model.
		ITilePart<T> child = partMap.getTabPartMap().get(newModel);
		if(child == null) {
			// not found, create one
			child = createChildPartControl(parent.getCTabFolder());

		} else {
			// An editor is found, use it
			child.reparent(parent, parent.getCTabFolder());
			// Orphan old attached editor
			editorTile.orphan();
			// Attach new editor.
			editorTile = (EditorTile<T>)child;
		}

		// control.setControl(child.getControl());
		setItemControl(child.getControl());
		refreshTabDecorations();
	}

	/**
	 * Get the container of the Parent. This container is used as root of the
	 * Controls associated to this editor.
	 * 
	 * @return
	 */
	private CTabFolder getTabFolder() {
		return (CTabFolder)parent.getControl();
	}

	/**
	 * @return the model
	 */
	protected Object getModel() {
		return model;
	}

	/**
	 * Fill the provided part map with the child's parts.
	 * 
	 * @param partMap
	 */
	public void fillPartMap(GarbageMaps<T> partMap) {

		editorTile.fillPartMap(partMap);
	}

	/**
	 * Remove the TabPart.
	 * Dispose the associated SWT CTabItem.
	 * (TODO Remove from the parent list.)
	 * Orphan the associated ITilePart
	 * 
	 * @see
	 * @return the parent
	 */
	protected void remove() {

		// setControl() change the visibility of the underlying SWT control
		// (here the editor).
		// This should not happen if the editor is already attached to another
		// folder.
		// check this case and remember the flag to put it back if needed
		setItemControl(null);
		parent = null;
		control.dispose();
		// Orphan associates Tiles
		editorTile.orphan();
	}

	/**
	 * Set the item control. Setting the item control with the
	 * control.setControl() method has a side effect: the previous control is
	 * modified with previousControl.setVisible(false). This is annoying when
	 * the previous control has already been attached to another parent. This
	 * method take care to not change the visibility of the previous control if
	 * it is detached from the item's parent.
	 * 
	 * @param newControl
	 */
	private void setItemControl(Control newControl) {
		// setControl() change the visibility of the underlying SWT control
		// (here the editor).
		// This should not happen if the editor is already attached to another
		// folder.
		// check this case and remember the flag to put it back if needed
		boolean editorIsVisible = false;
		// Get previously attached editor's control
		Control editorControl = control.getControl();
		if(editorControl != null && editorControl.getParent() != control.getParent()) {
			// Editor has already been reattached
			// Remember its visible flag
			editorIsVisible = editorControl.getVisible();
			// Detach the item's control
			control.setControl(newControl);
			if(editorIsVisible)
				editorControl.setVisible(editorIsVisible);
		} else {
			// Not reattached, do nothing else
			control.setControl(newControl);
		}
	}

	/**
	 * Dispose the associated control.
	 */
	public void dispose() {
		Control itemControl = control.getControl();
		control.dispose();

		// Dispose the inner control if any.
		if(!itemControl.isDisposed())
			itemControl.dispose();

		//
		parent = null;
		model = null;
	}

	/**
	 * Set the image of the associated tab.
	 * 
	 * @param titleImage
	 */
	private void setTabImage(Image titleImage) {
		control.setImage(titleImage);
	}

	/**
	 * Set the text of the associated tab.
	 * 
	 * @param title
	 */
	private void setTabText(String title) {
		control.setText(title);
	}

	/**
	 * Get associated editor part.
	 * 
	 * @return
	 */
	public IEditorPart getIEditorPart() {
		return editorTile.getIEditorPart();
	}

	/**
	 * Return the associated EditorTile.
	 * 
	 * @return
	 */
	public EditorTile<T> getEditorTile() {
		return editorTile;
	}

	/**
	 * Locates the part that intersects the given point and that have the expected type
	 * 
	 * @param toFind
	 * @return
	 */
	public <U extends ITilePart<T>> U findPartAt(Point toFind, Class<U> expectedTileType) {

		if(expectedTileType == this.getClass())
			return (U)this;

		return editorTile.findPartAt(toFind, expectedTileType);
	}


	/**
	 * Accept the provided visitor.
	 * Call the corresponding accept method in the visitor.
	 * 
	 * @param visitor
	 * @return
	 */
	public void visit(ITileVisitor visitor) {
		visitor.accept(this);
	}

	/**
	 * Visit the children of this Tile.
	 * 
	 * @param visitor
	 */
	public void visitChildren(ITileVisitor visitor) {
		editorTile.visit(visitor);
	}


}
