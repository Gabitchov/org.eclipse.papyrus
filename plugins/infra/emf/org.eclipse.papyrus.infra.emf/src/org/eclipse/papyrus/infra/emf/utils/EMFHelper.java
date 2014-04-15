/*****************************************************************************
 * Copyright (c) 2010, 2014 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - filter out EObjects that are Resources (CDO)
 *  Christian W. Damus (CEA) - Support read-only state at object level (CDO)
 *  Christian W. Damus (CEA) - bug 323802
 *  Christian W. Damus (CEA) - bug 429826
 *  Christian W. Damus (CEA) - bug 408491
 *  
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.emf.facet.custom.ui.CustomizedContentProviderUtils;
import org.eclipse.papyrus.infra.core.resource.IReadOnlyHandler;
import org.eclipse.papyrus.infra.core.resource.IReadOnlyHandler2;
import org.eclipse.papyrus.infra.core.resource.ReadOnlyAxis;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.utils.ServiceUtilsForActionHandlers;
import org.eclipse.papyrus.infra.emf.Activator;
import org.eclipse.papyrus.infra.tools.util.PlatformHelper;

import com.google.common.collect.ImmutableList;

/**
 * A Helper class for manipulating EMF Objects
 * 
 * @author Camille Letavernier
 */
//TODO : Check implementations. Most of them are old and don't always match the specification
public class EMFHelper {

	/**
	 * Returns the EClass corresponding to the given nsUri and className
	 * 
	 * @param nsUri
	 *        The NSURI of the EClass' EPackage
	 * @param className
	 *        The EClass' name
	 * @return
	 *         The EClass instance, or null if the EClass couldn't be found
	 */
	public static EClass getEClass(final String nsUri, final String className) {
		EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(nsUri);
		if(ePackage == null) {
			Activator.log.warn("Cannot find an EPackage matching the nsURI " + nsUri); //$NON-NLS-1$
			return null;
		}
		return getEClass(ePackage, className);
	}

	/**
	 * Return the EClass corresponding to the given EPackage and className
	 * 
	 * @param metamodel
	 *        The EClass' EPackage
	 * @param className
	 *        The EClass' name
	 * @return
	 *         The EClass instance, or null if the EClass couldn't be found
	 */
	public static EClass getEClass(final EPackage metamodel, final String className) {
		EClassifier classifier = metamodel.getEClassifier(className);
		if(classifier == null) {
			Activator.log.warn("Classifier " + className + " not found in metamodel " + metamodel.getName() + " (" + metamodel.getNsURI() + ")"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
		}
		if(classifier instanceof EClass) {
			return (EClass)classifier;
		} else {
			Activator.log.warn("Classifier " + className + " in " + metamodel.getName() + " (" + metamodel.getNsURI() + ") is not an EClass"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
		}

		return null;
	}

	/**
	 * Tests if an Object is an instance of the given EClass
	 * 
	 * @param element
	 *        The EObject to test
	 * @param className
	 *        The name of the EClass
	 * @param metamodel
	 *        The EPackage owning the EClass
	 * @return
	 *         True if the EObject is an instance of the EClass, or of one of the EClass' subtypes
	 */
	public static boolean isInstance(final EObject element, final String className, final EPackage metamodel) {

		EClassifier theClass = metamodel.getEClassifier(className);

		if(theClass == null) {
			String message = String.format("Class %s not found in  metamodel: %s (%s)", className, metamodel.getName(), metamodel.getNsURI());//$NON-NLS-1$
			Activator.log.warn(message);
			return false;
		}

		return theClass.isInstance(element);
	}


	/**
	 * Tests if an Object is an instance of the given EClass
	 *
	 * @param element
	 *        The EObject to test
	 * @param className
	 *        The name of the EClass
	 * @param metamodel
	 *        The URI of the EPackage owning the EClass
	 * @return
	 *         True if the EObject is an instance of the EClass, or of one of the EClass' subtypes
	 */
	public static boolean isInstance(EObject selectedItem, String className, String nsUri) {
		EClass actualEClass = selectedItem.eClass();

		//Exact match
		if(isExactMatch(actualEClass, className, nsUri)) {
			return true;
		}

		List<EClass> allSuperTypes = actualEClass.getEAllSuperTypes();
		for(EClass eClass : allSuperTypes) {
			if(isExactMatch(eClass, className, nsUri)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Tests whether the given EClass has the given className and belongs to the EPackage represented by nsUri
	 *
	 * @param eClass
	 *        The EClass to test
	 * @param className
	 *
	 * @param nsUri
	 * @return
	 *         True if the EClass' name is className and the EClass' EPackage's nsURI is nsUri
	 */
	private static boolean isExactMatch(EClass eClass, String className, String nsUri) {
		return className.equals(eClass.getName()) && nsUri.equals(eClass.getEPackage().getNsURI());
	}

	/**
	 * Tests if the given eClass is a Subclass of fromClass
	 * Also returns true when eClass == fromClass
	 * 
	 * @param eClass
	 * @param fromClass
	 * @return
	 *         true if eClass is a subclass of fromClass
	 */
	public static boolean isSubclass(final EClass eClass, final EClass fromClass) {
		//Everything is an EObject
		if(eClass != null && fromClass == EcorePackage.eINSTANCE.getEObject()) {
			return true;
		}

		if(eClass == fromClass) {
			return true;
		}

		List<EClass> superTypes = eClass.getEAllSuperTypes();
		if(superTypes.contains(fromClass)) {
			return true;
		}

		return false;
	}

	/**
	 * Returns the EObject corresponding to the input object
	 * Tests if the input is an EObject, or if it is Adaptable
	 * to an EObject
	 * 
	 * @param source
	 * @return An EObject corresponding to the input source, or null
	 *         if the EObject could not be resolved
	 */
	public static EObject getEObject(final Object source) {

		//Support for EMF 0.2 CustomizedTree: The TreeElements are EObjects, and do not implement IAdatapble.
		//FIXME: Use an AdapterFactory instead, to remove the dependency to EMF Facet 0.2
		Object resolved = CustomizedContentProviderUtils.resolve(source);
		if(resolved != source && isEMFModelElement(resolved)) {
			return (EObject)resolved;
		}

		//General case
		if(isEMFModelElement(source)) {
			return (EObject)source;
		} else if(source instanceof IAdaptable) {
			EObject eObject = (EObject)((IAdaptable)source).getAdapter(EObject.class);
			if(eObject == null) { //EMF Facet 0.1
				eObject = (EObject)((IAdaptable)source).getAdapter(EReference.class);
			}
			return asEMFModelElement(eObject); // in case the adapter is a CDOResource
		}

		return null;
	}

	/**
	 * Queries whether an {@code object} is an EMF model element, an instance of
	 * some {@link EClass} from an EMF model. This isn't as simple as checking
	 * whether the object is an {@link EObject} because there are edge cases
	 * where objects are {@code EObject}s but shouldn't be treated as
	 * "model content". But, a minimum requirement is that the {@code object} is
	 * an {@link EObject}.
	 * 
	 * @param object
	 *        an object
	 * @return whether it is "model content"
	 * 
	 * @see EMFHelper#asEMFModelElement(Object)
	 */
	public static boolean isEMFModelElement(Object object) {
		return (object instanceof EObject) && !(object instanceof Resource);
	}

	/**
	 * Casts an {@code object} as an EMF model element, if appropriate.
	 * 
	 * @param object
	 *        an object
	 * @return the object as an EMF model element, or {@code null} if it is not
	 *         an EMF model element
	 * 
	 * @see #isEMFModelElement(Object)
	 */
	public static EObject asEMFModelElement(Object object) {
		return isEMFModelElement(object) ? (EObject)object : null;
	}

	/**
	 * Retrieve the EditingDomain for the given source object. The object is first
	 * resolved to an EObject through #getEObject when possible.
	 * 
	 * @param source
	 * @return
	 *         The source object's editing domain, or null if it couldn't be found
	 */
	public static EditingDomain resolveEditingDomain(final Object source) {
		return resolveEditingDomain(getEObject(source));
	}

	/**
	 * Retrieve the EditingDomain for the given source EObject
	 * 
	 * @param source
	 * @return
	 *         The source eObject's editing domain, or null if it couldn't be found
	 */
	public static EditingDomain resolveEditingDomain(final EObject source) {
		EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(source);
		if(domain == null) {
			try {
				domain = ServiceUtilsForActionHandlers.getInstance().getTransactionalEditingDomain();
			} catch (ServiceException e) {
				//Ignore: We cannot find the domain
			}
		}
		return domain;
	}

	/**
	 * Return the eClassifier' qualified name. The qualified name is obtained by the concatenation
	 * of its package hierarchy with the class name, separated by the given separator
	 * 
	 * @param eClassifier
	 * @param separator
	 *        The separator used between each package name
	 * @return
	 *         The EClassifier' qualified name
	 */
	public static String getQualifiedName(final EClassifier eClassifier, final String separator) {
		return getQualifiedName(eClassifier.getEPackage(), separator) + separator + eClassifier.getName();
	}

	/**
	 * Return the ePackage's qualified name. The qualified name is obtained by the concatenation
	 * of its superPackage hierarchy with the ePackage name, separated by the given separator
	 * 
	 * @param ePackage
	 * @param separator
	 *        The separator used between each package name
	 * @return
	 *         The EPackage's qualified name
	 */
	public static String getQualifiedName(final EPackage ePackage, final String separator) {
		if(ePackage.getESuperPackage() == null) {
			return ePackage.getName();
		}
		return getQualifiedName(ePackage.getESuperPackage(), separator) + separator + ePackage.getName();
	}


	/**
	 * Loads and returns the first EObject at the given URI.
	 * The EObject is loaded in the given resourceSet.
	 * 
	 * @param resourceSet
	 *        The ResourceSet in which the model will be loaded
	 * @param uri
	 *        The URI describing the location of the model to load
	 * @return
	 *         The first EObject located at the given URI
	 * @throws IOException
	 *         When the URI cannot be loaded
	 */
	public static EObject loadEMFModel(ResourceSet resourceSet, final URI uri) throws IOException {
		if(resourceSet == null) {
			resourceSet = new ResourceSetImpl();
		}
		try {
			Resource resource = resourceSet.getResource(uri, true);
			if(resource != null) {
				if(!resource.getContents().isEmpty()) {
					return resource.getContents().get(0);
				}
			}
		} catch (Exception ex) {
			IOException exception = new IOException(ex.toString());
			exception.initCause(ex);
			throw exception;
		}

		return null;
	}

	/**
	 * Completely unloads a resource set so that it and all the models it contained may be reclaimed by the
	 * Java garbage collector. This includes, at least:
	 * <ul>
	 * <li>unloading all resources in the set, which converts all model elements to proxies and removes all adapters from them</li>
	 * <li>removing all resources from the set</li>
	 * <li>removing all adapters from all resources</li>
	 * <li>removing all adapters from the resource set</li>
	 * </ul>
	 * 
	 * @param resourceSet
	 *        the resource set to purge
	 */
	public static void unload(ResourceSet resourceSet) {
		List<Resource> resources = ImmutableList.copyOf(resourceSet.getResources());
		resourceSet.getResources().clear();
		for(Resource next : resources) {
			next.unload();
			next.eAdapters().clear();
		}
		resourceSet.eAdapters().clear();
	}

	/**
	 * Return the root package containing the given package, or the package
	 * itself if it is already the root
	 * 
	 * @param ePackage
	 * @return
	 *         The Root package
	 */
	public static EPackage getRootPackage(final EPackage ePackage) {
		if(ePackage == null) {
			return null;
		}

		if(ePackage.getESuperPackage() == null) {
			return ePackage;
		}
		return getRootPackage(ePackage.getESuperPackage());
	}


	/**
	 * Return the list of EClasses that are subtypes
	 * of the given EClass
	 * 
	 * @param type
	 * @param concreteClassesOnly
	 *        If true, only Concrete EClasses will be returned. Abstract and Interface EClasses will be filtered
	 * @return
	 *         The list of EClasses implementing or extending the given EClass
	 */
	public static List<EClass> getSubclassesOf(final EClass type, final boolean concreteClassesOnly) {
		Set<EClass> result = new LinkedHashSet<EClass>();
		if(!concreteClassesOnly || (!type.isAbstract() && !type.isInterface())) {
			result.add(type);
		}

		EPackage ePackage = getRootPackage(type.getEPackage());
		getSubclassesOf(type, ePackage, result, concreteClassesOnly);
		return new LinkedList<EClass>(result);
	}

	/**
	 * Return the list of EClasses that are sub types
	 * of the given EClass
	 * 
	 * @param type
	 * @param concreteClassesOnly
	 *        If true, only Concrete EClasses will be returned. Abstract and Interface EClasses will be filtered
	 * @param packagesToBrowse
	 *        The EPackages in which the EClasses should be retrieved
	 * @return
	 *         The list of EClasses implementing or extending the given EClass
	 */
	public static List<EClass> getSubclassesOf(final EClass type, final boolean concreteClassesOnly, Collection<EPackage> packagesToBrowse) {
		Set<EClass> result = new LinkedHashSet<EClass>();
		if(!concreteClassesOnly || (!type.isAbstract() && !type.isInterface())) {
			result.add(type);
		}

		for(EPackage ePackage : packagesToBrowse) {
			getSubclassesOf(type, ePackage, result, concreteClassesOnly);
		}

		return new LinkedList<EClass>(result);
	}

	/**
	 * Return the list of EClasses that are sub types of the given EClass
	 * 
	 * @param type
	 * @param concreteClassesOnly
	 *        If true, only Concrete EClasses will be returned. Abstract and Interface EClasses will be filtered
	 * @param browseAllRegisteredPackages
	 *        If true, all registered EPackages will be navigated to retrieve the matching EClasses. Otherwise,
	 *        only the current EPackage will be used.
	 * @return
	 *         The list of EClasses implementing or extending the given EClass
	 */
	public static List<EClass> getSubclassesOf(final EClass type, final boolean concreteClassesOnly, final boolean browseAllRegisteredPackages) {
		//If the current package is a dynamic package, it may not be registered (?). Add it directly
		EPackage currentPackage = getRootPackage(type.getEPackage());

		Set<EPackage> allPackages = new LinkedHashSet<EPackage>();
		allPackages.add(currentPackage);

		if(browseAllRegisteredPackages) {
			//FIXME // WARNING: This loop will load all EPackages. The first call is expensive.
			Set<String> allUris = new HashSet<String>(EPackage.Registry.INSTANCE.keySet());

			for(String nsURI : allUris) {
				allPackages.add(EPackage.Registry.INSTANCE.getEPackage(nsURI));
			}
		}

		return getSubclassesOf(type, concreteClassesOnly, allPackages);
	}

	private static void getSubclassesOf(final EClass type, final EPackage fromPackage, final Set<EClass> result, final boolean concreteClassesOnly) {
		for(EClassifier classifier : fromPackage.getEClassifiers()) {
			if(classifier instanceof EClass) {
				EClass eClass = (EClass)classifier;
				if(eClass.getEAllSuperTypes().contains(type)) {
					if(!concreteClassesOnly || (!eClass.isAbstract() && !eClass.isInterface())) {
						result.add(eClass);
					}
				}
			}
		}

		for(EPackage subPackage : fromPackage.getESubpackages()) {
			getSubclassesOf(type, subPackage, result, concreteClassesOnly);
		}
	}

	/**
	 * Tests if an EObject is read only on any {@linkplain ReadOnlyAxis axis}.
	 * Delegates to the EObject's editing domain if it can be found
	 * 
	 * @param eObject
	 * @return
	 *         True if the EObject is read only on any axis
	 * @see #isReadOnly(Set, EObject, EditingDomain)
	 */
	public static boolean isReadOnly(final EObject eObject) {
		return isReadOnly(ReadOnlyAxis.anyAxis(), eObject);
	}

	/**
	 * Tests if an EObject is read only on any of the specified {@code axes}.
	 * Delegates to the EObject's editing domain if it can be found
	 * 
	 * @param axes
	 *        a set if orthogonal axes of read-only-ness to consider. May be empty, but that would not be especially useful
	 * @param eObject
	 * @return
	 *         True if the EObject is read only on any of the given {@code axes}
	 */
	public static boolean isReadOnly(Set<ReadOnlyAxis> axes, final EObject eObject) {
		EditingDomain domain = resolveEditingDomain(eObject);
		return isReadOnly(axes, eObject, domain);
	}

	/**
	 * Tests if an EObject is read only on any {@linkplain ReadOnlyAxis axis}.
	 * Delegates to the given editing domain if it isn't null
	 * 
	 * @param eObject
	 * @param domain
	 * @return
	 *         True if the EObject is read only on any axis
	 */
	public static boolean isReadOnly(final EObject eObject, final EditingDomain domain) {
		return isReadOnly(ReadOnlyAxis.anyAxis(), eObject, domain);
	}

	/**
	 * Tests if an EObject is read only on any of the specified {@code axes}.
	 * Delegates to the given editing domain if it isn't null
	 * 
	 * @param axes
	 *        a set if orthogonal axes of read-only-ness to consider. May be empty, but that would not be especially useful
	 * @param eObject
	 * 
	 * @param domain
	 * @return
	 *         True if the EObject is read only
	 */
	public static boolean isReadOnly(Set<ReadOnlyAxis> axes, final EObject eObject, final EditingDomain domain) {
		if(domain != null) {
			Object handler = PlatformHelper.getAdapter(domain, IReadOnlyHandler.class);
			if(handler instanceof IReadOnlyHandler2) {
				return ((IReadOnlyHandler2)handler).isReadOnly(axes, eObject).get();
			}else if(handler instanceof IReadOnlyHandler) {
				// these handlers only deal with permission-based read-only-ness
				return axes.contains(ReadOnlyAxis.PERMISSION) && ((IReadOnlyHandler)handler).isReadOnly(eObject).get();
			}

			if(eObject.eResource() != null) {
				return domain.isReadOnly(eObject.eResource());
			}
		}
		return false;
	}

	/**
	 * Tests if the Resource is read only on any {@linkplain ReadOnlyAxis axis}.
	 * Delegates to the given editing domain if it isn't null
	 * 
	 * @param resource
	 * @param domain
	 * @return
	 *         True if the Resource is read only on any axis
	 */
	public static boolean isReadOnly(final Resource resource, final EditingDomain domain) {
		return isReadOnly(ReadOnlyAxis.anyAxis(), resource, domain);
	}

	/**
	 * Tests if the Resource is read only on any of the given {@code axes}.
	 * Delegates to the given editing domain if it isn't null
	 * 
	 * @param axes
	 *        a set if orthogonal axes of read-only-ness to consider. May be empty, but that would not be especially useful
	 * @param resource
	 * @param domain
	 * @return
	 *         True if the Resource is read only on any of the given {@code axes}
	 */
	public static boolean isReadOnly(Set<ReadOnlyAxis> axes, final Resource resource, final EditingDomain domain) {
		if(resource == null) {
			return false;
		}

		if(domain != null && resource.getURI() != null) {
			Object handler = PlatformHelper.getAdapter(domain, IReadOnlyHandler.class);
			if(handler instanceof IReadOnlyHandler2) {
				return ((IReadOnlyHandler2)handler).anyReadOnly(axes, new URI[]{ resource.getURI() }).get();
			} else if(handler instanceof IReadOnlyHandler) {
				// these handlers only deal with permission-based read-only-ness
				return axes.contains(ReadOnlyAxis.PERMISSION) && ((IReadOnlyHandler)handler).anyReadOnly(new URI[]{ resource.getURI() }).get();
			}
			return domain.isReadOnly(resource);
		}

		// no editing domain : use file system attribute
		ResourceSet resourceSet = resource.getResourceSet();

		if(resourceSet == null) {
			return false;
		}

		Map<String, ?> attributes = resourceSet.getURIConverter().getAttributes(resource.getURI(), null);
		Boolean readOnly = (Boolean)attributes.get(URIConverter.ATTRIBUTE_READ_ONLY);

		return readOnly == null ? false : readOnly;
	}

	/**
	 * Tests if an object that is read only could possibly be made writable by some means (file system attributes, team provider hook, database
	 * permissions, etc.)
	 * 
	 * @param eObject
	 *        an object that is assumed to be read-only
	 * @param domain
	 *        the editing domain context of the {@link eObject}
	 * @return
	 *         whether the {@code eObject} could be made writable
	 */
	public static boolean canMakeWritable(final EObject eObject, final EditingDomain domain) {
		return canMakeWritable(ReadOnlyAxis.anyAxis(), eObject, domain);
	}

	/**
	 * Tests if an object that is read only could possibly be made writable according to any of
	 * the specified {@code axes} of read-only-ness.
	 * 
	 * @param axes
	 *        a set if orthogonal axes of read-only-ness to consider. May be empty, but that would not be especially useful
	 * @param eObject
	 *        an object that is assumed to be read-only
	 * @param domain
	 *        the editing domain context of the {@link eObject}
	 * @return
	 *         whether the {@code eObject} could be made writable
	 */
	public static boolean canMakeWritable(Set<ReadOnlyAxis> axes, final EObject eObject, final EditingDomain domain) {
		if(domain != null) {
			Object handler = PlatformHelper.getAdapter(domain, IReadOnlyHandler.class);
			if(handler instanceof IReadOnlyHandler2) {
				return ((IReadOnlyHandler2)handler).canMakeWritable(axes, eObject).or(false);
			}
		}
		return false;
	}

	/**
	 * Tests if a resource that is read only could possibly be made writable by some means (file system attributes, team provider hook, database
	 * permissions, etc.)
	 * 
	 * @param resource
	 *        a resource that is assumed to be read-only
	 * @param domain
	 *        the editing domain context of the {@link resource}
	 * @return
	 *         whether the {@code resource} could be made writable
	 */
	public static boolean canMakeWritable(final Resource resource, final EditingDomain domain) {
		return canMakeWritable(ReadOnlyAxis.anyAxis(), resource, domain);
	}

	/**
	 * Tests if a resource that is read only could possibly be made writable according to any of
	 * the specified {@code axes} of read-only-ness.
	 * 
	 * @param axes
	 *        a set if orthogonal axes of read-only-ness to consider. May be empty, but that would not be especially useful
	 * @param resource
	 *        a resource that is assumed to be read-only
	 * @param domain
	 *        the editing domain context of the {@link resource}
	 * @return
	 *         whether the {@code resource} could be made writable
	 */
	public static boolean canMakeWritable(Set<ReadOnlyAxis> axes, final Resource resource, final EditingDomain domain) {
		if(domain != null) {
			Object handler = PlatformHelper.getAdapter(domain, IReadOnlyHandler.class);
			if(handler instanceof IReadOnlyHandler2) {
				return ((IReadOnlyHandler2)handler).canMakeWritable(axes, new URI[] { resource.getURI() }).or(false);
			}
		}
		return false;
	}

	/**
	 * Tests if the given EStructuralFeature is required (ie. should always
	 * have a value)
	 * 
	 * A feature is required if at least of one the following conditions if
	 * true :
	 * 
	 * - It has a defaultValue
	 * - Its lowerBound is at least 1
	 * - It is an enumeration (Enumerations always have a default value)
	 * - It is a Java primitive type, and is not marked as Unsettable
	 * 
	 * @param feature
	 *        the feature to test
	 * @return
	 *         true if the feature is required, false otherwise
	 */
	public static boolean isRequired(final EStructuralFeature feature) {
		//EEnums are always required, as an EEnum always has a default value
		if(feature.getEType() instanceof EEnum) {
			return true;
		}

		//At least one value means it is required
		if(feature.getLowerBound() >= 1) {
			return true;
		}

		//Java primitive types cannot have a null value
		//if the feature is not specifically marked as unsettable, then it is required
		if(feature.getEType().getInstanceClass().isPrimitive() && !feature.isUnsettable()) {
			return true;
		}

		//If there is a default value, there is always a value
		if(feature.getDefaultValueLiteral() != null) {
			return true;
		}

		return false; //The property if not required
	}

	/**
	 * Returns all objects of type T contained in the resource
	 * 
	 * @param resource
	 * @param type
	 * @return
	 */
	public static <T> Set<T> allInstances(final Resource resource, Class<T> type) {
		TreeIterator<EObject> iterator = resource.getAllContents();
		Set<T> result = new LinkedHashSet<T>();

		while(iterator.hasNext()) {
			EObject element = iterator.next();
			if(type.isInstance(element)) {
				result.add(type.cast(element));
			}
		}

		return result;
	}

	/**
	 * Returns all the EPackages and nested EPackages contained in this resource
	 * 
	 * @param resource
	 * @return
	 */
	public static Set<EPackage> getAllEPackages(final Resource resource) {
		Set<EPackage> result = new LinkedHashSet<EPackage>();

		for(EObject rootElement : resource.getContents()) {
			if(rootElement instanceof EPackage) {
				result.add((EPackage)rootElement);
				result.addAll(getAllNestedPackages((EPackage)rootElement));
			}
		}

		return result;
	}

	/**
	 * Returns all packages nested in the given EPackage (recursively). Does not
	 * include the base EPackage.
	 * 
	 * @param basePackage
	 * @return
	 */
	public static Set<EPackage> getAllNestedPackages(EPackage basePackage) {
		Set<EPackage> result = new LinkedHashSet<EPackage>();

		for(EPackage nestedPackage : basePackage.getESubpackages()) {
			result.add(nestedPackage);
			result.addAll(getAllNestedPackages(nestedPackage));
		}

		return result;
	}

	/**
	 * 
	 * @param resource
	 *        a resource
	 * 
	 * @return
	 *         the list of the metamodels known by the resource
	 */
	public static Set<EPackage> getMetamodels(final Resource resource) {
		Set<EPackage> metamodels = new HashSet<EPackage>();
		if(resource != null) {
			final List<EObject> contents = new ArrayList<EObject>(resource.getContents());
			for(final EObject current : contents) {
				metamodels.add(current.eClass().getEPackage());
			}
		}
		return metamodels;
	}

	/**
	 * 
	 * Returns the XMI ID of the given {@link EObject} or <code>null</code> if it cannot be resolved.
	 * 
	 * @param object
	 *        Object which we seek the XMI ID of.
	 * @return <code>object</code>'s XMI ID, <code>null</code> if not applicable.
	 */
	public static final String getXMIID(final EObject object) {
		String objectID = null;
		if(object != null && object.eResource() instanceof XMIResource) {
			objectID = ((XMIResource)object.eResource()).getID(object);
		}
		return objectID;
	}



	/**
	 * Gets the usages.
	 * 
	 * @param source
	 *        the source
	 * 
	 * @return the usages or null if there is no usages
	 */
	public static Collection<Setting> getUsages(EObject source) {
		// the functional code is defined in core because we need it in infra.core
		// but infra.core can't depend on infra.emf (circular dependency)
		return org.eclipse.papyrus.infra.core.utils.EMFHelper.getUsages(source);
	}


	/**
	 * <pre>
	 * Test if the used element is referenced by other elements than the known
	 * referencer (except its container). It ignores references from an other meta-model.
	 * </pre>
	 * 
	 * @param usedObject
	 *        the used object
	 * @param knownReferencer
	 *        the known referencer
	 * @return true if the known referencer is the only referencer.
	 */
	public static boolean isOnlyUsage(EObject usedObject, EObject knownReferencer) {
		boolean isUsed = false;
		EPackage mmPackage = usedObject.eClass().getEPackage();

		// Retrieve the list of elements referencing the usedObject.
		Set<EObject> crossReferences = new HashSet<EObject>();
		for(Setting setting : getUsages(usedObject)) {
			EObject eObj = setting.getEObject();
			if(eObj.eClass().getEPackage().equals(mmPackage)) {
				crossReferences.add(eObj);
			}
		}

		// Remove the container of used object.
		crossReferences.remove(usedObject.eContainer());
		// Remove the knownReferencer from the list of references.
		crossReferences.remove(knownReferencer);

		// If no referencer remains in the list, the known element is the only
		// usage.
		if(crossReferences.isEmpty()) {
			isUsed = true;
		}

		return isUsed;
	}

	/**
	 * 
	 * @param superType
	 *        an eclassifier
	 * @param subType
	 *        another eClassifier
	 * @return
	 *         <code>true</code> if the 2nd {@link EClassifier} is a subtype of the first one
	 */
	public static boolean isSuperType(final EClassifier superType, final EClassifier subType) {
		if(superType == subType) {
			return true;
		}

		if(superType instanceof EClass && subType instanceof EClass) {
			// special case because isSuperTypeOf doesn't handle it
			if(superType == EcorePackage.eINSTANCE.getEObject()) {
				return true;
			}

			EClass superTypeEClass = (EClass)superType;
			EClass subTypeEClass = (EClass)subType;
			return superTypeEClass.isSuperTypeOf(subTypeEClass);
		}

		//manage EDtataType
		if(superType == EcorePackage.eINSTANCE.getEDataType() && subType instanceof EDataType) {
			return true;
		}

		return false;
	}

	/**
	 * Computes the path from the root EObject to the given element, as a List of EObjects
	 * 
	 * @param element
	 * @return
	 */
	public static List<EObject> getContainmentPath(EObject element) {
		List<EObject> result;
		if(element.eContainer() == null) {
			result = new LinkedList<EObject>();
			result.add(element);
			return result;
		} else {
			result = getContainmentPath(element.eContainer());
			result.add(element);
		}
		return result;
	}

	/**
	 * Returns the given element, reloaded into the resource set of the context element,
	 * or the source element itself if not possible.
	 *
	 * Use this method for e.g. loading an element from a shared resource set into another resource set
	 * (Apply a registered profile/library, drop an element from the project explorer, ...)
	 *
	 * @param element
	 * @param contextElement
	 * @return
	 */
	public static <T extends EObject> T reloadIntoContext(T element, EObject contextElement) {
		ResourceSet sourceResourceSet = getResourceSet(element);
		ResourceSet loadingContext = getResourceSet(contextElement);

		if(sourceResourceSet == loadingContext || loadingContext == null) {
			return element;
		}

		URI sourceURI = EcoreUtil.getURI(element);
		EObject result = loadingContext.getEObject(sourceURI, true);

		return (T)result;
	}

	/**
	 * Returns the resourceSet owning this eObject, or null if it is detached
	 *
	 * @param eObject
	 */
	public static ResourceSet getResourceSet(EObject eObject) {
		if(eObject == null || eObject.eResource() == null) {
			return null;
		}

		return eObject.eResource().getResourceSet();
	}
}
