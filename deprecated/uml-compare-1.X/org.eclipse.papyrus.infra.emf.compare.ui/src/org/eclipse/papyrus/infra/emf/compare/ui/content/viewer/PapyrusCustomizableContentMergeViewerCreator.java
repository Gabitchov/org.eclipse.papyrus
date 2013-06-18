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
import org.eclipse.compare.internal.CompareEditor;
import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.infra.tools.util.EditorHelper;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorPart;

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
		final IEditorPart editor = EditorHelper.getCurrentEditor();//the current CompareEditor
		Assert.isTrue(editor instanceof CompareEditor);
		return new PapyrusCustomizableModelContentMergeViewer(parent, config, editor);
	}
}
