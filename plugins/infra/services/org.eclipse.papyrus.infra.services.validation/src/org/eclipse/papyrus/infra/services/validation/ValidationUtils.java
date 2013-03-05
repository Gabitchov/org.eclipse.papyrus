/*****************************************************************************
 * Copyright (c) 2010, 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Ansgar Radermacher (CEA LIST) ansgar.radermacher@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - refactor for non-workspace abstraction of problem markers (CDO)
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.services.validation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;


public class ValidationUtils {
	
	/**
	 * Return the validation resource for a selected eObject
	 * 
	 * @return The resource on which markers should be applied.
	 */
	public static Resource getValidationResource(EObject eObject) {
		// fix for bug 397518 - assure that markers are put onto UML resource instead of delegating to domain
		return eObject.eResource();
		// TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(eObject);
		// return getValidationResourceViaDomain(domain);
	}
}
