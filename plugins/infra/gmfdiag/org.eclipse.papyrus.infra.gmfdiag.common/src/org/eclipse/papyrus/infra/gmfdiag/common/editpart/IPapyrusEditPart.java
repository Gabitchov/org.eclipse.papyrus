/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) - Initial API and implementation
 /*****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.editpart;

import org.eclipse.draw2d.IFigure;

/**
 * This is an editPart in which we can get primaryShape to obtain the figure
 * 
 */
public interface IPapyrusEditPart {

	/**
	 * <p>
	 * Returns the primary shape being the View of this edit part.
	 * </p>
	 * <b>Warning</b> It should never return <code>null</code>
	 * 
	 * @return the primary shape associated to this edit part.
	 */
	public IFigure getPrimaryShape();
}
