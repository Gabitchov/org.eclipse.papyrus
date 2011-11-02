/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tatiana Fesenko (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.compare.ui.viewer.content;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.IViewerCreator;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Composite;


/**
 * The Class UMLModelContentMergeViewerCreator.
 */
public class UMLModelContentMergeViewerCreator implements IViewerCreator {
	
	/**
	 * Creates the viewer.
	 *
	 * @param parent the parent
	 * @param config the config
	 * @return the viewer
	 * {@inheritDoc}
	 */
	public Viewer createViewer(Composite parent, CompareConfiguration config) {
		return new UMLModelContentMergeViewer(parent, config);
	}
	
}
