package org.eclipse.papyrus.profile.ui.dialogs;

import org.eclipse.uml2.uml.Stereotype;

/**
 * Label provider for stereotypes that modifies {@link StereotypeLabelProvider#getText(Object)}.
 * It returns the qualified name of the Stereotype instead of the simple name.
 */
public class StereotypeQualifiedLabelProvider extends StereotypeLabelProvider {
	
	/* (non-Javadoc)
	 * @see com.cea.papyrus.ui.dialogs.ChooseSetStereotypeDialog.StereotypeLabelProvider#getText(java.lang.Object)
	 */
	@Override
	public String getText(Object stereotype) {
		if(!(stereotype instanceof Stereotype)) {
			return "not a stereotype";
		} else {
			return ((Stereotype)stereotype).getQualifiedName();
		}
	}
}