/*******************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cedric Dumoulin Cedric.dumoulin@lifl.fr
 ******************************************************************************/
package org.eclipse.papyrus.layers.runtime.utils;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationFactory;


/**
 * Set of utilities on Notation for testing purposes
 * 
 * @author cedric dumoulin
 *
 */
public class NotationDiagramTestUtils {

	/**
	 * Constructor.
	 *
	 */
	public NotationDiagramTestUtils() {
	}

	public Diagram newDiagram() {
		
		Diagram diagram = NotationFactory.eINSTANCE.createDiagram();
		return diagram;
	}
}
