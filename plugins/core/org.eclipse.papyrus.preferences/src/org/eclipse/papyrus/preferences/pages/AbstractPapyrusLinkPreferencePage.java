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
 * <li>{@link org.eclipse.gmf.runtime.notation.RoutingStyle#isAvoidObstructions <em>Avoid Obstructions</em>}</li>
 * <li>{@link org.eclipse.gmf.runtime.notation.RoutingStyle#isClosestDistance <em>Closest Distance</em>}</li>
 * <li>{@link org.eclipse.gmf.runtime.notation.RoutingStyle#getJumpLinkStatus <em>Jump Link Status</em>}</li>
 * <li>{@link org.eclipse.gmf.runtime.notation.RoutingStyle#getJumpLinkType <em>Jump Link Type</em>}</li>
 * <li>{@link org.eclipse.gmf.runtime.notation.RoutingStyle#isJumpLinksReverse <em>Jump Links Reverse</em>}</li>
 * </ul>
 * 
 * <p>
 * Sub-classes have to implement :
 * <ul>
 * <li><code>getJumpLinkStatusPreferenceName()</code> to get the preference name (identifier) to use for the jump link status</li>
 * <li><code>getJumpLinkTypePreferenceName()</code> to get the preference name (identifier) to use for the jump link type</li>
 * <li><code>getJumpLinkReversePreferenceName()</code> to get the preference name (identifier) to use for the line color</li>
 * <li><code>getSmoothnessPreferenceName()</code> to get the preference name (identifier) to use for the smoothness</li>
 * <li><code>getRoutingStylePreferenceName()</code> to get the preference name (identifier) to use for the routing style</li>
 * <li><code>getRoutingObstructionPolicyPreferenceName()</code> to get the preference name (identifier) to use for the routing obstruction policy</li>
 * <li><code>getRoutingDistancePolicyPreferenceName()</code> to get the preference name (identifier) to use for the routing distance policy</li>
 * </ul>
 * </p>
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

	private static final String[][] SMOOTHNESS_COMBOFIELDEDITOR_NAMES_AND_VALUES = { { "None", "" + Smoothness.NONE }, { "Less", "" + Smoothness.LESS }, { "Normal", "" + Smoothness.NORMAL },
			{ "More", "" + Smoothness.MORE } };

	private static final String[][] JUMPLINK_STATUS_COMBOFIELDEDITOR_NAMES_AND_VALUES = { { "None", "" + JumpLinkStatus.NONE }, { "Below", "" + JumpLinkStatus.BELOW },
			{ "All", "" + JumpLinkStatus.ALL }, { "Above", "" + JumpLinkStatus.ABOVE } };

	private static final String[][] JUMPLINK_TYPE_COMBOFIELDEDITOR_NAMES_AND_VALUES = { { "Semi-Circle", "" + JumpLinkType.SEMICIRCLE }, { "Square", "" + JumpLinkType.SQUARE },
			{ "Chamfered", "" + JumpLinkType.CHAMFERED } };

	// TODO : check if Tree is always a valid possibility
	private static final String[][] ROUTING_STYLES_COMBOFIELDEDITOR_NAMES_AND_VALUES = { { "Oblique", "" + Routing.MANUAL }, { "Rectilinear", "" + Routing.RECTILINEAR }, { "Tree", "" + Routing.TREE } };

	@Override
	protected void createPageContents(Composite parent) {
		super.createPageContents(parent);

		Group connectionGroup = new Group(parent, 2);
		connectionGroup.setLayout(new GridLayout());
		connectionGroup.setText(CONNECTION_GROUPBOX_LABEL);

		ComboFieldEditor smoothnessComboFieldEditor = new ComboFieldEditor(getSmoothnessPreferenceName(), SMOOTHNESS_COMBOFIELDEDITOR_LABEL, SMOOTHNESS_COMBOFIELDEDITOR_NAMES_AND_VALUES,
				connectionGroup);
		addEditorFields(smoothnessComboFieldEditor);

		createRoutingGroup(connectionGroup);
		createJumpLinkGroup(connectionGroup);

	}

	private void createJumpLinkGroup(Group connectionGroup) {
		Group jumpLinkGroup = new Group(connectionGroup, 2);
		jumpLinkGroup.setLayout(new GridLayout());
		jumpLinkGroup.setText(JUMP_LINKS_GROUPBOX_LABEL);

		ComboFieldEditor jumpLinkStatusComboFieldEditor = new ComboFieldEditor(getJumpLinkStatusPreferenceName(), JUMPLINK_STATUS_COMBOFIELDEDITOR_LABEL,
				JUMPLINK_STATUS_COMBOFIELDEDITOR_NAMES_AND_VALUES, jumpLinkGroup);
		addEditorFields(jumpLinkStatusComboFieldEditor);

		ComboFieldEditor jumpLinkTypeComboFieldEditor = new ComboFieldEditor(getJumpLinkTypePreferenceName(), JUMPLINK_TYPE_COMBOFIELDEDITOR_LABEL, JUMPLINK_TYPE_COMBOFIELDEDITOR_NAMES_AND_VALUES,
				jumpLinkGroup);
		addEditorFields(jumpLinkTypeComboFieldEditor);

		BooleanFieldEditor jumpLinkReverseBooleanFieldEditor = new BooleanFieldEditor(getJumpLinkReversePreferenceName(), JUMPLINK_REVERSE_BOOLEANFIELDEDITOR_LABEL, jumpLinkGroup);
		addEditorFields(jumpLinkReverseBooleanFieldEditor);
	}

	private void createRoutingGroup(Group connectionGroup) {

		Group routingGroup = new Group(connectionGroup, 2);
		routingGroup.setLayout(new GridLayout());
		routingGroup.setText(ROUTING_GROUPBOX_LABEL);

		ComboFieldEditor routingStylesComboFieldEditor = new ComboFieldEditor(getRoutingStylePreferenceName(), ROUTING_STYLES_COMBOFIELDEDITOR_LABEL, ROUTING_STYLES_COMBOFIELDEDITOR_NAMES_AND_VALUES,
				routingGroup);
		addEditorFields(routingStylesComboFieldEditor);

		BooleanFieldEditor routingObstructionPolicyBooleanFieldEditor = new BooleanFieldEditor(getRoutingObstructionPolicyPreferenceName(), ROUTING_OBSTRUCTION_POLICY_BOOLEANFIELDEDITOR_LABEL,
				routingGroup);
		addEditorFields(routingObstructionPolicyBooleanFieldEditor);

		BooleanFieldEditor routingDistancePolicyBooleanFieldEditor = new BooleanFieldEditor(getRoutingDistancePolicyPreferenceName(), ROUTING_DISTANCE_POLICY_BOOLEANFIELDEDITOR_LABEL, routingGroup);
		addEditorFields(routingDistancePolicyBooleanFieldEditor);

	}

	/**
	 * Get the preference name (identifier) to use for the jump link status
	 * 
	 * @return the name of the preference to use
	 */
	protected abstract String getJumpLinkStatusPreferenceName();

	/**
	 * Get the preference name (identifier) to use for the jump link type
	 * 
	 * @return the name of the preference to use
	 */
	protected abstract String getJumpLinkTypePreferenceName();

	/**
	 * Get the preference name (identifier) to use for the line color
	 * 
	 * @return the name of the preference to use
	 */
	protected abstract String getJumpLinkReversePreferenceName();

	/**
	 * Get the preference name (identifier) to use for the smoothness
	 * 
	 * @return the name of the preference to use
	 */
	protected abstract String getSmoothnessPreferenceName();

	/**
	 * Get the preference name (identifier) to use for the routing style
	 * 
	 * @return the name of the preference to use
	 */
	protected abstract String getRoutingStylePreferenceName();

	/**
	 * Get the preference name (identifier) to use for the routing obstruction policy
	 * 
	 * @return the name of the preference to use
	 */
	protected abstract String getRoutingObstructionPolicyPreferenceName();

	/**
	 * Get the preference name (identifier) to use for the routing distance policy
	 * 
	 * @return the name of the preference to use
	 */
	protected abstract String getRoutingDistancePolicyPreferenceName();
}
