/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.extendedtypes.types;

import java.net.URL;

import org.eclipse.gmf.runtime.emf.type.core.IContainerDescriptor;
import org.eclipse.gmf.runtime.emf.type.core.IElementMatcher;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.SpecializationType;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelperAdvice;
import org.eclipse.papyrus.infra.extendedtypes.ICreationElementValidator;


/**
 * @author RS211865
 */
public class ExtendedHintedElementType extends SpecializationType implements IExtendedHintedElementType {

	private String semanticHint;

	protected ICreationElementValidator creationElementValidator;
	
	/**
	 * @param id
	 * @param iconURL
	 * @param displayName
	 * @param elementTypes
	 * @param matcher
	 * @param descriptor
	 * @param editHelperAdvice
	 * @param iElementCreationValidator 
	 */
	public ExtendedHintedElementType(String id, URL iconURL, String displayName, IElementType[] elementTypes, IElementMatcher matcher, IContainerDescriptor descriptor, IEditHelperAdvice editHelperAdvice, String semanticHint, ICreationElementValidator creationElementValidator) {
		super(id, iconURL, displayName, elementTypes, matcher, descriptor, editHelperAdvice);
		this.semanticHint = semanticHint;
		this.creationElementValidator = creationElementValidator;
	}

	/**
	 * Gets the semantic hint.
	 */
	public String getSemanticHint() {
		return semanticHint;
	}

	/**
	 * {@inheritDoc}
	 */
	public ICreationElementValidator getCreationElementValidator() {
		return creationElementValidator;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "Extended Type: "+getDisplayName()+" ["+getId()+"]";
	}
}
