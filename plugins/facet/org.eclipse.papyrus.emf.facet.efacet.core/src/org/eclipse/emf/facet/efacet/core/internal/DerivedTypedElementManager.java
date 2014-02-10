/**
 * Copyright (c) 2011, 2012, 2013 Mia-Software.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Gregoire Dupe (Mia-Software) - Bug 333553 - The user has not to deal with two files to create a facet
 *  Emmanuelle Rouillé (Mia-Software) - Bug 352618 - To be able to use non derived facet structural features and save them values.
 *  Nicolas Bros (Mia-Software) - Bug 361612 - New core for new version of the Facet metamodel
 *  Nicolas Bros (Mia-Software) - Bug 362191 - [Restructuring] Query mechanism for eFacet2
 *  Gregoire Dupe (Mia-Software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 *  Gregoire Dupe (Mia-Software) - Bug 364325 - [Restructuring] The user must be able to navigate into a model using the Facet.
 *  Gregoire Dupe (Mia-Software) - Bug 373078 - API Cleaning
 *  Nicolas Bros (Mia-Software) - Bug 376941 - [EFacet] Facet operation arguments in Facet model
 *  Alban Ménager (Soft-Maint) - Bug 387470 - [EFacet][Custom] Editors
 *  Gregoire Dupe (Mia-Software) - Bug 418885 - ETypedElementSwitchQuery implemented using a deprecated query evaluator extension point
 */
package org.eclipse.emf.facet.efacet.core.internal;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.efacet.core.IDerivedTypedElementManager;
import org.eclipse.emf.facet.efacet.core.IFacetManager;
import org.eclipse.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.emf.facet.efacet.core.internal.exception.DerivedTypedElementEvaluationException;
import org.eclipse.emf.facet.efacet.core.internal.exception.DerivedTypedElementTypeCheckingException;
import org.eclipse.emf.facet.efacet.core.internal.exception.UnmatchingExpectedTypeException;
import org.eclipse.emf.facet.efacet.core.internal.query.DerivedTypedElementImplementationFactoryRegistry;
import org.eclipse.emf.facet.efacet.core.internal.query.QueryImplementationFactoryRegistry;
import org.eclipse.emf.facet.efacet.core.internal.query.QueryUtils;
import org.eclipse.emf.facet.efacet.core.query.IDerivedTypedElementImplementation;
import org.eclipse.emf.facet.efacet.core.query.IQueryImplementation;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.DerivedTypedElement;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.ParameterValue;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.ETypedElementResult;
import org.eclipse.emf.facet.util.core.Logger;

public class DerivedTypedElementManager implements IDerivedTypedElementManager {

	public Object evaluate(final DerivedTypedElement derivedTypedElement,
			final EObject source, final List<ParameterValue> parameterValues,
			final IFacetManager facetManager)
			throws DerivedTypedElementException {
		Object result;
		if (derivedTypedElement.isMany()) {
			result = evaluateMultiValued(derivedTypedElement, source, parameterValues, null, facetManager);
		} else {
			result = evaluateSingleValued(derivedTypedElement, source, parameterValues, null, facetManager);
		}
		return result;
	}

	public Object evaluate(final Query query, final EObject source, final List<ParameterValue> parameterValues, final IFacetManager facetManager)
			throws DerivedTypedElementException {
		final IQueryImplementation evaluator = QueryImplementationFactoryRegistry.INSTANCE.getEvaluatorFor(query, this);
		final DerivedTypedElement derivedTE = QueryUtils.getOwningDerivedTypedElement(query);
		Object result;
		try {
			result = evaluator.getValue(query, derivedTE, source, parameterValues, facetManager);
		} catch (Exception e) {
			throw new DerivedTypedElementEvaluationException(e);
		}
		return result;
	}

	public <T> T evaluateSingleValued(final DerivedTypedElement derivedTypedElement,
			final EObject source, final List<ParameterValue> parameterValues, final Class<T> expectedType, final IFacetManager facetManager)
			throws DerivedTypedElementException {
		if (derivedTypedElement.isMany()) {
			throw new IllegalArgumentException("This method doesn't accept a multi-valued derived typed element."); //$NON-NLS-1$
		}

		Query query = derivedTypedElement.getQuery();
		if (query == null) {
			throw new DerivedTypedElementException("The given derived typed element doesn't contain a query"); //$NON-NLS-1$
		}
		Object queryResult = evaluate(derivedTypedElement, source, parameterValues, facetManager, query);

		// expectedResultType == null means match everything
		// And a null value for queryResult matches any type
		if (expectedType != null && queryResult != null && !expectedType.isInstance(queryResult)) {
			Exception e1 = new UnmatchingExpectedTypeException(
					"The derived typed element did not evaluate to the expected type", expectedType, queryResult); //$NON-NLS-1$
			throw new DerivedTypedElementException(e1);
		}
		// just checked
		@SuppressWarnings("unchecked")
		T typedQueryResult = (T) queryResult;
		return typedQueryResult;
	}

	public <T> List<T> evaluateMultiValued(final DerivedTypedElement derivedTypedElement,
			final EObject source, final List<ParameterValue> parameterValues, final Class<T> expectedType, final IFacetManager facetManager)
			throws DerivedTypedElementException {
		if (!derivedTypedElement.isMany()) {
			throw new IllegalArgumentException("This method doesn't accept a single-valued derived typed element."); //$NON-NLS-1$
		}

		Query query = derivedTypedElement.getQuery();
		if (query == null) {
			throw new DerivedTypedElementException("The given derived typed element doesn't contain a query"); //$NON-NLS-1$
		}
		Object queryResult = evaluate(derivedTypedElement, source, parameterValues, facetManager, query);
		queryResult = setAsList(queryResult);
		List<T> result;
		if (queryResult instanceof List<?>) {
			List<?> queryListResult = (List<?>) queryResult;
			for (Object queryResultElement : queryListResult) {
				// expectedType == null means match everything
				// And a null queryResultElement for queryResult matches any type
				if (expectedType != null && queryResultElement != null && !expectedType.isInstance(queryResultElement)) {
					Exception e1 = new UnmatchingExpectedTypeException(
							"The derived typed element did not evaluate to the expected type"); //$NON-NLS-1$
					throw new DerivedTypedElementException(e1);
				}
			}
			// just checked
			@SuppressWarnings("unchecked")
			List<T> typedQueryListResult = (List<T>) queryListResult;
			result = typedQueryListResult;
		} else {
			throw new DerivedTypedElementException("The given multi-valued derived typed element did not evaluate to a List."); //$NON-NLS-1$
		}
		return result;
	}

	protected Object evaluate(final DerivedTypedElement derivedTE, final EObject source, final List<ParameterValue> parameterValues,
			final IFacetManager facetManager, final Query query) throws DerivedTypedElementException {
		Object queryResult;
		IQueryImplementation evaluator = null;
		IDerivedTypedElementImplementation evaluator2 = null;
		try {
			evaluator = QueryImplementationFactoryRegistry.INSTANCE.getEvaluatorFor(query, this);
		} catch (DerivedTypedElementException exc) {
			final String message = String.format(
					"%s will try to use a deprected implementation", //$NON-NLS-1$
					this.getClass().getName());
			Logger.logError(exc, message, Activator.getDefault());
			evaluator2 = DerivedTypedElementImplementationFactoryRegistry.INSTANCE.getEvaluatorFor(query, this);
		}
		if (evaluator == null) {
			queryResult = evaluateAndCheck(derivedTE, source, parameterValues, evaluator2, facetManager);
		} else {
			queryResult = evaluateAndCheck(derivedTE.getQuery(), source, parameterValues, evaluator, facetManager);
		}
		return queryResult;
	}

	/** @deprecated support for the deprecated {@link IDerivedTypedElementImplementation} */
	@Deprecated
	private static Object evaluateAndCheck(final DerivedTypedElement derivedTE, final EObject source,
			final List<ParameterValue> parameterValues, final IDerivedTypedElementImplementation evaluator, final IFacetManager facetManager)
			throws DerivedTypedElementException {
		Query query = derivedTE.getQuery();
		checkQuery(query, source);
		Object result;
		try {
			result = evaluator.getValue(derivedTE, source, parameterValues, facetManager);
		} catch (Throwable e) {
			if (e instanceof DerivedTypedElementEvaluationException) {
				throw (DerivedTypedElementEvaluationException) e;
			}
			throw new DerivedTypedElementEvaluationException(e);
		}
		// result = setAsList(result);
		// gdupe: I don't understand why the result is wrapped in a list
		checkResult(query, result, evaluator.getCheckResultType(),
				isPrimitive(QueryUtils.getReturnType(query)));
		return result;
	}
	
	private static Object evaluateAndCheck(final Query query, final EObject source, final List<ParameterValue> parameterValues,
			final IQueryImplementation evaluator, final IFacetManager facetManager)
			throws DerivedTypedElementException {
		checkQuery(query, source);
		Object result;
		try {
			result = evaluator.getValue(query, QueryUtils.getOwningDerivedTypedElement(query), source, parameterValues, facetManager);
		} catch (Throwable e) {
			if (e instanceof DerivedTypedElementEvaluationException) {
				throw (DerivedTypedElementEvaluationException) e;
			}
			throw new DerivedTypedElementEvaluationException(e);
		}
		checkResult(query, result, evaluator.isCheckResultType(), isPrimitive(QueryUtils.getReturnType(query)));
		return result;
	}

	private static void checkQuery(final Query query, final EObject source) throws DerivedTypedElementException {
		if (query == null) {
			throw new IllegalArgumentException("query cannot be null"); //$NON-NLS-1$
		}
		
		EClassifier sourceType = QueryUtils.getSourceType(query);
		if (sourceType == null && source != null) {
			throw new DerivedTypedElementException("the query's sourceType is null and the source is not null"); //$NON-NLS-1$
		}
		
		// a null value for eObject matches any type
		if (sourceType != null && source != null && !sourceType.isInstance(source)) {
			StringBuffer message = new StringBuffer();
			message.append("Wrong source type (for " + QueryUtils.getQueryDescription(query) + "): '"); //$NON-NLS-1$ //$NON-NLS-2$
			message.append(source.eClass().getName());
			message.append("' found; expected '"); //$NON-NLS-1$
			message.append(sourceType.getName());
			message.append("'."); //$NON-NLS-1$
			throw new DerivedTypedElementTypeCheckingException(message.toString());
		}
	}

	// public List<? extends AbstractDerivedTypedElementResult> evaluate(final DerivedTypedElement
	// derivedTypedElement, final Collection<EObject> sources,
	// final List<ParameterValue> parameterValues) throws DerivedTypedElementException {
	// if (derivedTypedElement.isMany()) {
	// try {
	// return evaluateSingleValued(derivedTypedElement, sources, parameterValues, null);
	// } catch (UnmatchingExpectedTypeException e) {
	// // should never happen
	//				throw new IllegalStateException("Unexpected error"); //$NON-NLS-1$
	// }
	// } else {
	// try {
	// return evaluateMultiValued(derivedTypedElement, sources, parameterValues, null);
	// } catch (UnmatchingExpectedTypeException e) {
	// // should never happen
	//				throw new IllegalStateException("Unexpected error"); //$NON-NLS-1$
	// }
	// }
	// }
	
	
	// batch evaluation disabled : Bug 365429 - DerivedTypedElementManager : re-implement batch evaluation 

	public <T extends ETypedElementResult> List<T> batchEvaluate(final DerivedTypedElement derivedTypedElement,
			final Collection<? extends EObject> sources, final List<ParameterValue> parameterValues, final Class<T> expectedType, final IFacetManager facetManager)
			throws DerivedTypedElementException {
		
		throw new UnsupportedOperationException("not implemented yet"); //$NON-NLS-1$

//		if (derivedTypedElement == null) {
//			throw new IllegalArgumentException("The given derived typed element must not be null"); //$NON-NLS-1$
//		}
//
//		List<T> abstractResultList;
//
//		Query query = derivedTypedElement.getQuery();
//		if (query == null) {
//			throw new DerivedTypedElementException("The given derived typed element doesn't contain a query"); //$NON-NLS-1$
//		}
//		EClassifier eType = derivedTypedElement.getEType();
//		if (eType == null) {
//			throw new DerivedTypedElementException("The given derived typed element has a null type"); //$NON-NLS-1$
//		}
//		IDerivedTypedElementImplementation evaluator = DerivedTypedElementImplementationFactoryRegistry.INSTANCE.getEvaluatorFor(query);
//		if (evaluator == null) {
//			throw new DerivedTypedElementEvaluationException("No evaluator was found for a query of type " + query.getClass().getName()); //$NON-NLS-1$
//		}
//
//		final boolean primitiveType = isPrimitive(eType);
//
//		// if the evaluator implements multiple evaluation itself, then use it
//		if (evaluator instanceof IDerivedTypedElementCollectionImplementation) {
//			IDerivedTypedElementCollectionImplementation collectionEvaluator = (IDerivedTypedElementCollectionImplementation) evaluator;
//			if (derivedTypedElement.isMany()) {
//				if (primitiveType) {
//					if (expectedType != DerivedTypedElementPrimitiveTypeListResult.class) {
//						throw new UnmatchingExpectedTypeException("The derivedTypedElement is multi-valued, and its type is primitive, " + //$NON-NLS-1$
//								"so expectedType must be " + DerivedTypedElementPrimitiveTypeListResult.class.getSimpleName()); //$NON-NLS-1$
//					}
//					List<DerivedTypedElementPrimitiveTypeListResult<?>> listResultList = batchEvaluateMultiValuedPrimitiveDerivedTypedElementWithCollectionEvaluator(
//							derivedTypedElement, sources, parameterValues, collectionEvaluator);
//					// we just checked the type parameter T through expectedType
//					@SuppressWarnings("unchecked")
//					List<T> castList = (List<T>) listResultList;
//					abstractResultList = castList;
//				} else {
//					if (expectedType != DerivedTypedElementEObjectListResult.class) {
//						throw new UnmatchingExpectedTypeException("The derivedTypedElement is multi-valued, and it returns model elements, " + //$NON-NLS-1$
//								"so expectedType must be " + DerivedTypedElementEObjectListResult.class.getSimpleName()); //$NON-NLS-1$
//					}
//					List<DerivedTypedElementEObjectListResult<?>> listResultList = batchEvaluateMultiValuedEObjectDerivedTypedElementWithCollectionEvaluator(
//							derivedTypedElement, sources, parameterValues, collectionEvaluator);
//					// we just checked the type parameter T through expectedType
//					@SuppressWarnings("unchecked")
//					List<T> castList = (List<T>) listResultList;
//					abstractResultList = castList;
//				}
//			} else {
//				if (primitiveType) {
//					if (expectedType != DerivedTypedElementPrimitiveTypeResult.class) {
//						throw new UnmatchingExpectedTypeException("The derivedTypedElement is single-valued, and its type is primitive, " + //$NON-NLS-1$
//								"so expectedType must be " + DerivedTypedElementPrimitiveTypeResult.class.getSimpleName()); //$NON-NLS-1$
//					}
//					List<DerivedTypedElementPrimitiveTypeResult<?>> resultList = batchEvaluateSingleValuedPrimitiveDerivedTypedElementWithCollectionEvaluator(
//							derivedTypedElement, sources, parameterValues, collectionEvaluator);
//					// we just checked the type parameter T through expectedType
//					@SuppressWarnings("unchecked")
//					List<T> castList = (List<T>) resultList;
//					abstractResultList = castList;
//				} else {
//					if (expectedType != DerivedTypedElementEObjectResult.class) {
//						throw new UnmatchingExpectedTypeException("The derivedTypedElement is single-valued, and it returns a model element, " + //$NON-NLS-1$
//								"so expectedType must be " + DerivedTypedElementEObjectResult.class.getSimpleName()); //$NON-NLS-1$
//					}
//					List<DerivedTypedElementEObjectResult<?>> resultList = batchEvaluateSingleValuedEObjectDerivedTypedElementWithCollectionEvaluator(
//							derivedTypedElement, sources, parameterValues, collectionEvaluator);
//					// we just checked the type parameter T through expectedType
//					@SuppressWarnings("unchecked")
//					List<T> castList = (List<T>) resultList;
//					abstractResultList = castList;
//				}
//			}
//
//		} else {
//			// otherwise, do multiple evaluation by calling the evaluator's
//			// single evaluation multiple times
//
//			if (derivedTypedElement.isMany()) {
//				if (primitiveType) {
//					if (expectedType != DerivedTypedElementPrimitiveTypeListResult.class) {
//						throw new UnmatchingExpectedTypeException("The derivedTypedElement is multi-valued, and its type is primitive, " + //$NON-NLS-1$
//								"so expectedType must be " + DerivedTypedElementPrimitiveTypeListResult.class.getSimpleName()); //$NON-NLS-1$
//					}
//					List<DerivedTypedElementPrimitiveTypeListResult<?>> listResultList = batchEvaluateMultiValuedPrimitiveDerivedTypedElementWithSimpleEvaluator(
//							derivedTypedElement, sources, parameterValues, evaluator);
//					@SuppressWarnings("unchecked")
//					List<T> castList = (List<T>) listResultList;
//					abstractResultList = castList;
//				} else {
//					if (expectedType != DerivedTypedElementEObjectListResult.class) {
//						throw new UnmatchingExpectedTypeException("The derivedTypedElement is multi-valued, and it returns model elements, " + //$NON-NLS-1$
//								"so expectedType must be " + DerivedTypedElementEObjectListResult.class.getSimpleName()); //$NON-NLS-1$
//					}
//					List<DerivedTypedElementEObjectListResult<?>> listResultList = batchEvaluateMultiValuedEObjectDerivedTypedElementWithSimpleEvaluator(
//							derivedTypedElement, sources, parameterValues, evaluator);
//					@SuppressWarnings("unchecked")
//					List<T> castList = (List<T>) listResultList;
//					abstractResultList = castList;
//				}
//			} else {
//				if (primitiveType) {
//					if (expectedType != DerivedTypedElementPrimitiveTypeResult.class) {
//						throw new UnmatchingExpectedTypeException("The derivedTypedElement is single-valued, and its type is primitive, " + //$NON-NLS-1$
//								"so expectedType must be " + DerivedTypedElementPrimitiveTypeResult.class.getSimpleName()); //$NON-NLS-1$
//					}
//					List<DerivedTypedElementPrimitiveTypeResult<?>> resultList = batchEvaluateSingleValuedPrimitiveDerivedTypedElementWithSimpleCollectionEvaluator(
//							derivedTypedElement, sources, parameterValues, evaluator);
//					@SuppressWarnings("unchecked")
//					List<T> castList = (List<T>) resultList;
//					abstractResultList = castList;
//				} else {
//					if (expectedType != DerivedTypedElementEObjectResult.class) {
//						throw new UnmatchingExpectedTypeException("The derivedTypedElement is single-valued, and it returns a model element, " + //$NON-NLS-1$
//								"so expectedType must be " + DerivedTypedElementEObjectResult.class.getSimpleName()); //$NON-NLS-1$
//					}
//					List<DerivedTypedElementEObjectResult<?>> resultList = batchEvaluateSingleValuedEObjectDerivedTypedElementWithSimpleCollectionEvaluator(
//							derivedTypedElement, sources, parameterValues, null);
//					@SuppressWarnings("unchecked")
//					List<T> castList = (List<T>) resultList;
//					abstractResultList = castList;
//				}
//			}
//		}
//		return abstractResultList;
	}

//	private static List<DerivedTypedElementPrimitiveTypeListResult<?>> batchEvaluateMultiValuedPrimitiveDerivedTypedElementWithCollectionEvaluator(
//			final DerivedTypedElement derivedTypedElement, final Collection<EObject> sources, final List<ParameterValue> parameterValues,
//			final IDerivedTypedElementCollectionImplementation collectionEvaluator)
//			throws DerivedTypedElementException {
//
//		List<? extends AbstractDerivedTypedElementResult> listResultList = collectionEvaluator
//				.getValues(derivedTypedElement, sources, parameterValues);
//
//		// check the return type from the evaluator in order to be able to cast safely
//		for (int index = 0; index < listResultList.size(); index++) {
//			AbstractDerivedTypedElementResult elementResult = listResultList.get(index);
//			if (elementResult instanceof DerivedTypedElementPrimitiveTypeListResult<?>) {
//				DerivedTypedElementPrimitiveTypeListResult<?> derivedTypedElementPrimitiveTypeListResult = (DerivedTypedElementPrimitiveTypeListResult<?>) elementResult;
//				checkResult(derivedTypedElement.getQuery(), derivedTypedElementPrimitiveTypeListResult.getResultList(),
//						collectionEvaluator.getCheckResultType());
//			} else {
//				throw new DerivedTypedElementEvaluationException(ErrorHandlingUtils.buildWrongTypeMessage(
//						"Wrong element type at index " + index + " in the result from the evaluator: " + collectionEvaluator.getClass().getName(), //$NON-NLS-1$//$NON-NLS-2$
//						DerivedTypedElementPrimitiveTypeListResult.class, elementResult));
//			}
//		}
//
//		// just checked
//		@SuppressWarnings("unchecked")
//		List<DerivedTypedElementPrimitiveTypeListResult<?>> result = (List<DerivedTypedElementPrimitiveTypeListResult<?>>) listResultList;
//		return result;
//	}
//
//	private static List<DerivedTypedElementEObjectListResult<?>> batchEvaluateMultiValuedEObjectDerivedTypedElementWithCollectionEvaluator(
//			final DerivedTypedElement derivedTypedElement, final Collection<EObject> sources, final List<ParameterValue> parameterValues,
//			final IDerivedTypedElementCollectionImplementation collectionEvaluator)
//			throws DerivedTypedElementException {
//		List<? extends AbstractDerivedTypedElementResult> listResultList = collectionEvaluator
//				.getValues(derivedTypedElement, sources, parameterValues);
//
//		// check the return type from the evaluator in order to be able to cast safely
//		for (int index = 0; index < listResultList.size(); index++) {
//			AbstractDerivedTypedElementResult elementResult = listResultList.get(index);
//			if (elementResult instanceof DerivedTypedElementEObjectListResult<?>) {
//				DerivedTypedElementEObjectListResult<?> derivedTypedElementEObjectListResult = (DerivedTypedElementEObjectListResult<?>) elementResult;
//				checkResult(derivedTypedElement.getQuery(), derivedTypedElementEObjectListResult.getResultList(),
//						collectionEvaluator.getCheckResultType());
//			} else {
//				throw new DerivedTypedElementEvaluationException(ErrorHandlingUtils.buildWrongTypeMessage(
//						"Wrong element type at index " + index + " in the result from the evaluator: " + collectionEvaluator.getClass().getName(), //$NON-NLS-1$//$NON-NLS-2$
//						DerivedTypedElementEObjectListResult.class, elementResult));
//			}
//		}
//
//		// just checked
//		@SuppressWarnings("unchecked")
//		List<DerivedTypedElementEObjectListResult<?>> result = (List<DerivedTypedElementEObjectListResult<?>>) listResultList;
//		return result;
//	}
//
//	private static List<DerivedTypedElementPrimitiveTypeResult<?>> batchEvaluateSingleValuedPrimitiveDerivedTypedElementWithCollectionEvaluator(
//			final DerivedTypedElement derivedTypedElement, final Collection<EObject> sources, final List<ParameterValue> parameterValues,
//			final IDerivedTypedElementCollectionImplementation collectionEvaluator)
//			throws DerivedTypedElementException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	private static List<DerivedTypedElementEObjectResult<?>> batchEvaluateSingleValuedEObjectDerivedTypedElementWithCollectionEvaluator(
//			final DerivedTypedElement derivedTypedElement, final Collection<EObject> sources, final List<ParameterValue> parameterValues,
//			final IDerivedTypedElementCollectionImplementation collectionEvaluator) throws DerivedTypedElementException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	private static List<DerivedTypedElementPrimitiveTypeListResult<?>> batchEvaluateMultiValuedPrimitiveDerivedTypedElementWithSimpleEvaluator(
//			final DerivedTypedElement derivedTypedElement, final Collection<EObject> sources, final List<ParameterValue> parameterValues,
//			final IDerivedTypedElementImplementation evaluator) {
//
//		Query query = derivedTypedElement.getQuery();
//
//		List<DerivedTypedElementPrimitiveTypeListResult<?>> listResultList = new ArrayList<DerivedTypedElementPrimitiveTypeListResult<?>>();
//		for (EObject eObject : sources) {
//			DerivedTypedElementPrimitiveTypeListResult<Object> primitiveTypeListResult = EFacetFactory.eINSTANCE
//					.createDerivedTypedElementPrimitiveTypeListResult();
//
//			Throwable error = null;
//			try {
//				primitiveTypeListResult.setSource(eObject);
//				primitiveTypeListResult.setDerivedTypedElement(derivedTypedElement);
//				setParameterValues(primitiveTypeListResult.getParameterValues(), parameterValues);
//				checkSourceType(query.getSourceType(), query, eObject);
//			} catch (Throwable e) {
//				error = e;
//			}
//			if (error != null) {
//				primitiveTypeListResult.setException(error);
//			} else {
//				try {
//					Object evaluationResult = evaluator.getValue(derivedTypedElement, eObject, parameterValues);
//					checkResult(query, evaluationResult, evaluator.getCheckResultType());
//					// checked by checkResult
//					Collection<?> evaluationResultCollection = (Collection<?>) evaluationResult;
//					for (Object object : evaluationResultCollection) {
//						primitiveTypeListResult.getResultList().add(object);
//					}
//				} catch (Throwable e) {
//					primitiveTypeListResult.setException(e);
//				}
//			}
//			listResultList.add(primitiveTypeListResult);
//
//		}
//		return listResultList;
//	}
//
//	private static List<DerivedTypedElementEObjectListResult<?>> batchEvaluateMultiValuedEObjectDerivedTypedElementWithSimpleEvaluator(
//			final DerivedTypedElement derivedTypedElement, final Collection<EObject> sources, final List<ParameterValue> parameterValues,
//			final IDerivedTypedElementImplementation evaluator) {
//		Query query = derivedTypedElement.getQuery();
//
//		List<DerivedTypedElementEObjectListResult<?>> listResultList = new ArrayList<DerivedTypedElementEObjectListResult<?>>();
//		for (EObject eObject : sources) {
//			DerivedTypedElementEObjectListResult<EObject> eObjectListResult = EFacetFactory.eINSTANCE
//					.createDerivedTypedElementEObjectListResult();
//
//			Throwable error = null;
//			try {
//				eObjectListResult.setSource(eObject);
//				eObjectListResult.setDerivedTypedElement(derivedTypedElement);
//				setParameterValues(eObjectListResult.getParameterValues(), parameterValues);
//				checkSourceType(query.getSourceType(), query, eObject);
//			} catch (Throwable e) {
//				error = e;
//			}
//			if (error != null) {
//				eObjectListResult.setException(error);
//			} else {
//				try {
//					Object evaluationResult = evaluator.getValue(derivedTypedElement, eObject, parameterValues);
//					checkResult(query, evaluationResult, evaluator.getCheckResultType(), false);
//					// checked by checkResult
//					@SuppressWarnings("unchecked")
//					Collection<? extends EObject> evaluationResultCollection = (Collection<? extends EObject>) evaluationResult;
//					for (EObject e : evaluationResultCollection) {
//						eObjectListResult.getResultList().add(e);
//					}
//				} catch (Throwable e) {
//					eObjectListResult.setException(e);
//				}
//			}
//			listResultList.add(eObjectListResult);
//
//		}
//		return listResultList;
//	}
//
//	private static List<DerivedTypedElementPrimitiveTypeResult<?>> batchEvaluateSingleValuedPrimitiveDerivedTypedElementWithSimpleCollectionEvaluator(
//			final DerivedTypedElement derivedTypedElement, final Collection<EObject> sources, final List<ParameterValue> parameterValues,
//			final IDerivedTypedElementImplementation evaluator)
//			throws DerivedTypedElementException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	private static List<DerivedTypedElementEObjectResult<?>> batchEvaluateSingleValuedEObjectDerivedTypedElementWithSimpleCollectionEvaluator(
//			final DerivedTypedElement derivedTypedElement, final Collection<EObject> sources, final List<ParameterValue> parameterValues,
//			final IDerivedTypedElementImplementation evaluator)
//			throws DerivedTypedElementException {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	public <T> List<DerivedTypedElementListResult<T>> evaluateMultiValued(final DerivedTypedElement derivedTypedElement,
//			final Collection<? extends EObject> sources, final List<ParameterValue> parameterValues,
//			final Class<T> expectedType)
//			throws DerivedTypedElementException, UnmatchingExpectedTypeException {
//		if (!derivedTypedElement.isMany()) {
//			throw new IllegalArgumentException("This method doesn't accept a single-valued derived typed element."); //$NON-NLS-1$
//		}
//
//		Query query = derivedTypedElement.getQuery();
//		if (query == null) {
//			throw new DerivedTypedElementException("The given derived typed element doesn't contain a query"); //$NON-NLS-1$
//		}
//		IDerivedTypedElementImplementation evaluator =
//				DerivedTypedElementImplementationFactoryRegistry.INSTANCE.getEvaluatorFor(query);
//
//		List<?> queryResult = batchEvaluateAndCheck(derivedTypedElement, sources, parameterValues,
//				evaluator);
//		// Java doesn't support co- or contra-variance on generics,
//		// so we can't return the right type
//		@SuppressWarnings("unchecked")
//		List<DerivedTypedElementListResult<T>> multiResultList =
//				(List<DerivedTypedElementListResult<T>>) queryResult;
//
//		// check each result element in each result list
//		if (expectedType != null) {
//			int sourceIndex = 0;
//			for (DerivedTypedElementListResult<?> derivedTypedElementResult : multiResultList) {
//				EList<?> resultList = derivedTypedElementResult.getResultList();
//				int index = 0;
//				for (Object resultElement : resultList) {
//					// a null value for resultElement matches any type
//					if (resultElement != null && !expectedType.isInstance(resultElement)) {
//						throw new UnmatchingExpectedTypeException(
//								"The element at index " + index + " in the list that resulted from the evaluation of the multi-valued " //$NON-NLS-1$ //$NON-NLS-2$
//										+ "derived typed element does not match the expected type " //$NON-NLS-1$
//										+ "for the source element at index " + sourceIndex, expectedType, resultElement); //$NON-NLS-1$
//					}
//					index++;
//				}
//				sourceIndex++;
//			}
//		}
//		return multiResultList;
//	}
//
//	private static List<?> batchEvaluateAndCheck(final DerivedTypedElement derivedTypedElement,
//			final Collection<EObject> eObjects,
//			final List<ParameterValue> parameterValues, final IDerivedTypedElementImplementation
//			evaluator)
//			throws DerivedTypedElementException {
//		List<?> result;
//
//		Query query = derivedTypedElement.getQuery();
//		if (query == null) {
//			throw new IllegalArgumentException("the query cannot be null"); //$NON-NLS-1$
//		}
//
//		EClassifier sourceType = query.getSourceType();
//
//		final boolean primitiveType = derivedTypedElement instanceof EAttribute;
//
//		if (derivedTypedElement.isMany()) {
//			if (evaluator instanceof IDerivedTypedElementCollectionImplementation) {
//				IDerivedTypedElementCollectionImplementation collectionEvaluator =
//						(IDerivedTypedElementCollectionImplementation) evaluator;
//				// List<? extends AbstractDerivedTypedElementResult> listResultList =
//				// collectionEvaluator
//				// .getValues(derivedTypedElement, eObjects, parameterValues);
//				// int index = 0;
//				// for (AbstractDerivedTypedElementResult listResult : listResultList) {
//				// EList<?> resultList;
//				// if (primitiveType && listResult instanceof
//				// DerivedTypedElementPrimitiveTypeListResult<?>) {
//				// DerivedTypedElementPrimitiveTypeListResult<?> primitiveListResult =
//				// (DerivedTypedElementPrimitiveTypeListResult<?>) listResult;
//				// resultList = primitiveListResult.getResultList();
//				// } else if (!primitiveType && listResult instanceof
//				// DerivedTypedElementEObjectListResult<?>) {
//				// DerivedTypedElementEObjectListResult<?> eObjectListResult =
//				// (DerivedTypedElementEObjectListResult<?>) listResult;
//				// resultList = eObjectListResult.getResultList();
//				// } else {
//				// throw new DerivedTypedElementEvaluationException(
//				//								"Wrong element type at index " + index + " in the result from the evaluator " + collectionEvaluator.getClass().getName()); //$NON-NLS-1$//$NON-NLS-2$
//				// }
//				// checkResult(query, resultList, evaluator.getCheckResultType());
//				// index++;
//				// }
//				// result = listResultList;
//			} else {
//
//				// List<AbstractDerivedTypedElementResult> listResultList = new
//				// ArrayList<AbstractDerivedTypedElementResult>();
//				// for (EObject eObject : eObjects) {
//				// AbstractDerivedTypedElementResult listResult;
//				// List<?> resultList;
//				// if (primitiveType) {
//				// DerivedTypedElementPrimitiveTypeListResult<?> primitiveTypeListResult =
//				// EFacetFactory.eINSTANCE
//				// .createDerivedTypedElementPrimitiveTypeListResult();
//				// listResult = primitiveTypeListResult;
//				// resultList = primitiveTypeListResult.getResultList();
//				// } else {
//				// DerivedTypedElementEObjectListResult<?> eObjectTypeListResult =
//				// EFacetFactory.eINSTANCE
//				// .createDerivedTypedElementEObjectListResult();
//				// listResult = eObjectTypeListResult;
//				// resultList = eObjectTypeListResult.getResultList();
//				// }
//				//
//				// Throwable error = null;
//				// try {
//				// listResult.setSource(eObject);
//				// listResult.setDerivedTypedElement(derivedTypedElement);
//				// setParameterValues(listResult.getParameterValues(), parameterValues);
//				// checkSourceType(sourceType, query, eObject);
//				// } catch (Throwable e) {
//				// error = e;
//				// }
//				// if (error != null) {
//				// listResult.setException(error);
//				// } else {
//				// try {
//				// Object evaluationResult = evaluator.getValue(derivedTypedElement, eObject,
//				// parameterValues);
//				// checkResult(query, evaluationResult, evaluator.getCheckResultType());
//				// // checked by checkResult
//				// Collection<?> evaluationResultCollection = (Collection<?>) evaluationResult;
//				// for (Object object : evaluationResultCollection) {
//				// resultList.add(object);
//				// }
//				// } catch (Throwable e) {
//				// listResult.setException(e);
//				// }
//				// }
//				// listResultList.add(listResult);
//				//
//				// }
//				// result = listResultList;
//
//			}
//		} else {
//			// if the evaluator implements multiple evaluation itself, then use it
//			if (evaluator instanceof IDerivedTypedElementCollectionImplementation) {
//				IDerivedTypedElementCollectionImplementation collectionEvaluator =
//						(IDerivedTypedElementCollectionImplementation) evaluator;
//				List<? extends AbstractDerivedTypedElementResult> singleResultList = collectionEvaluator
//						.getValues(derivedTypedElement, eObjects, parameterValues);
//				int index = 0;
//				for (AbstractDerivedTypedElementResult singleResult : singleResultList) {
//					Object resultElement;
//					if (primitiveType && singleResult instanceof DerivedTypedElementPrimitiveTypeResult<?>) {
//						DerivedTypedElementPrimitiveTypeResult<?> primitiveResult =
//								(DerivedTypedElementPrimitiveTypeResult<?>) singleResult;
//						resultElement = primitiveResult.getResult();
//					} else if (!primitiveType && singleResult instanceof DerivedTypedElementEObjectResult<?>) {
//						DerivedTypedElementEObjectResult<?> eObjectResult = (DerivedTypedElementEObjectResult<?>)
//								singleResult;
//						resultElement = eObjectResult.getResult();
//					} else {
//						throw new DerivedTypedElementEvaluationException(
//								"Wrong element type at index " + index + " in the result from the evaluator " + collectionEvaluator.getClass().getName()); //$NON-NLS-1$//$NON-NLS-2$
//					}
//					checkResult(query, result, evaluator.getCheckResultType());
//					index++;
//				}
//			} else {
//				// otherwise, do multiple evaluation by calling the evaluator's
//				// single evaluation multiple times
//				List<DerivedTypedElementResult<?>> resultList = new
//						ArrayList<DerivedTypedElementResult<?>>();
//				for (EObject eObject : eObjects) {
//					DerivedTypedElementResult<Object> singleResult =
//							EFacetFactory.eINSTANCE.createDerivedTypedElementResult();
//					Throwable error = null;
//					try {
//						singleResult.setSource(eObject);
//						singleResult.setDerivedTypedElement(derivedTypedElement);
//						setParameterValues(singleResult.getParameterValues(), parameterValues);
//						checkSourceType(sourceType, query, eObject);
//					} catch (Throwable e) {
//						error = e;
//					}
//					if (error != null) {
//						singleResult.setException(error);
//					} else {
//						try {
//							Object evaluationResult = evaluator.getValue(derivedTypedElement, eObject, parameterValues);
//							checkResult(query, evaluationResult, evaluator.getCheckResultType());
//							singleResult.setResult(evaluationResult);
//						} catch (Throwable e) {
//							singleResult.setException(e);
//						}
//					}
//					resultList.add(singleResult);
//				}
//				result = resultList;
//			}
//		}
//
//		return result;
//	}

//	private static void checkSourceType(final EClassifier sourceType, final Query query, final EObject eObject)
//			throws DerivedTypedElementException {
//		if (sourceType != null) {
//			// a null value for eObject matches any type
//			if (eObject != null && !sourceType.isInstance(eObject)) {
//				StringBuffer message = new StringBuffer();
//				message.append("Wrong source type (for " + QueryUtils.getQueryDescription(query) + "): '"); //$NON-NLS-1$ //$NON-NLS-2$
//				message.append(eObject.eClass().getName());
//				message.append("' found; expected '"); //$NON-NLS-1$
//				message.append(sourceType.getName());
//				message.append("'."); //$NON-NLS-1$
//				throw new DerivedTypedElementTypeCheckingException(message.toString());
//			}
//		} else {
//			if (eObject != null) {
//				throw new DerivedTypedElementException("the query's sourceType is null and the source is not null"); //$NON-NLS-1$
//			}
//		}
//	}
//
//	private static void setParameterValues(final EList<ParameterValue> target, final List<ParameterValue> parameterValues) {
//		if (parameterValues != null) {
//			for (ParameterValue parameterValue : parameterValues) {
//				if (parameterValue == null) {
//					throw new IllegalArgumentException("null parameter value"); //$NON-NLS-1$
//				}
//				// containment link -> we need to copy since we can have the same
//				// parameter for several results
//				target.add(EcoreUtil.copy(parameterValue));
//			}
//		}
//	}

	private static final void checkResult(final Query query, final Object result,
			final boolean checkResultType, final boolean primitive) throws DerivedTypedElementTypeCheckingException {
		if (QueryUtils.isMany(query)) {
			if (!(result instanceof Collection<?>)) {
				String strResult;
				if (result == null) {
					strResult = "null"; //$NON-NLS-1$
				} else {
					strResult = "an instance of " + result.getClass().getName(); //$NON-NLS-1$
				}
				throw new DerivedTypedElementTypeCheckingException(
						"A collection is expected as result. The result is " //$NON-NLS-1$
								+ strResult + " (on " + QueryUtils.getQueryDescription(query) + ")"); //$NON-NLS-1$ //$NON-NLS-2$
			}
			if (checkResultType) {
				for (Object collectionElement : (Collection<?>) result) {
					if (collectionElement != null
							&& !(QueryUtils.getReturnType(query)
									.isInstance(collectionElement))) {
						throw new DerivedTypedElementTypeCheckingException(
								"Wrong result collection element type: " + collectionElement.getClass().getName() //$NON-NLS-1$
										+ "(" + QueryUtils.getReturnType(query).getName() + " is expected) " //$NON-NLS-1$ //$NON-NLS-2$
										+ " on " + QueryUtils.getQueryDescription(query)); //$NON-NLS-1$
					}
				}
			} else if (!primitive) {
				// at least check that EObjects are returned
				for (Object collectionElement : (Collection<?>) result) {
					if (collectionElement != null && !(collectionElement instanceof EObject)) {
						throw new DerivedTypedElementTypeCheckingException(
								"Wrong result collection element type: " + collectionElement.getClass().getName() //$NON-NLS-1$
										+ "(an instance of " + EObject.class.getName() + " is expected) " //$NON-NLS-1$ //$NON-NLS-2$
										+ " on " + QueryUtils.getQueryDescription(query)); //$NON-NLS-1$
					}
				}
			}
		} else {
			if (result instanceof Collection<?>) {
				throw new DerivedTypedElementTypeCheckingException("A " //$NON-NLS-1$
						+ QueryUtils.getSourceType(query).getName()
						+ " instance is expected as result. The result is: " //$NON-NLS-1$
						+ result + " (on " + QueryUtils.getQueryDescription(query) + ")"); //$NON-NLS-1$//$NON-NLS-2$
			}
			if (checkResultType) {
				if (result != null && !(QueryUtils.getReturnType(query).isInstance(result))) {
					throw new DerivedTypedElementTypeCheckingException("Wrong result type: " //$NON-NLS-1$
							+ result.getClass().getName()
							+ " is returned while " //$NON-NLS-1$
							+ QueryUtils.getReturnType(query).getInstanceClassName()
							+ " is expected." + " (on " + QueryUtils.getQueryDescription(query) + ")"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				}
			} else if (!primitive) {
				// at least check that an EObject is returned
				if (result != null && !(result instanceof EObject)) {
					throw new DerivedTypedElementTypeCheckingException(
							"Wrong result collection element type: " + result.getClass().getName() //$NON-NLS-1$
									+ "(an instance of " + EObject.class.getName() + " is expected) " //$NON-NLS-1$ //$NON-NLS-2$
									+ " on " + QueryUtils.getQueryDescription(query)); //$NON-NLS-1$
				}
			}
		}
	}

	private static boolean isPrimitive(final EClassifier eType) {
		final boolean primitiveType;
		if (eType instanceof EDataType) {
			primitiveType = true;
		} else if (eType instanceof EClass) {
			primitiveType = false;
		} else {
			throw new IllegalArgumentException("unhandled derived typed element type: " + eType.getName()); //$NON-NLS-1$
		}
		return primitiveType;
	}
	
	/**
	 * Transform the element in parameter in list (if necessary).
	 * 
	 * @param element
	 *            the element to transform
	 * @return a list.
	 */
	protected static List<Object> setAsList(final Object element) {
		List<Object> newList = new LinkedList<Object>();
		if (element instanceof List) {
			@SuppressWarnings("unchecked")
			//@SuppressWarnings("unchecked") the cast is safe because were 
			//casting a List to a List<Object>
			final List<Object> tmpList = (List<Object>) element;
			newList = tmpList;
		} else {
			newList.add(element);
		}
		return newList;
	}

}
