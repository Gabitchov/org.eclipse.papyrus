/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
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

		PropertyPreferencePage.initDefaults(store);

		DataTypePreferencePage.initDefaults(store);

		CommentPreferencePage.initDefaults(store);

		ClassifierTemplateParameterPreferencePage.initDefaults(store);

		ClassPreferencePage.initDefaults(store);

		EnumerationLiteralPreferencePage.initDefaults(store);

		ComponentPreferencePage.initDefaults(store);

		PackagePreferencePage.initDefaults(store);

		SignalPreferencePage.initDefaults(store);

		InterfacePreferencePage.initDefaults(store);

		ShortCutDiagramPreferencePage.initDefaults(store);

		ReceptionPreferencePage.initDefaults(store);

		TemplateParameterPreferencePage.initDefaults(store);

		DependencyPreferencePage.initDefaults(store);

		PrimitiveTypePreferencePage.initDefaults(store);

		EnumerationPreferencePage.initDefaults(store);

		SlotPreferencePage.initDefaults(store);

		InstanceSpecificationPreferencePage.initDefaults(store);

		AssociationClassPreferencePage.initDefaults(store);

		ConstraintPreferencePage.initDefaults(store);

		AssociationPreferencePage.initDefaults(store);

		OperationPreferencePage.initDefaults(store);

		ModelPreferencePage.initDefaults(store);

		RedefinableTemplateSignaturePreferencePage.initDefaults(store);

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

		GeneralizationSetPreferencePage.initDefaults(store);

		RealizationPreferencePage.initDefaults(store);

		InterfaceRealizationPreferencePage.initDefaults(store);

	}
}
