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

package org.eclipse.papyrus.cpp.codegen.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.cpp.codegen.Constants;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.ClassifierTemplateParameter;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.ConnectableElementTemplateParameter;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.DirectedRelationship;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.LiteralBoolean;
import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.LiteralUnlimitedNatural;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.OpaqueBehavior;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.OperationTemplateParameter;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterableElement;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.TemplateSignature;
import org.eclipse.uml2.uml.Type;

import C_Cpp.ExternClass;
import C_Cpp.NoCodeGen;
import C_Cpp.Typedef;
import C_Cpp.Visibility;



/**
 * Some utilities: a set of static method for C++ code generator
 * Mainly "Template" related methods
 * Should probably be put in com.cea.utils in next release
 * 
 * @author wassim
 * 
 */
public class GenUtils {

	public static final String NL = System.getProperties().getProperty("line.separator");

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

	public static boolean isTemplateBoundElement(Classifier cl) {
		boolean result = false;
		EList<TemplateBinding> tb = cl.getTemplateBindings();
		if(tb != null) {
			Iterator<TemplateBinding> itb = tb.iterator();
			while(itb.hasNext()) {
				TemplateBinding currentTb = itb.next();
				result = currentTb.getBoundElement() == cl;
			}
		}
		return result;
	}

	public static Collection<TemplateParameter> getTemplateParameters(Classifier classifier) {

		Collection<TemplateParameter> params = new ArrayList<TemplateParameter>();
		TemplateSignature ts = classifier.getOwnedTemplateSignature();
		if(ts != null) {
			params.addAll(ts.getOwnedParameters());
		}

		return params;
	}

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
	 * Return a list of template parameters without type
	 * 
	 * @param classifier
	 * @return
	 */
	public static String getTemplateParametersWoType(Classifier classifier) {
		String tparamWoType = "";

		Iterator<TemplateParameter> it = GenUtils.getTemplateParameters(classifier).iterator();

		while(it.hasNext()) {
			TemplateParameter currentTParam = it.next();
			tparamWoType = tparamWoType + GenUtils.getName(currentTParam);

			if(it.hasNext()) {
				tparamWoType = tparamWoType + ", ";
			}
		}
		return tparamWoType;
	}

	/**
	 * The standard UML and MARTE libraries do not apply the cppType stereotype. Yet, we want to treat these
	 * types in an identical way, i.e. we use a typedef to the associated primitive C++ type
	 * 
	 * @param type
	 * @return
	 */
	public static String getStdtypes(PrimitiveType type) {
		Object owner = type.getOwner();
		String owningPkgName = "";
		if(owner instanceof Package) {
			owningPkgName = ((Package)owner).getName();
		}
		if(owningPkgName.equals("PrimitiveTypes") || // used in UML 2.4
		owningPkgName.equals("UMLPrimitiveTypes") || // used in UML < 2.4
		owningPkgName.equals("MARTE_PrimitivesTypes")) {
			String td = null;
			String name = type.getName();

			if(name.equals("Boolean")) {
				td = "bool";
			} else if(name.equals("Integer")) {
				td = "int";
			} else if(name.equals("String")) {
				td = "const char *";
			} else if(name.equals("Unlimited Natural")) {
				td = "unsigned long";
			}
			if(td != null) {
				return "typedef " + td + " " + name + ";";
			}
			// else unknown within UMLPrimitiveTypes, treat in standard way
		}

		return "";
	}

	/**
	 * Gives the type of the parameter or null for void.
	 * (used in particular in the context of template parameters
	 * TODO: redundant with qualifiedName??)
	 * 
	 * @return the template type formated as string
	 */
	public static String getType(TemplateParameter templateParam) {
		String type = "", name = "";

		// Retrieve name of the ParameteredElement (when possible = it is a NamedElement
		ParameterableElement pElt = templateParam.getParameteredElement();
		if((pElt != null) && (pElt instanceof NamedElement)) {
			name = ((NamedElement)pElt).getName();
			if(templateParam instanceof ClassifierTemplateParameter) {
				type = "class";
			} else if(templateParam instanceof OperationTemplateParameter) {
				type = "";
			} else if(templateParam instanceof ConnectableElementTemplateParameter) {
				type = "";
			} else {// uml2TemplateParameter instanceof TemplateParameter
				if(pElt instanceof LiteralInteger) {
					type = "int";
				} else if(pElt instanceof LiteralString) {
					type = "String";
				} else if(pElt instanceof LiteralBoolean) {
					type = "Boolean";
				} else if(pElt instanceof LiteralUnlimitedNatural) {
					type = "UnlimitedNatural";
				} else {
					type = pElt.eClass().getName();
				}
			}
		} else {
			name = "undefined";
		}

		// Retrieve the name of the type
		/*
		 * if (templateParam instanceof ClassifierTemplateParameter) {
		 * type = "class";
		 * } else
		 * {
		 * if ((pElt != null) && (pElt instanceof LiteralInteger)) {
		 * type = "int";
		 * } else {
		 * // Need test the other cases (LiteralBoolean ? LiteralString ?)
		 * type = "undefined";
		 * }
		 * }
		 */

		return (type + " " + name);
	}

	public static String getName(TemplateParameter templateParam) {
		String name = "";
		ParameterableElement pElt = templateParam.getParameteredElement();
		if((pElt != null) && (pElt instanceof NamedElement)) {
			name = ((NamedElement)pElt).getName();
		} else {
			name = "undefined";
		}

		return name;
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
	 * Retrieve the operations in the current class then for each
	 * operation it finds the parameters that have a class type
	 * 
	 * @param current
	 *        Class on which the attributes are searched
	 * @return collection of classes which are the types of the operations parameters
	 */
	public static EList<Classifier> getIncludesFromOperations(Classifier current) {
		EList<Classifier> result = new UniqueEList<Classifier>();
		Iterator<Operation> operations = current.getOperations().iterator();
		while(operations.hasNext()) {
			Operation op = operations.next();
			Iterator<Parameter> i = op.getOwnedParameters().iterator();
			while(i.hasNext()) {
				Parameter param = i.next();
				Type type = param.getType();
				if(type instanceof Classifier) {
					Classifier paramType = (Classifier)type;
					result.add(paramType);
				}
			}
		}
		return result;
	}

	public static EList<Interface> getImplementedInterfaces(Class current) {
		EList<Interface> interfaces = new UniqueEList<Interface>();
		Iterator<Interface> interfacesIt = current.getImplementedInterfaces().iterator();
		Interface currentInterface;
		while(interfacesIt.hasNext()) {
			currentInterface = (Interface)interfacesIt.next();
			interfaces.add(currentInterface);
		}
		return interfaces;
	}

	/**
	 * Return a list of classifiers that are referenced by relationships, i.e.
	 * dependencies or associations
	 * 
	 * @param current
	 * @return
	 */
	public static EList<Classifier> getRelationships(Classifier current) {
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
	public static EList<Classifier> getDependencies(Classifier current) {
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
	public static EList<Classifier> getRelationshipsNoDeps(Classifier current) {
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
		return ne.getQualifiedName().replace("::", "_");
	}

	/**
	 * return the full name in upper case
	 * 
	 * @param ne
	 * @return
	 */
	public static String getFullNameUC(NamedElement ne) {
		return ne.getQualifiedName().replace("::", "_").toUpperCase();
	}

	/**
	 * Return a C++ namespace definition for a named element
	 * 
	 * @param ne
	 *        a named element
	 * @return a C++ namespace definition for a named element
	 */
	public static String getNamespace(NamedElement ne) {
		String namespace = "";
		for(Namespace ns : ne.allNamespaces()) {
			if(ns.getOwner() != null) {
				String nsName = ns.getName();
				if(!namespace.equals("")) {
					nsName += "::";
				}
				namespace = nsName + namespace;
			}
		}
		if(!namespace.equals("")) {
			namespace = "\n" + "using namespace " + namespace + ";\n";
		}
		return namespace;
	}

	/**
	 * Return a C++ open-namespace definition for a named element
	 * 
	 * @param ne
	 *        a named element
	 * @return a C++ open-namespace definition for a named element
	 */
	public static String openNS(NamedElement ne) {
		String openNS = "";
		currentNS = ne.getNamespace();
		if(ne instanceof Package) {
			openNS = "namespace " + ne.getName() + " {\n";
		}
		for(Namespace ns : ne.allNamespaces()) {
			if(ns.getOwner() != null) {
				openNS = "namespace " + ns.getName() + " {\n" + openNS;
			}
		}
		return openNS;
	}

	/**
	 * Return a C++ close-namespace definition for a named element
	 * 
	 * @param ne
	 *        a named element
	 * @return a C++ close-namespace definition for a named element
	 */
	public static String closeNS(NamedElement ne) {
		String closeNS = "";
		if(ne instanceof Package) {
			closeNS = "} // of namespace " + ne.getName() + "\n";
		}
		for(Namespace ns : ne.allNamespaces()) {
			if(ns.getOwner() != null) {
				closeNS += "} // of namespace " + ns.getName() + "\n";
			}
		}
		return closeNS;
	}

	/**
	 * Return the qualified name of a named element or "undefined", if it does not exist.
	 * 
	 * @param ne
	 * @return
	 */
	public static String qualifiedName(NamedElement ne) {
		if(ne == null) {
			return Constants.undefinedType;
		}
		Object owner = ne.getOwner();
		String owningPkgName = "";
		if(owner instanceof Package) {
			owningPkgName = ((Package)owner).getName();
		}
		if((hasStereotype(ne, ExternClass.class)) || (hasStereotype(ne, NoCodeGen.class))) {
			return ne.getName();
		} else if(owningPkgName.equals("AnsiCLibrary")) {
			// always use the short name for types within the ANSI C library
			return ne.getName();
		}

		String qName = ne.getName();
		if(currentNS == ne.getNamespace()) {
			// return simple name, if in current namespace
			return qName;
		}
		if(ne instanceof PrimitiveType) {
			if(!hasStereotype(ne, Typedef.class) && (getStdtypes((PrimitiveType)ne).length() == 0)) {
				// is a primitive type without further definition and not a standard primitive type
				// => assume that it is a external type without namespace
				return qName;
			}
		}

		for(Namespace ns : ne.allNamespaces()) {
			// don't add top-level
			if(ns.getOwner() != null) {
				qName = ns.getName() + "::" + qName;
			}
		}
		if(qName.contains("::")) {
			// is a qualified name => make path absolute
			return "::" + qName;
		} else {
			return qName;
		}
	}

	public static String getComments(Element element) {
		String commentText = "";
		for(Comment comment : element.getOwnedComments()) {
			// remove eventual CRs (avoid confusion in Acceleo template which adds " *" after line breaks)
			commentText += comment.getBody().replace("\r", "");
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
		EList<Package> result = new BasicEList<Package>();
		for(Element depElement : pkg.getClientDependencies()) {
			if(depElement instanceof Package) {
				result.add((Package)depElement);
			}
		}
		return result;
	}

	/**
	 * Return a list of dependent classes (the list of dependent
	 * elements filtered for classes)
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
		return pkg.getQualifiedName().replace("::", "/");
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
		EList<Stereotype> list = element.getAppliedStereotypes();
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
			// check whether the stereotype is a suopebclass of the passed parameter clazz
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
	 * @param stereotype
	 *        fully qualified stereotype name
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
	 * Is a certain stereotype applied?
	 * 
	 * @param element
	 * @param stereotype
	 *        fully qualified stereotype name
	 * @return
	 */
	public static void setStereotype(Element element, String stereotName, boolean apply) {
		Stereotype stereotype = element.getApplicableStereotype(stereotName);
		if(stereotype != null) {
			if(apply) {
				if(!element.isStereotypeApplied(stereotype)) {
					element.applyStereotype(stereotype);
				}
			} else {
				if(element.isStereotypeApplied(stereotype)) {
					element.unapplyStereotype(stereotype);
				}
			}
		}
	}

	/**
	 * This method returns the stereotype applied to a certain element when given its name.
	 * Returns null, if a stereotype of that name does not exist.
	 * This function is quite similar to getAppliedStereotype, the difference is that it
	 * is not based on fully qualified name.
	 */
	public static String getTaggedValue(Element element, String stereo_name, String attrib_name) {
		Stereotype stereotype = element.getAppliedStereotype(stereo_name);
		if(stereotype == null) {
			return "";
		}
		Object value = element.getValue(stereotype, attrib_name);
		if(value == null) {
			return "";
		}

		if(value instanceof NamedElement) {
			return ((NamedElement)value).getName();
		} else if(value instanceof String) {
			return (String)value;
		} else {
			return value.toString();
		}
	}

	/**
	 * This method returns the stereotype applied to a certain element when given its name.
	 * Returns null, if a stereotype of that name does not exist.
	 * This function is quite similar to getAppliedStereotype, the difference is that it
	 * is not based on fully qualified name.
	 */
	public static void setTaggedValue(Element element, String stereo_name, String attrib_name, Object value) {
		Stereotype stereotype = element.getAppliedStereotype(stereo_name);
		if(stereotype != null) {
			element.setValue(stereotype, attrib_name, value);
		}
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
						// additional "\r" confuse Acceleo
						return body.replace("\r", "");
					}
				}
			}
		}
		return "";
	}
	
	/**
	 * Return the C++ visibility (on generalizations) in text form. Return public, if no stereotype
	 * visibility exists
	 *
	 * @param element
	 * @return
	 */
	public static String getGeneralizationVisibility(Element element) {
		// get visibility and target name
		Visibility cppVisibility = GenUtils.getApplication(element, Visibility.class);
		if(cppVisibility != null) {
			return cppVisibility.getValue();
		} else {
			return "public";
		}
	}

	/**
	 * Avoid null strings, i.e. replace null strings by empty strings
	 * 
	 * @param str
	 * @return
	 */
	public static String maskNull(String str) {
		if(str == null) {
			return "";
		}
		return str;
	}

	private static Namespace currentNS;
}
