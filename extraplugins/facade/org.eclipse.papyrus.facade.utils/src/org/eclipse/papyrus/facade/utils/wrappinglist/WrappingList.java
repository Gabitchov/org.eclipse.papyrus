package org.eclipse.papyrus.facade.utils.wrappinglist;

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.facade.utils.RepresentingElement;


public interface WrappingList<E extends RepresentingElement> extends EList<E> {

	public void notWrappingAdd(E object);

	public E notWrappingRemove(E object);

	public void silentAdd(int i, E object);

	public E silentRemove(int index);


}
