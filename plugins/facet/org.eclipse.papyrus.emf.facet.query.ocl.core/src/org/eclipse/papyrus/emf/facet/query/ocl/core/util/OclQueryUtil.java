/**
 * Copyright (c) 2012 Mia-Software.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  	Alban Ménager (Soft-Maint) - Bug 387470 - [EFacet][Custom] Editors
 */
package org.eclipse.papyrus.emf.facet.query.ocl.core.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.OCL;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.CollectionType;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.PrimitiveType;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.expressions.IteratorExp;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.helper.Choice;
import org.eclipse.ocl.helper.ConstraintKind;
import org.eclipse.ocl.helper.OCLHelper;

/**
 * All necessary methods for the creation and evaluation of OCL expressions.
 */
public final class OclQueryUtil {

	private static OCL<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> oclEnvironment = OCL
			.newInstance(EcoreEnvironmentFactory.INSTANCE);
	private static OCLHelper<EClassifier, EOperation, EStructuralFeature, Constraint> oclHelper = getOCLEnvironment()
			.createOCLHelper();

	private OclQueryUtil() {
		// Private Constructor.
	}

	/**
	 * Get or create an OCL instance for Ecore.
	 * 
	 * @return the OCL environment for Ecore
	 */
	private static OCL<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> getOCLEnvironment() {
		return oclEnvironment;
	}

	public static EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> getEvaluationEvironment() {
		return getOCLEnvironment().getEvaluationEnvironment();
	}

	/**
	 * Get or create an OCLHelper with a specific context.
	 * 
	 * @param context
	 *            the context of the helper.
	 * @return the helper according to the context.
	 */
	private static OCLHelper<EClassifier, EOperation, EStructuralFeature, Constraint> getOCLHelper() {
		return oclHelper;
	}

	/**
	 * Set the helper context.
	 * 
	 * @param context
	 *            the context of the helper.
	 */
	private static void setHelperContext(final EClassifier context) {
		getOCLHelper().setContext(context);
	}

	/**
	 * Set the helper context.
	 * 
	 * @param context
	 *            the context of the helper.
	 */
	public static void setHelperInstanceContext(final Object context) {
		getOCLHelper().setInstanceContext(context);
	}

	/**
	 * Create an OCLExpression according to a string.
	 * 
	 * @param expression
	 *            the expression to create.
	 * @return the expression.
	 * @throws ParserException
	 *             if the string expression isn't well formed.
	 */
	public static OCLExpression<EClassifier> createOCLExpression(
			final EClassifier context, final String expression)
			throws ParserException {
		setHelperContext(context);
		return getOCLHelper().createQuery(expression);
	}

	/**
	 * Evaluate the expression in parameter.
	 * 
	 * @param oclExpression
	 *            the expression to evaluate.
	 * @return the result of the expression.
	 */
	public static Object evaluateQuery(final EClassifier context,
			final OCLExpression<EClassifier> oclExpression) {
		setHelperContext(context);
		return getOCLEnvironment().createQuery(oclExpression).evaluate();
	}

	/**
	 * Evaluate the expression in parameter on the specific object.
	 * 
	 * @param oclExpression
	 *            the expression to evaluate.
	 * @param objectSource
	 *            the object on which evaluate the expression.
	 * @return the result of the query.
	 */
	public static Object evaluateQuery(final EClassifier context,
			final OCLExpression<EClassifier> oclExpression,
			final Object objectSource) {
		setHelperContext(context);
		return getOCLEnvironment().createQuery(oclExpression).evaluate(
				objectSource);
	}

	/**
	 * Evaluate the expression in parameter on the specifics objects.
	 * 
	 * @param oclExpression
	 *            the expression to evaluate.
	 * @param objectsSource
	 *            the objects on which evaluate the expression.
	 * @return the result of the query.
	 */
	public static Object evaluateQuery(final EClassifier context,
			final OCLExpression<EClassifier> oclExpression,
			final List<?> objectsSource) {
		setHelperContext(context);
		return getOCLEnvironment().createQuery(oclExpression).evaluate(
				objectsSource);
	}

	/**
	 * Return a list of syntax choice for the current expression.
	 * 
	 * @param expression
	 *            the expression.
	 * @return the different choices.
	 */
	public static List<Choice> getSyntaxHelp(final EClassifier context,
			final String expression) {
		setHelperContext(context);
		return getOCLHelper().getSyntaxHelp(ConstraintKind.INVARIANT,
				expression);
	}

	/**
	 * Return the {@link EClassifier} associated to the <code>type</code> in
	 * parameter.
	 * 
	 * @param context
	 *            the context of the environment.
	 * @param type
	 *            the type to find.
	 * @return the {@link EClassifier} associated. Null if not.
	 */
	public static EClassifier getEClassifier(final EClassifier context,
			final Object type) {
		EClassifier result = null;
		String name = null;
		List<EClassifier> classifiers = null;

		if (type instanceof PrimitiveType) {
			name = ((PrimitiveType) type).getInstanceClassName();
			classifiers = EcorePackage.eINSTANCE.getEClassifiers();
		} else if (type instanceof EClass) {
			name = ((EClass) type).getInstanceClassName();
			classifiers = context.getEPackage().getEClassifiers();
		} else if (type instanceof CollectionType) {
			name = ((CollectionType) type).getElementType()
					.getInstanceClassName();
			classifiers = context.getEPackage().getEClassifiers();
		} else {
			name = type.getClass().getName();
			classifiers = EcorePackage.eINSTANCE.getEClassifiers();
		}
		for (final EClassifier classifier : classifiers) {
			final String instanceClassName = classifier.getInstanceClassName();
			if (instanceClassName.equals(name)) {
				result = classifier;
				break;
			}
		}

		return result;
	}

	/**
	 * Compare the two types and return if they are equivalents.
	 * 
	 * @param firstType
	 *            the first {@link EClassifier} to compare.
	 * @param secondType
	 *            the second {@link EClassifier} to compare.
	 * @return true if they are equivalents.
	 */
	public static boolean compareClassifierTypes(final EClassifier firstType,
			final EClassifier secondType) {
		boolean result = false;
		if (firstType.getName().equals(secondType.getName())) {
			result = true;
		} else if (firstType.getName().contains(secondType.getName())
				|| secondType.getName().contains(firstType.getName())) {
			result = true;
		}

		return result;
	}

	/**
	 * @param exp
	 * @return
	 */
	public static Object getExpressionType(
			final OCLExpression<?> expression) {
		Object result = null;
		
		if (expression instanceof IteratorExp<?, ?>) {
			final Object type = ((IteratorExp<?, ?>) expression).getType();
			result = ((CollectionType) type).getElementType();
		} else {
			result = expression.getType();
		}
		
		return result;
	}
}
