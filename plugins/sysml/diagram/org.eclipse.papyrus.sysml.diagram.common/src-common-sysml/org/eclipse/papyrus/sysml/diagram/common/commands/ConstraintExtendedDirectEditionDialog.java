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
