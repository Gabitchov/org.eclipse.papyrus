/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin cedric.dumoulin@lifl.fr - Initial API and implementation
 *  Yann Tanguy yann.tanguy@cea.fr - Adapted from Class Diagram
 *
 *****************************************************************************/

package org.eclipse.papyrus.diagram.composite;

import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.papyrus.core.adaptor.gmf.AbstractPapyrusGmfCreateDiagramCommandHandler;
import org.eclipse.papyrus.diagram.composite.edit.parts.PackageEditPart;
import org.eclipse.papyrus.diagram.composite.part.UMLDiagramEditorPlugin;

/**
 * Define a command to create a new Composite Diagram. This command is used by all UI (toolbar,
 * outline, creation wizards) to create a new Composite Diagram.
 * 
 */
public class CreateCompositeDiagramCommand extends AbstractPapyrusGmfCreateDiagramCommandHandler {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getDiagramName() {
		return openDiagramNameDialog("CompositeDiagram");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getDiagramNotationID() {
		return PackageEditPart.MODEL_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected PreferencesHint getPreferenceHint() {
		return UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT;
	}

}
