package org.eclipse.papyrus.qompass.modellibs.core.bindinghelpers;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.FCM.util.IBindingHelper;
import org.eclipse.papyrus.qompass.designer.core.acceleo.AcceleoDriverWrapper;
import org.eclipse.papyrus.qompass.designer.core.listeners.CopyListener;
import org.eclipse.papyrus.qompass.designer.core.templates.BindingUtils;
import org.eclipse.papyrus.qompass.designer.core.templates.TemplateUtils;
import org.eclipse.papyrus.qompass.designer.core.transformations.Copy;
import org.eclipse.papyrus.qompass.designer.core.transformations.TransformationException;
import org.eclipse.papyrus.qompass.modellibs.core.Activator;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.OpaqueBehavior;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.Type;

public class LoopOperations implements IBindingHelper, CopyListener {

	private TemplateBinding binding;
	
	@Override
	public EObject copyEObject(Copy copy, EObject sourceEObj) {
		
		if(sourceEObj instanceof Operation) {
			Operation operation = (Operation)sourceEObj;

			Classifier actual = TemplateUtils.getFirstActualFromBinding(binding);
			Class boundClass = copy.getCopy(operation.getClass_());
			
			if(!(actual instanceof Interface)) {
				return sourceEObj;
			}
			Interface passedActualIntf = (Interface)actual;
			Operation last = null;
			EList<Element> removalList = new BasicEList<Element>();
			for(Operation intfOperation : passedActualIntf.getAllOperations()) {
				for(Element removalElement : removalList) {
					copy.removeForCopy(removalElement); // enable subsequent instantiations
				}
				removalList.clear();
				last = BindingUtils.instantiateOperation(copy, intfOperation, operation, boundClass);
				removalList.add(operation);
				for(Behavior method : operation.getMethods()) {
					if(method instanceof OpaqueBehavior) {
						try {
							Behavior newBehavior =
								BindingUtils.instantiateBehavior(copy, intfOperation, (OpaqueBehavior)method);
							newBehavior.setSpecification(last);
						}
						catch (TransformationException e) {
							Activator.log.error(e);;
						}
						// removalList.add(method);
						copy.removeForCopy(method); // enable subsequent instantiations
					}
				}
			}
			// from a logical viewpoint, we need to copy parameters & name, but not the
			// operation identity.
			copy.put(operation, last);
			return last;
			/*
			else { // not LOOP_OPERATIONS
			Operation newOperation = instantiateOperation(actual, template, operation, boundClass);
			for(Behavior method : operation.getMethods()) {
				if(method instanceof OpaqueBehavior) {
					Behavior newBehavior =
						instantiateBehavior(actual, template, (OpaqueBehavior)method);
					newBehavior.setSpecification(newOperation);
				}
			}
			return newOperation;
			*/
		}
		else if(sourceEObj instanceof EnumerationLiteral) {
				EnumerationLiteral literal = (EnumerationLiteral)sourceEObj;
				Classifier actual = TemplateUtils.getFirstActualFromBinding(binding);
				// Type passedActual = getPassedActual(template, actual, boundClass);
				Type passedActual = actual;
				if(!(passedActual instanceof Interface)) {
					return sourceEObj;
				}
				Interface passedActualIntf = (Interface)passedActual;
				EnumerationLiteral newLiteral = null;
				for(Operation intfOperation : passedActualIntf.getAllOperations()) {
					copy.removeForCopy(literal);
					newLiteral = copy.getCopy(literal);
					try {
						String newName = AcceleoDriverWrapper.evaluate(literal.getName(), intfOperation, null);
						newLiteral.setName(newName);
					}
					catch (TransformationException e) {
						Activator.log.error(e);
						newLiteral.setName("none"); //$NON-NLS-1$
					}
				}
				return newLiteral;
			}
		return null;
	}

	@Override
	public void handleElement(TemplateBinding binding, Element object) {
		this.binding = binding;
	}
}
