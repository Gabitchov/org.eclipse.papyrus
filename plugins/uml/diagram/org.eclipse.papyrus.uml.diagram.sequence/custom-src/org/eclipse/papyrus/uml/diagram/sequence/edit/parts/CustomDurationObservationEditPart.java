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
package org.eclipse.papyrus.uml.diagram.sequence.edit.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.IBorderItemLocator;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.locator.ExternalLabelPositionLocator;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.CustomConnectionHandleEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.CustomExternalLabelPrimaryDragRoleEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.DeleteTimeElementWithoutEventPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.semantic.CustomDurationObservationItemSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLVisualIDRegistry;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CustomDurationObservationEditPart extends DurationObservationEditPart {

	/**
	 * Constructor.
	 * 
	 * @param view
	 */
	public CustomDurationObservationEditPart(View view) {
		super(view);
	}

	/**
	 * @Override
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomDurationObservationItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CONNECTION_HANDLES_ROLE, new CustomConnectionHandleEditPolicy());
		removeEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
		removeEditPolicy(DeleteTimeElementWithoutEventPolicy.KEY);
	}

	/**
	 * Make sure bounds are also refreshed.
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#refresh()
	 * @Override
	 */
	@Override
	public void refresh() {
		super.refresh();
		refreshBounds();
	}

	/**
	 * @Override use ExternalLabelPrimaryDragRoleEditPolicy
	 */
	@Override
	protected LayoutEditPolicy createLayoutEditPolicy() {
		org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

			@Override
			protected org.eclipse.gef.EditPolicy createChildEditPolicy(EditPart child) {
				View childView = (View)child.getModel();
				switch(UMLVisualIDRegistry.getVisualID(childView)) {
				case DurationObservationAppliedStereotypeEditPart.VISUAL_ID:
					// use ExternalLabelPrimaryDragRoleEditPolicy
					return new CustomExternalLabelPrimaryDragRoleEditPolicy();
				}
				org.eclipse.gef.EditPolicy result = child.getEditPolicy(org.eclipse.gef.EditPolicy.PRIMARY_DRAG_ROLE);
				if(result == null) {
					result = new NonResizableEditPolicy();
				}
				return result;
			}

			@Override
			protected Command getMoveChildrenCommand(Request request) {
				return null;
			}

			@Override
			protected Command getCreateCommand(CreateRequest request) {
				return null;
			}
		};
		return lep;
	}

	/**
	 * @Override use ExternalLabelPositionLocator
	 */
	@Override
	protected void addBorderItem(IFigure borderItemContainer, IBorderItemEditPart borderItemEditPart) {
		if(borderItemEditPart instanceof DurationObservationAppliedStereotypeEditPart) {
			//use ExternalLabelPositionLocator
			IBorderItemLocator locator = new ExternalLabelPositionLocator(getMainFigure());
			borderItemContainer.add(borderItemEditPart.getFigure(), locator);
		} else {
			super.addBorderItem(borderItemContainer, borderItemEditPart);
		}
	}

	/**
	 * @Override use correct minimum size
	 */
	@Override
	protected NodeFigure createNodePlate() {
		// use correct minimum size
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(-1, -1);
		//String prefElementId = "DurationObservation";
		//IPreferenceStore store = UMLDiagramEditorPlugin.getInstance().getPreferenceStore();
		//String preferenceConstantWitdh = PreferenceInitializerForElementHelper.getpreferenceKey(getNotationView(), prefElementId, PreferencesConstantsHelper.WIDTH);
		//String preferenceConstantHeight = PreferenceInitializerForElementHelper.getpreferenceKey(getNotationView(), prefElementId, PreferencesConstantsHelper.HEIGHT);
		//DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(store.getInt(preferenceConstantWitdh), store.getInt(preferenceConstantHeight));
		return result;
	}

	@Override
	protected IFigure createNodeShape() {
		return primaryShape = new CustomDurationObservationConstraint();
	}

	public class CustomDurationObservationConstraint extends DurationObservationConstraint {

		/**
		 * @see org.eclipse.papyrus.uml.diagram.sequence.edit.parts.DurationObservationEditPart.DurationObservationConstraint#getDurationLabel()
		 * 
		 * @return
		 */
		@Override
		public WrappingLabel getDurationLabel() {
			return this;
		}
	}
}
