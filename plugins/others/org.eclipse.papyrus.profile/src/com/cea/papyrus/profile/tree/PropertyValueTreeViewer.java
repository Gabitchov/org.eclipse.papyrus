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
package com.cea.papyrus.profile.tree;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

// TODO: Auto-generated Javadoc
/**
 * The Class PropertyValueTreeViewer.
 */
public class PropertyValueTreeViewer extends TreeViewer {
	
	/**
	 * Constructor.
	 * 
	 * @param parent the parent
	 */
	public PropertyValueTreeViewer(Composite parent) {
		super(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
	}
}
