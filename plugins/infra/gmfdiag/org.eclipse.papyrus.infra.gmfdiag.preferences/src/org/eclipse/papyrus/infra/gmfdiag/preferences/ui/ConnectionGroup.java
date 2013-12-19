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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr 
 *  Thibault Landre (Atos Origin) 
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.preferences.ui;

import org.eclipse.gmf.runtime.notation.JumpLinkStatus;
import org.eclipse.gmf.runtime.notation.JumpLinkType;
import org.eclipse.gmf.runtime.notation.Routing;
import org.eclipse.gmf.runtime.notation.Smoothness;
import org.eclipse.jface.dialogs.DialogPage;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper;
import org.eclipse.papyrus.infra.gmfdiag.preferences.Messages;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

/**
 * The Class ConnectionGroupComposite constains all field to manage the router of a link
 */
public class ConnectionGroup extends AbstractGroup {

	/**
	 * Instantiates a new connection group composite.
	 * 
	 * @param parent
	 *        the parent of the composite
	 * @param String
	 *        the title of the page
	 * @param dialogPage
	 *        to set the page in field editor
	 **/

	public ConnectionGroup(Composite parent, String title, DialogPage dialogPage) {
		super(parent, title, dialogPage);
		createContent(parent);
	}

	/** The Constant JUMPLINK_STATUS_COMBOFIELDEDITOR_LABEL. */
	private static final String JUMPLINK_STATUS_COMBOFIELDEDITOR_LABEL = Messages.AbstractPapyrusLinkPreferencePage_Status;

	/** The Constant JUMPLINK_TYPE_COMBOFIELDEDITOR_LABEL. */
	private static final String JUMPLINK_TYPE_COMBOFIELDEDITOR_LABEL = Messages.AbstractPapyrusLinkPreferencePage_Type;

	/** The Constant JUMPLINK_REVERSE_BOOLEANFIELDEDITOR_LABEL. */
	private static final String JUMPLINK_REVERSE_BOOLEANFIELDEDITOR_LABEL = Messages.AbstractPapyrusLinkPreferencePage_ReverseJumpLinks;

	/** The Constant ROUTING_STYLES_COMBOFIELDEDITOR_LABEL. */
	private static final String ROUTING_STYLES_COMBOFIELDEDITOR_LABEL = Messages.AbstractPapyrusLinkPreferencePage_Styles;

	/** The Constant ROUTING_OBSTRUCTION_POLICY_BOOLEANFIELDEDITOR_LABEL. */
	private static final String ROUTING_OBSTRUCTION_POLICY_BOOLEANFIELDEDITOR_LABEL = Messages.AbstractPapyrusLinkPreferencePage_AvoidObstructions;

	/** The Constant ROUTING_DISTANCE_POLICY_BOOLEANFIELDEDITOR_LABEL. */
	private static final String ROUTING_DISTANCE_POLICY_BOOLEANFIELDEDITOR_LABEL = Messages.AbstractPapyrusLinkPreferencePage_ClosestDistance;

	/** The Constant SMOOTHNESS_COMBOFIELDEDITOR_NAMES_AND_VALUES. */
	private static final String[][] SMOOTHNESS_COMBOFIELDEDITOR_NAMES_AND_VALUES = { { Messages.AbstractPapyrusLinkPreferencePage_None, "" + Smoothness.NONE }, //$NON-NLS-2$
	{ Messages.AbstractPapyrusLinkPreferencePage_Less, "" + Smoothness.LESS }, { Messages.AbstractPapyrusLinkPreferencePage_Normal, "" + Smoothness.NORMAL }, { Messages.AbstractPapyrusLinkPreferencePage_More, "" + Smoothness.MORE } }; //$NON-NLS-2$ //$NON-NLS-4$ //$NON-NLS-6$

	/** The Constant JUMPLINK_STATUS_COMBOFIELDEDITOR_NAMES_AND_VALUES. */
	private static final String[][] JUMPLINK_STATUS_COMBOFIELDEDITOR_NAMES_AND_VALUES = { { Messages.AbstractPapyrusLinkPreferencePage_None, "" + JumpLinkStatus.NONE }, { Messages.AbstractPapyrusLinkPreferencePage_Below, "" + JumpLinkStatus.BELOW }, //$NON-NLS-2$ //$NON-NLS-4$
	{ Messages.AbstractPapyrusLinkPreferencePage_All, "" + JumpLinkStatus.ALL }, { Messages.AbstractPapyrusLinkPreferencePage_Above, "" + JumpLinkStatus.ABOVE } }; //$NON-NLS-2$ //$NON-NLS-4$

	/** The Constant JUMPLINK_TYPE_COMBOFIELDEDITOR_NAMES_AND_VALUES. */
	private static final String[][] JUMPLINK_TYPE_COMBOFIELDEDITOR_NAMES_AND_VALUES = { { Messages.AbstractPapyrusLinkPreferencePage_SemiCircle, "" + JumpLinkType.SEMICIRCLE }, { Messages.AbstractPapyrusLinkPreferencePage_Square, "" + JumpLinkType.SQUARE }, //$NON-NLS-2$ //$NON-NLS-4$
	{ Messages.AbstractPapyrusLinkPreferencePage_Chamfered, "" + JumpLinkType.CHAMFERED } }; //$NON-NLS-2$

	// TODO : check if Tree is always a valid possibility
	/** The Constant ROUTING_STYLES_COMBOFIELDEDITOR_NAMES_AND_VALUES. */
	private static final String[][] ROUTING_STYLES_COMBOFIELDEDITOR_NAMES_AND_VALUES = { { Messages.AbstractPapyrusLinkPreferencePage_Oblique, "" + Routing.MANUAL }, { Messages.AbstractPapyrusLinkPreferencePage_Rectilinear, "" + Routing.RECTILINEAR }, //$NON-NLS-2$ //$NON-NLS-4$
	{ Messages.AbstractPapyrusLinkPreferencePage_Tree, "" + Routing.TREE } }; //$NON-NLS-2$

	/** The routing styles combo field editor. */
	private ComboFieldEditor routingStylesComboFieldEditor;

	/** The routing obstruction policy boolean field editor. */
	private BooleanFieldEditor routingObstructionPolicyBooleanFieldEditor;

	/** The routing distance policy boolean field editor. */
	private BooleanFieldEditor routingDistancePolicyBooleanFieldEditor;

	/** The jump link reverse boolean field editor. */
	private BooleanFieldEditor jumpLinkReverseBooleanFieldEditor;

	/** The jump link type combo field editor. */
	private ComboFieldEditor jumpLinkTypeComboFieldEditor;

	/** The jump link status combo field editor. */
	private ComboFieldEditor jumpLinkStatusComboFieldEditor;

	/**
	 * Creates the content.
	 * 
	 * @param parent
	 *        the parent
	 */
	public void createContent(Composite parent) {
		Group connectionGroup = new Group(parent, 2);
		connectionGroup.setLayout(new GridLayout());
		connectionGroup.setText(Messages.AbstractPapyrusLinkPreferencePage_Connection);

		ComboFieldEditor smoothnessComboFieldEditor = new ComboFieldEditor(getPreferenceConstant(PreferencesConstantsHelper.SMOOTHNESS), Messages.AbstractPapyrusLinkPreferencePage_Smoothness, SMOOTHNESS_COMBOFIELDEDITOR_NAMES_AND_VALUES, connectionGroup);

		addFieldEditor(smoothnessComboFieldEditor);

		createRoutingGroup(connectionGroup);
		createJumpLinkGroup(connectionGroup);
	}

	/**
	 * Creates the jump link group.
	 * 
	 * @param connectionGroup
	 *        the connection group
	 */

	private void createJumpLinkGroup(Group connectionGroup) {
		Group jumpLinkGroup = new Group(connectionGroup, 2);
		jumpLinkGroup.setLayout(new GridLayout());
		jumpLinkGroup.setText(Messages.AbstractPapyrusLinkPreferencePage_JUMPLINKS);

		jumpLinkStatusComboFieldEditor = new ComboFieldEditor(getPreferenceConstant(PreferencesConstantsHelper.JUMPLINK_STATUS), JUMPLINK_STATUS_COMBOFIELDEDITOR_LABEL, JUMPLINK_STATUS_COMBOFIELDEDITOR_NAMES_AND_VALUES, jumpLinkGroup);
		jumpLinkStatusComboFieldEditor.setPage(dialogPage);

		addFieldEditor(jumpLinkStatusComboFieldEditor);

		jumpLinkTypeComboFieldEditor = new ComboFieldEditor(getPreferenceConstant(PreferencesConstantsHelper.JUMPLINK_TYPE), JUMPLINK_TYPE_COMBOFIELDEDITOR_LABEL, JUMPLINK_TYPE_COMBOFIELDEDITOR_NAMES_AND_VALUES, jumpLinkGroup);
		jumpLinkTypeComboFieldEditor.setPage(dialogPage);

		addFieldEditor(jumpLinkTypeComboFieldEditor);

		jumpLinkReverseBooleanFieldEditor = new BooleanFieldEditor(getPreferenceConstant(PreferencesConstantsHelper.JUMPLINK_REVERSE), JUMPLINK_REVERSE_BOOLEANFIELDEDITOR_LABEL, jumpLinkGroup);
		jumpLinkReverseBooleanFieldEditor.setPage(dialogPage);

		addFieldEditor(jumpLinkReverseBooleanFieldEditor);
	}

	/**
	 * Creates the routing group.
	 * 
	 * @param connectionGroup
	 *        the connection group
	 */
	private void createRoutingGroup(Group connectionGroup) {
		Group routingGroup = new Group(connectionGroup, 2);
		routingGroup.setLayout(new GridLayout());
		routingGroup.setText(Messages.AbstractPapyrusLinkPreferencePage_Routing);

		routingStylesComboFieldEditor = new ComboFieldEditor(getPreferenceConstant(PreferencesConstantsHelper.ROUTING_STYLE), ROUTING_STYLES_COMBOFIELDEDITOR_LABEL, ROUTING_STYLES_COMBOFIELDEDITOR_NAMES_AND_VALUES, routingGroup);
		routingStylesComboFieldEditor.setPage(dialogPage);

		addFieldEditor(routingStylesComboFieldEditor);

		routingObstructionPolicyBooleanFieldEditor = new BooleanFieldEditor(getPreferenceConstant(PreferencesConstantsHelper.ROUTING_POLICY_OBSTRUCTION), ROUTING_OBSTRUCTION_POLICY_BOOLEANFIELDEDITOR_LABEL, routingGroup);
		routingObstructionPolicyBooleanFieldEditor.setPage(dialogPage);

		addFieldEditor(routingObstructionPolicyBooleanFieldEditor);

		routingDistancePolicyBooleanFieldEditor = new BooleanFieldEditor(getPreferenceConstant(PreferencesConstantsHelper.ROUTING_POLICY_DISTANCE), ROUTING_DISTANCE_POLICY_BOOLEANFIELDEDITOR_LABEL, routingGroup);
		routingDistancePolicyBooleanFieldEditor.setPage(dialogPage);

		addFieldEditor(routingDistancePolicyBooleanFieldEditor);

	}

}
