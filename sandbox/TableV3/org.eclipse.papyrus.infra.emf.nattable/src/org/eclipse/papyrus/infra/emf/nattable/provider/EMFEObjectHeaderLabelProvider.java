package org.eclipse.papyrus.infra.emf.nattable.provider;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.papyrus.infra.nattable.provider.AbstractNattableCellLabelProvider;
import org.eclipse.papyrus.infra.nattable.utils.ILabelProviderContextElement;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;


public class EMFEObjectHeaderLabelProvider extends AbstractNattableCellLabelProvider {

	@Override
	public boolean accept(Object element) {
		if(element instanceof ILabelProviderContextElement) {
			final Object object = ((ILabelProviderContextElement)element).getCell().getDataValue();
			return object instanceof EObject && !(object instanceof EStructuralFeature);
		}
		return false;
	}

	@Override
	public String getText(Object element) {
		final EObject object = (EObject)((ILabelProviderContextElement)element).getCell().getDataValue();
		final IConfigRegistry configRegistry = ((ILabelProviderContextElement)element).getConfigRegistry();
		final LabelProviderService serv = getLabelProviderService(configRegistry);
		return serv.getLabelProvider(object).getText(object);
	}
}
