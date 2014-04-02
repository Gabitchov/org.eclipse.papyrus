/*******************************************************************************
 * Copyright (c) 2013 Atos
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Arthur Daussy - initial implementation
 *******************************************************************************/
package org.eclipse.papyrus.team.collaborative.core.utils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;


/**
 * The Class URIUtils.
 */
public class URIUtils {

	/**
	 * Checks if is {@link Resource} {@link URI}.
	 * 
	 * @param uri
	 *        the uri
	 * @param resourceSet
	 *        the resource set
	 * @return true, if is resource uri
	 */
	public static boolean isResourceURI(URI uri, ResourceSet resourceSet) {
		return resourceSet.getResource(uri, false) != null;
	}

	/**
	 * Checks if an {@link URI} is an {@link EObject}.
	 * 
	 * @param uri
	 *        the uri
	 * @param resourceSet
	 *        the resource set
	 * @return true, if is e object
	 */
	public static boolean isEObject(URI uri, ResourceSet resourceSet) {
		return uri.hasFragment() && resourceSet.getEObject(uri, false) != null;
	}


	/**
	 * Gets the satellite resource {@link URI}.
	 * 
	 * @param uri
	 *        the base uri
	 * @param fileExtension
	 *        the file extension
	 * @return the satelite resource
	 */
	public static URI getSateliteResource(URI uri, String fileExtension) {
		return uri.trimFileExtension().appendFileExtension(fileExtension);
	}



	/**
	 * Convert EMF URI to Eclipse file
	 * Copied from org.eclipse.emf.edapt.common.URIUtils
	 * 
	 * @param uri
	 *        the uri
	 * @return the file
	 */
	public static IFile getFile(URI uri) {
		String platformString = uri.toPlatformString(true);
		if(platformString != null) {
			Path path = new Path(platformString);
			return ResourcesPlugin.getWorkspace().getRoot().getFile(path);
		}
		return null;
	}

	/**
	 * Convert EMF URI to Eclipse folder
	 * Copied from org.eclipse.emf.edapt.common.URIUtils
	 * 
	 * @param uri
	 *        the uri
	 * @return the folder
	 */
	public static IFolder getFolder(URI uri) {
		Path path = new Path(uri.toPlatformString(true));
		return ResourcesPlugin.getWorkspace().getRoot().getFolder(path);
	}

	/**
	 * Convert Eclipse resource to EMF URI
	 * Copied from org.eclipse.emf.edapt.common.URIUtils
	 * 
	 * @param file
	 *        the file
	 * @return the uri
	 */
	public static URI getURI(IResource file) {
		return getURI(file.getFullPath());
	}

	/**
	 * Create an EMF URI from an Eclipse path
	 * Copied from org.eclipse.emf.edapt.common.URIUtils
	 * 
	 * @param path
	 *        the path
	 * @return the uri
	 */
	public static URI getURI(IPath path) {
		return URI.createPlatformResourceURI(path.toString(), true);
	}

	/**
	 * Convert a file name to an EMF URI
	 * Copied from org.eclipse.emf.edapt.common.URIUtils
	 * 
	 * @param fileName
	 *        the file name
	 * @return EMF URI
	 */
	public static URI getURI(String fileName) {
		return getURI(new File(fileName));
	}

	/**
	 * Convert a file name to an EMF URI
	 * Copied from org.eclipse.emf.edapt.common.URIUtils
	 * 
	 * @param file
	 *        the file
	 * @return EMF URI
	 */
	public static URI getURI(File file) {
		return URI.createFileURI(file.getAbsolutePath());
	}

	/**
	 * Get Java URL from EMF URI
	 * Copied from org.eclipse.emf.edapt.common.URIUtils
	 * 
	 * @param uri
	 *        EMF URI
	 * @return Java URL
	 */
	public static URL getURL(URI uri) {
		try {
			URL url = new URL(uri.toString());
			return url;
		} catch (MalformedURLException e) {
			return null;
		}
	}

	/**
	 * Get EMF URI from Java URL
	 * Copied from org.eclipse.emf.edapt.common.URIUtils
	 * 
	 * @param url
	 *        Java URL
	 * @return EMF URI
	 */
	public static URI getURI(URL url) {
		return URI.createURI(url.toString());
	}

	/**
	 * Replace extension of a file
	 * Copied from org.eclipse.emf.edapt.common.URIUtils
	 * 
	 * @param file
	 *        File
	 * @param ext
	 *        New extension
	 * @return New file
	 */
	public static IFile replaceExtension(IFile file, String ext) {
		IProject project = file.getProject();
		return project.getFile(file.getProjectRelativePath().removeFileExtension().addFileExtension(ext));
	}

	/**
	 * Replace extension of a EMF URI
	 * Copied from org.eclipse.emf.edapt.common.URIUtils
	 * 
	 * @param uri
	 *        EMF URI
	 * @param ext
	 *        New extension
	 * @return New EMF URI
	 */
	public static URI replaceExtension(URI uri, String ext) {
		return uri.trimFileExtension().appendFileExtension(ext);
	}

	/**
	 * Get the Java file for a URI
	 * Copied from org.eclipse.emf.edapt.common.URIUtils
	 * 
	 * @param uri
	 *        the uri
	 * @return Java file
	 */
	public static File getJavaFile(URI uri) {
		if(uri.isPlatform()) {
			IFile file = getFile(uri);
			IPath location = file.getLocation();
			return location.toFile();
		}
		return new File(uri.toFileString());
	}

	/**
	 * Get the relative path of a {@link URI} w.r.t. another {@link URI}.
	 * Copied from org.eclipse.emf.edapt.common.URIUtils
	 * 
	 * @param uri
	 *        the uri
	 * @param relativeTo
	 *        the relative to
	 * @return the relative path
	 */
	public static URI getRelativePath(URI uri, URI relativeTo) {
		return uri.deresolve(relativeTo, true, true, true);
	}



}
