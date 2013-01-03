/*
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.papyrus.uml.diagram.timing.part;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.common.ui.URIEditorInput;

/**
 * @generated
 */
@SuppressWarnings("all")
// disable warnings on generated code
public class UMLUriEditorInputTester extends PropertyTester {

	/**
	 * @generated
	 */
	public boolean test(final Object receiver, final String method, final Object[] args, final Object expectedValue) {
		if (false == receiver instanceof URIEditorInput) {
			return false;
		}
		final URIEditorInput editorInput = (URIEditorInput) receiver;
		return "PapyrusUMLTiming_diagram".equals(editorInput.getURI().fileExtension()); //$NON-NLS-1$
	}

}
