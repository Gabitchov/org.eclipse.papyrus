/*****************************************************************************
 * Copyright (c) 2011 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *	
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.draw2d;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * Layout to create a row (or colunm) layout All children will be displayer
 * under the previous one You can add constraint with {@link FlowLayoutAdvancedConstraint}
 * 
 * @author arthur daussy - arthur.daussy@atosorigin.com
 * 
 */
public class FlowLayoutAdvanced extends FlowLayout {

	/***
	 * Orientation of the layout
	 * 
	 * @author adaussy
	 * 
	 */
	public enum Orientation {
		HORIZONTAL, VERTICAL
	}

	/**
	 * Not implemented yet TODO
	 */
	private Orientation orientation = Orientation.VERTICAL;

	private Map<IFigure, Object> constraints = new HashMap<IFigure, Object>();

	protected void setBoundsOfChild(IFigure parent, IFigure child, Rectangle bounds) {
		parent.getClientArea(Rectangle.SINGLETON);
		bounds.translate(Rectangle.SINGLETON.x, Rectangle.SINGLETON.y);
		Dimension childDim = this.getChildSize(child, Rectangle.SINGLETON.width, Rectangle.SINGLETON.height).getCopy();
		bounds.setSize(childDim);
		Object _constraint = getConstraint(child);
		if(_constraint instanceof FlowLayoutAdvancedConstraint) {
			FlowLayoutAdvancedConstraint constraint = (FlowLayoutAdvancedConstraint)_constraint;
			if(constraint != null) {
				if(constraint.isFill()) {
					if(Orientation.VERTICAL.equals(orientation)) {
						bounds.setSize(bounds.getSize().getCopy().width, getAvailableSpaceForFilledElement(child, Rectangle.SINGLETON.getSize().getCopy()).getCopy().height);
					} else {
						bounds.setSize(getAvailableSpaceForFilledElement(child, Rectangle.SINGLETON.getSize().getCopy()).getCopy().width, bounds.getSize().getCopy().height);
					}
				}
				if(constraint.isFull()) {
					bounds.setSize(Rectangle.SINGLETON.getSize().getCopy());
					bounds.setLocation(Rectangle.SINGLETON.getLocation().getCopy());
				}
			}
		}
		child.setBounds(bounds);
	}

	public Object getConstraint(IFigure child) {
		return constraints.get(child);
	}

	/**
	 * 
	 * @see org.eclipse.draw2d.AbstractLayout#setConstraint(org.eclipse.draw2d.IFigure, java.lang.Object) Use this kind of constraint
	 *      {@link FlowLayoutAdvancedConstraint}
	 * @param child
	 * @param constraint
	 */
	public void setConstraint(IFigure child, Object constraint) {
		if(constraint instanceof FlowLayoutAdvancedConstraint || constraint == null) {
			constraints.put(child, constraint);
		}
	}

	private Dimension getAvailableSpaceForFilledElement(IFigure currentChild, Dimension parentDim) {
		Set<IFigure> children = constraints.keySet();
		if(children.isEmpty()) {
			throw new RuntimeException("Current layout is not set on any figure");// TODO
																					// externalize
		}
		int numberOfFilledElement = 0;
		for(Object _child : children) {
			if(_child instanceof IFigure) {
				IFigure child = (IFigure)_child;
				if(constraints.containsKey(child)) {
					FlowLayoutAdvancedConstraint localConstraint = (FlowLayoutAdvancedConstraint)constraints.get(child);
					if(localConstraint != null && localConstraint.isFill()) {
						numberOfFilledElement++;
					}
				}
				/*
				 * TODO set with the orientation attribute
				 */
				if(!child.equals(currentChild)) {
					parentDim = parentDim.getShrinked(0, getChildSize(child, Rectangle.SINGLETON.width, Rectangle.SINGLETON.height).height);
				}
			}
		}
		if(Orientation.VERTICAL.equals(orientation)) {
			parentDim.setHeight((int)((float)parentDim.height / (float)numberOfFilledElement));
			// parentDim.setWidth(0);
		} else {
			parentDim.setWidth((int)((float)parentDim.width / (float)numberOfFilledElement));
			// parentDim.setHeight(0);
		}
		return parentDim;
	}

	public Orientation getOrientation() {
		return orientation;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}

	@Override
	public Dimension getMinimumSize(IFigure container, int w, int h) {
		Dimension minDim = null;
		for(IFigure figure : constraints.keySet()) {
			Object _c = constraints.get(figure);
			if(_c instanceof FlowLayoutAdvancedConstraint) {
				FlowLayoutAdvancedConstraint constraint = (FlowLayoutAdvancedConstraint)_c;
				if(constraint.isHasMinsize()) {
					if(minDim == null) {
						minDim = figure.getMinimumSize();
					} else {
						minDim = Dimension.min(minDim, figure.getMinimumSize());
					}
				}
			}
		}
		if(minDim == null) {
			minDim = new Dimension(0, 0);
		}
		return minDim;
	}
}
