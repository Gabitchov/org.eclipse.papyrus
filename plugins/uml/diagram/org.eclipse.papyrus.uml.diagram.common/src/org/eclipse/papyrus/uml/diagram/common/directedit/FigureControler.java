/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
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
package org.eclipse.papyrus.uml.diagram.common.directedit;

import org.eclipse.draw2d.IFigure;

/**
 * A figure controler is used to associate a IFigure to model properties in a
 * lightweight way.
 */
public class FigureControler implements ILabelControler {

	/**
	 * 
	 */
	private IFigure figure;

	/**
	 * 
	 */
	private PropertyAccessor propertyAccessor;

	/**
	 * Creates a new FigureControler.
	 * 
	 * @param figure
	 *        the figure to be associated
	 * @param propertyAccessor
	 *        the accessor for the properties associated to the figure.
	 */
	public FigureControler(IFigure figure, PropertyAccessor propertyAccessor) {
		this.figure = figure;
		this.propertyAccessor = propertyAccessor;
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public IFigure getLabel() {
		return figure;
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public PropertyAccessor getPropertyAccessor() {
		return propertyAccessor;
	}

}
