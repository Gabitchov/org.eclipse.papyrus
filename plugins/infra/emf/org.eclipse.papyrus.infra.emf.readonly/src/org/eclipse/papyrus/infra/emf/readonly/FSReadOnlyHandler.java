/*****************************************************************************
 * Copyright (c) 2011, 2014 Atos Origin, CEA, and otherw.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mathieu Velten (Atos Origin) mathieu.velten@atosorigin.com - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 323802
 *  Christian W. Damus (CEA) - bug 429826
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.readonly;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourceAttributes;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.papyrus.infra.core.resource.ReadOnlyAxis;
import org.eclipse.swt.widgets.Display;

import com.google.common.base.Optional;

/**
 * The filesystem read-only handler is permission-based.
 */
public class FSReadOnlyHandler extends AbstractReadOnlyHandler {

	public FSReadOnlyHandler(EditingDomain editingDomain) {
		super(editingDomain);
	}

	public Optional<Boolean> anyReadOnly(Set<ReadOnlyAxis> axes, URI[] uris) {
		if (axes.contains(ReadOnlyAxis.PERMISSION)) {
			for(URI uri : uris) {
				IFile file = getFile(uri);
				if(file != null && file.isReadOnly()) {
					return Optional.of(Boolean.TRUE);
				}
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

	public Optional<Boolean> makeWritable(Set<ReadOnlyAxis> axes, final URI[] uris) {
		if (!axes.contains(ReadOnlyAxis.PERMISSION)) {
			return Optional.absent();
		}
		
		final AtomicBoolean doEnableWrite = new AtomicBoolean();
		
		// We can't make a file writable if it already is (there are read-only handlers that treat files that
		// are filesystem-writable as read-only for other reasons)
		Collection<IFile> readOnlyFiles = new ArrayList<IFile>(uris.length);
		for(int i = 0; i < uris.length; i++) {
			IFile file = getFile(uris[i]);
			if((file != null) && file.isReadOnly()) {
				readOnlyFiles.add(file);
			}
		}
		
		if (!readOnlyFiles.isEmpty()) {
			Display.getCurrent().syncExec(new Runnable() {
	
				public void run() {
					String message = "Do you want to remove read only flag on those files ?\n\n";
					for(URI uri : uris) {
						IFile file = getFile(uri);
						if(file != null && file.isReadOnly()) {
							message += file.getName() + "\n";
						}
					}
					doEnableWrite.set(MessageDialog.openConfirm(Display.getCurrent().getActiveShell(), "Enable Write", message));
				}
			});
		}
		
		if(doEnableWrite.get()) {
			Boolean ok = true;
			for(IFile file : readOnlyFiles) {
				try {
					ResourceAttributes att = file.getResourceAttributes();
					att.setReadOnly(false);
					file.setResourceAttributes(att);
				} catch (CoreException e) {
					ok = false;
				}
			}
			return Optional.of(ok);
		} else {
			return Optional.absent();
		}
	}

	/**
	 * I can make workspace resources writable.
	 */
	@Override
	public Optional<Boolean> canMakeWritable(Set<ReadOnlyAxis> axes, URI[] uris) {
		Optional<Boolean> result = Optional.absent();

		if(axes.contains(ReadOnlyAxis.PERMISSION)) {
			for(int i = 0; (!result.isPresent() || result.get()) && (i < uris.length); i++) {
				if(uris[i].isPlatformResource()) {
					result = Optional.of(true);
				} else if(uris[i].isFile()) {
					// We don't make non-workspace (external but local) files writable
					result = Optional.of(false);
				}
			}
		}
		
		return result;
	}
}
