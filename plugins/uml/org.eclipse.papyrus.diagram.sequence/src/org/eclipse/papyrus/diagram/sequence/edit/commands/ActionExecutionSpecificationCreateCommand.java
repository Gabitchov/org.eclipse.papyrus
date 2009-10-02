/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.sequence.edit.commands;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.util.MultiDiagramUtil;
import org.eclipse.papyrus.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Action;
import org.eclipse.uml2.uml.ActionExecutionSpecification;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated NOT
 */
public class ActionExecutionSpecificationCreateCommand extends CreateElementCommand {

	/**
	 * @generated
	 */
	private EClass eClass = null;

	/**
	 * @generated
	 */
	private EObject eObject = null;

	/**
	 * @generated NOT
	 */
	public ActionExecutionSpecificationCreateCommand(CreateElementRequest req, EObject eObject) {
		super(req);
		this.eObject = eObject;
		this.eClass = eObject != null ? eObject.eClass() : null;
	}

	/**
	 * @generated
	 */
	public static ActionExecutionSpecificationCreateCommand create(CreateElementRequest req, EObject eObject) {
		return new ActionExecutionSpecificationCreateCommand(req, eObject);
	}

	/**
	 * @generated NOT
	 */
	public ActionExecutionSpecificationCreateCommand(CreateElementRequest req) {
		super(req);
	}

	/**
	 * FIXME: replace with setElementToEdit()
	 * 
	 * @generated NOT
	 */
	@Override
	protected EObject getElementToEdit() {

		EObject container = ((CreateElementRequest) getRequest()).getContainer();
		if (container instanceof View) {
			container = ((View) container).getElement();
		}

		// AES : Added to contain the ActionExecutionSpecification inside the
		// Interaction, not in the Lifeline (where it is shown)
		if (container instanceof Lifeline) {
			return ((Lifeline) container).getInteraction();
		}

		if (container != null) {
			return container;
		}
		return eObject;
	}

	/**
	 * @generated
	 */
	@Override
	public boolean canExecute() {
		return true;

	}

	/**
	 * @generated NOT
	 */
	@Override
	protected EObject doDefaultElementCreation() {
		ActionExecutionSpecification newElement = (ActionExecutionSpecification) super.doDefaultElementCreation();
		if (newElement != null) {
			Interaction owner = (Interaction) getElementToEdit();
			owner.getFragments().add(newElement);

			UMLElementTypes.init_ActionExecutionSpecification_3006(newElement);

			MultiDiagramUtil.addEAnnotationReferenceToDiagram(UMLDiagramEditorPlugin.getInstance(), newElement);

			if (newElement.getAction() == null) {
				Action action = owner.createAction("Action", UMLPackage.eINSTANCE.getOpaqueAction());
				newElement.setAction(action);
			}
		}
		return newElement;
	}

}
