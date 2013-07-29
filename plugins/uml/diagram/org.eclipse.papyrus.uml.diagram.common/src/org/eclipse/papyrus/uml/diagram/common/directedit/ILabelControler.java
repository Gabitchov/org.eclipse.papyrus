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
 * Interface for a controler that is used to associate a IFigure to model
 * properties in a lightweight way.
 */
public interface ILabelControler {

	/**
	 * Returns the figure associated to this FigureControler.
	 * 
	 * @return the figure associated to this FigureControler
	 */
	public abstract IFigure getLabel();

	/**
	 * Returns the accessors associated to this FigureControler.
	 * 
	 * @return the accessors associated to this FigureControler
	 */
	public abstract PropertyAccessor getPropertyAccessor();

}
