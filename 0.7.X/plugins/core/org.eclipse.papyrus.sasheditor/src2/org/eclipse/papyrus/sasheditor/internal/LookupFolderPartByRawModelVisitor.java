/**
 * 
 */
package org.eclipse.papyrus.sasheditor.internal;



/**
 * A visitor used to lookup a {@link TabFolderPart} by its raw model.
 * 
 * @author cedric dumoulin
 * 
 */
public class LookupFolderPartByRawModelVisitor extends PartVisitor {

	private Object rawModel;

	private TabFolderPart result;


	public LookupFolderPartByRawModelVisitor(Object rawModel) {
		this.rawModel = rawModel;
	}

	/**
	 * Get the result of the lookup.
	 * 
	 * @return
	 */
	public TabFolderPart result() {
		return result;
	}

	/**
	 * Check if the part is for the specified rawModel.
	 * 
	 * @param part
	 * @return
	 */
	private boolean isModelFor(TabFolderPart part) {

		if(part.getRawModel() == rawModel) {
			result = part;
			return true;
		}
		// stop looking
		return false;
	}

	/**
	 * Check if it is this Component
	 */
	@Override
	protected boolean acceptTabFolderPart(TabFolderPart part) {
		if(isModelFor(part))
			return false;

		// Continue looking
		return true;
	}

}
