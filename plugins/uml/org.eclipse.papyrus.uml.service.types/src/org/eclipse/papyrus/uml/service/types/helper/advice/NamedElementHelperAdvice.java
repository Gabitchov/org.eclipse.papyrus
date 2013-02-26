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
package org.eclipse.papyrus.uml.service.types.helper.advice;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyDependentsRequest;
import org.eclipse.uml2.uml.DirectedRelationship;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * <pre>
 * This HelperAdvice completes {@link NamedElement} edit commands with the deletion of any
 * {@link DirectedRelationship} related to the named element (source or target).
 * </pre>
 */
public class NamedElementHelperAdvice extends AbstractEditHelperAdvice {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getBeforeDestroyDependentsCommand(DestroyDependentsRequest request) {

		ICommand command = super.getBeforeDestroyDependentsCommand(request);

		NamedElement elementToDestroy = (NamedElement)request.getElementToDestroy();

		Set<DirectedRelationship> relationshipsWithoutEnds = new HashSet<DirectedRelationship>();

		Iterator<DirectedRelationship> srcRelationhipsIt = elementToDestroy.getSourceDirectedRelationships(UMLPackage.eINSTANCE.getDependency()).iterator();
		while(srcRelationhipsIt.hasNext()) {
			DirectedRelationship directedRelationship = srcRelationhipsIt.next();

			// If all sources from the directed relationship are to be destroyed, add the relationship destruction 
			if(request.getDependentElementsToDestroy().containsAll(directedRelationship.getSources())) {
				if(!request.getDependentElementsToDestroy().contains(directedRelationship)) {
					relationshipsWithoutEnds.add(directedRelationship);
				}
			}
		}

		Iterator<DirectedRelationship> tgtRelationhipsIt = elementToDestroy.getTargetDirectedRelationships(UMLPackage.eINSTANCE.getDependency()).iterator();
		while(tgtRelationhipsIt.hasNext()) {
			DirectedRelationship directedRelationship = tgtRelationhipsIt.next();

			// If all sources from the directed relationship are to be destroyed, add the relationship destruction 
			if(request.getDependentElementsToDestroy().containsAll(directedRelationship.getTargets())) {
				if(!request.getDependentElementsToDestroy().contains(directedRelationship)) {
					relationshipsWithoutEnds.add(directedRelationship);
				}
			}
		}

		// Destroy these relationships
		DestroyDependentsRequest ddr = new DestroyDependentsRequest(request.getEditingDomain(), request.getElementToDestroy(), false);
		ddr.setClientContext(request.getClientContext());
		ddr.addParameters(request.getParameters());
		ICommand destroyDependantCommand = ddr.getDestroyDependentsCommand(relationshipsWithoutEnds);

		command = CompositeCommand.compose(destroyDependantCommand, command);

		return command;
	}
}
