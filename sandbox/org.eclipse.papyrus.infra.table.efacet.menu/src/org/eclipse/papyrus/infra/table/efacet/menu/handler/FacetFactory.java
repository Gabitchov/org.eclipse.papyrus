package org.eclipse.papyrus.infra.table.efacet.menu.handler;

import java.io.ObjectInputStream.GetField;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.facet.efacet.core.IFacetSetCatalogManager;
import org.eclipse.emf.facet.efacet.core.IFacetSetCatalogManagerFactory;
import org.eclipse.emf.facet.efacet.core.exception.FacetManagerException;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.EFacetFactory;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetAttribute;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetOperation;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetReference;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.query.EObjectLiteralQuery;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.query.OperationCallQuery;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.query.QueryFactory;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.query.StringLiteralQuery;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacetcatalog.EfacetcatalogFactory;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.emf.facet.efacet.core.*;

public class FacetFactory {


	private FacetFactory() {
		//to prevent instanciation
	}

	public static final FacetSet createFacetSet(final String name, final String nsPrefix, final String nsURI, final String documentation) {
		FacetSet set = EFacetFactory.eINSTANCE.createFacetSet();
		set.setName(name);
		set.setNsPrefix(nsPrefix);
		set.setNsURI(nsURI);
		set.setDocumentation(documentation);
		return set;
	}

	public static final Facet createFacet(final Stereotype stereotype) {
		Facet facet = EFacetFactory.eINSTANCE.createFacet();
		facet.setName(stereotype.getName());
		facet.setDocumentation("This facet represents the eClass " + stereotype.getName());
		//		facet.setConformanceTypedElement(value);//TODO
		facet.setExtendedMetaclass(UMLPackage.eINSTANCE.getElement());//TODO
		for(final Property attribute : stereotype.getOwnedAttributes()) {
			FacetAttribute facetAttr = createFacetAttribute2(attribute, stereotype);
			facet.getFacetElements().add(facetAttr);
		}

		//We create the query to get the reprensentedStereotype
		FacetOperation operation = EFacetFactory.eINSTANCE.createFacetOperation();
		operation.setLowerBound(1);
		operation.setUpperBound(1);
		operation.setDocumentation("Returns the qualified name of the represented stereotype");
		operation.setName("getStereotypeQualifiedName");
		//		operation.setEType(); //string
		StringLiteralQuery query = QueryFactory.eINSTANCE.createStringLiteralQuery();
		query.setValue(stereotype.getQualifiedName());
		operation.setQuery(query);
		return facet;
	}

	private static FacetOperation singleStringValueOperation;
	private static FacetOperation singleStringValueOperation2;

	private static FacetOperation multiStringValueOperation;

	private static FacetOperation singlePrimitiveTypeValueOperation;

	private static FacetOperation multiPrimitiveTypeValueOperation;

	private static Facet stereotypedElementFacet;



	private static final Facet getStereotypedElementFacet(final ResourceSet resourceSet) {
		if(stereotypedElementFacet == null) {
			IFacetSetCatalogManager manager = IFacetSetCatalogManagerFactory.DEFAULT.getOrCreateFacetSetCatalogManager(resourceSet);
			for(FacetSet set : manager.getRegisteredFacetSets()) {
				if("org.eclipse.papyrus.uml.efacet/0.9/UML_stereotype".equals(set.getNsURI())) {
					stereotypedElementFacet = (Facet)set.getEClassifier("stereotyped_element");
					break;
				}
			}
		}
		return stereotypedElementFacet;
	}

	private static FacetOperation getMultiPrimitiveTypeValueOperation(final ResourceSet resourceSet) {
		if(singleStringValueOperation == null) {
			final Facet stereotypedElementFacet = getStereotypedElementFacet(resourceSet);
			if(stereotypedElementFacet != null)
				for(final FacetOperation op : stereotypedElementFacet.getFacetOperations()) {
					if("getMultiPrimitiveTypeValue".equals(op.getName())) {
						multiPrimitiveTypeValueOperation = op;
						break;
					}
				}
		}
		return multiPrimitiveTypeValueOperation;
	}

	private static FacetOperation getSinglePrimitiveTypeValueOperation(final ResourceSet resourceSet) {
		if(singleStringValueOperation == null) {
			final Facet stereotypedElementFacet = getStereotypedElementFacet(resourceSet);
			if(stereotypedElementFacet != null)
				for(final FacetOperation op : stereotypedElementFacet.getFacetOperations()) {
					if("getSinglePrimitiveTypeValue".equals(op.getName())) {
						singlePrimitiveTypeValueOperation = op;
						break;
					}
				}
		}
		return singlePrimitiveTypeValueOperation;
	}

	private static FacetOperation getSingleStringValueOperation(final ResourceSet resourceSet) {
		if(singleStringValueOperation == null) {
			final Facet stereotypedElementFacet = getStereotypedElementFacet(resourceSet);
			if(stereotypedElementFacet != null)
				for(final FacetOperation op : stereotypedElementFacet.getFacetOperations()) {
					if("getSingleStringValue".equals(op.getName())) {
						singleStringValueOperation = op;
						break;
					}
				}
		}
		return singleStringValueOperation;
	}
	
	private static FacetOperation getSingleStringValueOperation2(final ResourceSet resourceSet) {
		if(singleStringValueOperation2 == null) {
			final Facet stereotypedElementFacet = getStereotypedElementFacet(resourceSet);
			if(stereotypedElementFacet != null)
				for(final FacetOperation op : stereotypedElementFacet.getFacetOperations()) {
					if("getSingleStringValue2".equals(op.getName())) {
						singleStringValueOperation2 = op;
						break;
					}
				}
		}
		return singleStringValueOperation2;
	}

	//the first version with the qualifiedName
	public static final FacetAttribute createFacetAttribute(Property attribute2, final Stereotype ste) {
		FacetAttribute facetAttribute = EFacetFactory.eINSTANCE.createFacetAttribute();
		facetAttribute.setName(attribute2.getName());
		facetAttribute.setDocumentation("This Facet Attribute represents the stereotype property " + attribute2.getQualifiedName());
		facetAttribute.setChangeable(!attribute2.isDerived());
		facetAttribute.setDerived(true);
		Type type = attribute2.getType();
		EClassifier eType = null;
		OperationCallQuery query;
		FacetOperation facetOperationCalled = null;
		int upperBound = facetAttribute.getUpperBound();
		if(type instanceof PrimitiveType) {
			PrimitiveType pType = (PrimitiveType)type;
			final String name = pType.getName();
			if("EString".equals(name)) {
				eType = EcorePackage.eINSTANCE.getEString();
				if(upperBound > 1) {
					//TODO
				} else {
					facetOperationCalled = getSingleStringValueOperation(attribute2.eResource().getResourceSet());
				}
			} else if("EBoolean".equals(name)) {
				eType = EcorePackage.eINSTANCE.getEBoolean();
			} else if("EInt".equals(name)) {
				eType = EcorePackage.eINSTANCE.getEInt();
			}
			//else TODO to finish





			//we prepare the arguments
			query = QueryFactory.eINSTANCE.createOperationCallQuery();
			query.setCanHaveSideEffects(false);

			StringLiteralQuery qualifiedNameQuery = QueryFactory.eINSTANCE.createStringLiteralQuery();
			qualifiedNameQuery.setValue(ste.getQualifiedName());
			query.getArguments().add(qualifiedNameQuery);

			StringLiteralQuery propertyNameQuery = QueryFactory.eINSTANCE.createStringLiteralQuery();
			propertyNameQuery.setValue(attribute2.getName());
			query.getArguments().add(propertyNameQuery);
			facetAttribute.setQuery(query);

			query.setOperation(facetOperationCalled);

		}
		facetAttribute.setEType(eType);//TODO
		//		attribute.setQuery(query);////TODO
		facetAttribute.setLowerBound(attribute2.getLower());
		facetAttribute.setUpperBound(attribute2.getUpper());
		return facetAttribute;
	}
	
	//the second version with references to property and stereitype
	public static final FacetAttribute createFacetAttribute2(Property attribute2, final Stereotype ste) {
		FacetAttribute facetAttribute = EFacetFactory.eINSTANCE.createFacetAttribute();
		facetAttribute.setName(attribute2.getName());
		facetAttribute.setDocumentation("This Facet Attribute represents the stereotype property " + attribute2.getQualifiedName());
		facetAttribute.setChangeable(!attribute2.isDerived());
		facetAttribute.setDerived(true);
		Type type = attribute2.getType();
		EClassifier eType = null;
		OperationCallQuery query;
		FacetOperation facetOperationCalled = null;
		int upperBound = facetAttribute.getUpperBound();
		if(type instanceof PrimitiveType) {
			PrimitiveType pType = (PrimitiveType)type;
			final String name = pType.getName();
			if("EString".equals(name) || "String".equals(name)) {
				eType = EcorePackage.eINSTANCE.getEString();
				if(upperBound > 1) {
					//TODO
				} else {
					facetOperationCalled = getSingleStringValueOperation2(attribute2.eResource().getResourceSet());
				}
			} else if("EBoolean".equals(name)) {
				eType = EcorePackage.eINSTANCE.getEBoolean();
			} else if("EInt".equals(name)) {
				eType = EcorePackage.eINSTANCE.getEInt();
			}
			//else TODO to finish





			//we prepare the arguments
			query = QueryFactory.eINSTANCE.createOperationCallQuery();
			query.setCanHaveSideEffects(false);

			EObjectLiteralQuery qualifiedNameQuery = QueryFactory.eINSTANCE.createEObjectLiteralQuery();
			qualifiedNameQuery.setElement(ste);
			query.getArguments().add(qualifiedNameQuery);

			EObjectLiteralQuery propertyNameQuery = QueryFactory.eINSTANCE.createEObjectLiteralQuery();
			propertyNameQuery.setElement(attribute2);
			query.getArguments().add(propertyNameQuery);
			facetAttribute.setQuery(query);

			query.setOperation(facetOperationCalled);

		}
		facetAttribute.setEType(eType);//TODO
		//		attribute.setQuery(query);////TODO
		facetAttribute.setLowerBound(attribute2.getLower());
		facetAttribute.setUpperBound(attribute2.getUpper());
		return facetAttribute;
	}

	public static final FacetReference createFacetReference() {
		FacetReference reference = EFacetFactory.eINSTANCE.createFacetReference();
		return reference;
	}
}
