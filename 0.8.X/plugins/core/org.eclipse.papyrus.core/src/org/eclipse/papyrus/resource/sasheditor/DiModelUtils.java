/**
 * 
 */
package org.eclipse.papyrus.resource.sasheditor;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;


/**
 * Set of utility methods linked to Di resource.
 * @author cedric dumoulin
 *
 */
public class DiModelUtils {

	
	/**
	 * Returns the related di file.
	 * Warning : this method is here for historical reasons. It should be removed asap.
	 * @param file
	 *        A file (di, model or notation).
	 * @return The associated DI file.
	 * @deprecated No replacement.
	 */
	public static IFile getRelatedDiFile(IFile file) {
		if(file == null) {
			return null;
		}
		IFile diFile;
		if(DiModel.DI_FILE_EXTENSION.equalsIgnoreCase(file.getFileExtension())) {
			diFile = file;
		} else {
			// Find the correct file
			IPath diPath = file.getFullPath().removeFileExtension().addFileExtension(DiModel.DI_FILE_EXTENSION);
			diFile = file.getParent().getFile(diPath.makeRelativeTo(file.getParent().getFullPath()));
		}
		return diFile;
	}

	
}
