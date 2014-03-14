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
package org.eclipse.papyrus.sysml.diagram.common.figure;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.OrderedLayout;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.figures.ShapeCompartmentFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.papyrus.uml.diagram.common.draw2d.InteractionFigure;
import org.eclipse.papyrus.uml.diagram.common.draw2d.LeftToolbarLayout;
import org.eclipse.papyrus.uml.diagram.common.figure.node.AutomaticCompartmentLayoutManager;
import org.eclipse.papyrus.uml.diagram.common.figure.node.NodeNamedElementFigure;

public class SysMLDiagramFrameFigure extends NodeNamedElementFigure {

	private WrappingLabel stereotypeLabel;

	private WrappingLabel frameLabel;

	private RectangleFigure frameLabelContainerFigure;
	
	private InteractionFigure interactionFigure;
	
	private int structureOffset;

	public SysMLDiagramFrameFigure() {
		super();
		createContents();
	}

	protected void createContents() {
		add(createFigureHeader());
		setLayoutManager(new SysMLLayoutLayoutManager());
	}

	protected RectangleFigure createFigureHeader() {
		
		if (this.stereotypeLabel == null) {
			this.stereotypeLabel = new WrappingLabel() {
	
				@Override
				public Dimension getPreferredSize(final int wHint, final int hHint) {
					final Dimension preferredSize = super.getPreferredSize(wHint, hHint);
					if(preferredSize.width == 0) {
						return preferredSize;
					}
					return new Dimension(preferredSize.width + 2, preferredSize.height);
				}
			};
		}

		stereotypeLabel.setAlignment(OrderedLayout.ALIGN_CENTER);
		if (this.frameLabel == null) {
			this.frameLabel = new WrappingLabel() {
	
				@Override
				public Dimension getPreferredSize(final int wHint, final int hHint) {
					final Dimension preferredSize = super.getPreferredSize(wHint, hHint);
					if(preferredSize.width == 0) {
						return preferredSize;
					}
					return new Dimension(preferredSize.width + 9, preferredSize.height);
				}
			};
		}

		interactionFigure = new InteractionFigure();
		interactionFigure.setBorder(new MarginBorder(3, 3, 6, 3));
		interactionFigure.setLayoutManager(new LeftToolbarLayout());
		interactionFigure.add(frameLabel);

		frameLabelContainerFigure = new RectangleFigure();
		frameLabelContainerFigure.setOutline(false);
		frameLabelContainerFigure.setFill(false);
		frameLabelContainerFigure.setLayoutManager(new ToolbarLayout(false));
		frameLabelContainerFigure.add(interactionFigure, OrderedLayout.ALIGN_CENTER);
		return frameLabelContainerFigure;
	}

	@Override
	public WrappingLabel getNameLabel() {
		if (frameLabel == null) {
			createFigureHeader();
		}
		return frameLabel;
	}

	public RectangleFigure getLabelContainer() {
		return frameLabelContainerFigure;
	}
	
	/**
	 * this is the layout manager in charge to place element in the enumeration
	 * 
	 */
	private class SysMLLayoutLayoutManager extends AutomaticCompartmentLayoutManager {

		/**
		 * 
		 * {@inheritDoc}
		 */
		public void layout(final IFigure container) {
			List<IFigure> figuresToRemove = new ArrayList<IFigure>();
			for(int i = 0; i < container.getChildren().size(); i++) {
				IFigure currentCompartment = (IFigure)container.getChildren().get(i);
				// this is a visible compartment
				if(currentCompartment instanceof ShapeCompartmentFigure) {
					Rectangle bound = new Rectangle(currentCompartment.getBounds());
					currentCompartment.invalidate();
					Dimension pref = currentCompartment.getPreferredSize();
					currentCompartment.invalidate();
					Dimension prefConstraint = currentCompartment.getPreferredSize(container.getBounds().width - 40, -1);
					if(pref.width < prefConstraint.width) {
						bound.setSize(pref);
					} else {
						bound.setSize(prefConstraint);
					}
					bound.x = container.getBounds().x + 10;
					bound.y = container.getBounds().y + structureOffset ;
					bound.width = container.getBounds().width - 20;
					bound.height = container.getBounds().height - structureOffset - 10; 
					currentCompartment.setBounds(bound);
				} else if (currentCompartment == frameLabelContainerFigure) {
					Rectangle boundLabel = new Rectangle(frameLabelContainerFigure.getBounds());
					Dimension frameLabelDimension = frameLabelContainerFigure.getPreferredSize();
					boundLabel.setSize(frameLabelDimension);
					frameLabelContainerFigure.setBounds(boundLabel);
				} else {
					// remove other figure
					figuresToRemove.add(currentCompartment);
				}
			}
			for (IFigure iFigure : figuresToRemove) {
				container.getChildren().remove(iFigure);
			}
		}
	}

	public void setStereotypeLabel(String stereotypeText) {
		interactionFigure.remove(frameLabel);
		if (interactionFigure.getChildren().contains(stereotypeLabel)) {
			interactionFigure.remove(stereotypeLabel);
		}
		if (stereotypeText != null && !stereotypeText.isEmpty()) {
			stereotypeLabel.setText(String.valueOf("\u00AB") + stereotypeText + String.valueOf("\u00BB"));
			interactionFigure.add(stereotypeLabel);
			structureOffset = 41;
		}
		else {
			// no stereotype
			structureOffset = 26;
		}
		interactionFigure.add(frameLabel);
	}
	
}
