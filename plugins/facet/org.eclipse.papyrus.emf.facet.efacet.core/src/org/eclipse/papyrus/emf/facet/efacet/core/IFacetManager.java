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
 *     Olivier Remaud (Soft-Maint) - Bug 361794 - [Restructuring] EMF Facet customization meta-model
 *     Gregoire Dupe (Mia-Software) - Bug 361794 - [Restructuring] New customization meta-model
 *     Gregoire Dupe (Mia-Software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 *     Gregoire Dupe (Mia-Software) - Bug 364325 - [Restructuring] The user must be able to navigate into a model using the Facet.
 *     Gregoire Dupe (Mia-Software) - Bug 373078 - API Cleaning
 *     Thomas Cicognani (Soft-Maint) - Bug 416221 - New methods to get references in FacetManager API
 *     Thomas Cicognani (Soft-Maint) - Bug 420193 - Listener on FacetManager
 *******************************************************************************/
package org.eclipse.emf.facet.efacet.core;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.facet.efacet.core.exception.FacetManagerException;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetAttribute;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetReference;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.ETypedElementResult;

/**
 * This interface allows clients to use the EMF Facet API to get and set the values of virtually
 * added {@link EReference}s and {@link EAttribute}s, and invoke {@link EOperation}s.
 * <p>
 * Derived {@link FacetAttribute}s and {@link FacetReference}s are computed by queries, whereas
 * non-derived {@link FacetAttribute}s and {@link EAttribute}s and {@link EReference}s and
 * {@link FacetReference}s are stored in the serialization {@link Resource} specified in the
 * {@link IFacetManagerFactory} that created this {@link IFacetManager}.
 *
 * @since 0.2
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface IFacetManager {

	/**
	 * Serialize the model containing the structural feature instances.
	 */
	void saveStructuralFeatureInstanceModel() throws FacetManagerException;

	/**
	 * Returns whether the given model element conforms to the given Facet
	 *
	 * @param eObject
	 *            the model element
	 * @param facet
	 *            the Facet the applicability of which is being tested
	 * @throws FacetManagerException
	 *             if there is an error evaluating the Facet's conformance typed element
	 * @return whether the given model element should be seen as an instance of the given Facet
	 */
	boolean isConforming(final EObject eObject, final Facet facet)
			throws FacetManagerException;

	/**
	 * Set the value of the given {@link EStructuralFeature} on the given
	 * {@link EObject} to the given {@link Object} value.
	 * 
	 * @param eObject
	 *            the model element whose feature must be set
	 * @param structuralFeature
	 *            the feature to set
	 * @param newValue
	 *            the new value
	 * @param editingDomain
	 * @throws FacetManagerException
	 *             <ul>
	 *             <li>if the eObject doesn't conform to the Facet of the given
	 *             attribute (in the case of a FacetAttribute)</li>
	 *             <li>if the Facet of the given attribute is not applicable to
	 *             the given eObject (in the case of a FacetAttribute)</li>
	 *             <li>
	 *             if there is an error evaluating the Facet's conformance typed
	 *             element</li>
	 *             </ul>
	 */
	void set(EObject eObject, EStructuralFeature structuralFeature,
			Object newValue, EditingDomain editingDomain)
			throws FacetManagerException;

	/**
	 * Evaluate the given {@link EOperation} of the given {@link EObject}. The
	 * returned value has to be of the given expectedType {@link Class}
	 * 
	 * @param eObject
	 *            the model element on which the operation is evaluated
	 * @param operation
	 *            the operation to evaluate
	 * @param resultType
	 *            the expected type of the returned value; if the effective type
	 *            is not compatible, an UnmatchingExpectedTypeException will be
	 *            thrown
	 * @param arguments
	 *            the values of the parameters of the EOperation that is
	 *            evaluated: they must match both in size, types and
	 *            multiplicity
	 * @return the return value of the operation
	 * @throws FacetManagerException
	 *             <ul>
	 *             <li>if the effective type does not match the expected type</li>
	 *             <li>in case of an error in the query that returns the value
	 *             (can only happen in the case of a FacetOperation)</li>
	 *             <li>in case of an error when delegating to the Ecore
	 *             reflexive API (if the given EOperation is not a
	 *             FacetOperation)</li>
	 *             <li>if the eObject doesn't conform to the Facet of the given
	 *             operation (in the case of a FacetOperation)</li>
	 *             <li>if the Facet of the given operation is not applicable to
	 *             the given eObject (in the case of a FacetOperation)</li>
	 *             <li>if there is an error evaluating the Facet's conformance
	 *             typed element</li>
	 *             <li>if the given actual parameters don't match the
	 *             EOperation's formal parameters</li>
	 *             </ul>
	 */
	<T> T invoke(EObject eObject, EOperation operation,
			Class<T> resultType, EditingDomain editingDomain,
			Object... arguments) throws FacetManagerException;

	/**
	 * Invoke the given {@link EOperation} on each element of the given
	 * collection of {@link EObject}s.
	 * 
	 * @param eObjects
	 *            the model elements on which the operation is evaluated
	 * @param operation
	 *            the operation to evaluate
	 * @param arguments
	 *            the values of the parameters of the EOperation that is
	 *            evaluated: they must match both in size, types and
	 *            multiplicity
	 * @return the list of results, one for each model element of the given
	 *         <code>eObjects</code>
	 * @throws FacetManagerException
	 *             <ul>
	 *             <li>in case of an error when delegating to the Ecore
	 *             reflexive API (if the given EOperation is not a
	 *             FacetOperation)</li>
	 *             <li>
	 *             in case of an error in the derived typed element that returns
	 *             the value</li>
	 *             </ul>
	 */
	List<ETypedElementResult> batchInvoke(Collection<EObject> eObjects,
			EOperation operation, Object... arguments)
			throws FacetManagerException;
	
	/**
	 * This method returns the list of loaded facet sets.
	 * 
	 * @return a modifiable list of all FacetSets that
	 *  constitute the working context of the FacetManager
	 */
	List<FacetSet> getManagedFacetSets();

	/** @return the resourceSet used to manage the facet models. */
	ResourceSet getResourceSet();

	<T> T getOrInvoke(EObject element, ETypedElement query, Class<T> aClass)
			throws FacetManagerException;

	<T> List<T> getOrInvokeMultiValued(EObject eObject, ETypedElement feature,
			Class<T> aClass) throws FacetManagerException;
	
	<T> List<ETypedElementResult> batchGetOrInvoke(Collection<EObject> sources,
			ETypedElement query, Class<T> aClass) throws FacetManagerException;
	
	/**
	 * Get virtual references from an EObject. References must be defined in a
	 * FacetSet
	 * 
	 * @param eObject
	 *            Model element
	 * @return All not duplicated virtual references
	 * @throws FacetManagerException
	 * @since 0.4
	 */
	Set<EReference> getReferences(EObject eObject) throws FacetManagerException;

	/**
	 * Get virtual attributes from an EObject. References must be defined in a
	 * FacetSet
	 * 
	 * @param eObject
	 *            Model element
	 * @return All not duplicated virtual attributes
	 * @throws FacetManagerException
	 * @since 0.4
	 */
	Set<EAttribute> getAttributes(EObject eObject) throws FacetManagerException;

	/**
	 * Get virtual references and attributes from an EObject. References must be
	 * defined in a FacetSet
	 * 
	 * @param eObject
	 *            Model element
	 * @return All not duplicated virtual references and attributes
	 * @throws FacetManagerException
	 * @since 0.4
	 */
	Set<EStructuralFeature> getStructuralFeature(EObject eObject)
			throws FacetManagerException;
	
	/**
	 * Adds a listener to this manager that will be notified when this manager's
	 * state changes.
	 * 
	 * @param listener
	 *            The listener to be added
	 * @since 0.4
	 */
	void addListener(IFacetManagerListener listener);

	/**
	 * Removes a listener from this manager.
	 * 
	 * @param listener
	 *            The listener to be removed
	 * @since 0.4
	 */
	void removeListener(IFacetManagerListener listener);

}
