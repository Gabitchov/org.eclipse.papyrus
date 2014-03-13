/*******************************************************************************
 * Copyright (c) 2008, 2009 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Gabriel Barbier (Mia-Software) - initial API and implementation
 *    Fabien Giquel (Mia-Software)
 *    Nicolas Bros (Mia-Software)
 *    Nicolas Guyomar (Mia-Software) - Bug 340339 - Need some Utils class for Folder/File/Project management
 *******************************************************************************/

package org.eclipse.papyrus.emf.facet.util.core.internal.exported;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;

/**
 * @author Gabriel Barbier
 * @since 0.2
 */
public final class FolderUtils {

	// This class has been copied from org.eclipse.papyrus.emf.facet.infra.common.core.internal.utils.FolderUtils

	private FolderUtils() {
		// prevent instantiation
	}

	/**
	 * This method delete the content of the folder
	 * @param folder The folder that has to be emptied
	 */
	public static final void clearFolder(final File folder) {
		assert folder != null;
		assert folder.exists();
		assert folder.isDirectory();
		/*
		 * To delete the contents of this folder, we recurse on all elements (File) in this folder.
		 * In the case of a directory, we first delete its own contents before deleting it. In the
		 * case of a file, we just delete the file.
		 */
		File[] files = folder.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				FolderUtils.clearFolder(file);
			}
			file.delete();
		}
	}

	/**
	 * This method create a folder and it parents if they do not exists.
	 * @param folder The folder that have to be created.
	 * @throws CoreException
	 */
	public static void createFolder(final IFolder folder) throws CoreException {
		if (!folder.getParent().exists()) {
			FolderUtils.createFolder((IFolder) folder.getParent());
		}
		if (!folder.exists()) {
			folder.create(true, true, new NullProgressMonitor());
		}
	}

	/**
	 * Copies the source directory to the target directory. The target is
	 * created if it does not exist.
	 */
	public static final void copyFolder(final File srcDir, final File destDir)
			throws IOException {
		FolderUtils.copyFolder(srcDir, destDir, new IFilter<String>() {
			public boolean filter(final String object) {
				return true;
			}
		});
	}

	/**
	 * Copies the source directory to the target directory.
	 */
	public static final void copyFolder(final File srcDir, final File destDir,
			final IFilter<String> filter) throws IOException {

		if (!destDir.exists()) {
			destDir.mkdirs();
		}
		File[] filesList = srcDir.listFiles();
		File dest;
		// Copies each file and directory, one by one
		for (File src : filesList) {
			dest = new File(destDir.getPath() + File.separator + src.getName());
			if (filter.filter(dest.getAbsolutePath())) {
				if (src.isDirectory()) {
					FolderUtils.copyFolder(src, dest, filter);
				} else {
					FileUtils.copyFile(src, dest);
				}
			}
		}
	}
}
