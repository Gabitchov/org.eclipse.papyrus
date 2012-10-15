/**
 * 
 */
package org.eclipse.papyrus.infra.core.resource.sasheditor;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.infra.core.resource.IModel;
import org.eclipse.papyrus.infra.core.resource.ModelSet;

/**
 * Set of utility methods linked to Di resource.
 * 
 * @author cedric dumoulin
 * 
 */
public class DiModelUtils {

	/**
	 * Returns the related di file. Warning : this method is here for historical
	 * reasons. It should be removed asap.
	 * 
	 * @param file
	 *        A file (di, model or notation).
	 * @return The associated DI file.
	 * @deprecated No replacement.
	 */
	@Deprecated
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

	/**
	 * Returns the DI Resource associated to the model set. May be null.
	 * 
	 * @param modelSet
	 * @return
	 */
	public static Resource getDiResource(ModelSet modelSet) {
		IModel diModel = modelSet.getModel(DiModel.MODEL_ID);
		if(diModel instanceof SashModel) {
			return ((SashModel)diModel).getResource();
		}
		return null;
	}

}
