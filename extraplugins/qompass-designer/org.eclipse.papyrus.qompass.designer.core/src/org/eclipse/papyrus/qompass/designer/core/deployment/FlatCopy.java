package org.eclipse.papyrus.qompass.designer.core.deployment;

import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.Type;

import org.eclipse.papyrus.qompass.designer.core.ConnectorUtils;
import org.eclipse.papyrus.qompass.designer.core.Utils;
import org.eclipse.papyrus.qompass.designer.core.transformations.Copy;
import org.eclipse.papyrus.qompass.designer.core.transformations.TransformationException;

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
 *         [same problem in distToNode code: need to know implementation]
 */
public class FlatCopy implements InstanceDeployer {

	public void init(Copy copy, BootLoaderGen bootloader, InstanceSpecification node) {
		this.copy = copy;
		// this.bootloader = bootloader;
		pc = new PartialCopy();
		pc.init(copy, bootloader, node);
		this.node = node;
	}

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
	public void flattenAssembly(InstanceSpecification instance) {
		Class smContainedComposite = (Class)DepUtils.getClassifier(instance);
		Class smContainingComposite = null; // ci.smCompClass;
		Class tmContainingComposite = (Class)copy.get(smContainingComposite);
		// Need parent information (logic: deploy a sub-instance and add in this moment the property to
		// the parent of the parent ...
		Property containedPart = null; // (Property)ci.slot.getDefiningFeature();
		if(!smContainingComposite.getOwnedAttributes().contains(containedPart)) {
			// should never happen.
			return;
		}
		String partPrefix = containedPart.getName() + "_";
		InstanceSpecification smInstance = null; // DepUtils.getInstance(ci.slot);
		// add parts of contained composite to the containing composite
		// for (InstanceSpecification partIS : InstanceUtils.getContainedInstance (is))
		for(Slot slot : smInstance.getSlots()) {
			Property smPart = (Property)slot.getDefiningFeature();
			InstanceSpecification subInstance = DepUtils.getInstance(slot);
			if(!AllocUtils.getNodesOrThreads(subInstance).contains(node)) {
				continue;
			}
			Type type = smPart.getType();
			if((type instanceof Class) && (Utils.isComponent((Class)type))) {

			}
			Property tmPart = copy.getCopy(smPart);
			tmPart.setName(partPrefix + smPart.getName());

			// now redirect connectors
			for(Connector connector : smContainedComposite.getOwnedConnectors()) {
				if(ConnectorUtils.connectsPart(connector, smPart)) {
					// internal connector for the part, check whether delegation
					ConnectorEnd ce = ConnectorUtils.connEndNotPart(connector, smPart);
					if(ce.getPartWithPort() == null) {
						// delegation connector, need to re-targed connections to external port
						Port port = (Port)ce.getRole();
						// now look for connections to this port in the containingComposite and shortcut these ...
						retargetConnections(smContainingComposite, port, containedPart, tmPart);
					} else {
						// assembly: the connector needs to be added to the containing composite after all
						// parts have been added (see below).
					}
				}
			}
			// move is
			/*
			 * InstanceSpecification partIS;
			 * DepUtils.createSlot (cdp, newIS, partIS, newPart);
			 */
		}
		// create assembly connectors of containedComposite in containingComposite
		for(Connector connector : smContainedComposite.getOwnedConnectors()) {
			if(ConnectorUtils.isAssembly(connector)) {
				//   but need to assure that both connected parts have been added before.
				copy.getCopy(connector);
			}
		}
		// TODO: need to do that on instance level as well.
		// remove contained part
		tmContainingComposite.getOwnedAttributes().remove(containedPart);
	}

	/**
	 * Find a connection within a connecting
	 * 
	 * @param containingComposite
	 * @param port
	 * @param part
	 *        a part within the containing composite (which is a composite as well) = containedComposite
	 * @param subPart
	 *        a newly created part which corresponds to a part of the containedComposite which should disappear
	 */
	public void retargetConnections(Class containingComposite, Port port, Property part, Property subPart) {
		for(Connector connector : containingComposite.getOwnedConnectors()) {
			if(ConnectorUtils.connectsPart(connector, part) && ConnectorUtils.connectsPort(connector, port)) {
				ConnectorEnd ce = ConnectorUtils.connEndForPart(connector, part);
				if(ce != null) {
					// support not using a port
					ce.setPartWithPort(subPart);
				}
			}
		}
	}

	public Classifier deployInstance(InstanceSpecification is)
		throws TransformationException {
		Classifier classifier = DepUtils.getClassifier(is);
		Class smCl = (Class)classifier;
		NamedElement existing = Utils.getExistingNEinTarget(copy, smCl);
		if(existing instanceof Classifier) {
			// classifier exists already in target model (or is imported), nothing todo
			return (Classifier)existing;
		}
		if(!(classifier instanceof Class)) {
			return copy.getCopy(classifier);
		}
		/*
		 * if(StUtils.isAssemblyImpl(smCl)) {
		 * // class is tagged as assembly, i.e. it does not need to be deployed.
		 * flattenAssembly(is);
		 * return null;
		 * } else {
		 */
		return pc.deployInstance(is);
		// }
	}

	private Copy copy;

	private PartialCopy pc;

	private InstanceSpecification node;
}
