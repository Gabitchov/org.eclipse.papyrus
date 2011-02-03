/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Mathieu Velten (Atos Origin) mathieu.velten@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.types.helper.advice;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyDependentsRequest;
import org.eclipse.uml2.uml.PartDecomposition;

public class PartDecompositionHelperAdvice extends AbstractEditHelperAdvice {

	protected ICommand getBeforeDestroyDependentsCommand(DestroyDependentsRequest request) {
		PartDecomposition decomposition = (PartDecomposition)request.getElementToDestroy();
		// destroy the decomposed lifelines
		return request.getDestroyDependentsCommand(decomposition.getCovereds());
	}
}
