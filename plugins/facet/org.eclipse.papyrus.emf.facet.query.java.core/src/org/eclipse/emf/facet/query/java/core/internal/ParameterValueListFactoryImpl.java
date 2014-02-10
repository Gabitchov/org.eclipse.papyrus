/**
 * Copyright (c) 2011 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Nicolas Guyomar (Mia-Software) - Bug 334615 - Java Query for EMF Facet
 */
package org.eclipse.emf.facet.query.java.core.internal;

import org.eclipse.emf.facet.efacet.ParameterValue;
import org.eclipse.emf.facet.query.java.core.IParameterValueList;
import org.eclipse.emf.facet.query.java.core.IParameterValueListFactory;

/**
 * Implementation of {@link IParameterValueListFactory}
 */
//deprecated APIs that are still maintained
@SuppressWarnings("deprecation")
public class ParameterValueListFactoryImpl implements
		IParameterValueListFactory {

	public IParameterValueList createParameterValueList(
			final ParameterValue... values) {
		return new ParameterValueList(values);
	}

}
