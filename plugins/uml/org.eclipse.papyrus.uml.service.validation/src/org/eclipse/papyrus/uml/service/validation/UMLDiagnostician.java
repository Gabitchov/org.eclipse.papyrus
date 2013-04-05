/*****************************************************************************
 * Copyright (c) 2010, 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CoPatrick Tessier (CEA LIST) Patrick.Tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.validation;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.services.validation.EcoreDiagnostician;
import org.eclipse.uml2.uml.Element;

/**
 * this is a specific diagnostician use to validate also stereotype application
 *
 */
public class UMLDiagnostician extends EcoreDiagnostician {

	public UMLDiagnostician(){
	}

	protected boolean doValidateStereotypeApplications(
		EObject eObject, DiagnosticChain diagnostics,
		Map<Object, Object> context) {
		List<EObject> stereotypeApplications = eObject instanceof Element
			? ((Element) eObject).getStereotypeApplications()
				: Collections.<EObject> emptyList();

			if (!stereotypeApplications.isEmpty()) {
				Iterator<EObject> i = stereotypeApplications
					.iterator();
				boolean result = validate(i.next(), diagnostics,
					context);

				while (i.hasNext()
					&& (result || diagnostics != null)) {

					result &= validate(i.next(), diagnostics,
						context);
				}

				return result;
			} else {
				return true;
			}
	}

	@Override
	protected boolean doValidateContents(EObject eObject,
		DiagnosticChain diagnostics,
		Map<Object, Object> context) {
		boolean result = doValidateStereotypeApplications(
			eObject, diagnostics, context);

		if (result || diagnostics != null) {
			result &= super.doValidateContents(eObject,
				diagnostics, context);
		}

		return result;
	}
}
