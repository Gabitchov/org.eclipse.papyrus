package org.eclipse.papyrus.moka.fuml;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.core.Activator;
import org.eclipse.papyrus.moka.communication.request.isuspendresume.Resume_Request;
import org.eclipse.papyrus.moka.communication.request.isuspendresume.Suspend_Request;
import org.eclipse.papyrus.moka.communication.request.iterminate.Terminate_Request;
import org.eclipse.papyrus.moka.debug.MokaBreakpoint;
import org.eclipse.papyrus.moka.debug.MokaDebugTarget;
import org.eclipse.papyrus.moka.debug.MokaThread;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.BooleanValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.IntegerValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.StringValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.UnlimitedNaturalValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.Value;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.ParameterValue;
import org.eclipse.papyrus.moka.fuml.debug.ControlDelegate;
import org.eclipse.papyrus.moka.fuml.presentation.FUMLPresentationUtils;
import org.eclipse.papyrus.moka.ui.presentation.AnimationUtils;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Type;

public class FUMLExecutionEngineForMoka extends FUMLExecutionEngine {
	
	protected ControlDelegate controlDelegate ;
	
	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.moka.engine.AbstractExecutionEngine#init(org.eclipse.emf.ecore.EObject, java.lang.String[], org.eclipse.papyrus.moka.debug.MokaDebugTarget, int, int, int)
	 */
	@Override
	public void init(EObject eObjectToExecute, String[] args, MokaDebugTarget debugTarget, int requestPort, int replyPort, int eventPort) throws UnknownHostException, IOException {
		super.init(eObjectToExecute, args, debugTarget, requestPort, replyPort, eventPort);
		if (eObjectToExecute instanceof Behavior) {
			main = (Behavior)eObjectToExecute ;
			this.debugTarget = debugTarget ;
			this.debugTarget.setName("FUML Execution Engine") ;
			FUMLPresentationUtils.init(eObjectToExecute) ;
			AnimationUtils.init() ;
			FUMLExecutionEngine.eInstance = this ;
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.moka.engine.AbstractExecutionEngine#initializeArguments(java.lang.String[])
	 */
	@Override
	public void initializeArguments(String[] args) {
		this.args = args ;
		if (this.locus == null) {
			return ;
		}

		this.arguments = new ArrayList<ParameterValue>() ;
		if (this.args == null)
			return ;

		List<Value> tmpArgs = new ArrayList<Value>() ;

		// analyzes arguments versus parameters of the main behavior
		List<Parameter> parameters = main.getOwnedParameters() ;
		if (parameters == null)
			return ;
		List<Parameter> parametersWhichNeedArguments = new ArrayList<Parameter>() ;
		// There must be the same number of parameters (except the return parameter)
		for (Parameter p : parameters) {
			if (p.getDirection() != ParameterDirectionKind.RETURN_LITERAL)
				parametersWhichNeedArguments.add(p) ;
		}
		if (parametersWhichNeedArguments.size() != this.args.length)
			return ;

		// iterates on parameters, and tries to create tokens corresponding to arguments
		int i = 0 ;
		for (Parameter p : parametersWhichNeedArguments) {
			Type t = p.getType() ;
			if (t != null) {
				PrimitiveType pt = this.locus.factory.getBuiltInType(t.getName()) ;
				if (pt == null)
					return ;
				if (pt.getName().equals("Integer")) {
					IntegerValue value = new IntegerValue() ;
					value.value = new Integer(this.args[i]) ;
					tmpArgs.add(value) ;
				}
				else if (pt.getName().equals("String")) {
					StringValue value = new StringValue() ;
					value.value = this.args[i] ;
					tmpArgs.add(value) ;
				}
				else if (pt.getName().equals("Boolean")) {
					BooleanValue value = new BooleanValue() ;
					value.value = new Boolean(this.args[i]) ;
					tmpArgs.add(value) ;
				}
				else if (pt.getName().equals("UnlimitedNatural")) {
					UnlimitedNaturalValue value = new UnlimitedNaturalValue() ;
					value.value = new Integer(args[i]) ;
					tmpArgs.add(value) ;
				}
				else {
					return ; // Unsupported type. TODO Consider Real 
				}
			}
			i++ ;
		}

		i = 0 ;
		// creates actual arguments
		for (Value v : tmpArgs) {
			ParameterValue arg = new ParameterValue() ;
			arg.parameter = parameters.get(i) ;
			arg.values = new ArrayList<Value>() ;
			arg.values.add(v) ;
			this.arguments.add(arg) ;
			i++ ;
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.moka.fuml.FUMLExecutionEngine#getControlDelegate()
	 */
	public ControlDelegate getControlDelegate() {
		if (this.controlDelegate == null)
			this.controlDelegate = new ControlDelegate(this) ;
		return this.controlDelegate ;
	}
	
	@Override
	public void addBreakpoint(MokaBreakpoint breakpoint) {
		this.getControlDelegate().addBreakpoint(breakpoint) ;
	}

	@Override
	public void removeBreakpoint(MokaBreakpoint breakpoint) {
		this.getControlDelegate().removeBreakpoint(breakpoint) ;
	}

	@Override
	public void disconnect() {
		// Do nothing
	}

	@Override
	public void resume(Resume_Request request) {
		if (!this.started) {
			Runnable execution = new Runnable() {
				public void run() {
					if (main != null) {
						start(main) ;
						if (! isTerminated()) {
							try {
								getDebugTarget().terminate() ;
							} catch (DebugException e) {
								Activator.log.error(e);
							}
						}
					}
				}
			};
			Thread mainThread = new Thread(execution) ;
			mainThread.start() ;
		}
		else {
			this.getControlDelegate().resume(request) ;
		}
	}

	@Override
	public void suspend(Suspend_Request request) {
		this.getControlDelegate().suspend(request) ;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.moka.engine.AbstractExecutionEngine#terminate(org.eclipse.papyrus.moka.communication.request.iterminate.Terminate_Request)
	 */
	@Override
	public void terminate(Terminate_Request request) {
		this.getControlDelegate().terminate(request) ;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.moka.engine.IExecutionEngine#getThreads()
	 */
	public MokaThread[] getThreads() {
		return this.getControlDelegate().getThreads() ;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.moka.engine.AbstractExecutionEngine#getStackFrames(org.eclipse.debug.core.model.IThread)
	 */
	@Override
	public IStackFrame[] getStackFrames(IThread thread) {
		return this.getControlDelegate().getStackFrames(thread) ;
	}

}
