/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan Faure (Atos Origin) tristan.faure@atosorigin.com - Initial API and implementation
 *
  *****************************************************************************/
package org.eclipse.papyrus.diagramprofile.utils;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.helper.OCLHelper;

public class OCLUtils {

	/**
	 * variables for ocl
	 */
	private static org.eclipse.ocl.OCL<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, org.eclipse.ocl.ecore.Constraint, EClass, EObject> ocl = OCL
			.newInstance(new EcoreEnvironmentFactory());

	private static OCLHelper<EClassifier, ?, ?, ?> oclHelper = ocl.createOCLHelper();

	/**
	 * The Ocl rule is evaluated to the eobject argument this methods returns an object and the type
	 * depends of the input rule
	 * 
	 * @param oclRule
	 *            the ocl rule
	 * @param object
	 *            the object
	 * 
	 * @return the object, result of the query
	 */
	public static Object runOclRule(String oclRule, EObject object) {
		if (object != null) {
			oclHelper.setContext(object.eClass());
		}
		OCLExpression exp;
		try {
			exp = (OCLExpression) oclHelper.createQuery(oclRule);
			Object result = ocl.evaluate(object, exp);
			return result;
		} catch (ParserException e) {
			e.printStackTrace();
		}
		return null;
	}
}
