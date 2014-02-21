/*******************************************************************************
 * Copyright (c) 2008, 2009, 2011 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Nicolas Bros (Mia-Software) - initial API and implementation
 *    Nicolas Guyomar (Mia-Software) - Bug 340339 - Need some Utils class for Folder/File/Project management
 *    Nicolas Guyomar (Mia-Software) - Bug 342451 - To be able to edit derived facet attributes and derived facet references in a table
 *    Gregoire Dupe (Mia-Software) - Bug 373078 - API Cleaning
 *    Thomas Cicognani (Soft-Maint) - Bug 398079 - org.eclipse.papyrus.emf.facet.util.core.internal.exported.FileUtils.copyFolderFromBundle 
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.util.core.internal.exported;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.Enumeration;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.osgi.framework.Bundle;

/**
 * @since 0.2
 */
public final class FileUtils {

	// This class has been copied from org.eclipse.papyrus.emf.facet.infra.common.core.internal.utils.FileUtils

	private static final int COPY_BUFFER_SIZE = 512 * 1024;

	private FileUtils() {
		// Nothing
	}

	/** Get the contents of a file from a Bundle */
	public static String getFileContents(final Bundle bundle, final String path) throws IOException {
		InputStream source;
		URL url = bundle.getResource(path);
		if (url == null) {
			return null;
		}
		source = url.openStream();
		return FileUtils.readInputStream(source);
	}

	public static String readInputStream(final InputStream stream) throws IOException {
		return readInputStream(stream, "UTF-8"); //$NON-NLS-1$
	}

	public static String readInputStream(final InputStream stream, final String charset)
			throws IOException {
		final int bufferSize = 65536;
		final char[] buffer = new char[bufferSize];
		StringBuilder builder = new StringBuilder();
		Reader reader = new InputStreamReader(stream, charset);
		int read;
		do {
			read = reader.read(buffer, 0, buffer.length);
			if (read > 0) {
				builder.append(buffer, 0, read);
			}
		} while (read >= 0);

		reader.close();
		return builder.toString();
	}
	
	/**
	 * Copy a folder contents from a bundle
	 * 
	 * @param folderPath
	 *            Folder path to copy
	 * @param project
	 *            Copy folder into this {@link IProject}
	 * @param destinationPath
	 *            Destination path
	 * @param bundleContainingResources
	 *            Bundle which has resources to copy
	 * @param recurse
	 *            <code>true</code> to copy recursively
	 * @throws IOException
	 * @throws CoreException
	 * @since 0.3
	 */
	public static void copyFolderFromBundle(final String folderPath, final IProject project,
			final String destinationPath, final Bundle bundleContainingResources,
			final boolean recurse)
			throws IOException, CoreException {
		@SuppressWarnings("unchecked")
		// @SuppressWarnings("unchecked") findEntries returns a raw type.
		final Enumeration<URL> files = bundleContainingResources.findEntries(folderPath, "*.*", recurse); //$NON-NLS-1$
		while (files.hasMoreElements()) {
			final URL element = files.nextElement();
			String filename = element.getFile().replace(folderPath, ""); //$NON-NLS-1$
			if (!filename.startsWith("/")) { //$NON-NLS-1$
				filename = "/" + filename; //$NON-NLS-1$
			}
			copyFileFromBundle(element.getFile(), project, destinationPath + filename, bundleContainingResources);
		}
	}

	public static IFile copyFileFromBundle(final String sourcePath, final IProject project,
			final String destinationPath, final Bundle bundleContainingResources)
			throws IOException, CoreException {
		InputStream source;
		URL url = bundleContainingResources.getResource(sourcePath);
		if (url != null) {
			source = url.openStream();
		} else {
			url = bundleContainingResources.getEntry(sourcePath);
			if (url == null) {
				throw new IOException(sourcePath + " not found."); //$NON-NLS-1$
			}
			source = url.openStream();
		}
		IFile javaFile = project.getFile(destinationPath);
		if (javaFile.exists()) {
			try {
				javaFile.delete(true, new NullProgressMonitor());
			} catch (CoreException e) {
				// problem deleting the file : try to close the project before deleting
				if (project.isOpen()) {
					try {
						project.close(new NullProgressMonitor());
						javaFile.delete(true, new NullProgressMonitor());
					} finally {
						project.open(new NullProgressMonitor());
					}
				}
			}
		}
		if (!javaFile.getParent().exists()) {
			FolderUtils.createFolder((IFolder) javaFile.getParent());
		}
		javaFile.create(source, true, new NullProgressMonitor());
		return javaFile;
	}

	/**
	 * Copies the source file to the target file.
	 *
	 * @return <code>true</code> if successful, <code>false</code> otherwise
	 */
	public static final boolean copyFile(final File source, final File destination) {
		boolean result = false;
		FileInputStream sourceFile = null;
		FileOutputStream destinationFile = null;
		try {
			// File creation
			destination.createNewFile();
			sourceFile = new FileInputStream(source);
			destinationFile = new FileOutputStream(destination);
			// 0.5 MiB buffer for reading
			byte[] buffer = new byte[FileUtils.COPY_BUFFER_SIZE];
			int nbRead;
			while ((nbRead = sourceFile.read(buffer)) != -1) {
				destinationFile.write(buffer, 0, nbRead);
			}

			// Copied
			result = true;
		} catch (java.io.FileNotFoundException f) {
			result = false;
		} catch (java.io.IOException e) {
			result = false;
		} finally {
			try {
				if (sourceFile != null) {
					sourceFile.close();
				}
				if (destinationFile != null) {
					destinationFile.close();
				}
			} catch (Exception e) {
				result = false;
			}
		}
		return result;
	}
}
