package org.eclipse.papyrus.uml.diagram.sequence.locator;

import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

public class LabelCellEditorLocator implements CellEditorLocator {

	/**
	 * @generated
	 */
	private Label label;

	/**
	 * @generated
	 */
	public LabelCellEditorLocator(Label label) {
		this.label = label;
	}

	/**
	 * @generated
	 */
	public Label getLabel() {
		return label;
	}

	/**
	 * @generated
	 */
	public void relocate(CellEditor celleditor) {
		Text text = (Text)celleditor.getControl();
		Rectangle rect = getLabel().getTextBounds().getCopy();
		getLabel().translateToAbsolute(rect);
		if(!text.getFont().isDisposed()) {
			int avr = FigureUtilities.getFontMetrics(text.getFont()).getAverageCharWidth();
			rect.setSize(new Dimension(text.computeSize(SWT.DEFAULT, SWT.DEFAULT)).expand(avr * 2, 0));
		}
		if(!rect.equals(new Rectangle(text.getBounds()))) {
			text.setBounds(rect.x, rect.y, rect.width, rect.height);
		}
	}
}
