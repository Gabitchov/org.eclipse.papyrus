/*******************************************************************************
 * Copyright (c) 2006 CEA List.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA List - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.profile.ui.listeners;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.papyrus.profile.tree.objects.PropertyTreeObject;
import org.eclipse.papyrus.profile.tree.objects.ValueTreeObject;
import org.eclipse.papyrus.profile.ui.panels.AbstractPanel;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.TreeItem;


// TODO: Auto-generated Javadoc
/**
 * The Class DoubleClickListener.
 */
public class DoubleClickListener implements Listener {

	/**
	 * The tree viewer.
	 */
	protected TreeViewer treeViewer;
	
	/**
	 * The parent.
	 */
	private AbstractPanel parent;
	
	/**
	 * The Constructor.
	 * 
	 * @param treeViewer the tree viewer
	 * @param parent the parent
	 */
	public DoubleClickListener(AbstractPanel parent, TreeViewer treeViewer) {
		this.treeViewer = treeViewer;
		this.parent = parent;
	}
	
	/**
	 * 
	 */
	public DoubleClickListener(){
		super();
	}
	
	/**
	 * Handle event.
	 * 
	 * @param e the e
	 */
	public void handleEvent(Event e) {
		if((e.widget != null) && (e.widget.getData() != null) && (e.widget.getData() instanceof PropertyTreeObject)){
			PropertyTreeObject pto = (PropertyTreeObject)e.widget.getData();
			if((pto.getProperty() != null) && pto.getProperty().isReadOnly())
				return;
		}
		int index = getSelectionIndex();
		TreeItem item = getSelection();
		if (item != null) {
			itemDClicked(item, index);
		}
	}

	/**
	 * When doubleclicked : opens a dialog to allow edition of a new PrimitiveType.
	 * 
	 * @param item the item
	 * @param index the index
	 * @param selectedElt the element that owns the stereotype
	 * @param value the current value or list of values of the property if isMultivalued
	 * @param isMultivalued is the property multivalued or not
	 * @param selectedProp the selected property
	 * @param currentStereotype the stereotype associated to selectedProp
	 */
	protected void itemDClicked (TreeItem item, int index) {			
		if (!(item.getData() instanceof ValueTreeObject)) {
			return;
		}
		ValueTreeObject object = (ValueTreeObject) item.getData();
		
		if (object instanceof ValueTreeObject) {
			((ValueTreeObject) object).editMe();
		}
			
		if(parent!=null)
			parent.refresh();
	}
	
	/**
	 * Gets the selection index.
	 * 
	 * @return the selection index
	 */
	private int getSelectionIndex() {
		int index = -1;
		
		TreeItem selectedItem = getSelection();
		if (selectedItem != null) {
			index = treeViewer.getTree().indexOf(selectedItem);
		}	
		return index;
	}
	
	/**
	 * Gets the selection.
	 * 
	 * @return the selection
	 */
	private TreeItem getSelection() {
		TreeItem item = null;

		if (treeViewer != null) {
			TreeItem[] selectedItems = treeViewer.getTree().getSelection();
			if ((selectedItems != null) && (selectedItems.length == 1)) {
				item = selectedItems[0];
			}
		}
		return item;
	}
}
