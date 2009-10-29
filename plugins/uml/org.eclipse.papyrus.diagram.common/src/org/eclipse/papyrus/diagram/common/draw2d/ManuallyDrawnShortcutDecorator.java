/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana .
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Francisco Javier Cano MuÃ±oz (Prodevelop) - initial API implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.common.draw2d;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.AbstractDecorator;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;

/**
 * Workaround for #214160 and #209802 -- in some cases SWT fails to paint Images correctly. Until
 * its fixed, we are going to show draw2d polyline based decorations instead of image-based
 */
// @unused
public class ManuallyDrawnShortcutDecorator extends AbstractDecorator {

	// @unused
	public ManuallyDrawnShortcutDecorator(IDecoratorTarget decoratorTarget) {
		super(decoratorTarget);
	}

	public void activate() {
		refresh();
	}

	public void refresh() {
		removeDecoration();
		EditPart editPart = (EditPart) getDecoratorTarget().getAdapter(EditPart.class);
		if (editPart instanceof ShapeEditPart) {
			setDecoration(getDecoratorTarget().addShapeDecoration(new ManuallyDrawnShortcutDecorationFigure(),
					IDecoratorTarget.Direction.SOUTH_WEST, 0, false));
		} else if (editPart instanceof ConnectionEditPart) {
			setDecoration(getDecoratorTarget().addConnectionDecoration(new ManuallyDrawnShortcutDecorationFigure(), 50,
					false));
		}
	}

}
