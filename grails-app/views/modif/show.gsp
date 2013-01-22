
<%@ page import="ar.com.elegantsoft.ftbmods.Modif" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'mod.label', default: 'Mod')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-mod" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-mod" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list mod">
			
				<g:if test="${modInstance?.modName}">
				<li class="fieldcontain">
					<span id="modName-label" class="property-label"><g:message code="mod.modName.label" default="Mod Name" /></span>
					
						<span class="property-value" aria-labelledby="modName-label"><g:fieldValue bean="${modInstance}" field="modName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${modInstance?.modVersion}">
				<li class="fieldcontain">
					<span id="modVersion-label" class="property-label"><g:message code="mod.modVersion.label" default="Mod Version" /></span>
					
						<span class="property-value" aria-labelledby="modVersion-label"><g:fieldValue bean="${modInstance}" field="modVersion"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${modInstance?.modCreator}">
				<li class="fieldcontain">
					<span id="modCreator-label" class="property-label"><g:message code="mod.modCreator.label" default="Mod Creator" /></span>
					
						<span class="property-value" aria-labelledby="modCreator-label"><g:fieldValue bean="${modInstance}" field="modCreator"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${modInstance?.modUrl}">
				<li class="fieldcontain">
					<span id="modUrl-label" class="property-label"><g:message code="mod.modUrl.label" default="Mod Url" /></span>
					
						<span class="property-value" aria-labelledby="modUrl-label"><g:fieldValue bean="${modInstance}" field="modUrl"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${modInstance?.modItems}">
				<li class="fieldcontain">
					<span id="items-label" class="property-label"><g:message code="mod.items.label" default="Items" /></span>
					
						<g:each in="${modInstance.modItems}" var="i">
						<span class="property-value" aria-labelledby="items-label"><g:link controller="item" action="show" id="${i.id}">${i?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${modInstance?.modPack}">
				<li class="fieldcontain">
					<span id="pack-label" class="property-label"><g:message code="mod.pack.label" default="Pack" /></span>
					
						<span class="property-value" aria-labelledby="pack-label"><g:link controller="pack" action="show" id="${modInstance?.modPack?.id}">${modInstance?.modPack?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${modInstance?.modRecipes}">
				<li class="fieldcontain">
					<span id="recipes-label" class="property-label"><g:message code="mod.recipes.label" default="Recipes" /></span>
					
						<g:each in="${modInstance.modRecipes}" var="r">
						<span class="property-value" aria-labelledby="recipes-label"><g:link controller="recipe" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${modInstance?.id}" />
					<g:link class="edit" action="edit" id="${modInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
