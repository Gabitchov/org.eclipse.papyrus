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
 *    Emmanuelle Rouillé (Mia-Software) - Bug 352618 - To be able to use non derived facet structural features and save them values.
 *    Nicolas Bros (Mia-Software) - Bug 361612 - New core for new version of the Facet metamodel
 */
package org.eclipse.papyrus.emf.facet.query.java.core;

import java.util.List;

import org.eclipse.emf.ecore.EParameter;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.ParameterValue;

/**
 * @since 0.2
 */
public interface IParameterValueList2 extends List<ParameterValue> {
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
		public ParameterValue getParameterValue(final EParameter parameter);

		/**
		 * Return the value of a parameter
		 *
		 * @param parameter
		 *            the parameter
		 * @return the value of the parameter
		 */
		public Object getValue(final EParameter parameter);
}