/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Laurent Wouters laurent.wouters@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.viewpoints.policy;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

/**
 * Eclipse view for the user to explore the current viewpoint
 * 
 * @author Laurent Wouters
 *
 */
public class ViewpointExplorer extends ViewPart {

	private TreeViewer tree;

	public ViewpointExplorer() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createPartControl(Composite parent) {
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		parent.setLayout(gridLayout);

		Composite inner = new Composite(parent, SWT.NONE);
		inner.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL | GridData.FILL_VERTICAL));
		inner.setLayout(new FillLayout());

		tree = new TreeViewer(inner, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		tree.setLabelProvider(new ViewPrototypeContentProvider.LP());
		tree.setSorter(getViewerSorter());
		tree.setContentProvider(new ViewPrototypeContentProvider());
		tree.setInput(ViewPrototypeContentProvider.treeRoot);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
	 */
	@Override
	public void setFocus() {

	}


	/**
	 * Gets the viewer sorter for this dialog
	 * 
	 * @return A viewer sorter
	 */
	private ViewerSorter getViewerSorter() {
		return new ViewerSorter() {
			@Override
			public int compare(Viewer viewer, Object e1, Object e2) {
				if (e1 instanceof ViewPrototype) {
					ViewPrototype b1 = (ViewPrototype) e1;
					ViewPrototype b2 = (ViewPrototype) e2;
					return b1.getFullLabel().compareTo(b2.getFullLabel());
				}
				return super.compare(viewer, e1, e2);
			}
		};
	}
}
