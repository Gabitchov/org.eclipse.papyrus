/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.alf.scoping;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

public class AlfPartialScope {
	
	private List<List<EObject>> nestedScopes ;
	private IGetNameStrategy nameStrategy ;
	private IBuildScopeStrategy buildScopeStrategy ;
	
	public AlfPartialScope(IGetNameStrategy nameStrategy, IBuildScopeStrategy buildScopeStrategy, EObject contextElement) {
		this.nameStrategy = nameStrategy ;
		this.buildScopeStrategy = buildScopeStrategy ;
		nestedScopes = buildScopeStrategy.buildScope(contextElement) ;
	}
	
	public String getElementName(EObject eObject) {
		return nameStrategy.getName(eObject) ;
	}
	
	public void buildScope(EObject contextElement) {
		nestedScopes = buildScopeStrategy.buildScope(contextElement) ;
	}

	public List<EObject> resolveByName(String elemName) {
		List<EObject> resolvedElements = new ArrayList<EObject>() ;
		Iterator<List<EObject>> nestedScopesIterator = nestedScopes.iterator() ;
		String normalizedElementName = elemName.startsWith("'") ? 
											elemName.substring(1, elemName.length()-1) : // removes first and last ' 
											elemName ; 
		while (nestedScopesIterator.hasNext() && resolvedElements.isEmpty()) {
			for (EObject elem : nestedScopesIterator.next()) {
				if (getElementName(elem).equals(normalizedElementName))
					resolvedElements.add(elem) ;
			}
		}
		return resolvedElements ;
	}
	
	public List<List<EObject>> getScopeDetails() {
		return nestedScopes ;
	}
	
	public int getScopingLevel(EObject element) {
		for (int i = 0 ; i<nestedScopes.size() ; i++) {
			if (nestedScopes.get(i).contains(element))
				return i ;
		}
		return -1 ;
	}
	
	public interface IGetNameStrategy {
		public String getName(EObject element) ;
	}
	
	public interface IBuildScopeStrategy {
		public List<List<EObject>> buildScope(EObject contextElement) ; 
	}
}
