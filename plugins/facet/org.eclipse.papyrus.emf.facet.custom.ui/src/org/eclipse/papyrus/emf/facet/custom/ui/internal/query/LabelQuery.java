/**
 *  Copyright (c) 2011 Mia-Software.
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *  	Gregoire Dupe (Mia-Software) - Bug 361794 - [Restructuring] EMF Facet customization meta-model
 *      Gregoire Dupe (Mia-Software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 *      Gregoire Dupe (Mia-Software) - Bug 373078 - API Cleaning
 *      Gregoire Dupe (Mia-Software) - Bug 375087 - [Table] ITableWidget.addColumn(List<ETypedElement>, List<FacetSet>)
 *      Nicolas Bros (Mia-Software) - Bug 379683 - customizable Tree content provider
 */
package org.eclipse.papyrus.emf.facet.custom.ui.internal.query;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.ReflectiveItemProvider;
import org.eclipse.papyrus.emf.facet.efacet.core.IFacetManager;
import org.eclipse.papyrus.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.papyrus.emf.facet.query.java.core.IJavaQuery2;
import org.eclipse.papyrus.emf.facet.query.java.core.IParameterValueList2;
import org.eclipse.papyrus.emf.facet.util.emf.core.ModelUtils;

public class LabelQuery implements IJavaQuery2<EObject, String> {

	private static final String NAME = "name"; //$NON-NLS-1$

	public String evaluate(final EObject source,
			final IParameterValueList2 parameterValues,
			final IFacetManager facetManager)
			throws DerivedTypedElementException {
		ETypedElement sfParam = null;
		if (parameterValues != null) {
			sfParam = (ETypedElement) parameterValues
					.getParameterValueByName("eStructuralFeature").getValue(); //$NON-NLS-1$
		}
		String result = null;
		if (sfParam == null) {
			final ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(
					ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
			final IItemLabelProvider itemLabelProvider = (IItemLabelProvider) adapterFactory
					.adapt(source, IItemLabelProvider.class);
			// We don't want to use a ReflectiveItemProvider because it provides
			// a string prefixed with the eObject's meta-class name.
			if (itemLabelProvider instanceof ReflectiveItemProvider) {
				result = LabelQuery.getDefaultName(source);
			} else if (itemLabelProvider == null) {
				result = ModelUtils.getDefaultName(source);
			} else {
				result = itemLabelProvider.getText(source);
			}
		} else {
			try {
				if (sfParam instanceof EAttribute && sfParam.getUpperBound() == 1) {
					final Object object = facetManager.getOrInvoke(source, sfParam, Object.class);
					final String objectLabel = getObjectLabel(object, facetManager);
					result = sfParam.getName() + " = " + objectLabel; //$NON-NLS-1$
				} else {
					result = sfParam.getName();
				}
			} catch (final Exception e) {
				throw new DerivedTypedElementException(e);
			}
		}
		return result;
	}

	private String getObjectLabel(final Object object,
			final IFacetManager facetManager)
			throws DerivedTypedElementException {
		String result;
		if (object instanceof EObject) {
			final EObject eObject = (EObject) object;
			result = evaluate(eObject, null, facetManager);
		} else {
			result = String.valueOf(object);
		}
		return result;
	}

	/**
	 * @return a default name based on a string feature of the given
	 *         {@link EObject}
	 */
	// from org.eclipse.papyrus.emf.facet.infra.common.core.internal.utils.ModelUtils
	public static String getDefaultName(final EObject eObject) {
		String result = ""; //$NON-NLS-1$
		// find a feature that can be used as a name
		final EStructuralFeature feature = LabelQuery.getLabelFeature(eObject
				.eClass());
		if (feature != null) {
			result = (String) eObject.eGet(feature);
		}
		return result;
	}

	/**
	 * This method searches for a structural feature that can be used as a name
	 *
	 * @param eClass
	 *            in which class to search a structural feature that can be used as
	 *            a name
	 * @return an EStructuralFeature
	 */
	// Copied from org.eclipse.emf.edit.provider.ReflectiveItemProvider to org.eclipse.papyrus.emf.facet.infra.common.core.internal.utils.ModelUtils
	// Copied from org.eclipse.papyrus.emf.facet.infra.common.core.internal.utils.ModelUtils
	private static EStructuralFeature getLabelFeature(final EClass eClass) {
		EAttribute result = null;
		for (final EAttribute eAttribute : eClass.getEAllAttributes()) {
			if (!eAttribute.isMany()
					&& eAttribute.getEType().getInstanceClass() != FeatureMap.Entry.class) {
				if (LabelQuery.NAME.equalsIgnoreCase(eAttribute
						.getName())) {
					result = eAttribute;
					break;
				} else if (result == null) {
					result = eAttribute;
				} else if (eAttribute.getEAttributeType().getInstanceClass() == String.class
						&& result.getEAttributeType().getInstanceClass() != String.class) {
					result = eAttribute;
				}
			}
		}
		return result;
	}

}
