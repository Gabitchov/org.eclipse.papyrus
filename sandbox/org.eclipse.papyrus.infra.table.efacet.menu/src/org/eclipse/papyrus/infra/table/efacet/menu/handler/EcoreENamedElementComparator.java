package org.eclipse.papyrus.infra.table.efacet.menu.handler;

import java.util.Comparator;

import org.eclipse.emf.ecore.ENamedElement;


public class EcoreENamedElementComparator implements Comparator<ENamedElement> {

	public int compare(final ENamedElement o1, final ENamedElement o2) {
		return o1.getName().compareToIgnoreCase(o2.getName());
	}

}