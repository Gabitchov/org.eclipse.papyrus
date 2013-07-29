package org.eclipse.papyrus.sysml.diagram.parametric.provider;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.core.providers.AbstractViewProvider;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateDiagramViewOperation;
import org.eclipse.papyrus.sysml.diagram.parametric.Activator;
import org.eclipse.papyrus.sysml.diagram.parametric.factory.ParametricDiagramViewFactory;

public class ParametricDiagramViewProvider extends AbstractViewProvider {

		@Override
		protected boolean provides(CreateDiagramViewOperation operation) {
	
			if(ElementTypes.DIAGRAM_ID.equals(operation.getSemanticHint())) {
				return true;
			}
	
			return false;
		}
	
		@Override
		protected Class<?> getDiagramViewClass(IAdaptable semanticAdapter, String diagramKind) {
			if(ElementTypes.DIAGRAM_ID.equals(diagramKind)) {
				return ParametricDiagramViewFactory.class;
			}
	
			Activator.log.error(new Exception("Could not create View."));
			return null;
		}
}

