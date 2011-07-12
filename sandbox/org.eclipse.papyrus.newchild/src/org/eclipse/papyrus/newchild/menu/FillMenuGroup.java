package org.eclipse.papyrus.newchild.menu;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.papyrus.newchild.MenuGroup;
import org.eclipse.papyrus.newchild.MenuItem;


public class FillMenuGroup extends FillMenuContainer {

	protected MenuGroup group;

	public FillMenuGroup(MenuGroup group, Object selectedObject) {
		super(group, selectedObject);
		this.group = group;
	}

	@Override
	public void fill(IMenuManager menuManager) {
		for(MenuItem menuItem : container.getSubmenus()) {
			FillElement filler = FillerFactory.instance.getFiller(group, menuItem, selectedObject);
			filler.fill(menuManager);
		}
	}

}
