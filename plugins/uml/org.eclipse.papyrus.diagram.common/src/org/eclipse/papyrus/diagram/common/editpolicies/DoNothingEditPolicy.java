/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Michael Golubev (Borland) - initial API and implementation
 */
package org.eclipse.papyrus.diagram.common.editpolicies;

import org.eclipse.gef.editpolicies.AbstractEditPolicy;

/**
 * Effectively NULL EditPolicy.
 * 
 * The only purpose of this class is to use it with gmfgen.GenNode#customBehavior in order to
 * <b>remove</b> some other edit-policy defined for some well-known key.
 */
public class DoNothingEditPolicy extends AbstractEditPolicy {
	//
}
