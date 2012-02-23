/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.service.types.helper.advice;

import java.util.Arrays;
import java.util.List;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.uml2.uml.Actor;
import org.eclipse.uml2.uml.Association;


/**
 * Advice to restrict {@link Association} creation in SysML
 */
public class ActorEditHelperAdvice extends AbstractEditHelperAdvice {

	/**
	 * {@inheritDoc}
	 * 
	 * In case of {@link Association} creation, it should not be possible to have an {@link Actor} as source.
	 */
	@Override
	protected ICommand getBeforeCreateRelationshipCommand(CreateRelationshipRequest request) {
		IElementType type = request.getElementType();
		if(SysMLElementTypes.ASSOCIATION.equals(type)) {
			return UnexecutableCommand.INSTANCE;
		}
		if(type != null) {
			List<IElementType> superTypes = Arrays.asList(type.getAllSuperTypes());
			if(superTypes.contains(SysMLElementTypes.ASSOCIATION)) {
				return UnexecutableCommand.INSTANCE;
			}

		}
		return super.getBeforeCreateRelationshipCommand(request);
	}

	protected boolean hasSuperType(IElementType elementType, IElementType typeToTest) {
		if(elementType == null || typeToTest == null) {
			return false;
		}

		if(elementType.equals(typeToTest)) {
			return true;
		}

		List<IElementType> superTypes = Arrays.asList(elementType.getAllSuperTypes());
		if(superTypes.contains(typeToTest)) {
			return true;
		}

		return false;
	}
}
