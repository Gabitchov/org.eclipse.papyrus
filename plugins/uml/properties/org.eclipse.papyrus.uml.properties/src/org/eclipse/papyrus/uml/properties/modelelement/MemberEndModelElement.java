/*****************************************************************************
 * Copyright (c) 2010, 2014 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 323802
 *  
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.modelelement;

import static org.eclipse.papyrus.uml.tools.databinding.OwnerObservableValue.ASSOCIATION;
import static org.eclipse.papyrus.uml.tools.databinding.OwnerObservableValue.CLASSIFIER;
import static org.eclipse.papyrus.uml.tools.util.MultiplicityParser.ANY;
import static org.eclipse.papyrus.uml.tools.util.MultiplicityParser.ONE;
import static org.eclipse.papyrus.uml.tools.util.MultiplicityParser.ONE_OR_MORE;
import static org.eclipse.papyrus.uml.tools.util.MultiplicityParser.OPTIONAL;

import java.util.List;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.StaticContentProvider;
import org.eclipse.papyrus.uml.properties.Activator;
import org.eclipse.papyrus.uml.tools.databinding.ExtensionEndMultiplicityObservableValue;
import org.eclipse.papyrus.uml.tools.databinding.MultiplicityObservableValue;
import org.eclipse.papyrus.uml.tools.databinding.NavigationObservableValue;
import org.eclipse.papyrus.uml.tools.databinding.OwnerObservableValue;
import org.eclipse.papyrus.views.properties.modelelement.AbstractModelElement;
import org.eclipse.uml2.uml.ExtensionEnd;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;

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
			if(source instanceof ExtensionEnd) {
				return new ExtensionEndMultiplicityObservableValue((ExtensionEnd)source, domain);
			}
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
			if(source instanceof ExtensionEnd) {
				return new StaticContentProvider(new String[]{ ONE, OPTIONAL });
			}
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
			List<Property> memberEnds = ((Property)source).getAssociation().getMemberEnds();
			if(memberEnds.size() == 2) {
				//Association between two associations : this doesn't make sense ?
				if(isAssociation(memberEnds.get(0)) && isAssociation(memberEnds.get(1))) {
					return false;
				}
			}
			return (((Property)source).getAssociation().getMemberEnds().size() <= 2) && !EMFHelper.isReadOnly(source);
		}
		return !EMFHelper.isReadOnly(source);
	}

	private boolean isAssociation(Property property) {
		return property.getType().eClass() == UMLPackage.eINSTANCE.getAssociation();
	}

	@Override
	public boolean forceRefresh(String propertyPath) {
		return propertyPath.equals(NAVIGABLE) || propertyPath.equals(OWNER);
	}
}
