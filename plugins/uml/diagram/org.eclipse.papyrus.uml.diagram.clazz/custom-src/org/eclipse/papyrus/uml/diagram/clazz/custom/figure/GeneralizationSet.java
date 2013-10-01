/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.clazz.custom.figure;

import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.papyrus.uml.diagram.common.figure.edge.DashedEdgeFigure;

/**
 * this class is used to display the figure of GeneralizationSet
 */
public class GeneralizationSet extends DashedEdgeFigure {

	private WrappingLabel constraintLabel = null;

	/**
	 * Constructor
	 */
	public GeneralizationSet() {
		super(false);
		constraintLabel = new WrappingLabel();
		this.add(constraintLabel);
	}

	/**
	 * obtain the label to display the constraint
	 * 
	 * @return the label to display the constraint
	 */
	public WrappingLabel getConstraintLabel() {
		return constraintLabel;
	}
}
