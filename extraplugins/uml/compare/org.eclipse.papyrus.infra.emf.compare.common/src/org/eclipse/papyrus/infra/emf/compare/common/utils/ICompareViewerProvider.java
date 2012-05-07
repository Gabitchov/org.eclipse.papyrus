/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
package org.eclipse.papyrus.infra.emf.compare.common.utils;

import org.eclipse.compare.contentmergeviewer.ContentMergeViewer;
import org.eclipse.emf.compare.ui.viewer.structure.ModelStructureMergeViewer;

/**
 * 
 * This interface
 * 
 */
public interface ICompareViewerProvider {

	/**
	 * 
	 * @return
	 *         the content merge viewer for this input. The returned value can be <code>null</code> if the viewer has not been yet created
	 */
	public ContentMergeViewer getContentMergeViewer();

	/**
	 * 
	 * @return
	 *         the structure merge viewer for this input. The returned value can be <code>null</code> if the viewer has not been yet created
	 */
	public ModelStructureMergeViewer getStructureMergeViewer();

}
