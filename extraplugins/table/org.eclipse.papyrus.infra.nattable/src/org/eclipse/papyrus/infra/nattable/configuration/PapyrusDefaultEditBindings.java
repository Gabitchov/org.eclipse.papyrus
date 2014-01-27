/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		 Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.configuration;

import org.eclipse.nebula.widgets.nattable.config.AbstractUiBindingConfiguration;
import org.eclipse.nebula.widgets.nattable.edit.action.CellEditDragMode;
import org.eclipse.nebula.widgets.nattable.edit.action.KeyEditAction;
import org.eclipse.nebula.widgets.nattable.edit.action.MouseEditAction;
import org.eclipse.nebula.widgets.nattable.edit.config.DefaultEditBindings;
import org.eclipse.nebula.widgets.nattable.grid.GridRegion;
import org.eclipse.nebula.widgets.nattable.painter.cell.CheckBoxPainter;
import org.eclipse.nebula.widgets.nattable.ui.binding.UiBindingRegistry;
import org.eclipse.nebula.widgets.nattable.ui.matcher.CellEditorMouseEventMatcher;
import org.eclipse.nebula.widgets.nattable.ui.matcher.CellPainterMouseEventMatcher;
import org.eclipse.nebula.widgets.nattable.ui.matcher.KeyEventMatcher;
import org.eclipse.nebula.widgets.nattable.ui.matcher.LetterOrDigitKeyEventMatcher;
import org.eclipse.nebula.widgets.nattable.ui.matcher.MouseEventMatcher;
import org.eclipse.swt.SWT;

/**
 * 
 * @author VL222926
 *         Copy of {@link DefaultEditBindings} excepted for edition on double click replacing edition on single click
 */
public class PapyrusDefaultEditBindings extends AbstractUiBindingConfiguration {

	/**
	 * 
	 * @see org.eclipse.nebula.widgets.nattable.config.IConfiguration#configureUiBindings(org.eclipse.nebula.widgets.nattable.ui.binding.UiBindingRegistry)
	 * 
	 * @param uiBindingRegistry
	 */
	@Override
	public void configureUiBindings(UiBindingRegistry uiBindingRegistry) {
		//configure the space key to activate a cell editor via keyboard
		//this is especially useful for changing the value for a checkbox
		uiBindingRegistry.registerKeyBinding(new KeyEventMatcher(SWT.NONE, 32), new KeyEditAction());
		uiBindingRegistry.registerKeyBinding(new KeyEventMatcher(SWT.NONE, SWT.F2), new KeyEditAction());
		uiBindingRegistry.registerKeyBinding(new LetterOrDigitKeyEventMatcher(), new KeyEditAction());
		uiBindingRegistry.registerKeyBinding(new LetterOrDigitKeyEventMatcher(SWT.SHIFT), new KeyEditAction());

		uiBindingRegistry.registerDoubleClickBinding(new CellEditorMouseEventMatcher(GridRegion.BODY), new MouseEditAction());

		uiBindingRegistry.registerMouseDragMode(new CellEditorMouseEventMatcher(GridRegion.BODY), new CellEditDragMode());

		uiBindingRegistry.registerFirstSingleClickBinding(new CellPainterMouseEventMatcher(GridRegion.BODY, MouseEventMatcher.LEFT_BUTTON, CheckBoxPainter.class), new MouseEditAction());

		uiBindingRegistry.registerFirstMouseDragMode(new CellPainterMouseEventMatcher(GridRegion.BODY, MouseEventMatcher.LEFT_BUTTON, CheckBoxPainter.class), new CellEditDragMode());

	}

}
