/*******************************************************************************
 * Copyright (c) 2009, 2011, 2012 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Nicolas Bros (Mia-Software) - initial API and implementation
 *    Nicolas Guyomar (Mia-Software) - Bug 349546 - EMF Facet facetSet editor
 *    Alban Ménager (Soft-Maint) - Bug 387470 - [EFacet][Custom] Editors
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.util.emf.ui.internal.exported.util.composite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.papyrus.emf.facet.util.emf.ui.internal.Messages;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.composite.FilteredElementSelectionComposite;
import org.eclipse.swt.widgets.Composite;

/**
 * A control to select an {@link EClass}, that can be filtered using the
 * associated text field.
 * 
 * @since 0.3
 */
public class EClassifierSelectionControl<T extends EClassifier> extends
		FilteredElementSelectionComposite {

	private final Map<String, T> stringToEClass = new HashMap<String, T>();
	private final Class<? extends EClassifier> eTypeSel;
	private String metamodelNsUri;

	public EClassifierSelectionControl(final Composite parent,
			final String metamodelNsUri, final Class<? extends T> eTypeSel) {
		super(parent, true, false);
		this.eTypeSel = eTypeSel;
		this.metamodelNsUri = metamodelNsUri;
	}

	public void updateList(final String metamodelNsUri2) {
		this.metamodelNsUri = metamodelNsUri2;
		final EPackage ePackage = EPackage.Registry.INSTANCE
				.getEPackage(this.metamodelNsUri);
		if (ePackage != null) {
			final List<String> eClasses = new ArrayList<String>();
			final EList<EClassifier> eClassifiers = ePackage.getEClassifiers();
			addElements(eClasses, eClassifiers);
			if (eClasses.isEmpty()) {
				eClasses.add(Messages.No_result_found);
				setEnabled(false);
			} else {
				setEnabled(true);
			}
			setElements(eClasses.toArray());
		}
	}

	private void addElements(final List<String> eClasses,
			final EList<? extends EClassifier> eClassifiers) {
		for (final EClassifier eClassifier : eClassifiers) {
			if (this.eTypeSel.isInstance(eClassifier)) {
				eClasses.add(eClassifier.getName());
				@SuppressWarnings("unchecked")
				// @SuppressWarnings("unchecked") checked by the surrounding if
				final T eClassifier2 = (T) eClassifier;
				this.stringToEClass.put(eClassifier.getName(), eClassifier2);
			}
		}
	}

	public T getSelectedEClassifier() {
		T result = null;
		final Object[] selectElements = getSelectedElements();
		if ((selectElements != null) && (selectElements.length > 0)
				&& this.stringToEClass.containsKey(selectElements[0])) {
			result = this.stringToEClass.get(selectElements[0]);
		}
		return result;
	}
}
