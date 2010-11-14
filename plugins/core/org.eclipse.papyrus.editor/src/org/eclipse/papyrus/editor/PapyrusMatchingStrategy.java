package org.eclipse.papyrus.editor;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorMatchingStrategy;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PartInitException;


public class PapyrusMatchingStrategy implements IEditorMatchingStrategy {

	/**
	 * Check whether an existing editor matches a new editor input, i.e. if the existing editor shouldthis function is only called for Papyrus editors
	 * get focus instead of opening a second one. Whereas the passed editor reference always refers to a Papyrus
	 * editor, the passed editor input may not be related to UML, it might for instance be a Java or text
	 * file. Therefore, the code verifies that the new editor input is either a notation, uml or di file
	 * @see org.eclipse.ui.IEditorMatchingStrategy#matches(org.eclipse.ui.IEditorReference, org.eclipse.ui.IEditorInput)
	 *
	 * @param editorRef a reference to an opened Papyrus editor
	 * @param newEInput the new editor input
	 * @return true, if the new input matches the existing editor reference.
	 */
	public boolean matches(IEditorReference editorRef, IEditorInput newEInput) {
		IFile newFile = ((IFileEditorInput) newEInput).getFile();
		String extension = newFile.getFileExtension();
		if (extension.equals("uml") || extension.equals("di") || extension.equals("notation")) {
			try {
				IEditorInput exiEInput = editorRef.getEditorInput();
				if ((exiEInput instanceof IFileEditorInput) && (newEInput instanceof IFileEditorInput)) {
					IFile exiFile = ((IFileEditorInput)exiEInput).getFile();
					IPath exiFilenameWOE = exiFile.getFullPath().removeFileExtension();
					IPath newFilenameWOE = newFile.getFullPath().removeFileExtension();

					if (exiFilenameWOE.equals (newFilenameWOE)) {
						return true;
					}
				}
			}
			catch (PartInitException e) {		
			}
		}
		return false;
	}
}
