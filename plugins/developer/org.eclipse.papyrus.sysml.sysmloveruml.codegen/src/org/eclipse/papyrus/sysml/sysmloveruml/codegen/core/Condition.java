/**
 *  Copyright (c) 2011 Atos.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *  Atos - Initial API and implementation
 * 
 */
package org.eclipse.papyrus.sysml.sysmloveruml.codegen.core;

import org.eclipse.emf.codegen.ecore.genmodel.GenBase;

/**
 * Condition on a GenBase to say if a generator has to be used with this {@link GenBase}.
 * 
 * @author Arthur Daussy <a
 *         href="mailto:arthur.daussy@atos.net">arthur.daussy@atos.net</a>
 * @param <T>
 *        Element inherited from {@link GenBase} to calculate the condition
 */
public interface Condition<T extends GenBase> {

	/**
	 * Tell if the condition is true with the parameter.
	 * 
	 * @param gen
	 *        T
	 * @return true if the condition relate to T is true
	 */
	boolean canGenerate(T gen);
}
