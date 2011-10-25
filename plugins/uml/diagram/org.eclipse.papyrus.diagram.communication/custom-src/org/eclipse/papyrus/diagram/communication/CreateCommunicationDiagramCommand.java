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
 *  Atos Origin - Initial API and implementation
 *  Saadia Dhouib (CEA LIST) saadia.dhouib@cea.fr - Adapted from class diagram
 *****************************************************************************/

package org.eclipse.papyrus.diagram.communication;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.papyrus.diagram.common.commands.CreateBehavioredClassifierDiagramCommand;
import org.eclipse.papyrus.diagram.communication.edit.parts.ModelEditPart;
import org.eclipse.papyrus.diagram.communication.part.UMLDiagramEditorPlugin;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Define a command to create a new Communication Diagram. This command is used
 * by all UI (toolbar, outline, creation wizards) to create a new Composite
 * Diagram.
 * 
 */
public class CreateCommunicationDiagramCommand extends CreateBehavioredClassifierDiagramCommand {

	@Override
	protected EClass getBehaviorEClass() {
		return UMLPackage.eINSTANCE.getInteraction();
	}

	@Override
	protected String getDiagramNotationID() {
		return ModelEditPart.MODEL_ID;
	}

	@Override
	protected PreferencesHint getPreferenceHint() {
		return UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT;
	}

	@Override
	protected String getDefaultDiagramName() {
		return "ComDiagram"; //$NON-NLS-1$
	}


}
