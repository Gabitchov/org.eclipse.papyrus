/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.uml.diagram.clazz.custom.command;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.papyrus.uml.diagram.clazz.edit.policies.UMLBaseItemSemanticEditPolicy;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.TemplateableElement;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * 
 * custom class in order to fill the propety signature of a template bindinf
 * 
 */
public class CTemplateBindingCreateCommand extends org.eclipse.papyrus.uml.diagram.clazz.edit.commands.TemplateBindingCreateCommand {

	public CTemplateBindingCreateCommand(CreateRelationshipRequest request, EObject source, EObject target) {
		super(request, source, target);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.clazz.edit.commands.TemplateBindingCreateCommand#canExecute()
	 * 
	 */
	public boolean canExecute() {
		if(source == null && target == null) {
			return false;
		}
		if(source != null && false == source instanceof TemplateableElement) {
			return false;
		}
		if(target != null && false == target instanceof TemplateableElement) {
			return false;
		}
		if(target != null && target instanceof TemplateableElement && ((TemplateableElement)target).getOwnedTemplateSignature() == null) {
			return false;
		}
		if(getSource() == null) {
			return true; // link creation is in progress; source is not defined yet
		}
		// target may be null here but it's possible to check constraint
		if(getContainer() == null) {
			return false;
		}
		return UMLBaseItemSemanticEditPolicy.getLinkConstraints().canCreateTemplateBinding_4015(getContainer(), getSource(), getTarget());
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.clazz.edit.commands.TemplateBindingCreateCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor,
	 *      org.eclipse.core.runtime.IAdaptable)
	 * 
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if(!canExecute()) {
			throw new ExecutionException("Invalid arguments in create link command"); //$NON-NLS-1$
		}
		TemplateBinding newElement = UMLFactory.eINSTANCE.createTemplateBinding();
		getContainer().getTemplateBindings().add(newElement);
		newElement.setBoundElement(getSource());
		newElement.setSignature(((TemplateableElement)target).getOwnedTemplateSignature());
		doConfigure(newElement, monitor, info);
		((CreateElementRequest)getRequest()).setNewElement(newElement);
		return CommandResult.newOKCommandResult(newElement);
	}
}
