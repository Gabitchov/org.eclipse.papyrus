package org.eclipse.papyrus.infra.nattable.common.manager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.nattable.model.nattable.EObjectAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.IAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.NattableFactory;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.IAxisContentsProvider;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.NattablecontentproviderPackage;


public class FeatureManager extends AbstractAxisManager {

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
		//if a configuration is declared we doesn't add columns when a new element is added to the table
		if(!hasConfiguration()) {
			final Set<EStructuralFeature> features = new HashSet<EStructuralFeature>();
			for(final Object current : objectToAdd) {
				if(current instanceof EObject) {
					features.addAll(((EObject)current).eClass().getEAllStructuralFeatures());
				}
			}
			features.removeAll(getTableManager().getColumnElementsList());
			if(!features.isEmpty()) {
				Collection<IAxis> toAdd = new ArrayList<IAxis>();
				for(final EStructuralFeature feature : features) {
					final EObjectAxis newAxis = NattableFactory.eINSTANCE.createEObjectAxis();
					newAxis.setElement(feature);
					toAdd.add(newAxis);
				}
				//FIXME : we must use a factory and use the service edit
				return AddCommand.create(domain, getRepresentedContentProvider(), NattablecontentproviderPackage.eINSTANCE.getDefaultContentProvider_Axis(), toAdd);
			}
		}
		return null;
	}

	private Collection<EStructuralFeature> getAllFeatures(final Collection<Object> objects) {
		final Collection<EStructuralFeature> features = new HashSet<EStructuralFeature>();
		for(final Object current : objects) {
			if(current instanceof EObject) {
				features.addAll(((EObject)current).eClass().getEAllStructuralFeatures());
			}
		}
		return features;
	}




	/**
	 * calculus of the contents of the axis
	 */
	protected synchronized void contentsCalculus() {
		final List<IAxis> axis = getRepresentedContentProvider().getAxis();
		final List<Object> axisElements = getTableManager().getColumnElementsList();
		for(int i = 0; i < axis.size(); i++) {
			IAxis current = axis.get(i);
			if(current instanceof EObjectAxis) {
				final EObject element = (EObject)current.getElement();
				if(element instanceof EStructuralFeature) {
					int currentIndex = axisElements.indexOf(element);
					if(currentIndex == -1) {
						axisElements.add(element);
					} else if(currentIndex != i) {
						axisElements.remove(currentIndex);
						axisElements.add(i, element);
					}
				}
			}
		}
	}



	@Override
	public Object getDataValue(final int columnIndex, final int rowIndex) {
		final List<Object> list = new ArrayList<Object>(getAllExistingAxis());
		return list.get(columnIndex);
	}



	public int getColumnCount() {
		return getAllExistingAxis().size();
	}


	public int getRowCount() {
		return getAllExistingAxis().size();
	}


	@Override
	public Object getHeaderDataValue(final int columnIndex, final int rowIndex) {
		final List<Object> list = new ArrayList<Object>(getAllExistingAxis());
		final Object current = list.get(columnIndex);
		if(current instanceof EStructuralFeature) {
			return ((EStructuralFeature)current).getName();
		}
		return null;
	}





	@Override
	public List<?> getAllExistingAxis() {
		return getTableManager().getColumnElementsList();
	}




}
