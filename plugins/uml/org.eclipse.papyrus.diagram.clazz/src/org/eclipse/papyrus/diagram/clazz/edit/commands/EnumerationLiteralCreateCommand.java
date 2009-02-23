/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.clazz.edit.commands;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class EnumerationLiteralCreateCommand extends CreateElementCommand {

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
	public EnumerationLiteralCreateCommand(CreateElementRequest req, EObject eObject) {
		super(req);
		this.eObject = eObject;
		this.eClass = eObject != null ? eObject.eClass() : null;
	}

	/**
	 * @generated
	 */
	public static EnumerationLiteralCreateCommand create(CreateElementRequest req, EObject eObject) {
		return new EnumerationLiteralCreateCommand(req, eObject);
	}

	/**
	 * @generated
	 */
	public EnumerationLiteralCreateCommand(CreateElementRequest req) {
		super(req);
	}

	/**
	 * @generated
	 */
	protected EObject doDefaultElementCreation() {
		EnumerationLiteral newElement = UMLFactory.eINSTANCE.createEnumerationLiteral();

		Enumeration owner = (Enumeration) getElementToEdit();
		owner.getOwnedLiterals().add(newElement);

		UMLElementTypes.init_EnumerationLiteral_3017(newElement);

		// code used in MOSKitt approach in order to manage "delete from diagram"
		// org.eclipse.gmf.runtime.notation.Diagram diagram = es.cv.gvcase.mdt.common.util.MDTUtil.getDiagramFromRequest(getRequest());
		// if (diagram != null) {
		// es.cv.gvcase.mdt.common.util.MultiDiagramUtil.AddEAnnotationReferenceToDiagram(diagram, newElement);
		// }
		// else {
		// es.cv.gvcase.mdt.common.util.MultiDiagramUtil.
		// addEAnnotationReferenceToDiagram(
		// org.eclipse.papyrus.diagram.clazz.part.UMLDiagramEditorPlugin.getInstance(), newElement);
		// }
		return newElement;
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
		return UMLPackage.eINSTANCE.getEnumeration();
	}

	/**
	 * @generated
	 */
	protected EObject getElementToEdit() {

		EObject container = ((CreateElementRequest) getRequest()).getContainer();
		if (container instanceof View) {
			container = ((View) container).getElement();
		}
		if (container != null) {
			return container;
		}
		return eObject;
	}

}
