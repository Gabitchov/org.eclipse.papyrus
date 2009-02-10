/****************************************************************************
 * Copyright (c) 2008 Atos Origin.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		Thibault Landre (Atos Origin) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.clazz.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.diagram.clazz.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.preferences.pages.AbstractPapyrusLinkPreferencePage;

/**
 * @generated
 */
public class GeneralizationPreferencePage extends AbstractPapyrusLinkPreferencePage {

	/**
	 * @generated
	 */
	public static void initDefaults(IPreferenceStore store) {

	}

	/**
	 * @generated
	 */
	@Override
	protected String getBundleId() {
		return UMLDiagramEditorPlugin.getInstance().ID;
	}

	/**
	 * @generated
	 */
	@Override
	protected String getFontColorPreferenceName() {
		return IPapyrusPreferencesConstant.GENERALIZATION_PREF_SMOOTHNESS;
	}

	/**
	 * @generated
	 */
	@Override
	protected String getFontPreferenceName() {
		return IPapyrusPreferencesConstant.GENERALIZATION_PREF_FONT;
	}

	/**
	 * @generated
	 */
	@Override
	protected String getJumpLinkReversePreferenceName() {
		return IPapyrusPreferencesConstant.GENERALIZATION_PREF_JUMPLINK_REVERSE;
	}

	/**
	 * @generated
	 */
	@Override
	protected String getJumpLinkStatusPreferenceName() {
		return IPapyrusPreferencesConstant.GENERALIZATION_PREF_JUMPLINK_STATUS;
	}

	/**
	 * @generated
	 */
	@Override
	protected String getJumpLinkTypePreferenceName() {
		return IPapyrusPreferencesConstant.GENERALIZATION_PREF_JUMPLINK_TYPE;
	}

	/**
	 * @generated
	 */
	@Override
	protected String getLineColorPreferenceName() {
		return IPapyrusPreferencesConstant.GENERALIZATION_PREF_LINE_COLOR;
	}

	/**
	 * @generated
	 */
	@Override
	protected String getRoutingDistancePolicyPreferenceName() {
		return IPapyrusPreferencesConstant.GENERALIZATION_PREF_ROUTING_DISTANCE_POLICY;
	}

	/**
	 * @generated
	 */
	@Override
	protected String getRoutingObstructionPolicyPreferenceName() {
		return IPapyrusPreferencesConstant.GENERALIZATION_PREF_ROUTING_OBSTRUCTION_POLICY;
	}

	/**
	 * @generated
	 */
	@Override
	protected String getRoutingStylePreferenceName() {
		return IPapyrusPreferencesConstant.GENERALIZATION_PREF_ROUTING_STYLE;
	}

	/**
	 * @generated
	 */
	@Override
	protected String getSmoothnessPreferenceName() {
		return IPapyrusPreferencesConstant.GENERALIZATION_PREF_SMOOTHNESS;
	}

}
