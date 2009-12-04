package org.eclipse.papyrus.diagram.statemachine.view.factories;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.AbstractShapeViewFactory;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.RegionEditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.RegionSubverticesEditPart;
import org.eclipse.papyrus.diagram.statemachine.part.UMLVisualIDRegistry;


/**
 * @generated
 */
public class RegionViewFactory extends AbstractShapeViewFactory {

	/**
	 * @generated
	 */
	@Override
	protected List createStyles(View view) {
		List styles = new ArrayList();
		styles.add(NotationFactory.eINSTANCE.createShapeStyle());
		return styles;
	}

	/**
	 * @generated
	 */
	@Override
	protected void decorateView(View containerView, View view,
			IAdaptable semanticAdapter, String semanticHint, int index,
			boolean persisted) {
		if(semanticHint == null) {
			semanticHint = UMLVisualIDRegistry
					.getType(RegionEditPart.VISUAL_ID);
			view.setType(semanticHint);
		}
		super.decorateView(containerView, view, semanticAdapter, semanticHint,
				index, persisted);
		IAdaptable eObjectAdapter = null;
		EObject eObject = (EObject)semanticAdapter.getAdapter(EObject.class);
		if(eObject != null) {
			eObjectAdapter = new EObjectAdapter(eObject);
		}
		getViewService().createNode(
				eObjectAdapter,
				view,
				UMLVisualIDRegistry
				.getType(RegionSubverticesEditPart.VISUAL_ID),
				ViewUtil.APPEND, true, getPreferencesHint());
	}
}
