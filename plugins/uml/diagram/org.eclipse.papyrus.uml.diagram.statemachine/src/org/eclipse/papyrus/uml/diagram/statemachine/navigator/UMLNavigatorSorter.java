package org.eclipse.papyrus.uml.diagram.statemachine.navigator;

import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.papyrus.uml.diagram.statemachine.part.UMLVisualIDRegistry;

/**
 * @generated
 */
public class UMLNavigatorSorter extends ViewerSorter {

	/**
	 * @generated
	 */
	private static final int GROUP_CATEGORY = 19002;

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
