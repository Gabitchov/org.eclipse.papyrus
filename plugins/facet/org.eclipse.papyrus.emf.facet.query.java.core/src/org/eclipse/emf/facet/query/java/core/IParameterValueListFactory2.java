/**
 * Copyright (c) 2011 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Nicolas Guyomar (Mia-Software) - Bug 334615 - Java Query for EMF Facet
 *    Emmanuelle Rouillé (Mia-Software) - Bug 352618 - To be able to use non derived facet structural features and save them values.
 *    Nicolas Bros (Mia-Software) - Bug 361612 - New core for new version of the Facet metamodel
 */
package org.eclipse.emf.facet.query.java.core;

import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.ParameterValue;
import org.eclipse.emf.facet.query.java.core.internal.ParameterValueListFactoryImpl2;

/**
 * @since 0.2
 */
public interface IParameterValueListFactory2 {
	/** Factory singleton */
	public static final IParameterValueListFactory2 INSTANCE = new ParameterValueListFactoryImpl2();

	/**
	 * This method has to be used to get a new instance of {@link IParameterValueList2}
	 *
	 * @param values
	 *            the list of parameters
	 * @return an {@link IParameterValueList2} instance containing the provided
	 *         parameter values
	 */
	public IParameterValueList2 createParameterValueList(
			final ParameterValue... values);
}
