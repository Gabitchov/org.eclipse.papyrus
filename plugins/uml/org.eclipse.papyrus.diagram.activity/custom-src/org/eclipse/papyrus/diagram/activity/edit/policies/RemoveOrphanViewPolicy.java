/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.Tessier@cea.fr - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.diagram.activity.edit.policies;

import org.eclipse.papyrus.diagram.activity.edit.parts.ActionLocalPostconditionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActionLocalPreconditionEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityActivityContentCompartmentEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityActivityParametersCompartmentEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityActivityPostConditionsCompartmentEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityActivityPreConditionsCompartmentEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityNameEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityPartitionActivityPartitionContentCompartmentEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ConditionalNodeStructuredActivityNodeContentCompartmentEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ExpansionRegionStructuredActivityNodeContentCompartmentEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.LoopNodeStructuredActivityNodeContentCompartmentEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.SequenceNodeStructuredActivityNodeContentCompartmentEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.StructuredActivityNodeStructuredActivityNodeContentCompartmentEditPart;
import org.eclipse.papyrus.diagram.common.editpolicies.OrphanViewPolicy;

/**
 * this policy is used to suppress orphan node view in GMF view the policy to remove orphan
 * connection is more complex. It is dependent of the diagram. see remove OrphanConnectionView
 * policy
 * 
 */
public class RemoveOrphanViewPolicy extends OrphanViewPolicy {

	public int[] notOrphanNode = { ActivityNameEditPart.VISUAL_ID, ActionLocalPreconditionEditPart.VISUAL_ID, ActionLocalPostconditionEditPart.VISUAL_ID, ActivityEditPart.VISUAL_ID, ActivityActivityContentCompartmentEditPart.VISUAL_ID, ActivityActivityParametersCompartmentEditPart.VISUAL_ID, ActivityActivityPreConditionsCompartmentEditPart.VISUAL_ID, ActivityActivityPostConditionsCompartmentEditPart.VISUAL_ID, ActivityPartitionActivityPartitionContentCompartmentEditPart.VISUAL_ID, InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentEditPart.VISUAL_ID, ConditionalNodeStructuredActivityNodeContentCompartmentEditPart.VISUAL_ID, ExpansionRegionStructuredActivityNodeContentCompartmentEditPart.VISUAL_ID, LoopNodeStructuredActivityNodeContentCompartmentEditPart.VISUAL_ID, SequenceNodeStructuredActivityNodeContentCompartmentEditPart.VISUAL_ID, StructuredActivityNodeStructuredActivityNodeContentCompartmentEditPart.VISUAL_ID };

	public RemoveOrphanViewPolicy() {
		super();
		init(notOrphanNode);
	}

}
