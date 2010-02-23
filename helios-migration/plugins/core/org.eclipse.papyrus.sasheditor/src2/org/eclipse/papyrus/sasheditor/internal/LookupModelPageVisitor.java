/**
 * 
 */
package org.eclipse.papyrus.sasheditor.internal;

import org.eclipse.papyrus.sasheditor.editor.IPage;


/**
 * A visitor used to lookup a PagePart from its raw model.
 * 
 * @author cedric dumoulin
 * 
 */
public class LookupModelPageVisitor extends PartVisitor {

	private Object rawModel;

	private IPage result;


	public LookupModelPageVisitor(Object rawModel) {
		this.rawModel = rawModel;
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
	private boolean isModelFor(PagePart part) {

		if(part.getRawModel() == rawModel) {
			result = part;
			return true;
		}
		return false;
	}

	/**
	 * Check if it is this Component
	 */
	@Override
	protected boolean acceptEditorTile(ComponentPart part) {
		if(isModelFor(part))
			return false;

		// Continue looking
		return true;
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
