/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.cdo.internal.core;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.cdo.core.IPapyrusRepository;
import org.eclipse.papyrus.cdo.core.IResourceSetDisposalApprover;

import com.google.common.collect.Lists;

/**
 * This is the CompositeResourceSetDisposalApprover type. Enjoy.
 */
class CompositeResourceSetDisposalApprover
		implements IResourceSetDisposalApprover {

	private final List<IResourceSetDisposalApprover> approvers = Lists
		.newArrayListWithExpectedSize(1);

	CompositeResourceSetDisposalApprover() {
		super();
	}

	public DisposeAction disposalRequested(IPapyrusRepository repository,
			Collection<ResourceSet> resourceSets) {
		
		DisposeAction result = DisposeAction.CLOSE;

		if (!resourceSets.isEmpty() && !approvers.isEmpty()) {
			for (IResourceSetDisposalApprover next : approvers) {
				DisposeAction action = wrapNull(next
					.disposalRequested(repository, resourceSets));

				result = result.compareTo(action) > 0
					? action
					: result;

				if (result == DisposeAction.NONE) {
					// no need to consult anyone else
					break;
				}
			}
		}

		return result;
	}

	private DisposeAction wrapNull(DisposeAction action) {
		return (action == null)
			? DisposeAction.NONE
			: action;
	}

	void addApprover(IResourceSetDisposalApprover approver) {
		if (!approvers.contains(approver)) {
			approvers.add(approver);
		}
	}

	void removeApprover(IResourceSetDisposalApprover approver) {
		approvers.remove(approver);
	}
}
