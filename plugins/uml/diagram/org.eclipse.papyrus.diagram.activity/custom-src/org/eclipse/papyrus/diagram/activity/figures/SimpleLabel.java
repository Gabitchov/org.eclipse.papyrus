/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
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
package org.eclipse.papyrus.diagram.activity.figures;

import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.text.FlowContext;
import org.eclipse.draw2d.text.ParagraphTextLayout;
import org.eclipse.draw2d.text.TextFlow;
import org.eclipse.draw2d.text.TextLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;

/**
 * This class is a {@link WrappingLabel}, which default behavior is set differently :
 * 
 * The text is centered and does not wrap on several lines.
 */
public class SimpleLabel extends WrappingLabel {

	/**
	 * Construct an empty wrapping label with customized alignment.
	 */
	public SimpleLabel() {
		super();
		setTextJustification(WrappingLabel.CENTER);
		setAlignment(WrappingLabel.CENTER);
		setTextWrap(true);

		// ensure wrapping performed at line breaks only (no auto wrap)
		if(getTextFigure().getChildren().size() > 0) {
			Object textFigChild = getTextFigure().getChildren().get(0);
			LayoutManager layoutMgr = getTextFigure().getLayoutManager();
			if(textFigChild instanceof TextFlow && layoutMgr instanceof FlowContext) {
				TextFlow textFlow = (TextFlow)textFigChild;
				TextLayout layout = new ParagraphTextLayout(textFlow, ParagraphTextLayout.WORD_WRAP_HARD);
				layout.setFlowContext((FlowContext)layoutMgr);
				textFlow.setLayoutManager(layout);
			}
		}
	}
}
