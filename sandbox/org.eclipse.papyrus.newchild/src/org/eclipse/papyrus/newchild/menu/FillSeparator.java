package org.eclipse.papyrus.newchild.menu;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.papyrus.newchild.MenuGroup;
import org.eclipse.papyrus.newchild.Separator;
import org.eclipse.papyrus.newchild.util.MenuHelper;


public class FillSeparator implements FillElement {

	protected Separator separator;

	protected MenuGroup group;

	public FillSeparator(MenuGroup parentGroup, Separator separator) {
		this.separator = separator;
		this.group = parentGroup;
	}

	public void fill(IMenuManager menuManager) {
		MenuHelper.add(group, menuManager, new org.eclipse.jface.action.Separator());
	}

}
