/****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		Patrick Tessier (CEA LIST), Thibault Landre (Atos Origin) - Initial API and implementation
 *		Vincent Lorenzo (CEA LIST), change layout(IFigure container)
 *		Laurent Wouters (CEA LIST), refactoring, cleanup, added layout of labels on top of shapes
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.figure.node;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.AbstractLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.papyrus.infra.gmfdiag.common.figure.node.SVGNodePlateFigure;
import org.eclipse.papyrus.infra.gmfdiag.common.figure.node.ScalableCompartmentFigure;

/**
 * This is the layout manager in charge to place element in compartment element.
 * A modification of the code has been done in order to manage none visible
 * compartment. if a compartment becomes invisible, its size and its height are
 * equal to 1.
 *
 */
public class AutomaticCompartmentLayoutManager extends AbstractLayout {

	protected static final int MINIMUM_COMPARTMENT_HEIGHT = 15;

	/**
	 * list of visible compartment children
	 */
	protected ArrayList<IFigure> visibleCompartments = new ArrayList<IFigure>();

	/**
	 * list of visible non-compartment children (e.g. labels)
	 */
	protected ArrayList<IFigure> visibleOthers = new ArrayList<IFigure>();

	/**
	 * list of the invisible children
	 */
	protected ArrayList<IFigure> invisibles = new ArrayList<IFigure>();

	/**
	 * true if the bounds of the labels are forced by an inner figure
	 */
	protected boolean forcedLabelBounds = false;

	/**
	 * true if extra distance between compartment should be added
	 */
	protected boolean addExtraHeight = true;

	/**
	 * Sets whether extra distance between compartment should be added
	 *
	 * @param addExtraHeight
	 */
	public void setAddExtraHeight(boolean addExtraHeight) {
		this.addExtraHeight = addExtraHeight;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Dimension calculatePreferredSize(IFigure container, int hint, int hint2) {
		collectInformation(container);
		int minimumWith = 0;
		int minimumHeight = 0;
		if(container instanceof CompartmentFigure) {
			CompartmentFigure cf = (CompartmentFigure)container;
			WrappingLabel wl = cf.getNameLabel();
			// display name
			if(wl != null && container.getChildren().contains(wl)) {
				if(wl.getPreferredSize().width > minimumWith) {
					minimumWith = wl.getPreferredSize().width;
				}
			}
		}
		if(!visibleCompartments.isEmpty()) {
			for(Object o : container.getChildren()) {
				IFigure child = (IFigure)o;
				minimumHeight += child.getPreferredSize().height;
				minimumWith = Math.max(minimumWith, child.getPreferredSize().width);
			}
		} else {
			for(IFigure child : visibleOthers) {
				minimumHeight += child.getPreferredSize().height;
			}
		}
		if(addExtraHeight) {
			minimumHeight += 7;
		}
		return new Dimension(minimumWith, minimumHeight);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Dimension getMinimumSize(IFigure container, int wHint, int hHint) {
		return new Dimension(20, 20);
	}

	/**
	 * {@inheritDoc}
	 */
	public void layout(IFigure container) {
		collectInformation(container);
		// gets the bounds of this container
		Rectangle bounds = container.getBounds();
		// do the layout based on the policies
		if(!visibleCompartments.isEmpty()) {
			if(forcedLabelBounds) {
				layoutForcedLabel(container);
			} else {
				layoutDefault(container);
			}
		} else {
			// only non-compartment elements are visible
			// center them within this container
			layoutOthers(bounds);
		}
		// layout the invisible elements
		layoutInvisibles(bounds.x + 3, bounds.getBottomLeft().y + 1);
	}

	/**
	 * Layouts the invisible elements at the given location
	 *
	 * @param x
	 *        location's x coordinate
	 * @param y
	 *        location's y coordinate
	 */
	protected void layoutInvisibles(int x, int y) {
		for(IFigure child : invisibles) {
			Rectangle bound = new Rectangle(child.getBounds());
			bound.x = x;
			bound.y = y;
			child.setBounds(bound);
		}
	}

	/**
	 * Layout the other elements within the given container bounds
	 *
	 * @param container
	 *        The container's bound
	 */
	protected void layoutOthers(Rectangle container) {
		int totalHeight = 0;
		for(IFigure child : visibleOthers) {
			totalHeight += child.getPreferredSize(50, -1).height;
		}

		IFigure previous = null;
		for(IFigure child : visibleOthers) {
			Rectangle bound = new Rectangle();
			if (child instanceof WrappingLabel) {
				((WrappingLabel) child).setTextWrap(true);
				((WrappingLabel) child).setTextJustification(PositionConstants.CENTER);
				bound.setSize(child.getPreferredSize(container.width, -1));
			} else {
				bound.setSize(getPreferedSize(child));
			}
			if(previous != null) {
				bound.y = previous.getBounds().getBottomLeft().y + 1;
				bound.x = container.x + 3;
				bound.width = container.width;
			} else {
				bound.x = container.x + 3;
				// in the case where the content is grater than the container
				// it is forbidden to change the y coordinate
				if(((container.height - totalHeight) / 2)>0 ){
					bound.y = container.y + ((container.height - totalHeight) / 2);}
				else{
					bound.y = container.y;
				}
				bound.width = container.width;
			}
			child.setBounds(bound);
			previous = child;
		}
	}

	/**
	 * Gets the preferred size of the given figure
	 *
	 * @param figure
	 *        A figure that contains a GMF compartment
	 * @return The figure's preferred size
	 */
	private Dimension getPreferedSize(IFigure figure) {
		Dimension dim = figure.getPreferredSize();
		if(!figure.getChildren().isEmpty()) {
			Object compartment = figure.getChildren().get(0);
			if(compartment instanceof ResizableCompartmentFigure) {
				dim.height = ((ResizableCompartmentFigure)compartment).getPreferredSize().height + 10;
				if(dim.height < MINIMUM_COMPARTMENT_HEIGHT) {
					dim.height = MINIMUM_COMPARTMENT_HEIGHT;
				}
			}
		}
		return dim;
	}

	/**
	 * Default layout behavior with compartments
	 *
	 * @param container
	 *        The container to layout
	 */
	protected void layoutDefault(IFigure container) {
		// this list contains the visible compartments (that is to say :
		// notCompartmentList + compartmentsList
		List<IFigure> visibles = new ArrayList<IFigure>();
		visibles.addAll(visibleOthers);
		visibles.addAll(visibleCompartments);

		List<Rectangle> bounds = buildInitialsBounds(container, visibles);
		double notCompartmentsHeight = getTotalHeight(bounds, 0, visibleOthers.size());
		double compartmentsHeight = getTotalHeight(bounds, visibleOthers.size(), visibleCompartments.size());
		double remainingspace = container.getBounds().height - notCompartmentsHeight;
		// because of the place of the label we have to remove 3
		remainingspace -= 3;
		// because we move compartment of 1 pixel the space is decrease of 1 per compartment
		remainingspace -= visibleCompartments.size();
		// adjustment ratio for the height of the compartments
		double ratio = compartmentsHeight / remainingspace;

		for(int i = 0; i != bounds.size(); i++) {
			Rectangle bound = bounds.get(i);
			if(i < visibleOthers.size()) {
				fillBoundsForOther(container, bound, (i == 0) ? null : bounds.get(i - 1));
			} else {
				fillBoundsForCompartment(container, bound, (i == 0) ? null : bounds.get(i - 1), ratio);
			}
			visibles.get(i).setBounds(bound);
		}
	}

	/**
	 * Fills the given bound data as a compartment child
	 *
	 * @param container
	 *        The container to layout
	 * @param bound
	 *        The bound to fill
	 * @param previous
	 *        The previously filled bound
	 * @param ratio
	 *        The ratio to be applied on the height of the compartment
	 */
	private void fillBoundsForCompartment(IFigure container, Rectangle bound, Rectangle previous, double ratio) {
		fillBoundsForOther(container, bound, previous);
		bound.height = (int)(bound.height / ratio);
		if(previous == null) {
			bound.y = container.getBounds().y;
		}
	}

	/**
	 * Fills the given bound data as a non-compartment child
	 *
	 * @param container
	 *        The container to layout
	 * @param bound
	 *        The bound to fill
	 * @param previous
	 *        The previously filled bound
	 */
	private void fillBoundsForOther(IFigure container, Rectangle bound, Rectangle previous) {
		bound.x = container.getBounds().x + 1;
		bound.width = container.getBounds().width;
		if(previous == null) {
			bound.y = container.getBounds().y + 3;
		} else {
			bound.y = previous.getBottomLeft().y + 1;
		}
	}

	/**
	 * Computes the total height of the given list of bounds
	 *
	 * @param bounds
	 *        A list of bounds
	 * @param startIndex
	 *        The starting index of the bounds to take into account
	 * @param count
	 *        The number of bounds to take into account
	 * @return The total height of the slice of bounds data
	 */
	private double getTotalHeight(List<Rectangle> bounds, int startIndex, int count) {
		double result = 0.0;
		for(int i = startIndex; i != startIndex + count; i++) {
			result += bounds.get(i).preciseHeight();
		}
		return result;
	}

	/**
	 * Builds the initial bounds data for all the given children
	 *
	 * @param container
	 *        The container to layout
	 * @param visibles
	 *        The list of the visible children
	 * @return A list of the bounds of the given children in the same order
	 */
	private List<Rectangle> buildInitialsBounds(IFigure container, List<IFigure> visibles) {
		List<Rectangle> result = new ArrayList<Rectangle>(visibles.size());
		for(IFigure child : visibles) {
			result.add(buildInitialsBounds(container, child));
		}
		return result;
	}

	/**
	 * Builds the initial bounds data for the given container and child
	 *
	 * @param container
	 *        The container to layout
	 * @param child
	 *        The child for which bounds shall be built
	 * @return The initial child's bounds
	 */
	private Rectangle buildInitialsBounds(IFigure container, IFigure child) {
		Rectangle bounds = new Rectangle(child.getBounds());
		child.invalidate();
		Dimension pref = child.getPreferredSize();
		child.invalidate();
		Dimension prefConstraint = child.getPreferredSize(container.getBounds().width - 40, -1);
		if(pref.width < prefConstraint.width) {
			bounds.setSize(pref);
		} else {
			bounds.setSize(prefConstraint);
		}
		return bounds;
	}

	/**
	 * Layout all the compartment by their default and the label at the forced position
	 *
	 * @param container
	 *        The container to layout
	 */
	protected void layoutForcedLabel(IFigure container) {
		// first, fixes the order of the children
		// remove the labels
		container.getChildren().removeAll(visibleOthers);
		// add them at the end
		container.getChildren().addAll(visibleOthers);

		List<Rectangle> bounds = buildInitialsBounds(container, visibleCompartments);
		double compartmentsHeight = getTotalHeight(bounds, 0, visibleCompartments.size());
		double remainingspace = container.getBounds().height;
		// because we move compartment of 1 pixel the space is decrease of 1 per compartment
		remainingspace -= visibleCompartments.size();
		// adjustment ratio for the height of the compartments
		double ratio = compartmentsHeight / remainingspace;

		IFigure shapeCompartment = null;
		for(int i = 0; i != visibleCompartments.size(); i++) {
			Rectangle bound = bounds.get(i);
			fillBoundsForCompartment(container, bound, (i == 0) ? null : bounds.get(i - 1), ratio);
			IFigure compartment = visibleCompartments.get(i);
			compartment.setBounds(bound);
			if(compartment instanceof ScalableCompartmentFigure) {
				shapeCompartment = compartment;
			}
		}

		Rectangle otherBounds = container.getBounds();
		if(shapeCompartment != null) {
			otherBounds = ((SVGNodePlateFigure)container.getParent()).getLabelBounds(shapeCompartment.getBounds());
		}
		layoutOthers(otherBounds);
	}

	/**
	 * Collects information on the container to layout
	 *
	 * @param container
	 *        The container to layout
	 */
	protected void collectInformation(IFigure container) {
		forcedLabelBounds = false;
		if(container.getParent() instanceof SVGNodePlateFigure) {
			forcedLabelBounds = ((SVGNodePlateFigure)container.getParent()).hasLabelBounds();
		}
		visibleCompartments.clear();
		visibleOthers.clear();
		invisibles.clear();
		for(Object o : container.getChildren()) {
			IFigure child = (IFigure)o;
			if(isGMFContainer(child)) {
				visibleCompartments.add(child);
			} else if(child instanceof Label || child instanceof WrappingLabel || child instanceof StereotypePropertiesCompartment) {
				visibleOthers.add(child);
			} else if(child instanceof ScalableCompartmentFigure) {
				visibleCompartments.add(child);
			} else {
				invisibles.add(child);
			}
		}
	}

	/**
	 * Tests whether the figure contains a GMF compartment
	 *
	 * @param figure
	 *        The figure to test
	 * @return <code>true</code> if the figure contains a GMF compartment
	 */
	private boolean isGMFContainer(IFigure figure) {
		if(figure instanceof StereotypePropertiesCompartment) {
			return false;
		}
		if(figure.getChildren().size() > 0) {
			if(figure.getChildren().get(0) instanceof ResizableCompartmentFigure) {
				return true;
			}
		}
		return false;
	}
}
