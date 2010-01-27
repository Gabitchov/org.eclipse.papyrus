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
package org.eclipse.papyrus.layouttool.algorithms.horizontalsymmetryalgorithm;

import org.eclipse.papyrus.layouttool.managealgorithms.AlgorithmFactory;
import org.eclipse.zest.layouts.LayoutStyles;
import org.eclipse.zest.layouts.algorithms.AbstractLayoutAlgorithm;

/**
 * The Class HorizontalSymmetryAlgorithm.
 */
public class HorizontalSymmetryAlgorithm implements AlgorithmFactory {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.layouttool.managealgorithms.AlgorithmFactory#createAlgorithm()
	 */
	public AbstractLayoutAlgorithm createAlgorithm() {
		return new HorizontalSymmetryLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING);
	}

}
