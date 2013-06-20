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

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.C_Cpp.Ptr;
import org.eclipse.papyrus.qompass.designer.core.PortUtils;
import org.eclipse.papyrus.qompass.designer.core.StUtils;
import org.eclipse.papyrus.qompass.designer.core.Utils;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Type;

/**
 * A collection of transformations related to component-types (or abstract implementations)
 * 
 * 1. Add access operations for ports, i.e. operations that return a reference of a port
 * (if port provides interface) and/or allow to connect a port with a given reference
 * (if port requires an interface)
 * 2. Remove ports (after ports have been replaced with standard properties)
 * 
 * TODO: transformation is specific to C++
 * 
 * @author ansgar
 * 
 */
public class CompTypeTrafos {

	public static final String INDEX_TYPE_FOR_MULTI_RECEPTACLE = "corba::Long";
	
	/**
	 * Complete access operations recursively, i.e. traverse all packageable
	 * elements and apply the completeAccessOps operation on classes
	 * 
	 * @param pkg
	 *        the package for which the completion should start
	 * @see completeAccessOps(Class)
	 */
	public static void completeAccessOps(Package pkg) {
		for(PackageableElement element : new BasicEList<PackageableElement>(pkg.getPackagedElements())) {
			if(element instanceof Package) {
				completeAccessOps((Package)element);
			} else if(element instanceof Class) {
				completeAccessOps((Class)element);
			}
		}
	}

	/**
	 * Complete access operations that return the reference. This function is a completion,
	 * since the access operations have already been added for component implementations
	 * (partly, if implementation was abstract).
	 * 
	 * @param component
	 *        the component for which access operation should be completed.
	 * @return
	 */
	private static void completeAccessOps(Class component) {
		// only owned ports => since the operation is also applied on inherited types.
		for(Port port : component.getOwnedPorts()) {
			Interface providedIntf = PortUtils.getProvided(port);
			if(providedIntf != null) {
				// add operation CCM_<%type%> get_<portname>
				String getName = PrefixConstants.getP_Prefix + port.getName();

				// create unless already existing
				if(component.getOwnedOperation(getName, null, null) == null) {
					Operation op = component.createOwnedOperation(getName, null, null);
					op.setIsAbstract(true);
					Parameter retParam = op.createOwnedParameter("ret", providedIntf);
					retParam.setDirection(ParameterDirectionKind.RETURN_LITERAL);
					StUtils.apply(retParam, Ptr.class);
					// StUtils.apply(op, CppVirtual.class);
				}
			}
			Interface requiredIntf = PortUtils.getRequired(port);
			if(requiredIntf != null) {
				// add operation CCM_<%type%> connect_q <portname>
				String connName = PrefixConstants.connectQ_Prefix + port.getName();

				// create unless already existing
				if(component.getOwnedOperation(connName, null, null) == null) {
					Operation op = component.createOwnedOperation(connName, null, null);
					op.setIsAbstract(true);
					boolean multiPort = (port.getUpper() > 1) || (port.getUpper() == -1); // -1 indicates "*"
					if(multiPort) {
						// add index parameter
						Element eLong = Utils.getQualifiedElement(Utils.getTop(component), INDEX_TYPE_FOR_MULTI_RECEPTACLE);
						if(eLong instanceof Type) {
							op.createOwnedParameter("index", (Type)eLong);
						}
						else {
							throw new RuntimeException("Can not find type " + INDEX_TYPE_FOR_MULTI_RECEPTACLE +
									". Thus, unable to create suitable connect operation in component to OO transformation");
						}
					}
					Parameter refParam = op.createOwnedParameter("ref", requiredIntf);
					refParam.setDirection(ParameterDirectionKind.IN_LITERAL);
					StUtils.apply(refParam, Ptr.class);
					// StUtils.apply(op, CppVirtual.class);
				}
			}
		}
	}

	/**
	 * Remove ports recursively from all classes within a package and its
	 * sub-packages
	 * 
	 * @param pkg
	 *        the package (root) from which the port deletion starts.
	 */
	public static void removePorts(Package pkg) {
		for(PackageableElement element : pkg.getPackagedElements()) {
			if(element instanceof Package) {
				removePorts((Package)element);
			} else if(element instanceof Class) {
				EList<Port> portListCopy = new BasicEList<Port>();
				portListCopy.addAll(((Class)element).getOwnedPorts());
				// avoid dangling references by calling destroy on the port list
				// TODO: who still has a reference to these ports? (connectors? - indication of other errors?)
				// maybe from port-list within ContainerRule stereotype?
				for(Port port : portListCopy) {
					port.destroy();
				}
			}
		}
	}
}
