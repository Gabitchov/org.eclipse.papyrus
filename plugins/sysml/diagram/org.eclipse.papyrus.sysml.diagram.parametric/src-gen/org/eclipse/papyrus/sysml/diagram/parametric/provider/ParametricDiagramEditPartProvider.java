package org.eclipse.papyrus.sysml.diagram.parametric.provider;

import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.CreateGraphicEditPartOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.IEditPartOperation;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.diagram.parametric.Activator;
import org.eclipse.papyrus.sysml.diagram.parametric.edit.part.ParametricDiagramEditPart;

public class ParametricDiagramEditPartProvider extends AbstractEditPartProvider {

	@Override
	public boolean provides(IOperation operation) {
		if(operation instanceof CreateGraphicEditPartOperation) {
			View view = ((IEditPartOperation)operation).getView();

			// Ensure current diagram is Parametric Diagram
			if(ElementTypes.DIAGRAM_ID.equals(view.getType())) {
				return true;
			}
		}

		return false;
	}

	@Override
	protected Class<?> getDiagramEditPartClass(View view) {
		if(ElementTypes.DIAGRAM_ID.equals(view.getType())) {
			return ParametricDiagramEditPart.class;
		}

		Activator.log.error(new Exception("Could not create EditPart."));
		return null;
	}

}
