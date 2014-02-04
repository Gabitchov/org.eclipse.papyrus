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
package org.eclipse.papyrus.sysml.diagram.common.parser;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.sysml.diagram.common.preferences.ILabelPreferenceConstants;
import org.eclipse.papyrus.sysml.portandflows.FlowDirection;
import org.eclipse.papyrus.sysml.portandflows.FlowProperty;
import org.eclipse.papyrus.sysml.portandflows.PortandflowsPackage;
import org.eclipse.papyrus.uml.diagram.common.parser.PropertyLabelParser;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * Semantic Parser for {@link FlowProperty}
 */
public class FlowPropertyLabelParser extends PropertyLabelParser {

	/** The String format for displaying a FlowProperty with direction */
	protected static final String DIRECTION_FORMAT = "%s %s";

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getPrintString(IAdaptable element, int flags) {

		Collection<String> maskValues = getMaskValues(element);

		if(maskValues.isEmpty()) {
			return MaskedLabel;
		}

		String result = super.getPrintString(element, flags);

		EObject eObject = (EObject)element.getAdapter(EObject.class);
		if((eObject != null) && (eObject instanceof Property)) {

			Property property = (Property)eObject;
			FlowProperty flowProperty = UMLUtil.getStereotypeApplication(property, FlowProperty.class);
			if(flowProperty != null) {

				// manage direction
				if(maskValues.contains(ILabelPreferenceConstants.DISP_DIRECTION)) {
					String direction;
					switch(flowProperty.getDirection().getValue()) {
					case FlowDirection.IN_VALUE:
						direction = "in";
						break;
					case FlowDirection.OUT_VALUE:
						direction = "out";
						break;
					case FlowDirection.INOUT_VALUE:
						direction = "inout";
						break;
					default:
						direction = "inout";
						break;
					}
					result = String.format(DIRECTION_FORMAT, direction, result);
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
				return PortandflowsPackage.eINSTANCE.getFlowProperty_Direction().equals(feature) || super.isAffectingEvent(event, flags);
			}
		}

		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<EObject> getSemanticElementsBeingParsed(EObject element) {
		List<EObject> semanticElementsBeingParsed = super.getSemanticElementsBeingParsed(element);

		if((element != null) && (element instanceof Property)) {
			Property semElement = (Property)element;

			FlowProperty flowProperty = UMLUtil.getStereotypeApplication(semElement, FlowProperty.class);
			if(flowProperty != null) {
				semanticElementsBeingParsed.add(flowProperty);
			}
		}
		return semanticElementsBeingParsed;
	}

	@Override
	public Map<String, String> getMasks() {
		Map<String, String> masks = new HashMap<String, String>(10);
		masks.put(ILabelPreferenceConstants.DISP_DIRECTION, "Direction");
		masks.put(ILabelPreferenceConstants.DISP_VISIBILITY, "Visibility");
		masks.put(ILabelPreferenceConstants.DISP_DERIVE, "Is Derived");
		masks.put(ILabelPreferenceConstants.DISP_NAME, "Name");
		masks.put(ILabelPreferenceConstants.DISP_TYPE, "Type");
		masks.put(ILabelPreferenceConstants.DISP_UNDEFINED_TYPE, "Show <Undefined> type");
		masks.put(ILabelPreferenceConstants.DISP_MULTIPLICITY, "Multiplicity");
		masks.put(ILabelPreferenceConstants.DISP_DEFAULT_MULTIPLICITY, "Show default multiplicity");
		masks.put(ILabelPreferenceConstants.DISP_DEFAULT_VALUE, "Default Value");
		masks.put(ILabelPreferenceConstants.DISP_MODIFIERS, "Modifiers");
		return masks;
	}

	@Override
	public Collection<String> getDefaultValue(IAdaptable element) {
		return Arrays.asList(ILabelPreferenceConstants.DISP_DIRECTION, ILabelPreferenceConstants.DISP_NAME, ILabelPreferenceConstants.DISP_TYPE, ILabelPreferenceConstants.DISP_UNDEFINED_TYPE);
	}
}
