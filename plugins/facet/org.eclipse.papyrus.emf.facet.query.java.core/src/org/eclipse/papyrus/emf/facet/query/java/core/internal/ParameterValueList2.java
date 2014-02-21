/**
 * Copyright (c) 2009 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Bertrand Daru (Mia-Software) - initial API and implementation
 *    Gregoire Dupe (Mia-Software) - initial API and implementation
 *    Emmanuelle Rouillé (Mia-Software) - Bug 352618 - To be able to use non derived facet structural features and save them values.
 *    Nicolas Bros (Mia-Software) - Bug 361612 - New core for new version of the Facet metamodel
 *    David Couvrand (Soft-Maint) - Bug 418813 - [Query] Optimization in creation of ParameterValueList2
 */
package org.eclipse.emf.facet.query.java.core.internal;

import java.util.ArrayList;
import java.util.Arrays;

import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.EFacetFactory;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.ParameterValue;
import org.eclipse.emf.facet.query.java.core.IParameterValueList2;

public class ParameterValueList2 extends ArrayList<ParameterValue> implements IParameterValueList2 {
	// This class is a copy of
	// org.eclipse.emf.facet.infra.query.core.java.ParameterValueList

	private static final long serialVersionUID = 1L;

	ParameterValueList2(final ParameterValue... values) {
		super(Arrays.asList(values));
	}

	/**
	 * Return the value of the parameter with the specified name.
	 *
	 * @param name
	 *            the name of the parameter
	 * @return the value, or <code>null</code> if there is no parameter with
	 *         that name.
	 */
	public Object getValueByParameterName(final String name) {
		ParameterValue param = getParameterValueByName(name);
		if (param == null) {
			return null;
		}
		return param.getValue();
	}

	/**
	 * Return the parameter with the specified name.
	 *
	 * @param name
	 *            the name of the parameter
	 * @return the parameter, or <code>null</code> if there is no parameter with
	 *         that name.
	 */
	public ParameterValue getParameterValueByName(final String name) {
		for (ParameterValue param : this) {
			EParameter parameter = param.getParameter();
			if (parameter != null) {
				if (name.equals(parameter.getName())) {
					return param;
				}
			}
		}
		return null;
	}

	public static ParameterValue createParameterValue(final Object value,
			final EParameter parameter) {
		ParameterValue paramValue = EFacetFactory.eINSTANCE
				.createParameterValue();
		paramValue.setParameter(parameter);
		paramValue.setValue(value);
		return paramValue;
	}

	/**
	 * Return the parameter corresponding to the given parameter declaration.
	 *
	 * @param parameter
	 *            the parameter declaration
	 * @return the parameter, or <code>null</code> if the given parameter
	 *         declaration is unknown.
	 */
	public ParameterValue getParameterValue(final EParameter parameter) {
		for (ParameterValue paramValue : this) {
			if (paramValue.getParameter() == parameter) {
				return paramValue;
			}
		}
		return null;
	}

	/**
	 * Return the value of a parameter
	 *
	 * @param parameter
	 *            the parameter
	 * @return the value of the parameter
	 */
	public Object getValue(final EParameter parameter) {
		return getParameterValue(parameter).getValue();
	}
}
