package org.eclipse.papyrus.diagram.clazz.view.factories;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.AbstractShapeViewFactory;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.HintedDiagramLinkStyle;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AppliedStereotypeChildNodeDataTypeEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.DataTypeAttributeCompartment2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.DataTypeEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.DataTypeName4EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.DataTypeNameEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.DataTypeOperationCompartment2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.DataTypeQualifiedName2EditPart;
import org.eclipse.papyrus.diagram.clazz.part.UMLVisualIDRegistry;

/**
 * @generated
 */
public class DataTypeViewFactoryCN extends AbstractShapeViewFactory {

	/**
	 * @generated
	 */
	protected List createStyles(View view) {
		List styles = new ArrayList();
		styles.add(NotationFactory.eINSTANCE.createShapeStyle());
		{
			HintedDiagramLinkStyle diagramFacet = NotationFactory.eINSTANCE.createHintedDiagramLinkStyle();
			styles.add(diagramFacet);
		}
		return styles;
	}

	/**
	 * @generated
	 */
	protected void decorateView(View containerView, View view, IAdaptable semanticAdapter, String semanticHint, int index, boolean persisted) {
		if (semanticHint == null) {
			semanticHint = UMLVisualIDRegistry.getType(DataTypeEditPartCN.VISUAL_ID);
			view.setType(semanticHint);
		}
		super.decorateView(containerView, view, semanticAdapter, semanticHint, index, persisted);
		IAdaptable eObjectAdapter = null;
		EObject eObject = (EObject) semanticAdapter.getAdapter(EObject.class);
		if (eObject != null) {
			eObjectAdapter = new EObjectAdapter(eObject);
		}
		getViewService().createNode(eObjectAdapter, view, UMLVisualIDRegistry.getType(DataTypeNameEditPartCN.VISUAL_ID), ViewUtil.APPEND, true, getPreferencesHint());
		getViewService().createNode(eObjectAdapter, view, UMLVisualIDRegistry.getType(DataTypeAttributeCompartment2EditPart.VISUAL_ID), ViewUtil.APPEND, true, getPreferencesHint());
		getViewService().createNode(eObjectAdapter, view, UMLVisualIDRegistry.getType(DataTypeOperationCompartment2EditPart.VISUAL_ID), ViewUtil.APPEND, true, getPreferencesHint());
	}

}
