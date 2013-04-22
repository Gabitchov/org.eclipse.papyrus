package org.eclipse.papyrus.uml.diagram.sequence.locator;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.papyrus.uml.diagram.common.figure.node.IMultilineEditableFigure;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

public class MultilineCellEditorLocator implements CellEditorLocator {

	/**
	 * @generated
	 */
	private IMultilineEditableFigure multilineEditableFigure;

	/**
	 * @generated
	 */
	public MultilineCellEditorLocator(IMultilineEditableFigure figure) {
		this.multilineEditableFigure = figure;
	}

	/**
	 * @generated
	 */
	public IMultilineEditableFigure getMultilineEditableFigure() {
		return multilineEditableFigure;
	}

	/**
	 * @generated
	 */
	public void relocate(CellEditor celleditor) {
		Text text = (Text)celleditor.getControl();
		Rectangle rect = getMultilineEditableFigure().getBounds().getCopy();
		rect.x = getMultilineEditableFigure().getEditionLocation().x;
		rect.y = getMultilineEditableFigure().getEditionLocation().y;
		getMultilineEditableFigure().translateToAbsolute(rect);
		if(getMultilineEditableFigure().getText().length() > 0) {
			rect.setSize(new Dimension(text.computeSize(rect.width, SWT.DEFAULT)));
		}
		if(!rect.equals(new Rectangle(text.getBounds()))) {
			text.setBounds(rect.x, rect.y, rect.width, rect.height);
		}
	}
}
