/*
 * Copyright (c) 2014 CEA and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus (CEA) - Initial API and implementation
 *
 */
package org.eclipse.papyrus.junit.utils.rules;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.ResourceAttributes;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;


/**
 * A self-creating and self-destroying workspace project named according to the current test case.
 */
public class ProjectFixture implements TestRule {

	private IProject project;

	public ProjectFixture() {
		super();
	}

	public final IProject getProject() {
		return project;
	}

	public URI getURI(IPath path) {
		return URI.createPlatformResourceURI(project.getFile(path).getFullPath().toString(), true);
	}

	public URI getURI(String path) {
		return URI.createPlatformResourceURI(project.getFile(new Path(path)).getFullPath().toString(), true);
	}

	public IFile getFile(URI uri) {
		return !uri.isPlatformResource() ? null : project.getWorkspace().getRoot().getFile(new Path(uri.toPlatformString(true)));
	}

	public Statement apply(final Statement base, final Description description) {
		return new Statement() {

			@Override
			public void evaluate() throws Throwable {
				createProject(description.getMethodName());

				try {
					base.evaluate();
				} finally {
					deleteProject();
				}
			}
		};
	}

	protected void createProject(String name) throws CoreException {
		project = ResourcesPlugin.getWorkspace().getRoot().getProject(name);

		if(project.exists()) {
			// Start clean, if we can
			deleteProject();
		}

		if(!project.exists()) {
			project.create(null);
		}

		if(!project.isOpen()) {
			project.open(null);
		}

		project.refreshLocal(IResource.DEPTH_INFINITE, null);
	}

	protected void deleteProject() {
		try {
			project.refreshLocal(IResource.DEPTH_INFINITE, null);

			// Make sure that we can delete everything
			project.accept(new IResourceVisitor() {

				public boolean visit(IResource resource) throws CoreException {
					switch(resource.getType()) {
					case IResource.FILE:
					case IResource.FOLDER:
						ensureWritable(resource);
						break;
					}

					return true;
				}
			});

			project.delete(true, null);
		} catch (CoreException e) {
			e.printStackTrace();
			// leave the project.  We may end up re-using it, who knows?
		}
	}

	protected void ensureWritable(IResource resource) throws CoreException {
		ResourceAttributes attr = resource.getResourceAttributes();
		if(attr.isReadOnly()) {
			attr.setReadOnly(false);
			resource.setResourceAttributes(attr);
		}
	}
}
