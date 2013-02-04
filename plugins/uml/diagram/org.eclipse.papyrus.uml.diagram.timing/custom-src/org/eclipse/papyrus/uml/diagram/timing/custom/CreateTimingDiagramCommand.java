/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom;

import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.papyrus.infra.gmfdiag.common.AbstractPapyrusGmfCreateDiagramCommandHandler;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.TimingDiagramEditPart;

/**
 * A command to create a new Timing Diagram. This command is used by all UI (toolbar, model explorer, creation wizards)
 * to create a new Timing Diagram.
 */
public class CreateTimingDiagramCommand extends AbstractPapyrusGmfCreateDiagramCommandHandler {

	/**
	 * Name of the Diagram
	 */
	protected static final String TIMING_DIAGRAM_NAME = "TimingDiagram"; //$NON-NLS-1$

	@Override
	protected String getDefaultDiagramName() {
		return TIMING_DIAGRAM_NAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getDiagramNotationID() {
		return TimingDiagramEditPart.MODEL_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected PreferencesHint getPreferenceHint() {
		return org.eclipse.papyrus.uml.diagram.timing.part.UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT;
	}

}
