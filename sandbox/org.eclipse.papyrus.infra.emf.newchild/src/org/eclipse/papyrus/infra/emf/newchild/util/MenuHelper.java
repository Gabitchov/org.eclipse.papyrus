/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.newchild.util;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.papyrus.infra.emf.newchild.menu.FillMenuGroup;


public class MenuHelper {

	public static void add(FillMenuGroup group, IMenuManager manager, IContributionItem item) {
		if(group == null) {
			manager.add(item);
		} else {
			manager.appendToGroup(group.getGroupId(), item);
		}
	}

	public static void add(FillMenuGroup group, IMenuManager manager, Action action) {
		add(group, manager, new ActionContributionItem(action));
	}

}
