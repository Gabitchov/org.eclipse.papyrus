package org.eclipse.papyrus.example.diagram.simplediagram;

import org.eclipse.papyrus.core.adaptor.gmf.GmfEditorFactory;
import org.eclipse.papyrus.example.diagram.simplediagram.edit.parts.ModelEditPart;

public class DiagramEditorFactory extends GmfEditorFactory {

	/**
	 * @param diagramClass
	 * @param expectedType
	 */
	public DiagramEditorFactory() {
		super(UmlDiagramForMultiEditor.class, ModelEditPart.MODEL_ID);

	}
	

}
