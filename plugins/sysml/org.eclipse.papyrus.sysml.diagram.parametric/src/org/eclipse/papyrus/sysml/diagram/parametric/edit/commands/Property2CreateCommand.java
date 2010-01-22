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
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.parametric.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagramprofile.utils.StereotypeUtils;
import org.eclipse.papyrus.sysml.constraints.ConstraintProperty;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.StructuredClassifier;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * @generated
 */
public class Property2CreateCommand extends EditElementCommand {

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
	public Property2CreateCommand(CreateElementRequest req, EObject eObject) {
		super(req.getLabel(), null, req);
		this.eObject = eObject;
		this.eClass = eObject != null ? eObject.eClass() : null;
	}

	/**
	 * @generated
	 */
	public static Property2CreateCommand create(CreateElementRequest req, EObject eObject) {
		return new Property2CreateCommand(req, eObject);
	}

	/**
	 * @generated
	 */
	public Property2CreateCommand(CreateElementRequest req) {
		super(req.getLabel(), null, req);
	}

	/**
	 * FIXME: replace with setElementToEdit()
	 * 
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
	 * @generated NOT
	 */
	public boolean canExecute() {
		ConstraintProperty container = (ConstraintProperty) getElementToEdit();
		Property baseProperty = container.getBase_Property();
		if (baseProperty != null && baseProperty.getType() != null) {
				// TODO constraint is too restrictive
				// && StereotypeUtils.isStereotypeApplied("SysML::Constraints::ConstraintBlock", baseProperty.getType())) {
			return true;
		}
		return false;

	}

	/**
	 * @generated NOT
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		Property newElement = UMLFactory.eINSTANCE.createProperty();
		ConstraintProperty owner = (ConstraintProperty) getElementToEdit();
		Type type = owner.getBase_Property().getType();

		if (type != null && type instanceof StructuredClassifier) {
			StructuredClassifier classifier = (StructuredClassifier) type;
			classifier.getOwnedAttributes().add(newElement);

			doConfigure(newElement, monitor, info);

			((CreateElementRequest) getRequest()).setNewElement(newElement);
			return CommandResult.newOKCommandResult(newElement);
		} else {
			return CommandResult.newCancelledCommandResult();
		}
	}

	/**
	 * @generated
	 */
	protected void doConfigure(Property newElement, IProgressMonitor monitor, IAdaptable info)
			throws ExecutionException {
		IElementType elementType = ((CreateElementRequest) getRequest()).getElementType();
		ConfigureRequest configureRequest = new ConfigureRequest(getEditingDomain(), newElement, elementType);
		configureRequest.setClientContext(((CreateElementRequest) getRequest()).getClientContext());
		configureRequest.addParameters(getRequest().getParameters());
		ICommand configureCommand = elementType.getEditCommand(configureRequest);
		if (configureCommand != null && configureCommand.canExecute()) {
			configureCommand.execute(monitor, info);
		}
	}

}
