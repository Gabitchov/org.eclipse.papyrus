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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.uml.service.types.utils.EMFUtil;
import org.eclipse.uml2.uml.Actor;
import org.eclipse.uml2.uml.Association;

/**
 * Advice to restrict {@link Association} creation in SysML
 */
public class PackageEditHelperAdvice extends AbstractEditHelperAdvice {

	/**
	 * {@inheritDoc}
	 * 
	 * In case of {@link Association} creation, it should not be possible to target an association as target end.
	 */
	@Override
	protected ICommand getBeforeCreateRelationshipCommand(CreateRelationshipRequest request) {
		// test if the creation is for a SysML association

		IElementType type = request.getElementType();
		if(hasSuperType(type, SysMLElementTypes.ASSOCIATION)) {
			// test source and target...
			EObject target = request.getTarget();
			if(target instanceof Association || target == null) {
				return UnexecutableCommand.INSTANCE;
			}

			if (!(hasSuperType(type, SysMLElementTypes.ASSOCIATION_NONE_DIRECTED) || hasSuperType(type, SysMLElementTypes.ASSOCIATION_COMPOSITE_DIRECTED) || hasSuperType(type, SysMLElementTypes.ASSOCIATION_SHARED_DIRECTED))) {
				// The association is bidirectional. Check if that is possible.
				
				// The target can be read-only only if the association is directed.
				if (EMFUtil.isReadOnly(target)) {
					return UnexecutableCommand.INSTANCE;
				}
				// association should be directed to the actor. In this case, the property is owned by the association, not by the actor
				if (target instanceof Actor) {
					return UnexecutableCommand.INSTANCE;
				}
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
