/*
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.papyrus.uml.diagram.timing.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.uml.diagram.timing.part.UMLDiagramEditorPlugin;

/**
 * @generated
 */
@SuppressWarnings("all")
// disable warnings on generated code
public class DiagramPreferenceInitializer extends AbstractPreferenceInitializer {

	/**
	 * @generated
	 */
	@Override
	public void initializeDefaultPreferences() {
		final IPreferenceStore store = getPreferenceStore();

		InteractionPreferencePage.initDefaults(store);

		TimeConstraintPreferencePage.initDefaults(store);

		TimeObservationPreferencePage.initDefaults(store);

		VerticalLineStateInvariantPreferencePage.initDefaults(store);

		GeneralOrderingPreferencePage.initDefaults(store);

		CompactStateInvariantPreferencePage.initDefaults(store);

		LinearTimingRulerPreferencePage.initDefaults(store);

		LifelinePreferencePage.initDefaults(store);

		DurationConstraintPreferencePage.initDefaults(store);

		DurationObservationPreferencePage.initDefaults(store);

		TickPreferencePage.initDefaults(store);

		FreeTimingRulerPreferencePage.initDefaults(store);

		FullLifelinePreferencePage.initDefaults(store);

		MessageOccurrenceSpecificationPreferencePage.initDefaults(store);

		OccurrenceSpecificationPreferencePage.initDefaults(store);

		DestructionOccurrenceSpecificationPreferencePage.initDefaults(store);

		FullStateInvariantPreferencePage.initDefaults(store);

		CompactLifelinePreferencePage.initDefaults(store);

		GatePreferencePage.initDefaults(store);

		StateDefinitionPreferencePage.initDefaults(store);

		MessageAsyncPreferencePage.initDefaults(store);

		MessageSyncPreferencePage.initDefaults(store);

		MessageReplyPreferencePage.initDefaults(store);

		MessageDeletePreferencePage.initDefaults(store);

		MessageCreatePreferencePage.initDefaults(store);

		MessageLostPreferencePage.initDefaults(store);

		MessageFoundPreferencePage.initDefaults(store);

	}

	/**
	 * @generated
	 */
	protected IPreferenceStore getPreferenceStore() {
		return UMLDiagramEditorPlugin.getInstance().getPreferenceStore();
	}
}
