/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte, Generalitat 
 * de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *     Francisco Javier Cano Muñoz (Prodevelop) - initial API implementation
 *     Obeo
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.activity.action;

import org.eclipse.core.commands.IHandler;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.papyrus.core.adaptor.gmf.AbstractPapyrusGmfCreateDiagramCommandHandler;
import org.eclipse.papyrus.diagram.activity.edit.parts.PackageEditPart;
import org.eclipse.papyrus.diagram.activity.part.UMLDiagramEditorPlugin;

/**
 * The Class CreateGmfActivityDiagramCommandHandler.
 * 
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class CreateGmfActivityDiagramCommandHandler extends AbstractPapyrusGmfCreateDiagramCommandHandler implements IHandler {

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

	@Override
	protected String getDiagramName() {
		return openDiagramNameDialog("ActivityDiagram");
	}

}
