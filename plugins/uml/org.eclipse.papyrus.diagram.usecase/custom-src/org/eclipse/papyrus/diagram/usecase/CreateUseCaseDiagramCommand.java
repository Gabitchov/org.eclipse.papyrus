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
package org.eclipse.papyrus.diagram.usecase;

import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.papyrus.core.adaptor.gmf.AbstractPapyrusGmfCreateDiagramCommandHandler;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCaseDiagramEditPart;
import org.eclipse.papyrus.diagram.usecase.part.UMLDiagramEditorPlugin;

/**
 * Define a command to create a new UseCase Diagram. This command is used by all UI (toolbar,
 * outline, creation wizards) to create a new UseCase Diagram.
 * 
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class CreateUseCaseDiagramCommand extends AbstractPapyrusGmfCreateDiagramCommandHandler {

	@Override
	protected String getDiagramNotationID() {
		return UseCaseDiagramEditPart.MODEL_ID;
	}

	@Override
	protected PreferencesHint getPreferenceHint() {
		return UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT;
	}

	@Override
	protected String getDefaultDiagramName() {
		return super.openDiagramNameDialog("UseCaseDiagram");
	}

}
