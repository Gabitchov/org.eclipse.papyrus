/*******************************************************************************
 * Copyright (c) 2006 - 2013 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA LIST - initial API and implementation
 *******************************************************************************/

package org.eclipse.papyrus.acceleo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.DirectedRelationship;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.OpaqueBehavior;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.ParameterableElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.TemplateSignature;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.util.UMLUtil;


/**
 * Some utilities: a set of static methods for Acceleo based code generation
 * 
 * @author wassim, ansgar
 * 
 */
public class GenUtils {

	public static final String NL = System.getProperties().getProperty("line.separator"); //$NON-NLS-1$

	/**
	 * Retrieve template bindings for the class passed as a Parameter
	 * only one template binding can exist for an element
	 * 
	 * @param current
	 *        Class on which the template binding is searched
	 * @return the template binding of current Class
	 */
	public static TemplateBinding getTemplateBindings(Class current) {
		TemplateBinding binding = null;
		if(current.getTemplateBindings().size() == 1) {
			binding = current.getTemplateBindings().get(0);
		}

		return binding;
	}

	/**
	 * Check whether the passed classifier has a template binding with itself as bound element
	 *
	 * @param cl
	 * @return
	 */
	public static boolean isTemplateBoundElement(Classifier cl) {
		boolean result = false;
		EList<TemplateBinding> tbs = cl.getTemplateBindings();
		if(tbs.size() > 0) {
			for (TemplateBinding tb : tbs) {
				// TODO: will only work for single element in template binding list
				result = tb.getBoundElement() == cl;
			}
		}
		return result;
	}

	/**
	 * Get the name of a template parameter or undefined, if it is not set
	 * 
	 * @param templateParam
	 * @return
	 */
	public static String getTemplateName(TemplateParameter templateParam) {
		String name = ""; //$NON-NLS-1$
		ParameterableElement pElt = templateParam.getParameteredElement();
		if((pElt != null) && (pElt instanceof NamedElement)) {
			name = ((NamedElement)pElt).getName();
		} else {
			name = "undefined"; //$NON-NLS-1$
		}

		return name;
	}

	
	/**
	 *
	 * @param classifier a classifier owning a template signature
	 * @return the list of (formal) parameters defined within a template signature
	 */
	public static Collection<TemplateParameter> getTemplateParameters(Classifier classifier) {

		Collection<TemplateParameter> params = new ArrayList<TemplateParameter>();
		TemplateSignature ts = classifier.getOwnedTemplateSignature();
		if(ts != null) {
			params.addAll(ts.getOwnedParameters());
		}

		return params;
	}

	/**
	 * 
	 * @param classifier
	 * @return
	 */
	public static Collection<ParameterableElement> getTemplateParameteredElements(Classifier classifier) {

		Collection<ParameterableElement> params = new ArrayList<ParameterableElement>();
		TemplateSignature ts = classifier.getOwnedTemplateSignature();
		if(ts != null) {
			for(TemplateParameter tp : ts.getOwnedParameters()) {
				if(tp != null) {
					params.add(tp.getParameteredElement());
				}
			}
		}
		return params;
	}

	/**
	 * Retrieve a list of types that belong to by a classifier in the current class
	 * 
	 * @param current
	 *        Class on which the attributes are searched
	 * @return collection of classes which are the type of the attributes
	 */
	public static EList<Classifier> getOwnedAttributeTypes(Classifier current) {
		EList<Classifier> result = new UniqueEList<Classifier>();

		Iterator<Property> attributes;
		attributes = current.getAttributes().iterator();
		while(attributes.hasNext()) {
			Property currentAttribute = attributes.next();
			Type type = currentAttribute.getType();
			if(type instanceof Classifier) {
				Classifier attrType = (Classifier)type;
				result.add(attrType);
			}
		}
		return result;
	}
	
	/**
	 * Retrieve a list of types that belong to by a classifier in the current class
	 * 
	 * @param current
	 *        Class on which the attributes are searched
	 * @return collection of classes which are the type of the attributes
	 */
	public static EList<Classifier> getTypesViaAttributes(Classifier current) {
		EList<Classifier> result = new UniqueEList<Classifier>();

		for (Property currentAttribute : current.getAttributes()) {
			Type type = currentAttribute.getType();
			if(type instanceof Classifier) {
				result.add((Classifier) type);
			}
		}
		return result;
	}

	/**
	 * Retrieve the operations in the current class. For each
	 * operation collected the classifier type. This class thus finds types, on
	 * which the signature depends.
	 * 
	 * @param current
	 *        Class on which the attributes are searched
	 * @return collection of classes which are the types of the operations parameters
	 */
	public static EList<Classifier> getTypesViaOperations(Classifier current) {
		EList<Classifier> result = new UniqueEList<Classifier>();
		for(Operation operation : current.getOperations()) {
			for (Parameter param : operation.getOwnedParameters()) {
				Type type = param.getType();
				if(type instanceof Classifier) {
					Classifier paramType = (Classifier)type;
					result.add(paramType);
				}
			}
		}
		return result;
	}

	/**
	 * Return a list of classifiers that are referenced by relationships, i.e.
	 * dependencies or associations
	 * 
	 * @param current
	 * @return
	 */
	public static EList<Classifier> getTypesViaRelationships(Classifier current) {
		EList<Classifier> classifiers = new UniqueEList<Classifier>();

		for(DirectedRelationship relationship : current.getSourceDirectedRelationships()) {

			if(relationship.getTargets().size() > 0) {
				// there should always be at least one element in the target
				// list and it should be a classifier, but better check.
				Element element = relationship.getTargets().get(0);
				if(element instanceof Classifier) {
					classifiers.add((Classifier)element);
				}
			}
		}
		return classifiers;
	}

	/**
	 * Return a list of classifiers that are referenced via dependencies
	 * 
	 * @param current
	 * @return
	 */
	public static EList<Classifier> getTypesViaDependencies(Classifier current) {
		EList<Classifier> classifiers = new UniqueEList<Classifier>();

		for(DirectedRelationship relationship : current.getSourceDirectedRelationships()) {
			if(relationship instanceof Dependency) {
				if(relationship.getTargets().size() > 0) {
					// there should always be at least one element in the target
					// list and it should be a classifier, but better check.
					Element element = relationship.getTargets().get(0);
					if(element instanceof Classifier) {
						classifiers.add((Classifier)element);
					}
				}
			}
		}
		return classifiers;
	}

	/**
	 * Return a list of classifiers that are referenced via all kinds of relations except
	 * dependencies
	 * 
	 * @param current
	 * @return
	 */
	public static EList<Classifier> getTypesViaRelationshipsNoDeps(Classifier current) {
		EList<Classifier> classifiers = new UniqueEList<Classifier>();

		for(DirectedRelationship relationship : current.getSourceDirectedRelationships()) {
			if(!(relationship instanceof Dependency)) {
				if(relationship.getTargets().size() > 0) {
					// there should always be at least one element in the target
					// list and it should be a classifier, but better check.
					Element element = relationship.getTargets().get(0);
					if(element instanceof Classifier) {
						classifiers.add((Classifier)element);
					}
				}
			}
		}
		return classifiers;
	}

	
	/**
	 * Return the qualified name of a named element, but use "_" instead of "::" as separator
	 * 
	 * @param ne
	 *        a named element
	 * @return the fully qualified name with "_" as separator character
	 */
	public static String getFullName(NamedElement ne) {
		return ne.getQualifiedName().replace("::", "_"); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * return the full name in upper case
	 * 
	 * @param ne
	 * @return
	 */
	public static String getFullNameUC(NamedElement ne) {
		return ne.getQualifiedName().replace("::", "_").toUpperCase(); //$NON-NLS-1$ //$NON-NLS-2$
	}

	
	/**
	 * Retrieve the comments associated with an element
	 * TODO: check whether comment's annotated element link belongs to element in question
	 * @param element
	 * @return
	 */
	public static String getComments(Element element) {
		String commentText = ""; //$NON-NLS-1$
		for(Comment comment : element.getOwnedComments()) {
			// remove eventual CRs (avoid confusion in Acceleo template which adds " *" after line breaks)
			commentText += cleanCR(comment.getBody());
		}
		return commentText;
	}

	/**
	 * Return a list of dependent package (the list of dependent
	 * elements filtered for packages)
	 * 
	 * @param pkg
	 * @return
	 */
	public static EList<Package> getUsedPackages(Package pkg) {
		EList<Package> result = new UniqueEList<Package>();
		for(Element depElement : pkg.getClientDependencies()) {
			if(depElement instanceof Package) {
				result.add((Package)depElement);
			}
		}
		return result;
	}

	/**
	 * Return a list of dependent classifiers (the list of dependent
	 * elements filtered for classifiers)
	 * 
	 * @param pkg
	 * @return
	 */
	public static EList<Classifier> getUsedClassifiers(Classifier cls) {
		EList<Classifier> result = new BasicEList<Classifier>();
		for(Element depElement : cls.getClientDependencies()) {
			if(depElement instanceof Classifier) {
				result.add((Classifier)depElement);
			}
		}
		return result;
	}

	/**
	 * Return the qualified name of a package, but use "/" instead of "::" as separator
	 * 
	 * @param pkg
	 * @return
	 */
	public static String getFullPath(Package pkg) {
		return pkg.getQualifiedName().replace("::", "/");  //$NON-NLS-1$//$NON-NLS-2$
	}

	/**
	 * Is a certain stereotype applied?
	 * 
	 * @param element
	 * @param stereotype
	 *        fully qualified stereotype name
	 * @return
	 */
	public static boolean hasStereotype(Element element, String stereotName) {
		return element.getAppliedStereotype(stereotName) != null;
	}

	/**
	 * Is a certain stereotype applied?
	 * 
	 * @param element
	 * @param stereotype
	 *        fully qualified stereotype name
	 * @return
	 */
	public static boolean hasStereotype(Element element, java.lang.Class<? extends EObject> clazz) {
		for(EObject stereoApplication : element.getStereotypeApplications()) {
			// check whether the stereotype is a super-class of the passed parameter clazz
			if(clazz.isAssignableFrom(stereoApplication.getClass())) {
				return true;
			}
		}
		return false;
	}


	/**
	 * Is a certain stereotype applied?
	 * In case of Java, we use the class above (without the A) prefix. In case of Acceleo, a stereotype
	 * such as C_Cpp::Include is passed as EClass and we therefore use this operation from Acceleo.
	 * 
	 * @param element
	 * @param definition The eClass associated with the stereotype name (its definition)
	 * @return
	 */
	public static boolean hasStereotypeA(Element element, EClass definition) {
		if(element == null) {
			// make query more robust
			return false;
		}
		for(EObject stereoApplication : element.getStereotypeApplications()) {
			// check whether the stereotype application has the right eClass
			if(stereoApplication.eClass() == definition) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Verify if an Element or its parent Elements have a stereotype. Pass the class associated with a stereotype
	 * 
	 * @param elt
	 *        Element used.
	 * @param clazz
	 * 		  the class associated with a stereotype in a static profile
	 * 
	 * @return true if found. false otherwise
	 */
	public static boolean hasStereotypeTree(Element elt, java.lang.Class<? extends EObject> clazz)
	{

		if(hasStereotype(elt, clazz)) {
			return true;
		}
		else {
			Element owner = elt.getOwner();
			if (owner != null) {
				return hasStereotypeTree(owner, clazz);
			}
			else {
				return false;
			}
		}
	}


	/**
	 * Verify if an Element or its parent Elements have a stereotype. Pass the definition of the stereotype
	 * 
	 * @param elt
	 *        Element used.
	 * @param definition
	 *        The stereotype definition
	 * @return true if found. false otherwise
	 */
	public static boolean hasStereotypeTree(Element elt, EClass definition)
	{
		Element owner;

		if(hasStereotypeA(elt, definition))
			return true;
		else if((owner = elt.getOwner()) != null)
			return hasStereotypeTree(owner, definition);
		else
			return false;
	}


	/**
	 * return the first occurrence of a stereotype application in the ownership tree
	 * 
	 * @param elt an element
	 * @param definition the definition of a stereotype (its eClass)
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T extends EObject> T getApplicationTree(Element elt, java.lang.Class<T> clazz)
	{
		EObject application = UMLUtil.getStereotypeApplication(elt, clazz);
		if(application != null) {
			return (T) application;
		}
		else {
			Element owner = elt.getOwner();
			if (owner != null) {
				return getApplicationTree(owner, clazz);
			}
			else {
				return null;
			}
		}
	}


	/**
	 * return the first occurrence of a stereotype application in the ownership tree
	 * Variant of @see getApplicationTree that is useful for Acceleo
	 * @param elt an element
	 * @param definition the definition of a stereotype (its eClass)
	 * @return
	 */
	public static EObject getApplicationTreeA(Element elt, EClass definition)
	{
		EObject application = getApplicationA(elt, definition);
		if(application != null) {
			return application;
		}
		else {
			Element owner = elt.getOwner();
			if (owner != null) {
				return getApplicationTreeA(owner, definition);
			}
			else {
				return null;
			}
		}
	}
	

	/**
	 * Return a stereotype application when given the eClass of that application.
	 * In case of Java, we use the class above (without the A) prefix. In case of Acceleo, a stereotype
	 * such as C_Cpp::Include is passed as EClass and we therefore use this operation from Acceleo.

	 * @param element
	 *        the UML model element
	 * @param eClass
	 *        the eClass of the stereotype application
	 * @return
	 */
	public static EObject getApplicationA(Element element, EClass eClass) {
		for(EObject stereoApplication : element.getStereotypeApplications()) {
			// check whether the stereotype is an instance of the passed parameter clazz
			if(stereoApplication.eClass() == eClass) {
				return stereoApplication;
			}
		}
		return null;
	}

	
	/**
	 * @param operation
	 *        the operation
	 * @param selectedLanguage
	 *        the selected language
	 * @return Return the first body of a selected language that is provided by
	 *         one of the operation's methods
	 */
	public static String getBody(Operation operation, String selectedLanguage) {
		for(Behavior behavior : operation.getMethods()) {
			if(behavior instanceof OpaqueBehavior) {
				return getBodyFromOB((OpaqueBehavior) behavior, selectedLanguage);
			}
		}
		return ""; //$NON-NLS-1$
	}
	
	
	/**
	 * @param ob
	 *        an opaque behavior
	 * @param selectedLanguage
	 *        the selected language
	 * @return Return the first body of a selected language that is provided by
	 *         one of the operation's methods
	 */
	public static String getBodyFromOB(OpaqueBehavior ob, String selectedLanguage) {
		Iterator<String> bodies = ob.getBodies().iterator();
		for(String language : ob.getLanguages()) {
			// additional sanity check: number of languages and number of bodies should be synchronized,
			// 	but there is no guarantee that this is the case 
			if (bodies.hasNext()) {
				String body = bodies.next();
				if(language.equals(selectedLanguage)) {
					// additional "\r" confuses Acceleo
					return cleanCR(body);
				}
			}
		}
		return ""; //$NON-NLS-1$
	}
	
	/**
	 * Remove <CR> from a String. These confuse Acceleo's indentation
	 * @param str
	 * @return
	 */
	public static String cleanCR(String str) {
		return str.replace("\r", ""); //$NON-NLS-1$ //$NON-NLS-2$
	}
	
	
	/**
	 * Avoid null strings, i.e. replace null strings by empty strings
	 * 
	 * @param str
	 * @return
	 */
	public static String maskNull(String str) {
		if(str == null) {
			return ""; //$NON-NLS-1$
		}
		return str;
	}
	
	/**
	 * Return the relative path of ne2 as seen from ne1
	 * (might not always be useful, if includes are always done from a common root)
	 *
	 * @param ne1 a named element
	 * @param ne2 a named element
	 * @return
	 */
	public static String getRelativePath(NamedElement ne1, NamedElement ne2) {
		// get common prefix
		EList<Namespace> ne1namespaces = ne1.allNamespaces();
		String path = "";
		for (Namespace ns : ne2.allNamespaces()) {
			if (ne1namespaces.contains(ns)) {
				// ns is a common prefix
				return ne2.getName();
			}
			path += "../";
		}
		return null;
	}
	
	/**
	 * Return the type of a behavior, i.e. the type of the first parameter with
	 * "return" direction
	 * @param behavior a behavior
	 * @return the associated type
	 */
	public static Parameter returnResult(Behavior behavior) {
		for (Parameter parameter : behavior.getOwnedParameters()) {
			if (parameter.getDirection() == ParameterDirectionKind.RETURN_LITERAL) {
				return parameter;
			}
		}
		return null;
	}
}
