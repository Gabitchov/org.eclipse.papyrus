/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.Tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.activity.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.ScalablePolygonShape;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.papyrus.infra.gmfdiag.common.figure.node.IPapyrusNodeFigure;
import org.eclipse.papyrus.uml.diagram.activity.draw2d.CenteredColumnConstraint;
import org.eclipse.papyrus.uml.diagram.activity.draw2d.CenteredColumnLayout;
import org.eclipse.papyrus.uml.diagram.common.draw2d.CenterLayout;
import org.eclipse.papyrus.uml.diagram.common.figure.node.CenteredWrappedLabel;
import org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusNodeUMLElementFigure;
import org.eclipse.papyrus.uml.diagram.common.helper.StereotypeFigureHelper;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;


/**
 * add time template, make margin border relative, use StereotypeFigureHelper
 */

public class AcceptEventActionFigure extends ScalablePolygonShape implements IPapyrusNodeUMLElementFigure, IPapyrusNodeFigure {

	/**
	 * this label is internal to the figure and represents the name of the acceptEventAction
	 */
	private CenteredWrappedLabel fAcceptEventActionLabel;

	private final Insets marginTemplate;

	/** The helper which handles stereotype aspects */
	private StereotypeFigureHelper stereotypeHelper;

	public AcceptEventActionFigure() {
		CenteredColumnLayout layoutThis = new CenteredColumnLayout();
		this.setLayoutManager(layoutThis);
		this.addPoint(new Point(0, 0));
		this.addPoint(new Point(200, 0));
		this.addPoint(new Point(200, 50));
		this.addPoint(new Point(0, 50));
		this.addPoint(new Point(50, 25));
		// add time template
		this.addTimePoint(new Point(0, 0));
		this.addTimePoint(new Point(100, 0));
		this.addTimePoint(new Point(50, 25));
		this.addTimePoint(new Point(100, 50));
		this.addTimePoint(new Point(0, 50));
		this.addTimePoint(new Point(50, 25));
		this.setFill(true);
		this.setLineWidth(1);
		// make margin border relative
		marginTemplate = new Insets(0, 50, 0, 0);
		this.setBorder(new MarginBorder(marginTemplate));
		createContents();
		// use StereotypeFigureHelper
		stereotypeHelper = new StereotypeFigureHelper(this) {

			@Override
			public Object getStereotypeRectangleConstraint() {
				CenteredColumnConstraint constraintStereotypeRect0 = new CenteredColumnConstraint(false);
				return constraintStereotypeRect0;
			}
		};
	}

	/**
	 * This method is used to create the content into the figure, in our case this is the label of the acceptEventAction
	 */
	private void createContents() {
		RectangleFigure labelRect0 = new RectangleFigure();
		labelRect0.setFill(false);
		labelRect0.setOutline(false);
		labelRect0.setLineWidth(1);
		// use CenteredColumnConstraint
		CenteredColumnConstraint constraintLabelRect0 = new CenteredColumnConstraint(true);
		this.add(labelRect0, constraintLabelRect0);
		CenterLayout layoutLabelRect0 = new CenterLayout();
		labelRect0.setLayoutManager(layoutLabelRect0);
		fAcceptEventActionLabel = new CenteredWrappedLabel();
		//fAcceptEventActionLabel.setBorder(new MarginBorder(5, 5, 5, 5));
		labelRect0.add(fAcceptEventActionLabel);
	}


	private final PointList myTemplate = new PointList();


	private Rectangle myTemplateBounds;


	@Override
	public void addPoint(Point point) {
		myTemplate.addPoint(point);
		myTemplateBounds = null;
	}

	/**
	 * Refresh the layout of the figure
	 */
	protected void refreshLayout() {
	}

	/** The value to display as stereotype display when available */
	String stereotypeDisplayText = null;

	/** The value to display as stereotype display when available */
	Image stereotypeDisplayImg = null;

	/**
	 * Sets the stereotypes for this figure.
	 *
	 * @param stereotypes
	 *        the string representing the stereotypes to be displayed
	 * @param image
	 *        the image representing the stereotypes to be displayed
	 * @see org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusUMLElementFigure#setStereotypeDisplay(java.lang.String,
	 *      org.eclipse.swt.graphics.Image)
	 */
	@Override
	public void setStereotypeDisplay(String stereotypes, Image image) {
		if(!isTemplateForAcceptTimeEventActionUsed()) {
			stereotypeHelper.setStereotypeDisplay(stereotypes, image);
			refreshLayout();
		}
		// record values in case figure changes
		stereotypeDisplayText = stereotypes;
		stereotypeDisplayImg = image;
	}

	/** The value to display as stereotype in brace when available */
	String stereotypePropertiesInBrace = null;

	/**
	 * Sets the stereotypes properties for this figure.
	 *
	 * @param stereotypeProperties
	 *        the string representing the stereotype properties to be displayed
	 */
	@Override
	public void setStereotypePropertiesInBrace(String stereotypeProperties) {
		if(!isTemplateForAcceptTimeEventActionUsed()) {
			stereotypeHelper.setStereotypePropertiesInBrace(stereotypeProperties);
			refreshLayout();
		}
		// record values in case figure changes
		stereotypePropertiesInBrace = stereotypeProperties;
	}

	/** The value to display as stereotype in brace when available */
	String stereotypePropertiesInCompartment = null;

	/**
	 * displays the new string corresponding to the list of stereotypes.
	 *
	 * @param stereotypeProperties
	 *        the string to be displayed.
	 */
	@Override
	public void setStereotypePropertiesInCompartment(String stereotypeProperties) {
		if(!isTemplateForAcceptTimeEventActionUsed()) {
			stereotypeHelper.setStereotypePropertiesInCompartment(stereotypeProperties);
			refreshLayout();
		}
		// record values in case figure changes
		stereotypePropertiesInCompartment = stereotypeProperties;
	}

	/**
	 * Gets the stereotype label.
	 *
	 * @return the stereotype label
	 * @unused
	 * @deprecated
	 */
	@Override
	@Deprecated
	public Label getStereotypesLabel() {
		return null;//fActionStereotypeLabel;
	}

	/**
	 * @generated
	 */
	private final PointList myTemplateTime = new PointList();

	/**
	 * @generated
	 */
	private boolean useTemplateTime = false;

	/**
	 * Set whether the figure must use the classic concave pentagon template for AcceptEventAction or the hourglass template for
	 * AcceptTimeEventAction
	 *
	 * @param useAcceptTimeEventActionTemplate
	 *        true if the hourglass template must be used, false for default template
	 */
	public void useTemplateForAcceptTimeEventAction(boolean useAcceptTimeEventActionTemplate) {
		if(useAcceptTimeEventActionTemplate) {
			// erase stereotypes representation in block
			stereotypeHelper.setStereotypeDisplay(null, null);
			stereotypeHelper.setStereotypePropertiesInBrace(null);
			stereotypeHelper.setStereotypePropertiesInCompartment(null);
		} else {
			// restore stereotypes representation in block
			stereotypeHelper.setStereotypeDisplay(stereotypeDisplayText, stereotypeDisplayImg);
			stereotypeHelper.setStereotypePropertiesInBrace(stereotypePropertiesInBrace);
			stereotypeHelper.setStereotypePropertiesInCompartment(stereotypePropertiesInCompartment);
		}
		useTemplateTime = useAcceptTimeEventActionTemplate;
	}

	/**
	 * Ask whether the figure uses the classic concave pentagon template for AcceptEventAction or the hourglass template for
	 * AcceptTimeEventAction
	 *
	 * @return true if the hourglass template is used, false for default template
	 */
	public boolean isTemplateForAcceptTimeEventActionUsed() {
		return useTemplateTime;
	}

	private Rectangle myTemplateTimeBounds;

	public void addTimePoint(Point point) {
		myTemplateTime.addPoint(point);
		myTemplateTimeBounds = null;
	}

	@Override
	protected void fillShape(Graphics graphics) {
		Rectangle bounds = getBounds();
		graphics.pushState();
		graphics.translate(bounds.x, bounds.y);
		graphics.fillPolygon(scalePointList());
		graphics.popState();
		// refresh relative margin
		Insets newInsets = scaleMargin();
		if(!newInsets.equals(getBorder().getInsets(this))) {
			this.setBorder(new MarginBorder(scaleMargin()));
		}
	}

	@Override
	protected void outlineShape(Graphics graphics) {
		Rectangle bounds = getBounds();
		graphics.pushState();
		graphics.translate(bounds.x, bounds.y);
		graphics.setLineWidth(Math.max(1, getLineWidth()));
		graphics.drawPolygon(scalePointList());
		graphics.popState();
	}

	private Insets scaleMargin() {
		Rectangle pointsBounds = getTemplateBounds();
		Rectangle actualBounds = getBounds();
		float xScale = ((float)actualBounds.width) / pointsBounds.width;
		float yScale = ((float)actualBounds.height) / pointsBounds.height;
		if(xScale == 1 && yScale == 1) {
			return marginTemplate;
		}
		Insets scaled = new Insets(marginTemplate);
		scaled.top = (int)Math.floor(scaled.top * yScale);
		scaled.left = (int)Math.floor(scaled.left * xScale);
		scaled.bottom = (int)Math.floor(scaled.bottom * yScale);
		scaled.right = (int)Math.floor(scaled.right * xScale);
		return scaled;
	}

	/**
	 * switch between the two templates
	 */
	private Rectangle getTemplateBounds() {
		if(myTemplateBounds == null) {
			myTemplateBounds = myTemplate.getBounds().getCopy().union(0, 0);
			//just safety -- we are going to use this as divider
			if(myTemplateBounds.width < 1) {
				myTemplateBounds.width = 1;
			}
			if(myTemplateBounds.height < 1) {
				myTemplateBounds.height = 1;
			}
		}
		// switch between the two templates : create the second template bounds
		if(myTemplateTimeBounds == null) {
			myTemplateTimeBounds = myTemplateTime.getBounds().getCopy().union(0, 0);
			//just safety -- we are going to use this as divider
			if(myTemplateTimeBounds.width < 1) {
				myTemplateTimeBounds.width = 1;
			}
			if(myTemplateTimeBounds.height < 1) {
				myTemplateTimeBounds.height = 1;
			}
		}
		// switch between the two templates : choose appropriate one
		if(useTemplateTime) {
			return myTemplateTimeBounds;
		} else {
			return myTemplateBounds;
		}
	}

	private int[] scalePointList() {
		Rectangle pointsBounds = getTemplateBounds();
		Rectangle actualBounds = getBounds();
		float xScale = ((float)actualBounds.width) / pointsBounds.width;
		float yScale = ((float)actualBounds.height) / pointsBounds.height;
		if(xScale == 1 && yScale == 1) {
			// switch between the two templates
			if(useTemplateTime) {
				return myTemplateTime.toIntArray();
			} else {
				return myTemplate.toIntArray();
			}
		}
		// switch between the two templates
		int[] scaled;
		if(useTemplateTime) {
			scaled = myTemplateTime.toIntArray().clone();
		} else {
			scaled = myTemplate.toIntArray().clone();
		}
		for(int i = 0; i < scaled.length; i += 2) {
			scaled[i] = (int)Math.floor(scaled[i] * xScale);
			scaled[i + 1] = (int)Math.floor(scaled[i + 1] * yScale);
		}
		return scaled;
	}

	/**
	 * @generated
	 */
	public CenteredWrappedLabel getAcceptEventActionLabel() {
		return fAcceptEventActionLabel;
	}

	@Override
	public Color getBorderColor() {
		return null;
	}

	@Override
	public boolean isShadow() {
		return false;
	}

	@Override
	public void setBorderColor(Color borderColor) {

	}

	@Override
	public void setShadow(boolean shadow) {

	}

	@Override
	public void setTransparency(int transparency) {

	}

	@Override
	public void setGradientData(int gradientColor1, int gradientColor2, int gradientStyle) {
	}

	@Override
	public void setIsUsingGradient(boolean b) {

	}
}
