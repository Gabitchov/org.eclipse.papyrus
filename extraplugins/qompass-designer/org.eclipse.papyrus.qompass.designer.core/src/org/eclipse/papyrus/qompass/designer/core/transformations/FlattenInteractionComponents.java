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

package org.eclipse.papyrus.qompass.designer.core.transformations;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.FCM.InteractionComponent;
import org.eclipse.papyrus.qompass.designer.core.ConnectorUtils;
import org.eclipse.papyrus.qompass.designer.core.deployment.DepUtils;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.StructuralFeature;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * Deploy instances in a flat way, i.e. only deploy leaves. "Normal" composites
 * still need to be deployed (since they might have a behavior of their own).
 * However, composites tagged as assemblies (FCM stereotype attribute) may be
 * not be deployed, instead their contents is deployed.
 * 
 * A composite that is not deployed implies that
 * - assembly connections within this composite need to move up one or more levels
 * in the composite hierarchy
 * - re-targeting connections from/to a composite to the inner part (along delegation connections inside
 * the composite)
 * [Need to stop at a composite]
 * 
 * Problems: need to do that on instance level. It could be that the same composite is instantiated
 * at different places in the tree with a different implementation choices => would require different
 * variants of the sub-type.
 * Solution: a. completely flatten except system of which we know that a single
 * instance exists)
 * b. forbid that different implementation variants are used by different instances of same composant
 * 
 * CAVEAT: function not yet properly working,
 * function currently not used
 * 
 * @author ansgar
 * 
 *      
 */
public class FlattenInteractionComponents {

	public static FlattenInteractionComponents getInstance() {
		return instance;
	}
	
	private static FlattenInteractionComponents instance = new FlattenInteractionComponents();
	
	/**
	 * flatten an assembly, i.e. remove the passed containedPart (which must be a part within the passed containing
	 * composite)
	 * 
	 * @param containingComposite
	 * @param containedPart
	 *        a part within the passed containing composite
	 * @param containedComposite
	 *        the type (implementation) of the passed part
	 */
	public void flattenAssembly(InstanceSpecification instance, Slot slot)
	{
		Classifier cl = DepUtils.getClassifier(instance);
		if ((cl instanceof Class) && (slot != null)) {
			InteractionComponent ic = UMLUtil.getStereotypeApplication((Class) cl, InteractionComponent.class);
			if ((ic != null) && ic.isForDistribution()) {
				Slot containingSlot = DepUtils.getParentSlot(instance);
				InstanceSpecification containingInstance = containingSlot.getOwningInstance();
				flattenAssembly((Class) cl, instance, containingInstance, containingSlot);
			}
		}
		// create a copy, since flatten might modify the number of slots
		EList<Slot> slots =  new BasicEList<Slot>(instance.getSlots());
		for (Slot subISslot : slots) {
			InstanceSpecification subIS = DepUtils.getInstance(subISslot);
			if (subIS != null) {
				flattenAssembly (subIS, subISslot);
			}
		}
	}
	
	/**
	 * Flatten a composite interaction component, i.e. replace it by the containing fragments. This includes the following actions
	 * 1. Parts typed with the interaction component must be replaced with a set of parts typed with the fragment.
	 * 2. Connectors must be redirected.
	 *
	 * Please note that we do not delete the original interaction component, but it will not appear in a model generated for a specific node.
	 * TODO: We need to re-target connectors in all containing composites, but the same containingComposite might have several instances within an application. In this case,
	 * we only need to move slots.
	 * 
	 * Well, there are different classes: first: the flattened interaction component and other components that reference the flattened interaction component.
	 * @param composite a composite class
	 * @param instance the instance associated with the composite class (1st parameter)
	 * @param containingInstance an instance of the containing composite
	 * @param containingSlot the slot associated with the instance (2nd parameter)
	 */
	public void flattenAssembly(Class composite, InstanceSpecification instance, InstanceSpecification containingInstance, Slot containingSlot)
	{
		Classifier containingCompositeCl = DepUtils.getClassifier(containingInstance);
		StructuralFeature sfForIA = containingSlot.getDefiningFeature();
		Map<Property, Property> replaceParts = new HashMap<Property, Property>();
		if ((containingCompositeCl instanceof Class)  && (sfForIA instanceof Property)) {
			Class containingComposite = (Class) containingCompositeCl;
			Property partForIA = (Property) sfForIA;
			
			for (Property fragmentPart : composite.getAllAttributes()) {
				if (fragmentPart instanceof Port) continue;
				String partName = partForIA.getName() + "_" + fragmentPart.getName(); //$NON-NLS-1$
				// create a new part in the containing composite
				Property newPartForFragment = containingComposite.createOwnedAttribute(partName, fragmentPart.getType());
				replaceParts.put(fragmentPart, newPartForFragment);
				
				boolean foundConnector = false;
				// now redirect connectors: find whether a port delegates to the fragment
				for(Connector connector : composite.getOwnedConnectors()) {
					if(ConnectorUtils.connectsPart(connector, fragmentPart)) {
						foundConnector = true;
						// internal connector for the part, check whether delegation
						ConnectorEnd ce = ConnectorUtils.connEndNotPart(connector, fragmentPart);
						if((ce != null) && (ce.getPartWithPort() == null)) {
							// delegation connector, need to re-targed connections to external port
							Port port = (Port)ce.getRole();
							// now look for connections to this port in the containingComposite and shortcut these ...
							retargetConnections(containingComposite, port, partForIA, newPartForFragment);
						} else {
							// assembly: assembly connection between fragments are not authorized
						}
					}
				}
				if (!foundConnector) {
					throw new RuntimeException("the part <" + fragmentPart.getName() + "> within composite <" + composite.getName() + "> is not connected with any of its ports"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				}
			}
			// on instance level: move slots from instance to containingInstance
			EList<Slot> slots = instance.getSlots();
			containingInstance.getSlots().addAll(slots);
			// replace defining feature
			for (Slot slot : containingInstance.getSlots()) {
				StructuralFeature sf = slot.getDefiningFeature();
				if (replaceParts.containsKey(sf)) {
					slot.setDefiningFeature(replaceParts.get(sf));
				}
			}
			// TODO: assure naming convention for instances
			
			containingSlot.destroy();
			instance.destroy();
			partForIA.destroy();
			
			// move is
			/*
			 * InstanceSpecification partIS;
			 * DepUtils.createSlot (cdp, newIS, partIS, newPart);
			 */
		}
	}

	/**
	 * Find a connection within a connecting
	 * 
	 * @param containingComposite
	 * @param port A port which delegates to a fragment
	 * @param part
	 *        the part within the containing composite (1st parameter) point to the interactionComponent
	 * @param subPart
	 *        a newly created part  corresponding to the fragment
	 */
	public void retargetConnections(Class containingComposite, Port port, Property part, Property subPart) {
		for(Connector connector : containingComposite.getOwnedConnectors()) {
			if(ConnectorUtils.connectsPart(connector, part) && ConnectorUtils.connectsPort(connector, port)) {
				ConnectorEnd ce = ConnectorUtils.connEndForPart(connector, part);
				if(ce != null) {
					// TODO: only with with connections targeting a port of a part, not with
					// those targeting directly a part
					ce.setPartWithPort(subPart);
				}
			}
		}
	}
}
