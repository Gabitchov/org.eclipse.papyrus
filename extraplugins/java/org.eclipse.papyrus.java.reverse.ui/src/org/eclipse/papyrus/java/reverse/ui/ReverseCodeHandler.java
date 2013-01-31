/**
 * 
 */
package org.eclipse.papyrus.java.reverse.ui;

import japa.parser.ParseException;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.uml.tools.model.UmlUtils;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.utils.EditorUtils;
import org.eclipse.papyrus.infra.core.utils.ServiceUtilsForActionHandlers;
import org.eclipse.papyrus.java.reverse.ui.dialog.ReverseCodeDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Package;


/**
 * @author dumoulin
 * 
 */
public class ReverseCodeHandler extends AbstractHandler implements IHandler {

	private static String DefaultGenerationPackageName = "generated";

	/**
	 * Method called when button is pressed.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {



		final Resource umlResource = getUmlResource();
		//        String rootModelName = getRootModelName(umlResource);

		// Try to compute a uid identifying the model. Used to store user settings.
		String modelUid = umlResource.getURI().toPlatformString(true);
		if( modelUid == null)
		{
			System.err.println("Can't compute relatif model uid. Use absolute one");
			modelUid = umlResource.getURI().path();
		}
		System.out.println("Model uid :" + modelUid);
		
		// Get reverse parameters from a dialog
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActivePart().getSite().getShell();
		//    	ReverseCodeDialog dialog = new ReverseCodeDialog(shell, DefaultGenerationPackageName, Arrays.asList("generated") );
		ReverseCodeDialog dialog = new ReverseCodeDialog(shell, modelUid, null, null);

		int res = dialog.open();
		//    	System.out.println("dialog result =" + res);
		if(res == Window.CANCEL) {
			System.out.println("Canceled by user.");
			return null;
		}
		// Get returned name
		String generationPackageName = dialog.getValue();
		if(generationPackageName == null || generationPackageName.length() == 0) {
			generationPackageName = DefaultGenerationPackageName;
		}

		// Adjust name
		//    	generationPackageName = rootModelName + "/" + generationPackageName;
		// Create searchpaths. Add the rootmodelname as prefix.
		final List<String> searchPaths = Arrays.asList(dialog.getSearchPath());
		//       	final List<String> searchPaths = new ArrayList<String>();
		//    	for(String path : dialog.getSearchPath())
		//    	{
		//    		searchPaths.add( rootModelName + "/" + path);
		//    	}

		// Create revers object


		// Execute the reverse with provided parameters
		TransactionalEditingDomain editingDomain;
		try {
			editingDomain = getEditingDomain();
		} catch (ServiceException e) {
			// Can't get editing domain
			e.printStackTrace();
			throw new ExecutionException(e.getMessage());
		}
		
		final String pname = generationPackageName;
		RecordingCommand command = new RecordingCommand(editingDomain, "Reverse Java Code") {

			@Override
			protected void doExecute() {
				executeCodeReverse(umlResource, pname, searchPaths);
			}

		};

		editingDomain.getCommandStack().execute(command);


		return null;
	}

	/**
	 * Real Implementation of the command.
	 * 
	 * @param generationPackageName
	 * @param searchPaths
	 */
	private void executeCodeReverse(Resource umlResource, String generationPackageName, List<String> searchPaths) {
		System.out.println("executeCodeReverse()");
		JavaCodeReverse codeReverse = new JavaCodeReverse(getRootPackage(umlResource), generationPackageName, searchPaths);
		// Get current selection
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		ISelection selection = page.getSelection();

		TreeSelection treeSelection = (TreeSelection)selection;
		//        String filename = treeSelection.
		@SuppressWarnings("rawtypes")
		Iterator iter = treeSelection.iterator();
		while(iter.hasNext()) {
			Object obj = iter.next();
			// Translate java ICompilationUnit to Iresource
			if(obj instanceof ICompilationUnit) {
				ICompilationUnit u = (ICompilationUnit)obj;
				try {
					obj = u.getCorrespondingResource();
				} catch (JavaModelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
        	if(obj instanceof IPackageFragment)
        	{
				IPackageFragment u = (IPackageFragment)obj;
				try {
					IResource res = u.getCorrespondingResource();
					if(res != null)
						obj = res;
				} catch (JavaModelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
        	// This happen when selection is an element from a jar
        	if(obj instanceof IJavaElement)
        	{
        		IJavaElement u = (IJavaElement)obj;
				try {
        			
				codeReverse.reverseJavaElement(u);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        	// This is a regular java file
         	if(obj instanceof IResource )
        	{
        		try {
					codeReverse.reverseResource((IResource)obj);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (CoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

    	System.out.println("reverse done");

	}


	/**
	 * Get the uml resource used by the model.
	 * 
	 * @return
	 */
	private Resource getUmlResource() {
		Resource umlResource = UmlUtils.getUmlModel().getResource();
		return umlResource;
	}

	/**
	 * Get the name of the root model.
	 * 
	 * @return
	 */
	private Package getRootPackage(Resource umlResource) {
		Package rootPackage = (Package)umlResource.getContents().get(0);
		return rootPackage;
	}

	/**
	 * Get the current MultiDiagramEditor.
	 * 
	 * @return
	 */
	protected IMultiDiagramEditor getMultiDiagramEditor() {
		return EditorUtils.getMultiDiagramEditor();
	}

	/**
	 * Get the main editing doamin.
	 * 
	 * @return
	 * @throws ServiceException 
	 */
	protected TransactionalEditingDomain getEditingDomain() throws ServiceException {
		return ServiceUtilsForActionHandlers.getInstance().getTransactionalEditingDomain();
	}

}
