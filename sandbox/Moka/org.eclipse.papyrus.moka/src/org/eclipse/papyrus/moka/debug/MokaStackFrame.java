/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.debug;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IRegisterGroup;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.emf.ecore.EObject;

/**
 * An implementation of MokaStackFrame.
 * A MokaStackFrame is associated with a model element.
 *
 */
public class MokaStackFrame extends MokaDebugElement implements IStackFrame {
	
	/**
	 * The model element represented by this moka stack frame.
	 * For example, this can be a node or edge in a UML Activity 
	 * 
	 */
	protected EObject modelElement ;

	public MokaStackFrame(MokaDebugTarget target) {
		super(target);
	}

	/**
	 * Sets the model element represented by this stack frame
	 * 
	 * @param modelElement the model element represented by this stack frame
	 */
	public void setModelElement(EObject modelElement) {
		this.modelElement = modelElement ;
	}
	
	/**
	 * Returns the model element represented by this stack frame
	 * 
	 * @return the model element represented by this stack frame
	 */
	public EObject getModelElement() {
		return this.modelElement ;
	}
	
	////////////////////////////////
	// Implementation of IStackFrame
	////////////////////////////////
	
	/**
	 * The thread this stack frame is contained in
	 */
	protected MokaThread thread = null ;
	
	/**
	 * The variables associated with this stack frame
	 */
	protected MokaVariable[] variables = null ;
	
	/**
	 * The name of this stack frame
	 */
	protected String name = null ;
	
	/**
	 *  The register groups assigned to this stack frame
	 */
	protected IRegisterGroup[] registerGroups = null ;
	
	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IStackFrame#getThread()
	 */
	public IThread getThread() {
		return this.thread ;
	}
	
	/**
	 * A Convenience method for setting the thread containing this stack frame
	 * 
	 * @param thread The thread containing this stack frame
	 */
	public void setThread(MokaThread thread) {
		this.thread = thread ;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IStackFrame#getVariables()
	 */
	public IVariable[] getVariables() throws DebugException {
		if (this.variables != null)
			return this.variables ;
		// Delegates retrieval of variables to the owning debug target
		this.variables = this.debugTarget.getVariables(this) ;
		return this.variables ;
	}

	/**
	 * A convenience method for setting the visible variables of this stack frame
	 * 
	 * @param variables The visible variables of this stack frame
	 */
	public void setVariables(MokaVariable[] variables) {
		if (variables != null)
			this.variables = variables ;
		else
			this.variables = new MokaVariable[]{} ;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IStackFrame#hasVariables()
	 */
	public boolean hasVariables() throws DebugException {
		return this.getVariables().length > 0;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IStackFrame#getLineNumber()
	 */
	public int getLineNumber() throws DebugException {
		// line number information is not available / does not make sense in the context of a model 
		return -1 ;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IStackFrame#getCharStart()
	 */
	public int getCharStart() throws DebugException {
		// char start information is not available / does not make sense in the context of a model 
		return -1;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IStackFrame#getCharEnd()
	 */
	public int getCharEnd() throws DebugException {
		// char end information is not available / does not make sense in the context of a model 
		return -1;
	}

//	/* (non-Javadoc)
//	 * @see org.eclipse.debug.core.model.IStackFrame#getName()
//	 */
//	public String getName() throws DebugException {
//		if (this.name != null)
//			return this.name ;
//		// Delegates to the owning debug target retrieval of this stack frame name
//		this.name = this.debugTarget.getName(this) ;
//		return this.name ;
//	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IStackFrame#getName()
	 */
	public String getName() throws DebugException {
		if (this.name != null)
			return this.name ;
		// Delegates to the owning debug target retrieval of this stack frame name
		return "" ;
	}
	
	/**
	 * A convenience method for setting the name of this stack frame
	 * 
	 * @param name The new name for this stack frame
	 */
	public void setName(String name) {
		this.name = name != null ? name : "" ;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IStackFrame#getRegisterGroups()
	 */
	public IRegisterGroup[] getRegisterGroups() throws DebugException {
		if (this.registerGroups != null)
			return this.registerGroups ;
		// Delegates retrieval of register groups to the owning debug target
		this.registerGroups = this.debugTarget.getRegisterGroups(this) ;
		return this.registerGroups;
	}

	/**
	 * A convenience method for setting the register groups of a stack frame
	 * 
	 * @param registerGroups The register groups of this stack frame
	 */
	public void setRegisterGroups(IRegisterGroup[] registerGroups) {
		if (registerGroups != null)
			this.registerGroups = registerGroups ;
		else
			this.registerGroups = new IRegisterGroup[]{} ;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IStackFrame#hasRegisterGroups()
	 */
	public boolean hasRegisterGroups() throws DebugException {
		return this.getRegisterGroups().length > 0;
	}

	//////////////////////////
	// Implementation of IStep
	//////////////////////////
	
	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IStep#canStepInto()
	 */
	public boolean canStepInto() {
		// delegates to the owning thread
		return this.getThread().canStepInto() ;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IStep#canStepOver()
	 */
	public boolean canStepOver() {
		// delegates to the owning thread
		return this.getThread().canStepOver() ;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IStep#canStepReturn()
	 */
	public boolean canStepReturn() {
		// delegates to the owning thread
		return this.getThread().canStepReturn() ;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IStep#isStepping()
	 */
	public boolean isStepping() {
		// delegates to the owning thread
		return this.getThread().isStepping() ;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IStep#stepInto()
	 */
	public void stepInto() throws DebugException {
		// delegates to the owning thread
		this.getThread().stepInto() ;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IStep#stepOver()
	 */
	public void stepOver() throws DebugException {
		// delegates to the owning thread
		this.getThread().stepOver() ;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.IStep#stepReturn()
	 */
	public void stepReturn() throws DebugException {
		// delegates to the owning thread
		this.getThread().stepReturn() ;
	}

	///////////////////////////////////
	// Implementation of ISuspendResume
	///////////////////////////////////
	
	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.ISuspendResume#canResume()
	 */
	public boolean canResume() {
		// delegates to the owning thread
		return this.getThread().canResume() ;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.ISuspendResume#canSuspend()
	 */
	public boolean canSuspend() {
		// delegates to the owning thread
		return this.getThread().canSuspend() ;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.ISuspendResume#isSuspended()
	 */
	public boolean isSuspended() {
		// delegates to the owning thread
		return this.getThread().isSuspended() ;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.ISuspendResume#resume()
	 */
	public void resume() throws DebugException {
		// delegates to the owning thread
		this.getThread().resume() ;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.ISuspendResume#suspend()
	 */
	public void suspend() throws DebugException {
		// delegates to the owning thread
		this.getThread().suspend() ;
	}

	///////////////////////////////
	// Implementation of ITerminate
	///////////////////////////////
	
	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.ITerminate#canTerminate()
	 */
	public boolean canTerminate() {
		// delegates to the owning thread
		return this.getThread().canTerminate() ;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.ITerminate#isTerminated()
	 */
	public boolean isTerminated() {
		// delegates to the owning thread
		return this.getThread().isTerminated() ;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.ITerminate#terminate()
	 */
	public void terminate() throws DebugException {
		// delegates to the owning thread
		this.getThread().terminate() ;
	}

}
