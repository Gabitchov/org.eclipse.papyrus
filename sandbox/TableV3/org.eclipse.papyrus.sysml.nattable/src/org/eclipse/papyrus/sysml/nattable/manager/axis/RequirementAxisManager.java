package org.eclipse.papyrus.sysml.nattable.manager.axis;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.infra.nattable.manager.axis.AbstractSynchronizedOnFeatureAxisManager;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.manager.table.NattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.EMFFeatureValueAxisProvider;
import org.eclipse.papyrus.sysml.service.types.matcher.RequirementMatcher;
import org.eclipse.swt.widgets.Display;



public class RequirementAxisManager extends AbstractSynchronizedOnFeatureAxisManager {//FIXME : this abstract class must inherits from the UML Element axis manager

	private Adapter featureListener;

	private boolean isRefreshing = false;

	@Override
	public void init(INattableModelManager manager, String managerId, Table table, AbstractAxisProvider provider, boolean mustRefreshOnAxisChanges) {
		super.init(manager, managerId, table, provider, false);//false, with this axis manager, the contents is derived of the feature
		updateAxisContents();
		final EStructuralFeature listenFeature = ((EMFFeatureValueAxisProvider)getRepresentedContentProvider()).getListenFeature();

		//		this.featureListener = new UMLDerivedUnionAdapter() {
		//
		//			@Override
		//			public void notifyChanged(Notification notification) {
		//				// TODO Auto-generated method stub
		//				super.notifyChanged(notification);
		//			}
		//
		//			@Override
		//			public void notifyChanged(Notification notification, EClass eClass, EStructuralFeature derivedUnion) {
		//				// TODO Auto-generated method stub
		//				super.notifyChanged(notification, eClass, derivedUnion);
		//			}
		this.featureListener = new AdapterImpl() {

			@Override
			public void notifyChanged(Notification msg) {
				//				if(msg.getFeature() == ((EMFFeatureValueAxisProvider)getRepresentedContentProvider()).getListenFeature() || msg.getFeature() == UMLPackage.eINSTANCE.getStructuredClassifier_OwnedAttribute()) {
				//								//FIXME : add test
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
				//				}
			}
		};
		getTable().getContext().eAdapters().add(this.featureListener);
	}


	@Override
	public void dispose() {
		getTable().getContext().eAdapters().remove(this.featureListener);
		super.dispose();
	}

	/**
	 * calculus of the contents of the axis
	 */
	@Override
	public synchronized void updateAxisContents() {
		final EObject context = getTable().getContext();
		final EStructuralFeature ref = ((EMFFeatureValueAxisProvider)getRepresentedContentProvider()).getListenFeature();
		Object value = context.eGet(ref);
		assert value instanceof List<?>;

		List<?> interestingObject = filterObject((List<?>)value);
		interestingObject = sortObjects(interestingObject);

		final List axisElements = getTableManager().getElementsList(getRepresentedContentProvider());
		for(int i = 0; i < interestingObject.size(); i++) {
			final Object object = interestingObject.get(i);
			int currentIndex = axisElements.indexOf(object);
			if(currentIndex == -1) {
				axisElements.add(object);
			} else if(currentIndex != i) {
				axisElements.remove(currentIndex);
				axisElements.add(i, object);
			}
		}
	}

	/**
	 * 
	 * @param objects
	 * @return
	 */
	protected List<?> sortObjects(final List<?> objects) { //FIXME : move me in an upper class
		return objects;
	}

	protected List<?> filterObject(final List<?> objects) {
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

	@Override
	public boolean canReoderElements() {
		return false;
	}

}
