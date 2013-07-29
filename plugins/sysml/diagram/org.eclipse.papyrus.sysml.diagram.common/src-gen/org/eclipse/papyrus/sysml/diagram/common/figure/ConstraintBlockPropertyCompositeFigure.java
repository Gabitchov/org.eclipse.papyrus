package org.eclipse.papyrus.sysml.diagram.common.figure; 

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.text.FlowPage;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.papyrus.uml.diagram.common.figure.node.PapyrusRoundedNodeFigure;

public class ConstraintBlockPropertyCompositeFigure extends PapyrusRoundedNodeFigure {

	protected WrappingLabel constraintLabel;

	/** main flow page */
	protected FlowPage page;

	public ConstraintBlockPropertyCompositeFigure() {
		super();
		corner = 50;
		
		nameLabel = new WrappingLabel();
		nameLabel.setOpaque(false);
		nameLabel.setAlignment(PositionConstants.MIDDLE);
		add(nameLabel);


		constraintLabel = new WrappingLabel();
		constraintLabel.setAlignment(PositionConstants.RIGHT);
		add(constraintLabel);
	}
	
	/**
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusNodeNamedElementFigure#getNameLabel()
	 * 
	 * @return
	 */
	public WrappingLabel getNameLabel() {
		return nameLabel;
	}
	
	/**
	 * 
	 * @return the textflow of the constraint that contain the string of the
	 *         specification
	 */
	public WrappingLabel getConstraintLabel() {
		return constraintLabel;
	}

}
