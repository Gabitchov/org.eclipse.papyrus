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
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.command;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.GeneralOrderingCreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.UMLBaseItemSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceRequestConstant;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceUtil;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.OccurrenceSpecification;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CustomGeneralOrderingCreateCommand extends GeneralOrderingCreateCommand {

	protected final EObject source;

	protected final EObject target;

	protected InteractionFragment container;

	/**
	 * Non generated, completely redefined to find correct ends and correct container
	 * 
	 * @Override find source and target events and container
	 */
	public CustomGeneralOrderingCreateCommand(CreateRelationshipRequest request, EObject source, EObject target) {
		super(request, source, target);
		// check source occurrence specification
		List<OccurrenceSpecification> possibleSourceOcc = null;
		if(getRequest().getParameters().containsKey(SequenceRequestConstant.NEAREST_OCCURRENCE_SPECIFICATION)) {
			Object paramOccurrence1 = getRequest().getParameter(SequenceRequestConstant.NEAREST_OCCURRENCE_SPECIFICATION);
			List<OccurrenceSpecification> occ1List = SequenceUtil.getAsOccSpecList(paramOccurrence1);
			possibleSourceOcc = occ1List;
		}
		// check target occurrence specification
		List<OccurrenceSpecification> possibleTargetOcc = null;
		if(getRequest().getParameters().containsKey(SequenceRequestConstant.NEAREST_OCCURRENCE_SPECIFICATION_2)) {
			Object paramOccurrence2 = getRequest().getParameter(SequenceRequestConstant.NEAREST_OCCURRENCE_SPECIFICATION_2);
			List<OccurrenceSpecification> occ2List = SequenceUtil.getAsOccSpecList(paramOccurrence2);
			possibleTargetOcc = occ2List;
		}
		// disable duration constraint on a same event
		if(possibleSourceOcc != null && !possibleSourceOcc.isEmpty()) {
			this.source = possibleSourceOcc.get(0);
		} else {
			this.source = null;
		}
		if(possibleTargetOcc != null && !possibleTargetOcc.isEmpty() && Collections.disjoint(possibleSourceOcc, possibleTargetOcc)) {
			this.target = possibleTargetOcc.get(0);
		} else {
			// set invalid target to disable it (or null to enable in case second end is not defined)
			this.target = target;
		}
		container = deduceContainer(source, target);
	}

	public boolean canExecute() {
		if(source == null && target == null) {
			return false;
		}
		if(source != null && false == source instanceof OccurrenceSpecification) {
			return false;
		}
		if(target != null && false == target instanceof OccurrenceSpecification) {
			return false;
		}
		if(getSource() == null) {
			return true; // link creation is in progress; source is not defined yet
		}
		// target may be null here but it's possible to check constraint
		if(getContainer() == null) {
			return false;
		}
		return UMLBaseItemSemanticEditPolicy.getLinkConstraints().canCreateGeneralOrdering_4012(getContainer(), getSource(), getTarget());
	}

	protected OccurrenceSpecification getSource() {
		return (OccurrenceSpecification)source;
	}

	protected OccurrenceSpecification getTarget() {
		return (OccurrenceSpecification)target;
	}

	public InteractionFragment getContainer() {
		return container;
	}
}
