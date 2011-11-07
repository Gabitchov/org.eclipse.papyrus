/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 		Atos Origin - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.utils;

import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.Lifeline;

/**
 * Utility class for <code>org.eclipse.uml2.uml.Executionspecification</code><BR>
 */
public class ExecutionSpecificationUtil {

	/**
	 * Retrieve the Lifeline associated with an ExecutionSpecification.
	 * According to the UML Specification, an ExecutionSpecification must have a start and a finish.
	 * 
	 * In Papyrus, an ExecutionSpecification may not have a start and finish.
	 * To handle this specific case, we return the first Lifeline that the ES covered.
	 * 
	 * @param es
	 *        the targeted execution specification
	 * @return the associated Lifeline, or null if the ES has no start, no finish, no covered Lifeline.
	 */
	public static Lifeline getExecutionSpecificationLifeline(ExecutionSpecification es) {
		Lifeline lifeline = null;
		if(es.getStart() != null) {
			lifeline = es.getStart().getCovereds().get(0);
		} else if(es.getFinish() != null) {
			lifeline = es.getFinish().getCovereds().get(0);
		}

		if(lifeline == null) {
			if(!es.getCovereds().isEmpty()) {
				lifeline = es.getCovereds().get(0);
			}
		}
		return lifeline;
	}
}
