/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Ansgar Radermacher  ansgar.radermacher@cea.fr  
 *
 *****************************************************************************/

package org.eclipse.papyrus.qompass.designer.core;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.FCM.Assembly;
import org.eclipse.papyrus.FCM.ContainerRule;
import org.eclipse.papyrus.FCM.RuleApplication;
import org.eclipse.papyrus.FCM.Singleton;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForHandlers;
import org.eclipse.papyrus.qompass.designer.core.preferences.QompassPreferenceConstants;
import org.eclipse.papyrus.uml.tools.utils.StereotypeUtil;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.util.UMLUtil;

public class Utils {

	public static final String QUOTE = "\""; //$NON-NLS-1$

	/**
	 * Retrieve an element from a list of named elements via its name
	 * 
	 * @param namedElementList
	 * @param name
	 * @return
	 */
	public static NamedElement getNamedElementFromList(
		EList<? extends NamedElement> namedElementList, String name) {
		Iterator<? extends NamedElement> namedElements = namedElementList
			.iterator();
		while(namedElements.hasNext()) {
			NamedElement namedElement = namedElements.next();
			if(namedElement.getName().equals(name)) {
				return namedElement;
			}
		}
		return null;
	}

	/**
	 * return the top-level owner of an element. This function returns the same
	 * value as getModel, if the top-level element is a model. While this is the
	 * case for models, model libraries have a top-level package (not a model).
	 * In this case, getTop returns the top-level package whereas getModel would
	 * return null.
	 * 
	 * @param element
	 * @return the top-level owning package
	 */
	public static Package getTop(Element element) {
		while(element != null) {
			Element owner = element.getOwner();
			if(owner == null) {
				if(element instanceof Package) {
					return (Package)element;
				}
			}
			element = owner;
		}
		return null;
	}

	/**
	 * Return package at first level. Useful, since last model transformation 
	 * will put elements under a new "root"
	 * 
	 * @param element
	 * @return
	 */
	public static Package getFirstLevel(Element element) {
		Element lastElement = element;
		while(element != null) {
			Element owner = element.getOwner();
			if(owner == null) {
				if(lastElement instanceof Package) {
					return (Package)lastElement;
				}
			}
			lastElement = element;
			element = owner;
		}
		return null;
	}

	/**
	 * @param element
	 *        an element which is owned by a model.
	 * @param subfolder
	 *        the name of a sub-folder within root (created, if not
	 *        existent)
	 * @return a reference to the sub folder within the root of the model that
	 *         belongs to the passed element.
	 */
	public static Package getRoot(Element element, String subfolder) {
		Package root = getTop(element);
		if(root.getNestedPackage(subfolder) != null) {
			return root.getNestedPackage(subfolder);
		} else {
			return root.createNestedPackage(subfolder);
		}
	}

	/**
	 * Convenience method enabling to apply getOwnedOperation equally to classes
	 * and interfaces
	 * 
	 * @param cl
	 * @param name
	 * @param paramNames
	 * @param paramTypes
	 * @return
	 */
	public static Operation createOwnedOperation(Classifier cl, String name,
		EList<String> paramNames, EList<Type> paramTypes, Type retType) {
		if(cl instanceof Class) {
			return ((Class)cl).createOwnedOperation(name, paramNames,
				paramTypes, retType);
		} else if(cl instanceof Interface) {
			return ((Interface)cl).createOwnedOperation(name, paramNames,
				paramTypes, retType);
		} else {
			return null;
		}
	}

	public static Operation getOwnedOperation(Classifier cl, String name,
		EList<String> paramNames, EList<Type> paramTypes) {
		if(cl instanceof Class) {
			return ((Class)cl).getOwnedOperation(name, paramNames, paramTypes);
		} else if(cl instanceof Interface) {
			return ((Interface)cl).getOwnedOperation(name, paramNames,
				paramTypes);
		} else {
			return null;
		}
	}

	/**
	 * this method returns the component type of an implementation. It is based
	 * on the modeling convention that implementations inherit from types.
	 */
	public static Class componentType(Class implementation) {
		if(Utils.isCompImpl(implementation)) {
			Iterator<Class> superclasses = implementation.getSuperClasses()
				.iterator();
			while(superclasses.hasNext()) {
				Class componentType = superclasses.next();
				if(Utils.isCompType(componentType)) {
					return componentType;
				}
			}
		}
		return null;
	}

	/**
	 * return true, if a component (implementation) is a composite, i.e. has
	 * inner parts
	 */
	public static boolean isComposite(Class implementation) {
		return Utils.isCompImpl(implementation)
			&& (getParts(implementation).size() > 0);
	}

	public static EList<Property> getParts(Class implementation) {
		if(treatNoneAsComposite()) {
			EList<Property> parts = new BasicEList<Property>();
			for(Property part : implementation.getAttributes()) {
				if(part.getAggregation() != AggregationKind.SHARED_LITERAL) {
					parts.add(part);
				}
			}
			return parts;
		}
		else {
			return implementation.getParts();
		}
	}


	/**
	 * @param attribute
	 *        an attribute
	 * @return true, if the aggregation kind is considered as a composition
	 */
	public static boolean isComposition(Property attribute) {
		if(treatNoneAsComposite()) {
			return (attribute.getAggregation() != AggregationKind.SHARED_LITERAL);
		}
		else {
			return (attribute.getAggregation() == AggregationKind.COMPOSITE_LITERAL);
		}
	}

	/**
	 * return true, if an instance specification is a composite, i.e. has > 1
	 * slots TODO: distinguish parts and configuration attributes
	 */

	public static boolean isComposite(InstanceSpecification is) {
		return (is.getSlots().size() > 0);
	}

	/**
	 * Get an element via its qualified name. Will find elements from the root
	 * model and elements in imported models. Also supports target model in
	 * which imports have been copied (while keeping the top-level name)
	 * 
	 * @param root
	 * @param qualifiedName
	 * @return
	 */
	public static NamedElement getQualifiedElement(Package root,
		String qualifiedName) {
		NamedElement namedElement = null;
		int index = qualifiedName.indexOf("::"); //$NON-NLS-1$
		if(index != -1) {
			// first try using a path without top element (since
			// getQualifiedElement is typically used for
			// imported elements)
			String remainder = qualifiedName.substring(index + 2);
			namedElement = getQualifiedElement(root, remainder, qualifiedName);
		}
		if(namedElement == null) {
			// try with complete name as path name, but assume that the element
			// has been copied into the model,
			// i.e. qualifiedName is prefixed by model name
			namedElement = getQualifiedElement(root, qualifiedName,
				root.getName() + "::" + qualifiedName); //$NON-NLS-1$
		}
		return namedElement;
	}

	/**
	 * Retrieve an element via its qualified name within a package The segments
	 * of the package may be non unique due to imports
	 * 
	 * @return the found element, if it exists
	 */
	public static NamedElement getQualifiedElement(Package root,
		String remainingPath, String qualifiedName) {
		if(root == null) {
			return null;
		}
		if(!remainingPath.contains(Namespace.SEPARATOR)) {
			for(NamedElement candidate : root.getMembers()) {
				String name = candidate.getName();
				if((name != null) && name.equals(remainingPath)) {
					if(candidate.getQualifiedName().equals(qualifiedName)) {
						return candidate;
					}
				}
			}
		} else {
			String segment = remainingPath.split(Namespace.SEPARATOR)[0];
			String remainder = remainingPath.substring(segment.length() + 2);
			for(Element element : root.getMembers()) {
				if(element instanceof Package) {
					if(((NamedElement)element).getName().equals(segment)) {
						NamedElement foundElement = getQualifiedElement(
							(Package)element, remainder, qualifiedName);
						// return, if not found
						if(foundElement != null) {
							return foundElement;
						}
					}
				}
			}
		}
		return null;
	}

	/**
	 * Simple check whether an element is in a different model than the passed
	 * package It will return true, whenever the the top elements do not match.
	 * This is always true, if the 2nd belongs to a different model, whether
	 * imported or not. This distinction is however not required in our context.
	 */
	public static boolean isElementInDifferentModel(Package model,
		NamedElement namedElement) {
		return model != getTop(namedElement);
	}

	/**
	

	/**
	 * Check whether a class contains a non-port attribute of a given name
	 * 
	 * @param cl
	 * @return
	 */
	public static boolean hasNonPortOwnedAttribute(Class cl, String name) {
		for(Property p : cl.getOwnedAttributes()) {
			if(!(p instanceof Port)) {
				if(p.getName().equals(name)) {
					return true;
				}
			}
		}
		return false;
	}

	public static <T extends EObject> EList<T> getAllElementsOfType(Element examineElement, java.lang.Class<T> clazz)
	{
		EList<Element> visitedPackages = new BasicEList<Element>();
		return getAllElementsOfType(examineElement, clazz, visitedPackages);
	}

	@SuppressWarnings("unchecked")
	public static <T extends EObject> EList<T> getAllElementsOfType(Element examineElement, java.lang.Class<T> clazz, EList<Element> visitedPackages)
	{
		EList<T> list = new UniqueEList<T>();
		for(Element element : examineElement.allOwnedElements()) {
			if(element instanceof Package) {
				if(!visitedPackages.contains(element)) {
					visitedPackages.add(element);
					list.addAll(getAllElementsOfType((Package)element, clazz,
						visitedPackages));
				}
			} else if(clazz.isInstance(element)) {
				list.add((T)element);
			}
		}
		return list;
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

	/**
	 * @param a
	 *        potential implementation
	 * @return true, if passed classifier is an implementation (i.e. declared
	 *         via stereotypes as component or connector implementation (a sub-type of component implementations,
	 *         therefore no additional check is required)
	 */
	public static boolean isCompImpl(Classifier implementation) {
		return !implementation.isAbstract();
	}

	/**
	 * Check whether the passed class is a component type (and not a component implementation).
	 * This includes connector and container types as well.
	 * 
	 * @param component
	 * @return
	 */
	public static boolean isCompType(Class component) {
		return component.isAbstract();
	}

	public static boolean isSingleton(Class component) {
		return StereotypeUtil.isApplied(component, Singleton.class);
	}

	public static boolean isAssembly(Class component) {
		return StereotypeUtil.isApplied(component, Assembly.class);
	}

	public static boolean treatNoneAsComposite() {
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		return store.getBoolean(QompassPreferenceConstants.P_TREAT_NONE_AS_COMPOSITE);
	}

	public static boolean allAttributesAreConfigAttributs() {
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		return store.getBoolean(QompassPreferenceConstants.P_ALL_ATTRIBUTES_ARE_CONFIG_ATTRIBUTES);
	}

	/**
	 * True, if either a component implementation or a type
	 * 
	 * @param component
	 * @return
	 */
	public static boolean isComponent(Class component) {
		return (isCompType(component) || isCompImpl(component));
	}

	/**
	 * Return the rules associated with a component
	 * 
	 * @param component
	 * @return
	 */
	public static EList<ContainerRule> getRules(Class component) {
		RuleApplication ruleApplication = UMLUtil.getStereotypeApplication(component, RuleApplication.class);
		if(ruleApplication != null) {
			return ruleApplication.getContainerRule();
		}
		return null;
	}

	/**
	 * Return the absolute file name to a file name given e.g. in the form platform:/plugin/xxx
	 * 
	 * @param fileName
	 *        the file name using eclipse elements such as platform:/plugin
	 * @return the absolute file name
	 */
	public static String getAbsoluteFN(String fileName) {
		try {
			URL absoluteURL = FileLocator.toFileURL(new URL(fileName));
			return absoluteURL.getFile();
		} catch (MalformedURLException e) {
		} catch (IOException e) {
		}
		return null;
	}

	// TODO: need a generic utility function for getting all elements obeying a certain
	// criteria from a model 
	public static EList<ContainerRule> getAllRules(Package pkg) {
		EList<Package> visitedPackages = new BasicEList<Package>();
		EList<ContainerRule> contRuleList = new BasicEList<ContainerRule>();
		getAllRules(pkg, visitedPackages, contRuleList);
		return contRuleList;
	}

	public static void getAllRules(Package pkg, EList<Package> visitedPackages, EList<ContainerRule> contRuleList) {
		for(Element el : pkg.getMembers()) {
			if(el instanceof Package) {
				if(!visitedPackages.contains(el)) {
					visitedPackages.add((Package)el);
					getAllRules((Package)el, visitedPackages, contRuleList);
				}
			}
			else if(el instanceof Class) {
				if(StereotypeUtil.isApplied(el, ContainerRule.class)) {
					ContainerRule rule = UMLUtil.getStereotypeApplication((Class)el, ContainerRule.class);
					contRuleList.add(rule);
				}
			}
		}
	}

	/**
	 * Put quotes around a string, unless string already starts with a quote.
	 * 
	 * @param str
	 * @return
	 */
	public static String quoteString(String str) {
		if (str.startsWith(QUOTE)) {
			return str;
		}
		else {
			return QUOTE + str + QUOTE;
		}
	}
}
