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
package org.eclipse.papyrus.uml.diagram.sequence.edit.policies;

import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeNodeLabelDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;

/**
 * This policy is used to automatically move a lifeline when a stereotype is changed.
 * this avoids the move of the dash line and its ES.
 * 
 * @author mvelten
 * 
 */
public class LifelineAppliedStereotypeNodeLabelDisplayEditPolicy extends AppliedStereotypeNodeLabelDisplayEditPolicy {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void refreshDisplay() {
		super.refreshDisplay();

		if(getHost() instanceof LifelineEditPart) {
			((LifelineEditPart)getHost()).updateLifelinePosition();
		}
	}
}
