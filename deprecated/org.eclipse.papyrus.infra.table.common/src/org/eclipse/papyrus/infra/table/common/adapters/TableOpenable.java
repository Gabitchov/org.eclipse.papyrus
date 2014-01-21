package org.eclipse.papyrus.infra.table.common.adapters;

import java.util.Collection;
import java.util.NoSuchElementException;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance2.TableInstance2;
import org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.IOpenableWithContainer;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrusTableInstance;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;


public class TableOpenable implements IOpenableWithContainer {

	protected TableInstance2 tableInstance;

	public TableOpenable(TableInstance2 tableInstance) {
		this.tableInstance = tableInstance;
	}

	public Object getPageIdentifier() {
		Collection<Setting> usages = EMFHelper.getUsages(tableInstance);
		Predicate<Setting> p = new Predicate<EStructuralFeature.Setting>() {

			public boolean apply(EStructuralFeature.Setting setting) {
				return setting.getEObject() instanceof PapyrusTableInstance;
			}
		};
		try {
			return Iterables.filter(usages, p).iterator().next();
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	public Object getContainer() {
		return tableInstance.getContext();
	}

}
