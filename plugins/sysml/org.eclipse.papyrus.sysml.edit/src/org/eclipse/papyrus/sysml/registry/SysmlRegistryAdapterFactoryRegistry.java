/*****************************************************************************
 * Copyright (c) 2011 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.sysml.registry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.papyrus.sysml.activities.provider.ActivitiesItemProviderAdapterFactory;
import org.eclipse.papyrus.sysml.allocations.provider.AllocationsItemProviderAdapterFactory;
import org.eclipse.papyrus.sysml.blocks.provider.BlocksItemProviderAdapterFactory;
import org.eclipse.papyrus.sysml.constraints.provider.ConstraintsItemProviderAdapterFactory;
import org.eclipse.papyrus.sysml.edit.provider.IComposableAdapterFactory;
import org.eclipse.papyrus.sysml.edit.provider.IRootAdapterFactory;
import org.eclipse.papyrus.sysml.modelelements.provider.ModelelementsItemProviderAdapterFactory;
import org.eclipse.papyrus.sysml.portandflows.provider.PortandflowsItemProviderAdapterFactory;
import org.eclipse.papyrus.sysml.requirements.provider.RequirementsItemProviderAdapterFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.edit.providers.AbstractionItemProvider;
import org.eclipse.uml2.uml.edit.providers.ActivityEdgeItemProvider;
import org.eclipse.uml2.uml.edit.providers.ActivityPartitionItemProvider;
import org.eclipse.uml2.uml.edit.providers.BehaviorItemProvider;
import org.eclipse.uml2.uml.edit.providers.ClassItemProvider;
import org.eclipse.uml2.uml.edit.providers.ClassifierItemProvider;
import org.eclipse.uml2.uml.edit.providers.CommentItemProvider;
import org.eclipse.uml2.uml.edit.providers.ConnectorEndItemProvider;
import org.eclipse.uml2.uml.edit.providers.ConnectorItemProvider;
import org.eclipse.uml2.uml.edit.providers.DataTypeItemProvider;
import org.eclipse.uml2.uml.edit.providers.DependencyItemProvider;
import org.eclipse.uml2.uml.edit.providers.InformationFlowItemProvider;
import org.eclipse.uml2.uml.edit.providers.InstanceSpecificationItemProvider;
import org.eclipse.uml2.uml.edit.providers.InterfaceItemProvider;
import org.eclipse.uml2.uml.edit.providers.NamedElementItemProvider;
import org.eclipse.uml2.uml.edit.providers.ObjectNodeItemProvider;
import org.eclipse.uml2.uml.edit.providers.OperationItemProvider;
import org.eclipse.uml2.uml.edit.providers.PackageItemProvider;
import org.eclipse.uml2.uml.edit.providers.ParameterItemProvider;
import org.eclipse.uml2.uml.edit.providers.ParameterSetItemProvider;
import org.eclipse.uml2.uml.edit.providers.PortItemProvider;
import org.eclipse.uml2.uml.edit.providers.PropertyItemProvider;
import org.eclipse.uml2.uml.edit.providers.UMLItemProviderAdapterFactory;

/**
 * Get a registry of all SysML Adapter Factory classified by the UML class their
 * correspond.
 * 
 * Example:
 * 
 * <Class.class> ->[ModelelementsItemProviderAdapterFactory,
 * BlocksAdapterItemProviderFactory, RequirementsAdapterItemProviderFactory]
 * 
 * @generated
 */
public class SysmlRegistryAdapterFactoryRegistry {

	/**
	 * Keep track of the item provider of type ModelelementsItemProviderAdapterFactory
	 * 
	 * @generated
	 */

	protected ModelelementsItemProviderAdapterFactory modelelementsAdapterFactoryItemProvider;

	/**
	 * Keep track of the item provider of type BlocksItemProviderAdapterFactory
	 * 
	 * @generated
	 */

	protected BlocksItemProviderAdapterFactory blocksAdapterFactoryItemProvider;

	/**
	 * Keep track of the item provider of type PortandflowsItemProviderAdapterFactory
	 * 
	 * @generated
	 */

	protected PortandflowsItemProviderAdapterFactory portandflowsAdapterFactoryItemProvider;

	/**
	 * Keep track of the item provider of type ConstraintsItemProviderAdapterFactory
	 * 
	 * @generated
	 */

	protected ConstraintsItemProviderAdapterFactory constraintsAdapterFactoryItemProvider;

	/**
	 * Keep track of the item provider of type ActivitiesItemProviderAdapterFactory
	 * 
	 * @generated
	 */

	protected ActivitiesItemProviderAdapterFactory activitiesAdapterFactoryItemProvider;

	/**
	 * Keep track of the item provider of type AllocationsItemProviderAdapterFactory
	 * 
	 * @generated
	 */

	protected AllocationsItemProviderAdapterFactory allocationsAdapterFactoryItemProvider;

	/**
	 * Keep track of the item provider of type RequirementsItemProviderAdapterFactory
	 * 
	 * @generated
	 */

	protected RequirementsItemProviderAdapterFactory requirementsAdapterFactoryItemProvider;

	/**
	 * Registry for all SysML AdapterFactory
	 * 
	 * @generated
	 */
	private List<AdapterFactory> adapterFactoryRegistry = new ArrayList<AdapterFactory>(7);

	/**
	 * Registry of all {@link AdapterFactory} classified by corresponding UML element
	 * 
	 * @generated
	 */
	private HashMap<EClass, ArrayList<AdapterFactory>> adapterFactoryRegistryMap = new HashMap<EClass, ArrayList<AdapterFactory>>();

	/**
	 * Default adapterFactory
	 * 
	 * @generated
	 */
	private UMLItemProviderAdapterFactory defaultAdapterFactory = new UMLItemProviderAdapterFactory();

	/**
	 * Constructor + initialize
	 * 
	 * @generated
	 */
	private SysmlRegistryAdapterFactoryRegistry() {
		/**
		 * Initialize all AdapterFactories
		 */

		modelelementsAdapterFactoryItemProvider = new ModelelementsItemProviderAdapterFactory();
		adapterFactoryRegistry.add(modelelementsAdapterFactoryItemProvider);

		blocksAdapterFactoryItemProvider = new BlocksItemProviderAdapterFactory();
		adapterFactoryRegistry.add(blocksAdapterFactoryItemProvider);

		portandflowsAdapterFactoryItemProvider = new PortandflowsItemProviderAdapterFactory();
		adapterFactoryRegistry.add(portandflowsAdapterFactoryItemProvider);

		constraintsAdapterFactoryItemProvider = new ConstraintsItemProviderAdapterFactory();
		adapterFactoryRegistry.add(constraintsAdapterFactoryItemProvider);

		activitiesAdapterFactoryItemProvider = new ActivitiesItemProviderAdapterFactory();
		adapterFactoryRegistry.add(activitiesAdapterFactoryItemProvider);

		allocationsAdapterFactoryItemProvider = new AllocationsItemProviderAdapterFactory();
		adapterFactoryRegistry.add(allocationsAdapterFactoryItemProvider);

		requirementsAdapterFactoryItemProvider = new RequirementsItemProviderAdapterFactory();
		adapterFactoryRegistry.add(requirementsAdapterFactoryItemProvider);

		/**
		 * AdapterFactories for the ABSTRACTION elements
		 */
		adapterFactoryRegistryMap.put(UMLPackage.Literals.ABSTRACTION, new ArrayList<AdapterFactory>(Collections.singletonList(requirementsAdapterFactoryItemProvider)));

		adapterFactoryRegistryMap.get(UMLPackage.Literals.ABSTRACTION).add(allocationsAdapterFactoryItemProvider);

		/**
		 * AdapterFactories for the ACTIVITY_EDGE elements
		 */
		adapterFactoryRegistryMap.put(UMLPackage.Literals.ACTIVITY_EDGE, new ArrayList<AdapterFactory>(Collections.singletonList(activitiesAdapterFactoryItemProvider)));

		/**
		 * AdapterFactories for the ACTIVITY_PARTITION elements
		 */
		adapterFactoryRegistryMap.put(UMLPackage.Literals.ACTIVITY_PARTITION, new ArrayList<AdapterFactory>(Collections.singletonList(allocationsAdapterFactoryItemProvider)));

		/**
		 * AdapterFactories for the BEHAVIOR elements
		 */
		adapterFactoryRegistryMap.put(UMLPackage.Literals.BEHAVIOR, new ArrayList<AdapterFactory>(Collections.singletonList(requirementsAdapterFactoryItemProvider)));

		adapterFactoryRegistryMap.get(UMLPackage.Literals.BEHAVIOR).add(activitiesAdapterFactoryItemProvider);

		/**
		 * AdapterFactories for the CLASS elements
		 */
		adapterFactoryRegistryMap.put(UMLPackage.Literals.CLASS, new ArrayList<AdapterFactory>(Collections.singletonList(requirementsAdapterFactoryItemProvider)));

		adapterFactoryRegistryMap.get(UMLPackage.Literals.CLASS).add(modelelementsAdapterFactoryItemProvider);

		adapterFactoryRegistryMap.get(UMLPackage.Literals.CLASS).add(constraintsAdapterFactoryItemProvider);

		adapterFactoryRegistryMap.get(UMLPackage.Literals.CLASS).add(blocksAdapterFactoryItemProvider);

		/**
		 * AdapterFactories for the CLASSIFIER elements
		 */
		adapterFactoryRegistryMap.put(UMLPackage.Literals.CLASSIFIER, new ArrayList<AdapterFactory>(Collections.singletonList(blocksAdapterFactoryItemProvider)));

		/**
		 * AdapterFactories for the COMMENT elements
		 */
		adapterFactoryRegistryMap.put(UMLPackage.Literals.COMMENT, new ArrayList<AdapterFactory>(Collections.singletonList(modelelementsAdapterFactoryItemProvider)));

		/**
		 * AdapterFactories for the CONNECTOR elements
		 */
		adapterFactoryRegistryMap.put(UMLPackage.Literals.CONNECTOR, new ArrayList<AdapterFactory>(Collections.singletonList(blocksAdapterFactoryItemProvider)));

		/**
		 * AdapterFactories for the CONNECTOR_END elements
		 */
		adapterFactoryRegistryMap.put(UMLPackage.Literals.CONNECTOR_END, new ArrayList<AdapterFactory>(Collections.singletonList(blocksAdapterFactoryItemProvider)));

		/**
		 * AdapterFactories for the DATA_TYPE elements
		 */
		adapterFactoryRegistryMap.put(UMLPackage.Literals.DATA_TYPE, new ArrayList<AdapterFactory>(Collections.singletonList(blocksAdapterFactoryItemProvider)));

		/**
		 * AdapterFactories for the DEPENDENCY elements
		 */
		adapterFactoryRegistryMap.put(UMLPackage.Literals.DEPENDENCY, new ArrayList<AdapterFactory>(Collections.singletonList(modelelementsAdapterFactoryItemProvider)));

		/**
		 * AdapterFactories for the INFORMATION_FLOW elements
		 */
		adapterFactoryRegistryMap.put(UMLPackage.Literals.INFORMATION_FLOW, new ArrayList<AdapterFactory>(Collections.singletonList(portandflowsAdapterFactoryItemProvider)));

		/**
		 * AdapterFactories for the INSTANCE_SPECIFICATION elements
		 */
		adapterFactoryRegistryMap.put(UMLPackage.Literals.INSTANCE_SPECIFICATION, new ArrayList<AdapterFactory>(Collections.singletonList(blocksAdapterFactoryItemProvider)));

		/**
		 * AdapterFactories for the INTERFACE elements
		 */
		adapterFactoryRegistryMap.put(UMLPackage.Literals.INTERFACE, new ArrayList<AdapterFactory>(Collections.singletonList(portandflowsAdapterFactoryItemProvider)));

		/**
		 * AdapterFactories for the NAMED_ELEMENT elements
		 */
		adapterFactoryRegistryMap.put(UMLPackage.Literals.NAMED_ELEMENT, new ArrayList<AdapterFactory>(Collections.singletonList(requirementsAdapterFactoryItemProvider)));

		adapterFactoryRegistryMap.get(UMLPackage.Literals.NAMED_ELEMENT).add(allocationsAdapterFactoryItemProvider);

		/**
		 * AdapterFactories for the OBJECT_NODE elements
		 */
		adapterFactoryRegistryMap.put(UMLPackage.Literals.OBJECT_NODE, new ArrayList<AdapterFactory>(Collections.singletonList(activitiesAdapterFactoryItemProvider)));

		/**
		 * AdapterFactories for the OPERATION elements
		 */
		adapterFactoryRegistryMap.put(UMLPackage.Literals.OPERATION, new ArrayList<AdapterFactory>(Collections.singletonList(requirementsAdapterFactoryItemProvider)));

		adapterFactoryRegistryMap.get(UMLPackage.Literals.OPERATION).add(activitiesAdapterFactoryItemProvider);

		/**
		 * AdapterFactories for the PACKAGE elements
		 */
		adapterFactoryRegistryMap.put(UMLPackage.Literals.PACKAGE, new ArrayList<AdapterFactory>(Collections.singletonList(modelelementsAdapterFactoryItemProvider)));

		/**
		 * AdapterFactories for the PARAMETER elements
		 */
		adapterFactoryRegistryMap.put(UMLPackage.Literals.PARAMETER, new ArrayList<AdapterFactory>(Collections.singletonList(activitiesAdapterFactoryItemProvider)));

		/**
		 * AdapterFactories for the PARAMETER_SET elements
		 */
		adapterFactoryRegistryMap.put(UMLPackage.Literals.PARAMETER_SET, new ArrayList<AdapterFactory>(Collections.singletonList(activitiesAdapterFactoryItemProvider)));

		/**
		 * AdapterFactories for the PORT elements
		 */
		adapterFactoryRegistryMap.put(UMLPackage.Literals.PORT, new ArrayList<AdapterFactory>(Collections.singletonList(portandflowsAdapterFactoryItemProvider)));

		/**
		 * AdapterFactories for the PROPERTY elements
		 */
		adapterFactoryRegistryMap.put(UMLPackage.Literals.PROPERTY, new ArrayList<AdapterFactory>(Collections.singletonList(portandflowsAdapterFactoryItemProvider)));

		adapterFactoryRegistryMap.get(UMLPackage.Literals.PROPERTY).add(constraintsAdapterFactoryItemProvider);

		adapterFactoryRegistryMap.get(UMLPackage.Literals.PROPERTY).add(blocksAdapterFactoryItemProvider);

	}

	/**
	 * Singleton holder
	 * 
	 * @generated
	 */
	private static class SingletonHolder {

		protected static SysmlRegistryAdapterFactoryRegistry instance = null;
		static {
			instance = new SysmlRegistryAdapterFactoryRegistry();
		}
	}

	/**
	 * @generated
	 */
	public static SysmlRegistryAdapterFactoryRegistry getSingleton() {
		return SingletonHolder.instance;
	}

	/**
	 * Get the default AdapterFactory
	 * 
	 * @return List<AdapterFactory> return the default adapter factory (UML)
	 * @generated
	 */
	public AdapterFactory getDefaultAdapterFactory() {
		return (AdapterFactory)defaultAdapterFactory;
	}

	/**
	 * Get the list of all AdapterFactory for this type
	 * 
	 * @param Object
	 *        element
	 * @return List<AdapterFactory> List of all the adapter factories which can handle the object element
	 * @generated
	 */
	public List<AdapterFactory> getAdapterFactoriesForType(Object element) {
		if(element instanceof EObject) {
			EObject eObject = (EObject)element;
			ArrayList<AdapterFactory> result = adapterFactoryRegistryMap.get(eObject.eClass());
			if(result != null) {
				return result;
			} else {
				return Collections.singletonList(getDefaultAdapterFactory());
			}
		} else {
			throw new RuntimeException("org.eclipse.papyrus.sysml.edit.utils.SysmlRegistryAdapterFactoryRegistery : This factory only works with EOBjects");
		}
	}

	/**
	 * Set the the root AdapterFactory for all registered adapter factory
	 * 
	 * @param AdapterFactory
	 *        The adapter factory which will be the root
	 * @generated
	 */
	public void setRootAdapterFactory(IRootAdapterFactory adapter) {
		for(AdapterFactory adap : adapterFactoryRegistry) {
			if(adap instanceof IComposableAdapterFactory) {
				((IComposableAdapterFactory)adap).setRootAdapterFactory(adapter);
			}
		}
	}

	/**
	 * Get a map of all UML ItemProvider needed
	 * 
	 * @generated
	 */
	public HashMap<EClass, ItemProviderAdapter> getUMLItemProviderClassifedByUMLElement(AdapterFactory rootAdapterFactory) {
		HashMap<EClass, ItemProviderAdapter> result = new HashMap<EClass, ItemProviderAdapter>();

		result.put(UMLPackage.Literals.INSTANCE_SPECIFICATION, new InstanceSpecificationItemProvider(rootAdapterFactory));

		result.put(UMLPackage.Literals.CONNECTOR_END, new ConnectorEndItemProvider(rootAdapterFactory));

		result.put(UMLPackage.Literals.OPERATION, new OperationItemProvider(rootAdapterFactory));

		result.put(UMLPackage.Literals.DEPENDENCY, new DependencyItemProvider(rootAdapterFactory));

		result.put(UMLPackage.Literals.OBJECT_NODE, new ObjectNodeItemProvider(rootAdapterFactory));

		result.put(UMLPackage.Literals.DATA_TYPE, new DataTypeItemProvider(rootAdapterFactory));

		result.put(UMLPackage.Literals.PROPERTY, new PropertyItemProvider(rootAdapterFactory));

		result.put(UMLPackage.Literals.BEHAVIOR, new BehaviorItemProvider(rootAdapterFactory));

		result.put(UMLPackage.Literals.COMMENT, new CommentItemProvider(rootAdapterFactory));

		result.put(UMLPackage.Literals.INTERFACE, new InterfaceItemProvider(rootAdapterFactory));

		result.put(UMLPackage.Literals.ABSTRACTION, new AbstractionItemProvider(rootAdapterFactory));

		result.put(UMLPackage.Literals.ACTIVITY_PARTITION, new ActivityPartitionItemProvider(rootAdapterFactory));

		result.put(UMLPackage.Literals.CONNECTOR, new ConnectorItemProvider(rootAdapterFactory));

		result.put(UMLPackage.Literals.PARAMETER_SET, new ParameterSetItemProvider(rootAdapterFactory));

		result.put(UMLPackage.Literals.ACTIVITY_EDGE, new ActivityEdgeItemProvider(rootAdapterFactory));

		result.put(UMLPackage.Literals.CLASSIFIER, new ClassifierItemProvider(rootAdapterFactory));

		result.put(UMLPackage.Literals.NAMED_ELEMENT, new NamedElementItemProvider(rootAdapterFactory));

		result.put(UMLPackage.Literals.PARAMETER, new ParameterItemProvider(rootAdapterFactory));

		result.put(UMLPackage.Literals.PORT, new PortItemProvider(rootAdapterFactory));

		result.put(UMLPackage.Literals.INFORMATION_FLOW, new InformationFlowItemProvider(rootAdapterFactory));

		result.put(UMLPackage.Literals.CLASS, new ClassItemProvider(rootAdapterFactory));

		result.put(UMLPackage.Literals.PACKAGE, new PackageItemProvider(rootAdapterFactory));

		return result;
	}

} //org.eclipse.papyrus.sysml.registry;

