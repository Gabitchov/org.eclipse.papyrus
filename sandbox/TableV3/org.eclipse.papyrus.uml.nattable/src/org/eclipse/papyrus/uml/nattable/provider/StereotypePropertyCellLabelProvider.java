package org.eclipse.papyrus.uml.nattable.provider;

import java.util.List;

import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell;
import org.eclipse.papyrus.infra.nattable.utils.ILabelProviderContextElement;
import org.eclipse.uml2.uml.Property;


public class StereotypePropertyCellLabelProvider extends AbstractUMLNattableCellLabelProvider {

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.nattable.provider.EMFCellLabelProvider#accept(java.lang.Object)
	 * 
	 * @param element
	 * @return
	 */
	@Override
	public boolean accept(Object element) {
		if(element instanceof ILabelProviderContextElement) {
			final ILayerCell cell = ((ILabelProviderContextElement)element).getCell();
			final IConfigRegistry registry = ((ILabelProviderContextElement)element).getConfigRegistry();

			//now it is possible that we accepts the element
			final Object rowObject = getRowObject(cell, registry);
			final Object columnObject = getColumnObject(cell, registry);

			final List<Object> objects = getUMLObjects(rowObject, columnObject);
			final Object feature = objects.get(1);
			return feature instanceof Property;

		}
		return false;
	}
}
