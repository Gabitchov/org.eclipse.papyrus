package org.eclipse.papyrus.sysml.diagram.parametric;

import org.eclipse.papyrus.infra.gmfdiag.common.GmfEditorFactory;
import org.eclipse.papyrus.sysml.diagram.parametric.provider.ElementTypes;

public class ParametricDiagramEditorFactory extends GmfEditorFactory {

	public ParametricDiagramEditorFactory() {
		super(ParametricDiagramForMultiEditor.class, ElementTypes.DIAGRAM_ID);
	}

}
