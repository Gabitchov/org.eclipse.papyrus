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

package org.eclipse.papyrus.diagram.common.parser;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public interface ExternalToString {

	public String getToString(EObject object, int flags);

	public boolean isAffectingFeature(EStructuralFeature feature);

	public static final ExternalToString NOT_IMPLEMENTED = new ExternalToString() {

		public String getToString(EObject object, int flags) {
			return "-NOT-IMPLEMENTED-";
		}

		public boolean isAffectingFeature(EStructuralFeature feature) {
			return false;
		}
	};

	public static interface WithReferences extends ExternalToString {

		public List getAdditionalReferencedElements(EObject object);
	}
}
