/***************************************************************************
 * Copyright (c) 2007 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Gabriel Merin Cubero (Prodevelop) – Sequence Diagram implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.sequence.edit.commands;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.uml.BehaviorExecutionSpecification;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.UMLPackage;

import org.eclipse.papyrus.diagram.common.util.MultiDiagramUtil;
import org.eclipse.papyrus.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.diagram.sequence.providers.UMLElementTypes;

/**
 * @generated
 */
public class BehaviorExecutionSpecificationCreateCommand extends
		CreateElementCommand {

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
	public BehaviorExecutionSpecificationCreateCommand(
			CreateElementRequest req, EObject eObject) {
		super(req);
		this.eObject = eObject;
		this.eClass = eObject != null ? eObject.eClass() : null;
	}

	/**
	 * @generated
	 */
	public static BehaviorExecutionSpecificationCreateCommand create(
			CreateElementRequest req, EObject eObject) {
		return new BehaviorExecutionSpecificationCreateCommand(req, eObject);
	}

	/**
	 * @generated
	 */
	public BehaviorExecutionSpecificationCreateCommand(CreateElementRequest req) {
		super(req);
	}

	/**
	 * @generated NOT
	 */
	@Override
	protected EObject getElementToEdit() {
		EObject container = ((CreateElementRequest) getRequest())
				.getContainer();
		if (container instanceof View) {
			container = ((View) container).getElement();
		}

		// Added to contain the BehaviourExecutionSpecification inside the
		// Interaction, not in the Lifeline (where it is shown)
		if (container instanceof Lifeline)
			return ((Lifeline) container).getInteraction();

		return container;
	}

	/**
	 * @generated
	 */
	@Override
	protected EClass getEClassToEdit() {

		EObject eObject = getElementToEdit();
		if (eObject != null) {
			return eObject.eClass();
		}
		if (eClass != null) {
			return eClass;
		}
		return UMLPackage.eINSTANCE.getInteraction();
	}

	/**
	 * @generated
	 */
	protected Diagram getDiagramFromRequest() {

		if (getRequest().getParameters().get(
				MultiDiagramUtil.BelongToDiagramSource) != null) {
			Object parameter = getRequest().getParameters().get(
					MultiDiagramUtil.BelongToDiagramSource);
			if (parameter instanceof Diagram) {
				return (Diagram) parameter;
			}
		}
		return null;
	}

	/**
	 * @generated
	 */
	@Override
	protected EObject doDefaultElementCreation() {
		BehaviorExecutionSpecification newElement = (BehaviorExecutionSpecification) super
				.doDefaultElementCreation();
		if (newElement != null) {
			Interaction owner = (Interaction) getElementToEdit();
			owner.getFragments().add(newElement);

			UMLElementTypes
					.init_BehaviorExecutionSpecification_2003(newElement);

			Diagram diagram = getDiagramFromRequest();
			if (diagram != null) {
				MultiDiagramUtil.AddEAnnotationReferenceToDiagram(diagram,
						newElement);
			} else {
				MultiDiagramUtil.addEAnnotationReferenceToDiagram(
						UMLDiagramEditorPlugin.getInstance(), newElement);
			}
		}
		return newElement;
	}
}
