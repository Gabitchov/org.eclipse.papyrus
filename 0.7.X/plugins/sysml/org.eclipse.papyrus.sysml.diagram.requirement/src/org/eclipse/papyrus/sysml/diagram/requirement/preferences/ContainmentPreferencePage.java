package org.eclipse.papyrus.sysml.diagram.requirement.preferences;

import org.eclipse.papyrus.sysml.diagram.requirement.edit.part.RequirementDiagramEditPart;


/**
 * Preference Page for Class usage in Requirement Diagram
 * 
 */
public class ContainmentPreferencePage extends RequirementDiagramLinkPreferencePage {

	/**
	 * Constructor.
	 * 
	 */

	public ContainmentPreferencePage() {
		super();
		setPreferenceKey(RequirementDiagramEditPart.DIAGRAM_ID + "_Abstraction"); //$NON-NLS-1$
	}

}
