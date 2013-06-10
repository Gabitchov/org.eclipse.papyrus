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
package org.eclipse.papyrus.uml.diagram.interactionoverview.part;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	static {
		NLS.initializeMessages("messages", Messages.class); //$NON-NLS-1$
	}

	private Messages() {
	}

	public static String CustomInteractionOverviewDiagramCreationEditPolicy_CreateActivity;

	public static String CreateCallActionDialog_BehaviorInvocationCreationTitle;

	public static String CreateCallActionDialog_BehaviorInvocationCreationHelp;

	public static String CreateCallActionDialog_BehaviorInvocationSelectionTitle;

	public static String CreateCallActionDialog_BehaviorTitle;

	public static String CreateCallActionDialog_CreateBehavior;

	public static String CreateCallActionDialog_SelectBehavior;

	public static String CallBehaviorActionAsInteractionEditHelperAdvice_ConfigureCreatedInteraction;

	public static String CallBehaviorActionAsInteractionUseEditHelperAdvice_ConfigureCreatedInteraction;

	public static String CreateSnapshotForInteractionFromRefreshCommand_CreateSnapshotForRefresh;

	public static String CreateSnapshotForInteractionFromViewDescriptorCommand_CreateSnapshotForRefresh;

	public static String CreateInteractionUseDialog_InteractionUsePrefix;

	public static String ActivityContentCompartmentCreationEditPolicy_CreateCallBehaviorActionAsInteractionCommand;

	public static String CreateDiagramImage_LifelineDialogTitle;

	public static String CreateDiagramImage_LifelineDialogMessage;

	public static String CreateDiagramImage_MultipleValueSelectorDialog;

	public static String CreateSnapshotForInteractionFromViewDescriptorCommand_DiagramSelectorTitle;

	public static String CreateSnapshotForInteractionFromViewDescriptorCommand_DiagramSelectorMessage;
}
