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

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.DelegatingLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.sequence.edit.helpers.AnchorHelper;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.semantic.CustomActionExecutionSpecificationItemSemanticEditPolicy;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CustomActionExecutionSpecificationEditPart extends ActionExecutionSpecificationEditPart {

	/**
	 * Constructor.
	 * 
	 * @param view
	 */
	public CustomActionExecutionSpecificationEditPart(View view) {
		super(view);
	}

	/**
	 * @Override
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomActionExecutionSpecificationItemSemanticEditPolicy());
	}

	/**
	 * Overrides to disable the defaultAnchorArea. The edge is now more stuck with the middle of the
	 * figure.
	 * 
	 * @Override
	 */
	@Override
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(16, 60) {

			/**
			 * @see org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure#isDefaultAnchorArea(org.eclipse.draw2d.geometry.PrecisionPoint)
			 */
			@Override
			protected boolean isDefaultAnchorArea(PrecisionPoint p) {
				return false;
			}

			@Override
			public ConnectionAnchor getConnectionAnchor(String terminal) {
				//Use FixedAnchorEx for MessageSync, this will be invoked by mapConnectionAnchor(termial) operation.
				if(terminal != null && terminal.indexOf("{") != -1 && terminal.indexOf("}") != -1) {
					int position = AnchorHelper.FixedAnchorEx.parsePosition(terminal);
					if(PositionConstants.TOP == position || PositionConstants.BOTTOM == position) {
						return new AnchorHelper.FixedAnchorEx(this, position);
					}
				}
				return super.getConnectionAnchor(terminal);
			}
		};
		result.setMinimumSize(new Dimension(getMapMode().DPtoLP(16), getMapMode().DPtoLP(20))); // min height 20
		return result;
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model so you may safely remove
	 * <i>generated</i> tag and modify it.
	 * 
	 * @Override
	 */
	@Override
	protected NodeFigure createNodeFigure() {
		final NodeFigure figure = createNodePlate();
		figure.setLayoutManager(new DelegatingLayout());
		//figure.setLayoutManager(new StackLayout());
		IFigure shape = createNodeShape();
		figure.add(shape, new FillParentLocator());
		contentPane = setupContentPane(shape);
		return figure;
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ActionExecutionSpecificationEditPart#setLineWidth(int)
	 * 
	 * @param width
	 */
	@Override
	protected void setLineWidth(int width) {
		//		super.setLineWidth(width);
	}
}
