/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.configuration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.nebula.widgets.nattable.config.CellConfigAttributes;
import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.data.convert.IDisplayConverter;
import org.eclipse.nebula.widgets.nattable.data.validate.IDataValidator;
import org.eclipse.nebula.widgets.nattable.edit.EditConfigAttributes;
import org.eclipse.nebula.widgets.nattable.edit.config.DefaultEditConfiguration;
import org.eclipse.nebula.widgets.nattable.edit.editor.ICellEditor;
import org.eclipse.nebula.widgets.nattable.layer.cell.ColumnOverrideLabelAccumulator;
import org.eclipse.nebula.widgets.nattable.painter.cell.ICellPainter;
import org.eclipse.nebula.widgets.nattable.style.DisplayMode;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.emf.providers.EMFLabelProvider;
import org.eclipse.papyrus.infra.nattable.Activator;
import org.eclipse.papyrus.infra.nattable.accumulator.CustomRowOverrideLabelAccumulator;
import org.eclipse.papyrus.infra.nattable.celleditor.config.CellEditorConfigurationFactory;
import org.eclipse.papyrus.infra.nattable.celleditor.config.IAxisCellEditorConfiguration;
import org.eclipse.papyrus.infra.nattable.layerstack.BodyLayerStack;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.messages.Messages;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.CellEditorDeclaration;
import org.eclipse.papyrus.infra.nattable.utils.NattableConfigAttributes;


/**
 * 
 * The configuration for the edition of the table
 * 
 */
public class EditConfiguration extends DefaultEditConfiguration {

	/**
	 * the list of the message already displayed
	 */
	private Collection<String> messagesAlreadyDisplayed = new ArrayList<String>();

	@Override
	public void configureRegistry(IConfigRegistry configRegistry) {
		super.configureRegistry(configRegistry);
		//we remove the default cell editor
		configRegistry.unregisterConfigAttribute(EditConfigAttributes.CELL_EDITOR, DisplayMode.NORMAL, null);

		INattableModelManager modelManager = configRegistry.getConfigAttribute(NattableConfigAttributes.NATTABLE_MODEL_MANAGER_CONFIG_ATTRIBUTE, DisplayMode.NORMAL, NattableConfigAttributes.NATTABLE_MODEL_MANAGER_ID);

		final BodyLayerStack bodyLayerStack = modelManager.getBodyLayerStack();
		final Table table = modelManager.getTable();
		final CellEditorDeclaration editorDeclaration = modelManager.getTable().getTableConfiguration().getCellEditorDeclaration();
		if(editorDeclaration.equals(CellEditorDeclaration.COLUMN)) {
			if(table.isInvertAxis()) {
				//we declared celleditor on row
				final CustomRowOverrideLabelAccumulator accumulator = new CustomRowOverrideLabelAccumulator(bodyLayerStack);
				declaredCellEditors(modelManager.getRowElementsList(), configRegistry, null, accumulator);
				bodyLayerStack.setConfigLabelAccumulator(accumulator);
			} else {
				final ColumnOverrideLabelAccumulator accumulator = new ColumnOverrideLabelAccumulator(bodyLayerStack);
				declaredCellEditors(modelManager.getColumnElementsList(), configRegistry, accumulator, null);
				bodyLayerStack.setConfigLabelAccumulator(accumulator);
			}
		} else if(editorDeclaration.equals(CellEditorDeclaration.ROW)) {
			if(table.isInvertAxis()) {
				//we declared celleditor on column
				final ColumnOverrideLabelAccumulator accumulator = new ColumnOverrideLabelAccumulator(bodyLayerStack);
				declaredCellEditors(modelManager.getColumnElementsList(), configRegistry, accumulator, null);
				bodyLayerStack.setConfigLabelAccumulator(accumulator);
			} else {
				final CustomRowOverrideLabelAccumulator accumulator = new CustomRowOverrideLabelAccumulator(bodyLayerStack);
				declaredCellEditors(modelManager.getRowElementsList(), configRegistry, null, accumulator);
				bodyLayerStack.setConfigLabelAccumulator(accumulator);
			}
		} else if(editorDeclaration.equals(CellEditorDeclaration.CELL)) {
			//not yet supported
			throw new UnsupportedOperationException(Messages.EditConfiguration_DeclarationNotYetSupported);
		}


	}

	private void declaredCellEditors(final List<Object> elements, final IConfigRegistry configRegistry, final ColumnOverrideLabelAccumulator columnAccumulator, final CustomRowOverrideLabelAccumulator rowAccumulator) {
		INattableModelManager modelManager = configRegistry.getConfigAttribute(NattableConfigAttributes.NATTABLE_MODEL_MANAGER_CONFIG_ATTRIBUTE, DisplayMode.NORMAL, NattableConfigAttributes.NATTABLE_MODEL_MANAGER_ID);
		boolean declareOnColumn = columnAccumulator != null;
		boolean declareOnRow = rowAccumulator != null;
		assert declareOnColumn != declareOnRow;
		final CellEditorConfigurationFactory factory = CellEditorConfigurationFactory.INSTANCE;
		List<String> existingEditorIds = new ArrayList<String>();
		for(int i = 0; i < elements.size(); i++) {
			//FIXME : for containement feature : see oep.views.properties.
			// example : create Usecase in a class from the property view : EcorePropertyEditorFactory create a popup to display available type 
			//then EditionDialog to edit the created object
			final Object current = elements.get(i);
			final Table table = modelManager.getTable();
			final IAxisCellEditorConfiguration config = factory.getFirstCellEditorConfiguration(table, current);
			if(config != null) {
				final ICellEditor editor = config.getICellEditor(table, current, modelManager.getTableAxisElementProvider());
				if(editor != null) {
					final String editorId = config.getEditorId() + Integer.toString(i);
					if(existingEditorIds.contains(editorId)) {
						org.eclipse.papyrus.infra.nattable.Activator.log.warn("Several editor have the same id");
					} else {
						existingEditorIds.add(editorId);
					}

					final String cellId = editorId + "_cellId"; //$NON-NLS-1$

					final ICellPainter painter = config.getCellPainter(table, current);
					final String displayMode = config.getDisplayMode(table, current);
					final IDisplayConverter converter = config.getDisplayConvert(current, table, new EMFLabelProvider());//FIXME : label provider + arg order

					final IDataValidator validator = config.getDataValidator(table, current);
					assert !cellId.equals(editorId);
					if(declareOnColumn) {
						columnAccumulator.registerColumnOverrides(i, editorId, cellId);
					} else {
						rowAccumulator.registerRowOverrides(i, editorId, cellId);
					}
					if(painter != null) {
						configRegistry.registerConfigAttribute(CellConfigAttributes.CELL_PAINTER, painter, displayMode, cellId);
					}
					configRegistry.registerConfigAttribute(EditConfigAttributes.CELL_EDITOR, editor, displayMode, editorId);

					if(converter != null) {
						configRegistry.registerConfigAttribute(CellConfigAttributes.DISPLAY_CONVERTER, converter, displayMode, cellId);
					}

					if(validator != null) {
						configRegistry.registerConfigAttribute(EditConfigAttributes.DATA_VALIDATOR, validator, displayMode, cellId);
					}
				} else {
					final String errorMessage = NLS.bind(Messages.EditConfiguration_FactoryHandlesElementButDoesntProvideEditor, config.getEditorId(), current);
					if(!this.messagesAlreadyDisplayed.contains(errorMessage)) {
						Activator.log.warn(errorMessage);
						this.messagesAlreadyDisplayed.add(errorMessage);
					}

				}
			} else {
				final String errorMessage = NLS.bind(Messages.EditConfiguration_ConfigurationNotFound, current);
				if(!this.messagesAlreadyDisplayed.contains(errorMessage)) {
					Activator.log.warn(errorMessage);
					this.messagesAlreadyDisplayed.add(errorMessage);
				}
			}
		}
	}

}
