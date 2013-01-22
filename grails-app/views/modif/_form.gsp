<%@ page import="ar.com.elegantsoft.ftbmods.Modif" %>



<div class="fieldcontain ${hasErrors(bean: modInstance, field: 'modName', 'error')} required">
	<label for="modName">
		<g:message code="mod.modName.label" default="Mod Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="modName" maxlength="50" required="" value="${modInstance?.modName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: modInstance, field: 'modVersion', 'error')} required">
	<label for="modVersion">
		<g:message code="mod.modVersion.label" default="Mod Version" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="modVersion" value="${fieldValue(bean: modInstance, field: 'modVersion')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: modInstance, field: 'modCreator', 'error')} required">
	<label for="modCreator">
		<g:message code="mod.modCreator.label" default="Mod Creator" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="modCreator" maxlength="50" required="" value="${modInstance?.modCreator}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: modInstance, field: 'modUrl', 'error')} ">
	<label for="modUrl">
		<g:message code="mod.modUrl.label" default="Mod Url" />
		
	</label>
	<g:field type="url" name="modUrl" value="${modInstance?.modUrl}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: modInstance, field: 'items', 'error')} ">
	<label for="items">
		<g:message code="mod.items.label" default="Items" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${modInstance?.modItems?}" var="i">
    <li><g:link controller="item" action="show" id="${i.id}">${i?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="item" action="create" params="['mod.id': modInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'item.label', default: 'Item')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: modInstance, field: 'pack', 'error')} required">
	<label for="pack">
		<g:message code="mod.pack.label" default="Pack" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="pack" name="pack.id" from="${ar.com.elegantsoft.ftbmods.Pack.list()}" optionKey="id" required="" value="${modInstance?.modPack?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: modInstance, field: 'recipes', 'error')} ">
	<label for="recipes">
		<g:message code="mod.recipes.label" default="Recipes" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${modInstance?.modRecipes?}" var="r">
    <li><g:link controller="recipe" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="recipe" action="create" params="['mod.id': modInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'recipe.label', default: 'Recipe')])}</g:link>
</li>
</ul>

</div>

