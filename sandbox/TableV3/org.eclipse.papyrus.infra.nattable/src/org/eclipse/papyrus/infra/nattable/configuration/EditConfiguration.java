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

import org.eclipse.nebula.widgets.nattable.config.AbstractRegistryConfiguration;
import org.eclipse.nebula.widgets.nattable.config.CellConfigAttributes;
import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.data.convert.IDisplayConverter;
import org.eclipse.nebula.widgets.nattable.data.validate.IDataValidator;
import org.eclipse.nebula.widgets.nattable.edit.EditConfigAttributes;
import org.eclipse.nebula.widgets.nattable.edit.editor.ICellEditor;
import org.eclipse.nebula.widgets.nattable.layer.cell.ColumnOverrideLabelAccumulator;
import org.eclipse.nebula.widgets.nattable.painter.cell.ICellPainter;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.commands.Activator;
import org.eclipse.papyrus.infra.emf.providers.EMFLabelProvider;
import org.eclipse.papyrus.infra.nattable.accumulator.CustomRowOverrideLabelAccumulator;
import org.eclipse.papyrus.infra.nattable.celleditor.configs.IAxisCellEditorConfiguration;
import org.eclipse.papyrus.infra.nattable.celleditor.factory.AbstractCellEditorConfigurationFactory;
import org.eclipse.papyrus.infra.nattable.celleditor.factory.CellEditorConfigurationFactoryRegistry;
import org.eclipse.papyrus.infra.nattable.layerstack.BodyLayerStack;
import org.eclipse.papyrus.infra.nattable.manager.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.messages.Messages;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.CellEditorDeclaration;


/**
 * 
 * The configuration for the edition of the table
 * 
 */
public class EditConfiguration extends AbstractRegistryConfiguration {

	/**
	 * the model manager
	 */
	private final INattableModelManager modelManager;

	private Collection<String> messagesAlreadyDisplayed = new ArrayList<String>();

	//FIXME : remove this field, the ModelManager must provides it
	private BodyLayerStack bodyLayerStack;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param modelManager
	 * @param bodyLayerStack
	 */
	public EditConfiguration(final INattableModelManager modelManager, final BodyLayerStack bodyLayerStack) {
		this.modelManager = modelManager;
		this.bodyLayerStack = bodyLayerStack;
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param modelManager
	 */
	public EditConfiguration(final INattableModelManager modelManager) {
		this.modelManager = modelManager;
	}

	public void configureRegistry(IConfigRegistry configRegistry) {
		final BodyLayerStack bodyLayerStack = this.bodyLayerStack;
		final Table table = this.modelManager.getTable();
		final CellEditorDeclaration editorDeclaration = this.modelManager.getTable().getEditorConfiguration().getEditorDeclaration();
		if(editorDeclaration.equals(CellEditorDeclaration.COLUMN)) {
			if(table.isInvertAxis()) {
				//we declared celleditor on row
				final CustomRowOverrideLabelAccumulator accumulator = new CustomRowOverrideLabelAccumulator(bodyLayerStack);
				declaredCellEditors(this.modelManager.getRowElementsList(), configRegistry, null, accumulator);
				bodyLayerStack.setConfigLabelAccumulator(accumulator);
			} else {
				final ColumnOverrideLabelAccumulator accumulator = new ColumnOverrideLabelAccumulator(bodyLayerStack);
				declaredCellEditors(this.modelManager.getColumnElementsList(), configRegistry, accumulator, null);
				bodyLayerStack.setConfigLabelAccumulator(accumulator);
			}
		} else if(editorDeclaration.equals(CellEditorDeclaration.ROW)) {
			if(table.isInvertAxis()) {
				//we declared celleditor on column
				final ColumnOverrideLabelAccumulator accumulator = new ColumnOverrideLabelAccumulator(bodyLayerStack);
				declaredCellEditors(this.modelManager.getColumnElementsList(), configRegistry, accumulator, null);
				bodyLayerStack.setConfigLabelAccumulator(accumulator);
			} else {
				final CustomRowOverrideLabelAccumulator accumulator = new CustomRowOverrideLabelAccumulator(bodyLayerStack);
				declaredCellEditors(this.modelManager.getRowElementsList(), configRegistry, null, accumulator);
				bodyLayerStack.setConfigLabelAccumulator(accumulator);
			}
		} else if(editorDeclaration.equals(CellEditorDeclaration.CELL)) {
			//not yet supported
			throw new UnsupportedOperationException(Messages.EditConfiguration_DeclarationNotYetSupported);
		}


	}

	private void declaredCellEditors(final List<Object> elements, final IConfigRegistry configRegistry, final ColumnOverrideLabelAccumulator columnAccumulator, final CustomRowOverrideLabelAccumulator rowAccumulator) {
		boolean declareOnColumn = columnAccumulator != null;
		boolean declareOnRow = rowAccumulator != null;
		assert declareOnColumn != declareOnRow;
		//currently we use only the EMF factory, in the future, we must use the global factory
		final CellEditorConfigurationFactoryRegistry factoryRegistry = CellEditorConfigurationFactoryRegistry.INSTANCE;

		for(int i = 0; i < elements.size(); i++) {//FIXME : verify if the column is editable!
			//FIXME : for containement feature : see oep.views.properties.
			// example : create Usecase in a class fro mthe property view : EcorePropertyEditorFactory create a popup to display available type 
			//then EditionDialog to edit the created object
			final Object current = elements.get(i);
			final AbstractCellEditorConfigurationFactory factory = factoryRegistry.getFirstCellEditorConfigurationFactory(null, current);
			if(factory != null) {
				final IAxisCellEditorConfiguration config = factory.getCellEditorConfiguration(modelManager.getTable(), current);
				if(config != null) {
					final String cellId = config.getConfigCellId();
					final String editorId = config.getEditorId() + Integer.toString(i);
					final ICellPainter painter = config.getCellPainter();
					final String displayMode = config.getDisplayMode();
					final IDisplayConverter converter = config.getDisplayConvert(new EMFLabelProvider());//FIXME
					final ICellEditor editor = config.getICellEditor(current, this.modelManager.getTableAxisElementProvider());
					final IDataValidator validator = config.getDataValidator();
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
					final String errorMessage = NLS.bind(Messages.EditConfiguration_ConfigurationNotFound, current);
					if(!messagesAlreadyDisplayed.contains(errorMessage)) {
						Activator.log.warn(errorMessage);
						messagesAlreadyDisplayed.add(errorMessage);
					}
				}
			} else {
				final String errorMessage = NLS.bind(Messages.EditConfiguration_ConfigurationFactoryNotFound, current);
				if(!messagesAlreadyDisplayed.contains(errorMessage)) {
					Activator.log.warn(errorMessage);
					messagesAlreadyDisplayed.add(errorMessage);
				}
			}
		}
	}

}
