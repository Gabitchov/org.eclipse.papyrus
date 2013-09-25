package org.eclipse.papyrus.infra.emf.utils;

import java.io.File;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.infra.widgets.Activator;

//TODO
public class EMFFileUtil {

	/*
	 * Returns the path to the IFile (Encoded)
	 * 
	 * @param file
	 * @return
	 */
	public static String getPath(IFile file) {		
		URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
		
		//ToString, toPlatformString
		return uri.toString();
	}

	/*
	 * Returns the IFile (Workspace file) from the given location.
	 * The location may be either absolute (From the FileSystem) or
	 * relative to the workspace root.
	 * 
	 * @param location
	 * @return
	 */
	public static IFile getIFile(String location) {
		URI uri = URI.createURI(location);
		IWorkspaceRoot workspace = ResourcesPlugin.getWorkspace().getRoot();
		
		//Search the file in the workspace
		if (uri.isPlatform()){
			Path workspacePath = new Path(uri.toPlatformString(true));
			return workspace.getFile(workspacePath);
		} else { //Then search it on the disk
			Path absolutePath = new Path(URI.decode(location));
			return workspace.getFileForLocation(absolutePath);
		}
	}

	/*
	 * Returns the Java File from the given location.
	 * The location may be either absolute (From the FileSystem) or
	 * relative to the workspace root.
	 * 
	 * @param location
	 * @return
	 */
	public static File getFile(String location) {
		IFile iFile = getIFile(location);
		if(iFile == null || !iFile.exists()) {
			return new File(location);
		}

		return new File(iFile.getLocationURI());
	}

	/*
	 * Returns the Java File from the given location.
	 * The location is relative to the workspace root.
	 * 
	 * @param location
	 * @return
	 */
	public static File getWorkspaceFile(String location) {
		IWorkspaceRoot workspace = ResourcesPlugin.getWorkspace().getRoot();
		IPath path = new Path(location);
		IFile currentFile = null;
		try {
			currentFile = workspace.getFile(path);
		} catch (IllegalArgumentException ex) {
			Activator.log.error(ex);
			return null;
		}

		return currentFile.getLocation().toFile();
	}
}
