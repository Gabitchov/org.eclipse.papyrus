package org.eclipse.papyrus.uml.diagram.sequence.edit.policies;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AbstractMaskManagedEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.helpers.MessageLabelHelper;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;

public class MessageLabelEditPolicy extends AbstractMaskManagedEditPolicy {

	public static interface ICustomMessageLabel {
	}

	private DefaultValueListener defaultValueListener;

	/**
	 * Refreshes the display of the edit part
	 */
	@Override
	public void refreshDisplay() {
		// calls the helper for this edit Part
		ConnectionEditPart lp = (ConnectionEditPart)getHost();
		List<?> children = lp.getChildren();
		for(Object p : children) {
			if(p instanceof ICustomMessageLabel) {
				MessageLabelHelper.getInstance().refreshEditPartDisplay((GraphicalEditPart)p);
			}
		}
	}

	@Override
	public int getDefaultDisplayValue() {
		return CustomMessagePreferencePage.DEFAULT_LABEL_DISPLAY;
	}

	public String getMaskLabel(int value) {
		return MessageLabelHelper.getInstance().getMaskLabel(value);
	}

	public Collection<String> getMaskLabels() {
		return MessageLabelHelper.getInstance().getMaskLabels();
	}

	@Override
	public Map<Integer, String> getMasks() {
		return MessageLabelHelper.getInstance().getMasks();
	}

	public Collection<Integer> getMaskValues() {
		return MessageLabelHelper.getInstance().getMaskValues();
	}

	@Override
	public Message getUMLElement() {
		if(hostSemanticElement instanceof Message) {
			return ((Message)hostSemanticElement);
		}
		return null;
	}

	@Override
	public void addAdditionalListeners() {
		super.addAdditionalListeners();
		this.defaultValueListener = new DefaultValueListener();
		Message e = getUMLElement();
		// check host semantic element is not null
		if(e == null || e.getSignature() == null) {
			return;
		}
		hookMessageSignature(e.getSignature());
		EList<ValueSpecification> argments = e.getArguments();
		for(ValueSpecification v : argments) {
			if(v instanceof EObject) {
				getDiagramEventBroker().addNotificationListener(v, this);
			}
		}
	}

	private void hookMessageSignature(NamedElement sig) {
		if(sig == null) {
			return;
		}
		if(sig instanceof Operation) {
			Operation operation = (Operation)sig;
			getDiagramEventBroker().addNotificationListener(operation, this);
			// adds a listener to the element itself, and to linked elements, like Type
			for(Parameter parameter : operation.getOwnedParameters()) {
				getDiagramEventBroker().addNotificationListener(parameter, this);
				getDiagramEventBroker().addNotificationListener(parameter.getDefaultValue(), defaultValueListener);
				// should also add this element as a listener of parameter type
				getDiagramEventBroker().addNotificationListener(parameter.getType(), this);
			}
		} else if(sig instanceof Signal) {
			Signal signal = (Signal)sig;
			getDiagramEventBroker().addNotificationListener(signal, this);
			for(Property property : signal.getOwnedAttributes()) {
				getDiagramEventBroker().addNotificationListener(property, this);
				getDiagramEventBroker().addNotificationListener(property.getDefaultValue(), defaultValueListener);
				// should also add this element as a listener of parameter type
				getDiagramEventBroker().addNotificationListener(property.getType(), this);
			}
		}
	}

	@Override
	protected void removeAdditionalListeners() {
		super.removeAdditionalListeners();
		Message e = getUMLElement();
		// check host semantic element is not null
		if(e == null || e.getSignature() == null) {
			return;
		}
		unhookMessageSignature(e.getSignature());
		EList<ValueSpecification> argments = e.getArguments();
		for(ValueSpecification v : argments) {
			if(v instanceof EObject) {
				getDiagramEventBroker().removeNotificationListener(v, this);
			}
		}
	}

	private void unhookMessageSignature(NamedElement sig) {
		if(sig == null) {
			return;
		}
		if(sig instanceof Operation) {
			Operation operation = (Operation)sig;
			getDiagramEventBroker().removeNotificationListener(operation, this);
			for(Parameter parameter : operation.getOwnedParameters()) {
				getDiagramEventBroker().removeNotificationListener(parameter, this);
				getDiagramEventBroker().removeNotificationListener(parameter.getDefaultValue(), defaultValueListener);
				// remove parameter type listener
				getDiagramEventBroker().removeNotificationListener(parameter.getType(), this);
			}
		} else if(sig instanceof Signal) {
			Signal signal = (Signal)sig;
			getDiagramEventBroker().removeNotificationListener(signal, this);
			for(Property property : signal.getOwnedAttributes()) {
				getDiagramEventBroker().removeNotificationListener(property, this);
				getDiagramEventBroker().removeNotificationListener(property.getDefaultValue(), defaultValueListener);
				// remove parameter type listener
				getDiagramEventBroker().removeNotificationListener(property.getType(), this);
			}
		}
	}

	@Override
	public void notifyChanged(Notification notification) {
		super.notifyChanged(notification);
		final Object object = notification.getNotifier();
		Message e = getUMLElement();
		// check host semantic element is not null
		if(e == null) {
			return;
		}
		if(UMLPackage.Literals.MESSAGE__ARGUMENT.equals(notification.getFeature())) {
			parameterListChange(notification);
			return;
		} else if(e.getArguments().contains(object)) {
			refreshDisplay();
			return;
		}
		NamedElement sig = e.getSignature();
		if(sig instanceof Operation) {
			Operation operation = (Operation)sig;
			if(object.equals(operation)) {
				notifyOperationChanged(operation, notification);
			} else if(isParameter(object, operation)) {
				notifyParameterChanged(notification);
			} else if(isParameterType(object, operation)) {
				notifyTypeChanged(notification);
			}
		} else if(sig instanceof Signal) {
			Signal signal = (Signal)sig;
			if(object.equals(signal)) {
				notifySignalChanged(signal, notification);
			} else if(isProperty(object, signal)) {
				notifyPropertyChanged(notification);
			} else if(isPropertyType(object, signal)) {
				notifyTypeChanged(notification);
			} else if(object instanceof ValueSpecification) {
				Element own = ((ValueSpecification)object).getOwner();
				if(isProperty(own, signal)) {
					refreshDisplay(); // may be default value
				}
			}
		}
		if(isMaskManagedAnnotation(object)) {
			refreshDisplay();
		} else if(isRemovedMaskManagedLabelAnnotation(object, notification)) {
			refreshDisplay();
		} else if(sig == null && object instanceof Message && notification.getFeature().equals(UMLPackage.eINSTANCE.getNamedElement_Name())) {
			refreshDisplay();
		}
		//Try to update label when signature of message changed.
		else if(UMLPackage.eINSTANCE.getMessage_Signature() == notification.getFeature()) {
			Object oldValue = notification.getOldValue();
			if(oldValue instanceof NamedElement) {
				unhookMessageSignature((NamedElement)oldValue);
			}
			Object newValue = notification.getNewValue();
			if(newValue instanceof NamedElement) {
				hookMessageSignature((NamedElement)newValue);
			}
			refreshDisplay();
		}
	}

	class DefaultValueListener implements NotificationListener {

		@Override
		public void notifyChanged(Notification notification) {
			refreshDisplay();
		}
	}

	private void notifyPropertyChanged(Notification notification) {
		switch(notification.getFeatureID(Property.class)) {
		case UMLPackage.PROPERTY__DEFAULT_VALUE: // set or unset default value
			if(notification.getOldValue() instanceof EObject) {
				getDiagramEventBroker().removeNotificationListener((EObject)notification.getOldValue(), defaultValueListener);
			}
			if(notification.getNewValue() instanceof EObject) {
				getDiagramEventBroker().addNotificationListener((EObject)notification.getNewValue(), defaultValueListener);
			}
			refreshDisplay();
			break;
		case UMLPackage.PROPERTY__NAME:
		case UMLPackage.PROPERTY__IS_ORDERED:
		case UMLPackage.PROPERTY__LOWER:
		case UMLPackage.PROPERTY__UPPER:
		case UMLPackage.PROPERTY__LOWER_VALUE:
		case UMLPackage.PROPERTY__UPPER_VALUE:
			refreshDisplay();
			break;
		case UMLPackage.PROPERTY__TYPE:
			parameterListChange(notification);
			break;
		default:
			// does nothing in other cases
			break;
		}
	}

	/**
	 * notifies that a parameter of the operation has changed.
	 *
	 * @param parameter
	 *        the {@link Parameter} that has changed
	 * @param notification
	 *        the notification send when the element has been changed
	 */
	protected void notifyParameterChanged(Notification notification) {
		switch(notification.getFeatureID(Parameter.class)) {
		case UMLPackage.PARAMETER__DEFAULT_VALUE:
			if(notification.getOldValue() instanceof EObject) {
				getDiagramEventBroker().removeNotificationListener((EObject)notification.getOldValue(), defaultValueListener);
			}
			if(notification.getNewValue() instanceof EObject) {
				getDiagramEventBroker().addNotificationListener((EObject)notification.getNewValue(), defaultValueListener);
			}
			refreshDisplay();
			break;
		case UMLPackage.PARAMETER__NAME:
		case UMLPackage.PARAMETER__DIRECTION:
		case UMLPackage.PARAMETER__IS_STREAM:
		case UMLPackage.PARAMETER__IS_ORDERED:
		case UMLPackage.PARAMETER__LOWER:
		case UMLPackage.PARAMETER__UPPER:
		case UMLPackage.PARAMETER__LOWER_VALUE:
		case UMLPackage.PARAMETER__UPPER_VALUE:
			refreshDisplay();
			break;
		case UMLPackage.PARAMETER__TYPE:
			parameterListChange(notification);
			break;
		default:
			// does nothing in other cases
			break;
		}
	}

	protected void parameterListChange(Notification notification) {
		switch(notification.getEventType()) {
		// if it is added => adds listener to the type element
		case Notification.ADD:
			getDiagramEventBroker().addNotificationListener((EObject)notification.getNewValue(), this);
			refreshDisplay();
			// if it is removed => removes listener from the type element
			break;
		case Notification.ADD_MANY:
			if(notification.getNewValue() instanceof List<?>) {
				List<?> addedElements = (List<?>)notification.getNewValue();
				for(Object addedElement : addedElements) {
					if(addedElement instanceof EObject) {
						getDiagramEventBroker().addNotificationListener((EObject)addedElement, this);
					}
				}
			}
			refreshDisplay();
			break;
		case Notification.REMOVE:
			getDiagramEventBroker().removeNotificationListener((EObject)notification.getOldValue(), this);
			refreshDisplay();
			break;
		case Notification.REMOVE_MANY:
			if(notification.getOldValue() instanceof List<?>) {
				List<?> removedElements = (List<?>)notification.getOldValue();
				for(Object removedElement : removedElements) {
					if(removedElement instanceof EObject) {
						getDiagramEventBroker().removeNotificationListener((EObject)removedElement, this);
					}
				}
			}
			refreshDisplay();
			break;
		// if it is set, remove the old one and adds the new one. this is the method use when
		// the type is set or removed...
		case Notification.SET:
			if(notification.getNewValue() != null) {
				getDiagramEventBroker().addNotificationListener((EObject)notification.getNewValue(), this);
			}
			if(notification.getOldValue() != null) {
				getDiagramEventBroker().removeNotificationListener((EObject)notification.getOldValue(), this);
			}
			refreshDisplay();
		default:
			break;
		}
	}

	/**
	 * notifies that a parameter of the operation has changed.
	 *
	 * @param parameter
	 *        the {@link Parameter} that has changed
	 * @param notification
	 *        the notification send when the element has been changed
	 */
	protected void notifyTypeChanged(Notification notification) {
		// should be type.class, but seems to be a bug if this is put instead.
		switch(notification.getFeatureID(notification.getNotifier().getClass())) {
		case UMLPackage.TYPE__NAME:
		case UMLPackage.TYPE__TEMPLATE_PARAMETER:
		case UMLPackage.TYPE__VISIBILITY:
			refreshDisplay();
			break;
		default:
			// does nothing in other cases
			break;
		}
	}

	/**
	 * notifies that the the property has changed.
	 *
	 * @param operation
	 *        the operation that has changed
	 * @param notification
	 *        the notification send when the element has been changed
	 */
	protected void notifyOperationChanged(Operation operation, Notification notification) {
		switch(notification.getFeatureID(Operation.class)) {
		case UMLPackage.OPERATION__NAME:
		case UMLPackage.OPERATION__VISIBILITY:
		case UMLPackage.OPERATION__IS_UNIQUE:
		case UMLPackage.OPERATION__REDEFINED_OPERATION:
		case UMLPackage.OPERATION__IS_ORDERED:
		case UMLPackage.OPERATION__LOWER:
		case UMLPackage.OPERATION__UPPER:
		case UMLPackage.OPERATION__IS_STATIC:
			refreshDisplay();
			break;
		case UMLPackage.OPERATION__OWNED_PARAMETER:
			parameterListChange(notification);
			break;
		default:
			// does nothing in other cases
			break;
		}
	}

	private void notifySignalChanged(Signal signal, Notification notification) {
		switch(notification.getFeatureID(Signal.class)) {
		case UMLPackage.SIGNAL__NAME:
		case UMLPackage.SIGNAL__VISIBILITY:
			refreshDisplay();
			break;
		case UMLPackage.SIGNAL__OWNED_ATTRIBUTE:
			parameterListChange(notification);
			break;
		default:
			// does nothing in other cases
			break;
		}
	}

	/**
	 * Checks if the given object is one of the parameter type of the operation
	 *
	 * @param object
	 *        the object to test
	 * @param operation
	 * @return <code>true</code> if the object corresponds to the type of a parameter of the
	 *         operation
	 */
	protected boolean isParameterType(Object object, Operation operation) {
		if(!(object instanceof Type)) {
			return false;
		}
		for(Parameter parameter : operation.getOwnedParameters()) {
			if(object.equals(parameter.getType())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks if the given object is one of the parameter of the operation
	 *
	 * @param object
	 *        the object to test
	 * @param operation
	 * @return <code>true</code> if the object is a parameter of the operation
	 */
	protected boolean isParameter(Object object, Operation operation) {
		if(!(object instanceof Parameter)) {
			return false;
		}
		return operation.getOwnedParameters().contains(object);
	}

	private boolean isPropertyType(Object object, Signal signal) {
		if(!(object instanceof Type)) {
			return false;
		}
		for(Property property : signal.getOwnedAttributes()) {
			if(object.equals(property.getType())) {
				return true;
			}
		}
		return false;
	}

	private boolean isProperty(Object object, Signal signal) {
		if(!(object instanceof Property)) {
			return false;
		}
		return signal.getOwnedAttributes().contains(object);
	}

}
