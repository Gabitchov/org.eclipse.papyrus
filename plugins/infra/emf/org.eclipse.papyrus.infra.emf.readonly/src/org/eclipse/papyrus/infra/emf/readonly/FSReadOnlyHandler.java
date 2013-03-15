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
package org.eclipse.papyrus.infra.emf.readonly;

import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourceAttributes;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;

import com.google.common.base.Optional;

public class FSReadOnlyHandler  extends AbstractReadOnlyHandler {

	public Optional<Boolean> anyReadOnly(URI[] uris, EditingDomain editingDomain) {
		for(URI uri : uris) {

			IFile file = getFile(uri);
			if(file != null && file.isReadOnly()) {
				return Optional.of(Boolean.TRUE);
			}
		}

		return Optional.absent();
	}

	private static IFile getFile(URI uri) {
		if(uri.isPlatform()) {
			return ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(uri.toPlatformString(true)));
		}
		return null;
	}

	public Optional<Boolean> makeWritable(final URI[] uris, EditingDomain editingDomain) {
		final AtomicBoolean doEnableWrite = new AtomicBoolean();
		Display.getCurrent().syncExec(new Runnable() {

			public void run() {
				String message = "Do you want to remove read only flag on those files ?\n\n";
				for(URI uri : uris) {
					IFile file = getFile(uri);
					if(file != null && file.isReadOnly()) {
						message += file.getName() + "\n";
					}
				}
				doEnableWrite.set(MessageDialog.openConfirm(Display.getCurrent().getActiveShell(), "Enable write", message));
			}
		});

		if(doEnableWrite.get()) {
			Boolean ok = true;
			for(URI uri : uris) {
				IFile file = getFile(uri);
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
			return Optional.of(ok);
		} else {
			return Optional.absent();
		}
	}

}
