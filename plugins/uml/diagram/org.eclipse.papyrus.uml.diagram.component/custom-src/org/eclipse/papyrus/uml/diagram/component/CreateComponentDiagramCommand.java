/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	Amine EL KOUHEN (CEA LIST/LIFL) - Amine.El-Kouhen@lifl.fr 
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.component;

import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.papyrus.infra.gmfdiag.common.AbstractPapyrusGmfCreateDiagramCommandHandler;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ComponentDiagramEditPart;


// TODO: Auto-generated Javadoc
/**
 * The Class CreateComponentDiagramCommand.
 */
public class CreateComponentDiagramCommand extends AbstractPapyrusGmfCreateDiagramCommandHandler {

	/**
	 * Gets the default diagram name.
	 * 
	 * @return the default diagram name
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.AbstractPapyrusGmfCreateDiagramCommandHandler#getDefaultDiagramName()
	 */

	@Override
	protected String getDefaultDiagramName() {
		return "NewComponentDiagram";
	}


	/**
	 * Gets the diagram notation id.
	 * 
	 * @return the diagram notation id
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.AbstractPapyrusGmfCreateDiagramCommandHandler#getDiagramNotationID()
	 */

	@Override
	protected String getDiagramNotationID() {
		return ComponentDiagramEditPart.MODEL_ID;
	}

	/**
	 * Gets the preference hint.
	 * 
	 * @return the preference hint
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.AbstractPapyrusGmfCreateDiagramCommandHandler#getPreferenceHint()
	 */

	@Override
	protected PreferencesHint getPreferenceHint() {
		return org.eclipse.papyrus.uml.diagram.component.part.UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT;
	}

}
