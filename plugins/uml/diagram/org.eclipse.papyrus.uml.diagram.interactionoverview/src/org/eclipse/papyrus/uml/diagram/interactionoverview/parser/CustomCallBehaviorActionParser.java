/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.interactionoverview.parser;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.uml.diagram.activity.parser.custom.CallBehaviorActionParser;
import org.eclipse.uml2.uml.CallBehaviorAction;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.UMLPackage;

public class CustomCallBehaviorActionParser extends CallBehaviorActionParser {

	public CustomCallBehaviorActionParser() {
		super(new EAttribute[]{});
	}

	@Override
	public String getPrintString(final IAdaptable element, final int flags) {
		final Object obj = EMFHelper.getEObject(element);
		if(obj instanceof CallBehaviorAction) {
			final CallBehaviorAction action = (CallBehaviorAction)obj;
			String behaviorName = "";
			if(action.getBehavior() != null && action.getBehavior().getName() != null) {
				behaviorName = action.getBehavior().getName();
			}
			// display behavior name alone if name is not specified differently
			if(!"".equals(behaviorName)) {
				return behaviorName;
			}
		}
		return " ";
	}

	@Override
	public String getEditString(final IAdaptable element, final int flags) {
		final Object obj = EMFHelper.getEObject(element);
		if(obj instanceof CallBehaviorAction) {
			final CallBehaviorAction action = (CallBehaviorAction)obj;
			String behaviorName = "";
			if(action.getBehavior() != null && action.getBehavior().getName() != null) {
				behaviorName = action.getBehavior().getName();
			}
			// display behavior name alone if name is not specified differently
			if(!"".equals(behaviorName)) {
				return behaviorName;
			}
		}
		return " ";
	}

	@Override
	public ICommand getParseCommand(final IAdaptable adapter, final String newString, final int flags) {
		if(newString == null) {
			return UnexecutableCommand.INSTANCE;
		}
		final EObject element = EMFHelper.getEObject(adapter);
		final TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(element);
		if(editingDomain == null) {
			return UnexecutableCommand.INSTANCE;
		}
		final CompositeTransactionalCommand command = new CompositeTransactionalCommand(editingDomain, "Set Values"); //$NON-NLS-1$
		if(element instanceof CallBehaviorAction) {
			final Interaction interactionUse = (Interaction)(((CallBehaviorAction)element).getBehavior());
			command.compose(getModificationCommand(interactionUse, UMLPackage.eINSTANCE.getNamedElement_Name(), newString));
		}
		return command;
	}

}
