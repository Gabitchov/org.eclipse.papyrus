package org.eclipse.papyrus.dev.infra.emf.export.handler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.internal.resources.File;
import org.eclipse.core.internal.resources.Workspace;
import org.eclipse.core.internal.resources.WorkspaceRoot;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.dev.infra.emf.export.Activator;
import org.eclipse.papyrus.infra.widgets.editors.InputDialog;
import org.eclipse.papyrus.infra.widgets.providers.WorkspaceContentProvider;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.CheckedTreeSelectionDialog;
import org.eclipse.ui.dialogs.SaveAsDialog;


public class EMFSaveAsHandler extends AbstractHandler {

	private ITreeContentProvider contentProvider = null;

	private ILabelProvider labelProvider = null;

	public Object execute(ExecutionEvent event) throws ExecutionException {
		ResourceSet set = new ResourceSetImpl();
		final List<Resource> selectedResources = getSelectedResource(set);

		// the dialog used to choose a file to browse
		final CheckedTreeSelectionDialog dialog = new CheckedTreeSelectionDialog(Display.getCurrent().getActiveShell(), getLabelProvider(), getContentProvider());
		dialog.setTitle("Browse Model");
		dialog.setMessage("Select the elements to export");
		dialog.setInput(selectedResources);

		if(dialog.open() == Window.OK) {
			final Object[] selectedEObject = dialog.getResult();
			final Collection<EObject> toExport = new ArrayList<EObject>();
			for(final Object current : selectedEObject) {
				assert current instanceof EObject;
				EcoreUtil.resolveAll((EObject)current);
				toExport.add((EObject)current);
			}

			SaveAsDialog saveAsDialog = new SaveAsDialog(Display.getCurrent().getActiveShell());
			//			saveAsDialog.setTitle("Select the destination for the exported elements"); //without effect
			if(saveAsDialog.open() == Window.OK) {
				Resource newResource = createNewResource(set, saveAsDialog.getResult());
				newResource.getContents().addAll(toExport);
				try {
					newResource.save(Collections.emptyMap());
					for(final Resource current : selectedResources) {
						current.save(Collections.emptyMap());
					}

				} catch (IOException e) {
					Activator.log.error(e);
				}
			}
		}

		return null;
	}

	/**
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#isEnabled()
	 * 
	 * @return
	 */
	@Override
	public boolean isEnabled() {
		return getSelectedResource(new ResourceSetImpl()).size() != 0;
	}

	/**
	 * FIXME : use the label provider service
	 * 
	 * @return
	 *         the label provider to use
	 */
	public ILabelProvider getLabelProvider() {
		if(labelProvider == null) {
			final AdapterFactory factory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
			labelProvider = new AdapterFactoryLabelProvider(factory);
		}
		return labelProvider;
	}

	/**
	 * FIXME : use the content provider service
	 * 
	 * @return
	 *         the content provider to use
	 */
	public ITreeContentProvider getContentProvider() {
		final AdapterFactory factory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		if(contentProvider == null) {
			contentProvider = new AdapterFactoryContentProvider(factory) {

				@Override
				public Object[] getElements(Object inputElement) {
					if(inputElement instanceof Resource) {
						return ((Resource)inputElement).getContents().toArray();

					} else if(inputElement instanceof Collection<?>) {
						return ((Collection)inputElement).toArray();
					} else {
						return super.getElements(inputElement);
					}
				}
			};
		}
		return contentProvider;
	}

	/**
	 * 
	 * @param set
	 *        a resource set
	 * @return
	 *         the selected resource
	 */
	protected List<Resource> getSelectedResource(final ResourceSet set) {
		IStructuredSelection selection = (IStructuredSelection)PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();
		final List<Resource> selectedResources = new ArrayList<Resource>();
		final List<?> selectedElement = selection.toList();
		for(Object object : selectedElement) {

			if(object instanceof IAdaptable) {
				final File file = (File)((IAdaptable)object).getAdapter(IFile.class);
				if(file != null) {

					final String pathName = ((File)file).getFullPath().toString();


					final URI uri = URI.createPlatformResourceURI(pathName, true);
					final Resource res = set.getResource(uri, true);
					EcoreUtil.resolveAll(res);
					if(pathName.contains("notation")) {

						selectedResources.add(0, res);
					} else {
						selectedResources.add(res);
					}
				}
			}

		}
		//		final Object selectedElement = ((IStructuredSelection)selection).getFirstElement();
		//		String pathName = "";
		//		Resource res = null;
		//		if(selectedElement instanceof IAdaptable) {
		//			final File file = (File)((IAdaptable)selectedElement).getAdapter(IFile.class);
		//			if(file!=null){
		//			
		//					pathName = ((File)file).getFullPath().toString();
		//
		//				final URI uri = URI.createPlatformResourceURI(pathName, true);
		//				 res = set.getResource(uri, true);
		//			}
		//		}
		//		return res;
		//		System.out.println(object);
		return selectedResources;
	}

	/**
	 * 
	 * @param set
	 *        the resourceset to use
	 * @param iPath
	 *        a path
	 * @return
	 *         the created resource with the wanted path
	 */
	protected Resource createNewResource(final ResourceSet set, final IPath iPath) {
		//		EcoreResourceUtil.
		//		URIConverter converter = set.getURIConverter();
		//		converter.
		//		IPath wsPath = ResourcesPlugin.getWorkspace().getDescription()
		//		java.io.File file = iPath.toFile();
		//		file.
		//		URI.createPlatformResourceURI(pathName)

		//FIXME : the references to the new files are stored with OS path (F:/....)
		IPath fullPath = ResourcesPlugin.getWorkspace().getRoot().getFile(iPath).getLocation();
		//		fullPath.get
		final URI uri = URI.createPlatformResourceURI(iPath.toString(), true);//FileURI(fullPath.toFile().getAbsolutePath());
		final URI uri2 = URI.createPlatformResourceURI(iPath.toFile().getPath(), true);
		String device = iPath.getDevice();
		final Resource newResource = set.createResource(uri);
		return newResource;
	}

}
