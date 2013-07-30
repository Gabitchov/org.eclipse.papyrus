package org.eclipse.papyrus.sysml.diagram.parametric.figures;

import org.eclipse.draw2d.Label;
import org.eclipse.papyrus.sysml.diagram.common.figure.BlockPropertyCompositeFigure;

public class CustomBlockPropertyCompositeFigure extends
		BlockPropertyCompositeFigure {

	@Override
	protected void initTagLabel(String value) {
		// do nothing: we don't want a two lines element (tag + name)
	}
	
	@Override
	public Label getTaggedLabel() {
		// return a mock Label
		return new Label();
	}
	
	@Override
	public void setNameLabelIcon(boolean displayNameLabelIcon) {
		getNameLabel().setIcon(null);
	}
}
