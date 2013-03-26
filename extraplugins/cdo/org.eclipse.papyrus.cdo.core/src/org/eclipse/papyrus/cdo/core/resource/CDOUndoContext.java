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
package org.eclipse.papyrus.cdo.core.resource;

import java.util.Set;

import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.cdo.internal.core.l10n.Messages;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;


/**
 * A CDO-specific undo context that records at the level of objects the scope of what is affected by an operation.
 */
public final class CDOUndoContext implements IUndoContext {

	private final Set<EObject> affectedObjects;

	private String cachedLabel;

	/**
	 * Initializes me with a non-empty aggregate of affected objects.
	 * 
	 * @param affectedObjects
	 *        the affected objects to record
	 * 
	 * @throws IllegalArgumentException
	 *         if the {@code affectedObjects} is empty
	 */
	public CDOUndoContext(Iterable<? extends EObject> affectedObjects) {
		super();

		if(Iterables.isEmpty(affectedObjects)) {
			throw new IllegalArgumentException("affectedObjects is empty"); //$NON-NLS-1$
		}

		this.affectedObjects = ImmutableSet.copyOf(affectedObjects);
	}

	/**
	 * Obtains an immutable set of the objects affected by the operation.
	 * 
	 * @return my affected objects. This set is immutable
	 */
	public Set<EObject> getAffectedObjects() {
		return affectedObjects;
	}

	public boolean matches(IUndoContext context) {
		return (context instanceof CDOUndoContext) && !Sets.intersection(getAffectedObjects(), ((CDOUndoContext)context).getAffectedObjects()).isEmpty();
	}

	public String getLabel() {
		if(cachedLabel == null) {
			StringBuilder buf = new StringBuilder();
			Joiner.on(", ").appendTo(buf, Iterables.limit(affectedObjects, 3)); //$NON-NLS-1$
			if(affectedObjects.size() > 3) {
				buf.append(", ..."); //$NON-NLS-1$
			}

			cachedLabel = NLS.bind(Messages.CDOUndoContext_0, buf);
		}

		return cachedLabel;
	}

	@Override
	public String toString() {
		return getLabel();
	}
}
