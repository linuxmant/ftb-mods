<%@ page import="ar.com.elegantsoft.ftbmods.Item" %>



<div class="fieldcontain ${hasErrors(bean: itemInstance, field: 'priId', 'error')} required">
	<label for="priId">
		<g:message code="item.priId.label" default="Pri Id" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="priId" maxlength="10" required="" value="${itemInstance?.priId}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: itemInstance, field: 'secId', 'error')} ">
	<label for="secId">
		<g:message code="item.secId.label" default="Sec Id" />
		
	</label>
	<g:textField name="secId" maxlength="10" value="${itemInstance?.secId}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: itemInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="item.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${itemInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: itemInstance, field: 'pic', 'error')} ">
	<label for="pic">
		<g:message code="item.pic.label" default="Pic" />
		
	</label>
	<g:textField name="pic" value="${itemInstance?.pic}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: itemInstance, field: 'mod', 'error')} required">
	<label for="mod">
		<g:message code="item.mod.label" default="Mod" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="mod" name="mod.id" from="${ar.com.elegantsoft.ftbmods.Modif.list()}" optionKey="id" required="" value="${itemInstance?.mod?.id}" class="many-to-one"/>
</div>

