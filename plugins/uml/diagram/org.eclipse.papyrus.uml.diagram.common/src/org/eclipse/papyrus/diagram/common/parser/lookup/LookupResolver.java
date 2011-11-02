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

package org.eclipse.papyrus.diagram.common.parser.lookup;

import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.uml2.uml.NamedElement;

public interface LookupResolver {

	// @unused
	public abstract void addLookupResolveRequest(LookupResolveRequest request, Callback callback);

	public abstract boolean isEmpty();

	public abstract boolean canResolve();

	// @unused
	public abstract AbstractTransactionalCommand getResolveCommand();

	public static interface Callback {

		public void lookupResolved(NamedElement resolution);
	}

	public static final LookupResolver NULL = new LookupResolver() {

		public boolean isEmpty() {
			return true;
		}

		public AbstractTransactionalCommand getResolveCommand() {
			return null;
		}

		public boolean canResolve() {
			return false;
		}

		public void addLookupResolveRequest(LookupResolveRequest request, Callback callback) {
			//
		}

	};

}
