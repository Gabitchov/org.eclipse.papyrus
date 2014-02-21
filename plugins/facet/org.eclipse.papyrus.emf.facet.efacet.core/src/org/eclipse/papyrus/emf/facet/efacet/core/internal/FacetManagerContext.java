/*******************************************************************************
 * Copyright (c) 2011 Mia-Software
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Olivier Remaud (Soft-Maint) - Bug 361794 - [Restructuring] EMF Facet customization meta-model
 *     Gregoire Dupe (Mia-Software) - Bug 364325 - [Restructuring] The user must be able to navigate into a model using the Facet.
 *     Gregoire Dupe (Mia-Software) - Bug 361794 - [Restructuring] EMF Facet customization meta-model
 *     Gregoire Dupe (Mia-Software) - Bug 373078 - API Cleaning
 *     Gregoire Dupe (Mia-Software) - Bug 375087 - [Table] ITableWidget.addColumn(List<ETypedElement>, List<FacetSet>)
 *     Gregoire Dupe (Mia-Software) - Bug 372626 - Aggregates
 *     Gregoire Dupe (Mia-Software) - Bug 377178 - [EFacet] infinite recursion in override resolution
 *     Gregoire Dupe (Mia-software) - Bug 383418 - [Table] FacetManagerContext.getOverrideCandidateFeatures(...) is empty
 *     Gregoire Dupe (Mia-software) - Bug 420093 - [EFacet] The facetManger list doesn't deal with uniqueness
 *     Thomas Cicognani (Soft-Maint) - Bug 420193 - Listener on FacetManager
 *     Fabien Treguer (Soft-Maint) - Bug 423285 - [Table] FacetSets not stored in a resource cause model manager crashes
 *******************************************************************************/

package org.eclipse.emf.facet.efacet.core.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.facet.efacet.core.FacetUtils;
import org.eclipse.emf.facet.efacet.core.IFacetManagerListener;
import org.eclipse.emf.facet.efacet.core.exception.FacetManagerException;
import org.eclipse.emf.facet.efacet.core.internal.FacetManager.ConformanceState;
import org.eclipse.emf.facet.efacet.core.internal.exception.UnmatchingExpectedTypeException;
import org.eclipse.emf.facet.efacet.core.internal.exported.IResolverManager;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.DerivedTypedElement;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;
import org.eclipse.emf.facet.util.core.Logger;
import org.eclipse.emf.facet.util.core.internal.exported.ListUtils;
import org.eclipse.emf.facet.util.emf.core.ModelUtils;

/**
 * @author oremaud
 * 
 *         FacetManager Context
 * 
 *         Defines which FacetSets will be taken into account, and in which
 *         order ('front' FacetSets have higher precedence)
 * 
 *         Responsible of overrides resolution for Facets and Customs
 */
class FacetManagerContext implements List<FacetSet> {

	private static final String SILENT_OPTION = "org.eclipse.emf.facet.efacet.core.internal.FacetManagerContext.getOverrideCandidateFeatures.silent"; //$NON-NLS-1$
	private static final boolean SILENT = Boolean
			.getBoolean(FacetManagerContext.SILENT_OPTION);

	// We cannot use the interface (i.e, List) instead because we need to use
	// the methods addLast and addFirst
	private LinkedList<FacetSet> managedFacetSets = new LinkedList<FacetSet>(); // NOPMD by gdupe on 15/03/12 10:36
	private final transient FacetManager manager;
	/**
	 * This field is used to avoid to have to many error messages in the log.
	 */
	private final Set<ETypedElement> failingFeatures = new HashSet<ETypedElement>();
	
	private final Set<IFacetManagerListener> listeners = new HashSet<IFacetManagerListener>();

	public FacetManagerContext(final FacetManager manager) {
		this.manager = manager;
	}

	/**
	 * 
	 * @param baseFeature
	 * @param eObject
	 * @return
	 * @throws FacetConformanceEvaluationException
	 * @throws UnmatchingExpectedTypeException
	 * @throws FacetManagerException 
	 */
	public <T extends ETypedElement> T resolveOverrides(final T baseFeature,
			final EObject eObject) throws FacetManagerException {
		T result = baseFeature;
		if (baseFeature instanceof DerivedTypedElement) {
			final DerivedTypedElement derivedResult = resolveOverrides(
					(DerivedTypedElement) baseFeature, eObject);
			if (derivedResult != null
					&& !(derivedResult instanceof ETypedElement)) {
				throw new UnmatchingExpectedTypeException(
						"Type mismatch in override resolution '" + baseFeature.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$
			}
			result = (T) derivedResult;
		}
		// If nothing is found, return the original basefeature
		if (result == null) {
			result = baseFeature;
		}
		return result;
	}

	/**
	 * 
	 * @param baseFeature
	 * @param eObject
	 * @return
	 * @throws FacetConformanceEvaluationException
	 * @throws FacetManagerException 
	 */
	public <T extends DerivedTypedElement> T resolveOverrides(
			final T baseFeature, final EObject eObject)
			throws FacetManagerException {
		try {
			// -- Find master override
			// If the baseFeature overrides another feature, then we follow the
			// override chain to find the top feature
			// The main idea behind this is that the baseFeature does not really
			// represents a specific feature but a
			// feature signature (as in java method invocation)
			final T signatureFeature = FacetUtils
					.getTopOverrideFeature(baseFeature);

			// -- Find all candidates
			// Get all Facet referenced by the FacetManager to get all features
			// matching this signature
			// Note : candidates are searched ine the order provided by the current
			// FacetManager,
			// so they are already ordered by the wanted priority
			// XXX : Debug check that DerivedTypedElement only contained by Facet
			final List<T> orderedCandidates = getOverrideCandidateFeatures(eObject,
					signatureFeature);

			// -- Find the most specific feature
			return findMostSpecificFeature(orderedCandidates);
		} catch (Exception e) {
			throw new FacetManagerException(e);
		}
	}

	public List<FacetSet> getManagedFacetSets() {
		return Collections.unmodifiableList(this.managedFacetSets);
	}

	public void setManagedFacetSets(final List<FacetSet> facetSets) {
		this.managedFacetSets = new LinkedList<FacetSet>(facetSets);
		notifyListeners();
	}

	public void addBackManagedFacetSet(final FacetSet facetSet) {
		// adding an already managed FacetSet again moves it to the right position
		this.managedFacetSets.remove(facetSet);
		this.managedFacetSets.addLast(facetSet);
		notifyListeners();
	}

	public void addFrontManagedFacetSet(final FacetSet facetSet) {
		if (this.managedFacetSets == null) {
			this.managedFacetSets = new LinkedList<FacetSet>();
		}
		// adding an already managed FacetSet again moves it to the right position
		this.managedFacetSets.remove(facetSet);
		this.managedFacetSets.addFirst(facetSet);
		notifyListeners();
	}

	/**
	 * Find the most specific feature in the candidates list. The most specific
	 * is the feature that : - is the most specific (in terms of Facet
	 * inheritance) : the lowest in the inheritance tree (per branch) - is
	 * encountered first. The order is given by the FacetManager context.
	 * 
	 * @param candidates
	 *            The list of candidates features. Can be empty.
	 * @return
	 */
	private static <T extends DerivedTypedElement> T findMostSpecificFeature(
			final List<T> orderedCandidates) {
		T result = null;
		if (!orderedCandidates.isEmpty()) {
			final Iterator<T> candidatesIt = orderedCandidates.iterator();
			result = candidatesIt.next();
			// We have the highest priority feature, we just have to check
			// that there is no more specific one in the override chain (from
			// top to bottom)
			while (candidatesIt.hasNext()) {
				final T candidate = candidatesIt.next();
				if (isOverridenBy(candidate, result)) {
					result = candidate;
				}
			}
		}
		return result;
	}

	/**
	 * Find matching candidates.
	 * 
	 * @param eObject
	 * @param baseFeature
	 * @return A list of candidates, in the right order for conflict resolution
	 * @throws FacetManagerException 
	 */
	private <T extends DerivedTypedElement> List<T> getOverrideCandidateFeatures(
			final EObject eObject, final T baseFeature)
			throws FacetManagerException {
		final ResourceSet baserFeatureRS = baseFeature.eResource().getResourceSet();
		final List<T> result = new LinkedList<T>();
		// Iterate over all Facets from all facetSets to find conforming
		// features
		final List<FacetSet> managedFSets = getManagedFacetSets();
		final List<FacetSet> allFacetSets = new ArrayList<FacetSet>(managedFSets);
		// add aggregated FacetSets
		for (FacetSet facetSet : managedFSets) {
			//FIXME Should handle recursive containment.
			for (FacetSet subFacetSet : facetSet.getFacetSets()) {
				final FacetSet resolvedFacetSet = IResolverManager.DEFAULT
						.resolve(subFacetSet, FacetSet.class);
				allFacetSets.add(resolvedFacetSet);
			}
		}
		for (FacetSet facetSet : allFacetSets) {
			final Resource resource = facetSet.eResource();
			if (resource == null) {
				final String message = String.format(
						"The facetSet %s (%s) is not stored in a resource.", //$NON-NLS-1$
						facetSet.getName(), facetSet.getNsURI());
				Logger.logWarning(message, Activator.getDefault());
			} else {
				final ResourceSet facetSetRS = resource.getResourceSet();
				if (!facetSetRS.equals(baserFeatureRS)) {
					Logger.logWarning(
							"The facet manager is dealing with more than one resource set.", //$NON-NLS-1$
							Activator.getDefault());
				}
			}
			for (Facet facet : FacetUtils.getFacets(facetSet)) {
				final T matchingFeature = getMatchingFeature(eObject, facet,
						baseFeature);
				if (matchingFeature != null) {
					result.add(matchingFeature);
				}
			}
		}
		if (result.isEmpty()) {
			if (!this.failingFeatures.contains(baseFeature)
					&& !FacetManagerContext.SILENT) {
				Logger.logWarning(
						"The result of " //$NON-NLS-1$
								+ this.getClass().getSimpleName()
								+ ".getOverrideCandidateFeatures(...) is empty! baseFeature=" //$NON-NLS-1$
								+ EcoreUtil.getURI(baseFeature)
								+ " (This message will be sent only once)", //$NON-NLS-1$
						Activator.getDefault());
				// This avoid to have to many error messages in the log.
				this.failingFeatures.add(baseFeature);
			}
			result.add(baseFeature);
		}
		return result;
	}

	/**
	 * Test whether a feature is overridden by another (directly or not)
	 * 
	 * @param targetParent
	 * @param child
	 * @return true if child is directly or indirectly overridden by parent,
	 *         false otherwise
	 */
	private static boolean isOverridenBy(final DerivedTypedElement child,
			final DerivedTypedElement targetParent) {

		boolean result = false;
		if (child.equals(targetParent)) {
			result = true;
		} else {
			DerivedTypedElement currentParent = child.getOverride();
			while (!result && currentParent != null) {
				if (currentParent.equals(targetParent)) {
					result = true;
				} else {
					currentParent = currentParent.getOverride();
				}
			}
		}
		return result;
	}

	/**
	 * Find DerivedTypedElement features that matches the 'signature'
	 * 
	 * @param eObject
	 *            EObject used to test conformance
	 * @param facet
	 * @param signatureFeature
	 *            reference feature that serves as 'signature'
	 * @throws FacetManagerException 
	 */
	private <T extends DerivedTypedElement> T getMatchingFeature(
			final EObject eObject, final Facet facet, final T signatureFeature)
			throws FacetManagerException {
		T result = null;
		EList<? extends ETypedElement> eTypedElements;
		if (signatureFeature instanceof EOperation) {
			eTypedElements = facet.getFacetOperations();
		} else {
			eTypedElements = facet.getFacetElements();
		}
		// For each eTypedElement check is it override the signature feature and
		// if the eTypedElement is owned by a facet to which the eObject
		// conforms.
		for (ETypedElement feature : eTypedElements) {
			if (isMatchingFeature2(signatureFeature, feature)) {
				// The conformance check is done after the check on the override
				// to avoid infinite recursion.
				final ConformanceState conformanceState = this.manager
						.getConformanceState(eObject, facet);
				if (conformanceState == ConformanceState.Conformant) {
					if (!signatureFeature.getClass().isInstance(feature)) {
						throw new FacetManagerException(
								ModelUtils.getQualifiedName(feature)
										+ " overrides " //$NON-NLS-1$
										+ ModelUtils
												.getQualifiedName(signatureFeature)
										+ " but both are not of the same kind."); //$NON-NLS-1$
					}
					@SuppressWarnings("unchecked")
					// @SuppressWarnings("unchecked") check by
					// "if (!signatureFeature.getClass().isInstance(feature))"
					final T tmpFeature = (T) feature;
					result = tmpFeature;
					break;
					// Two features from the same Facet cannot
					// override a feature, so only one can be find
					// in this Facet => stop search here.
				}
			}
		}
		return result;
	}

	private static <T extends DerivedTypedElement> boolean isMatchingFeature2(
			final T signatureFeature, final ETypedElement feature)
			throws FacetManagerException {
		boolean result = false;
		// We're focusing on DerivedTypedElements
		// ECore native features could not be overridden by Facets
		// (EMF facet is supposed to be non intrusive)

		if (signatureFeature.getClass().isInstance(feature)) {
			final T element = (T) feature;
			// Just check that the top override is the same as the base feature
			// i.e. that the current feature matches the 'signature'
			final DerivedTypedElement topFeature = FacetUtils
					.getTopOverrideFeature(element);
			if (topFeature == signatureFeature) {
				// found a match
				result = true;
			} else {
				final Resource topResource = topFeature.eResource();
				final Resource signatureResource = signatureFeature.eResource();
				if (topResource == null || signatureResource == null || topFeature.eResource().getResourceSet() != signatureFeature.eResource().getResourceSet()) {
					Logger.logWarning(
							"topOverrideFeature.eResource().getResourceSet() != signatureFeature.eResource().getResourceSet()", //$NON-NLS-1$
							Activator.getDefault());
				} 
			}
		}
		return result;
	}

	public void removeFacetSet(final FacetSet facetSet) {
		final boolean removed = this.managedFacetSets.remove(facetSet);
		if (removed) {
			notifyListeners();
		}
	}

	public void clear() {
		final boolean empty = this.managedFacetSets.isEmpty();
		if (!empty) {
			this.managedFacetSets.clear();
			notifyListeners();
		}
	}

	public int size() {
		return this.managedFacetSets.size();
	}

	public boolean isEmpty() {
		return this.managedFacetSets.isEmpty();
	}

	public boolean contains(final Object object) {
		return this.managedFacetSets.contains(object);
	}

	public Iterator<FacetSet> iterator() {
		return this.managedFacetSets.iterator();
	}

	public Object[] toArray() {
		return this.managedFacetSets.toArray();
	}

	public <T> T[] toArray(final T[] array) {
		return this.managedFacetSets.toArray(array);
	}

	public boolean add(final FacetSet object) {
		boolean result = false;
		this.managedFacetSets.remove(object);
		if (object != null) {
			result = this.managedFacetSets.add(object);
		}
		if (result) {
			notifyListeners();
		}
		return result;
	}

	public boolean remove(final Object object) {
		final boolean isRemoved = this.managedFacetSets.remove(object);
		if (isRemoved) {
			notifyListeners();
		}
		return isRemoved;
	}

	public boolean containsAll(final Collection<?> collection) {
		return this.managedFacetSets.containsAll(collection);
	}

	public boolean addAll(final Collection<? extends FacetSet> collection) {
		boolean result = false;
		for (FacetSet facetSet : collection) {
			this.managedFacetSets.remove(facetSet);
			if (facetSet != null) {
				final boolean addResult = this.managedFacetSets.add(facetSet);
				result = result || addResult;
			}
		}
		if (result) {
			notifyListeners();
		}
		return result;
	}

	public boolean addAll(final int index,
			final Collection<? extends FacetSet> collection) {
		final List<FacetSet> filtered = new ArrayList<FacetSet>();
		for (FacetSet facetSet : collection) {
			if (!filtered.contains(facetSet)) {
				filtered.add(facetSet);
			}
		}
		this.managedFacetSets.removeAll(filtered);
		final boolean isAdded = this.managedFacetSets.addAll(index,
				ListUtils.cleanList(filtered));
		if (isAdded) {
			notifyListeners();
		}
		return isAdded;
	}

	public boolean removeAll(final Collection<?> collection) {
		final boolean isRemoved = this.managedFacetSets.removeAll(collection);
		if (isRemoved) {
			notifyListeners();
		}
		return isRemoved;
	}

	public boolean retainAll(final Collection<?> collection) {
		final boolean isRetained = this.managedFacetSets.retainAll(collection);
		if (isRetained) {
			notifyListeners();
		}
		return isRetained;
	}

	public FacetSet get(final int index) {
		return this.managedFacetSets.get(index);
	}

	public FacetSet set(final int index, final FacetSet element) {
		final FacetSet oldElement = this.managedFacetSets.set(index, element);
		if (!oldElement.equals(element)) {
			notifyListeners();
		}
		return oldElement;
	}

	public void add(final int index, final FacetSet element) {
		this.managedFacetSets.remove(element);
		if (element != null) {
			this.managedFacetSets.add(index, element);
			notifyListeners();
		}
	}

	public FacetSet remove(final int index) {
		final FacetSet oldElement = this.managedFacetSets.remove(index);
		notifyListeners();
		return oldElement;
	}

	public int indexOf(final Object object) {
		return this.managedFacetSets.indexOf(object);
	}

	public int lastIndexOf(final Object object) {
		return this.managedFacetSets.lastIndexOf(object);
	}

	public ListIterator<FacetSet> listIterator() {
		return this.managedFacetSets.listIterator();
	}

	public ListIterator<FacetSet> listIterator(final int index) {
		return this.managedFacetSets.listIterator(index);
	}

	public List<FacetSet> subList(final int fromIndex, final int toIndex) {
		return this.subList(fromIndex, toIndex);
	}

	public void addListener(final IFacetManagerListener listener) {
		this.listeners.add(listener);
	}

	public void removeListener(final IFacetManagerListener listener) {
		this.listeners.remove(listener);
	}
	
	private void notifyListeners() {
		for (IFacetManagerListener listener : this.listeners) {
			listener.facetManagerChanged();
		}
	}
}
