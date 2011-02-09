package org.eclipse.papyrus.diagram.newdiagram;

import org.eclipse.papyrus.core.adaptor.gmf.GmfEditorFactory;
import org.eclipse.papyrus.diagram.newdiagram.edit.parts.ModelEditPart;

public class DiagramEditorFactory extends GmfEditorFactory {

	/**
	 * @param diagramClass
	 * @param expectedType
	 */
	public DiagramEditorFactory() {
		super(UmlDiagramForMultiEditor.class, ModelEditPart.MODEL_ID);

	}
	

}
