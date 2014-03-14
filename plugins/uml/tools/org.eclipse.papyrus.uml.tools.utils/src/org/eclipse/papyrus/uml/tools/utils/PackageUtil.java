/*****************************************************************************
 * Copyright (c) 2008, 2014 CEA LIST and others.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi SCHNEKENBURGER (CEA LIST) Remi.schnekenburger@cea.fr - Initial API and implementation
 *  Yann TANGUY (CEA LIST) yann.tanguy@cea.fr
 *  Christian W. Damus (CEA) - bug 402525
 *  
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.utils;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForHandlers;
import org.eclipse.uml2.uml.Collaboration;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.ProfileApplication;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Utility class for <code>org.eclipse.uml2.uml.Package</code><BR>
 */
public class PackageUtil {

	/**
	 * Apply a profile and every subprofiles to a package. Also import types defined in profile
	 * 
	 * @param profileToApply
	 *        profile to apply on package
	 * @param package_
	 *        on which profiles are applied
	 * @param withSubProfiles
	 *        true if subprofiles must be automatically imported
	 */
	public static boolean applyProfile(org.eclipse.uml2.uml.Package package_, org.eclipse.uml2.uml.Profile profileToApply, boolean withSubProfiles) {

		// Returns�true if the model was modified
		boolean isChanged = false;

		// if profile is not defined abort treatment
		if(!profileToApply.isDefined()) {
			return isChanged;
		}

		// if same version of profile is applied do not re-apply it
		ProfileApplication profileApplication = package_.getProfileApplication(profileToApply);
		if(profileApplication != null) {

			EPackage previous_definition = profileApplication.getAppliedDefinition();
			EPackage new_definition = profileToApply.getDefinition();
			if(previous_definition == new_definition) {
				return isChanged;
			}
		}

		// Apply main profile and import contained types
		package_.applyProfile(profileToApply);
		importTypes(package_, profileToApply);
		isChanged = true;

		if(withSubProfiles) {
			// Manage sub profiles
			List<Profile> subProfiles = new ArrayList<Profile>();
			subProfiles = getSubProfiles(profileToApply);

			Iterator<Profile> iter = subProfiles.iterator();
			while(iter.hasNext()) {
				Profile subProfile = iter.next();
				package_.applyProfile(subProfile);
				importTypes(package_, subProfile);
			}
		}

		return isChanged;
	}

	/**
	 * Retrieve recursively the subprofiles of package.
	 * 
	 * @param profile
	 * 
	 * @return an arrayList containing the subprofiles
	 */
	public static List<Profile> getSubProfiles(org.eclipse.uml2.uml.Package package_) {
		List<Profile> subProfiles = new ArrayList<Profile>();

		Iterator<Package> iter = package_.getNestedPackages().iterator();
		while(iter.hasNext()) {

			Object element = iter.next();
			if(element instanceof Profile) {
				Profile currentSubProfile = (Profile)element;
				subProfiles.add(currentSubProfile);
				subProfiles.addAll(getSubProfiles(currentSubProfile));
			} else if(element instanceof org.eclipse.uml2.uml.Package) {
				org.eclipse.uml2.uml.Package currentSubPackage = (org.eclipse.uml2.uml.Package)element;
				subProfiles.addAll(getSubProfiles(currentSubPackage));
			}
		}
		return subProfiles;
	}

	/**
	 * Returns the top package of the specified element, i.e. the model or profile that is the root element
	 * 
	 * @return the top {@link Package} for the specified element
	 */
	public static Package getRootPackage(Element element) {
		Package nearest = element.getNearestPackage();
		return (nearest == null) ? null : getRootPackage(nearest);
	}

	/**
	 * Returns the top package of the specified package, i.e. the model or profile that is the root element
	 * 
	 * @return the top {@link Package} for the specified element
	 */
	public static Package getRootPackage(Package package_) {
		Element owner = package_.getOwner();

		//Bug 370412: The package might not be contained in a Package 
		//(e.g. it can be contained in a Component). Search for the nearest
		//package, excluding self (Package#getNearestPackage() returns self)
		while(owner != null && !(owner instanceof Package)) {
			owner = owner.getOwner();
		}

		if(owner == null) {
			return package_;
		}

		return getRootPackage((Package)owner);
	}

	/**
	 * Import public type contained in the profileToApply into pkg.
	 * 
	 * @param profileToApply
	 *        profile that contains type to import
	 * @param pkg
	 *        receive the types from profile
	 */
	private static void importTypes(Package pkg, Package profileToApply) {

		/** import public types of the profile */

		// get visible members of the profile
		EList<PackageableElement> visibleMemb = profileToApply.visibleMembers();
		Iterator<PackageableElement> iterator = visibleMemb.iterator();

		while(iterator.hasNext()) {
			Element elemt = iterator.next();

			if(elemt instanceof Package) {

				// if the package is a model library the import it
				// in the package on which the profile is applied
				if(((Package)elemt).isModelLibrary()) {
					PackageImport pi = UMLFactory.eINSTANCE.createPackageImport();
					pi.setImportedPackage((Package)elemt);
					pkg.getPackageImports().add(pi);
				}
			}
		}
	}

	/**
	 * returns the list of the names of imported packages
	 * 
	 * @param pkg
	 *        the package that has element imports
	 * @return the list of the name of imported packages
	 */
	public static List<String> getImportedPackagesNames(Package pkg) {
		List<String> packageNames = new ArrayList<String>();
		// iterate through package imports of the given package
		Iterator<PackageImport> importedIt = pkg.getPackageImports().iterator();
		while(importedIt.hasNext()) {
			PackageImport currentImport = importedIt.next();
			// get name of the imported package and adds it to the result list
			String currentName = currentImport.getImportedPackage().getName();
			packageNames.add(currentName);
		}
		return packageNames;
	}

	/**
	 * Removes the last definition of a profile, and in its nested profiles
	 * 
	 * @param thepackage
	 *        profile to clean
	 */
	// @unused
	public static void removeLastDefinition(Package thepackage) {
		removeLastDefinition(thepackage, true);
	}

	/**
	 * Removes the last definition of a profile
	 * 
	 * @param thepackage
	 *        profile to clean
	 * @param recursive
	 *        boolean <code>true</code> if the clean is recursive, i.e. nested profiles must be
	 *        clean
	 */
	public static void removeLastDefinition(Package thepackage, boolean recursive) {
		// he wants to define
		if(thepackage instanceof Profile) {
			EPackage pak = ((Profile)thepackage).getDefinition();
			((EAnnotation)pak.eContainer()).getContents().remove(pak);
		}
		if(recursive) {
			Iterator<Package> it = thepackage.getNestedPackages().iterator();
			while(it.hasNext()) {
				Package p = it.next();
				removeLastDefinition(p, recursive);
			}
		}
	}

	/**
	 * Define this package if it is a profile and its sub-profiles
	 * 
	 * @param thePackage
	 *        the package to define (if it is a profile)
	 */
	public static void defineProfiles(Package thePackage) {
		// he wants to define
		if(thePackage instanceof Profile) {
			((Profile)thePackage).define();
		}
		Iterator<Package> it = thePackage.getNestedPackages().iterator();
		while(it.hasNext()) {
			Package p = it.next();
			defineProfiles(p);
		}
	}

	/**
	 * Retrieve a type accessible in this Package, given its name.
	 * 
	 * @param name
	 *        the name of the type to find, which must not be <code>null</code>
	 * 
	 * @return the type found or <code>null</code> if not found.
	 */
	public static Type findTypeByName(Package pack, String name) {
		assert name != null : "Type Name should not be null";

		// update method to find a type by its name
		// 1. find the direct accessible types (in the package and the imported
		// elements)
		// 2. find in the subpackages and their import
		// 3. find in all resources

		Iterator<Type> it = getAccessibleTypes(pack).iterator();
		while(it.hasNext()) {
			Type t = it.next();
			if(name.equals(t.getName())) {
				return t;
			}
		}

		Resource resource = pack.eResource();
		ResourceSet resourceSet = null;
		if(resource != null) {
			resourceSet = resource.getResourceSet();
		}

		if(resourceSet != null) {
			return findTypeByName(resourceSet, name);
		}
		return null;
	}

	/**
	 * Retrieve a collaboration accessible in this Package, given its name.
	 * 
	 * @param name
	 *        the name of the collaboration to find, which must not be <code>null</code>
	 * 
	 * @return the collaboration found or <code>null</code> if not found.
	 */
	public static Collaboration findCollaborationByName(Package pack, String name) {
		assert name != null : "Collaboration Name should not be null";

		// update method to find a type by its name
		// 1. find the direct accessible types (in the package and the imported
		// elements)
		// 2. find in the subpackages and their import
		// 3. find in all resources

		Iterator<Collaboration> it = getAccessibleCollaborations(pack).iterator();
		while(it.hasNext()) {
			Collaboration t = it.next();
			if(name.equals(t.getName())) {
				return t;
			}
		}

		Resource resource = pack.eResource();
		ResourceSet resourceSet = null;
		if(resource != null) {
			resourceSet = resource.getResourceSet();
		}

		if(resourceSet != null) {
			return findCollaborationByName(resourceSet, name);
		}
		return null;
	}

	/**
	 * Returns a type given its name from a resource set.
	 * 
	 * @param resourceSet
	 *        the resource Set
	 * @param name
	 *        the name of the type to find. It must not be <code>null</code>
	 * @return the found type or <code>null</code> if the type was not found
	 */
	private static Type findTypeByName(ResourceSet resourceSet, String name) {
		TreeIterator<Notifier> iterator = resourceSet.getAllContents();

		while(iterator.hasNext()) {
			Notifier notifier = iterator.next();
			if(notifier instanceof Type) {
				Type type = ((Type)notifier);
				if(name.equals(type.getName())) {
					return type;
				}
			}
		}
		return null;
	}

	/**
	 * Returns a collaboration given its name from a resource set.
	 * 
	 * @param resourceSet
	 *        the resource Set
	 * @param name
	 *        the name of the collaboration to find. It must not be <code>null</code>
	 * @return the found type or <code>null</code> if the collaboration was not found
	 */
	private static Collaboration findCollaborationByName(ResourceSet resourceSet, String name) {
		TreeIterator<Notifier> iterator = resourceSet.getAllContents();

		while(iterator.hasNext()) {
			Notifier notifier = iterator.next();
			if(notifier instanceof Collaboration) {
				Collaboration type = ((Collaboration)notifier);
				if(name.equals(type.getName())) {
					return type;
				}
			}
		}
		return null;
	}

	/**
	 * Returns all accessible types in the model
	 * 
	 * @param element
	 *        the element from which all resources can be accessed
	 * @return the list of Types accessible in the model
	 */
	public static Set<Type> getAllTypes(Element element) {
		SortedSet<Type> set = new TreeSet<Type>(new TypeNameComparator());

		Resource resource = element.eResource();
		ResourceSet resourceSet = null;
		if(resource != null) {
			resourceSet = resource.getResourceSet();
		}

		if(resourceSet != null) {
			TreeIterator<Notifier> iterator = resourceSet.getAllContents();

			while(iterator.hasNext()) {
				Notifier notifier = iterator.next();
				if(notifier instanceof Type && ((Type)notifier).getName() != null) {
					set.add(((Type)notifier));
				}
			}
		}
		return set;
	}

	/**
	 * Return all top-level packages within a resource set.
	 * @param element an element
	 * @return the list of top-level packages
	 */
	public static List<Package> getTopLevelPackages(Element element) {
		List<Package> topLevelPackages = new BasicEList<Package>();
		if (element.eResource() != null) {
			for (Resource resource : element.eResource().getResourceSet().getResources()) {
				if ((resource.getContents().size() > 0) && (resource.getContents().get(0) instanceof Package)) {
					topLevelPackages.add((Package) resource.getContents().get(0)); 
				}
			}
		}
		return topLevelPackages;
	}
	
	/**
	 * Returns all accessible Collaboration in the model
	 * 
	 * @param element
	 *        the element from which all resources can be accessed
	 * @return the list of Collaboration accessible in the model
	 */
	public static Set<Collaboration> getAllCollaborations(Element element) {
		SortedSet<Collaboration> set = new TreeSet<Collaboration>(new TypeNameComparator());

		Resource resource = element.eResource();
		ResourceSet resourceSet = null;
		if(resource != null) {
			resourceSet = resource.getResourceSet();
		}

		if(resourceSet != null) {
			TreeIterator<Notifier> iterator = resourceSet.getAllContents();

			while(iterator.hasNext()) {
				Notifier notifier = iterator.next();
				if(notifier instanceof Collaboration && ((Collaboration)notifier).getName() != null) {
					set.add(((Collaboration)notifier));
				}
			}
		}
		return set;
	}

	/**
	 * Get all possible types for an element owned by this package.
	 * 
	 * @return a set of all available Types
	 */
	public static TreeSet<Type> getAccessibleTypes(Package pack) {
		TreeSet<Type> set = new TreeSet<Type>(new TypeNameComparator());
		// umlTypeList is used to detect type listed twice in the proposed list
		// this may occurs for example with indirect import of UMLPrimitiveTypes
		// Set<String> umlTypeQNames = new HashSet<String>();

		Iterator<NamedElement> it = pack.getMembers().iterator();
		// get direct members
		while(it.hasNext()) {
			NamedElement element = it.next();
			if((element instanceof Type) /*
										 * && (!(element instanceof Relationship))
										 */) {
				// Check for redundant type
				// if (!umlTypeQNames.contains(element.getQualifiedName())) {
				// /umlTypeQNames.add(element.getQualifiedName());
				// set.add((Type) element);
				// }
				set.add((Type)element);
			}
		}

		// Recursive call on parents
		if((pack.getOwner() != null) && (pack.getOwner() instanceof Package)) {

			Iterator<Type> itParent = PackageUtil.getAccessibleTypes(pack.getNestingPackage()).iterator();

			while(itParent.hasNext()) {
				set.add(itParent.next());
				// Type currentType = itParent.next();

				// if (!umlTypeQNames.contains(currentType.getQualifiedName()))
				// {
				// umlTypeQNames.add(currentType.getQualifiedName());
				// set.add(currentType);
				// }
			}
		}

		return set;
	}

	/**
	 * Get all possible Collaboration owned by this package.
	 * 
	 * @return a set of all available Collaborations
	 */
	public static TreeSet<Collaboration> getAccessibleCollaborations(Package pack) {
		TreeSet<Collaboration> set = new TreeSet<Collaboration>(new TypeNameComparator());

		Iterator<NamedElement> it = pack.getMembers().iterator();
		// Get direct members
		while(it.hasNext()) {
			NamedElement element = it.next();
			if(element instanceof Collaboration) {

				set.add((Collaboration)element);
			}
		}

		// Recursive call on parents
		if((pack.getOwner() != null) && (pack.getOwner() instanceof Package)) {

			Iterator<Collaboration> itParent = PackageUtil.getAccessibleCollaborations(pack.getNestingPackage()).iterator();

			while(itParent.hasNext()) {
				set.add(itParent.next());
			}
		}

		return set;
	}

	/**
	 * 
	 * 
	 * @return returns all nested elements of a package (classes, packages, interfaces, data types,
	 *         properties, operations) Returned elements are of type org.eclipse.uml2.uml.Element
	 */
	public static Set<Element> getAllNestedElements(Package thePackage) {
		Set<org.eclipse.uml2.uml.Element> nestedElements = new HashSet<Element>();
		Iterator<org.eclipse.uml2.uml.NamedElement> i = thePackage.getOwnedMembers().iterator();
		org.eclipse.uml2.uml.Element currentElement;
		while(i.hasNext()) {
			currentElement = i.next();
			nestedElements.add(currentElement);
			// Package
			if(currentElement instanceof org.eclipse.uml2.uml.Package) {
				nestedElements.addAll((PackageUtil.getAllNestedElements((Package)currentElement)));
			}
			// Class
			else if(currentElement instanceof org.eclipse.uml2.uml.Class) {
				nestedElements.addAll(((org.eclipse.uml2.uml.Class)currentElement).getMembers());
			}
		}
		return nestedElements;
	}

	/**
	 * Load Package from a specified URI
	 * 
	 * @param uri
	 *        URI of the file to load
	 * @param set
	 *        ResourceSet
	 * @return the root Package
	 */
	public static org.eclipse.uml2.uml.Package loadPackage(URI uri, ResourceSet set) {

		org.eclipse.uml2.uml.Package package_ = null;
		Resource resource = set.getResource(uri, true);

		if(resource != null) {
			package_ = (org.eclipse.uml2.uml.Package)EcoreUtil.getObjectByType(resource.getContents(), UMLPackage.Literals.PACKAGE);
		} else {
			Activator.logException(new FileNotFoundException("Could not retrieve resource from URI : " + uri + "."));
		}

		return package_;

	}

	/**
	 * Comparator using type names
	 */
	static class TypeNameComparator implements Comparator<Type> {

		/**
		 * {@inheritDoc}
		 */
		public int compare(Type o1, Type o2) {
			final String o1Name = ((o1.getName() != null) ? o1.getName() : ""); //$NON-NLS-1$
			final String o2Name = ((o2.getName() != null) ? o2.getName() : ""); //$NON-NLS-1$
			return o1Name.compareTo(o2Name);
		}
	}
	
	/**
	 * Return the top element of the model that is currently edited. This function is based on the
	 * assumption that the user model is the first resource that is loaded into the model set.
	 * Use this function instead of Utils.getTop (or getModel) if you want to avoid navigating to the
	 * root of an imported model.
	 * 
	 * @return the top level package of the model currently loaded into an editor.
	 */
	public static Package getUserModel(ExecutionEvent event) {
		ServiceUtilsForHandlers serviceUtils = ServiceUtilsForHandlers.getInstance();
		try {
			// IPath fn = serviceUtils.getModelSet().getFilenameWithoutExtension();
			EList<Resource> resources = serviceUtils.getModelSet(event).getResources();
			if(resources.size() >= 3) {
				// check first three resources (di, notation, uml)
				for(int i = 0; i < 3; i++) {
					Resource userResource = resources.get(i);
					if(userResource.getContents().size() > 0) {
						EObject topEObj = userResource.getContents().get(0);
						if((topEObj instanceof Package) && (!(topEObj instanceof Profile))) {
							return (Package)topEObj;
						}
					}
				}
			}
		} catch (ServiceException e) {
		}
		return null;
	}
}
