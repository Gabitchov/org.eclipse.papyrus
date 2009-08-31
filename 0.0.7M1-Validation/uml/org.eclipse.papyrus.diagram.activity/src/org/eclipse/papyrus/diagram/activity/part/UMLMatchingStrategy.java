package org.eclipse.papyrus.diagram.activity.part;

import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.diagram.common.part.CachedResourcesDiagramEditor;
import org.eclipse.papyrus.diagram.common.part.CachedResourcesEditorInput;
import org.eclipse.papyrus.diagram.common.util.MDTUtil;
import org.eclipse.papyrus.diagram.common.util.URIUtil;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorMatchingStrategy;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.PartInitException;

/**
 * @generated
 */
public class UMLMatchingStrategy implements IEditorMatchingStrategy {

	/**
	 * @generated
	 */
	public boolean matches(IEditorReference editorRef, IEditorInput newInput) {
		IEditorInput oldInput;
		try {
			oldInput = editorRef.getEditorInput();
		} catch (PartInitException e) {
			return false;
		}

		boolean openInNewEditor = false;

		CachedResourcesEditorInput newCachedEditorInput = null;
		if (newInput instanceof CachedResourcesEditorInput) {
			newCachedEditorInput = (CachedResourcesEditorInput) newInput;
			openInNewEditor = newCachedEditorInput.isOpenInNewEditor();
		}

		if (openInNewEditor) {
			// we want to open in a new editor, alas if the IEditorInput is
			// exactly the same (the same resource AND diagram) we can reuse
			// this editor
			if (CachedResourcesEditorInput.checkSameEditorInputWithFragment(
					oldInput, newCachedEditorInput)) {
				return true;
			}
			return false;
		}

		// get real URIs for both the old input ant the new input
		CachedResourcesDiagramEditor editor = MDTUtil
				.getCachedResourcesDiagramEditorFromEditorRef(editorRef);
		String editorID = editor != null ? editor.getEditorID() : null;
		URI oldUri = URIUtil.getUri(oldInput, editorID);
		URI newUri = URIUtil.getUri(newInput, editorID);

		if (oldUri != null && newUri != null) {
			return oldUri.equals(newUri);
		}

		return false;

	}

}
