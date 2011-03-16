/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.table.requirement;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.facet.widgets.nattable.tableconfiguration.TableConfiguration;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.services.ServicesRegistry;
import org.eclipse.papyrus.nattable.instance.papyrustableinstance.PapyrusTableInstance;
import org.eclipse.papyrus.resource.NotFoundException;
import org.eclipse.papyrus.sysml.table.requirement.editor.RequirementTableEditor;
import org.eclipse.papyrus.table.common.handlers.AbstractCreateNattableEditorCommand;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;



/**
 * The command to create the Requirement Table
 * 
 * 
 * 
 */
public class CreateRequirementTableCommand extends AbstractCreateNattableEditorCommand {

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public CreateRequirementTableCommand() {
		super(RequirementTableEditor.EDITOR_TYPE, RequirementTableEditor.DEFAULT_NAME);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.table.defaultt.handlers.AbstractCreateNattableEditorCommand#createEditorModel(ServicesRegistry)
	 * 
	 * @param serviceRegistry
	 * @return
	 * @throws ServiceException
	 * @throws NotFoundException
	 */
	@Override
	protected Object createEditorModel(ServicesRegistry serviceRegistry) throws ServiceException, NotFoundException {
		PapyrusTableInstance papyrusTable = (PapyrusTableInstance)super.createEditorModel(serviceRegistry);

		ResourceSet resourceSet = papyrusTable.getTable().eResource().getResourceSet();

		String symbolicName = org.eclipse.papyrus.sysml.table.requirement.Activator.getDefault().getBundle().getSymbolicName();
		URI uri = URI.createPlatformPluginURI(symbolicName + "/resource/Requirements.tableconfiguration", true); //$NON-NLS-1$
		resourceSet.getResourceFactoryRegistry().getContentTypeToFactoryMap().put("tableconfiguration", new XMIResourceFactoryImpl()); //$NON-NLS-1$
		Resource resource = resourceSet.getResource(uri, true);

		TableConfiguration tableConfiguration = null;
		if(resource.getContents().get(0) instanceof TableConfiguration) {
			tableConfiguration = (TableConfiguration)resource.getContents().get(0);
		}

		papyrusTable.getTable().setTableConfiguration(tableConfiguration);

		return papyrusTable;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.table.common.handlers.AbstractCreateNattableEditorCommand#isEnabled()
	 * 
	 * @return
	 */
	@Override
	public boolean isEnabled() {
		EObject object = getTableContext();
		//		try {
		//			object = 
		//		} catch (ServiceException e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//			return false;
		//		}
		if(object instanceof Element) {
			Element el = (Element)object;
			Package pack = el.getNearestPackage();
			//we can create an Allocation Table only when the profile is applied
			return pack.getAppliedProfile("SysML::Requirements", true) != null; //$NON-NLS-1$
		}
		return false;
	}

}
