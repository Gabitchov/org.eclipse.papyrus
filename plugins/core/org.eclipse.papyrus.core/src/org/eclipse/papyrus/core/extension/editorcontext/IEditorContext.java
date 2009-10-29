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
package org.eclipse.papyrus.core.extension.editorcontext;

import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditDomain;
import org.eclipse.papyrus.core.editor.BackboneException;
import org.eclipse.papyrus.core.editor.IMultiDiagramEditor;
import org.eclipse.ui.IEditorInput;

/**
 * Context provided to an editor.
 */
public interface IEditorContext {

	/**
	 * To be determined
	 * 
	 * @param IEditorInput
	 */
	// @unused
	public void setInput(IEditorInput input);

	/**
	 * Initialize the context. This method is called immediately after Context instantiation.
	 * 
	 * @param multiEditor
	 *            the multiEditor to initialize
	 * @throws BackboneException
	 */
	public void init(IMultiDiagramEditor multiEditor) throws BackboneException;

	/**
	 * Sets the editing domain used by the editors. This edit domain should have a reference to the
	 * same command stack shared among each editor in the multi diagram editor.
	 * 
	 * @param domain
	 *            the gmf editing doamin shared among all diagram editors
	 */
	public void setDiagramEditDomain(DiagramEditDomain domain);

	/**
	 * Returns the editing domain used by the editors. This edit domain should have a reference to
	 * the same command stack shared among each editor in the multi diagram editor.
	 * 
	 * @return the gmf editing doamin shared among all diagram editors
	 */
	public DiagramEditDomain getDiagramEditDomain();
}
