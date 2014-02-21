/*******************************************************************************
 * Copyright (c) 2011 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Nicolas Guyomar (Mia-Software) - Bug 349569 - Need new exceptions for java query class creation
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.query.java.core.internal.exceptions;

/**
 * This exception is raised whenever the class being created already exists.
 * @since 0.2
 */
public class ClassAlreadyExistsException extends Exception {

	private static final long serialVersionUID = -7352916272441579074L;

}