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
package org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.validation;

import org.eclipse.papyrus.uml.alf.alf.AlfPackage;
import org.eclipse.papyrus.uml.alf.alf.NameExpression;
import org.eclipse.papyrus.uml.profile.structure.AppliedStereotypeProperty;
import org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.AppliedStereotypePropertyEditorUtil;
import org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.appliedStereotypeProperty.AppliedStereotypePropertyRule;
import org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.appliedStereotypeProperty.ExpressionValueRule;
import org.eclipse.papyrus.uml.xtext.integration.core.ContextElementUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.xtext.validation.Check;

public class AppliedStereotypePropertyJavaValidator extends AbstractAppliedStereotypePropertyJavaValidator {

	protected static final String NOT_EXIST_DISPLAY = "This named element does not exist";

	public static final String NOT_EXIST = "AppliedStereotypeProperty.quickfix.NOT_EXIST";

	@Check
	public void checkAppliedStereotypePropertyRule_property(AppliedStereotypePropertyRule appliedStereotypePropertyRule) {
		AppliedStereotypeProperty contextElement = (AppliedStereotypeProperty) ContextElementUtil
				.getContextElement(appliedStereotypePropertyRule.eResource());
		// nothing to do any more - property has been removed
	}

	@Check
	public void checkNameExpression(ExpressionValueRule expressionValue) {
		// error("ExpressionValueRule",
		// AppliedStereotypePropertyPackage.eINSTANCE.getExpressionValueRule_Expression());
	}

	@Check
	public void checkNameExpression(NameExpression nameExpression) {
		AppliedStereotypeProperty contextElement = (AppliedStereotypeProperty) ContextElementUtil
				.getContextElement(nameExpression.eResource());
		Object[] objectList = AppliedStereotypePropertyEditorUtil.getPossibleElements(contextElement);
		// if the property references a stereotyped element
		if (contextElement.getStereotypeProperty().getType().eClass().getName().equals("Stereotype")) {
			if (AppliedStereotypePropertyEditorUtil.getApplicationStereotypeFor(nameExpression, objectList) == null) {
				error(NOT_EXIST_DISPLAY, AlfPackage.eINSTANCE.getNameExpression_Id(), NOT_EXIST, NOT_EXIST_DISPLAY);
			}
			return;
		}
		// if the property references an element
		if (contextElement.getStereotypeProperty().getType() instanceof Element) {
			if (AppliedStereotypePropertyEditorUtil.getNamedElementFor(nameExpression, objectList) == null) {
				error(NOT_EXIST_DISPLAY, AlfPackage.eINSTANCE.getNameExpression_Id(), NOT_EXIST, NOT_EXIST_DISPLAY);
			}
			return;
		}
	}
	// @Check
	// public void checkGreetingStartsWithCapital(Greeting greeting) {
	// if (!Character.isUpperCase(greeting.getName().charAt(0))) {
	// warning("Name should start with a capital",
	// MyDslPackage.Literals.GREETING__NAME);
	// }
	// }

}
