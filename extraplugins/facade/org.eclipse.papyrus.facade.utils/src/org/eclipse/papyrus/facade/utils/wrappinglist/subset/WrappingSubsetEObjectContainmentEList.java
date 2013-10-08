package org.eclipse.papyrus.facade.utils.wrappinglist.subset;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.papyrus.facade.utils.RepresentingElement;
import org.eclipse.papyrus.facade.utils.wrappinglist.WrappingEObjectContainmentEList;
import org.eclipse.papyrus.facade.utils.wrappinglist.WrappingList;
import org.eclipse.uml2.uml.Element;


public class WrappingSubsetEObjectContainmentEList<E extends RepresentingElement> extends WrappingEObjectContainmentEList<E> {

	protected List<WrappingList<E>> representingSuperSets;

	public WrappingSubsetEObjectContainmentEList(Class<?> dataClass, InternalEObject owner, int featureID, Collection<Element> representedElementList, WrappingList<E>... representingSuperSets) {
		super(dataClass, owner, featureID, representedElementList);
		this.representingSuperSets = new ArrayList<WrappingList<E>>();
		for(int i = 0; i < representingSuperSets.length; i++) {
			this.representingSuperSets.add(representingSuperSets[i]);
		}
	}

	//	@Override
	//	public boolean add(E object) {
	//		for(WrappingList representingSuperSet : representingSuperSets) {
	//			EcoreEList<E> list = ((EcoreEList<E>)representingSuperSet);
	//
	//			Notification notification = new ENotificationImpl((InternalEObject)list.getEObject(), Notification.ADD, list.getEStructuralFeature(), null, object, list.size(), true);
	//
	//			System.err.println("Wrapping");
	//			list.getEObject().eNotify(notification);
	//
	//			//			if(!representingSuperSet.contains(object)) {
	//			//				representingSuperSet.notWrappingAdd(object);
	//			//			}
	//		}
	//
	//
	//		return super.add(object);
	//	}
	//
	//	@Override
	//	public void add(int index, E object) {
	//		for(WrappingList representingSuperSet : representingSuperSets) {
	//			if(!representingSuperSet.contains(object)) {
	//				//				representingSuperSet.notWrappingAdd(object);
	//				EcoreEList<E> list = ((EcoreEList<E>)representingSuperSet);
	//
	//				Notification notification = new ENotificationImpl((InternalEObject)list.getEObject(), Notification.ADD, list.getEStructuralFeature(), null, object, list.size(), true);
	//
	//				System.err.println("Wrapping");
	//				list.getEObject().eNotify(notification);
	//			}
	//		}
	//
	//		super.add(index, object);
	//	}
	//
	//	@Override
	//	public boolean addAll(Collection<? extends E> collection) {
	//		for(WrappingList representingSuperSet : representingSuperSets) {
	//			for(E e : collection) {
	//				if(!representingSuperSet.contains(e)) {
	//					//					representingSuperSet.notWrappingAdd(e);
	//					EcoreEList<E> list = ((EcoreEList<E>)representingSuperSet);
	//
	//					Notification notification = new ENotificationImpl((InternalEObject)list.getEObject(), Notification.ADD, list.getEStructuralFeature(), null, e, list.size(), true);
	//
	//					System.err.println("Wrapping");
	//					list.getEObject().eNotify(notification);
	//				}
	//			}
	//		}
	//
	//		return super.addAll(collection);
	//	}
	//
	//	@Override
	//	public boolean addAll(int index, Collection<? extends E> collection) {
	//		for(WrappingList representingSuperSet : representingSuperSets) {
	//			for(E e : collection) {
	//				if(!representingSuperSet.contains(e)) {
	//					//					representingSuperSet.notWrappingAdd(e);
	//					EcoreEList<E> list = ((EcoreEList<E>)representingSuperSet);
	//
	//					Notification notification = new ENotificationImpl((InternalEObject)list.getEObject(), Notification.ADD, list.getEStructuralFeature(), null, e, list.size(), true);
	//
	//					System.err.println("Wrapping");
	//					list.getEObject().eNotify(notification);
	//				}
	//			}
	//		}
	//
	//		return super.addAll(index, collection);
	//	}
	//
	//	@Override
	//	public boolean remove(Object object) {
	//		for(WrappingList representingSuperSet : representingSuperSets) {
	//			//			representingSuperSet.notWrappingRemove((E)object);
	//			EcoreEList<E> list = ((EcoreEList<E>)representingSuperSet);
	//
	//			Notification notification = new ENotificationImpl((InternalEObject)list.getEObject(), Notification.REMOVE, list.getEStructuralFeature(), object, null, list.size() - 1, true);
	//
	//			System.err.println("Wrapping");
	//			list.getEObject().eNotify(notification);
	//		}
	//
	//		return super.remove(object);
	//	}
	//
	//	@Override
	//	public E remove(int index) {
	//		for(WrappingList representingSuperSet : representingSuperSets) {
	//			//			representingSuperSet.notWrappingRemove(get(index));
	//			EcoreEList<E> list = ((EcoreEList<E>)representingSuperSet);
	//
	//			Notification notification = new ENotificationImpl((InternalEObject)list.getEObject(), Notification.REMOVE, list.getEStructuralFeature(), get(index), null, list.size() - 1, true);
	//
	//			System.err.println("Wrapping");
	//			list.getEObject().eNotify(notification);
	//		}
	//
	//		return super.remove(index);
	//	}
	//
	//	@Override
	//	public boolean removeAll(Collection<?> collection) {
	//		for(WrappingList representingSuperSet : representingSuperSets) {
	//			for(Object e : collection) {
	//				//				representingSuperSet.notWrappingRemove((E)e);
	//				EcoreEList<E> list = ((EcoreEList<E>)representingSuperSet);
	//
	//				Notification notification = new ENotificationImpl((InternalEObject)list.getEObject(), Notification.REMOVE, list.getEStructuralFeature(), e, null, list.size() - 1, true);
	//
	//				System.err.println("Wrapping");
	//				list.getEObject().eNotify(notification);
	//			}
	//		}
	//
	//		return super.removeAll(collection);
	//	}
	//
	//	@Override
	//	public void clear() {
	//		for(WrappingList representingSuperSet : representingSuperSets) {
	//			for(Object e : this) {
	//				//				representingSuperSet.notWrappingRemove((E)e);
	//				EcoreEList<E> list = ((EcoreEList<E>)representingSuperSet);
	//
	//				Notification notification = new ENotificationImpl((InternalEObject)list.getEObject(), Notification.REMOVE, list.getEStructuralFeature(), e, null, list.size() - 1, true);
	//
	//				System.err.println("Wrapping");
	//				list.getEObject().eNotify(notification);
	//			}
	//		}
	//
	//		super.clear();
	//	}
	//
	//	@Override
	//	public void notWrappingAdd(E object) {
	//		for(WrappingList representingSuperSet : representingSuperSets) {
	//			if(!representingSuperSet.contains(object)) {
	//				representingSuperSet.notWrappingAdd(object);
	//			}
	//		}
	//
	//		doAddUnique(object);
	//	}
	//
	//	@Override
	//	public E notWrappingRemove(E object) {
	//		for(WrappingList representingSuperSet : representingSuperSets) {
	//			representingSuperSet.notWrappingRemove(object);
	//		}
	//
	//		return doRemove(indexOf(object));
	//	}
}
