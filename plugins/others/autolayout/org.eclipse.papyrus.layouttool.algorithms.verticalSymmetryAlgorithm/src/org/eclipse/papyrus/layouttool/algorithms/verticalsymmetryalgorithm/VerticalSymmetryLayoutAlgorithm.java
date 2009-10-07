/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Allanic Alexia (Atos Origin) alexia.allanic@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.layouttool.algorithms.verticalsymmetryalgorithm;

import org.eclipse.zest.layouts.LayoutStyles;
import org.eclipse.zest.layouts.algorithms.AbstractLayoutAlgorithm;
import org.eclipse.zest.layouts.dataStructures.InternalNode;
import org.eclipse.zest.layouts.dataStructures.InternalRelationship;

/**
 * The Class VerticalSymmetryLayoutAlgorithm.
 */
public class VerticalSymmetryLayoutAlgorithm extends AbstractLayoutAlgorithm {

	/**
	 * Instantiates a new vertical symmetry layout algorithm.
	 * 
	 * @param styles
	 *            the styles
	 */
	public VerticalSymmetryLayoutAlgorithm(int styles) {
		super(styles);
	}

	/**
	 * Instantiates a new vertical symmetry layout algorithm.
	 */
	public VerticalSymmetryLayoutAlgorithm() {
		this(LayoutStyles.NONE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.zest.layouts.algorithms.AbstractLayoutAlgorithm#applyLayoutInternal(org.eclipse
	 * .zest.layouts.dataStructures.InternalNode[],
	 * org.eclipse.zest.layouts.dataStructures.InternalRelationship[], double, double, double,
	 * double)
	 */
	@Override
	protected void applyLayoutInternal(InternalNode[] entitiesToLayout, InternalRelationship[] relationshipsToConsider,
			double boundsX, double boundsY, double boundsWidth, double boundsHeight) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.zest.layouts.algorithms.AbstractLayoutAlgorithm#getCurrentLayoutStep()
	 */
	@Override
	protected int getCurrentLayoutStep() {
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.zest.layouts.algorithms.AbstractLayoutAlgorithm#getTotalNumberOfLayoutSteps()
	 */
	@Override
	protected int getTotalNumberOfLayoutSteps() {
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.zest.layouts.algorithms.AbstractLayoutAlgorithm#isValidConfiguration(boolean,
	 * boolean)
	 */
	@Override
	protected boolean isValidConfiguration(boolean asynchronous, boolean continuous) {
		if (asynchronous && continuous) {
			return false;
		} else if (asynchronous && !continuous) {
			return true;
		} else if (!asynchronous && continuous) {
			return false;
		} else if (!asynchronous && !continuous) {
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.zest.layouts.algorithms.AbstractLayoutAlgorithm#postLayoutAlgorithm(org.eclipse
	 * .zest.layouts.dataStructures.InternalNode[],
	 * org.eclipse.zest.layouts.dataStructures.InternalRelationship[])
	 */
	@Override
	protected void postLayoutAlgorithm(InternalNode[] entitiesToLayout, InternalRelationship[] relationshipsToConsider) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.zest.layouts.algorithms.AbstractLayoutAlgorithm#preLayoutAlgorithm(org.eclipse
	 * .zest.layouts.dataStructures.InternalNode[],
	 * org.eclipse.zest.layouts.dataStructures.InternalRelationship[], double, double, double,
	 * double)
	 */
	@Override
	protected void preLayoutAlgorithm(InternalNode[] entitiesToLayout, InternalRelationship[] relationshipsToConsider,
			double x, double y, double width, double height) {
		double middle = calculateMiddleArea(x, width);
		for (InternalNode node : entitiesToLayout) {
			node.setLocation((middle + (middle - node.getInternalX())) - node.getWidthInLayout(), node.getInternalY());
		}
	}

	/**
	 * Calculate middle area.
	 * 
	 * @param x
	 *            the x
	 * @param width
	 *            the width
	 * 
	 * @return the double
	 */
	private double calculateMiddleArea(double x, double width) {
		return x + ((width - x) / 2);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.zest.layouts.algorithms.AbstractLayoutAlgorithm#setLayoutArea(double,
	 * double, double, double)
	 */
	@Override
	public void setLayoutArea(double x, double y, double width, double height) {

	}

}
