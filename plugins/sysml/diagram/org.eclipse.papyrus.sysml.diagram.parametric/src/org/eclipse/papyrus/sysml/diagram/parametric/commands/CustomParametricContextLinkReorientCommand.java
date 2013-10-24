/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		Régis CHEVREL: chevrel.regis <at> gmail.com
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.parametric.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.service.types.utils.NamedElementHelper;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;

/**
 * A context link must have a Constraint as source and a Namespace as target
 * @See ContextLinkReorientCommand
 *
 */
public class CustomParametricContextLinkReorientCommand extends EditElementCommand {

	private final int reorientDirection;

	protected ReorientReferenceRelationshipRequestWithGraphical request;
	protected EObject referenceOwner;
	protected EObject oldSource;
	protected EObject newSource;
	protected EObject oldTarget;
	protected EObject newTarget;
	
	public CustomParametricContextLinkReorientCommand(
			ReorientReferenceRelationshipRequestWithGraphical request) {
		super(request.getLabel(), null, request);
		this.request = request;
		reorientDirection = request.getDirection();
		referenceOwner = request.getReferenceOwner();
		oldSource = reorientDirection == ReorientRequest.REORIENT_SOURCE ? request.getOldRelationshipEnd() : request.getReferenceOwner();
		newSource = reorientDirection == ReorientRequest.REORIENT_SOURCE ? request.getNewRelationshipEnd() : request.getReferenceOwner();
		oldTarget = reorientDirection == ReorientRequest.REORIENT_SOURCE ? request.getReferenceOwner() : request.getOldRelationshipEnd();
		newTarget = reorientDirection == ReorientRequest.REORIENT_SOURCE ? request.getReferenceOwner() : request.getNewRelationshipEnd();		
	}

	public boolean canExecute() {
		return getNewSource() instanceof Constraint && resolveNamespace(getNewTarget()) instanceof Namespace;
	}

	/**
	 * Get the property Namespace in case of property typed by a Namespace
	 */
	protected Namespace resolveNamespace(Element element) {
		if (element instanceof Namespace) {
			return (Namespace)element;
		}
		if (element instanceof Property) {
			Type type = ((Property) element).getType();
			if (type instanceof Namespace) {
				return (Namespace)type;
			}
		}
		return null;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if(!canExecute()) {
			throw new ExecutionException("Invalid arguments in reorient link command"); //$NON-NLS-1$
		}
		if(reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			return reorientSource();
		}
		if(reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			return reorientTarget();
		}
		throw new IllegalStateException();
	}

	/**
	 * Set a default container for old Constraint (diagram consistency).
	 * Set the new context for new Constraint
	 * Update new Constraint name with new owner ownedRules if necessary
	 */
	protected CommandResult reorientSource() {
		EditPart sourceEditPart = request.getSourceEditPart();
		Namespace nearestNamespace = getNearestNamespace(sourceEditPart);
		getOldSource().setContext(nearestNamespace); // set a default container
		Namespace context = resolveNamespace(getNewTarget());
		// Check name
		String defaultNameWithIncrementFromBase = NamedElementHelper.getDefaultNameWithIncrementFromBase(Constraint.class.getSimpleName(), context.getOwnedRules(), getNewSource());
		((Constraint)getNewSource()).setName(defaultNameWithIncrementFromBase);
		// set the context
		((Constraint)getNewSource()).setContext(resolveNamespace(getNewTarget()));

		return CommandResult.newOKCommandResult(referenceOwner);
	}

	private Namespace getNearestNamespace(EditPart editPart) {
		if (editPart != null) {
			EObject semanticElement = ViewUtil.resolveSemanticElement((View) editPart.getModel());
			if (semanticElement != null) {
				Namespace resolvedNamespace = resolveNamespace((Element)semanticElement);
				if (resolvedNamespace instanceof Namespace) {
					return resolvedNamespace;
				}
				return getNearestNamespace(editPart.getParent());				
			}
		}
		return null;
	}

	/**
	 * Set the new context for new Constraint
	 * Update new Constraint name with new owner ownedRules if necessary
	 */
	protected CommandResult reorientTarget() {
		Namespace context = resolveNamespace(getNewTarget());
		// Check name
		String defaultNameWithIncrementFromBase = NamedElementHelper.getDefaultNameWithIncrementFromBase(Constraint.class.getSimpleName(), context.getOwnedRules(), getNewSource());
		((Constraint)getNewSource()).setName(defaultNameWithIncrementFromBase);
		// Set the context
		((Constraint)getNewSource()).setContext(context);
		return CommandResult.newOKCommandResult(referenceOwner);
	}

	protected Constraint getOldSource() {
		return (Constraint)oldSource;
	}

	protected Element getNewSource() {
		return (Element)newSource;
	}

	protected Element getOldTarget() {
		return (Element)oldTarget;
	}

	protected Element getNewTarget() {
		return (Element)newTarget;
	}
}
