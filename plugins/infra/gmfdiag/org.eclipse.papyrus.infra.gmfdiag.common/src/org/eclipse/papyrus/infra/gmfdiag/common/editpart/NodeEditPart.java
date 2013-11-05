/*****************************************************************************
 * Copyright (c) 2008-2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Style implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.editpart;

import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.BooleanValueStyle;
import org.eclipse.gmf.runtime.notation.FillStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.datatype.GradientData;
import org.eclipse.papyrus.infra.emf.appearance.helper.AppearanceHelper;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.BorderDisplayEditPolicy;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.FollowSVGSymbolEditPolicy;
import org.eclipse.papyrus.infra.gmfdiag.common.figure.node.IPapyrusNodeFigure;
import org.eclipse.papyrus.infra.gmfdiag.common.figure.node.SVGNodePlateFigure;
import org.eclipse.papyrus.infra.gmfdiag.common.service.shape.ShapeService;
import org.eclipse.swt.graphics.Color;
import org.w3c.dom.svg.SVGDocument;

/**
 * this edit part can refresh shadow and gradient.
 */
public abstract class NodeEditPart extends AbstractBorderedShapeEditPart implements IPapyrusEditPart {

	private SVGNodePlateFigure svgNodePlate;

	protected IFigure shape;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param view
	 */
	public NodeEditPart(View view) {
		super(view);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected NodeFigure createMainFigure() {
		return createNodeFigure();
	}

	protected void refreshSVGPath() {
		View view = getNotationView();
		if(svgNodePlate != null) {
			BooleanValueStyle followStyle = (BooleanValueStyle)view.getNamedStyle(NotationPackage.eINSTANCE.getBooleanValueStyle(), FollowSVGSymbolEditPolicy.FOLLOW_SVG_SYMBOL);
			if(followStyle != null && followStyle.isBooleanValue()) {
				if(ShapeService.getInstance().hasShapeToDisplay(getNotationView())) {
					List<SVGDocument> svgToDisplay = ShapeService.getInstance().getSVGDocumentToDisplay(getNotationView());
					int documentNumber = svgToDisplay.size();
					SVGDocument svgdoc = null;
					if(documentNumber > 0) {
						svgdoc = svgToDisplay.get(documentNumber - 1);
					}

					svgNodePlate.setSVGDocument(svgdoc);
				} else {
					svgNodePlate.setSVGDocument(null);
				}
			} else {
				svgNodePlate.setSVGDocument(null);
			}
		}
	}

	/**
	 * <p>
	 * Returns the primary shape being the View of this edit part.
	 * </p>
	 * <b>Warning</b> It should never return <code>null</code>
	 * 
	 * @return the primary shape associated to this edit part.
	 */
	@Override
	public abstract IPapyrusNodeFigure getPrimaryShape();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean supportsGradient() {
		return true;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	protected void handleNotificationEvent(Notification event) {
		super.handleNotificationEvent(event);

		// Update the figure when the line width changes
		Object feature = event.getFeature();
		if((getModel() != null) && (getModel() == event.getNotifier())) {
			if(NotationPackage.eINSTANCE.getLineStyle_LineWidth().equals(feature)) {
				refreshLineWidth();
			} else if(NotationPackage.eINSTANCE.getLineTypeStyle_LineType().equals(feature)) {
				refreshLineType();
			}
		}

		// set the figure active when the feature of the of a class is true
		if(resolveSemanticElement() != null) {
			refreshShadow();
		}
	}

	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshShadow();
		refreshLineType();
		refreshLineWidth();
		refreshTransparency();
	}

	@Override
	protected void setLineWidth(int width) {
		if(width < 0) {
			width = 1;
		}
		getPrimaryShape().setLineWidth(width);
	}

	@Override
	protected void setLineType(int style) {
		getPrimaryShape().setLineStyle(style);
	}

	/**
	 * Override to set the transparency to the correct figure
	 */
	@Override
	protected void setTransparency(int transp) {
		getPrimaryShape().setTransparency(transp);
	}

	/**
	 * sets the back ground color of this edit part
	 * 
	 * @param color
	 *        the new value of the back ground color
	 */
	@Override
	protected void setBackgroundColor(Color color) {
		getPrimaryShape().setBackgroundColor(color);
		getPrimaryShape().setIsUsingGradient(false);
		getPrimaryShape().setGradientData(-1, -1, 0);
	}

	/**
	 * Override to set the gradient data to the correct figure
	 */
	@Override
	protected void setGradient(GradientData gradient) {
		IPapyrusNodeFigure fig = getPrimaryShape();
		FillStyle style = (FillStyle)getPrimaryView().getStyle(NotationPackage.Literals.FILL_STYLE);
		if(gradient != null) {
			fig.setIsUsingGradient(true);;
			fig.setGradientData(style.getFillColor(), gradient.getGradientColor1(), gradient.getGradientStyle());
		} else {
			fig.setIsUsingGradient(false);
		}
	}

	/**
	 * sets the font color
	 * 
	 * @param color
	 *        the new value of the font color
	 */
	@Override
	protected void setFontColor(Color color) {
		// NULL implementation
	}

	/**
	 * sets the fore ground color of this edit part's figure
	 * 
	 * @param color
	 *        the new value of the foregroundcolor
	 */
	@Override
	protected void setForegroundColor(Color color) {
		getPrimaryShape().setForegroundColor(color);
	}

	/**
	 * Refresh the shadow of the figure
	 */
	protected final void refreshShadow() {
		getPrimaryShape().setShadow(AppearanceHelper.showShadow((View)getModel()));
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(BorderDisplayEditPolicy.BORDER_DISPLAY_EDITPOLICY, new BorderDisplayEditPolicy());
	}

	/**
	 * 
	 * @return the figure that represent the shape, this class is generated by the GMF tooling
	 */
	protected abstract IFigure createNodePlate();

	/**
	 * 
	 * @return the figure that represent the shape, this class is generated by the GMF tooling
	 */
	protected abstract IFigure createNodeShape();

	/**
	 * this method installs the content pane in the node shape to add compartment for example
	 * 
	 * @param nodeShape
	 * @return the figure that is the the node shape
	 */
	protected abstract IFigure setupContentPane(IFigure nodeShape);


	/**
	 * Now the method create node plate is not used,
	 * If you want to overlad it you must overload createSVGNodePlate
	 * 
	 * @return the figure that allow following border of shape
	 */
	protected NodeFigure createSVGNodePlate() {

		svgNodePlate = new SVGNodePlateFigure(-1, -1);
		svgNodePlate.setDefaultNodePlate(createNodePlate());
		return svgNodePlate;
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 */
	protected NodeFigure createMainFigureWithSVG() {

		NodeFigure figure = createSVGNodePlate();

		figure.setLayoutManager(new StackLayout());
		shape = createNodeShape();
		figure.add(shape);
		setupContentPane(shape);
		return figure;
	}

	@Override
	public IFigure getContentPane() {
		if(shape != null) {
			IFigure contentPane = setupContentPane(shape);
			return contentPane;
		} else {
			return super.getContentPane();
		}
	}
}
