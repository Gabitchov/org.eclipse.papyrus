/*******************************************************************************
 * Copyright (c) 2011 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA LIST - initial API and implementation
 *******************************************************************************/

package org.eclipse.papyrus.qompass.designer.core.extensions;

import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.Classifier;

/**
 * Interface used by Qompass extensions that supports specific external code generators, e.g. CORBA and DDS
 */
public interface IExternalGenerator {

	/**
	 * generate a class by means of an external generator
	 * @param source A source element for the generator, e.g. an interface for a CORBA generator
	 * @returns a list of generated classifiers:
	 * 	Even, if the external generator produces code directly, the Java wrapper should return a set
	 *  model elements (may be incomplete) that represent the generated elements. For instance, in case
	 *  of C++, an empty class with the stereotype "extern C" could be returned 
	 */
	public EList<Classifier> generate (Classifier source);
}
