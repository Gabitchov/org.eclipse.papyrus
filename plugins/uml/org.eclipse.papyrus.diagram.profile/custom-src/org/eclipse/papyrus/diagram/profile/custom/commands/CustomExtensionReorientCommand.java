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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.profile.custom.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.papyrus.diagram.profile.custom.helper.ExtensionHelper;
import org.eclipse.papyrus.diagram.profile.custom.policies.CUMLBaseItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.profile.edit.commands.ExtensionReorientCommand;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;


public class CustomExtensionReorientCommand extends ExtensionReorientCommand {

	/** the new end */
	protected EObject newEnd;

	/** the old end */
	protected EObject oldEnd;

	/** the end to reconnect */
	protected int reorientDirection;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param request
	 */
	public CustomExtensionReorientCommand(ReorientRelationshipRequest request) {
		super(request);
		this.reorientDirection = request.getDirection();
		this.oldEnd = request.getOldRelationshipEnd();
		this.newEnd = request.getNewRelationshipEnd();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.diagram.profile.edit.commands.ExtensionReorientCommand#canReorientSource()
	 * 
	 * @return
	 */
	@Override
	protected boolean canReorientSource() {
		Type target = getLink().getEndTypes().get(1);
		if(!(target instanceof Class)) {
			return false;
		}
		if(_getNewSource() == null) {
			return false;
		}
		Package container = (Package)getLink().eContainer();
		return CUMLBaseItemSemanticEditPolicy.LinkConstraints.canExistExtension_1013(container, _getNewSource(), (Class)target);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.diagram.profile.edit.commands.ExtensionReorientCommand#canReorientTarget()
	 * 
	 * @return
	 */
	@Override
	protected boolean canReorientTarget() {
		Type source = getLink().getEndTypes().get(0);
		if(!(source instanceof Stereotype)) {
			return false;
		}
		if(!(getNewTarget() instanceof org.eclipse.uml2.uml.Class) || (getNewTarget() instanceof org.eclipse.uml2.uml.Stereotype)) {
			return false;
		}
		Package container = (Package)getLink().eContainer();
		return CUMLBaseItemSemanticEditPolicy.LinkConstraints.canExistExtension_1013(container, (Stereotype)source, getNewTarget());
	}

	/**
	 * @generated
	 */
	@Override
	protected CommandResult reorientSource() throws ExecutionException {
		return ExtensionHelper.reconnectSource(getLink(), _getNewSource());
	}

	/**
	 * @generated
	 */
	@Override
	protected CommandResult reorientTarget() throws ExecutionException {
		return ExtensionHelper.reconnectTarget(getLink(), getNewTarget());
	}

	/**
	 * Returns the new source
	 * 
	 * @return
	 *         <ul>
	 *         <li>the new source if its a {@link Stereotype}</li>
	 *         <li>null if not</li>
	 *         </ul>
	 */
	protected Stereotype _getNewSource() {
		if(newEnd instanceof Stereotype) {
			return (Stereotype)newEnd;
		}
		return null;
	}
}
