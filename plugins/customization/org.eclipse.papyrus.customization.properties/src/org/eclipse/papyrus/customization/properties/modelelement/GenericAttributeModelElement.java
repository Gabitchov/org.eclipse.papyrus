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
package org.eclipse.papyrus.customization.properties.modelelement;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.papyrus.infra.constraints.ConfigProperty;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForResource;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.infra.widgets.providers.AbstractStaticContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.papyrus.views.properties.modelelement.AbstractModelElement;
import org.eclipse.papyrus.views.properties.ui.WidgetAttribute;

/**
 * XWT relies a lot on reflectivity, as it is based on an XML syntax.
 * However, in some cases, we like to have real attributes, to use them as
 * specific properties in the Property view.
 * 
 * This ModelElement is a bridge between reflective properties and predefined
 * properties.
 * 
 * It has been designed to use pre-defined {@link ConfigProperty} and {@link WidgetAttribute}, but can also be used for other EMF classes based on
 * a key/value pair.
 * 
 * For example, some layouts need a "numColumns" property, but not all of them.
 * In fact, this property is specific to the "GridLayout" and
 * "PropertiesLayout". This property is defined via a key/value pair
 * (i.e. a {@link WidgetAttribute} which name is "numColumns" and the value is the
 * number of columns). However, in the property view, we want to display a field "Number
 * of Columns" when we select a GridLayout or PropertiesLayout.
 * 
 * The same goes for Constraints : EMFInstanceOf needs a "nsUri" and
 * "className" {@link ConfigProperty}, while "UmlInstanceOf" needs a
 * "umlClassName" {@link ConfigProperty}.
 * 
 * 
 * @see GenericPropertyModelElementFactory
 * @see GenericAttributeModelElementFactory
 * 
 * @author Camille Letavernier
 */
public class GenericAttributeModelElement extends AbstractModelElement {

	private EObject source;

	private EditingDomain domain;

	private EStructuralFeature createIn;

	private EFactory createFrom;

	private EClass createAsValue;

	private EClass createAsReference;

	/**
	 * 
	 * Constructs a new ModelElement for handling generic, reflective properties
	 * 
	 * @param source
	 *        The EObject being edited
	 * @param domain
	 *        The Editing domain on which the commands will be executed
	 * @param createIn
	 *        The Feature in which the new value will be created
	 * @param createFrom
	 *        The EFactory used to instantiate the value
	 * @param createAsValue
	 *        The EClass used to instantiate the value, if the value is an instance of datatype
	 * @param createAsReference
	 *        The EClass used to instantiate the value, if the value is a reference to an instance of EClass
	 */
	public GenericAttributeModelElement(EObject source, EditingDomain domain, EStructuralFeature createIn, EFactory createFrom, EClass createAsValue, EClass createAsReference) {
		this.source = source;
		this.domain = domain;
		this.createIn = createIn;
		this.createFrom = createFrom;
		this.createAsValue = createAsValue;
		this.createAsReference = createAsReference;
	}

	@Override
	public IObservableValue doGetObservable(String propertyPath) {
		return new GenericAttributeObservable(source, domain, createIn, createFrom, createAsValue, createAsReference, propertyPath);
	}

	@Override
	public IStaticContentProvider getContentProvider(String propertyPath) {
		return new AbstractStaticContentProvider() {

			public Object[] getElements() {
				Collection<EObject> result = ItemPropertyDescriptor.getReachableObjectsOfType(source, EcorePackage.eINSTANCE.getEObject());
				Iterator<EObject> iterator = result.iterator();
				while(iterator.hasNext()) {
					EObject eObject = iterator.next();
					if(!(eObject instanceof org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query)) {
						iterator.remove();
					}
				}
				return result.toArray();
			}
		};
	}

	@Override
	public ILabelProvider getLabelProvider(String propertyPath) {
		try {
			return ServiceUtilsForResource.getInstance().getServiceRegistry(source.eResource()).getService(LabelProviderService.class).getLabelProvider();
		} catch (ServiceException ex) {
			return new LabelProvider();
		}
	}

	@Override
	public Object getDefaultValue(String propertyPath) {
		return ""; //$NON-NLS-1$
	}
}
