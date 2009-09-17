/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.clazz.custom.parsers;

import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.papyrus.diagram.clazz.parsers.MessageFormatParser;

public class CustomMessageFormatParser extends MessageFormatParser {

	/** this is the ref ereference in order to obtain the obtain which feature will be displayed **/
	private EStructuralFeature eRefFeature;

	/** this is the index of object that we look for **/
	private int objectIndex;

	public CustomMessageFormatParser(EAttribute[] features, EStructuralFeature eRefFeature, int objectIndex) {
		super(features);
		this.eRefFeature = eRefFeature;
		this.objectIndex = objectIndex;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getEditString(IAdaptable adapter, int flags) {
		IAdaptable reachedObject = obtainObject(adapter);
		if (reachedObject != null) {
			return super.getEditString(reachedObject, flags);
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public ICommand getParseCommand(IAdaptable adapter, String newString, int flags) {
		IAdaptable reachedObject = obtainObject(adapter);
		if (reachedObject != null) {
			return super.getParseCommand(reachedObject, newString, flags);
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getPrintString(IAdaptable adapter, int flags) {
		IAdaptable reachedObject = obtainObject(adapter);
		if (reachedObject != null) {
			return super.getPrintString(reachedObject, flags);
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public IParserEditStatus isValidEditString(IAdaptable adapter, String editString) {
		IAdaptable reachedObject = obtainObject(adapter);
		if (reachedObject != null) {
			return super.isValidEditString(reachedObject, editString);
		}
		return null;
	}

	/**
	 * this method returns the object that is link to the elemtn by an Ereference
	 * 
	 * @param adapter
	 *            the element where we look for the good element
	 * @return the associated element
	 */
	protected IAdaptable obtainObject(IAdaptable adapter) {
		EObject element = (EObject) adapter.getAdapter(EObject.class);
		Object result = element.eGet(eRefFeature);
		// this is a collection
		if (result instanceof List<?>) {
			// the index is coherent
			if (((List<?>) result).size() > objectIndex) {
				EObject object = (EObject) ((List<?>) result).get(objectIndex);
				return new EObjectAdapter(object);
			}
			// the index is not coherent
			return null;
		} else {
			// this not a collection
			if (objectIndex == 0) {
				return new EObjectAdapter((EObject) result);
			}
		}
		return null;
	}
}
