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

# System imports
import xml.dom.minidom # Minimal XML


# encoding of the XML files
XML_ENCODING="UTF-8"
# identation string
XML_IDENT="\t"
# new line string
XML_NEWLINE="\n"


# Outputs the XML document in the given file with pretty printing
def output(document, file):
	document.normalize()
	content = XML_NEWLINE.join([line for line in document.toprettyxml(XML_IDENT, XML_NEWLINE, XML_ENCODING).split(XML_NEWLINE) if line.strip()])
	output = open(file, "w")
	output.write(content)
	output.close()