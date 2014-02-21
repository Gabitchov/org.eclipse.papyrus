/*******************************************************************************
 * Copyright (c) 2011, 2012 Mia-Software
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	   Emmanuelle Rouillé (Mia-Software) - Bug 352618 - To be able to use non derived facet structural features and save them values.
 *     Nicolas Bros (Mia-Software) - Bug 361612 - New core for new version of the Facet metamodel
 *     Grégoire Dupé (Mia-Software) - Bug 361612 - [Restructuring] New core for new version of the Facet metamodel*
 *     Olivier Remaud (Soft-Maint) - Bug 361794 - [Restructuring] EMF Facet customization meta-model
 *     Gregoire Dupe (Mia-Software) - Bug 361794 - [Restructuring] New customization meta-model
 *     Gregoire Dupe (Mia-Software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 *     Gregoire Dupe (Mia-Software) - Bug 364325 - [Restructuring] The user must be able to navigate into a model using the Facet.
 *     Olivier Remaud (Mia-Software) - Bug 374348 - Infinite loop in Facet override resolution
 *     Gregoire Dupe (Mia-Software) - Bug 373078 - API Cleaning
 *     Gregoire Dupe (Mia-Software) - Bug 376576 - [EFacet] Change the multiplicity of Facet::extendedFacet
 *     Nicolas Bros (Mia-Software) - Bug 378475 - unit test failures after table refactoring
 *     Thomas Cicognani (Soft-Maint) - Bug 416221 - New methods to get references in FacetManager API
 *     Thomas Cicognani (Soft-Maint) - Bug 420193 - Listener on FacetManager
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.efacet.core.internal;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.emf.facet.efacet.core.FacetUtils;
import org.eclipse.papyrus.emf.facet.efacet.core.IDerivedTypedElementManager;
import org.eclipse.papyrus.emf.facet.efacet.core.IFacetManager;
import org.eclipse.papyrus.emf.facet.efacet.core.IFacetManagerListener;
import org.eclipse.papyrus.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.papyrus.emf.facet.efacet.core.exception.FacetManagerException;
import org.eclipse.papyrus.emf.facet.efacet.core.internal.exception.FacetConformanceEvaluationException;
import org.eclipse.papyrus.emf.facet.efacet.core.internal.exception.NonApplicableFacetException;
import org.eclipse.papyrus.emf.facet.efacet.core.internal.exception.NonConformingEObjectException;
import org.eclipse.papyrus.emf.facet.efacet.core.internal.exception.UnmatchingExpectedTypeException;
import org.eclipse.papyrus.emf.facet.efacet.core.internal.serialization.SerializationManager;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.DerivedTypedElement;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetAttribute;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetOperation;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetReference;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.ETypedElementEObjectListResult;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.ETypedElementEObjectResult;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.ETypedElementPrimitiveTypeListResult;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.ETypedElementPrimitiveTypeResult;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.ETypedElementResult;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.RuntimeFactory;
import org.eclipse.papyrus.emf.facet.util.core.Logger;

public class FacetManager implements IFacetManager, Adapter {

	private static final EClassifier EBOOLEAN = EcorePackage.eINSTANCE.getEBoolean();
	private static final EClassifier EBOOLEAN_OBJECT = EcorePackage.eINSTANCE.getEBooleanObject();
	private final FacetManagerContext context;
	private final SerializationManager serializationMgr;
	private final ResourceSet resourceSet;

	public FacetManager(final Resource resource) {
		this.serializationMgr = new SerializationManager(resource);
		this.context = new FacetManagerContext(this);
		this.resourceSet = resource.getResourceSet();
	}

	public FacetManager(final ResourceSet resourceSet) {
		this.serializationMgr = new SerializationManager(null);
		this.context = new FacetManagerContext(this);
		this.resourceSet = resourceSet;
	}

	public void saveStructuralFeatureInstanceModel()
			throws FacetManagerException {
		this.serializationMgr.saveStructuralFeatureInstanceModel();
	}

	/**
	 * Returns whether the given model element conforms to the given Facet
	 * 
	 * @param eObject
	 *            the model element
	 * @param facet
	 *            the Facet the applicability of which is being tested
	 * @return whether the given model element should be seen as an instance of the given Facet
	 */
	public boolean isConforming(final EObject eObject, final Facet facet)
			throws FacetManagerException {
		return getConformanceState(eObject, facet) == FacetManager.ConformanceState.Conformant;
	}

	public enum ConformanceState {
		Conformant, NonConformingMetaclass, NonConformingElement
	}

	private void checkConformance(final EObject eObject, final Facet facet)
			throws FacetManagerException {
		final ConformanceState conformanceState = getConformanceState(eObject, facet);
		if (conformanceState == FacetManager.ConformanceState.NonConformingMetaclass) {
			throw new FacetManagerException("NonApplicableFacetException"); //$NON-NLS-1$
		}
		if (conformanceState == FacetManager.ConformanceState.NonConformingElement) {
			throw new FacetManagerException("NonConformingEObjectException"); //$NON-NLS-1$
		}
	}

	protected ConformanceState getConformanceState(final EObject eObject,
			final Facet facet) throws FacetManagerException {
		// Begin of precondition section
		if (eObject == null) {
			throw new IllegalArgumentException("eObject cannot be null"); //$NON-NLS-1$
		}
		if (facet == null) {
			throw new IllegalArgumentException("facet cannot be null"); //$NON-NLS-1$
		}
		// End of precondition section
		ConformanceState result;
		final EClass extendedMetaclass = FacetUtils.getExtendedMetaclass(facet);
		if (extendedMetaclass != null
				&& (extendedMetaclass.isSuperTypeOf(eObject.eClass()) || extendedMetaclass == EcorePackage.eINSTANCE.getEObject())) {
			final ETypedElement typeElement = facet.getConformanceTypedElement();
			if (typeElement == null) {
				result = FacetManager.ConformanceState.Conformant;
			} else {
				final Boolean isConforming = getConformanceValue(eObject, typeElement);
				if (isConforming.booleanValue()) {
					result = FacetManager.ConformanceState.Conformant;
				} else {
					result = FacetManager.ConformanceState.NonConformingElement;
				}
			}
		} else {
			result = FacetManager.ConformanceState.NonConformingMetaclass;
		}
		// The conformance constraint is inherited from the super facet.
		if (result == FacetManager.ConformanceState.Conformant) {
			for (Facet extFacet : facet.getExtendedFacets()) {
				result = getConformanceState(eObject, extFacet);
				if (result != FacetManager.ConformanceState.Conformant) {
					break;
				}
			}
		}
		return result;
	}

	private Boolean getConformanceValue(final EObject eObject,
			final ETypedElement typeElement) throws FacetManagerException {
		// Begin precondition checking
		if (typeElement.isMany()) {
			throw new FacetManagerException(
					"The Facet's conformance typed element must not be multi-valued"); //$NON-NLS-1$
		}
		if (typeElement.getEType() != FacetManager.EBOOLEAN && typeElement.getEType() != FacetManager.EBOOLEAN_OBJECT) {
			throw new FacetManagerException(
					"The Facet conformance typed element evaluated to a wrong type."); //$NON-NLS-1$
		}
		// End precondition checking
		Boolean result; // conformance typedElement Value
		try {
			if (typeElement instanceof EStructuralFeature) {
				final EStructuralFeature structuralFeature = (EStructuralFeature) typeElement;
				// basicGet = true in order to avoid an infinite recursion
				result = internalGet(eObject, structuralFeature, Boolean.class, true);
			} else if (typeElement instanceof EOperation) {
				final EOperation operation = (EOperation) typeElement;
				if (operation.getEParameters().size() > 0) {
					throw new FacetConformanceEvaluationException("The Facet's conformance operation cannot have parameters"); //$NON-NLS-1$
				}
				// basicInvoke = true in order to avoid an infinite recursion,
				// ie don't check conformance and don't resolve overrides
				result = internalInvoke(eObject, operation, Boolean.class, true);
			} else {
				throw new FacetConformanceEvaluationException("Unsupported conformance typed element type: " + typeElement.getClass().getName()); //$NON-NLS-1$
			}
		} catch (Exception e) {
			throw new FacetManagerException(e);
		}
		if (result == null) {
			throw new FacetManagerException(
					"The Facet conformance typed element evaluated to null"); //$NON-NLS-1$
		}
		return result;
	}

	public void set(final EObject eObject,
			final EStructuralFeature structuralFeature, final Object newValue,
			final EditingDomain editingDomain) throws FacetManagerException {
		if (structuralFeature.isMany() && !(newValue instanceof Collection<?>)) {
			throw new IllegalArgumentException("newValue should be a Collection because eStructuralFeature is an EReference"); //$NON-NLS-1$
			// TODO: check the type of the elements of the list.
		}
		final EObject eContainer = structuralFeature.eContainer();
		if (eContainer instanceof Facet) {
			final Facet facet = (Facet) eContainer;
			checkConformance(eObject, facet);
			if (structuralFeature instanceof EAttribute) {
				final EAttribute eAttribute = (EAttribute) structuralFeature;
				if (structuralFeature instanceof FacetAttribute) {
					// TODO We still have to implement the setting of a derived facet attribute. Cf.
					// https://bugs.eclipse.org/bugs/show_bug.cgi?id=365726
					throw new UnsupportedOperationException("Setting a FacetAttribute is not yet implemented"); //$NON-NLS-1$
				} // else { // instanceof EAttribute
				this.serializationMgr.setAttribute(eObject, eAttribute, newValue);
				// }
			} else if (structuralFeature instanceof EReference) {
				final EReference reference = (EReference) structuralFeature;
				if (reference instanceof FacetReference) {
					// TODO We still have to implement the setting of a derived facet attribute. Cf.
					// https://bugs.eclipse.org/bugs/show_bug.cgi?id=365726
					throw new UnsupportedOperationException("Setting a FacetReference is not yet implemented"); //$NON-NLS-1$
				} // else { // instanceof EReference
				this.serializationMgr.setReference(eObject, reference, newValue);
				// }
			} else {
				throw new UnsupportedOperationException(
						"Setting a structural feature of type '" + structuralFeature.getClass().getName() + "' is not implemented"); //$NON-NLS-1$ //$NON-NLS-2$
			}
		} else {
			eObject.eSet(structuralFeature, newValue);
		}
	}

	public <T> T get(final EObject eObject,
			final EStructuralFeature structuralFeature,
			final Class<T> expectedType) throws FacetManagerException {
		return internalGet(eObject, structuralFeature, expectedType, false);
	}

	private <T> T internalGet(final EObject eObject,
			final EStructuralFeature structuralFeature,
			final Class<T> expectedType, final boolean basicGet)
			throws FacetManagerException {
		try {
			Object value;	
			if (structuralFeature.eContainer() instanceof Facet) {
				
				EStructuralFeature baseFeature = structuralFeature;
								
				if (!basicGet) {
					baseFeature = this.context.resolveOverrides(structuralFeature, eObject);
					final Facet facet = (Facet) baseFeature.eContainer();
					checkConformance(eObject, facet);
				}
				if (baseFeature.isDerived()) {
					if (!(baseFeature instanceof DerivedTypedElement)) {
						throw new UnsupportedOperationException("Cannot evaluate a derived structural feature that is not a DerivedTypedElement : not implemented"); //$NON-NLS-1$
					}
					value = IDerivedTypedElementManager.INSTANCE.evaluate((DerivedTypedElement) baseFeature, eObject, null, this);
				} else {
					if (baseFeature instanceof DerivedTypedElement) {
						throw new IllegalArgumentException("A DerivedTypedElement must always be derived"); //$NON-NLS-1$
					}
					value = this.serializationMgr.getNotDerivedValue(eObject, baseFeature);
				}
			} else { // Regular structural feature
				if (structuralFeature instanceof DerivedTypedElement) {
					throw new IllegalStateException("The given DerivedTypedElement is not contained in a Facet"); //$NON-NLS-1$
				}
				value = eObject.eGet(structuralFeature, true);
			}
			return EmfUtils.checkAssignment(structuralFeature, expectedType, value);
		} catch (Exception e) {
			throw new FacetManagerException(e);
		}
	}

	public <T> List<T> getMultiValued(final EObject eObject,
			final EStructuralFeature structuralFeature,
			final Class<T> expectedType) throws FacetManagerException {
		final Object result = internalGet(eObject, structuralFeature, null, false);
		// return the original list, which must be modifiable by the caller
		try {
			return CastUtils.castToExpectedListType(result, expectedType, true);
		} catch (UnmatchingExpectedTypeException e) {
			throw new UnmatchingExpectedTypeException("Failed to cast the value of '" + structuralFeature.getName() + "' to a list of " + expectedType.getName(), e); //$NON-NLS-1$//$NON-NLS-2$
		}
	}

	public <T> T invoke(final EObject eObject, final EOperation operation,
			final Class<T> expectedType, final EditingDomain editingDomain, final Object... arguments)
			throws FacetManagerException {
		try {
			return internalInvoke(eObject, operation, expectedType, false, arguments);
		} catch (Exception e) {
			throw new FacetManagerException("Error invoking Facet operation '" + operation.getName() + "'", e); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	public <T> List<T> invokeMultiValued(final EObject eObject, final EOperation operation,
			final Class<T> expectedType, final Object... arguments)
			throws FacetManagerException {
		Object result;
		try {
			result = internalInvoke(eObject, operation, null, false, arguments);
		} catch (Exception e) {
			throw new FacetManagerException("Error invoking Facet operation '" + operation.getName() + "'", e); //$NON-NLS-1$ //$NON-NLS-2$
		}
		return CastUtils.castToExpectedListType(result, expectedType, true);
	}

	private <T> T internalInvoke(final EObject eObject, final EOperation operation, final Class<T> expectedType,
			final boolean basicInvoke, final Object... arguments)
			throws DerivedTypedElementException, InvocationTargetException,
			FacetConformanceEvaluationException, NonApplicableFacetException,
			NonConformingEObjectException, FacetManagerException {
		Object result;
		if (operation.eContainer() instanceof Facet) {
			final Facet facet = (Facet) operation.eContainer();
			
			if (!basicInvoke) {
				checkConformance(eObject, facet);
			}
			if (operation instanceof FacetOperation) {
				final FacetOperation facetOperation = (FacetOperation) operation;
				FacetOperation baseOperation = facetOperation;
				if (!basicInvoke) {
					baseOperation = this.context.resolveOverrides(facetOperation, eObject);
				}
				result = DerivedTypedElementUtils.evaluate(eObject, baseOperation, this, arguments);
			} else {
				result = EmfUtils.ecoreInvoke(eObject, operation, null, arguments);
			}
		} else { // Regular eOperation
			if (operation instanceof FacetOperation) {
				throw new IllegalStateException("The given FacetOperation is not contained in a Facet"); //$NON-NLS-1$
			}
			result = EmfUtils.ecoreInvoke(eObject, operation, null, arguments);
		}
		return CastUtils.castToExpectedType(result, expectedType);
	}

	public List<ETypedElementResult> get(final Collection<EObject> eObjects, final EStructuralFeature structuralFeature)
			throws DerivedTypedElementException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("not implemented yet"); //$NON-NLS-1$
	}

	public List<ETypedElementResult> batchInvoke(
			final Collection<EObject> eObjects, final EOperation operation,
			final Object... arguments) throws FacetManagerException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("not implemented yet"); //$NON-NLS-1$
	}

	public List<FacetSet> getManagedFacetSets() {
		return this.context;
	}

	public void setManagedFacetSets(final List<FacetSet> facetSets) {
		this.context.setManagedFacetSets(facetSets);
	}

	public void removeFacetSet(final FacetSet facetSet) {
		this.context.removeFacetSet(facetSet);
	}

	public ResourceSet getResourceSet() {
		return this.resourceSet;
	}

	public List<ETypedElement> getAppliedFeatures() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("not implemented yet"); //$NON-NLS-1$
	}

	public Set<EAttribute> getAttributes(final EObject eObject)
			throws FacetManagerException {
		return getEStructuralFeatures(eObject, EAttribute.class);
	}
	
	public Set<EStructuralFeature> getStructuralFeature(final EObject eObject)
			throws FacetManagerException {
		return getEStructuralFeatures(eObject, EStructuralFeature.class);
	}
	
	public <T extends ETypedElement> Set<T> getEStructuralFeatures(
			final EObject eObject, final Class<T> classs)
			throws FacetManagerException {
		final Set<T> result = new HashSet<T>();
		for (FacetSet facetSet : this.context.getManagedFacetSets()) {
			result.addAll(getETypedElements(eObject, facetSet, classs));
		}
		return result;
	}
	
	private <T extends ETypedElement> Collection<T> getETypedElements(
			final EObject eObject, final FacetSet facetSet,
			final Class<T> classs) throws FacetManagerException {
		final Set<T> result = new HashSet<T>();
		for (EClassifier eClassifier : facetSet.getEClassifiers()) {
			if (eClassifier instanceof Facet) {
				final Facet facet = (Facet) eClassifier;
				if (isConforming(eObject, facet)) {
					for (EStructuralFeature eStructuralFeature : getAllEStructuralFeatures(facet)) {
						if (classs.isInstance(eStructuralFeature)) {
							@SuppressWarnings("unchecked")
							// @SuppressWarnings("unchecked") This type has been
							// checked using isInstance
							final T typedSF = (T) eStructuralFeature;
							result.add(typedSF);
						}
					}
				}
			}
		}
		// hierarchical FacetSets
		for (EPackage ePackage : facetSet.getESubpackages()) {
			if (ePackage instanceof FacetSet) {
				final FacetSet subFacetSet = (FacetSet) ePackage;
				result.addAll(getETypedElements(eObject,
						subFacetSet, classs));
			}
		}
		// aggregates
		for (FacetSet subFacetSet : facetSet.getFacetSets()) {
			result.addAll(getETypedElements(eObject, subFacetSet, classs));
		}
		return result;
	}

	private List<EStructuralFeature> getAllEStructuralFeatures(final Facet facet) {
		final List<EStructuralFeature> structFeatures = new LinkedList<EStructuralFeature>();
		structFeatures.addAll(facet.getFacetElements());
		for (Facet extFacet : facet.getExtendedFacets()) {
			structFeatures.addAll(getAllEStructuralFeatures(extFacet));
		}
		return structFeatures;
	}

	public Set<EReference> getReferences(final EObject eObject)
			throws FacetManagerException {
		return getEStructuralFeatures(eObject, EReference.class);
	}

	public Collection<? extends EStructuralFeature> getSF(final EObject eObject)
			throws FacetManagerException {
		return getEStructuralFeatures(eObject, EStructuralFeature.class);
	}
	
	@Deprecated
	public void addFacets(final EList<Facet> facets) {
		for (Facet facetToLoad : facets) {
			this.context.addFrontManagedFacetSet((FacetSet) facetToLoad
					.getEPackage());
		}
	}

	@Deprecated
	public void unLoadAllFacets() {
		removeAllManagedFacetSets();
	}

	public void removeAllManagedFacetSets() {
		this.context.clear();
	}

	public <T> List<T> getOrInvokeMultiValued(final EObject eObject,
			final ETypedElement eTypedElement, final Class<T> classs)
			throws FacetManagerException {
		List<T> result = null;
		if (eTypedElement instanceof EStructuralFeature) {
			final EStructuralFeature structuralFeature = (EStructuralFeature) eTypedElement;
			result = getMultiValued(eObject, structuralFeature, classs);
		} else if (eTypedElement instanceof EOperation) {
			final EOperation eOperation = (EOperation) eTypedElement;
			result = invokeMultiValued(eObject, eOperation, classs);
		}
		return result;
	}
	
	public <T> T getOrInvoke(final EObject eObject,
			final ETypedElement eTypedElement, final Class<T> classs)
			throws FacetManagerException {
		T result = null;
		if (eTypedElement instanceof EStructuralFeature) {
			final EStructuralFeature structuralFeature = (EStructuralFeature) eTypedElement;
			result = get(eObject, structuralFeature, classs);
		} else if (eTypedElement instanceof EOperation) {
			final EOperation eOperation = (EOperation) eTypedElement;
			result = invoke(eObject, eOperation, classs, null);
		}
		return result;
	}

	public List<Facet> getManagedFacets() {
		throw new IllegalStateException("Not implemented, and never will since it's deprecated"); //$NON-NLS-1$
	}

	public <T> List<ETypedElementResult> batchGetOrInvoke(final Collection<EObject> sources, final ETypedElement query, final Class<T> classs)
			throws FacetManagerException {
		final List<ETypedElementResult> results = new LinkedList<ETypedElementResult>();
		for (EObject source : sources) {
			ETypedElementResult result = null;
			Exception exception = null;
			if (query.getEType() instanceof EClass) {
				if (query.getUpperBound() == 1) {
					final ETypedElementEObjectResult<EObject> eObjectResult = RuntimeFactory.eINSTANCE.createETypedElementEObjectResult();
					try {
						eObjectResult.setResult(this.getOrInvoke(source, query, EObject.class));
					} catch (Exception e) {
						exception = e;
					}
					result = eObjectResult;
				} else {
					final ETypedElementEObjectListResult<EObject> eObjectResultList = RuntimeFactory.eINSTANCE.createETypedElementEObjectListResult();
					try {
						eObjectResultList.getResultList().addAll(this.getOrInvokeMultiValued(source, query, EObject.class));
					} catch (Exception e) {
						exception = e;
					}
					result = eObjectResultList;
				}
			} else {
				if (query.getUpperBound() == 1) {
					final ETypedElementPrimitiveTypeResult<Object> eObjectResult = RuntimeFactory.eINSTANCE.createETypedElementPrimitiveTypeResult();
					try {
						eObjectResult.setResult(this.getOrInvoke(source, query, Collection.class));
					} catch (Exception e) {
						exception = e;
					}
					result = eObjectResult;
				} else {
					final ETypedElementPrimitiveTypeListResult<Object> eObjectResultList = RuntimeFactory.eINSTANCE.createETypedElementPrimitiveTypeListResult();
					eObjectResultList.getResultList().addAll(this.getOrInvokeMultiValued(source, query, Object.class));
					result = eObjectResultList;
				}
			}
			if (exception != null) {
				result.setException(exception);
				Logger.logWarning(exception, Activator.getDefault());
			}
			result.setDerivedTypedElement(query);
			result.setSource(source);
			results.add(result);
		}
		return results;
	}

	public void addBackManagedFacetSet(final FacetSet facetSet) {
		this.context.addBackManagedFacetSet(facetSet);
	}
	
	public void addFrontManagedFacetSet(final FacetSet facetSet) {
		this.context.addFrontManagedFacetSet(facetSet);
	}

	public void notifyChanged(final Notification notification) {
		// Nothing to do
	}

	public Notifier getTarget() {
		return null;
	}

	public void setTarget(final Notifier newTarget) {
		// Nothing to do
	}

	public boolean isAdapterForType(final Object type) {
		return false;
	}

	public void addListener(final IFacetManagerListener listener) {
		this.context.addListener(listener);
	}

	public void removeListener(final IFacetManagerListener listener) {
		this.context.removeListener(listener);
	}

}
