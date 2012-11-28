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

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.facet.infra.query.ModelQuery;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.EStructuralFeatureArgument;
import org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.ParametricQuery;
import org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.ParametricqueryFactory;
import org.eclipse.papyrus.infra.emf.facet.queries.parametricquery.StringArgument;
import org.eclipse.papyrus.uml.profilefacet.generation.Activator;
import org.eclipse.papyrus.uml.profilefacet.generation.messages.Messages;
import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.ProfileFacetFactory;
import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.ProfileFacetSet;
import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.StereotypeFacet;
import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.StereotypePropertyFacetAttribute;
import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.StereotypePropertyFacetReference;
import org.eclipse.papyrus.uml.profilefacet.queries.registry.QueryRegistry;
import org.eclipse.papyrus.uml.profilefacet.utils.ArgumentUtils;
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
	public static final String GET_QUERY_DESCRIPTION = Messages.ProfileFacetGenericFactory_GetterForStereotypeProperty;

	/** String for the set query description */
	public static final String SET_QUERY_DESCRIPTION = Messages.ProfileFacetGenericFactory_SetterForStereotypeProperty;

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
	public ProfileFacetSet createProfileFacetSet(final Profile profile) {
		final ProfileFacetSet set = ProfileFacetFactory.eINSTANCE.createProfileFacetSet();
		set.setName(profile.getName());
		set.setProfileQualifiedName(profile.getQualifiedName());
		set.setNsPrefix(profile.getName());
		set.setNsURI("http://www.eclipse.org/papyrus/profilefacet/" + profile.getQualifiedName()); //$NON-NLS-1$
		set.setExtendedPackage(UMLPackage.eINSTANCE);
		final XMIResource res = (XMIResource)profile.eResource();
		final String XMI_ID = res.getID(profile);
		set.setRepresentedElement_XMI_ID(XMI_ID);
		for(final PackageableElement packagedElement : profile.getPackagedElements()) {
			if(packagedElement instanceof Profile) {
				final ProfileFacetSet subProfile = createProfileFacetSet((Profile)packagedElement);
				//We ignore empty facetSet
				if(subProfile != null && (subProfile.getStereotypeFacets().size() != 0 || subProfile.getSubProfileFacetSet().size() != 0)) {
					set.getESubpackages().add(subProfile);
				}
			} else if(packagedElement instanceof Stereotype) {
				final StereotypeFacet stereotypeFacet = createFacet((Stereotype)packagedElement);

				//we ignore stereotypes without properties

				if(stereotypeFacet.getStereotypePropertyElements().size() != 0) {
					set.getEClassifiers().add(stereotypeFacet);
				}
			}
		}

		if(set.getStereotypeFacets().size() != 0 || set.getSubProfileFacetSet().size() != 0) {
			return set;
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
	public StereotypeFacet createFacet(final Stereotype stereotype) {
		final StereotypeFacet facet = ProfileFacetFactory.eINSTANCE.createStereotypeFacet();
		final String stereotypeQualifiedName = stereotype.getQualifiedName();
		facet.setStereotypeQualifiedName(stereotypeQualifiedName);
		facet.setName(stereotype.getName());
		facet.getESuperTypes().add(UMLPackage.eINSTANCE.getElement());
		final XMIResource res = (XMIResource)stereotype.eResource();
		final String XMI_ID = res.getID(stereotype);
		facet.setRepresentedElement_XMI_ID(XMI_ID);
		final Collection<String> ignoredPropertyName = new ArrayList<String>();

		for(final Class extendedMetaclassName : stereotype.getAllExtendedMetaclasses()) {
			ignoredPropertyName.add(BASE_ + extendedMetaclassName.getName());
		}

		//		for(final Property attribute : stereotype.getAllAttributes()) { //in this case we duplicate facet properties for the same attribute
		for(final Property attribute : stereotype.getAttributes()) {
			if(ignoredPropertyName.contains(attribute.getName())) {
				continue;
			}
			if(attribute.getType() instanceof DataType) {
				final StereotypePropertyFacetAttribute attr = createFacetAttribute(attribute);
				if(attr != null) {
					facet.getEStructuralFeatures().add(attr);
				}
			} else if(attribute.getType() instanceof EObject) {
				final StereotypePropertyFacetReference ref = createFacetReference(attribute);
				if(ref != null) {
					facet.getEStructuralFeatures().add(ref);
				}
			}
		}


		//set the condition query (test on the appied stereotype)
		final ModelQuery query = getQueryForIsAppliedStereotype(stereotypeQualifiedName);
		facet.setConditionQuery(query);
		return facet;
	}

	/**
	 * 
	 * @param stereotypeQualifiedName
	 *        the stereotype qualified name
	 * @return
	 *         the query to test if the required stereotype is applied on the element
	 */
	protected ModelQuery getQueryForIsAppliedStereotype(final String stereotypeQualifiedName) {
		//1. create the returned query
		final ParametricQuery query = ParametricqueryFactory.eINSTANCE.createParametricQuery();
		query.setName("IsApplied_" + stereotypeQualifiedName + "_query"); //$NON-NLS-1$ //$NON-NLS-2$
		query.setLowerBound(0);
		query.setUpperBound(1);
		query.setReturnType(EcorePackage.eINSTANCE.getEBoolean());

		//2.create the argument for this query
		final StringArgument arg = ParametricqueryFactory.eINSTANCE.createStringArgument();
		arg.setArgumentName(ArgumentUtils.STEREOTYPE_QUALIFIED_NAME);
		arg.setValue(stereotypeQualifiedName);
		query.getArguments().add(arg);

		//3.set tge called query
		final ModelQuery testStereotypeCalledQuery = this.registry.getModelQuery(QueryRegistry.IS_APPLIED_REQUIRED_STEREOTYPE);
		query.setCalledQuery(testStereotypeCalledQuery);
		query.setDescription(NLS.bind("Test if the stereotype {0} or one of its specialization is applied on the element", stereotypeQualifiedName));
		return query;
	}

	/**
	 * 
	 * @param property
	 *        the property used to create the FacetReference
	 * @return
	 *         the created FacetReference for this property
	 */
	public StereotypePropertyFacetReference createFacetReference(final Property property) {
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


		final int upperBound = property.upperBound();
		facetReference.setLowerBound(property.getLower());
		facetReference.setUpperBound(property.getUpper());

		ModelQuery getCalledQuery = null;
		ModelQuery setCalledQuery = null;

		//EObject reference
		if(type instanceof Element) {

			if(upperBound == -1 || upperBound > 1) {
				getCalledQuery = this.registry.getModelQuery(QueryRegistry.GET_EOBJECT_MULTI_REFERENCE_OPERATION_ID);
				setCalledQuery = this.registry.getModelQuery(QueryRegistry.SET_EOBJECT_MULTI_REFERENCE_OPERATION_ID);
			} else {
				getCalledQuery = this.registry.getModelQuery(QueryRegistry.GET_EOBJECT_SINGLE_REFERENCE_OPERATION_ID);
				setCalledQuery = this.registry.getModelQuery(QueryRegistry.GET_EOBJECT_SINGLE_REFERENCE_OPERATION_ID);
			}

		} else {
			return null;
		}
		//1. we create the getValueQuery
		ParametricQuery getQuery = getQuery = ParametricqueryFactory.eINSTANCE.createParametricQuery();
		getQuery.setName("get_" + property.getQualifiedName() + "_value"); //$NON-NLS-1$ //$NON-NLS-2$
		getQuery.setDescription(NLS.bind(GET_QUERY_DESCRIPTION, property.getQualifiedName()));

		getQuery.setLowerBound(facetReference.getLowerBound());
		getQuery.setUpperBound(facetReference.getUpperBound());
		getQuery.setReturnType(eType);

		getQuery.setCalledQuery(getCalledQuery);
		//1.bis we create the argument
		final EStructuralFeatureArgument getArgument = ParametricqueryFactory.eINSTANCE.createEStructuralFeatureArgument();
		getArgument.setArgumentName(ArgumentUtils.EDITED_FEATURE);
		getArgument.setValue(facetReference);
		getQuery.getArguments().add(getArgument);


		//2. we create the setValueQuery
		ParametricQuery setQuery = ParametricqueryFactory.eINSTANCE.createParametricQuery();
		setQuery.setName("set_" + property.getQualifiedName() + "_value"); //$NON-NLS-1$ //$NON-NLS-2$
		setQuery.setDescription(NLS.bind(SET_QUERY_DESCRIPTION, property.getQualifiedName()));
		setQuery.setLowerBound(0);
		setQuery.setUpperBound(1);
		setQuery.setReturnType(eType);
		setQuery.setCalledQuery(setCalledQuery);
		//2.bis we create the argument
		final EStructuralFeatureArgument setArgument = ParametricqueryFactory.eINSTANCE.createEStructuralFeatureArgument();
		setArgument.setArgumentName(ArgumentUtils.EDITED_FEATURE);
		setArgument.setValue(facetReference);
		setQuery.getArguments().add(setArgument);

		facetReference.setEType(eType);
		facetReference.setValueQuery(getQuery);
		facetReference.setSetQuery(setQuery);

		return facetReference;
	}

	/**
	 * 
	 * @param property
	 *        the property used to create the FacetAttribute
	 * @return
	 *         the created FacetAttribute for this property
	 */
	public StereotypePropertyFacetAttribute createFacetAttribute(final Property property) {
		final Type type = property.getType();
		EClassifier eType = null;
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
				Activator.log.warn(NLS.bind(Messages.ProfileFacetGenericFactory_TheTypeIsNotManaged, type));
				return null;

			}
		}

		facetAttribute.setEType(eType);

		//1. we create the getValueQuery
		final ParametricQuery getQuery = ParametricqueryFactory.eINSTANCE.createParametricQuery();
		getQuery.setCalledQuery(getCalledQuery);
		getQuery.setName("get_" + property.getQualifiedName() + "_value"); //$NON-NLS-1$ //$NON-NLS-2$
		getQuery.setDescription(NLS.bind(GET_QUERY_DESCRIPTION, property.getQualifiedName()));
		getQuery.setLowerBound(facetAttribute.getLowerBound());
		getQuery.setUpperBound(facetAttribute.getUpperBound());
		getQuery.setReturnType(eType);

		//1.bis we prepare the argument
		final EStructuralFeatureArgument getArgument = ParametricqueryFactory.eINSTANCE.createEStructuralFeatureArgument();
		getArgument.setValue(facetAttribute);
		getArgument.setArgumentName(ArgumentUtils.EDITED_FEATURE);
		getQuery.getArguments().add(getArgument);

		facetAttribute.setValueQuery(getQuery);

		//2. we create the setValueQuery
		final ParametricQuery setQuery = ParametricqueryFactory.eINSTANCE.createParametricQuery();
		setQuery.setCalledQuery(setCalledQuery);
		setQuery.setName("set_" + property.getQualifiedName() + "_value"); //$NON-NLS-1$ //$NON-NLS-2$
		setQuery.setDescription(NLS.bind(SET_QUERY_DESCRIPTION, property.getQualifiedName()));
		setQuery.setLowerBound(0);
		setQuery.setUpperBound(1);
		setQuery.setReturnType(eType);

		//2.bis we prepare the argument
		final EStructuralFeatureArgument setArgument = ParametricqueryFactory.eINSTANCE.createEStructuralFeatureArgument();
		setArgument.setValue(facetAttribute);
		setArgument.setArgumentName(ArgumentUtils.EDITED_FEATURE);
		setQuery.getArguments().add(setArgument);

		facetAttribute.setSetQuery(setQuery);
		return facetAttribute;
	}

}
