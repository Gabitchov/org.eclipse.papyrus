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
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.graphics.Rectangle;
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
		 final Text text = super.createEditorControl(parent);
         
         //this listener allows us to initialize the text widget wit the best size in order to display the full lines of the text
         text.addControlListener(new ControlListener() {

                @Override
                public void controlResized(ControlEvent e) {
                       final Rectangle bounds = text.getBounds();
                       final int nbLines = text.getLineCount();
                       text.removeControlListener(this);
                       if(nbLines > 1) {
                              text.setBounds(bounds.x, bounds.y, bounds.width, getBestHeight(text));
                       }
                       text.removeControlListener(this);

                }

                /**
                * 
                 * @see org.eclipse.swt.events.ControlListener#controlMoved(org.eclipse.swt.events.ControlEvent)
                * 
                 * @param e
                */
                @Override
                public void controlMoved(ControlEvent e) {
                       // nothing to do 
                }
         });
         return text;
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
			 //we resize the text widget in order to display all lines
            final Rectangle bounds = text.getBounds();
            text.setBounds(bounds.x, bounds.y, bounds.width, getBestHeight(text));
		} else {
			super.keyPressed(parent, text, event);
		}
	}
	
    /**
    * 
     * @param text
    * the text widget
    * @return
    * the best height for the text widget according to the number of new line in the text + the height ot a line
    */
    protected final int getBestHeight(final Text text){
          return (text.getLineCount()+1)* text.getLineHeight();
    }
}
