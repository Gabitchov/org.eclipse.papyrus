package org.eclipse.papyrus.uml.diagram.interactionoverview.edit.part;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.CallBehaviorActionEditPart;
import org.eclipse.papyrus.uml.diagram.interactionoverview.figures.InteractionUseFigure;


public class CustomInteractionUseEditPartCN extends CallBehaviorActionEditPart {

	public CustomInteractionUseEditPartCN(final View view) {
		super(view);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected IFigure createNodeShape() {
		return primaryShape = new InteractionUseFigure();
	}

}
