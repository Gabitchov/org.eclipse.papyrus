package org.eclipse.papyrus.diagram.clazz.custom.edit.part;

import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.edit.parts.Dependency2EditPart;
import org.eclipse.papyrus.diagram.common.figure.node.AssociationNodeFigure;

public class CDependencyNodeEditPart extends Dependency2EditPart {

	public CDependencyNodeEditPart(View view) {
		super(view);
	}

	/**
	 * 
	 * @return
	 */
	protected NodeFigure createNodePlate() {

		DefaultSizeNodeFigure result = new AssociationNodeFigure(10, 10);

		return result;
	}
}
