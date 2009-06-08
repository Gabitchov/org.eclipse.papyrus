package org.eclipse.papyrus.diagram.clazz.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.diagram.clazz.part.UMLDiagramEditorPlugin;

/**
 * @generated
 */
public class DiagramPreferenceInitializer extends AbstractPreferenceInitializer {

	/**
	 * @generated
	 */
	protected IPreferenceStore getPreferenceStore() {
		return UMLDiagramEditorPlugin.getInstance().getPreferenceStore();
	}

	/**
	 * @generated
	 */
	public void initializeDefaultPreferences() {
		IPreferenceStore store = getPreferenceStore();

		DataTypePreferencePage.initDefaults(store);

		ModelPreferencePage.initDefaults(store);

		SignalPreferencePage.initDefaults(store);

		AssociationPreferencePage.initDefaults(store);

		InstanceSpecificationPreferencePage.initDefaults(store);

		CommentPreferencePage.initDefaults(store);

		ConstraintPreferencePage.initDefaults(store);

		EnumerationPreferencePage.initDefaults(store);

		DependencyPreferencePage.initDefaults(store);

		InterfacePreferencePage.initDefaults(store);

		PrimitiveTypePreferencePage.initDefaults(store);

		ClassPreferencePage.initDefaults(store);

		AssociationClassPreferencePage.initDefaults(store);

		PackagePreferencePage.initDefaults(store);

		ComponentPreferencePage.initDefaults(store);

		PackageMergePreferencePage.initDefaults(store);

		AbstractionPreferencePage.initDefaults(store);

		GeneralizationSetPreferencePage.initDefaults(store);

		AssociationPreferencePage.initDefaults(store);

		GeneralizationPreferencePage.initDefaults(store);

		ElementImportPreferencePage.initDefaults(store);

		DependencyPreferencePage.initDefaults(store);

		RealizationPreferencePage.initDefaults(store);

		UsagePreferencePage.initDefaults(store);

		InterfaceRealizationPreferencePage.initDefaults(store);

		TemplateBindingPreferencePage.initDefaults(store);

		PackageImportPreferencePage.initDefaults(store);

		SubstitutionPreferencePage.initDefaults(store);

		AssociationClassPreferencePage.initDefaults(store);

		ProfileApplicationPreferencePage.initDefaults(store);

	}
}
