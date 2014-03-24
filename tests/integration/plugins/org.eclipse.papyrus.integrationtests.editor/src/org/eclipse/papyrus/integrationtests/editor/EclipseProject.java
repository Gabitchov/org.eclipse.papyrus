/*****************************************************************************
 * Copyright (c) 2014 Cedric Dumoulin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.integrationtests.editor;

import java.net.URL;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;


/**
 * This class allows to create or load an Eclipse Project.
 * This is the projects found in the project explorer.
 * This class is mainly used in tests.
 * 
 * @author cedric dumoulin
 *
 */
public class EclipseProject {

	/**
	 * The underlying Eclipse project.
	 * 
	 */
	protected IProject project;
	
	protected IProgressMonitor monitor = new NullProgressMonitor();
	
	/**
	 * Constructor.
	 * Create or load the specified project.
	 * @throws ExecutionException 
	 */
	public EclipseProject( String projectName ) throws ExecutionException {
		// Create the project
		initProject(projectName);
	}

	/**
	 * Create or load the project.
	 * 
	 * @param projectName
	 * @throws ExecutionException 
	 */
	protected void initProject(String projectName ) throws ExecutionException {
		project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
		
		if( project == null) {
			throw new ExecutionException("Can't get project '" + projectName + "' from workspace.");
		}
		
		if(project != null && !project.exists()) {
//			IProgressMonitor monitor = new NullProgressMonitor();
			try {
				project.create(monitor);
			} catch (CoreException e) {
				throw new ExecutionException("Can't create project '" + projectName + "'.", e);
			}
		}
		
		if(!project.isOpen()) {
			try {
				project.open(null);
			} catch (CoreException e) {
				throw new ExecutionException("Can't open project '" + projectName + "'.", e);
			}
		}



	}

	
	/**
	 * @return the project
	 */
	public IProject getProject() {
		return project;
	}
	
	/**
	 * 
	 * @param fromBundle
	 * @param fromResourceName
	 * @param toResourceName
	 * @return
	 * @throws ExecutionException
	 */
	public IFile copyResource( String fromBundle, String fromResourceName, String toResourceName) throws ExecutionException {
		
		try {
			Path toURL = new Path(toResourceName);
			System.out.println(toURL);
			
			IFile file = project.getFile(toResourceName);
			// link all the models resources
			if(!file.exists()) {
				// Create intermediate folders
				ensureFolders(file);

				URL url = FileLocator.find(Platform.getBundle(fromBundle), new Path(fromResourceName), null);
				URL newFile = FileLocator.resolve(url);

				// encode the URI for spaces in the path
				// And then create a link to the file
				file.createLink(new URL(newFile.toString().replaceAll(" ", "%20")).toURI(), IResource.REPLACE, monitor);
			}	
			return file;
		} catch (Exception e) {
			throw new ExecutionException("Can't copy resource '" + toResourceName + "'.", e);
		} 
	}
	
	/**
	 * Copy the specified resource from the specified bundle to this project.
	 * Use the same path in src and target.
	 * 
	 * @param fromBundle
	 * @param fromResourceName
	 * @return
	 * @throws ExecutionException
	 */
	public IFile copyResource( String fromBundle, String fromResourceName) throws ExecutionException {

		return copyResource(fromBundle, fromResourceName, fromResourceName);
	}
	
	/**
	 * 
	 * @param fromBundle
	 * @param fromResourceNames
	 * @throws ExecutionException
	 */
	public void copyResources(String fromBundle, String ...fromResourceNames) throws ExecutionException {
		
		for(String fromResourceName : fromResourceNames) {
			copyResource(fromBundle, fromResourceName);
		}
	}
	
	/**
	 * Ensure that the intermediates folders exist in the project.
	 * 
	 * @param project
	 * @param name
	 * @throws CoreException
	 */
	protected void ensureFolders(IFile file) throws CoreException {
		
		IPath path = file.getProjectRelativePath();
		IPath folderPath = path.removeLastSegments(1);
		
		String[] segments = folderPath.segments();
		
		for( int i = segments.length-1; i>=0; i--) {
			IPath curFolderPath = folderPath.removeLastSegments(i);
			createFolder(curFolderPath);
		}
		

	}

	/**
	 * 
	 * @param folderPath
	 * @throws CoreException
	 */
	private void createFolder(IPath folderPath) throws CoreException {
		IFolder parent = project.getFolder(folderPath);
		if(!parent.exists()) {
			parent.create(true, true, monitor);
		}
		assert (parent.exists());	}

	/**
	 * Creates all the folders that are needed to contains the resource.
	 * 
	 * @param modelName
	 * @throws ExecutionException 
	 */
	public void createFolders(String modelName) throws ExecutionException {
		try {
			IFile file = project.getFile(modelName);
			// link all the models resources
			if(!file.exists()) {
				// Create intermediate folders
				ensureFolders(file);
			}
		} catch (CoreException e) {
			throw new ExecutionException("Can't create intermediate folders for '" + modelName + ". ", e);
		}
	}

}
