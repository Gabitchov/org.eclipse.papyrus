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

package org.eclipse.papyrus.diagram.common.parser.slot;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.diagram.common.parser.AbstractToString;
import org.eclipse.uml2.uml.Expression;
import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.StructuralFeature;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;

public abstract class SlotToString extends AbstractToString {

	public static class EDIT extends SlotToString {

		public boolean isAffectingFeature(EStructuralFeature feature) {
			throw new UnsupportedOperationException("I am edit toString, I am not expected to be asked"); //$NON-NLS-1$
		}
	}

	public static class VIEW extends SlotToString implements WithReferences {

		private static final List AFFECTING = Arrays.asList(new EStructuralFeature[] { UMLPackage.eINSTANCE.getSlot_Value(), UMLPackage.eINSTANCE.getSlot_DefiningFeature(),
				UMLPackage.eINSTANCE.getExpression_Symbol(), UMLPackage.eINSTANCE.getLiteralString_Value(), UMLPackage.eINSTANCE.getLiteralInteger_Value(), });

		public boolean isAffectingFeature(EStructuralFeature feature) {
			return AFFECTING.contains(feature);
		}

		public List getAdditionalReferencedElements(EObject object) {
			Slot slot = asSlot(object);
			List result = new LinkedList();
			result.add(slot);
			StructuralFeature definingFeature = slot.getDefiningFeature();
			if (definingFeature != null) {
				result.add(definingFeature);
			}
			result.addAll(slot.getValues());
			return result;
		}

	}

	public String getToString(EObject object, int flags) {
		Slot slot = asSlot(object);
		StringBuffer result = new StringBuffer();
		appendFeatureName(result, slot);
		appendSlotValue(result, slot);
		return result.toString();
	}

	protected void appendFeatureName(StringBuffer result, Slot slot) {
		StructuralFeature feature = slot.getDefiningFeature();
		appendName(result, feature);
	}

	/**
	 * FIXME: It is unclear from the spec how multiple values should be shown. For now assuming only one value
	 */
	protected void appendSlotValue(StringBuffer result, Slot slot) {
		for (Iterator values = slot.getValues().iterator(); values.hasNext();) {
			ValueSpecification next = (ValueSpecification) values.next();
			String nextDisplayValue = getSlotValue(next);
			if (!isEmpty(nextDisplayValue)) {
				result.append(" = ").append(nextDisplayValue); //$NON-NLS-1$
				// FIXME: for now stop on first success
				break;
			}
		}
	}

	protected String getSlotValue(ValueSpecification value) {
		if (value instanceof LiteralString) {
			LiteralString literal = (LiteralString) value;
			return "\"" + literal.getValue() + "\""; //$NON-NLS-1$ //$NON-NLS-2$
		}
		if (value instanceof LiteralInteger) {
			LiteralInteger literal = (LiteralInteger) value;
			return String.valueOf(literal.getValue());
		}
		if (value instanceof Expression) {
			Expression expression = (Expression) value;
			return expression.getSymbol();
		}
		return null;
	}

	protected Slot asSlot(EObject object) {
		if (false == object instanceof Slot) {
			throw new IllegalStateException("I can not provide toString for: " + object); //$NON-NLS-1$
		}
		return (Slot) object;
	}

}
