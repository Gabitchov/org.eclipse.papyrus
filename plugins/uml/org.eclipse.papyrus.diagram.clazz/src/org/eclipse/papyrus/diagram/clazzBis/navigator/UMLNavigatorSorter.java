package org.eclipse.papyrus.diagram.clazzBis.navigator;

import org.eclipse.jface.viewers.ViewerSorter;

/**
 * @generated
 */
public class UMLNavigatorSorter extends ViewerSorter {

	/**
	 * @generated
	 */
	private static final int GROUP_CATEGORY = 5036;

	/**
	 * @generated
	 */
	public int category(Object element) {
		if (element instanceof org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorItem) {
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorItem item = (org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorItem) element;
			return org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}
