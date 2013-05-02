/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.interactionoverview.figures;

import java.util.List;

import org.eclipse.draw2d.AbstractLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.OrderedLayout;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.figures.ShapeCompartmentFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.papyrus.uml.diagram.activity.figures.ActivityFigure;
import org.eclipse.papyrus.uml.diagram.common.draw2d.InteractionFigure;
import org.eclipse.papyrus.uml.diagram.common.draw2d.LeftToolbarLayout;

public class ActivityAsInteractionFigure extends ActivityFigure {

	private WrappingLabel interactionHeader;

	private RectangleFigure interactionLabelContainer;

	private RectangleFigure interactionContentPane;

	public ActivityAsInteractionFigure() {
		createContents();
		this.corner = 0;
	}

	protected void createContents() {
		add(createInteractionFigureHeader());
		add(createContentPane());
		final int childrenSize = getChildren().size();
		setLayoutManager(new ActivityLayoutManager());
	}

	protected RectangleFigure createContentPane() {
		interactionContentPane = new RectangleFigure();
		// Margin allow to add message easily
		interactionContentPane.setBorder(new MarginBorder(5, 5, 5, 5));
		interactionContentPane.setFill(false);
		interactionContentPane.setOutline(false);

		return interactionContentPane;
	}

	protected RectangleFigure createInteractionFigureHeader() {
		this.interactionHeader = new WrappingLabel() {

			@Override
			public Dimension getPreferredSize(final int wHint, final int hHint) {
				final Dimension preferredSize = super.getPreferredSize(wHint, hHint);
				if(preferredSize.width == 0) {
					return preferredSize;
				}
				return new Dimension(preferredSize.width + 2, preferredSize.height + 2);
			}
		};

		final InteractionFigure interactionFigure = new InteractionFigure();
		interactionFigure.setBorder(new MarginBorder(3, 3, 3, 3));
		interactionFigure.setLayoutManager(new LeftToolbarLayout());
		interactionFigure.add(interactionHeader);
		interactionLabelContainer = new RectangleFigure();
		interactionLabelContainer.setOutline(false);
		interactionLabelContainer.setFill(false);
		interactionLabelContainer.setLayoutManager(new ToolbarLayout(false));
		interactionLabelContainer.add(interactionFigure, OrderedLayout.ALIGN_CENTER);
		return interactionLabelContainer;
	}

	@Override
	public WrappingLabel getNameLabel() {
		return interactionHeader;
	}

	public RectangleFigure getLabelContainer() {
		return interactionLabelContainer;
	}

	@Override
	public RectangleFigure getContentFigure() {
		return interactionContentPane;
	}

	/**
	 * get the gmf container figure of the package
	 * 
	 * @return the gmf container
	 */
	@Override
	public ShapeCompartmentFigure getGMFContentContainer() {
		if(interactionContentPane.getChildren().size() > 0) {
			return (ShapeCompartmentFigure)interactionContentPane.getChildren().get(0);
		}
		return null;
	}

	/**
	 * this is the layout manager in charge to place element in the enumeration
	 * 
	 */
	private class ActivityLayoutManager extends AbstractLayout {

		/**
		 * ---------------------------------------------------| |sterotypeLabel|
		 * precondition | |--------------| | |QualifiedName
		 * |-----------------------------------| |--------------| | |name |
		 * postcondition | |--------------------------------------------------|
		 * | stereotype compartment |
		 * |--------------------------------------------------| |parameter | |
		 * |----------- | | activity content |
		 * ----------------------------------------------------
		 * 
		 * {@inheritDoc}
		 */
		@Override
		protected Dimension calculatePreferredSize(final IFigure container, final int hint, final int hint2) {
			int minimumWith = 0;
			int minimumHeight = 0;
			// take in account the content of the figure activity
			if((getContentFigure().getChildren().size() > 0)) {
				final IFigure content = (IFigure)getContentFigure().getChildren().get(0);
				minimumWith = content.getPreferredSize().width + 50;
				minimumHeight = content.getPreferredSize().height + 50;
			}
			// display name
			if(getNameLabel() != null) {
				if(getNameLabel().getPreferredSize().width > minimumWith) {
					minimumWith = getNameLabel().getPreferredSize().width;
				}
				minimumHeight += getNameLabel().getPreferredSize().height;
			}
			if(getHeaderSingleExecution() != null) {
				if(getHeaderSingleExecution().getBounds().getTopRight().x > minimumWith) {
					minimumWith = getHeaderSingleExecution().getBounds().getTopRight().x;
				}
			}
			return new Dimension(minimumWith, minimumHeight);
		}

		/**
		 * 
		 * {@inheritDoc}
		 */
		public void layout(final IFigure container) {
			final List childrenList = container.getChildren();
			for(int i = 0; i < container.getChildren().size(); i++) {
				final IFigure currentFigure = (IFigure)childrenList.get(i);
				if(currentFigure.equals(getLabelContainer()) || currentFigure.equals(getContentFigure())) {
					final Rectangle bound = new Rectangle(((IFigure)childrenList.get(i)).getBounds());
					bound.setSize(((IFigure)childrenList.get(i)).getPreferredSize());
					if(i > 0) {
						bound.y = ((IFigure)childrenList.get(i - 1)).getBounds().getBottomLeft().y + 1;
						// bound.x = getBounds().x + GAP_X;
					} else {
						// bound.x = getBounds().x + GAP_X;
						bound.y = getBounds().y + GAP_Y;
					}
					((IFigure)childrenList.get(i)).setBounds(bound);
				}
			}
			// container
			final Rectangle lastRectangle = getContentFigure().getBounds();
			lastRectangle.height = getBounds().y + getBounds().height - lastRectangle.y;
			lastRectangle.x = container.getBounds().x;
			lastRectangle.width = getBounds().width;
			getContentFigure().setBounds(lastRectangle);
			if(getGMFContentContainer() != null) {
				getGMFContentContainer().setBounds(lastRectangle);
			}

			// replace compartment stereotype properties
			if(getStereotypePropertiesContent() != null) {
				final Rectangle pscontainer = getStereotypePropertiesContent().getBounds().getCopy();
				if(getPostconditionFigure().getBounds().y + getPostconditionFigure().getBounds().height + GAP_Y > pscontainer.y)
					pscontainer.y = getPostconditionFigure().getBounds().y + getPostconditionFigure().getBounds().height + GAP_Y;
				getStereotypePropertiesContent().setBounds(pscontainer);
			}
			// // place parameter
			// // replace compartment stereotype properties
			// if(getStereotypePropertiesContent() != null) {
			// Rectangle paramBoundcontainer =
			// getParameterFigure().getBounds().getCopy();
			// paramBoundcontainer.y =
			// getStereotypePropertiesContent().getBounds().getBottomLeft().y;
			// getParameterFigure().setBounds(paramBoundcontainer);
			// if(getParameterFigure().getChildren().size() > 0) {
			// ((IFigure)interactionContentPane.getChildren().get(0)).setBounds(paramBoundcontainer);
			// }
			// } else {
			// Rectangle paramBoundcontainer =
			// getParameterFigure().getBounds().getCopy();
			// paramBoundcontainer.y =
			// getNameLabel().getBounds().getBottomLeft().y;
			// getParameterFigure().setBounds(paramBoundcontainer);
			// if(getParameterFigure().getChildren().size() > 0) {
			// ((IFigure)interactionContentPane.getChildren().get(0)).setBounds(paramBoundcontainer);;
			// }
			// }
		}
	}
}
