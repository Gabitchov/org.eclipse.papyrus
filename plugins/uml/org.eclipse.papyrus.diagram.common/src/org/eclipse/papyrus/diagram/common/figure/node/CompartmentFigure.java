/****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		Patrick Tessier (CEA LIST), Thibault Landre (Atos Origin) - Initial API and implementation
 *	
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.figure.node;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.AbstractLayout;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;

/**
 * A rectangular figure that supports compartment.
 */
public class CompartmentFigure extends NodeNamedElementFigure {	

	private Map<String, RectangleFigure> containerFigures;

	private List<String> compartmentID;

	private IFigure contentPane;


	/**
	 * Constructor.
	 * 
	 * @param compartmentFigure
	 */
	public CompartmentFigure(List<String> compartmentFigure) {
		this(compartmentFigure, null);
	}

	/**
	 * Constructor with a tagged value.
	 * 
	 * @param compartmentFigure
	 *            a list of id for the compartment figure
	 * @param taggedLabelValue
	 *            the value to display as tagged value
	 */
	public CompartmentFigure(List<String> compartmentFigure, String taggedLabelValue) {
		super(taggedLabelValue);

		setLayoutManager(new CompartmentLayoutManager());
		setOpaque(true);
		compartmentID = compartmentFigure;
		createContentPane(compartmentFigure);

	}

	

	/**
	 * 
	 * @param compartmentFigure
	 */
	protected void createContentPane(List<String> compartmentFigure) {
		contentPane = new Figure();
		contentPane.setOpaque(false);

		add(contentPane);

		containerFigures = new HashMap<String, RectangleFigure>();

		for (String id : compartmentFigure) {
			RectangleFigure newFigure = new RectangleFigure();
			newFigure.setFill(false);
			newFigure.setBorder(null);
			newFigure.setOutline(false);
			contentPane.add(newFigure);
			containerFigures.put(id, newFigure);
		}

	}

	/**
	 * Get the content pane
	 * 
	 * @return
	 */
	public IFigure getContentPane() {
		return contentPane;
	}

	/**
	 * Get the RectangleFigure containing the wanted compartment.
	 * 
	 * @param id
	 *            the id to find the right compartment
	 * @return the RectangleFigure
	 */
	public RectangleFigure getCompartment(String id) {
		return containerFigures.get(id);
	}

	/**
	 * A Specific layout manager to handle compartment in the content pane
	 */
	private class CompartmentLayoutManager extends AbstractLayout {

		// TODO : replace this value by the size of the incriminated label
		private static final int wrappedLabelSize = 18;

		/**
		 * {@inheritDoc}
		 */
		@Override
		protected Dimension calculatePreferredSize(IFigure container, int wHint, int hHint) {
			int minimumWith = 0;
			int minimumHeight = 0;
			// display name
			if (getNameLabel() != null) {
				if (getNameLabel().getPreferredSize().width > minimumWith) {
					minimumWith = getNameLabel().getPreferredSize().width;
				}
				minimumHeight += getNameLabel().getPreferredSize().height;
			}

			return new Dimension(minimumWith, minimumHeight);
		}

		/**
		 * {@inheritDoc}
		 */
		public void layout(IFigure container) {
			// Header
			List childrenList = container.getChildren();
			for (int i = 0; i < childrenList.size(); i++) {
				Rectangle bound = new Rectangle(((IFigure) childrenList.get(i)).getBounds());
				bound.setSize(((IFigure) childrenList.get(i)).getPreferredSize());
				bound.width = getBounds().width;
				bound.x = getBounds().x;
				if (i > 0) {
					bound.y = ((IFigure) childrenList.get(i - 1)).getBounds().getBottomLeft().y + 1;
				} else {
					bound.y = getBounds().y;
				}
				((IFigure) childrenList.get(i)).setBounds(bound);
			}

			for (int i = 0; i < compartmentID.size(); i++) {
				RectangleFigure rectangleFigure = containerFigures.get(compartmentID.get(i));
				if (rectangleFigure.getChildren().size() > 0) {
					ResizableCompartmentFigure rcf = (ResizableCompartmentFigure) rectangleFigure.getChildren().get(0);
					if (rcf != null) {
						Point point = getPosition(i);
						Dimension dimensionCompartment = getDimension(i, rcf, point);
						Rectangle rect = new Rectangle(point, dimensionCompartment);
						rcf.getParent().setBounds(rect);
						rcf.setBounds(rect);
					}
				}

			}
			contentPane.getBounds().setSize(getBounds().width,
					getBounds().y + getBounds().height - contentPane.getBounds().y);
		}

		/**
		 * Get the dimension of the compartment depending on its position and its content.
		 * 
		 * @param index
		 *            the index of the compartment in the containerFigures list
		 * @param rcf
		 *            the ResizableCompartmentFigure which will be displayed
		 * @param point
		 *            the location of the compartment
		 * @return the dimension of the compartment
		 */
		private Dimension getDimension(int index, ResizableCompartmentFigure rcf, Point point) {
			Dimension dimensionCompartment = new Dimension(getBounds().width, wrappedLabelSize);
			if (rcf.isExpanded()) {
				dimensionCompartment.height += wrappedLabelSize * (rcf.getContentPane().getChildren().size());
			}
			// If it is the last compartment of the figure, get all the available room in the
			// contentPane
			if (index == compartmentID.size() - 1) {
				dimensionCompartment.height = getBounds().y + getBounds().height - point.y;
			}
			return dimensionCompartment;
		}

		/**
		 * Calculate the location of the compartment. It depends on its previous compartment
		 * location and size if it has any. Otherwise it is the location of the contentPane
		 * 
		 * @param index
		 *            the index of the compartment in the containerFigures list
		 * @return the position of the compartment
		 */
		private Point getPosition(int index) {
			// By default, it is the position of the contentPane
			Point point = new Point(getContentPane().getBounds().x, getContentPane().getBounds().y);
			// If it has a compartment before, calculate a new position
			if (index > 0) {
				RectangleFigure previousRectangle = containerFigures.get(compartmentID.get(index - 1));
				ResizableCompartmentFigure rcf = (ResizableCompartmentFigure) previousRectangle.getChildren().get(0);
				point.y = rcf.getParent().getBounds().y + rcf.getParent().getBounds().height;
			}
			return point;
		}

	}
}
