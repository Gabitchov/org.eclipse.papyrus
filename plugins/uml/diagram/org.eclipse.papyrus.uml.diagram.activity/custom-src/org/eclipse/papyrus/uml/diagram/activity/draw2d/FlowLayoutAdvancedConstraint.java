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

/**
 * Constraint used for FlowAdvancedLayout
 * 
 * @author Arthur Daussy - arthur.daussy@atosorigin.com
 * 
 */
public class FlowLayoutAdvancedConstraint {

	/**
	 * If true then the figure take all the free space left (divided by the
	 * number of fill element (An element is event full or fill)
	 */
	private boolean fill;

	/**
	 * If true then the figure take the same size than the parent (An element is
	 * event full or fill)
	 */
	private boolean full;

	/**
	 * Has minimum size
	 */
	private boolean hasMinsize;

	/**
	 * 
	 * Constructor. Init all contants to false
	 */
	public FlowLayoutAdvancedConstraint() {
		super();
		fill = false;
		full = false;
		hasMinsize = false;
	}

	/**
	 * {@link #fill}
	 * 
	 * @param fill
	 */
	public void setFill(boolean fill) {
		if(fill) {
			full = false;
		}
		this.fill = fill;
	}

	/**
	 * {@link #fill}
	 * 
	 * @return
	 */
	public boolean isFull() {
		return full;
	}

	/**
	 * {@link #full}
	 * 
	 * @param full
	 */
	public void setFull(boolean full) {
		if(full) {
			fill = false;
		}
		this.full = full;
	}

	/**
	 * {@link #full}
	 * 
	 * @return
	 */
	public boolean isFill() {
		return fill;
	}

	/**
	 * {@link #hasMinsize}
	 * 
	 * @return
	 */
	public boolean isHasMinsize() {
		return hasMinsize;
	}

	/**
	 * {@link #hasMinsize}
	 * 
	 * @param hasMinsize
	 */
	public void setHasMinsize(boolean hasMinsize) {
		this.hasMinsize = hasMinsize;
	}
}
