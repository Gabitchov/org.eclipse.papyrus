/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.stereotype.edition.editpart;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableCompartmentEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.diagram.ui.internal.figures.NestedResizableCompartmentFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.ResizeableListCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.DuplicatePasteEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.figure.node.AppliedStereotypeCompartmentFigure;
import org.eclipse.papyrus.uml.diagram.stereotype.edition.editpolicies.AppliedStereotypePropertiesEditPolicy;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * this compartment is the an editpart associated to an applied stereotype
 */

public class AppliedStereotypeConpartmentEditPart extends ResizeableListCompartmentEditPart{

	public static String ID="AppliedStereotypeCompartement";

	public AppliedStereotypeConpartmentEditPart(View view) {
		super(view);
	}

	protected boolean hasModelChildrenChanged(Notification evt) {
		return false;
	}

	public String getCompartmentName() {

		Stereotype stereotype=UMLUtil.getStereotype(this.resolveSemanticElement());
		if(stereotype!=null){
			return ""+String.valueOf("\u00AB")+stereotype.getName()+ String.valueOf("\u00BB");
		}
		return "bad compartement stereotype";
	}


	/** 
	 * this method has bee rewritten in order to add its wn figure to ensure to mange it 
	 * in papyrus Figure.
	 * 
	 * Adds a constrained flow layout algorithm to the content pane of compartment figure
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
	 */
	public IFigure createFigure() {
		ResizableCompartmentFigure rcf;
		if (getParent() == getTopGraphicEditPart()){
			//replace ResizableCompartmentFigure by it own figure in order to manage it.
			rcf = new AppliedStereotypeCompartmentFigure(getCompartmentName(), getMapMode());
		} else {
			rcf = new NestedResizableCompartmentFigure(getMapMode());

		}
		if( this.getParent() instanceof AppliedStereotypesCommentEditPart){
			rcf.setBorder(null);
			if(rcf.getTextPane().getChildren().size()>0 &&rcf.getTextPane().getChildren().get(0) instanceof WrappingLabel){
				WrappingLabel label=(WrappingLabel)rcf.getTextPane().getChildren().get(0);
				label.setAlignment(PositionConstants.LEFT);
			}
		}
		ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
		layout.setStretchMajorAxis(false);
		layout.setStretchMinorAxis(false);
		layout.setMinorAlignment(ConstrainedToolbarLayout.ALIGN_TOPLEFT);
		rcf.getContentPane().setLayoutManager(layout);


		return rcf;
	}


	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ListCompartmentEditPart#createDefaultEditPolicies()
	 *
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new ResizableCompartmentEditPolicy());
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
		installEditPolicy(DuplicatePasteEditPolicy.PASTE_ROLE, new DuplicatePasteEditPolicy());
		installEditPolicy(AppliedStereotypePropertiesEditPolicy.APPLIED_STEREOTYPE_VISIBILITY_COMPARTMENT, new AppliedStereotypePropertiesEditPolicy());

	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ResizableCompartmentEditPart#setRatio(java.lang.Double)
	 *
	 * @param ratio
	 */
	protected void setRatio(Double ratio) {
		if(getFigure().getParent().getLayoutManager() instanceof ConstrainedToolbarLayout) {
			super.setRatio(ratio);
		}
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.editpart.ResizeableListCompartmentEditPart#handleNotificationEvent(org.eclipse.emf.common.notify.Notification)
	 *
	 * @param notification
	 */
	protected void handleNotificationEvent(Notification notification) {
		Object feature = notification.getFeature();
		if(NotationPackage.eINSTANCE.getSize_Width().equals(feature) || NotationPackage.eINSTANCE.getSize_Height().equals(feature) || NotationPackage.eINSTANCE.getLocation_X().equals(feature) || NotationPackage.eINSTANCE.getLocation_Y().equals(feature)) {
			refreshBounds();
		}
		super.handleNotificationEvent(notification);
	}

	protected void refreshBounds() {
		int width = ((GraphicalEditPart)getParent()).getFigure().getBounds().getSize().width;
		int height = 20;
		Dimension size = new Dimension(width, height);
		Point loc = new Point(10,10 );
		//((GraphicalEditPart)getParent()).setLayoutConstraint(this, getFigure(), new Rectangle(loc, size));
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.editpart.ResizeableListCompartmentEditPart#refreshVisuals()
	 *
	 */
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshBounds();
	}
}
