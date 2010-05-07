/*****************************************************************************
 * Copyright (c) 2009 CEA
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
package org.eclipse.papyrus.diagram.sequence.edit.parts;

import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ListCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.editpolicies.DuplicatePasteEditPolicy;
import org.eclipse.papyrus.diagram.sequence.edit.policies.CombinedFragmentCombinedFragmentCompartmentItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.sequence.part.Messages;

/**
 * @generated
 */
public class CombinedFragmentCombinedFragmentCompartmentEditPart extends ListCompartmentEditPart {

	/**
	 * Children string for notification event type.
	 */
	private static final String CHILDREN_TYPE = "children";

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 7004;

	/**
	 * @generated
	 */
	public CombinedFragmentCombinedFragmentCompartmentEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected boolean hasModelChildrenChanged(Notification evt) {
		return false;
	}

	/**
	 * @generated
	 */
	public String getCompartmentName() {
		return Messages.CombinedFragmentCombinedFragmentCompartmentEditPart_title;
	}

	/**
	 * Not generated for delete borders add stretch children figures.
	 * 
	 * @generated NOT
	 */
	public IFigure createFigure() {
		ResizableCompartmentFigure result = (ResizableCompartmentFigure)super.createFigure();
		result.setTitleVisibility(false);
		result.setBorder(null);
		IFigure contentPane = result.getContentPane();
		if(contentPane != null) {
			contentPane.setBorder(null);
			LayoutManager layout = contentPane.getLayoutManager();
			if(layout instanceof ConstrainedToolbarLayout) {
				ConstrainedToolbarLayout constrainedToolbarLayout = (ConstrainedToolbarLayout)layout;
				constrainedToolbarLayout.setStretchMajorAxis(true);
				constrainedToolbarLayout.setStretchMinorAxis(true);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CombinedFragmentCombinedFragmentCompartmentItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
		installEditPolicy(DuplicatePasteEditPolicy.PASTE_ROLE, new DuplicatePasteEditPolicy());


		//in Papyrus diagrams are not strongly synchronised
		//installEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CANONICAL_ROLE, new org.eclipse.papyrus.diagram.sequence.edit.policies.CombinedFragmentCombinedFragmentCompartmentCanonicalEditPolicy());

	}

	/**
	 * Not generated for handle the first InteractionOperand case (no LineSeparator) {@inheritDoc}
	 * 
	 * @generataed NOT
	 */
	@Override
	protected EditPart createChild(Object model) {
		EditPart child = super.createChild(model);
		if(getChildren() == null || getChildren().isEmpty() && child instanceof InteractionOperandEditPart) {
			((InteractionOperandEditPart)child).setFirstOperand(true);
		}
		return child;
	}

	/**
	 * @generated
	 */
	protected void setRatio(Double ratio) {
		if(getFigure().getParent().getLayoutManager() instanceof ConstrainedToolbarLayout) {
			super.setRatio(ratio);
		}
	}

	/**
	 * Handle the first InteractionOperand deletion case (change FirstOperand attribute)
	 */
	@Override
	protected void handleNotificationEvent(Notification event) {
		Object feature = event.getFeature();

		if(feature instanceof EStructuralFeature) {
			EStructuralFeature ref = (EStructuralFeature)feature;
			String typeName = ref.getName();
			if(CHILDREN_TYPE.equals(typeName)) {
				if(event.getEventType() == Notification.UNSET || event.getEventType() == Notification.REMOVE) {
					List<?> children = getChildren();
					if(children != null && children.size() > 1) {
						Object firstChild = children.get(0);
						if(firstChild instanceof InteractionOperandEditPart) {
							InteractionOperandEditPart firstOperandChild = (InteractionOperandEditPart)firstChild;
							Object firstChildModel = firstOperandChild.getModel();
							if(firstChildModel != null && firstChildModel.equals(event.getOldValue())) {
								InteractionOperandEditPart secondOperandChild = (InteractionOperandEditPart)children.get(1);
								secondOperandChild.setFirstOperand(true);
							}
						}
					}
				}
			}
		}
		super.handleNotificationEvent(event);
	}

	/**
	 * @generated
	 */
	protected void refreshBounds() {
		int width = ((Integer)getStructuralFeatureValue(NotationPackage.eINSTANCE.getSize_Width())).intValue();
		int height = ((Integer)getStructuralFeatureValue(NotationPackage.eINSTANCE.getSize_Height())).intValue();
		Dimension size = new Dimension(width, height);
		int x = ((Integer)getStructuralFeatureValue(NotationPackage.eINSTANCE.getLocation_X())).intValue();
		int y = ((Integer)getStructuralFeatureValue(NotationPackage.eINSTANCE.getLocation_Y())).intValue();
		Point loc = new Point(x, y);
		((GraphicalEditPart)getParent()).setLayoutConstraint(this, getFigure(), new Rectangle(loc, size));
	}

	/**
	 * @generated
	 */
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshBounds();
	}

}
