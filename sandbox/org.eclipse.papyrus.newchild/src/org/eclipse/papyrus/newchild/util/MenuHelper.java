package org.eclipse.papyrus.newchild.util;

import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.papyrus.newchild.MenuGroup;
import org.eclipse.papyrus.newchild.runtime.NewchildManager;


public class MenuHelper {

	public static void add(MenuGroup group, IMenuManager manager, IContributionItem item) {
		if(group == null) {
			manager.add(item);
		} else if(manager.find(group.getBefore()) != null) {
			manager.insertBefore(group.getBefore(), item);
		} else if(manager.find(group.getAfter()) != null) {
			manager.insertAfter(group.getAfter(), item);
		} else if(group.getAbsolutePosition() != null) {
			switch(group.getAbsolutePosition()) {
			case TOP:
				if(manager.find(NewchildManager.TOP) != null) {
					manager.insertBefore(NewchildManager.TOP, item);
					break;
				}
			case BOTTOM:
			default:
				manager.add(item);
				break;
			}
		} else {
			manager.add(item);
		}
	}

}
