package org.eclipse.papyrus.newchild.menu;

import org.eclipse.papyrus.newchild.Menu;
import org.eclipse.papyrus.newchild.MenuGroup;
import org.eclipse.papyrus.newchild.util.EMFHelper;


public class FillNewSibling extends FillNewChild {

	public FillNewSibling(MenuGroup parentGroup, Menu menu, Object selectedObject) {
		super(parentGroup, menu, EMFHelper.getEObject(selectedObject) != null ? EMFHelper.getEObject(selectedObject).eContainer() : selectedObject);
	}

}
