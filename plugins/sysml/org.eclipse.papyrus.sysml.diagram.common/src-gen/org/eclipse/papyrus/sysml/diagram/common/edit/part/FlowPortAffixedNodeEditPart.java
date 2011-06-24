/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.common.edit.part;

import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.handles.MoveHandle;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.IBorderItemLocator;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.editpolicies.ShowHideLabelEditPolicy;
import org.eclipse.papyrus.diagram.common.locator.ExternalLabelPositionLocator;
import org.eclipse.papyrus.gmf.diagram.common.edit.policy.ExternalLabelPrimaryDragRoleEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.edit.part.AbstractElementBorderEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.NamedElementAffixedLabelNameEditPart;
import org.eclipse.papyrus.uml.diagram.common.utils.UMLGraphicalTypes;

public class FlowPortAffixedNodeEditPart extends AbstractElementBorderEditPart {

	public FlowPortAffixedNodeEditPart(View view) {
		super(view);
	}

	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(ShowHideLabelEditPolicy.SHOW_HIDE_LABEL_ROLE, new ShowHideLabelEditPolicy());

		// Start of user code custom policies	
		// End of user code		
	}

	@Override
	protected LayoutEditPolicy createLayoutEditPolicy() {
		org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				View childView = (View)child.getModel();
				String childGraphicalType = childView.getType();

				if(UMLGraphicalTypes.AFFIXEDLABEL_UML_NAMEDELEMENT_NAME_ID.equals(childGraphicalType)) {
					return new ExternalLabelPrimaryDragRoleEditPolicy() {

						protected List createSelectionHandles() {
							MoveHandle mh = new MoveHandle((GraphicalEditPart)getHost());
							mh.setBorder(null);
							return Collections.singletonList(mh);
						}
					};
				}
				EditPolicy result = child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
				if(result == null) {
					result = new NonResizableEditPolicy();
				}
				return result;
			}

			protected Command getMoveChildrenCommand(Request request) {
				return null;
			}

			protected Command getCreateCommand(CreateRequest request) {
				return null;
			}
		};
		return lep;
	}

	@Override
	protected void addBorderItem(IFigure borderItemContainer, IBorderItemEditPart borderItemEditPart) {
		if(borderItemEditPart instanceof NamedElementAffixedLabelNameEditPart) {
			IBorderItemLocator locator = new ExternalLabelPositionLocator(getMainFigure());
			borderItemContainer.add(borderItemEditPart.getFigure(), locator);
			return;
		}
	}

	@Override
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(UMLGraphicalTypes.AFFIXEDLABEL_UML_NAMEDELEMENT_NAME_ID);
	}
}
