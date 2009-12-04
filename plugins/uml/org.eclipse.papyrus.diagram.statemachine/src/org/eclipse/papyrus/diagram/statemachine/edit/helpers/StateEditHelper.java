package org.eclipse.papyrus.diagram.statemachine.edit.helpers;

import org.eclipse.emf.common.util.URI;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class StateEditHelper extends UMLBaseEditHelper {

	public static final String PARAMETER_CONFIGURE_SUBMACHINE = StateEditHelper.class
			.getName()
			+ ":ConfigureSubmachine"; //$NON-NLS-1$

	/**
	 * @generated NOT
	 */
	@Override
	protected ICommand getConfigureCommand(ConfigureRequest req) {
		if(req.getElementToConfigure() instanceof State
				&& req.getParameter(PARAMETER_CONFIGURE_SUBMACHINE) instanceof StateMachineWrapper) {
			State state = (State)req.getElementToConfigure();
			URI stateMachineURI = ((StateMachineWrapper)req
					.getParameter(PARAMETER_CONFIGURE_SUBMACHINE))
					.getStateMachineURI();
			StateMachine stateMachine = (StateMachine)req.getEditingDomain()
					.getResourceSet().getEObject(stateMachineURI, true);
			SetRequest request = new SetRequest(state, UMLPackage.eINSTANCE
					.getState_Submachine(), stateMachine);
			return new SetValueCommand(request);
		}
		return super.getConfigureCommand(req);
	}

	/**
	 * @generated NOT
	 */
	public static class StateMachineWrapper {

		public void setStateMachineURI(URI stateMachineURI) {
			myStateMachineURI = stateMachineURI;
		}

		public URI getStateMachineURI() {
			return myStateMachineURI;
		}

		private URI myStateMachineURI;
	}
}
