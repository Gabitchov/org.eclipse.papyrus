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
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.gmf.diagram.common.parser.IMaskManagedSemanticParser;
import org.eclipse.papyrus.infra.tools.util.StringHelper;
import org.eclipse.papyrus.sysml.diagram.common.preferences.ILabelPreferenceConstants;
import org.eclipse.papyrus.uml.diagram.common.utils.ParameterLabelUtil;
import org.eclipse.papyrus.uml.tools.utils.ICustomAppearance;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.VisibilityKind;

/**
 * Semantic Parser for {@link Operation}
 */
public class OperationLabelParser extends NamedElementLabelParser {

	/** Parameter parser */
	protected IMaskManagedSemanticParser parameterParser = new ParameterLabelParser();

	/** The String format for displaying {@link Operation} label with visibility */
	protected static final String VISIBILITY_FORMAT = "%s ";

	/** The String format for displaying a {@link Operation} label with its name */
	protected static final String NAME_FORMAT = "%s%s(%s)";

	/** The String format for displaying a {@link Operation} label with its type */
	protected static final String TYPE_FORMAT = "%s: %s";

	/** The String format for displaying a {@link Operation} label with modifiers */
	protected static final String MODIFIER_FORMAT = "%s{%s}";

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

		if((eObject != null) && (eObject instanceof Operation)) {

			Operation operation = (Operation)eObject;

			// manage visibility
			if(maskValues.contains(ILabelPreferenceConstants.DISP_VISIBILITY)) {
				String visibility;
				switch(operation.getVisibility().getValue()) {
				case VisibilityKind.PACKAGE:
					visibility = "~";
					break;
				case VisibilityKind.PUBLIC:
					visibility = "+";
					break;
				case VisibilityKind.PROTECTED:
					visibility = "#";
					break;
				case VisibilityKind.PRIVATE:
					visibility = "-";
					break;
				default:
					visibility = "+";
					break;
				}
				result = String.format(VISIBILITY_FORMAT, visibility);
			}

			// manage name and parameters
			if((maskValues.contains(ILabelPreferenceConstants.DISP_NAME)) && (operation.isSetName())) {
				String name = operation.getName();

				StringBuffer params = new StringBuffer();
				for(Parameter parameter : operation.getOwnedParameters()) {
					if(parameter.getDirection() != ParameterDirectionKind.RETURN_LITERAL) {
						String currentParamLabel = ParameterLabelUtil.getPrintString(parameter, extractParameterMaskValues(maskValues));
						params.append(params.length() == 0 ? currentParamLabel : ", " + currentParamLabel);
					}
				}

				result = String.format(NAME_FORMAT, result, name, params);
			}

			// manage type
			if((maskValues.contains(ILabelPreferenceConstants.DISP_TYPE))) {
				String type = "<Undefined>";
				if(operation.getType() != null) {
					type = operation.getType().getName();
				}

				// If type is undefined only show "<Undefined>" when explicitly asked.
				if((maskValues.contains(ILabelPreferenceConstants.DISP_UNDEFINED_TYPE)) || (!"<Undefined>".equals(type))) {
					result = String.format(TYPE_FORMAT, result, type);
				}
			}

			// manage modifier
			if(maskValues.contains(ILabelPreferenceConstants.DISP_MODIFIERS)) {
				StringBuffer sb = new StringBuffer();
				if(operation.isAbstract()) {
					sb.append(sb.length() == 0 ? "abstract" : ", abstract");
				}
				if(operation.isStatic()) {
					sb.append(sb.length() == 0 ? "static" : ", static");
				}
				if(operation.isUnique()) {
					sb.append(sb.length() == 0 ? "unique" : ", unique");
				}
				if(operation.isQuery()) {
					sb.append(sb.length() == 0 ? "query" : ", query");
				}
				if(operation.isLeaf()) {
					sb.append(sb.length() == 0 ? "leaf" : ", leaf");
				}

				if(sb.length() != 0) {
					result = String.format(MODIFIER_FORMAT, result, sb.toString());
				}
			}
		}
		return result;
	}

	private static Collection<String> extractParameterMaskValues(Collection<String> operationMaskValues) {
		Set<String> result = new HashSet<String>();

		for(String maskValue : operationMaskValues) {
			if(maskValue.startsWith(ICustomAppearance.PARAMETERS_PREFIX)) {
				String newValue = StringHelper.firstToLower(maskValue.replace(ICustomAppearance.PARAMETERS_PREFIX, ""));
				result.add(newValue);
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
				return UMLPackage.eINSTANCE.getNamedElement_Visibility().equals(feature) || UMLPackage.eINSTANCE.getTypedElement_Type().equals(feature) || UMLPackage.eINSTANCE.getBehavioralFeature_IsAbstract().equals(feature) || UMLPackage.eINSTANCE.getFeature_IsStatic().equals(feature) || UMLPackage.eINSTANCE.getOperation_IsUnique().equals(feature) || UMLPackage.eINSTANCE.getOperation_IsQuery().equals(feature) || UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf().equals(feature) || parameterParser.isAffectingEvent(event, flags) || super.isAffectingEvent(event, flags);
			}
		}

		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<EObject> getSemanticElementsBeingParsed(EObject element) {
		List<EObject> semanticElementsBeingParsed = new ArrayList<EObject>();

		if((element != null) && (element instanceof Operation)) {
			Operation semElement = (Operation)element;

			semanticElementsBeingParsed.add(semElement);
			if(semElement.getType() != null) {
				semanticElementsBeingParsed.add(semElement.getType());
			}
			for(Parameter parameter : semElement.getOwnedParameters()) {
				semanticElementsBeingParsed.addAll(parameterParser.getSemanticElementsBeingParsed(parameter));
			}
		}
		return semanticElementsBeingParsed;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, String> getMasks() {
		Map<String, String> masks = new HashMap<String, String>(5);
		masks.put(ILabelPreferenceConstants.DISP_VISIBILITY, "Visibility");
		masks.put(ILabelPreferenceConstants.DISP_NAME, "Name");
		masks.put(ILabelPreferenceConstants.DISP_TYPE, "Type");
		masks.put(ILabelPreferenceConstants.DISP_UNDEFINED_TYPE, "Show <Undefined> type");
		masks.put(ILabelPreferenceConstants.DISP_MODIFIERS, "Modifiers");

		masks.put(ILabelPreferenceConstants.DISP_PARAMETER_DIRECTION, "Parameter direction");
		masks.put(ILabelPreferenceConstants.DISP_PARAMETER_NAME, "Parameter name");
		masks.put(ILabelPreferenceConstants.DISP_PARAMETER_TYPE, "Parameter type");
		masks.put(ILabelPreferenceConstants.DISP_PARAMETER_MULTIPLICITY, "Parameter multiplicity");
		masks.put(ILabelPreferenceConstants.DISP_PARAMETER_DEFAULT, "Parameter default value");
		masks.put(ILabelPreferenceConstants.DISP_PARAMETER_MODIFIERS, "Parameter modifiers");
		return masks;
	}

	@Override
	public Collection<String> getDefaultValue(IAdaptable element) {
		return Arrays.asList(ILabelPreferenceConstants.DISP_NAME, ILabelPreferenceConstants.DISP_TYPE, ILabelPreferenceConstants.DISP_PARAMETER_DIRECTION, ILabelPreferenceConstants.DISP_PARAMETER_NAME, ILabelPreferenceConstants.DISP_PARAMETER_TYPE);
	}
}
