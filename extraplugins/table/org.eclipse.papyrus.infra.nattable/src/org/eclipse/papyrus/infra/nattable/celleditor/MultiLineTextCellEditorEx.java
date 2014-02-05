/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		Vincent Lorenzo (CEA-LIST) - vincent.lorenzo@cea.fr
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.celleditor;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.keys.IBindingService;

/**
 * 
 * @author VL222926
 *         This multi line cell editor has the same behavior than spreadsheet (ALT+ENTER (Excel)for new line and ENTER to commit).
 *         To get this behavior, we desactivate the filtering done by org.eclipse.e4.ui.bindings.keys.KeyBindingDispatcher. This class
 *         set event.doit==false if the keypressed are binding for eclipse command (ALT-ENTER is registered to show property view)
 * 
 *         //TODO : the next version of nattable seems support this behavior with ALT-ENTER,
 */
public class MultiLineTextCellEditorEx extends MultiLineTextCellEditor {

	/**
	 * boolean indicating if the eclipse filter was activated when the editor has been created
	 */
	private boolean initialValueForFilteringKeyPress;

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public MultiLineTextCellEditorEx() {
		super();
		this.commitOnEnter = true;
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param lineWrap
	 */
	public MultiLineTextCellEditorEx(boolean lineWrap) {
		super(lineWrap);
		this.commitOnEnter = true;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.celleditor.MultiLineTextCellEditor#createEditorControl(org.eclipse.swt.widgets.Composite)
	 * 
	 * @param parent
	 * @return
	 */
	@Override
	public Text createEditorControl(Composite parent) {
		IBindingService service = (IBindingService)PlatformUI.getWorkbench().getService(IBindingService.class);
		this.initialValueForFilteringKeyPress = service.isKeyFilterEnabled();
		if(this.initialValueForFilteringKeyPress) {
			service.setKeyFilterEnabled(false);
		}
		return super.createEditorControl(parent);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.celleditor.TextCellEditor#close()
	 * 
	 */
	@Override
	public void close() {
		if(this.initialValueForFilteringKeyPress) {
			IBindingService service = (IBindingService)PlatformUI.getWorkbench().getService(IBindingService.class);
			service.setKeyFilterEnabled(this.initialValueForFilteringKeyPress);
		}
		super.close();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.celleditor.TextCellEditor#keyPressed(org.eclipse.swt.widgets.Composite, org.eclipse.swt.widgets.Text,
	 *      org.eclipse.swt.events.KeyEvent)
	 * 
	 * @param parent
	 * @param text
	 * @param event
	 */
	@Override
	protected void keyPressed(Composite parent, Text text, KeyEvent event) {
		if(event.stateMask == SWT.ALT && (event.keyCode == SWT.CR || event.keyCode == SWT.KEYPAD_CR)) {
			text.insert(text.getLineDelimiter());
		} else {
			super.keyPressed(parent, text, event);
		}
	}
}
