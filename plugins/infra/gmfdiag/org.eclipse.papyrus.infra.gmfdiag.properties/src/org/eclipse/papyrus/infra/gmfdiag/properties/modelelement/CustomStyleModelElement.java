/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.properties.modelelement;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.infra.gmfdiag.common.databinding.custom.CustomBooleanStyleObservableList;
import org.eclipse.papyrus.infra.gmfdiag.common.databinding.custom.CustomBooleanStyleObservableValue;
import org.eclipse.papyrus.infra.gmfdiag.common.databinding.custom.CustomEObjectStyleObservableList;
import org.eclipse.papyrus.infra.gmfdiag.common.databinding.custom.CustomEObjectStyleObservableValue;
import org.eclipse.papyrus.infra.gmfdiag.common.databinding.custom.CustomIntStyleObservableList;
import org.eclipse.papyrus.infra.gmfdiag.common.databinding.custom.CustomIntStyleObservableValue;
import org.eclipse.papyrus.infra.gmfdiag.common.databinding.custom.CustomStringStyleObservableList;
import org.eclipse.papyrus.infra.gmfdiag.common.databinding.custom.CustomStringStyleObservableValue;
import org.eclipse.papyrus.infra.widgets.creation.ReferenceValueFactory;
import org.eclipse.papyrus.infra.widgets.creation.StringEditionFactory;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.papyrus.views.properties.contexts.DataContextElement;
import org.eclipse.papyrus.views.properties.contexts.Property;
import org.eclipse.papyrus.views.properties.environment.Type;
import org.eclipse.papyrus.views.properties.modelelement.EMFModelElement;


public class CustomStyleModelElement extends EMFModelElement {

	private DataContextElement element;

	//this.view == super.source
	private View view;

	public CustomStyleModelElement(View source, DataContextElement context) {
		this(source, null, context);
	}

	public CustomStyleModelElement(View source, EditingDomain domain, DataContextElement element) {
		super(source, domain);
		this.element = element;
		this.view = source;
	}

	protected Property findProperty(String propertyPath) {
		for(Property property : element.getProperties()) {
			if(propertyPath.equals(property.getName())) {
				return property;
			}
		}
		return null;
	}

	@Override
	public IObservable doGetObservable(String propertyPath) {
		Property property = findProperty(propertyPath);
		if(property == null) {
			return null;
		}
		if(property.getMultiplicity() == 1) {
			switch(property.getType()) {
			case BOOLEAN:
				return new CustomBooleanStyleObservableValue(view, domain, propertyPath);
			case INTEGER:
				return new CustomIntStyleObservableValue(view, domain, propertyPath);
			case REFERENCE:
				return new CustomEObjectStyleObservableValue(view, domain, propertyPath);
			case STRING:
				return new CustomStringStyleObservableValue(view, domain, propertyPath);
			default:
				return null;
			}
		} else {
			switch(property.getType()) {
			case BOOLEAN:
				return new CustomBooleanStyleObservableList(view, domain, propertyPath);
			case INTEGER:
				return new CustomIntStyleObservableList(view, domain, propertyPath);
			case REFERENCE:
				return new CustomEObjectStyleObservableList(view, domain, propertyPath);
			case STRING:
				return new CustomStringStyleObservableList(view, domain, propertyPath);
			default:
				return null;
			}
		}
	}

	@Override
	public boolean isEditable(String propertyPath) {
		return findProperty(propertyPath) != null;
	}


	//TODO: Implement these methods for multivalued properties (XxxListStyle)

	@Override
	public IStaticContentProvider getContentProvider(String propertyPath) {
		return super.getContentProvider(propertyPath);
	}

	@Override
	public ILabelProvider getLabelProvider(String propertyPath) {
		return super.getLabelProvider(propertyPath);
	}

	@Override
	public boolean isOrdered(String propertyPath) {
		return true;
	}

	@Override
	public boolean isUnique(String propertyPath) {
		return false;
	}

	@Override
	public boolean isMandatory(String propertyPath) {
		return false;
	}

	@Override
	public boolean forceRefresh(String propertyPath) {
		return false;
	}

	@Override
	public ReferenceValueFactory getValueFactory(String propertyPath) {
		Property property = findProperty(propertyPath);
		if(property == null) {
			return null;
		}

		switch(property.getType()) {
		case STRING:
			return new StringEditionFactory();
		case INTEGER:
		case BOOLEAN:
			return null;
		case REFERENCE:
			return null;
		default:
			return null;
		}
	}

	@Override
	public Object getDefaultValue(String propertyPath) {
		return null;
	}

	@Override
	public boolean getDirectCreation(String propertyPath) {
		Property property = findProperty(propertyPath);
		if(property == null) {
			return false;
		}

		return property.getType() != Type.REFERENCE;
	}

}
