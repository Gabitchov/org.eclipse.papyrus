package org.eclipse.papyrus.infra.nattable.provider;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.grid.GridRegion;
import org.eclipse.nebula.widgets.nattable.layer.LabelStack;
import org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell;
import org.eclipse.nebula.widgets.nattable.style.DisplayMode;
import org.eclipse.papyrus.infra.nattable.utils.Constants;
import org.eclipse.papyrus.infra.nattable.utils.ILabelProviderContextElement;
import org.eclipse.papyrus.infra.nattable.utils.LabelProviderContextElement;
import org.eclipse.papyrus.infra.nattable.utils.NattableConfigAttributes;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;


public class NattableCellLabelProvider extends AbstractNattableCellLabelProvider {


	/**
	 * 
	 * @param cell
	 * @param configRegistry
	 * @return
	 */
	protected String getHeaderLabel(final ILayerCell cell, final IConfigRegistry configRegistry) {
		return getLabel(cell, configRegistry, Constants.HEADER_LABEL_PROVIDER_CONTEXT);
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
		final ILayerCell cell = ((ILabelProviderContextElement)element).getCell();
		final IConfigRegistry configRegistry = ((ILabelProviderContextElement)element).getConfigRegistry();
		final LabelStack labels = cell.getConfigLabels();
		if(labels.hasLabel(GridRegion.COLUMN_HEADER) || labels.hasLabel(GridRegion.ROW_HEADER)) {//we use the same things, because we can invert rows and columns
			return getHeaderLabel(cell, configRegistry);
		} else if(labels.hasLabel(GridRegion.BODY)) {
			return getBodyLabel(cell, configRegistry);
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
			final ILabelProviderContextElement contextElement = new LabelProviderContextElement(cell, configRegistry);
			LabelProviderService serv = configRegistry.getConfigAttribute(NattableConfigAttributes.LABEL_PROVER_SERVICE_CONFIG_ATTRIBUTE, DisplayMode.NORMAL, NattableConfigAttributes.LABEL_PROVIDER_SERVICE_ID);
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
		return element instanceof ILabelProviderContextElement;
	}

}
