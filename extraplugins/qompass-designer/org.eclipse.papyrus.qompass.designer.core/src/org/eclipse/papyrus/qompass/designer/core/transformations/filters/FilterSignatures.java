package org.eclipse.papyrus.qompass.designer.core.transformations.filters;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.TemplateSignature;

import org.eclipse.papyrus.qompass.designer.core.listeners.CopyListener;
import org.eclipse.papyrus.qompass.designer.core.transformations.Copy;


/**
 * Remove signatures from package template (only remove signatures within the
 * template, not others)
 * 
 * @author ansgar
 * 
 */
public class FilterSignatures implements CopyListener {

	public static FilterSignatures getInstance() {
		if(instance == null) {
			instance = new FilterSignatures();
		}
		return instance;
	}

	public EObject copyEObject(Copy copy, EObject sourceEObj) {
		if(sourceEObj instanceof TemplateSignature) {
			if(copy.withinTemplate(sourceEObj)) {
				return null;
			}
		}
		return sourceEObj;
	}

	private static FilterSignatures instance = null;
}
