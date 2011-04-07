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
 *  Tatiana Fesenko (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.compare.match;

import org.eclipse.emf.compare.match.engine.GenericMatchScopeProvider;
import org.eclipse.emf.compare.match.engine.IMatchScope;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.compare.UMLCompareUtils;
import org.eclipse.uml2.uml.util.UMLUtil;


/**
 * Implementation of GenericMatchScopeProvider for UML Diagrams:
 * <li>Processes changes in stereotypes and tagged values as children of the base element, not of resource</li> 
 */
public class PapyrusMatchScopeProvider extends GenericMatchScopeProvider {

	/**
	 * Instantiates a new papyrus match scope provider.
	 *
	 * @param leftResource the left resource
	 * @param rightResource the right resource
	 */
	public PapyrusMatchScopeProvider(Resource leftResource, Resource rightResource) {
		super(leftResource, rightResource);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.compare.match.engine.GenericMatchScopeProvider#getLeftScope()
	 */
	@Override
	public IMatchScope getLeftScope() {
		return new PapyrusMatchScope(super.getLeftScope());
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.compare.match.engine.GenericMatchScopeProvider#getRightScope()
	 */
	@Override
	public IMatchScope getRightScope() {
		return new PapyrusMatchScope(super.getRightScope());
	}

	/**
	 * The Class PapyrusMatchScope.
	 */
	private static class PapyrusMatchScope implements IMatchScope {

		/** The my scope. */
		private final IMatchScope myScope;

		/**
		 * Instantiates a new papyrus match scope.
		 *
		 * @param scope the scope
		 */
		private PapyrusMatchScope(IMatchScope scope) {
			myScope = scope;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.emf.compare.match.engine.IMatchScope#isInScope(org.eclipse.emf.ecore.EObject)
		 */
		public boolean isInScope(EObject eObject) {
			return myScope.isInScope(eObject) && !UMLCompareUtils.isStereotypeApplication(eObject);
		}

		/* (non-Javadoc)
		 * @see org.eclipse.emf.compare.match.engine.IMatchScope#isInScope(org.eclipse.emf.ecore.resource.Resource)
		 */
		public boolean isInScope(Resource resource) {
			return myScope.isInScope(resource);
		}

	}

}
