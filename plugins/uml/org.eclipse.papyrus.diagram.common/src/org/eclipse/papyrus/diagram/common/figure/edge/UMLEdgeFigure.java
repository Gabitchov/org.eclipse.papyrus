package org.eclipse.papyrus.diagram.common.figure.edge;

import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.swt.SWT;

/**
 * An UML edge is an edge that owns a label to display the 
 *
 */
public class UMLEdgeFigure  extends PolylineConnectionEx {



	private WrappingLabel appliedStereotypeLabel;

/**
 * get the applied stereotype label
 * @return applied stereotype label
 */
	public WrappingLabel getAppliedStereotypeLabel() {
		return appliedStereotypeLabel;
	}

	public UMLEdgeFigure(){
		super();
		setAntialias(SWT.ON);
		createContents();
	}
	/**
	 * @generated
	 */
	protected void createContents() {

		appliedStereotypeLabel = new WrappingLabel();
		appliedStereotypeLabel.setText("");

		this.add(appliedStereotypeLabel);

	}
}
