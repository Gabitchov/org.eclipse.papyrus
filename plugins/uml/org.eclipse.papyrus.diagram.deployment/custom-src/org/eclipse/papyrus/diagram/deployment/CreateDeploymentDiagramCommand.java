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
 *	Amine EL KOUHEN (CEA LIST/INRIA DaRT) amine.el_kouhen@inria.fr
 *****************************************************************************/
package org.eclipse.papyrus.diagram.deployment;

import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.papyrus.core.adaptor.gmf.AbstractPapyrusGmfCreateDiagramCommandHandler;
import org.eclipse.papyrus.diagram.deployment.edit.parts.DeploymentDiagramEditPart;



// TODO: Auto-generated Javadoc
/**
 * The Class CreateDeploymentDiagramCommand.
 */
public class CreateDeploymentDiagramCommand extends AbstractPapyrusGmfCreateDiagramCommandHandler {




	/**
	 * Gets the default diagram name.
	 * 
	 * @return the default diagram name
	 * @see org.eclipse.papyrus.core.adaptor.gmf.AbstractPapyrusGmfCreateDiagramCommandHandler#getDefaultDiagramName()
	 */

	@Override
	protected String getDefaultDiagramName() {
		return "NewDeploymentDiagram";
	}





	/**
	 * Gets the diagram notation id.
	 * 
	 * @return the diagram notation id
	 * @see org.eclipse.papyrus.core.adaptor.gmf.AbstractPapyrusGmfCreateDiagramCommandHandler#getDiagramNotationID()
	 */

	@Override
	protected String getDiagramNotationID() {
		return DeploymentDiagramEditPart.MODEL_ID;
	}



	/**
	 * Gets the preference hint.
	 * 
	 * @return the preference hint
	 * @see org.eclipse.papyrus.core.adaptor.gmf.AbstractPapyrusGmfCreateDiagramCommandHandler#getPreferenceHint()
	 */

	@Override
	protected PreferencesHint getPreferenceHint() {
		return org.eclipse.papyrus.diagram.deployment.part.UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT;
	}

}
