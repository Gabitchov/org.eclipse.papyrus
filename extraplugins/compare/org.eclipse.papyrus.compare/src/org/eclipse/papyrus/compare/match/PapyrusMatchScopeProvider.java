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


public class PapyrusMatchScopeProvider extends GenericMatchScopeProvider {

	public PapyrusMatchScopeProvider(Resource leftResource, Resource rightResource) {
		super(leftResource, rightResource);
	}

	@Override
	public IMatchScope getLeftScope() {
		return new PapyrusMatchScope(super.getLeftScope());
	}

	@Override
	public IMatchScope getRightScope() {
		return new PapyrusMatchScope(super.getRightScope());
	}

	private static class PapyrusMatchScope implements IMatchScope {

		private final IMatchScope myScope;

		private PapyrusMatchScope(IMatchScope scope) {
			myScope = scope;
		}

		public boolean isInScope(EObject eObject) {
			return myScope.isInScope(eObject) && !UMLCompareUtils.isStereotypeApplication(eObject);
		}

		public boolean isInScope(Resource resource) {
			return myScope.isInScope(resource);
		}

	}

}
