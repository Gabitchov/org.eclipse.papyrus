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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.sysml.blocks.BlocksPackage;
import org.eclipse.papyrus.sysml.blocks.Dimension;
import org.eclipse.papyrus.sysml.blocks.Unit;
import org.eclipse.papyrus.sysml.diagram.common.preferences.ILabelPreferenceConstants;
import org.eclipse.papyrus.uml.diagram.common.parser.NamedElementLabelParser;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * Semantic Parser for {@link Unit}
 */
public class UnitLabelParser extends NamedElementLabelParser {

	/** The String format for displaying a {@link Unit} label with its name */
	protected static final String NAME_FORMAT = "%s";

	/** The String format for displaying a {@link Unit} with direction */
	protected static final String DIMENSION_FORMAT = "%s {%s}";

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getPrintString(IAdaptable element, int flags) {

		Collection<String> maskValues = getMaskValues(element);

		if(maskValues.isEmpty()) {
			return MaskedLabel;
		}

		String result = "";
		EObject eObject = (EObject)element.getAdapter(EObject.class);

		if((eObject != null) && (eObject instanceof InstanceSpecification)) {

			InstanceSpecification iSpec = (InstanceSpecification)eObject;

			Unit unit = UMLUtil.getStereotypeApplication(iSpec, Unit.class);

			// manage name
			if((maskValues.contains(ILabelPreferenceConstants.DISP_NAME)) && (iSpec.isSetName())) {
				String name = iSpec.getName();
				result = String.format(NAME_FORMAT, name);
			}

			// manage dimension
			if((maskValues.contains(ILabelPreferenceConstants.DISP_DIMENSION))) {
				String dimensionName = "<Undefined>";
				if((unit != null) && (unit.getDimension() != null)) {
					Dimension dim = unit.getDimension();
					if((dim.getBase_InstanceSpecification() != null) && (dim.getBase_InstanceSpecification().isSetName())) {
						dimensionName = dim.getBase_InstanceSpecification().getName();
					}
				}
				result = String.format(DIMENSION_FORMAT, result, dimensionName);
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
				return BlocksPackage.eINSTANCE.getUnit_Dimension().equals(feature) || super.isAffectingEvent(event, flags);
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

		if((element != null) && (element instanceof InstanceSpecification)) {
			InstanceSpecification semElement = (InstanceSpecification)element;

			semanticElementsBeingParsed.add(semElement);

			Unit unit = UMLUtil.getStereotypeApplication(semElement, Unit.class);
			if(unit != null) {
				semanticElementsBeingParsed.add(unit);
			}
		}
		return semanticElementsBeingParsed;
	}


	@Override
	public Map<String, String> getMasks() {
		Map<String, String> masks = new HashMap<String, String>();
		masks.put(ILabelPreferenceConstants.DISP_NAME, "Name");
		masks.put(ILabelPreferenceConstants.DISP_DIMENSION, "Dimension");
		return masks;
	}

	public Collection<String> getDefaultValue() {
		return Arrays.asList(ILabelPreferenceConstants.DISP_NAME, ILabelPreferenceConstants.DISP_DIMENSION);
	}
}
