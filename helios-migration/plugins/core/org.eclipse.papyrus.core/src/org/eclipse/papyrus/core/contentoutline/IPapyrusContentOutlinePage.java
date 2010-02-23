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
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.core.contentoutline;

import org.eclipse.papyrus.core.editor.BackboneException;
import org.eclipse.papyrus.core.editor.IMultiDiagramEditor;

/**
 * Extends the original interface to add the init method.
 */
public interface IPapyrusContentOutlinePage extends org.eclipse.ui.views.contentoutline.IContentOutlinePage {

	/**
	 * Init the content outline.
	 * 
	 * @param multiEditor
	 *        the multiEditor is used to access to the context
	 * @throws BackboneException
	 *         during research of the associated context.
	 */
	void init(IMultiDiagramEditor multiEditor) throws BackboneException;

}
