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
package org.eclipse.papyrus.preferences.pages;

import org.eclipse.gmf.runtime.notation.JumpLinkStatus;
import org.eclipse.gmf.runtime.notation.JumpLinkType;
import org.eclipse.gmf.runtime.notation.Routing;
import org.eclipse.gmf.runtime.notation.Smoothness;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

/**
 * An abstract implementation of a basic link preference page.
 * 
 * <p>
 * This Preference page adds the preference for
 * <ul>
 * <li>{@link org.eclipse.gmf.runtime.notation.RoutingStyle#getRouting <em>Routing</em>}</li>
 * <li>{@link org.eclipse.gmf.runtime.notation.RoutingStyle#getSmoothness <em>Smoothness</em>}</li>
 * <li>{@link org.eclipse.gmf.runtime.notation.RoutingStyle#isAvoidObstructions <em>Avoid
 * Obstructions</em>}</li>
 * <li>{@link org.eclipse.gmf.runtime.notation.RoutingStyle#isClosestDistance <em>Closest Distance
 * </em>}</li>
 * <li>{@link org.eclipse.gmf.runtime.notation.RoutingStyle#getJumpLinkStatus <em>Jump Link Status
 * </em>}</li>
 * <li>{@link org.eclipse.gmf.runtime.notation.RoutingStyle#getJumpLinkType <em>Jump Link Type</em>}
 * </li>
 * <li>{@link org.eclipse.gmf.runtime.notation.RoutingStyle#isJumpLinksReverse <em>Jump Links
 * Reverse</em>}</li>
 * </ul>
 * 
 * @author tlandre
 */
public abstract class AbstractPapyrusLinkPreferencePage extends AbstractPapyrusElementPreferencePage {

	private static final String CONNECTION_GROUPBOX_LABEL = "Connection";

	private static final String JUMP_LINKS_GROUPBOX_LABEL = "Jump Links";

	private static final String ROUTING_GROUPBOX_LABEL = "Routing";

	private static final String SMOOTHNESS_COMBOFIELDEDITOR_LABEL = "Smoothness";

	private static final String JUMPLINK_STATUS_COMBOFIELDEDITOR_LABEL = "Status";

	private static final String JUMPLINK_TYPE_COMBOFIELDEDITOR_LABEL = "Type";

	private static final String JUMPLINK_REVERSE_BOOLEANFIELDEDITOR_LABEL = "Reverse jump links";

	private static final String ROUTING_STYLES_COMBOFIELDEDITOR_LABEL = "Styles";

	private static final String ROUTING_OBSTRUCTION_POLICY_BOOLEANFIELDEDITOR_LABEL = "Avoid Obstructions";

	private static final String ROUTING_DISTANCE_POLICY_BOOLEANFIELDEDITOR_LABEL = "Closest Distance";

	private static final String[][] SMOOTHNESS_COMBOFIELDEDITOR_NAMES_AND_VALUES = { { "None", "" + Smoothness.NONE },
			{ "Less", "" + Smoothness.LESS }, { "Normal", "" + Smoothness.NORMAL }, { "More", "" + Smoothness.MORE } };

	private static final String[][] JUMPLINK_STATUS_COMBOFIELDEDITOR_NAMES_AND_VALUES = {
			{ "None", "" + JumpLinkStatus.NONE }, { "Below", "" + JumpLinkStatus.BELOW },
			{ "All", "" + JumpLinkStatus.ALL }, { "Above", "" + JumpLinkStatus.ABOVE } };

	private static final String[][] JUMPLINK_TYPE_COMBOFIELDEDITOR_NAMES_AND_VALUES = {
			{ "Semi-Circle", "" + JumpLinkType.SEMICIRCLE }, { "Square", "" + JumpLinkType.SQUARE },
			{ "Chamfered", "" + JumpLinkType.CHAMFERED } };

	// TODO : check if Tree is always a valid possibility
	private static final String[][] ROUTING_STYLES_COMBOFIELDEDITOR_NAMES_AND_VALUES = {
			{ "Oblique", "" + Routing.MANUAL }, { "Rectilinear", "" + Routing.RECTILINEAR },
			{ "Tree", "" + Routing.TREE } };

	@Override
	protected void createPageContents(Composite parent) {
		super.createPageContents(parent);

		Group connectionGroup = new Group(parent, 2);
		connectionGroup.setLayout(new GridLayout());
		connectionGroup.setText(CONNECTION_GROUPBOX_LABEL);

		ComboFieldEditor smoothnessComboFieldEditor = new ComboFieldEditor(
				getPreferenceConstant(PreferenceConstantHelper.SMOOTHNESS), SMOOTHNESS_COMBOFIELDEDITOR_LABEL,
				SMOOTHNESS_COMBOFIELDEDITOR_NAMES_AND_VALUES, connectionGroup);
		addEditorFields(smoothnessComboFieldEditor);

		createRoutingGroup(connectionGroup);
		createJumpLinkGroup(connectionGroup);

	}

	private void createJumpLinkGroup(Group connectionGroup) {
		Group jumpLinkGroup = new Group(connectionGroup, 2);
		jumpLinkGroup.setLayout(new GridLayout());
		jumpLinkGroup.setText(JUMP_LINKS_GROUPBOX_LABEL);

		ComboFieldEditor jumpLinkStatusComboFieldEditor = new ComboFieldEditor(
				getPreferenceConstant(PreferenceConstantHelper.JUMPLINK_STATUS),
				JUMPLINK_STATUS_COMBOFIELDEDITOR_LABEL, JUMPLINK_STATUS_COMBOFIELDEDITOR_NAMES_AND_VALUES,
				jumpLinkGroup);
		addEditorFields(jumpLinkStatusComboFieldEditor);

		ComboFieldEditor jumpLinkTypeComboFieldEditor = new ComboFieldEditor(
				getPreferenceConstant(PreferenceConstantHelper.JUMPLINK_TYPE), JUMPLINK_TYPE_COMBOFIELDEDITOR_LABEL,
				JUMPLINK_TYPE_COMBOFIELDEDITOR_NAMES_AND_VALUES, jumpLinkGroup);
		addEditorFields(jumpLinkTypeComboFieldEditor);

		BooleanFieldEditor jumpLinkReverseBooleanFieldEditor = new BooleanFieldEditor(
				getPreferenceConstant(PreferenceConstantHelper.JUMPLINK_REVERSE),
				JUMPLINK_REVERSE_BOOLEANFIELDEDITOR_LABEL, jumpLinkGroup);
		addEditorFields(jumpLinkReverseBooleanFieldEditor);
	}

	private void createRoutingGroup(Group connectionGroup) {

		Group routingGroup = new Group(connectionGroup, 2);
		routingGroup.setLayout(new GridLayout());
		routingGroup.setText(ROUTING_GROUPBOX_LABEL);

		ComboFieldEditor routingStylesComboFieldEditor = new ComboFieldEditor(
				getPreferenceConstant(PreferenceConstantHelper.ROUTING_STYLE), ROUTING_STYLES_COMBOFIELDEDITOR_LABEL,
				ROUTING_STYLES_COMBOFIELDEDITOR_NAMES_AND_VALUES, routingGroup);
		addEditorFields(routingStylesComboFieldEditor);

		BooleanFieldEditor routingObstructionPolicyBooleanFieldEditor = new BooleanFieldEditor(
				getPreferenceConstant(PreferenceConstantHelper.ROUTING_POLICY_OBSTRUCTION),
				ROUTING_OBSTRUCTION_POLICY_BOOLEANFIELDEDITOR_LABEL, routingGroup);
		addEditorFields(routingObstructionPolicyBooleanFieldEditor);

		BooleanFieldEditor routingDistancePolicyBooleanFieldEditor = new BooleanFieldEditor(
				getPreferenceConstant(PreferenceConstantHelper.ROUTING_POLICY_DISTANCE),
				ROUTING_DISTANCE_POLICY_BOOLEANFIELDEDITOR_LABEL, routingGroup);
		addEditorFields(routingDistancePolicyBooleanFieldEditor);

	}

}
