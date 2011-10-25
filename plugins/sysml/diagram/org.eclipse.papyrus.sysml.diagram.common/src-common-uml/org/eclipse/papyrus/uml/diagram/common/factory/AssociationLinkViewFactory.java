/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.factory;

import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.EObjectValueStyle;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.gmf.diagram.common.factory.ConnectorViewFactory;
import org.eclipse.papyrus.uml.diagram.common.utils.AssociationViewUtils;
import org.eclipse.papyrus.uml.diagram.common.utils.UMLGraphicalTypes;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Property;

/**
 * View factory for Association.
 */
public class AssociationLinkViewFactory extends ConnectorViewFactory {

	/**
	 * <pre>
	 * {@inheritDoc}
	 * 
	 * Add two EObjectValueStyle in order to store the Properties that are associated with 
	 * the Graphical ends.
	 * </pre>
	 */
	@Override
	protected List createStyles(View view) {

		EObjectValueStyle sourceStyle = NotationFactory.eINSTANCE.createEObjectValueStyle();
		sourceStyle.setName(AssociationViewUtils.SEMANTIC_SOURCE_END);

		EObjectValueStyle targetStyle = NotationFactory.eINSTANCE.createEObjectValueStyle();
		targetStyle.setName(AssociationViewUtils.SEMANTIC_TARGET_END);

		view.getStyles().add(sourceStyle);
		view.getStyles().add(targetStyle);

		return super.createStyles(view);
	}

	/**
	 * <pre>
	 * {@inheritDoc}
	 * 
	 * Store {@link Association} semantic ends (Property) in dedicated styles.
	 * </pre>
	 */
	@Override
	public View createView(IAdaptable semanticAdapter, View containerView, String semanticHint, int index, boolean persisted, PreferencesHint preferencesHint) {
		Edge view = (Edge)super.createView(semanticAdapter, containerView, semanticHint, index, persisted, preferencesHint);

		if((view != null) && (view.getElement() != null) && (view.getElement() instanceof Association)) {
			Association association = (Association)view.getElement();

			assert (association.getMemberEnds().size() == 2);

			Property propertySource = association.getMemberEnds().get(0);
			Property propertyTarget = association.getMemberEnds().get(1);

			AssociationViewUtils.setSourceSemanticEnd(view, propertySource);
			AssociationViewUtils.setTargetSemanticEnd(view, propertyTarget);
		}

		return view;
	}

	/**
	 * Creates Association view and add Label nodes
	 */
	@Override
	protected void decorateView(View containerView, View view, IAdaptable element, String semanticHint, int index, boolean persisted) {

		getViewService().createNode(element, view, UMLGraphicalTypes.LINKLABEL_UML_APPLIEDSTEREOTYPE_ID, ViewUtil.APPEND, persisted, getPreferencesHint());
		getViewService().createNode(element, view, UMLGraphicalTypes.LINKLABEL_UML_NAMEDELEMENT_NAME_ID, ViewUtil.APPEND, persisted, getPreferencesHint());
		getViewService().createNode(element, view, UMLGraphicalTypes.LINKLABEL_UML_ASSOCIATION_SOURCE_ROLE_ID, ViewUtil.APPEND, persisted, getPreferencesHint());
		getViewService().createNode(element, view, UMLGraphicalTypes.LINKLABEL_UML_ASSOCIATION_SOURCE_MULTIPLICITY_ID, ViewUtil.APPEND, persisted, getPreferencesHint());
		getViewService().createNode(element, view, UMLGraphicalTypes.LINKLABEL_UML_ASSOCIATION_TARGET_ROLE_ID, ViewUtil.APPEND, persisted, getPreferencesHint());
		getViewService().createNode(element, view, UMLGraphicalTypes.LINKLABEL_UML_ASSOCIATION_TARGET_MULTIPLICITY_ID, ViewUtil.APPEND, persisted, getPreferencesHint());

		super.decorateView(containerView, view, element, semanticHint, index, persisted);
	}
}
