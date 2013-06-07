/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Boutheina Bannour (CEA LIST) boutheina.bannour@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.uml.diagram.profile.custom.commands;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.papyrus.uml.diagram.profile.edit.commands.ContextLinkCreateCommand;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Namespace;

/**
 * use to construct the instance specification link between two instance
 * 
 */
public class CustomContextLinkCreateCommand extends ContextLinkCreateCommand {


	public CustomContextLinkCreateCommand(CreateRelationshipRequest request, EObject source, EObject target) {
		super(request, source, target);
	}

	@Override
	public boolean canExecute() {
		if(source == null && target == null) {
			return false;
		}
		if(source != null && false == source instanceof Constraint) {
			return false;
		}
		if(target != null && false == target instanceof Namespace) {
			return false;
		}
		if(getSource() == null) {
			return true; // link creation is in progress; source is not defined yet
		}
		if(getSource() != null) {
			// the context is already set
			if(getSource().getContext() != null && target != null && getSource().getContext() != target) {
				return false;
			}
		}
		if(getTarget() != null && (getTarget().getOwnedRules().contains(getTarget()))) {
			return false;
		}
		return true;
	}


}
