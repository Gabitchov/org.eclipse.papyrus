package org.eclipse.papyrus.sysml.nattable.manager.axis;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.nattable.manager.axis.AbstractSynchronizedOnFeatureAxisManager;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.manager.table.NattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisManagerRepresentation;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider;
import org.eclipse.papyrus.sysml.service.types.matcher.RequirementMatcher;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.UMLPackage;



public class RequirementAxisManager extends AbstractSynchronizedOnFeatureAxisManager {

	@Override
	public void init(INattableModelManager manager, AxisManagerRepresentation rep, Table table, AbstractAxisProvider provider, boolean mustRefreshOnAxisChanges) {
		super.init(manager, rep, table, provider, false);//false, with this axis manager, the contents is derived of the feature
	}

	@Override
	protected void addContextFeatureValueListener() {
		this.featureListener = new AdapterImpl() {

			@Override
			public void notifyChanged(Notification msg) {
				if(msg.getFeature() == RequirementAxisManager.this.currentListenFeature || msg.getFeature() == UMLPackage.eINSTANCE.getPackage_PackagedElement()) {
					if(!RequirementAxisManager.this.isRefreshing) {//to avoid to many thread
						RequirementAxisManager.this.isRefreshing = true;
						Display.getDefault().asyncExec(new Runnable() {

							public void run() {
								updateAxisContents();
								((NattableModelManager)getTableManager()).refreshNattable();
								RequirementAxisManager.this.isRefreshing = false;
							}
						});
					}
				}
			}
		};
		getTable().getContext().eAdapters().add(this.featureListener);
	}

	@Override
	public void dispose() {
		getTable().getContext().eAdapters().remove(this.featureListener);
		super.dispose();
	}

	@Override
	protected List<Object> filterObject(final List<?> objects) {
		final List<Object> interestingObjects = new ArrayList<Object>();
		final RequirementMatcher matcher = new RequirementMatcher();
		for(Object object : objects) {
			if(object instanceof EObject) {
				if(matcher.matches((EObject)object)) {
					interestingObjects.add(object);
				}
			}
		}
		return interestingObjects;
	}

}
