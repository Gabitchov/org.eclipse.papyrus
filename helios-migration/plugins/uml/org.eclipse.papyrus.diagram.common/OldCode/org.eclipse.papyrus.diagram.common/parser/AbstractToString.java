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

package org.eclipse.papyrus.diagram.common.parser;

import org.eclipse.uml2.uml.LiteralUnlimitedNatural;
import org.eclipse.uml2.uml.MultiplicityElement;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.TypedElement;
import org.eclipse.uml2.uml.VisibilityKind;

public abstract class AbstractToString implements ExternalToString {

	protected String getVisibility(NamedElement namedElement) {
		VisibilityKind visibility = namedElement.getVisibility();
		switch (visibility.getValue()) {
		case VisibilityKind.PACKAGE:
			return "~";
		case VisibilityKind.PRIVATE:
			return "-";
		case VisibilityKind.PROTECTED:
			return "#";
		case VisibilityKind.PUBLIC:
			return ""; // omitted
		}
		throw new IllegalArgumentException("Unknown visibility for :" + namedElement + ", that is: " + visibility);
	}

	protected void appendName(StringBuffer result, NamedElement namedElement) {
		if (namedElement == null) {
			return;
		}
		String name = namedElement.getName();
		if (!isEmpty(name)) {
			result.append(name);
		}
	}

	protected void appendType(StringBuffer result, TypedElement typedElement) {
		if (typedElement == null) {
			return;
		}
		Type type = typedElement.getType();
		if (type == null) {
			return;
		}
		appendType(result, type.getName());
	}

	protected static void appendType(StringBuffer result, String typeName) {
		if (isEmpty(typeName)) {
			return;
		}
		result.append(" : ");
		result.append(typeName);
	}

	protected static boolean isEmpty(String text) {
		return text == null || text.trim().length() == 0;
	}

	protected void appendMultiplicity(StringBuffer result, MultiplicityElement element) {
		appendMultiplicity(result, element, true);
	}

	protected void appendMultiplicity(StringBuffer result, MultiplicityElement element, boolean skipIfExactlyOne) {
		if (element == null) {
			return;
		}
		int lower = element.getLower();
		int upper = element.getUpper();
		if (upper == 1 && lower == 1 && skipIfExactlyOne) {
			return;
		}
		result.append(" [");
		if (lower != upper) {
			result.append(lower);
			result.append('.').append('.');
		}
		if (upper == LiteralUnlimitedNatural.UNLIMITED) {
			result.append('*');
		} else {
			result.append(upper);
		}
		result.append(']');
	}

	protected static class ModifiersBuilder {

		private final StringBuffer myBuffer;

		public ModifiersBuilder() {
			myBuffer = new StringBuffer();
		}

		public void appendModifier(String modifier) {
			if (modifier.length() == 0) {
				return;
			}
			if (myBuffer.length() != 0) {
				myBuffer.append(", ");
			}
			myBuffer.append(modifier);
		}

		public void writeInto(StringBuffer output) {
			if (myBuffer.length() == 0) {
				return;
			}
			output.append(" ");
			output.append("{ ");
			output.append(myBuffer);
			output.append(" }");
		}

		@Override
		public String toString() {
			return super.toString();
		}

	}

}
