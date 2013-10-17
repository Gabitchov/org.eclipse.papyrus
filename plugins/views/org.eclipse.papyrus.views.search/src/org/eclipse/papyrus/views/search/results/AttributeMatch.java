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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.services.openelement.service.OpenElementService;
import org.eclipse.papyrus.views.search.scope.ScopeEntry;
import org.eclipse.ui.PartInitException;
import org.eclipse.uml2.uml.Stereotype;

/**
 * 
 * A match raised by the value of an attribute
 * 
 */
public class AttributeMatch extends ModelMatch {

	/**
	 * The element containing the value of the attribute that matches
	 */

	protected URI uriSource;

	protected Object attribute;

	private Stereotype stereotype;



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
	public AttributeMatch(int offset, int lenght, Object target, ScopeEntry scopeEntry, Object attribute, Stereotype stereotype) {
		super(offset, lenght, target, scopeEntry);
		this.attribute = attribute;
		this.stereotype = stereotype;

		//		if(target instanceof EObject) {
		//			this.uriSource = EcoreUtil.getURI((EObject)target);
		//		}
		this.parent = new ResultEntry(target, scopeEntry);
		recursiveHierarchy((AbstractResultEntry)parent);
	}

	/**
	 * Create an attribute-match in a parent result entry that already exists.
	 * 
	 * @param parent
	 *        the parent result entry
	 * @param offset
	 * @param lengtt
	 * @param target
	 *        the element containing the value of the attribute that matches
	 * @param attribute
	 *        the attribute that raised the match
	 */
	public AttributeMatch(AbstractResultEntry parent, int offset, int length, Object target, Object attribute, Stereotype stereotype) {
		super(offset, length, target, (ScopeEntry)parent.getElement());

		this.attribute = attribute;
		this.stereotype = stereotype;
		this.parent = parent;
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
				if(((AttributeMatch)obj).getSource() instanceof EObject && this.getSource() instanceof EObject) {
					if(EcoreUtil.equals((EObject)((AttributeMatch)obj).getSource(), (EObject)this.getSource())) {
						return true;
					}
				} else {
					if(((AttributeMatch)obj).getSource().equals(this.getSource())) {
						return true;
					}
				}
			}
			return false;

		} else {
			return false;
		}
	}

	//	public Object getTarget() {
	//		//		ResourceSet resSet = new ResourceSetImpl();
	//		if(this.uriSource != null) {
	//			ResourceSet resSet = ((ScopeEntry)this.getElement()).getModelSet();
	//			return resSet.getEObject(this.uriSource, true);
	//		}
	//		return null;
	//
	//	}
	//
	//	public void setTarget(Object target) {
	//		if(target instanceof EObject) {
	//			this.uriSource = EcoreUtil.getURI((EObject)target);
	//		}
	//
	//	}

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
		return this.getSource();
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
			return service.openSemanticElement((EObject)this.getSource());
		}
		return null;
	}

	public Object getMetaAttribute() {
		// TODO Auto-generated method stub
		return this.attribute;
	}

	public Stereotype getStereotype() {
		return stereotype;
	}


	public void setStereotype(Stereotype stereotype) {
		this.stereotype = stereotype;
	}

}
