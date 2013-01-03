/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.edit.policies;

import org.eclipse.papyrus.uml.diagram.timing.custom.figures.LifelineVerticalLabel;
import org.eclipse.papyrus.uml.diagram.timing.edit.policies.UMLTextSelectionEditPolicy;

/** Shows feedback for the selection of a Lifeline name vertical label. */
public class CustomLifelineNameEditPolicy extends UMLTextSelectionEditPolicy {
	@Override
	protected void showPrimarySelection() {
		final LifelineVerticalLabel label = (LifelineVerticalLabel) getHostFigure();
		label.setSelected(true);
		label.setFocus(true);
	}

	@Override
	protected void showSelection() {
		final LifelineVerticalLabel label = (LifelineVerticalLabel) getHostFigure();
		label.setSelected(true);
		label.setFocus(false);
	}

	@Override
	protected void hideSelection() {
		final LifelineVerticalLabel label = (LifelineVerticalLabel) getHostFigure();
		label.setSelected(false);
		label.setFocus(false);
	}

	@Override
	protected void showFocus() {
		final LifelineVerticalLabel label = (LifelineVerticalLabel) getHostFigure();
		label.setFocus(true);
	}

	@Override
	protected void hideFocus() {
		final LifelineVerticalLabel label = (LifelineVerticalLabel) getHostFigure();
		label.setFocus(false);
	}
}
