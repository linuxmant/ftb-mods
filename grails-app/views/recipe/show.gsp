
<%@ page import="ar.com.elegantsoft.ftbmods.Recipe" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'recipe.label', default: 'Recipe')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-recipe" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-recipe" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list recipe">
			
				<g:if test="${recipeInstance?.product}">
				<li class="fieldcontain">
					<span id="product-label" class="property-label"><g:message code="recipe.product.label" default="Product" /></span>
					
						<span class="property-value" aria-labelledby="product-label"><g:link controller="item" action="show" id="${recipeInstance?.product?.id}">${recipeInstance?.product?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${recipeInstance?.mats}">
				<li class="fieldcontain">
					<span id="mats-label" class="property-label"><g:message code="recipe.mats.label" default="Mats" /></span>
					
						<g:each in="${recipeInstance.mats}" var="m">
						<span class="property-value" aria-labelledby="mats-label"><g:link controller="item" action="show" id="${m.id}">${m?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${recipeInstance?.shapeless}">
				<li class="fieldcontain">
					<span id="shapeless-label" class="property-label"><g:message code="recipe.shapeless.label" default="Shapeless" /></span>
					
						<span class="property-value" aria-labelledby="shapeless-label"><g:formatBoolean boolean="${recipeInstance?.shapeless}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${recipeInstance?.mod}">
				<li class="fieldcontain">
					<span id="mod-label" class="property-label"><g:message code="recipe.mod.label" default="Mod" /></span>
					
						<span class="property-value" aria-labelledby="mod-label"><g:link controller="modif" action="show" id="${recipeInstance?.mod?.id}">${recipeInstance?.mod?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${recipeInstance?.quantity}">
				<li class="fieldcontain">
					<span id="quantity-label" class="property-label"><g:message code="recipe.quantity.label" default="Quantity" /></span>
					
						<span class="property-value" aria-labelledby="quantity-label"><g:fieldValue bean="${recipeInstance}" field="quantity"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${recipeInstance?.id}" />
					<g:link class="edit" action="edit" id="${recipeInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
