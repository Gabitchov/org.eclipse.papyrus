package com.cea.papyrus.profile.ui.dialogs;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;

import com.cea.papyrus.profile.Activator;


public class FileSelectionValidator implements ISelectionStatusValidator {

	public IStatus validate(Object[] arg0) {

		if ((arg0 == null) || (arg0.length < 1)) {
			return new Status(IStatus.ERROR, Activator.PLUGIN_ID, "No selection.");
		}
		
		Object selection = arg0[0];
		if (! (selection instanceof IFile)) {
			
			return new Status(IStatus.ERROR, Activator.PLUGIN_ID, "The selection should be a file.");
		}
		
		return new Status(
				IStatus.OK
				, Activator.PLUGIN_ID
				, "Selection is valid");
	}
}

