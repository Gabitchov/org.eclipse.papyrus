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
package org.eclipse.papyrus.uml.diagram.common.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.sysml.diagram.common.preferences.ILabelPreferenceConstants;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Semantic Parser for {@link Connector}
 */
public class ConnectorLabelParser extends NamedElementLabelParser {

	/** The String format for displaying a {@link Connector} label with its name */
	protected static final String NAME_FORMAT = "%s";

	/** The String format for displaying a {@link Connector} label with its type */
	protected static final String TYPE_FORMAT = "%s: %s";

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getPrintString(IAdaptable element, int flags) {
		
		if (flags == 0) {
			return MaskedLabel;
		}
		
		String result = "";
		EObject eObject = (EObject)element.getAdapter(EObject.class);

		if((eObject != null) && (eObject instanceof Connector)) {

			Connector connector = (Connector)eObject;

			// manage name
			if(((flags & ILabelPreferenceConstants.DISP_NAME) == ILabelPreferenceConstants.DISP_NAME) && (connector.isSetName())) {
				String name = connector.getName();
				result = String.format(NAME_FORMAT, name);
			}

			// manage type
			if(((flags & ILabelPreferenceConstants.DISP_TYPE) == ILabelPreferenceConstants.DISP_TYPE)) {
				String type = "<Undefined>";
				if(connector.getType() != null) {
					type = connector.getType().getName();
				}

				// If type is undefined only show "<Undefined>" when explicitly asked.
				if(((flags & ILabelPreferenceConstants.DISP_UNDEFINED_TYPE) == ILabelPreferenceConstants.DISP_UNDEFINED_TYPE) || (!"<Undefined>".equals(type))) {
					result = String.format(TYPE_FORMAT, result, type);
				}
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
				return UMLPackage.eINSTANCE.getTypedElement_Type().equals(feature) || super.isAffectingEvent(event, flags);
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
	
	public Map<Integer, String> getMasks() {
		Map<Integer, String> masks = new HashMap<Integer, String>(2);
		masks.put(ILabelPreferenceConstants.DISP_NAME, "Name");
		masks.put(ILabelPreferenceConstants.DISP_TYPE, "Type");
		masks.put(ILabelPreferenceConstants.DISP_UNDEFINED_TYPE, "Show <Undefined> type");
		return masks;
	}
}
