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
package org.eclipse.papyrus.diagram.activity.activitygroup;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.papyrus.diagram.activity.activitygroup.groupcontainment.ActivityContainment;
import org.eclipse.papyrus.diagram.activity.activitygroup.groupcontainment.ActivityNodeContainment;
import org.eclipse.papyrus.diagram.activity.activitygroup.groupcontainment.ActivityPartitionContainment;
import org.eclipse.papyrus.diagram.activity.activitygroup.groupcontainment.ConditionalNodeContainment;
import org.eclipse.papyrus.diagram.activity.activitygroup.groupcontainment.ExpansionRegionContainment;
import org.eclipse.papyrus.diagram.activity.activitygroup.groupcontainment.InterruptibleActivityRegionContainment;
import org.eclipse.papyrus.diagram.activity.activitygroup.groupcontainment.LoopNodeContainment;
import org.eclipse.papyrus.diagram.activity.activitygroup.groupcontainment.SequenceNodeContainment;
import org.eclipse.papyrus.diagram.activity.activitygroup.groupcontainment.StructuredActivityNodeContainment;
import org.eclipse.uml2.uml.UMLPackage;


public final class ContainerNodeDescriptorRegistry {

//	public static class NodeDescriptorSwitch extends UMLSwitch<Iterable<? extends IContainerNodeDescriptor>>{
//
//		@Override
//		public Iterable<? extends IContainerNodeDescriptor> caseActivityNode(ActivityNode object) {
//			return Collections.singletonList(new ActivityNodeContainment());
//		}
//
//		@Override
//		public Iterable<? extends IContainerNodeDescriptor> caseActivity(Activity object) {
//			return Collections.singletonList(new ActivityContainment();
//		}
//
//		@Override
//		public Iterable<? extends IContainerNodeDescriptor> caseActivityPartition(ActivityPartition object) {
//			return Collections.singletonList(new ActivityPartitionContainment());
//		}
//
//		@Override
//		public Iterable<? extends IContainerNodeDescriptor> caseStructuredActivityNode(StructuredActivityNode object) {
//			return  new StructuredActivityNodeContainment();
//		}
//
//		@Override
//		public Iterable<? extends IContainerNodeDescriptor> caseInterruptibleActivityRegion(InterruptibleActivityRegion object) {
//			return Collections.singletonList(new InterruptibleActivityRegionContainment());
//		}
//
//		@Override
//		public Iterable<? extends IContainerNodeDescriptor> caseSequenceNode(SequenceNode object) {
//			return Collections.singletonList(new SequenceNodeContainment());
//		}
//
//		@Override
//		public Iterable<? extends IContainerNodeDescriptor> caseConditionalNode(ConditionalNode object) {
//			return Collections.singletonList(new ConditionalNodeContainment());
//		}
//
//		@Override
//		public Iterable<? extends IContainerNodeDescriptor> caseLoopNode(LoopNode object) {
//			return Collections.singletonList(new LoopNodeContainment());
//		}
//
//		@Override
//		public Iterable<? extends IContainerNodeDescriptor> caseExpansionRegion(ExpansionRegion object) {
//			return Collections.singletonList(new ExpansionRegionContainment());
//		}
//		
//	}
	
	
	private ContainerNodeDescriptorRegistry() {

	}

//	private static NodeDescriptorSwitch descriptorSwitch = new NodeDescriptorSwitch();
	
	private static Map<EClass, IContainerNodeDescriptor> registry;

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
			return registry.get(eclass);
		} catch (Exception e) {
			throw new RuntimeException("wrong use of the ContainerNodeDescriptorRegistry");
		}
	}

	public static ContainerNodeDescriptorRegistry getInstance() {
		return SingletonHolder.instance;
	}

}
