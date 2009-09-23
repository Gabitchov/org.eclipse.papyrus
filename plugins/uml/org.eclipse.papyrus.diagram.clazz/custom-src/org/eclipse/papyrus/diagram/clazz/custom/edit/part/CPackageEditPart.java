package org.eclipse.papyrus.diagram.clazz.custom.edit.part;

import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PackageEditPart;
import org.eclipse.papyrus.diagram.common.figure.node.PackageNodePlateFigure;

public class CPackageEditPart extends PackageEditPart {

	public CPackageEditPart(View view) {
		super(view);
	}

	/**
	 * {@inheritDoc}
	 */
	protected NodeFigure createNodePlate() {

		DefaultSizeNodeFigure result = new PackageNodePlateFigure(200, 100);
		return result;
	}
}
