/*****************************************************************************
 * Copyright (c) 2008 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.usecase.edit.commands;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.usecase.providers.UMLElementTypes;
import org.eclipse.uml2.uml.ExtensionPoint;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.UseCase;

/**
 * @generated
 */
public class ExtensionPointCreateCommand extends CreateElementCommand {

	/**
	 * @generated
	 */
	private EClass eClass = null;
	/**
	 * @generated
	 */
	private EObject eObject = null;

	/**
	 * @generated
	 */
	public ExtensionPointCreateCommand(CreateElementRequest req, EObject eObject) {
		super(req);
		this.eObject = eObject;
		this.eClass = eObject != null ? eObject.eClass() : null;
	}

	/**
	 * @generated
	 */
	public static ExtensionPointCreateCommand create(CreateElementRequest req,
			EObject eObject) {
		return new ExtensionPointCreateCommand(req, eObject);
	}

	/**
	 * @generated
	 */
	public ExtensionPointCreateCommand(CreateElementRequest req) {
		super(req);
	}

	/**
	 * @generated
	 */
	protected EObject getElementToEdit() {

		EObject container = ((CreateElementRequest) getRequest())
				.getContainer();
		if (container instanceof View) {
			container = ((View) container).getElement();
		}
		if (container != null) {
			return container;
		}
		return eObject;
	}

	/**
	 * @generated
	 */
	protected EClass getEClassToEdit() {

		EObject eObject = getElementToEdit();
		if (eObject != null) {
			return eObject.eClass();
		}
		if (eClass != null) {
			return eClass;
		}
		return UMLPackage.eINSTANCE.getUseCase();
	}

	/**
	 * @generated
	 */
	protected EObject doDefaultElementCreation() {
		ExtensionPoint newElement = UMLFactory.eINSTANCE.createExtensionPoint();

		UseCase owner = (UseCase) getElementToEdit();
		owner.getExtensionPoints().add(newElement);

		UMLElementTypes.init_ExtensionPoint_3002(newElement);

		//code used in MOSKitt approach in order to manage "delete from diagram"
		//org.eclipse.gmf.runtime.notation.Diagram diagram = es.cv.gvcase.mdt.common.util.MDTUtil.getDiagramFromRequest(getRequest());
		//if (diagram != null) {
		//	es.cv.gvcase.mdt.common.util.MultiDiagramUtil.AddEAnnotationReferenceToDiagram(diagram, newElement);
		//}
		//else {
		//	es.cv.gvcase.mdt.common.util.MultiDiagramUtil.
		//		addEAnnotationReferenceToDiagram(
		//		org.eclipse.papyrus.diagram.usecase.part.UMLDiagramEditorPlugin.getInstance(), newElement);
		//}
		return newElement;
	}

}
