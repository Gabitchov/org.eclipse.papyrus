/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.search.ui.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.papyrus.uml.search.ui.Activator;
import org.eclipse.papyrus.uml.search.ui.Messages;
import org.eclipse.papyrus.uml.search.ui.dialogs.TypesFilterDialog;
import org.eclipse.search.ui.text.AbstractTextSearchViewPage;

import com.swtdesigner.ResourceManager;

/**
 * 
 * Action that opens a {@link org.eclipse.papyrus.uml.search.ui.dialogs.TypesFilterDialog} in order to filter search results
 * 
 */
public class FilterTypesAction extends Action {

	private AbstractTextSearchViewPage fPage;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param page
	 *        the result page whose results while be filtered
	 */
	public FilterTypesAction(AbstractTextSearchViewPage page) {
		fPage = page;
		setText(Messages.FilterTypesAction_0);
		setToolTipText(Messages.FilterTypesAction_1);
		this.setImageDescriptor(ResourceManager.getPluginImageDescriptor(Activator.PLUGIN_ID, "icons/filter.png")); //$NON-NLS-1$
	}

	/**
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 * 
	 */
	@Override
	public void run() {
		TypesFilterDialog typesFilterDialog = new TypesFilterDialog(null, fPage);
		typesFilterDialog.open();

	}
}
