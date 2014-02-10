/**
 * Copyright (c) 2011 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Nicolas Guyomar (Mia-Software) - Bug 334615 - Java Query for EMF Facet
 */
package org.eclipse.emf.facet.query.java.core;

import org.eclipse.emf.facet.efacet.ParameterValue;
import org.eclipse.emf.facet.query.java.core.internal.ParameterValueList;
import org.eclipse.emf.facet.query.java.core.internal.ParameterValueListFactoryImpl;

/**
 * Factory for the creation of instances of {@link ParameterValueList}.
 * 
 * @deprecated cf. https://bugs.eclipse.org/bugs/show_bug.cgi?id=374678
 */
@Deprecated
public interface IParameterValueListFactory {

	/**
	 * Factory singleton
	 */
	public static final IParameterValueListFactory INSTANCE = new ParameterValueListFactoryImpl();

	/**
	 * This method has to be used to get a new instance of
	 * {@link IParameterValueList}
	 * 
	 * @param values
	 *            the list of parameters
	 * @return an {@link IParameterValueList} instance containing the provided
	 *         parameter values
	 */
	public IParameterValueList createParameterValueList(
			final ParameterValue... values);
}
