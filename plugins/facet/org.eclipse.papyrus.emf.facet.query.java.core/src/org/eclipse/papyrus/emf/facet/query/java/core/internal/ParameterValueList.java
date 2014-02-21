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
 */
package org.eclipse.papyrus.emf.facet.query.java.core.internal;

import java.util.ArrayList;
import java.util.Arrays;

import org.eclipse.papyrus.emf.facet.efacet.EFacetFactory;
import org.eclipse.papyrus.emf.facet.efacet.Parameter;
import org.eclipse.papyrus.emf.facet.efacet.ParameterValue;
import org.eclipse.papyrus.emf.facet.query.java.core.IParameterValueList;

//deprecated APIs that are still maintained
@SuppressWarnings("deprecation")
public class ParameterValueList extends ArrayList<ParameterValue> implements
		IParameterValueList {

	// This class is a copy of
	// org.eclipse.papyrus.emf.facet.infra.query.core.java.ParameterValueList

	/** SERIAL ID */
	private static final long serialVersionUID = 1L;

	ParameterValueList(final ParameterValue... values) {
		this.addAll(Arrays.asList(values));
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
			if (param.getParameter().getName().equals(name)) {
				return param;
			}
		}
		return null;
	}

	public static ParameterValue createParameterValue(final Object value,
			final Parameter parameter) {
		ParameterValue paramValue = EFacetFactory.eINSTANCE
				.createParameterValue();
		paramValue.setParameter(parameter);
		paramValue.getValue().add(value);

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
	public ParameterValue getParameterValue(final Parameter parameter) {
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
	public Object getValue(final Parameter parameter) {
		return getParameterValue(parameter).getValue();
	}

}
