/*******************************************************************************
 * Copyright (c) 2011 Mia-Software
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	   Emmanuelle Rouillé (Mia-Software) - Bug 352618 - To be able to use non derived facet structural features and save them values.
 *     Nicolas Bros (Mia-Software) - Bug 361612 - New core for new version of the Facet metamodel
 *     Grégoire Dupé (Mia-Software) - Bug 361612 - [Restructuring] New core for new version of the Facet metamodel
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.efacet.core.internal.serialization;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.emf.facet.efacet.core.internal.exception.SaveStructuralFeatureInstanceModelException;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.AbstractAttributeInstance;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.AbstractReferenceInstance;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.ExtendedEObjectReference;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.MultiValuedAttributeInstance;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.MultiValuedContainmentReferenceInstance;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.MultiValuedReferenceInstance;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.SerializationFactory;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.SingleValuedAttributeInstance;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.SingleValuedContainmentReferenceInstance;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.serialization.SingleValuedReferenceInstance;

public class SerializationManager {

	private final Resource structuralFeatureInstancesResource;

	public SerializationManager(final Resource structuralFeatureInstancesResource) {
		this.structuralFeatureInstancesResource = structuralFeatureInstancesResource;
		if (structuralFeatureInstancesResource != null) {
			final EList<EObject> contents = structuralFeatureInstancesResource.getContents();
			for (EObject eObject : contents) {
				if (eObject instanceof ExtendedEObjectReference) {
					final ExtendedEObjectReference extendedEObjectReference = (ExtendedEObjectReference) eObject;
					final LinkToExtendedEObjectReferenceAdapter adapter = (LinkToExtendedEObjectReferenceAdapter) ILinkToExtendedEObjectReferenceAdapterFactory.INSTANCE
							.adapt(extendedEObjectReference.getExtendedEObject(),
									ILinkToExtendedEObjectReference.class);
					adapter.setExtendedEObjectReference(extendedEObjectReference);
				}
			}
		}
	}

	/**
	 * This method creates a ReferenceInstance in the given {@link ExtendedEObjectReference} with
	 * the reference {@link EStructuralFeature} and the value {@link Object}.
	 */
	private static MultiValuedContainmentReferenceInstance createMultiValuedContainmentReferenceInstance(final EReference reference,
			final List<EObject> values,
			final ExtendedEObjectReference extendedEObjectReference) {
		final MultiValuedContainmentReferenceInstance containmentReferenceInstance = SerializationFactory.eINSTANCE
				.createMultiValuedContainmentReferenceInstance();
		containmentReferenceInstance.setEReference(reference);
		if (values != null) {
			containmentReferenceInstance.getOwnedElements().addAll(values);
		}
		extendedEObjectReference.getReferenceInstances().add(containmentReferenceInstance);
		return containmentReferenceInstance;
	}

	/**
	 * This method returns the {@link ExtendedEObjectReference} associated with the given
	 * {@link EObject} if it exists or <code>null</code> if it does not exist.
	 */
	private static ExtendedEObjectReference getExtendedEObjectReference(final EObject eObject) {
		ExtendedEObjectReference result = null;
		for (final Adapter adapter : eObject.eAdapters()) {
			if (adapter.isAdapterForType(ILinkToExtendedEObjectReference.class)) {
				final LinkToExtendedEObjectReferenceAdapter linkToExtendedEObjectReferenceAdapter = (LinkToExtendedEObjectReferenceAdapter) adapter;
				result = linkToExtendedEObjectReferenceAdapter.getExtendedEObjectReference();
				break;
			}
		}
		return result;
	}

	/**
	 * This method creates an AttributeInstance in the given {@link ExtendedEObjectReference} with
	 * the attribute {@link EStructuralFeature} and the value {@link Object}.
	 */
	private static MultiValuedAttributeInstance createMultiValuedAttributeInstance(final EAttribute attribute, final List<Object> values,
			final ExtendedEObjectReference extendedEObjectReference) {
		final MultiValuedAttributeInstance attributeInstance = SerializationFactory.eINSTANCE.createMultiValuedAttributeInstance();
		attributeInstance.setEAttribute(attribute);
		if (values != null) {
			attributeInstance.getValues().addAll(values);
		}
		extendedEObjectReference.getAttributeInstances().add(attributeInstance);
		return attributeInstance;
	}

	/**
	 * This method creates a ReferenceInstance in the given {@link ExtendedEObjectReference} with
	 * the reference {@link EStructuralFeature} and the value {@link Object}.
	 */
	private static MultiValuedReferenceInstance createMultiValuedReferenceInstance(final EReference reference, final List<EObject> values,
			final ExtendedEObjectReference extendedEObjectReference) {
		final MultiValuedReferenceInstance referenceInstance = SerializationFactory.eINSTANCE
				.createMultiValuedReferenceInstance();
		referenceInstance.setEReference(reference);
		if (values != null) {
			referenceInstance.getReferencedElements().addAll(values);
		}
		extendedEObjectReference.getReferenceInstances().add(referenceInstance);
		return referenceInstance;
	}

	private static SingleValuedAttributeInstance getSingleValuedAttributeInstance(final ExtendedEObjectReference extendedEObjectReference,
			final EAttribute eAttribute) {
		SingleValuedAttributeInstance result = null;
		final EList<AbstractAttributeInstance> attributeInstances = extendedEObjectReference.getAttributeInstances();
		for (final AbstractAttributeInstance attributeInstance : attributeInstances) {
			if (eAttribute.equals(attributeInstance.getEAttribute())) {
				if (attributeInstance instanceof SingleValuedAttributeInstance) {
					result = (SingleValuedAttributeInstance) attributeInstance;
					break;
				}
				throw new IllegalStateException("single valued attribute should be associated to an instance of SingleValuedAttributeInstance"); //$NON-NLS-1$
			}
		}
		return result;
	}

	private static MultiValuedAttributeInstance getMultiValuedAttributeInstance(final ExtendedEObjectReference extendedEObjectReference,
			final EAttribute eAttribute) {
		MultiValuedAttributeInstance result = null;
		final EList<AbstractAttributeInstance> attributeInstances = extendedEObjectReference.getAttributeInstances();
		for (final AbstractAttributeInstance attributeInstance : attributeInstances) {
			if (eAttribute.equals(attributeInstance.getEAttribute())) {
				if (attributeInstance instanceof MultiValuedAttributeInstance) {
					result = (MultiValuedAttributeInstance) attributeInstance;
					break;
				}
				throw new IllegalStateException("multi valued attribute should be associated to an instance of MultiValuedAttributeInstance"); //$NON-NLS-1$

			}
		}
		return result;
	}

	private static SingleValuedReferenceInstance getSingleValuedReferenceInstance(final ExtendedEObjectReference extendedEObjectReference,
			final EReference eReference) {
		SingleValuedReferenceInstance result = null;
		final EList<AbstractReferenceInstance> referenceInstances = extendedEObjectReference.getReferenceInstances();
		for (final AbstractReferenceInstance referenceInstance : referenceInstances) {
			if (eReference.equals(referenceInstance.getEReference())) {
				if (referenceInstance instanceof SingleValuedReferenceInstance) {
					result = (SingleValuedReferenceInstance) referenceInstance;
					break;
				}
				throw new IllegalStateException(
						"a single valued non-containment reference should be associated to an instance of SingleValuedReferenceInstance"); //$NON-NLS-1$
			}
		}
		return result;
	}

	private static SingleValuedContainmentReferenceInstance getSingleValuedContainmentReferenceInstance(
			final ExtendedEObjectReference extendedEObjectReference,
			final EReference eReference) {
		SingleValuedContainmentReferenceInstance result = null;
		final EList<AbstractReferenceInstance> referenceInstances = extendedEObjectReference.getReferenceInstances();
		for (final AbstractReferenceInstance referenceInstance : referenceInstances) {
			if (eReference.equals(referenceInstance.getEReference())) {
				if (referenceInstance instanceof SingleValuedContainmentReferenceInstance) {
					result = (SingleValuedContainmentReferenceInstance) referenceInstance;
					break;
				}
				throw new IllegalStateException(
						"a single valued containment reference should be associated to an instance of SingleValuedContainmentReferenceInstance"); //$NON-NLS-1$
			}
		}
		return result;
	}

	private static MultiValuedReferenceInstance getMultiValuedReferenceInstance(final ExtendedEObjectReference extendedEObjectReference,
			final EReference eReference) {
		MultiValuedReferenceInstance result = null;
		final EList<AbstractReferenceInstance> referenceInstances = extendedEObjectReference.getReferenceInstances();
		for (final AbstractReferenceInstance referenceInstance : referenceInstances) {
			if (eReference.equals(referenceInstance.getEReference())) {
				if (referenceInstance instanceof MultiValuedReferenceInstance) {
					result = (MultiValuedReferenceInstance) referenceInstance;
					break;
				}
				throw new IllegalStateException(
						"a multi valued non-containment reference should be associated to an instance of MultiValuedReferenceInstance"); //$NON-NLS-1$
			}
		}
		return result;
	}

	private static MultiValuedContainmentReferenceInstance getMultiValuedContainmentReferenceInstance(final ExtendedEObjectReference extendedEObjectReference,
			final EReference eReference) {
		MultiValuedContainmentReferenceInstance result = null;
		final EList<AbstractReferenceInstance> referenceInstances = extendedEObjectReference.getReferenceInstances();
		for (final AbstractReferenceInstance referenceInstance : referenceInstances) {
			if (eReference.equals(referenceInstance.getEReference())) {
				if (referenceInstance instanceof MultiValuedContainmentReferenceInstance) {
					result = (MultiValuedContainmentReferenceInstance) referenceInstance;
					break;
				}
				throw new IllegalStateException(
						"a multi valued containment reference should be associated to an instance of MultiValuedContainmentReferenceInstance"); //$NON-NLS-1$
			}
		}
		return result;
	}

	public void saveStructuralFeatureInstanceModel()
			throws SaveStructuralFeatureInstanceModelException {
		if (this.structuralFeatureInstancesResource == null) {
			throw new SaveStructuralFeatureInstanceModelException("This facet manager has been initailized with a null structural feature instances resource"); //$NON-NLS-1$
		}
		try {
			this.structuralFeatureInstancesResource.save(Collections.EMPTY_MAP);
		} catch (final IOException e) {
			throw new SaveStructuralFeatureInstanceModelException(e);
		}
	}

	/**
	 * This method returns the ExtendedEObjectReference associated with the given {@link EObject} if
	 * it exists or creates it if it does not exist.
	 */
	private ExtendedEObjectReference getOrCreateExtendedEObjectReference(final EObject eObject) {
		ExtendedEObjectReference extendedEObjectReference = SerializationManager.getExtendedEObjectReference(eObject);
		if (extendedEObjectReference == null) {
			extendedEObjectReference = SerializationFactory.eINSTANCE.createExtendedEObjectReference();
			extendedEObjectReference.setExtendedEObject(eObject);
			if (this.structuralFeatureInstancesResource != null) {
				this.structuralFeatureInstancesResource.getContents().add(extendedEObjectReference);
			}
			final LinkToExtendedEObjectReferenceAdapter adapter = (LinkToExtendedEObjectReferenceAdapter) ILinkToExtendedEObjectReferenceAdapterFactory.INSTANCE
					.adapt(eObject, ILinkToExtendedEObjectReference.class);
			adapter.setExtendedEObjectReference(extendedEObjectReference);
		}
		return extendedEObjectReference;
	}

	public void setAttribute(final EObject eObject, final EAttribute attribute, final Object newValue) {
		final ExtendedEObjectReference extendedEObjectReference = this.getOrCreateExtendedEObjectReference(eObject);
		if (attribute.isMany()) {
			if (newValue instanceof List) {
				// safe to cast
				@SuppressWarnings("unchecked")
				final List<Object> list = (List<Object>) newValue;
				final MultiValuedAttributeInstance attributeInstance =
						SerializationManager.getMultiValuedAttributeInstance(extendedEObjectReference, attribute);
				if (attributeInstance == null) {
					SerializationManager.createMultiValuedAttributeInstance(attribute, list, extendedEObjectReference);
				} else {
					attributeInstance.getValues().clear();
					attributeInstance.getValues().addAll(list);
				}
			} else {
				throw new IllegalArgumentException("The given FacetAttribute is multiplicity-many, so the value must be a List"); //$NON-NLS-1$
			}
		} else {
			final SingleValuedAttributeInstance attributeInstance =
					SerializationManager.getSingleValuedAttributeInstance(extendedEObjectReference, attribute);
			if (attributeInstance == null) {
				createSingleValuedAttributeInstance(attribute, newValue, extendedEObjectReference);
			} else {
				attributeInstance.setValue(newValue);
			}
		}

	}


	/**
	 * This method creates an AttributeInstance in the given {@link ExtendedEObjectReference} with
	 * the attribute {@link EStructuralFeature} and the value {@link Object}.
	 */
	private static SingleValuedAttributeInstance createSingleValuedAttributeInstance(final EAttribute attribute, final Object value,
			final ExtendedEObjectReference extendedEObjectReference) {
		final SingleValuedAttributeInstance attributeInstance = SerializationFactory.eINSTANCE.createSingleValuedAttributeInstance();
		attributeInstance.setEAttribute(attribute);
		attributeInstance.setValue(value);
		extendedEObjectReference.getAttributeInstances().add(attributeInstance);
		return attributeInstance;
	}

	/**
	 * This method creates a ReferenceInstance in the given {@link ExtendedEObjectReference} with
	 * the reference {@link EStructuralFeature} and the value {@link Object}.
	 */
	private static SingleValuedReferenceInstance createSingleValuedReferenceInstance(final EReference reference, final EObject value,
			final ExtendedEObjectReference extendedEObjectReference) {
		final SingleValuedReferenceInstance referenceInstance = SerializationFactory.eINSTANCE
				.createSingleValuedReferenceInstance();
		referenceInstance.setEReference(reference);
		referenceInstance.setReferencedElement(value);
		extendedEObjectReference.getReferenceInstances().add(referenceInstance);
		return referenceInstance;
	}

	public void setReference(final EObject eObject, final EReference reference, final Object newValue) {
		final ExtendedEObjectReference extendedEObjectReference = this.getOrCreateExtendedEObjectReference(eObject);
		if (reference.isMany()) {
			throw new UnsupportedOperationException(
					"The given FacetReference is multi-valued : add elements to the list returned by getMultiValuedReference() instead"); //$NON-NLS-1$
		}
		if (!(newValue instanceof EObject)) {
			throw new IllegalArgumentException("newValue should be an EObject because eStructuralFeature is an EReference"); //$NON-NLS-1$	
		}
		final EObject newEObjectValue = (EObject) newValue;
		if (reference.isContainment()) {
			final SingleValuedContainmentReferenceInstance referenceInstance =
					SerializationManager.getSingleValuedContainmentReferenceInstance(extendedEObjectReference, reference);
			if (referenceInstance == null) {
				createSingleValuedContainmentReferenceInstance(reference, newEObjectValue, extendedEObjectReference);
			} else {
				referenceInstance.setOwnedElement(newEObjectValue);
			}
		} else {
			final SingleValuedReferenceInstance referenceInstance =
					SerializationManager.getSingleValuedReferenceInstance(extendedEObjectReference, reference);
			if (referenceInstance == null) {
				createSingleValuedReferenceInstance(reference, newEObjectValue, extendedEObjectReference);
			} else {
				referenceInstance.setReferencedElement(newEObjectValue);
			}
		}

	}
	
	/**
	 * This method creates a ReferenceInstance in the given {@link ExtendedEObjectReference} with
	 * the reference {@link EStructuralFeature} and the value {@link Object}.
	 */
	private static SingleValuedContainmentReferenceInstance createSingleValuedContainmentReferenceInstance(final EReference reference,
			final EObject value,
			final ExtendedEObjectReference extendedEObjectReference) {
		final SingleValuedContainmentReferenceInstance containmentReferenceInstance = SerializationFactory.eINSTANCE
				.createSingleValuedContainmentReferenceInstance();
		containmentReferenceInstance.setEReference(reference);
		containmentReferenceInstance.setOwnedElement(value);
		extendedEObjectReference.getReferenceInstances().add(containmentReferenceInstance);
		return containmentReferenceInstance;
	}

	private Object getMultiValuedStructuralFeature(final EObject eObject, final EStructuralFeature structuralFeature) {
		Object result = null;
		final ExtendedEObjectReference extendedEObjectReference = this.getOrCreateExtendedEObjectReference(eObject);
		if (structuralFeature instanceof EAttribute) {
			final EAttribute eAttribute = (EAttribute) structuralFeature;
			final MultiValuedAttributeInstance attributeInstance =
					SerializationManager.getMultiValuedAttributeInstance(extendedEObjectReference, eAttribute);
			if (attributeInstance != null) {
				result = attributeInstance.getValues();
			}
		} else if (structuralFeature instanceof EReference) {
			final EReference eReference = (EReference) structuralFeature;
			if (eReference.isContainment()) {
				MultiValuedContainmentReferenceInstance referenceInstance =
						SerializationManager.getMultiValuedContainmentReferenceInstance(extendedEObjectReference, eReference);
				if (referenceInstance == null) {
					referenceInstance = SerializationManager.createMultiValuedContainmentReferenceInstance(eReference, null, extendedEObjectReference);
					result = referenceInstance.getOwnedElements();					
				} else {
					result =  referenceInstance.getOwnedElements();
				}
			} else {
				MultiValuedReferenceInstance referenceInstance =
						SerializationManager.getMultiValuedReferenceInstance(extendedEObjectReference, eReference);
				if (referenceInstance == null) {
					referenceInstance = SerializationManager.createMultiValuedReferenceInstance(eReference, null, extendedEObjectReference);
					result =  referenceInstance.getReferencedElements();
				} else {
					result = referenceInstance.getReferencedElements();
				}
			}
		} else {
			throw new UnsupportedOperationException("Getting a structural feature of type '" + structuralFeature.getClass().getName() + "' is not implemented"); //$NON-NLS-1$ //$NON-NLS-2$
		}
		return result;
	}
	
	private static Object getSingleValuedStructuralFeature(final EObject eObject, final EStructuralFeature structuralFeature) {
		Object result = null;
		final ExtendedEObjectReference extendedEObjectReference = SerializationManager.getExtendedEObjectReference(eObject);
		if (extendedEObjectReference != null) {
			if (structuralFeature instanceof EAttribute) {
				final EAttribute eAttribute = (EAttribute) structuralFeature;
				final SingleValuedAttributeInstance attributeInstance = SerializationManager.getSingleValuedAttributeInstance(extendedEObjectReference, eAttribute);
				if (attributeInstance != null) {
					result = attributeInstance.getValue();
				}
			} else if (structuralFeature instanceof EReference) {
				final EReference eReference = (EReference) structuralFeature;
				if (eReference.isContainment()) {
					final SingleValuedContainmentReferenceInstance referenceInstance =
							SerializationManager.getSingleValuedContainmentReferenceInstance(extendedEObjectReference, eReference);
					result = referenceInstance.getOwnedElement();
				} else {
					final SingleValuedReferenceInstance referenceInstance =
							SerializationManager.getSingleValuedReferenceInstance(extendedEObjectReference, eReference);
					result = referenceInstance.getReferencedElement();
				}
			} else {
				throw new IllegalArgumentException("Unexpected structuralFeature kind"); //$NON-NLS-1$
			}
		}
		return result;
	}
	
	public Object getNotDerivedValue(final EObject eObject, final EStructuralFeature structuralFeature) {
		Object result;
		if (structuralFeature.isMany()) {
			result = this.getMultiValuedStructuralFeature(eObject, structuralFeature);
		} else {
			result = SerializationManager.getSingleValuedStructuralFeature(eObject, structuralFeature);
		}
		return result;
	}
}
