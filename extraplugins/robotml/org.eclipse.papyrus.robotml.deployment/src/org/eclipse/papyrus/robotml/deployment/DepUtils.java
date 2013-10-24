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

import java.util.Iterator;
import java.util.Stack;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.papyrus.RobotML.DeploymentPlan;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.StructuralFeature;
import org.eclipse.uml2.uml.ValueSpecification;


/**
 * Utilities around instances (within deployment plan)
 * [DepPlanUtils?]
 * [but missing: creation, ..., allocation?]
 * Structuration ??
 * 
 * @author ansgar
 * 
 */
public class DepUtils {

	

	/**
	 * Find a sub instance via its name. This is in particular useful for connectors that cannot be
	 * found via a slot, since UML only supports structural features (a connector is only a feature)
	 * in the definingFeature attribute of a slot.
	 * 
	 * @param owningInstance
	 *        an owning instance
	 * @param name
	 *        name of the sub-element (unqualified)
	 * @return the found sub-instance or null
	 */
	public static InstanceSpecification getNamedSubInstance(InstanceSpecification owningInstance, String name) {
		Element cdp = owningInstance.getOwner();
		String candidateName = owningInstance.getName() + "." + name;
		if(cdp instanceof Package) {
			for(PackageableElement instance : ((Package)cdp).getPackagedElements()) {
				if(instance instanceof InstanceSpecification) {
					InstanceSpecification candidate = (InstanceSpecification)instance;

					if(candidateName != null) {
						if(candidateName.equals(candidate.getName())) {
							return candidate;
						}
					}
				}
			}
		}
		return null;
	}

	

	/**
	 * return an instance specification for the main instance within
	 * a package.
	 * 
	 * @param cdp
	 *        the deployment plan
	 */
	public static InstanceSpecification getMainInstance(Package cdp) {
		DeploymentPlan dp = StUtils.getApplication(cdp, DeploymentPlan.class);
		return dp.getMainInstance();
	}

	/**
	 * Apply the stereotype deployment plan and set the mainInstance value
	 * 
	 * @param cdp
	 *        the deployment plan
	 * @param main
	 *        instance the top-level instance specification of the plan
	 */
	public static void setMainInstance(Package cdp, InstanceSpecification mainInstance) {
		StUtils.apply(cdp, DeploymentPlan.class);
		DeploymentPlan dp = StUtils.getApplication(cdp, DeploymentPlan.class);
		dp.setMainInstance(mainInstance);
	}

	/**
	 * return the implementation associated with an instance specification, i.e. a
	 * Class.
	 * 
	 * @param instance
	 * @return
	 */
	public static Class getImplementation(InstanceSpecification instance) {
		Classifier cl = getClassifier(instance);
		if(cl instanceof Class) {
			return (Class)cl;
		}
		return null;
	}

	

	/**
	 * Return the first classifier referenced by an instance specification. Whereas UML supports
	 * a set of classifiers, we assume that that an instance specification has only one.
	 * 
	 * @param instance
	 *        the instance, for which we are interested in type information
	 */
	public static Classifier getClassifier(InstanceSpecification instance) {
		Iterator<Classifier> classifierIt = instance.getClassifiers().iterator();
		// simply return the first element (if there is any)
		if(classifierIt.hasNext()) {
			return classifierIt.next();
		}
		return null;
	}

	/**
	 * Return the first instance specification within a deployment plan that instantiates a given
	 * classifier
	 * 
	 * @param cdp
	 *        the deployment plan
	 * @param cl
	 *        the classifier
	 * @return
	 */
	public static InstanceSpecification getInstanceForClassifier(Package cdp, Classifier cl) {
		for(PackageableElement pe : cdp.getPackagedElements()) {
			if(pe instanceof InstanceSpecification) {
				InstanceSpecification is = (InstanceSpecification)pe;
				if(getClassifier(is) == cl) {
					return is;
				}
			}
		}
		return null;
	}

	/**
	 * Return the (unique) list of implementations that are contained within an
	 * instance specification
	 */
	public static EList<Classifier> getContainedImplementations(InstanceSpecification is) {
		Iterator<InstanceSpecification> instances = getContainedInstances(is).iterator();
		EList<Classifier> list = new UniqueEList<Classifier>();
		while(instances.hasNext()) {
			Classifier implementation = getClassifier(instances.next());
			list.add(implementation);
		}
		return list;
	}

	/**
	 * Return the slot that is associated with a property
	 * 
	 * @param is
	 *        an instance specification (of a class having properties)
	 * @param property
	 *        A property of the classifier associated with the passed instance specification
	 * @return the associated slot or null, if it does not exist
	 */
	public static Slot getSlot(InstanceSpecification is, Property property) {
		Iterator<Slot> slots = is.getSlots().iterator();
		while(slots.hasNext()) {
			Slot slot = slots.next();
			if(slot.getDefiningFeature() == property) {
				return slot;
			}
		}
		return null;
	}

	/**
	 * Return the instance referenced by a slot value, i.e. the first instance value associated
	 * with a slot
	 * 
	 * @param slot
	 * @return
	 */
	public static InstanceSpecification getInstance(Slot slot) {
		for(ValueSpecification value : slot.getValues()) {
			// instances are accessible via ValueSpecification subclass InstanceValue
			if(value instanceof InstanceValue) {
				return ((InstanceValue)value).getInstance();
			}
		}
		return null;
	}

	/**
	 * This method returns the instances contained within a composite instance
	 * specification for an assembly.
	 */
	public static EList<InstanceSpecification> getContainedInstances(InstanceSpecification is) {
		EList<InstanceSpecification> contained = new BasicEList<InstanceSpecification>();
		for(Slot slot : is.getSlots()) {
			InstanceSpecification instance = getInstance(slot);
			if(instance != null) {
				contained.add(instance);
			}
		}
		return contained;
	}

	/**
	 * return all slots that reference an instance specification
	 * 
	 * @param is
	 * @return
	 */
	public static EList<Slot> getReferencingSlots(InstanceSpecification is) {
		EList<Slot> list = new BasicEList<Slot>();
		for(Setting setting : UML2Util.getNonNavigableInverseReferences(is)) {
			// no trigger is referencing the event any more, delete call event
			EObject eObj = setting.getEObject();
			if(eObj instanceof ValueSpecification) {
				ValueSpecification vs = (ValueSpecification)eObj;
				Element owner = vs.getOwner();
				if(owner instanceof Slot)
					list.add((Slot)owner);
			}
		}
		return list;
	}

	/**
	 * Return an instance specification that refers to the composite in which the
	 * passed instance is contained
	 * 
	 * @param is
	 *        an instance that is contained within an composite (i.e. that
	 *        belongs to a part of this composite).
	 * @return
	 */
	public static Slot getParentSlot(InstanceSpecification is) {
		for(Slot slot : getReferencingSlots(is)) {
			// no trigger is referencing the event any more, delete call event
			if(slot.getDefiningFeature() instanceof Property) {
				if(((Property)slot.getDefiningFeature()).getAggregation() == AggregationKind.COMPOSITE_LITERAL) {
					return slot;
				}
			}
		}
		return null;
	}

	/**
	 * Return an instance specification that refers to the composite in which the
	 * passed instance is contained
	 * 
	 * @param is
	 *        an instance that is contained within an composite (i.e. that
	 *        belongs to a part of this composite).
	 * @return
	 */
	public static InstanceSpecification getParentIS(InstanceSpecification is) {
		Slot parentSlot = getParentSlot(is);
		if(parentSlot != null) {
			return parentSlot.getOwningInstance();
		}
		return null;
	}

	public static Stack<Slot> getAccessPath(InstanceSpecification is) {
		Stack<Slot> path = new Stack<Slot>();
		while(is != null) {
			Slot parentSlot = getParentSlot(is);
			if(parentSlot == null) {
				break;
			}
			path.insertElementAt(parentSlot, 0);
			is = parentSlot.getOwningInstance();
		}
		return path;
	}

	public static boolean isShared(Slot slot) {
		StructuralFeature df = slot.getDefiningFeature();
		if(df instanceof Property) {
			return ((Property)df).getAggregation() == AggregationKind.SHARED_LITERAL;
		}
		return false;
	}
}
