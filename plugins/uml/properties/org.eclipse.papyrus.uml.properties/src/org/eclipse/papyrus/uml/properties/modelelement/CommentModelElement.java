/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Sebastien Poissonnet (CEA LIST) sebastien.poissonnet@cea.fr
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.modelelement;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.widgets.creation.ReferenceValueFactory;
import org.eclipse.papyrus.uml.properties.databinding.AppliedCommentsObservableList;
import org.eclipse.papyrus.views.properties.modelelement.EMFModelElement;
import org.eclipse.uml2.uml.Element;

public class CommentModelElement extends EMFModelElement {

	private static final String APPLIED_COMMENTS_PROPERTY = "appliedComments";

	public CommentModelElement(Element source, EditingDomain domain) {
		super(source, domain);
	}

	@Override
	public boolean isOrdered(String propertyPath) {
		if(APPLIED_COMMENTS_PROPERTY.equals(propertyPath)) {
			return false;
		}
		return super.isOrdered(propertyPath);
	}

	@Override
	public boolean isUnique(String propertyPath) {
		if(APPLIED_COMMENTS_PROPERTY.equals(propertyPath)) {
			return true;
		}
		return super.isUnique(propertyPath);
	}

	@Override
	protected IObservable doGetObservable(String propertyPath) {
		if(APPLIED_COMMENTS_PROPERTY.equals(propertyPath)) {
			return new AppliedCommentsObservableList(domain, (Element)source);
		}
		return super.doGetObservable(propertyPath);
	}

	@Override
	public ReferenceValueFactory getValueFactory(String propertyPath) {
		if(APPLIED_COMMENTS_PROPERTY.equals(propertyPath)) {
			return super.getValueFactory("ownedComment");
		}

		return super.getValueFactory(propertyPath);
	}

	@Override
	public boolean getDirectCreation(String propertyPath) {
		if(APPLIED_COMMENTS_PROPERTY.equals(propertyPath)) {
			return true;
		}
		return super.getDirectCreation(propertyPath);
	}

	@Override
	public boolean isEditable(String propertyPath) {
		if(APPLIED_COMMENTS_PROPERTY.equals(propertyPath)) {
			return true;
		}
		return super.isEditable(propertyPath);
	}

}
