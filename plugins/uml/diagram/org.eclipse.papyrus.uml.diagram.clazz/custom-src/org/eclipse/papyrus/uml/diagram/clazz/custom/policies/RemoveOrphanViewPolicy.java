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
 *  Patrick Tessier (CEA LIST) Patrick.Tessier@cea.fr - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.clazz.custom.policies;

import org.eclipse.papyrus.uml.diagram.common.editpolicies.OrphanViewPolicy;

/**
 * this policy is used to suppress orphan node view in GMF view the policy to remove orphan
 * connection is more complex. It is dependent of the diagram. see remove OrphanConnectionView
 * policy in clazzdiagram
 * 
 */
public class RemoveOrphanViewPolicy extends OrphanViewPolicy {

	public int[] notOrphanNode = { 7034, 7001, 7002, 7003, 7004, 7014, 7005, 7006, 7007, 7008, 7009, 7022, 7023, 7024, 7025, 7026, 7027, 7028, 7029, 7030, 7031, 7010, 7011, 7013, 7032, 7033, 7015, 7016, 7017, 7018, 7019, 7020, 7021, 4016 };

	public RemoveOrphanViewPolicy() {
		super();
		init(notOrphanNode);
	}
}
