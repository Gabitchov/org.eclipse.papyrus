/*****************************************************************************
 * Copyright (c) 2010 CEA.
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
package org.eclipse.papyrus.diagram.sequence.edit.policies;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.uml.DestructionEvent;
import org.eclipse.uml2.uml.OccurrenceSpecification;


/**
 * A specific itemSemantic edit policy for the destructionEvent.
 * Add some behavior specific to the DestructionEvent.
 */
public class DestructionEventCompleteItemSemanticEditPolicy extends DestructionEventItemSemanticEditPolicy {

	/**
	 * Override to add specific behavior on delete action :
	 * When the destructionEvent is deleted, the occurrenceSpecification which links the lifeline and the destructionEvent has to be delete too.
	 */
	@Override
	protected Command getDestroyElementCommand(DestroyElementRequest req) {

		// Get the super command
		Command command = super.getDestroyElementCommand(req);

		// Define a new CompositeTransactional command
		CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(getEditingDomain(), null);
		cmd.setTransactionNestingEnabled(false);

		if(command instanceof ICommandProxy) {

			// Retrieve the ICommand from the super command to add it to the new CompositeTransactional command
			ICommandProxy cmdProxy = (ICommandProxy)command;
			cmd.add(cmdProxy.getICommand());

			// Get the UML element associated with this policy
			View view = (View)getHost().getModel();
			EObject eObject = view.getElement();

			if(eObject instanceof DestructionEvent) {
				// Get the usage of this destructionEvent in the resourceSet. 
				Collection<EStructuralFeature.Setting> usages = getUsages(eObject, getEditingDomain().getResourceSet());

				for(EStructuralFeature.Setting setting : usages) {
					EObject settingEObj = setting.getEObject();
					// In case it is an OccurrenceSpecification, add a DestroyElement command.
					// An OccurrenceSpecification must have an event
					if(settingEObj instanceof OccurrenceSpecification) {
						DestroyElementRequest r = new DestroyElementRequest((OccurrenceSpecification)settingEObj, false);
						cmd.add(new DestroyElementCommand(r));
					}
				}
			}


		}

		// Wrap and return the command
		return getGEFWrapper(cmd.reduce());
	}

	//TODO : comment and extract this method into a generic class.
	public static Collection<EStructuralFeature.Setting> getUsages(EObject source, ResourceSet r) {
		Collection<EStructuralFeature.Setting> collection = null;
		ECrossReferenceAdapter crossReferenceAdapter = ECrossReferenceAdapter.getCrossReferenceAdapter(source);
		if(crossReferenceAdapter != null) {
			collection = crossReferenceAdapter.getNonNavigableInverseReferences(source);
		} else {
			collection = EcoreUtil.UsageCrossReferencer.find(source, r);
		}
		return collection;
	}
}
