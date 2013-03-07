/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.search.ui.providers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.uml.search.ui.pages.PapyrusSearchPage;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * 
 * A content provider for a ePackage
 * 
 */
public class ParticipantTypeContentProvider implements ITreeContentProvider {

	private EPackage ePackage = null;

	PapyrusSearchPage papyrusSearchPage = null;

	public ParticipantTypeContentProvider(PapyrusSearchPage papyrusSearchPage) {
		this.papyrusSearchPage = papyrusSearchPage;
	}

	public void dispose() {

	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

	}

	public Object[] getElements(Object inputElement) {
		List<EObject> result = new ArrayList<EObject>();
		if(inputElement instanceof EPackage) {
			ePackage = (EPackage)inputElement;

			for(EClassifier classifier : ePackage.getEClassifiers()) {
				if(classifier instanceof EClass) {
					if(papyrusSearchPage != null) {
						if(papyrusSearchPage.getSearchAllStringAttributes()) {
							result.add(classifier);
						} else {

							if(classifier == UMLPackage.eINSTANCE.getNamedElement()) {
								result.add(classifier);
							}
							EList<EClass> supers = ((EClass)classifier).getEAllSuperTypes();
							if(supers.contains(UMLPackage.eINSTANCE.getNamedElement())) {
								result.add(classifier);
							}
						}

					} else {
						result.add(classifier);
					}
				}
			}

		}

		return result.toArray();
	}

	public Object[] getChildren(Object parentElement) {
		return null;
	}

	public Object getParent(Object element) {

		return null;
	}

	public boolean hasChildren(Object element) {
		return false;
	}
}
