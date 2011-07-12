package org.eclipse.papyrus.newchild.menu;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.papyrus.newchild.MenuGroup;
import org.eclipse.papyrus.newchild.MenuRoot;


public class FillMenuRoot extends FillMenuContainer {

	protected MenuRoot root;

	public FillMenuRoot(MenuRoot root, Object selectedObject) {
		super(root, selectedObject);

		this.root = root;
	}

	@Override
	public void fill(IMenuManager menuManager) {
		super.fill(menuManager);

		for(MenuGroup group : root.getGroups()) {
			FillerFactory.instance.getFiller(group, selectedObject).fill(menuManager);
		}
	}

}
