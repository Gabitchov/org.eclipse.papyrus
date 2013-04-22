/*****************************************************************************
 * Copyright (c) 2010 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.edit.parts;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.sequence.util.ElementIconUtil;
import org.eclipse.swt.graphics.Image;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CustomInteractionUseNameEditPart extends InteractionUseNameEditPart {

	/**
	 * Constructor.
	 * 
	 * @param view
	 */
	public CustomInteractionUseNameEditPart(View view) {
		super(view);
	}

	protected Image getLabelIcon() {
		return ElementIconUtil.getLabelIcon(this);
	}
}
