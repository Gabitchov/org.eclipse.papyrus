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
package org.eclipse.papyrus.diagram.common.figure.node;

import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;

/**
 * this is the custom figure to manage NamedElement
 * 
 * @author Patrick Tessier
 * @deprecated
 */
public class CNamedElementFigure extends CustomAbstractFigure {

	/** index of the stereotype label */
	private static final int stereotypeIndex = 0;

	/** index of the name of the element **/
	private static final int labelIndex = 1;

	/** index of the qualifiedNamed */
	private static final int qualifiedNameIndex = 2;

	/**
	 * get the name element label of the figure
	 * 
	 * @return the named label
	 */
	public WrappingLabel getElementStereotype() {
		if (getSubFigure(stereotypeIndex) != null && getSubFigure(stereotypeIndex) instanceof WrappingLabel) {
			return ((WrappingLabel) getSubFigure(stereotypeIndex));
		} else
			return null;
	}

	/**
	 * get the name element label of the figure
	 * 
	 * @return the named label
	 */
	public WrappingLabel getElementName() {
		if (getSubFigure(labelIndex) != null && getSubFigure(labelIndex) instanceof WrappingLabel) {
			return ((WrappingLabel) getSubFigure(labelIndex));
		} else
			return null;
	}

	/**
	 * get the qualified named label of this figure
	 * 
	 * @return the qualified name label
	 */
	public WrappingLabel getElementQualifiedName() {
		if (getSubFigure(qualifiedNameIndex) != null && getSubFigure(qualifiedNameIndex) instanceof WrappingLabel) {
			return ((WrappingLabel) getSubFigure(qualifiedNameIndex));
		} else
			return null;
	}

}
