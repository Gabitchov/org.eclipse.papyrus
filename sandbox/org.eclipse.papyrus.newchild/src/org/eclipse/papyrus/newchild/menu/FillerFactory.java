package org.eclipse.papyrus.newchild.menu;

import org.eclipse.papyrus.newchild.Menu;
import org.eclipse.papyrus.newchild.MenuContainer;
import org.eclipse.papyrus.newchild.MenuGroup;
import org.eclipse.papyrus.newchild.MenuItem;
import org.eclipse.papyrus.newchild.MenuRoot;
import org.eclipse.papyrus.newchild.NewChildMenu;
import org.eclipse.papyrus.newchild.NewSiblingMenu;
import org.eclipse.papyrus.newchild.Separator;


public class FillerFactory {

	public static FillerFactory instance = new FillerFactory();

	public FillElement getFiller(MenuGroup parentGroup, MenuItem menuItem, Object selectedObject) {
		if(menuItem instanceof NewChildMenu) {
			return new FillNewChild(parentGroup, (Menu)menuItem, selectedObject);
		}

		if(menuItem instanceof NewSiblingMenu) {
			return new FillNewSibling(parentGroup, (Menu)menuItem, selectedObject);
		}

		if(menuItem instanceof Separator) {
			return new FillSeparator(parentGroup, (Separator)menuItem);
		}

		if(menuItem instanceof Menu) {
			return new FillMenu(parentGroup, (Menu)menuItem, selectedObject);
		}

		return null;
	}

	public FillElement getFiller(MenuItem menuItem, Object selectedObject) {
		return getFiller(null, menuItem, selectedObject);
	}

	public FillElement getFiller(MenuContainer container, Object selectedObject) {
		if(container instanceof MenuGroup) {
			return new FillMenuGroup((MenuGroup)container, selectedObject);
		} else if(container instanceof MenuRoot) {
			return new FillMenuRoot((MenuRoot)container, selectedObject);
		}

		return null;
	}

	private FillerFactory() {

	}
}
