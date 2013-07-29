package org.eclipse.papyrus.sysml.diagram.parametric.edit.part;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.BlockLabelNameEditPart;

public class CustomBlockLabelNameEditPart extends BlockLabelNameEditPart {

	public CustomBlockLabelNameEditPart(View view) {
		super(view);
	}

	@Override
	protected String getLabelText() {
		String diagramName = getDiagramView().getName();
		return super.getLabelText() + " [" + diagramName + "]";
	}
}
