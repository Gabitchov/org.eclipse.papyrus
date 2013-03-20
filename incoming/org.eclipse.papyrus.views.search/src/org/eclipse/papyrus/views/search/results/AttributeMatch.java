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
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.services.openelement.service.OpenElementService;
import org.eclipse.papyrus.views.search.scope.ScopeEntry;
import org.eclipse.ui.PartInitException;

/**
 * 
 * A match raised by the value of an attribute
 * 
 */
public class AttributeMatch extends ModelMatch {

	/**
	 * The element containing the value of the attribute that matches
	 */
	protected Object target;

	/**
	 * Similar to {@link AbstractResultEntry} but adds an information about which attribute raised the match and which element contains the value of
	 * the attribute that matches
	 * 
	 * @param offset
	 * @param lenght
	 * @param target
	 *        the element containing the value of the attribute that matches
	 * @param scopeEntry
	 * @param attribute
	 *        the attribute that raised the match
	 */
	public AttributeMatch(int offset, int lenght, Object target, ScopeEntry scopeEntry, Object attribute) {
		super(offset, lenght, attribute, scopeEntry);
		this.target = target;
		this.parent = new ModelElementMatch(target, scopeEntry);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.views.search.results.AbstractResultEntry#equals(java.lang.Object)
	 *      In addition, it checks if target is the same as well.
	 * 
	 * @param obj
	 * @return
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof AttributeMatch) {
			if(super.equals(obj)) {
				if(((AttributeMatch)obj).getTarget().equals(this.target)) {
					return true;
				}
			}
			return false;

		} else {
			return false;
		}
	}

	public Object getTarget() {
		return target;
	}

	public void setTarget(Object target) {
		this.target = target;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.views.search.results.AbstractResultEntry#elementToDisplay()
	 * 
	 * @return
	 */
	@Override
	public Object elementToDisplay() {
		return this;

	}

	/**
	 * 
	 * @see org.eclipse.papyrus.views.search.results.AbstractResultEntry#elementToCheckFilterFor()
	 * 
	 * @return
	 */
	@Override
	public Object elementToCheckFilterFor() {
		return target;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.views.search.results.AbstractResultEntry#openElement()
	 * 
	 * @return
	 */
	@Override
	public Object openElement(OpenElementService service) throws ServiceException, PartInitException {
		if(target instanceof EObject) {
			return service.openSemanticElement((EObject)target);
		}
		return null;
	}
}
