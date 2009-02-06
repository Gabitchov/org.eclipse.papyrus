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
package org.eclipse.papyrus.diagram.activity.action;

import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.core.adaptor.gmf.AbstractGmfCreateDiagramAction;
import org.eclipse.papyrus.core.adaptor.gmf.GmfMultiDiagramSharedObjects;
import org.eclipse.papyrus.diagram.activity.edit.parts.PackageEditPart;
import org.eclipse.papyrus.diagram.activity.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.diagram.common.ids.MOSKittEditorIDs;
import org.eclipse.papyrus.sasheditor.extension.ICreateDiagramAction;
import org.eclipse.ui.IEditorInput;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;


/**
 * The Class CreateActivityDiagramAction.
 * @deprecated
 * TODO Remove it.
 */
public class CreateActivityDiagramAction extends AbstractGmfCreateDiagramAction implements ICreateDiagramAction {

	/** The shared objects. */
	GmfMultiDiagramSharedObjects sharedObjects = null;

	/**
	 * Gets the shared objects.
	 * 
	 * @return the shared objects
	 */
	public GmfMultiDiagramSharedObjects getSharedObjects() {
		return sharedObjects;
	}

	/**
	 * Sets the shared objects.
	 * 
	 * @param sharedObjects
	 *            the new shared objects
	 */
	public void setSharedObjects(GmfMultiDiagramSharedObjects sharedObjects) {
		this.sharedObjects = sharedObjects;
	}

	/**
	 * Gets the diagram from shared resources.
	 * 
	 * @param sharedObjects
	 *            the shared objects
	 * 
	 * @return the diagram from shared resources
	 */
	protected Diagram getDiagramFromSharedResources(GmfMultiDiagramSharedObjects sharedObjects) {
		if (sharedObjects == null) {
			return null;
		}
		IEditorInput input = sharedObjects.getLoadedEditor().getEditorInput();
		if (input instanceof URIEditorInput) {
			URIEditorInput uriEditorInput = (URIEditorInput) input;
			EObject eObject = null;
			if (uriEditorInput.getURI().hasFragment()) {
				eObject = sharedObjects.getLoadedEditor().getEditingDomain().getResourceSet().getEObject(uriEditorInput.getURI(), false);
			} else {
				eObject = sharedObjects.getLoadedEditor().getEditingDomain().getResourceSet().getResource(uriEditorInput.getURI(), false).getContents().get(0);
			}
			if (eObject instanceof Diagram) {
				return (Diagram) eObject;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Element createInitialModel() {
		Diagram diagram = getDiagramFromSharedResources(getSharedObjects());
		if (diagram != null) {
			EObject eObject = diagram.getElement();
			if (eObject instanceof Package) {
				return ((Package) eObject).createPackagedElement("Activity", UMLPackage.eINSTANCE.getActivity());
			}
		}
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
		return "MOSKitt UML2 Activity Diagram";
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run(GmfMultiDiagramSharedObjects sharedObjects) {
		setSharedObjects(sharedObjects);
		super.run(sharedObjects);
	}

}
