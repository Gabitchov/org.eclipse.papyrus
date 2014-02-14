/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.blockdefinition.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.Activator;

public class BlockDefinitionDiagramPreferenceInitializer extends AbstractPreferenceInitializer {

	protected IPreferenceStore getPreferenceStore() {
		return Activator.getInstance().getPreferenceStore();
	}

	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore store = getPreferenceStore();

		org.eclipse.papyrus.sysml.diagram.blockdefinition.preferences.ModelPreferencePage.initDefaults(store);
		org.eclipse.papyrus.sysml.diagram.blockdefinition.preferences.PackagePreferencePage.initDefaults(store);
		org.eclipse.papyrus.sysml.diagram.blockdefinition.preferences.InstanceSpecificationPreferencePage.initDefaults(store);
		org.eclipse.papyrus.sysml.diagram.blockdefinition.preferences.CommentPreferencePage.initDefaults(store);
		ActorPreferencePage.initDefaults(store);
		BlockPreferencePage.initDefaults(store);
		ConstraintBlockPreferencePage.initDefaults(store);
		DataTypePreferencePage.initDefaults(store);
		DimensionPreferencePage.initDefaults(store);
		EnumerationPreferencePage.initDefaults(store);
		EnumerationLiteralPreferencePage.initDefaults(store);
		FlowPortPreferencePage.initDefaults(store);
		FlowSpecificationPreferencePage.initDefaults(store);
		InterfacePreferencePage.initDefaults(store);
		PortPreferencePage.initDefaults(store);
		PrimitiveTypePreferencePage.initDefaults(store);
		SignalPreferencePage.initDefaults(store);
		UnitPreferencePage.initDefaults(store);
		ValueTypePreferencePage.initDefaults(store);
		AssociationPreferencePage.initDefaults(store);
		DependencyPreferencePage.initDefaults(store);
		GeneralizationPreferencePage.initDefaults(store);
		InterfaceRealizationPreferencePage.initDefaults(store);
		UsagePreferencePage.initDefaults(store);

		// DependencyPreferencePage.initDefaults(store);
	}
}
