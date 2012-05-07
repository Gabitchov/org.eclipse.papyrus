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
package org.eclipse.papyrus.uml.compare.utils;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.CompareViewerPane;
import org.eclipse.emf.compare.diff.metamodel.ComparisonSnapshot;
import org.eclipse.emf.compare.ui.viewer.content.ModelContentMergeViewer;
import org.eclipse.papyrus.infra.emf.compare.common.utils.PapyrusModelCompareEditorInput;
import org.eclipse.papyrus.uml.compare.content.viewer.UMLTransactionalModelContentMergeViewer;
import org.eclipse.ui.IEditorPart;

/**
 * 
 * The Input for the nested UMLCompareEditor
 * 
 */
public class UMLModelCompareEditorInput extends PapyrusModelCompareEditorInput {

	/**
	 * 
	 * Constructor.
	 * 
	 * @param snapshot
	 *        the comparison snapshot
	 * @param editor
	 *        the editor
	 */
	public UMLModelCompareEditorInput(final ComparisonSnapshot snapshot, final IEditorPart editor) {
		super(snapshot, editor);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.compare.common.utils.PapyrusModelCompareEditorInput#createMergeViewer(org.eclipse.compare.CompareViewerPane,
	 *      org.eclipse.compare.CompareConfiguration)
	 * 
	 * @param pane
	 * @param config
	 * @return
	 */
	@Override
	protected ModelContentMergeViewer createMergeViewer(final CompareViewerPane pane, final CompareConfiguration config) {
		return new UMLTransactionalModelContentMergeViewer(pane, config, editor);
	}

}
