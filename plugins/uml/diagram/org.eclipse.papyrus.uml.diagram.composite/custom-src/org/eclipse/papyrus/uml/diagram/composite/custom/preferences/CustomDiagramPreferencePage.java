/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.composite.custom.preferences;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.composite.preferences.DiagramGeneralPreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;


public class CustomDiagramPreferencePage  extends DiagramGeneralPreferencePage{

	public static String IS_INSIDE_COMPOSITE_COMPOSITE_DIAGRAM= "isInsideComposite_CompositeDiagram";


	public CustomDiagramPreferencePage() {
		super();
	}

	@Override
	public void createFieldEditors() {
		Group group = createGroup("Port position");
		addField(new BooleanFieldEditor(IS_INSIDE_COMPOSITE_COMPOSITE_DIAGRAM,"is inside the composite",group));
		
	}
	

	/**
	 * Initialize preferences.
	 */
	public static void initDefaults(IPreferenceStore store) {
		store.setDefault(IS_INSIDE_COMPOSITE_COMPOSITE_DIAGRAM, false);
	}

	private Group createGroup(String text) {
		Group group = new Group(getFieldEditorParent(), SWT.NONE);
		//group.setLayout(new GridLayout(1, false));

		GridLayout gridLayout = new GridLayout(2, false);
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalSpan = 2;

		group.setLayoutData(gridData);
		group.setLayout(gridLayout);

		group.setText(text);

		return group;
	}
}
