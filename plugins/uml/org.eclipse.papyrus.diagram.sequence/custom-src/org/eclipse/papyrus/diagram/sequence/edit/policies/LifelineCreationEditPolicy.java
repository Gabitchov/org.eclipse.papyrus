/*****************************************************************************
 * Copyright (c) 2009 CEA
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

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.draw2d.Polyline;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SemanticCreateCommand;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.diagram.ui.requests.RefreshConnectionsRequest;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.diagram.sequence.util.SequenceRequestConstant;
import org.eclipse.papyrus.diagram.sequence.util.SequenceUtil;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.OccurrenceSpecification;

/**
 * A specific creation edit policy for the Lifeline.
 * Execution Specification is created graphically on the lifeline, but depending on its graphical position determines also its model container.
 * 
 * 
 */
public class LifelineCreationEditPolicy extends CreationEditPolicy {

	private Polyline feedback;

	@Override
	protected Command getCreateElementAndViewCommand(CreateViewAndElementRequest request) {
		// get the element descriptor
		CreateElementRequestAdapter requestAdapter = request.getViewAndElementDescriptor().getCreateElementRequestAdapter();

		// get the semantic request
		CreateElementRequest createElementRequest = (CreateElementRequest)requestAdapter.getAdapter(CreateElementRequest.class);

		if(createElementRequest.getContainer() == null) {
			// complete the semantic request by filling in the host's semantic
			// element as the context
			View view = (View)getHost().getModel();
			EObject hostElement = ViewUtil.resolveSemanticElement(view);

			if(hostElement == null && view.getElement() == null) {
				hostElement = view;
			}

			// Returns null if host is unresolvable so that trying to create a
			// new element in an unresolved shape will not be allowed.
			if(hostElement == null) {
				return null;
			}
			createElementRequest.setContainer(hostElement);
		}

		InteractionFragment ift = SequenceUtil.findInteractionFragmentAt(request.getLocation(), getHost());

		Map<String, Object> extendedData = request.getExtendedData();
		extendedData.put(SequenceRequestConstant.INTERACTIONFRAGMENT_CONTAINER, ift);

		// record the nearest event if necessary
		String timeConstraintHint = ((IHintedType)UMLElementTypes.TimeConstraint_3019).getSemanticHint();
		String timeObservationHint = ((IHintedType)UMLElementTypes.TimeObservation_3020).getSemanticHint();
		String durationConstraintOnLifelineHint = ((IHintedType)UMLElementTypes.DurationConstraint_3021).getSemanticHint();
		String requestHint = request.getViewAndElementDescriptor().getSemanticHint();
		if(timeConstraintHint.equals(requestHint) || timeObservationHint.equals(requestHint) || durationConstraintOnLifelineHint.equals(requestHint)) {
			EditPart hostPart = getHost();
			if(hostPart instanceof LifelineEditPart) {
				Entry<OccurrenceSpecification, Point> eventAndLocation = SequenceUtil.findNearestEvent(request.getLocation(), (LifelineEditPart)hostPart);
				// find an event near enough to create the constraint or observation
				OccurrenceSpecification event = null;
				Point location = null;
				if(eventAndLocation != null) {
					event = eventAndLocation.getKey();
					location = eventAndLocation.getValue();
				}
				if(extendedData.containsKey(SequenceRequestConstant.NEAREST_OCCURRENCE_SPECIFICATION_2)) {
					extendedData.put(SequenceRequestConstant.NEAREST_OCCURRENCE_SPECIFICATION_2, event);
				} else {
					extendedData.put(SequenceRequestConstant.NEAREST_OCCURRENCE_SPECIFICATION, event);
				}
				if(extendedData.containsKey(SequenceRequestConstant.OCCURRENCE_SPECIFICATION_LOCATION_2)) {
					extendedData.put(SequenceRequestConstant.OCCURRENCE_SPECIFICATION_LOCATION_2, location);
				} else {
					extendedData.put(SequenceRequestConstant.OCCURRENCE_SPECIFICATION_LOCATION, location);
				}
			}
		}

		// get the create element command based on the elementdescriptor's
		// request
		Command createElementCommand = getHost().getCommand(new EditCommandRequestWrapper((CreateElementRequest)requestAdapter.getAdapter(CreateElementRequest.class), request.getExtendedData()));

		if(createElementCommand == null) {
			return UnexecutableCommand.INSTANCE;
		}
		if(!createElementCommand.canExecute()) {
			return createElementCommand;
		}
		// create the semantic create wrapper command
		SemanticCreateCommand semanticCommand = new SemanticCreateCommand(requestAdapter, createElementCommand);
		Command viewCommand = getCreateCommand(request);

		Command refreshConnectionCommand = getHost().getCommand(new RefreshConnectionsRequest(((List)request.getNewObject())));


		// form the compound command and return
		CompositeCommand cc = new CompositeCommand(semanticCommand.getLabel());
		cc.compose(semanticCommand);
		cc.compose(new CommandProxy(viewCommand));
		if(refreshConnectionCommand != null) {
			cc.compose(new CommandProxy(refreshConnectionCommand));
		}

		return new ICommandProxy(cc);
	}

}
