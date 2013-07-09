package org.eclipse.papyrus.infra.nattable.utils;

import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AbstractHeaderAxisConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.IAxisConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.IPasteConfiguration;


public class PasteConfigurationUtil {


	private PasteConfigurationUtil() {
		//to prevent instanciation
	}

	public static final IPasteConfiguration getRowPasteConfigurationDefinedInTableConfiguration(final Table table) {
		AbstractHeaderAxisConfiguration conf = HeaderAxisConfigurationManagementUtils.getRowAbstractHeaderAxisInTableConfiguration(table);
		for(final IAxisConfiguration current : conf.getOwnedAxisConfigurations()) {
			if(current instanceof IPasteConfiguration) {
				return (IPasteConfiguration)current;
			}
		}
		return null;
	}

	public static final IPasteConfiguration getColumnPasteConfigurationDefinedInTableConfiguration(final Table table) {
		AbstractHeaderAxisConfiguration conf = HeaderAxisConfigurationManagementUtils.getColumnAbstractHeaderAxisInTableConfiguration(table);
		for(final IAxisConfiguration current : conf.getOwnedAxisConfigurations()) {
			if(current instanceof IPasteConfiguration) {
				return (IPasteConfiguration)current;
			}
		}
		return null;
	}
}
