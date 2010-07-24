/*****************************************************************************
 * Copyright (c) 2010 CEA
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

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.papyrus.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.diagram.sequence.util.SequenceRequestConstant;
import org.eclipse.papyrus.diagram.sequence.util.SequenceUtil;
import org.eclipse.uml2.uml.OccurrenceSpecification;


public class CreationOnMessageEditPolicy extends CreationEditPolicy {

	/**
	 * Get the command after updating the request with appropriate occurrences
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy#getCreateElementAndViewCommand(org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest)
	 * 
	 * @param request
	 *        the request
	 * @return command or null
	 */
	@Override
	protected Command getCreateElementAndViewCommand(CreateViewAndElementRequest request) {
		Map<String, Object> extendedData = request.getExtendedData();

		// record the nearest event if necessary
		String requestHint = request.getViewAndElementDescriptor().getSemanticHint();
		if(isDurationHint(requestHint)) {
			EditPart hostPart = getHost();
			if(hostPart instanceof ConnectionNodeEditPart) {
				LifelineEditPart sourceLifeline = SequenceUtil.getParentLifelinePart(((ConnectionNodeEditPart)hostPart).getSource());
				LifelineEditPart targetLifeline = SequenceUtil.getParentLifelinePart(((ConnectionNodeEditPart)hostPart).getTarget());
				Entry<Point, List<OccurrenceSpecification>> eventAndLocation = null;
				if(sourceLifeline != null) {
					eventAndLocation = SequenceUtil.findNearestEvent(request.getLocation(), sourceLifeline);
				}
				if(targetLifeline != null && eventAndLocation == null) {
					eventAndLocation = SequenceUtil.findNearestEvent(request.getLocation(), targetLifeline);
				}
				// find an event near enough to create the constraint or observation
				List<OccurrenceSpecification> events = Collections.emptyList();
				Point location = null;
				if(eventAndLocation != null) {
					location = eventAndLocation.getKey();
					events = eventAndLocation.getValue();
				}
				if(extendedData.containsKey(SequenceRequestConstant.NEAREST_OCCURRENCE_SPECIFICATION_2)) {
					extendedData.put(SequenceRequestConstant.NEAREST_OCCURRENCE_SPECIFICATION_2, events);
				} else {
					extendedData.put(SequenceRequestConstant.NEAREST_OCCURRENCE_SPECIFICATION, events);
				}
				if(extendedData.containsKey(SequenceRequestConstant.OCCURRENCE_SPECIFICATION_LOCATION_2)) {
					extendedData.put(SequenceRequestConstant.OCCURRENCE_SPECIFICATION_LOCATION_2, location);
				} else {
					extendedData.put(SequenceRequestConstant.OCCURRENCE_SPECIFICATION_LOCATION, location);
				}
			}
		}
		return super.getCreateElementAndViewCommand(request);
	}

	/**
	 * Return true if request hint is hint of a duration element figure
	 * 
	 * @param requestHint
	 *        the hint to test
	 * @return true if duration hint
	 */
	private boolean isDurationHint(String requestHint) {
		String durCstOnLifelineHint = ((IHintedType)UMLElementTypes.DurationConstraint_3021).getSemanticHint();
		String durCstOnMessage = ((IHintedType)UMLElementTypes.DurationConstraint_3023).getSemanticHint();
		String durObsOnMessage = ((IHintedType)UMLElementTypes.DurationObservation_3024).getSemanticHint();
		return durCstOnLifelineHint.equals(requestHint) || durCstOnMessage.equals(requestHint) || durObsOnMessage.equals(requestHint);
	}

}
