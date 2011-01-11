package org.eclipse.papyrus.core.navigation;

import java.util.List;

import org.eclipse.emf.ecore.EObject;


public interface INavigationRule {

	public boolean handle(EObject element);

	public List<NavigableElement> getNextPossibleElements(NavigableElement currentNavElement);
}
