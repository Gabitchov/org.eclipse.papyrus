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
package org.eclipse.papyrus.infra.emf.newchild.menu;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.papyrus.infra.emf.newchild.MenuGroup;
import org.eclipse.papyrus.infra.emf.newchild.MenuItem;
import org.eclipse.papyrus.infra.emf.newchild.runtime.NewchildManager;


public class FillMenuGroup extends FillMenuContainer {

	private static String TOP_SEP = "TMP_GROUP#TOP"; //$NON-NLS-1$

	private static String END_SEP = "TMP_GROUP#END"; //$NON-NLS-1$

	protected MenuGroup group;

	protected String groupId = TOP_SEP;

	public FillMenuGroup(MenuGroup group, Object selectedObject) {
		super(group, selectedObject);
		this.group = group;
	}

	@Override
	public void fill(IMenuManager manager) {

		Separator tmpSeparator = new Separator(groupId);

		if(manager.find(group.getBefore()) != null) {
			manager.insertBefore(group.getBefore(), tmpSeparator);
		} else if(manager.find(group.getAfter()) != null) {
			manager.insertAfter(group.getAfter(), tmpSeparator);
		} else if(group.getAbsolutePosition() != null) {
			switch(group.getAbsolutePosition()) {
			case TOP:
				if(manager.find(NewchildManager.TOP) != null) {
					manager.insertAfter(NewchildManager.TOP, tmpSeparator);
					break;
				}
			case BOTTOM:
			default:
				manager.add(tmpSeparator);
				break;
			}
		}

		Separator endSeparator = new Separator(END_SEP);
		manager.insertAfter(TOP_SEP, endSeparator);

		for(MenuItem menuItem : container.getSubmenus()) {
			FillElement filler = FillerFactory.instance.getFiller(this, menuItem, selectedObject);
			if(filler != null) {
				filler.fill(manager);
			}
		}

		manager.remove(tmpSeparator);
		manager.remove(endSeparator);
	}

	public String getGroupId() {
		return groupId;
	}

}
