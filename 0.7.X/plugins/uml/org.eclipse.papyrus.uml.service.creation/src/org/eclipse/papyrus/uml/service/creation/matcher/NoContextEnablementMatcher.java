package org.eclipse.papyrus.uml.service.creation.matcher;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.service.creation.IPapyrusContextMatcher;

/**
 * This matcher is used to always disable the context where the semantic
 * creation service are defined.
 * This means the the creation service requires to be called which explicit
 * context specification.
 * 
 */
public class NoContextEnablementMatcher implements IPapyrusContextMatcher {

	public boolean matches(EObject eObject) {
		return false;
	}

}
