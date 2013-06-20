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

package org.eclipse.papyrus.qompass.designer.core.sync;

import java.util.Iterator;

import org.eclipse.papyrus.FCM.DeploymentPlan;
import org.eclipse.papyrus.qompass.designer.core.Log;
import org.eclipse.papyrus.qompass.designer.core.StUtils;
import org.eclipse.papyrus.qompass.designer.core.Utils;
import org.eclipse.papyrus.qompass.designer.core.deployment.DepCreation;
import org.eclipse.papyrus.qompass.designer.core.deployment.DepPlanUtils;
import org.eclipse.papyrus.qompass.designer.core.deployment.DepUtils;
import org.eclipse.papyrus.qompass.designer.core.transformations.TransformationException;
import org.eclipse.papyrus.qompass.designer.core.transformations.TransformationRTException;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.ValueSpecification;

/**
 * Currently unused synchronization for deployment plans.
 * 
 * @see comp.cea.ec3m.gentools.core.listeners.DepPlanListener
 * 
 * @author ansgar
 */
public class DepPlanSync {

	/**
	 * Synchronize a deployment plan: remove slots that refer to properties that exist no longer
	 * and add those that do not exist yet
	 * 
	 * @param element
	 *        an arbitrary element of the source model (i.e. the model that will
	 *        store the deployment plan
	 * @throws TransformationException
	 */
	public static void syncAllDepPlans(Element element) {
		for(Package depPlan : DepPlanUtils.getAllDepPlans(element)) {
			syncDepPlan(depPlan);
		}
	}

	/**
	 * Synchronize a deployment plan: remove slots that refer to properties that exist no longer
	 * and add those that do not exist yet
	 * 
	 * @param depPlan
	 * @throws TransformationException
	 */
	public static void syncDepPlan(Package depPlan) {
		removeUnusedSlots(depPlan);
		// EList<InstanceSpecification> list = new BasicEList<InstanceSpecification>();
		DeploymentPlan cdp = StUtils.getApplication(depPlan, DeploymentPlan.class);
		if(cdp == null) {
			return;
		}
		InstanceSpecification mainInstance = cdp.getMainInstance();
		addCDP(depPlan, mainInstance, mainInstance.getName());
		// now add elements that are not in the plan - although they should
		// avoid to replicate code already in dep-creation. => createDepPlan(top)
		// strategy: create new dep-plan and compare?
	}

	private static void addCDP(Package depPlan, InstanceSpecification instance, String canonicalName)
	{
		Class implementation = DepUtils.getImplementation(instance);
		if(!instance.getName().equals(canonicalName)) {
			instance.setName(canonicalName);
		}
		// check sub-instances
		for(Slot slot : instance.getSlots()) {
			InstanceSpecification subInstance = DepUtils.getInstance(slot);
			if(subInstance != null) {
				addCDP(depPlan, subInstance, canonicalName + "." + slot.getDefiningFeature().getName());
			}
		}
		for(Property attribute : Utils.getParts(implementation)) {
			Type type = attribute.getType();
			if(type instanceof Class) {
				if(!hasSlot(instance, attribute)) {
					try {
						InstanceSpecification partIS =
							DepCreation.createDepPlan(depPlan, (Class)type, instance.getName() + "." + attribute.getName(), true);
						DepPlanUtils.createSlot(depPlan, instance, partIS, attribute);
					} catch (TransformationException e) {
						Log.log(Log.ERROR_MSG, Log.DEPLOYMENT, e.getMessage());
						throw new TransformationRTException(e.getMessage());
					}
				}
			}
		}
	}

	private static boolean hasSlot(InstanceSpecification instance, Property attribute) {
		for(Slot slot : instance.getSlots()) {
			if(slot.getDefiningFeature() == attribute) {
				return true;
			}
		}
		return false;
	}

	public static void removeUnusedSlots(Package depPlan) {
		// remove elements that are no longer in the plan
		for(NamedElement member : depPlan.getMembers()) {
			if(member instanceof InstanceSpecification) {
				InstanceSpecification instance = (InstanceSpecification)member;
				Iterator<Slot> slotIt = instance.getSlots().iterator();
				while(slotIt.hasNext()) {
					Slot slot = slotIt.next();
					if(slot.getDefiningFeature() == null) {
						// property has been removed => remove associated slot
						for(ValueSpecification value : slot.getValues()) {
							if(value instanceof InstanceValue) {
								InstanceSpecification is = ((InstanceValue)value).getInstance();
								DepPlanUtils.delDepPlan(is);
							}
						}
						slot.destroy();
						slotIt.remove();
					}
				}
			}
		}
	}
}
