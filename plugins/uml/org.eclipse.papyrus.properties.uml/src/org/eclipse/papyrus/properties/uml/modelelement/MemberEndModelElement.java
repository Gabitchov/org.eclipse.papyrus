/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
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

import static org.eclipse.papyrus.properties.uml.databinding.MultiplicityObservableValue.ANY;
import static org.eclipse.papyrus.properties.uml.databinding.MultiplicityObservableValue.ONE;
import static org.eclipse.papyrus.properties.uml.databinding.MultiplicityObservableValue.ONE_OR_MORE;
import static org.eclipse.papyrus.properties.uml.databinding.MultiplicityObservableValue.OPTIONAL;
import static org.eclipse.papyrus.properties.uml.databinding.OwnerObservableValue.ASSOCIATION;
import static org.eclipse.papyrus.properties.uml.databinding.OwnerObservableValue.CLASSIFIER;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.properties.modelelement.AbstractModelElement;
import org.eclipse.papyrus.properties.uml.Activator;
import org.eclipse.papyrus.properties.uml.databinding.MultiplicityObservableValue;
import org.eclipse.papyrus.properties.uml.databinding.NavigationObservableValue;
import org.eclipse.papyrus.properties.uml.databinding.OwnerObservableValue;
import org.eclipse.papyrus.widgets.providers.IStaticContentProvider;
import org.eclipse.papyrus.widgets.providers.StaticContentProvider;
import org.eclipse.uml2.uml.Property;

/**
 * A Model Element for manipulating MemberEnd properties
 * 
 * @author Camille Letavernier
 */
public class MemberEndModelElement extends AbstractModelElement {

	private EObject source;

	private EditingDomain domain;

	/**
	 * The "multiplicity" virtual property
	 */
	public static String MULTIPLICITY = "multiplicity"; //$NON-NLS-1$

	/**
	 * The "owner" virtual property
	 */
	public static String OWNER = "owner"; //$NON-NLS-1$

	/**
	 * The "navigable" virtual property
	 */
	public static String NAVIGABLE = "navigable"; //$NON-NLS-1$

	/**
	 * 
	 * Constructor.
	 * 
	 * @param source
	 *        The EObject being edited
	 * @param domain
	 *        The Editing domain on which the commands will be executed
	 */
	public MemberEndModelElement(EObject source, EditingDomain domain) {
		this.source = source;
		this.domain = domain;
	}

	@Override
	public IObservable doGetObservable(String propertyPath) {
		if(propertyPath.equals(MULTIPLICITY)) {
			return new MultiplicityObservableValue(source, domain);
		} else if(propertyPath.equals(OWNER)) {
			return new OwnerObservableValue(source, domain);
		} else if(propertyPath.equals(NAVIGABLE)) {
			return new NavigationObservableValue(source, domain);
		}
		Activator.log.warn("The property " + propertyPath + " doesn't exist"); //$NON-NLS-1$ //$NON-NLS-2$
		return null;
	}

	@Override
	public IStaticContentProvider getContentProvider(String propertyPath) {
		if(propertyPath.equals(MULTIPLICITY)) {
			return new StaticContentProvider(new String[]{ ANY, ONE_OR_MORE, OPTIONAL, ONE });
		} else if(propertyPath.equals(OWNER)) {
			return new StaticContentProvider(new String[]{ ASSOCIATION, CLASSIFIER });
		}
		return super.getContentProvider(propertyPath);
	}

	@Override
	public boolean isMandatory(String propertyPath) {
		return true;
	}

	@Override
	public boolean isEditable(String propertyPath) {
		if(propertyPath.equals(OWNER)) {
			return ((Property)source).getAssociation().getMemberEnds().size() <= 2;
		}
		return true;
	}

	@Override
	public boolean forceRefresh(String propertyPath) {
		return propertyPath.equals(NAVIGABLE) || propertyPath.equals(OWNER);
	}
}
