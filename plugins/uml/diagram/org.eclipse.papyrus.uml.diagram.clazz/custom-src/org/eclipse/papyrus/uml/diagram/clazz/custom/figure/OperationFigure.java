package org.eclipse.papyrus.uml.diagram.clazz.custom.figure;

public class OperationFigure extends org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel {

	static final org.eclipse.swt.graphics.Font THIS_FONT = new org.eclipse.swt.graphics.Font(org.eclipse.swt.widgets.Display.getCurrent(), "Arial", 10, org.eclipse.swt.SWT.NORMAL);

	public OperationFigure() {
		this.setText("");

		this.setFont(THIS_FONT);
	}
}
