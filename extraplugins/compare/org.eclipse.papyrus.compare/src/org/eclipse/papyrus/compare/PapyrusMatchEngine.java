package org.eclipse.papyrus.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.compare.match.engine.AbstractSimilarityChecker;
import org.eclipse.emf.compare.match.engine.GenericMatchEngine;
import org.eclipse.emf.compare.match.engine.IMatchScope;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Element;


public class PapyrusMatchEngine extends GenericMatchEngine {
	
	@Override
	protected AbstractSimilarityChecker prepareChecker() {
		return super.prepareChecker();
	}
	
	@Override
	protected List<EObject> getScopeInternalContents(EObject eObject, IMatchScope scope) {
		ArrayList<EObject> result = new ArrayList<EObject>(super.getScopeInternalContents(eObject, scope));
		result.addAll(getStereotypeApplications(eObject));
		return result;
	}
	
	private List<EObject> getStereotypeApplications(EObject eObject) {
		if (eObject instanceof Element) {
			return ((Element)eObject).getStereotypeApplications();
		} else {
			return Collections.emptyList();
		}
	}
	
}
