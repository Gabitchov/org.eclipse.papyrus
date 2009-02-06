package org.eclipse.papyrus.profile.ui.dialogs;

import java.util.List;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;


public class FileSelectionFilter extends ViewerFilter {

	/** Authorized file extensions */
	List<String> filetypes;
	
	/**
	 * If newFileTypes is null, any extension is accepted
	 * @param newFiletypes authorized extensions for the file viewer filter
	 */
	public FileSelectionFilter(List<String> newFiletypes) {
		super();
		filetypes = newFiletypes;
	}

	@Override
	public boolean select(Viewer arg0, Object arg1, Object arg2) {

		if ((arg2 instanceof IContainer) || (arg2 instanceof IFile)) {
			
			// Filter files
			if (arg2 instanceof IFile) {
				IFile file = (IFile) arg2;
				String file_ext = file.getFileExtension();

				if ((filetypes != null) && (! filetypes.contains(file_ext))) {
					return false;
				}
			}
			
			// Filter folders
			if (arg2 instanceof IContainer) {
				IContainer container = (IContainer) arg2;
				String name = container.getName();
				
				// Mask hidden folder 
				if (name.startsWith(".")) {
					return false;
				}
			}
			
			return true;
		}
		return false;
	}

}
