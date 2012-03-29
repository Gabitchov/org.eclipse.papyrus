/*****************************************************************************
 * Copyright (c) 2011 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mathieu Velten (Atos Origin) mathieu.velten@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.readonly;

import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourceAttributes;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;

public class FSReadOnlyHandler implements IReadOnlyHandler {

	public boolean isReadOnly(IFile[] files, EditingDomain editingDomain) {
		for(IFile file : files) {
			if(file != null && file.isReadOnly()) {
				return true;
			}
		}
		return false;
	}

	public boolean enableWrite(final IFile[] files, EditingDomain editingDomain) {
		final AtomicBoolean doEnableWrite = new AtomicBoolean();
		Display.getCurrent().syncExec(new Runnable() {

			public void run() {
				String message = "Do you want to remove read only flag on those files ?\n\n";
				for(IFile file : files) {
					if(file != null && file.isReadOnly()) {
						message += file.getName() + "\n";
					}
				}
				doEnableWrite.set(MessageDialog.openConfirm(Display.getCurrent().getActiveShell(), "Enable write", message));
			}
		});

		if(doEnableWrite.get()) {
			boolean ok = true;
			for(IFile file : files) {
				if(file != null && file.isReadOnly()) {
					try {
						ResourceAttributes att = file.getResourceAttributes();
						att.setReadOnly(false);
						file.setResourceAttributes(att);
					} catch (CoreException e) {
						ok = false;
					}
				}
			}
			return ok;
		} else {
			return false;
		}
	}

}
