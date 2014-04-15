/*******************************************************************************
 * Copyright (c) 2014 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Juan Cadavid <juan.cadavid@cea.fr> implementation
 ******************************************************************************/
package org.eclipse.papyrus.mwe2.utils.components;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.m2m.qvt.oml.BasicModelExtent;
import org.eclipse.m2m.qvt.oml.ExecutionContextImpl;
import org.eclipse.m2m.qvt.oml.ExecutionDiagnostic;
import org.eclipse.m2m.qvt.oml.ModelExtent;
import org.eclipse.m2m.qvt.oml.TransformationExecutor;
import org.eclipse.papyrus.mwe2.utils.messages.Messages;

/**
 * MWE Component to execute QVTO transformations. An example of use is:
 * <blockquote>
 * component = org.eclipse.papyrus.mwe.utils.components.QvtoTransformationWorkflowComponent {
		inputSlots = 'inputGmfgen'
		inputSlots = 'gmfgenUmlMetamodel'
		transformationURI = 'platform:/resource/org.eclipse.papyrus.tests.framework/qvto/gmfgen2uml.qvto'
		outputSlot = 'inputGmfgenUml'
	}
	</blockquote>
 * where the multi-valued input slots are the input parameters for the transformation; 
 * there should be as many as there are declared in the qvto file;
 * transformationURI is the location of the .qvto file and outputSlot the slot where 
 * the list of resulting eObjects of the transformation will be placed.
 *
 */
public class QvtoTransformationWorkflowComponent extends
		AbstractWorkflowComponent {

	private String transformationURI;
	private String outputSlot;
	private ArrayList<String> inputSlots = new ArrayList<String>();
	private Log log = LogFactory.getLog(getClass());

	public String getTransformationURI() {
		return transformationURI;
	}

	public void setTransformationURI(String transformationURI) {
		this.transformationURI = transformationURI;
	}

	public String getOutputSlot() {
		return outputSlot;
	}

	public void setOutputSlot(String outputSlot) {
		this.outputSlot = outputSlot;
	}

	public boolean addInputSlots(String c) {
		return inputSlots.add(c);
	}

	public ExecutionDiagnostic generate(List<? extends EObject> inObjects,
			URI transformationURI, WorkflowContext ctx, Issues issues)
			throws IOException {
		//resolveProxies(inObjects);
		TransformationExecutor executor = new TransformationExecutor(
				transformationURI);
		Diagnostic loadTransformationDiagnostic = executor.loadTransformation();
		if (!loadTransformationDiagnostic.getMessage().equals("OK")) { //$NON-NLS-1$
			log.error(Messages.QvtoTransformationWorkflowComponent_1
					+ loadTransformationDiagnostic);
			return null;
		}
		ExecutionContextImpl context = new ExecutionContextImpl();
		ArrayList<ModelExtent> input = new ArrayList<ModelExtent>();
		for (EObject eObject : inObjects) {
			BasicModelExtent basicModelExtent = new BasicModelExtent();
			basicModelExtent.add(eObject);
			input.add(basicModelExtent);
		}
		issues.addInfo(new File("..").getAbsolutePath()); //$NON-NLS-1$
		ModelExtent output = new BasicModelExtent();
		input.add(output);
		ModelExtent[] modelParameters = input.toArray(new ModelExtent[] {});
		context = new ExecutionContextImpl();
		context.setConfigProperty("keepModeling", true); //$NON-NLS-1$
		ExecutionDiagnostic result = executor.execute(context, modelParameters);
		if (result.getSeverity() == Diagnostic.OK) {
			List<EObject> outObjects = output.getContents();
			ctx.set(getOutputSlot(), outObjects);
			log.info(Messages.QvtoTransformationWorkflowComponent_4 + getTransformationURI());
		} else {
			issues.addError(result.toString());
		}
		return result;
	}

	@Override
	protected void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor,
			Issues issues) {
		List<EObject> inObjects = new ArrayList<EObject>();
		for (String inputSlot : inputSlots) {

			Object inputObject = ctx.get(inputSlot);
			if(inputObject instanceof EObject){
				inObjects.add((EObject) inputObject);
			}else if(inputObject instanceof List<?>){
				List<EObject> list = (List<EObject>) inputObject;
				inObjects.add((EObject) list.get(0));
			}
		}
		try {
			generate(inObjects, URI.createURI(transformationURI),
					ctx, issues);
		} catch (IOException e) {
			log.error(e.getLocalizedMessage());
		}

	}

	@Override
	public void checkConfiguration(Issues issues) {
		if (inputSlots.isEmpty()) {
			issues.addError(Messages.QvtoTransformationWorkflowComponent_5);
		}
	}
	
	

}
