/*******************************************************************************
 * Copyright (c) 2011, 2012 Mia-Software
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Nicolas Bros (Mia-Software) - Bug 361612 - New core for new version of the Facet metamodel
 *     Nicolas Bros (Mia-Software) - Bug 361817 - [Restructuring] Dynamic load to the facet catalog
 *     Gregoire Dupe (Mia-Software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 *     Nicolas Bros (Mia-Software) - Bug 371367 - Hierarchical FacetSets
 *     Gregoire Dupe (Mia-Software) - Bug 371367 - Hierarchical FacetSets
 *     Gregoire Dupe (Mia-Software) - Bug 364325 - [Restructuring] The user must be able to navigate into a model using the Facet.
 *     Gregoire Dupe (Mia-Software) - Bug 373510 - EditingDomain, ResourceSet, Catalogs, etc. have to be properly managed between editors and views
 *     Gregoire Dupe (Mia-Software) - Bug 373078 - API Cleaning
 *     Gregoire Dupe (Mia-Software) - Bug 374903 - [Table] ITableWidget.setLoadedFacetSets
 *     Gregoire Dupe (Mia-Software) - Bug 375087 - [Table] ITableWidget.addColumn(List<ETypedElement>, List<FacetSet>)
 *     Olivier Remaud (Soft-Maint) - Bug 361794 - [Restructuring] EMF Facet customization meta-model
 *     Gregoire Dupe (Mia-Software) - Bug 364325 - [Restructuring] The user must be able to navigate into a model using the Facet.
 *     Gregoire Dupe (Mia-Software) - Bug 361794 - [Restructuring] EMF Facet customization meta-model
 *     Gregoire Dupe (Mia-Software) - Bug 373078 - API Cleaning
 *     Gregoire Dupe (Mia-Software) - Bug 372626 - Aggregates
 *     Nicolas Bros (Mia-Software) - Bug 372626 - Aggregates
 *     Gregoire Dupe (Mia-Software) - Bug 376576 - [EFacet] Change the multiplicity of Facet::extendedFacet
 *     Vincent Lorenzo (CEA-LIST) - Bug 357621 - Improve the label displayed for Customization and Facets
 *     Grégoire Dupé (Mia-Software) - Bug 387470 - [EFacet][Custom] Editors
 *     Alban Ménager (Soft-Maint) - Bug 387470 - [EFacet][Custom] Editors
 *     Gregoire Dupe (Mia-Software) - Bug 377870 - [EFacet] ETypedElementDialog doesn't show all available ETypedElement (library example problem?)
 *     Grégoire Dupé (Mia-Software) - Bug 387470 - [EFacet][Custom] Editors
 *     Grégoire Dupé (Mia-Software) - Bug 391442 - Select ETypedElement Dialog doesn't used the subpackages (subEFacetSet)
 *******************************************************************************/
package org.eclipse.emf.facet.efacet.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.facet.efacet.core.exception.FacetManagerException;
import org.eclipse.emf.facet.efacet.core.internal.exported.IResolverManager;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.DerivedTypedElement;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetOperation;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.ETypedElementEObjectListResult;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.ETypedElementEObjectResult;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.ETypedElementPrimitiveTypeListResult;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.ETypedElementPrimitiveTypeResult;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.ETypedElementResult;
import org.eclipse.emf.facet.util.emf.core.ModelUtils;
import org.eclipse.emf.facet.util.emf.core.internal.EMFUtils;

/**
 * @since 0.2
 */
public final class FacetUtils {

	private FacetUtils() {
		// static methods only
	}

	/**
	 * Find a Facet in a FacetSet
	 * 
	 * @param facetSet
	 *            the FacetSet
	 * @param facetName
	 *            the name of the Facet to look for
	 * @return the Facet with the given name in the given FacetSet
	 */
	public static Facet getFacet(final FacetSet facetSet, final String facetName) {
		Facet result = null;
		final List<Facet> facets = FacetUtils.getFacets(facetSet);
		for (Facet facet : facets) {
			if (facetName.equals(facet.getName())) {
				result = facet;
				break;
			}
		}
		return result;
	}

	public static <T extends ETypedElement> T getETypedElement(
			final Facet facet, final String name, final Class<T> classs) {
		T result = null;
		final List<ETypedElement> eTypedElements = new ArrayList<ETypedElement>();
		eTypedElements.addAll(facet.getFacetElements());
		eTypedElements.addAll(facet.getFacetOperations());
		for (ETypedElement eTypedElement : eTypedElements) {
			if (name.equals(eTypedElement.getName())
					&& classs.isInstance(eTypedElement)) {
				@SuppressWarnings("unchecked")
				// @SuppressWarnings("unchecked") This assignment is check by
				// the call 'classs.isInstance(structuralFeature)'
				final T castResult = (T) eTypedElement;
				result = castResult;
				break;
			}
		}
		return result;
	}

	public static Object getResultValue(final ETypedElementResult eTEresult) {
		Object result = null;
		if (eTEresult instanceof ETypedElementEObjectListResult<?>) {
			final ETypedElementEObjectListResult<?> eObjectList = (ETypedElementEObjectListResult<?>) eTEresult;
			result = eObjectList.getResultList();
		} else if (eTEresult instanceof ETypedElementEObjectResult<?>) {
			final ETypedElementEObjectResult<?> eObjectRef = (ETypedElementEObjectResult<?>) eTEresult;
			result = eObjectRef.getResult();
		} else if (eTEresult instanceof ETypedElementPrimitiveTypeListResult<?>) {
			final ETypedElementPrimitiveTypeListResult<?> objectList = (ETypedElementPrimitiveTypeListResult<?>) eTEresult;
			result = objectList.getDerivedTypedElement();
		} else if (eTEresult instanceof ETypedElementPrimitiveTypeResult<?>) {
			final ETypedElementPrimitiveTypeResult<?> objectRef = (ETypedElementPrimitiveTypeResult<?>) eTEresult;
			result = objectRef.getResult();
		} else {
			throw new IllegalStateException(
					"Unknown ETypedElementResult type: " + eTEresult.getClass()); //$NON-NLS-1$
		}
		return result;
	}

	/**
	 * Find a FacetSet with the given name among the given list of FacetSets. If several FacetSets have the same name,
	 * then return the first one.
	 * 
	 * @param facetSets
	 *            where to look for
	 * @param name
	 *            the name of the FacetSet to find
	 * @return the FacetSet, or <code>null</code> if not found in the given list
	 */
	public static FacetSet getFacetSet(final Collection<FacetSet> facetSets, final String name) {
		FacetSet result = null;
		for (FacetSet facetSet : facetSets) {
			if (name.equals(facetSet.getName())) {
				result = facetSet;
			}
		}
		return result;
	}

	/**
	 * Find all FacetSets with the given name among the given list of FacetSets.
	 * 
	 * @param facetSets
	 *            where to look for
	 * @param name
	 *            the name of the FacetSets to find
	 * @return the FacetSets with the given name
	 */
	public static List<FacetSet> getFacetSets(
			final Collection<FacetSet> facetSets, final String name) {
		final List<FacetSet> result = new ArrayList<FacetSet>();
		for (FacetSet facetSet : facetSets) {
			if (name.equals(facetSet.getName())) {
				result.add(facetSet);
			}
		}
		return result;
	}

	/**
	 * 
	 * @param facetSet
	 *            a facetSet
	 * @return a set with all the EPackage extended by the facetSet and its
	 *         owned facetSet
	 * @since 0.2
	 */
	public static Set<EPackage> getAllExtendedEPackage(final FacetSet facetSet) {
		final Set<EPackage> extendedEPackages = new HashSet<EPackage>();
		final EPackage res1 = getExtendedEPackage(facetSet);
		if (res1 != null) {
			extendedEPackages.add(res1);
		}
		for (FacetSet current : facetSet.getFacetSets()) {
			extendedEPackages.addAll(getAllExtendedEPackage(current));
		}
		final EList<EPackage> pack = facetSet.getESubpackages();
		for (EPackage current : pack) {
			if (current instanceof FacetSet) {
				extendedEPackages
						.addAll(getAllExtendedEPackage((FacetSet) current));
			}
		}
		return extendedEPackages;
	}
	
	/**
	 * Find all the FacetSets with the given path among the given list of root
	 * FacetSets. For example: <code>getFacetSetsByPath("a", "b", "c")</code>
	 * returns a FacetSet named "c", contained in a FacetSet named "b",
	 * contained in a registered FacetSet named "a".
	 * 
	 * @param path
	 *            a list of FacetSet names, starting from the root registered
	 *            FacetSets, and leading to the wanted FacetSet(s)
	 * @return the FacetSets that have the given path
	 */
	public static List<FacetSet> getFacetSetsByPath(
			final Collection<FacetSet> rootFacetSets, final String... path) {
		if (path.length == 0) {
			throw new IllegalArgumentException("The given path cannot be empty"); //$NON-NLS-1$
		}
		List<FacetSet> facetSets = new ArrayList<FacetSet>(rootFacetSets);
		for (int i = 0; i < path.length; i++) {
			if (i > 0) {
				facetSets = getSubFacetSets(facetSets);
			}
			final String name = path[i];
			facetSets = getFacetSets(facetSets, name);
			if (facetSets.isEmpty()) {
				break;
			}

		}
		return facetSets;
	}

	private static List<FacetSet> getSubFacetSets(
			final Collection<FacetSet> parents) {
		final List<FacetSet> subFacetSets = new ArrayList<FacetSet>();
		for (FacetSet facetSet : parents) {
			final EList<EPackage> eSubpackages = facetSet.getESubpackages();
			for (EPackage ePackage : eSubpackages) {
				if (ePackage instanceof FacetSet) {
					final FacetSet subFacetSet = (FacetSet) ePackage;
					subFacetSets.add(subFacetSet);
				}
			}
		}
		return subFacetSets;
	}

	/**
	 * Find a Facet with the given name among the given list of Facets.
	 * 
	 * @param facets
	 *            where to look
	 * @param name
	 *            the name of the Facet that is being looked for
	 * @return the first {@link Facet} with this name, or <code>null</code> if
	 *         none
	 */
	public static Facet getFacet(final Collection<Facet> facets,
			final String name) {
		Facet result = null;
		for (Facet facet : facets) {
			if (name.equals(facet.getName())) {
				result = facet;
			}
		}
		return result;
	}

	public static FacetSet getRootFacetSet(final Facet facet) {
		FacetSet result = (FacetSet) facet.eContainer();
		while (result != null && result.eContainer() instanceof FacetSet) {
			result = (FacetSet) result.eContainer();
		}
		return result;
	}

	public static FacetSet getRootFacetSet(final FacetSet facetSet) {
		FacetSet result = facetSet;
		while (result != null && result.eContainer() instanceof FacetSet) {
			result = (FacetSet) result.eContainer();
		}
		return result;
	}

	/**
	 * This methods returns all the known (registered) eTypedElements.
	 * 
	 * @param resourceSet
	 *            the eTypedElement search will be done in/using this resourceSet
	 * @return all the known (registered) eTypedElements
	 */
	public static Set<? extends ETypedElement> getETypedElements(
			final ResourceSet resourceSet) {
		final Set<ETypedElement> result = new HashSet<ETypedElement>();
		final Collection<Object> ePackages = EPackage.Registry.INSTANCE
				.values();
		for (Object object : ePackages) {
			EPackage ePackage = null;
			if (object instanceof EPackage) {
				ePackage = (EPackage) object;
			} else if (object instanceof EPackage.Descriptor) {
				final EPackage.Descriptor descriptor = (EPackage.Descriptor) object;
				ePackage = descriptor.getEPackage();
			}
			if (ePackage != null) {
				result.addAll(getETypedElements(ePackage));
			}
		}
		result.addAll(getFacetETypedElements(resourceSet));
		return result;
	}

	/**
	 * @since 0.3
	 */
	public static Set<? extends ETypedElement> getFacetETypedElements(
			final ResourceSet resourceSet) {
		final Set<ETypedElement> result = new HashSet<ETypedElement>();
		final Collection<FacetSet> facetSets = IFacetSetCatalogManagerFactory.DEFAULT
				.getOrCreateFacetSetCatalogManager(resourceSet)
				.getRegisteredFacetSets();
		for (FacetSet facetSet : facetSets) {
			result.addAll(getETypedElements(facetSet));
		}
		return result;
	}

	public static List<ETypedElement> getETypedElements(final EPackage ePackage) {
		final List<ETypedElement> result = new LinkedList<ETypedElement>();
		for (EClassifier eClassifier : ePackage.getEClassifiers()) {
			result.addAll(getETypedElements(eClassifier));
		}
		for (EPackage subPackage : ePackage.getESubpackages()) {
			result.addAll(getETypedElements(subPackage));
		}
		return result;
	}

	/**
	 * @since 0.3
	 */
	public static List<ETypedElement> getETypedElements(
			final EClassifier eClassifier) {
		final List<ETypedElement> result = new ArrayList<ETypedElement>();
		if (eClassifier instanceof Facet) {
			final Facet facet = (Facet) eClassifier;
			result.addAll(facet.getFacetElements());
			result.addAll(facet.getFacetOperations());
		} else if (eClassifier instanceof EClass) {
			final EClass eClass = (EClass) eClassifier;
			result.addAll(eClass.getEAllStructuralFeatures());
			result.addAll(eClass.getEAllOperations());
		}
		return result;
	}

	public static List<Facet> getFacets(final FacetSet facetSet) {
		final List<Facet> result = new LinkedList<Facet>();
		for (EClassifier eClassifier : facetSet.getEClassifiers()) {
			if (eClassifier instanceof Facet) {
				final Facet facet = (Facet) eClassifier;
				result.add(facet);
			}
		}
		return result;
	}

	public static FacetSet getFacetSet(final Facet facet) {
		FacetSet result = null;
		if (facet.getEPackage() instanceof FacetSet) {
			result = (FacetSet) facet.getEPackage();
		}
		return result;
	}

	// Moved from
	// org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.FacetSetImpl
	public static EPackage getExtendedEPackage(final FacetSet facetSet) {
		final List<Facet> facets = FacetUtils.getFacets(facetSet);
		EPackage result = null;
		for (Facet facet : facets) {
			final EClass extendedMetaclass = facet.getExtendedMetaclass();
			if (extendedMetaclass != null) {
				final EPackage ePackage = extendedMetaclass.getEPackage();
				if (ePackage != null) {
					if (result != null && !ePackage.equals(result)) {
						throw new IllegalStateException(
								"The Facets in a FacetSet must all extend EClasses from the same EPackage"); //$NON-NLS-1$
					}
					result = ePackage;
				}
			}
		}
		return result;
	}

	// Copied (and refactored) from
	// org.eclipse.emf.facet.efacet.core.internal.FacetManager
	public static <T extends ETypedElement> Set<T> getETypedElements(
			final EObject eObject, final Class<T> classs,
			final IFacetManager facetManager) throws FacetManagerException {
		final Set<T> result = new HashSet<T>();
		for (FacetSet facetSet : facetManager.getManagedFacetSets()) {
			result.addAll(getETypedElements(eObject, facetSet, classs,
					facetManager));
		}
		return result;
	}

	// Copied (and refactored) from
	// org.eclipse.emf.facet.efacet.core.internal.FacetManager
	private static <T extends ETypedElement> Set<T> getETypedElements(
			final EObject eObject, final FacetSet facetSet,
			final Class<T> classs, final IFacetManager manager)
			throws FacetManagerException {
		final Set<T> result = new HashSet<T>();
		for (EClassifier eClassifier : facetSet.getEClassifiers()) {
			if (eClassifier instanceof Facet) {
				final Facet facet = (Facet) eClassifier;
				if (manager.isConforming(eObject, facet)) {
					result.addAll(getETypedElement(classs, facet));
				}
			}
		}
		// hierarchical FacetSets
		for (EPackage ePackage : facetSet.getESubpackages()) {
			if (ePackage instanceof FacetSet) {
				final FacetSet subFacetSet = (FacetSet) ePackage;
				result.addAll(getETypedElements(eObject, subFacetSet, classs,
						manager));
			}
		}
		// aggregates
		for (FacetSet subFacetSet : facetSet.getFacetSets()) {
			result.addAll(getETypedElements(eObject, subFacetSet, classs,
					manager));
		}
		return result;
	}

	private static <T> Set<T> getETypedElement(final Class<T> classs,
			final Facet facet) {
		final Set<T> result = new HashSet<T>();
		for (ETypedElement eTypedElement : getAllETypedElements(facet)) {
			if (classs.isInstance(eTypedElement)) {
				@SuppressWarnings("unchecked")
				// @SuppressWarnings("unchecked") This type has been
				// checked using isInstance
				final T typedSF = (T) eTypedElement;
				final T resolvedTE = IResolverManager.DEFAULT
						.resolve(typedSF, classs);
				if (resolvedTE == null) {
					result.add(typedSF);
				} else {
					result.add(resolvedTE);
				}
			}
		}
		return result;
	}

	// Copied (and refactored) from
	// org.eclipse.emf.facet.efacet.core.internal.FacetManager
	private static List<ETypedElement> getAllETypedElements(
			final Facet facet) {
		final List<ETypedElement> structFeatures = new LinkedList<ETypedElement>();
		structFeatures.addAll(facet.getFacetElements());
		structFeatures.addAll(facet.getFacetOperations());
		for (Facet extFacet : facet.getExtendedFacets()) {
			structFeatures.addAll(getAllETypedElements(extFacet));
		}
		return structFeatures;
	}

	/**
	 * @param eTypedElement
	 * @return
	 * @since 0.2
	 */
	public static FacetSet getFacetSet(final ETypedElement eTypedElement) {
		FacetSet result = null;
		if (eTypedElement.eContainer() instanceof Facet) {
			final Facet facet = (Facet) eTypedElement.eContainer();
			if (facet.eContainer() instanceof FacetSet) {
				result = (FacetSet) facet.eContainer();
			}
		}
		return result;
	}

	/**
	 * 
	 * @param facetOperation
	 * @return
	 * @since 0.2
	 */
	public static DerivedTypedElement getSignature(
			final FacetOperation facetOperation) {
		DerivedTypedElement current = facetOperation;
		while (current.getOverride() != null) {
			current = current.getOverride();
		}
		return current;
	}

	/**
	 * 
	 * @param facet
	 * @return
	 * @since 0.2
	 */
	public static EClass getExtendedMetaclass(final Facet facet) {
		EClass result = facet.getExtendedMetaclass();
		if (result == null) {
			final List<EClass> eClasses = new LinkedList<EClass>();
			for (Facet extfacet : facet.getExtendedFacets()) {
				eClasses.add(getExtendedMetaclass(extfacet));
			}
			result = EMFUtils.computeLeastCommonSupertype(eClasses);
		}
		return result;
	}

	/**
	 * Find the top level feature in the override chain
	 * 
	 * @param feature
	 * @return The top level feature in the override chain or the feature
	 *         parameter itself if no override
	 * @throws FacetManagerException
	 * @since 0.2
	 * 
	 */
	// Copied from
	// org.eclipse.emf.facet.efacet.core.internal.FacetManagerContext
	// * Contributors:
	// * Olivier Remaud (Soft-Maint) - Bug 361794 - [Restructuring] EMF Facet
	// customization meta-model
	// * Gregoire Dupe (Mia-Software) - Bug 364325 - [Restructuring] The user
	// must be able to navigate into a model using the Facet.
	// * Gregoire Dupe (Mia-Software) - Bug 361794 - [Restructuring] EMF Facet
	// customization meta-model
	// * Gregoire Dupe (Mia-Software) - Bug 373078 - API Cleaning
	@SuppressWarnings("unchecked")
	// @SuppressWarnings("unchecked") cf. comment in the method body
	public static <T extends DerivedTypedElement> T getTopOverrideFeature(
			final T feature) throws FacetManagerException {
		T signatureFeature = feature;
		while (signatureFeature.getOverride() != null) {
			if (feature.getClass().isInstance(signatureFeature.getOverride())) {
				// @SuppressWarnings("unchecked") the if test check the
				// assignment using the method 'isInstance'
				signatureFeature = (T) signatureFeature.getOverride();
			} else {
				// signature feature type name
				final String sfTypeName = signatureFeature.eClass().getName();
				// signature feature name
				final String sfName = ModelUtils
						.getQualifiedName(signatureFeature);
				final String ofName = signatureFeature.getOverride().eClass()
						.getName(); // overridden feature type name
				throw new FacetManagerException("The " + sfTypeName + " '" //$NON-NLS-1$ //$NON-NLS-2$
						+ sfName + "' overides a " + ofName); //$NON-NLS-1$
			}
		}
		return signatureFeature;
	}

	/**
	 * @since 0.3
	 */
	public static EClass findExtendedEClass(final Facet facet) {
		EClass result = facet.getExtendedMetaclass();
		if (result == null) {
			for (Facet extFacet : facet.getExtendedFacets()) {
				result = findExtendedEClass(extFacet);
				if (result != null) {
					break;
				}
			}
		}
		return result;
	}

	/**
	 * @since 0.3
	 */
	public static DerivedTypedElement getContainingDerivedTypedElement(
			final EObject eObject) {
		DerivedTypedElement dte = null;
		if (eObject instanceof DerivedTypedElement) {
			dte = (DerivedTypedElement) eObject;
		} else if (eObject != null) {
			dte = getContainingDerivedTypedElement(eObject.eContainer());
		}
		return dte;
	}

	/**
	 * Return the main facetSet.
	 * 
	 * @param eObject
	 *            the element in the model selected.
	 * @return the main facetSet.
	 * @since 0.3
	 */
	public static FacetSet getContainingFacetSet(final EObject eObject) {
		FacetSet result = null;
		if (eObject instanceof FacetSet) {
			result = (FacetSet) eObject;
		} else {
			final EObject container = eObject.eContainer();
			if (container != null) {
				result = getContainingFacetSet(container);
			}
		}
		return result;
	}

	/**
	 * Return all the operations of the model.
	 * 
	 * @param parent
	 *            the first FacetSet of the model.
	 * @return the list of operations.
	 * @since 0.3
	 */
	public static Map<String, FacetOperation> getAllOperationsByName(
			final FacetSet parent) {
		final Map<String, FacetOperation> operations = new HashMap<String, FacetOperation>();
		for (final EClassifier facet : parent.getEClassifiers()) {
			for (final FacetOperation operation : ((Facet) facet)
					.getFacetOperations()) {
				operations.put(operation.getName(), operation);
			}
		}
		for (final EPackage element : parent.getESubpackages()) {
			operations.putAll(getAllOperationsByName((FacetSet) element));
		}
		return operations;
	}

	/**
	 * Return all the facets of the model.
	 * 
	 * @param parent
	 *            the first FacetSet of the model.
	 * @return the list of facets.
	 * @since 0.3
	 */
	public static Map<String, Facet> getAllFacetsByName(final FacetSet parent) {
		final Map<String, Facet> facets = new HashMap<String, Facet>();
		for (final EClassifier facet : parent.getEClassifiers()) {
			facets.put(facet.getName(), (Facet) facet);
		}
		for (final EPackage element : parent.getESubpackages()) {
			facets.putAll(getAllFacetsByName((FacetSet) element));
		}

		return facets;
	}

	/**
	 * Return all the facets of the model.
	 * 
	 * @param parent
	 *            the first FacetSet of the model.
	 * @return the list of facets.
	 * @since 0.3
	 */
	public static Map<String, FacetSet> getAllFacetSetsByName(
			final EPackage parent) {
		final Map<String, FacetSet> facetSets = new HashMap<String, FacetSet>();
		if (parent instanceof FacetSet) {
			final FacetSet facetSet = (FacetSet) parent;
			facetSets.put(parent.getName(), facetSet);
		}
		for (final EPackage element : parent.getESubpackages()) {
			facetSets.putAll(getAllFacetSetsByName(element));
		}
		return facetSets;
	}

	/**
	 * @since 0.3
	 */
	public static List<Facet> getAllFacet(final FacetSet facetSet) {
		final List<Facet> result = new ArrayList<Facet>();
		for (EClassifier eClassifier : facetSet.getEClassifiers()) {
			if (eClassifier instanceof Facet) {
				final Facet facet = (Facet) eClassifier;
				result.add(facet);
			}
		}
		for (EPackage ePackage : facetSet.getESubpackages()) {
			if (ePackage instanceof FacetSet) {
				final FacetSet subFacetSet = (FacetSet) ePackage;
				result.addAll(getAllFacet(subFacetSet));
			}
		}
		return result;
	}

}
