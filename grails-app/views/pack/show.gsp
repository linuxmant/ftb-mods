
<%@ page import="ar.com.elegantsoft.ftbmods.Pack" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'pack.label', default: 'Pack')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-pack" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-pack" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list pack">
			
				<g:if test="${packInstance?.packName}">
				<li class="fieldcontain">
					<span id="packName-label" class="property-label"><g:message code="pack.packName.label" default="Pack Name" /></span>
					
						<span class="property-value" aria-labelledby="packName-label"><g:fieldValue bean="${packInstance}" field="packName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${packInstance?.packVersion}">
				<li class="fieldcontain">
					<span id="packVersion-label" class="property-label"><g:message code="pack.packVersion.label" default="Pack Version" /></span>
					
						<span class="property-value" aria-labelledby="packVersion-label"><g:fieldValue bean="${packInstance}" field="packVersion"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${packInstance?.packMods}">
				<li class="fieldcontain">
					<span id="mods-label" class="property-label"><g:message code="pack.mods.label" default="Mods" /></span>
					
						<g:each in="${packInstance.packMods}" var="m">
						<span class="property-value" aria-labelledby="mods-label"><g:link controller="modif" action="show" id="${m.id}">${m?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${packInstance?.id}" />
					<g:link class="edit" action="edit" id="${packInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
