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
 *	    Vincent Lorenzo (CEA LIST), change layout(IFigure container)
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.figure.node;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.AbstractLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.papyrus.infra.gmfdiag.common.figure.node.ScalableCompartmentFigure;

/**
 * this is the layout manager in charge to place element in compartment element.
 * A modification of the code has been done in order to manage none visible
 * compartment. if a compartment becomes invisible, its size and its height are
 * equal to 1.
 * 
 */

public class AutomaticCompartmentLayoutManager extends AbstractLayout {

	protected static final int MINIMUM_COMPARTMENT_HEIGHT = 15;

	// list of compartments
	protected ArrayList<IFigure> compartmentList = new ArrayList<IFigure>();

	// list of none compartments ex wrapping label etc...
	protected ArrayList<IFigure> notCompartmentList = new ArrayList<IFigure>();

	// background figure
	//protected IFigure backgroundFigure;

	protected boolean addExtraHeight = true;

	/**
	 * set the distance between compartments
	 * 
	 * @param addExtraHeight
	 */
	public void setAddExtraHeight(boolean addExtraHeight) {
		this.addExtraHeight = addExtraHeight;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	protected Dimension calculatePreferredSize(IFigure container, int hint, int hint2) {
		collectInformationOnChildren(container);
		int minimumWith = 0;
		int minimumHeight = 0;
		if(container instanceof CompartmentFigure) {
			// display name
			if(((CompartmentFigure)container).getNameLabel() != null) {
				if(((CompartmentFigure)container).getNameLabel().getPreferredSize().width > minimumWith) {
					minimumWith = ((CompartmentFigure)container).getNameLabel().getPreferredSize().width;
				}
			}
		}
		if(compartmentList.size() != 0) {
			for(int i = 0; i < container.getChildren().size(); i++) {
				IFigure child = (IFigure)container.getChildren().get(i);
				minimumHeight += child.getPreferredSize().height;
				minimumWith = Math.max(minimumWith, child.getPreferredSize().width);
			}
		} else {
			for(int i = 0; i < notCompartmentList.size(); i++) {
				minimumHeight += notCompartmentList.get(i).getPreferredSize().height;
			}
		}
		if(addExtraHeight)
			minimumHeight += 7;
		return new Dimension(minimumWith, minimumHeight);
	}

	@Override
	public Dimension getMinimumSize(IFigure container, int wHint, int hHint) {
		return new Dimension(20, 20);
	}

	/**
	 * layout by putting label in the center of figure
	 * 
	 * @param container
	 */
	protected void layoutCenterForLabel(IFigure container) {
		int labelheight = 0;
		for(int i = 0; i < notCompartmentList.size(); i++) {
			labelheight += notCompartmentList.get(i).getPreferredSize().height;
		}

		for(int i = 0; i < container.getChildren().size(); i++) {
			if(notCompartmentList.contains((container.getChildren().get(i)))) {
				Rectangle bound = new Rectangle(((IFigure)container.getChildren().get(i)).getBounds());
				bound.setSize(getPreferedSize(((IFigure)container.getChildren().get(i))));
				if(i > 0) {
					bound.y = ((IFigure)container.getChildren().get(i - 1)).getBounds().getBottomLeft().y + 1;
					bound.x = container.getBounds().x + 3;
					bound.width = container.getBounds().width;
				} else {
					bound.x = container.getBounds().x + 3;
					bound.y = container.getBounds().y + ((container.getBounds().height - labelheight) / 2);
					bound.width = container.getBounds().width;

				}
				((IFigure)container.getChildren().get(i)).setBounds(bound);
			} else {
				Rectangle bound = new Rectangle(((IFigure)container.getChildren().get(i)).getBounds());
				bound.y = container.getBounds().getBottomLeft().y + 1;
				bound.x = container.getBounds().x + 3;
				((IFigure)container.getChildren().get(i)).setBounds(bound);
			}
		}

	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public void layout(IFigure container) {
		collectInformationOnChildren(container);

		//		container.remove(backgroundFigure);
		//		container.add(backgroundFigure, 0);

		// this list contains the visible compartments (that is to say :
		// notCompartmentList + compartmentsList
		List<IFigure> visibleCompartments = new ArrayList<IFigure>();

		visibleCompartments.addAll(notCompartmentList);
		visibleCompartments.addAll(compartmentList);

		// choose the good layout by taking in account if it exist GMF
		// compartment
		if(compartmentList.size() != 0) {
			// visit all compartment
			for(int i = 0; i < container.getChildren().size(); i++) {
				IFigure currentCompartment = (IFigure)container.getChildren().get(i);
				// this is a visible compartment
				if(visibleCompartments.contains(currentCompartment)) {

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
					//bound.setSize(getPreferedSize(currentCompartment));
					if(visibleCompartments.indexOf(currentCompartment) > 0) {
						bound.y = (visibleCompartments.get(visibleCompartments.indexOf(currentCompartment) - 1)).getBounds().getBottomLeft().y + 1;
						bound.x = container.getBounds().x + 3;
						bound.width = container.getBounds().width;
					} else {
						bound.x = container.getBounds().x + 3;
						bound.y = container.getBounds().y + 3;
						bound.width = container.getBounds().width;
					}
					currentCompartment.setBounds(bound);
				} else {
					// this is a none visible compartment
					Rectangle bound = new Rectangle(currentCompartment.getBounds());
					bound.setSize(1, 1);
					currentCompartment.setBounds(bound);
				}
			}
			optimizeCompartmentSize(container);
		} else {
			layoutCenterForLabel(container);
		}

		//		if(backgroundFigure!=null) {
		//			Rectangle bound = new Rectangle(((IFigure)container).getBounds());
		//			bound.y = container.getBounds().y + 1;
		//			bound.x = container.getBounds().x + 3;
		//			backgroundFigure.setBounds(bound);	
		//		}
		//		
	}

	/**
	 * Optimize the size of each compartment depending on the size of the
	 * compartments container, and the size of each compartment. If a
	 * compartment is empty, or not expanded, then a default size is applied to
	 * this compartment
	 * 
	 * @param compartmentsDimension
	 *        an hashmap containing each compartment dimension.
	 */
	protected void optimizeCompartmentSize(IFigure container) {
		int compartmentsHeight = 0;
		int notCompartmentsHeight = 0;
		for(int i = 0; i < notCompartmentList.size(); i++) {
			notCompartmentsHeight += notCompartmentList.get(i).getBounds().height;
		}

		for(int i = 0; i < compartmentList.size(); i++) {
			compartmentsHeight += compartmentList.get(i).getBounds().height;
		}
		int remainingspace = container.getBounds().height - notCompartmentsHeight;

		// ratio between the height of all compartments and the size of the
		// compartments container.
		double ratio = new Integer(compartmentsHeight).doubleValue() / new Integer(remainingspace).doubleValue();

		for(int i = 0; i < compartmentList.size(); i++) {
			Rectangle bound = new Rectangle((compartmentList.get(i)).getBounds());
			int value = (int)(bound.height / ratio);
			bound.height = value;
			bound.x = container.getBounds().x;
			if(i > 0) {
				bound.y = (compartmentList.get(i - 1)).getBounds().getBottomLeft().y + 1;

			}
			(compartmentList.get(i)).setBounds(bound);

		}

	}

	/**
	 * use to know what kind of element we have in order to apply the good
	 * policy for the disposition
	 * 
	 * @param container
	 */
	public void collectInformationOnChildren(IFigure container) {
		compartmentList = new ArrayList<IFigure>();
		notCompartmentList = new ArrayList<IFigure>();
		for(int i = 0; i < container.getChildren().size(); i++) {
			if(isAGMFContainer(((IFigure)container.getChildren().get(i)))) {
				compartmentList.add(((IFigure)container.getChildren().get(i)));
			} else if((container.getChildren().get(i)) instanceof Label || (container.getChildren().get(i)) instanceof WrappingLabel || ((container.getChildren().get(i)) instanceof StereotypePropertiesCompartment)) {
				notCompartmentList.add(((IFigure)container.getChildren().get(i)));
			} else {
				if((container.getChildren().get(i)) instanceof ScalableCompartmentFigure) {
					compartmentList.add((IFigure)container.getChildren().get(i));
				}

			}
		}
	}

	/**
	 * obtain a prefered size
	 * 
	 * @param figure
	 *        that can contain a GMF compartment figure
	 * @return a the size
	 */
	public Dimension getPreferedSize(IFigure figure) {
		Dimension dim = figure.getPreferredSize();
		if(figure.getChildren().size() > 0) {
			Object compartment = figure.getChildren().get(0);
			if(compartment instanceof ResizableCompartmentFigure) {
				dim.height = ((ResizableCompartmentFigure)compartment).getPreferredSize().height + 10;
				if(dim.height == 0) {
					dim.height = MINIMUM_COMPARTMENT_HEIGHT;
				}

			}
		}
		return dim;
	}

	/**
	 * tests is the figure contains a GMF compartment
	 * 
	 * @param figure
	 * @return true if this is the case
	 */
	public boolean isAGMFContainer(IFigure figure) {
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
