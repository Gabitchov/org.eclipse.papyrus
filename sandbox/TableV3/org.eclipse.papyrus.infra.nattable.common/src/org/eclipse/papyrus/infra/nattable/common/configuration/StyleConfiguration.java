package org.eclipse.papyrus.infra.nattable.common.configuration;

import org.eclipse.nebula.widgets.nattable.config.CellConfigAttributes;
import org.eclipse.nebula.widgets.nattable.config.DefaultNatTableStyleConfiguration;
import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;


public class StyleConfiguration extends DefaultNatTableStyleConfiguration {

//	private final CustomizedCellPainter cellPainter;
//	final LabelProviderService labelProviderService) {
//		this.cellPainter = new CustomizedCellPainter(labelProviderService);
//	}


	@Override
	public void configureRegistry(final IConfigRegistry configRegistry) {
		super.configureRegistry(configRegistry);
		configRegistry.registerConfigAttribute(CellConfigAttributes.CELL_PAINTER, new CustomizedCellPainter());

	}


}
