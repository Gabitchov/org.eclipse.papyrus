package org.eclipse.papyrus.properties.uml.xtext;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.widgets.xtext.adapter.IXtextAdapter;

import com.google.inject.Injector;


public class ParameterAdapter implements IXtextAdapter {

	public EObject reconcile(EObject sourceModelObject, EObject xtextObject) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getText(EObject modelObject) {
		//ParameterPopupEditor config = new ParameterPopupEditor();
		//return config.getTextToEdit(modelObject);
		return null;
	}

	public Injector getInjector(EObject sourceModelObject) {
		//		Injector injector = InjectorFactory.createInjector((Parameter)sourceModelObject);
		//		System.out.println(injector.getInstance(Element.class));
		//		return injector;
		return null;
	}

}
