package org.eclipse.papyrus.preferences.ui;

import org.eclipse.gmf.runtime.notation.JumpLinkStatus;
import org.eclipse.gmf.runtime.notation.JumpLinkType;
import org.eclipse.gmf.runtime.notation.Routing;
import org.eclipse.gmf.runtime.notation.Smoothness;
import org.eclipse.jface.dialogs.DialogPage;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.preferences.Messages;
import org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;


public class ConnectionGroupComposite extends AbstractGroupComposite {
	public ConnectionGroupComposite(Composite parent,String title, DialogPage dialogPage) {
		super(parent, title, dialogPage);
		createContent(parent);
	}

	

	private static final String JUMPLINK_STATUS_COMBOFIELDEDITOR_LABEL = Messages.AbstractPapyrusLinkPreferencePage_Status;

	private static final String JUMPLINK_TYPE_COMBOFIELDEDITOR_LABEL = Messages.AbstractPapyrusLinkPreferencePage_Type;

	private static final String JUMPLINK_REVERSE_BOOLEANFIELDEDITOR_LABEL = Messages.AbstractPapyrusLinkPreferencePage_ReverseJumpLinks;

	private static final String ROUTING_STYLES_COMBOFIELDEDITOR_LABEL = Messages.AbstractPapyrusLinkPreferencePage_Styles;

	private static final String ROUTING_OBSTRUCTION_POLICY_BOOLEANFIELDEDITOR_LABEL = Messages.AbstractPapyrusLinkPreferencePage_AvoidObstructions;

	private static final String ROUTING_DISTANCE_POLICY_BOOLEANFIELDEDITOR_LABEL = Messages.AbstractPapyrusLinkPreferencePage_ClosestDistance;

	private static final String[][] SMOOTHNESS_COMBOFIELDEDITOR_NAMES_AND_VALUES = {
			{ Messages.AbstractPapyrusLinkPreferencePage_None, "" + Smoothness.NONE }, //$NON-NLS-2$
			{ Messages.AbstractPapyrusLinkPreferencePage_Less, "" + Smoothness.LESS }, { Messages.AbstractPapyrusLinkPreferencePage_Normal, "" + Smoothness.NORMAL }, { Messages.AbstractPapyrusLinkPreferencePage_More, "" + Smoothness.MORE } }; //$NON-NLS-2$ //$NON-NLS-4$ //$NON-NLS-6$

	private static final String[][] JUMPLINK_STATUS_COMBOFIELDEDITOR_NAMES_AND_VALUES = {
			{ Messages.AbstractPapyrusLinkPreferencePage_None, "" + JumpLinkStatus.NONE }, { Messages.AbstractPapyrusLinkPreferencePage_Below, "" + JumpLinkStatus.BELOW }, //$NON-NLS-2$ //$NON-NLS-4$
			{ Messages.AbstractPapyrusLinkPreferencePage_All, "" + JumpLinkStatus.ALL }, { Messages.AbstractPapyrusLinkPreferencePage_Above, "" + JumpLinkStatus.ABOVE } }; //$NON-NLS-2$ //$NON-NLS-4$

	private static final String[][] JUMPLINK_TYPE_COMBOFIELDEDITOR_NAMES_AND_VALUES = {
			{ Messages.AbstractPapyrusLinkPreferencePage_SemiCircle, "" + JumpLinkType.SEMICIRCLE }, { Messages.AbstractPapyrusLinkPreferencePage_Square, "" + JumpLinkType.SQUARE }, //$NON-NLS-2$ //$NON-NLS-4$
			{ Messages.AbstractPapyrusLinkPreferencePage_Chamfered, "" + JumpLinkType.CHAMFERED } }; //$NON-NLS-2$

	// TODO : check if Tree is always a valid possibility
	private static final String[][] ROUTING_STYLES_COMBOFIELDEDITOR_NAMES_AND_VALUES = {
			{ Messages.AbstractPapyrusLinkPreferencePage_Oblique, "" + Routing.MANUAL }, { Messages.AbstractPapyrusLinkPreferencePage_Rectilinear, "" + Routing.RECTILINEAR }, //$NON-NLS-2$ //$NON-NLS-4$
			{ Messages.AbstractPapyrusLinkPreferencePage_Tree, "" + Routing.TREE } }; //$NON-NLS-2$

	private ComboFieldEditor routingStylesComboFieldEditor;

	private BooleanFieldEditor routingObstructionPolicyBooleanFieldEditor;

	private BooleanFieldEditor routingDistancePolicyBooleanFieldEditor;

	private BooleanFieldEditor jumpLinkReverseBooleanFieldEditor;

	private ComboFieldEditor jumpLinkTypeComboFieldEditor;

	private ComboFieldEditor jumpLinkStatusComboFieldEditor;

	public void createContent(Composite parent){
		Group connectionGroup = new Group(parent, 2);
		connectionGroup.setLayout(new GridLayout());
		connectionGroup.setText(Messages.AbstractPapyrusLinkPreferencePage_Connection);

		ComboFieldEditor smoothnessComboFieldEditor = new ComboFieldEditor(
				getPreferenceConstant(PreferenceConstantHelper.SMOOTHNESS), Messages.AbstractPapyrusLinkPreferencePage_Smoothness,
				SMOOTHNESS_COMBOFIELDEDITOR_NAMES_AND_VALUES, connectionGroup);

		createRoutingGroup(connectionGroup);
		createJumpLinkGroup(connectionGroup);
	}
	private void createJumpLinkGroup(Group connectionGroup) {
		Group jumpLinkGroup = new Group(connectionGroup, 2);
		jumpLinkGroup.setLayout(new GridLayout());
		jumpLinkGroup.setText(Messages.AbstractPapyrusLinkPreferencePage_JUMPLINKS);

		jumpLinkStatusComboFieldEditor = new ComboFieldEditor(
				getPreferenceConstant(PreferenceConstantHelper.JUMPLINK_STATUS),
				JUMPLINK_STATUS_COMBOFIELDEDITOR_LABEL, JUMPLINK_STATUS_COMBOFIELDEDITOR_NAMES_AND_VALUES,
				jumpLinkGroup);
		jumpLinkStatusComboFieldEditor.setPage(dialogPage);

		jumpLinkTypeComboFieldEditor = new ComboFieldEditor(
				getPreferenceConstant(PreferenceConstantHelper.JUMPLINK_TYPE), JUMPLINK_TYPE_COMBOFIELDEDITOR_LABEL,
				JUMPLINK_TYPE_COMBOFIELDEDITOR_NAMES_AND_VALUES, jumpLinkGroup);
		jumpLinkTypeComboFieldEditor.setPage(dialogPage);
		
		jumpLinkReverseBooleanFieldEditor = new BooleanFieldEditor(
				getPreferenceConstant(PreferenceConstantHelper.JUMPLINK_REVERSE),
				JUMPLINK_REVERSE_BOOLEANFIELDEDITOR_LABEL, jumpLinkGroup);
		jumpLinkReverseBooleanFieldEditor.setPage(dialogPage);
	}

	private void createRoutingGroup(Group connectionGroup) {
		Group routingGroup = new Group(connectionGroup, 2);
		routingGroup.setLayout(new GridLayout());
		routingGroup.setText(Messages.AbstractPapyrusLinkPreferencePage_Routing);

		routingStylesComboFieldEditor = new ComboFieldEditor(
				getPreferenceConstant(PreferenceConstantHelper.ROUTING_STYLE), ROUTING_STYLES_COMBOFIELDEDITOR_LABEL,
				ROUTING_STYLES_COMBOFIELDEDITOR_NAMES_AND_VALUES, routingGroup);
		routingStylesComboFieldEditor.setPage(dialogPage);

		routingObstructionPolicyBooleanFieldEditor = new BooleanFieldEditor(
				getPreferenceConstant(PreferenceConstantHelper.ROUTING_POLICY_OBSTRUCTION),
				ROUTING_OBSTRUCTION_POLICY_BOOLEANFIELDEDITOR_LABEL, routingGroup);
		routingObstructionPolicyBooleanFieldEditor.setPage(dialogPage);
		
		routingDistancePolicyBooleanFieldEditor = new BooleanFieldEditor(
				getPreferenceConstant(PreferenceConstantHelper.ROUTING_POLICY_DISTANCE),
				ROUTING_DISTANCE_POLICY_BOOLEANFIELDEDITOR_LABEL, routingGroup);
		routingDistancePolicyBooleanFieldEditor.setPage(dialogPage);

	}
	
	public void setPreferenceStore(IPreferenceStore preferenceStore) {
		super.setPreferenceStore(preferenceStore);
		jumpLinkReverseBooleanFieldEditor.setPreferenceStore(preferenceStore);
		jumpLinkStatusComboFieldEditor.setPreferenceStore(preferenceStore);
		jumpLinkTypeComboFieldEditor.setPreferenceStore(preferenceStore);
		routingDistancePolicyBooleanFieldEditor.setPreferenceStore(preferenceStore);
		routingObstructionPolicyBooleanFieldEditor.setPreferenceStore(preferenceStore);
		routingStylesComboFieldEditor.setPreferenceStore(preferenceStore);
	}
	
	public void load(){
	jumpLinkReverseBooleanFieldEditor.load();
	jumpLinkStatusComboFieldEditor.load();
	jumpLinkTypeComboFieldEditor.load();
	routingDistancePolicyBooleanFieldEditor.load();
	routingObstructionPolicyBooleanFieldEditor.load();
	routingStylesComboFieldEditor.load();
	}
	
	public void storePreferences() {
		jumpLinkReverseBooleanFieldEditor.store();
		jumpLinkStatusComboFieldEditor.store();
		jumpLinkTypeComboFieldEditor.store();
		routingDistancePolicyBooleanFieldEditor.store();
		routingObstructionPolicyBooleanFieldEditor.store();
		routingStylesComboFieldEditor.store();
	}
	@Override
	public void loadDefault() {
		jumpLinkReverseBooleanFieldEditor.loadDefault();
		jumpLinkStatusComboFieldEditor.loadDefault();
		jumpLinkTypeComboFieldEditor.loadDefault();
		routingDistancePolicyBooleanFieldEditor.loadDefault();
		routingObstructionPolicyBooleanFieldEditor.loadDefault();
		routingStylesComboFieldEditor.loadDefault();
		
	}
	
}
