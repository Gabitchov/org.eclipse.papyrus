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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Adapted from class diagram
 *****************************************************************************/

package org.eclipse.papyrus.diagram.profile;

import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.papyrus.core.adaptor.gmf.AbstractPapyrusGmfCreateDiagramCommandHandler;
import org.eclipse.papyrus.diagram.profile.edit.parts.ProfileDiagramEditPart;
import org.eclipse.papyrus.diagram.profile.part.UMLDiagramEditorPlugin;

/**
 * Define a command to create a new Composite Diagram. This command is used by all UI (toolbar,
 * outline, creation wizards) to create a new Composite Diagram.
 * 
 */
public class CreateProfileDiagramCommand extends AbstractPapyrusGmfCreateDiagramCommandHandler {

	/**
	 * Name of the Diagram
	 */
	protected static final String PROFILE_DEFAULT_NAME = "ProfileDiagram"; //$NON-NLS-1$

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getDefaultDiagramName() {
		return PROFILE_DEFAULT_NAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getDiagramNotationID() {
		return ProfileDiagramEditPart.MODEL_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected PreferencesHint getPreferenceHint() {
		return UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT;
	}

}
