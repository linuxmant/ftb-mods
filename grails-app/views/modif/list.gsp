
<%@ page import="ar.com.elegantsoft.ftbmods.Modif" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'mod.label', default: 'Mod')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-mod" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-mod" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="modName" title="${message(code: 'mod.modName.label', default: 'Mod Name')}" />
					
						<g:sortableColumn property="modVersion" title="${message(code: 'mod.modVersion.label', default: 'Mod Version')}" />
					
						<g:sortableColumn property="modCreator" title="${message(code: 'mod.modCreator.label', default: 'Mod Creator')}" />
					
						<g:sortableColumn property="modUrl" title="${message(code: 'mod.modUrl.label', default: 'Mod Url')}" />
					
						<th><g:message code="mod.pack.label" default="Pack" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${modInstanceList}" status="i" var="modInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${modInstance.id}">${fieldValue(bean: modInstance, field: "modName")}</g:link></td>
					
						<td>${fieldValue(bean: modInstance, field: "modVersion")}</td>
					
						<td>${fieldValue(bean: modInstance, field: "modCreator")}</td>
					
						<td>${fieldValue(bean: modInstance, field: "modUrl")}</td>
					
						<td>${fieldValue(bean: modInstance, field: "modPack")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${modInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
