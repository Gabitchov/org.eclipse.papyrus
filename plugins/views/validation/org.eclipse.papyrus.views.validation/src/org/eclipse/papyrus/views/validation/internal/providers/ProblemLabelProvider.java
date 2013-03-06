/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.validation.internal.providers;

import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ViewerComparator;

/**
 * This is the ProblemLabelProvider type. Enjoy.
 */
public abstract class ProblemLabelProvider
		extends LabelProvider {

	public ProblemLabelProvider() {
		super();
	}

	public CellLabelProvider createCellLabelProvider() {
		return new ProblemCellLabelProvider(this);
	}
	
	public ViewerComparator createSorter() {
		return new LabelProviderSorter(this);
	}
	
}
