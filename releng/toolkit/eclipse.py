################################################################################
# Copyright (c) 2014 CEA LIST.
#
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
#
# Contributors:
# Laurent Wouters laurent.wouters@cea.fr - Initial API and implementation
#
################################################################################

# This script provides an API to load and manipulate
# Eclipse plugins and features in a code repository

import os # File handling
import os.path # File path handling
import re # Regular expressions
import xml.dom.minidom # Minimal XML

# Represents an Eclipse bundle
class Bundle:
	# Constructor
	def __init__(self, location):
		# The name as the last element of the path (folder name)
		self.name = os.path.basename(location)
		# The folder
		self.location = location


# Represents an Eclipse plugin
class Plugin(Bundle):
	def __init__(self, location):
		Bundle.__init__(self, location)
		# Initializes the list of dependencies
		self.dependencies=[]
		# Initializes the manifest data
		self.properties={}
		# Load the data from manifest
		manifest = open(os.path.join(os.path.join(location, "META-INF"), "MANIFEST.MF"), "r")
		onDep = False
		for line in manifest:
			if line.startswith("Require-Bundle:") or onDep:
				m = re.search("[a-zA-Z_][a-zA-Z_0-9]+(\\.[a-zA-Z_][a-zA-Z_0-9]+)+", line)
				dep = m.group(0)
				self.dependencies.append(dep)
				onDep = line.endswith(",")
			elif line.startswith("Bundle-"):
				m = re.match("Bundle-(\\w+): (.*)", line)
				self.properties[m.group(1)] = m.group(2)
		manifest.close()


# Represents an Eclipse feature
class Feature(Bundle):
	def __init__(self, location):
		Bundle. __init__(self, location)
		# Initializes the list of the included features
		self.included=[]
		# Initializes the list of the plugins
		self.plugins=[]
		# Load the content
		doc = xml.dom.minidom.parse(os.path.join(location, "feature.xml"))
		for node in doc.getElementsByTagName("plugin"):
			id = node.getAttribute("id")
			self.plugins.append(id)
		for node in doc.getElementsByTagName("includes"):
			id = node.getAttribute("id")
			self.included.append(id)


# Represents a repository of Eclipse plugins and features
class Repository:
	def __init__(self):
		# Initializes a dictionary of plugins indexed by name
		self.plugins={}
		# Initializes a dictionary of features indexed by name
		self.features={}

	# Recursively load plugins and features in the given directory
	def load(self, dir):
		subs = os.listdir(dir)
		if "META-INF" in subs:
			# this is a plugin
			plugin = Plugin(dir)
			self.plugins[plugin.name] = plugin
			return
		if "feature.xml" in subs:
			# this is a feature
			feature = Feature(dir)
			self.features[feature.name] = feature
			return
		for name in subs:
			sub = os.path.join(dir, name)
			if os.path.isdir(sub):
				self.load(sub)

	# Checks the consistency of the repository to check whether
	# all required features and plugins are present
	# The given pattern is used to determine whether a feature or
	# plugin is required ; matching means required
	# This method returns the list of the missing features and plugins
	def check(self, includePattern, excludePattern):
		result=[]
		for name in self.features:
			if match(name, excludePattern):
				continue
			feature = self.features[name]
			for included in feature.included:
				if match(included, excludePattern):
					continue
				if not included in self.features and match(included, includePattern):
					result.append(included)
			for plugin in feature.plugins:
				if match(plugin, excludePattern):
					continue
				if not plugin in self.plugins and match(plugin, includePattern):
					result.append(plugin)
		for name in self.plugins:
			if match(name, excludePattern):
				continue
			plugin = self.plugins[name]
			for dep in plugin.dependencies:
				if match(dep, excludePattern):
					continue
				if not dep in self.plugins and match(dep, includePattern):
					result.append(dep)
		return result


def match(value, pattern):
	m = re.match(pattern, value)
	return (m is not None)