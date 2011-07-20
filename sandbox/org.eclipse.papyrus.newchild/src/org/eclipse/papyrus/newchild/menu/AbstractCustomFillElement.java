package org.eclipse.papyrus.newchild.menu;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.papyrus.newchild.CustomFiller;
import org.eclipse.papyrus.newchild.MenuGroup;

/**
 * A base implementation for CustomFillElement
 * 
 * @author Camille Letavernier
 */
public abstract class AbstractCustomFillElement implements CustomFillElement {

	protected MenuGroup group;

	protected CustomFiller filler;

	public void setMenuItem(CustomFiller filler) {
		this.filler = filler;
	}

	public void setParentGroup(MenuGroup group) {
		this.group = group;
	}

	public abstract void fill(IMenuManager menuManager);

}
