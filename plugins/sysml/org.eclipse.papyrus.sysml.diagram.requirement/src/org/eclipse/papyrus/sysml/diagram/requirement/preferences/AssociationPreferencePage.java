package org.eclipse.papyrus.sysml.diagram.requirement.preferences;

import org.eclipse.papyrus.sysml.diagram.requirement.edit.part.RequirementDiagramEditPart;


/**
 * Preference Page for Class usage in Requirement Diagram
 * 
 */
public class AssociationPreferencePage extends RequirementDiagramLinkPreferencePage {

	/**
	 * Constructor.
	 * 
	 */

	public AssociationPreferencePage() {
		super();
		setPreferenceKey(RequirementDiagramEditPart.DIAGRAM_ID + "_Association"); //$NON-NLS-1$
	}

}
