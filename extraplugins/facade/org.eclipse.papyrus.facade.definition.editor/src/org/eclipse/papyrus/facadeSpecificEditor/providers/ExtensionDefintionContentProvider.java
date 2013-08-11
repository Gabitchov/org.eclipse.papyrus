package org.eclipse.papyrus.facadeSpecificEditor.providers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.facade.Facade;
import org.eclipse.papyrus.facade.extensiondefinition.BaseMetaclass;
import org.eclipse.papyrus.facade.extensiondefinition.ExtensionDefinition;
import org.eclipse.papyrus.facade.extensiondefinition.ExtensionDefinitionKind;

public class ExtensionDefintionContentProvider implements ITreeContentProvider {


	public void dispose() {
		// TODO Auto-generated method stub

	}


	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// TODO Auto-generated method stub

	}


	public Object[] getElements(Object inputElement) {

		HashSet<ExtensionDefinition> output = new HashSet<ExtensionDefinition>();

		if(inputElement instanceof Facade) {

			EList<ExtensionDefinition> extensionsDefinitions = ((Facade)inputElement).getExtensionDefinitions();
			for(ExtensionDefinition extensionDefinition : extensionsDefinitions) {

				output.add(extensionDefinition);

				// if (StereotypeTools.findEClass(((Extension) extensionDefinition.getExtension()).getMetaclass()) == extensionDefinition.getBaseMetaclass()) {
				// output.add(extensionDefinition);
				// }

			}

		}

		return output.toArray();

	}


	public Object[] getChildren(Object parentElement) {
		List<BaseMetaclass> output = new ArrayList<BaseMetaclass>();
		if(parentElement instanceof ExtensionDefinition) {

			ExtensionDefinition parent = (ExtensionDefinition)parentElement;

			if(parent.getKind() == ExtensionDefinitionKind.MULTI_GENERALIZATION) {
				for(BaseMetaclass baseMetaclass : parent.getBaseMetaclasses()) {
					if(!((EClass)baseMetaclass.getBase()).isAbstract()) {
						output.add(baseMetaclass);
					}
				}
			}
		}
		return output.toArray();
	}


	public Object getParent(Object element) {
		// TODO Auto-generated method stub
		return null;
	}


	public boolean hasChildren(Object element) {
		if(getChildren(element).length != 0) {
			return true;
		} else {
			return false;
		}

	}

}
