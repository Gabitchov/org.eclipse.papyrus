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
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class PrimitiveType2CreateCommand extends CreateElementCommand {

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
	public PrimitiveType2CreateCommand(CreateElementRequest req, EObject eObject) {
		super(req);
		this.eObject = eObject;
		this.eClass = eObject != null ? eObject.eClass() : null;
	}

	/**
	 * @generated
	 */
	public static PrimitiveType2CreateCommand create(CreateElementRequest req, EObject eObject) {
		return new PrimitiveType2CreateCommand(req, eObject);
	}

	/**
	 * @generated
	 */
	public PrimitiveType2CreateCommand(CreateElementRequest req) {
		super(req);
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
		return UMLPackage.eINSTANCE.getPackage();
	}

	/**
	 * @generated
	 */
	protected EObject doDefaultElementCreation() {
		PrimitiveType newElement = UMLFactory.eINSTANCE.createPrimitiveType();

		Package owner = (Package) getElementToEdit();
		owner.getPackagedElements().add(newElement);

		UMLElementTypes.init_PrimitiveType_3026(newElement);

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

}
