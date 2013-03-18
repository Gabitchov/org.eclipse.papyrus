package org.eclipse.papyrus.infra.nattable.provider;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.grid.GridRegion;
import org.eclipse.nebula.widgets.nattable.layer.LabelStack;
import org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell;
import org.eclipse.nebula.widgets.nattable.style.DisplayMode;
import org.eclipse.papyrus.infra.nattable.manager.AbstractNattableWidgetManager;
import org.eclipse.papyrus.infra.nattable.manager.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.ILabelConfiguration;
import org.eclipse.papyrus.infra.nattable.utils.Constants;
import org.eclipse.papyrus.infra.nattable.utils.ILabelProviderCellContextElement;
import org.eclipse.papyrus.infra.nattable.utils.ILabelProviderContextElement;
import org.eclipse.papyrus.infra.nattable.utils.LabelProviderCellContextElement;
import org.eclipse.papyrus.infra.nattable.utils.LocationValue;
import org.eclipse.papyrus.infra.nattable.utils.NattableConfigAttributes;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;


public class NattableCellLabelProvider extends AbstractNattableCellLabelProvider {


	/**
	 * 
	 * @param cell
	 * @param configRegistry
	 * @return
	 */
	protected String getColumnHeaderLabel(final ILayerCell cell, final IConfigRegistry configRegistry) {
		final INattableModelManager manager = configRegistry.getConfigAttribute(NattableConfigAttributes.NATTABLE_MODEL_MANAGER_CONFIG_ATTRIBUTE, DisplayMode.NORMAL, NattableConfigAttributes.NATTABLE_MODEL_MANAGER_ID);
		final ILabelConfiguration labelConfiguration = manager.getVerticalAxisProvider().getAxisConfiguration().getLabelConfiguration();
		final String labelContext = labelConfiguration.getLabelProviderContext();
		if(labelContext != null) {
			return getLabel(cell, configRegistry, labelContext);
		} else {
			return getLabel(cell, configRegistry, Constants.HEADER_LABEL_PROVIDER_CONTEXT);
		}
	}

	/**
	 * 
	 * @param cell
	 * @param configRegistry
	 * @return
	 */
	protected String getRowHeaderLabel(final ILayerCell cell, final IConfigRegistry configRegistry) {
		final INattableModelManager manager = configRegistry.getConfigAttribute(NattableConfigAttributes.NATTABLE_MODEL_MANAGER_CONFIG_ATTRIBUTE, DisplayMode.NORMAL, NattableConfigAttributes.NATTABLE_MODEL_MANAGER_ID);
		final ILabelConfiguration labelConfiguration = manager.getHorizontalAxisProvider().getAxisConfiguration().getLabelConfiguration();
		final String labelContext = labelConfiguration.getLabelProviderContext();
		if(labelContext != null) {
			return getLabel(cell, configRegistry, labelContext);
		} else {
			return getLabel(cell, configRegistry, Constants.HEADER_LABEL_PROVIDER_CONTEXT);
		}
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.provider.AbstractNattableCellLabelProvider#getText(java.lang.Object)
	 * 
	 * @param element
	 * @return
	 */
	@Override
	public String getText(Object element) {
		final ILayerCell cell = ((ILabelProviderCellContextElement)element).getCell();
		final IConfigRegistry configRegistry = ((ILabelProviderContextElement)element).getConfigRegistry();
		LabelStack labels = cell.getConfigLabels();
		if(labels.getLabels().isEmpty()){
			//in case of copy, we don't have the label
			final INattableModelManager manager = configRegistry.getConfigAttribute(NattableConfigAttributes.NATTABLE_MODEL_MANAGER_CONFIG_ATTRIBUTE, DisplayMode.NORMAL, NattableConfigAttributes.NATTABLE_MODEL_MANAGER_ID);
			labels = ((AbstractNattableWidgetManager)manager).getGridLayer().getBodyLayer().getConfigLabelsByPosition(cell.getColumnPosition(), cell.getRowPosition());
		}
		
		if(labels.hasLabel(GridRegion.COLUMN_HEADER)) {
			return getColumnHeaderLabel(cell, configRegistry);
		} else if(labels.hasLabel(GridRegion.ROW_HEADER)) {
			return getRowHeaderLabel(cell, configRegistry);
		} else if(labels.hasLabel(GridRegion.BODY)) {
			return getBodyLabel(cell, configRegistry);
		} else if(labels.getLabels().size() == 0) {
			
		}
		Object value = cell.getDataValue();
		if(value != null) {
			return value.toString();
		}
		return "";
	}

	/**
	 * 
	 * @param cell
	 * @param configRegistry
	 * @param labelproviderContext
	 * @return
	 */
	protected String getLabel(final ILayerCell cell, final IConfigRegistry configRegistry, final String labelproviderContext) {
		String txt = "";
		Object value = cell.getDataValue();
		if(value instanceof Integer || value instanceof String) {
			txt = value.toString();
		} else {
			final ILabelProviderContextElement contextElement = new LabelProviderCellContextElement(cell, configRegistry);
			LabelProviderService serv = configRegistry.getConfigAttribute(NattableConfigAttributes.LABEL_PROVIDER_SERVICE_CONFIG_ATTRIBUTE, DisplayMode.NORMAL, NattableConfigAttributes.LABEL_PROVIDER_SERVICE_ID);
			ILabelProvider labelProvider = serv.getLabelProvider(labelproviderContext, contextElement);
			if(labelProvider != null) {
				return labelProvider.getText(contextElement);
			} else {
				labelProvider = serv.getLabelProvider(labelproviderContext, value);
				if(labelProvider != null) {
					txt = labelProvider.getText(value);
				} else {
					labelProvider = serv.getLabelProvider(value);
					if(labelProvider != null) {
						txt = labelProvider.getText(value);
					} else {
						txt = value.toString();
					}
				}
			}
		}
		return txt;
	}

	/**
	 * 
	 * @param cell
	 * @param configRegistry
	 * @return
	 */
	protected String getBodyLabel(final ILayerCell cell, final IConfigRegistry configRegistry) {//Body or data grid?
		return getLabel(cell, configRegistry, Constants.BODY_LABEL_PROVIDER_CONTEXT);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.provider.AbstractNattableCellLabelProvider#accept(java.lang.Object)
	 * 
	 * @param element
	 * @return
	 */
	public boolean accept(Object element) {
		return element instanceof ILabelProviderCellContextElement;
	}

}
