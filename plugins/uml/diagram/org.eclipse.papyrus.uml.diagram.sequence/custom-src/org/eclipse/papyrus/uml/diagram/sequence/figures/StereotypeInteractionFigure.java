/*****************************************************************************
 * Copyright (c) 2013 CEA
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
package org.eclipse.papyrus.uml.diagram.sequence.figures;

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.papyrus.uml.diagram.common.draw2d.InteractionFigure;
import org.eclipse.papyrus.uml.diagram.common.draw2d.LeftToolbarLayout;
import org.eclipse.papyrus.uml.diagram.common.figure.node.InteractionRectangleFigure;
import org.eclipse.swt.graphics.Font;


/**
 * This figure allows to display Stereotypes(both single stereotype name and stereotype in brace) on top of the name label.
 * 
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class StereotypeInteractionFigure extends InteractionRectangleFigure {

	/**
	 * Constructor.
	 * 
	 */
	public StereotypeInteractionFigure() {
	}

	/**
	 * Display stereotype on top of the name.
	 * 
	 * Return a RectangleFigure has BorderLayout.
	 */
	protected RectangleFigure createHeader() {
		interactionLabel = new WrappingLabel() {

			public void setFont(Font f) {
				super.setFont(f);
				if(stereotypesLabel != null) {
					stereotypesLabel.setFont(f);
				}
				if(stereotypePropertiesInBraceContent != null) {
					stereotypePropertiesInBraceContent.setFont(f);
				}
			}
		};
		interactionLabel.setAlignment(PositionConstants.CENTER);
		interactionLabel.setBorder(new MarginBorder(1, 1, 3, 3));

		interactionLabelContainer = new InteractionFigure() {

			@Override
			protected void outlineShape(Graphics graphics) {
				Rectangle r = getBounds();

				int labelWidth = -1;

				for(Object obj : getChildren()) {
					if(obj instanceof Label) {//Stereotype labels
						labelWidth = Math.max(labelWidth, ((Label)obj).getPreferredSize().width);
					} else if(obj instanceof WrappingLabel) {
						WrappingLabel wLabel = (WrappingLabel)obj;
						labelWidth = Math.max(labelWidth, wLabel.getPreferredSize().width);
					}
				}

				// case the size of the label is 0 or -1 (no label)
				if(labelWidth <= 0) {
					labelWidth = r.width / 4;
				} else if(labelWidth > r.width) {
					labelWidth = r.width;
				}

				PointList points = new PointList();

				Point verticalStart = new Point();
				Point verticalEnd = new Point();
				Point diagonalStart = new Point();
				Point diagonalEnd = new Point();
				Point horizontalStart = new Point();
				Point horizontalEnd = new Point();

				verticalStart.x = r.x + labelWidth + 15;
				verticalStart.y = r.y;
				points.addPoint(verticalStart);

				verticalEnd.x = verticalStart.x;
				verticalEnd.y = verticalStart.y + r.height / 2 + 3;
				points.addPoint(verticalEnd);

				diagonalStart.x = verticalEnd.x;
				diagonalStart.y = verticalEnd.y;
				points.addPoint(diagonalStart);

				diagonalEnd.x = diagonalStart.x - r.height / 2 + 3;
				diagonalEnd.y = r.y + r.height - 1;
				points.addPoint(diagonalEnd);

				horizontalStart.x = diagonalEnd.x;
				horizontalStart.y = diagonalEnd.y;
				points.addPoint(horizontalStart);

				horizontalEnd.x = r.x;
				horizontalEnd.y = horizontalStart.y;
				points.addPoint(horizontalEnd);

				graphics.drawPolyline(points);
			}
		};
		interactionLabelContainer.setBorder(new MarginBorder(3, 3, 3, 15));
		interactionLabelContainer.setLayoutManager(new LeftToolbarLayout());

		interactionLabelContainer.add(interactionLabel);

		Figure header = new Figure();
		//		header.setBorder(new MarginBorder(1, 1, 0, 3));
		header.setLayoutManager(new ToolbarLayout(false));
		header.add(interactionLabelContainer);

		RectangleFigure container = new RectangleFigure();
		container.setOutline(false);
		container.setFill(false);
		container.setLayoutManager(new BorderLayout());
		container.add(header, BorderLayout.LEFT);
		return container;
	}

	public void setStereotypes(String stereotypes) {
		if(stereotypes == null || stereotypes.trim().equals("")) {
			// Remove label if any
			if(this.stereotypesLabel != null) {
				getStereotypeLabelContainer().remove(this.stereotypesLabel);
				this.stereotypesLabel = null;
			}
			return;
		}
		super.setStereotypes(stereotypes);
	}

	public void setStereotypePropertiesInBrace(String stereotypeProperties) {
		if(stereotypeProperties == null || stereotypeProperties.trim().equals("")) {
			// Remove label if any
			if(this.stereotypePropertiesInBraceContent != null) {
				getStereotypePropertiesInBraceLabelContainer().remove(this.stereotypePropertiesInBraceContent);
				this.stereotypePropertiesInBraceContent = null;
			}
			return;
		}
		super.setStereotypePropertiesInBrace(stereotypeProperties);
	}

	protected IFigure getStereotypeLabelContainer() {
		return interactionLabelContainer;
	}

	protected IFigure getStereotypePropertiesInBraceLabelContainer() {
		return interactionLabelContainer;
	}

}
