/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.preferences;

/**
 * Defines specific preference constants for the UML activity diagram.
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface IActivityPreferenceConstants {

	/**
	 * the preference for opening the confirmation popup when an attribute
	 * property or a parameter is modified. This popup warns the user that
	 * invoking actions will be updated with a pin reorganization.
	 */
	public static final String PREF_CONFIRM_PIN_SYNC_FROM_PARAMETER = "org.eclipse.papyrus.uml.diagram.activity.confirmPinSyncFromParameter"; //$NON-NLS-1$

	/**
	 * the preference for opening the confirmation popup when a parameter is
	 * removed. This popup warns the user that associated activity parameter
	 * nodes will be removed too.
	 */
	public static final String PREF_CONFIRM_ACTIVITY_PARAMETER_SYNC_FROM_PARAMETER = "org.eclipse.papyrus.uml.diagram.activity.confirmActivityParameterSyncFromParameter"; //$NON-NLS-1$

	/**
	 * the preference for displaying the name label of an activity edge.
	 */
	public static final String PREF_ACTIVITY_EDGE_SHOW_NAME_LABEL = "org.eclipse.papyrus.uml.diagram.activity.ActivityEdge.showNameLabel"; //$NON-NLS-1$

	/**
	 * the preference for displaying the specific label of the descent of
	 * structured activity node (LoopNode , ConditionalNode ...)
	 */
	public static final String PREF_STRUCTURED_SPECIFIC_KEYWORD_DISPLAY_LOOP_NODE = "org.eclipse.papyrus.uml.diagram.activity.StructuredActivityNode.specificLabel.loopNode"; //$NON-NLS-1$

	/**
	 * the preference for displaying the specific label of the descent of
	 * structured activity node (LoopNode , ConditionalNode ...)
	 */
	public static final String PREF_STRUCTURED_SPECIFIC_KEYWORD_DISPLAY_CONDITIONAL_NODE = "org.eclipse.papyrus.uml.diagram.activity.StructuredActivityNode.specificLabel.conditionalNode"; //$NON-NLS-1$

	/**
	 * the preference for displaying the specific label of the descent of
	 * structured activity node (LoopNode , ConditionalNode ...)
	 */
	public static final String PREF_STRUCTURED_SPECIFIC_KEYWORD_DISPLAY_SEQUENCE_NODE = "org.eclipse.papyrus.uml.diagram.activity.StructuredActivityNode.specificLabel.sequenceNode"; //$NON-NLS-1$

	/**
	 * the preference for displaying the specific label of the descent of
	 * structured activity node (LoopNode , ConditionalNode ...)
	 */
	public static final String PREF_STRUCTURED_SPECIFIC_KEYWORD_DISPLAY_STRUCTURED_NODE = "org.eclipse.papyrus.uml.diagram.activity.StructuredActivityNode.specificLabel.structuredNode"; //$NON-NLS-1$

	/**
	 * Alpha of the following figure
	 */
	public static final String PREF_ACTIVITY_PARTITION_ALPHA = "org.eclipse.papyrus.uml.diagram.activity.StructuredActivityNode.alpha.activityPartition"; //$NON-NLS-1$

	/**
	 * Alpha of the following figure
	 */
	public static final String PREF_STRUCTURED_NODE_ALPHA = "org.eclipse.papyrus.uml.diagram.activity.StructuredActivityNode.alpha.structuredNode"; //$NON-NLS-1$

	/**
	 * Alpha of the following figure
	 */
	public static final String PREF_LOOP_NODE_ALPHA = "org.eclipse.papyrus.uml.diagram.activity.StructuredActivityNode.alpha.loopNode"; //$NON-NLS-1$

	/**
	 * Alpha of the following figure
	 */
	public static final String PREF_CONDITIONAL_NODE_ALPHA = "org.eclipse.papyrus.uml.diagram.activity.StructuredActivityNode.alpha.conditionalNode"; //$NON-NLS-1$

	/**
	 * Alpha of the following figure
	 */
	public static final String PREF_SEQUENCE_NODE_ALPHA = "org.eclipse.papyrus.uml.diagram.activity.StructuredActivityNode.alpha.sequenceNode"; //$NON-NLS-1$

	/**
	 * Alpha of the following figure
	 */
	public static final String PREF_EXPANSION_REGION_ALPHA = "org.eclipse.papyrus.uml.diagram.activity.StructuredActivityNode.alpha.conditionalNode"; //$NON-NLS-1$

	/**
	 * the preference for keeping user's choice of whether select or create
	 * option is selected in the CallBehaviorAction creation dialog.
	 */
	public static final String PREF_NEW_CALL_BEHAVIOR_ACTION_SELECT_AS_DEFAULT = "org.eclipse.papyrus.uml.diagram.activity.CallBehaviorAction.CreateDialog.selectAsDefault"; //$NON-NLS-1$

	/**
	 * the preference for keeping user's choice of whether select or create
	 * option is selected in the CallOperationAction creation dialog.
	 */
	public static final String PREF_NEW_CALL_OPERATION_ACTION_SELECT_AS_DEFAULT = "org.eclipse.papyrus.uml.diagram.activity.CallOperationAction.CreateDialog.selectAsDefault"; //$NON-NLS-1$

	/**
	 * the preference for keeping user's choice of whether select or create
	 * option is selected in the SendSignalAction creation dialog.
	 */
	public static final String PREF_NEW_SEND_SIGNAL_ACTION_SELECT_AS_DEFAULT = "org.eclipse.papyrus.uml.diagram.activity.SendSignalAction.CreateDialog.selectAsDefault"; //$NON-NLS-1$

	/**
	 * the preference for keeping user's choice of which is the default owner's
	 * URI of the new created Behavior in the CallBehaviorAction creation dialog
	 * in a given resource.
	 */
	public static final String PREF_NEW_CALL_BEHAVIOR_ACTION_CREATION_OWNER = "org.eclipse.papyrus.uml.diagram.activity.CallBehaviorAction.CreateDialog.owner"; //$NON-NLS-1$

	/**
	 * the preference for keeping user's choice of which is the default owner's
	 * URI of the new created Operation in the CallOperationAction creation
	 * dialog in a given resource.
	 */
	public static final String PREF_NEW_CALL_OPERATION_ACTION_CREATION_OWNER = "org.eclipse.papyrus.uml.diagram.activity.CallOperationAction.CreateDialog.owner"; //$NON-NLS-1$

	/**
	 * the preference for keeping user's choice of which is the default owner's
	 * URI of the new created Signal in the SendSignalAction creation dialog in
	 * a given resource.
	 */
	public static final String PREF_NEW_SEND_SIGNAL_ACTION_CREATION_OWNER = "org.eclipse.papyrus.uml.diagram.activity.SendSignalAction.CreateDialog.owner"; //$NON-NLS-1$
}
