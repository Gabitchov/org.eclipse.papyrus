package org.eclipse.papyrus.infra.nattable.common.configuration;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell;
import org.eclipse.nebula.widgets.nattable.painter.cell.TextPainter;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForResource;
import org.eclipse.papyrus.infra.nattable.common.Activator;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.infra.services.labelprovider.service.impl.LabelProviderServiceImpl;
import org.eclipse.swt.graphics.GC;


public class CustomizedCellPainter extends TextPainter {

	private static final String BEGIN_OF_LIST = "[";

	private static final String END_OF_LIST = "]";

	private static final String VALUE_SEPARATOR = ", ";

	//FIXME currently the service registry can't be obtained for features, because their resources are not included in the resourceSet
	private static LabelProviderService serv;

	public CustomizedCellPainter() {
		if(serv == null) {
			serv = new LabelProviderServiceImpl();
			try {
				serv.startService();
			} catch (final ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	protected String getTextToDisplay(final ILayerCell cell, final GC gc, final int availableLength, final String text) {
		// TODO Auto-generated method stub
		return super.getTextToDisplay(cell, gc, availableLength, text);
	}

	@Override
	protected String convertDataType(final ILayerCell cell, final IConfigRegistry configRegistry) {
		final Object value = cell.getDataValue();
		if(value != null) {
			if(value instanceof EObject) {
				return getLabelForEObject((EObject)value);
			} else if(value instanceof Collection<?>) {
				final Iterator<Object> iter = ((Collection)value).iterator();
				String text = BEGIN_OF_LIST;
				while(iter.hasNext()) {
					final Object current = iter.next();
					if(current instanceof EObject) {
						text += getLabelForEObject((EObject)current);
						if(iter.hasNext()) {
							text += VALUE_SEPARATOR;
						}
					}
				}
				text += END_OF_LIST;
				return text;
			}
			//			//stereotype management
			//			else if(value instanceof String){
			//				
			//			}



		}
		return super.convertDataType(cell, configRegistry);
	}



	private String getLabelForEObject(final EObject object) {
		LabelProviderService service = getLabelProviderService(object);
		if(service == null) {
			service = serv;
		}
		if(service != null) {
			final ILabelProvider provider = service.getLabelProvider();
			return provider.getText(object);
		}
		return "";
	}

	private LabelProviderService getLabelProviderService(final EObject eobject) {
		final ServicesRegistry registry = getServiceRegistry(eobject);
		if(registry != null) {
			try {
				return registry.getService(LabelProviderService.class);
			} catch (final ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	private ServicesRegistry getServiceRegistry(final EObject object) {
		try {
			return ServiceUtilsForResource.getInstance().getServiceRegistry(object.eResource());
		} catch (final ServiceException e) {
			Activator.log.error("ServiceRegistry not found", e);
		}
		return null;
	}

}
