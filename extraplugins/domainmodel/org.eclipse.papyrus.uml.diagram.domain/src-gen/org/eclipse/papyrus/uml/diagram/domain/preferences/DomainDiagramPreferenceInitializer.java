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
package org.eclipse.papyrus.uml.diagram.domain.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.uml.diagram.domain.Activator;

public class DomainDiagramPreferenceInitializer extends AbstractPreferenceInitializer {

	protected IPreferenceStore getPreferenceStore() {
		return Activator.getInstance().getPreferenceStore();
	}

	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore store = getPreferenceStore();

		org.eclipse.papyrus.uml.diagram.domain.preferences.PackagePreferencePage.initDefaults(store);
		org.eclipse.papyrus.uml.diagram.domain.preferences.CommentPreferencePage.initDefaults(store);
		org.eclipse.papyrus.uml.diagram.domain.preferences.ConstraintPreferencePage.initDefaults(store);
		org.eclipse.papyrus.uml.diagram.domain.preferences.InstanceSpecificationPreferencePage.initDefaults(store);
		org.eclipse.papyrus.uml.diagram.domain.preferences.ClassPreferencePage.initDefaults(store);
		org.eclipse.papyrus.uml.diagram.domain.preferences.DataTypePreferencePage.initDefaults(store);
		org.eclipse.papyrus.uml.diagram.domain.preferences.EnumerationPreferencePage.initDefaults(store);
		org.eclipse.papyrus.uml.diagram.domain.preferences.EnumerationPreferencePage.initDefaults(store);
		org.eclipse.papyrus.uml.diagram.domain.preferences.PrimitiveTypePreferencePage.initDefaults(store);
		org.eclipse.papyrus.uml.diagram.domain.preferences.CommentLinkPreferencePage.initDefaults(store);
		org.eclipse.papyrus.uml.diagram.domain.preferences.ConstraintConstrainedElementPreferencePage.initDefaults(store);
		org.eclipse.papyrus.uml.diagram.domain.preferences.GeneralizationPreferencePage.initDefaults(store);
		org.eclipse.papyrus.uml.diagram.domain.preferences.AssociationPreferencePage.initDefaults(store);
	}
}
