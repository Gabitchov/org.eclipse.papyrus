/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.interactionoverview.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.uml.diagram.interactionoverview.Activator;

public class InteractionOverviewDiagramPreferenceInitializer extends AbstractPreferenceInitializer {

	protected IPreferenceStore getPreferenceStore() {
		return Activator.getInstance().getPreferenceStore();
	}

	@Override
	public void initializeDefaultPreferences() {
		final IPreferenceStore store = getPreferenceStore();

		org.eclipse.papyrus.uml.diagram.interactionoverview.preferences.ActivityFinalNodePreferencePage.initDefaults(store);
		org.eclipse.papyrus.uml.diagram.interactionoverview.preferences.CallBehaviorActionPreferencePage.initDefaults(store);
		org.eclipse.papyrus.uml.diagram.interactionoverview.preferences.CommentPreferencePage.initDefaults(store);
		org.eclipse.papyrus.uml.diagram.interactionoverview.preferences.ConditionalNodePreferencePage.initDefaults(store);
		org.eclipse.papyrus.uml.diagram.interactionoverview.preferences.DecisionNodePreferencePage.initDefaults(store);
		org.eclipse.papyrus.uml.diagram.interactionoverview.preferences.FlowFinalNodePreferencePage.initDefaults(store);
		org.eclipse.papyrus.uml.diagram.interactionoverview.preferences.ForkNodePreferencePage.initDefaults(store);
		org.eclipse.papyrus.uml.diagram.interactionoverview.preferences.InitialNodePreferencePage.initDefaults(store);
		org.eclipse.papyrus.uml.diagram.interactionoverview.preferences.JoinNodePreferencePage.initDefaults(store);
		org.eclipse.papyrus.uml.diagram.interactionoverview.preferences.LoopNodePreferencePage.initDefaults(store);
		org.eclipse.papyrus.uml.diagram.interactionoverview.preferences.MergeNodePreferencePage.initDefaults(store);
		org.eclipse.papyrus.uml.diagram.interactionoverview.preferences.NamedElementPreferencePage.initDefaults(store);
		org.eclipse.papyrus.uml.diagram.interactionoverview.preferences.ActivityPreferencePage.initDefaults(store);
		org.eclipse.papyrus.uml.diagram.interactionoverview.preferences.SequenceNodePreferencePage.initDefaults(store);
		org.eclipse.papyrus.uml.diagram.interactionoverview.preferences.ConstraintPreferencePage.initDefaults(store);
		org.eclipse.papyrus.uml.diagram.interactionoverview.preferences.CommentAnnotatedElementPreferencePage.initDefaults(store);
		org.eclipse.papyrus.uml.diagram.interactionoverview.preferences.ControlFlowPreferencePage.initDefaults(store);
	}
}
