/*******************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Nicolas Bros (Mia-Software) - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.facet.widgets.celleditors.internal.ui;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public class FeatureValuesInput {
	private final EStructuralFeature feature;
	private final EObject source;

	public FeatureValuesInput(final EStructuralFeature feature, final EObject source) {
		this.feature = feature;
		this.source = source;
	}

	public EStructuralFeature getFeature() {
		return this.feature;
	}

	public EObject getSource() {
		return this.source;
	}
}