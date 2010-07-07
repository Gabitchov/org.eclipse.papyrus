package org.eclipse.papyrus.sysml.diagram.requirement.preferences;

import org.eclipse.papyrus.sysml.diagram.requirement.edit.part.RequirementDiagramEditPart;


/**
 * Preference Page for Class usage in Requirement Diagram
 * 
 */
public class PackagePreferencePage extends RequirementDiagramNodePreferencePage {

	/**
	 * Constructor.
	 * 
	 */

	public PackagePreferencePage() {
		super();
		setPreferenceKey(RequirementDiagramEditPart.DIAGRAM_ID + "_Package"); //$NON-NLS-1$
	}

}
