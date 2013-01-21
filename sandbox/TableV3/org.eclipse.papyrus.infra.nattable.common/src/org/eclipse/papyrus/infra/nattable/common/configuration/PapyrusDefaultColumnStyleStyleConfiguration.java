package org.eclipse.papyrus.infra.nattable.common.configuration;

import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.layer.config.DefaultColumnHeaderStyleConfiguration;
import org.eclipse.nebula.widgets.nattable.painter.cell.decorator.BeveledBorderDecorator;


public class PapyrusDefaultColumnStyleStyleConfiguration extends DefaultColumnHeaderStyleConfiguration {



	@Override
	public void configureRegistry(final IConfigRegistry configRegistry) {
		this.cellPainter = new BeveledBorderDecorator(new CustomizedCellPainter());
		super.configureRegistry(configRegistry);
		//		configRegistry.registerConfigAttribute(CellConfigAttributes.CELL_PAINTER, new CustomizedCellPainter(), DisplayMode.NORMAL, GridRegion.COLUMN_HEADER);
	}
}
