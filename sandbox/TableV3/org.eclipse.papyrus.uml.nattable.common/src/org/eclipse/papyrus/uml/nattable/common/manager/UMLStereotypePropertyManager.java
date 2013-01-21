package org.eclipse.papyrus.uml.nattable.common.manager;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import org.eclipse.papyrus.infra.nattable.common.manager.AbstractAxisManager;
import org.eclipse.papyrus.infra.nattable.common.manager.IAxisManager;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;



public class UMLStereotypePropertyManager extends AbstractAxisManager {

	public Object getHeaderDataValue(final int columnIndex, final int rowIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getHeaderColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getHeaderRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setHeaderDataValue(final int columnIndex, final int rowIndex, final Object newValue) {
		// TODO Auto-generated method stub

	}

	public Object getDataValue(final int columnIndex, final int rowIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setDataValue(final int columnIndex, final int rowIndex, final Object newValue) {
		// TODO Auto-generated method stub

	}

	public int getColumnCount() {
		return getAllExistingAxis().size();
	}

	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<?> getAllVisibleAxis() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<?> getAllCurrentPossibleAxis() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<?> getAllExistingAxis() {
		//FIXME cas d'inversion ligne colonne non géré
		final IAxisManager lineManager = getTableManager().getLineDataProvider();
		final Set<Stereotype> stereotypes = new LinkedHashSet<Stereotype>();
		for(final Object current : lineManager.getAllExistingAxis()) {
			if(current instanceof Element) {
				final Element el = (Element)current;
				stereotypes.addAll(el.getAppliedStereotypes());
			}
		}
		final Set<Property> properties = new LinkedHashSet<Property>();
		final Set<String> propertyQN = new LinkedHashSet<String>();
		for(final Stereotype ste : stereotypes) {
			properties.addAll(ste.getAllAttributes());
		}

		final List<Property> prop = new ArrayList<Property>(properties);
		final ListIterator<Property> iter = prop.listIterator();
		while(iter.hasNext()) {
			final Property current = iter.next();
			if("base_Class".equals(current.getName())) {
				iter.remove();
			}
		}
		return prop;
		//		return new ArrayList<Object>(propertyQN);
	}


}
