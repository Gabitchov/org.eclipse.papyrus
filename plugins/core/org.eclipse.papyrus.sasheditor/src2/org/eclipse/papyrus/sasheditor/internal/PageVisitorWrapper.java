/**
 * 
 */
package org.eclipse.papyrus.sasheditor.internal;

import org.eclipse.papyrus.sasheditor.editor.IPageVisitor;


/**
 * A wrapper used to let the provided public visitor use the internal visitor to
 * visit {@link ComponentPart} and {@link EditorPart}.
 *  
 * @author Cedric dumoulin
 *
 */
public class PageVisitorWrapper extends PartVisitor {

	/**
	 * @param pageVisitor
	 */
	public PageVisitorWrapper(IPageVisitor pageVisitor) {
		super();
		this.pageVisitor = pageVisitor;
	}

	/**
	 * The public visitor.
	 */
	private IPageVisitor pageVisitor;
	
	/**
	 * We visit a Component part
	 */
	@Override
	public boolean accept(ComponentPart part) {
		pageVisitor.accept(part);
		return true;
	}
	
	/**
	 * We visit an {@link EditorPart}.
	 */
	@Override
	public boolean accept(EditorPart part) {
		pageVisitor.accept(part);
		return true;
	}
}
