/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.profilefacet.generation.factory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.facet.infra.facet.FacetReference;
import org.eclipse.emf.facet.infra.facet.impl.FacetAttributeImpl;
import org.eclipse.emf.facet.infra.query.ModelQuery;
import org.eclipse.emf.facet.infra.query.QueryFactory;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.Argument;
import org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.EStructuralFeatureArgument;
import org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.ParametricQuery;
import org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.ParametricqueryFactory;
import org.eclipse.papyrus.uml.profilefacet.generation.Activator;
import org.eclipse.papyrus.uml.profilefacet.generation.messages.Messages;
import org.eclipse.papyrus.uml.profilefacet.generation.utils.CreatedEObjectWithModelQuery;
import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.ProfileFacetFactory;
import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.ProfileFacetSet;
import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.StereotypeFacet;
import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.StereotypePropertyElement;
import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.StereotypePropertyFacetAttribute;
import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.StereotypePropertyFacetReference;
import org.eclipse.papyrus.uml.profilefacet.queries.registry.QueryRegistry;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * 
 * This factory allows to generate a ProfileEFacetSet from a UML Profile
 * 
 */
public class ProfileFacetGenericFactory {

	/** the string base_ used to identify stereotype properties */
	private static final String BASE_ = "base_"; //$NON-NLS-1$

	/** the string used for UML boolean */
	private static final String UML_BOOLEAN = "Boolean"; //$NON-NLS-1$

	/** the string used for UML integer */
	private static final String UML_INTEGER = "Integer"; //$NON-NLS-1$

	/** the string used for UML string */
	private static final String UML_STRING = "String"; //$NON-NLS-1$

	/** the string used for uml real */
	private static final String UML_REAL = "Real"; //$NON-NLS-1$

	/** the string used for uml unlimited natural */
	private static final String UML_UNLIMITED_NATURAL = "UnlimitedNatural"; //$NON-NLS-1$

	/** the facetOperation registry */
	private final QueryRegistry registry;

	/** String for the get query description */
	public static final String GET_QUERY_DESCRIPTION = "Getter for the stereotype property {0}";

	/** String for the set query description */
	public static final String SET_QUERY_DESCRIPTION = "Setter for the stereotype property {0}";

	//FIXME : manage the read-only properties 
	/**
	 * 
	 * Constructor.
	 * 
	 * @param resourceSet
	 *        the resourceSet which will be used to find required FacetOperation for Getter and Setter
	 */
	public ProfileFacetGenericFactory() {
		this.registry = new QueryRegistry();
	}


	/**
	 * 
	 * @param profile
	 * @return
	 *         the ProfileFacetSet for this profile or <code>null</code> if the profile argument doesn't contains steretoypes with properties
	 */
	public CreatedEObjectWithModelQuery<ProfileFacetSet> createProfileFacetSet(final Profile profile) {
		final ProfileFacetSet set = ProfileFacetFactory.eINSTANCE.createProfileFacetSet();
		set.setName(profile.getName());
		set.setProfileQualifiedName(profile.getQualifiedName());
		set.setNsPrefix(profile.getName());
		set.setNsURI("http://www.eclipse.org/papyrus/profilefacet/" + profile.getQualifiedName()); //$NON-NLS-1$
		set.setExtendedPackage(UMLPackage.eINSTANCE);
		final XMIResource res = (XMIResource)profile.eResource();
		final String XMI_ID = res.getID(profile);
		set.setRepresentedElement_XMI_ID(XMI_ID);
		Collection<ModelQuery> queries = new ArrayList<ModelQuery>();
		for(final PackageableElement packagedElement : profile.getPackagedElements()) {
			if(packagedElement instanceof Profile) {
				final CreatedEObjectWithModelQuery<ProfileFacetSet> createdElement = createProfileFacetSet((Profile)packagedElement);
				if(createdElement != null) {
					final ProfileFacetSet subProfile = createdElement.getCreatedElement();
					//We ignore empty facetSet
					if(subProfile != null && (subProfile.getStereotypeFacets().size() != 0 || subProfile.getSubProfileFacetSet().size() != 0)) {
						set.getESubpackages().add(subProfile);
						queries.addAll(createdElement.getCreatedQueries());
					}
				}
			} else if(packagedElement instanceof Stereotype) {
				final CreatedEObjectWithModelQuery<StereotypeFacet> createdElement = createFacet((Stereotype)packagedElement);
				final StereotypeFacet stereotypeFacet = createdElement.getCreatedElement();

				//we ignore stereotypes without properties

				if(stereotypeFacet.getStereotypePropertyElements().size() != 0) {
					set.getFacets().add(stereotypeFacet);
					queries.addAll(createdElement.getCreatedQueries());
				}
			}
		}

		if(set.getStereotypeFacets().size() != 0 || set.getSubProfileFacetSet().size() != 0) {
			return new CreatedEObjectWithModelQuery<ProfileFacetSet>(set, queries);
		}

		return null;

	}

	/**
	 * 
	 * @param stereotype
	 *        the stereotype for which we want to create the facet
	 * @return
	 *         the created facet for this stereotype or <code>null</code> if the stereotype doesn't contain property
	 */
	public CreatedEObjectWithModelQuery<StereotypeFacet> createFacet(final Stereotype stereotype) {
		final StereotypeFacet facet = ProfileFacetFactory.eINSTANCE.createStereotypeFacet();
		facet.setStereotypeQualifiedName(stereotype.getQualifiedName());
		facet.setName(stereotype.getName());
		facet.getESuperTypes().add(UMLPackage.eINSTANCE.getElement());
		final XMIResource res = (XMIResource)stereotype.eResource();
		final String XMI_ID = res.getID(stereotype);
		facet.setRepresentedElement_XMI_ID(XMI_ID);
		final Collection<String> ignoredPropertyName = new ArrayList<String>();

		for(final Class extendedMetaclassName : stereotype.getAllExtendedMetaclasses()) {
			ignoredPropertyName.add(BASE_ + extendedMetaclassName.getName());
		}

		final Collection<ModelQuery> queries = new ArrayList<ModelQuery>();
		//		for(final Property attribute : stereotype.getAllAttributes()) { //in this case we duplicate facet properties for the same attribute
		for(final Property attribute : stereotype.getAttributes()) {
			if(ignoredPropertyName.contains(attribute.getName())) {
				continue;
			}
			if(attribute.getType() instanceof DataType) {
				final CreatedEObjectWithModelQuery<StereotypePropertyFacetAttribute> createdValue = createFacetAttribute(attribute);
				if(createdValue.getCreatedElement() != null) {
					facet.getEAttributes().add(createdValue.getCreatedElement());
					queries.addAll(createdValue.getCreatedQueries());
				}
			} else if(attribute.getType() instanceof EObject) {
				final CreatedEObjectWithModelQuery<StereotypePropertyFacetReference> createdValue = createFacetReference(attribute);
				if(createdValue.getCreatedElement() != null) {
					facet.getEReferences().add(createdValue.getCreatedElement());
					queries.addAll(createdValue.getCreatedQueries());
				}
			}
		}


		return new CreatedEObjectWithModelQuery<StereotypeFacet>(facet, queries);
	}


	/**
	 * 
	 * @param property
	 *        the property used to create the FacetReference
	 * @return
	 *         the created FacetReference for this property
	 */
	public CreatedEObjectWithModelQuery<StereotypePropertyFacetReference> createFacetReference(final Property property) {
		final StereotypePropertyFacetReference facetReference = ProfileFacetFactory.eINSTANCE.createStereotypePropertyFacetReference();
		facetReference.setIsDerived(property.isDerived());
		facetReference.setChangeable(!property.isReadOnly());
		facetReference.setDerived(true);
		facetReference.setPropertyQualifiedName(property.getQualifiedName());
		final XMIResource res = (XMIResource)property.eResource();
		final String XMI_ID = res.getID(property);
		facetReference.setRepresentedElement_XMI_ID(XMI_ID);
		facetReference.setName(property.getName());
		final Type type = property.getType();
		final EClassifier eType = EcorePackage.eINSTANCE.getEObject();
		ParametricQuery getQuery;
		ParametricQuery setQuery;

		final int upperBound = property.upperBound();
		facetReference.setLowerBound(property.getLower());
		facetReference.setUpperBound(property.getUpper());

		//EObject reference
		if(type instanceof Element) {
			ModelQuery getCalledQuery = null;
			ModelQuery setCalledQuery = null;
			if(upperBound == -1 || upperBound > 1) {
				getCalledQuery = this.registry.getModelQuery(QueryRegistry.GET_EOBJECT_MULTI_REFERENCE_OPERATION_ID);
				setCalledQuery = this.registry.getModelQuery(QueryRegistry.SET_EOBJECT_MULTI_REFERENCE_OPERATION_ID);
			} else {
				getCalledQuery = this.registry.getModelQuery(QueryRegistry.GET_EOBJECT_SINGLE_REFERENCE_OPERATION_ID);
				setCalledQuery = this.registry.getModelQuery(QueryRegistry.GET_EOBJECT_SINGLE_REFERENCE_OPERATION_ID);
			}

			//we create the query
			getQuery = ParametricqueryFactory.eINSTANCE.createParametricQuery();
			setQuery = ParametricqueryFactory.eINSTANCE.createParametricQuery();

			getQuery.setCalledQuery(getCalledQuery);
			setQuery.setCalledQuery(setCalledQuery);
			//we prepare the arguments
			EStructuralFeatureArgument arg = ParametricqueryFactory.eINSTANCE.createEStructuralFeatureArgument();
			arg.setValue(facetReference);
			getQuery.setName("get_" + property.getQualifiedName() + "_value");
			getQuery.setDescription(NLS.bind(GET_QUERY_DESCRIPTION, property.getQualifiedName()));
			getQuery.getArguments().add(arg);
			getQuery.setLowerBound(facetReference.getLowerBound());
			getQuery.setUpperBound(facetReference.getUpperBound());
			getQuery.setReturnType(eType);

			setQuery.setName("set_" + property.getQualifiedName() + "_value");
			setQuery.setDescription(NLS.bind(SET_QUERY_DESCRIPTION, property.getQualifiedName()));
			setQuery.getArguments().add(arg);
			setQuery.setLowerBound(0);
			setQuery.setUpperBound(1);
			setQuery.setReturnType(eType);

		} else {
			return null;
		}
		facetReference.setEType(eType);
		facetReference.setValueQuery(getQuery);
		facetReference.setSetQuery(setQuery);
		final Collection<ModelQuery> queries = new ArrayList<ModelQuery>();
		queries.add(getQuery);
		queries.add(setQuery);
		return new CreatedEObjectWithModelQuery<StereotypePropertyFacetReference>(facetReference, queries);
	}

	/**
	 * 
	 * @param property
	 *        the property used to create the FacetAttribute
	 * @return
	 *         the created FacetAttribute for this property
	 */
	public CreatedEObjectWithModelQuery<StereotypePropertyFacetAttribute> createFacetAttribute(final Property property) {
		final Type type = property.getType();
		EClassifier eType = null;
		ParametricQuery getQuery;
		ParametricQuery setQuery;

		final int upperBound = property.upperBound();
		final StereotypePropertyFacetAttribute facetAttribute = ProfileFacetFactory.eINSTANCE.createStereotypePropertyFacetAttribute();
		facetAttribute.setIsDerived(property.isDerived());
		facetAttribute.setChangeable(!property.isReadOnly());
		facetAttribute.setDerived(true);

		facetAttribute.setPropertyQualifiedName(property.getQualifiedName());
		final XMIResource res = (XMIResource)property.eResource();
		final String XMI_ID = res.getID(property);
		facetAttribute.setRepresentedElement_XMI_ID(XMI_ID);

		facetAttribute.setName(property.getName());
		facetAttribute.setLowerBound(property.getLower());
		facetAttribute.setUpperBound(property.getUpper());
		ModelQuery getCalledQuery = null;
		ModelQuery setCalledQuery = null;
		//UML primitive type
		if(type instanceof PrimitiveType) {
			final PrimitiveType pType = (PrimitiveType)type;
			final String name = pType.getName();

			if(UML_BOOLEAN.equals(name)) {
				eType = EcorePackage.eINSTANCE.getEBoolean();
				if(upperBound == -1 || upperBound > 1) {
					getCalledQuery = this.registry.getModelQuery(QueryRegistry.GET_BOOLEAN_MULTI_VALUE_OPERATION_ID);
					setCalledQuery = this.registry.getModelQuery(QueryRegistry.SET_BOOLEAN_MULTI_VALUE_OPERATION_ID);
				} else {
					getCalledQuery = this.registry.getModelQuery(QueryRegistry.GET_BOOLEAN_SINGLE_VALUE_OPERATION_ID);
					setCalledQuery = this.registry.getModelQuery(QueryRegistry.SET_BOOLEAN_SINGLE_VALUE_OPERATION_ID);
				}
			} else if(UML_INTEGER.equals(name)) {
				eType = EcorePackage.eINSTANCE.getEInt();
				if(upperBound == -1 || upperBound > 1) {
					getCalledQuery = this.registry.getModelQuery(QueryRegistry.GET_INTEGER_MULTI_VALUE_OPERATION_ID);
					setCalledQuery = this.registry.getModelQuery(QueryRegistry.SET_INTEGER_MULTI_VALUE_OPERATION_ID);
				} else {
					getCalledQuery = this.registry.getModelQuery(QueryRegistry.GET_INTEGER_SINGLE_VALUE_OPERATION_ID);
					setCalledQuery = this.registry.getModelQuery(QueryRegistry.SET_INTEGER_SINGLE_VALUE_OPERATION_ID);
				}

			} else if(UML_REAL.equals(name)) {
				eType = EcorePackage.eINSTANCE.getEDouble();
				if(upperBound == -1 || upperBound > 1) {
					getCalledQuery = this.registry.getModelQuery(QueryRegistry.GET_REAL_MULTI_VALUE_OPERATION_ID);
					setCalledQuery = this.registry.getModelQuery(QueryRegistry.SET_REAL_MULTI_VALUE_OPERATION_ID);
				} else {
					getCalledQuery = this.registry.getModelQuery(QueryRegistry.GET_REAL_SINGLE_VALUE_OPERATION_ID);
					setCalledQuery = this.registry.getModelQuery(QueryRegistry.SET_REAL_SINGLE_VALUE_OPERATION_ID);
				}

			} else if(UML_STRING.equals(name)) {
				eType = EcorePackage.eINSTANCE.getEString();
				if(upperBound == -1 || upperBound > 1) {
					getCalledQuery = this.registry.getModelQuery(QueryRegistry.GET_STRING_MULTI_VALUE_OPERATION_ID);
					setCalledQuery = this.registry.getModelQuery(QueryRegistry.SET_STRING_MULTI_VALUE_OPERATION_ID);
				} else {
					getCalledQuery = this.registry.getModelQuery(QueryRegistry.GET_STRING_SINGLE_VALUE_OPERATION_ID);
					setCalledQuery = this.registry.getModelQuery(QueryRegistry.SET_STRING_SINGLE_VALUE_OPERATION_ID);
				}

			} else if(UML_UNLIMITED_NATURAL.equals(name)) {
				eType = EcorePackage.eINSTANCE.getEInt();
				if(upperBound == -1 || upperBound > 1) {
					getCalledQuery = this.registry.getModelQuery(QueryRegistry.GET_UNLIMITED_NATURAL_MULTI_VALUE_OPERATION_ID);
					setCalledQuery = this.registry.getModelQuery(QueryRegistry.SET_UNLIMITED_NATURAL_MULTI_VALUE_OPERATION_ID);
				} else {
					getCalledQuery = this.registry.getModelQuery(QueryRegistry.GET_UNLIMITED_NATURAL_SINGLE_VALUE_OPERATION_ID);
					setCalledQuery = this.registry.getModelQuery(QueryRegistry.SET_UNLIMITED_NATURAL_SINGLE_VALUE_OPERATION_ID);
				}

			}

		} else if(type instanceof Enumeration) {
			if(upperBound == -1 || upperBound > 1) {
				eType = UMLPackage.eINSTANCE.getEnumerationLiteral();
				getCalledQuery = this.registry.getModelQuery(QueryRegistry.GET_UML_ENUMERATION_MULTI_VALUE_OPERATION_ID);
				setCalledQuery = this.registry.getModelQuery(QueryRegistry.SET_UML_ENUMERATION_MULTI_VALUE_OPERATION_ID);
			} else {
				eType = UMLPackage.eINSTANCE.getEnumerationLiteral();
				getCalledQuery = this.registry.getModelQuery(QueryRegistry.GET_UML_ENUMERATION_SINGLE_VALUE_OPERATION_ID);
				setCalledQuery = this.registry.getModelQuery(QueryRegistry.SET_UML_ENUMERATION_SINGLE_VALUE_OPERATION_ID);
			}

		}

		if(eType == null) {
			if(type instanceof PrimitiveType) {
				eType = EcorePackage.eINSTANCE.getEString();
				if(upperBound == -1 || upperBound > 1) {
					getCalledQuery = this.registry.getModelQuery(QueryRegistry.GET_PRIMITIVE_TYPE_MULTI_VALUE_OPERATION_ID);
					setCalledQuery = this.registry.getModelQuery(QueryRegistry.SET_PRIMITIVE_TYPE_MULTI_VALUE_OPERATION_ID);
				} else {
					getCalledQuery = this.registry.getModelQuery(QueryRegistry.GET_PRIMITIVE_TYPE_SINGLE_VALUE_OPERATION_ID);
					setCalledQuery = this.registry.getModelQuery(QueryRegistry.SET_PRIMITIVE_TYPE_SINGLE_VALUE_OPERATION_ID);
				}
			} else if(type instanceof DataType) {
				eType = EcorePackage.eINSTANCE.getEString();
				if(upperBound == -1 || upperBound > 1) {
					getCalledQuery = this.registry.getModelQuery(QueryRegistry.GET_DATATYPE_MULTI_VALUE_OPERATION_ID);
					setCalledQuery = this.registry.getModelQuery(QueryRegistry.SET_DATATYPE_MULTI_VALUE_OPERATION_ID);
				} else {
					getCalledQuery = this.registry.getModelQuery(QueryRegistry.GET_DATATYPE_SINGLE_VALUE_OPERATION_ID);
					setCalledQuery = this.registry.getModelQuery(QueryRegistry.SET_DATATYPE_SINGLE_VALUE_OPERATION_ID);
				}
			} else {
				Activator.log.warn(NLS.bind(Messages.ProfileEFacetGenericFactory_TypeNotManagedMessage, type));
				return null;

			}
		}

		//1. we create the queries
		getQuery = ParametricqueryFactory.eINSTANCE.createParametricQuery();
		setQuery = ParametricqueryFactory.eINSTANCE.createParametricQuery();
		getQuery.setCalledQuery(getCalledQuery);
		setQuery.setCalledQuery(setCalledQuery);
		//we prepare the arguments
		final EStructuralFeatureArgument argument = ParametricqueryFactory.eINSTANCE.createEStructuralFeatureArgument();
		argument.setValue(facetAttribute);

		getQuery.setName("get_" + property.getQualifiedName() + "_value");
		getQuery.setDescription(NLS.bind(GET_QUERY_DESCRIPTION, property.getQualifiedName()));
		getQuery.getArguments().add(argument);
		getQuery.setLowerBound(facetAttribute.getLowerBound());
		getQuery.setUpperBound(facetAttribute.getUpperBound());
		getQuery.setReturnType(eType);

		setQuery.setName("set_" + property.getQualifiedName() + "_value");
		setQuery.setDescription(NLS.bind(SET_QUERY_DESCRIPTION, property.getQualifiedName()));
		setQuery.getArguments().add(argument);
		setQuery.setLowerBound(0);
		setQuery.setUpperBound(1);
		setQuery.setReturnType(eType);

		facetAttribute.setEType(eType);
		facetAttribute.setValueQuery(getQuery);
		facetAttribute.setSetQuery(setQuery);
		final Collection<ModelQuery> queries = new ArrayList<ModelQuery>();
		queries.add(getQuery);
		queries.add(setQuery);
		return new CreatedEObjectWithModelQuery<StereotypePropertyFacetAttribute>(facetAttribute, queries);
	}

}
