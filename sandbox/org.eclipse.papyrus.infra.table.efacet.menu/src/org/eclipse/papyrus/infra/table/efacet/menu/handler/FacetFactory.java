package org.eclipse.papyrus.infra.table.efacet.menu.handler;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.EFacetFactory;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetOperation;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetReference;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.query.EObjectLiteralQuery;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.query.OperationCallQuery;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.query.QueryFactory;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.query.StringLiteralQuery;
import org.eclipse.papyrus.uml.efacet.metamodel.umlefacet.ProfileFacetSet;
import org.eclipse.papyrus.uml.efacet.metamodel.umlefacet.StereotypeFacet;
import org.eclipse.papyrus.uml.efacet.metamodel.umlefacet.StereotypePropertyFacetAttribute;
import org.eclipse.papyrus.uml.efacet.metamodel.umlefacet.StereotypePropertyFacetReference;
import org.eclipse.papyrus.uml.efacet.metamodel.umlefacet.UmlEFacetFactory;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;

public class FacetFactory {


	private FacetFactory() {
		//to prevent instanciation
	}

	public static final String UML_BOOLEAN = "Boolean";

	public static final String UML_INTEGER = "Integer";

	public static final String UML_STRING = "String";

	public static final String UML_REAL = "Real";

	public static final String UML_UNLIMITED_NATURAL = "UnlimitedNatural";

	public static final FacetSet createFacetSet(final String name, final String nsPrefix, final String nsURI, final String documentation) {
		final FacetSet set = EFacetFactory.eINSTANCE.createFacetSet();
		set.setName(name);
		set.setNsPrefix(nsPrefix);
		set.setNsURI(nsURI);
		set.setDocumentation(documentation);
		return set;
	}

	/**
	 * 
	 * @param profile
	 * @return
	 *         the ProfileFacetSet for this profile or <code>null</code> if the profile argument doesn't contains steretoypes with properties
	 */
	public static final ProfileFacetSet createProfileFacetSet(final Profile profile) {
		final ProfileFacetSet set = UmlEFacetFactory.eINSTANCE.createProfileFacetSet();
		set.setName(profile.getName());
		set.setProfileQualifiedName(profile.getQualifiedName());
		profile.getPackagedElements();
		for(final PackageableElement packagedElement : profile.getPackagedElements()) {
			if(packagedElement instanceof Profile) {
				final ProfileFacetSet subProfile = createProfileFacetSet((Profile)packagedElement);
				//We ignore empty facetSet
				if(subProfile != null && (subProfile.getEClassifiers().size() != 0 || subProfile.getESubpackages().size() != 0)) {
					set.getESubpackages().add(subProfile);
				}
			} else if(packagedElement instanceof Stereotype) {
				//TODO and inherited properties
				//we ignore stereotypes without properties
				final StereotypeFacet stereotypeFacet = createFacet((Stereotype)packagedElement);
				if(stereotypeFacet.getFacetElements().size() != 0) {
					set.getEClassifiers().add(stereotypeFacet);
				}
			}
		}

		//TODO
		//		set.setNsPrefix(nsPrefix);
		//		set.setNsURI(nsURI);
		//		set.setDocumentation(documentation);

		if(set.getEClassifiers().size() != 0 || set.getESubpackages().size() != 0) {
			return set;
		}
		return null;

	}

	public static final StereotypeFacet createFacet(final Stereotype stereotype) {
		final StereotypeFacet facet = UmlEFacetFactory.eINSTANCE.createStereotypeFacet();
		facet.setStereotypeQualifiedName(stereotype.getQualifiedName());
		facet.setName(stereotype.getName());
		facet.setDocumentation("This facet represents the eClass " + stereotype.getName());
		//		facet.setConformanceTypedElement(value);//TODO
		facet.setExtendedMetaclass(UMLPackage.eINSTANCE.getElement());//TODO
		//TODO and inherited properties?
		final Collection<String> ignoredPropertyName = new ArrayList<String>();

		final String BASE_ = "base_"; //TODO move it in another plugin!
		for(final Class tutu : stereotype.getExtendedMetaclasses()) {
			ignoredPropertyName.add(BASE_ + tutu.getName());
		}
		for(final Property attribute : stereotype.getOwnedAttributes()) {
			if(ignoredPropertyName.contains(attribute.getName())) {
				continue;
			}
			if(attribute.getType() instanceof DataType) {
				final StereotypePropertyFacetAttribute facetAttr = createFacetAttribute(attribute, stereotype);
				facet.getFacetElements().add(facetAttr);
			} else if(attribute.getType() instanceof Element) {//or EObject TODO ?
				final StereotypePropertyFacetReference facetRef = createFacetReference(attribute, stereotype);
				facet.getFacetElements().add(facetRef);
			}
		}

		//		//We create the query to get the reprensentedStereotype
		//		final FacetOperation operation = EFacetFactory.eINSTANCE.createFacetOperation();
		//		operation.setLowerBound(1);
		//		operation.setUpperBound(1);
		//		operation.setDocumentation("Returns the qualified name of the represented stereotype");
		//		operation.setName("getStereotypeQualifiedName");
		//		//		operation.setEType(); //string
		//		final StringLiteralQuery query = QueryFactory.eINSTANCE.createStringLiteralQuery();
		//		query.setValue(stereotype.getQualifiedName());
		//		operation.setQuery(query);
		return facet;
	}





	public static final StereotypePropertyFacetReference createFacetReference(final Property attribute2, final Stereotype ste) {
		final StereotypePropertyFacetReference facetReference = UmlEFacetFactory.eINSTANCE.createStereotypePropertyFacetReference();
		facetReference.setIsDerived(attribute2.isDerived());
		facetReference.setPropertyName(attribute2.getName());

		facetReference.setName(attribute2.getName());
		facetReference.setDocumentation("This Facet Attribute represents the stereotype property " + attribute2.getQualifiedName());
		facetReference.setChangeable(!attribute2.isDerived());
		facetReference.setDerived(true);
		final Type type = attribute2.getType();
		final EClassifier eType = EcorePackage.eINSTANCE.getEObject(); //TODO or element ?
		OperationCallQuery query;
		FacetOperation facetOperationCalled = null;
		final int upperBound = attribute2.upperBound();

		//UML primitive type
		if(type instanceof Element) {
			if(upperBound == -1 || upperBound > 1) {
				facetOperationCalled = FacetOperationUtils.getEObjectMultiReferenceOperation(attribute2.eResource().getResourceSet());
			} else {
				facetOperationCalled = FacetOperationUtils.getEObjectSingleReferenceOperation(attribute2.eResource().getResourceSet());
			}

			//we prepare the arguments
			query = QueryFactory.eINSTANCE.createOperationCallQuery();
			query.setCanHaveSideEffects(false);

			final EObjectLiteralQuery featureQuery = QueryFactory.eINSTANCE.createEObjectLiteralQuery();
			featureQuery.setElement(facetReference);
			query.getArguments().add(featureQuery);
//			final StringLiteralQuery qualifiedNameQuery = QueryFactory.eINSTANCE.createStringLiteralQuery();
//			qualifiedNameQuery.setValue(ste.getQualifiedName());
//			query.getArguments().add(qualifiedNameQuery);
//
//			final StringLiteralQuery propertyNameQuery = QueryFactory.eINSTANCE.createStringLiteralQuery();
//			propertyNameQuery.setValue(attribute2.getName());
//			query.getArguments().add(propertyNameQuery);
			
			facetReference.setQuery(query);

			query.setOperation(facetOperationCalled);
		} else {
			//TODO?
		}
		facetReference.setEType(eType);
		facetReference.setLowerBound(attribute2.getLower());
		facetReference.setUpperBound(attribute2.getUpper());
		return facetReference;
	}



	//the first version with the qualifiedName
	public static final StereotypePropertyFacetAttribute createFacetAttribute(final Property attribute2, final Stereotype ste) {
		final ResourceSet set = attribute2.eResource().getResourceSet();
		//		final FacetAttribute facetAttribute = EFacetFactory.eINSTANCE.createFacetAttribute();

		final StereotypePropertyFacetAttribute facetAttribute = UmlEFacetFactory.eINSTANCE.createStereotypePropertyFacetAttribute();
		facetAttribute.setIsDerived(attribute2.isDerived());
		facetAttribute.setPropertyName(attribute2.getName());


		facetAttribute.setName(attribute2.getName());
		facetAttribute.setDocumentation("This Facet Attribute represents the stereotype property " + attribute2.getQualifiedName());
		facetAttribute.setChangeable(!attribute2.isDerived());
		facetAttribute.setDerived(true);
		final Type type = attribute2.getType();
		EClassifier eType = null;
		OperationCallQuery query;
		FacetOperation facetOperationCalled = null;
		final int upperBound = attribute2.upperBound();

		//UML primitive type
		if(type instanceof PrimitiveType) {
			final PrimitiveType pType = (PrimitiveType)type;
			final String name = pType.getName();
			if(UML_BOOLEAN.equals(name)) {
				eType = EcorePackage.eINSTANCE.getEBoolean();
				if(upperBound == -1 || upperBound > 1) {
					facetOperationCalled = FacetOperationUtils.getBooleanMultiValueOperation(set);
				} else {
					facetOperationCalled = FacetOperationUtils.getBooleanSingleValueOperation(set);
				}
			} else if(UML_INTEGER.equals(name)) {
				eType = EcorePackage.eINSTANCE.getEInt();
				if(upperBound == -1 || upperBound > 1) {
					facetOperationCalled = FacetOperationUtils.getIntegerMultiValueOperation(set);
				} else {
					facetOperationCalled = FacetOperationUtils.getIntegerSingleValueOperation(set);
				}

			} else if(UML_REAL.equals(name)) {
				eType = EcorePackage.eINSTANCE.getEDouble();
				if(upperBound == -1 || upperBound > 1) {
					facetOperationCalled = FacetOperationUtils.getRealMultiValueOperation(set);
				} else {
					facetOperationCalled = FacetOperationUtils.getRealSingleValueOperation(set);
				}

			} else if(UML_STRING.equals(name)) {
				eType = EcorePackage.eINSTANCE.getEString();
				if(upperBound == -1 || upperBound > 1) {
					facetOperationCalled = FacetOperationUtils.getStringMultiValueOperation(set);
				} else {
					facetOperationCalled = FacetOperationUtils.getStringSingleValueOperation(set);
				}

			} else if(UML_UNLIMITED_NATURAL.equals(name)) {
				eType = EcorePackage.eINSTANCE.getEInt();
				if(upperBound == -1 || upperBound > 1) {
					facetOperationCalled = FacetOperationUtils.getUnlimitedNaturalMultiValueOperation(set);
				} else {
					facetOperationCalled = FacetOperationUtils.getUnlimitedNaturalSingleValueOperation(attribute2.eResource().getResourceSet());
				}

			}


			//we prepare the arguments
			query = QueryFactory.eINSTANCE.createOperationCallQuery();
			query.setCanHaveSideEffects(false);

			final EObjectLiteralQuery featureQuery = QueryFactory.eINSTANCE.createEObjectLiteralQuery();
			featureQuery.setElement(facetAttribute);
			query.getArguments().add(featureQuery);
			
//			final StringLiteralQuery qualifiedNameQuery = QueryFactory.eINSTANCE.createStringLiteralQuery();
//			qualifiedNameQuery.setValue(ste.getQualifiedName());
//			query.getArguments().add(qualifiedNameQuery);
//
//			final StringLiteralQuery propertyNameQuery = QueryFactory.eINSTANCE.createStringLiteralQuery();
//			propertyNameQuery.setValue(attribute2.getName());
//			query.getArguments().add(propertyNameQuery);
			facetAttribute.setQuery(query);

			query.setOperation(facetOperationCalled);

		} else if(type instanceof DataType) {
			//TODO
		}

		facetAttribute.setEType(eType);//TODO
		//		attribute.setQuery(query);////TODO
		facetAttribute.setLowerBound(attribute2.getLower());
		facetAttribute.setUpperBound(attribute2.getUpper());
		return facetAttribute;
	}

	//	//the second version with references to property and stereitype
	//	public static final FacetAttribute createFacetAttribute2(Property attribute2, final Stereotype ste) {
	//		FacetAttribute facetAttribute = EFacetFactory.eINSTANCE.createFacetAttribute();
	//		facetAttribute.setName(attribute2.getName());
	//		facetAttribute.setDocumentation("This Facet Attribute represents the stereotype property " + attribute2.getQualifiedName());
	//		facetAttribute.setChangeable(!attribute2.isDerived());
	//		facetAttribute.setDerived(true);
	//		Type type = attribute2.getType();
	//		EClassifier eType = null;
	//		OperationCallQuery query;
	//		FacetOperation facetOperationCalled = null;
	//		int upperBound = facetAttribute.getUpperBound();
	//		if(type instanceof PrimitiveType) {
	//			PrimitiveType pType = (PrimitiveType)type;
	//			final String name = pType.getName();
	//			if("EString".equals(name) || "String".equals(name)) {
	//				eType = EcorePackage.eINSTANCE.getEString();
	//				if(upperBound > 1) {
	//					//TODO
	//				} else {
	//					facetOperationCalled = getSingleStringValueOperation2(attribute2.eResource().getResourceSet());
	//				}
	//			} else if("EBoolean".equals(name)) {
	//				eType = EcorePackage.eINSTANCE.getEBoolean();
	//			} else if("EInt".equals(name)) {
	//				eType = EcorePackage.eINSTANCE.getEInt();
	//			}
	//			//else TODO to finish
	//
	//
	//
	//
	//
	//			//we prepare the arguments
	//			query = QueryFactory.eINSTANCE.createOperationCallQuery();
	//			query.setCanHaveSideEffects(false);
	//
	//			EObjectLiteralQuery qualifiedNameQuery = QueryFactory.eINSTANCE.createEObjectLiteralQuery();
	//			qualifiedNameQuery.setElement(ste);
	//			query.getArguments().add(qualifiedNameQuery);
	//
	//			EObjectLiteralQuery propertyNameQuery = QueryFactory.eINSTANCE.createEObjectLiteralQuery();
	//			propertyNameQuery.setElement(attribute2);
	//			query.getArguments().add(propertyNameQuery);
	//			facetAttribute.setQuery(query);
	//
	//			query.setOperation(facetOperationCalled);
	//
	//		}
	//		facetAttribute.setEType(eType);//TODO
	//		//		attribute.setQuery(query);////TODO
	//		facetAttribute.setLowerBound(attribute2.getLower());
	//		facetAttribute.setUpperBound(attribute2.getUpper());
	//		return facetAttribute;
	//	}

	public static final FacetReference createFacetReference() {
		final FacetReference reference = EFacetFactory.eINSTANCE.createFacetReference();
		return reference;
	}
}
