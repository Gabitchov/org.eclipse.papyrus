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
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

/**
 * 
 * A content provider for a ePackage
 * 
 */
public class ParticipantTypeContentProvider implements ITreeContentProvider {




	private HashMap<ParticipantTypeElement, List<ParticipantTypeAttribute>> participantsList = new HashMap<ParticipantTypeElement, List<ParticipantTypeAttribute>>();




	public ParticipantTypeContentProvider() {
	}

	public void dispose() {

	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		participantsList = (HashMap<ParticipantTypeElement, List<ParticipantTypeAttribute>>)newInput;
	}

	public Object[] getElements(Object inputElement) {


		List<Object> result = new ArrayList<Object>();

		if(inputElement instanceof HashMap) {
			return ((HashMap)inputElement).keySet().toArray();
		}

		
		return result.toArray();
	}

	public Object[] getChildren(Object parentElement) {
		if(parentElement instanceof ParticipantTypeElement) {
			if(!(parentElement instanceof ParticipantTypeAttribute)) {
				return participantsList.get(parentElement).toArray();
			}
		}
		return null;

	}

	public Object getParent(Object element) {


		return null;

	}

	public boolean hasChildren(Object element) {
		if(element instanceof ParticipantTypeAttribute) {
			return false;
		} else {
			if(getChildren(element).length > 0)
				return true;
			else
				return false;
		}

	}
}
