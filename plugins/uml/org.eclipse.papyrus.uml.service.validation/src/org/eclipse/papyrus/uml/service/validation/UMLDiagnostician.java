/*****************************************************************************
 * Copyright (c) 2010, 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Patrick Tessier (CEA LIST) Patrick.Tessier@cea.fr - Initial API and implementation
 * Ansgar Radermacher (CEA LIST) ansgar.radermacher@cea.fr - Contribution related to bug 410457, 410119 and 410059
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.validation;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.services.validation.EcoreDiagnostician;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * This is a specific diagnostician used to validate stereotype applications
 *k
 */
public class UMLDiagnostician extends EcoreDiagnostician {

	public UMLDiagnostician() {
		validateStereotype = false;
	}

	protected boolean doValidateStereotypeApplications(EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (validateStereotype) {
			// this function is called recursively. Avoid trying to obtain stereotype applications, if we are
			// already examining a stereotype
			return true;
		}
		List<EObject> stereotypeApplications = eObject instanceof Element ? ((Element)eObject).getStereotypeApplications() : Collections.<EObject> emptyList();
		if(!stereotypeApplications.isEmpty()) {
			Iterator<EObject> i = stereotypeApplications.iterator();
			validateStereotype = true;
			boolean result = validate(i.next(), diagnostics, context);
			while(i.hasNext() && (result || diagnostics != null)) {
				result &= validate(i.next(), diagnostics, context);
			}
			validateStereotype = false;
			return result;
		} else {
			return true;
		}
	}

	@Override
	protected boolean doValidateContents(EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = doValidateStereotypeApplications(eObject, diagnostics, context);
		if(result || diagnostics != null) {
			result &= super.doValidateContents(eObject, diagnostics, context);
		}
		return result;
	}
	
	@Override
	public boolean validate(EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!context.containsKey(this)) {
			// put instance of the UMLDiagnostician into context map to identify first invocation
			// (validate is called recursively)
			context.put(this, null);
			BasicDiagnostic newDiagChain = createDefaultDiagnostic(eObject);
			boolean ok = super.validate(eObject, newDiagChain, context);
			// replace markers here instead of using a validation adapter, see
			// bug 410457 - [Validation] Ghost markers when validating profile constraints
			// bug 410119 - [Validation] markers related to stereotype applications are not updated in diagrams 
			// bug 410059 - [Validation] delete subtree does not remove markers associated with stereotypes
			for (Diagnostic d : newDiagChain.getChildren()) {
				Object data[] = d.getData().toArray();
				if (data.length > 0) {
					Object target = data[0];
					if (target instanceof EObject) {
						EObject base = UMLUtil.getBaseElement((EObject) target);
						if (base != null) {
							data[0] = base;
						}
					}
				}
			    diagnostics.add(new BasicDiagnostic(
			    	d.getSeverity(), d.getSource(), d.getCode(), d.getMessage(), data));
			}
			return ok;
		}
		else {
			return super.validate(eObject, diagnostics, context);
		}
	}
	
	protected boolean validateStereotype;

}
