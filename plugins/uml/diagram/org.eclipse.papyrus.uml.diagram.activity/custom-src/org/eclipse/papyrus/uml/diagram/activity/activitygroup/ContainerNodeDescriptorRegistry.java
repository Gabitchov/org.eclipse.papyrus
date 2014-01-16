/*****************************************************************************
 * Copyright (c) 2011 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Arthur Daussy (Atos) - Initial API and implementation
 *   Arthur Daussy - 371712 : 372745: [ActivityDiagram] Major refactoring group framework
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.activitygroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.papyrus.uml.diagram.activity.activitygroup.groupcontainment.ActivityContainment;
import org.eclipse.papyrus.uml.diagram.activity.activitygroup.groupcontainment.ActivityNodeContainment;
import org.eclipse.papyrus.uml.diagram.activity.activitygroup.groupcontainment.ActivityPartitionContainment;
import org.eclipse.papyrus.uml.diagram.activity.activitygroup.groupcontainment.ConditionalNodeContainment;
import org.eclipse.papyrus.uml.diagram.activity.activitygroup.groupcontainment.ExpansionRegionContainment;
import org.eclipse.papyrus.uml.diagram.activity.activitygroup.groupcontainment.InterruptibleActivityRegionContainment;
import org.eclipse.papyrus.uml.diagram.activity.activitygroup.groupcontainment.LoopNodeContainment;
import org.eclipse.papyrus.uml.diagram.activity.activitygroup.groupcontainment.SequenceNodeContainment;
import org.eclipse.papyrus.uml.diagram.activity.activitygroup.groupcontainment.StructuredActivityNodeContainment;
import org.eclipse.uml2.uml.UMLPackage;

import com.google.common.collect.Lists;

/**
 * Registry of all node and group descriptor
 */
public final class ContainerNodeDescriptorRegistry {

	/**
	 * Constructor
	 */
	private ContainerNodeDescriptorRegistry() {
	}

	/**
	 * Registry of all descriptor
	 */
	private static Map<EClass, IContainerNodeDescriptor> registry;
	/**
	 * Initialize
	 * (May be in the future using extension point
	 */
	static {
		registry = new HashMap<EClass, IContainerNodeDescriptor>();
		registry.put(UMLPackage.Literals.ACTIVITY_PARTITION, new ActivityPartitionContainment());
		registry.put(UMLPackage.Literals.STRUCTURED_ACTIVITY_NODE, new StructuredActivityNodeContainment());
		registry.put(UMLPackage.Literals.CONDITIONAL_NODE, new ConditionalNodeContainment());
		registry.put(UMLPackage.Literals.EXPANSION_REGION, new ExpansionRegionContainment());
		registry.put(UMLPackage.Literals.INTERRUPTIBLE_ACTIVITY_REGION, new InterruptibleActivityRegionContainment());
		registry.put(UMLPackage.Literals.LOOP_NODE, new LoopNodeContainment());
		registry.put(UMLPackage.Literals.SEQUENCE_NODE, new SequenceNodeContainment());
		registry.put(UMLPackage.Literals.ACTIVITY_NODE, new ActivityNodeContainment());
		registry.put(UMLPackage.Literals.ACTIVITY, new ActivityContainment());
	}

	/**
	 * SingletonHolder is loaded on the first execution of Singleton.getInstance()
	 * or the first access to SingletonHolder.INSTANCE, not before.
	 */
	private static class SingletonHolder {

		public static final ContainerNodeDescriptorRegistry instance = new ContainerNodeDescriptorRegistry();
	}

	public IContainerNodeDescriptor getContainerNodeDescriptor(EClass eclass) {
		try {
			IContainerNodeDescriptor result = registry.get(eclass);
			if(result == null) {
				ArrayList<EClass> superTypes = Lists.newArrayList(eclass.getEAllSuperTypes());
				for(EClass aux : Lists.reverse(superTypes)) {
					result = registry.get(aux);
					if(result != null) {
						return result;
					}
				}
			}
			return result;
		} catch (Exception e) {
			throw new RuntimeException("wrong use of the ContainerNodeDescriptorRegistry");
		}
	}

	public static ContainerNodeDescriptorRegistry getInstance() {
		return SingletonHolder.instance;
	}
}
