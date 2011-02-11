/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.table.menu.handler.states;

import org.eclipse.emf.facet.widgets.nattable.api.INatTableWidgetProvider;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;



/**
 * This class provides the state for the Only Common Column Action
 * 
 * 
 * 
 */
public class OnlyCommonColumnsState extends AbstractToggleStateProvider /* implements IStartup */{


	/**
	 * 
	 * @see org.eclipse.table.handler.states.AbstractToggleStateProvider#refreshState()
	 * 
	 */
	@Override
	protected void refreshState() {
		try {
			IEditorPart activeEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
			INatTableWidgetProvider widget = (INatTableWidgetProvider)activeEditor.getAdapter(INatTableWidgetProvider.class);
			if(widget != null) {
				Boolean currentCommandValue = (Boolean)getValue();
				boolean realValue = new Boolean(widget.getNatTableWidget().getTableInstance().isOnlyShowCommonColumns());

				if(!currentCommandValue.equals(realValue)) {
					//change the state of the command
					setValue(realValue);
				}
			} else {
				setValue(false);
			}
		} catch (NullPointerException e) {

		}
	}
}
