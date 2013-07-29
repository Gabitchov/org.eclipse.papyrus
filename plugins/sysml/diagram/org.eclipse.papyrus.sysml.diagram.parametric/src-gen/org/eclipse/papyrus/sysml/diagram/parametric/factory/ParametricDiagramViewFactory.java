package org.eclipse.papyrus.sysml.diagram.parametric.factory;

import org.eclipse.gmf.runtime.diagram.ui.view.factories.DiagramViewFactory;
import org.eclipse.gmf.runtime.notation.MeasurementUnit;

public class ParametricDiagramViewFactory extends DiagramViewFactory {

	// Start of user code Custom view Factory field
	// End of user code

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected MeasurementUnit getMeasurementUnit() {
		return MeasurementUnit.PIXEL_LITERAL;
	}
}
