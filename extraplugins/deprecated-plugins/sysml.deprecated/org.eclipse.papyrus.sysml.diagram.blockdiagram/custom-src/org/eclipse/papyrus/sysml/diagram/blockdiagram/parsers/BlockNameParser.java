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
package org.eclipse.papyrus.sysml.diagram.blockdiagram.parsers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.papyrus.sysml.blocks.Block;
import org.eclipse.papyrus.sysml.blocks.BlocksPackage;
import org.eclipse.uml2.uml.UMLPackage;


public class BlockNameParser extends SysMLMessageFormatParser {

	public BlockNameParser(EAttribute[] features, EAttribute[] editableFeatures) {
		super(features, editableFeatures);
	}

	@Override
	protected boolean isValidFeature(EStructuralFeature feature) {
		return super.isValidFeature(feature) || BlocksPackage.eINSTANCE.getBlock_IsEncapsulated().equals(feature);
	}

	@Override
	public String getPrintString(IAdaptable adapter, int flags) {
		Object element = adapter.getAdapter(EObject.class);
		StringBuffer sb = new StringBuffer();
		if(element instanceof Block) {
			Block block = (Block)element;
			sb.append("<<Block>>\n");
			if(block.getBase_Class() != null) {
				// Set the name
				sb.append(block.getBase_Class().getName());
			}
			if(block.isIsEncapsulated()) {
				sb.append("\n").append("{encapsulated}");
			}

		}
		return sb.toString();
	}

	@Override
	protected Object getValue(EObject element, EAttribute feature) {
		if(UMLPackage.eINSTANCE.getNamedElement_Name().equals(feature) && element instanceof Block) {
			Block block = (Block)element;
			return super.getValue(block.getBase_Class(), feature);
		}
		return super.getValue(element, feature);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getParseCommand(IAdaptable adapter, Object[] values, int flags) {
		if(values == null || validateNewValues(values).getCode() != IParserEditStatus.EDITABLE) {
			return UnexecutableCommand.INSTANCE;
		}
		EObject element = (EObject)adapter.getAdapter(EObject.class);
		if(element instanceof Block) {
			element = ((Block)element).getBase_Class();
		}
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(element);
		if(editingDomain == null) {
			return UnexecutableCommand.INSTANCE;
		}
		CompositeTransactionalCommand command = new CompositeTransactionalCommand(editingDomain, "Set Values"); //$NON-NLS-1$
		for(int i = 0; i < values.length; i++) {
			command.compose(getModificationCommand(element, editableFeatures[i], values[i]));
		}
		return command;
	}

}
