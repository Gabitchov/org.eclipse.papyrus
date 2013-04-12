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
 *  Camille Letavernier (camille.letavernier@cea.fr) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.hyperlink.helper;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.emf.providers.EMFGraphicalContentProvider;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.infra.hyperlink.Activator;
import org.eclipse.papyrus.infra.hyperlink.commands.CreateHyperLinkObjectCommand;
import org.eclipse.papyrus.infra.hyperlink.object.HyperLinkObject;
import org.eclipse.papyrus.infra.hyperlink.object.HyperLinkSpecificObject;
import org.eclipse.papyrus.infra.hyperlink.util.HyperLinkConstants;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.infra.widgets.editors.TreeSelectorDialog;
import org.eclipse.papyrus.infra.widgets.providers.CompositeContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.ICompositeContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.IHierarchicContentProvider;
import org.eclipse.ui.PlatformUI;

/**
 * An Hyperlink Helper for referencing objects (i.e. specific object within an
 * editor, such as a Specific Class in a Class Diagram)
 * 
 * @author Camille Letavernier
 * 
 */
public class ObjectHyperLinkHelper extends AbstractHyperLinkHelper {

	@Override
	public String getNameofManagedHyperLink() {
		return "Specific object";
	}

	@Override
	public void executeNewMousePressed(List<HyperLinkObject> list, EObject aModel) {
		ServicesRegistry servicesRegistry;
		LabelProviderService labelProviderService;
		ModelSet modelSet;
		try {
			servicesRegistry = ServiceUtilsForEObject.getInstance().getServiceRegistry(aModel);
			if(servicesRegistry == null) {
				return;
			}

			labelProviderService = servicesRegistry.getService(LabelProviderService.class);
			modelSet = servicesRegistry.getService(ModelSet.class);
		} catch (ServiceException e) {
			Activator.log.error(e);
			return;
		}

		//Create and opens a dialog for page models
		TreeSelectorDialog selectionDialog = new TreeSelectorDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell());
		selectionDialog.setBlockOnOpen(true);

		IHierarchicContentProvider semanticProvider = getContentProvider();
		ITreeContentProvider graphicalProvider = new EMFGraphicalContentProvider(semanticProvider, modelSet, Activator.PLUGIN_ID + ".specificHyperLinks");

		selectionDialog.setContentProvider(graphicalProvider);
		selectionDialog.setLabelProvider(labelProviderService.getLabelProvider());
		selectionDialog.setInput(aModel);
		selectionDialog.open();
		if(selectionDialog.getReturnCode() == Window.OK) {
			Object[] result = selectionDialog.getResult();
			for(Object resultElement : result) {
				if(resultElement instanceof EObject) {
					list.add(new HyperLinkSpecificObject((EObject)resultElement));
				}
			}
		}
	}

	public static final String EXTENSION_ID = Activator.PLUGIN_ID + ".specificHyperLinks";

	protected IHierarchicContentProvider getContentProvider() {
		ICompositeContentProvider provider = new CompositeContentProvider();

		IConfigurationElement[] configElements = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_ID);

		for(IConfigurationElement e : configElements) {
			try {
				Object contentProviderObject = e.createExecutableExtension("contentProvider");
				if(!(contentProviderObject instanceof ITreeContentProvider)) {
					Activator.log.warn("Plugin " + e.getContributor() + " contributed an invalid extension for " + EXTENSION_ID + ". The content provider must be a ITreeContentProvider");
					continue;
				}

				ITreeContentProvider contentProvider = (ITreeContentProvider)contentProviderObject;
				provider.appendContentProvider(contentProvider);
			} catch (Exception ex) {
				Activator.log.error("Plugin " + e.getContributor() + " contributed an invalid extension for " + EXTENSION_ID, ex);
			}
		}

		return provider;
	}

	@Override
	public List<HyperLinkObject> getFilteredObject(List<HyperLinkObject> hyperLinkObjects) {
		List<HyperLinkObject> result = new LinkedList<HyperLinkObject>();
		for(HyperLinkObject object : hyperLinkObjects) {
			if(object instanceof HyperLinkSpecificObject) {
				result.add(object);
			}
		}
		return result;
	}

	@Override
	public HyperLinkObject getHyperLinkObject(EAnnotation eAnnotation) {
		if(HyperLinkConstants.PAPYRUS_HYPERLINK_SPECIFIC_ELEMENT.equals(eAnnotation.getSource())) {
			if(!eAnnotation.getReferences().isEmpty()) {
				HyperLinkSpecificObject specificObjectHyperlink = new HyperLinkSpecificObject();
				specificObjectHyperlink.setTargetElement(eAnnotation.getReferences().get(0));
				specificObjectHyperlink.setIsDefault(Boolean.parseBoolean(eAnnotation.getDetails().get(HyperLinkConstants.HYPERLINK_IS_DEFAULT_NAVIGATION)));
				specificObjectHyperlink.setTooltipText(eAnnotation.getDetails().get(HyperLinkConstants.HYPERLINK_TOOLTYPE_TEXT));
				return specificObjectHyperlink;
			}
		}

		return null;
	}

	@Override
	public RecordingCommand getAddHyperLinkCommand(TransactionalEditingDomain domain, EModelElement object, HyperLinkObject hyperLinkObject) {
		if(hyperLinkObject instanceof HyperLinkSpecificObject) {
			HyperLinkSpecificObject hyperLinkSpecificObject = (HyperLinkSpecificObject)hyperLinkObject;
			return new CreateHyperLinkObjectCommand(domain, object, hyperLinkSpecificObject.getTooltipText(), HyperLinkConstants.PAPYRUS_HYPERLINK_SPECIFIC_ELEMENT, hyperLinkSpecificObject.getTargetElement(), hyperLinkObject.getIsDefault());
		}
		return null;
	}
}
