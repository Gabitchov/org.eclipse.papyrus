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

		CommentPreferencePage.initDefaults(store);

		DependencyPreferencePage.initDefaults(store);

		PrimitiveTypePreferencePage.initDefaults(store);

		EnumerationPreferencePage.initDefaults(store);

		ClassPreferencePage.initDefaults(store);

		InstanceSpecificationPreferencePage.initDefaults(store);

		ComponentPreferencePage.initDefaults(store);

		AssociationClassPreferencePage.initDefaults(store);

		ConstraintPreferencePage.initDefaults(store);

		PackagePreferencePage.initDefaults(store);

		AssociationPreferencePage.initDefaults(store);

		ModelPreferencePage.initDefaults(store);

		SignalPreferencePage.initDefaults(store);

		InterfacePreferencePage.initDefaults(store);

		DependencyPreferencePage.initDefaults(store);

		GeneralizationPreferencePage.initDefaults(store);

		TemplateBindingPreferencePage.initDefaults(store);

		AssociationClassPreferencePage.initDefaults(store);

		UsagePreferencePage.initDefaults(store);

		AssociationPreferencePage.initDefaults(store);

		SubstitutionPreferencePage.initDefaults(store);

		PackageImportPreferencePage.initDefaults(store);

		PackageMergePreferencePage.initDefaults(store);

		AbstractionPreferencePage.initDefaults(store);

		ElementImportPreferencePage.initDefaults(store);

		ProfileApplicationPreferencePage.initDefaults(store);

		RealizationPreferencePage.initDefaults(store);

		InterfaceRealizationPreferencePage.initDefaults(store);

	}
}
