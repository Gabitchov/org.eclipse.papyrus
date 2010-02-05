/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
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
package org.eclipse.papyrus.diagram.activity.edit.policies;

import org.eclipse.papyrus.diagram.activity.edit.parts.ActionInputPinInCallBeActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActionInputPinInCallOpActAsTargetEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActionInputPinInCallOpActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActionInputPinInOpaqueActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinInCallBeActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinInCallOpActAsTargetEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinInCallOpActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InputPinInOpaqueActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OutputPinInCallBeActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OutputPinInCallOpActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.OutputPinInOpaqueActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ValuePinInCallBeActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ValuePinInCallOpActAsTargetEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ValuePinInCallOpActEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ValuePinInOpaqueActEditPart;

/**
 * Edit Policy for managing pin creation from the palette on an action
 */
public class PinCreationEditPolicy extends AutoManagedNodeCreationEditPolicy {

	/**
	 * Detect pin views
	 * 
	 * @see org.eclipse.papyrus.diagram.activity.edit.policies.AutoManagedNodeCreationEditPolicy#isSemanticHintAutoManaged(java.lang.String)
	 * 
	 * @param semanticHint
	 *        the semantic hint of the node being created
	 * @return true if the view kind is for a pin
	 */
	@Override
	protected boolean isSemanticHintAutoManaged(String semanticHint) {
		Integer intHint = new Integer(semanticHint);
		switch(intHint) {
		case InputPinInOpaqueActEditPart.VISUAL_ID:
		case InputPinInCallBeActEditPart.VISUAL_ID:
		case InputPinInCallOpActEditPart.VISUAL_ID:
		case InputPinInCallOpActAsTargetEditPart.VISUAL_ID:
		case ActionInputPinInOpaqueActEditPart.VISUAL_ID:
		case ActionInputPinInCallBeActEditPart.VISUAL_ID:
		case ActionInputPinInCallOpActEditPart.VISUAL_ID:
		case ActionInputPinInCallOpActAsTargetEditPart.VISUAL_ID:
		case ValuePinInOpaqueActEditPart.VISUAL_ID:
		case ValuePinInCallBeActEditPart.VISUAL_ID:
		case ValuePinInCallOpActEditPart.VISUAL_ID:
		case ValuePinInCallOpActAsTargetEditPart.VISUAL_ID:
		case OutputPinInOpaqueActEditPart.VISUAL_ID:
		case OutputPinInCallBeActEditPart.VISUAL_ID:
		case OutputPinInCallOpActEditPart.VISUAL_ID:
			return true;
		default:
			return false;
		}
	}

}
