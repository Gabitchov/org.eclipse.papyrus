package org.eclipse.papyrus.sysml.diagram.requirement.preferences;

import org.eclipse.papyrus.sysml.diagram.requirement.edit.part.RequirementDiagramEditPart;


/**
 * Preference Page for Class usage in Requirement Diagram
 * 
 */
public class AbstractionPreferencePage extends RequirementDiagramLinkPreferencePage {

	/**
	 * Constructor.
	 * 
	 */

	public AbstractionPreferencePage() {
		super();
		setPreferenceKey(RequirementDiagramEditPart.DIAGRAM_ID + "_Containment"); //$NON-NLS-1$
	}

}
