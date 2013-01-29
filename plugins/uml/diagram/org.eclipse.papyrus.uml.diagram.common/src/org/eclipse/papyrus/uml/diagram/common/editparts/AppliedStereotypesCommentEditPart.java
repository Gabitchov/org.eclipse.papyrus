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
package org.eclipse.papyrus.uml.diagram.common.editparts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IPrimaryEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.NodeEditPart;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.ServiceUtilsForEditPart;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeCompartmentForCommentShapeEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.CommentShapeForAppliedStereotypeEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.figure.node.CornerBentFigure;

/**
 * The Applied StereotypeCommentEdipart and the appliedStereotypeCommentLinkEditPart are connected to the semantic element.
 * Thanks to this, if the semantic element is deleted the comment will be also deleted.
 * The Applied StereotypeCommentEdipart will be contains eannotation about stereotype application exactly as the editpart
 * that represents the semantic element. In this manner, it is possible to reuse mechanism of stereotype edition.
 * To ensure the creation of the comment and the synchronization of eannotation information from the Semantic editpart
 * an editpolicy will be added: the AppliedStereotypeCommentEditPolicy.
 * 
 */

public class AppliedStereotypesCommentEditPart extends NodeEditPart implements IGraphicalEditPart, IPrimaryEditPart {

	public AppliedStereotypesCommentEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected IFigure contentPane;

	@Override
	protected void createDefaultEditPolicies() {
		// TODO Auto-generated method stub
		super.createDefaultEditPolicies();
		installEditPolicy("AppliedStereotypeCompartment", new AppliedStereotypeCompartmentForCommentShapeEditPolicy());
		installEditPolicy("AutomaticDeletionIfEmpty", new CommentShapeForAppliedStereotypeEditPolicy());
	}

	/**
	 * @generated
	 */
	public static final String ID = "AppliedStereotypesComment";

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */
	@Override
	protected NodeFigure createMainFigure() {
		NodeFigure figure = createNodePlate();
		figure.setLayoutManager(new StackLayout());
		IFigure shape = createNodeShape();
		figure.add(shape);
		contentPane = setupContentPane(shape);
		return figure;
	}

	@Override
	public String toString() {
		//return super.toString();
		ILabelProvider labelProvider;
		try {
			labelProvider = ServiceUtilsForEditPart.getInstance().getService(LabelProviderService.class, this).getLabelProvider();
		} catch (ServiceException ex) {
			labelProvider = new LabelProvider();
		}
		return "Applied Stereotypes Set of " + labelProvider.getText((resolveSemanticElement()));
	}



	/**
	 * @generated
	 */
	@Override
	public IFigure getContentPane() {
		if(contentPane != null) {
			return contentPane;
		}
		return super.getContentPane();
	}


	/**
	 * @generated
	 */
	@Override
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		return getContentPane();
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(100, 50);
		return result;
	}

	/**
	 * Default implementation treats passed figure as content pane.
	 * Respects layout one may have set for generated figure.
	 * 
	 * @param nodeShape
	 *        instance of generated figure class
	 * @generated
	 */
	protected IFigure setupContentPane(IFigure nodeShape) {
		if(nodeShape.getLayoutManager() == null) {
			ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
			layout.setSpacing(0);
			nodeShape.setLayoutManager(layout);
		}
		return nodeShape; // use nodeShape itself as contentPane
	}

	/**
	 * @generated
	 */
	protected IFigure primaryShape;

	/**
	 * @generated
	 */
	protected IFigure createNodeShape() {
		primaryShape = new CornerBentFigure();
		return primaryShape;
	}

	/**
	 * @generated
	 */
	@Override
	public CornerBentFigure getPrimaryShape() {
		return (CornerBentFigure)primaryShape;
	}


}
