package org.eclipse.papyrus.diagram.clazz.view.factories;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.AbstractShapeViewFactory;
import org.eclipse.gmf.runtime.notation.HintedDiagramLinkStyle;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AssociationNodeEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ModelEditPart;
import org.eclipse.papyrus.diagram.clazz.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.clazz.preferences.IPapyrusPreferencesConstant;
import org.eclipse.papyrus.preferences.initializer.NodeViewInitializer;

/**
 * @generated
 */
public class AssociationNodeViewFactory extends AbstractShapeViewFactory {

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
			semanticHint = UMLVisualIDRegistry.getType(AssociationNodeEditPart.VISUAL_ID);
			view.setType(semanticHint);
		}
		super.decorateView(containerView, view, semanticAdapter, semanticHint, index, persisted);
		if (!ModelEditPart.MODEL_ID.equals(UMLVisualIDRegistry.getModelID(containerView))) {
			EAnnotation shortcutAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			shortcutAnnotation.setSource("Shortcut"); //$NON-NLS-1$
			shortcutAnnotation.getDetails().put("modelID", ModelEditPart.MODEL_ID); //$NON-NLS-1$
			view.getEAnnotations().add(shortcutAnnotation);
		}
	}

	/**
	 * @generated
	 */
	@Override
	protected void initializeFromPreferences(View view) {

		IPreferenceStore store = (IPreferenceStore) getPreferencesHint().getPreferenceStore();

		if (store == null) {
			return;
		}

		NodeViewInitializer viewInitializer = new NodeViewInitializer(view, store);
		viewInitializer.initFillColor(IPapyrusPreferencesConstant.ASSOCIATION_2015_PREF_FILL_COLOR);
		viewInitializer.initFont(IPapyrusPreferencesConstant.ASSOCIATION_2015_PREF_FONT);
		viewInitializer.initFontColor(IPapyrusPreferencesConstant.ASSOCIATION_2015_PREF_FONT_COLOR);
		viewInitializer.initLineColor(IPapyrusPreferencesConstant.ASSOCIATION_2015_PREF_LINE_COLOR);

	}

}
