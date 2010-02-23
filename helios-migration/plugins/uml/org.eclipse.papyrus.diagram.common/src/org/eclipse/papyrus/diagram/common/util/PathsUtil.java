/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte, Generalitat 
 * de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Francisco Javier Cano Muñoz (Prodevelop) – Initial implementation.
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.common.util;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.part.FileEditorInput;

// TODO: Auto-generated Javadoc
/**
 * Several util general methods to work with <URI>s, <IPath>s and <IFile>s.
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 * @author <a href="mailto:gmerin@prodevelop.es">Gabriel Merin Cubero</a>
 * 
 */
public class PathsUtil {

	/**
	 * From absolute file system to absolute workspace.
	 * 
	 * @param filesystemPath
	 *        the filesystem path
	 * 
	 * @return the string
	 */
	public static String fromAbsoluteFileSystemToAbsoluteWorkspace(String filesystemPath) {
		String workspacePath = removeSchemas(filesystemPath);
		workspacePath = removeWorkspace(workspacePath);
		workspacePath = removeProtocols(workspacePath);
		workspacePath = addRoot(workspacePath);
		return URI.decode(workspacePath);
	}

	// @unused
	public static String fromEditorInputToURIString(IEditorInput editorInput) {
		String uri = null;
		if(editorInput instanceof FileEditorInput) {
			uri = ((FileEditorInput)editorInput).getPath().toString();
			uri = MDTUtil.fullFilePathToResourceURI(uri).toString();
		} else if(editorInput instanceof URIEditorInput) {
			uri = ((URIEditorInput)editorInput).getURI().trimFragment().toString();
		}
		if(uri != null) {
			uri = fromAbsoluteFileSystemToAbsoluteWorkspace(uri);
		}
		return uri;
	}

	// The lower-cased schemes that will be used to identify archive URIs.
	/** The Constant archiveSchemes. */
	private static final Set<String> archiveSchemes;

	// Identifies a file-type absolute URI.
	/** The Constant SCHEME_FILE. */
	private static final String SCHEME_FILE = "file";

	/** The Constant SCHEME_JAR. */
	private static final String SCHEME_JAR = "jar";

	/** The Constant SCHEME_ZIP. */
	private static final String SCHEME_ZIP = "zip";

	/** The Constant SCHEME_ARCHIVE. */
	private static final String SCHEME_ARCHIVE = "archive";

	/** The Constant SCHEME_PLATFORM. */
	private static final String SCHEME_PLATFORM = "platform";
	// Static initializer for archiveSchemes.
	static {
		Set<String> set = new HashSet<String>();
		String propertyValue = System.getProperty("org.eclipse.emf.common.util.URI.archiveSchemes");

		if(propertyValue == null) {
			set.add(SCHEME_JAR);
			set.add(SCHEME_ZIP);
			set.add(SCHEME_ARCHIVE);
			set.add(SCHEME_FILE);
			set.add(SCHEME_PLATFORM);
		} else {
			for(StringTokenizer t = new StringTokenizer(propertyValue); t.hasMoreTokens();) {
				set.add(t.nextToken().toLowerCase());
			}
		}

		archiveSchemes = Collections.unmodifiableSet(set);
	}

	/** The Constant PROTOCOLS. */
	private static final String[] PROTOCOLS = new String[]{ "resource", "plugin" };

	/** The Constant SCHEME_SEPARATOR. */
	private static final String SCHEME_SEPARATOR = ":";

	/** The Constant AUTHORITY_SEPARATOR. */
	private static final String AUTHORITY_SEPARATOR = "//";

	/** The Constant replacement. */
	private static final String replacement = "";

	/**
	 * Removes the schemas.
	 * 
	 * @param path
	 *        the path
	 * 
	 * @return the string
	 */
	public static String removeSchemas(String path) {
		if(path == null) {
			return path;
		}
		String newPath = path;
		for(String archiveSchema : archiveSchemes) {
			if(newPath.startsWith(archiveSchema)) {
				newPath = newPath.replaceFirst(archiveSchema, replacement);
			}
		}
		if(newPath.startsWith(SCHEME_SEPARATOR)) {
			newPath = newPath.replaceFirst(SCHEME_SEPARATOR, replacement);
			if(newPath.startsWith(AUTHORITY_SEPARATOR)) {
				newPath = newPath.replaceFirst(AUTHORITY_SEPARATOR, replacement);
			}
		}
		return newPath;
	}

	/**
	 * Removes the workspace.
	 * 
	 * @param path
	 *        the path
	 * 
	 * @return the string
	 */
	public static String removeWorkspace(String path) {
		if(path == null) {
			return path;
		}
		String newPath = path;
		if(newPath.startsWith(MDTUtil.getWorkspaceLocation().toString()) || newPath.startsWith("/" + MDTUtil.getWorkspaceLocation().toString())) {
			newPath = newPath.replaceFirst(MDTUtil.getWorkspaceLocation().toString(), replacement);
		}
		return newPath;
	}

	/**
	 * Removes the protocols.
	 * 
	 * @param path
	 *        the path
	 * 
	 * @return the string
	 */
	public static String removeProtocols(String path) {
		if(path == null) {
			return null;
		}
		for(String protocol : PROTOCOLS) {
			if(path.startsWith(protocol) || path.startsWith("/" + protocol)) {
				path = path.replaceFirst(protocol, replacement);
			}
		}
		return path;
	}

	/**
	 * Adds the root.
	 * 
	 * @param path
	 *        the path
	 * 
	 * @return the string
	 */
	public static String addRoot(String path) {
		if(path == null) {
			return path;
		}
		String newPath = path;
		String rootPath = Path.ROOT.toString();
		while(newPath.startsWith(rootPath)) {
			newPath = newPath.replaceFirst(rootPath, replacement);
		}
		if(newPath.startsWith(Path.ROOT.toString()) == false) {
			newPath = Path.ROOT.toString() + newPath;
		}
		return newPath;
	}

	/**
	 * Gets the relative workspace from editor input. Removes <URI>'s fragments.
	 * 
	 * @param input
	 *        the input
	 * 
	 * @return the relative workspace from editor input
	 */
	public static String getRelativeWorkspaceFromEditorInput(IEditorInput input) {
		if(input == null) {
			return null;
		}
		String uriString = null;
		if(input instanceof FileEditorInput) {
			uriString = ((FileEditorInput)input).getFile().getFullPath().toString();
		}
		if(input instanceof URIEditorInput) {
			uriString = ((URIEditorInput)input).getURI().trimFragment().toString();
		}
		if(uriString != null) {
			uriString = fromAbsoluteFileSystemToAbsoluteWorkspace(uriString);
		}
		return uriString;
	}

	/**
	 * Gets the relative workspace from editor input. Does not remove <URI>'s fragments.
	 * 
	 * @param input
	 *        the input
	 * 
	 * @return the relative workspace from editor input
	 */
	public static String getRelativeWorkspaceFromEditorInputWithFragment(IEditorInput input) {
		if(input == null) {
			return null;
		}
		String uriString = null;
		if(input instanceof FileEditorInput) {
			uriString = ((FileEditorInput)input).getURI().toString();
		}
		if(input instanceof URIEditorInput) {
			uriString = ((URIEditorInput)input).getURI().toString();
		}
		if(uriString != null) {
			uriString = fromAbsoluteFileSystemToAbsoluteWorkspace(uriString);
		}
		return uriString;
	}
}
