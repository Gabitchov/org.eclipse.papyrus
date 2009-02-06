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
 * Abstract implementation of the interface {@link IEditorContext}
 * 
 * @author Remi Schnekenburger
 * @author Patrick Tessier
 */
public abstract class AbstractEditorContext implements IEditorContext {

	/** default edit domain shared among editors */
	private DiagramEditDomain diagramEditDomain;

	/** multi editor linked to the context */
	private IMultiDiagramEditor multiEditor;

	/**
	 * {@inheritDoc}
	 */
	public DiagramEditDomain getDiagramEditDomain() {
		return diagramEditDomain;
	}

	/**
	 * {@inheritDoc}
	 */
	public void init(IMultiDiagramEditor multiEditor) throws BackboneException {
		this.multiEditor = multiEditor;
		setDiagramEditDomain(this.multiEditor.getDiagramEditDomain());
	}

	/**
	 * {@inheritDoc}
	 */
	public void setDiagramEditDomain(DiagramEditDomain domain) {
		diagramEditDomain = domain;
	}

	/**
	 * {@inheritDoc}
	 */
	public abstract void setInput(IEditorInput input);
}
