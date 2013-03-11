/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.cdo.core.tests;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

/**
 * This is the TestProject type. Enjoy.
 */
public class TestProject
		extends TestWatcher {

	private IProject project;

	public TestProject(String name) {
		super();

		this.project = ResourcesPlugin.getWorkspace().getRoot()
			.getProject(name);
	}

	public IProject getProject() {
		return project;
	}

	public IFile getFile(String path) {
		IFile result = getProject().getFile(new Path(path));

		assertThat(result, notNullValue());
		assertThat(result.exists(), is(true));

		return result;
	}

	public URI getResourceURI(String path) {
		return URI.createPlatformResourceURI(getFile(path).getFullPath()
			.toString(), true);
	}

	@Override
	protected void starting(Description description) {
		try {
			// ensure that the project doesn't exist
			if (project.exists()) {
				project.delete(true, null);
			}

			// create the project
			project.create(null);
			project.open(null);

			// fill it
			unzip();
		} catch (Exception e) {
			e.printStackTrace();
			fail("Failed to create test project: " + e.getLocalizedMessage());
		}
	}

	@Override
	protected void finished(Description description) {
		try {
			project.delete(true, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void unzip()
			throws Exception {

		URL zipResource = Platform.getBundle(
			"org.eclipse.papyrus.cdo.core.tests").getEntry(
			String.format("resources/projects/%s.zip", project.getName()));
		ZipInputStream zip = new ZipInputStream(zipResource.openStream());

		for (ZipEntry entry = zip.getNextEntry(); entry != null; entry = zip
			.getNextEntry()) {
			if (entry.isDirectory()) {
				createDirectory(project, entry.getName());
			} else {
				createFile(project, entry.getName(),
					new ZipEntryInputStreamWrapper(zip));
			}
		}

		zip.close();
	}

	private void createDirectory(IProject project, String name)
			throws Exception {

		createDirectory(project, new Path(name));
	}

	private IFolder createDirectory(IProject project, IPath path)
			throws Exception {
		IContainer container = project;

		for (String next : path.segments()) {
			IFolder folder = container.getFolder(new Path(next));
			if (!folder.exists()) {
				folder.create(true, true, null);
			}
			container = folder;
		}

		return (IFolder) container;
	}

	private void createFile(IProject project, String name, InputStream contents)
			throws Exception {

		IPath path = new Path(name);

		IContainer container = project;
		if (path.segmentCount() > 1) {
			container = createDirectory(project, path.removeLastSegments(1));
		}

		IFile file = container.getFile(new Path(path.lastSegment()));
		if (!file.exists()) {
			file.create(contents, true, null);
		} else {
			file.setContents(contents, true, false, null);
		}
	}

	private static class ZipEntryInputStreamWrapper
			extends FilterInputStream {

		private ZipInputStream zip;

		public ZipEntryInputStreamWrapper(ZipInputStream input) {
			super(input);

			this.zip = input;
		}

		@Override
		public void close()
				throws IOException {

			zip.closeEntry();
		}
	}
}
