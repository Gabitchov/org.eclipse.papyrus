/*****************************************************************************
 * Copyright (c) 2011 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos - Initial API and implementation
 *   Arthur Daussy - arthur.daussy@atos.net - Bug 368932 - [ActivitiyDiagram] Prevent Compartment of Activity group to be selected
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.activity.edit.part.ActivityGroup;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ScrollPane;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.activity.activitygroup.editpolicy.ActivityPartitionActivityPartitionContentCompartmentCreationEditPolicy;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityPartitionActivityPartitionContentCompartmentEditPart;

/**
 * Set in order to have Generation Gap Pattern.
 * 
 * @author arthur daussy
 * 
 */
public class CustomActivityPartitionActivityPartitionContentCompartmentEditPart extends ActivityPartitionActivityPartitionContentCompartmentEditPart implements IGroupCompartmentEditPart{

	public CustomActivityPartitionActivityPartitionContentCompartmentEditPart(View view) {
		super(view);
	}

	/**
	 * Unselectable EditPart
	 */
	@Override
	public boolean isSelectable() {
		return false;
	}

	/**
	 * remove the bottom border, remove scrollbars
	 */
	@Override
	public IFigure createFigure() {
		ResizableCompartmentFigure result = (ResizableCompartmentFigure)super.createFigure();
		result.setTitleVisibility(false);
		// remove the top border
		result.setBorder(null);
		// remove scrollbars
		result.getScrollPane().setEnabled(false);
		result.getScrollPane().setHorizontalScrollBar(null);
		result.getScrollPane().setVerticalScrollBar(null);
		result.getScrollPane().setScrollBarVisibility(ScrollPane.NEVER);
		// result.getScrollPane().getViewport().setContentsTracksHeight(true);
		return result;
	}
	

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new ActivityPartitionActivityPartitionContentCompartmentCreationEditPolicy());
	}

}
