/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Chokri Mraidha (CEA LIST) Chokri.Mraidha@cea.fr - Initial API and implementation
 *  Patrick Tessier (CEA LIST) Patrick.Tessier@cea.fr - modification
 *
 *****************************************************************************/
package org.eclipse.papyrus.profile.tree.objects;

import org.eclipse.emf.transaction.TransactionalEditingDomain;

// TODO: Auto-generated Javadoc
/**
 * The Class UserPrimitiveTypeValueTreeObject.
 */
public class UserPrimitiveTypeValueTreeObject extends PrimitiveTypeValueTreeObject {

	/**
	 * The Constructor.
	 * 
	 * @param value
	 *        the value
	 * @param parent
	 *        the parent
	 */
	public UserPrimitiveTypeValueTreeObject(AppliedStereotypePropertyTreeObject parent, Object value, TransactionalEditingDomain domain) {
		super(parent, value, domain);
	}
}
