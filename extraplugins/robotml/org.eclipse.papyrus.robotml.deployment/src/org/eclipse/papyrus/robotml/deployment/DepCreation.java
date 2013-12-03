/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia Dhouib (CEA LIST) saadia.dhouib@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.robotml.deployment;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.Node;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.StructuralFeature;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;

public class DepCreation {

	private static Map<Object, Integer> map;

	/**
	 * Create a slot and add an instance value associated with a part instance
	 * specification.
	 * 
	 * @param is
	 *        the instance specification for which a slot should be created
	 * @param partIS
	 *        the instance specification associated with the slot (to be
	 *        precise with slot's instance value)
	 * @param part
	 *        the part associated with the slot, i.e. its defining feature
	 * @return The created slot
	 */
	public static Slot createSlot(InstanceSpecification is,
		InstanceSpecification partIS, Property part) {
		// the instance specification of the composite has a slot for each part
		// and it points
		// to the instance specification associated with the part.
		Slot slot = is.createSlot();
		slot.setDefiningFeature(part);

		InstanceValue iv = (InstanceValue)slot.createValue(null, null,
			UMLPackage.eINSTANCE.getInstanceValue());
		iv.setInstance(partIS);
		return slot;

	}

	/**
	 * Create a Slot and a value for a configuration attribute
	 * 
	 * @param attribute
	 */
	public static Slot createSlotForConfigProp(InstanceSpecification is,
		Property attribute) {

		Slot slot = is.createSlot();
		slot.setDefiningFeature(attribute);
		// For primitive types, the UML type does not provide sufficient
		// information to decide
		// whether it is a string or a numerical value. In case of the C++
		// profile, primitive
		// UML types denote a language specific type, but we want to avoid C++
		// specific code, if
		// possible.
		// => pragmatic solution: use LiteralString as default, unless a check
		// for some known numerical
		// primitive types holds (in particular the UML as well as Qompass CORBA
		// types)
		// In addition, string values are not automatically quoted, i.e. it is
		// possible to enter e.g.
		// a float value as a string expression (it also means that a "real"
		// string value must be quoted
		// by the user).
		Type type = attribute.getType();
		if(type != null) {
			String name = type.getName();
			String qname = type.getQualifiedName();
			if(name.equals("Integer") ) {
				slot.createValue("value for " + attribute.getName(), type,
					UMLPackage.eINSTANCE.getLiteralInteger());
			} else if(name.equals("Boolean")) {
				slot.createValue("value for " + attribute.getName(), type,
					UMLPackage.eINSTANCE.getLiteralBoolean());
			} else {
				slot.createValue("value for " + attribute.getName(), type,
					UMLPackage.eINSTANCE.getLiteralString());
			}
		}
		return slot;
	}

	/**
	 * Create a string slot and a value for a configuration attribute
	 * 
	 * @param attribute
	 */
	public static Slot createStringSlotForConfigProp(InstanceSpecification is,
		Property attribute) {

		Slot slot = is.createSlot();
		slot.setDefiningFeature(attribute);
		Type type = attribute.getType();
		if(type != null) {
			slot.createValue("value for " + attribute.getName(), type,
				UMLPackage.eINSTANCE.getLiteralString());
		}
		return slot;
	}

	/**
	 * create a deployment plan, i.e. a set of instances that correspond to an
	 * implementation which is potentially a composite. In case of the latter,
	 * this function is called recursively to create deployment plans for the
	 * parts. Since a composite implementation may optionally specify only the
	 * type of parts (not the concrete implementation), this function also
	 * supports that a type is passed. In this case, an implementation is
	 * automatically assigned.
	 * 
	 * @param cdp
	 *        the deployment plan (package) in which to create instances
	 * @param typeOrImplem
	 *        the type
	 * @param nane
	 *        the name of the instance
	 * @param createSlotsForConfigValues
	 *        if true, create slots for configuration values
	 */
	public static InstanceSpecification createDepPlan(Package cdp,
		Class typeOrImplem, String name, boolean createSlotsForConfigValues)
		throws TransformationException
	{
		return createDepPlan(cdp, typeOrImplem, name, createSlotsForConfigValues, new Stack<Classifier>());
	}

	public static InstanceSpecification createDepPlan(Package cdp,
		Class typeOrImplem, String name, boolean createSlotsForConfigValues, Stack<Classifier> visitedClassifiers)
		throws TransformationException
	{
		// create an instance specification for the composite
		if(visitedClassifiers.contains(typeOrImplem)) {
			String path = "";
			for(Classifier cl : visitedClassifiers) {
				if(path.length() > 0) {
					path += ", ";
				}
				path += cl.getName();
			}
			path += ", " + typeOrImplem.getName();
			throw new TransformationException("Class \"" + typeOrImplem.getQualifiedName() +
				"\" is referenced in a circle! Thus, an infinite number of instance specifications would be required.\n\n" +
				"recursion path: " + path);
		}
		visitedClassifiers.push(typeOrImplem);

		InstanceSpecification is = (InstanceSpecification)
			cdp.createPackagedElement(name, UMLPackage.eINSTANCE.getInstanceSpecification());

		// TODO: hack, could be named differently.
		if(name.equals("mainInstance")) {
			DepUtils.setMainInstance(cdp, is);
		}

		Class implementation = null;

		// treat HW architecture or nodes as implementations
		if(Utils.isCompImpl(typeOrImplem)
			|| typeOrImplem instanceof Node) {
			// implementation is known => must be able to do this.
			if(typeOrImplem instanceof Class) {
				implementation = (Class)typeOrImplem;
			}
		}

		if(!(implementation instanceof Class)) {
			throw new TransformationException(
				"cannot find suitable implementation for instance <" + name
					+ "> (given type <" + typeOrImplem.getName() + ">)");
		}
		// else implementation is instance of Class (and not null)

		is.getClassifiers().add(implementation);
		// add connector and container implementations
		

		

		for(Property attribute : implementation.getAllAttributes()) {
			// loop over all attributes (not only parts, since we need to
			// capture singletons)
			if(attribute instanceof Port) {
				continue;
			}
			Type type = attribute.getType();

			if(Utils.isComposition(attribute)) {
				// composition, attribute is a part
				if(((type instanceof Class) && Utils.isComponent((Class)type)) || type instanceof Node) {
					Class cl = (Class)type;

					// hack: ad-hoc replication support. Better solution via design patterns
					int upper = attribute.getUpper();
					String infix = "";
					
					// TODO: check validation constraints
					for(int i = 0; i < upper; i++) {
						String partName = name + "." + attribute.getName();
						if(upper > 1) {
							partName += "_" + infix + i;
						}
						InstanceSpecification partIS = createDepPlan(cdp, cl,
							partName, createSlotsForConfigValues, visitedClassifiers);

						createSlot(is, partIS, attribute);
					}
				} 
			} else if(type instanceof Class) {
				// no composition - only create slot, if a singleton
				// (otherwise, it's not clear with which instance the slot
				// should be associated)
				Log.log(Log.INFO_MSG, Log.DEPLOYMENT,
					"DepCreation.createDepPlan: " + type.getQualifiedName());
//				if(Utils.isSingleton((Class)type)) {
//					// is a singleton - exactly one instance exists
//					// use a common instance prefix for singletons
//					String partName = "singleton_" + attribute.getName();
//					PackageableElement pe = cdp.getPackagedElement(partName);
//
//					if(pe instanceof InstanceSpecification) {
//						// instance specification for singleton exists already
//						Slot slot = createSlot(is, (InstanceSpecification)pe,
//							attribute);
//						slot.setDefiningFeature(attribute);
//					} else if(type instanceof Class) {
//						// instance specification for singleton does not exist
//						// => create
//						// [case that a non-instance specification with the name
//						// <partName> exists already
//						// is not handled]
//						InstanceSpecification partIS = createDepPlan(cdp,
//							(Class)type, partName, createSlotsForConfigValues, visitedClassifiers);
//						Slot slot = createSlot(is, partIS, attribute);
//						slot.setDefiningFeature(attribute);
//					}
//				}
			} else if(type == null) {
				throw new TransformationException("type of attribute \""
					+ attribute.getName() + "\" within class \""
					+ implementation.getName() + "\" is not defined");
			}
		}
		visitedClassifiers.pop();
		return is;
	}

	

	/**
	 * create a deployment plan, i.e. a set of instances that correspond to an
	 * implementation which is potentially a composite. In case of the latter,
	 * this function is called recursively to create deployment plans for the
	 * parts. Since a composite implementation may optionally specify only the
	 * type of parts (not the concrete implementation), this function also
	 * supports that a type is passed. In this case, an implementation is
	 * automatically assigned.
	 * 
	 * @param cdp
	 *        the deployment plan (package) in which to create instances
	 * @param typeOrImplem
	 *        the type
	 * @param nane
	 *        the name of the instance
	 * @param createSlotsForConfigValues
	 *        if true, create slots for configuration values
	 */
	public static InstanceSpecification createPlatformInstances(
		Package platform, Class implementation, String name)
		throws TransformationException {
		// create an instance specification for the composite
		InstanceSpecification is = null;
		if(name != null) {
			// donn't create instance specification for root element (detectable via the empty name)
			is = (InstanceSpecification)platform.createPackagedElement(name,
				UMLPackage.eINSTANCE.getInstanceSpecification());
			is.getClassifiers().add(implementation);
		}

		// add connector and container implementations

		for(Property attribute : implementation.getAllAttributes()) {
			// loop over all attributes (not only parts, since we need to
			// capture singletons)
			if(attribute instanceof Port) {
				continue;
			}
			Type type = attribute.getType();

			if(Utils.isComposition(attribute)) {
				// composition, attribute is a part
				if(type instanceof Class) { // should be a node, but do not require it
					Class cl = (Class)type;

					// hack: ad-hoc replication support. Better solution via
					// Design patterns
					int upper = attribute.getUpper();
					String infix = "";
					// TODO: check validation constraints
					for(int i = 0; i < upper; i++) {
						// prefix with name, unless null
						String partName = (name != null) ? name + "." : "";
						partName += attribute.getName();
						if(upper > 1) {
							partName += "_" + infix + i;
						}
						InstanceSpecification partIS = createPlatformInstances(
							platform, cl, partName);

						if(is != null) {
							createSlot(is, partIS, attribute);
						}
					}
				} 
			}
		}
		return is;
	}

	/**
	 * Initialize the automatic values within a deployment plan - and the update
	 * eventual copies of these values.
	 * 
	 * @param is
	 *        the main instance of the deployment plan
	 */
	public static void initAutoValues(InstanceSpecification is) {
		map = new HashMap<Object, Integer>();
		initAutoValuesHelper(is);
		Stack<InstanceSpecification> isStack = new Stack<InstanceSpecification>();
		copyAutoValues(isStack, is);
	}

	/**
	 * Initialize the automatic values within a deployment plan.
	 * 
	 * @param is
	 *        the main instance of the deployment plan
	 */
	public static void initAutoValuesHelper(InstanceSpecification is) {
		for(Slot slot : is.getSlots()) {
			StructuralFeature sf = slot.getDefiningFeature();
			
		}
	}

	/**
	 * Initialize the automatic values within a deployment plan.
	 * 
	 * @param is
	 *        the main instance of the deployment plan
	 */
	public static void copyAutoValues(Stack<InstanceSpecification> isStack,
		InstanceSpecification is) {
		isStack.push(is);
		for(Slot slot : is.getSlots()) {
			StructuralFeature sf = slot.getDefiningFeature();
			if(sf == null) {
				// throw new TransformationException (is.getName() + " has a slot without defining feature");
				System.err.println(is.getName());
				break;
			}
		
			// recursion in case of values that are instance values
			for(ValueSpecification vs : slot.getValues()) {
				if(vs instanceof InstanceValue) {
					InstanceSpecification subIS = ((InstanceValue)vs).getInstance();
					if(subIS != null) {
						copyAutoValues(isStack, subIS);
					}
				}
			}
		}
		isStack.pop();
	}

	/**
	 * try to find a value (ValueSpecification) for the passed source element,
	 * beginning a the "deepest" instance specification of the passed stack. If
	 * not found, continue at elements higher up in the hierarchy
	 * 
	 * @param isStack
	 *        a stack of instance specifications corresponding to a path
	 *        within an instance tree
	 * @param source
	 *        a property (defining feature) for which we search an instance
	 *        specification
	 * @return The value specifications for the passed source property or null
	 */

	public static ValueSpecification getNearestValue(
		Stack<InstanceSpecification> isStack, Property source) {
		Stack<InstanceSpecification> copy = new Stack<InstanceSpecification>();
		copy.addAll(isStack);
		while(!copy.isEmpty()) {
			InstanceSpecification pop = copy.pop();
			ValueSpecification vs = getNearestValueHelper(isStack, pop, source);
			if(vs != null) {
				return vs;
			}
		}
		return null;
	}

	/**
	 * Helper for getNearestValue: search for an instance specification that has
	 * source as defining feature. Start at the passed instance specification,
	 * but do not recursed into elements that are contained in the stack.
	 * 
	 * @param isStack
	 *        A stack of instance specifications corresponding to a path
	 *        within an instance tree
	 * @param is
	 *        the starting instance specification
	 * @param source
	 *        source a property (defining feature) for which we search an
	 *        instance specification
	 * @return The value specifications for the passed source property or null
	 */
	public static ValueSpecification getNearestValueHelper(
		Stack<InstanceSpecification> isStack, InstanceSpecification is,
		Property source) {
		for(Slot slot : is.getSlots()) {
			StructuralFeature sf = slot.getDefiningFeature();
			if(sf == source) {
				// found property, now return first value specification
				for(ValueSpecification vs : slot.getValues()) {
					return vs;
				}
				return null;
			}

			// recursion in case of values that are instance values
			for(ValueSpecification vs : slot.getValues()) {
				if(vs instanceof InstanceValue) {
					InstanceSpecification subIS = ((InstanceValue)vs)
						.getInstance();
					if(!isStack.contains(subIS)) {
						// only recurse, if not contained in stack of instance
						// specifications (avoid traversing
						// the same elements multiple times)
						return getNearestValueHelper(isStack, subIS, source);
					}
				}
			}
		}
		return null;
	}
}
