package org.eclipse.papyrus.diagram.clazz.custom.edit.part;

import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderItemEditPart;
import org.eclipse.gmf.runtime.notation.View;

public abstract class AbstractRedefinableTemplateSignatureEditPart extends AbstractBorderItemEditPart {

	public AbstractRedefinableTemplateSignatureEditPart(View view) {
		super(view);
	}

	/**
	 * {@inheritDoc}
	 */
	protected void refreshBounds() {
		super.refreshBounds();
		// ensure refreshing figures
		getFigure().getParent().getLayoutManager().layout(getFigure().getParent());
	}
}
