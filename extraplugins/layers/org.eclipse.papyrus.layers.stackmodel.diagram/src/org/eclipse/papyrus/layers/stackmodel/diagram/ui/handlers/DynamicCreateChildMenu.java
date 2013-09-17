/*******************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cedric Dumoulin Cedric.dumoulin@lifl.fr
 ******************************************************************************/
package org.eclipse.papyrus.layers.stackmodel.diagram.ui.handlers;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.action.IContributionItem;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.CompoundContributionItem;
import org.eclipse.ui.menus.CommandContributionItem;


/**
 * This class is responsible to create the dynamic menu allowing to create
 * child elements of a Layer Model.
 * 
 * @author cedric dumoulin
 *
 */
public class DynamicCreateChildMenu extends CompoundContributionItem {

	/**
	 * @see org.eclipse.ui.actions.CompoundContributionItem#getContributionItems()
	 *
	 * @return
	 */
	@Override
	protected IContributionItem[] getContributionItems() {
		// TODO Auto-generated method stub
		System.err.println("getContributionItems()");
		IContributionItem[] items = new IContributionItem[1];
		
	    Map<String, String> parms = new HashMap<String, String>();
	    parms.put("groupBy", "Severity");
	    items[0] = new CommandContributionItem(PlatformUI.getWorkbench().getActiveWorkbenchWindow(), null,
	            "org.eclipse.ui.views.problems.grouping",
	            parms, null, null, null, "Severity", null,
	            null, CommandContributionItem.STYLE_PUSH);
		return items;
	}

}
