/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan Faure (Atos Origin) tristan.faure@atosorigin.com - Initial API and implementation
 *
  *****************************************************************************/
package org.eclipse.papyrus.diagramprofile.parsers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.resource.ResourcePackage;

public abstract class ResourceEObjectParserProvider extends AbstractProvider implements IParserProvider {

	//private IProviderChangeListener myListener;

	private ResourceEObjectParser resourceEObjectParser;

	/**
	 * returns the label from the current eobject to access base element please do self.base_...
	 * 
	 * @return
	 */
	public abstract String getOclRule();

	/**
	 * @return the target type to determine if the operation can be performed
	 */
	public abstract String getTargetType();

	/**
	 * @return the structural feature to display and edit
	 */
	public abstract EStructuralFeature getEStructuralFeatureFromOCLResult();

	/**
	 * @see org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider#getParser(org.eclipse.core.runtime.IAdaptable)
	 */
	public IParser getParser(IAdaptable hint) {
		resourceEObjectParser = new ResourceEObjectParser(getOclRule(), getEStructuralFeatureFromOCLResult());
		return resourceEObjectParser;
	}

	/**
	 * @see org.eclipse.gmf.runtime.common.core.service.IProvider#provides(org.eclipse.gmf.runtime.common.core.service.IOperation)
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			GetParserOperation pOperation = (GetParserOperation) operation;
			IElementType type = (IElementType) pOperation.getHint().getAdapter(IElementType.class);
			return getTargetType() != null
					&& getTargetType().equals((String) pOperation.getHint().getAdapter(String.class))
					&& ResourcePackage.Literals.RESOURCE_EOBJECT.isSuperTypeOf(type.getEClass());
		}
		return false;
	}

}
