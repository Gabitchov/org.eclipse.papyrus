/*******************************************************************************
 * Copyright (c) 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.diagram.activity;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityDiagramEditPart;
import org.eclipse.papyrus.diagram.activity.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.diagram.common.commands.CreateBehavioredClassifierDiagramCommand;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Define a command to create a new Activity Diagram. This command is used by all UI (toolbar,
 * outline, creation wizards) to create a new Activity Diagram.
 */
public class CreateActivityDiagramCommand extends CreateBehavioredClassifierDiagramCommand {


	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getDiagramNotationID() {
		return ActivityDiagramEditPart.MODEL_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected PreferencesHint getPreferenceHint() {
		return UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT;
	}

	@Override
	protected EClass getBehaviorEClass() {
		return UMLPackage.eINSTANCE.getActivity();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getDefaultDiagramName() {
		return super.openDiagramNameDialog("NewDiagram"); //$NON-NLS-1$
	}
}
