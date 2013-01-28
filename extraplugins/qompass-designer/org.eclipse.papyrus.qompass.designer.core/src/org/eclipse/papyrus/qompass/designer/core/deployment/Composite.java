package org.eclipse.papyrus.qompass.designer.core.deployment;

import java.util.Iterator;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.StructuralFeature;

import Cpp.CppPtr;

import org.eclipse.papyrus.qompass.designer.core.ConnectorUtils;
import org.eclipse.papyrus.qompass.designer.core.StUtils;
import org.eclipse.papyrus.qompass.designer.core.Utils;

/**
 * Composite deployment, i.e. the composite is responsible for instantiating the contained properties
 * 
 * @author ansgar
 *         Currently not used
 * 
 */
@Deprecated
public class Composite {

	public EList<InstanceSpecification> getInstancesForImplementation(Package depPlan, Classifier implementation) {
		Iterator<NamedElement> members = depPlan.getMembers().iterator();
		EList<InstanceSpecification> list = new BasicEList<InstanceSpecification>();
		while(members.hasNext()) {
			NamedElement member = members.next();
			if(member instanceof InstanceSpecification) {
				InstanceSpecification is = (InstanceSpecification)member;
				if(is.getClassifiers().contains(implementation)) {
					list.add(is);
				}
			}
		}
		return list;
	}

	public void deploy(Package depPlan) {
		Iterator<NamedElement> members = depPlan.getMembers().iterator();
		while(members.hasNext()) {
			NamedElement member = members.next();
			if(member instanceof InstanceSpecification) {
				InstanceSpecification is = (InstanceSpecification)member;
				if(Utils.isComposite(is)) {
					deployComposite(depPlan, is);
				}
			}
		}
	}

	private void deployComposite(Package depPlan, InstanceSpecification composite) {
		Class implementation = DepUtils.getImplementation(composite);
		// assure that part is a pointer
		for(Property part : Utils.getParts(implementation)) {
			StUtils.apply(part, CppPtr.class);
		}
		// create function
		String body = "";
		for(Slot slot : composite.getSlots()) {
			StructuralFeature f = slot.getDefiningFeature();
			// TODO: avoid new, replace by adding additional properties (non pointer)
			String line = f.getName() + " = new " + implementation.getName() + "()\n";
			body = body + line;
		}
		/*
		 * EList<InstanceSpecification> otherInstances =
		 * getInstancesForImplementation (depPlan, implementation);
		 * // EList<InstanceSpecification> containedInstances = UMLTool.getContainedInstances (is);
		 * }
		 */
		// create delegation connectors

		for(Connector connector : implementation.getOwnedConnectors()) {
			if(!ConnectorUtils.isAssembly(connector)) {
				// is a delegation connector, add specific methods
			}
		}
	}
}
