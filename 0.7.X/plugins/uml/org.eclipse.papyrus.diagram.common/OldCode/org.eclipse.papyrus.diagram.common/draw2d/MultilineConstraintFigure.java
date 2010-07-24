/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Michael Golubev (Borland) - initial API and implementation
 */
package org.eclipse.papyrus.diagram.common.draw2d;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel;

/**
 * XXX: It is temporary hack.
 * 
 * To be removed when GMF graph will support multiline labels. If it is not achiveable, move this
 * into the generation using custom viewmap attributes.
 */
public class MultilineConstraintFigure extends ConstraintFigureBase {

	@Override
	public void add(IFigure figure, Object constraint, int index) {
		if (figure instanceof WrapLabel) {
			((WrapLabel) figure).setTextWrap(true);
		}
		super.add(figure, constraint, index);
	}
}
