/**
 * Copyright (c) 2014 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.uml.diagram.deployment.preferences;

import org.eclipse.papyrus.infra.gmfdiag.preferences.pages.DiagramPreferencePage;
import org.eclipse.papyrus.uml.diagram.deployment.edit.parts.DeploymentDiagramEditPart;
import org.eclipse.papyrus.uml.diagram.deployment.part.UMLDiagramEditorPlugin;

/**
 * @generated
 */
public class DiagramGeneralPreferencePage extends DiagramPreferencePage {

	/**
	 * @generated
	 */
	public DiagramGeneralPreferencePage() {
		setPreferenceStore(UMLDiagramEditorPlugin.getInstance().getPreferenceStore());
		setPreferenceKey(DeploymentDiagramEditPart.MODEL_ID);
	}
}
