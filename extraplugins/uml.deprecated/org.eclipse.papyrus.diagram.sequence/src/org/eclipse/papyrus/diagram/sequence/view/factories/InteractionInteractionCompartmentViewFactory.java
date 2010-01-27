/***************************************************************************
 * Copyright (c) 2007 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Gabriel Merin Cubero (Prodevelop) – Sequence Diagram implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.sequence.view.factories;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.BasicNodeViewFactory;
import org.eclipse.gmf.runtime.notation.DrawerStyle;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.TitleStyle;
import org.eclipse.gmf.runtime.notation.View;

import org.eclipse.papyrus.diagram.sequence.edit.parts.InteractionInteractionCompartmentEditPart;
import org.eclipse.papyrus.diagram.sequence.part.UMLVisualIDRegistry;

/**
 * @generated
 */
public class InteractionInteractionCompartmentViewFactory extends
		BasicNodeViewFactory {

	/**
	 * @generated
	 */
	@Override
	protected List createStyles(View view) {
		List styles = new ArrayList();
		styles.add(NotationFactory.eINSTANCE.createSortingStyle());
		styles.add(NotationFactory.eINSTANCE.createFilteringStyle());
		return styles;
	}

	/**
	 * @generated
	 */
	@Override
	protected void decorateView(View containerView, View view,
			IAdaptable semanticAdapter, String semanticHint, int index,
			boolean persisted) {
		if (semanticHint == null) {
			semanticHint = UMLVisualIDRegistry
					.getType(InteractionInteractionCompartmentEditPart.VISUAL_ID);
			view.setType(semanticHint);
		}
		super.decorateView(containerView, view, semanticAdapter, semanticHint,
				index, persisted);
		setupCompartmentTitle(view);
		setupCompartmentCollapsed(view);
	}

	/**
	 * @generated
	 */
	protected void setupCompartmentTitle(View view) {
		TitleStyle titleStyle = (TitleStyle) view
				.getStyle(NotationPackage.eINSTANCE.getTitleStyle());
		if (titleStyle != null) {
			titleStyle.setShowTitle(true);
		}
	}

	/**
	 * @generated
	 */
	protected void setupCompartmentCollapsed(View view) {
		DrawerStyle drawerStyle = (DrawerStyle) view
				.getStyle(NotationPackage.eINSTANCE.getDrawerStyle());
		if (drawerStyle != null) {
			drawerStyle.setCollapsed(false);
		}
	}
}
