/*******************************************************************************
 * Copyright (c) 2009, 2011 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Nicolas Bros (Mia-Software) - initial API and implementation
 *    Nicolas Guyomar (Mia-Software) - Bug 349546 - EMF Facet facetSet editor
 *******************************************************************************/
package org.eclipse.emf.facet.efacet.ui.internal.widget;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.facet.efacet.ui.internal.Messages;
import org.eclipse.emf.facet.efacet.ui.internal.composites.FilteredElementSelectionComposite;
import org.eclipse.emf.facet.efacet.ui.internal.composites.SelectETypeComposite.ETypeSelectionOptions;
import org.eclipse.swt.widgets.Composite;

/**
 * A control to select an {@link EClass}, that can be filtered using the associated text field.
 */
public class EClassifierSelectionControl extends FilteredElementSelectionComposite {

	private final Map<String, EClassifier> stringToEClassifierMap = new HashMap<String, EClassifier>();
	private final ETypeSelectionOptions eTypeSelectionOption;
	private String metamodelNsUri;

	public EClassifierSelectionControl(final Composite parent, final String metamodelNsUri, final ETypeSelectionOptions eTypeSelectionOption) {
		super(parent, true, false);
		this.eTypeSelectionOption = eTypeSelectionOption;
		this.metamodelNsUri = metamodelNsUri;
	}

	public void updateList(final String metamodelNsUri2) {
		this.metamodelNsUri = metamodelNsUri2;
		EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(this.metamodelNsUri);
		if (ePackage != null) {
			List<String> eClasses = new ArrayList<String>();
			EList<EClassifier> eClassifiers = ePackage.getEClassifiers();
			if (this.eTypeSelectionOption == ETypeSelectionOptions.ECLASS) {
				for (EClassifier eClassifier : eClassifiers) {
					if (eClassifier instanceof EClass) {
						eClasses.add(eClassifier.getName());
						this.stringToEClassifierMap.put(eClassifier.getName(), eClassifier);
					}
				}
			} else if (this.eTypeSelectionOption == ETypeSelectionOptions.EDATATYPE) {
				for (EClassifier eClassifier : eClassifiers) {
					if (eClassifier instanceof EDataType) {
						eClasses.add(eClassifier.getName());
						this.stringToEClassifierMap.put(eClassifier.getName(), eClassifier);
					}
				}

			} else {
				for (EClassifier eClassifier : eClassifiers) {
					eClasses.add(eClassifier.getName());
					this.stringToEClassifierMap.put(eClassifier.getName(), eClassifier);
				}
			}
			if (eClasses.isEmpty()) {
				eClasses.add(Messages.No_result_found);
				setEnabled(false);
			} else {
				setEnabled(true);
			}
			setElements(eClasses.toArray());
		}
	}

	public EClassifier getSelectedEClassifier() {
		Object[] selectElements = getSelectedElements();
		if (selectElements != null && selectElements.length > 0) {
			if (this.stringToEClassifierMap.containsKey(selectElements[0])) {
				return this.stringToEClassifierMap.get(selectElements[0]);
			}
		}
		return null;
	}
}
