/**
 * 
 */
package org.eclipse.papyrus.sasheditor.internal;

import org.eclipse.papyrus.sasheditor.editor.IEditorPage;
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
	 * The public visitor.
	 */
	private IPageVisitor pageVisitor;

	/**
	 * @param pageVisitor
	 */
	public PageVisitorWrapper(IPageVisitor pageVisitor) {
		super();
		this.pageVisitor = pageVisitor;
	}

	/**
	 * We visit a Component part
	 */
	@Override
	public boolean acceptEditorTile(ComponentPart part) {
		pageVisitor.accept(part);
		return true;
	}

	/**
	 * We visit an {@link EditorPart}.
	 */
	@Override
	public boolean acceptEditorTile(EditorPart part) {
		pageVisitor.accept((IEditorPage)part);
		return true;
	}
}
