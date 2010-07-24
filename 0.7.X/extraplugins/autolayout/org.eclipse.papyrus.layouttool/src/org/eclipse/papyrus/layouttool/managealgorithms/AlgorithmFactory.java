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
 *  Alexia Allanic (Atos Origin) alexia.allanic@atosorigin.com - AlgorithmFactory Implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.layouttool.managealgorithms;

import org.eclipse.zest.layouts.algorithms.AbstractLayoutAlgorithm;

/**
 * The class AlgorithmFactory.
 */
public interface AlgorithmFactory {

	/**
	 * Creates the algorithm.
	 * 
	 * @return algorithm
	 */
	AbstractLayoutAlgorithm createAlgorithm();
}
