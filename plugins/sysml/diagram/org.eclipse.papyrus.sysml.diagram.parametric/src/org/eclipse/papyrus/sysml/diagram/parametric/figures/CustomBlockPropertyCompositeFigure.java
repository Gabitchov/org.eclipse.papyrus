/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		Régis CHEVREL: chevrel.regis <at> gmail.com
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.parametric.figures;

import org.eclipse.draw2d.Label;
import org.eclipse.papyrus.sysml.diagram.common.figure.BlockPropertyCompositeFigure;

public class CustomBlockPropertyCompositeFigure extends
		BlockPropertyCompositeFigure {

	@Override
	protected void initTagLabel(String value) {
		// do nothing: we don't want a two lines element (tag + name)
	}
	
	@Override
	public Label getTaggedLabel() {
		// return a mock Label
		return new Label();
	}
	
	@Override
	public void setNameLabelIcon(boolean displayNameLabelIcon) {
		getNameLabel().setIcon(null);
	}
}
