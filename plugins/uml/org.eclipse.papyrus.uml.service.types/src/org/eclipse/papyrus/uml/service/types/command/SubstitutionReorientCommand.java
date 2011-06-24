/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 
 * 		Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.types.command;

import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Substitution;

/**
 * <pre>
 * Re-orient command for {@link Substitution} elements.
 * </pre>
 */
public class SubstitutionReorientCommand extends DependencyReorientCommand {

	/**
	 * <pre>
	 * Constructor.
	 * 
	 * @param request the re-orient relationship request.
	 * </pre>
	 */
	public SubstitutionReorientCommand(ReorientRelationshipRequest request) {
		super(request);
	}

	/**
	 * <pre>
	 * @see org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand#canExecute()
	 * 
	 * @return true if the command is executable.
	 * </pre>
	 */
	public boolean canExecute() {
		if(! (getElementToEdit() instanceof Substitution)) {
			return false;
		}
		
		return super.canExecute();
	}

	protected boolean canReorientSource() {
		if(!(newEnd instanceof Classifier)) {
			return false;
		}

		if (newEnd == getLink().getContract()) {
			return false;
		}
		
		return true;
	}

	protected boolean canReorientTarget() {
		if(!(newEnd instanceof Classifier)) {
			return false;
		}

		if (newEnd == getLink().getSubstitutingClassifier()) {
			return false;
		}
		
		return true;
	}

	protected Substitution getLink() {
		return (Substitution)getElementToEdit();
	}

}
