/*******************************************************************************
 * Copyright (c) 2009, 2014 Mia-Software, CEA, and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * 	Contributors:
 * 		Nicolas Bros (Mia-Software) - Bug 366367 - To be able to change the "CanBePresentedInTheTable" query
 *      Gregoire Dupe (Mia-Software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 *      Laurent Pichierri (Soft-Maint) - Bug 371204 - Compatibility with Helios
 *      Gregoire Dupe (Mia-Software) - Bug 371367 - Hierarchical FacetSets
 *      Gregoire Dupe (Mia-Software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 *      Gregoire Dupe (Mia-Software) - Bug 387470 - [EFacet][Custom] Editors
 *      Christian W. Damus (CEA) - bug 410346
 *      
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.util.emf.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.papyrus.emf.facet.util.core.Logger;
import org.eclipse.papyrus.emf.facet.util.core.internal.exported.StringUtils;
import org.eclipse.papyrus.emf.facet.util.emf.core.internal.Activator;

/**
 * Utility class for models.
 * @since 0.2
 */
public final class ModelUtils {

	/**
	 * Meta-model qualified name separator
	 */
	private static final String MM_QNAME_SEPARATOR = "::"; //$NON-NLS-1$
	
	/**
	 * Utility classes don't need to (and shouldn't) be instantiated.
	 */
	private ModelUtils() {
		// prevents instantiation
	}

	/**
	 * Computes a list of {@link EObject}s from the same {@link ResourceSet} as
	 * <code>source</code> that can be assigned to the given feature.
	 */
	//Copied from org.eclipse.papyrus.emf.facet.infra.common.core.internal.utils.ModelUtils.computeAssignableElements(EStructuralFeature, EObject)
	public static List<EObject> computeAssignableElements(final EStructuralFeature feature,
			final EObject source) {
		EClassifier eType = feature.getEType();

		// build a list of EObjects assignable to the EReference
		List<EObject> list = new ArrayList<EObject>();
		Resource eResource = source.eResource();
		ResourceSet resourceSet = eResource.getResourceSet();
		TreeIterator<Notifier> allContents = resourceSet.getAllContents();
		while (allContents.hasNext()) {
			Notifier notifier = allContents.next();
			if (notifier instanceof EObject) {
				EObject eObject = (EObject) notifier;
				if (eType.isInstance(eObject)) {
					list.add(eObject);
				}
			}
		}
		return list;
	}
	
	public static boolean isBooleanDataType(final EClassifier classifier) {
		if (classifier instanceof EDataType) {
			EDataType dataType = (EDataType) classifier;
			Class<?> instanceClass = dataType.getInstanceClass();
			return instanceClass == Boolean.class || instanceClass == boolean.class;
		}
		return false;
	}
	
	/**
	 * Find all subclasses of the given metaclass in the package registry
	 * 
	 * @param context
	 *            the metaclass whose subclasses must be found
	 * @return all the subclasses
	 */
	//Copied from org.eclipse.papyrus.emf.facet.infra.common.core.internal.utils.ModelUtils.allSubClasses(final EClass context)
	public static List<EClass> allSubClasses(final EClass context) {
		List<EClass> result = new ArrayList<EClass>();
		// Set<Resource> resources = new HashSet<Resource>();
		Collection<String> uris = new ArrayList<String>(EPackage.Registry.INSTANCE.keySet());
		for (String ePackageURI : uris) {
			try {
				EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(ePackageURI);
				EList<EClassifier> eClassifiers = ePackage.getEClassifiers();
				for (EClassifier eClassifier : eClassifiers) {
					if (eClassifier instanceof EClass) {
						EClass eClass = (EClass) eClassifier;
						if (isSuperTypeOf(context, eClass)) {
							result.add(eClass);
						}
					}
				}
			} catch (Exception e) {
				Logger.logError(e, Activator.getDefault());
			}
		}
		return result;
	}
	
	//Copied from org.eclipse.papyrus.emf.facet.infra.common.core.internal.utils.ModelUtils.isSuperTypeOf(final EClass self, final EClass typeDeclaration)
	public static boolean isSuperTypeOf(final EClass self, final EClass typeDeclaration) {
		return typeDeclaration.getEAllSuperTypes().contains(self);
	}
	
	/** @return the qualified name of the given metaclass */
	//Copied from org.eclipse.papyrus.emf.facet.infra.common.core.internal.utils.ModelUtils.getMetaclassQualifiedName(final EClassifier eClass)
	public static String getMetaclassQualifiedName(final EClassifier eClass) {
		final ArrayList<String> qualifiedNameParts = new ArrayList<String>();
		final StringBuilder builder = new StringBuilder();

		EPackage ePackage = eClass.getEPackage();
		while (ePackage != null) {
			qualifiedNameParts.add(ePackage.getName());
			ePackage = ePackage.getESuperPackage();
		}

		for (int i = qualifiedNameParts.size() - 1; i >= 0; i--) {
			builder.append(qualifiedNameParts.get(i) + "."); //$NON-NLS-1$
		}

		builder.append(eClass.getName());

		return builder.toString();
	}

	/**
	 * Returns a name for the given model element from the EMF global registry,
	 * or use a default name taken from a String attribute.
	 * 
	 * @return a name for the given element
	 */
	//Copied from org.eclipse.papyrus.emf.facet.infra.common.core.internal.utils.ModelUtils.getName(EObject)
	public static String getName(final EObject eObject) {
		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		try {
			IItemLabelProvider itemLabelProvider = (IItemLabelProvider)adapterFactory.adapt(eObject, IItemLabelProvider.class);
			if(itemLabelProvider != null) {
				return itemLabelProvider.getText(eObject);
			}
		} finally {
			// Dispose the adapter factory because it added an adapter that would leak, as it will never be reused
			adapterFactory.dispose();
		}

		return ModelUtils.getDefaultName(eObject);
	}

	/**
	 * @return a default name based on a string feature of the given
	 *         {@link EObject}
	 */
	//Copied from org.eclipse.papyrus.emf.facet.infra.common.core.internal.utils.ModelUtils.getDefaultName(EObject)
	public static String getDefaultName(final EObject eObject) {
		// find a feature that can be used as a name
		final EStructuralFeature feature = ModelUtils.getLabelFeature(eObject.eClass());
		if (feature != null) {
			final Object value = eObject.eGet(feature);
			if (value != null) {
				return StringUtils.truncateBeforeNewline(value.toString());
			}
		}
		return ""; //$NON-NLS-1$
	}
	
	//Copied from ReflectiveItemProvider class
	//Copied from org.eclipse.papyrus.emf.facet.infra.common.core.internal.utils.ModelUtils.getLabelFeature(EClass)
	private static EStructuralFeature getLabelFeature(final EClass eClass) {
		EAttribute result = null;
		for (final EAttribute eAttribute : eClass.getEAllAttributes()) {
			if (!eAttribute.isMany()
					&& eAttribute.getEType().getInstanceClass() != FeatureMap.Entry.class) {
				if ("name".equalsIgnoreCase(eAttribute.getName())) { //$NON-NLS-1$
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
	
	/**
	 * @author Gregoire Dupe (Mia-Software)
	 * @param namedElement
	 * @return
	 */
	public static String getQualifiedName(final ENamedElement namedElement) {
		String parentQName = ""; //$NON-NLS-1$
		if (namedElement.eContainer() instanceof ENamedElement) {
			ENamedElement parent = (ENamedElement) namedElement.eContainer();
			parentQName = getQualifiedName(parent) + ModelUtils.MM_QNAME_SEPARATOR;
		}
		return parentQName + namedElement.getName();
	}

	/**
	 * @since 0.3
	 */
	public static ResourceSet getOrCreateResourceSet(final EObject eObject) {
		ResourceSet resourceSet = null;
		if (eObject.eResource() == null) {
			resourceSet = new ResourceSetImpl();
		} else {
			resourceSet = eObject.eResource().getResourceSet();
		}
		return resourceSet;
	}

	/**
	 * @since 0.3
	 */
	public static IProject getProject(final EObject eObject) {
		IProject result = null;
		final Resource resource = eObject.eResource();
		final URI uri = resource.getURI();
		if (uri.isPlatformResource()) {
			final String projectName = uri.segment(1);
			final IWorkspace workspace = ResourcesPlugin.getWorkspace();
			result = workspace.getRoot()
					.getProject(projectName);
		}
		return result;
	}
}
