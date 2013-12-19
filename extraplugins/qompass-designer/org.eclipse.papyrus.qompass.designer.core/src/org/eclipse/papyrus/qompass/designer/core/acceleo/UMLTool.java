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
 *  Christophe JOUVRAY
 *
 *****************************************************************************/

package org.eclipse.papyrus.qompass.designer.core.acceleo;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.papyrus.C_Cpp.External;
import org.eclipse.papyrus.C_Cpp.NoCodeGen;
import org.eclipse.papyrus.C_Cpp.Typedef;
import org.eclipse.papyrus.uml.tools.utils.StereotypeUtil;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.InterfaceRealization;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Relationship;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLUtil;


/**
 * Collection of utility functions. In contrast to core.Utils, it is chiefly used by Acceleo
 * scripts
 * 
 * @author ansgar
 * 
 */

public class UMLTool {

	private static final String UNDERSCORE = "_"; //$NON-NLS-1$

	/**
	 * @param operation
	 * @return all in and inout parameters of an operation
	 */
	public static EList<Parameter> parametersInInout(Operation operation) {
		EList<Parameter> list = new BasicEList<Parameter>();
		for(Parameter parameter : operation.getOwnedParameters()) {
			if((parameter.getDirection().getValue() == ParameterDirectionKind.IN) ||
				(parameter.getDirection().getValue() == ParameterDirectionKind.INOUT)) {
				list.add(parameter);
			}
		}
		return list;
	}

	/**
	 * @param operation
	 * @return all out, inout and return parameters of an operation
	 */
	public static EList<Parameter> parametersOutInout(Operation operation) {
		EList<Parameter> list = new BasicEList<Parameter>();
		for(Parameter parameter : operation.getOwnedParameters()) {
			if((parameter.getDirection().getValue() == ParameterDirectionKind.OUT) ||
				(parameter.getDirection().getValue() == ParameterDirectionKind.RETURN) ||
				(parameter.getDirection().getValue() == ParameterDirectionKind.INOUT)) {
				list.add(parameter);
			}
		}
		return list;
	}

	/**
	 * @param operation
	 * @return all non-return parameters of an operation
	 */
	public static EList<Parameter> parametersNonRet(Operation operation) {
		EList<Parameter> list = new BasicEList<Parameter>();
		for(Parameter parameter : operation.getOwnedParameters()) {
			if(parameter.getDirection().getValue() != ParameterDirectionKind.RETURN) {
				list.add(parameter);
			}
		}
		return list;
	}

	/**
	 * A small helper function that makes names compliant with variable
	 * names in programming languages such as C++ or Java
	 * Unlike varName2, replace scoping signs as well
	 */
	public static String varName(NamedElement element) {
		return varName(element.getName());
	}

	/**
	 * A small helper function that makes names compliant with variable
	 * names in programming languages such as C++ or Java
	 * Unlike varName2, replace scoping signs as well
	 */
	public static String varName(String umlName) {
		umlName = umlName.replace(".", UNDERSCORE);  //$NON-NLS-1$
		umlName = umlName.replace(Namespace.SEPARATOR, UNDERSCORE);
		return varName2(umlName);
	}

	/**
	 * A small helper function that makes names compliant with variable
	 * names in programming languages such as C++ or Java
	 * TODO: obviously, it is not complete (e.g. in case of "$", national characters ("ä", "é", ...) , ...)
	 */
	public static String varName2(NamedElement element) {
		String umlName = element.getName();
		return varName2(umlName);
	}

	/**
	 * Like varName, but does not replace "." with "_"
	 * 
	 * @param umlName
	 * @return
	 */
	public static String varName2(String umlName) {
		umlName = umlName.replace(" ", UNDERSCORE); //$NON-NLS-1$
		umlName = umlName.replace("-", UNDERSCORE); //$NON-NLS-1$
		umlName = umlName.replace("+", UNDERSCORE); //$NON-NLS-1$
		umlName = umlName.replace("?", UNDERSCORE); //$NON-NLS-1$
		return umlName;
	}

	public static EList<Namespace> usedNamespaces(NamedElement element) {
		EList<Namespace> list = new BasicEList<Namespace>(element.allNamespaces());

		if(list.size() < 1) {
			return null;
		}
		list.remove(list.size() - 1); // remove last element (top-level)
		return list;
	}

	/**
	 * Return a sequence of namespaces for a given element, starting from the "bottom"
	 * one, i.e. the one in which the element is contained. It will end before the
	 * searchNS namespace is reached. Returns null, if the element is not contained
	 * within the search namespace.
	 * 
	 * @param element
	 * @param searchNS
	 * @return
	 */
	public static EList<Namespace> relativePath(Element element, Namespace searchNS) {
		EList<Namespace> pathList = new BasicEList<Namespace>();
		Element owner = element.getOwner();
		if(!(owner instanceof Namespace)) {
			// happens, if element is contained in a template signature
			return null;
		}
		Namespace ns = (Namespace)owner;
		while(ns != null) {
			if(ns == searchNS) {
				return pathList;
			}
			pathList.add(ns);

			ns = (Namespace)ns.getOwner();
		}
		return null;
	}

	/**
	 * This method returns all types that are referenced by a classifier. This includes
	 * attribute types, types within operations as well as inherited types.
	 * This is useful to generate the #includes
	 * (which is used by the Acceleo code within the packaging plugin)
	 */
	public static EList<Classifier> getReferencedClassifiers(Classifier classifier) {
		EList<Classifier> list = new UniqueEList<Classifier>();
		list.addAll(classifier.parents());

		if(classifier instanceof Class) {
			// get classifiers referenced by attributes
			for(Operation operation : ((Class)classifier).getOwnedOperations()) {
				for(Parameter parameter : operation.getOwnedParameters()) {
					Type type = parameter.getType();
					if(type instanceof Classifier) {
						list.add((Classifier)type);
					}
				}
			}

			// get classifiers referenced by attributes
			for(Property attribute : ((Class)classifier).getOwnedAttributes()) {
				Type type = attribute.getType();
				if(type instanceof Classifier) {
					list.add((Classifier)type);
				}
			}
		}
		return list;
	}

	/**
	 * TODO: copy&paste from C++ generator (& specific for C++)
	 * 
	 * @param ne
	 * @return
	 */
	public static String cppQName(NamedElement ne) {
		if((StereotypeUtil.isApplied(ne, External.class)) || (StereotypeUtil.isApplied(ne, NoCodeGen.class))) {
			return ne.getName();
		} else {
			String qName = ne.getName();
			for(Namespace ns : ne.allNamespaces()) {
				if(!(ns instanceof Model)) {
					qName = ns.getName() + "::" + qName; //$NON-NLS-1$
				}
			}
			return qName;
		}
	}

	/**
	 * Return the name of a parameter. In case of a return parameter, always return the name
	 * "retValue". This is quite useful for marshalling operations (which need to assign a
	 * value to the return parameter, which is sometimes not initialized)
	 * 
	 * @param parameter
	 * @return
	 */
	public static String paramName(Parameter parameter) {
		if(parameter.getDirection().getValue() == ParameterDirectionKind.RETURN) {
			return "retValue"; //$NON-NLS-1$
		} else {
			return parameter.getName();
		}
	}

	/**
	 * Return the interface which owns an operation that is implemented by a class.
	 * Context: a class might implement several interfaces by defining their operations.
	 * The operation is useful in the context of state-machines: when a transition is triggered by
	 * the call of an operation of the class, we'd like to know which interceptor (for which interface)
	 * belongs to it (since the operations are enumerated within each interface).
	 * TOOD: move operation into state-chart java code
	 * 
	 * @param operation
	 * @return the interface which the operation belongs
	 */
	public static Interface implementsInterface(Operation operation) {
		Element owner = operation.getOwner();
		if(owner instanceof Class) {
			String name = operation.getName();
			EList<Type> types = new BasicEList<Type>();
			for(Parameter parameter : operation.getOwnedParameters()) {
				types.add(parameter.getType());
			}
			// loop over implemented realizations. Do not rely on FCM derivedElement information
			// as it might be missing on some models (it would point from an operation of the class
			// to the associated operation of the interface)
			for(InterfaceRealization ir : ((Class)owner).getInterfaceRealizations()) {
				// check for types to allow for overloading
				Operation candidate = ir.getContract().getOwnedOperation(name, null, types);
				if(candidate != null) {
					return ir.getContract();
				}
			}
		}
		else if(owner instanceof Interface) {
			return (Interface)owner;
		}
		return null;
	}

	/**
	 * Convenience function: Declare a dependency from source to destination. The function checks,
	 * if a dependency already exists to avoid double dependencies.
	 * 
	 * @param source
	 *        source type of the dependency
	 * @param dest
	 *        destination of the dependency
	 */
	public static void declareDependency(Type source, Type dest) {
		// check, if a relationship already exists
		for(Relationship dependency : source.getRelationships(UMLPackage.eINSTANCE.getDependency())) {
			if(((Dependency)dependency).getSuppliers().contains(dest)) {
				return;
			}
		}
		source.createDependency(dest);
	}

	/**
	 * Get the URI fragment of an element within your model
	 * Useful for transmitting model references
	 * 
	 * @param element
	 *        a UML element
	 * @return
	 */
	public static String fragment(Element element) {
		Resource resource = element.eResource();
		// TODO: use EcoreUtil getURI (InternalEObject) instead?

		if(resource instanceof XMLResource) {
			XMLResource xmlResource = (XMLResource)resource;
			return "\"" + xmlResource.getURIFragment(element) + "\"";  //$NON-NLS-1$//$NON-NLS-2$
		}
		return null;
	}

	/**
	 * Get the XML (URI) Id of an element within your model
	 * Useful for transmitting model references
	 * 
	 * @param element
	 *        a UML element
	 * @return
	 */
	public static String xmlID(Element element) {
		Resource resource = element.eResource();
		// TODO: use EcoreUtil getURI (InternalEObject) instead?

		if(resource instanceof XMLResource) {
			XMLResource xmlResource = (XMLResource)resource;
			return xmlResource.getID(element);
		}
		return null;
	}

	public static String getURI(Element element) {
		Resource resource = element.eResource();
		if(resource != null) {
			URI uri = resource.getURI();
			return uri.toString();
		}
		return null;
	}

	/**
	 * 
	 * TODO: Specific to C++
	 * 
	 * @param type
	 *        a type
	 * @return return the definition of a typedef, if the type has been defined via
	 *         the stereotype CppType of the Cpp profile
	 */
	public static String dereferenceTypedef(Type type) {
		if(type instanceof PrimitiveType) {
			Typedef cppType = UMLUtil.getStereotypeApplication(type, Typedef.class);
			if(cppType != null) {
				return cppType.getDefinition();
			}
		}
		return type.getQualifiedName();

	}

	public static String encodeID(String uri) {
		// _ becomes escape character. original _ is __, '-' becomes _M
		return uri.
				replace(UNDERSCORE, UNDERSCORE + UNDERSCORE).
				replace("-", "_M"); //$NON-NLS-1$ //$NON-NLS-2$
	}

	public static String decodeID(String encodedURI) {
		String result = ""; //$NON-NLS-1$
		for(int i = 0; i < encodedURI.length(); i++) {
			char c = encodedURI.charAt(i);
			if(c == '_') {
				char next = encodedURI.charAt(i + 1);
				if(next == 'M')
					result += '-';
				else if(next == '_')
					result += '_';
				i++;
			}
			else {
				result += c;
			}
		}
		return result;
	}
}
