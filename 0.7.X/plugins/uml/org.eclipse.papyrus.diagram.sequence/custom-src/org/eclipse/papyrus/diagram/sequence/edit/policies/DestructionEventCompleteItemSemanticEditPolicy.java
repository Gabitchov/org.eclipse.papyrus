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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.helper.DurationConstraintHelper;
import org.eclipse.papyrus.diagram.common.helper.DurationObservationHelper;
import org.eclipse.papyrus.diagram.common.helper.TimeConstraintHelper;
import org.eclipse.papyrus.diagram.common.helper.TimeObservationHelper;
import org.eclipse.papyrus.diagram.sequence.util.SequenceDeleteHelper;
import org.eclipse.uml2.uml.DestructionEvent;
import org.eclipse.uml2.uml.DurationConstraint;
import org.eclipse.uml2.uml.DurationObservation;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.OccurrenceSpecification;
import org.eclipse.uml2.uml.TimeConstraint;
import org.eclipse.uml2.uml.TimeObservation;


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
						OccurrenceSpecification event = (OccurrenceSpecification)settingEObj;
						DestroyElementRequest r = new DestroyElementRequest(event, false);
						cmd.add(new DestroyElementCommand(r));

						// delete linked time elements
						List<TimeObservation> timeObs = TimeObservationHelper.getTimeObservations(event);
						List<TimeConstraint> timeCst = TimeConstraintHelper.getTimeConstraintsOn(event);
						List<DurationObservation> durObs = DurationObservationHelper.getDurationObservationsOn(event);
						List<DurationConstraint> durCst = DurationConstraintHelper.getDurationConstraintsOn(event);
						List<NamedElement> timeElements = new ArrayList<NamedElement>(timeObs.size() + durObs.size() + timeCst.size() + durCst.size());
						timeElements.addAll(timeObs);
						timeElements.addAll(timeCst);
						timeElements.addAll(durObs);
						timeElements.addAll(durCst);
						for(NamedElement elt : timeElements) {
							cmd.add(new DestroyElementCommand(new DestroyElementRequest(elt, false)));
						}
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

	/**
	 * This method has been overridden to also delete linked time/duration views
	 */
	protected Command addDeleteViewCommand(Command mainCommand, DestroyRequest completedRequest) {
		CompoundCommand deleteViewsCommand = new CompoundCommand();
		Command deleteViewCommand = getGEFWrapper(new DeleteCommand(getEditingDomain(), (View)getHost().getModel()));
		deleteViewsCommand.add(deleteViewCommand);
		SequenceDeleteHelper.completeDeleteDestructionEventViewCommand(deleteViewsCommand, getEditingDomain(), getHost());
		if(mainCommand == null) {
			return deleteViewsCommand;
		} else {
			return mainCommand.chain(deleteViewsCommand);
		}
	}
}
