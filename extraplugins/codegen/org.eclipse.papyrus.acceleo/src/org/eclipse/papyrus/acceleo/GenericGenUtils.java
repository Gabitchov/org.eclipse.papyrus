/*******************************************************************************
 * Copyright (c) 2006 - 2012 CEA LIST.
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
import org.eclipse.uml2.uml.OpaqueBehavior;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterableElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.TemplateSignature;
import org.eclipse.uml2.uml.Type;


/**
 * Some utilities: a set of static methods for Acceleo based code generation
 * 
 * @author wassim
 * 
 */
public class GenericGenUtils {

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
	 * 
	 * @param classifier
	 * @return
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
	public static EList<Classifier> getTypesViaAttributesk(Classifier current) {
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
	 * Retrieve the operations in the current class then for each
	 * operation it finds the parameters that have a class type
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
	 * 
	 * @param element
	 * @param eClass The eClass associated with the stereotype name
	 * @return
	 */
	public static boolean hasStereotypeA(Element element, EClass eClass) {
		if(element == null) {
			// make query more robust
			return false;
		}
		for(EObject stereoApplication : element.getStereotypeApplications()) {
			// check whether the stereotype application has the right eClass
			if(stereoApplication.eClass() == eClass) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Return the stereotype application by passing an element of the static profile
	 * 
	 * @param element
	 *        the UML model element
	 * @param clazz
	 *        the class of an element of a static profile. Compatible sub-types will be returned as well
	 * @return the stereotype application or null
	 */
	@SuppressWarnings("unchecked")
	public static <T extends EObject> T getApplication(Element element, java.lang.Class<T> clazz) {
		for(EObject stereoApplication : element.getStereotypeApplications()) {
			// check whether the stereotype is an instance of the passed parameter clazz
			if(clazz.isInstance(stereoApplication)) {
				return (T)stereoApplication;
			}
		}
		return null;
	}

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
				OpaqueBehavior ob = (OpaqueBehavior)behavior;
				Iterator<String> bodies = ob.getBodies().iterator();
				for(String language : ob.getLanguages()) {
					String body = bodies.next();
					if(language.equals(selectedLanguage)) {
						// additional "\r" confuses Acceleo
						return cleanCR(body);
					}
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
}
