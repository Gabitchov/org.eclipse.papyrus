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
 *  Jeremie Belmudes (Atos Origin) Jeremie.Belmudes@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.documentation.view;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Control;

/**
 * Interface representing a text widget
 * @author jbelmude
 *
 */
public interface IText {

	/** makes the widget editable or not */
	void setEditable(boolean isChangeable);

	/** makes the widget enable or not */
	void setEnabled(boolean isChangeable);

	/** set the layout data for the text widget */
	void setLayoutData(Object layoutData);

	/** get the global control for the widget */
	Control getControl();

	/** set a specific text to the widget */
	void setText(String string);

	/** get the text of the widget */
	String getText();

	/** changes the background color of the widget */
	void setBackground(Color color);

	/** changes the foreground color of the widget */
    void setForeground(Color color);

	/** get the control corresponding to the text for the widget */
	Control getTextControl();
	
}
