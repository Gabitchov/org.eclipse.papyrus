package org.eclipse.papyrus.diagram.statemachine.navigator;

import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.papyrus.diagram.statemachine.part.UMLVisualIDRegistry;


/**
 * @generated
 */
public class UMLNavigatorSorter extends ViewerSorter {

	/**
	 * @generated
	 */
	private static final int GROUP_CATEGORY = 5004;

	/**
	 * @generated
	 */
	private static final int SHORTCUTS_CATEGORY = 5003;

	/**
	 * @generated
	 */
	@Override
	public int category(Object element) {
		if(element instanceof UMLNavigatorItem) {
			UMLNavigatorItem item = (UMLNavigatorItem)element;
			if(item.getView().getEAnnotation("Shortcut") != null) { //$NON-NLS-1$
				return SHORTCUTS_CATEGORY;
			}
			return UMLVisualIDRegistry.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}
