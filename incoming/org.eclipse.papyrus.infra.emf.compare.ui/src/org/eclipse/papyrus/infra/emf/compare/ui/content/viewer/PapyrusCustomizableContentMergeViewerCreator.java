/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.compare.ui.content.viewer;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.IViewerCreator;
import org.eclipse.emf.compare.diff.metamodel.AbstractDiffExtension;
import org.eclipse.emf.compare.diff.metamodel.UpdateReference;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Composite;

/**
 * 
 * This class allows to create the MergeViewer
 * 
 */
public class PapyrusCustomizableContentMergeViewerCreator implements IViewerCreator {

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public PapyrusCustomizableContentMergeViewerCreator() {
		//nothing to do
	}

	/**
	 * 
	 * @see org.eclipse.compare.IViewerCreator#createViewer(org.eclipse.swt.widgets.Composite, org.eclipse.compare.CompareConfiguration)
	 * 
	 * @param parent
	 * @param config
	 * @return
	 */
	public Viewer createViewer(Composite parent, CompareConfiguration config) {
		return new PapyrusCustomizableModelContentMergeViewer(parent, config);
	}
}
