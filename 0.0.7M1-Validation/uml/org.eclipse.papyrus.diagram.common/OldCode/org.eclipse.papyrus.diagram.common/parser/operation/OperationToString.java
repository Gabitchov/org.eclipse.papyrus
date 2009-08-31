/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Michael Golubev (Borland) - initial API and implementation
 */

package org.eclipse.papyrus.diagram.common.parser.operation;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.diagram.common.details.DetailLevelParserOptions;
import org.eclipse.papyrus.diagram.common.parser.AbstractToString;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.UMLPackage;

public abstract class OperationToString extends AbstractToString {

	public static class EDIT extends OperationToString {

		public String getToString(EObject object, int flags) {
			return getToString(object, true, flags);
		}

		public boolean isAffectingFeature(EStructuralFeature feature) {
			throw new UnsupportedOperationException();
		}
	}

	public static class VIEW extends OperationToString implements WithReferences {

		private static final List AFFECTING = Arrays.asList(new EStructuralFeature[] {
				UMLPackage.eINSTANCE.getNamedElement_Visibility(), UMLPackage.eINSTANCE.getNamedElement_Name(),
				UMLPackage.eINSTANCE.getBehavior_OwnedParameter(), UMLPackage.eINSTANCE.getParameter_Direction(),
				UMLPackage.eINSTANCE.getTypedElement_Type(), UMLPackage.eINSTANCE.getMultiplicityElement_UpperValue(),
				UMLPackage.eINSTANCE.getMultiplicityElement_LowerValue(),
				UMLPackage.eINSTANCE.getLiteralUnlimitedNatural_Value(),
				UMLPackage.eINSTANCE.getLiteralInteger_Value(), });

		public String getToString(EObject object, int flags) {
			return getToString(object, false, flags);
		}

		public boolean isAffectingFeature(EStructuralFeature feature) {
			return AFFECTING.contains(feature);
		}

		public List getAdditionalReferencedElements(EObject object) {
			Operation operation = asOperation(object);
			List result = new LinkedList() {

				@Override
				public boolean add(Object data) {
					return (data != null) && super.add(data);
				}
			};
			result.add(operation);
			for (Iterator params = operation.getOwnedParameters().iterator(); params.hasNext();) {
				Parameter next = (Parameter) params.next();
				result.add(next.getType());
				result.add(next);
				result.add(next.getLowerValue());
				result.add(next.getUpperValue());
			}
			return result;
		}
	}

	protected String getToString(EObject object, boolean editNotView, int flags) {
		Operation operation = asOperation(object);
		StringBuffer result = new StringBuffer();

		if (!editNotView && DetailLevelParserOptions.LEVEL_ANALYSIS == flags) {
			appendName(result, operation);
			result.append("()"); //$NON-NLS-1$
			Parameter ret = operation.getReturnResult();
			if (ret != null) {
				appendType(result, ret);
			}
			return result.toString();
		}

		result.append(getVisibility(operation));
		appendName(result, operation);
		result.append("( "); //$NON-NLS-1$

		Parameter ret = operation.getReturnResult();
		boolean firstWritten = false;
		for (Iterator parameters = operation.getOwnedParameters().iterator(); parameters.hasNext();) {
			Parameter next = (Parameter) parameters.next();
			if (next.equals(ret)) {
				continue;
			}
			if (firstWritten) {
				result.append(", "); //$NON-NLS-1$
			}
			firstWritten = true;
			result.append(getDirection(next));
			appendName(result, next);
			appendType(result, next);
			appendMultiplicity(result, next);
			if (editNotView) {
				appendDefaultParameterValue(result, next);
			}

		}
		result.append(" )"); //$NON-NLS-1$

		if (ret != null) {
			appendType(result, ret);
		}
		if (editNotView) {
			appendModifiers(result, operation);
		}
		return result.toString();
	}

	protected void appendDefaultParameterValue(StringBuffer result, Parameter parameter) {
		String def = parameter.getDefault();
		if (!isEmpty(def)) {
			result.append(" = "); //$NON-NLS-1$
			result.append(def);
		}
	}

	protected String getDirection(Parameter parameter) {
		ParameterDirectionKind direction = parameter.getDirection();
		switch (direction.getValue()) {
		case ParameterDirectionKind.IN:
			return ""; //default is omitted //$NON-NLS-1$
		case ParameterDirectionKind.OUT:
			return "out "; //$NON-NLS-1$
		case ParameterDirectionKind.INOUT:
			return "inout "; //$NON-NLS-1$
		case ParameterDirectionKind.RETURN:
			throw new IllegalStateException("Return parameter should not be included into parameters list"); //$NON-NLS-1$
		}

		throw new IllegalStateException(
				"Unknown parameter direction kind: " + direction + " for parameter: " + parameter); //$NON-NLS-1$ //$NON-NLS-2$
	}

	protected Operation asOperation(EObject object) {
		if (false == object instanceof Operation) {
			throw new IllegalStateException("I can not provide toString for: " + object); //$NON-NLS-1$
		}
		return (Operation) object;
	}

	public void appendModifiers(StringBuffer result, Operation operation) {
		ModifiersBuilder builder = new ModifiersBuilder();
		if (operation.isQuery()) {
			builder.appendModifier("query"); //$NON-NLS-1$
		}
		if (operation.isOrdered()) {
			builder.appendModifier("ordered"); //$NON-NLS-1$
		}
		if (operation.isUnique()) {
			builder.appendModifier("unique"); //$NON-NLS-1$
		}
		for (Iterator redefines = operation.getRedefinedOperations().iterator(); redefines.hasNext();) {
			Operation next = (Operation) redefines.next();
			String nextName = next.getName();
			if (!isEmpty(nextName)) {
				builder.appendModifier("redefines " + nextName); //$NON-NLS-1$
			}
		}

		builder.writeInto(result);
	}

}
