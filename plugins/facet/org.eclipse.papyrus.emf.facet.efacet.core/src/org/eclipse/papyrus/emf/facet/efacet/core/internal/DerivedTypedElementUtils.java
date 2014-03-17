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
 *     Gregoire Dupe (Mia-Software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 *     Gregoire Dupe (Mia-Software) - Bug 375087 - [Table] ITableWidget.addColumn(List<ETypedElement>, List<FacetSet>)
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.efacet.core.internal;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.papyrus.emf.facet.efacet.core.IDerivedTypedElementManager;
import org.eclipse.papyrus.emf.facet.efacet.core.IFacetManager;
import org.eclipse.papyrus.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.papyrus.emf.facet.efacet.core.internal.exception.UnmatchingExpectedTypeException;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.EFacetFactory;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetOperation;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.ParameterValue;

public final class DerivedTypedElementUtils {
	
	private DerivedTypedElementUtils() {
		// Must not be used
	}
	
	private static <T> List<ParameterValue> createAndCheckOperationParameterValues(final EOperation operation,
			final Object... arguments) throws UnmatchingExpectedTypeException {
		final EList<EParameter> operationParameters = operation.getEParameters();
		//Begin precondition checking
		if (arguments.length > 0
				&& operationParameters.size() != arguments.length) {
			throw new IllegalArgumentException("Facet operation '" + operation.getName() + //$NON-NLS-1$
					"' expects " + operationParameters.size() + " parameters. Got " + arguments.length); //$NON-NLS-1$ //$NON-NLS-2$
		}
		//End precondition checking
		final List<ParameterValue> parameterValues = new ArrayList<ParameterValue>();
		for (int i = 0; i < arguments.length; i++) {
			final Object argument = arguments[i];
			final EParameter eParameter = operationParameters.get(i);
			//Begin precondition checking
			EmfUtils.checkAssignment(argument, eParameter);
			//End precondition checking
			final ParameterValue parameterValue = EFacetFactory.eINSTANCE.createParameterValue();
			parameterValue.setParameter(eParameter);
			parameterValue.setValue(argument);
			parameterValues.add(parameterValue);
		}
		return parameterValues;
	}
	
	public static Object evaluate(final EObject eObject, final EOperation operation, final IFacetManager facetManager, final Object... arguments) throws UnmatchingExpectedTypeException,
			DerivedTypedElementException {
		Object result;
		final List<ParameterValue> parameterValues = DerivedTypedElementUtils.createAndCheckOperationParameterValues(operation, arguments);
		result = IDerivedTypedElementManager.INSTANCE.evaluate((FacetOperation) operation, eObject, parameterValues, facetManager);
		return result;
	}
}
