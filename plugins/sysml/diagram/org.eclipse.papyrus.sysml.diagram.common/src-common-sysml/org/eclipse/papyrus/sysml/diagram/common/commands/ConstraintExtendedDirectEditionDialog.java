/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.common.commands;

import org.eclipse.papyrus.extensionpoints.editors.configuration.IDirectEditorConfiguration;
import org.eclipse.papyrus.extensionpoints.editors.ui.ExtendedDirectEditionDialog;
import org.eclipse.swt.widgets.Shell;

public class ConstraintExtendedDirectEditionDialog extends ExtendedDirectEditionDialog {

	public ConstraintExtendedDirectEditionDialog(Shell parentShell,
			Object object, String initialValue,
			IDirectEditorConfiguration configuration) {
		super(parentShell, object, initialValue, configuration);
		this.title = "Edit Constraint specification";
	}

}
