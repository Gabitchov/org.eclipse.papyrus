package org.eclipse.papyrus.diagram.clazz.navigator;

import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.papyrus.diagram.clazz.part.UMLVisualIDRegistry;

/**
 * @generated
 */
public class UMLNavigatorSorter extends ViewerSorter {

	/**
	 * @generated
	 */
	private static final int GROUP_CATEGORY = 7040;

	/**
	 * @generated
	 */
	public int category(Object element) {
		if(element instanceof UMLNavigatorItem) {
			UMLNavigatorItem item = (UMLNavigatorItem)element;
			return UMLVisualIDRegistry.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}
