package org.eclipse.papyrus.diagram.statemachine.custom.edit.part;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.IBorderItemLocator;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.statemachine.custom.helpers.Zone;
import org.eclipse.papyrus.diagram.statemachine.custom.locator.CustomLabelInRegionCompartmentLocator;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.PseudoStateNodeLabelEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateNodeEditPart;

public class CStateNodeEditPart extends StateNodeEditPart {

	public CStateNodeEditPart(View view) {
		super(view);
	}

	@Override
	protected void addBorderItem(IFigure borderItemContainer,
			IBorderItemEditPart borderItemEditPart) {
		if (borderItemEditPart instanceof PseudoStateNodeLabelEditPart) {
			IBorderItemLocator locator = new CustomLabelInRegionCompartmentLocator(
					getMainFigure(),Zone.getBounds((View)(this.getParent()).getParent().getModel()));
			borderItemContainer.add(borderItemEditPart.getFigure(), locator);
		} else {
			super.addBorderItem(borderItemContainer, borderItemEditPart);
		}
	}
}
