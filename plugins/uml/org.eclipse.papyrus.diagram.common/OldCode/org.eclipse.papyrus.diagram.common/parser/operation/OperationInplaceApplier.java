/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Michael Golubev (Borland) - initial API and implementation
 */

package org.eclipse.papyrus.diagram.common.parser.operation;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.diagram.common.parser.ApplyStrategy;
import org.eclipse.papyrus.diagram.common.parser.BasicApplyStrategy;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.UMLPackage;

public class OperationInplaceApplier extends BasicApplyStrategy implements ApplyStrategy {

	private static final UMLPackage UML = UMLPackage.eINSTANCE;

	@Override
	public List/* 1.5 <ICommand> */apply(EObject modelObject, EObject parsedObject) {
		List output = new LinkedList();
		assertOperation(modelObject);
		assertOperation(parsedObject);
		Operation model = (Operation) modelObject;
		Operation parsed = (Operation) parsedObject;

		transferValue(output, model, parsed, UML.getNamedElement_Visibility());
		transferValue(output, model, parsed, UML.getNamedElement_Name());
		transferValue(output, model, parsed, UML.getOperation_IsQuery());
		transferValue(output, model, parsed, UML.getOperation_IsOrdered());
		transferValue(output, model, parsed, UML.getOperation_IsUnique());
		transferValue(output, model, parsed, UML.getRedefinableElement_RedefinedElement());

		// XXX parameters may have incoming references, try to preserve them
		// match parameters and transfer their features one by one instead of total delete-create
		transferValue(output, model, parsed, UML.getBehavioralFeature_OwnedParameter());

		return output.isEmpty() ? NOT_EXECUTABLE : output;
	}

	protected void assertOperation(EObject object) {
		if (false == object instanceof Operation) {
			throw new IllegalStateException("Operation expected: " + object); //$NON-NLS-1$
		}
	}

}
