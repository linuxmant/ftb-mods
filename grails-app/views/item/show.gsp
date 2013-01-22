
<%@ page import="ar.com.elegantsoft.ftbmods.Item" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'item.label', default: 'Item')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-item" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-item" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list item">
			
				<g:if test="${itemInstance?.priId}">
				<li class="fieldcontain">
					<span id="priId-label" class="property-label"><g:message code="item.priId.label" default="Pri Id" /></span>
					
						<span class="property-value" aria-labelledby="priId-label"><g:fieldValue bean="${itemInstance}" field="priId"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${itemInstance?.secId}">
				<li class="fieldcontain">
					<span id="secId-label" class="property-label"><g:message code="item.secId.label" default="Sec Id" /></span>
					
						<span class="property-value" aria-labelledby="secId-label"><g:fieldValue bean="${itemInstance}" field="secId"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${itemInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="item.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${itemInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${itemInstance?.pic}">
				<li class="fieldcontain">
					<span id="pic-label" class="property-label"><g:message code="item.pic.label" default="Pic" /></span>
					
						<span class="property-value" aria-labelledby="pic-label"><g:fieldValue bean="${itemInstance}" field="pic"/></span>
					<span class="property-value"><img class="itemicon ${itemInstance?.pic}" /></span>
				</li>
				</g:if>
			
				<g:if test="${itemInstance?.mod}">
				<li class="fieldcontain">
					<span id="mod-label" class="property-label"><g:message code="item.mod.label" default="Mod" /></span>
					
						<span class="property-value" aria-labelledby="mod-label"><g:link controller="modif" action="show" id="${itemInstance?.mod?.id}">${itemInstance?.mod?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${itemInstance?.id}" />
					<g:link class="edit" action="edit" id="${itemInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
