/*****************************************************************************
 * Copyright (c) 2009-2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.composite.custom.figures;

import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.papyrus.uml.diagram.common.figure.edge.DashedEdgeFigure;

/**
 * Figure for RoleBinding representation. This element is a dependency used to bind roles from the
 * type of a CollaborationUse to ConnectableElement(s) owned by the Structured.
 */
public class RoleBindingFigure extends DashedEdgeFigure {

	/** Owned label for RoleBinding Role **/
	protected WrappingLabel roleLabel;

	/**
	 * Default constructor
	 */
	public RoleBindingFigure() {
		super(false);
		createContents();
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	protected void createContents() {
		super.createContents();

		roleLabel = new WrappingLabel();
		roleLabel.setTextWrap(true);
		this.add(roleLabel);
	}

	/**
	 * Gets the RoleBinding role label.
	 * 
	 * @return the RoleBinding role label
	 */
	public WrappingLabel getRoleLabel() {
		return roleLabel;
	}
}
