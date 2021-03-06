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
package org.eclipse.papyrus.diagram.tests.canonical;

import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;

/**
 * The Class TestTopNode.
 */
public abstract class TestTopNode extends AbstractTestNode {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected IGraphicalEditPart getContainerEditPart() {
		return getDiagramEditPart();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected View getRootView() {
		return (View)getContainerEditPart().getModel();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected boolean isSemanticTest() {
		return true;
	}
}
