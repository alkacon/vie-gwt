[VIE-GWT](https://raw.github.com/bergie/VIE/master/design/vie_logo_100.png) Wrapper project
====================

### Alkacon Software develops a Google Web Toolkit wrapper for the Vienna IKS Editables (VIE)

OpenCms from Alkacon Software is a professional content management system that helps content managers worldwide to create and maintain websites fast and efficiently.

Interactive Knowledge Stack (IKS) is an EU funded project bringing semantic technologies (capabilities) to content management systems. Alkacon Software is an industrial partner in the IKS project.

IKS now provides the Vienna IKS Editables (VIE), a JavaScript based software component to semantically enhance and edit web pages inline through annotations. IKS also provides Apache Stanbol, a reusable set of software components that are meant to be accessed over RESTful interfaces to provide semantic services for content management. Both the VIE and Stanbol components have been developed as part of the IKS project over the last 2 years and are now close a release version.

## By adopting the IKS software stack, Alkacon plans to achieve the following goals for OpenCms:

1. Allow the generation of semantically annotated content for search engine optimization (SEO).
2. Enhance the advanced direct edit mode of OpenCms with inline-editing capabilities using VIE.
3. Support for semantic content enrichment, using VIE as frontend and Stanbol as backend.

## A GWT wrapper around the VIE JavaScript library

For client side programming, the Google Web Toolkit (GWT) is used in OpenCms to provide content managers with a modern and easy to use web 2.0 user interface. In order to minimize development time, code maintaining costs and also to increase code transparency, Alkacon will stay with GWT and Java technology. Therefore Alkacon wants to avoid writing native JavaScript code that is part of the OpenCms core system.

To integrate the VIE capabilities into OpenCms, Alkacon is developing a GWT wrapper around the VIE JavaScript library. This is a common approach to provide access to feature-rich native JavaScript widget libraries in GWT, for example used for projects like "Ext GWT", "Smart GWT" and others.

## Implementation design for the VIE wrapper

Alkacon aims to develop a VIE-GWT wrapper that is independent from OpenCms and enables a Java / GWT developer to make full use of the VIE capabilities without knowledge about the JavaScript internals of VIE.

In general there are a number of possible approaches when creating a wrapper for an existing JavaScript API using the GWT: JavaScript Native Interface (JSNI), JavaScriptObject overlays, JavaScript InterOp library, GWT Linker extensions, GWT Generators and maybe more. A first prototype of the wrapper implementation is already available on GitHub – using the JavaScript Native Interface approach.

In the upcoming month Alkacon will even evaluate a number of alternative approaches.
 
### Related links

- [VIE-GWT project on GitHub] (https://github.com/alkacon/vie-gwt)
- [VIE project website] (http://viejs.org/)
- [Editable VIE Widgets] (http://wiki.iks-project.eu/index.php/VIE/Widgets#Editable_Widgets)
- [Apache Stanbol project website] (http://incubator.apache.org/stanbol/)
- [Backbone local storage] (http://documentcloud.github.com/backbone/docs/backbone-localstorage.html)
