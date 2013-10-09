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
package org.eclipse.papyrus.uml.diagram.clazz.custom.edit.part;

import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderItemEditPart;
import org.eclipse.gmf.runtime.notation.View;

/**
 * this a editpart to force the refresh after change the size of the border item
 */
public abstract class AbstractRedefinableTemplateSignatureEditPart extends AbstractBorderItemEditPart {

	public AbstractRedefinableTemplateSignatureEditPart(View view) {
		super(view);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void refreshBounds() {
		super.refreshBounds();
		// ensure refreshing figures
		getFigure().getParent().getLayoutManager().layout(getFigure().getParent());
	}

	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshTransparency();
	}
}
