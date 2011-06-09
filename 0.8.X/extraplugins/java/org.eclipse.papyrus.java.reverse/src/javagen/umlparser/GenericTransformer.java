/***************************************************
 * Copyright (c) 2010 Atos Origin.

 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Atos Origin - Initial API and implementation
 *
 ****************************************************/
package javagen.umlparser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.UsageCrossReferencer;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * The Class GenericTransformer. Permits to transform an eobject of eclass to
 * another eclass
 */
public class GenericTransformer {

	/** element to transform */
	private EObject element;

	/**
	 * Instantiates a new generic transformer.
	 * 
	 * @param currentEobject
	 *            the current eobject
	 */
	public GenericTransformer(EObject currentEobject) {
		this.element = currentEobject;
	}

	/**
	 * Transform the element to the given eclass.
	 * 
	 * @param requestedType
	 *            the targeted eclass
	 */
	public EObject transform(EClass requestedType) {

		// Create the result
		EObject result = requestedType.getEPackage().getEFactoryInstance()
				.create(requestedType);

		try {
			// Copy features
			copyAllFeatures(element, result);
			// Change parent
//			EcoreUtil.replace(element, result);
			changeReferences(element, result);

			// Change references on the old objet to references on the new
			// object.

			// drop caches about input element
			ECrossReferenceAdapter cross = ECrossReferenceAdapter
					.getCrossReferenceAdapter(element);
			if (cross != null) {
				cross.unsetTarget(element);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * Copy the feature of the source into the target
	 * 
	 * @param element2
	 * @param result
	 */
	private void copyAllFeatures(EObject source, EObject target) {
		EClass eclass = source.eClass();
		if (eclass != null) {
			EList<EStructuralFeature> eAllStructuralFeatures = eclass
					.getEAllStructuralFeatures();
			for (EStructuralFeature structuralFeature : eAllStructuralFeatures) {
				if (contains(target.eClass(), structuralFeature)) {
					copyFeature(source, target, structuralFeature);
				}
			}
		}

	}

	/**
	 * check if the target eclass contains a estructuralfeature with the same
	 * name less rigorous can work for many cases
	 * 
	 * @param target
	 *            the target
	 * @param e
	 *            the e
	 * 
	 * @return true, if successful
	 */
	private boolean contains(EClass target, EStructuralFeature e) {
		EList<EStructuralFeature> features = target.getEAllStructuralFeatures();
		for (EStructuralFeature f : features) {
			if (f.getName().equals(e.getName())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Copy specified feature from source to target.
	 * 
	 * @param mixedDomain
	 *            the mixed domain
	 * @param source
	 *            the source
	 * @param target
	 *            the target
	 * @param feature
	 *            the e
	 */
	@SuppressWarnings("unchecked")
	private void copyFeature(EObject source, EObject target,
			EStructuralFeature feature) {
		Collection<Object> alreadyManaged = new ArrayList<Object>();

		// Get the target feature
		EStructuralFeature targetFeature = getFeature(target, feature.getName());

		if (feature.getUpperBound() <= targetFeature.getUpperBound()
				&& feature.getLowerBound() >= targetFeature.getLowerBound()) {
			if (feature.isChangeable() && !feature.isDerived()) {
				Object value = source.eGet(feature);

				if (feature.isMany() && targetFeature.isMany()) {
					// Collection to collection
					Collection<EObject> values = (Collection<EObject>) value;
					if (values != null && !values.isEmpty()) {
						Collection<EObject> newList = new ArrayList<EObject>();
						newList.addAll(values);
						if (feature instanceof EReference
								&& !((EReference) feature).isContainment()) {
							// references
							setFeatureValue(target, targetFeature, newList);
							// add(new SetValueCommand(new
							// SetRequest(editingDomain, target, targetFeature,
							// newList)));
						} else if (feature instanceof EReference
								&& ((EReference) feature).isContainment()) {
							// Containement feature
							Collection<Object> toTreat = new ArrayList<Object>();
							for (Object o : newList) {
								if (!alreadyManaged.contains(o)) {
									toTreat.add(o);
									alreadyManaged.add(o);
								}
							}

							setFeatureValue(target, targetFeature, newList);
						}
					}
				} else if (!feature.isMany() && !targetFeature.isMany()) {
					// Copy one to one
					if (value != null) {
						if (!alreadyManaged.contains(value)) {
							alreadyManaged.add(value);
							setFeatureValue(target, targetFeature, value);
						}
					}
				}
			}
		}

	}

	/**
	 * 
	 * Set the value of the specified feature
	 * 
	 * @param elementToEdit
	 * @param feature
	 * @param value
	 */
	protected void setFeatureValue(EObject elementToEdit,
			EStructuralFeature feature, Object value) {

		boolean many = FeatureMapUtil.isMany(elementToEdit, feature);
		if (many) {
			Collection collection = ((Collection) elementToEdit.eGet(feature));
			if (value instanceof List) {
				List values = (List) value;
				collection.clear();
				collection.addAll(values);
			} else {
				collection.add(value);
			}
		} else {
			elementToEdit.eSet(feature, value);
		}
	}

	/**
	 * Gets a feature from a name
	 * 
	 * @param eobject
	 *            the eobject
	 * @param name
	 *            the name
	 * 
	 * @return the feature
	 */
	private EStructuralFeature getFeature(EObject eobject, String name) {
		return eobject.eClass().getEStructuralFeature(name);
	}

	/**
	 * Replace all references on source by references on target Deletes the
	 * object from its {@link EObject#eResource containing} resource and/or its
	 * {@link EObject#eContainer containing} object as well as from any other
	 * feature that references it within the enclosing resource set, resource,
	 * or root object.
	 * 
	 * @param eObject
	 *            the object to delete.
	 * @copyright org.eclipse.emf.ecore.util.EcoreUtil
	 */
	private void changeReferences(EObject source, EObject target) {
		EObject rootEObject = EcoreUtil.getRootContainer(source);
		Resource resource = rootEObject.eResource();

		Collection<EStructuralFeature.Setting> usages;
		if (resource == null) {
			usages = UsageCrossReferencer.find(source, rootEObject);
		} else {
			ResourceSet resourceSet = resource.getResourceSet();
			if (resourceSet == null) {
				usages = UsageCrossReferencer.find(source, resource);
			} else {
				usages = UsageCrossReferencer.find(source, resourceSet);
			}
		}

		for (EStructuralFeature.Setting setting : usages) {
			if (setting.getEStructuralFeature().isChangeable()) {
				EcoreUtil.replace(setting, source, target);
			}
		}

		EcoreUtil.replace(source, target);
	}

}
