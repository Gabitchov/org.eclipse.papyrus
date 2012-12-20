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

import org.eclipse.swt.widgets.Composite;


public class MultipleChoiceFieldEditor extends MUFromXtext {

	/*
	 * public MultipleChoiceFieldEditor(String name, String labelText, Composite parent) {
	 * super(name, labelText, parent);
	 * }
	 */

	public MultipleChoiceFieldEditor(String name, String labeltext, int numColumns, String[][] labelsAndValues, Composite fieldEditorParent, boolean useGroup) {
		super(name, labeltext, numColumns, labelsAndValues, fieldEditorParent, useGroup);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected String calculateResult(String[][] settings) {
		int traceActionValue = 0;
		int index = 0;
		for(String setting[] : settings) {
			// [0] = name, [1] = value [2] = checked
			if(setting[2].equals("true")) {
				traceActionValue += 1 << index;
			}
			index++;
		};
		/*
		 * String traceMechanism = "";
		 * for(Object tableElement : fTraceImplementations.getCheckedElements()) {
		 * traceMechanism = (String)tableElement;
		 * };
		 * 
		 * Object[] result = new Object[]{
		 * traceActionValue,
		 * traceMechanism
		 * };
		 */
		return String.valueOf(traceActionValue);
	}

	@Override
	protected boolean isSelected(String fieldName, String valueToSet) {
		try {
			int value = new Integer(valueToSet);
			int index = 0;
			for(String setting[] : labelsAndValues) {
				// [0] = name, [1] = value [2] = checked
				if(setting[0].equals(fieldName)) {
					return (value & (1 << index)) > 0;
				}
				index++;
			};
		} catch (NumberFormatException e) {
		}
		return false;
	}

}
