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
package org.eclipse.papyrus.uml.diagram.sequence.locator;

import org.eclipse.draw2d.Label;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.papyrus.uml.diagram.common.figure.node.IMultilineEditableFigure;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CellEditorLocators {

	public static CellEditorLocator getTextCellEditorLocator(ITextAwareEditPart source) {
		if(source.getFigure() instanceof IMultilineEditableFigure)
			return new MultilineCellEditorLocator((IMultilineEditableFigure)source.getFigure());
		else if(source.getFigure() instanceof WrappingLabel)
			return new TextCellEditorLocator((WrappingLabel)source.getFigure());
		else if(source.getFigure() instanceof NodeFigure) {
			WrappingLabel wrappingLabel = (WrappingLabel)source.getFigure().getChildren().get(0);
			if(wrappingLabel != null) {
				return new TextCellEditorLocator(wrappingLabel);
			}
			return new LabelCellEditorLocator((Label)source.getFigure());
		} else {
			return new LabelCellEditorLocator((Label)source.getFigure());
		}
	}
}
