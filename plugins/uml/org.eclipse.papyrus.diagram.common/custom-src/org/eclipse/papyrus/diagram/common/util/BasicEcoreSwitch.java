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
 * Basic implementation of an <EcoreSwitch>, with info available for the Switch.
 * 
 * @param <T>
 *            the type returned by the doSwitch() method
 * @param <I>
 *            the type of the info
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 */
public abstract class BasicEcoreSwitch<T, I> implements EcoreSwitch<T, I> {

	/** The info. */
	I info = null;

	/**
	 * Basic constructor.
	 */
	public BasicEcoreSwitch() {
		;
	}

	/**
	 * Constructor with info.
	 * 
	 * @param info
	 *            the info
	 */
	public BasicEcoreSwitch(I info) {
		this.info = info;
	}

	/**
	 * Gets the info, if any.
	 * 
	 * @return the info
	 */
	public I getInfo() {
		return info;
	}

	/*
	 * (non-Javadoc)
	 * 
	 */
	public void setInfo(I info) {
		this.info = info;
	}

	/**
	 * TODO: to be implemented by specializers.
	 * 
	 * @param object
	 *            the object
	 * 
	 * @return the T
	 */
	public abstract T doSwitch(EObject object);

}
