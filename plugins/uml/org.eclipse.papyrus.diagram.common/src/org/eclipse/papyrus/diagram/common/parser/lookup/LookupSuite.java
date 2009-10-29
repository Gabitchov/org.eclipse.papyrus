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

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

public interface LookupSuite {

	// @unused
	public <T> Lookup<T> getLookup(Class<T> clazz);

	public static final Lookup NULL_LOOKUP = new Lookup() {

		public Object lookup(String name, EObject context) {
			return null;
		}

		public List getResolutionElementTypes() {
			return Collections.emptyList();
		}
	};

	// @unused
	public static final LookupSuite NULL_SUITE = new LookupSuite() {

		public <T> Lookup<T> getLookup(Class<T> clazz) {
			return NULL_LOOKUP;
		}
	};

}
