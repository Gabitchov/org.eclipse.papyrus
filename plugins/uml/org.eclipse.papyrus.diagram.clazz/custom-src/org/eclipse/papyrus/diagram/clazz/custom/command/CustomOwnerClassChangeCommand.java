/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Fadoi LAKHAL  Fadoi.Lakhal@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.clazz.custom.command;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.uml2.uml.Classifier;

public class CustomOwnerClassChangeCommand extends AbstractTransactionalCommand {

	public static final String CUSTOMREMOVE_COMMAND = "CustomremoveCommand";

	private Classifier classifier;

	public CustomOwnerClassChangeCommand(TransactionalEditingDomain domain, Classifier containedclassifier) {
		super(domain, CUSTOMREMOVE_COMMAND, null);
		classifier = containedclassifier;

	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		Classifier sourceClassifier = (Classifier)classifier.getOwner();
		if(sourceClassifier instanceof org.eclipse.uml2.uml.Class) {
			org.eclipse.uml2.uml.Class sourceClass = (org.eclipse.uml2.uml.Class)sourceClassifier;
			org.eclipse.uml2.uml.Class targetClass = (org.eclipse.uml2.uml.Class)classifier;
			targetClass.setPackage(sourceClass.getPackage());
			EList<Classifier> listNestedClassifier = sourceClass.getNestedClassifiers();
			listNestedClassifier.remove(targetClass);
		}
		return CommandResult.newOKCommandResult();
	}

}
