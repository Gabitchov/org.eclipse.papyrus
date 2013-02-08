package org.eclipse.papyrus.uml.nattable.common.manager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.nattable.common.manager.AbstractAxisManager;
import org.eclipse.papyrus.infra.nattable.common.manager.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.common.manager.NattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.IAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.IdAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.NattableFactory;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.IAxisContentsProvider;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.NattablecontentproviderPackage;
import org.eclipse.papyrus.uml.nattable.common.utils.Constants;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;



public class UMLStereotypePropertyManager extends AbstractAxisManager {

	private Adapter listener;

	@Override
	public void init(INattableModelManager manager, String managerId, Table table, IAxisContentsProvider provider) {
		super.init(manager, managerId, table, provider);
		if(hasConfiguration()) {
			contentsCalculus();
		}
		this.listener = new AdapterImpl() {

			@Override
			public void notifyChanged(final Notification msg) {
				if(NattablecontentproviderPackage.eINSTANCE.getDefaultContentProvider_Axis() == msg.getFeature()) {
					contentsCalculus();
					((NattableModelManager)getTableManager()).refreshNattable();
				}
			}
		};
		provider.eAdapters().add(this.listener);
	}

	@Override
	public Command getComplementaryAddAxisCommand(final EditingDomain domain, final Collection<Object> objectToAdd) {
		//FIXME : we must test the configuration
		//		if(!hasConfiguration()) {
		final Set<Stereotype> appliedStereotypes = new HashSet<Stereotype>();
		for(final Object current : objectToAdd) {
			if(current instanceof Element) {
				appliedStereotypes.addAll(((Element)current).getAppliedStereotypes());
			}
		}
		final Set<Property> allProperties = new HashSet<Property>();
		for(final Stereotype stereotype : appliedStereotypes) {
			allProperties.addAll(stereotype.getAllAttributes());
		}

		final List<String> allPropertyQN = new ArrayList<String>();
		for(Property property : allProperties) {
			allPropertyQN.add(Constants.PROPERTY_OF_STEREOTYPE_PREFIX + property.getQualifiedName());
		}

		allPropertyQN.removeAll(getTableManager().getColumnElementsList());
		if(!allPropertyQN.isEmpty()) {
			final Collection<IAxis> toAdd = new ArrayList<IAxis>();
			for(String propQN : allPropertyQN) {
				final IdAxis newAxis = NattableFactory.eINSTANCE.createIdAxis();
				newAxis.setElement(propQN);
				toAdd.add(newAxis);
			}
			//FIXME : we must use a factory and use the service edit
			return AddCommand.create(domain, getRepresentedContentProvider(), NattablecontentproviderPackage.eINSTANCE.getDefaultContentProvider_Axis(), toAdd);

		}
		return null;
	}

	/**
	 * calculus of the contents of the axis
	 */
	protected synchronized void contentsCalculus() {
		final List<IAxis> axis = getRepresentedContentProvider().getAxis();
		final List<Object> axisElements = getTableManager().getColumnElementsList();
		for(int i = 0; i < axis.size(); i++) {
			IAxis current = axis.get(i);
			if(current instanceof IdAxis) {
				final String id = (String)current.getElement();
				if(id.startsWith(Constants.PROPERTY_OF_STEREOTYPE_PREFIX)) {
					int currentIndex = axisElements.indexOf(id);
					if(currentIndex == -1) {
						axisElements.add(id);
					} else if(currentIndex != i) {
						axisElements.remove(currentIndex);
						axisElements.add(i, id);
					}
				}
			}
		}
	}


	public int getColumnCount() {
		if(isUsedVertically()) {
			return getAllExistingAxis().size();
		}
		return 0;
	}

	public int getRowCount() {
		if(isUsedHorizontally()) {
			return getAllExistingAxis().size();
		}
		return 0;

	}



	@Override
	public List<?> getAllExistingAxis() {
		return getTableManager().getColumnElementsList();
	}


}
