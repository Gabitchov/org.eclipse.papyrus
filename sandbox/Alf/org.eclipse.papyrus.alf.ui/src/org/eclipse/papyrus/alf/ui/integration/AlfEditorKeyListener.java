/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.alf.ui.integration;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.VerifyKeyListener;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Element;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorModelAccess;

@SuppressWarnings("restriction")
public class AlfEditorKeyListener extends KeyAdapter implements VerifyKeyListener {
	
	protected Element contextElement ;
	
	protected EmbeddedEditorModelAccess embeddedEditorAccess ;
	
	protected TransactionalEditingDomain editingDomain ;
	
	protected Object[] args ;
	
	public AlfEditorKeyListener(Element contextElement, Object[] args, EmbeddedEditorModelAccess editorModelAccess) {
		super();
		this.contextElement = contextElement ;
		this.embeddedEditorAccess = editorModelAccess;
		this.args = args ;
		editingDomain = (TransactionalEditingDomain)EMFHelper.resolveEditingDomain(contextElement) ;
	}

	@Override
	public void keyPressed(KeyEvent event) {
		int keyCode = event.keyCode;
		if ((event.stateMask & SWT.CTRL) != 0 && ((keyCode == SWT.KEYPAD_CR) || (keyCode == SWT.CR))) {
			boolean success = new AlfSerializer().serialize(this.contextElement, embeddedEditorAccess.getSerializedModel(), this.args) ;
			int messageDialogKind = success ? MessageDialog.INFORMATION : MessageDialog.ERROR ;
			String message = "" ;
			if (success) {
				message += "- Alf statements successfully compiled.\n" ;
				message += "- Textual representation comment successfully generated or updated" ;
				MessageDialog.open(messageDialogKind, Display.getCurrent().getActiveShell(), "Serialization info", message, SWT.NONE) ;
			}
			else {
				message += "- Compilation failed.\n" ;
				message += "- Textual representation comment successfully generated or updated" ;
				MessageDialog.open(messageDialogKind, Display.getCurrent().getActiveShell(), "Serialization info", message, SWT.NONE) ;
			}
		}
		if ((event.stateMask & SWT.ALT) != 0 && ((keyCode == SWT.KEYPAD_CR) || (keyCode == SWT.CR))) {
			boolean success = new AlfSerializer().validate(this.contextElement, embeddedEditorAccess.getSerializedModel(), this.args) ;
			int messageDialogKind = success ? MessageDialog.INFORMATION : MessageDialog.ERROR ;
			String message = "" ;
			if (success) {
				message += "Specification is valid." ;
				MessageDialog.open(messageDialogKind, Display.getCurrent().getActiveShell(), "Validation info", message, SWT.NONE) ;
			}
			else {
				message += "Validation failed" ;
				MessageDialog.open(messageDialogKind, Display.getCurrent().getActiveShell(), "Validation info", message, SWT.NONE) ;
			}
		}
	}

	public void verifyKey(VerifyEvent event) {
		if ((event.stateMask & SWT.CTRL) != 0 && ((event.keyCode == SWT.KEYPAD_CR) || (event.keyCode == SWT.CR))) {
			event.doit = false;
		}
		if ((event.stateMask & SWT.ALT) != 0 && ((event.keyCode == SWT.KEYPAD_CR) || (event.keyCode == SWT.CR))) {
			event.doit = false;
		}
	}

}
