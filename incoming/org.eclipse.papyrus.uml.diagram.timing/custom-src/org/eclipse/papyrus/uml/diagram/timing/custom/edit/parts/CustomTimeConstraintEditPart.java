/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.edit.parts;

import org.eclipse.gef.DragTracker;
import org.eclipse.gef.Request;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.timing.custom.edit.policies.ExternalLabelPrimaryDragRoleEditPolicy;
import org.eclipse.papyrus.uml.diagram.timing.custom.edit.policies.LayoutEditPolicyForLabel;
import org.eclipse.papyrus.uml.diagram.timing.custom.parts.NoScrollNoBorderDragEditPartsTracker;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.TimeConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.TimeConstraintSpecificationEditPart;

public class CustomTimeConstraintEditPart extends TimeConstraintEditPart {

	public CustomTimeConstraintEditPart(final View view) {
		super(view);
	}

	/**
	 * The drag tracker has been specialized in order to constrain movement inside its container without scroll bar
	 * 
	 * @see http://wiki.eclipse.org/Papyrus_Developer_Guide/NoScrollbar
	 */
	@Override
	public DragTracker getDragTracker(final Request request) {
		return new NoScrollNoBorderDragEditPartsTracker(this);
	}

	/** Use {@link ExternalLabelPrimaryDragRoleEditPolicy} to display a link while dragging */
	@Override
	protected LayoutEditPolicy createLayoutEditPolicy() {
		return new LayoutEditPolicyForLabel(TimeConstraintSpecificationEditPart.VISUAL_ID);
	}
}
