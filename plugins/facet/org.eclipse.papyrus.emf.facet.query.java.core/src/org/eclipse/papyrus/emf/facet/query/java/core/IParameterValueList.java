/**
 * Copyright (c) 2009, 2011 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Bertrand Daru (Mia-Software) - initial API and implementation
 *    Gregoire Dupe (Mia-Software) - initial API and implementation
 */
package org.eclipse.papyrus.emf.facet.query.java.core;

import java.util.List;

import org.eclipse.papyrus.emf.facet.efacet.Parameter;
import org.eclipse.papyrus.emf.facet.efacet.ParameterValue;

/**
 * List of query parameters, with two methods for direct access to value or
 * parameter by name.
 * 
 * @deprecated cf. https://bugs.eclipse.org/bugs/show_bug.cgi?id=374678
 */
@Deprecated
public interface IParameterValueList extends List<ParameterValue> {
	// This interface is a rewrite of
	// org.eclipse.papyrus.emf.facet.infra.query.core.java.ParameterValueList

	/**
	 * Return the value of the parameter with the specified name.
	 * 
	 * @param name
	 *            the name of the parameter
	 * @return the value, or <code>null</code> if there is no parameter with
	 *         that name.
	 */
	public Object getValueByParameterName(final String name);

	/**
	 * Return the parameter with the specified name.
	 * 
	 * @param name
	 *            the name of the parameter
	 * @return the parameter, or <code>null</code> if there is no parameter with
	 *         that name.
	 */
	public ParameterValue getParameterValueByName(final String name);

	/**
	 * Return the parameter corresponding to the given parameter declaration.
	 * 
	 * @param parameter
	 *            the parameter declaration
	 * @return the parameter, or <code>null</code> if the given parameter
	 *         declaration is unknown.
	 */
	public ParameterValue getParameterValue(final Parameter parameter);

	/**
	 * Return the value of a parameter
	 * 
	 * @param parameter
	 *            the parameter
	 * @return the value of the parameter
	 */
	public Object getValue(final Parameter parameter);
}
