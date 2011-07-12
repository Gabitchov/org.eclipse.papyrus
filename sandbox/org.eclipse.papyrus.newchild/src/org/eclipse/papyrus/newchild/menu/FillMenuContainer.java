package org.eclipse.papyrus.newchild.menu;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.papyrus.newchild.MenuContainer;
import org.eclipse.papyrus.newchild.MenuItem;


public class FillMenuContainer implements FillElement {

	protected MenuContainer container;

	protected Object selectedObject;

	public FillMenuContainer(MenuContainer container, Object selectedObject) {
		this.container = container;
		this.selectedObject = selectedObject;
	}

	public void fill(IMenuManager menuManager) {
		for(MenuItem menuItem : container.getSubmenus()) {
			FillElement filler = FillerFactory.instance.getFiller(menuItem, selectedObject);
			filler.fill(menuManager);
		}
	}

}
