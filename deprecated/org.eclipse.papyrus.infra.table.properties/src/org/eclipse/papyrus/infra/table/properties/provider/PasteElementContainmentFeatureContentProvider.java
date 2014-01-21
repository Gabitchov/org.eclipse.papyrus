/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.table.properties.provider;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrusTableInstance;
import org.eclipse.papyrus.infra.widgets.providers.AbstractStaticContentProvider;


public class PasteElementContainmentFeatureContentProvider extends AbstractStaticContentProvider implements ITreeContentProvider {

	private PapyrusTableInstance contextTable;

	public PasteElementContainmentFeatureContentProvider(PapyrusTableInstance contextTable) {
		this.contextTable = contextTable;
	}

	public EClass[] getElements() {
		EObject context = contextTable.getTable().getContext();

		if(context == null) {
			return new EClass[0];
		}

		EClass contextMetaclass = context.eClass();
		return new EClass[]{ contextMetaclass };
	}

	public EReference[] getChildren(Object parentElement) {
		if(parentElement instanceof EClass) {
			EClass contextMetaclass = (EClass)parentElement;
			List<EReference> result = new LinkedList<EReference>();
			for(EReference reference : contextMetaclass.getEAllReferences()) {
				if(reference.isContainment() && reference.getUpperBound() != 1) {
					result.add(reference);
				}
			}
			return result.toArray(new EReference[result.size()]);
		}

		return new EReference[0];
	}

	public Object getParent(Object element) {
		if(element instanceof EReference) {
			return ((EReference)element).getEContainingClass();
		}
		return null;
	}

	public boolean hasChildren(Object element) {
		return getChildren(element).length > 0;
	}

}
