package org.eclipse.papyrus.qompass.designer.core.transformations;

import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.papyrus.qompass.designer.core.Log;
import org.eclipse.papyrus.qompass.designer.core.deployment.AllocUtils;
import org.eclipse.papyrus.qompass.designer.core.deployment.DepUtils;
import org.eclipse.papyrus.qompass.designer.core.extensions.InstanceConfigurator;
import org.eclipse.papyrus.qompass.designer.core.sync.CompImplSync;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Slot;

public class TransformationUtil {
	public static void applyInstanceConfigurators(InstanceSpecification instance) {
		for (Slot slot : instance.getSlots()) {
			InstanceSpecification subInstance = DepUtils.getInstance(slot);
			if (!DepUtils.isShared(slot) && (subInstance != null)) {
				if (slot.getDefiningFeature() instanceof Property) {
					InstanceConfigurator.configureInstance(subInstance, (Property) slot.getDefiningFeature(), instance);
				}
				applyInstanceConfigurators(subInstance);
			}
		}
	}
	
	public static void propagateAllocation(InstanceSpecification instance) {
		propagateAllocation(instance, new UniqueEList<InstanceSpecification>());
	}
	
	public static void propagateAllocation(InstanceSpecification instance, EList<InstanceSpecification> nodes) {
		// create copy of node (otherwise, more and more nodes get aggregated. 
		UniqueEList<InstanceSpecification> nodesCopy = new UniqueEList<InstanceSpecification>();
		nodesCopy.addAll(nodes);
		nodesCopy.addAll(AllocUtils.getNodes(instance));
		for (Slot slot : instance.getSlots()) {
			InstanceSpecification subInstance = DepUtils.getInstance(slot);
			if (subInstance != null) {
				if (DepUtils.isShared(slot)) {
					for (InstanceSpecification node : nodesCopy) {
						Log.log(Status.INFO, Log.DEPLOYMENT, String.format("Propagate node allocation: %s to %s", subInstance.getName(), node.getName())); //$NON-NLS-1$
						AllocUtils.allocate(subInstance, node);
					}
				}
				else {
					propagateAllocation(subInstance, nodesCopy);
				}
			}
		}
	}
	
	/**
	 * Update derived interfaces of ports. This is required, since the Copier does not follow references
	 * that are referenced via a derived attribute. Derived attributes are used for provided and required
	 * interfaces in the stereotype attributes of an FCM port. Thus, required (derived) interfaces would be
	 * unavailable in the copy, if not explicitly updated.
	 * However, the provided interface is not concerned as it appears in an "implements" relation. If the
	 * port is connected, the used interface of one port is the provided interface of the port counter part.
	 * Thus, the explicit update done by this function is not needed in most cases.
	 *
	 * see also FixTemplateSync (remove the latter?)
	 */
	public static void updateDerivedInterfaces(InstanceSpecification instance) {
		Classifier cl = DepUtils.getClassifier(instance);
		if (cl instanceof Class) {
			Class implementation = (Class) cl;
			CompImplSync.updatePorts(implementation);
			CompImplSync.syncRealizations(implementation);
		}
		for (Slot slot : instance.getSlots()) {
			InstanceSpecification subInstance = DepUtils.getInstance(slot);
			if (!DepUtils.isShared(slot) && (subInstance != null)) {
				updateDerivedInterfaces(subInstance);
			}
		}
	}

}
