package org.eclipse.papyrus.newchild.menu;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.papyrus.newchild.Menu;
import org.eclipse.papyrus.newchild.MenuGroup;
import org.eclipse.papyrus.newchild.util.Util;


public class FillMenu extends FillMenuContainer {

	protected Menu menu;

	protected MenuGroup parentGroup;

	public FillMenu(MenuGroup parentGroup, Menu menu, Object selectedObject) {
		super(menu, selectedObject);
		this.menu = menu;
		this.parentGroup = parentGroup;
	}

	@Override
	public void fill(IMenuManager menuManager) {
		MenuManager subMenuManager = new MenuManager(menu.getName(), Util.getImage(menu), menu.getId());
		super.fill(subMenuManager);
	}
}
