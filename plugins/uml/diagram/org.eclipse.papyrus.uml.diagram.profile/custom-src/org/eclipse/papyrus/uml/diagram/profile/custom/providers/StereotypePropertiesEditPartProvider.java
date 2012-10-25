/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.profile.custom.providers;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.CreateGraphicEditPartOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.IEditPartOperation;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.providers.RestrictedAbstractEditPartProvider;
import org.eclipse.papyrus.uml.diagram.common.editparts.AppliedStereotypeConpartmentEditPart;
import org.eclipse.papyrus.uml.diagram.common.editparts.AppliedStereotypeMultilinePropertyEditPart;
import org.eclipse.papyrus.uml.diagram.common.editparts.AppliedStereotypePropertyEditPart;
import org.eclipse.papyrus.uml.diagram.common.editparts.AppliedStereotypesCommentEditPart;
import org.eclipse.papyrus.uml.diagram.common.editparts.AppliedStereotypesCommentLinkEditPart;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.ProfileDiagramEditPart;

/**
 * provides editpart to edit properties of applied stereotypes
 *
 */
public class StereotypePropertiesEditPartProvider extends RestrictedAbstractEditPartProvider {

	/** Map containing node view types supported by this provider */
	protected Map<String, Class<?>> nodeMap = new HashMap<String, Class<?>>();

	/** Map containing edge view types supported by this provider */
	protected Map<String, Class<?>> edgeMap = new HashMap<String, Class<?>>();

	/** Default constructor */
	public StereotypePropertiesEditPartProvider() {
		super();

		diagramType = ProfileDiagramEditPart.MODEL_ID;

		
		nodeMap.put(AppliedStereotypeConpartmentEditPart.ID, AppliedStereotypeConpartmentEditPart.class);
		nodeMap.put(AppliedStereotypePropertyEditPart.ID, AppliedStereotypeMultilinePropertyEditPart.class);
		nodeMap.put(AppliedStereotypesCommentEditPart.ID, AppliedStereotypesCommentEditPart.class);
		edgeMap.put(AppliedStereotypesCommentLinkEditPart.ID, AppliedStereotypesCommentLinkEditPart.class);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean provides(IOperation operation) {
		if(operation instanceof CreateGraphicEditPartOperation) {
			View newView = ((IEditPartOperation)operation).getView();
			if(newView == null) {
				return false;
			}

			String graphicalType = newView.getType();

			if((newView instanceof Node) && (!nodeMap.containsKey(graphicalType))) {
				return false;
			}

			if((newView instanceof Edge) && (!edgeMap.containsKey(graphicalType))) {
				return false;
			}
		}

		return super.provides(operation);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Class<?> getNodeEditPartClass(View view) {
		return nodeMap.get(view.getType());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Class<?> getEdgeEditPartClass(View view) {
		return edgeMap.get(view.getType());
	}
}
