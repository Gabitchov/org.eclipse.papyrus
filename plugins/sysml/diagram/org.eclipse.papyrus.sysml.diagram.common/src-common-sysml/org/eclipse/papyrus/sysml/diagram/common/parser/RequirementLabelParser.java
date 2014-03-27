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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.sysml.diagram.common.preferences.ILabelPreferenceConstants;
import org.eclipse.papyrus.sysml.requirements.Requirement;
import org.eclipse.papyrus.uml.diagram.common.parser.NamedElementLabelParser;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * Semantic Parser for {@link Requirement}
 */
public class RequirementLabelParser extends NamedElementLabelParser {

	/** The String format for displaying a Requirement name */
	protected static final String NAME_FORMAT = "%s";

	/** The String format for displaying a FlowProperty with direction */
	protected static final String ID_FORMAT = "%s{id = %s}";

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
		EObject eObject =EMFHelper.getEObject(element);

		if((eObject != null) && (eObject instanceof Class)) {

			Class clazz = (Class)eObject;
			Requirement requirement = UMLUtil.getStereotypeApplication(clazz, Requirement.class);

			// manage name
			if(maskValues.contains(ILabelPreferenceConstants.DISP_NAME)) {
				String name = clazz.getName();
				result = String.format(NAME_FORMAT, name);
			}


			if(requirement != null) {

				// manage id
				if(maskValues.contains(ILabelPreferenceConstants.DISP_ID)) {
					String id = requirement.getId();
					result = String.format(ID_FORMAT, result, id);
				}
			}
		}

		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<EObject> getSemanticElementsBeingParsed(EObject element) {
		List<EObject> semanticElementsBeingParsed = new ArrayList<EObject>();

		if((element != null) && (element instanceof Class)) {
			Class semElement = (Class)element;

			semanticElementsBeingParsed.add(semElement);

			Requirement requirement = UMLUtil.getStereotypeApplication(semElement, Requirement.class);
			if(requirement != null) {
				semanticElementsBeingParsed.add(requirement);
			}
		}
		return semanticElementsBeingParsed;
	}

	@Override
	public Map<String, String> getMasks() {
		Map<String, String> masks = new HashMap<String, String>();
		masks.put(ILabelPreferenceConstants.DISP_NAME, "Name");
		masks.put(ILabelPreferenceConstants.DISP_ID, "Id");
		return masks;
	}

	@Override
	public Collection<String> getDefaultValue(IAdaptable element) {
		return Arrays.asList(ILabelPreferenceConstants.DISP_NAME, ILabelPreferenceConstants.DISP_ID);
	}
}
