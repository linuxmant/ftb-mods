
<%@ page import="ar.com.elegantsoft.ftbmods.Item" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'item.label', default: 'Item')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-item" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-item" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
						<g:sortableColumn property="fullId" title="${message(code: 'item.fullId.label', default: 'Id')}" />
					
<!-- 						<g:sortableColumn property="secId" title="${message(code: 'item.secId.label', default: 'Sec Id')}" /> -->
					
						<g:sortableColumn property="name" title="${message(code: 'item.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="pic" title="${message(code: 'item.pic.label', default: 'Pic')}" />
					
						<th><g:message code="item.mod.label" default="Mod" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${itemInstanceList}" status="i" var="itemInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${itemInstance.id}">${fieldValue(bean: itemInstance, field: "fullId")}</g:link></td>
					
<!-- 						<td>${fieldValue(bean: itemInstance, field: "secId")}</td> -->
					
						<td>${fieldValue(bean: itemInstance, field: "name")}</td>
					
						<td><img class="itemicon ${fieldValue(bean: itemInstance, field: "pic")}" /></td>
					
						<td>${fieldValue(bean: itemInstance, field: "mod")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${itemInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
