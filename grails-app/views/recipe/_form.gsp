<%@ page import="ar.com.elegantsoft.ftbmods.Recipe" %>



<div class="fieldcontain ${hasErrors(bean: recipeInstance, field: 'product', 'error')} required">
	<label for="product">
		<g:message code="recipe.product.label" default="Product" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="product" name="product.id" from="${ar.com.elegantsoft.ftbmods.Item.findAllByPriIdGreaterThan(0)}" optionKey="id" optionValue="name" required="" value="${recipeInstance?.product?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: recipeInstance, field: 'mats', 'error')} required">
	<label for="mats">
		<g:message code="recipe.mats.label" default="Mats" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="mats" from="${ar.com.elegantsoft.ftbmods.Item.findAllByPriIdGreaterThan(0)}" multiple="multiple" optionKey="id" optionValue="name" size="5" required="" value="${recipeInstance?.mats*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: recipeInstance, field: 'shapeless', 'error')} ">
	<label for="shapeless">
		<g:message code="recipe.shapeless.label" default="Shapeless" />
		
	</label>
	<g:checkBox name="shapeless" value="${recipeInstance?.shapeless}" />
</div>

<div class="fieldcontain ${hasErrors(bean: recipeInstance, field: 'mod', 'error')} required">
	<label for="mod">
		<g:message code="recipe.mod.label" default="Mod" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="mod" name="mod.id" from="${ar.com.elegantsoft.ftbmods.Modif.list()}" optionKey="id" required="" value="${recipeInstance?.mod?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: recipeInstance, field: 'quantity', 'error')} required">
	<label for="quantity">
		<g:message code="recipe.quantity.label" default="Quantity" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="quantity" type="number" value="${recipeInstance.quantity}" required=""/>
</div>

