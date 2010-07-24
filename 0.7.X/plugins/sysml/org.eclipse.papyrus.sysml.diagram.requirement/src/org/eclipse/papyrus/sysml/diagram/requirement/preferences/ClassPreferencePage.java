package org.eclipse.papyrus.sysml.diagram.requirement.preferences;

import org.eclipse.papyrus.sysml.diagram.requirement.edit.part.RequirementDiagramEditPart;


/**
 * Preference Page for Class usage in Requirement Diagram
 * 
 */
public class ClassPreferencePage extends RequirementDiagramNodePreferencePage {

	/**
	 * Constructor.
	 * 
	 */

	public ClassPreferencePage() {
		super();
		setPreferenceKey(RequirementDiagramEditPart.DIAGRAM_ID + "_Class"); //$NON-NLS-1$
	}

}
