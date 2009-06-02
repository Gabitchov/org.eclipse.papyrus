/*******************************************************************************
 * Copyright (c) 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.navigator.providers;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.core.extension.diagrameditor.EditorFactoryRegistry;
import org.eclipse.papyrus.core.extension.diagrameditor.IEditorFactoryRegistry;
import org.eclipse.papyrus.navigator.internal.AdditionalResources;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;

/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class UMLLabelProvider extends AdapterFactoryLabelProvider implements ICommonLabelProvider/* , IFontProvider */{

	/** Registry to store editor factories */
	private IEditorFactoryRegistry editorRegistry;

	/** <ICommonContentExtensionSite> as given in initialization. */
	protected ICommonContentExtensionSite contentExtensionSite = null;

	// private Font diagramFont = null;

	public UMLLabelProvider() {
		super(UMLComposedAdapterFactory.getAdapterFactory());
	}

	public void init(ICommonContentExtensionSite config) {
		this.contentExtensionSite = config;
	}

	public void restoreState(IMemento memento) {
		// TODO Auto-generated method stub

	}

	public void saveState(IMemento memento) {
		// TODO Auto-generated method stub

	}

	public String getDescription(Object anElement) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Returns the platform icon for a file. You can replace with your own icon If not a IFile, then passes to the regular EMF.Edit providers
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public Image getImage(Object element) {
		// if (object instanceof IFile)
		// return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FILE);
		if (element instanceof Diagram) {
			return getEditorRegistry().getEditorIcon(element);
		}
		return super.getImage(element);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getText(Object element) {
		if (element instanceof AdditionalResources) {
			return "Additional Resources";
		}

		// if (object instanceof IFile)
		// return ((IFile) object).getName();

		if (element instanceof Diagram) {
			Diagram diagram = (Diagram) element;
			return super.getText(diagram);
			
//			if (diagram.getSemanticModel() instanceof CoreSemanticModelBridge) {
//				CoreSemanticModelBridge coreSemanticModelBridge = (CoreSemanticModelBridge) diagram.getSemanticModel();
//				return super.getText(coreSemanticModelBridge.getElement());
//			}
		}

		return super.getText(element);
	}

	/**
	 * Get the EditorRegistry used to create editor instances. This default implementation return the singleton eINSTANCE. This method can be subclassed to return another registry.
	 * 
	 * @return the singleton eINSTANCE of editor registry
	 */
	protected IEditorFactoryRegistry getEditorRegistry() {
		if (editorRegistry == null) {
			editorRegistry = createEditorRegistry();
		}
		return editorRegistry;
	}

	/**
	 * Return the EditorRegistry for nested editor descriptors. Subclass should implements this method in order to return the registry associated to the extension point namespace.
	 * 
	 * @return the EditorRegistry for nested editor descriptors
	 */
	protected IEditorFactoryRegistry createEditorRegistry() {
		return new EditorFactoryRegistry(org.eclipse.papyrus.core.Activator.PLUGIN_ID);
	}

	// @Override
	// public Font getFont(Object element) {
	// if (element instanceof Diagram) {
	// return getDiagramFont();
	// }
	// return JFaceResources.getFontRegistry().defaultFont();
	// //return null;
	// }
	// private Font getDiagramFont()
	// {
	// if (this.diagramFont == null){
	// //Display display = getSite().getShell().getDisplay();
	// //Display display = Display.getCurrent();
	// //FontData[] datas = currentViewer.getControl().getFont().getFontData().clone();
	// //FontData[] datas = getDefaultFont().getFontData().clone();
	// //datas[0].setStyle(SWT.BOLD);
	// //this.diagramFont = new Font(display, datas);
	// this.diagramFont = JFaceResources.getFontRegistry().getBold(JFaceResources.DEFAULT_FONT);
	// }
	// return this.diagramFont;
	// }
	//
	//	
	// @Override
	// public void dispose() {
	// if(diagramFont!=null){
	// diagramFont.dispose();
	// diagramFont=null;
	// }
	// super.dispose();
	// }

}
