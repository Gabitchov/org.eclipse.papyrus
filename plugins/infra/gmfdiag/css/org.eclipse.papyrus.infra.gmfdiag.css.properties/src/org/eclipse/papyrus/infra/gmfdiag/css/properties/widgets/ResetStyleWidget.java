/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.css.properties.widgets;

import java.util.HashMap;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.papyrus.infra.gmfdiag.css.handler.ResetStyleHandler;
import org.eclipse.papyrus.infra.gmfdiag.css.properties.Activator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;


public class ResetStyleWidget implements SelectionListener {

	private Button button;

	public ResetStyleWidget(Composite parent, int style) {
		button = new Button(parent, SWT.PUSH);
		button.addSelectionListener(this);
		button.setText("Default style");
		button.setToolTipText("Resets the properties which have been customized outside of the Style support. The default style will be applied");
	}

	public void widgetSelected(SelectionEvent event) {
		if(event.widget != button) {
			return;
		}

		ResetStyleHandler handler = new ResetStyleHandler();
		try {
			//FIXME: The ExecutionEvent needs the EclipseContext
			handler.execute(new ExecutionEvent(null, new HashMap<String, String>(), event, null));
		} catch (ExecutionException ex) {
			Activator.log.error(ex);
		}
	}

	public void widgetDefaultSelected(SelectionEvent e) {
		//Nothing
	}

	public void setText(String text) {
		button.setText(text);
	}

	public String getText() {
		return button.getText();
	}

	public void setToolTipText(String tooltip) {
		button.setToolTipText(tooltip);
	}

	public String getToolTipText() {
		return button.getToolTipText();
	}
}
