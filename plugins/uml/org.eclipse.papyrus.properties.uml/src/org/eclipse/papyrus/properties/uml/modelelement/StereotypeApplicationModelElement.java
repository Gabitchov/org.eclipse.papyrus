/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.uml.modelelement;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.properties.modelelement.AbstractModelElement;
import org.eclipse.papyrus.properties.providers.EMFObjectLabelProvider;
import org.eclipse.papyrus.properties.uml.databinding.ProfileApplicationObservableList;
import org.eclipse.papyrus.properties.uml.databinding.StereotypeApplicationObservableList;
import org.eclipse.papyrus.properties.uml.providers.ApplicableStereotypeContentProvider;
import org.eclipse.papyrus.widgets.providers.IStaticContentProvider;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;

/**
 * A ModelElement for handling stereotypes applied on a UML Element
 * 
 * @author Camille Letavernier
 */
public class StereotypeApplicationModelElement extends AbstractModelElement {

	private Element umlSource;

	private EditingDomain domain;

	public StereotypeApplicationModelElement(Element umlSource, EditingDomain domain) {
		this.umlSource = umlSource;
		this.domain = domain;
	}

	public IObservable getObservable(String propertyPath) {
		if(propertyPath.equals("stereotypeApplication")) {
			return new StereotypeApplicationObservableList(umlSource, domain);
		} else if(propertyPath.equals("profileApplication")) {
			return new ProfileApplicationObservableList((Package)umlSource, domain);
		}

		return null;
	}

	@Override
	public ILabelProvider getLabelProvider(String propertyPath) {
		return new EMFObjectLabelProvider();
	}

	@Override
	public IStaticContentProvider getContentProvider(String propertyPath) {
		return new ApplicableStereotypeContentProvider(umlSource);
	}

	@Override
	public boolean isUnique(String propertyPath) {
		return true;
	}

	@Override
	public boolean isOrdered(String propertyPath) {
		return false;
	}
}
