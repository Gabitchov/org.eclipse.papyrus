/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.common.service;

import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.uml.Element;

/**
 * Request to apply stereotype on elements
 */
public class ApplyStereotypeRequest extends CreateRequest {

	/** type of the Apply stereotype request */
	public static String APPLY_STEREOTYPE_REQUEST = "applyStereotype";

	/** stereotypes to apply */
	final protected List<String> stereotypes;

	protected IAdaptable viewAdapter;

	protected Element element;

	protected boolean renameWithFirstStereotype;


	/**
	 * Creates a new ApplyStereotypeRequest
	 * 
	 * @param objects
	 *        the list of stereotypes to apply, identified by their
	 *        qualified names
	 */
	public ApplyStereotypeRequest(IAdaptable viewAdapter, List<String> stereotypes, boolean renameWithFirstStereotype) {
		super();
		this.stereotypes = stereotypes;
		this.viewAdapter = viewAdapter;
		this.renameWithFirstStereotype = renameWithFirstStereotype;
		// initialize the type of this request
		setType(APPLY_STEREOTYPE_REQUEST);
	}

	public ApplyStereotypeRequest(Element element, List<String> stereotypes) {
		this.stereotypes = stereotypes;
		this.element = element;
		// initialize the type of this request
		setType(APPLY_STEREOTYPE_REQUEST);
	}

	/**
	 * Returns the list of stereotypes to apply, identified by their qualified
	 * names
	 * 
	 * @return the list of stereotypes to apply, identified by their qualified
	 *         names, or an empty list
	 */
	public List<String> getStereotypesToApply() {
		return stereotypes;
	}

	public boolean renameWithFirstStereotype() {
		return renameWithFirstStereotype;
	}
	
	public void setElement(Element elem) {
		this.element = elem;
	}

	public Element getElement() {
		if (element == null && viewAdapter != null) {
			View view = (View)viewAdapter.getAdapter(View.class);
			if (view != null && view.getElement() instanceof Element) {
				element = (Element)view.getElement();
			}
		}
		return element;
	}
}
