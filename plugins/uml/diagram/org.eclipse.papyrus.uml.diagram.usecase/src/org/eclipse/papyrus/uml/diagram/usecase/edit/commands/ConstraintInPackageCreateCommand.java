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
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.usecase.edit.commands;

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
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.viewpoints.policy.ModelAddData;
import org.eclipse.papyrus.infra.viewpoints.policy.PolicyChecker;
import org.eclipse.papyrus.uml.diagram.usecase.providers.ElementInitializers;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class ConstraintInPackageCreateCommand extends EditElementCommand {

	/**
	 * @generated
	 */
	private Diagram diagram = null;

	/**
	 * @generated
	 */
	private EObject eObject = null;

	/**
	 * @generated
	 */
	public ConstraintInPackageCreateCommand(CreateElementRequest req, EObject eObject, Diagram diagram) {
		super(req.getLabel(), null, req);
		this.eObject = eObject;
		this.diagram = diagram;
	}

	/**
	 * @generated
	 */
	public static ConstraintInPackageCreateCommand create(CreateElementRequest req, EObject eObject, Diagram diagram) {
		return new ConstraintInPackageCreateCommand(req, eObject, diagram);
	}

	/**
	 * @generated
	 */
	public ConstraintInPackageCreateCommand(CreateElementRequest req, Diagram diagram) {
		super(req.getLabel(), null, req);
		this.diagram = diagram;
	}

	/**
	 * FIXME: replace with setElementToEdit()
	 * 
	 * @generated
	 */
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

	/**
	 * @generated
	 */
	public boolean canExecute() {
		EObject target = getElementToEdit();
		ModelAddData data = PolicyChecker.getCurrent().getChildAddData(diagram, target.eClass(), UMLPackage.eINSTANCE.getConstraint());
		return data.isPermitted();
	}

	/**
	 * @generated
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		Constraint newElement = UMLFactory.eINSTANCE.createConstraint();
		EObject target = getElementToEdit();
		ModelAddData data = PolicyChecker.getCurrent().getChildAddData(diagram, target, newElement);
		if(data.isPermitted()) {
			if(data.isPathDefined()) {
				if(!data.execute(target, newElement))
					return CommandResult.newErrorCommandResult("Failed to follow the policy-specified for the insertion of the new element");
			} else {
				Package qualifiedTarget = (Package)target;
				qualifiedTarget.getPackagedElements().add(newElement);
			}
		} else {
			return CommandResult.newErrorCommandResult("The active policy restricts the addition of this element");
		}
		Namespace childHolder = (Namespace)getElementToEdit();
		childHolder.getOwnedRules().add(newElement);
		ElementInitializers.getInstance().init_Constraint_3010(newElement);
		doConfigure(newElement, monitor, info);
		((CreateElementRequest)getRequest()).setNewElement(newElement);
		return CommandResult.newOKCommandResult(newElement);
	}

	/**
	 * @generated
	 */
	protected void doConfigure(Constraint newElement, IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
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
