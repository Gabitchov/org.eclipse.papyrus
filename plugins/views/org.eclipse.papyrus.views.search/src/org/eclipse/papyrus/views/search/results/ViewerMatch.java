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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.services.openelement.service.OpenElementService;
import org.eclipse.papyrus.views.search.scope.ScopeEntry;
import org.eclipse.ui.PartInitException;

/**
 * 
 * A match raised by a viewer (i.e. something that is a view of a real match) in a model
 * 
 */
public class ViewerMatch extends AbstractResultEntry {

	/**
	 * The model element that is represented by the viewer
	 */
	protected URI URIsemanticElement;

	public ViewerMatch(Object source, ScopeEntry scopeEntry, Object semanticElement) {
		super(UNSPECIFIED, UNSPECIFIED, source, scopeEntry);
		if(semanticElement instanceof EObject) {
			this.URIsemanticElement = EcoreUtil.getURI((EObject)semanticElement);
		}


		this.parent = getLastParent(this, scopeEntry);
		//		this.parent = new ResultEntry(scopeEntry.getResource(), scopeEntry);

	}

	public Object getSemanticElement() {
		if(this.URIsemanticElement != null) {
			ResourceSet resSet = ((ScopeEntry)this.getElement()).getModelSet();
			return resSet.getEObject(this.URIsemanticElement, true);
		}
		return null;
	}

	public void setSemanticElement(Object semanticElement) {
		if(semanticElement instanceof EObject) {
			this.URIsemanticElement = EcoreUtil.getURI((EObject)semanticElement);
		}
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.views.search.results.AbstractResultEntry#elementToDisplay()
	 * 
	 * @return
	 */
	@Override
	public Object elementToDisplay() {
		return this.getSource();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.views.search.results.AbstractResultEntry#elementToCheckFilterFor()
	 * 
	 * @return
	 */
	@Override
	public Object elementToCheckFilterFor() {
		if(this.URIsemanticElement != null) {
			ResourceSet resSet = ((ScopeEntry)this.getElement()).getModelSet();
			return resSet.getEObject(this.URIsemanticElement, true);
		}
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.views.search.results.AbstractResultEntry#openElement()
	 * 
	 * @return
	 */
	@Override
	public Object openElement(OpenElementService service) throws ServiceException, PartInitException {
		if(this.getSource() instanceof EObject) {
			return service.openElement((EObject)this.getSource());
		}
		return null;
	}

}
