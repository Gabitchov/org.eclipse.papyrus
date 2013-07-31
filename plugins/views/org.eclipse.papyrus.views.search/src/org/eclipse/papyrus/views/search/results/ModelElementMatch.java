/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
package org.eclipse.papyrus.views.search.results;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.services.openelement.service.OpenElementService;
import org.eclipse.papyrus.views.search.scope.ScopeEntry;
import org.eclipse.ui.PartInitException;

/**
 * 
 * A match raised by an element in a model
 * 
 */
public class ModelElementMatch extends ModelMatch {



	public ModelElementMatch(Object source, ScopeEntry scopeEntry) {
		super(UNSPECIFIED, UNSPECIFIED, source, scopeEntry);
		recursiveHierarchy(this);


		//		this.parent = new ResultEntry(scopeEntry.getResource(), scopeEntry);
	}

	@Override
	public boolean equals(Object obj) {
		//		if(obj instanceof ModelElementMatch) {
		//			if(super.equals(obj)) {
		//
		//				return true;
		//
		//			}
		//			return false;
		//
		//		} else {
		//			return false;
		//		}
		return super.equals(obj);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.views.search.results.AbstractResultEntry#elementToDisplay()
	 * 
	 * @return
	 */
	@Override
	public Object elementToDisplay() {
		//		return this.getSource();
		if(this.uriSource != null) {
			ResourceSet resSet = ((ScopeEntry)this.getElement()).getModelSet();
			return resSet.getEObject(this.uriSource, true);
		}
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.views.search.results.AbstractResultEntry#elementToCheckFilterFor()
	 * 
	 * @return
	 */
	@Override
	public Object elementToCheckFilterFor() {
		return this.getSource();
	}

	//	@Override
	//	public Object getSource() {
	//
	//		if(this.uriSource != null) {
	//			ResourceSet resSet = ((ScopeEntry)this.getElement()).getModelSet();
	//			return resSet.getEObject(this.uriSource, true);
	//		}
	//		return null;
	//
	//
	//	}

	/**
	 * 
	 * @see org.eclipse.papyrus.views.search.results.AbstractResultEntry#openElement()
	 * 
	 * @return
	 */
	@Override
	public Object openElement(OpenElementService service) throws ServiceException, PartInitException {
		if(this.getSource() instanceof EObject) {

			return service.openSemanticElement((EObject)this.getSource());
		}
		return null;
	}
}
