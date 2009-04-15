/*****************************************************************************
 * Copyright (c) 2008 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.usecase.view.factories;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.AbstractShapeViewFactory;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ConstraintEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ConstraintNameEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.PackageEditPart;
import org.eclipse.papyrus.diagram.usecase.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.usecase.preferences.IPapyrusPreferencesConstant;
import org.eclipse.papyrus.preferences.initializer.NodeViewInitializer;

/**
 * @generated
 */
public class ConstraintViewFactory extends AbstractShapeViewFactory {

	/**
	 * @generated
	 */
	protected List createStyles(View view) {
		List styles = new ArrayList();
		styles.add(NotationFactory.eINSTANCE.createShapeStyle());
		return styles;
	}

	/**
	 * @generated
	 */
	protected void decorateView(View containerView, View view,
			IAdaptable semanticAdapter, String semanticHint, int index,
			boolean persisted) {
		if (semanticHint == null) {
			semanticHint = UMLVisualIDRegistry
					.getType(ConstraintEditPart.VISUAL_ID);
			view.setType(semanticHint);
		}
		super.decorateView(containerView, view, semanticAdapter, semanticHint,
				index, persisted);
		if (!PackageEditPart.MODEL_ID.equals(UMLVisualIDRegistry
				.getModelID(containerView))) {
			EAnnotation shortcutAnnotation = EcoreFactory.eINSTANCE
					.createEAnnotation();
			shortcutAnnotation.setSource("Shortcut"); //$NON-NLS-1$
			shortcutAnnotation.getDetails().put(
					"modelID", PackageEditPart.MODEL_ID); //$NON-NLS-1$
			view.getEAnnotations().add(shortcutAnnotation);
		}
		IAdaptable eObjectAdapter = null;
		EObject eObject = (EObject) semanticAdapter.getAdapter(EObject.class);
		if (eObject != null) {
			eObjectAdapter = new EObjectAdapter(eObject);
		}
		getViewService().createNode(eObjectAdapter, view,
				UMLVisualIDRegistry.getType(ConstraintNameEditPart.VISUAL_ID),
				ViewUtil.APPEND, true, getPreferencesHint());
	}

	/**
	 * @generated
	 */
	@Override
	protected void initializeFromPreferences(View view) {

		IPreferenceStore store = (IPreferenceStore) getPreferencesHint()
				.getPreferenceStore();

		if (store == null) {
			return;
		}

		NodeViewInitializer viewInitializer = new NodeViewInitializer(view,
				store);
		viewInitializer
				.initFillColor(IPapyrusPreferencesConstant.CONSTRAINT_2008_PREF_FILL_COLOR);
		viewInitializer
				.initFont(IPapyrusPreferencesConstant.CONSTRAINT_2008_PREF_FONT);
		viewInitializer
				.initFontColor(IPapyrusPreferencesConstant.CONSTRAINT_2008_PREF_FONT_COLOR);
		viewInitializer
				.initLineColor(IPapyrusPreferencesConstant.CONSTRAINT_2008_PREF_LINE_COLOR);

	}
}
