package org.eclipse.papyrus.newchild.menu;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.papyrus.newchild.runtime.DisabledContributionItem;
import org.eclipse.papyrus.newchild.util.MenuHelper;


public class MyCustomFiller extends AbstractCustomFillElement {

	@Override
	public void fill(IMenuManager menuManager) {
		DisabledContributionItem item = new DisabledContributionItem("MyCustomFiller", null, null);
		item.setMenuStyle(true);
		MenuHelper.add(group, menuManager, item);
	}

}
