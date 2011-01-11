package org.eclipse.papyrus.diagram.common.providers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.CreateDecoratorsOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.CallBehaviorAction;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.UseCase;


public class NavigationDecoratorProvider extends AbstractProvider implements IDecoratorProvider {

	public boolean provides(IOperation operation) {
		if(!(operation instanceof CreateDecoratorsOperation)) {
			return false;
		}
		IDecoratorTarget decoratorTarget = ((CreateDecoratorsOperation)operation).getDecoratorTarget();
		View view = (View)decoratorTarget.getAdapter(View.class);
		
		EObject element = view.getElement();
		
		if (element instanceof CallBehaviorAction) {
			return true;
		}
		if (element instanceof org.eclipse.uml2.uml.Class) {
			return true;
		}
		if (element instanceof Package) {
			return true;
		}
		if (element instanceof Transition) {
			return true;
		}
		if (element instanceof State) {
			return true;
		}
		if (element instanceof UseCase) {
			return true;
		}
		if (element instanceof Behavior) {
			return true;
		}
		return false;
	}

	public void createDecorators(IDecoratorTarget decoratorTarget) {
		decoratorTarget.installDecorator("NAVIGATION", new NavigationDecorator(decoratorTarget));
	}

}
