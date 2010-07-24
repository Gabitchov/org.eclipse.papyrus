/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.blockdiagram.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.providers.UMLParserProvider;
import org.eclipse.papyrus.sysml.blocks.BlocksPackage;
import org.eclipse.papyrus.sysml.diagram.blockdiagram.edit.part.BlockNameEditPart;
import org.eclipse.papyrus.sysml.diagram.blockdiagram.parsers.BlockNameParser;
import org.eclipse.papyrus.sysml.diagram.blockdiagram.part.SysmlVisualIDRegistry;
import org.eclipse.uml2.uml.UMLPackage;


/**
 * @generated
 */
public class SysmlParserProvider extends UMLParserProvider {

	private IParser block_2001Parser;

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch(visualID) {
		case BlockNameEditPart.VISUAL_ID:
			return getBlock_2001Parser();
		}

		return super.getParser(visualID);
	}



	/**
	 * @generated
	 */
	public IParser getParser(IAdaptable hint) {
		String vid = (String)hint.getAdapter(String.class);
		if(vid != null) {
			return getParser(SysmlVisualIDRegistry.getVisualID(vid));
		}
		View view = (View)hint.getAdapter(View.class);
		if(view != null) {
			return getParser(SysmlVisualIDRegistry.getVisualID(view));
		}
		return super.getParser(hint);
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if(operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation)operation).getHint();
			if(SysmlElementTypes.getElement(hint) == null) {
				return false;
			}
			return getParser(hint) != null;
		}
		return super.provides(operation);
	}

	/**
	 * @generated
	 */
	private IParser getBlock_2001Parser() {
		if(block_2001Parser == null) {
			EAttribute[] features = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name(), BlocksPackage.eINSTANCE.getBlock_IsEncapsulated() };
			EAttribute[] editablefeatures = new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() };
			BlockNameParser parser = new BlockNameParser(features, editablefeatures);
			block_2001Parser = parser;
		}
		return block_2001Parser;
	}

}
