/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.uml.diagram.clazz.custom.figure;

/**
 * the figure of a instance specification link
 * it contains moreover two label to display roles
 */
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.papyrus.uml.diagram.common.figure.edge.UMLEdgeFigure;

public class InstanceSpecificationLinkFigure extends UMLEdgeFigure {

	protected WrappingLabel targetLabel;

	protected WrappingLabel sourceLabel;

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public InstanceSpecificationLinkFigure() {
		super();
		targetLabel = new WrappingLabel();
		this.add(targetLabel);
		sourceLabel = new WrappingLabel();
		this.add(sourceLabel);
	}

	/**
	 * 
	 * @return the label of the target, never null
	 */
	public WrappingLabel getTargetLabel() {
		return targetLabel;
	}

	/**
	 * 
	 * @return return the source of the label, never null
	 */
	public WrappingLabel getSourceLabel() {
		return sourceLabel;
	}
}
