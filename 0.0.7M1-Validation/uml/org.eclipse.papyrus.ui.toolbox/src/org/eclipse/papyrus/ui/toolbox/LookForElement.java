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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.ui.toolbox;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.papyrus.core.editor.IMultiDiagramEditor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.TemplateableElement;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UMLResource;

/**
 * The Class LookForElement that contains method that allows looking for elements.
 */
public class LookForElement {

	/** debug channel */
	private static final int channel = 26;

	/**
	 * This method is used to look for the top package that contains this element.
	 * 
	 * @param element
	 *            the element
	 * @return the top package
	 */
	public static Package topPackage(Element element) {
		if (element.getOwner() == null) {
			return (Package) element;
		} else {
			return topPackage(element.getOwner());
		}
	}

	/**
	 * this method is used to have all type in a package.
	 * 
	 * @param model
	 *            the package
	 * @return list of type in the package
	 */
	public static ArrayList lookForAllTypes(Package model) {
		ArrayList<Element> typeCollection = new ArrayList<Element>();
		Collection elements = model.allOwnedElements(); // select all elements of the model
		Iterator it = elements.iterator();
		// filter classifier DataType and Element Import
		while (it.hasNext()) {
			Element currentElement = (Element) it.next();
			if (currentElement instanceof Type) {
				typeCollection.add(currentElement);
			}
			if (currentElement instanceof ElementImport) {
				if (((ElementImport) currentElement).getImportedElement() instanceof Type) {
					typeCollection.add(((ElementImport) currentElement).getImportedElement());
				}
			}
		}
		return typeCollection;
	}

	/**
	 * this method is used to obtain theAssociation of the model.
	 * 
	 * 
	 * @param model
	 *            the model
	 * 
	 * @return the list of associations
	 */
	public static ArrayList lookForAllAssociation(Package model) {
		ArrayList<Association> typeCollection = new ArrayList<Association>();
		Collection elements = model.allOwnedElements();// select all elements
		Iterator it = elements.iterator();
		while (it.hasNext()) {// filter by Association
			Element currentElement = (Element) it.next();
			if (currentElement instanceof org.eclipse.uml2.uml.Association) {
				typeCollection.add((Association) currentElement);
			}
		}
		return typeCollection;
	}

	/**
	 * Loads content for the given URI, and returns the top package of this content.
	 * 
	 * @param uri
	 *            the uri of the content to load
	 * @param element
	 *            the Element used to retrieve ResourceSet
	 * @return the top package of the loaded content
	 */
	public static org.eclipse.uml2.uml.Package contentload(URI uri, Element element) {
		ResourceSet resourceSet = element.eResource().getResourceSet();
		Package package_ = null;
		try {
			Resource resource = resourceSet.getResource(uri, true);

			package_ = (org.eclipse.uml2.uml.Package) EcoreUtil.getObjectByType(resource.getContents(),
					UMLPackage.eINSTANCE.getPackage());
		} catch (WrappedException we) {
			System.err.println("impossible to load content for URI: " + uri);
		}

		return package_;
	}

	/**
	 * return all type contained in the metamodel UML2. Elements in the list are the UML2
	 * representation of the concepts of the metamodel. each element of the list must be casted with
	 * org.eclipse.uml2.Classifier
	 * 
	 * @return list of metaclasses of the metamodel UML2
	 */
	public static List<Type> getMetaclasses(Element element) {
		if (element == null) {
			System.err.println("element should not be null to retrieve metaclasses");
		}
		Package uml2Metamodel = LookForElement.contentload(URI.createURI(UMLResource.UML_METAMODEL_URI), element);

		return uml2Metamodel.getOwnedTypes();
	}

	/**
	 * return every type contained in the UML2 metamodel that comply with the filter Eclass
	 * including abstract classifiers.
	 * 
	 * @param filter
	 *            the filter
	 * 
	 * @return list of metaclasses of the UML2 metamodel that comply with the filter Eclass
	 */
	public static List getMetaclasses(EClass filter, Element element) {
		boolean includeAbstractClassifiers = true;
		return getMetaclasses(filter, includeAbstractClassifiers, element);
	}

	/**
	 * return every type contained in the UML2 metamodel that comply with the filter Eclass.
	 * 
	 * @param includeAbstractClassifiers
	 *            the include abstract classifiers
	 * @param filter
	 *            the filter
	 * 
	 * @return list of metaclasses of the UML2 metamodel that comply with the filter Eclass
	 */
	public static List getMetaclasses(EClass filter, boolean includeAbstractClassifiers, Element element) {

		// this Comparator is used to produce a sorted list of uml Classifiers
		final class ClassifierComparator implements Comparator<Classifier> {

			public int compare(Classifier o1, Classifier o2) {
				try {
					return o1.getName().compareTo(o2.getName());
				} catch (Exception e) {
					System.err.println("could not compare " + o1 + " and " + o2);
				}
				return 0;
			}

			public boolean equals(Object o) {
				return o.equals(this);
			}
		}

		List completeList = getMetaclasses(element);
		List filteredList = new ArrayList();
		SortedSet<Classifier> filteredSortedClassifiers = new TreeSet<Classifier>(new ClassifierComparator());

		// Retrieves the UML Classifier (i.e. the classifier used to describe the corresponding
		// concept)
		// of the metamodel corresponding to the EClass filter
		Classifier filterClassifier = null;
		for (Iterator i = completeList.iterator(); i.hasNext() && filterClassifier == null;) {
			Classifier c = (Classifier) i.next();
			if (c.getName().equals(filter.getName())) {
				filterClassifier = c;
			}
		}
		if (filterClassifier == null) // the corresponding UML classifier has not been found
			return filteredList;

		// The corresponding UML Classifier has been found
		// Now retrieves all Classifiers derived from this Classifier
		for (Iterator<Classifier> i = completeList.iterator(); i.hasNext();) {
			Classifier c = i.next();
			if (includeAbstractClassifiers == false) {
				if (!c.isAbstract()) {
					if (c.allParents().contains(filterClassifier)) {
						filteredSortedClassifiers.add(c);
						// filteredList.add(c) ;
					}
				}
			} else if (c.allParents().contains(filterClassifier)) {
				filteredSortedClassifiers.add(c);
				// filteredList.add(c) ;
			}
		}
		if (includeAbstractClassifiers == false) {
			if (!filterClassifier.isAbstract())
				// filteredList.add(filterClassifier) ;
				filteredSortedClassifiers.add(filterClassifier);
		} else
			// filteredList.add(filterClassifier) ;
			filteredSortedClassifiers.add(filterClassifier);

		for (Iterator<Classifier> i = filteredSortedClassifiers.iterator(); i.hasNext();) {
			filteredList.add(i.next());
		}
		return filteredList;
	}

	/**
	 * look for all metaclasses of the meta model UML2 for a profile.
	 * 
	 * @param element
	 *            the profile which needs the metaclasses list
	 * @return the possible metaclasses
	 */
	public static ArrayList getPossibleMetaclasses(Element element) {
		ArrayList metaList = new ArrayList();
		List metaclasses = getMetaclasses(element); // get all type of the metaclass

		for (int i = 0; i < metaclasses.size(); i++) {
			if (metaclasses.get(i) instanceof org.eclipse.uml2.uml.Class) {
				metaList.add(metaclasses.get(i));
			}
		}

		return metaList;
	}

	/**
	 * look for an elemnent import in the model that contains the researched Element.
	 * 
	 * @param model
	 *            the model
	 * @param elt
	 *            the elt
	 * 
	 * @return the element import
	 */
	public static ElementImport getElementImport(Package model, Element elt) {
		if (model == null)
			return null;
		Iterator it = model.getElementImports().iterator();
		while (it.hasNext()) {
			ElementImport current = (ElementImport) it.next();
			if (current.getImportedElement().equals(elt)) {
				return current;
			}
		}
		return null;
	}

	/**
	 * Gets the command stack.
	 * 
	 * @return the command stack
	 */
	public static CommandStack getCommandStack() {
		// getCommandStack
		if ((PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage() != null)
				&& (PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor() != null)) {

			IEditorPart editorPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
					.getActiveEditor();

			if (editorPart instanceof IMultiDiagramEditor) {
				IEditorPart multiEditorPart;
				multiEditorPart = ((IMultiDiagramEditor) editorPart).getActiveEditor();
				CommandStack stack = (CommandStack) multiEditorPart.getAdapter(CommandStack.class);
				return stack;
			} else
				return (CommandStack) editorPart.getAdapter(CommandStack.class);
		}
		return null;
	}

	/**
	 * Gets the list of edit parts contained in the outline.
	 * 
	 * @return the list of edit parts contained in the outline
	 */
	public static List<EditPart> getAllOutlineEditParts() {
		List<EditPart> editPartList = new ArrayList<EditPart>();
		/*
		 * IEditorPart editor =
		 * PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor() ;
		 * //editor if (editor instanceof MultiDiagramEditor) { TreeOutlinePage outline =
		 * (TreeOutlinePage)((MultiDiagramEditor)editor).getAdapter(IContentOutlinePage.class) ;
		 * editPartList.addAll(getAllEditParts(outline.getModel().getModelTreeEditPart())); }
		 */
		return editPartList;
	}

	/**
	 * Gets the list of (direct or indirect) children edit parts of a root edit part, including root
	 * in the result list.
	 * 
	 * @param EditPart
	 *            root, the root edit part
	 * @param root
	 *            the root
	 * 
	 * @return the list of (direct or indirect) children EditParts of the root EditPart.
	 */
	public static List<EditPart> getAllEditParts(EditPart root) {
		List<EditPart> editPartList = new ArrayList<EditPart>();
		editPartList.add(root);
		if (root.getChildren() != null) {
			for (Iterator<EditPart> i = root.getChildren().iterator(); i.hasNext();) {
				EditPart current = i.next();
				editPartList.addAll(getAllEditParts(current));
			}
		}
		return editPartList;
	}

	/**
	 * Gets the list of all templates contained directly or indirectly in the root package.
	 * 
	 * @param root
	 *            the root
	 * @param Package
	 *            root, the root package
	 * 
	 * @return the list of (direct or indirect) children template bindings.
	 */
	public static List<TemplateableElement> getAllTemplates(Model root) {
		List<TemplateableElement> templateList = new ArrayList<TemplateableElement>();
		List<Element> allOwnedElements = root.allOwnedElements();
		for (Iterator<Element> i = allOwnedElements.iterator(); i.hasNext();) {
			Element current = i.next();
			if (current instanceof TemplateableElement) {
				if (((TemplateableElement) current).isTemplate())
					templateList.add((TemplateableElement) current);
			}
		}
		return templateList;
	}

	/**
	 * Gets the list of all template binding contained directly or indirectly in the root package.
	 * 
	 * @param root
	 *            the root
	 * @param Package
	 *            root, the root package
	 * 
	 * @return the list of (direct or indirect) children template bindings.
	 */
	public static List<TemplateBinding> getAllTemplateBinding(Model root) {
		List<TemplateBinding> templateBindingList = new ArrayList<TemplateBinding>();
		List<Element> allOwnedElements = root.allOwnedElements();
		for (Iterator<Element> i = allOwnedElements.iterator(); i.hasNext();) {
			Element current = i.next();
			if (current instanceof TemplateBinding) {
				templateBindingList.add((TemplateBinding) current);
			}
		}
		return templateBindingList;
	}

	/**
	 * Returns all packages, profiles or models that are accessible from the specified model. If a
	 * package is imported, its root model/package/profile is return, not the package itself.
	 * 
	 * @return the set of imported packages, models, or profiles that are imported
	 */
	public static HashSet<Package> buildImportedTopPackagesList(Package rootModel, HashSet<Package> importedPackages) {
		// for each imported element, adds the parent package of the imported package
		Iterator<PackageableElement> it = rootModel.getImportedMembers().iterator();
		while (it.hasNext()) {

			Package topPackage = LookForElement.topPackage(it.next());
			// following test is not very pertinent, the hashset implementation removes doublons
			if (!importedPackages.contains(topPackage) && topPackage != rootModel) {
				importedPackages.add(topPackage);
			}
		}

		// update the list for sub packages
		it = rootModel.getPackagedElements().iterator();
		while (it.hasNext()) {
			Element currentElement = (Element) it.next();
			if (currentElement instanceof Package) {
				buildImportedTopPackagesList((Package) currentElement, importedPackages);
			}
		}
		return importedPackages;
	}

	/**
	 * Returns all packages, profiles or models that are accessible from the specified model. If a
	 * package is imported, its root model/package/profile is return, not the package itself.
	 * 
	 * @return the set of imported packages, models, or profiles that are imported
	 */
	public static HashSet<Package> buildExtendedImportedPackagesList(HashSet<Package> importedPackages,
			Package refPackage) {
		// duplicates the list, because importedPackages will be modified
		HashSet<Package> unmodifiedList = (HashSet<Package>) importedPackages.clone();

		// iterate over each element in the import list.
		// if this element has imports that are unknown yet, add them to the list of elements to
		// check.
		Iterator it = unmodifiedList.iterator();
		while (it.hasNext()) {
			Package curPackage = (Package) it.next();
			Iterator<Package> it2 = buildImportedTopPackagesList(curPackage, new HashSet<Package>()).iterator();
			while (it2.hasNext()) {
				Package impPack = it2.next();
				// test neither to add an element that already exists in the list nor to add base
				// model
				if (!importedPackages.contains(impPack) && impPack != refPackage) {
					importedPackages.add(impPack);
				}
			}
		}

		// Some elements have been added, so it has to be recompute again, using the new extended
		// list
		if (unmodifiedList.size() != importedPackages.size()) {
			buildExtendedImportedPackagesList(importedPackages, refPackage);
		}

		// finally, everything is contained in the list, it can be returned
		return importedPackages;
	}

	/**
	 * Gets the TransactionalEditingDomain.
	 * 
	 * @return the {@link TransactionalEditingDomain}
	 */
	public static TransactionalEditingDomain getTransactionalEditingDomain() {
		// getCommandStack
		if ((PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage() != null)
				&& (PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor() != null)) {

			IEditorPart editorPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
					.getActiveEditor();

			if (editorPart instanceof IMultiDiagramEditor) {
				IMultiDiagramEditor multiEditorPart = (IMultiDiagramEditor) editorPart;
				return multiEditorPart.getDefaultContext().getTransactionalEditingDomain();
			}
		}
		return null;
	}
}
