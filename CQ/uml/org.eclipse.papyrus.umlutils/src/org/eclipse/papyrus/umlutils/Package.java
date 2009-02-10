/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi SCHNEKENBURGER (CEA LIST) Remi.schnekenburger@cea.fr - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.umlutils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.VisibilityKind;

// TODO: Auto-generated Javadoc
/**
 * 
 * 
 * 
 * This class encapsulates a package and encapsulates an <code>org.eclipse.uml2.uml.Package object</code>.
 */
public class Package extends NamedElement {

	/**
	 * 
	 */
	private org.eclipse.uml2.uml.Package uml2Package;

	/**
	 * 
	 * 
	 * @param source
	 */
	public Package(org.eclipse.uml2.uml.Package source) {
		super(source);
		uml2Package = source;
	}

	/**
	 * 
	 * 
	 * @return Returns the uml2Package.
	 */
	public org.eclipse.uml2.uml.Package getUml2Package() {
		return uml2Package;
	}

	/**
	 * 
	 * 
	 * @return returns the classes, interfaces and packages contained by this package.
	 */
	public Set<org.eclipse.papyrus.umlutils.Element> getOwnedStructureElements() {
		Set<org.eclipse.papyrus.umlutils.Element> ownedElements = new HashSet<org.eclipse.papyrus.umlutils.Element>();
		// Add all supported Elements
		Iterator i = uml2Package.getOwnedElements().iterator();
		org.eclipse.uml2.uml.Element currentElement;
		while (i.hasNext()) {
			currentElement = (org.eclipse.uml2.uml.Element) i.next();
			// Package
			if (currentElement instanceof org.eclipse.uml2.uml.Package) {
				ownedElements.add(new Package((org.eclipse.uml2.uml.Package) currentElement));
			}
			// class
			if (currentElement instanceof org.eclipse.uml2.uml.Class) {
				ownedElements.add(new Class((org.eclipse.uml2.uml.Class) currentElement));
			}
			// interface
			if (currentElement instanceof org.eclipse.uml2.uml.Interface) {
				ownedElements.add(new Interface((org.eclipse.uml2.uml.Interface) currentElement));
			}
			// datatype
			if (currentElement instanceof org.eclipse.uml2.uml.DataType) {
				ownedElements.add(new org.eclipse.papyrus.umlutils.DataType((org.eclipse.uml2.uml.DataType) currentElement));
			}
		}
		return ownedElements;
	}

	/**
	 * 
	 * 
	 * @return returns all nested elements of a package (classes, packages, interfaces, data types, properties, operations) Returned elements are of type org.eclipse.uml2.uml.Element
	 */
	public Set<Element> getAllNestedElements() {
		Set<org.eclipse.uml2.uml.Element> nestedElements = new HashSet<Element>();
		Iterator<org.eclipse.uml2.uml.NamedElement> i = uml2Package.getOwnedMembers().iterator();
		org.eclipse.uml2.uml.Element currentElement;
		while (i.hasNext()) {
			currentElement = i.next();
			nestedElements.add(currentElement);
			// Package
			if (currentElement instanceof org.eclipse.uml2.uml.Package) {
				nestedElements.addAll((new Package((org.eclipse.uml2.uml.Package) currentElement)).getAllNestedElements());
			}
			// Class
			else if (currentElement instanceof org.eclipse.uml2.uml.Class) {
				nestedElements.addAll(((org.eclipse.uml2.uml.Class) currentElement).getMembers());
			}
		}
		return nestedElements;
	}

	/**
	 * Get the full name of the package. The full name of the package is the name of the packaged prefixed by the name of the package containing thi one.
	 * 
	 * @return the Full name of the package
	 */
	@Override
	public String getFullName() {
		String name = getName();
		Package parentPackage = getPackage();
		if (parentPackage != null) {
			if (parentPackage.namespace()) {
				name = parentPackage.getFullName() + "_" + name;
			}
		}
		return name;
	}

	/**
	 * Get the full name of the package. The full name of the package is the name of the packaged prefixed by the
	 * 
	 * @param name
	 *            of the package containing thi one.
	 * 
	 * @return the Full name of the package
	 */
	public String getFullPath() {
		String name = getName();
		Package parentPackage = getPackage();
		if (parentPackage != null) {
			if (parentPackage.namespace()) {
				name = parentPackage.getFullPath() + "/" + name;
			}
		}
		return name;
	}

	/**
	 * Gives the package that own this package.
	 * 
	 * @return The owner package or null.
	 */
	public Package getPackage() {
		Package parent = null;
		org.eclipse.uml2.uml.Package u2parent = uml2Package.getNestingPackage();
		if (u2parent != null) {
			if (!(u2parent instanceof org.eclipse.uml2.uml.Model)) {
				parent = new Package(u2parent);
			}
		}
		return parent;
	}

	/**
	 * Tells if this package uses glib or not.
	 * 
	 * @return
	 */
	public boolean usesGlib() {
		return !hasStereotype("noGlib");
	}

	/**
	 * Tells if this package is a namespace or not (i.e. if the members of this package have to be prefixed by the package name or not).
	 * 
	 * @return
	 */
	public boolean namespace() {
		return !hasStereotype("cNoNamespace") && !hasStereotype("cRoot");
	}

	/**
	 * Tells if the C code generator will generate a header file for this package.
	 * 
	 * @return
	 */
	public boolean hasHeader() {
		return !hasStereotype("cRoot") && !hasStereotype("nocode");
	}

	/**
	 * Gives the path of the Package (from the root of the project). This is the directory where the owned elements of the package can be found.
	 * 
	 * @return A string representing the full path to the package directory, from the root of the project.
	 */
	public String getPath() {
		String path = "";
		if (!hasStereotype("cRoot")) {

			path = getName() + "/";

			if (getPackage() != null) {
				path = getPackage().getPath() + path;
			}
		}

		return path;
	}

	/**
	 * Gives the path of the Package (from the root of the project). This is the directory where the owned elements of the package can be found.
	 * 
	 * @return A string representing the full path to the package directory, from the root of the project.
	 */
	public String getRelativePathFromRoot() {
		String path = "";
		if (!hasStereotype("cRoot")) {
			path += "../";
		}
		if (getPackage() != null) {
			path = getPackage().getRelativePathFromRoot() + path;
		}
		return path;
	}

	/**
	 * Gives the set of packages used by current package.
	 * 
	 * @param stereotypeName
	 * 
	 * @return
	 */
	public Set<org.eclipse.uml2.uml.Package> getUsedPackages(String stereotypeName) {

		Set usedElements = new HashSet();
		Set<org.eclipse.uml2.uml.Package> usedPackages = new HashSet<org.eclipse.uml2.uml.Package>();
		org.eclipse.uml2.uml.NamedElement currentNamedElement;

		// initialize currentElement with currentPackage to acces getUsedElemens method
		org.eclipse.papyrus.umlutils.NamedElement currentPackageAsNamedElement = new org.eclipse.papyrus.umlutils.NamedElement(uml2Package);

		usedElements = currentPackageAsNamedElement.getUsedElements(stereotypeName);
		Iterator usedElementsIt = usedElements.iterator();

		while (usedElementsIt.hasNext()) {
			currentNamedElement = (org.eclipse.uml2.uml.NamedElement) usedElementsIt.next();

			if (currentNamedElement instanceof org.eclipse.uml2.uml.Package) {
				// If the element is a Package, it should be returned in the result set
				usedPackages.add((org.eclipse.uml2.uml.Package) currentNamedElement);
			}
		}

		return usedPackages;
	}

	/**
	 * create an owned class in this package.
	 * 
	 * @param name
	 *            , the class name
	 * @param visibilityValue
	 * @param visbility
	 *            the visibility kind
	 * @param name
	 * 
	 * @return the created class
	 */
	public org.eclipse.papyrus.umlutils.Class createOwnedClass(String name, int visibilityValue) {
		org.eclipse.uml2.uml.Class uml2class = uml2Package.createOwnedClass(name, false);
		uml2class.setName(name);

		// TODO modify the visiblity creation
		uml2class.setVisibility(VisibilityKind.get(visibilityValue));
		return new org.eclipse.papyrus.umlutils.Class(uml2class);
	}

	/**
	 * Copy a class in current package.
	 * 
	 * @param initialClass
	 * 
	 * @return the new class
	 */
	public org.eclipse.papyrus.umlutils.Class createOwnedClass(org.eclipse.uml2.uml.Class initialClass) {

		org.eclipse.uml2.uml.Class newClass = (org.eclipse.uml2.uml.Class) EcoreUtil.copy(initialClass);
		getUml2Package().getPackagedElements().add(newClass);

		return (new org.eclipse.papyrus.umlutils.Class(newClass));
	}

	/**
	 * Copy a class in current package.
	 * 
	 * @param initialClass
	 * @param newName
	 *            for the created class
	 * 
	 * @return the new class
	 */
	public org.eclipse.papyrus.umlutils.Class createOwnedClass(org.eclipse.uml2.uml.Class initialClass, String newName) {

		org.eclipse.uml2.uml.Class newClass = (org.eclipse.uml2.uml.Class) EcoreUtil.copy(initialClass);
		newClass.setName(newName);

		getUml2Package().getPackagedElements().add(newClass);

		return (new org.eclipse.papyrus.umlutils.Class(newClass));
	}

	/**
	 * create an owned Enumeration in this package.
	 * 
	 * @param name
	 *            , the enumeration name
	 * @param visibilityValue
	 * @param visbility
	 *            the visibility kind
	 * @param name
	 * 
	 * @return the created enumeration
	 */
	public org.eclipse.papyrus.umlutils.Enumeration createOwnedEnumeration(String name, int visibilityValue) {
		org.eclipse.uml2.uml.Enumeration uml2enumeration = uml2Package.createOwnedEnumeration(name);
		uml2enumeration.setVisibility(VisibilityKind.get(visibilityValue));

		return new org.eclipse.papyrus.umlutils.Enumeration(uml2enumeration);
	}

	/**
	 * Create a new primitive type in the package.
	 * 
	 * @param name
	 * 
	 * @return
	 */
	public org.eclipse.papyrus.umlutils.PrimitiveType createOwnedPrimitiveType(String name) {

		// Create new primitive type
		org.eclipse.uml2.uml.PackageableElement newType = getUml2Package().createOwnedPrimitiveType(name);
		newType.setName(name);

		return (new org.eclipse.papyrus.umlutils.PrimitiveType((org.eclipse.uml2.uml.PrimitiveType) newType));
	}

	/**
	 * create an owned Package in this package.
	 * 
	 * @param name
	 *            , the package nam
	 * @param name
	 * 
	 * @return the created Package
	 */
	public org.eclipse.papyrus.umlutils.Package createOwnedPackage(String name) {
		org.eclipse.uml2.uml.Package uml2package = uml2Package.createNestedPackage(name);
		uml2package.setName(name);

		return new org.eclipse.papyrus.umlutils.Package(uml2package);
	}

	/**
	 * create an owned Enumeration in this package.
	 * 
	 * @param supplier
	 * @param supplier
	 *            , the named supplier element
	 * @param client
	 *            , the named client element
	 * @param client
	 * 
	 * @return the created dependency
	 */
	public org.eclipse.uml2.uml.Dependency createOwnedDependency(org.eclipse.uml2.uml.NamedElement client, org.eclipse.uml2.uml.NamedElement supplier) {

		// Create dependency
		org.eclipse.uml2.uml.Dependency uml2dependency = UMLFactory.eINSTANCE.createDependency();
		uml2dependency.getClients().add(client);
		uml2dependency.getSuppliers().add(supplier);

		// Add the dependency in the owner package ?
		getUml2Package().getPackagedElements().add(uml2dependency);

		return uml2dependency;
	}

	/**
	 * Get all possible types for an element owned by this package.
	 * 
	 * @return a list of all available Types
	 */
	@SuppressWarnings("unchecked")
	public Set<org.eclipse.papyrus.umlutils.Type> getAccessibleTypes() {
		Set<org.eclipse.papyrus.umlutils.Type> list = new HashSet<org.eclipse.papyrus.umlutils.Type>();
		// umlTypeList is used to detect dooblons in the proposed list
		// this may occurs for example with indirect import of UMLPrimitiveTypes
		Set<String> umlTypeQNames = new HashSet<String>();

		Iterator<org.eclipse.uml2.uml.NamedElement> it = this.getUml2Package().getMembers().iterator();

		// get direct members
		while (it.hasNext()) {
			org.eclipse.uml2.uml.NamedElement element = it.next();
			if ((element instanceof org.eclipse.uml2.uml.Type) && (!(element instanceof org.eclipse.uml2.uml.Relationship))) {
				// Check for dooblons
				if (!umlTypeQNames.contains(element.getQualifiedName())) {
					umlTypeQNames.add(element.getQualifiedName());
					list.add(new org.eclipse.papyrus.umlutils.Type((org.eclipse.uml2.uml.Type) element));
				}
			}
		}

		// Recursive call on parents
		if (uml2Package.getOwner() != null) {
			if (uml2Package.getOwner() instanceof org.eclipse.uml2.uml.Package) {

				// The list is parsed one by one to avoid dooblons

				Package ownerPackage = new Package((org.eclipse.uml2.uml.Package) uml2Package.getOwner());
				Iterator<org.eclipse.papyrus.umlutils.Type> itParent = ownerPackage.getAccessibleTypes().iterator();

				while (itParent.hasNext()) {
					org.eclipse.papyrus.umlutils.Type currentType = itParent.next();

					if (!umlTypeQNames.contains(currentType.getUml2Type().getQualifiedName())) {
						umlTypeQNames.add(currentType.getUml2Type().getQualifiedName());
						list.add(currentType);
					}
				}
			}

		}

		return list;

	}

	/**
	 * Get all possible types for an element owned by this package.
	 * 
	 * @return a list of all available Types
	 */
	@SuppressWarnings("unchecked")
	public Set<org.eclipse.papyrus.umlutils.Type> getAccessibleTypes(boolean isRoot) {
		if (isRoot == false)
			return getAccessibleTypes();
		Set<org.eclipse.papyrus.umlutils.Type> list = new HashSet<org.eclipse.papyrus.umlutils.Type>();
		// umlTypeList is used to detect dooblons in the proposed list
		// this may occurs for example with indirect import of UMLPrimitiveTypes
		Set<String> umlTypeQNames = new HashSet<String>();

		Iterator<org.eclipse.uml2.uml.NamedElement> it = this.getUml2Package().getMembers().iterator();

		// get direct members
		while (it.hasNext()) {
			org.eclipse.uml2.uml.NamedElement element = it.next();
			if ((element instanceof org.eclipse.uml2.uml.Type) && (!(element instanceof org.eclipse.uml2.uml.Relationship))) {
				// Check for dooblons
				if (!umlTypeQNames.contains(element.getQualifiedName())) {
					umlTypeQNames.add(element.getQualifiedName());
					list.add(new org.eclipse.papyrus.umlutils.Type((org.eclipse.uml2.uml.Type) element));
				}
			} else if (element instanceof org.eclipse.uml2.uml.Package) {
				list.addAll(new Package((org.eclipse.uml2.uml.Package) element).getAccessibleTypes(true));
			}
		}
		return list;

	}

	/**
	 * Get all possible Associations for an element owned by this package.
	 * 
	 * @return a list of all available Types
	 */
	@SuppressWarnings("unchecked")
	public Set<org.eclipse.papyrus.umlutils.Type> getAccesibleAssociation() {
		Set<org.eclipse.papyrus.umlutils.Type> list = new HashSet<org.eclipse.papyrus.umlutils.Type>();
		Iterator<org.eclipse.uml2.uml.NamedElement> it = this.uml2Package.getMembers().iterator();

		// get direct members
		while (it.hasNext()) {
			org.eclipse.uml2.uml.NamedElement element = it.next();
			if ((element instanceof org.eclipse.uml2.uml.Association)) {
				list.add(new org.eclipse.papyrus.umlutils.Type((org.eclipse.uml2.uml.Association) element));
			}
		}

		// Recursive call on parents
		if (uml2Package.getOwner() != null) {
			if (uml2Package.getOwner() instanceof org.eclipse.uml2.uml.Package) {

				Package ownerPackage = new Package((org.eclipse.uml2.uml.Package) uml2Package.getOwner());
				list.addAll(ownerPackage.getAccesibleAssociation());
			}

		}

		return list;

	}

	/**
	 * Retrieve a type accessible in this Package, given its name.
	 * 
	 * @param name
	 *            the name of the type to find
	 * 
	 * @return the type found or <code>null</code> if not found.
	 */
	public Type findTypeByName(String name) {
		Type type = null;
		boolean isFound = false;
		Assert.isNotEmptyString(name, "findTypeByName(name)");

		Iterator<Type> it = this.getAccessibleTypes().iterator();
		while (!isFound && it.hasNext()) {
			Type t = it.next();
			if (t.getName().equals(name)) {
				isFound = true;
				type = t;
			}
		}

		return type;
	}

	/**
	 * return all properties contains in the package and sub packages.
	 * 
	 * @param propertiesList
	 *            lis of properties already found.
	 * 
	 * @return the list of all properties contained in this package and subPackages
	 */
	public ArrayList<org.eclipse.uml2.uml.Property> getAllProperties(ArrayList<org.eclipse.uml2.uml.Property> propertiesList) {

		Iterator<Element> it = this.getAllNestedElements().iterator();
		while (it.hasNext()) {
			Element currentElement = it.next();
			if (currentElement instanceof org.eclipse.uml2.uml.Property && !(currentElement instanceof org.eclipse.uml2.uml.Port)) {
				if (!propertiesList.contains(currentElement)) {
					propertiesList.add((org.eclipse.uml2.uml.Property) currentElement);
				}
			}
		}
		Iterator<org.eclipse.papyrus.umlutils.Element> iterator = this.getOwnedStructureElements().iterator();
		while (iterator.hasNext()) {
			org.eclipse.papyrus.umlutils.Element currentElement = iterator.next();
			if (currentElement instanceof org.eclipse.papyrus.umlutils.Package) {
				propertiesList = ((Package) currentElement).getAllProperties(propertiesList);
			}
		}

		return propertiesList;
	}

	/**
	 * Apply the profile AND every subprofiles. Deprecated see PackageUtil.applyProfile instead
	 * 
	 * @param aProfile
	 *            the profile to be applied
	 */
	@Deprecated
	public void applyProfile(org.eclipse.uml2.uml.Profile aProfile) {

		// Apply main profile
		getUml2Package().applyProfile(aProfile);

		// Manage sub profiles
		ArrayList<Profile> subProfiles = new ArrayList<Profile>();
		subProfiles = (new Package(aProfile)).getSubProfiles();
		Iterator iter = subProfiles.iterator();
		while (iter.hasNext()) {
			Profile subProfile = (Profile) iter.next();
			getUml2Package().applyProfile(subProfile);
		}
	}

	/**
	 * 
	 * 
	 * @return Deprecated see PackageUtil.getSubProfiles instead
	 */
	@Deprecated
	private ArrayList<Profile> getSubProfiles() {
		ArrayList<Profile> subProfiles = new ArrayList<Profile>();

		Iterator iter = getUml2Package().getMembers().iterator();
		while (iter.hasNext()) {

			Object element = iter.next();
			if (element instanceof Profile) {

				Profile currentSubProfile = (Profile) element;
				subProfiles.add(currentSubProfile);
				subProfiles.addAll((new Package(currentSubProfile)).getSubProfiles());

			}
		}
		return subProfiles;
	}

	/**
	 * Gets the all deployment targets.
	 * 
	 * @param traversedPackage
	 *            the traversed package
	 * 
	 * @return possibleNodes the possible deployment targets
	 */
	public ArrayList<org.eclipse.uml2.uml.DeploymentTarget> getAllDeploymentTargets(ArrayList<org.eclipse.uml2.uml.Package> traversedPackage) {
		ArrayList<org.eclipse.uml2.uml.DeploymentTarget> possibleDeploymentTargets = new ArrayList<org.eclipse.uml2.uml.DeploymentTarget>();
		traversedPackage.add(uml2Package);
		Iterator elements = uml2Package.getMembers().iterator();
		while (elements.hasNext()) {
			Element element = (Element) elements.next();
			if ((element instanceof org.eclipse.uml2.uml.DeploymentTarget) && (possibleDeploymentTargets.contains((org.eclipse.uml2.uml.DeploymentTarget) element) == false)) {
				possibleDeploymentTargets.add((org.eclipse.uml2.uml.DeploymentTarget) element);
			} else if ((element instanceof org.eclipse.uml2.uml.Package) && (traversedPackage.contains((org.eclipse.uml2.uml.Package) element) == false)) {
				Package newPackage = new Package((org.eclipse.uml2.uml.Package) element);
				possibleDeploymentTargets.addAll(newPackage.getAllDeploymentTargets(traversedPackage));
			}
		}
		return possibleDeploymentTargets;
	}

	/**
	 * Gets the all use cases.
	 * 
	 * @param traversedPackage
	 *            the traversed package
	 * 
	 * @return possibleUseCases the possible use cases
	 */
	public ArrayList<org.eclipse.uml2.uml.UseCase> getAllUSeCases(ArrayList<org.eclipse.uml2.uml.Package> traversedPackage) {
		ArrayList<org.eclipse.uml2.uml.UseCase> possibleUseCases = new ArrayList<org.eclipse.uml2.uml.UseCase>();
		traversedPackage.add(uml2Package);
		Iterator elements = uml2Package.getMembers().iterator();
		while (elements.hasNext()) {
			Element element = (Element) elements.next();
			if ((element instanceof org.eclipse.uml2.uml.UseCase) && (possibleUseCases.contains((org.eclipse.uml2.uml.UseCase) element) == false)) {
				possibleUseCases.add((org.eclipse.uml2.uml.UseCase) element);
			} else if ((element instanceof org.eclipse.uml2.uml.Package) && (traversedPackage.contains((org.eclipse.uml2.uml.Package) element) == false)) {
				Package newPackage = new Package((org.eclipse.uml2.uml.Package) element);
				possibleUseCases.addAll(newPackage.getAllUSeCases(traversedPackage));
			}
		}
		return possibleUseCases;
	}

	/**
	 * Gets the all subjects.
	 * 
	 * @param traversedPackage
	 *            the traversed package
	 * 
	 * @return possibleSubjects the possible subjects
	 */
	public ArrayList<org.eclipse.uml2.uml.Classifier> getAllSubjects(ArrayList<org.eclipse.uml2.uml.Package> traversedPackage) {
		ArrayList<org.eclipse.uml2.uml.Classifier> possibleSubjects = new ArrayList<org.eclipse.uml2.uml.Classifier>();
		traversedPackage.add(uml2Package);
		Iterator elements = uml2Package.getMembers().iterator();
		while (elements.hasNext()) {
			Element element = (Element) elements.next();
			if ((element instanceof org.eclipse.uml2.uml.Classifier) && (possibleSubjects.contains((org.eclipse.uml2.uml.Classifier) element) == false)) {
				possibleSubjects.add((org.eclipse.uml2.uml.Classifier) element);
			} else if ((element instanceof org.eclipse.uml2.uml.Package) && (traversedPackage.contains((org.eclipse.uml2.uml.Package) element) == false)) {
				Package newPackage = new Package((org.eclipse.uml2.uml.Package) element);
				possibleSubjects.addAll(newPackage.getAllSubjects(traversedPackage));
			}
		}
		return possibleSubjects;
	}

	/**
	 * Check if the profile is applied to the package.
	 * 
	 * @param profileName
	 * 
	 * @return
	 */
	public boolean hasProfile(String profileName) {
		boolean found = false;

		Iterator it = getUml2Package().getAllAppliedProfiles().iterator();
		while (it.hasNext() && !found) {
			org.eclipse.uml2.uml.Profile currentProf = (org.eclipse.uml2.uml.Profile) it.next();

			if (profileName.equals(currentProf.getName())) {
				found = true;
			}
		}

		return found;
	}

	/**
	 * Check if the library is imported in the package.
	 * 
	 * @param libName
	 * 
	 * @return
	 */
	public boolean hasLibrary(String libName) {
		boolean found = false;

		Iterator it = getUml2Package().getImportedPackages().iterator();
		while (it.hasNext() && !found) {
			org.eclipse.uml2.uml.Package currentLibrary = (org.eclipse.uml2.uml.Package) it.next();

			if (libName.equals(currentLibrary.getName())) {
				found = true;
			}
		}

		return found;
	}

	/**
	 * Retrieve a type owned by a Pacakage Import.
	 * 
	 * @param typeName
	 *            the wishing type
	 * @param model
	 *            the model owning the package import
	 * @param packageImportName
	 *            the package import name handling the type
	 * 
	 * @return the type, or null if not found
	 */
	public org.eclipse.uml2.uml.Type getTypeFromPackageImport(String packageImportName, String typeName) {
		org.eclipse.uml2.uml.Type type = null;

		org.eclipse.emf.common.util.EList list = getUml2Package().getPackageImports();
		java.util.Iterator i = list.iterator();
		org.eclipse.uml2.uml.PackageImport currentPackage;
		while ((i.hasNext()) && (type == null)) {
			currentPackage = (org.eclipse.uml2.uml.PackageImport) i.next();
			if (currentPackage.getImportedPackage().getName().equals(packageImportName)) {
				type = currentPackage.getImportedPackage().getOwnedType(typeName);
			}
		}
		if (type == null) {
			// Warning type not found in package (packageImportName)
		}
		return type;
	}

}
