package org.eclipse.papyrus.diagram.activity.activitygroup.functions;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.diagram.activity.activitygroup.editpolicy.notifiers.IGroupNotifier;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;


public class FromIGroupNotifierToEObject implements Function<IGroupNotifier, EObject> {	
	
	FromIGroupNotifierToEObject(){
		
	}
	
	private static class SingletonHolder {
		public static final FromIGroupNotifierToEObject INSTANCE = new FromIGroupNotifierToEObject();
	}
	
	public static FromIGroupNotifierToEObject getInstance(){
		return SingletonHolder.INSTANCE;
	}
	
	public static Iterable<EObject> transform (Iterable<IGroupNotifier> from){
		return Iterables.transform(from, FromIGroupNotifierToEObject.getInstance());
	}
	
	
	
	public EObject apply(IGroupNotifier from) {
		return from.getEObject();
	}

}
