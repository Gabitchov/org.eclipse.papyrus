package org.eclipse.papyrus.uml.diagram.component.sheet;

import org.eclipse.gmf.tooling.runtime.sheet.DefaultPropertySection;
import org.eclipse.ui.views.properties.IPropertySourceProvider;

/**
 * @generated
 */
public class UMLPropertySection extends DefaultPropertySection implements
		IPropertySourceProvider {

	/**
	 * Modify/unwrap selection.
	 * 
	 * @generated
	 */
	protected Object transformSelection(Object selected) {
		selected = /* super. */transformSelectionToDomain(selected);
		return selected;
	}
}
