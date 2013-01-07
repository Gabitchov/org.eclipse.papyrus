/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Ansgar Radermacher (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.services.tracepoints.preferences;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.RadioGroupFieldEditor;
import org.eclipse.papyrus.infra.services.tracepoints.ITraceMechanism;
import org.eclipse.papyrus.infra.services.tracepoints.TraceActions;
import org.eclipse.papyrus.infra.services.tracepoints.TraceActions.TAClass;
import org.eclipse.papyrus.infra.services.tracepoints.TraceActions.TAOperation;
import org.eclipse.papyrus.infra.services.tracepoints.TraceActions.TAState;
import org.eclipse.papyrus.infra.services.tracepoints.TraceMechanism;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * This class represents the TracePoint preference page
 * <p>
 * This page is used to modify preferences only. They are stored in the preference store that belongs to the main plug-in class. That way, preferences
 * can be accessed directly via the preference store.
 */

public class TPPreferencePage
	extends FieldEditorPreferencePage
	implements IWorkbenchPreferencePage {

	public TPPreferencePage() {
		super(GRID);
		setPreferenceStore(org.eclipse.papyrus.infra.services.tracepoints.Activator.getDefault().getPreferenceStore());
		setDescription("Trace options");
	}

	/**
	 * Creates the field editors. Field editors are abstractions of
	 * the common GUI blocks needed to manipulate various types
	 * of preferences. Each field editor knows how to save and
	 * restore itself.
	 */
	public void createFieldEditors() {
		EList<ITraceMechanism> mechanisms = TraceMechanism.getTraceMechanisms();
		int elements = 0;
		int i;
		for(ITraceMechanism mechanism : mechanisms) {
			// TODO: function need to support null object
			EList<String> mechanismIDs = mechanism.getTraceMechanismIDs(null);
			elements += mechanismIDs.size();
		}
		String[][] mechList = new String[elements][2];
		elements = 0;
		for(ITraceMechanism mechanism : mechanisms) {
			// TODO: function need to support null object
			EList<String> mechanismIDs = mechanism.getTraceMechanismIDs(null);
			for(String id : mechanismIDs) {
				mechList[elements][1] = id;
				mechList[elements][0] = mechanism.getTraceMechanismDescription(null, id);
				elements++;
			}
		}

		String[][] taClassOptions = TraceActions.getStringFields(TAClass.values());
		String[][] taStateOptions = TraceActions.getStringFields(TAState.values());
		String[][] taOperationOptions = TraceActions.getStringFields(TAOperation.values());

		addField(new BinaryEncodedMChoiceFieldEditor(TPPreferenceConstants.P_TRACE_OPTION_CLASS, "Class options", 3, taClassOptions, getFieldEditorParent(), true));

		addField(new BinaryEncodedMChoiceFieldEditor(TPPreferenceConstants.P_TRACE_OPTION_STATE, "State options", 3, taStateOptions, getFieldEditorParent(), true));

		addField(new RadioGroupFieldEditor(
			TPPreferenceConstants.P_TRACE_OPTION_OP,
			"Operations options", 3, taOperationOptions, getFieldEditorParent(), true));

		addField(new ComboFieldEditor(
			TPPreferenceConstants.P_TRACE_IMPLEMENTATION_PORT,
			"Trace Mechanism for ports", mechList, getFieldEditorParent()));

		addField(new ComboFieldEditor(
			TPPreferenceConstants.P_TRACE_IMPLEMENTATION_OP,
			"Trace Mechanism for operations (+construction/destruction)", mechList, getFieldEditorParent()));

		addField(new ComboFieldEditor(
			TPPreferenceConstants.P_TRACE_IMPLEMENTATION_SM,
			"Trace Mechanism for state machines", mechList, getFieldEditorParent()));

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {
	}
}
