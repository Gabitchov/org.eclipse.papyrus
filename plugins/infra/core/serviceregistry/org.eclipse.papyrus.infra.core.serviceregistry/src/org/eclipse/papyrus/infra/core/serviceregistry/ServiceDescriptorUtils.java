/*****************************************************************************
 * Copyright (c) 2012 Cedric Dumoulin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.core.serviceregistry;

import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.AbstractServiceDesc;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.AliasDesc;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServiceDesc;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.AbstractServiceIdDesc;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.AliasIdDesc;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServiceIdDesc;
import org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.StartupKind;


/**
 * Utilities used as bridge between {@link ServiceDescriptor} and {@link AbstractServiceIdDesc}.
 * 
 * @author cedric dumoulin
 *
 */
public class ServiceDescriptorUtils {

	/**
	 * Create a {@link ServiceDescriptor} from a {@link AbstractServiceIdDesc}.
	 * @param idDesc
	 * @return
	 */
	public static ServiceDescriptor toServiceDescriptor(AbstractServiceIdDesc idDesc) {
		
		
		if( idDesc instanceof ServiceIdDesc ) {
			return toServiceDescriptor((ServiceIdDesc)idDesc);
		}
		else if(idDesc instanceof AliasIdDesc ) {
			return toServiceDescriptor((AliasIdDesc)idDesc);
		}
		
		// Should not happen
		throw new UnsupportedOperationException("Don't know how to transform '" + idDesc.getClass().getName() + "'.");
	}

	/**
	 * Create a {@link ServiceDescriptor} from a {@link AbstractServiceIdDesc}.
	 * @param serviceDesc
	 * @return
	 */
	public static ServiceDescriptor toServiceDescriptor(AbstractServiceDesc serviceDesc) {
		if( serviceDesc instanceof ServiceDesc ) {
			return toServiceDescriptor((ServiceDesc)serviceDesc);
		}
		else if(serviceDesc instanceof AliasDesc ) {
			return toServiceDescriptor((AliasDesc)serviceDesc);
		}
		
		// Should not happen
		throw new UnsupportedOperationException("Don't know how to transform '" + serviceDesc.getClass().getName() + "'.");
	}
		
	/**
	 * Create a {@link ServiceDescriptor} from a {@link AbstractServiceIdDesc}.
	 * @param serviceIdDesc
	 * @return
	 */
	public static ServiceDescriptor toServiceDescriptor(ServiceIdDesc serviceIdDesc) {
		
		ServiceStartKind serviceStartKind = transformToServiceStartKind(serviceIdDesc.getStartKind()); 
		return new ServiceDescriptor(serviceIdDesc.getName(), serviceIdDesc.getClassname(), serviceStartKind, serviceIdDesc.getPriority(), serviceIdDesc.getDependsOn());
	}
		
	/**
	 * 
	 * @param startKind
	 * @return
	 */
	private static ServiceStartKind transformToServiceStartKind(StartupKind startKind) {
		switch( startKind) {
		case STARTUP:
			return ServiceStartKind.STARTUP;
		case LAZY:
			return ServiceStartKind.LAZY;
		default:
			return ServiceStartKind.STARTUP;
		}
	}

	/**
	 * Create a {@link ServiceDescriptor} from a {@link AbstractServiceIdDesc}.
	 * @param serviceDesc
	 * @return
	 */
	public static ServiceDescriptor toServiceDescriptor(AliasIdDesc serviceDesc) {
		
		return new AliasDescriptor(serviceDesc.getName(), serviceDesc.getAliasedService(), serviceDesc.getPriority());
	}

	/**
	 * Create a {@link ServiceDescriptor} from a {@link AbstractServiceIdDesc}.
	 * @param serviceIdDesc
	 * @return
	 */
	public static ServiceDescriptor toServiceDescriptor(ServiceDesc serviceIdDesc) {
		
		ServiceStartKind serviceStartKind = transformToServiceStartKind(serviceIdDesc.getStartKind()); 
		return new ServiceDescriptor(serviceIdDesc.getName(), serviceIdDesc.getClassname(), serviceStartKind, serviceIdDesc.getPriority(), serviceIdDesc.getDependsOnIds());
	}
		
	/**
	 * 
	 * @param startKind
	 * @return
	 */
	private static ServiceStartKind transformToServiceStartKind(org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.StartupKind startKind) {
		switch( startKind) {
		case STARTUP:
			return ServiceStartKind.STARTUP;
		case LAZY:
			return ServiceStartKind.LAZY;
		default:
			return ServiceStartKind.STARTUP;
		}
	}

	/**
	 * Create a {@link ServiceDescriptor} from a {@link AbstractServiceIdDesc}.
	 * @param serviceDesc
	 * @return
	 */
	public static ServiceDescriptor toServiceDescriptor(AliasDesc serviceDesc) {
		
		return new AliasDescriptor(serviceDesc.getName(), serviceDesc.getAliasedServiceId(), serviceDesc.getPriority());
	}


}
