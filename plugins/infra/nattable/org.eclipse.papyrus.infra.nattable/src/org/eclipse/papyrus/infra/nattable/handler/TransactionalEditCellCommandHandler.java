/*
 * Copyright (c) 2014 CEA and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus (CEA) - Initial API and implementation
 *   Dirk Fauth <dirk.fauth@gmail.com> - Initial API and implementation of EditController class
 *
 */
package org.eclipse.papyrus.infra.nattable.handler;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.window.Window;
import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.config.IEditableRule;
import org.eclipse.nebula.widgets.nattable.edit.ActiveCellEditorRegistry;
import org.eclipse.nebula.widgets.nattable.edit.EditConfigAttributes;
import org.eclipse.nebula.widgets.nattable.edit.EditTypeEnum;
import org.eclipse.nebula.widgets.nattable.edit.ICellEditHandler;
import org.eclipse.nebula.widgets.nattable.edit.InlineEditHandler;
import org.eclipse.nebula.widgets.nattable.edit.command.EditCellCommand;
import org.eclipse.nebula.widgets.nattable.edit.command.UpdateDataCommand;
import org.eclipse.nebula.widgets.nattable.edit.editor.ICellEditor;
import org.eclipse.nebula.widgets.nattable.edit.gui.CellEditDialogFactory;
import org.eclipse.nebula.widgets.nattable.edit.gui.ICellEditDialog;
import org.eclipse.nebula.widgets.nattable.layer.ILayer;
import org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell;
import org.eclipse.nebula.widgets.nattable.style.DisplayMode;
import org.eclipse.nebula.widgets.nattable.widget.EditModeEnum;
import org.eclipse.papyrus.infra.nattable.Activator;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;


/**
 * A variant of the {@link EditCellCommand} handler that executes changes on a {@link TransactionalEditingDomain}'s command-stack.
 */
public class TransactionalEditCellCommandHandler extends TransactionalCommandHandler<EditCellCommand> {

	public TransactionalEditCellCommandHandler(TransactionalEditingDomain domain) {
		this(domain, "Edit Table Cell");
	}

	public TransactionalEditCellCommandHandler(TransactionalEditingDomain domain, String label) {
		super(domain, label);
	}

	@Override
	public Class<EditCellCommand> getCommandClass() {
		return EditCellCommand.class;
	}

	protected boolean doCommand(EditCellCommand command) {
		ILayerCell cell = command.getCell();
		Composite parent = command.getParent();
		IConfigRegistry configRegistry = command.getConfigRegistry();

		IEditableRule rule = (IEditableRule)configRegistry.getConfigAttribute(EditConfigAttributes.CELL_EDITABLE_RULE, DisplayMode.EDIT, cell.getConfigLabels().getLabels());

		if(rule.isEditable(cell, configRegistry)) {
			return editCell(cell, parent, cell.getDataValue(), configRegistry);
		}

		return false;
	}

	// From Nebula EditController (with minor tweaks)
	protected boolean editCell(ILayerCell cell, Composite parent, Object initialCanonicalValue, IConfigRegistry configRegistry) {
		boolean result = false;

		try {
			Rectangle cellBounds = cell.getBounds();
			ILayer layer = cell.getLayer();

			int columnPosition = cell.getColumnPosition();
			int rowPosition = cell.getRowPosition();

			List<String> configLabels = cell.getConfigLabels().getLabels();

			ICellEditor cellEditor = (ICellEditor)configRegistry.getConfigAttribute(EditConfigAttributes.CELL_EDITOR, DisplayMode.EDIT, configLabels);

			// Try to open an in-line editor before falling back to a dialog
			if(cellEditor.openInline(configRegistry, configLabels)) {
				ICellEditHandler editHandler = new InlineEditHandler(layer, columnPosition, rowPosition);

				Rectangle editorBounds = layer.getLayerPainter().adjustCellBounds(columnPosition, rowPosition, new Rectangle(cellBounds.x, cellBounds.y, cellBounds.width, cellBounds.height));

				cellEditor.activateCell(parent, initialCanonicalValue, EditModeEnum.INLINE, editHandler, cell, configRegistry);

				Control editorControl = cellEditor.getEditorControl();
				if((editorControl != null) && (!(editorControl.isDisposed()))) {
					editorControl.setBounds(editorBounds);

					cellEditor.addEditorControlListeners();
					ActiveCellEditorRegistry.registerActiveCellEditor(cellEditor);
					result = true;
				}
			} else {
				// The dialog case
				List<ILayerCell> cells = new ArrayList<ILayerCell>(1);
				cells.add(cell);
				result = editCells(cells, parent, initialCanonicalValue, configRegistry);
			}
		} catch (OperationCanceledException e) {
			// OK.  The user cancelled a dialog or some such
			result = false;
		} catch (Exception e) {
			Activator.log.error("Uncaught exception in table cell editor activation.", e); //$NON-NLS-1$
		}

		return result;
	}

	// From Nebula EditController (with minor tweaks)
	protected boolean editCells(List<ILayerCell> cells, Composite parent, Object initialCanonicalValue, IConfigRegistry configRegistry) {
		if((cells == null) || (cells.isEmpty())) {
			return false;
		}

		ICellEditor cellEditor = (ICellEditor)configRegistry.getConfigAttribute(EditConfigAttributes.CELL_EDITOR, "EDIT", ((ILayerCell)cells.get(0)).getConfigLabels().getLabels());

		if((cells.size() != 1) && ((cells.size() <= 1) || !(supportMultiEdit(cells, cellEditor, configRegistry)))) {
			return false;
		}

		boolean result = false;

		ICellEditDialog dialog = CellEditDialogFactory.createCellEditDialog((parent != null) ? parent.getShell() : null, initialCanonicalValue, (ILayerCell)cells.get(0), cellEditor, configRegistry);

		int returnValue = dialog.open();

		if(returnValue == Window.OK) {
			result = true;

			for(ILayerCell selectedCell : cells) {
				Object editorValue = dialog.getCommittedValue();
				if(dialog.getEditType() != EditTypeEnum.SET) {
					editorValue = dialog.calculateValue(selectedCell.getDataValue(), editorValue);
				}
				ILayer layer = selectedCell.getLayer();

				layer.doCommand(new UpdateDataCommand(layer, selectedCell.getColumnPosition(), selectedCell.getRowPosition(), editorValue));
			}
		}

		return result;
	}

	// From Nebula EditController (with minor tweaks)
	private static boolean supportMultiEdit(List<ILayerCell> cells, ICellEditor cellEditor, IConfigRegistry configRegistry) {
		for(ILayerCell cell : cells) {
			if(!(cellEditor.supportMultiEdit(configRegistry, cell.getConfigLabels().getLabels()))) {
				return false;
			}
		}
		return true;
	}
}
