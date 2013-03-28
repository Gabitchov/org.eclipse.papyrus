/*****************************************************************************
 * Copyright (c) 2013 CEA LIST
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Patrick Tessier - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.part;

import org.eclipse.osgi.util.NLS;

/**
 * custom messages
 * 
 * @author PT202707
 * 
 */
public class CustomMessages extends NLS {

	static {
		NLS.initializeMessages("custom-messages", CustomMessages.class); //$NON-NLS-1$
	}

	private CustomMessages() {
	}

	public static String UMLValidation_ErrorTitle;

	public static String UMLValidation_WarningTitle;

	public static String CreatePinsForObjectFlowDialog_Title;

	public static String CreatePinsForObjectFlowDialog_PinCreationTitle;

	public static String CreatePinsForObjectFlowDialog_PinCreationHelp;

	public static String CreatePinsForObjectFlowDialog_Name;

	public static String CreatePinsForObjectFlowDialog_Type;

	public static String PinAndParameterSynchronizer_UndeleteablePinTitle;

	public static String PinAndParameterSynchronizer_UndeleteablePinMessage;

	public static String PinAndParameterSynchronizer_UnauthorizedModificationTitle;

	public static String PinAndParameterSynchronizer_UnauthorizedModificationRedirection;

	public static String PinAndParameterSynchronizer_UnauthorizedModification;

	public static String ActivityParameterAndParameterSynchronizer_UnauthorizedModificationTitle;

	public static String ActivityParameterAndParameterSynchronizer_UnauthorizedModificationRedirection;

	public static String ConfirmPinAndParameterSync_Title;

	public static String ConfirmPinAndParameterSync_FromParameterMsg;

	public static String ConfirmActivityParameterAndParameterSync_Title;

	public static String ConfirmActivityParameterAndParameterSync_FromParameterMsg;

	public static String CreateCallActionDialog_OperationTitle;

	public static String CreateCallActionDialog_SelectOperation;

	public static String CreateCallActionDialog_CreateOperation;

	public static String CreateCallActionDialog_BehaviorTitle;

	public static String CreateCallActionDialog_SelectBehavior;

	public static String CreateCallActionDialog_CreateBehavior;

	public static String CreateCallActionDialog_SignalTitle;

	public static String CreateCallActionDialog_SelectSignal;

	public static String CreateCallActionDialog_CreateSignal;

	public static String CreateCallActionDialog_ParentLabel;

	public static String CreateCallActionDialog_NameLabel;

	public static String CreateCallActionDialog_TypeLabel;

	public static String CreateCallActionDialog_IsSynchronousTitle;

	public static String CreateCallActionDialog_IsSynchronousHelp;

	public static String CreateCallActionDialog_IsSynchronous;

	public static String CreateCallActionDialog_OperationInvocationCreationTitle;

	public static String CreateCallActionDialog_OperationInvocationCreationHelp;

	public static String CreateCallActionDialog_OperationInvocationSelectionTitle;

	public static String CreateCallActionDialog_BehaviorInvocationCreationTitle;

	public static String CreateCallActionDialog_BehaviorInvocationCreationHelp;

	public static String CreateCallActionDialog_BehaviorInvocationSelectionTitle;

	public static String CreateCallActionDialog_SignalInvocationCreationTitle;

	public static String CreateCallActionDialog_SignalInvocationCreationHelp;

	public static String CreateCallActionDialog_SignalInvocationSelectionTitle;

	public static String CreateActivityParameterNodeDialog_DialogTitle;

	public static String CreateActivityParameterNodeDialog_ParameterSelectionTitle;

	public static String CreateActivityParameterNodeDialog_ParameterSelectionHelp;

	public static String CreateActivityParameterNodeDialog_ParameterSelectionLabel;

	public static String CreateActivityParameterNodeDialog_ParameterCreationTitle;

	public static String CreateActivityParameterNodeDialog_ParameterCreationHelp;

	public static String CreateActivityParameterNodeDialog_ParameterCreationLabel;

	public static String CreateActivityParameterNodeDialog_NameLabel;

	public static String CreateActivityParameterNodeDialog_TypeLabel;

	public static String CreateActivityParameterNodeDialog_DirectionLabel;

	public static String CreateParameterDialog_WarnNoImpact;

	public static String CreateParameterDialog_WarnImpact;

	public static String CreateParameterDialog_Open;

	public static String CreateParameterDialog_DialogTitle;

	public static String CreateParameterDialog_ParameterCreationTitle;

	public static String CreateParameterDialog_ParameterCreationHelp;

	public static String CreateParameterDialog_NameLabel;

	public static String CreateParameterDialog_TypeLabel;

	public static String CreateParameterDialog_DirectionLabel;

	public static String CreateAttributeDialog_WarnNoImpact;

	public static String CreateAttributeDialog_WarnImpact;

	public static String CreateAttributeDialog_Open;

	public static String CreateAttributeDialog_DialogTitle;

	public static String CreateAttributeDialog_CreationTitle;

	public static String CreateAttributeDialog_NameLabel;

	public static String CreateAttributeDialog_EClassLabel;

	public static String CreateAttributeDialog_TypeLabel;

	public static String DiagramsPreferencePage_disableNotification;

	public static String DiagramsPreferencePage_notificationGroup_label;

	public static String DiagramsPreferencePage_confirmPinSyncFromParameter_label;

	public static String DiagramsPreferencePage_confirmActivityParameterNodeSyncFromParameter_label;

	public static String ActivityEdgePreferencePage_visibilityGroup;

	public static String ActivityEdgePreferencePage_showName;

	public static String ForkJoinSegmentSwitchOrientation_actionLabel;

	public static String ForkJoinSegmentSwitchOrientation_helpMessage;

	public static String SpecificKeywordStructuredActivityNodeVisibility_visibility;

	public static String StructuredActivityNodePreferencePage_showSpecificKeyword;
	//TODO: put accessor fields manually	
}
