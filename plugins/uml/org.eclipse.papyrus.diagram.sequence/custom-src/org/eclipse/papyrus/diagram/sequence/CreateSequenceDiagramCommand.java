/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.sequence;

import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.papyrus.diagram.common.commands.CreateBehavioredClassifierDiagramCommand;
import org.eclipse.papyrus.diagram.sequence.edit.parts.PackageEditPart;
import org.eclipse.papyrus.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * Define a command to create a new Sequence Diagram. This command is used by all UI (toolbar,
 * outline, creation wizards) to create a new Sequence Diagram.
 */
public class CreateSequenceDiagramCommand extends CreateBehavioredClassifierDiagramCommand {

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

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getDefaultDiagramName() {
		return super.openDiagramNameDialog("SequenceDiagram"); //$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Behavior createBehavior() {
		return UMLFactory.eINSTANCE.createInteraction();
	}


}
