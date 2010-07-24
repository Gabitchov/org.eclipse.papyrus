/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte, Generalitat 
 * de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Francisco Javier Cano Muñoz (Prodevelop) – Initial implementation.
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.common.util;

import org.eclipse.emf.ecore.EObject;

// TODO: Auto-generated Javadoc
/**
 * Wrapper interface for generated model switches.
 * 
 * @param <T>
 *        *
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 */
public interface EcoreSwitch<T, I> {

	/**
	 * Retrieves the info stored in this switch.
	 * 
	 * @return the info
	 */
	I getInfo();

	/**
	 * Sets the info in this switch.
	 * 
	 * @param info
	 *        the info
	 */
	void setInfo(I info);

	/**
	 * Performs the switch action. Extra necessary info is available via the getInfo() method.
	 * 
	 * @param eObject
	 *        the e object
	 * 
	 * @return the T
	 */
	T doSwitch(EObject eObject);

}
