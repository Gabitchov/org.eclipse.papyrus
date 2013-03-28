/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
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

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.gmfdiag.preferences.pages.DiagramPreferencePage;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActivityDiagramEditPart;
import org.eclipse.papyrus.uml.diagram.activity.part.CustomMessages;
import org.eclipse.papyrus.uml.diagram.activity.part.Messages;
import org.eclipse.papyrus.uml.diagram.activity.part.UMLDiagramEditorPlugin;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

/**
 * @generated
 */
public class DiagramGeneralPreferencePage extends DiagramPreferencePage {

	/**
	 * @generated NOT
	 *            preference page editor control for displaying the pin synchronization from parameter confirmation dialog
	 */
	private BooleanFieldEditor confirmPinSyncFromParameter = null;

	/**
	 * @generated NOT
	 *            preference page editor control for displaying the activity parameter node synchronization from parameter confirmation dialog
	 */
	private BooleanFieldEditor confirmActivityParameterNodeSyncFromParameter = null;

	/**
	 * @generated
	 */
	public DiagramGeneralPreferencePage() {
		setPreferenceStore(UMLDiagramEditorPlugin.getInstance().getPreferenceStore());
		setPreferenceKey(ActivityDiagramEditPart.MODEL_ID);
	}

	/**
	 * Adds the field editors to this composite.
	 * 
	 * @param parent
	 *        the parent Composite that the field editors will be added to
	 * @generated NOT
	 */
	protected void addFields(Composite parent) {
		super.addFields(parent);
		Group notificationsGroup = new Group(parent, SWT.NONE);
		GridLayout gridLayout = new GridLayout(2, false);
		notificationsGroup.setLayout(gridLayout);
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalSpan = 2;
		notificationsGroup.setLayoutData(gridData);
		notificationsGroup.setText(CustomMessages.DiagramsPreferencePage_notificationGroup_label);
		Composite composite = new Composite(notificationsGroup, SWT.NONE);
		confirmPinSyncFromParameter = new BooleanFieldEditor(IActivityPreferenceConstants.PREF_CONFIRM_PIN_SYNC_FROM_PARAMETER, CustomMessages.DiagramsPreferencePage_confirmPinSyncFromParameter_label, composite);
		addField(confirmPinSyncFromParameter);
		confirmActivityParameterNodeSyncFromParameter = new BooleanFieldEditor(IActivityPreferenceConstants.PREF_CONFIRM_ACTIVITY_PARAMETER_SYNC_FROM_PARAMETER, CustomMessages.DiagramsPreferencePage_confirmActivityParameterNodeSyncFromParameter_label, composite);
		addField(confirmActivityParameterNodeSyncFromParameter);
	}

	/**
	 * Initializes the default preference values for this preference store.
	 * 
	 * @param IPreferenceStore
	 *        preferenceStore
	 * @generated NOT
	 */
	public static void initSpecificDefaults(IPreferenceStore preferenceStore) {
		preferenceStore.setDefault(IActivityPreferenceConstants.PREF_CONFIRM_PIN_SYNC_FROM_PARAMETER, true);
		preferenceStore.setDefault(IActivityPreferenceConstants.PREF_CONFIRM_ACTIVITY_PARAMETER_SYNC_FROM_PARAMETER, true);
	}
}
