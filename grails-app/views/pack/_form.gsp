<%@ page import="ar.com.elegantsoft.ftbmods.Pack" %>



<div class="fieldcontain ${hasErrors(bean: packInstance, field: 'packName', 'error')} required">
	<label for="packName">
		<g:message code="pack.packName.label" default="Pack Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="packName" required="" value="${packInstance?.packName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: packInstance, field: 'packVersion', 'error')} required">
	<label for="packVersion">
		<g:message code="pack.packVersion.label" default="Pack Version" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="packVersion" value="${fieldValue(bean: packInstance, field: 'packVersion')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: packInstance, field: 'mods', 'error')} ">
	<label for="mods">
		<g:message code="pack.mods.label" default="Mods" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${packInstance?.mods?}" var="m">
    <li><g:link controller="modif" action="show" id="${m.id}">${m?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="modif" action="create" params="['pack.id': packInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'mod.label', default: 'Mod')])}</g:link>
</li>
</ul>

</div>

