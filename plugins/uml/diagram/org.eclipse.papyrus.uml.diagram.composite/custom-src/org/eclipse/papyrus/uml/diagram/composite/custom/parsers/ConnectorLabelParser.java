/*****************************************************************************
 * Copyright (c) 2009-2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.composite.custom.parsers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Semantic Parser for {@link Connector} label
 */
public class ConnectorLabelParser extends NamedElementLabelParser {

	/** The String format for displaying a {@link Connector} label with its type (Association) */
	protected static final String TYPE_FORMAT = "%s: %s";

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getPrintString(IAdaptable element, int flags) {
		String result = "";
		EObject eObject = EMFHelper.getEObject(element);

		if((eObject != null) && (eObject instanceof Connector)) {

			Connector connector = (Connector)eObject;

			// manage name
			if(connector.isSetName()) {
				result = connector.getName();
			}

			// manage type
			String type = "";
			if((connector.getType() != null) && (connector.getType().isSetName())) {
				type = connector.getType().getName();
				result = String.format(TYPE_FORMAT, result, type);
			}

		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isAffectingEvent(Object event, int flags) {

		if(event instanceof Notification) {
			Object feature = ((Notification)event).getFeature();
			if(feature instanceof EStructuralFeature) {
				return UMLPackage.eINSTANCE.getNamedElement_Name().equals(feature) || UMLPackage.eINSTANCE.getConnector_Type().equals(feature);
			}
		}

		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<EObject> getSemanticElementsBeingParsed(EObject element) {
		List<EObject> semanticElementsBeingParsed = new ArrayList<EObject>();

		if((element != null) && (element instanceof Connector)) {
			Connector semElement = (Connector)element;

			semanticElementsBeingParsed.add(semElement);
			if(semElement.getType() != null) {
				semanticElementsBeingParsed.add(semElement.getType());
			}
		}
		return semanticElementsBeingParsed;
	}
}
