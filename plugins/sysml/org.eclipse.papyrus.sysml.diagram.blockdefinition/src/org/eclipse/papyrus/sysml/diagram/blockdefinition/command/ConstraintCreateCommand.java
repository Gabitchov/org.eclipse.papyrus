/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mathieu Velten (Atos Origin) mathieu.velten@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.blockdefinition.command;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.helper.NamedElementHelper;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

public class ConstraintCreateCommand extends EditElementCommand {

	/**
	 * @generated
	 */
	private EObject eObject = null;

	/**
	 * @generated
	 */
	public ConstraintCreateCommand(CreateElementRequest req, EObject eObject) {
		super(req.getLabel(), null, req);
		this.eObject = eObject;
	}

	/**
	 * @generated
	 */
	public static ConstraintCreateCommand create(CreateElementRequest req, EObject eObject) {
		return new ConstraintCreateCommand(req, eObject);
	}

	/**
	 * @generated
	 */
	public ConstraintCreateCommand(CreateElementRequest req) {
		super(req.getLabel(), null, req);
	}

	protected EObject getElementToEdit() {

		EObject container = ((CreateElementRequest)getRequest()).getContainer();
		if(container instanceof View) {
			container = ((View)container).getElement();
		}
		if(container != null) {
			return container;
		}
		return eObject;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		Constraint newConstraint = UMLFactory.eINSTANCE.createConstraint();

		Class owner = (Class)getElementToEdit();
		owner.getOwnedRules().add(newConstraint);

		String newElementName = NamedElementHelper.EINSTANCE.getNewUMLElementName(newConstraint.getOwner(), UMLPackage.eINSTANCE.getConstraint());
		newConstraint.setName(newElementName);

		((CreateElementRequest)getRequest()).setNewElement(newConstraint);

		doConfigure(newConstraint, monitor, info);
		return CommandResult.newOKCommandResult(newConstraint);
	}

	protected void doConfigure(Element newElement, IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		IElementType elementType = ((CreateElementRequest)getRequest()).getElementType();
		ConfigureRequest configureRequest = new ConfigureRequest(getEditingDomain(), newElement, elementType);
		configureRequest.setClientContext(((CreateElementRequest)getRequest()).getClientContext());
		configureRequest.addParameters(getRequest().getParameters());
		ICommand configureCommand = elementType.getEditCommand(configureRequest);
		if(configureCommand != null && configureCommand.canExecute()) {
			configureCommand.execute(monitor, info);
		}
	}

}
