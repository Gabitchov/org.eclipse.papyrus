/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.PackageImport;

/**
 * 
 * This class provides methods to get
 * <ul>
 * <li>all element of a given type</li>
 * <li>all imported namespaces</li>
 * </ul>
 * 
 * 
 * 
 */
public class Visitor {

	/**
	 * 
	 * shall be overridden to restrict the possible {@link Type}
	 * 
	 * 
	 * Returns the owned and imported {@link Type} imported namespace
	 * 
	 * @param visited
	 *        the visited namespace
	 * @return the owned and imported {@link Type} imported namespace
	 */
	public static List<Element> getOwnedAndImportedElement(Namespace visited, Class<?> wantedClass) {
		List<Element> visibleElements = new ArrayList<Element>();
		// first retrieves imported properties
		for(ElementImport eImport : visited.getElementImports()) {
			if(wantedClass.isInstance(eImport)) {
				visibleElements.add(eImport.getImportedElement());
			}
		}
		// then retrieves owned properties
		for(NamedElement n : visited.getOwnedMembers()) {
			if(wantedClass.isInstance(n)) {
				visibleElements.add(n);
			}
			if(n instanceof Namespace) {
				visibleElements.addAll(getOwnedAndImportedElement((Namespace)n, wantedClass));
			}
		}

		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(wantedClass);
		return visibleElements;
	}

	/**
	 * Returns the imported {@link Namespace}
	 * 
	 * @param visited
	 *        the visited namespace
	 * @return the imported {@link Namespace}
	 */
	public static List<Namespace> getImportedNamespaces(Namespace visited) {
		List<Namespace> namespaces = new ArrayList<Namespace>();

		// retrieves imported namespaces
		for(PackageImport pImport : visited.getPackageImports()) {
			namespaces.add(pImport.getImportedPackage());
		}
		for(ElementImport eImport : visited.getElementImports()) {
			if(eImport.getImportedElement() instanceof Namespace)
				namespaces.add((Namespace)eImport.getImportedElement());
		}

		return namespaces;
	}

	/**
	 * Returns the owned and imported {@link Namespace}
	 * 
	 * @param visited
	 *        the visited namespace
	 * @return the owned and imported {@link Namespace}
	 */
	public static List<Namespace> getOwnedAndImportedNamespaces(Namespace visited) {
		List<Namespace> namespaces = new ArrayList<Namespace>();
		// first retrieves imported namespaces
		namespaces.addAll(getImportedNamespaces(visited));
		// then retrieves owned namespaces
		for(NamedElement n : visited.getOwnedMembers()) {
			if(n instanceof Namespace)
				namespaces.add((Namespace)n);
		}
		return namespaces;
	}
}
