/*****************************************************************************
 * Copyright (c) 2011 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Arthur Daussy (Atos) - Initial API and implementation
 *   Arthur Daussy - 371712 : 372745: [ActivityDiagram] Major refactoring group framework
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.activitygroup.request;

import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;

public class SetDeferredRequest extends SetRequest {

	protected IAdaptable elementToEdit;

	public SetDeferredRequest(TransactionalEditingDomain editinDomain, IAdaptable elementToEdit, EStructuralFeature feature, Object value) {
		super(editinDomain, null, feature, value);
		this.elementToEdit = elementToEdit;
	}

	public IAdaptable getElementToSet() {
		return elementToEdit;
	}

	/**
	 * @deprecated use {@link SetDeferredRequest#getElementToSet()}
	 */
	@Override
	public List getElementsToEdit() {
		return super.getElementsToEdit();
	}
}
