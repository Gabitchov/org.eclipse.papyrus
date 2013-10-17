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

package org.eclipse.papyrus.qompass.designer.core;

import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Port;

/**
 * Information about a port that might belong to an extended port
 * It provides information about that port while taking the (optional) parent
 * port into account
 */
public class PortInfo {
	/**
	 * Create a new portInfo.
	 * @param port
	 * @param parentPort optional parent port (null, if no parent port exist, i.e. if this is not an extended port)
	 */
	public PortInfo (Port port, Port parentPort) {
		this.port = port;
		this.parentPort = parentPort;
	}
	
	/**
	 * Create a new port info for a combination of Port and sub-port. Compared to the constructor,
	 * the order of sub and parent port is inverted. The function is useful, if the sub-port is optional
	 * @param port a port
	 * @param subPort an optional supPort.
	 * @return
	 */
	public static PortInfo fromSubPort(Port port, Port subPort) {
		if (subPort != null) {
			return new PortInfo(subPort, port);
		}
		else {
			return new PortInfo (port, null);
		}
	}
	
	/**
	 * @return The name of a port. Might be a composite name in case of an extended port
	 */
	public String getName() {
		if (parentPort != null) {
			return parentPort.getName() + "_" + port.getName(); //$NON-NLS-1$
		}
		else {
			return port.getName();
		}
	}
	
	/**
	 * @return the interface provided by a port or sub-port. Takes conjugation of the parent port into account
	 */
	public Interface getProvided() {
		if ((parentPort != null) && parentPort.isConjugated()) {
			return PortUtils.getRequired(port);
		}
		else {
			return PortUtils.getProvided(port);
		}
	}

	/**
	 * @return the interface required by a port or sub-port. Takes conjugation of the parent port into account
	 */	
	public Interface getRequired() {
		if ((parentPort != null) && parentPort.isConjugated()) {
			return PortUtils.getProvided(port);
		}
		else {
			return PortUtils.getRequired(port);
		}
	}	

	/**
	 * @return true, if port is conjugated. Takes conjugation of the parent port into account
	 */
	public boolean isConjugated() {
		if (parentPort != null) {
			return port.isConjugated() != parentPort.isConjugated();
		}
		else {
			return port.isConjugated();
		}
	}
	
	/**
	 * TODO: take multiplicity of parent-port into account
	 *
	 * @return upper multiplicity of port
	 */
	public int getUpper() {
		return port.getUpper();
	}
	
	/**
	 * @return the described port or sub-port
	 */
	public Port getPort() {
		return port;
	}
	
	/**
	 * @return Return the port of the original model, i.e. the parent port, if the port is actually
	 *   a sub-port or the original port, if it is not.
	 *   This function is useful for testing delegation relationships (which could not exist for a
	 *   sub-port)
	 */
	public Port getModelPort() {
		if (parentPort != null) {
			return parentPort;
		}
		else {
			return port;
		}
	}
	
	protected Port port;
	
	protected Port parentPort;
}
