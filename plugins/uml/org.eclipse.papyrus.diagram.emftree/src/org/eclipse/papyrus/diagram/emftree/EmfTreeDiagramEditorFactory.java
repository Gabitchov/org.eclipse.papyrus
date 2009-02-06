/*******************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA LIST - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.diagram.emftree;

import org.eclipse.papyrus.core.editor.BackboneContext;
import org.eclipse.papyrus.core.extension.diagrameditor.IEditorFactory;
import org.eclipse.papyrus.core.extension.editorcontext.IEditorContext;
import org.eclipse.papyrus.di.Diagram;
import org.eclipse.ui.IEditorPart;

/**
 * @author Cedric Dumoulin
 * @author Remi Schnekenburger
 * @author Patrick Tessier
 */
public class EmfTreeDiagramEditorFactory implements IEditorFactory {

	/** name of the emf diagram in Di2 type diagram */
	public static final String EMF_DIAGRAM_TYPE = "emftree";

	public EmfTreeDiagramEditorFactory() {
	}

	/**
	 * Is this editor for the provided object ?
	 */
	public boolean isEditorFor(Object root) {
		if (root instanceof Diagram) {
			Diagram diagram = (Diagram) root;

			if (EMF_DIAGRAM_TYPE.equals(diagram.getType())) {
				return true;
			}
		}
		// no
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public IEditorPart createEditorFor(IEditorContext context, Object root) {
		assert (context instanceof BackboneContext);
		return createEditorFor((BackboneContext) context, root);
	}

	/**
	 * Create our editor. We do direct instanciation.
	 */
	public IEditorPart createEditorFor(BackboneContext context, Object root) {
		return new Di2Editor(context);
	}

}
