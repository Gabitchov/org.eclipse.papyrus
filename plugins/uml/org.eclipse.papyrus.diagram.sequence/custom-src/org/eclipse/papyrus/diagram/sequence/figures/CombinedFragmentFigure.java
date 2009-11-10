/*****************************************************************************
 * Copyright (c) 2009 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.sequence.figures;

public class CombinedFragmentFigure extends InteractionRectangleFigure {

	@Override
	protected void createContents() {
		super.createContents();
		setShadow(false);
		interactionContentPane.setOutline(false);
		interactionContentPane.setOpaque(false);
		interactionContentPane.setBorder(null);
	}

}
