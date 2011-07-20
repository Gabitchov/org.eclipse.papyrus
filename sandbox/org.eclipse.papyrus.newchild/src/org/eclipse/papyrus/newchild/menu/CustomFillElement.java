package org.eclipse.papyrus.newchild.menu;

import org.eclipse.papyrus.newchild.CustomFiller;
import org.eclipse.papyrus.newchild.MenuGroup;

/**
 * An interface for Custom menu filler
 * 
 * @author Camille Letavernier
 */
public interface CustomFillElement extends FillElement {

	public void setMenuItem(CustomFiller filler);

	public void setParentGroup(MenuGroup group);

}
