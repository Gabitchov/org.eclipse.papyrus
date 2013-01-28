package org.eclipse.papyrus.qompass.designer.core.deployment;

import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.InstanceSpecification;

import org.eclipse.papyrus.qompass.designer.core.transformations.Copy;
import org.eclipse.papyrus.qompass.designer.core.transformations.TransformationException;

/**
 * Copy a composite class while taking into account node allocation, i.e. only
 * copy parts that are deployed on a certain node (properties that are not typed
 * by a component are always copied). This function may be called several times
 * and will successively add parts that are required. If the same composite
 * (class level) is used in two different contexts, e.g. a socket connector
 * serving as client and server on the same node (for the same interface), the
 * resulting composite will be complete. On the instance level however, such as
 * composite is sub-optimal, since their are two different instances that use a
 * different subset. These cases are not very critical, since unused parts are
 * not instantiated (overhead = pointer)
 * 
 * The function will change assembly composites
 * 
 * @author ansgar
 * 
 */
public class PartialCopy implements InstanceDeployer {

	public void init(Copy copy, BootLoaderGen bootloader,
		InstanceSpecification node) {
		this.copy = copy;
		this.node = node; // only needed for debug output
		// add copy listeners ---
		// 1. only add required parts
		// does nothing for the moment
	}

	public Classifier deployInstance(InstanceSpecification is) throws TransformationException {
		Classifier classifier = DepUtils.getClassifier(is);
		return copy.getCopy(classifier);
	}

	private InstanceSpecification node;

	private Copy copy;
}
