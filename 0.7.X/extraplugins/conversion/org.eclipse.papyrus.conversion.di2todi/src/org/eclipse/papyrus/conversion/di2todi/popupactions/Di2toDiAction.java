/**
 * @author: Manel Fredj - CEA
 * This class enables to invoke QVTO transformation in order to convert a diagram from di2 into di+notation
 */

package org.eclipse.papyrus.conversion.di2todi.popupactions;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.m2m.internal.qvt.oml.ast.env.ModelExtentContents;
import org.eclipse.m2m.internal.qvt.oml.common.MdaException;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ModelContent;
import org.eclipse.m2m.internal.qvt.oml.library.Context;
import org.eclipse.m2m.internal.qvt.oml.runtime.generator.TransformationRunner;
import org.eclipse.m2m.internal.qvt.oml.runtime.generator.TransformationRunner.In;
import org.eclipse.m2m.internal.qvt.oml.runtime.generator.TransformationRunner.Out;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtInterpretedTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.TransformationUtil;
import org.eclipse.m2m.internal.qvt.oml.trace.Trace;
import org.eclipse.m2m.internal.qvt.oml.trace.TraceRecord;
import org.eclipse.m2m.qvt.oml.util.IContext;
import org.eclipse.papyrus.conversion.di2.util.Di2AdapterFactory;
import org.eclipse.papyrus.conversion.di2todi.Activator;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;



@SuppressWarnings("restriction")
public class Di2toDiAction implements IObjectActionDelegate {

	private static final Map<?, ?> options = null;
	private Shell shell;
	private IPath inModelPath;	//reference to selected Model
	private String inAbsolutepath;
	
	/**
	 * Constructor for Action1.
	 */
	public Di2toDiAction() {
		super();
		inModelPath=null;
		inAbsolutepath=null;
	}

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		shell = targetPart.getSite().getShell();
	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		if (adapterFactory == null) {
			// dummy operation to force loading/initialization of di2 plugin
			adapterFactory = new Di2AdapterFactory();
		}
		// Refer to an existing transformation via URI
		URI transformationURI = URI.createURI("platform:/plugin/" + Activator.PLUGIN_ID + "/TransfoQvtoDi2toDi/Transfo.qvto");
		
		//get the resources from the input URI
		ResourceSet resourceSet = new ResourceSetImpl();
		try {
			URI inURI = URI.createPlatformResourceURI(inModelPath.toString(), true);
			Resource inResource = resourceSet.getResource(inURI, true);
			// create the inputs
			List<EObject> inObjects =inResource.getContents();
			ModelContent input_di2 = new ModelContent (inObjects);
			ModelContent[] inputs = new ModelContent[1];
			inputs[0]=input_di2;
			
			// setup the execution environment details -> context
			IContext mycontext = new Context();
			Trace trace= null;
			
			QvtInterpretedTransformation transformation = new QvtInterpretedTransformation (TransformationUtil.getQvtModule(transformationURI));
			In IntransformationRunner=new TransformationRunner.In(inputs, mycontext);
			Out OuttransformationRunner=new TransformationRunner.Out(null,null, null);
			
			// running the transformation
			OuttransformationRunner=transformation.run(IntransformationRunner);
			
			// retrieve the outputs
			List<ModelExtentContents> outputs= OuttransformationRunner.getExtents();
			
			// retrieve the trace
			trace= OuttransformationRunner.getTrace();
			
			if (trace !=null && outputs.size()==2) {
				// processing the trace
				URI Uri_trace = inURI.trimFileExtension().appendFileExtension("trace");
				EList<TraceRecord> outObjects_trace =  trace.getTraceRecords();
				Resource outResource_trace  = resourceSet.createResource(Uri_trace);
				outResource_trace.getContents().addAll(outObjects_trace);
			
				// processing the outputs
				ModelExtentContents  output_notation=outputs.get(0);
				ModelExtentContents  output_di=outputs.get(1);
				
				URI Uri_notation = inURI.trimFileExtension().appendFileExtension("notation");
				URI Uri_di = inURI.trimFileExtension().appendFileExtension("di");
		
				// the output objects got captured in the output extent
				List<EObject> outObjects_notation = output_notation.getAllRootElements();
				List<EObject> outObjects_di = output_di.getAllRootElements();	
				
				//Let's persist them using a resource for notation
				Resource	outResource_notation   = resourceSet.createResource(Uri_notation );
				outResource_notation.getContents().addAll(outObjects_notation);
				
				// let's persist them using a resource for di
				Resource outResource_di   = resourceSet.createResource(Uri_di);
				outResource_di.getContents().addAll(outObjects_di);
				
				try{
					outResource_notation.save(Collections.emptyMap());
					outResource_di.save(Collections.emptyMap());
					outResource_trace.save(Collections.emptyMap());
				} 
				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				
				//remove trace file				
				URIConverter uri= resourceSet.getURIConverter();
				uri.delete(Uri_trace, options);
			}
			// when the transformation succeeds
			//1- restore the content of Di2 file i.e., di2 namespace
			PapyrusNamespace.restoreDi2Namespace(this.inAbsolutepath);
			//2-show dialog
			MessageDialog.openInformation(
					shell,
					"Paryrus1 => Payrus MDT converter",
					"Di2toDi Action was executed.");
		} 
		catch (MdaException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (RuntimeException e) {
			// Shell shell = new Shell ();
			MessageDialog.openError(
					shell,
					"Error during conversion",
					e.toString ());		
			e.printStackTrace ();
		}
		
			
	}

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection)
	{
		this.inModelPath = null;
		this.inAbsolutepath=null;
		IPath di2Path=null;
		IPath location = null;
		

		
		if (!(selection instanceof IStructuredSelection)) {
			// no structured-selection
			return;
		}
		IStructuredSelection structuredSelection = (IStructuredSelection) selection;
		if (selection.isEmpty()) {
			return;
		}
			
		Object firstElement = structuredSelection.getFirstElement();
		
		if (firstElement instanceof IFile) {
			
			IFile di2Select = (IFile) firstElement;
			// retrieve the path of the file
			di2Path=di2Select.getFullPath();
			location = ((IFile) firstElement).getLocation();
			if (location != null) {
				// Get the file for the location
				File file = location.toFile();
				if (file != null) {
					// Add the absolute path to the list
					this.inAbsolutepath = file.getAbsolutePath();
				}
			
				// check whether it is a .di2 file
				String di2filename = di2Path.toString();
				if (di2filename.endsWith (".di2")) {
					// change namespace of di2
					PapyrusNamespace.replaceNamespace(this.inAbsolutepath);
					this.inModelPath = di2Path;
				}
			}
		}
	}
	
	Di2AdapterFactory adapterFactory = null;
}
	
