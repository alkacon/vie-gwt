`VIE-GWT version: alpha (2012)`
   
`Readme version : alpha (2012)`


# **Google Web Toolkit wrapper for the Vienna IKS Editables**


#### Powered by:

<img src="http://www.alkacon.com/export/system/modules/org.opencms.website.template/resources/img/logo/logo_alkacon.gif" />
<img src="http://www.opencms.org/export/system/modules/org.opencms.website.template/resources/img/logo/logo_opencms.gif" />
<img src="http://www.alkacon.com/system/modules/org.opencms.website.template/resources/img/logo/iks-logo.png" />
<img src="http://www.alkacon.com/system/modules/org.opencms.website.template/resources/img/logo/vie_logo.png" />


## Alkacon Software develops a Google Web Toolkit wrapper for the Vienna IKS Editables (VIE)

OpenCms from Alkacon Software is a professional content management system that helps content managers worldwide to create and maintain websites fast and efficiently.

Interactive Knowledge Stack ([IKS](http://www.iks-project.eu/)) is an EU funded project bringing semantic technologies (capabilities) to content management systems. Alkacon Software is an industrial partner in the IKS project.

> "IKS now provides the Vienna IKS Editables (VIE), a JavaScript based software component to semantically enhance and edit web pages inline through annotations. IKS also provides Apache Stanbol, a reusable set of software components that are meant to be accessed over RESTful interfaces to provide semantic services for content management. Both the VIE and Stanbol components have been developed as part of the IKS project over the last 2 years and are now close a release version."


## By adopting the IKS software stack, Alkacon plans to achieve the following goals for OpenCms:

1. Allow the generation of semantically annotated content for search engine optimization (SEO).
2. Enhance the advanced direct edit mode of OpenCms with inline-editing capabilities using VIE.
3. Support for semantic content enrichment, using VIE as frontend and Stanbol as backend.


## What is VIE-GWT?

<b>VIE-GWT</b> is a wrapper implementation (written in Java) around the VIE JavaScript library. It makes the VIE capabilities accessible for GWT applications without writing native JavaScript. It's open source, completely free and you don't need to register neither for downloading nor for using VIE-GWT.

VIE is a JavaScript library for implementing decoupled Content Management Systems and semantic interaction in web applications.


## Why bother?

#### Motivation

To provide content managers with a modern and easy to use web 2.0 user interface OpenCms uses the Google Web Toolkit (GWT) for client side programming. In order to minimize development time, code maintaining costs and also to increase code transparency, Alkacon will stay with GWT and Java technology. Therefore Alkacon don't wants to write native JavaScript code that is part of the OpenCms core system.

#### Developing

To integrate the VIE capabilities into OpenCms, Alkacon develops a GWT wrapper around the VIE JavaScript library. This is a common approach to provide access to feature-rich native JavaScript widget libraries in GWT, for example used for projects like "Ext GWT", "Smart GWT" and others.

#### Benefit

If you want to enhance your Java based web-application for semantic capabilities and you quarrel with writing native JavaScript VIE-GWT will help you.


#### Features

- RDFa parsing (content 	analysis)
- Usage of semantic widgets (content interaction)
- Entity manipulation (data modification)
- Easy connectivity of RESTful Services (server communication)


## Implementation design for the VIE-GWT

Alkacon aims to develop a VIE-GWT wrapper independent from OpenCms and enables a Java / GWT developer to make full use of the VIE capabilities without knowledge about the JavaScript internals of VIE.

In general there are a number of possible approaches when creating a wrapper for an existing JavaScript API using the GWT:

- JavaScript Native Interface (JSNI)
- JavaScriptObject overlays
- JavaScript InterOp library
- GWT Linker extensions
- GWT Generators
- and maybe more. 

VIE-GWT (alpha version) uses the JavaScript Native Interface (JSNI) and the JavaScriptObject overlays for implementation.


## Getting started (coming soon ...)

#### Requirements
#### Installation
#### Documentation
#### Important known problems


## Related links

- [VIE-GWT project on GitHub](https://github.com/alkacon/vie-gwt)
- [VIE project website](http://viejs.org/)
- [Editable VIE Widgets](http://wiki.iks-project.eu/index.php/VIE/Widgets#Editable_Widgets)
- [Apache Stanbol project website](http://incubator.apache.org/stanbol/)
- [Backbone local storage](http://documentcloud.github.com/backbone/docs/backbone-localstorage.html)


## Contact: Alkacon Software GmbH - The OpenCms Experts

<b>Please use our [contact form](http://www.alkacon.com/en/company/contact/form.html) to contact us directly.</b>

Do not send us an email for the first contact, since we have problems with serious amounts of spam.

<b>Our office address:</b>  
Alkacon Software GmbH - The OpenCms Experts  
An der Wachsfabrik 13   
DE-50996 Cologne, Germany

- [http://www.alkacon.com/](http://www.alkacon.com/)
- [sales@alkacon.com](mailto:sales@alkacon.com)
- [Directions to the office](http://www.alkacon.com/en/company/contact/directions.html)
- [Map of the office location](http://www.alkacon.com/en/company/contact/map.html)


----------

**Please note**: This readme file was written to the best of knowledge. If there are any mistakes, please don't hesitate to use our [contact form](http://www.alkacon.com/en/company/contact/form.html).