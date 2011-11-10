/*******************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Nicolas Guyomar (Mia-Software) - Bug 335020 - Nattable widget should use the Eclipse framework
 *******************************************************************************/
package org.eclipse.papyrus.infra.table.menu.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.facet.widgets.nattable.INatTableWidget;
import org.eclipse.emf.facet.widgets.nattable.INatTableWidgetProvider;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * This class provides the handler to hide or show the empty column
 * 
 * 
 * 
 */
public class HideEmptyColumnsHandler extends AbstractHandler {

	/**
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 * 
	 * @param event
	 * @return
	 * @throws ExecutionException
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IEditorPart editor = HandlerUtil.getActiveEditor(event);
		INatTableWidgetProvider provider = (INatTableWidgetProvider)editor.getAdapter(INatTableWidgetProvider.class);
		if(provider != null) {
			INatTableWidget widget = provider.getNatTableWidget();
			widget.setHideEmptyColumns(!widget.getTableInstance().isHideEmptyColumns());
			//change the state of the command
			HandlerUtil.toggleCommandState(event.getCommand());
		}
		return null;
	}

}
