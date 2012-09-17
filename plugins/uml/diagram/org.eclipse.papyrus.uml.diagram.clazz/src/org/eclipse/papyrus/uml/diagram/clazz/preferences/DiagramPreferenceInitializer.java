/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.uml.diagram.clazz.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.uml.diagram.clazz.part.UMLDiagramEditorPlugin;

/**
 * @generated
 */
public class DiagramPreferenceInitializer extends AbstractPreferenceInitializer {

	/**
	 * @generated
	 */
	public void initializeDefaultPreferences() {
		IPreferenceStore store = getPreferenceStore();
		ShapeNamedElementPreferencePage.initDefaults(store);
		OperationPreferencePage.initDefaults(store);
		DataTypePreferencePage.initDefaults(store);
		ModelPreferencePage.initDefaults(store);
		ShortCutDiagramPreferencePage.initDefaults(store);
		InstanceSpecificationPreferencePage.initDefaults(store);
		ContainmentCirclePreferencePage.initDefaults(store);
		InformationItemPreferencePage.initDefaults(store);
		PropertyPreferencePage.initDefaults(store);
		SlotPreferencePage.initDefaults(store);
		TemplateSignaturePreferencePage.initDefaults(store);
		ComponentPreferencePage.initDefaults(store);
		TemplateParameterPreferencePage.initDefaults(store);
		SignalPreferencePage.initDefaults(store);
		CommentPreferencePage.initDefaults(store);
		DurationObservationPreferencePage.initDefaults(store);
		InterfacePreferencePage.initDefaults(store);
		ClassPreferencePage.initDefaults(store);
		OperationTemplateParameterPreferencePage.initDefaults(store);
		TimeObservationPreferencePage.initDefaults(store);
		ConstraintPreferencePage.initDefaults(store);
		EnumerationLiteralPreferencePage.initDefaults(store);
		PrimitiveTypePreferencePage.initDefaults(store);
		ConnectableElementTemplateParameterPreferencePage.initDefaults(store);
		AssociationClassPreferencePage.initDefaults(store);
		PackagePreferencePage.initDefaults(store);
		EnumerationPreferencePage.initDefaults(store);
		DependencyNodePreferencePage.initDefaults(store);
		ReceptionPreferencePage.initDefaults(store);
		ClassifierTemplateParameterPreferencePage.initDefaults(store);
		AssociationNodePreferencePage.initDefaults(store);
		DefaultNamedElementPreferencePage.initDefaults(store);
		RedefinableTemplateSignaturePreferencePage.initDefaults(store);
		PackageMergePreferencePage.initDefaults(store);
		AssociationClassDashedLinkPreferencePage.initDefaults(store);
		GeneralizationPreferencePage.initDefaults(store);
		AssociationBranchLinkPreferencePage.initDefaults(store);
		InstanceSpecificationLinkPreferencePage.initDefaults(store);
		RealizationPreferencePage.initDefaults(store);
		UsagePreferencePage.initDefaults(store);
		TemplateBindingPreferencePage.initDefaults(store);
		PackageImportPreferencePage.initDefaults(store);
		AssociationClassLinkPreferencePage.initDefaults(store);
		ContainmentLinkPreferencePage.initDefaults(store);
		AbstractionPreferencePage.initDefaults(store);
		GeneralizationSetPreferencePage.initDefaults(store);
		AssociationLinkPreferencePage.initDefaults(store);
		ElementImportPreferencePage.initDefaults(store);
		DependencyLinkPreferencePage.initDefaults(store);
		InterfaceRealizationPreferencePage.initDefaults(store);
		ContainmentSubLinkPreferencePage.initDefaults(store);
		SubstitutionPreferencePage.initDefaults(store);
		DependencyBranchLinkPreferencePage.initDefaults(store);
		ProfileApplicationPreferencePage.initDefaults(store);
	}

	/**
	 * @generated
	 */
	protected IPreferenceStore getPreferenceStore() {
		return UMLDiagramEditorPlugin.getInstance().getPreferenceStore();
	}
}
