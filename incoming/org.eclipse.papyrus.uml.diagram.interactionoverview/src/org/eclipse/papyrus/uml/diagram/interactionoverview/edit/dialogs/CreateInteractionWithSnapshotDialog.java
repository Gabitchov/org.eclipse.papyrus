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
package org.eclipse.papyrus.uml.diagram.interactionoverview.edit.dialogs;

import org.eclipse.papyrus.uml.diagram.interactionoverview.part.Messages;
import org.eclipse.papyrus.uml.diagram.interactionoverview.preferences.InteractionOverviewPreferenceConstants;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.InvocationAction;

public class CreateInteractionWithSnapshotDialog extends
		CreateInteractionUseDialog {

	public CreateInteractionWithSnapshotDialog(Shell shell, Activity owner,
			InvocationAction newAction) {
		super(shell, owner, newAction);
	}
	
	/**
	 * Get the id of the preference storing whether selection is the default
	 * choice.
	 * 
	 * @return preference id
	 */
	@Override
	protected String getSelectionIsDefaultPreference() {
		return InteractionOverviewPreferenceConstants.PREF_NEW_INTERACTION_SELECT_AS_DEFAULT;
	}

	/**
	 * Get the id of the preference storing the last selected owner.
	 * 
	 * @return preference id
	 */
	@Override
	protected String getCreationDefaultOwnerPreference() {
		return InteractionOverviewPreferenceConstants.PREF_NEW_INTERACTION_CREATION_OWNER;
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.activity.edit.dialogs.CreateInvocationActionDialog#getInvocationCreationSectionTitle()
	 */
	@Override
	protected String getInvocationCreationSectionTitle() {
		return Messages.CreateCallBehaviorActionAsInteractionDialog_BehaviorInvocationCreationTitle;
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.activity.edit.dialogs.CreateInvocationActionDialog#getInvocationCreationSectionHelp()
	 */
	@Override
	protected String getInvocationCreationSectionHelp() {
		return Messages.CreateCallBehaviorActionAsInteractionDialog_BehaviorInvocationCreationHelp;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.activity.edit.dialogs.CreateCallActionDialog#getTitle()
	 */
	@Override
	protected String getTitle() {
		return Messages.CreateCallBehaviorActionAsInteractionDialog_BehaviorTitle;
	}

	@Override
	protected String getCreationLabel() {
		return Messages.CreateCallBehaviorActionAsInteractionDialog_CreateBehavior;
	}

	@Override
	protected String getSelectionLabel() {
		return Messages.CreateCallBehaviorActionAsInteractionDialog_SelectBehavior;
	}

}
