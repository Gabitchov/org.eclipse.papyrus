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
package org.eclipse.papyrus.uml.diagram.sequence.figures;

import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.TreeSearch;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.papyrus.uml.diagram.common.figure.node.NodeNamedElementFigure;
import org.eclipse.papyrus.uml.diagram.common.figure.node.RectangularShadowBorder;
import org.eclipse.swt.graphics.Color;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class LifelineFigure extends NodeNamedElementFigure {

	protected RectangleFigure fFigureLifelineNameContainerFigure;

	protected RectangleFigure fFigureExecutionsContainerFigure;

	protected LifelineDotLineCustomFigure fFigureLifelineDotLineFigure;

	/**
	 * Constructor.
	 * 
	 */
	public LifelineFigure() {
	}

	public int getNameContainerPreferredHeight(int wHint) {
		return fFigureLifelineNameContainerFigure.getPreferredSize(wHint, -1).height;
	}

	/**
	 * Get the rectangle which contains all labels
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.common.figure.node.NodeNamedElementFigure#getDefaultLabelsContainer()
	 * @return lifeline labels rectangle
	 */
	@Override
	protected IFigure getDefaultLabelsContainer() {
		return getFigureLifelineNameContainerFigure();
	}

	/**
	 * Create the composite structure.
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.common.figure.node.PapyrusNodeFigure#createCompositeFigureStructure()
	 */
	@Override
	protected void createCompositeFigureStructure() {
		BorderLayout layoutThis = new BorderLayout();
		this.setLayoutManager(layoutThis);
		this.setOpaque(false);
		this.setPreferredSize(new Dimension(getMapMode().DPtoLP(100), getMapMode().DPtoLP(200)));
		createContents();
	}

	/**
	 * Paint the label rectangle as background instead of the whole figure
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.common.figure.node.PapyrusNodeFigure#paintBackground(org.eclipse.draw2d.Graphics,
	 *      org.eclipse.draw2d.geometry.Rectangle)
	 * @param graphics
	 *        graphics tool
	 * @param rectangle
	 *        unused
	 */
	@Override
	protected void paintBackground(Graphics graphics, Rectangle rectangle) {
		super.paintBackground(graphics, getFigureLifelineNameContainerFigure().getBounds());
	}

	/**
	 * Get the figure on which the border must be drawn.
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.common.figure.node.PapyrusNodeFigure#getBorderedFigure()
	 * @return the rectangle containing labels
	 */
	@Override
	protected IFigure getBorderedFigure() {
		return getFigureLifelineNameContainerFigure();
	}

	/**
	 * Construct the appropriate border
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.common.figure.node.PapyrusNodeFigure#getDefaultBorder(org.eclipse.swt.graphics.Color)
	 * @param borderColor
	 *        the color of the border
	 * @return the border
	 */
	@Override
	protected Border getDefaultBorder(Color borderColor) {
		int margin = getMapMode().DPtoLP(7);
		MarginBorder defaultBorder = new MarginBorder(margin, margin, margin, margin);
		return defaultBorder;
	}

	/**
	 * Get layout to display content of properties compartment.
	 * 
	 * @return the layout
	 */
	protected LayoutManager getPropertiesCompartmentLayout() {
		ToolbarLayout layout = new ToolbarLayout(false);
		layout.setStretchMinorAxis(true);
		return layout;
	}

	/**
	 * Create the name label with width wrap
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.common.figure.node.NodeNamedElementFigure#createNameLabel()
	 */
	@Override
	protected void createNameLabel() {
		super.createNameLabel();
	}

	/**
	 * remove label creation, change layout
	 */
	private void createContents() {
		fFigureLifelineNameContainerFigure = new RectangleFigure() {

			protected void fillShape(Graphics graphics) {
				graphics.pushState();
				applyTransparency(graphics);
				graphics.fillRectangle(getBounds());
				graphics.popState();
			}
		};
		// do not fill to enable gradient
		fFigureLifelineNameContainerFigure.setFill(false);
		fFigureLifelineNameContainerFigure.setBorder(new MarginBorder(getMapMode().DPtoLP(7), getMapMode().DPtoLP(7), getMapMode().DPtoLP(7), getMapMode().DPtoLP(7)));
		this.add(fFigureLifelineNameContainerFigure, BorderLayout.TOP);
		// change layout
		ToolbarLayout layout = new ToolbarLayout(false);
		layout.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);
		fFigureLifelineNameContainerFigure.setLayoutManager(layout);
		// remove label creation (created by parent figure)
		//			fFigureLifelineLabelFigure = new WrappingLabel();
		//
		//
		//
		//
		//			fFigureLifelineLabelFigure.setText("<...>");
		//
		//
		//
		//
		//			fFigureLifelineLabelFigure.setTextWrap(true);
		//
		//
		//
		//
		//			fFigureLifelineLabelFigure.setAlignment(PositionConstants.CENTER);
		//
		//
		//
		//			fFigureLifelineNameContainerFigure.add(fFigureLifelineLabelFigure);
		fFigureExecutionsContainerFigure = new RectangleFigure();
		fFigureExecutionsContainerFigure.setFill(false);
		fFigureExecutionsContainerFigure.setOutline(false);
		fFigureExecutionsContainerFigure.setLineWidth(1);
		this.add(fFigureExecutionsContainerFigure, BorderLayout.CENTER);
		fFigureExecutionsContainerFigure.setLayoutManager(new StackLayout());
		fFigureLifelineDotLineFigure = new LifelineDotLineCustomFigure();
		fFigureExecutionsContainerFigure.add(fFigureLifelineDotLineFigure);
	}

	protected IMapMode getMapMode() {
		return MapModeUtil.getMapMode();
	}

	/**
	 * get label from super figure
	 */
	public WrappingLabel getFigureLifelineLabelFigure() {
		return getNameLabel();
	}

	public RectangleFigure getFigureLifelineNameContainerFigure() {
		return fFigureLifelineNameContainerFigure;
	}

	public RectangleFigure getFigureExecutionsContainerFigure() {
		return fFigureExecutionsContainerFigure;
	}

	public LifelineDotLineCustomFigure getFigureLifelineDotLineFigure() {
		return fFigureLifelineDotLineFigure;
	}

	@Override
	public void setLineWidth(int w) {
		if(w < 0)
			return;
		super.setLineWidth(w);
		fFigureLifelineNameContainerFigure.setLineWidth(w);
		fFigureLifelineDotLineFigure.setLineWidth(w);
	}

	@Override
	public void setShadow(boolean shadow) {
		if(!shadow)
			fFigureLifelineNameContainerFigure.setBorder(new MarginBorder(getMapMode().DPtoLP(7), getMapMode().DPtoLP(7), getMapMode().DPtoLP(7), getMapMode().DPtoLP(7)));
		else {
			RectangularShadowBorder b = new RectangularShadowBorder(3, getForegroundColor()) {

				@Override
				public Insets getInsets(IFigure figure) {
					Insets insetsNew = new Insets(getMapMode().DPtoLP(7), getMapMode().DPtoLP(7), getMapMode().DPtoLP(7), getMapMode().DPtoLP(7));
					insetsNew.bottom = MapModeUtil.getMapMode(figure).DPtoLP(insetsNew.bottom + 3);
					insetsNew.right = MapModeUtil.getMapMode(figure).DPtoLP(insetsNew.right + 3);
					return insetsNew;
				}
			};
			fFigureLifelineNameContainerFigure.setBorder(b);
		}
	}

	@Override
	public IFigure findMouseEventTargetAt(int x, int y) {
		// check children first instead of self
		IFigure f = findMouseEventTargetInDescendantsAt(x, y);
		if(f != null) {
			return f;
		}
		if(!containsPoint(x, y)) {
			return null;
		}
		if(isMouseEventTarget()) {
			return this;
		}
		return null;
	}

	@Override
	public IFigure findFigureAt(int x, int y, TreeSearch search) {
		if(search.prune(this)) {
			return null;
		}
		IFigure child = findDescendantAtExcluding(x, y, search);
		if(child != null) {
			return child;
		}
		if(!containsPoint(x, y)) {
			return null;
		}
		if(search.accept(this)) {
			return this;
		}
		return null;
	}
}
