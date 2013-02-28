/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  <a href="mailto:thomas.szadel@atosorigin.com">Thomas Szadel</a> - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.ui.resources.refactoring;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.papyrus.infra.core.resource.sasheditor.DiModel;
import org.eclipse.papyrus.infra.ui.resources.refactoring.ui.RenameParticipantsDialog;
import org.eclipse.swt.widgets.Display;

public class ModelParticipantHelpers {

	/**
	 * get the files related the initialFile which need to be modified/deleted
	 * if initialFile is modified/deleted
	 * 
	 * @param initialFile
	 * @return a list of related files. Does not include initialFile.
	 */
	public static Set<IResource> getResourceToFix(final IFile initialFile) {

		RenameDialogRunnable runnable = new RenameDialogRunnable(initialFile);
		Display.getDefault().syncExec(runnable);
		return new HashSet<IResource>(runnable.getFiles());
	}

	/**
	 * get the files related the initialFile which need to be modified/deleted
	 * if initialFile is modified/deleted
	 * 
	 * @param initialFile
	 * @return a list of related files. Does not include initialFile.
	 */
	public static Set<IResource> getRelatedFiles(final IFile initialFile) {


		IContainer parent = initialFile.getParent();
		IPath initialPath = initialFile.getFullPath();

		IPath diPath = null;

		if(DiModel.DI_FILE_EXTENSION.equalsIgnoreCase(initialPath.getFileExtension())) {
			diPath = initialPath;
		} else {
			return Collections.<IResource> singleton(initialFile);
		}

		Set<IResource> relatedFiles = new HashSet<IResource>();
		if(diPath != null) {
			IFile diFile = parent.getFile(diPath.makeRelativeTo(parent.getFullPath()));
			if(diFile.exists()) {
				try {
					for(IResource r : diFile.getParent().members()) {
						if(r.getFullPath().removeFileExtension().lastSegment().equals(diFile.getFullPath().removeFileExtension().lastSegment())) {
							relatedFiles.add(r);
						}
					}
				} catch (CoreException e) {
				}
			}
		}

		// If the initialFile is contained in the list, we remove it
		if(relatedFiles.contains(initialFile)) {
			relatedFiles.remove(initialFile);
		}



		return relatedFiles;
	}

	public static class RenameDialogRunnable implements Runnable {

		private IFile initialFile;

		private RenameParticipantsDialog renameParticipantsDialog;

		public RenameDialogRunnable(IFile file) {
			initialFile = file;
		}

		public void run() {
			renameParticipantsDialog = new RenameParticipantsDialog(Display.getDefault().getActiveShell(), initialFile);
			renameParticipantsDialog.open();
		}

		public Collection<? extends IResource> getFiles() {
			return renameParticipantsDialog.getFiles();
		}
	}
}
