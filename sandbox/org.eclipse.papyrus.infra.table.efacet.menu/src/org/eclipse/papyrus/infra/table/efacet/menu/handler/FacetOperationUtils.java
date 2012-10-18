package org.eclipse.papyrus.infra.table.efacet.menu.handler;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.facet.efacet.core.IFacetSetCatalogManager;
import org.eclipse.emf.facet.efacet.core.IFacetSetCatalogManagerFactory;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetOperation;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;


public class FacetOperationUtils {

	/** the facet providing the operation to edit stereotype properties */
	private static Facet stereotypedElementFacet;

	private static FacetOperation stringSingleValueOperation;

	private static FacetOperation stringMultiValueOperation;


	private static FacetOperation eobjectMultiReferenceOperation;

	private static FacetOperation eobejctMonoReferenceOperation;

	private static FacetOperation booleanSingleValueOperation;

	private static FacetOperation booleanMultiValueOperation;

	private static FacetOperation integerMultiValueOperation;

	private static FacetOperation integerSingleValueOperation;

	private static FacetOperation realSingleValueOperation;

	private static FacetOperation realMultiValueOperation;

	private static FacetOperation unlimitedNaturalSingleValueOperation;

	private static FacetOperation unlimitedNaturalMultiValueOperation;

	private FacetOperationUtils() {
		//to prevent instanciation
	}

	public static final Facet getStereotypedElementFacet(final ResourceSet resourceSet) {
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

	public static FacetOperation getBooleanMultiValueOperation(final ResourceSet resourceSet) {
		if(booleanMultiValueOperation == null) {
			final Facet stereotypedElementFacet = getStereotypedElementFacet(resourceSet);
			if(stereotypedElementFacet != null)
				for(final FacetOperation op : stereotypedElementFacet.getFacetOperations()) {
					if("getBooleanMultiValue".equals(op.getName())) {
						booleanMultiValueOperation = op;
						break;
					}
				}
		}
		return booleanMultiValueOperation;
	}



	public static FacetOperation getBooleanSingleValueOperation(final ResourceSet resourceSet) {
		if(booleanSingleValueOperation == null) {
			final Facet stereotypedElementFacet = getStereotypedElementFacet(resourceSet);
			if(stereotypedElementFacet != null)
				for(final FacetOperation op : stereotypedElementFacet.getFacetOperations()) {
					if("getBooleanSingleValue".equals(op.getName())) {
						booleanSingleValueOperation = op;
						break;
					}
				}
		}
		return booleanSingleValueOperation;
	}


	public static FacetOperation getEObjectMultiReferenceOperation(final ResourceSet resourceSet) {
		if(eobjectMultiReferenceOperation == null) {
			final Facet stereotypedElementFacet = getStereotypedElementFacet(resourceSet);
			if(stereotypedElementFacet != null)
				for(final FacetOperation op : stereotypedElementFacet.getFacetOperations()) {
					if("getEObjectMultiReference".equals(op.getName())) {
						eobjectMultiReferenceOperation = op;
						break;
					}
				}
		}
		return eobjectMultiReferenceOperation;
	}

	public static FacetOperation getEObjectSingleReferenceOperation(final ResourceSet resourceSet) {
		if(eobejctMonoReferenceOperation == null) {
			final Facet stereotypedElementFacet = getStereotypedElementFacet(resourceSet);
			if(stereotypedElementFacet != null)
				for(final FacetOperation op : stereotypedElementFacet.getFacetOperations()) {
					if("getEObjectSingleReference".equals(op.getName())) {
						eobejctMonoReferenceOperation = op;
						break;
					}
				}
		}
		return eobejctMonoReferenceOperation;
	}

	public static FacetOperation getIntegerMultiValueOperation(final ResourceSet resourceSet) {
		if(integerMultiValueOperation == null) {
			final Facet stereotypedElementFacet = getStereotypedElementFacet(resourceSet);
			if(stereotypedElementFacet != null)
				for(final FacetOperation op : stereotypedElementFacet.getFacetOperations()) {
					if("getIntegerMultiValue".equals(op.getName())) {
						integerMultiValueOperation = op;
						break;
					}
				}
		}
		return integerMultiValueOperation;
	}

	public static FacetOperation getIntegerSingleValueOperation(final ResourceSet resourceSet) {
		if(integerSingleValueOperation == null) {
			final Facet stereotypedElementFacet = getStereotypedElementFacet(resourceSet);
			if(stereotypedElementFacet != null)
				for(final FacetOperation op : stereotypedElementFacet.getFacetOperations()) {
					if("getIntegerSingleValue".equals(op.getName())) {
						integerSingleValueOperation = op;
						break;
					}
				}
		}
		return integerSingleValueOperation;
	}


	public static FacetOperation getRealMultiValueOperation(final ResourceSet resourceSet) {
		if(realMultiValueOperation == null) {
			final Facet stereotypedElementFacet = getStereotypedElementFacet(resourceSet);
			if(stereotypedElementFacet != null)
				for(final FacetOperation op : stereotypedElementFacet.getFacetOperations()) {
					if("getRealMultiValue".equals(op.getName())) {
						realMultiValueOperation = op;
						break;
					}
				}
		}
		return realMultiValueOperation;
	}

	public static FacetOperation getRealSingleValueOperation(final ResourceSet resourceSet) {
		if(realSingleValueOperation == null) {
			final Facet stereotypedElementFacet = getStereotypedElementFacet(resourceSet);
			if(stereotypedElementFacet != null)
				for(final FacetOperation op : stereotypedElementFacet.getFacetOperations()) {
					if("getRealSingleValue".equals(op.getName())) {
						realSingleValueOperation = op;
						break;
					}
				}
		}
		return realSingleValueOperation;
	}

	public static FacetOperation getStringMultiValueOperation(final ResourceSet resourceSet) {
		if(stringMultiValueOperation == null) {
			final Facet stereotypedElementFacet = getStereotypedElementFacet(resourceSet);
			if(stereotypedElementFacet != null)
				for(final FacetOperation op : stereotypedElementFacet.getFacetOperations()) {
					if("getStringMultiValue".equals(op.getName())) {
						stringMultiValueOperation = op;
						break;
					}
				}
		}
		return stringMultiValueOperation;
	}

	public static FacetOperation getStringSingleValueOperation(final ResourceSet resourceSet) {
		if(stringSingleValueOperation == null) {
			final Facet stereotypedElementFacet = getStereotypedElementFacet(resourceSet);
			if(stereotypedElementFacet != null)
				for(final FacetOperation op : stereotypedElementFacet.getFacetOperations()) {
					if("getStringSingleValue".equals(op.getName())) {
						stringSingleValueOperation = op;
						break;
					}
				}
		}
		return stringSingleValueOperation;
	}

	public static FacetOperation getUnlimitedNaturalMultiValueOperation(final ResourceSet resourceSet) {
		if(unlimitedNaturalMultiValueOperation == null) {
			final Facet stereotypedElementFacet = getStereotypedElementFacet(resourceSet);
			if(stereotypedElementFacet != null)
				for(final FacetOperation op : stereotypedElementFacet.getFacetOperations()) {
					if("getUnlimitedNaturalMultiValue".equals(op.getName())) {
						unlimitedNaturalMultiValueOperation = op;
						break;
					}
				}
		}
		return unlimitedNaturalMultiValueOperation;
	}


	public static FacetOperation getUnlimitedNaturalSingleValueOperation(final ResourceSet resourceSet) {
		if(unlimitedNaturalSingleValueOperation == null) {
			final Facet stereotypedElementFacet = getStereotypedElementFacet(resourceSet);
			if(stereotypedElementFacet != null)
				for(final FacetOperation op : stereotypedElementFacet.getFacetOperations()) {
					if("getUnlimitedNaturalSingleValue".equals(op.getName())) {
						unlimitedNaturalSingleValueOperation = op;
						break;
					}
				}
		}
		return unlimitedNaturalSingleValueOperation;
	}
}
