/*******************************************************************************
 * Copyright (c) 2011 Mia-Software
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	   Emmanuelle Rouillé (Mia-Software) - Bug 352618 - To be able to use non derived facet structural features and save them values.
 *     Nicolas Bros (Mia-Software) - Bug 361612 - New core for new version of the Facet metamodel
 *     Grégoire Dupé (Mia-Software) - Bug 361612 - [Restructuring] New core for new version of the Facet metamodel
 *     Gregoire Dupe (Mia-Software) - Bug 375087 - [Table] ITableWidget.addColumn(List<ETypedElement>, List<FacetSet>)
 *     Gregoire Dupe (Mia-Software) - Bug 372626 - Aggregates
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.efacet.core.internal;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.emf.facet.efacet.core.internal.exception.UnmatchingExpectedTypeException;

public final class EmfUtils {
	
	private EmfUtils() {
		//Must not be used
	}

	public static void checkAssignment(final Object value, final ETypedElement eTypedElement)
			throws UnmatchingExpectedTypeException {
		final String typedElementName = getTypeElementDescription(eTypedElement);
		//Begin checking precondition
		if (eTypedElement.getEType() == null) {
			throw new IllegalArgumentException(typedElementName + " has a null type"); //$NON-NLS-1$
		}
		//End checking precondition
		if (value == null && (eTypedElement.getLowerBound() > 0)) {
			throw new IllegalArgumentException(
					"The assigned value cannot be null for " + typedElementName + " because multiplicity is " + eTypedElement.getLowerBound() + ".." + eTypedElement.getUpperBound()); //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$
		}
		if (value != null) {
			if (eTypedElement.getUpperBound() == 1) {
				if (!eTypedElement.getEType().isInstance(value)) {
					throw new IllegalArgumentException(
							"Type mismatch for " + EcoreUtil.getURI(eTypedElement) + ": expected '" + eTypedElement.getEType().getName() + "' but got '" + value.getClass().getName() + "'."); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
				}
			} else { // expect a list for multiplicity-many
				if (!(value instanceof List<?>)) {
					throw new IllegalArgumentException("Type mismatch for " + typedElementName + "': expected a List because the parameter is multiplicity-many. But got a " + //$NON-NLS-1$ //$NON-NLS-2$
							value.getClass().getName() + "'."); //$NON-NLS-1$
				}
				final List<?> argumentList = (List<?>) value;
				try {
					CastUtils.checkTypeOfAllListElements(argumentList, eTypedElement.getEType().getInstanceClass());
					//FIXME What happens if we use a not generated meta-model ?
				} catch (UnmatchingExpectedTypeException e) {
					throw new UnmatchingExpectedTypeException(
							"Type mismatch for an element of the list value " + typedElementName , e); //$NON-NLS-1$
				}
			} 
		}
	}

	private static String getTypeElementDescription(final ETypedElement eTypedElement) {
		String containerName = ""; //$NON-NLS-1$
		if (eTypedElement.eContainer() instanceof ENamedElement) {
			final ENamedElement namedContainer = (ENamedElement) eTypedElement.eContainer();
			containerName = "the " + namedContainer.eClass().getName() + " named '" + namedContainer.getName() + "'"; //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$
		}
		return "the " + eTypedElement.eClass().getName() + " named '" + eTypedElement.getName() + "' in " + containerName; //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$
	}

	public static Object ecoreInvoke(final EObject eObject, final EOperation operation, final Object... arguments) throws InvocationTargetException {
		// delegate to Ecore
		final BasicEList<Object> operationParams = new BasicEList<Object>();
		for (Object param : arguments) {
			operationParams.add(param);
		}
		return eObject.eInvoke(operation, operationParams);
	}

	public static <T> T checkAssignment(final EStructuralFeature eStructuralFeature, final Class<T> expectedType, final Object value)
			throws UnmatchingExpectedTypeException {
		if (eStructuralFeature.isMany() && expectedType != null) {
			if (expectedType != Object.class
					&& !Collection.class.isAssignableFrom(expectedType)) {
				throw new UnmatchingExpectedTypeException("The required eStructuralFeature is multi-valued, so expectedType must be a subtype of Collection."); //$NON-NLS-1$
			}
			if (!expectedType.isInstance(value)) {
				throw new UnmatchingExpectedTypeException("The derived typed element did not evaluate to the expected type", Collection.class, value); //$NON-NLS-1$
			}
		}
		return CastUtils.castToExpectedType(value, expectedType);
	}

}
