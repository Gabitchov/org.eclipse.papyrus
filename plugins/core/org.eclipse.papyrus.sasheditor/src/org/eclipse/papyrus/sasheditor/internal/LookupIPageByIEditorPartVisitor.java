/**
 * 
 */
package org.eclipse.papyrus.sasheditor.internal;

import org.eclipse.papyrus.sasheditor.editor.IPage;
import org.eclipse.ui.IEditorPart;


/**
 * A visitor used to lookup a PagePart by its IEditorPart.
 * 
 * @author cedric dumoulin
 * 
 */
public class LookupIPageByIEditorPartVisitor extends PartVisitor {

	private IEditorPart editorPart;

	private IPage result;


	public LookupIPageByIEditorPartVisitor(IEditorPart editorPart) {
		this.editorPart = editorPart;
	}

	/**
	 * Get the result of the lookup.
	 * 
	 * @return
	 */
	public IPage result() {
		return result;
	}

	/**
	 * Check if the part is for the specified rawModel.
	 * 
	 * @param part
	 * @return
	 */
	private boolean isModelFor(EditorPart part) {

		if(part.getIEditorPart() == editorPart) {
			result = part;
			return true;
		}
		// stop looking
		return false;
	}

	/**
	 * Check if it is this IEditor
	 */
	@Override
	protected boolean acceptEditorTile(EditorPart part) {
		if(isModelFor(part))
			return false;

		// Continue looking
		return true;
	}

}
