/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.edit.parts;

import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.timing.custom.edit.policies.LayoutEditPolicyForLabel;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.GateEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.GateLabelEditPart;

public class CustomGateEditPart extends GateEditPart {

	public CustomGateEditPart(final View view) {
		super(view);
	}

	@Override
	protected NodeFigure createNodePlate() {
		// make it a bit larger than the GateFigure itself in order to make it easier to select
		return new DefaultSizeNodeFigure(10, 10);
	}

	/** Use {@link ExternalLabelPrimaryDragRoleEditPolicy} to display a link while dragging */
	@Override
	protected LayoutEditPolicy createLayoutEditPolicy() {
		return new LayoutEditPolicyForLabel(GateLabelEditPart.VISUAL_ID);
	}
}
