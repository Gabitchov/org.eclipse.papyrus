package org.eclipse.papyrus.qompass.designer.core.transformations.filters;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Comment;

import org.eclipse.papyrus.qompass.designer.core.listeners.CopyListener;
import org.eclipse.papyrus.qompass.designer.core.transformations.Copy;

/**
 * Do not copy comments
 * 
 * @author ansgar
 * 
 */
public class FilterComments implements CopyListener {

	public static FilterComments getInstance() {
		if(instance == null) {
			instance = new FilterComments();
		}
		return instance;
	}

	public EObject copyEObject(Copy copy, EObject sourceEObj) {
		if(sourceEObj instanceof Comment) {
			return null;
		}
		return sourceEObj;
	}

	private static FilterComments instance = null;
}
