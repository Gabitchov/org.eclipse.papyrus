package org.eclipse.papyrus.sysml.diagram.requirement.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.gmfdiag.preferences.utils.PreferenceConstantHelper;
import org.eclipse.papyrus.sysml.diagram.requirement.edit.part.RequirementDiagramEditPart;
import org.eclipse.papyrus.sysml.diagram.requirement.edit.part.RequirementInformationCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.part.Messages;

/**
 * Preference Page for Class usage in Requirement Diagram
 * 
 */
public class ClassPreferencePage extends RequirementDiagramNodePreferencePage {

	/**
	 * the list of the compartments for this node
	 */
	public static final String compartments[] = { Messages.ClassAttributeCompartmentEditPartCN_title, Messages.ClassOperationCompartmentEditPartCN_title,
		Messages.ClassNestedClassifierCompartmentEditPartCN_title, 
		RequirementInformationCompartmentEditPart.COMPARTMENT_NAME};

	/**
	 * Constructor.
	 * 
	 */
	public ClassPreferencePage() {
		super();
		setPreferenceKey(RequirementDiagramEditPart.DIAGRAM_ID + "_Class"); //$NON-NLS-1$
	}

	/**
	 * 
	 * @param store
	 */
	public static void initDefaults(IPreferenceStore store) {

		String key = RequirementDiagramEditPart.DIAGRAM_ID + "_Class";
		// Compartment visibility is set to false by default as
		// Property, Operation, NestedClassifier compartment are 
		// not useful for most users in Requirement diagram.

		// These compartment can still be shown after creation (creation Preference may also be modified).
		for(String name : compartments) {
			String preferenceName = PreferenceConstantHelper.getCompartmentElementConstant(key, name, PreferenceConstantHelper.COMPARTMENT_VISIBILITY);
			store.setDefault(preferenceName, false);
		}

		// Requirement default size
		store.setDefault(PreferenceConstantHelper.getElementConstant(key, PreferenceConstantHelper.WIDTH), 120);
		store.setDefault(PreferenceConstantHelper.getElementConstant(key, PreferenceConstantHelper.HEIGHT), 80);

	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.preferences.pages.AbstractPapyrusNodePreferencePage#initializeCompartmentsList()
	 * 
	 */
	@Override
	protected void initializeCompartmentsList() {
		for(String name : compartments) {
			this.compartmentsList.add(name);
		}
	}

}
