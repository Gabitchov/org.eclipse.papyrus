/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.modelexplorer.widgets;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

/**
 * A Content Provider returning all subclasses of the given
 * class, contained in the input EPackage.
 * 
 * The metaclassNotWanted are removed from the result.
 * 
 * @author Camille Letavernier
 * 
 */
public class MetaclassContentProvider implements IStructuredContentProvider {

	protected Object type;

	protected List<Object> metaclassNotWanted;

	protected MetaclassContentProvider(Object type, List<Object> metaclassNotWanted) {
		this.type = type;
		this.metaclassNotWanted = metaclassNotWanted;
	}

	public MetaclassContentProvider(EClass type, List<Object> metaclassNotWanted) {
		this.type = type;
		this.metaclassNotWanted = metaclassNotWanted;
	}

	public void dispose() {
		// Nothing
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// Nothing
	}

	public Object[] getElements(Object inputElement) {
		if(type == null || !(type instanceof EClass)) {
			return new Object[0];
		}

		EClass wantedEClass = (EClass)type;

		EPackage ePackage;
		if(inputElement instanceof EPackage) {
			ePackage = (EPackage)inputElement;
		} else {
			return new Object[0];
		}

		List<EClass> result = new LinkedList<EClass>();

		for(EClassifier eClassifier : ePackage.getEClassifiers()) {
			if(eClassifier instanceof EClass) {
				EClass eClass = (EClass)eClassifier;
				if(wantedEClass.isSuperTypeOf(eClass)) {
					result.add(eClass);
				}
			}
		}

		result.removeAll(metaclassNotWanted);

		Collections.sort(result, new EclassComparator());

		return result.toArray();
	}

}
