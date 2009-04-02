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
package org.eclipse.papyrus.profile.ui.compositeforview;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.papyrus.profile.ui.listeners.DoubleClickListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TreeItem;

// TODO: Auto-generated Javadoc
/**
 * The Class StereotypePropertiesDoubleClickListener.
 */
public class StereotypePropertiesDoubleClickListener extends DoubleClickListener {

	/**
	 * The parent.
	 */
	protected Composite parent;

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
	 *            the property composite
	 * @param stereotypeComposite
	 *            the stereotype composite
	 * @param treeViewer
	 *            the tree viewer
	 * @param parent
	 *            the parent
	 */
	public StereotypePropertiesDoubleClickListener(Composite parent, TreeViewer treeViewer, AppliedStereotypeCompositeWithView stereotypeComposite, AppliedStereotypePropertyCompositeWithView propertyComposite) {
		super();
		this.treeViewer = treeViewer;
		this.parent = parent;
		this.stereotypeComposite = stereotypeComposite;
		this.propertyComposite = propertyComposite;
	}

	/**
	 * Item D clicked.
	 * 
	 * @param item
	 *            the item
	 * @param index
	 *            the index
	 */
	@Override
	protected void itemDClicked(TreeItem item, int index) {
		super.itemDClicked(item, index);
		propertyComposite.refresh();
		stereotypeComposite.refresh();
		propertyComposite.touchModel();
	}

}
