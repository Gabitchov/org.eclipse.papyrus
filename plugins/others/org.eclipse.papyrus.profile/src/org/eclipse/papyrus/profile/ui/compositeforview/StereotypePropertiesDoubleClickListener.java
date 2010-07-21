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
 *  Chokri Mraidha (CEA LIST) Chokri.Mraidha@cea.fr - Initial API and implementation
 *  Patrick Tessier (CEA LIST) Patrick.Tessier@cea.fr - modification
 *
 *****************************************************************************/
package org.eclipse.papyrus.profile.ui.compositeforview;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.papyrus.profile.ui.listeners.DoubleClickListener;
import org.eclipse.swt.widgets.TreeItem;

// TODO: Auto-generated Javadoc
/**
 * The Class StereotypePropertiesDoubleClickListener.
 */
public class StereotypePropertiesDoubleClickListener extends DoubleClickListener {

	/**
	 * The stereotype composite.
	 */
	protected AppliedStereotypeCompositeWithView stereotypeComposite;

	/**
	 * The property composite.
	 */
	protected AppliedStereotypePropertyCompositeWithView propertyComposite;

	/**
	 * The Constructor.
	 * 
	 * @param propertyComposite
	 *        the property composite
	 * @param stereotypeComposite
	 *        the stereotype composite
	 * @param treeViewer
	 *        the tree viewer
	 * @param parent
	 *        the parent
	 */
	public StereotypePropertiesDoubleClickListener(TreeViewer treeViewer, AppliedStereotypeCompositeWithView stereotypeComposite,
			AppliedStereotypePropertyCompositeWithView propertyComposite) {
		super();
		this.treeViewer = treeViewer;
		this.stereotypeComposite = stereotypeComposite;
		this.propertyComposite = propertyComposite;
	}

	/**
	 * Item D clicked.
	 * 
	 * @param item
	 *        the item
	 * @param index
	 *        the index
	 */
	@Override
	protected void itemDClicked(TreeItem item, int index) {
		super.itemDClicked(item, index);
		// nota: had to place touchModel before refresh.
		// In fact, if refresh is done before refresh, there can be a null pointer exception, as the composite input is not clearly defined.
		// so, in state, it should be better to keep this order.
		// propertyComposite.touchModel();
		propertyComposite.refresh();
		stereotypeComposite.refreshTreeViewer ();
	}

}
