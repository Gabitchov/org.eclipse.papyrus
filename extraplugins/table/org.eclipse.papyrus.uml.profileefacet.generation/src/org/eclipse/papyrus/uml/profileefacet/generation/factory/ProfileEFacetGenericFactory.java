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
package org.eclipse.papyrus.uml.profileefacet.generation.factory;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetOperation;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.query.EObjectLiteralQuery;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.query.OperationCallQuery;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.query.QueryFactory;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.uml.profileefacet.generation.Activator;
import org.eclipse.papyrus.uml.profileefacet.generation.messages.Messages;
import org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.ProfileEFacetFactory;
import org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.ProfileFacetSet;
import org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.StereotypeFacet;
import org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.StereotypePropertyFacetAttribute;
import org.eclipse.papyrus.uml.profileefacet.metamodel.profileefacet.StereotypePropertyFacetReference;
import org.eclipse.papyrus.uml.profileefacet.queries.registry.FacetOperationRegistry;
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
public class ProfileEFacetGenericFactory {

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
	private final FacetOperationRegistry registry;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param resourceSet
	 *        the resourceSet which will be used to find required FacetOperation for Getter and Setter
	 */
	public ProfileEFacetGenericFactory(final ResourceSet resourceSet) {
		this.registry = new FacetOperationRegistry(resourceSet);
	}


	/**
	 * 
	 * @param profile
	 * @return
	 *         the ProfileFacetSet for this profile or <code>null</code> if the profile argument doesn't contains steretoypes with properties
	 */
	public ProfileFacetSet createProfileFacetSet(final Profile profile) {
		final ProfileFacetSet set = ProfileEFacetFactory.eINSTANCE.createProfileFacetSet();
		set.setName(profile.getName());
		set.setProfileQualifiedName(profile.getQualifiedName());
		set.setNsPrefix(profile.getName());
		set.setNsURI("http://www.eclipse.org/papyrus/profileefacet/" + profile.getQualifiedName()); //$NON-NLS-1$
		set.setDocumentation(NLS.bind(Messages.ProfileEFacetGenericFactory_FacetSetDocumentation, profile.getName()));
		final XMIResource res = (XMIResource)profile.eResource();
		final String XMI_ID = res.getID(profile);
		set.setRepresentedElement_XMI_ID(XMI_ID);

		for(final PackageableElement packagedElement : profile.getPackagedElements()) {
			if(packagedElement instanceof Profile) {
				final ProfileFacetSet subProfile = createProfileFacetSet((Profile)packagedElement);
				//We ignore empty facetSet
				if(subProfile != null && (subProfile.getEClassifiers().size() != 0 || subProfile.getESubpackages().size() != 0)) {
					set.getESubpackages().add(subProfile);
				}
			} else if(packagedElement instanceof Stereotype) {
				//we ignore stereotypes without properties
				final StereotypeFacet stereotypeFacet = createFacet((Stereotype)packagedElement);
				if(stereotypeFacet.getFacetElements().size() != 0) {
					set.getEClassifiers().add(stereotypeFacet);
				}
			}
		}

		if(set.getEClassifiers().size() != 0 || set.getESubpackages().size() != 0) {
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
		final StereotypeFacet facet = ProfileEFacetFactory.eINSTANCE.createStereotypeFacet();
		facet.setStereotypeQualifiedName(stereotype.getQualifiedName());
		facet.setName(stereotype.getName());
		facet.setDocumentation(NLS.bind(Messages.ProfileEFacetGenericFactory_FacetDocumentation, stereotype.getName()));
		facet.setExtendedMetaclass(UMLPackage.eINSTANCE.getElement());
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
				final StereotypePropertyFacetAttribute facetAttr = createFacetAttribute(attribute);
				if(facetAttr != null) {
					facet.getFacetElements().add(facetAttr);
				}
			} else if(attribute.getType() instanceof EObject) {
				final StereotypePropertyFacetReference facetRef = createFacetReference(attribute);
				if(facetRef != null) {
					facet.getFacetElements().add(facetRef);
				}
			}
		}

		return facet;
	}


	/**
	 * 
	 * @param property
	 *        the property used to create the FacetReference
	 * @return
	 *         the created FacetReference for this property
	 */
	public StereotypePropertyFacetReference createFacetReference(final Property property) {
		final StereotypePropertyFacetReference facetReference = ProfileEFacetFactory.eINSTANCE.createStereotypePropertyFacetReference();
		facetReference.setIsDerived(property.isDerived());
		facetReference.setChangeable(!property.isReadOnly());
		facetReference.setDerived(true);
		facetReference.setPropertyQualifiedName(property.getQualifiedName());
		final XMIResource res = (XMIResource)property.eResource();
		final String XMI_ID = res.getID(property);
		facetReference.setRepresentedElement_XMI_ID(XMI_ID);
		facetReference.setName(property.getName());
		facetReference.setDocumentation(NLS.bind(Messages.ProfileEFacetGenericFactory_FacetReferenceDocumentation, property.getQualifiedName()));	
		final Type type = property.getType();
		final EClassifier eType = EcorePackage.eINSTANCE.getEObject();
		OperationCallQuery query;
		FacetOperation facetOperationCalled = null;
		final int upperBound = property.upperBound();

		//UML primitive type
		if(type instanceof Element) {
			if(upperBound == -1 || upperBound > 1) {
				facetOperationCalled = this.registry.getFacetOperation(FacetOperationRegistry.EOBJECT_MULTI_REFERENCE_OPERATION_ID);
			} else {
				facetOperationCalled = this.registry.getFacetOperation(FacetOperationRegistry.EOBJECT_SINGLE_REFERENCE_OPERATION_ID);
			}

			//we prepare the arguments
			query = QueryFactory.eINSTANCE.createOperationCallQuery();
			query.setCanHaveSideEffects(false);

			final EObjectLiteralQuery featureQuery = QueryFactory.eINSTANCE.createEObjectLiteralQuery();
			featureQuery.setElement(facetReference);
			query.getArguments().add(featureQuery);
			facetReference.setQuery(query);
			query.setOperation(facetOperationCalled);
		} else {
			return null;
		}
		facetReference.setEType(eType);
		facetReference.setLowerBound(property.getLower());
		facetReference.setUpperBound(property.getUpper());
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
		OperationCallQuery query;
		FacetOperation facetOperationCalled = null;
		final int upperBound = property.upperBound();
		final StereotypePropertyFacetAttribute facetAttribute = ProfileEFacetFactory.eINSTANCE.createStereotypePropertyFacetAttribute();
		facetAttribute.setIsDerived(property.isDerived());
		facetAttribute.setChangeable(!property.isReadOnly());
		facetAttribute.setDerived(true);
		
		facetAttribute.setPropertyQualifiedName(property.getQualifiedName());
		final XMIResource res = (XMIResource)property.eResource();
		final String XMI_ID = res.getID(property);
		facetAttribute.setRepresentedElement_XMI_ID(XMI_ID);

		facetAttribute.setName(property.getName());
		facetAttribute.setDocumentation(NLS.bind(Messages.ProfileEFacetGenericFactory_FacetAttributeDocumentation, property.getQualifiedName()));

		//UML primitive type
		if(type instanceof PrimitiveType) {
			final PrimitiveType pType = (PrimitiveType)type;
			final String name = pType.getName();
			if(UML_BOOLEAN.equals(name)) {
				eType = EcorePackage.eINSTANCE.getEBoolean();
				if(upperBound == -1 || upperBound > 1) {
					facetOperationCalled = this.registry.getFacetOperation(FacetOperationRegistry.BOOLEAN_MULTI_VALUE_OPERATION_ID);
				} else {
					facetOperationCalled = this.registry.getFacetOperation(FacetOperationRegistry.BOOLEAN_SINGLE_VALUE_OPERATION_ID);
				}
			} else if(UML_INTEGER.equals(name)) {
				eType = EcorePackage.eINSTANCE.getEInt();
				if(upperBound == -1 || upperBound > 1) {
					facetOperationCalled = this.registry.getFacetOperation(FacetOperationRegistry.INTEGER_MULTI_VALUE_OPERATION_ID);
				} else {
					facetOperationCalled = this.registry.getFacetOperation(FacetOperationRegistry.INTEGER_SINGLE_VALUE_OPERATION_ID);
				}

			} else if(UML_REAL.equals(name)) {
				eType = EcorePackage.eINSTANCE.getEDouble();
				if(upperBound == -1 || upperBound > 1) {
					facetOperationCalled = this.registry.getFacetOperation(FacetOperationRegistry.REAL_MULTI_VALUE_OPERATION_ID);
				} else {
					facetOperationCalled = this.registry.getFacetOperation(FacetOperationRegistry.REAL_SINGLE_VALUE_OPERATION_ID);
				}

			} else if(UML_STRING.equals(name)) {
				eType = EcorePackage.eINSTANCE.getEString();
				if(upperBound == -1 || upperBound > 1) {
					facetOperationCalled = this.registry.getFacetOperation(FacetOperationRegistry.STRING_MULTI_VALUE_OPERATION_ID);
				} else {
					facetOperationCalled = this.registry.getFacetOperation(FacetOperationRegistry.STRING_SINGLE_VALUE_OPERATION_ID);
				}

			} else if(UML_UNLIMITED_NATURAL.equals(name)) {
				eType = EcorePackage.eINSTANCE.getEInt();
				if(upperBound == -1 || upperBound > 1) {
					facetOperationCalled = this.registry.getFacetOperation(FacetOperationRegistry.UNLIMITED_NATURAL_MULTI_VALUE_OPERATION_ID);
				} else {
					facetOperationCalled = this.registry.getFacetOperation(FacetOperationRegistry.UNLIMITED_NATURAL_SINGLE_VALUE_OPERATION_ID);
				}

			}

		} else if(type instanceof Enumeration) {
			if(upperBound == -1 || upperBound > 1) {
				eType = UMLPackage.eINSTANCE.getEnumerationLiteral();
				facetOperationCalled = this.registry.getFacetOperation(FacetOperationRegistry.UML_ENUMERATION_MULTI_VALUE_OPERATION_ID);
			} else {
				eType = UMLPackage.eINSTANCE.getEnumerationLiteral();
				facetOperationCalled = this.registry.getFacetOperation(FacetOperationRegistry.UML_ENUMERATION_SINGLE_VALUE_OPERATION_ID);
			}

		}

		if(eType == null) {
			if(type instanceof PrimitiveType) {
				eType = EcorePackage.eINSTANCE.getEString();
				if(upperBound == -1 || upperBound > 1) {
					facetOperationCalled = this.registry.getFacetOperation(FacetOperationRegistry.PRIMITIVE_TYPE_MULTI_VALUE_OPERATION_ID);
				} else {
					facetOperationCalled = this.registry.getFacetOperation(FacetOperationRegistry.PRIMITIVE_TYPE_SINGLE_VALUE_OPERATION_ID);
				}
			} else if(type instanceof DataType) {
				eType = EcorePackage.eINSTANCE.getEString();
				if(upperBound == -1 || upperBound > 1) {
					facetOperationCalled = this.registry.getFacetOperation(FacetOperationRegistry.DATATYPE_MULTI_VALUE_OPERATION_ID);
				} else {
					facetOperationCalled = this.registry.getFacetOperation(FacetOperationRegistry.DATATYPE_SINGLE_VALUE_OPERATION_ID);
				}
			} else {
				Activator.log.warn(NLS.bind(Messages.ProfileEFacetGenericFactory_TypeNotManagedMessage, type));
				return null;

			}
		}

		//we prepare the arguments
		query = QueryFactory.eINSTANCE.createOperationCallQuery();
		query.setCanHaveSideEffects(false);

		final EObjectLiteralQuery featureQuery = QueryFactory.eINSTANCE.createEObjectLiteralQuery();
		featureQuery.setElement(facetAttribute);
		query.getArguments().add(featureQuery);
		facetAttribute.setQuery(query);

		query.setOperation(facetOperationCalled);

		facetAttribute.setEType(eType);
		facetAttribute.setLowerBound(property.getLower());
		facetAttribute.setUpperBound(property.getUpper());
		return facetAttribute;
	}

}
