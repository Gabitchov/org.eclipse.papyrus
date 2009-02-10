/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte, Generalitat 
 * de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Francisco Javier Cano Muñoz (Prodevelop) - initial API implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.sequence.actions;

import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.papyrus.core.adaptor.gmf.AbstractGmfCreateDiagramAction;
import org.eclipse.papyrus.diagram.common.ids.MOSKittEditorIDs;
import org.eclipse.papyrus.diagram.sequence.edit.parts.PackageEditPart;
import org.eclipse.papyrus.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.sasheditor.extension.ICreateDiagramAction;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.UMLFactory;


/**
 * The Class CreateSequenceDiagramAction.
 * 
 * @deprecated
 * TODO Remove it.
 */
public class CreateSequenceDiagramAction extends AbstractGmfCreateDiagramAction implements ICreateDiagramAction {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Element createInitialModel() {
		return UMLFactory.eINSTANCE.createPackage();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getDiagramName() {
		String modelID = getDiagramNotationID();
		if (MOSKittEditorIDs.getExtensionsMapModelToLabel().containsKey(modelID)) {
			return MOSKittEditorIDs.getExtensionsMapModelToLabel().get(modelID);
		}
		return "MOSKitt UML2 Sequence Diagram";
	}

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

}
